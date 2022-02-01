import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class ahjp
  implements zuz
{
  ahjp(ahiu paramahiu) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((agjp.a(this.a.sessionInfo.curFriendUin)) && (paramInt1 == 0)) {
      this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
    }
    for (;;)
    {
      paramString = this.a.jdField_a_of_type_Ocw.a(this.a.app, this.a.getCurFriendUin(), paramInt1);
      if (paramString != null) {
        nsf.a.b(this.a.getCurFriendUin(), paramString.id.get(), paramString.name.get());
      }
      return;
      com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
      this.a.jdField_a_of_type_Ocw.a(paramString, this.a.mActivity, this.a.app, this.a.getCurFriendUin(), paramInt1, ahiu.a(this.a), ahiu.b(this.a), paramInt2, this.a.sessionInfo);
      anxs.a(this.a.app, this.a.sessionInfo.curFriendUin, ahiu.e(this.a), paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjp
 * JD-Core Version:    0.7.0.1
 */