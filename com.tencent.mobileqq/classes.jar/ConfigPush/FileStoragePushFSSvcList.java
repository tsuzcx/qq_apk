package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileStoragePushFSSvcList
  extends JceStruct
{
  static BigDataChannel cache_bigDataChannel;
  static DomainIpChannel cache_domainIpChannel;
  static FmtIPInfo cache_fmtIPInfo;
  static byte[] cache_pttlist;
  static ArrayList<FileStorageServerListInfo> cache_vC2CPicDownList;
  static ArrayList<FileStorageServerListInfo> cache_vGPicDownLoadList;
  static ArrayList<FileStorageServerListInfo> cache_vPicDownLoadList;
  static ArrayList<FileStorageServerListInfo> cache_vQzoneProxyServiceList;
  static ArrayList<FileStorageServerListInfo> cache_vUpLoadList;
  static ArrayList<FileStorageServerListInfo> cache_vUrlEncodeServiceList;
  static ArrayList<FileStorageServerListInfo> cache_vVipEmotionList;
  public BigDataChannel bigDataChannel = null;
  public DomainIpChannel domainIpChannel = null;
  public FmtIPInfo fmtIPInfo = null;
  public byte[] pttlist = null;
  public ArrayList<FileStorageServerListInfo> vC2CPicDownList = null;
  public ArrayList<FileStorageServerListInfo> vGPicDownLoadList = null;
  public ArrayList<FileStorageServerListInfo> vPicDownLoadList = null;
  public ArrayList<FileStorageServerListInfo> vQzoneProxyServiceList = null;
  public ArrayList<FileStorageServerListInfo> vUpLoadList = null;
  public ArrayList<FileStorageServerListInfo> vUrlEncodeServiceList = null;
  public ArrayList<FileStorageServerListInfo> vVipEmotionList = null;
  
  public FileStoragePushFSSvcList() {}
  
  public FileStoragePushFSSvcList(ArrayList<FileStorageServerListInfo> paramArrayList1, ArrayList<FileStorageServerListInfo> paramArrayList2, ArrayList<FileStorageServerListInfo> paramArrayList3, ArrayList<FileStorageServerListInfo> paramArrayList4, ArrayList<FileStorageServerListInfo> paramArrayList5, BigDataChannel paramBigDataChannel, ArrayList<FileStorageServerListInfo> paramArrayList6, ArrayList<FileStorageServerListInfo> paramArrayList7, FmtIPInfo paramFmtIPInfo, DomainIpChannel paramDomainIpChannel, byte[] paramArrayOfByte)
  {
    this.vUpLoadList = paramArrayList1;
    this.vPicDownLoadList = paramArrayList2;
    this.vGPicDownLoadList = paramArrayList3;
    this.vQzoneProxyServiceList = paramArrayList4;
    this.vUrlEncodeServiceList = paramArrayList5;
    this.bigDataChannel = paramBigDataChannel;
    this.vVipEmotionList = paramArrayList6;
    this.vC2CPicDownList = paramArrayList7;
    this.fmtIPInfo = paramFmtIPInfo;
    this.domainIpChannel = paramDomainIpChannel;
    this.pttlist = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    FileStorageServerListInfo localFileStorageServerListInfo;
    if (cache_vUpLoadList == null)
    {
      cache_vUpLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vUpLoadList.add(localFileStorageServerListInfo);
    }
    this.vUpLoadList = ((ArrayList)paramJceInputStream.read(cache_vUpLoadList, 0, true));
    if (cache_vPicDownLoadList == null)
    {
      cache_vPicDownLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vPicDownLoadList.add(localFileStorageServerListInfo);
    }
    this.vPicDownLoadList = ((ArrayList)paramJceInputStream.read(cache_vPicDownLoadList, 1, true));
    if (cache_vGPicDownLoadList == null)
    {
      cache_vGPicDownLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vGPicDownLoadList.add(localFileStorageServerListInfo);
    }
    this.vGPicDownLoadList = ((ArrayList)paramJceInputStream.read(cache_vGPicDownLoadList, 2, false));
    if (cache_vQzoneProxyServiceList == null)
    {
      cache_vQzoneProxyServiceList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vQzoneProxyServiceList.add(localFileStorageServerListInfo);
    }
    this.vQzoneProxyServiceList = ((ArrayList)paramJceInputStream.read(cache_vQzoneProxyServiceList, 3, false));
    if (cache_vUrlEncodeServiceList == null)
    {
      cache_vUrlEncodeServiceList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vUrlEncodeServiceList.add(localFileStorageServerListInfo);
    }
    this.vUrlEncodeServiceList = ((ArrayList)paramJceInputStream.read(cache_vUrlEncodeServiceList, 4, false));
    if (cache_bigDataChannel == null) {
      cache_bigDataChannel = new BigDataChannel();
    }
    this.bigDataChannel = ((BigDataChannel)paramJceInputStream.read(cache_bigDataChannel, 5, false));
    if (cache_vVipEmotionList == null)
    {
      cache_vVipEmotionList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vVipEmotionList.add(localFileStorageServerListInfo);
    }
    this.vVipEmotionList = ((ArrayList)paramJceInputStream.read(cache_vVipEmotionList, 6, false));
    if (cache_vC2CPicDownList == null)
    {
      cache_vC2CPicDownList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vC2CPicDownList.add(localFileStorageServerListInfo);
    }
    this.vC2CPicDownList = ((ArrayList)paramJceInputStream.read(cache_vC2CPicDownList, 7, false));
    if (cache_fmtIPInfo == null) {
      cache_fmtIPInfo = new FmtIPInfo();
    }
    this.fmtIPInfo = ((FmtIPInfo)paramJceInputStream.read(cache_fmtIPInfo, 8, false));
    if (cache_domainIpChannel == null) {
      cache_domainIpChannel = new DomainIpChannel();
    }
    this.domainIpChannel = ((DomainIpChannel)paramJceInputStream.read(cache_domainIpChannel, 9, false));
    if (cache_pttlist == null)
    {
      cache_pttlist = (byte[])new byte[1];
      ((byte[])cache_pttlist)[0] = 0;
    }
    this.pttlist = ((byte[])paramJceInputStream.read(cache_pttlist, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUpLoadList, 0);
    paramJceOutputStream.write(this.vPicDownLoadList, 1);
    if (this.vGPicDownLoadList != null) {
      paramJceOutputStream.write(this.vGPicDownLoadList, 2);
    }
    if (this.vQzoneProxyServiceList != null) {
      paramJceOutputStream.write(this.vQzoneProxyServiceList, 3);
    }
    if (this.vUrlEncodeServiceList != null) {
      paramJceOutputStream.write(this.vUrlEncodeServiceList, 4);
    }
    if (this.bigDataChannel != null) {
      paramJceOutputStream.write(this.bigDataChannel, 5);
    }
    if (this.vVipEmotionList != null) {
      paramJceOutputStream.write(this.vVipEmotionList, 6);
    }
    if (this.vC2CPicDownList != null) {
      paramJceOutputStream.write(this.vC2CPicDownList, 7);
    }
    if (this.fmtIPInfo != null) {
      paramJceOutputStream.write(this.fmtIPInfo, 8);
    }
    if (this.domainIpChannel != null) {
      paramJceOutputStream.write(this.domainIpChannel, 9);
    }
    if (this.pttlist != null) {
      paramJceOutputStream.write(this.pttlist, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.FileStoragePushFSSvcList
 * JD-Core Version:    0.7.0.1
 */