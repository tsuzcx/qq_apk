package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.OfficialComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_get_rank_comment_rsp
  extends JceStruct
{
  static ArrayList<OfficialComment> cache_vcComments = new ArrayList();
  public ArrayList<OfficialComment> vcComments;
  
  static
  {
    OfficialComment localOfficialComment = new OfficialComment();
    cache_vcComments.add(localOfficialComment);
  }
  
  public mobile_get_rank_comment_rsp() {}
  
  public mobile_get_rank_comment_rsp(ArrayList<OfficialComment> paramArrayList)
  {
    this.vcComments = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vcComments = ((ArrayList)paramJceInputStream.read(cache_vcComments, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vcComments != null) {
      paramJceOutputStream.write(this.vcComments, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_get_rank_comment_rsp
 * JD-Core Version:    0.7.0.1
 */