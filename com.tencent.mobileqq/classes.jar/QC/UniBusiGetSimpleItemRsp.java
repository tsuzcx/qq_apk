package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class UniBusiGetSimpleItemRsp
  extends JceStruct
{
  static Map<Integer, ArrayList<UniBusiSimpleItemDetail>> cache_mAppidItemDetail = new HashMap();
  public String errmsg = "";
  public Map<Integer, ArrayList<UniBusiSimpleItemDetail>> mAppidItemDetail;
  public int ret;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new UniBusiSimpleItemDetail());
    cache_mAppidItemDetail.put(Integer.valueOf(0), localArrayList);
  }
  
  public UniBusiGetSimpleItemRsp() {}
  
  public UniBusiGetSimpleItemRsp(int paramInt, String paramString, Map<Integer, ArrayList<UniBusiSimpleItemDetail>> paramMap)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.mAppidItemDetail = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.mAppidItemDetail = ((Map)paramJceInputStream.read(cache_mAppidItemDetail, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.mAppidItemDetail != null) {
      paramJceOutputStream.write(this.mAppidItemDetail, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiGetSimpleItemRsp
 * JD-Core Version:    0.7.0.1
 */