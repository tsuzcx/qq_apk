import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Window;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.Iterator;
import java.util.List;

public class acir
{
  private aciu a(String paramString1, String paramString2, String paramString3, List<blaf> paramList)
  {
    if (paramList.contains(AuthorizationItem.a))
    {
      if (!paramList.contains(AuthorizationItem.b)) {
        break label57;
      }
      label26:
      if (!paramList.contains(AuthorizationItem.c)) {
        break label63;
      }
    }
    for (;;)
    {
      return new aciu(paramString1, paramString2, paramString3, null);
      paramString1 = "";
      break;
      label57:
      paramString2 = "";
      break label26;
      label63:
      paramString3 = "";
    }
  }
  
  private void a(Activity paramActivity, boolean paramBoolean, aciu paramaciu, acit paramacit, List<blaf> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult: entity -> " + paramaciu);
    }
    if (paramBoolean)
    {
      if (a(paramActivity, paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult has authorized, return info direct ");
        }
        if (paramacit != null)
        {
          paramaciu.a = 0;
          paramacit.a(paramaciu);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult show authorize dialog to authorize user info");
      }
      paramActivity = new blae(paramActivity, paramaciu, paramacit, paramList);
      paramaciu = paramActivity.getWindow();
      if (paramaciu != null) {
        paramaciu.setWindowAnimations(2131755013);
      }
      paramActivity.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult get result fail");
    }
    if (paramacit != null) {
      paramacit.a(aciu.a());
    }
    Toast.makeText(paramActivity, paramActivity.getString(2131690247), 0).show();
  }
  
  private boolean a(Context paramContext, List<blaf> paramList)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!paramContext.getBoolean(((blaf)paramList.next()).b, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "checkAuthorize user phone not authorize");
        }
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acir
 * JD-Core Version:    0.7.0.1
 */