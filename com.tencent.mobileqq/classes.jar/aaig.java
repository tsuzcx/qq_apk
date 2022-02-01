import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class aaig
  implements aaav<CertifiedAccountWrite.StDoCommentRsp>
{
  aaig(aaid paramaaid, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    wjj.a().dispatch(this.jdField_a_of_type_Aaid.a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), Integer.valueOf(this.jdField_a_of_type_Aaid.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaig
 * JD-Core Version:    0.7.0.1
 */