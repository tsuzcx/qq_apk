package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RespGetRecommender
  extends JceStruct
{
  static int cache_eReasonType;
  static ArrayList<RespEncounterInfo> cache_vEncounterInfos;
  public int eReasonType = 0;
  public int iExpiretime = 172800;
  public int iInnerInterval = 180;
  public int iOuterInterval = 86400;
  public String strBrief = "";
  public String strTitle = "";
  public long uRecommendTime = 0L;
  public ArrayList<RespEncounterInfo> vEncounterInfos = null;
  
  public RespGetRecommender() {}
  
  public RespGetRecommender(int paramInt1, int paramInt2, int paramInt3, ArrayList<RespEncounterInfo> paramArrayList, int paramInt4, String paramString1, String paramString2, long paramLong)
  {
    this.iOuterInterval = paramInt1;
    this.iInnerInterval = paramInt2;
    this.iExpiretime = paramInt3;
    this.vEncounterInfos = paramArrayList;
    this.eReasonType = paramInt4;
    this.strBrief = paramString1;
    this.strTitle = paramString2;
    this.uRecommendTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOuterInterval = paramJceInputStream.read(this.iOuterInterval, 0, false);
    this.iInnerInterval = paramJceInputStream.read(this.iInnerInterval, 1, false);
    this.iExpiretime = paramJceInputStream.read(this.iExpiretime, 2, false);
    if (cache_vEncounterInfos == null)
    {
      cache_vEncounterInfos = new ArrayList();
      RespEncounterInfo localRespEncounterInfo = new RespEncounterInfo();
      cache_vEncounterInfos.add(localRespEncounterInfo);
    }
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 3, false));
    this.eReasonType = paramJceInputStream.read(this.eReasonType, 4, false);
    this.strBrief = paramJceInputStream.readString(5, false);
    this.strTitle = paramJceInputStream.readString(6, false);
    this.uRecommendTime = paramJceInputStream.read(this.uRecommendTime, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOuterInterval, 0);
    paramJceOutputStream.write(this.iInnerInterval, 1);
    paramJceOutputStream.write(this.iExpiretime, 2);
    Object localObject = this.vEncounterInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.eReasonType, 4);
    localObject = this.strBrief;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.uRecommendTime, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     EncounterSvc.RespGetRecommender
 * JD-Core Version:    0.7.0.1
 */