package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g
{
  private static g a;
  private static f b;
  
  public static g a()
  {
    try
    {
      AppMethodBeat.i(219687);
      if (a == null) {
        a = new g();
      }
      g localg = a;
      AppMethodBeat.o(219687);
      return localg;
    }
    finally {}
  }
  
  public static String a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(219693);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (paramArrayOfString.length > 1)
      {
        int i = 0;
        while (i < paramArrayOfString.length - 1)
        {
          localStringBuilder.append(paramArrayOfString[i]).append(",");
          i += 1;
        }
      }
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    paramArrayOfString = localStringBuilder.toString();
    AppMethodBeat.o(219693);
    return paramArrayOfString;
  }
  
  public static String[] a(String paramString)
  {
    AppMethodBeat.i(219689);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      AppMethodBeat.o(219689);
      return paramString;
    }
    AppMethodBeat.o(219689);
    return null;
  }
  
  private SharedPreferences b(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(219697);
      paramContext = paramContext.getSharedPreferences("tbs_emergence", 4);
      AppMethodBeat.o(219697);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public List<String> a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219731);
    paramString = b(paramContext).getString(paramString, "");
    paramContext = new ArrayList();
    paramString = paramString.split(";");
    if (paramString.length > 0) {
      paramContext.addAll(Arrays.asList(paramString));
    }
    AppMethodBeat.o(219731);
    return paramContext;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(219708);
    b = f.a(new File(paramContext.getFilesDir(), "prefs.lock"));
    AppMethodBeat.o(219708);
  }
  
  public void a(Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(219746);
    paramContext = b(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
    paramContext.commit();
    AppMethodBeat.o(219746);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219703);
    List localList = a(paramContext, paramString1);
    localList.add(paramString2);
    a(paramContext, paramString1, localList);
    AppMethodBeat.o(219703);
  }
  
  public void a(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(219723);
    paramContext = b(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() > 1)
      {
        int i = 0;
        while (i < paramList.size() - 1)
        {
          localStringBuilder.append((String)paramList.get(i));
          localStringBuilder.append(";");
          i += 1;
        }
      }
      localStringBuilder.append((String)paramList.get(paramList.size() - 1));
    }
    paramContext.putString(paramString, localStringBuilder.toString());
    paramContext.apply();
    paramContext.commit();
    AppMethodBeat.o(219723);
  }
  
  public long b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219738);
    long l = b(paramContext).getLong(paramString, -1L);
    AppMethodBeat.o(219738);
    return l;
  }
  
  public boolean b()
  {
    return b != null;
  }
  
  public void c()
  {
    AppMethodBeat.i(219717);
    if (b != null)
    {
      b.b();
      b = null;
    }
    AppMethodBeat.o(219717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.g
 * JD-Core Version:    0.7.0.1
 */