package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PicTagInfo
  extends JceStruct
{
  static ArrayList<TagInfo> cache_vecTagInfo = new ArrayList();
  public int iCode = 0;
  public String strPicId = "";
  public String strPicTagId = "";
  public ArrayList<TagInfo> vecTagInfo = null;
  
  static
  {
    TagInfo localTagInfo = new TagInfo();
    cache_vecTagInfo.add(localTagInfo);
  }
  
  public PicTagInfo() {}
  
  public PicTagInfo(ArrayList<TagInfo> paramArrayList, String paramString1, int paramInt, String paramString2)
  {
    this.vecTagInfo = paramArrayList;
    this.strPicId = paramString1;
    this.iCode = paramInt;
    this.strPicTagId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecTagInfo = ((ArrayList)paramJceInputStream.read(cache_vecTagInfo, 0, false));
    this.strPicId = paramJceInputStream.readString(1, false);
    this.iCode = paramJceInputStream.read(this.iCode, 2, false);
    this.strPicTagId = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecTagInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.strPicId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.iCode, 2);
    localObject = this.strPicTagId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FASHION_FEEDS_TAG_PROTO.PicTagInfo
 * JD-Core Version:    0.7.0.1
 */