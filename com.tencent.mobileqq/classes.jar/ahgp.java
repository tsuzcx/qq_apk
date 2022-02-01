import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class ahgp
  implements bhai<oidb_0x8ed.RspBody>
{
  ahgp(ahgo paramahgo) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a.tag, 2, "exitRoom: errorCode = " + paramInt);
    }
    if ((paramInt == 0) || (paramInt == 1285))
    {
      if ((this.a.a.a != null) && (this.a.a.a.isShowing())) {
        this.a.a.a.dismiss();
      }
      new Intent().putExtra("isNeedFinish", true);
      bfyz.f(this.a.a.getActivity(), this.a.a.app.getCurrentAccountUin(), false);
      awkz.a().d();
      this.a.a.j = true;
      this.a.a.finish(1);
      return;
    }
    if ((this.a.a.a != null) && (this.a.a.a.isShowing())) {
      this.a.a.a.dismiss();
    }
    QQToast.a(this.a.a.getActivity(), 1, amtj.a(2131704196), 0).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgp
 * JD-Core Version:    0.7.0.1
 */