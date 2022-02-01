package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public int a;
  private String b;
  private Map<String, a> c;
  
  private d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174180);
    this.b = paramJSONObject.optString("VERSIONNAME");
    this.a = paramJSONObject.optInt("VERSIONCODE");
    paramJSONObject = paramJSONObject.optJSONArray("COMPONENTS");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      this.c = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        a locala = a(paramJSONObject.optJSONObject(i));
        if (locala != null) {
          this.c.put(locala.a, locala);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(174180);
  }
  
  private static a a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174181);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(174181);
      return null;
    }
    String str = paramJSONObject.optString("NAME");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(174181);
      return null;
    }
    a locala = new a();
    locala.a = str;
    locala.b = paramJSONObject.optString("VERSIONNAME");
    locala.c = paramJSONObject.optInt("VERSIONCODE");
    locala.d = paramJSONObject.optString("URL");
    locala.e = paramJSONObject.optString("MD5");
    paramJSONObject = paramJSONObject.optJSONArray("DEPENDENCIES");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      locala.f = new String[j];
      int i = 0;
      while (i < j)
      {
        locala.f[i] = paramJSONObject.optString(i);
        i += 1;
      }
    }
    AppMethodBeat.o(174181);
    return locala;
  }
  
  /* Error */
  public static d a(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 120	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokestatic 126	com/tencent/tbs/one/impl/common/d:a	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/d;
    //   20: astore_2
    //   21: aload_1
    //   22: invokestatic 131	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   25: ldc 118
    //   27: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_2
    //   31: areturn
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: new 133	com/tencent/tbs/one/TBSOneException
    //   40: dup
    //   41: sipush 306
    //   44: ldc 135
    //   46: aload_2
    //   47: invokespecial 138	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: ldc 118
    //   55: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: athrow
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: aload_2
    //   66: astore_0
    //   67: aload_1
    //   68: invokestatic 131	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   71: ldc 118
    //   73: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -14 -> 67
    //   84: astore_2
    //   85: goto -50 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	java.io.File
    //   13	68	1	localObject1	Object
    //   20	11	2	locald	d
    //   32	15	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   50	11	2	localTBSOneException	TBSOneException
    //   62	4	2	localObject2	Object
    //   84	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   5	14	32	java/io/FileNotFoundException
    //   16	21	62	finally
    //   37	51	62	finally
    //   53	58	62	finally
    //   60	62	62	finally
    //   5	14	78	finally
    //   16	21	84	java/io/FileNotFoundException
  }
  
  private static d a(InputStream paramInputStream)
  {
    AppMethodBeat.i(174178);
    try
    {
      paramInputStream = c.a(paramInputStream, "utf-8");
      paramInputStream = a(paramInputStream);
      AppMethodBeat.o(174178);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = new TBSOneException(307, "Failed to read DEPS contents", paramInputStream);
      AppMethodBeat.o(174178);
      throw paramInputStream;
    }
  }
  
  public static d a(String paramString)
  {
    AppMethodBeat.i(174179);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new d(localJSONObject);
      AppMethodBeat.o(174179);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      paramString = new TBSOneException(308, "Failed to parse DEPS " + paramString + ", " + localJSONException.getMessage(), localJSONException);
      AppMethodBeat.o(174179);
      throw paramString;
    }
  }
  
  public final a b(String paramString)
  {
    AppMethodBeat.i(174182);
    if (this.c == null)
    {
      AppMethodBeat.o(174182);
      return null;
    }
    paramString = (a)this.c.get(paramString);
    AppMethodBeat.o(174182);
    return paramString;
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String[] f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.d
 * JD-Core Version:    0.7.0.1
 */