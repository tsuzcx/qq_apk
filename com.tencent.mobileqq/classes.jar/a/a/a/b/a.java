package a.a.a.b;

import a.a.a.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public SharedPreferences a = null;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public Context e = null;
  public String f = "";
  
  public a(Context paramContext, String paramString)
  {
    try
    {
      this.e = paramContext;
      this.f = paramString;
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
      localJSONObject.put(g.a(27), this.b);
      localJSONObject.put(g.a(28), this.c);
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
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putLong(b.a(g.a[1]), paramLong);
      localEditor.putString(b.a(g.a[2]), paramString);
      localEditor.commit();
      this.b = paramLong;
      this.c = paramString;
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void a(Context paramContext)
  {
    this.d = (paramContext.getFilesDir().toString() + b.a(g.a[3]) + "_" + this.f);
    this.a = paramContext.getSharedPreferences(b.a(g.a[0]) + "_" + this.f, 0);
    this.b = this.a.getLong(b.a(g.a[1]), 0L);
    this.c = this.a.getString(b.a(g.a[2]), "");
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 44	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 140
    //   14: invokevirtual 144	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17: istore_3
    //   18: aload_1
    //   19: ldc 146
    //   21: invokevirtual 150	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   24: lstore 4
    //   26: aload_1
    //   27: ldc 152
    //   29: invokevirtual 156	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_1
    //   35: ldc 158
    //   37: invokevirtual 156	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: iconst_0
    //   41: invokestatic 164	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   44: astore_1
    //   45: iload_3
    //   46: ifne +133 -> 179
    //   49: aload_0
    //   50: aload_1
    //   51: aload 8
    //   53: invokevirtual 167	a/a/a/b/a:a	([BLjava/lang/String;)Z
    //   56: istore 6
    //   58: iload 6
    //   60: ifeq +113 -> 173
    //   63: new 110	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: getfield 31	a/a/a/b/a:d	Ljava/lang/String;
    //   71: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 7
    //   76: aload 7
    //   78: invokevirtual 171	java/io/File:exists	()Z
    //   81: ifeq +9 -> 90
    //   84: aload 7
    //   86: invokevirtual 174	java/io/File:delete	()Z
    //   89: pop
    //   90: aload 7
    //   92: invokevirtual 177	java/io/File:createNewFile	()Z
    //   95: pop
    //   96: new 179	java/io/FileOutputStream
    //   99: dup
    //   100: aload 7
    //   102: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore 7
    //   107: aload 7
    //   109: aload_1
    //   110: invokevirtual 186	java/io/FileOutputStream:write	([B)V
    //   113: aload 7
    //   115: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   118: iload_2
    //   119: ifeq +48 -> 167
    //   122: aload_0
    //   123: lload 4
    //   125: aload 8
    //   127: invokevirtual 191	a/a/a/b/a:a	(JLjava/lang/String;)V
    //   130: iconst_2
    //   131: iconst_0
    //   132: invokestatic 197	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   135: return
    //   136: astore_1
    //   137: aload 7
    //   139: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   142: aload_1
    //   143: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   146: iconst_0
    //   147: istore_2
    //   148: goto -30 -> 118
    //   151: astore 7
    //   153: aload 7
    //   155: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   158: goto -16 -> 142
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 63	org/json/JSONException:printStackTrace	()V
    //   166: return
    //   167: iconst_2
    //   168: iconst_2
    //   169: invokestatic 197	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   172: return
    //   173: iconst_2
    //   174: iconst_3
    //   175: invokestatic 197	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   178: return
    //   179: iconst_2
    //   180: iconst_1
    //   181: invokestatic 197	com/tencent/secprotocol/t/ReportLogHelper:report	(II)V
    //   184: return
    //   185: astore_1
    //   186: aconst_null
    //   187: astore 7
    //   189: goto -52 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	a
    //   0	192	1	paramString	String
    //   1	147	2	i	int
    //   17	29	3	j	int
    //   24	100	4	l	long
    //   56	3	6	bool	boolean
    //   74	64	7	localObject1	Object
    //   151	3	7	localIOException	java.io.IOException
    //   187	1	7	localObject2	Object
    //   32	94	8	str	String
    // Exception table:
    //   from	to	target	type
    //   107	118	136	java/lang/Exception
    //   137	142	151	java/io/IOException
    //   2	45	161	org/json/JSONException
    //   49	58	161	org/json/JSONException
    //   122	135	161	org/json/JSONException
    //   137	142	161	org/json/JSONException
    //   142	146	161	org/json/JSONException
    //   153	158	161	org/json/JSONException
    //   167	172	161	org/json/JSONException
    //   173	178	161	org/json/JSONException
    //   179	184	161	org/json/JSONException
    //   63	90	185	java/lang/Exception
    //   90	107	185	java/lang/Exception
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = h.a(paramArrayOfByte, null);
      bool2 = paramString.equalsIgnoreCase(c.b(paramArrayOfByte));
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public final void b()
  {
    try
    {
      Object localObject = c();
      a(this.e);
      if (!a((byte[])localObject, this.c))
      {
        localObject = this.a.edit();
        ((SharedPreferences.Editor)localObject).clear();
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new File(this.d);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        this.c = "";
        this.b = 0L;
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
    //   0: aload_0
    //   1: getfield 31	a/a/a/b/a:d	Ljava/lang/String;
    //   4: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 110	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	a/a/a/b/a:d	Ljava/lang/String;
    //   20: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 171	java/io/File:exists	()Z
    //   28: ifeq +32 -> 60
    //   31: aload_1
    //   32: invokevirtual 223	java/io/File:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore_2
    //   39: new 225	java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_1
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 230	java/io/FileInputStream:read	([B)I
    //   53: pop
    //   54: aload_1
    //   55: invokevirtual 231	java/io/FileInputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull -53 -> 10
    //   66: aload_1
    //   67: invokevirtual 231	java/io/FileInputStream:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   86: goto -24 -> 62
    //   89: astore_2
    //   90: goto -8 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   23	44	1	localObject1	Object
    //   72	2	1	localIOException	java.io.IOException
    //   81	1	1	localObject2	Object
    //   38	21	2	arrayOfByte	byte[]
    //   79	4	2	localException1	Exception
    //   89	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   66	70	72	java/io/IOException
    //   12	48	79	java/lang/Exception
    //   48	58	89	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */