package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetSuixintieSigFontRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  static ArrayList<UniBusiSimpleItemDetail> cache_vItems = new ArrayList();
  public CommonRsp stRet;
  public String strAttachInfo = "";
  public ArrayList<UniBusiSimpleItemDetail> vItems;
  
  static
  {
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = new UniBusiSimpleItemDetail();
    cache_vItems.add(localUniBusiSimpleItemDetail);
  }
  
  public GetSuixintieSigFontRsp() {}
  
  public GetSuixintieSigFontRsp(CommonRsp paramCommonRsp, ArrayList<UniBusiSimpleItemDetail> paramArrayList, String paramString)
  {
    this.stRet = paramCommonRsp;
    this.vItems = paramArrayList;
    this.strAttachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stRet = ((CommonRsp)paramJceInputStream.read(cache_stRet, 0, false));
    this.vItems = ((ArrayList)paramJceInputStream.read(cache_vItems, 1, false));
    this.strAttachInfo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stRet != null) {
      paramJceOutputStream.write(this.stRet, 0);
    }
    if (this.vItems != null) {
      paramJceOutputStream.write(this.vItems, 1);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetSuixintieSigFontRsp
 * JD-Core Version:    0.7.0.1
 */