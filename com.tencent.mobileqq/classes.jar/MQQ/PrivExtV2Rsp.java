package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PrivExtV2Rsp
  extends JceStruct
{
  static DataReturnFlag cache_data_flag;
  static ItemCfgList cache_itemCfgList;
  static Map<Integer, MenumItem> cache_map_menum;
  static VipMedalList cache_medalInfoList;
  static PayRuleCfg cache_payRule;
  static QidInfoItem cache_qid_info = new QidInfoItem();
  static QqLiveMsg cache_qqLiveMsg;
  static QQValueInfoItem cache_qq_value = new QQValueInfoItem();
  static TrafficResultInfo cache_trafficResult;
  static VipUserInfo cache_vipInfo = new VipUserInfo();
  public DataReturnFlag data_flag = null;
  public int iSyncFreq = -1;
  public int isAuditVersion = 0;
  public int isQQLivePgc = 0;
  public ItemCfgList itemCfgList = null;
  public Map<Integer, MenumItem> map_menum = null;
  public VipMedalList medalInfoList = null;
  public PayRuleCfg payRule = null;
  public QidInfoItem qid_info = null;
  public QqLiveMsg qqLiveMsg = null;
  public QQValueInfoItem qq_value = null;
  public TrafficResultInfo trafficResult = null;
  public VipUserInfo vipInfo = null;
  
  static
  {
    cache_trafficResult = new TrafficResultInfo();
    cache_medalInfoList = new VipMedalList();
    cache_itemCfgList = new ItemCfgList();
    cache_payRule = new PayRuleCfg();
    cache_qqLiveMsg = new QqLiveMsg();
    cache_data_flag = new DataReturnFlag();
    cache_map_menum = new HashMap();
    MenumItem localMenumItem = new MenumItem();
    cache_map_menum.put(Integer.valueOf(0), localMenumItem);
  }
  
  public PrivExtV2Rsp() {}
  
  public PrivExtV2Rsp(VipUserInfo paramVipUserInfo, TrafficResultInfo paramTrafficResultInfo, int paramInt1, VipMedalList paramVipMedalList, ItemCfgList paramItemCfgList, PayRuleCfg paramPayRuleCfg, int paramInt2, QqLiveMsg paramQqLiveMsg, int paramInt3, DataReturnFlag paramDataReturnFlag, Map<Integer, MenumItem> paramMap, QidInfoItem paramQidInfoItem, QQValueInfoItem paramQQValueInfoItem)
  {
    this.vipInfo = paramVipUserInfo;
    this.trafficResult = paramTrafficResultInfo;
    this.iSyncFreq = paramInt1;
    this.medalInfoList = paramVipMedalList;
    this.itemCfgList = paramItemCfgList;
    this.payRule = paramPayRuleCfg;
    this.isQQLivePgc = paramInt2;
    this.qqLiveMsg = paramQqLiveMsg;
    this.isAuditVersion = paramInt3;
    this.data_flag = paramDataReturnFlag;
    this.map_menum = paramMap;
    this.qid_info = paramQidInfoItem;
    this.qq_value = paramQQValueInfoItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vipInfo = ((VipUserInfo)paramJceInputStream.read(cache_vipInfo, 0, true));
    this.trafficResult = ((TrafficResultInfo)paramJceInputStream.read(cache_trafficResult, 1, false));
    this.iSyncFreq = paramJceInputStream.read(this.iSyncFreq, 2, false);
    this.medalInfoList = ((VipMedalList)paramJceInputStream.read(cache_medalInfoList, 3, false));
    this.itemCfgList = ((ItemCfgList)paramJceInputStream.read(cache_itemCfgList, 4, false));
    this.payRule = ((PayRuleCfg)paramJceInputStream.read(cache_payRule, 5, false));
    this.isQQLivePgc = paramJceInputStream.read(this.isQQLivePgc, 6, false);
    this.qqLiveMsg = ((QqLiveMsg)paramJceInputStream.read(cache_qqLiveMsg, 7, false));
    this.isAuditVersion = paramJceInputStream.read(this.isAuditVersion, 8, false);
    this.data_flag = ((DataReturnFlag)paramJceInputStream.read(cache_data_flag, 9, false));
    this.map_menum = ((Map)paramJceInputStream.read(cache_map_menum, 10, false));
    this.qid_info = ((QidInfoItem)paramJceInputStream.read(cache_qid_info, 11, false));
    this.qq_value = ((QQValueInfoItem)paramJceInputStream.read(cache_qq_value, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vipInfo, 0);
    Object localObject = this.trafficResult;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.iSyncFreq, 2);
    localObject = this.medalInfoList;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.itemCfgList;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.payRule;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.isQQLivePgc, 6);
    localObject = this.qqLiveMsg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    paramJceOutputStream.write(this.isAuditVersion, 8);
    localObject = this.data_flag;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.map_menum;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.qid_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.qq_value;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.PrivExtV2Rsp
 * JD-Core Version:    0.7.0.1
 */