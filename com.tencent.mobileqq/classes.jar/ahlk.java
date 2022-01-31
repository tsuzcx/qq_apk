import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ahlk
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
  
  public static ahls a(int paramInt)
  {
    QLog.d("AnimDrawerFactory", 2, "create drawer by type: " + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ahlp();
    case 2: 
      return new ahmf();
    }
    return new ahmc();
  }
  
  public static ahls a(String paramString, float paramFloat1, float paramFloat2, int paramInt)
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
  
  public static ahls a(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4)) {
      localObject = null;
    }
    ahls localahls;
    do
    {
      return localObject;
      localahls = a(acsp.a(paramArrayOfByte, 0));
      localObject = localahls;
    } while (localahls == null);
    localahls.a(BaseApplicationImpl.getApplication(), paramFloat1, paramFloat2, paramInt, paramArrayOfByte, 4, paramArrayOfByte.length - 4, true);
    return localahls;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */