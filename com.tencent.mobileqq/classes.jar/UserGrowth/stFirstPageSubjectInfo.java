package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stFirstPageSubjectInfo
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  static ArrayList<stNotifyMsg> cache_topContent = new ArrayList();
  public int ID = 0;
  public String name = "";
  public int redCount = 0;
  public stSchema schema = null;
  public ArrayList<stNotifyMsg> topContent = null;
  
  static
  {
    stNotifyMsg localstNotifyMsg = new stNotifyMsg();
    cache_topContent.add(localstNotifyMsg);
  }
  
  public stFirstPageSubjectInfo() {}
  
  public stFirstPageSubjectInfo(int paramInt1, String paramString, int paramInt2, ArrayList<stNotifyMsg> paramArrayList, stSchema paramstSchema)
  {
    this.ID = paramInt1;
    this.name = paramString;
    this.redCount = paramInt2;
    this.topContent = paramArrayList;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ID = paramJceInputStream.read(this.ID, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.redCount = paramJceInputStream.read(this.redCount, 2, false);
    this.topContent = ((ArrayList)paramJceInputStream.read(cache_topContent, 3, false));
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ID, 0);
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.redCount, 2);
    localObject = this.topContent;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFirstPageSubjectInfo
 * JD-Core Version:    0.7.0.1
 */