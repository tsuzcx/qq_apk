import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import java.util.ArrayList;

public class aige
  implements Runnable
{
  public aige(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void run()
  {
    int i;
    String str1;
    if (this.a.app != null)
    {
      int j = ((NearbyCardManager)this.a.app.getManager(105)).b();
      if ((this.a.b <= 0) || (((MediaPreviewInfo)this.a.a.get(0)).a != 2)) {
        break label108;
      }
      i = 1;
      if (j != 0) {
        break label113;
      }
      str1 = "1";
      label69:
      if (i == 0) {
        break label119;
      }
    }
    label108:
    label113:
    label119:
    for (String str2 = "2";; str2 = "1")
    {
      FaceScoreUtils.a("clk_detail", "", new String[] { "", str1, "", str2 });
      return;
      i = 0;
      break;
      str1 = "2";
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aige
 * JD-Core Version:    0.7.0.1
 */