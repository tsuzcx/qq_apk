package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MediaInfo
  extends JceStruct
{
  static ArrayList<AudioInfo> cache_audioinfo;
  static ArrayList<PicInfo> cache_picinfolist;
  static VedioInfo cache_vedioinfo;
  public ArrayList<AudioInfo> audioinfo;
  public ArrayList<PicInfo> picinfolist;
  public VedioInfo vedioinfo;
  
  public MediaInfo() {}
  
  public MediaInfo(ArrayList<PicInfo> paramArrayList, VedioInfo paramVedioInfo, ArrayList<AudioInfo> paramArrayList1)
  {
    this.picinfolist = paramArrayList;
    this.vedioinfo = paramVedioInfo;
    this.audioinfo = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_picinfolist == null)
    {
      cache_picinfolist = new ArrayList();
      localObject = new PicInfo();
      cache_picinfolist.add(localObject);
    }
    this.picinfolist = ((ArrayList)paramJceInputStream.read(cache_picinfolist, 0, false));
    if (cache_vedioinfo == null) {
      cache_vedioinfo = new VedioInfo();
    }
    this.vedioinfo = ((VedioInfo)paramJceInputStream.read(cache_vedioinfo, 1, false));
    if (cache_audioinfo == null)
    {
      cache_audioinfo = new ArrayList();
      localObject = new AudioInfo();
      cache_audioinfo.add(localObject);
    }
    this.audioinfo = ((ArrayList)paramJceInputStream.read(cache_audioinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picinfolist != null) {
      paramJceOutputStream.write(this.picinfolist, 0);
    }
    if (this.vedioinfo != null) {
      paramJceOutputStream.write(this.vedioinfo, 1);
    }
    if (this.audioinfo != null) {
      paramJceOutputStream.write(this.audioinfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.MediaInfo
 * JD-Core Version:    0.7.0.1
 */