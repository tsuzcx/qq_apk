package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryNewUserRecommendedListNotBind
  extends JceStruct
{
  static ArrayList<RecommendedContactInfo> cache_RecommendedContacts = new ArrayList();
  public ArrayList<RecommendedContactInfo> RecommendedContacts = null;
  public long lastUsedFlag = 1L;
  
  static
  {
    RecommendedContactInfo localRecommendedContactInfo = new RecommendedContactInfo();
    cache_RecommendedContacts.add(localRecommendedContactInfo);
  }
  
  public ResponeQueryNewUserRecommendedListNotBind() {}
  
  public ResponeQueryNewUserRecommendedListNotBind(ArrayList<RecommendedContactInfo> paramArrayList, long paramLong)
  {
    this.RecommendedContacts = paramArrayList;
    this.lastUsedFlag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.RecommendedContacts = ((ArrayList)paramJceInputStream.read(cache_RecommendedContacts, 1, true));
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.RecommendedContacts, 1);
    paramJceOutputStream.write(this.lastUsedFlag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryNewUserRecommendedListNotBind
 * JD-Core Version:    0.7.0.1
 */