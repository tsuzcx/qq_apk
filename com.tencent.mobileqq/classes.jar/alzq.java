import KQQ.ReqItem;
import KQQ.RespItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.text.TextUtils;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class alzq
  implements azal
{
  public alzq(PublicAccountHandler paramPublicAccountHandler) {}
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 0;
    localReqItem.eServiceID = 102;
    boolean bool = swy.c();
    long l1 = PublicAccountHandler.a(this.a, bool);
    long l2 = PublicAccountHandler.b(this.a, bool);
    Object localObject2 = PublicAccountHandler.a(this.a);
    if (bool)
    {
      localObject1 = new CertifiedAccountRead.StGetFollowListReq();
      ((CertifiedAccountRead.StGetFollowListReq)localObject1).seq.set(bdeu.a(l1));
      ((CertifiedAccountRead.StGetFollowListReq)localObject1).count.set(bdeu.a(1L));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((CertifiedAccountRead.StGetFollowListReq)localObject1).attach_info.set((String)localObject2);
      }
      localObject2 = new PROTOCAL.StQWebReq();
      ((PROTOCAL.StQWebReq)localObject2).Seq.set(-1L);
      ((PROTOCAL.StQWebReq)localObject2).qua.set(bjdm.a());
      ((PROTOCAL.StQWebReq)localObject2).deviceInfo.set(bjdl.a().c());
      ((PROTOCAL.StQWebReq)localObject2).busiBuff.set(ByteStringMicro.copyFrom(((CertifiedAccountRead.StGetFollowListReq)localObject1).toByteArray()));
      localObject1 = ykm.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((PROTOCAL.StQWebReq)localObject2).traceid.set((String)localObject1);
      }
      localObject2 = ((PROTOCAL.StQWebReq)localObject2).toByteArray();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      localReqItem.vecParam = bdpd.a((byte[])localObject1);
      return localReqItem;
    }
    Object localObject1 = new mobileqq_mp.GetUserFollowListRequest();
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).follow_seqno.set((int)l1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).public_account_seqno.set((int)l2);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).begin.set(0);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).limit.set(1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).version.set(1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).is_increment.set(true);
    localReqItem.vecParam = bdpd.a(((mobileqq_mp.GetUserFollowListRequest)localObject1).toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 102) && (paramRespItem.cResult == 0)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzq
 * JD-Core Version:    0.7.0.1
 */