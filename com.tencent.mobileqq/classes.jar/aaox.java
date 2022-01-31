import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class aaox
  extends ajjh
{
  public aaox(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.a();
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
      DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
    }
    while ((this.a.jdField_a_of_type_Bbms == null) || (!this.a.jdField_a_of_type_Bbms.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_Bbms.dismiss();
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null))
      {
        paramString = ((ajjj)this.a.app.getManager(51)).e(this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "");
        if (paramString != null) {
          this.a.d = paramString.name;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DiscussionInfoCardActivity", 2, "onUpdateFriendInfo get owner name failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaox
 * JD-Core Version:    0.7.0.1
 */