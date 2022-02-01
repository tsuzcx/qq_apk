package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.picinfolist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.vedioinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.audioinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.MediaInfo
 * JD-Core Version:    0.7.0.1
 */