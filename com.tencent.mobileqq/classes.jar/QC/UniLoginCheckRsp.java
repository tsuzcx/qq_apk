package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UniLoginCheckRsp
  extends JceStruct
{
  static ArrayList<HamletCheck> cache_stHamletList = new ArrayList();
  static GetUsrKeyWordInfoRsp cache_stKeyWord = new GetUsrKeyWordInfoRsp();
  public String errmsg = "";
  public int ret = 0;
  public ArrayList<HamletCheck> stHamletList = null;
  public GetUsrKeyWordInfoRsp stKeyWord = null;
  
  static
  {
    HamletCheck localHamletCheck = new HamletCheck();
    cache_stHamletList.add(localHamletCheck);
  }
  
  public UniLoginCheckRsp() {}
  
  public UniLoginCheckRsp(int paramInt, String paramString, ArrayList<HamletCheck> paramArrayList, GetUsrKeyWordInfoRsp paramGetUsrKeyWordInfoRsp)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.stHamletList = paramArrayList;
    this.stKeyWord = paramGetUsrKeyWordInfoRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stHamletList = ((ArrayList)paramJceInputStream.read(cache_stHamletList, 2, false));
    this.stKeyWord = ((GetUsrKeyWordInfoRsp)paramJceInputStream.read(cache_stKeyWord, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.stHamletList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stKeyWord;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniLoginCheckRsp
 * JD-Core Version:    0.7.0.1
 */