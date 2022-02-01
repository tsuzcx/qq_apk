import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class aaih
  implements aaav<CertifiedAccountWrite.StDoCommentRsp>
{
  aaih(aaid paramaaid, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramStDoCommentRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)) {
      paramStDoCommentRsp.comment.id.set(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get());
    }
    wjj.a().dispatch(this.jdField_a_of_type_Aaid.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.jdField_a_of_type_Aaid.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaih
 * JD-Core Version:    0.7.0.1
 */