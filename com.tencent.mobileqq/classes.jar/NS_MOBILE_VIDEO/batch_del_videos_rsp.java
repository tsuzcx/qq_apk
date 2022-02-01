package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class batch_del_videos_rsp
  extends JceStruct
{
  static ArrayList<DelVideoSummary> cache_summarys;
  public String msg = "";
  public int ret;
  public ArrayList<DelVideoSummary> summarys;
  
  public batch_del_videos_rsp() {}
  
  public batch_del_videos_rsp(int paramInt, String paramString, ArrayList<DelVideoSummary> paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.summarys = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_summarys == null)
    {
      cache_summarys = new ArrayList();
      DelVideoSummary localDelVideoSummary = new DelVideoSummary();
      cache_summarys.add(localDelVideoSummary);
    }
    this.summarys = ((ArrayList)paramJceInputStream.read(cache_summarys, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.summarys;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.batch_del_videos_rsp
 * JD-Core Version:    0.7.0.1
 */