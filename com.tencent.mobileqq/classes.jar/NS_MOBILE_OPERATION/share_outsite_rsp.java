package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class share_outsite_rsp
  extends JceStruct
{
  static s_arkshare cache_ark_sharedata = new s_arkshare();
  public s_arkshare ark_sharedata = null;
  public int iShareOutType = 0;
  public String msg = "";
  public int ret = 0;
  public String strProgramID = "";
  public String strProgramMsg = "";
  public String strProgramPath = "";
  public String url = "";
  
  public share_outsite_rsp() {}
  
  public share_outsite_rsp(int paramInt1, String paramString1, String paramString2, int paramInt2, s_arkshare params_arkshare, String paramString3, String paramString4, String paramString5)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.url = paramString2;
    this.iShareOutType = paramInt2;
    this.ark_sharedata = params_arkshare;
    this.strProgramID = paramString3;
    this.strProgramPath = paramString4;
    this.strProgramMsg = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.url = paramJceInputStream.readString(2, false);
    this.iShareOutType = paramJceInputStream.read(this.iShareOutType, 3, false);
    this.ark_sharedata = ((s_arkshare)paramJceInputStream.read(cache_ark_sharedata, 4, false));
    this.strProgramID = paramJceInputStream.readString(5, false);
    this.strProgramPath = paramJceInputStream.readString(6, false);
    this.strProgramMsg = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.iShareOutType, 3);
    localObject = this.ark_sharedata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.strProgramID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strProgramPath;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.strProgramMsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.share_outsite_rsp
 * JD-Core Version:    0.7.0.1
 */