import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import IMMsgBodyPack.PluginNum;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xea.submsgtype0xea.MsgBody;

public class abxc
  extends abvx
{
  private abxq<Long, abzb> a;
  
  public abxc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Abxq = new abxr();
    a();
  }
  
  public static MsgType0x210 a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      MsgType0x210 localMsgType0x210 = new MsgType0x210();
      localMsgType0x210.readFrom(paramArrayOfByte);
      return localMsgType0x210;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    MsgType0x210 localMsgType0x210 = a(paramMsgInfo.vMsg);
    if (b(localMsgType0x210)) {}
    do
    {
      return null;
      if (d(localMsgType0x210))
      {
        a(localMsgType0x210);
        return null;
      }
      if (a(localMsgType0x210)) {
        return a(paramMsgInfo, paramLong, localMsgType0x210);
      }
    } while (!c(localMsgType0x210));
    b(localMsgType0x210);
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    MessageRecord localMessageRecord = null;
    abzb localabzb = (abzb)this.jdField_a_of_type_Abxq.a(Long.valueOf(paramMsgType0x210.uSubMsgType));
    if (localabzb != null) {
      localMessageRecord = localabzb.a(this, paramMsgType0x210, paramLong, paramMsgType0x210.vProtobuf, paramMsgInfo);
    }
    return localMessageRecord;
  }
  
  @Nullable
  private String a(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent)
  {
    if (!paramMsgBody.bytes_extend_content.has()) {
      paramMsgBody = null;
    }
    String str;
    do
    {
      return paramMsgBody;
      str = paramMsgBody.bytes_extend_content.get().toStringUtf8();
      paramIntent.putExtra("open_chatfragment", true);
      paramIntent.putExtra("uin", str);
      paramIntent.putExtra("param_fromuin", str);
      paramIntent.putExtra("uintype", 1008);
      paramIntent.putExtra("isforceRequestDetail", true);
      paramMsgBody = str;
    } while (!QLog.isColorLevel());
    QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { str }));
    return str;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Abxq.a(Long.valueOf(39L), acah.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(40L), acai.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(63L), acap.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(166L), accd.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(48L), acaj.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(49L), acak.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(53L), acam.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(201L), accs.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(59L), acan.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(61L), acao.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(67L), acaq.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(68L), acar.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(179L), accj.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(228L), acdf.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(38L), acag.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(278L), abzm.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(279L), abzn.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(309L), acac.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(131L), acbm.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(181L), accl.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(190L), accm.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(72L), acas.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(81L), acav.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(74L), acat.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(84L), acaw.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(103L), acba.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(110L), acbd.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(99L), acax.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(102L), acaz.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(195L), acco.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(126L), acbl.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(78L), acau.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(107L), acbc.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(105L), acbb.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(222L), acdd.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(111L), acbe.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(120L), acbi.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(113L), acbf.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(137L), acbq.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(280L), abzo.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(118L), acbh.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(114L), acbg.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(121L), acbj.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(124L), acbk.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(134L), acbo.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(133L), acbn.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(146L), acbu.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(229L), acdg.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(159L), acbz.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(162L), accb.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(141L), acbs.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(135L), acbp.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(138L), acbr.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(139L), acbr.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(144L), acbt.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(149L), acbw.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(150L), acbx.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(206L), accv.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(284L), abzs.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(148L), acbv.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(220L), acdb.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(152L), acby.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(160L), acca.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(164L), accc.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(171L), accg.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(168L), acce.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(170L), accf.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(174L), acch.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(180L), acck.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(177L), acci.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(193L), accn.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(233L), acdi.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(199L), accr.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(197L), accp.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(258L), abze.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(238L), acdk.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(249L), acdn.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(253L), acdp.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(198L), accq.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(203L), acct.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(204L), accu.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(207L), accw.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(208L), accx.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(218L), accz.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(215L), accy.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(254L), acdq.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(221L), acdc.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(219L), acda.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(223L), acde.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(232L), acdh.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(235L), acdj.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(239L), acdl.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(267L), abzi.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(244L), acdm.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(251L), acdo.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(256L), abzc.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(257L), abzd.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(259L), abzf.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(260L), abzg.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(264L), abzh.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(273L), abzj.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(286L), abzt.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(287L), abzu.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(295L), abzz.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(297L), abzz.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(275L), abzk.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(277L), abzl.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(281L), abzp.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(288L), abzv.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(293L), abzx.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(282L), abzq.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(294L), abzy.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(283L), abzr.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(290L), abzw.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(291L), abzw.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(296L), acaa.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(311L), acaa.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(307L), acab.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(310L), acad.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(313L), acaf.class);
    this.jdField_a_of_type_Abxq.a(Long.valueOf(312L), acae.class);
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + paramLong + ", cOp = " + paramInt2 + ", cSubOp = " + paramByte);
    }
    amyp localamyp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getGAudioHandler();
    if (localamyp != null) {}
    switch (paramByte)
    {
    default: 
      return;
    case 0: 
    case 2: 
      localamyp.a(paramLong, true);
      return;
    case 1: 
      localamyp.b(paramLong, false);
      return;
    }
    localamyp.b(paramLong, true);
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + paramLong + ", cOp = " + paramInt2 + ", cSubOp = " + paramByte);
    }
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    HotChatInfo localHotChatInfo = localHotChatManager.a(String.valueOf(paramLong));
    if (paramByte == 3) {
      a(paramByte, paramInt1 + 1 + 4, paramLong, paramString, paramInt2, paramByte, localHotChatManager, localHotChatInfo);
    }
    do
    {
      return;
      if (paramByte == 2)
      {
        a(paramString, localHotChatManager, localHotChatInfo);
        return;
      }
    } while (paramByte != 1);
    a(paramLong);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3, int paramInt4, HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + paramLong + ", cOp = " + paramInt3 + ", cSubOp = " + paramInt4 + ", cSubOp2 = " + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramHotChatInfo == null);
        paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
        amtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692958), true);
        amuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
        ((amtp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
        return;
      } while (paramHotChatInfo == null);
      paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
      amtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692938), true);
      amuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
      ((amtp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
      return;
    } while (paramHotChatInfo == null);
    paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
    amtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692939), true);
    amuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
    ((amtp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
  }
  
  private void a(long paramLong)
  {
    amyp localamyp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getGAudioHandler();
    if (localamyp != null) {
      localamyp.a(paramLong, false);
    }
  }
  
  private void a(MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.stMsgInfo0x24;
    if ((paramMsgType0x210 != null) && (paramMsgType0x210.vPluginNumList != null))
    {
      Object localObject = paramMsgType0x210.vPluginNumList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMsgType0x210 = (bboi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (paramMsgType0x210 != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PluginNum localPluginNum = (PluginNum)((Iterator)localObject).next();
            if (localPluginNum != null)
            {
              long l = localPluginNum.dwID;
              if (localPluginNum.cFlag == 0) {}
              for (boolean bool = false;; bool = true)
              {
                paramMsgType0x210.a(l, bool, localPluginNum.dwNUm);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(anlx paramanlx, submsgtype0xc7.ForwardBody paramForwardBody)
  {
    if ((paramForwardBody.uint32_notify_type.has()) && (paramForwardBody.uint32_notify_type.get() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramForwardBody.uint32_op_type.has());
        switch (paramForwardBody.uint32_op_type.get())
        {
        case 3000: 
        default: 
          return;
        }
      } while (!paramForwardBody.msg_relational_chain_change.has());
      paramForwardBody = (submsgtype0xc7.RelationalChainChange)paramForwardBody.msg_relational_chain_change.get();
      if (paramForwardBody.uint64_appid.get() == 10001L)
      {
        awgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramForwardBody, paramanlx);
        return;
      }
      if (paramForwardBody.uint64_appid.get() == 19999L)
      {
        awha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramForwardBody, paramanlx);
        return;
      }
    } while (paramForwardBody.uint64_appid.get() != 10002L);
    afas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramForwardBody, paramanlx);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus = paramSvcReqPushMsg.wUserActive;
    if ((paramSvcReqPushMsg.wGeneralFlag & 0x20) == 32) {
      bfrf.a(true);
    }
    String str;
    ArrayList localArrayList1;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(paramSvcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(paramSvcReqPushMsg.wGeneralFlag) });
      }
      str = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
      paramToServiceMsg = new ArrayList();
      localArrayList1 = paramSvcReqPushMsg.vMsgInfos;
      if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
        break;
      }
      return;
      bfrf.a(false);
    }
    ArrayList localArrayList2 = new ArrayList();
    long l = paramSvcReqPushMsg.lUin;
    int i = paramSvcReqPushMsg.svrip;
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      abxi localabxi = new abxi(this, paramFromServiceMsg, paramSvcReqPushMsg, str, paramToServiceMsg, localArrayList1, localArrayList2, l, localArrayList3, (MsgInfo)localIterator.next(), false).a();
      if ((!localabxi.a()) && (localabxi.b())) {
        return;
      }
    }
    if (localArrayList3.size() > 0) {
      a(localArrayList3);
    }
    int j = paramFromServiceMsg.getRequestSsoSeq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(l, localArrayList2, i, j, null);
    boolean bool2;
    if (paramToServiceMsg.size() > 0)
    {
      bool2 = amwh.a(paramToServiceMsg);
      i = abwz.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {
        break label371;
      }
    }
    label371:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramFromServiceMsg.addMessage(paramToServiceMsg, String.valueOf(l), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a((int)paramSvcReqPushMsg.uMsgTime);
      a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().b(paramToServiceMsg);
      return;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.analysisOffLineFileMsg(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void a(String paramString, HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo != null)
    {
      paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_LONG_TIME_NOT_SAY);
      amtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692937), false);
      amuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
      ((amtp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(35)).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_LEFT_LONG_TIME_NOT_SAY });
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, 0);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    if (i == 3) {
      a(paramArrayOfByte[5], 5, l, String.valueOf(l), i);
    }
    while (i != 1) {
      return;
    }
    a(paramArrayOfByte[5], 5, l, i);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            String str = "" + localVisitorJoinInfo.uint64_visitor_uin.get();
            if (!str.equalsIgnoreCase((String)localObject))
            {
              if (localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8().equals("")) {}
              for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8() + "、") {
                break;
              }
            }
          }
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.length() > 1) {
            localObject = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (!localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            break label398;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label403;
          }
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692944);
        }
      }
      for (;;)
      {
        anky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label398:
        i = 0;
        break;
        label403:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692962);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692948);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent, int paramInt)
  {
    if (!paramMsgBody.bytes_extend_content.has()) {
      return true;
    }
    paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
    paramIntent.putExtra("extra_pull_active_push_type", paramInt);
    paramIntent.putExtra("extra_pull_active_push_url", paramMsgBody);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
    }
    return false;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = PkgTools.getLongData(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.getLongData(paramArrayOfByte, 5);
      long l3 = PkgTools.getLongData(paramArrayOfByte, 9);
      int i = PkgTools.getHShortData(paramArrayOfByte, 13);
      paramArrayOfByte = PkgTools.getUTFString(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private abxj b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(anls.a(paramInt)).a(anls.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private void b(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xea, [S2C push for ark]");
    }
    for (;;)
    {
      try
      {
        Object localObject = new submsgtype0xea.MsgBody();
        if (a(paramMsgType0x210))
        {
          ((submsgtype0xea.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
          if (((submsgtype0xea.MsgBody)localObject).bytes_title.has())
          {
            paramMsgType0x210 = ((submsgtype0xea.MsgBody)localObject).bytes_title.get().toStringUtf8();
            if (((submsgtype0xea.MsgBody)localObject).bytes_content.has())
            {
              localObject = ((submsgtype0xea.MsgBody)localObject).bytes_content.get().toStringUtf8();
              aowk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, (String)localObject);
              return;
            }
            localObject = "";
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xea], errInfo->" + paramMsgType0x210.getMessage());
      }
      paramMsgType0x210 = "";
    }
  }
  
  private boolean b(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210 == null;
  }
  
  private boolean b(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent, int paramInt)
  {
    if (!paramMsgBody.uint32_action_subType.has()) {
      return true;
    }
    int i = paramMsgBody.uint32_action_subType.get();
    paramIntent.putExtra("extra_pull_active_push_type", paramInt);
    paramIntent.putExtra("extra_pull_active_push_subtype", i);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(i) }));
    }
    return false;
  }
  
  private boolean c(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 234L;
  }
  
  private boolean d(MsgType0x210 paramMsgType0x210)
  {
    return (paramMsgType0x210.uSubMsgType == 36L) && (paramMsgType0x210.stMsgInfo0x24 != null);
  }
  
  public void a(int paramInt)
  {
    ((anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13)).a(paramInt);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        bbjr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
    }
    Object localObject2;
    Intent localIntent;
    int i;
    Object localObject1;
    do
    {
      do
      {
        return;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
      } while (!paramMsgBody.bytes_msg_summary.has());
      localObject2 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(335544320);
      i = paramMsgBody.uint32_action_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject2 }));
      }
      localObject1 = "";
      if (i != 1) {
        break;
      }
    } while (b(paramMsgBody, localIntent, i));
    label475:
    do
    {
      do
      {
        localIntent.putExtra(avng.b, (String)localObject2);
        localIntent.putExtra("activepull_push_flag", true);
        paramMsgBody = avng.jdField_a_of_type_JavaLangString;
        Object localObject3 = bfpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840385);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject2, paramMsgBody, localObject2 });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
        paramMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext();
        if (!bfyg.a(paramMsgBody)) {
          break;
        }
        localObject2 = (avng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(145);
        ((avng)localObject2).a(localIntent);
        localObject3 = (avnj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
        if (SettingCloneUtil.readValue(paramMsgBody, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMsgBody.getString(2131693533), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
          }
          ((avnj)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.PULL_ACTIVE_PUSH_UIN, 9653, false, avnf.a((String)localObject1, 1008, localIntent));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setChangeAndNotify(((avng)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
        return;
        if (i != 2) {
          break label475;
        }
      } while (!a(paramMsgBody, localIntent, i));
      return;
      if (i != 3) {
        break;
      }
      paramMsgBody = a(paramMsgBody, localIntent);
      localObject1 = paramMsgBody;
    } while (paramMsgBody != null);
  }
  
  public void a(byte[] paramArrayOfByte, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7");
    }
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      submsgtype0xc7.MsgBody localMsgBody = new submsgtype0xc7.MsgBody();
      try
      {
        paramArrayOfByte = (submsgtype0xc7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get().iterator();
        while (paramArrayOfByte.hasNext()) {
          a(paramanlx, (submsgtype0xc7.ForwardBody)paramArrayOfByte.next());
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramArrayOfByte) {}
    }
    QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7", paramArrayOfByte);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus == 0);
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  public boolean a(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.vProtobuf != null;
  }
  
  public boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxc
 * JD-Core Version:    0.7.0.1
 */