package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class BroadcastAudio
  extends JceStruct
{
  static BroadcastUrl cache_masterUrl = new BroadcastUrl();
  static ArrayList<BroadcastUrl> cache_slaveUrl = new ArrayList();
  public BroadcastUrl masterUrl = null;
  public ArrayList<BroadcastUrl> slaveUrl = null;
  
  static
  {
    BroadcastUrl localBroadcastUrl = new BroadcastUrl();
    cache_slaveUrl.add(localBroadcastUrl);
  }
  
  public BroadcastAudio() {}
  
  public BroadcastAudio(BroadcastUrl paramBroadcastUrl, ArrayList<BroadcastUrl> paramArrayList)
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
    Object localObject = this.masterUrl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.slaveUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio
 * JD-Core Version:    0.7.0.1
 */