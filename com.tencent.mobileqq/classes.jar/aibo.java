import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class aibo
  implements bila<oidb_0x8ed.RspBody>
{
  aibo(aiav paramaiav) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.k))
    {
      QQToast.a(this.a.mContext, 2, anvx.a(2131704594), 0).a();
      bhhr.f(this.a.getActivity(), this.a.app.getCurrentAccountUin(), false);
      this.a.a.a(this.a.mContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibo
 * JD-Core Version:    0.7.0.1
 */