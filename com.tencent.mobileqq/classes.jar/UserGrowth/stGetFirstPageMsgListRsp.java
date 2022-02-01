package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stGetFirstPageMsgListRsp
  extends JceStruct
{
  static ArrayList<stFirstPageSubjectInfo> cache_subjectList = new ArrayList();
  static Map<Integer, stMsgRedDotCount> cache_topRedCount;
  public boolean IsFinished = true;
  public String attachInfo = "";
  public ArrayList<stFirstPageSubjectInfo> subjectList = null;
  public Map<Integer, stMsgRedDotCount> topRedCount = null;
  
  static
  {
    Object localObject = new stFirstPageSubjectInfo();
    cache_subjectList.add(localObject);
    cache_topRedCount = new HashMap();
    localObject = new stMsgRedDotCount();
    cache_topRedCount.put(Integer.valueOf(0), localObject);
  }
  
  public stGetFirstPageMsgListRsp() {}
  
  public stGetFirstPageMsgListRsp(String paramString, boolean paramBoolean, ArrayList<stFirstPageSubjectInfo> paramArrayList, Map<Integer, stMsgRedDotCount> paramMap)
  {
    this.attachInfo = paramString;
    this.IsFinished = paramBoolean;
    this.subjectList = paramArrayList;
    this.topRedCount = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.IsFinished = paramJceInputStream.read(this.IsFinished, 1, false);
    this.subjectList = ((ArrayList)paramJceInputStream.read(cache_subjectList, 2, false));
    this.topRedCount = ((Map)paramJceInputStream.read(cache_topRedCount, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.IsFinished, 1);
    localObject = this.subjectList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.topRedCount;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetFirstPageMsgListRsp
 * JD-Core Version:    0.7.0.1
 */