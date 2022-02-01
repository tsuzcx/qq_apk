package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetAdvInfoReq
  extends JceStruct
{
  static ArrayList<String> cache_vecAdvIdList = new ArrayList();
  public String strUid = "";
  public ArrayList<String> vecAdvIdList = null;
  
  static
  {
    cache_vecAdvIdList.add("");
  }
  
  public GetAdvInfoReq() {}
  
  public GetAdvInfoReq(ArrayList<String> paramArrayList, String paramString)
  {
    this.vecAdvIdList = paramArrayList;
    this.strUid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecAdvIdList = ((ArrayList)paramJceInputStream.read(cache_vecAdvIdList, 0, false));
    this.strUid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecAdvIdList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.strUid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.GetAdvInfoReq
 * JD-Core Version:    0.7.0.1
 */