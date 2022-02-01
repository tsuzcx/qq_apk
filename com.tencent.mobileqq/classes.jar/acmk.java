import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.oidb.cmd0x787.oidb_0x787.MsgNeedField;

class acmk
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bcsd jdField_a_of_type_Bcsd;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private List<im_msg_body.Elem> jdField_a_of_type_JavaUtilList;
  private msg_comm.MsgHead jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public acmk(ArrayList<MessageRecord> paramArrayList, bcsd parambcsd, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = parambcsd;
    this.jdField_a_of_type_Bcsd = paramBoolean;
    this.jdField_a_of_type_Boolean = paramMsgHead;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead = paramLong1;
    this.jdField_a_of_type_Long = ???;
    this.jdField_b_of_type_Long = ???;
    this.jdField_c_of_type_Long = ???;
    Object localObject1;
    this.jdField_d_of_type_Long = localObject1;
    this.jdField_a_of_type_JavaUtilList = paramByte;
    this.jdField_a_of_type_Byte = paramString;
    Object localObject2;
    this.jdField_a_of_type_JavaLangString = localObject2;
  }
  
  private int a(int paramInt, long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    int i = paramInt;
    if (paramResvAttr.uint32_title_id.has())
    {
      int j = paramResvAttr.uint32_title_id.get();
      if (j > 0) {
        paramInt = j;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + j + ", troopUin=" + paramLong + ", sender=" + this.jdField_a_of_type_Long + ", msgTime=" + this.jdField_c_of_type_Long + ", isSaveDb=" + this.jdField_a_of_type_Boolean);
        i = paramInt;
      }
    }
    return i;
  }
  
  private int a(int paramInt, long paramLong, im_msg_body.Elem paramElem)
  {
    int m = 0;
    int i = paramInt;
    Object localObject;
    int j;
    label111:
    int k;
    if (paramElem.general_flags.bytes_pb_reserve.has())
    {
      localObject = new generalflags.ResvAttr();
      ((generalflags.ResvAttr)localObject).mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
      if (((generalflags.ResvAttr)localObject).uint32_rich_card_name_ver.has()) {
        ((generalflags.ResvAttr)localObject).uint32_rich_card_name_ver.get();
      }
      if (!((generalflags.ResvAttr)localObject).uint32_nearby_charm_level.has()) {
        break label465;
      }
      i = ((generalflags.ResvAttr)localObject).uint32_nearby_charm_level.get();
      if (!((generalflags.ResvAttr)localObject).uint32_global_group_level.has()) {
        break label472;
      }
      j = ((generalflags.ResvAttr)localObject).uint32_global_group_level.get();
      if (!((generalflags.ResvAttr)localObject).uint32_vip_type.has()) {
        break label479;
      }
      k = ((generalflags.ResvAttr)localObject).uint32_vip_type.get();
      label132:
      this.jdField_a_of_type_Int = k;
      if (!((generalflags.ResvAttr)localObject).uint32_vip_level.has()) {
        break label485;
      }
      k = ((generalflags.ResvAttr)localObject).uint32_vip_level.get();
      label159:
      this.jdField_b_of_type_Int = VipUtils.c(k);
      if (((generalflags.ResvAttr)localObject).uint32_user_bigclub_flag.has()) {
        this.jdField_c_of_type_Int = ((generalflags.ResvAttr)localObject).uint32_user_bigclub_flag.get();
      }
      if (((generalflags.ResvAttr)localObject).uint32_user_bigclub_level.has()) {
        this.jdField_d_of_type_Int = ((generalflags.ResvAttr)localObject).uint32_user_bigclub_level.get();
      }
      if (((generalflags.ResvAttr)localObject).uint32_nameplate.has()) {
        this.e = ((generalflags.ResvAttr)localObject).uint32_nameplate.get();
      }
      if (((generalflags.ResvAttr)localObject).bytes_user_vip_info.has())
      {
        paramElem = new Dialogue();
        paramElem.mergeFrom(((generalflags.ResvAttr)localObject).bytes_user_vip_info.get().toByteArray());
        k = m;
        if (paramElem.short_nameplate_itemid.has()) {
          k = paramElem.short_nameplate_itemid.get();
        }
        this.f = k;
      }
      a(paramLong, (generalflags.ResvAttr)localObject);
      a((generalflags.ResvAttr)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("kaiyan", 2, "isHideBigClub=" + this.g);
      }
      paramInt = a(paramInt, paramLong, (generalflags.ResvAttr)localObject);
      paramElem = a(paramLong, i, j, (generalflags.ResvAttr)localObject);
      a(this.jdField_a_of_type_Bcsd, paramLong, (generalflags.ResvAttr)localObject, paramElem);
      if (!((generalflags.ResvAttr)localObject).bytes_hudong_mark.has()) {
        break label491;
      }
    }
    label465:
    label472:
    label479:
    label485:
    label491:
    for (paramElem = ((generalflags.ResvAttr)localObject).bytes_hudong_mark.get().toByteArray();; paramElem = null)
    {
      localObject = bfwx.a(paramElem);
      ((bfwu)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), (String)localObject);
      this.h = bgek.a(paramElem);
      i = paramInt;
      return i;
      i = -100;
      break;
      j = -100;
      break label111;
      k = 0;
      break label132;
      k = 0;
      break label159;
    }
  }
  
  private int a(int paramInt, im_msg_body.Elem paramElem)
  {
    if (paramElem.general_flags.uint32_glamour_level.has()) {
      paramInt = paramElem.general_flags.uint32_glamour_level.get();
    }
    return paramInt;
  }
  
  @Nullable
  private TroopManager a(long paramLong, int paramInt1, int paramInt2, generalflags.ResvAttr paramResvAttr)
  {
    int i;
    if ((this.jdField_a_of_type_Bcsd.e == 1) && (paramResvAttr.uint32_group_member_flag_ex2.has()))
    {
      i = paramResvAttr.uint32_group_member_flag_ex2.get();
      aomi.a(this.jdField_a_of_type_Acmh.a, paramLong, i);
    }
    if ((this.jdField_a_of_type_Bcsd.e == 1) && (paramResvAttr.uint32_group_ringtone_id.has()) && (paramResvAttr.uint32_group_ringtone_id.get() > 0))
    {
      i = paramResvAttr.uint32_group_ringtone_id.get();
      aomi.b(this.jdField_a_of_type_Acmh.a, paramLong, i);
    }
    paramResvAttr = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramResvAttr != null) {
      paramResvAttr.a(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), paramInt1, paramInt2);
    }
    return paramResvAttr;
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_b_of_type_Boolean) {
      ((HotChatManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramLong);
    }
  }
  
  private void a(long paramLong, String paramString, TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramTroopInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + paramLong + ", memberUin=" + this.jdField_a_of_type_Long + " troopinfo is null, getGroupInfoReq ");
      }
      paramTroopInfo = new TroopInfo();
      paramTroopInfo.troopuin = paramString;
      paramTroopManager.b(paramTroopInfo);
      ((aoep)this.jdField_a_of_type_Acmh.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).j(paramString);
    }
  }
  
  private void a(long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    Object localObject1;
    Object localObject2;
    if (paramResvAttr.uint32_kings_honor_level.has())
    {
      localObject1 = (bgfx)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_GAME_CARD_MANAGER);
      localObject2 = new MemberGradeLevelInfo();
      ((MemberGradeLevelInfo)localObject2).memberuin = String.valueOf(this.jdField_a_of_type_Long);
      ((MemberGradeLevelInfo)localObject2).gradeLevel = (paramResvAttr.uint32_kings_honor_level.get() * 10000);
      ((bgfx)localObject1).a((MemberGradeLevelInfo)localObject2);
    }
    for (;;)
    {
      if ((paramResvAttr.uint32_group_info_flag_ex4.has()) || (paramResvAttr.bytes_group_msg_busi_buf.has()))
      {
        localObject1 = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramResvAttr.uint32_group_info_flag_ex4.has())
        {
          localObject2 = ((TroopManager)localObject1).c(String.valueOf(paramLong));
          ((TroopInfo)localObject2).groupFlagExt4 |= paramResvAttr.uint32_group_info_flag_ex4.get();
          ((TroopManager)localObject1).b((TroopInfo)localObject2);
        }
        if (paramResvAttr.bytes_group_msg_busi_buf.has()) {
          localObject2 = new oidb_0x787.MsgNeedField();
        }
      }
      try
      {
        ((oidb_0x787.MsgNeedField)localObject2).mergeFrom(paramResvAttr.bytes_group_msg_busi_buf.get().toByteArray());
        if (((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.has()) {
          ((TroopManager)localObject1).b(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), ((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.get());
        }
        return;
      }
      catch (Exception paramResvAttr)
      {
        paramResvAttr.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "kings_honor_level is null");
      }
    }
  }
  
  private void a(long paramLong1, boolean paramBoolean, long paramLong2, im_msg_body.Elem paramElem)
  {
    if (paramBoolean)
    {
      int i = paramElem.extra_info.uint32_flags.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + i + "|groupCode:" + paramLong2 + "fromUin:" + paramLong1);
      }
      if ((i & 0x10) == 16)
      {
        paramElem = ((HotChatManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramLong2 + "");
        String str = paramLong1 + "";
        if ((paramElem != null) && (!paramElem.adminUins.contains(str))) {
          paramElem.adminUins.add(str);
        }
      }
    }
  }
  
  private void a(bcsd parambcsd, long paramLong, generalflags.ResvAttr paramResvAttr, TroopManager paramTroopManager)
  {
    if ((parambcsd.e == 1) && (paramResvAttr.uint32_custom_featureid.has()) && (paramTroopManager != null) && (paramResvAttr.uint32_custom_featureid.get() == 19713))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + paramLong);
      }
      parambcsd = paramTroopManager.b(String.valueOf(paramLong));
      if ((parambcsd != null) && (!parambcsd.isQidianPrivateTroop()))
      {
        parambcsd.setQidianPrivateTroopFlag();
        paramTroopManager.b(parambcsd);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + paramLong);
        }
      }
    }
  }
  
  private void a(bcsd parambcsd, long paramLong, im_msg_body.Elem paramElem)
  {
    boolean bool;
    if ((parambcsd.e == 1) && (paramElem.general_flags.uint64_group_rank_seq.has()))
    {
      parambcsd = String.valueOf(paramLong);
      if ((this.jdField_a_of_type_Acmh.a.mAutomator == null) || (!this.jdField_a_of_type_Acmh.a.mAutomator.c())) {
        break label203;
      }
      bool = true;
      if (!bool) {
        break label209;
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(parambcsd);
      if (localTroopInfo != null)
      {
        paramLong = paramElem.general_flags.uint64_group_rank_seq.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambcsd + ", serverRankSeq=" + paramLong + ", localRankSeq=" + localTroopInfo.dwGroupLevelSeq + ", isSyncMsgFinish=" + bool);
        }
        if (paramLong > localTroopInfo.dwGroupLevelSeq) {
          ((aoep)this.jdField_a_of_type_Acmh.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(parambcsd, false);
        }
      }
    }
    label203:
    label209:
    while (!QLog.isColorLevel())
    {
      TroopInfo localTroopInfo;
      return;
      bool = false;
      break;
    }
    QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambcsd + ", isSyncMsgFinish=" + bool);
  }
  
  private void a(String paramString, bgiy parambgiy)
  {
    if (parambgiy.b(paramString))
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      int k = j - 1;
      if (k >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        j = i;
        if (bgiy.a(localMessageRecord))
        {
          if ((!TextUtils.isEmpty(localMessageRecord.msg)) || (localMessageRecord.msgData != null)) {
            break label89;
          }
          j = i;
        }
        for (;;)
        {
          k -= 1;
          i = j;
          break;
          label89:
          j = i;
          if (i == 0)
          {
            parambgiy.a(paramString, localMessageRecord.uniseq);
            j = 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + paramString + "," + localMessageRecord.uniseq + "," + localMessageRecord.shmsgseq);
          }
          parambgiy.c(paramString);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals(this.jdField_a_of_type_Acmh.a.getCurrentAccountUin())))
    {
      paramString2 = (bgiy)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      if (!paramString2.a(paramString1))
      {
        a(paramString1, paramString2);
        if (this.jdField_a_of_type_Acmh.a.getTroopMask(paramString1) == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + paramString1);
          }
          ((aoep)this.jdField_a_of_type_Acmh.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString1, this.jdField_a_of_type_Acmh.a.getCurrentAccountUin(), 0, 0);
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((MessageRecord)paramArrayList.next()).isOpenTroopMessage = true;
      }
      paramArrayList = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramArrayList != null) && (!paramArrayList.f(paramString)))
      {
        paramArrayList = (aoep)this.jdField_a_of_type_Acmh.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (paramArrayList != null) {
          paramArrayList.f(paramString, false);
        }
      }
    }
  }
  
  private void a(generalflags.ResvAttr paramResvAttr)
  {
    bhjg localbhjg;
    if ((this.jdField_c_of_type_Int != 0) && (paramResvAttr.uint32_nameplate_vip_type.has()) && (paramResvAttr.uint32_gray_name_plate.has()))
    {
      i = paramResvAttr.uint32_nameplate_vip_type.get();
      localbhjg = bhjg.a(i);
      if ((!bhjf.a(i)) || (localbhjg.b())) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 0)
    {
      if ((paramResvAttr.uint32_gray_name_plate.get() != 0) || (i != 0)) {
        this.g = 1;
      }
      if ((this.jdField_c_of_type_Int == 3) && (!localbhjg.c())) {
        this.jdField_c_of_type_Int = 1;
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, double paramDouble, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3, int paramInt5, int paramInt6)
  {
    TroopManager localTroopManager;
    if ((!paramBoolean) || (this.jdField_b_of_type_Boolean))
    {
      if (paramInt1 != -100)
      {
        localTroopManager = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager != null) {
          localTroopManager.a(paramString1, paramString2, paramInt1);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label311;
      }
      localTroopManager = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
      switch (paramInt5)
      {
      default: 
        localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
      }
    }
    for (;;)
    {
      localTroopManager.a(paramString1, paramString2, this.jdField_a_of_type_JavaLangString, paramInt4, this.h);
      return;
      localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
      continue;
      localTroopManager.a(paramString1, paramString2, "", paramInt3, paramString3, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
    }
    label311:
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = new TroopMemberInfo();
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.newRealLevel = this.h;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin = paramString2;
    switch (paramInt5)
    {
    default: 
      paramString1 = bhmb.b(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNick = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.level = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.realLevel = paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.sex = paramByte2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.age = paramByte1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distance = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.msgseq = this.jdField_b_of_type_Long;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
      if (this.jdField_a_of_type_Byte != 1) {
        break;
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString1.isTroopFollowed = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelf = paramDouble;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = "";
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      break;
    }
  }
  
  private boolean a(im_msg_body.Elem paramElem)
  {
    if (QLog.isColorLevel()) {
      if (!((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.has()) {
        break label74;
      }
    }
    label74:
    for (paramElem = ((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.get().toStringUtf8();; paramElem = null)
    {
      QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + paramElem);
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    boolean bool2 = true;
    boolean bool1 = paramBoolean;
    if (paramElem.general_flags.uint32_group_type.has()) {
      switch (paramElem.general_flags.uint32_group_type.get())
      {
      }
    }
    for (;;)
    {
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + paramBoolean + ", isHotChatMsg = " + this.jdField_b_of_type_Boolean);
        bool1 = paramBoolean;
      }
      return bool1;
      if (paramElem.general_flags.uint32_to_uin_flag.has())
      {
        if (paramElem.general_flags.uint32_to_uin_flag.get() == 2) {}
        for (paramBoolean = bool2;; paramBoolean = false) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public acmk a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -100;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.jdField_d_of_type_Int = -100;
    this.e = -100;
    this.f = -100;
    this.g = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = null;
    this.h = 0;
    long l;
    msg_comm.GroupInfo localGroupInfo;
    Object localObject1;
    int i;
    boolean bool2;
    boolean bool1;
    double d1;
    int j;
    Object localObject2;
    boolean bool3;
    int k;
    if ((this.jdField_a_of_type_Bcsd.e == 1) || (this.jdField_a_of_type_Bcsd.e == 1026))
    {
      l = 0L;
      localGroupInfo = (msg_comm.GroupInfo)this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead.group_info.get();
      if (localGroupInfo != null) {
        l = localGroupInfo.group_code.get();
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label715;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i = -100;
      bool2 = false;
      bool1 = false;
      d1 = -100.0D;
      j = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
        if (((im_msg_body.Elem)localObject2).general_flags.has())
        {
          bool3 = a(bool1, (im_msg_body.Elem)localObject2);
          k = a(i, (im_msg_body.Elem)localObject2);
          i = a(j, l, (im_msg_body.Elem)localObject2);
          a(this.jdField_a_of_type_Bcsd, l, (im_msg_body.Elem)localObject2);
          j = k;
          bool1 = bool2;
          bool2 = bool3;
        }
        for (;;)
        {
          k = j;
          bool3 = bool2;
          j = i;
          i = k;
          bool2 = bool1;
          bool1 = bool3;
          break;
          if ((((im_msg_body.Elem)localObject2).extra_info.has()) && (((im_msg_body.Elem)localObject2).extra_info.uint32_flags.has()))
          {
            a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, l, (im_msg_body.Elem)localObject2);
            k = i;
            bool3 = bool1;
            i = j;
            j = k;
            bool1 = bool2;
            bool2 = bool3;
          }
          else if (((im_msg_body.Elem)localObject2).pub_group.has())
          {
            bool2 = a((im_msg_body.Elem)localObject2);
            k = i;
            bool3 = bool1;
            i = j;
            j = k;
            bool1 = bool2;
            bool2 = bool3;
          }
          else
          {
            if ((!((im_msg_body.Elem)localObject2).elem_flags2.has()) || (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_longtitude.has()) || (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_latitude.has())) {
              break label690;
            }
            if (this.jdField_d_of_type_Long == this.jdField_a_of_type_Long) {
              break;
            }
            d1 = -1001.0D;
            k = i;
            bool3 = bool1;
            i = j;
            j = k;
            bool1 = bool2;
            bool2 = bool3;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = String.valueOf(l);
      localObject2 = (TroopManager)this.jdField_a_of_type_Acmh.a.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject3 = ((TroopManager)localObject2).b((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l + ", memberUin=" + this.jdField_a_of_type_Long + "，isHotChatMsg = " + this.jdField_b_of_type_Boolean + ",ti = " + localObject3);
      }
      a(l, (String)localObject1, (TroopManager)localObject2, (TroopInfo)localObject3);
      localObject2 = String.valueOf(this.jdField_a_of_type_Long);
      k = localGroupInfo.group_level.get();
      localObject3 = bhmb.a(localGroupInfo.group_card.get());
      int m = bhmb.a(localGroupInfo.group_card.get().toByteArray());
      int n = localGroupInfo.group_card_type.get();
      a(l);
      a(this.jdField_a_of_type_JavaUtilArrayList, bool1, (String)localObject1);
      a(bool2, i, (byte)0, (byte)1, 100, d1, j, (String)localObject1, (String)localObject2, k, (String)localObject3, n, m);
      a((String)localObject1, (String)localObject2);
      return this;
      label690:
      k = i;
      bool3 = bool1;
      i = j;
      j = k;
      bool1 = bool2;
      bool2 = bool3;
      break;
      label715:
      j = -1;
      d1 = -100.0D;
      i = -100;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public TroopMemberInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmk
 * JD-Core Version:    0.7.0.1
 */