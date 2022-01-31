package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BroadcastAudio
  extends JceStruct
{
  static BroadcastUrl cache_masterUrl = new BroadcastUrl();
  static ArrayList cache_slaveUrl = new ArrayList();
  public BroadcastUrl masterUrl;
  public ArrayList slaveUrl;
  
  static
  {
    BroadcastUrl localBroadcastUrl = new BroadcastUrl();
    cache_slaveUrl.add(localBroadcastUrl);
  }
  
  public BroadcastAudio() {}
  
  public BroadcastAudio(BroadcastUrl paramBroadcastUrl, ArrayList paramArrayList)
  {
    this.masterUrl = paramBroadcastUrl;
    this.slaveUrl = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.masterUrl = ((BroadcastUrl)paramJceInputStream.read(cache_masterUrl, 0, false));
    this.slaveUrl = ((ArrayList)paramJceInputStream.read(cache_slaveUrl, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.masterUrl != null) {
      paramJceOutputStream.write(this.masterUrl, 0);
    }
    if (this.slaveUrl != null) {
      paramJceOutputStream.write(this.slaveUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio
 * JD-Core Version:    0.7.0.1
 */