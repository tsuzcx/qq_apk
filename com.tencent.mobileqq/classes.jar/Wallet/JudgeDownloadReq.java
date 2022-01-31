package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;

public final class JudgeDownloadReq
  extends JceStruct
{
  static ArrayList cache_vecResInfo = new ArrayList();
  public float fMaxCPUFreq;
  public float fMinCPUFreq;
  public int iActId = 1001;
  public int iCores;
  public long iMemory;
  public int iPlatForm = 1;
  public int iRetryTimes;
  public int iType = 1;
  public long iUin;
  public String sPhoneType = "";
  public String sQQVersion = "";
  public ArrayList vecResInfo;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecResInfo.add(localResInfo);
  }
  
  public static JudgeDownloadReq createReq(ArrayList paramArrayList, long paramLong, int paramInt)
  {
    JudgeDownloadReq localJudgeDownloadReq = new JudgeDownloadReq();
    localJudgeDownloadReq.iUin = paramLong;
    localJudgeDownloadReq.vecResInfo = paramArrayList;
    localJudgeDownloadReq.sPhoneType = DeviceInfoUtil.j();
    localJudgeDownloadReq.sQQVersion = DeviceInfoUtil.d();
    localJudgeDownloadReq.fMinCPUFreq = ((float)DeviceInfoUtil.a());
    localJudgeDownloadReq.fMinCPUFreq = ((float)DeviceInfoUtil.b());
    localJudgeDownloadReq.iCores = DeviceInfoUtil.b();
    localJudgeDownloadReq.iMemory = (DeviceInfoUtil.e() / 1024L);
    localJudgeDownloadReq.iRetryTimes = paramInt;
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
    if (this.vecResInfo != null) {
      paramJceOutputStream.write(this.vecResInfo, 2);
    }
    if (this.sQQVersion != null) {
      paramJceOutputStream.write(this.sQQVersion, 3);
    }
    paramJceOutputStream.write(this.iType, 4);
    if (this.sPhoneType != null) {
      paramJceOutputStream.write(this.sPhoneType, 5);
    }
    paramJceOutputStream.write(this.fMinCPUFreq, 6);
    paramJceOutputStream.write(this.fMaxCPUFreq, 7);
    paramJceOutputStream.write(this.iCores, 8);
    paramJceOutputStream.write(this.iMemory, 9);
    paramJceOutputStream.write(this.iPlatForm, 10);
    paramJceOutputStream.write(this.iRetryTimes, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.JudgeDownloadReq
 * JD-Core Version:    0.7.0.1
 */