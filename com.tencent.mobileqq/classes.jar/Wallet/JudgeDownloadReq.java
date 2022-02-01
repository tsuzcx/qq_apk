package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class JudgeDownloadReq
  extends JceStruct
{
  static ArrayList<ResInfo> cache_vecResInfo = new ArrayList();
  public float fMaxCPUFreq = 0.0F;
  public float fMinCPUFreq = 0.0F;
  public int iActId = 1001;
  public int iCores = 0;
  public long iMemory = 0L;
  public int iPlatForm = 1;
  public int iRetryTimes = 0;
  public int iType = 1;
  public long iUin = 0L;
  public String sPhoneType = "";
  public String sQQVersion = "";
  public ArrayList<ResInfo> vecResInfo = null;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecResInfo.add(localResInfo);
  }
  
  public static JudgeDownloadReq createReq(ArrayList<ResInfo> paramArrayList, long paramLong1, int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2)
  {
    JudgeDownloadReq localJudgeDownloadReq = new JudgeDownloadReq();
    localJudgeDownloadReq.iUin = paramLong1;
    localJudgeDownloadReq.vecResInfo = paramArrayList;
    localJudgeDownloadReq.sPhoneType = paramString1;
    localJudgeDownloadReq.sQQVersion = paramString2;
    localJudgeDownloadReq.fMinCPUFreq = paramFloat1;
    localJudgeDownloadReq.fMaxCPUFreq = paramFloat2;
    localJudgeDownloadReq.iCores = paramInt2;
    localJudgeDownloadReq.iMemory = paramLong2;
    localJudgeDownloadReq.iRetryTimes = paramInt1;
    return localJudgeDownloadReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iActId = paramJceInputStream.read(this.iActId, 0, false);
    this.iUin = paramJceInputStream.read(this.iUin, 1, false);
    this.vecResInfo = ((ArrayList)paramJceInputStream.read(cache_vecResInfo, 2, false));
    this.sQQVersion = paramJceInputStream.readString(3, false);
    this.iType = paramJceInputStream.read(this.iType, 4, false);
    this.sPhoneType = paramJceInputStream.readString(5, false);
    this.fMinCPUFreq = paramJceInputStream.read(this.fMinCPUFreq, 6, false);
    this.fMaxCPUFreq = paramJceInputStream.read(this.fMaxCPUFreq, 7, false);
    this.iCores = paramJceInputStream.read(this.iCores, 8, false);
    this.iMemory = paramJceInputStream.read(this.iMemory, 9, false);
    this.iPlatForm = paramJceInputStream.read(this.iPlatForm, 10, false);
    this.iRetryTimes = paramJceInputStream.read(this.iRetryTimes, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iUin, 1);
    Object localObject = this.vecResInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.sQQVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.iType, 4);
    localObject = this.sPhoneType;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.fMinCPUFreq, 6);
    paramJceOutputStream.write(this.fMaxCPUFreq, 7);
    paramJceOutputStream.write(this.iCores, 8);
    paramJceOutputStream.write(this.iMemory, 9);
    paramJceOutputStream.write(this.iPlatForm, 10);
    paramJceOutputStream.write(this.iRetryTimes, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.JudgeDownloadReq
 * JD-Core Version:    0.7.0.1
 */