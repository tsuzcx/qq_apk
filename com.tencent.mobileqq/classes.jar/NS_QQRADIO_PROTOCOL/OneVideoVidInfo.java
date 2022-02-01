package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class OneVideoVidInfo
  extends JceStruct
{
  static ArrayList<OneVideoPlayInfo> cache_play_info_vec = new ArrayList();
  public int duration = 0;
  public String fileName = "";
  public String imageUrl = "";
  public ArrayList<OneVideoPlayInfo> play_info_vec = null;
  public int status = 0;
  public String vid = "";
  
  static
  {
    OneVideoPlayInfo localOneVideoPlayInfo = new OneVideoPlayInfo();
    cache_play_info_vec.add(localOneVideoPlayInfo);
  }
  
  public OneVideoVidInfo() {}
  
  public OneVideoVidInfo(String paramString1, String paramString2, int paramInt1, String paramString3, ArrayList<OneVideoPlayInfo> paramArrayList, int paramInt2)
  {
    this.vid = paramString1;
    this.fileName = paramString2;
    this.duration = paramInt1;
    this.imageUrl = paramString3;
    this.play_info_vec = paramArrayList;
    this.status = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vid = paramJceInputStream.readString(0, false);
    this.fileName = paramJceInputStream.readString(1, false);
    this.duration = paramJceInputStream.read(this.duration, 2, false);
    this.imageUrl = paramJceInputStream.readString(3, false);
    this.play_info_vec = ((ArrayList)paramJceInputStream.read(cache_play_info_vec, 4, false));
    this.status = paramJceInputStream.read(this.status, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.fileName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.duration, 2);
    localObject = this.imageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.play_info_vec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    paramJceOutputStream.write(this.status, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.OneVideoVidInfo
 * JD-Core Version:    0.7.0.1
 */