package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends j
{
  private int bUV = 0;
  public String cdl;
  public String cdm;
  public String cdn;
  public String cdo;
  public String cdp;
  public Orders nEh = null;
  private String qmm = null;
  public int qmn = 0;
  public com.tencent.mm.plugin.wallet.pay.a.c qmo = null;
  private int scene = 0;
  
  public e(PayInfo paramPayInfo, int paramInt)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramPayInfo == null)
    {
      y.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[] { bk.csb().toString() });
      this.qmm = "";
      this.scene = paramInt;
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap1.put("support_cardtag3", "1");
      localHashMap1.put("req_key", this.qmm);
      localHashMap1.put("bind_query_scene", String.valueOf(paramInt));
      localHashMap1.put("is_merge", "1");
      Object localObject = (k)g.r(k.class);
      localHashMap1.put("is_root", "0");
      if ((localObject == null) || ((!((k)localObject).aSG()) && (!((k)localObject).aST()))) {
        break label263;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((k)localObject).aSO();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      y.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.bUV = paramPayInfo.bUV;
      }
      a(paramPayInfo, localHashMap1, localHashMap2);
      D(localHashMap1);
      aC(localHashMap2);
      return;
      this.qmm = paramPayInfo.bMX;
      break;
      label263:
      localHashMap1.put("is_device_open_touch", "0");
      y.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
    }
  }
  
  public int HH()
  {
    return 1593;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        new JSONObject("{\n    \"Array\": [\n        {\n            \"Array\": [],\n            \"buy_bank_name\": \"\",\n            \"buy_bank_type\": \"\",\n            \"cre_time\": \"1500272996\",\n            \"desc\": \"中文[body]\",\n            \"fee\": \"101\",\n            \"pay_status\": \"1\",\n            \"pay_status_name\": \"\",\n            \"pay_time\": \"1500273027\",\n            \"sp_name\": \"新资金流测试商户05\",\n            \"spid\": \"2302880801\",\n            \"sub_spid\": \"\",\n            \"support_bank\": \"BOC_CREDIT|CMB_CREDIT|PAB_CREDIT|CEB_DEBIT|CEB_CREDIT|CCB_CREDIT|CCB_DEBIT|NBCB_CREDIT|CMB_DEBIT|CIB_CREDIT|ABC_DEBIT|GDB_DEBIT|GDB_CREDIT|CITIC_CREDIT|CITIC_DEBIT|CIB_DEBIT|PAB_DEBIT|CMBC_CREDIT|CMBC_DEBIT|BOSH_CREDIT|BOSH_DEBIT|SPDB_DEBIT|SPDB_CREDIT|PSBC_DEBIT|ICBC_DEBIT|BOC_DEBIT|HXB_DEBIT|CRB_DEBIT|HZB_DEBIT|CBHB_DEBIT|BSB_DEBIT|CQB_DEBIT|SDEB_DEBIT|QLB_DEBIT|HSBC_DEBIT|HDCB_DEBIT|NYCCB_DEBIT|JJCCB_DEBIT|KUERLECB_DEBIT|SZRCB_DEBIT|HRBB_DEBIT|BOCD_DEBIT|GDNYB_DEBIT|HXB_CREDIT|HZB_CREDIT|BSB_CREDIT|GDNYB_CREDIT|GZCB_CREDIT|SNCCB_DEBIT|FUXINB_CREDIT|BOQHB_CREDIT|ASCB_DEBIT|WUHAICB_DEBIT|HLJRCUB_DEBIT|JSNX_CREDIT|HKBEA_CREDIT|COMM_DEBIT|JSB_DEBIT|JSB_CREDIT|NBCB_DEBIT|NJCB_DEBIT|ZJTLCB_DEBIT|LJB_DEBIT|QDCCB_DEBIT|CSRCB_DEBIT|XAB_DEBIT|SRCB_CREDIT|BOD_CREDIT|BOD_DEBIT|JZB_DEBIT|ORDOSB_DEBIT|ORDOSB_CREDIT|GYCB_DEBIT|LZB_DEBIT|SRCB_DEBIT|FJNX_DEBIT|XJRCCB_DEBIT|PZHCCB_DEBIT|JLB_DEBIT|SDRCU_DEBIT|DYCCB_DEBIT|BNC_DEBIT|BOB_DEBIT|PSBC_CREDIT|WZB_DEBIT|GRCB_DEBIT|CZB_DEBIT|HBNX_DEBIT|HBNX_CREDIT|GDHX_DEBIT|GRCB_CREDIT|JSHB_DEBIT|HKBEA_DEBIT|JXNXB_DEBIT|GYCB_CREDIT|WHRC_DEBIT|JSNX_DEBIT|SXXH_DEBIT|HNNX_DEBIT|HEBNX_DEBIT|GSNX_DEBIT|CSCB_DEBIT|HSB_DEBIT|GLB_DEBIT|HRXJB_DEBIT|WEB_DEBIT|BOIMCB_DEBIT|ZYB_DEBIT|CZB_CREDIT|SJB_DEBIT|YNRCCB_DEBIT|GZCB_DEBIT|NCB_DEBIT|DRCB_DEBIT|GDRCU_DEBIT|CQRCB_DEBIT|WFB_DEBIT|JRCB_DEBIT|CZCB_DEBIT|ZJRCUB_DEBIT|BJRCB_DEBIT|NMGNX_DEBIT|TJBHB_DEBIT|LNNX_DEBIT|SCNX_DEBIT|JLNX_DEBIT|KRCB_DEBIT|WRCB_DEBIT|JNRCB_DEBIT|HUNNX_DEBIT|DLB_DEBIT|CCAB_DEBIT|JZCB_DEBIT|FDB_DEBIT|DRCB_CREDIT|JZCB_CREDIT|TJB_DEBIT|CQRCB_CREDIT|JCB_DEBIT|HBCB_DEBIT|FBB_DEBIT|BYK_DEBIT|TZB_DEBIT|HBCB_CREDIT|ZRCB_DEBIT|TCRCB_DEBIT|WJRCB_DEBIT|CDRCB_DEBIT|GXNX_DEBIT|TRCB_DEBIT|GZNX_DEBIT|SXNX_DEBIT|HAINNX_DEBIT|HAINNX_CREDIT|WHRC_CREDIT|BJRCB_CREDIT|CZCB_CREDIT|BOLB_DEBIT|LUZB_DEBIT|LYYHB_DEBIT|HFB_DEBIT|CQTGB_DEBIT|XIB_DEBIT|BHB_DEBIT|YRRCB_DEBIT|URB_DEBIT|SUZB_DEBIT|QHNX_DEBIT|HUSRB_DEBIT|YRRCB_CREDIT|ZJRCUB_CREDIT|BOB_CREDIT|BOTSB_DEBIT|BGZB_DEBIT|LWB_DEBIT|BOLFB_DEBIT|SRB_DEBIT|KLB_DEBIT|HKB_DEBIT|WHB_DEBIT|QSB_DEBIT|YTB_DEBIT|RZB_DEBIT|BOJX_DEBIT|GSB_DEBIT|ZZB_DEBIT|XMCCB_DEBIT|FJHXB_DEBIT|BEEB_DEBIT|BOHN_DEBIT|FJHXB_CREDIT|ZZB_CREDIT|BEEB_CREDIT|JUFENGB_DEBIT|ZJLXRB_DEBIT|BONX_DEBIT|WLMQB_DEBIT|BOCDB_DEBIT|FUXINB_DEBIT|ZJB_DEBIT|MINTAIB_DEBIT|DANDONGB_DEBIT|TACCB_DEBIT|WZB_CREDIT|COMM_CREDIT|CSRCB_CREDIT|XAB_CREDIT|BNC_CREDIT|HSB_CREDIT|WFB_CREDIT|CCAB_CREDIT|WHB_CREDIT|NJCB_CREDIT|SZRCB_CREDIT|TJBHB_CREDIT|BOZ_DEBIT|BOSZS_DEBIT|BCZ_DEBIT|DYB_DEBIT|SHINHAN_DEBIT|QDCCB_CREDIT|BONX_CREDIT|DANDONGB_CREDIT|MINTAIB_CREDIT|TACCB_CREDIT|DYB_CREDIT|BCZ_CREDIT|AHRCUB_DEBIT|AHRCUB_CREDIT|DSB_DEBIT|BOSXB_DEBIT|DLB_CREDIT|LSCCB_DEBIT|HANAB_DEBIT|UOB_DEBIT|QZCCB_DEBIT|NCCB_DEBIT|LSB_DEBIT|WB_DEBIT|BOPDS_DEBIT|BOQHB_DEBIT|BOBBG_DEBIT|BOBBG_CREDIT|LZB_CREDIT|LSB_CREDIT|FDB_CREDIT|QZCCB_CREDIT|CJCCB_DEBIT|YKCB_DEBIT|BOFS_DEBIT|BDB_DEBIT|LZCCB_DEBIT|QHDB_DEBIT|XTB_DEBIT|HZCCB_DEBIT|BOJN_DEBIT|GZCCB_DEBIT|BOCTS_DEBIT|BOIMCB_CREDIT|HFB_CREDIT|ZRCB_CREDIT|WRCB_CREDIT|TZB_CREDIT|JCBK_CREDIT|SUZB_CREDIT|SHRB_DEBIT|CFT|LQT|\",\n            \"transaction_id\": \"\"\n        }\n    ],\n    \"after_favor_amount\": 101,\n    \"bank_card_tag\": \"1\",\n    \"bindqueryresp\": {\n        \"Array\": [\n            {\n                \"IsSaveYfq\": \"0\",\n                \"arrive_type\": \"0\",\n                \"bank_card_tag\": \"1\",\n                \"bank_flag\": \"1\",\n                \"bank_logo_url\": \"http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/PayCardZGlogo@2x.png\",\n                \"bank_name\": \"中国银行\",\n                \"bank_phone\": \"95566\",\n                \"bank_type\": \"BOC_DEBIT\",\n                \"bankacc_type\": \"1\",\n                \"bankacc_type_name\": \"储蓄卡\",\n                \"bind_day_quota\": \"1000000\",\n                \"bind_icharacter4\": \"1\",\n                \"bind_once_quota\": \"1000000\",\n                \"bind_serial\": \"707177294500000000010001617051\",\n                \"bind_tail\": \"8770\",\n                \"day_quota_1\": \"1000000\",\n                \"day_quota_3\": \"1000000\",\n                \"draw_available\": \"\",\n                \"draw_status\": \"\",\n                \"draw_type\": \"\",\n                \"expired_flag\": \"0\",\n                \"export_end\": \"\",\n                \"export_start\": \"\",\n                \"extra_bind_flag\": \"NORMAL\",\n                \"fetch_pre_arrive_time\": \"1500307199\",\n                \"fetch_pre_arrive_time_wording\": \"当天24点前到账\",\n                \"maintain_endtime\": \"\",\n                \"maintain_starttime\": \"\",\n                \"mobile\": \"150******94\",\n                \"once_quota_1\": \"1000000\",\n                \"once_quota_3\": \"1000000\",\n                \"support_fetch\": \"1\",\n                \"support_micropay\": 1,\n                \"support_save\": \"1\"\n            },\n            {\n                \"IsSaveYfq\": \"0\",\n                \"arrive_type\": \"0\",\n                \"bank_card_tag\": \"1\",\n                \"bank_flag\": \"1\",\n                \"bank_logo_url\": \"http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/PayCardZSlogo@2x.png\",\n                \"bank_name\": \"招商银行\",\n                \"bank_phone\": \"95555\",\n                \"bank_type\": \"CMB_DEBIT\",\n                \"bankacc_type\": \"1\",\n                \"bankacc_type_name\": \"储蓄卡\",\n                \"bind_day_quota\": \"10000000\",\n                \"bind_icharacter4\": \"1\",\n                \"bind_once_quota\": \"10000000\",\n                \"bind_serial\": \"707176177500000000010001617051\",\n                \"bind_tail\": \"2414\",\n                \"day_quota_1\": \"10000000\",\n                \"day_quota_3\": \"10000000\",\n                \"draw_available\": \"\",\n                \"draw_status\": \"\",\n                \"draw_type\": \"\",\n                \"expired_flag\": \"0\",\n                \"export_end\": \"\",\n                \"export_start\": \"\",\n                \"extra_bind_flag\": \"NORMAL\",\n                \"fetch_pre_arrive_time\": \"1500280230\",\n                \"fetch_pre_arrive_time_wording\": \"2小时内到账\",\n                \"maintain_endtime\": \"\",\n                \"maintain_starttime\": \"\",\n                \"mobile\": \"150******94\",\n                \"once_quota_1\": \"10000000\",\n                \"once_quota_3\": \"10000000\",\n                \"support_fetch\": \"1\",\n                \"support_micropay\": 1,\n                \"support_save\": \"1\"\n            }\n        ],\n        \"balance_info\": {\n            \"avail_balance\": \"0\",\n            \"balance_bank_type\": \"CFT\",\n            \"balance_bind_serial\": \"CFT\",\n            \"balance_forbid_id\": \"12345683\",\n            \"balance_forbid_word\": \"零钱不足，剩余0.00元\",\n            \"balance_list_url\": \"https://wx.tenpay.com/cgi-bin/mmpayweb-bin/balanceuserrollbatch\",\n            \"balance_logo_url\": \"http://mmbiz.qpic.cn/mmbiz/icTdbqWNOwNRzNyksbtsXmsdA3SiaHL12lEibWHuSYKg5XbklDSj3ia9IjyRua6vcM6HQNkpjCDOYicOMAkkZ1t913A/0\",\n            \"balance_version\": 1490752891,\n            \"fetch_balance\": \"0\",\n            \"frozen_balance\": \"0\",\n            \"mobile\": \"150******94\",\n            \"support_micropay\": \"1\",\n            \"time_out\": 0,\n            \"total_balance\": \"0\",\n            \"use_cft_balance\": \"1\"\n        },\n        \"balance_notice\": [],\n        \"bind_query_scene\": \"2\",\n        \"fetch_notice\": [],\n        \"history_card_array\": [],\n        \"query_cache_time\": 0,\n        \"support_bank_word\": \"\",\n        \"switch_info\": {\n            \"switch_bit\": 73150\n        },\n        \"time_stamp\": 1500273030,\n        \"user_info\": {\n            \"authen_channel_state\": 0,\n            \"bind_card_num\": \"2\",\n            \"cre_name\": \"身份证\",\n            \"cre_type\": \"1\",\n            \"icard_user_flag\": \"2\",\n            \"is_reg\": \"1\",\n            \"last_card_bind_serialno\": \"\",\n            \"lct_url\": \"www.qq.com\",\n            \"lct_wording\": \"\",\n            \"touch_info\": {\n                \"is_open_touch\": \"0\",\n                \"use_touch_pay\": \"0\"\n            },\n            \"transfer_url\": \"https://wx.tenpay.com/f2f?t=AQAAAOrdwAB4HrmPXRZvsWFj5nQ%3D\",\n            \"true_name\": \"test\"\n        },\n        \"virtual_card_array\": []\n    },\n    \"favinfo\": {\n        \"afterFavorTradeAmount\": 101,\n        \"discountWording\": \"\",\n        \"favorComposeId\": \"0\",\n        \"favorComposeList\": {\n            \"favorComposeInfo\": [\n                {\n                    \"afterFavorTradeAmount\": 101,\n                    \"composeArray\": [],\n                    \"faovrComposeId\": \"0\",\n                    \"invariableFavorAmount\": 0,\n                    \"invariableFavorDesc\": \"优惠0元\",\n                    \"isVariableFavor\": 0,\n                    \"showFavorAmount\": 101,\n                    \"totalFavorAmount\": 0,\n                    \"tradeFavList\": [],\n                    \"variableFavorDesc\": \"\"\n                },\n                {\n                    \"afterFavorTradeAmount\": 0,\n                    \"composeArray\": [\n                        {\n                            \"favId\": \"602046852\",\n                            \"favorRemarks\": \"需使用招商银行储蓄卡支付\",\n                            \"favorUseManual\": \"满1.01元减1.00元\"\n                        }\n                    ],\n                    \"faovrComposeId\": \"602046852\",\n                    \"invariableFavorAmount\": 100,\n                    \"invariableFavorDesc\": \"指定招行立减优惠1元\",\n                    \"isVariableFavor\": 0,\n                    \"showFavorAmount\": 0,\n                    \"totalFavorAmount\": 100,\n                    \"tradeFavList\": [],\n                    \"variableFavorDesc\": \"\"\n                },\n                {\n                    \"afterFavorTradeAmount\": 1,\n                    \"composeArray\": [\n                        {\n                            \"favId\": \"602046853\",\n                            \"favorRemarks\": \"x需使用招商银行储蓄卡支付\",\n                            \"favorUseManual\": \"x满1.01元减1.00元\"\n                        }\n                    ],\n                    \"faovrComposeId\": \"602046853\",\n                    \"invariableFavorAmount\": 100,\n                    \"invariableFavorDesc\": \"x指定招行立减优惠1元\",\n                    \"isVariableFavor\": 0,\n                    \"showFavorAmount\": 1,\n                    \"totalFavorAmount\": 100,\n                    \"tradeFavList\": [],\n                    \"variableFavorDesc\": \"\"\n                }\n            ]\n        },\n        \"favorRuleWording\": \"\",\n        \"invariableFavorAmount\": 0,\n        \"invariableFavorDesc\": \"\",\n        \"isVariableFavor\": 0,\n        \"showFavorAmount\": 101,\n        \"totalFavAmount\": 0,\n        \"tradeAmount\": 101,\n        \"tradeFavList\": [\n            {\n                \"activity_id\": \"651239\",\n                \"bankLogoUrl\": \"http://mmbiz.qpic.cn/mmbiz/icTdbqWNOwNRzNyksbtsXmsdA3SiaHL12lwfqX0zZucvvKGGSp1U3bHMtA9XSk8phr1iaBPMZ3lDa9rkDiaB2oY6lQ/0\",\n                \"bankName\": \"招商银行储蓄卡\",\n                \"bankNo\": \"CMB_DEBIT\",\n                \"bind_serial_list\": [\n            \t\t \"707176177500000000010001617051\", \"707177294500000000010001617051\"\n                ],       \n                \"combineFavorDo\": [],\n                \"contribute_info\": [],\n                \"favDesc\": \"满1.01元减1.00元\",\n                \"favId\": \"602046852\",\n                \"favName\": \"指定招行立减\",\n                \"favPrice\": 100,\n                \"favProperty\": 137,\n                \"favSubType\": 5,\n                \"favType\": 1,\n                \"favorRemarks\": \"需使用招商银行储蓄卡支付\",\n                \"favorTypeDesc\": \"指定支付方式优惠\",\n                \"favorUseManual\": \"满1.01元减1.00元\",\n                \"goods_info\": [],\n                \"needBankPay\": 1,\n                \"realFavFee\": 100,\n                \"scope\": 1\n            }\n            ,\n                {\n                \"activity_id\": \"651241\",\n                \"bankLogoUrl\": \"http://mmbiz.qpic.cn/mmbiz/icTdbqWNOwNRzNyksbtsXmsdA3SiaHL12lwfqX0zZucvvKGGSp1U3bHMtA9XSk8phr1iaBPMZ3lDa9rkDiaB2oY6lQ/0\",\n                \"bankName\": \"x招商银行储蓄卡\",\n                \"bankNo\": \"CMB_DEBIT\",      \n                \"combineFavorDo\": [],\n                \"contribute_info\": [],\n                \"favDesc\": \"x满1.01元减1.00元\",\n                \"favId\": \"602046853\",\n                \"favName\": \"x指定招行立减\",\n                \"favPrice\": 100,\n                \"favProperty\": 137,\n                \"favSubType\": 5,\n                \"favType\": 1,\n                \"favorRemarks\": \"x需使用招商银行储蓄卡支付\",\n                \"favorTypeDesc\": \"x指定支付方式优惠\",\n                \"favorUseManual\": \"x满1.01元减1.00元\",\n                \"goods_info\": [],\n                \"needBankPay\": 1,\n                \"realFavFee\": 100,\n                \"scope\": 1\n            }\n        ],\n        \"useNaturalDefense\": 0,\n        \"variableFavorDesc\": \"\"\n    },\n    \"fee_type\": \"CNY\",\n    \"is_open_fee_protocal\": \"0\",\n    \"needbindcardtoshowfavinfo\": \"0\",\n    \"num\": 1,\n    \"query_order_info\": {\n        \"default_query_order_wording\": \"支付最后不明确默认报错\",\n        \"query_order_count\": 3,\n        \"query_order_time\": 4\n    },\n    \"query_order_time\": 10,\n    \"real_name_info\": {\n        \"guide_flag\": \"0\"\n    },\n    \"retcode\": \"0\",\n    \"retmsg\": \"OK\",\n    \"total_fee\": 101\n}");
        this.nEh = Orders.ak(paramJSONObject);
        if (this.nEh != null) {
          this.nEh.bMX = this.qmm;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          u.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            y.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            o.bVs().qzo = (paramString.optInt("query_order_time", 5) * 1000);
            o.bVs().mRetryCount = paramString.optInt("query_order_count", 0);
            o.bVs().qzp = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          o.bVs().qzq = paramString;
          ab.a(paramJSONObject.optJSONObject("bindqueryresp"), this.bUV);
          paramString = (k)g.r(k.class);
          if (paramString != null)
          {
            y.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
            paramString.aSH();
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.cdl = paramString.optString("guide_flag");
              this.cdm = paramString.optString("guide_wording");
              this.cdn = paramString.optString("left_button_wording");
              this.cdo = paramString.optString("right_button_wording");
              this.cdp = paramString.optString("upload_credit_url");
              this.qmn = paramString.optInt("guide_type", 0);
            }
            if (!paramJSONObject.has("user_notify_info")) {
              break;
            }
            paramString = paramJSONObject.optJSONObject("user_notify_info");
            if (paramString != null) {
              break label337;
            }
            paramString = null;
            this.qmo = paramString;
          }
        }
        else
        {
          y.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        y.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        return;
      }
      continue;
      label337:
      paramInt = paramString.optInt("notify_flag", 0);
      paramJSONObject = paramString.optString("notify_wording", "");
      String str1 = paramString.optString("left_button_wording", "");
      String str2 = paramString.optString("right_button_wording", "");
      String str3 = paramString.optString("confirm_button_wording", "");
      if (paramInt == 0)
      {
        paramString = null;
      }
      else
      {
        paramString = new com.tencent.mm.plugin.wallet.pay.a.c();
        paramString.qlX = paramInt;
        paramString.qlY = paramJSONObject;
        paramString.lRE = str1;
        paramString.lRF = str2;
        paramString.qlZ = str3;
      }
    }
  }
  
  public final void a(com.tencent.mm.wallet_core.c.c paramc, JSONObject paramJSONObject)
  {
    super.a(paramc, paramJSONObject);
    int i = this.bUV;
    paramJSONObject = this.qmm;
    int j = paramc.errCode;
    y.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    h.nFQ.f(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
  }
  
  public final int aEC()
  {
    return 112;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.e
 * JD-Core Version:    0.7.0.1
 */