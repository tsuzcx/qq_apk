import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class ahgv
  implements bhai<oidb_0x8ed.RspBody>
{
  ahgv(ahgc paramahgc) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.k))
    {
      QQToast.a(this.a.mContext, 2, amtj.a(2131704243), 0).a();
      bfyz.f(this.a.getActivity(), this.a.app.getCurrentAccountUin(), false);
      this.a.a.a(this.a.mContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgv
 * JD-Core Version:    0.7.0.1
 */