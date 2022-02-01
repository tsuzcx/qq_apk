import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class aacq
  implements zxa<CertifiedAccountRead.StGetFeedListRsp>
{
  aacq(aacp paramaacp, zxz paramzxz) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.jdField_a_of_type_Aacp.getLoadInfo().d(paramStGetFeedListRsp.livePageInfo.get());
      if ((this.jdField_a_of_type_Zxz.c()) || (this.jdField_a_of_type_Zxz.d())) {
        if ((paramStGetFeedListRsp.hotLive.get() == null) || (paramStGetFeedListRsp.hotLive.get().size() == 0)) {
          if (aacp.a(this.jdField_a_of_type_Aacp) != null)
          {
            this.jdField_a_of_type_Aacp.clearData();
            aacp.a(this.jdField_a_of_type_Aacp).b(true);
          }
        }
      }
    }
    label189:
    do
    {
      do
      {
        break label189;
        break label189;
        paramString = this.jdField_a_of_type_Aacp;
        localList = paramStGetFeedListRsp.hotLive.get();
        localStCommonExt = paramStGetFeedListRsp.extInfo;
        if (paramStGetFeedListRsp.isFinish.get() == 1) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramString.a(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
          this.jdField_a_of_type_Aacp.setShareData("share_key_continue_feeds", new zxs(paramStGetFeedListRsp.hotLive.get()));
          return;
          if (aacp.a(this.jdField_a_of_type_Aacp) == null) {
            break;
          }
          aacp.a(this.jdField_a_of_type_Aacp).b(false);
          break;
        }
      } while (!this.jdField_a_of_type_Zxz.e());
      paramString = this.jdField_a_of_type_Aacp;
      List localList = paramStGetFeedListRsp.hotLive.get();
      COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramString.b(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
        return;
      }
      this.jdField_a_of_type_Aacp.notifyLoadingComplete(false);
    } while (((!this.jdField_a_of_type_Zxz.c()) && (!this.jdField_a_of_type_Zxz.d())) || (aacp.a(this.jdField_a_of_type_Aacp) == null));
    aacp.a(this.jdField_a_of_type_Aacp).b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacq
 * JD-Core Version:    0.7.0.1
 */