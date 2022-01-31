import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import java.util.Comparator;

class ahga
  implements Comparator<SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo>
{
  ahga(ahfx paramahfx) {}
  
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
 * Qualified Name:     ahga
 * JD-Core Version:    0.7.0.1
 */