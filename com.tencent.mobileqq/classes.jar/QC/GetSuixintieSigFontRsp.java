package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetSuixintieSigFontRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  static ArrayList<UniBusiSimpleItemDetail> cache_vItems = new ArrayList();
  public int isEnd = 0;
  public CommonRsp stRet = null;
  public String strAttachInfo = "";
  public ArrayList<UniBusiSimpleItemDetail> vItems = null;
  
  static
  {
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = new UniBusiSimpleItemDetail();
    cache_vItems.add(localUniBusiSimpleItemDetail);
  }
  
  public GetSuixintieSigFontRsp() {}
  
  public GetSuixintieSigFontRsp(CommonRsp paramCommonRsp, ArrayList<UniBusiSimpleItemDetail> paramArrayList, String paramString, int paramInt)
  {
    this.stRet = paramCommonRsp;
    this.vItems = paramArrayList;
    this.strAttachInfo = paramString;
    this.isEnd = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stRet = ((CommonRsp)paramJceInputStream.read(cache_stRet, 0, false));
    this.vItems = ((ArrayList)paramJceInputStream.read(cache_vItems, 1, false));
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.isEnd = paramJceInputStream.read(this.isEnd, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stRet;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vItems;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.strAttachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.isEnd, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetSuixintieSigFontRsp
 * JD-Core Version:    0.7.0.1
 */