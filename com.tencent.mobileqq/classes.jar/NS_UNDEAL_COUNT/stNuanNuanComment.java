package NS_UNDEAL_COUNT;

import NS_MOBILE_COMM.OfficialComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stNuanNuanComment
  extends JceStruct
{
  static ArrayList<OfficialComment> cache_vcComments;
  static ArrayList<String> cache_vcFirstComments = new ArrayList();
  static ArrayList<String> cache_vcOtherComments;
  public int iPageCount = 5;
  public int iStatus = 0;
  public ArrayList<OfficialComment> vcComments = null;
  public ArrayList<String> vcFirstComments = null;
  public ArrayList<String> vcOtherComments = null;
  
  static
  {
    cache_vcFirstComments.add("");
    cache_vcOtherComments = new ArrayList();
    cache_vcOtherComments.add("");
    cache_vcComments = new ArrayList();
    OfficialComment localOfficialComment = new OfficialComment();
    cache_vcComments.add(localOfficialComment);
  }
  
  public stNuanNuanComment() {}
  
  public stNuanNuanComment(int paramInt1, int paramInt2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<OfficialComment> paramArrayList)
  {
    this.iStatus = paramInt1;
    this.iPageCount = paramInt2;
    this.vcFirstComments = paramArrayList1;
    this.vcOtherComments = paramArrayList2;
    this.vcComments = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iStatus = paramJceInputStream.read(this.iStatus, 0, true);
    this.iPageCount = paramJceInputStream.read(this.iPageCount, 1, false);
    this.vcFirstComments = ((ArrayList)paramJceInputStream.read(cache_vcFirstComments, 2, false));
    this.vcOtherComments = ((ArrayList)paramJceInputStream.read(cache_vcOtherComments, 3, false));
    this.vcComments = ((ArrayList)paramJceInputStream.read(cache_vcComments, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iStatus, 0);
    paramJceOutputStream.write(this.iPageCount, 1);
    if (this.vcFirstComments != null) {
      paramJceOutputStream.write(this.vcFirstComments, 2);
    }
    if (this.vcOtherComments != null) {
      paramJceOutputStream.write(this.vcOtherComments, 3);
    }
    if (this.vcComments != null) {
      paramJceOutputStream.write(this.vcComments, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.stNuanNuanComment
 * JD-Core Version:    0.7.0.1
 */