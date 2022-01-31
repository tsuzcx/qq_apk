import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ambv
  extends alzl<ambw>
{
  public int a()
  {
    return 567;
  }
  
  @NonNull
  public ambw a(int paramInt)
  {
    return new ambw();
  }
  
  @Nullable
  public ambw a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfalzs);
      }
      ambw localambw = ambw.a(paramArrayOfalzs);
      if (!TextUtils.isEmpty(paramArrayOfalzs))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfalzs).apply();
        MobileQQ.addBroadcastWhitList(localambw.a);
      }
    }
    return new ambw();
  }
  
  public Class<ambw> a()
  {
    return ambw.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(ambw paramambw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */