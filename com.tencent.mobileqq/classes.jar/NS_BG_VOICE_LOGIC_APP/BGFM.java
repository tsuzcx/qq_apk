package NS_BG_VOICE_LOGIC_APP;

import NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone;
import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BGFM
  extends JceStruct
{
  static ArrayList<BroadcastForQzone> cache_stFmBroadcast;
  static ArrayList<BGMusicForQzone> cache_stFmLists = new ArrayList();
  public ArrayList<BroadcastForQzone> stFmBroadcast = null;
  public ArrayList<BGMusicForQzone> stFmLists = null;
  
  static
  {
    Object localObject = new BGMusicForQzone();
    cache_stFmLists.add(localObject);
    cache_stFmBroadcast = new ArrayList();
    localObject = new BroadcastForQzone();
    cache_stFmBroadcast.add(localObject);
  }
  
  public BGFM() {}
  
  public BGFM(ArrayList<BGMusicForQzone> paramArrayList, ArrayList<BroadcastForQzone> paramArrayList1)
  {
    this.stFmLists = paramArrayList;
    this.stFmBroadcast = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFmLists = ((ArrayList)paramJceInputStream.read(cache_stFmLists, 1, false));
    this.stFmBroadcast = ((ArrayList)paramJceInputStream.read(cache_stFmBroadcast, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.stFmLists;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.stFmBroadcast;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_BG_VOICE_LOGIC_APP.BGFM
 * JD-Core Version:    0.7.0.1
 */