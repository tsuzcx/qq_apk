import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class aiej
  implements aakl
{
  aiej(aido paramaido) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((ahcf.a(this.a.sessionInfo.curFriendUin)) && (paramInt1 == 0)) {
      this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
    }
    for (;;)
    {
      paramString = this.a.jdField_a_of_type_Okn.a(this.a.app, this.a.getCurFriendUin(), paramInt1);
      if (paramString != null) {
        nzg.a.b(this.a.getCurFriendUin(), paramString.id.get(), paramString.name.get());
      }
      return;
      com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
      this.a.jdField_a_of_type_Okn.a(paramString, this.a.mActivity, this.a.app, this.a.getCurFriendUin(), paramInt1, aido.a(this.a), aido.b(this.a), paramInt2, this.a.sessionInfo);
      apau.a(this.a.app, this.a.sessionInfo.curFriendUin, aido.e(this.a), paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiej
 * JD-Core Version:    0.7.0.1
 */