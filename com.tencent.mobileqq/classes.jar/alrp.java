import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EmoticonHandler.1;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.ComicRich;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.GameRich;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.data.IPSiteModel.Gxzb;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.emosm.ComicIPSite.Book;
import com.tencent.pb.emosm.ComicIPSite.Comic;
import com.tencent.pb.emosm.ComicIPSite.ComicRich;
import com.tencent.pb.emosm.ComicIPSite.Game;
import com.tencent.pb.emosm.ComicIPSite.GameRich;
import com.tencent.pb.emosm.ComicIPSite.Goods;
import com.tencent.pb.emosm.ComicIPSite.Gxzb;
import com.tencent.pb.emosm.ComicIPSite.ModuleInfo;
import com.tencent.pb.emosm.ComicIPSite.ModuleReq;
import com.tencent.pb.emosm.ComicIPSite.ModuleRsp;
import com.tencent.pb.emosm.ComicIPSite.Video;
import com.tencent.pb.emosm.EmosmPb.ReqBody;
import com.tencent.pb.emosm.EmosmPb.RspBody;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x10MoveOrderReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x18Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x18Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x19Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1ReqDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1RspDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2ReqFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab.TabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3ReqFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3RspFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5ReqBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x8ReqAddTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class alrp
  extends alpd
{
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<aprv> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> c = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<String>> d = new ConcurrentHashMap();
  
  public alrp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList)
  {
    String str = "svr emoticon tab order list " + paramInt + " =";
    StringBuilder localStringBuilder = aepi.a();
    localStringBuilder.append(str);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuilder.append((String)paramArrayList.next());
      localStringBuilder.append(",");
      if (localStringBuilder.length() >= 500)
      {
        QLog.d("EmoticonHandler", 1, localStringBuilder.toString());
        localStringBuilder.setLength(str.length());
      }
    }
    QLog.d("EmoticonHandler", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    int i;
    for (;;)
    {
      try
      {
        paramObject = (ComicIPSite.ModuleRsp)new ComicIPSite.ModuleRsp().mergeFrom((byte[])paramObject);
        i = paramObject.result.get();
        switch (paramObject.sub_cmd.get())
        {
        case 1: 
          if (i != 0) {
            break label1468;
          }
          Object localObject1 = paramToServiceMsg.extraData.getString("epId");
          int k = paramObject.ipId.get();
          paramToServiceMsg = paramObject.ipName.get();
          String str1 = paramObject.ipDesc.get();
          String str2 = paramObject.ipUrl.get();
          int m = paramObject.itemSize.get();
          Object localObject2 = paramObject.strType.get();
          int n = paramObject.extId.get();
          Object localObject3 = paramObject.extStr.get();
          String str3 = paramObject.ipLogo.get();
          String str4 = paramObject.ipContent.get();
          long l;
          ArrayList localArrayList1;
          List localList1;
          Object localObject4;
          if (paramObject.requestInterval.get() == 0)
          {
            l = 86400L;
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "onReceive richIPReqTime = " + l);
            }
            localArrayList1 = new ArrayList();
            if ("gxzb".equals(localObject2))
            {
              localList1 = paramObject.gxzbList.get();
              i = 0;
              if (i >= localList1.size()) {
                continue;
              }
              localObject4 = (ComicIPSite.Gxzb)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Gxzb(((ComicIPSite.Gxzb)localObject4).appId.get(), ((ComicIPSite.Gxzb)localObject4).appName.get(), ((ComicIPSite.Gxzb)localObject4).cover.get(), ((ComicIPSite.Gxzb)localObject4).feeType.get(), ((ComicIPSite.Gxzb)localObject4).id.get(), ((ComicIPSite.Gxzb)localObject4).name.get()));
              i += 1;
              continue;
            }
          }
          else
          {
            l = paramObject.requestInterval.get();
            continue;
          }
          List localList2;
          ArrayList localArrayList2;
          int j;
          Object localObject5;
          if ("game".equals(localObject2))
          {
            localList1 = paramObject.gameList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Game)localList1.get(i);
              localList2 = ((ComicIPSite.Game)localObject4).rich.get();
              localArrayList2 = new ArrayList();
              j = 0;
              if (j < localList2.size())
              {
                localObject5 = (ComicIPSite.GameRich)localList2.get(j);
                localArrayList2.add(new IPSiteModel.GameRich(((ComicIPSite.GameRich)localObject5).anchorFaceUrl.get(), ((ComicIPSite.GameRich)localObject5).anchorId.get(), ((ComicIPSite.GameRich)localObject5).anchorName.get(), ((ComicIPSite.GameRich)localObject5).coverUrl.get(), ((ComicIPSite.GameRich)localObject5).online.get(), ((ComicIPSite.GameRich)localObject5).title.get(), ((ComicIPSite.GameRich)localObject5).richJumpUrl.get()));
                j += 1;
                continue;
              }
              localArrayList1.add(new IPSiteModel.Game(((ComicIPSite.Game)localObject4).cover.get(), ((ComicIPSite.Game)localObject4).desc.get(), ((ComicIPSite.Game)localObject4).id.get(), ((ComicIPSite.Game)localObject4).jumpUrl.get(), ((ComicIPSite.Game)localObject4).name.get(), ((ComicIPSite.Game)localObject4).recommDesc.get(), localArrayList2));
              i += 1;
              continue;
            }
          }
          else if ("goods".equals(localObject2))
          {
            localList1 = paramObject.goodsList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Goods)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Goods(((ComicIPSite.Goods)localObject4).cover.get(), ((ComicIPSite.Goods)localObject4).goodsTags.get(), ((ComicIPSite.Goods)localObject4).id.get(), ((ComicIPSite.Goods)localObject4).name.get(), ((ComicIPSite.Goods)localObject4).price.get(), ((ComicIPSite.Goods)localObject4).saleTags.get(), ((ComicIPSite.Goods)localObject4).svipPrice.get(), ((ComicIPSite.Goods)localObject4).url.get(), ((ComicIPSite.Goods)localObject4).moreUrl.get(), ((ComicIPSite.Goods)localObject4).saleNum.get()));
              i += 1;
              continue;
            }
          }
          else if ("video".equals(localObject2))
          {
            localList1 = paramObject.videoList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Video)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Video(((ComicIPSite.Video)localObject4).id.get(), ((ComicIPSite.Video)localObject4).buttonDesc.get(), ((ComicIPSite.Video)localObject4).content.get(), ((ComicIPSite.Video)localObject4).cover.get(), ((ComicIPSite.Video)localObject4).desc.get(), ((ComicIPSite.Video)localObject4).name.get(), ((ComicIPSite.Video)localObject4).endTime.get(), ((ComicIPSite.Video)localObject4).isShow.get(), ((ComicIPSite.Video)localObject4).newStartTime.get(), ((ComicIPSite.Video)localObject4).newEndTime.get(), ((ComicIPSite.Video)localObject4).redirectUrl.get(), ((ComicIPSite.Video)localObject4).videoSource.get(), ((ComicIPSite.Video)localObject4).showDate.get()));
              i += 1;
              continue;
            }
          }
          else if ("book".equals(localObject2))
          {
            localList1 = paramObject.bookList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Book)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Book(((ComicIPSite.Book)localObject4).cover.get(), ((ComicIPSite.Book)localObject4).desc.get(), ((ComicIPSite.Book)localObject4).id.get(), ((ComicIPSite.Book)localObject4).jumpUrl.get(), ((ComicIPSite.Book)localObject4).name.get(), ((ComicIPSite.Book)localObject4).recommDesc.get(), ((ComicIPSite.Book)localObject4).authorName.get()));
              i += 1;
              continue;
            }
          }
          else if ("comic".equals(localObject2))
          {
            localList1 = paramObject.comicList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Comic)localList1.get(i);
              localList2 = ((ComicIPSite.Comic)localObject4).rich.get();
              localArrayList2 = new ArrayList();
              j = 0;
              if (j < localList2.size())
              {
                localObject5 = (ComicIPSite.ComicRich)localList2.get(j);
                localArrayList2.add(new IPSiteModel.ComicRich(((ComicIPSite.ComicRich)localObject5).extCover.get(), ((ComicIPSite.ComicRich)localObject5).extName.get(), ((ComicIPSite.ComicRich)localObject5).extTitle.get(), ((ComicIPSite.ComicRich)localObject5).extUrl.get()));
                j += 1;
                continue;
              }
              localArrayList1.add(new IPSiteModel.Comic(((ComicIPSite.Comic)localObject4).comicType.get(), ((ComicIPSite.Comic)localObject4).cover.get(), ((ComicIPSite.Comic)localObject4).desc.get(), ((ComicIPSite.Comic)localObject4).id.get(), ((ComicIPSite.Comic)localObject4).jumpUrl.get(), ((ComicIPSite.Comic)localObject4).name.get(), ((ComicIPSite.Comic)localObject4).recommDesc.get(), ((ComicIPSite.Comic)localObject4).typeName.get(), localArrayList2));
              i += 1;
              continue;
            }
          }
          localObject2 = new VipIPSiteInfo(k, paramToServiceMsg, str1, str2, m, (String)localObject2, n, (String)localObject3, str3, str4, localArrayList1);
          if (this.app != null)
          {
            localObject3 = (aufn)this.app.getManager(14);
            if (localObject3 != null)
            {
              localObject1 = ((aufn)localObject3).a((String)localObject1);
              ((EmoticonPackage)localObject1).ipSiteInfo = ((VipIPSiteInfo)localObject2);
              ((EmoticonPackage)localObject1).ipSiteInfoBytes = ((aufn)localObject3).a((VipIPSiteInfo)localObject2);
              ((EmoticonPackage)localObject1).richIPReqTime = l;
              if (paramObject.goodsList.size() <= 0) {
                break label1462;
              }
              bool = true;
              ((EmoticonPackage)localObject1).hasIpProduct = bool;
              ((EmoticonPackage)localObject1).ipUrl = str3;
              ((EmoticonPackage)localObject1).ipName = paramToServiceMsg;
              ((EmoticonPackage)localObject1).ipDetail = str1;
              ((EmoticonPackage)localObject1).ipJumpUrl = str2;
              ((aufn)localObject3).a((EmoticonPackage)localObject1);
            }
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("EmoticonHandler", 2, "onReceive vipIPSiteInfo = " + localObject2);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EmoticonHandler", 1, "onReceive error = ", paramToServiceMsg);
        return;
      }
      label1462:
      boolean bool = false;
    }
    label1468:
    QLog.e("EmoticonHandler", 1, "onReceive error result = " + i);
    return;
  }
  
  public void a()
  {
    c(0);
  }
  
  public void a(int paramInt)
  {
    b(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "func fetchEmoticonsPackages, timestamp:" + paramInt1 + ",dividemask:" + paramInt2 + " businessType = " + paramInt3 + " fetchSeq:" + paramInt4);
    }
    Object localObject = new EmosmPb.SubCmd0x2ReqFetchTab();
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).fixed32_timestamp.set(paramInt1);
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).int32_segment_flag.set(paramInt2);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(2);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x2_req_fetchtab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.3.5");
    localReqBody.uint32_business_id.set(paramInt3);
    if (paramInt4 == 0)
    {
      paramInt2 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
      this.d.remove(Integer.valueOf(paramInt1));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
      this.c.remove(Integer.valueOf(paramInt1));
      this.b.remove(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 2);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmFetchSeq", paramInt1);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      return;
      paramInt1 = paramInt4;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.3.5");
    Object localObject;
    if (6 == paramInt1)
    {
      localReqBody.uint32_sub_cmd.set(paramInt1);
      localObject = new EmosmPb.SubCmd0x6Req();
      ((EmosmPb.SubCmd0x6Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x6Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x6_req.set((MessageMicro)localObject);
    }
    for (;;)
    {
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("EmoticonId", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", false);
      if (107 == paramInt1)
      {
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 7);
        ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", true);
      }
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      return;
      if ((7 == paramInt1) || (107 == paramInt1))
      {
        localReqBody.uint32_sub_cmd.set(7);
        localObject = new EmosmPb.SubCmd0x7Req();
        ((EmosmPb.SubCmd0x7Req)localObject).u32_tab_id.set(paramInt2);
        ((EmosmPb.SubCmd0x7Req)localObject).str_item_id.set(paramString);
        localReqBody.msg_subcmd0x7_req.set((MessageMicro)localObject);
      }
    }
  }
  
  public void a(int paramInt, ArrayList<Emoticon> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "emosm...fetch key count  = " + paramArrayList.size() + " epid = " + ((Emoticon)paramArrayList.get(0)).epId + "  eid.0 = " + ((Emoticon)paramArrayList.get(0)).eId);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Emoticon)((Iterator)localObject2).next();
      try
      {
        localObject3 = ByteStringMicro.copyFrom(apvx.a(((Emoticon)localObject3).eId));
        ((List)localObject1).add(localObject3);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    localObject2 = new EmosmPb.SubCmd0x3ReqFetchBq();
    ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).uint32_tab_id.set(paramInt);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).rpt_bytes_bqid.get().add(((List)localObject1).get(i));
      i += 1;
    }
    localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(3);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x3_req_fetchbq.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject2).extraData.putSerializable("EmosmEmos", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 3);
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "getKeySeq reqlocalseq:" + paramString);
    }
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(aprv paramaprv)
  {
    if (paramaprv != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addIfAbsent(paramaprv);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "ReportAddEmoticonPkg, pkgId=" + paramString + " businessType = " + paramInt);
    }
    Object localObject = new EmosmPb.SubCmd0x8ReqAddTab();
    ((EmosmPb.SubCmd0x8ReqAddTab)localObject).uint32_tab_id.set(Integer.parseInt(paramString));
    paramString = new EmosmPb.ReqBody();
    paramString.uint32_sub_cmd.set(8);
    paramString.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    paramString.int32_plat_id.set(109);
    paramString.str_app_version.set("8.3.5");
    paramString.msg_subcmd0x8_req_addtab.set((MessageMicro)localObject);
    paramString.uint32_business_id.set(paramInt);
    paramString.setHasFlag(true);
    localObject = createToServiceMsg("BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 8);
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "getCloudEmoticonForKeyword");
    }
    Object localObject = paramList1;
    if (paramList1 == null) {
      localObject = new ArrayList();
    }
    paramList1 = paramList2;
    if (paramList2 == null) {
      paramList1 = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "notFullExposeList size = " + ((List)localObject).size() + ",fullExposeList size = " + paramList1.size());
    }
    paramList2 = new EmosmPb.ReqBody();
    paramList2.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    paramList2.int32_plat_id.set(109);
    paramList2.uint32_sub_cmd.set(9);
    paramList2.str_app_version.set("8.3.5");
    EmosmPb.SubCmd0x9BqAssocReq localSubCmd0x9BqAssocReq = new EmosmPb.SubCmd0x9BqAssocReq();
    localSubCmd0x9BqAssocReq.str_key_word.set(paramString);
    localSubCmd0x9BqAssocReq.rpt_str_bq_item_id.set((List)localObject);
    localSubCmd0x9BqAssocReq.rpt_str_dead_bq_item_id.set(paramList1);
    paramList2.msg_subcmd0x9_req.set(localSubCmd0x9BqAssocReq);
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    paramString.extraData.putInt("EmosmSubCmd", 9);
    paramString.putWupBuffer(paramList2.toByteArray());
    super.sendPbReq(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "fetchEmoticonIPSiteInformationEx, tabId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("EmoticonHandler", 1, "fetchEmoticonIPSiteInformationEx error, id = " + paramString);
    }
    while (this.app == null) {
      return;
    }
    Object localObject = new ComicIPSite.ModuleInfo();
    ((ComicIPSite.ModuleInfo)localObject).appId.set(204);
    ((ComicIPSite.ModuleInfo)localObject).itemId.set("1_" + paramString);
    ((ComicIPSite.ModuleInfo)localObject).isRetSummary.set(paramBoolean);
    ComicIPSite.ModuleReq localModuleReq = new ComicIPSite.ModuleReq();
    localModuleReq.platform.set(109L);
    localModuleReq.mqqver.set("8.3.5");
    localModuleReq.uin.set(Long.valueOf(this.app.c()).longValue());
    localModuleReq.sub_cmd.set(1);
    localModuleReq.moduleInfo.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "gxzbIpsit.ipsite");
    ((ToServiceMsg)localObject).extraData.putString("epId", paramString);
    ((ToServiceMsg)localObject).putWupBuffer(localModuleReq.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).rpt_tab_id.addAll(paramArrayList);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", -1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 17);
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("EmosmPackageIds", paramArrayList);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(List<String> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList=" + paramList + ", shouldReverse=" + paramBoolean + ", businessType = " + paramInt);
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList null, abort");
      }
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x10MoveOrderReq();
    ArrayList localArrayList = new ArrayList(paramList.size());
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        i = paramList.size() - 1;
        if (i < 0) {
          continue;
        }
        str = (String)paramList.get(i);
        if (TextUtils.isEmpty(str)) {
          break label380;
        }
        localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
      }
      catch (Exception paramList)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmoticonHandler", 2, "reportEmoticonOrder, error=" + MsfSdkUtils.getStackTraceString(paramList));
        ((EmosmPb.SubCmd0x10MoveOrderReq)localObject).uint32_tab_id.set(localArrayList);
        paramList = new EmosmPb.ReqBody();
        paramList.uint32_sub_cmd.set(16);
        paramList.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
        paramList.int32_plat_id.set(109);
        paramList.str_app_version.set("8.3.5");
        paramList.msg_subcmd0x10_req.set((MessageMicro)localObject);
        paramList.uint32_business_id.set(paramInt);
        paramList.setHasFlag(true);
        localObject = createToServiceMsg("BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 16);
        ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
        super.sendPbReq((ToServiceMsg)localObject);
        return;
      }
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
      }
      else
      {
        label380:
        i -= 1;
      }
    }
  }
  
  public void b()
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(19);
    localReqBody.str_app_version.set("8.3.5");
    Object localObject1 = ((apty)this.app.getManager(172)).c();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest list is null");
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        if ((localObject1 == null) || (((List)localObject1).size() <= 1)) {
          break label377;
        }
        localObject2 = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
          if (localSmallYellowItem != null) {
            ((StringBuilder)localObject2).append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          }
          i += 1;
        }
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest item " + ((StringBuilder)localObject2).toString());
      }
      for (;;)
      {
        localObject2 = new EmosmPb.SubCmd0x13Req();
        ((EmosmPb.SubCmd0x13Req)localObject2).itemlist.set((List)localObject1);
        localReqBody.msg_subcmd0x13_req.set((MessageMicro)localObject2);
        localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 20);
        ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
        super.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest called.");
        }
        return;
        label377:
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest infos = null");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "fetchEmoticonRecommend, tabId:" + paramInt);
    }
    Object localObject = new EmosmPb.SubCmd0x18Req();
    ((EmosmPb.SubCmd0x18Req)localObject).uint32_tab_id.set(paramInt);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(24);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x18_req.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.3.5");
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 24);
    ((ToServiceMsg)localObject).extraData.putInt("tabId", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).uint32_tab_id.set(paramInt1);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_business_id.set(paramInt2);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(aprv paramaprv)
  {
    if (paramaprv != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaprv);
    }
  }
  
  public void c()
  {
    Object localObject1 = VasQuickUpdateManager.getJSONFromLocal(this.app, "watch_focus.json", true, null);
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("watchingFocusRecommendList");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        Object localObject2 = new ArrayList();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject1 = localJSONArray.optJSONObject(i);
          int j = ((JSONObject)localObject1).optInt("itemId");
          String str1 = ((JSONObject)localObject1).optString("name");
          int k = ((JSONObject)localObject1).optInt("itemType");
          int m = ((JSONObject)localObject1).optInt("feeType");
          localObject1 = "";
          if (k == 3) {
            localObject1 = apvx.k.replace("[epId]", String.valueOf(j)).replace("[mod]", String.valueOf(j % 10));
          }
          for (;;)
          {
            String str2 = bdtg.a(BaseApplicationImpl.context, "emojiDetail", String.valueOf(j), "") + "&sceneType=1";
            EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = new EmosmPb.STRecommendTabInfo();
            localSTRecommendTabInfo.u32_tab_id.set(j);
            localSTRecommendTabInfo.str_tab_name.set(str1);
            localSTRecommendTabInfo.i32_tab_type.set(k);
            localSTRecommendTabInfo.i32_feetype.set(m);
            localSTRecommendTabInfo.str_thumb_nail_url.set((String)localObject1);
            localSTRecommendTabInfo.str_button_url.set(str2);
            ((List)localObject2).add(localSTRecommendTabInfo);
            i += 1;
            break;
            if (k == 6) {
              localObject1 = apvx.l.replace("[epId]", String.valueOf(j));
            }
          }
        }
        localObject1 = new EmosmPb.SubCmd0x5RspBQRecommend();
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject1).st_new_tab_info.set((List)localObject2);
        localObject2 = (aufn)this.app.getManager(14);
        if (localObject2 != null) {
          ((aufn)localObject2).a((EmosmPb.SubCmd0x5RspBQRecommend)localObject1, 1);
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i = -1;
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(5);
    localReqBody.str_app_version.set("8.3.5");
    localReqBody.uint32_business_id.set(paramInt);
    Object localObject = new EmosmPb.SubCmd0x5ReqBQRecommend();
    int j = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendEmotion_sp_lastversion" + this.app.getCurrentAccountUin(), -1);
    if (!new File(this.app.getApplication().getFilesDir(), "recommemd_emotion_file__" + paramInt + this.app.getCurrentAccountUin()).exists()) {}
    for (paramInt = i;; paramInt = j)
    {
      ((EmosmPb.SubCmd0x5ReqBQRecommend)localObject).int32_last_recommend_version.set(paramInt);
      localReqBody.msg_subcmd0x5_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 5);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "handle request to recommendEmotionInfo");
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    if (paramInt == 0)
    {
      localOIDBSSOPkg.uint32_command.set(1168);
      localOIDBSSOPkg.uint32_service_type.set(92);
      localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x490_92");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
    while (paramInt != 1) {
      return;
    }
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(99);
    Object localObject = new oidb_0x5eb.ReqBody();
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.app.getCurrentAccountUin())));
    ((oidb_0x5eb.ReqBody)localObject).uint32_vas_emoticon_usage_info.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5eb_99");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return alrq.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int j;
    int i;
    int m;
    Object localObject1;
    Object localObject2;
    EmoticonResp localEmoticonResp;
    if (paramFromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq"))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      j = paramToServiceMsg.extraData.getInt("EmosmPackageId");
      i = paramToServiceMsg.extraData.getInt("EmosmSubCmd");
      m = 0;
      localObject1 = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      localObject2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("EmosmEmos");
      localEmoticonResp = new EmoticonResp();
      localEmoticonResp.resultcode = paramFromServiceMsg.getResultCode();
      localEmoticonResp.data = ((List)localObject2);
      localEmoticonResp.epId = j;
      localEmoticonResp.keySeq = ((String)localObject1);
      localEmoticonResp.timeoutReason = MessageHandler.a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "key_seq=" + (String)localObject1 + " isSuccess=" + bool1 + " resultCode=" + paramFromServiceMsg.getResultCode() + " timeout:" + localEmoticonResp.timeoutReason + ",subcmd = " + i);
      }
      if (bool1) {
        localObject1 = new EmosmPb.RspBody();
      }
    }
    boolean bool2;
    label949:
    label1244:
    label1513:
    label2164:
    boolean bool3;
    label1030:
    label1161:
    label1325:
    label1370:
    label2280:
    do
    {
      int n;
      long l;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              try
              {
                paramObject = (EmosmPb.RspBody)((EmosmPb.RspBody)localObject1).mergeFrom((byte[])paramObject);
                if (paramObject == null) {
                  break label3544;
                }
                m = paramObject.int32_result.get();
                k = paramObject.uint32_business_id.get();
                localEmoticonResp.resultcode = m;
                if (m != 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 失败，result = " + m);
                  }
                  bool1 = false;
                  j = k;
                  k = j;
                  bool2 = bool1;
                  j = i;
                  paramToServiceMsg = (aufn)this.app.getManager(14);
                  if (j != 2) {
                    break label3782;
                  }
                  if (!bool2) {
                    break;
                  }
                  ThreadManagerV2.excute(new EmoticonHandler.1(this, paramToServiceMsg, localEmoticonResp, k), 32, null, true);
                  return;
                }
              }
              catch (Exception paramObject)
              {
                localEmoticonResp.resultcode = -1;
                paramObject = null;
                continue;
                localObject1 = (aufn)this.app.getManager(14);
                switch (i)
                {
                }
              }
              Object localObject3;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            break;
                            localEmoticonResp.data = null;
                            localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramObject.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
                            paramToServiceMsg = String.valueOf(localEmoticonResp.delEpId);
                            ((aufn)localObject1).g(paramToServiceMsg, k);
                            paramToServiceMsg = ((aufn)localObject1).a(paramToServiceMsg, k);
                            aprn.a().b(paramToServiceMsg);
                            break;
                            paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("EmosmPackageIds");
                          } while (paramToServiceMsg == null);
                          if (paramToServiceMsg.size() == 0) {
                            break;
                          }
                          localEmoticonResp.ids = paramToServiceMsg;
                          paramToServiceMsg = paramToServiceMsg.iterator();
                          while (paramToServiceMsg.hasNext())
                          {
                            paramObject = String.valueOf((Integer)paramToServiceMsg.next());
                            ((aufn)localObject1).g(paramObject, k);
                            paramObject = ((aufn)localObject1).a(paramObject, k);
                            aprn.a().b(paramObject);
                          }
                          break;
                          m = paramToServiceMsg.extraData.getInt("EmosmFetchSeq");
                          Object localObject4 = (EmosmPb.SubCmd0x2RspFetchTab)paramObject.msg_subcmd0x2_rsp_fetchtab.get();
                          j = ((EmosmPb.SubCmd0x2RspFetchTab)localObject4).int32_segment_flag.get();
                          if (QLog.isColorLevel()) {
                            QLog.d("EmoticonHandler", 2, "fetchSeq:" + m + " cur segement:" + j + " mapSize:" + this.d.size());
                          }
                          paramToServiceMsg = ((EmosmPb.SubCmd0x2RspFetchTab)localObject4).rpt_msg_tabinfo.get();
                          localObject2 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject4).rpt_magic_tabinfo.get();
                          localObject1 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject4).rpt_smallbq_tabinfo.get();
                          localObject3 = new ArrayList();
                          if (((EmosmPb.SubCmd0x2RspFetchTab)localObject4).uint32_tab_id.has())
                          {
                            localObject4 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject4).uint32_tab_id.get().iterator();
                            while (((Iterator)localObject4).hasNext()) {
                              ((ArrayList)localObject3).add(String.valueOf((Integer)((Iterator)localObject4).next()));
                            }
                          }
                          n = ((EmosmPb.SubCmd0x2RspFetchTab)paramObject.msg_subcmd0x2_rsp_fetchtab.get()).fixed32_timestamp.get();
                          if ((j == 0) || (j == -1))
                          {
                            localEmoticonResp.timestamp = n;
                            paramObject = new ArrayList();
                            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m)) == null) {
                              break label4902;
                            }
                            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m))).addAll(paramToServiceMsg);
                            paramToServiceMsg = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(m));
                            paramToServiceMsg = paramToServiceMsg.iterator();
                            if (paramToServiceMsg.hasNext())
                            {
                              localObject4 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
                              EmoticonPackage localEmoticonPackage = new EmoticonPackage();
                              localEmoticonPackage.epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject4).uint32_tab_id.get());
                              localEmoticonPackage.expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject4).fixed32_expire_time.get();
                              if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject4).uint32_flags.get() == 1)
                              {
                                bool2 = true;
                                localEmoticonPackage.valid = bool2;
                                localEmoticonPackage.wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject4).int32_wording_id.get();
                                localEmoticonPackage.name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject4).str_tab_name.get();
                                if (k != 0) {
                                  break label1161;
                                }
                                localEmoticonPackage.aio = true;
                              }
                              for (;;)
                              {
                                paramObject.add(localEmoticonPackage);
                                if (!localEmoticonPackage.valid) {
                                  QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: normal emotion ep not valid ; ep = " + localEmoticonPackage);
                                }
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: normal emotion ep = " + localEmoticonPackage);
                                break;
                                bool2 = false;
                                break label1030;
                                if (k == 1) {
                                  localEmoticonPackage.kandian = true;
                                }
                              }
                            }
                            localEmoticonResp.data = paramObject;
                            paramObject = new ArrayList();
                            if (this.b.get(Integer.valueOf(m)) == null) {
                              break label4896;
                            }
                            ((List)this.b.get(Integer.valueOf(m))).addAll((Collection)localObject2);
                            paramToServiceMsg = (List)this.b.remove(Integer.valueOf(m));
                            paramToServiceMsg = paramToServiceMsg.iterator();
                            if (paramToServiceMsg.hasNext())
                            {
                              localObject2 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
                              localObject4 = new EmoticonPackage();
                              ((EmoticonPackage)localObject4).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_tab_id.get());
                              ((EmoticonPackage)localObject4).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).fixed32_expire_time.get();
                              if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_flags.get() == 1)
                              {
                                bool2 = true;
                                ((EmoticonPackage)localObject4).valid = bool2;
                                ((EmoticonPackage)localObject4).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_wording_id.get();
                                ((EmoticonPackage)localObject4).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).str_tab_name.get();
                                if (k != 0) {
                                  break label1498;
                                }
                                ((EmoticonPackage)localObject4).aio = true;
                                if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.has())
                                {
                                  ((EmoticonPackage)localObject4).type = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get();
                                  if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get() != 1) {
                                    break label1513;
                                  }
                                  ((EmoticonPackage)localObject4).jobType = 3;
                                }
                              }
                              for (;;)
                              {
                                if (!((EmoticonPackage)localObject4).valid) {
                                  QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: magic emotion ep not valid ; ep = " + localObject4);
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: magic emotion ep = " + localObject4);
                                }
                                paramObject.add(localObject4);
                                break;
                                bool2 = false;
                                break label1325;
                                if (k != 1) {
                                  break label1370;
                                }
                                ((EmoticonPackage)localObject4).kandian = true;
                                break label1370;
                                if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get() == 4) {
                                  ((EmoticonPackage)localObject4).jobType = 5;
                                }
                              }
                            }
                            localEmoticonResp.magicData = paramObject;
                            paramObject = new ArrayList();
                            if (this.c.get(Integer.valueOf(m)) == null) {
                              break label4890;
                            }
                            ((List)this.c.get(Integer.valueOf(m))).addAll((Collection)localObject1);
                            paramToServiceMsg = (List)this.c.remove(Integer.valueOf(m));
                            paramToServiceMsg = paramToServiceMsg.iterator();
                            if (paramToServiceMsg.hasNext())
                            {
                              localObject1 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
                              localObject2 = new EmoticonPackage();
                              ((EmoticonPackage)localObject2).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_tab_id.get());
                              ((EmoticonPackage)localObject2).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).fixed32_expire_time.get();
                              if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_flags.get() == 1)
                              {
                                bool2 = true;
                                ((EmoticonPackage)localObject2).valid = bool2;
                                ((EmoticonPackage)localObject2).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_wording_id.get();
                                ((EmoticonPackage)localObject2).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).str_tab_name.get();
                                ((EmoticonPackage)localObject2).jobType = 4;
                                if (k != 0) {
                                  break label1820;
                                }
                                ((EmoticonPackage)localObject2).aio = true;
                              }
                              for (;;)
                              {
                                paramObject.add(localObject2);
                                if (!((EmoticonPackage)localObject2).valid) {
                                  QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: small emotion ep not valid ; ep = " + localObject2);
                                }
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: small emotion ep = " + localObject2);
                                break;
                                bool2 = false;
                                break label1683;
                                if (k == 1) {
                                  ((EmoticonPackage)localObject2).kandian = true;
                                }
                              }
                            }
                            localEmoticonResp.smallEmoticonData = paramObject;
                            localEmoticonResp.tabOrderList = ((List)this.d.remove(Integer.valueOf(m)));
                            if (localEmoticonResp.tabOrderList == null) {
                              localEmoticonResp.tabOrderList = new ArrayList();
                            }
                            j = ((ArrayList)localObject3).size() - 1;
                            while (j >= 0)
                            {
                              localEmoticonResp.tabOrderList.add(((ArrayList)localObject3).get(j));
                              j -= 1;
                            }
                            QLog.d("EmoticonHandler", 1, "svr big emoticon data size = " + localEmoticonResp.data.size() + ", magic size = " + localEmoticonResp.magicData.size() + ", small emotion size = " + localEmoticonResp.smallEmoticonData.size() + ", tab size = " + localEmoticonResp.tabOrderList.size());
                            if (QLog.isColorLevel())
                            {
                              QLog.d("EmoticonHandler", 2, "svr big emoticon list=" + localEmoticonResp.data + "svr magic emoticon list=" + localEmoticonResp.magicData + "svr small emoticon list=" + localEmoticonResp.smallEmoticonData);
                              a(m, (ArrayList)localObject3);
                            }
                            break;
                          }
                          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m)) != null)
                          {
                            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m))).addAll(paramToServiceMsg);
                            if (this.b.get(Integer.valueOf(m)) == null) {
                              break label2262;
                            }
                            ((List)this.b.get(Integer.valueOf(m))).addAll((Collection)localObject2);
                            if (this.c.get(Integer.valueOf(m)) == null) {
                              break label2280;
                            }
                            ((List)this.c.get(Integer.valueOf(m))).addAll((Collection)localObject1);
                          }
                          for (;;)
                          {
                            paramToServiceMsg = new ArrayList();
                            i = ((ArrayList)localObject3).size() - 1;
                            while (i >= 0)
                            {
                              paramToServiceMsg.add(((ArrayList)localObject3).get(i));
                              i -= 1;
                            }
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(m), paramToServiceMsg);
                            break;
                            this.b.put(Integer.valueOf(m), localObject2);
                            break label2164;
                            this.c.put(Integer.valueOf(m), localObject1);
                          }
                          if (this.d.get(Integer.valueOf(m)) != null) {
                            ((List)this.d.get(Integer.valueOf(m))).addAll(paramToServiceMsg);
                          }
                          for (;;)
                          {
                            if (QLog.isColorLevel())
                            {
                              QLog.d("EmoticonHandler", 2, "--------secend fetch--------:");
                              a(m, (ArrayList)localObject3);
                            }
                            a(n, j, k, m);
                            return;
                            this.d.put(Integer.valueOf(m), paramToServiceMsg);
                          }
                          paramToServiceMsg = (ArrayList)localEmoticonResp.data;
                          localEmoticonResp.epId = j;
                          paramObject = ((EmosmPb.SubCmd0x3RspFetchBq)paramObject.msg_subcmd0x3_rsp_fetchbq.get()).rpt_bytes_key.get();
                          j = 0;
                          while (j < paramObject.size())
                          {
                            localObject1 = (ByteStringMicro)paramObject.get(j);
                            ((Emoticon)paramToServiceMsg.get(j)).encryptKey = ((ByteStringMicro)localObject1).toStringUtf8();
                            j += 1;
                          }
                          localEmoticonResp.data = paramToServiceMsg;
                        } while (!QLog.isColorLevel());
                        QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 成功");
                        break;
                        localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
                        localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x6Rsp)paramObject.msg_subcmd0x6_collect_auth.get()).int32_auth_detail.get();
                        localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x6Rsp)paramObject.msg_subcmd0x6_collect_auth.get()).str_auth_msg.get();
                        break;
                        localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
                        localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x7Rsp)paramObject.msg_subcmd0x7_rsp.get()).int32_auth_detail.get();
                        localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x7Rsp)paramObject.msg_subcmd0x7_rsp.get()).str_auth_msg.get();
                      } while (!paramToServiceMsg.extraData.getBoolean("EmosmSubCmdFllow"));
                      i = 107;
                      break;
                      localEmoticonResp.data = ((EmosmPb.SubCmd0x9BqAssocRsp)paramObject.msg_subcmd0x9_rsp.get()).rpt_assoc_bqs.get();
                      if (((EmosmPb.SubCmd0x9BqAssocRsp)paramObject.msg_subcmd0x9_rsp.get()).i32_reset_exposure_flag.get() == 1) {}
                      for (bool2 = true;; bool2 = false)
                      {
                        localEmoticonResp.resetKeywordExpose = bool2;
                        break;
                      }
                      paramToServiceMsg = (EmosmPb.SubCmd0x5RspBQRecommend)paramObject.msg_subcmd0x5_recommend.get();
                      bool2 = paramToServiceMsg.bool_update_flag.get();
                      if (bool2)
                      {
                        j = paramToServiceMsg.int32_last_recommend_version.get();
                        paramObject = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit();
                        paramObject.putInt("recommendEmotion_sp_lastversion" + this.app.getCurrentAccountUin(), j);
                        paramObject.putBoolean("isClickRecommendRedpoint", false);
                        paramObject.putLong("recommendRedpointStartTime", System.currentTimeMillis());
                        paramObject.putInt("recommendSeqinterval", paramToServiceMsg.int32_req_frequency.get());
                        paramObject.putInt("recommendRuleId", paramToServiceMsg.int32_ruleid.get());
                        paramObject.apply();
                        bool3 = paramToServiceMsg.bool_recommend_show_flag.get();
                        BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0).edit().putBoolean("force_to_recommend_panel_sp", bool3).apply();
                        ((aufn)localObject1).e();
                        if (QLog.isColorLevel()) {
                          QLog.d("EmoticonHandler", 2, "recommend info : lastVersion = " + j + ";seqFrequncy = " + paramToServiceMsg.int32_req_frequency.get() + ";isForceToRecommend = " + bool3);
                        }
                        ((aufn)localObject1).a(paramToServiceMsg, k);
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("EmoticonHandler", 2, "recommend update flag = " + bool2);
                    break;
                    paramToServiceMsg = ((EmosmPb.SubCmd0x13Rsp)paramObject.msg_subcmd0x13_rsp.get()).itemlist.get();
                    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 1))
                    {
                      if (QLog.isColorLevel())
                      {
                        paramObject = new StringBuilder();
                        j = 0;
                        while (j < paramToServiceMsg.size())
                        {
                          localObject1 = (EmosmPb.SmallYellowItem)paramToServiceMsg.get(j);
                          if ((QLog.isColorLevel()) && (localObject1 != null)) {
                            paramObject.append("type = " + ((EmosmPb.SmallYellowItem)localObject1).type.get() + ";id = " + ((EmosmPb.SmallYellowItem)localObject1).id.get() + ";ts =" + ((EmosmPb.SmallYellowItem)localObject1).ts.get());
                          }
                          j += 1;
                        }
                        QLog.d("EmoticonHandler", 2, "commonused systememoji item : " + paramObject.toString());
                      }
                      QLog.d("EmoticonHandler", 1, "commonused back");
                      ((apty)this.app.getManager(172)).a(paramToServiceMsg);
                      break;
                    }
                    QLog.e("EmoticonHandler", 1, "handleCommonUseInfo ItemInfo = null");
                    break;
                    j = paramToServiceMsg.extraData.getInt("tabId");
                    paramToServiceMsg = new apvt();
                    paramToServiceMsg.jdField_a_of_type_Boolean = paramObject.msg_subcmd0x18_rsp.bool_jump_flag.get();
                    paramToServiceMsg.jdField_a_of_type_Int = paramObject.msg_subcmd0x18_rsp.uint32_author_id.get();
                    paramToServiceMsg.a(j);
                  } while (!QLog.isColorLevel());
                  QLog.i("EmoticonHandler", 2, "fetchEmoticonRecommend return " + paramToServiceMsg.toString());
                  break;
                } while (!paramObject.msg_subcmd0x19_rsp.has());
                localObject1 = (EmosmPb.SubCmd0x19Rsp)paramObject.msg_subcmd0x19_rsp.get();
                j = ((EmosmPb.SubCmd0x19Rsp)localObject1).uint32_package_id.get();
                if (QLog.isColorLevel()) {
                  QLog.i("EmoticonHandler", 2, "TYPE_EMOSM_IP_SITE_INFORMATION id = " + j);
                }
                localObject2 = (aufn)this.app.getManager(14);
                localObject3 = ((aufn)localObject2).a(String.valueOf(j), k);
              } while (localObject3 == null);
              ((EmoticonPackage)localObject3).ipUrl = ((EmosmPb.SubCmd0x19Rsp)localObject1).str_ip_url.get();
              ((EmoticonPackage)localObject3).ipName = ((EmosmPb.SubCmd0x19Rsp)localObject1).str_ip_name.get();
              ((EmoticonPackage)localObject3).ipDetail = ((EmosmPb.SubCmd0x19Rsp)localObject1).str_ip_detail.get();
              paramObject = ((EmosmPb.SubCmd0x19Rsp)localObject1).str_op_name.get();
              paramToServiceMsg = paramObject;
              if (TextUtils.isEmpty(paramObject)) {
                paramToServiceMsg = alud.a(2131704478);
              }
              ((EmoticonPackage)localObject3).ipOpName = paramToServiceMsg;
              ((EmoticonPackage)localObject3).ipJumpUrl = ((EmosmPb.SubCmd0x19Rsp)localObject1).str_jump_url.get();
              if (((EmosmPb.SubCmd0x19Rsp)localObject1).fixed32_time.get() == 0) {}
              for (l = 86400L;; l = ((EmosmPb.SubCmd0x19Rsp)localObject1).fixed32_time.get())
              {
                ((EmoticonPackage)localObject3).ipReqTime = l;
                ((aufn)localObject2).a((EmoticonPackage)localObject3);
                break;
              }
              localEmoticonResp.resultcode = -1;
              if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 异常 subcmd = " + i);
              }
              bool1 = false;
              j = 0;
            }
            n = paramToServiceMsg.extraData.getInt("EmoticonRetry");
            QLog.e("EmoticonHandler", 1, "error can not send cmd: " + i);
            k = m;
            j = i;
            bool2 = bool1;
          } while (paramFromServiceMsg.getResultCode() == 1000);
          k = m;
          j = i;
          bool2 = bool1;
        } while (n >= 2);
        int k = m;
        j = i;
        bool2 = bool1;
      } while (i != 2);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "try index: " + n);
      }
      paramToServiceMsg.extraData.putInt("EmoticonRetry", n + 1);
      super.sendPbReq(paramToServiceMsg);
      return;
      QLog.e("EmoticonHandler", 1, "fetchEmoticonPackages failed: " + paramFromServiceMsg.getResultCode());
      notifyUI(j, bool2, localEmoticonResp);
      return;
      if (j == 3)
      {
        paramFromServiceMsg = (ArrayList)localEmoticonResp.data;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0) && (bool2)) {
          paramFromServiceMsg = paramFromServiceMsg.iterator();
        }
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (Emoticon)paramFromServiceMsg.next();
          paramToServiceMsg.a(paramObject);
          if (QLog.isColorLevel())
          {
            QLog.d("EmoticonHandler", 2, "epId:" + paramObject.epId + ",eId:" + paramObject.eId + ",key:" + paramObject.encryptKey);
            continue;
            QLog.i("EmoticonHandler", 1, "fetch key error:" + localEmoticonResp.resultcode);
          }
        }
        paramToServiceMsg = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (paramToServiceMsg.hasNext()) {
          ((aprv)paramToServiceMsg.next()).a(bool2, j, localEmoticonResp);
        }
      }
      notifyUI(j, bool2, localEmoticonResp);
      return;
      if (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x490_92")) {
        break;
      }
      if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
      {
        i = 1;
        bool1 = true;
        if (i == 0) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            if (paramToServiceMsg.uint32_result.get() != 0) {
              break label4226;
            }
            i = 1;
            if (i != 0)
            {
              paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              l = paramToServiceMsg.getInt();
              if (paramToServiceMsg.get() != 1) {
                break label4232;
              }
              bool1 = true;
              this.app.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_tag_" + this.app.getCurrentAccountUin(), bool1).commit();
            }
            if (QLog.isColorLevel()) {
              QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, needToFetchEmosmList = " + bool1);
            }
            if (!bool1) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, initEmoticon");
            }
            a(0, 0);
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
            return;
          }
          i = 0;
          break label4012;
          i = 0;
          continue;
          bool1 = false;
        }
      }
      i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
      QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_OIDB, error:" + paramFromServiceMsg.getResultCode());
    } while ((paramFromServiceMsg.getResultCode() != 1002) || (i >= 2));
    label1498:
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB try index: " + i);
    }
    label1602:
    label2262:
    label3544:
    paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
    label1683:
    label1820:
    label3782:
    super.sendPbReq(paramToServiceMsg);
    label4012:
    return;
    label4226:
    label4232:
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x5eb_99"))
    {
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break label4924;
      }
      i = 1;
      label4375:
      bool3 = false;
      bool2 = false;
      if (i == 0) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (QLog.isColorLevel())) {
          QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB uint32_result = " + paramToServiceMsg.uint32_result.get());
        }
        bool1 = bool3;
        if (paramToServiceMsg.uint32_result.has())
        {
          bool1 = bool3;
          if (paramToServiceMsg.uint32_result.get() == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            j = paramFromServiceMsg.rpt_msg_uin_data.size();
            if (!QLog.isColorLevel()) {
              break label4905;
            }
            QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB infoNum = " + j);
            break label4905;
            if (i < j)
            {
              if ((((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i)).uint32_vas_emoticon_usage_info.get() & 0x1) != 1) {
                break label4930;
              }
              bool1 = true;
              if (!bool1) {
                break label4915;
              }
              this.app.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_kandian_tag_" + this.app.getCurrentAccountUin(), bool1).commit();
              break label4915;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB, needToFetchEmosmList = " + bool1);
        }
        if (!bool1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB, initEmoticon");
        }
        a(0, 0, 1, 0);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
        return;
      }
      i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
      QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_KANDIAN_OIDB, error:" + paramFromServiceMsg.getResultCode());
      if ((paramFromServiceMsg.getResultCode() != 1002) || (i >= 2)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB try index: " + i);
      }
      paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
      super.sendPbReq(paramToServiceMsg);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("gxzbIpsit.ipsite"))
      {
        a(paramToServiceMsg, paramObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
      label4890:
      paramToServiceMsg = (ToServiceMsg)localObject1;
      break label1602;
      label4896:
      paramToServiceMsg = (ToServiceMsg)localObject2;
      break label1244;
      label4902:
      break label949;
      label4905:
      i = 0;
      bool1 = bool2;
      continue;
      label4915:
      i += 1;
      continue;
      label4924:
      i = 0;
      break label4375;
      label4930:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alrp
 * JD-Core Version:    0.7.0.1
 */