package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniSetRsp
  extends JceStruct
{
  static ExtraActAidInfo cache_extraAid = new ExtraActAidInfo();
  static UiExtraAppInfo cache_extraappinfo = new UiExtraAppInfo();
  static UiExtraGameInfo cache_extragameinfo = new UiExtraGameInfo();
  static HamletCheck cache_stHamletItem = new HamletCheck();
  static ArrayList<Hamlet> cache_stHamletItemList = new ArrayList();
  public String errmsg = "";
  public ExtraActAidInfo extraAid;
  public UiExtraAppInfo extraappinfo;
  public UiExtraGameInfo extragameinfo;
  public int feetype;
  public int ret;
  public HamletCheck stHamletItem;
  public ArrayList<Hamlet> stHamletItemList;
  public String url = "";
  public int validDay;
  
  static
  {
    Hamlet localHamlet = new Hamlet();
    cache_stHamletItemList.add(localHamlet);
  }
  
  public UniSetRsp() {}
  
  public UniSetRsp(int paramInt1, String paramString1, HamletCheck paramHamletCheck, String paramString2, ArrayList<Hamlet> paramArrayList, int paramInt2, int paramInt3, ExtraActAidInfo paramExtraActAidInfo, UiExtraAppInfo paramUiExtraAppInfo, UiExtraGameInfo paramUiExtraGameInfo)
  {
    this.ret = paramInt1;
    this.errmsg = paramString1;
    this.stHamletItem = paramHamletCheck;
    this.url = paramString2;
    this.stHamletItemList = paramArrayList;
    this.feetype = paramInt2;
    this.validDay = paramInt3;
    this.extraAid = paramExtraActAidInfo;
    this.extraappinfo = paramUiExtraAppInfo;
    this.extragameinfo = paramUiExtraGameInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stHamletItem = ((HamletCheck)paramJceInputStream.read(cache_stHamletItem, 2, false));
    this.url = paramJceInputStream.readString(3, false);
    this.stHamletItemList = ((ArrayList)paramJceInputStream.read(cache_stHamletItemList, 4, false));
    this.feetype = paramJceInputStream.read(this.feetype, 5, false);
    this.validDay = paramJceInputStream.read(this.validDay, 6, false);
    this.extraAid = ((ExtraActAidInfo)paramJceInputStream.read(cache_extraAid, 7, false));
    this.extraappinfo = ((UiExtraAppInfo)paramJceInputStream.read(cache_extraappinfo, 8, false));
    this.extragameinfo = ((UiExtraGameInfo)paramJceInputStream.read(cache_extragameinfo, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.stHamletItem != null) {
      paramJceOutputStream.write(this.stHamletItem, 2);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
    if (this.stHamletItemList != null) {
      paramJceOutputStream.write(this.stHamletItemList, 4);
    }
    paramJceOutputStream.write(this.feetype, 5);
    paramJceOutputStream.write(this.validDay, 6);
    if (this.extraAid != null) {
      paramJceOutputStream.write(this.extraAid, 7);
    }
    if (this.extraappinfo != null) {
      paramJceOutputStream.write(this.extraappinfo, 8);
    }
    if (this.extragameinfo != null) {
      paramJceOutputStream.write(this.extragameinfo, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniSetRsp
 * JD-Core Version:    0.7.0.1
 */