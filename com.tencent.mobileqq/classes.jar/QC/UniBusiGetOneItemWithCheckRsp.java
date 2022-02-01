package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiGetOneItemWithCheckRsp
  extends JceStruct
{
  static UniBusiSimpleItemDetail cache_stDetail = new UniBusiSimpleItemDetail();
  public String errmsg = "";
  public int ret = 0;
  public UniBusiSimpleItemDetail stDetail = null;
  
  public UniBusiGetOneItemWithCheckRsp() {}
  
  public UniBusiGetOneItemWithCheckRsp(int paramInt, String paramString, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.stDetail = paramUniBusiSimpleItemDetail;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stDetail = ((UniBusiSimpleItemDetail)paramJceInputStream.read(cache_stDetail, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.stDetail;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiGetOneItemWithCheckRsp
 * JD-Core Version:    0.7.0.1
 */