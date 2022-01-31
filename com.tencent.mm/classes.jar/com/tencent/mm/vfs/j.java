package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  private static final Pattern AQu;
  
  static
  {
    AppMethodBeat.i(54676);
    AQu = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    AppMethodBeat.o(54676);
  }
  
  static String J(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(54672);
    Matcher localMatcher = AQu.matcher(paramString);
    StringBuilder localStringBuilder;
    int i;
    if (localMatcher.find())
    {
      localStringBuilder = new StringBuilder(paramString.length());
      i = 0;
    }
    for (;;)
    {
      String str1 = localMatcher.group(1);
      String str2 = (String)paramMap.get(str1);
      if (str2 == null)
      {
        b.d("VFS.Utils", "Macro resolve: " + paramString + " cannot resolve ${" + str1 + "}.");
        AppMethodBeat.o(54672);
        return null;
      }
      localStringBuilder.append(paramString.substring(i, localMatcher.start())).append(str2);
      i = localMatcher.end();
      if (!localMatcher.find())
      {
        paramMap = paramString.substring(i);
        b.d("VFS.Utils", "Macro resolve: " + paramString + " => " + paramMap);
        AppMethodBeat.o(54672);
        return paramMap;
        b.d("VFS.Utils", "Macro resolve: " + paramString + " contains no macros.");
        AppMethodBeat.o(54672);
        return paramString;
      }
    }
  }
  
  public static void a(Parcel paramParcel, Class<? extends FileSystem> paramClass)
  {
    AppMethodBeat.i(54675);
    int i = paramParcel.readInt();
    if (i != 1)
    {
      paramParcel = new a(paramClass, i);
      AppMethodBeat.o(54675);
      throw paramParcel;
    }
    AppMethodBeat.o(54675);
  }
  
  static String avQ(String paramString)
  {
    AppMethodBeat.i(54674);
    int i = paramString.lastIndexOf('/');
    if (i <= 0)
    {
      AppMethodBeat.o(54674);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(54674);
    return paramString;
  }
  
  static String l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(54673);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(54673);
      return paramString;
    }
    int j;
    StringTokenizer localStringTokenizer;
    if (paramString.startsWith("/"))
    {
      j = 1;
      localObject = paramString;
      if (paramString.endsWith("/"))
      {
        localObject = paramString;
        if (paramString.length() > 1) {
          localObject = paramString.substring(0, paramString.length() - 1);
        }
      }
      localStringTokenizer = new StringTokenizer(((String)localObject).substring(j), "/");
      paramString = new ArrayList();
    }
    for (;;)
    {
      if (!localStringTokenizer.hasMoreTokens()) {
        break label199;
      }
      String str = localStringTokenizer.nextToken();
      if ((paramBoolean1) && ("..".equals(str)))
      {
        if (paramString.isEmpty())
        {
          AppMethodBeat.o(54673);
          return null;
          j = 0;
          break;
        }
        paramString.remove(paramString.size() - 1);
        i = 0;
        continue;
      }
      if (((paramBoolean1) && (".".equals(str))) || ("".equals(str))) {
        i = 0;
      } else {
        paramString.add(str);
      }
    }
    label199:
    if (i != 0)
    {
      if (paramBoolean2)
      {
        paramString = ((String)localObject).substring(j);
        AppMethodBeat.o(54673);
        return paramString;
      }
      AppMethodBeat.o(54673);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if ((!paramBoolean2) && (j > 0)) {
      ((StringBuilder)localObject).append('/');
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      ((StringBuilder)localObject).append(paramString.next());
      while (paramString.hasNext())
      {
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(paramString.next());
      }
    }
    paramString = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(54673);
    return paramString;
  }
  
  public static String p(Uri paramUri)
  {
    AppMethodBeat.i(54671);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramUri.getScheme();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      localStringBuilder.append(paramUri);
    }
    paramUri = localStringBuilder.toString();
    AppMethodBeat.o(54671);
    return paramUri;
  }
  
  static Uri parseUri(String paramString)
  {
    AppMethodBeat.i(54670);
    Uri.Builder localBuilder = new Uri.Builder();
    int j = paramString.indexOf(':');
    if (j < 0) {
      localBuilder.path(paramString);
    }
    for (;;)
    {
      paramString = localBuilder.build();
      AppMethodBeat.o(54670);
      return paramString;
      localBuilder.scheme(paramString.substring(0, j));
      int k = paramString.length();
      if ((k > j + 2) && (paramString.charAt(j + 1) == '/') && (paramString.charAt(j + 2) == '/'))
      {
        int i = j + 3;
        while (i < k) {
          switch (paramString.charAt(i))
          {
          default: 
            i += 1;
          }
        }
        localBuilder.authority(paramString.substring(j + 3, i));
        if (i < k) {
          localBuilder.path(paramString.substring(i + 1));
        }
      }
      else
      {
        localBuilder.path(paramString.substring(j + 1));
      }
    }
  }
  
  static final class a
    extends RuntimeException
  {
    a(Class<?> paramClass, int paramInt)
    {
      super();
      AppMethodBeat.i(54669);
      AppMethodBeat.o(54669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */