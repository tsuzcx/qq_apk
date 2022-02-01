package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RecordPlayInfo
  extends JceStruct
{
  static ArrayList<OneVideoVidInfo> cache_video_info_vec = new ArrayList();
  public String fileName = "";
  public int status = 0;
  public int totalCount = 0;
  public ArrayList<OneVideoVidInfo> video_info_vec = null;
  
  static
  {
    OneVideoVidInfo localOneVideoVidInfo = new OneVideoVidInfo();
    cache_video_info_vec.add(localOneVideoVidInfo);
  }
  
  public RecordPlayInfo() {}
  
  public RecordPlayInfo(String paramString, int paramInt1, int paramInt2, ArrayList<OneVideoVidInfo> paramArrayList)
  {
    this.fileName = paramString;
    this.totalCount = paramInt1;
    this.status = paramInt2;
    this.video_info_vec = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileName = paramJceInputStream.readString(0, false);
    this.totalCount = paramJceInputStream.read(this.totalCount, 1, false);
    this.status = paramJceInputStream.read(this.status, 2, false);
    this.video_info_vec = ((ArrayList)paramJceInputStream.read(cache_video_info_vec, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.fileName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.totalCount, 1);
    paramJceOutputStream.write(this.status, 2);
    localObject = this.video_info_vec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.RecordPlayInfo
 * JD-Core Version:    0.7.0.1
 */