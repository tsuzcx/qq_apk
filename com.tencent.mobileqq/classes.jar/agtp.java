import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import java.util.Comparator;

class agtp
  implements Comparator<SpringFestivalRedpacketConfBean.TimeInfo>
{
  agtp(agtk paramagtk) {}
  
  public int a(SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo1, SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo2)
  {
    if (paramTimeInfo1.beginTime == paramTimeInfo2.beginTime) {
      return 0;
    }
    if (paramTimeInfo1.beginTime > paramTimeInfo2.beginTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtp
 * JD-Core Version:    0.7.0.1
 */