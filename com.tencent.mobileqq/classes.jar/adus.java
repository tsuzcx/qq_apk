import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class adus
  extends anvi
{
  public adus(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.a();
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
      DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
    }
    while ((this.a.jdField_a_of_type_Bisl == null) || (!this.a.jdField_a_of_type_Bisl.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_Bisl.dismiss();
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null))
      {
        paramString = ((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adus
 * JD-Core Version:    0.7.0.1
 */