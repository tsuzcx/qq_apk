import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ajpk
{
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt == 3) {
      return 3;
    }
    return 0;
  }
  
  public static ajps a(int paramInt)
  {
    QLog.d("AnimDrawerFactory", 2, "create drawer by type: " + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ajpp();
    case 2: 
      return new ajqf();
    }
    return new ajqc();
  }
  
  public static ajps a(String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(Base64.decode(paramString.getBytes(), 0), paramFloat1, paramFloat2, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("AnimDrawerFactory", 2, "subtitle base64decode exception:" + paramString.toString());
    }
    return null;
  }
  
  public static ajps a(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4)) {
      localObject = null;
    }
    ajps localajps;
    do
    {
      return localObject;
      localajps = a(aevh.a(paramArrayOfByte, 0));
      localObject = localajps;
    } while (localajps == null);
    localajps.a(BaseApplicationImpl.getApplication(), paramFloat1, paramFloat2, paramInt, paramArrayOfByte, 4, paramArrayOfByte.length - 4, true);
    return localajps;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpk
 * JD-Core Version:    0.7.0.1
 */