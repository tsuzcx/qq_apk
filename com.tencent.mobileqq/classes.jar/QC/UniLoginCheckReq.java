package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniLoginCheckReq
  extends JceStruct
{
  static ArrayList<Hamlet> cache_stHamletList;
  static GetUsrKeyWordInfoReq cache_stKeyWord = new GetUsrKeyWordInfoReq();
  static LoginInfo cache_stLogin = new LoginInfo();
  public ArrayList<Hamlet> stHamletList = null;
  public GetUsrKeyWordInfoReq stKeyWord = null;
  public LoginInfo stLogin = null;
  public long uAppidMask = 0L;
  
  static
  {
    cache_stHamletList = new ArrayList();
    Hamlet localHamlet = new Hamlet();
    cache_stHamletList.add(localHamlet);
  }
  
  public UniLoginCheckReq() {}
  
  public UniLoginCheckReq(LoginInfo paramLoginInfo, ArrayList<Hamlet> paramArrayList, long paramLong, GetUsrKeyWordInfoReq paramGetUsrKeyWordInfoReq)
  {
    this.stLogin = paramLoginInfo;
    this.stHamletList = paramArrayList;
    this.uAppidMask = paramLong;
    this.stKeyWord = paramGetUsrKeyWordInfoReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.stHamletList = ((ArrayList)paramJceInputStream.read(cache_stHamletList, 1, false));
    this.uAppidMask = paramJceInputStream.read(this.uAppidMask, 2, false);
    this.stKeyWord = ((GetUsrKeyWordInfoReq)paramJceInputStream.read(cache_stKeyWord, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.stHamletList != null) {
      paramJceOutputStream.write(this.stHamletList, 1);
    }
    paramJceOutputStream.write(this.uAppidMask, 2);
    if (this.stKeyWord != null) {
      paramJceOutputStream.write(this.stKeyWord, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniLoginCheckReq
 * JD-Core Version:    0.7.0.1
 */