package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BroadcastForQzone
  extends JceStruct
{
  static BroadcastAudio cache_broadcastAudioUrl = new BroadcastAudio();
  static ArrayList cache_showList = new ArrayList();
  public BroadcastAudio broadcastAudioUrl;
  public String broadcastID = "";
  public String broadcastName = "";
  public ArrayList showList;
  
  static
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    cache_showList.add(localBroadcastOneShow);
  }
  
  public BroadcastForQzone() {}
  
  public BroadcastForQzone(String paramString1, String paramString2, BroadcastAudio paramBroadcastAudio, ArrayList paramArrayList)
  {
    this.broadcastID = paramString1;
    this.broadcastName = paramString2;
    this.broadcastAudioUrl = paramBroadcastAudio;
    this.showList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.broadcastID = paramJceInputStream.readString(0, false);
    this.broadcastName = paramJceInputStream.readString(1, false);
    this.broadcastAudioUrl = ((BroadcastAudio)paramJceInputStream.read(cache_broadcastAudioUrl, 2, false));
    this.showList = ((ArrayList)paramJceInputStream.read(cache_showList, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.broadcastID != null) {
      paramJceOutputStream.write(this.broadcastID, 0);
    }
    if (this.broadcastName != null) {
      paramJceOutputStream.write(this.broadcastName, 1);
    }
    if (this.broadcastAudioUrl != null) {
      paramJceOutputStream.write(this.broadcastAudioUrl, 2);
    }
    if (this.showList != null) {
      paramJceOutputStream.write(this.showList, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone
 * JD-Core Version:    0.7.0.1
 */