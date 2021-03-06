package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class FunnySpaceAction
  extends JceStruct
{
  static ArrayList<Integer> cache_ComboIndexList;
  static Map<String, String> cache_ExtendInfo = new HashMap();
  public ArrayList<Integer> ComboIndexList = null;
  public Map<String, String> ExtendInfo = null;
  public String ID = "";
  public String LikeKey = "";
  public String Name = "";
  public int Type = 0;
  public String Url = "";
  
  static
  {
    cache_ExtendInfo.put("", "");
    cache_ComboIndexList = new ArrayList();
    cache_ComboIndexList.add(Integer.valueOf(0));
  }
  
  public FunnySpaceAction() {}
  
  public FunnySpaceAction(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, ArrayList<Integer> paramArrayList)
  {
    this.ID = paramString1;
    this.Type = paramInt;
    this.Name = paramString2;
    this.LikeKey = paramString3;
    this.Url = paramString4;
    this.ExtendInfo = paramMap;
    this.ComboIndexList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ID = paramJceInputStream.readString(0, false);
    this.Type = paramJceInputStream.read(this.Type, 1, false);
    this.Name = paramJceInputStream.readString(2, false);
    this.LikeKey = paramJceInputStream.readString(3, false);
    this.Url = paramJceInputStream.readString(4, false);
    this.ExtendInfo = ((Map)paramJceInputStream.read(cache_ExtendInfo, 5, false));
    this.ComboIndexList = ((ArrayList)paramJceInputStream.read(cache_ComboIndexList, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.ID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.Type, 1);
    localObject = this.Name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.LikeKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.Url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.ExtendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    localObject = this.ComboIndexList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.FunnySpaceAction
 * JD-Core Version:    0.7.0.1
 */