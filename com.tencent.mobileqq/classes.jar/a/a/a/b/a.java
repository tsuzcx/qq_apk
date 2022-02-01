package a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("st");
        l = paramString.optLong("ver");
        str = paramString.optString("hs");
        paramString = Base64.decode(paramString.optString("sd"), 0);
        if (i == 0)
        {
          boolean bool = a(paramString, str);
          if (!bool) {}
        }
      }
      catch (JSONException paramString)
      {
        int i;
        long l;
        String str;
        Object localObject1;
        paramString.printStackTrace();
        return;
      }
      try
      {
        localObject1 = new File(e);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        ((File)localObject1).createNewFile();
        localObject1 = new FileOutputStream((File)localObject1);
        try
        {
          ((FileOutputStream)localObject1).write(paramString);
          ((FileOutputStream)localObject1).close();
          i = 1;
          if (i != 0) {
            a(l, str);
          }
          return;
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString)
      {
        Object localObject2 = null;
        continue;
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        paramString.printStackTrace();
        i = 0;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
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
    //   30: invokevirtual 213	java/io/File:length	()J
    //   33: l2i
    //   34: newarray byte
    //   36: astore_2
    //   37: new 215	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 220	java/io/FileInputStream:read	([B)I
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 221	java/io/FileInputStream:close	()V
    //   56: aload_2
    //   57: areturn
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -52 -> 9
    //   64: aload_1
    //   65: invokevirtual 221	java/io/FileInputStream:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 182	java/io/IOException:printStackTrace	()V
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
    //   70	2	1	localIOException	IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */