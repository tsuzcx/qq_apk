package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public int a;
  public String b;
  public String c;
  public String d;
  public a[] e;
  public Pair<String, String>[] f;
  
  private e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174253);
    this.a = paramJSONObject.optInt("VERSIONCODE");
    this.b = paramJSONObject.optString("RESOURCE");
    Object localObject1 = paramJSONObject.optString("ENTRY");
    ArrayList localArrayList;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split(":");
      if (localObject1.length == 1) {
        this.c = localObject1[0];
      }
    }
    else
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("FILES");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
        break label348;
      }
      int j = localJSONArray.length();
      localArrayList = new ArrayList(j);
      i = 0;
      label108:
      if (i >= j) {
        break label330;
      }
      localObject1 = localJSONArray.optJSONObject(i);
      if (localObject1 != null) {
        break label177;
      }
      localObject1 = null;
    }
    label177:
    label200:
    a locala;
    do
    {
      for (;;)
      {
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        i += 1;
        break label108;
        if (localObject1.length < 2) {
          break;
        }
        this.c = localObject1[0];
        this.d = localObject1[1];
        break;
        localObject2 = ((JSONObject)localObject1).optString("PATH");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label200;
        }
        localObject1 = null;
      }
      locala = new a();
      locala.a = ((String)localObject2);
      locala.b = ((JSONObject)localObject1).optString("MD5");
      locala.c = ((JSONObject)localObject1).optString("SEALED");
      localObject2 = ((JSONObject)localObject1).optString("PARENT");
      localObject1 = locala;
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    localObject1 = new b();
    Object localObject2 = ((String)localObject2).split(":");
    if (localObject2.length == 1) {}
    for (((b)localObject1).b = localObject2[0];; ((b)localObject1).b = localObject2[1])
    {
      locala.d = ((b)localObject1);
      localObject1 = locala;
      break;
      ((b)localObject1).a = localObject2[0];
    }
    label330:
    this.e = ((a[])localArrayList.toArray(new a[0]));
    label348:
    a(paramJSONObject.optJSONArray("RECEIVERS"));
    AppMethodBeat.o(174253);
  }
  
  /* Error */
  public static e a(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 140	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: new 2	com/tencent/tbs/one/impl/common/e
    //   19: dup
    //   20: new 35	org/json/JSONObject
    //   23: dup
    //   24: aload_2
    //   25: ldc 145
    //   27: invokestatic 150	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   30: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: invokespecial 155	com/tencent/tbs/one/impl/common/e:<init>	(Lorg/json/JSONObject;)V
    //   36: astore_3
    //   37: aload_2
    //   38: invokestatic 158	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   41: ldc 138
    //   43: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_3
    //   47: areturn
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: new 160	com/tencent/tbs/one/TBSOneException
    //   56: dup
    //   57: sipush 401
    //   60: new 162	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 164
    //   66: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokespecial 181	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: astore_0
    //   84: aload_2
    //   85: astore_1
    //   86: ldc 138
    //   88: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_2
    //   92: astore_1
    //   93: aload_0
    //   94: athrow
    //   95: astore_0
    //   96: aload_1
    //   97: invokestatic 158	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   100: ldc 138
    //   102: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: new 160	com/tencent/tbs/one/TBSOneException
    //   115: dup
    //   116: sipush 402
    //   119: new 162	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 183
    //   125: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_3
    //   139: invokespecial 181	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: astore_0
    //   143: aload_2
    //   144: astore_1
    //   145: ldc 138
    //   147: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_2
    //   151: astore_1
    //   152: aload_0
    //   153: athrow
    //   154: aload_2
    //   155: astore_1
    //   156: new 160	com/tencent/tbs/one/TBSOneException
    //   159: dup
    //   160: sipush 403
    //   163: new 162	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 185
    //   169: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 187
    //   181: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokevirtual 190	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload_3
    //   195: invokespecial 181	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: astore_0
    //   199: aload_2
    //   200: astore_1
    //   201: ldc 138
    //   203: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: astore_1
    //   208: aload_0
    //   209: athrow
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -117 -> 96
    //   216: astore_3
    //   217: goto -63 -> 154
    //   220: astore_3
    //   221: goto -111 -> 110
    //   224: astore_3
    //   225: goto -174 -> 51
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: goto -77 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramFile	java.io.File
    //   15	198	1	localFileInputStream1	java.io.FileInputStream
    //   13	218	2	localFileInputStream2	java.io.FileInputStream
    //   36	11	3	locale	e
    //   48	32	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   107	88	3	localIOException1	java.io.IOException
    //   216	1	3	localJSONException1	org.json.JSONException
    //   220	1	3	localIOException2	java.io.IOException
    //   224	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   228	1	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   5	14	48	java/io/FileNotFoundException
    //   16	37	95	finally
    //   53	84	95	finally
    //   86	91	95	finally
    //   93	95	95	finally
    //   112	143	95	finally
    //   145	150	95	finally
    //   152	154	95	finally
    //   156	199	95	finally
    //   201	206	95	finally
    //   208	210	95	finally
    //   5	14	107	java/io/IOException
    //   5	14	210	finally
    //   16	37	216	org/json/JSONException
    //   16	37	220	java/io/IOException
    //   16	37	224	java/io/FileNotFoundException
    //   5	14	228	org/json/JSONException
  }
  
  private void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(174254);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      AppMethodBeat.o(174254);
      return;
    }
    int k = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("CLASS");
      localObject = ((JSONObject)localObject).optJSONArray("EVENTS");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          localArrayList.add(new Pair(((JSONArray)localObject).optString(j), str));
          j += 1;
        }
      }
      i += 1;
    }
    this.f = ((Pair[])localArrayList.toArray(new Pair[0]));
    AppMethodBeat.o(174254);
  }
  
  public final a a(String paramString)
  {
    AppMethodBeat.i(174251);
    a[] arrayOfa = this.e;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.a.equals(paramString))
      {
        AppMethodBeat.o(174251);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(174251);
    return null;
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public String c;
    public e.b d;
  }
  
  public static final class b
  {
    public String a;
    public String b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.e
 * JD-Core Version:    0.7.0.1
 */