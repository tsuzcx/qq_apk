import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class aack
  implements aajs
{
  aack(aacd paramaacd, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(aacd.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((aacd.n(this.jdField_a_of_type_Aacd) != null) && (paramInt == 1))
    {
      if (aajr.a().a(aacd.o(this.jdField_a_of_type_Aacd), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Aacd.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Aacd.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Aacd.i();
      }
    }
    label90:
    while ((aajr.a().a(aacd.p(this.jdField_a_of_type_Aacd), "subscribe_sp_key_show_follow_guide") != 0) || (aaaf.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Aacd.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aack
 * JD-Core Version:    0.7.0.1
 */