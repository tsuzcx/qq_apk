import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import java.util.Comparator;

class agtn
  implements Comparator<SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo>
{
  agtn(agtk paramagtk) {}
  
  public int a(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo1, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo2)
  {
    if (paramBannerInfo1.bannerTime.beginTime == paramBannerInfo2.bannerTime.beginTime) {
      return 0;
    }
    if (paramBannerInfo1.bannerTime.beginTime > paramBannerInfo2.bannerTime.beginTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtn
 * JD-Core Version:    0.7.0.1
 */