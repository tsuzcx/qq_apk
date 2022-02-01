package a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static SharedPreferences b;
  public static long c = 0L;
  public static String d = "";
  public static String e = "";
  public Context a = null;
  
  public a(Context paramContext, String paramString)
  {
    try
    {
      this.a = paramContext;
      e = paramContext.getFilesDir().toString() + h.a(g.a[3]) + "_" + paramString;
      b = paramContext.getSharedPreferences(h.a(g.a[0]) + "_" + paramString, 0);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b();
      localJSONObject.put(g.a(24), 1);
      localJSONObject.put(g.a(27), c);
      localJSONObject.put(g.a(28), d);
      localJSONObject.put(g.a(26), "");
      localJSONObject.put(g.a(25), "");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((paramLong <= 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = b.edit();
      localEditor.putLong(h.a(g.a[1]), paramLong);
      localEditor.putString(h.a(g.a[2]), paramString);
      localEditor.commit();
      c = paramLong;
      d = paramString;
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 75	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 128	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 130
    //   14: invokevirtual 134	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17: istore_3
    //   18: aload_1
    //   19: ldc 136
    //   21: invokevirtual 140	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   24: lstore 4
    //   26: aload_1
    //   27: ldc 142
    //   29: invokevirtual 146	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_1
    //   35: ldc 148
    //   37: invokevirtual 146	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: iconst_0
    //   41: invokestatic 154	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   44: astore_1
    //   45: iload_3
    //   46: ifne +132 -> 178
    //   49: aload_0
    //   50: aload_1
    //   51: aload 8
    //   53: invokevirtual 157	a/a/a/b/a:a	([BLjava/lang/String;)Z
    //   56: istore 6
    //   58: iload 6
    //   60: ifeq +112 -> 172
    //   63: new 37	java/io/File
    //   66: dup
    //   67: getstatic 60	a/a/a/b/a:e	Ljava/lang/String;
    //   70: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 7
    //   77: invokevirtual 161	java/io/File:exists	()Z
    //   80: ifeq +9 -> 89
    //   83: aload 7
    //   85: invokevirtual 164	java/io/File:delete	()Z
    //   88: pop
    //   89: aload 7
    //   91: invokevirtual 167	java/io/File:createNewFile	()Z
    //   94: pop
    //   95: new 169	java/io/FileOutputStream
    //   98: dup
    //   99: aload 7
    //   101: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: astore 7
    //   106: aload 7
    //   108: aload_1
    //   109: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   112: aload 7
    //   114: invokevirtual 179	java/io/FileOutputStream:close	()V
    //   117: iload_2
    //   118: ifeq +48 -> 166
    //   121: aload_0
    //   122: lload 4
    //   124: aload 8
    //   126: invokevirtual 181	a/a/a/b/a:a	(JLjava/lang/String;)V
    //   129: iconst_2
    //   130: iconst_0
    //   131: invokestatic 187	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   134: return
    //   135: astore_1
    //   136: aload 7
    //   138: invokevirtual 179	java/io/FileOutputStream:close	()V
    //   141: aload_1
    //   142: invokevirtual 69	java/lang/Exception:printStackTrace	()V
    //   145: iconst_0
    //   146: istore_2
    //   147: goto -30 -> 117
    //   150: astore 7
    //   152: aload 7
    //   154: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   157: goto -16 -> 141
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 96	org/json/JSONException:printStackTrace	()V
    //   165: return
    //   166: iconst_2
    //   167: iconst_2
    //   168: invokestatic 187	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   171: return
    //   172: iconst_2
    //   173: iconst_3
    //   174: invokestatic 187	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   177: return
    //   178: iconst_2
    //   179: iconst_1
    //   180: invokestatic 187	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   183: return
    //   184: astore_1
    //   185: aconst_null
    //   186: astore 7
    //   188: goto -52 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	a
    //   0	191	1	paramString	String
    //   1	146	2	i	int
    //   17	29	3	j	int
    //   24	99	4	l	long
    //   56	3	6	bool	boolean
    //   73	64	7	localObject1	Object
    //   150	3	7	localIOException	java.io.IOException
    //   186	1	7	localObject2	Object
    //   32	93	8	str	String
    // Exception table:
    //   from	to	target	type
    //   106	117	135	java/lang/Exception
    //   136	141	150	java/io/IOException
    //   2	45	160	org/json/JSONException
    //   49	58	160	org/json/JSONException
    //   121	134	160	org/json/JSONException
    //   136	141	160	org/json/JSONException
    //   141	145	160	org/json/JSONException
    //   152	157	160	org/json/JSONException
    //   166	171	160	org/json/JSONException
    //   172	177	160	org/json/JSONException
    //   178	183	160	org/json/JSONException
    //   63	89	184	java/lang/Exception
    //   89	106	184	java/lang/Exception
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = i.a(paramArrayOfByte, null);
      bool2 = paramString.equalsIgnoreCase(c.b(paramArrayOfByte));
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public final void b()
  {
    try
    {
      Object localObject = c();
      c = b.getLong(h.a(g.a[1]), 0L);
      d = b.getString(h.a(g.a[2]), "");
      if (!a((byte[])localObject, d))
      {
        localObject = b.edit();
        ((SharedPreferences.Editor)localObject).clear();
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new File(e);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        d = "";
        c = 0L;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public final byte[] c()
  {
    // Byte code:
    //   0: getstatic 60	a/a/a/b/a:e	Ljava/lang/String;
    //   3: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 37	java/io/File
    //   14: dup
    //   15: getstatic 60	a/a/a/b/a:e	Ljava/lang/String;
    //   18: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 161	java/io/File:exists	()Z
    //   26: ifeq +32 -> 58
    //   29: aload_1
    //   30: invokevirtual 219	java/io/File:length	()J
    //   33: l2i
    //   34: newarray byte
    //   36: astore_2
    //   37: new 221	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 226	java/io/FileInputStream:read	([B)I
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 227	java/io/FileInputStream:close	()V
    //   56: aload_2
    //   57: areturn
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -52 -> 9
    //   64: aload_1
    //   65: invokevirtual 227	java/io/FileInputStream:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_2
    //   81: invokevirtual 69	java/lang/Exception:printStackTrace	()V
    //   84: goto -24 -> 60
    //   87: astore_2
    //   88: goto -8 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   21	44	1	localObject1	Object
    //   70	2	1	localIOException	java.io.IOException
    //   79	1	1	localObject2	Object
    //   36	21	2	arrayOfByte	byte[]
    //   77	4	2	localException1	Exception
    //   87	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   64	68	70	java/io/IOException
    //   11	46	77	java/lang/Exception
    //   46	56	87	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */