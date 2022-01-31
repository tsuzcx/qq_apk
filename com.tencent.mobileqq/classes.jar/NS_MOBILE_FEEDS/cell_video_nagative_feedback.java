package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_video_nagative_feedback
  extends JceStruct
{
  static ArrayList<nagative_fb_info> cache_vecNagFbInfo = new ArrayList();
  public String buttonTxt = "";
  public String leftTitle = "";
  public String toastTxt = "";
  public ArrayList<nagative_fb_info> vecNagFbInfo;
  
  static
  {
    nagative_fb_info localnagative_fb_info = new nagative_fb_info();
    cache_vecNagFbInfo.add(localnagative_fb_info);
  }
  
  public cell_video_nagative_feedback() {}
  
  public cell_video_nagative_feedback(ArrayList<nagative_fb_info> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    this.vecNagFbInfo = paramArrayList;
    this.leftTitle = paramString1;
    this.buttonTxt = paramString2;
    this.toastTxt = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecNagFbInfo = ((ArrayList)paramJceInputStream.read(cache_vecNagFbInfo, 0, false));
    this.leftTitle = paramJceInputStream.readString(1, false);
    this.buttonTxt = paramJceInputStream.readString(2, false);
    this.toastTxt = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecNagFbInfo != null) {
      paramJceOutputStream.write(this.vecNagFbInfo, 0);
    }
    if (this.leftTitle != null) {
      paramJceOutputStream.write(this.leftTitle, 1);
    }
    if (this.buttonTxt != null) {
      paramJceOutputStream.write(this.buttonTxt, 2);
    }
    if (this.toastTxt != null) {
      paramJceOutputStream.write(this.toastTxt, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_video_nagative_feedback
 * JD-Core Version:    0.7.0.1
 */