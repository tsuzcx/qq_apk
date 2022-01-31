package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RecommEncounterInfo
  extends JceStruct
{
  static ArrayList<RespEncounterInfo> cache_vEncounterInfos = new ArrayList();
  public String icon_url = "";
  public int postion;
  public int show_num;
  public String title = "";
  public ArrayList<RespEncounterInfo> vEncounterInfos;
  
  static
  {
    RespEncounterInfo localRespEncounterInfo = new RespEncounterInfo();
    cache_vEncounterInfos.add(localRespEncounterInfo);
  }
  
  public RecommEncounterInfo() {}
  
  public RecommEncounterInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<RespEncounterInfo> paramArrayList)
  {
    this.icon_url = paramString1;
    this.title = paramString2;
    this.postion = paramInt1;
    this.show_num = paramInt2;
    this.vEncounterInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.icon_url = paramJceInputStream.readString(0, true);
    this.title = paramJceInputStream.readString(1, true);
    this.postion = paramJceInputStream.read(this.postion, 2, true);
    this.show_num = paramJceInputStream.read(this.show_num, 3, true);
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.icon_url, 0);
    paramJceOutputStream.write(this.title, 1);
    paramJceOutputStream.write(this.postion, 2);
    paramJceOutputStream.write(this.show_num, 3);
    if (this.vEncounterInfos != null) {
      paramJceOutputStream.write(this.vEncounterInfos, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.RecommEncounterInfo
 * JD-Core Version:    0.7.0.1
 */