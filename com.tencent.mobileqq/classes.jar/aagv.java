import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class aagv
  implements aaav<CertifiedAccountRead.StGetFeedListRsp>
{
  aagv(aagu paramaagu, aabu paramaabu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.jdField_a_of_type_Aagu.getLoadInfo().d(paramStGetFeedListRsp.livePageInfo.get());
      if ((this.jdField_a_of_type_Aabu.c()) || (this.jdField_a_of_type_Aabu.d())) {
        if ((paramStGetFeedListRsp.hotLive.get() == null) || (paramStGetFeedListRsp.hotLive.get().size() == 0)) {
          if (aagu.a(this.jdField_a_of_type_Aagu) != null)
          {
            this.jdField_a_of_type_Aagu.clearData();
            aagu.a(this.jdField_a_of_type_Aagu).b(true);
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
        paramString = this.jdField_a_of_type_Aagu;
        localList = paramStGetFeedListRsp.hotLive.get();
        localStCommonExt = paramStGetFeedListRsp.extInfo;
        if (paramStGetFeedListRsp.isFinish.get() == 1) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramString.a(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
          this.jdField_a_of_type_Aagu.setShareData("share_key_continue_feeds", new aabn(paramStGetFeedListRsp.hotLive.get()));
          return;
          if (aagu.a(this.jdField_a_of_type_Aagu) == null) {
            break;
          }
          aagu.a(this.jdField_a_of_type_Aagu).b(false);
          break;
        }
      } while (!this.jdField_a_of_type_Aabu.e());
      paramString = this.jdField_a_of_type_Aagu;
      List localList = paramStGetFeedListRsp.hotLive.get();
      COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramString.b(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
        return;
      }
      this.jdField_a_of_type_Aagu.notifyLoadingComplete(false);
    } while (((!this.jdField_a_of_type_Aabu.c()) && (!this.jdField_a_of_type_Aabu.d())) || (aagu.a(this.jdField_a_of_type_Aagu) == null));
    aagu.a(this.jdField_a_of_type_Aagu).b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagv
 * JD-Core Version:    0.7.0.1
 */