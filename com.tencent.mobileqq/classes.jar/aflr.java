import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class aflr
  extends akat
{
  public aflr(SystemRequestInfoView paramSystemRequestInfoView) {}
  
  protected void a(String paramString)
  {
    if (this.a.a())
    {
      paramString = this.a.getResources().getString(2131720004);
      bcql.a(this.a.getContext(), 1, paramString, 0).b(this.a.a());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionError");
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin");
    }
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin stopProgress = fasle");
      }
    }
    long l1;
    structmsg.StructMsg localStructMsg;
    for (;;)
    {
      return;
      long l2 = aydc.a().b();
      l1 = l2;
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        l1 = Long.parseLong(paramString1);
        localStructMsg = aydc.a().a(Long.valueOf(l1));
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3))
          {
            bcql.a(this.a.getContext(), 1, paramString3, 0).b(this.a.a());
            if (!ayde.a(localStructMsg, paramInt3, paramString2, paramString4)) {
              continue;
            }
            SystemRequestInfoView.a(this.a).finish();
            return;
          }
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          l1 = l2;
          continue;
          paramString3 = this.a.getResources().getString(2131719262);
        }
        ayde.a(localStructMsg, paramInt1, paramString2, paramInt2);
        paramString2 = null;
        if (paramInt1 != 1) {
          break label234;
        }
      }
    }
    SystemRequestInfoView.a(this.a).finish();
    paramString1 = this.a.getResources().getString(2131692794);
    for (;;)
    {
      bcql.a(this.a.getContext(), 2, paramString1, 0).b(this.a.a());
      return;
      label234:
      paramString1 = paramString2;
      if (paramInt1 == 0)
      {
        paramString1 = paramString2;
        if (localStructMsg != null)
        {
          paramString1 = this.a.getResources().getString(2131692782);
          AutoRemarkActivity.a(SystemRequestInfoView.a(this.a), 1017, String.valueOf(localStructMsg.req_uin.get()), l1, null);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflr
 * JD-Core Version:    0.7.0.1
 */