package a.a.a.b;

import a.a.a.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.secprotocol.t.ReportLogHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    if (paramLong > 0L)
    {
      if (TextUtils.isEmpty(paramString)) {
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
  }
  
  public final void a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().toString());
    localStringBuilder.append(b.a(g.a[3]));
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    this.d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.a(g.a[0]));
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    this.a = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    this.b = this.a.getLong(b.a(g.a[1]), 0L);
    this.c = this.a.getString(b.a(g.a[2]), "");
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("st");
      long l = paramString.optLong("ver");
      String str = paramString.optString("hs");
      paramString = Base64.decode(paramString.optString("sd"), 0);
      int i = 1;
      if (j == 0)
      {
        boolean bool = a(paramString, str);
        if (bool)
        {
          Object localObject1 = null;
          try
          {
            Object localObject2 = new File(this.d);
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            ((File)localObject2).createNewFile();
            localObject2 = new FileOutputStream((File)localObject2);
            try
            {
              ((FileOutputStream)localObject2).write(paramString);
              ((FileOutputStream)localObject2).close();
            }
            catch (Exception paramString)
            {
              localObject1 = localObject2;
            }
            try
            {
              localObject1.close();
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
          catch (Exception paramString) {}
          paramString.printStackTrace();
          i = 0;
          if (i != 0)
          {
            a(l, str);
            ReportLogHelper.report(2, 0);
            return;
          }
          ReportLogHelper.report(2, 2);
          return;
        }
        ReportLogHelper.report(2, 3);
        return;
      }
      ReportLogHelper.report(2, 1);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      boolean bool1 = h.a(paramArrayOfByte, null);
      boolean bool2 = paramString.equalsIgnoreCase(c.b(paramArrayOfByte));
      if ((bool1) && (bool2)) {
        return true;
      }
    }
    return false;
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
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final byte[] c()
  {
    if (TextUtils.isEmpty(this.d)) {
      return null;
    }
    Object localObject;
    try
    {
      localObject = new File(this.d);
      if (((File)localObject).exists())
      {
        byte[] arrayOfByte = new byte[(int)((File)localObject).length()];
        localObject = new FileInputStream((File)localObject);
        try
        {
          ((FileInputStream)localObject).read(arrayOfByte);
          ((FileInputStream)localObject).close();
          return arrayOfByte;
        }
        catch (Exception localException1) {}
      }
      else
      {
        localObject = null;
      }
    }
    catch (Exception localException2)
    {
      localObject = null;
      localException2.printStackTrace();
    }
    if (localObject != null) {
      try
      {
        ((FileInputStream)localObject).close();
        return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */