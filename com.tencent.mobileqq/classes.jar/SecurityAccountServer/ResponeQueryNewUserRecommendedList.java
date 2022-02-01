package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryNewUserRecommendedList
  extends JceStruct
{
  static ArrayList<RecommendedContactInfo> cache_RecommendedContacts = new ArrayList();
  public ArrayList<RecommendedContactInfo> RecommendedContacts = null;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  
  static
  {
    RecommendedContactInfo localRecommendedContactInfo = new RecommendedContactInfo();
    cache_RecommendedContacts.add(localRecommendedContactInfo);
  }
  
  public ResponeQueryNewUserRecommendedList() {}
  
  public ResponeQueryNewUserRecommendedList(ArrayList<RecommendedContactInfo> paramArrayList, String paramString1, String paramString2, long paramLong)
  {
    this.RecommendedContacts = paramArrayList;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.lastUsedFlag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.RecommendedContacts = ((ArrayList)paramJceInputStream.read(cache_RecommendedContacts, 1, true));
    this.nationCode = paramJceInputStream.readString(2, true);
    this.mobileNo = paramJceInputStream.readString(3, true);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.RecommendedContacts, 1);
    paramJceOutputStream.write(this.nationCode, 2);
    paramJceOutputStream.write(this.mobileNo, 3);
    paramJceOutputStream.write(this.lastUsedFlag, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryNewUserRecommendedList
 * JD-Core Version:    0.7.0.1
 */