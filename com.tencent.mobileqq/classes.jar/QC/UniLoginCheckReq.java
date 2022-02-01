package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.stLogin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stHamletList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.uAppidMask, 2);
    localObject = this.stKeyWord;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniLoginCheckReq
 * JD-Core Version:    0.7.0.1
 */