import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ahjw
{
  public static void a(long paramLong, List<ahjx> paramList)
  {
    int j = (int)(SystemClock.elapsedRealtime() - paramLong) / 1000;
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!((ahjx)paramList.next()).a()) {
        break label99;
      }
      i += 1;
    }
    label99:
    for (;;)
    {
      break;
      a("0X800AB63", i + "", j + "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putBoolean("face2face_add_contact_guide_tip", true);
      paramQQAppInterface.commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactUtils", 2, " face2faceReport tValue = " + paramString1 + " r2 = " + paramString2 + " r3 = " + paramString3 + " r4 =" + paramString4);
    }
    azqs.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getPreferences().getBoolean("face2face_add_contact_guide_tip", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putBoolean("face2face_add_contact_guide_dialog", true);
      paramQQAppInterface.commit();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getPreferences().getBoolean("face2face_add_contact_guide_dialog", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjw
 * JD-Core Version:    0.7.0.1
 */