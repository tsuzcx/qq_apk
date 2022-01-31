import ActionMsg.MsgBody;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.BaseMessageManager.1;
import com.tencent.mobileqq.app.message.BaseMessageManager.2;
import com.tencent.mobileqq.app.message.BaseMessageManager.3;
import com.tencent.mobileqq.app.message.BaseMessageManager.4;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.revokemsg.RevokeMsgInfo;>;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import localpb.richMsg.RichMsg.FoldMsg;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public abstract class akok
  extends Observable
  implements akpq
{
  public QQAppInterface a;
  public QQMessageFacade a;
  private Object a;
  private Object b = new Object();
  
  public akok(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    Object localObject2;
    if (akpy.a(paramInt) == 1009)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(ajsf.w, 1009);
      localObject2 = "";
    }
    for (;;)
    {
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (paramString.equals(localMessageRecord.senderuin))
            {
              return localMessageRecord.uniseq;
              if (akpy.a(paramInt) == 1001)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(ajsf.H, 1001);
                localObject2 = ajsf.aj;
                continue;
              }
              if (akpy.a(paramInt) == 1010)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(ajsf.ab, 1010);
                localObject2 = ajsf.ak;
                continue;
              }
              if (akpy.a(paramInt) != 10002) {
                break label361;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(ajsf.H, 10002);
              localObject2 = ajsf.aj;
              continue;
            }
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((!ajsf.aj.equals(localMessageRecord.senderuin)) && (!ajsf.ak.equals(localMessageRecord.senderuin)))) {
              break label358;
            }
            i = 1;
          }
        }
      }
      label358:
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject2, akpy.a(paramInt));
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if (paramString.equals(((MessageRecord)localObject2).senderuin)) {
                return ((MessageRecord)localObject2).uniseq;
              }
            }
          }
        }
        return 0L;
      }
      label361:
      localObject2 = "";
    }
  }
  
  private aquz a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MessageForUniteGrayTip paramMessageForUniteGrayTip, long paramLong)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).d(paramString3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt(bbcl.jdField_a_of_type_JavaLangString, bbcl.jdField_b_of_type_Int);
      ((Bundle)localObject2).putLong(bbcl.jdField_b_of_type_JavaLangString, paramMessageForUniteGrayTip.uniseq);
      localObject2 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, (String)localObject1, true, (Bundle)localObject2);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 1, 0);
      }
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697944);
      int i = paramString1.length() + ((String)localObject2).length();
      int j = i + ((String)localObject1).length();
      paramString1 = paramString1 + (String)localObject2 + (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697945);
      paramString3 = new aquz(paramString3, paramString4, paramString1, paramInt, -5040, 1, paramLong);
      paramString4 = new Bundle();
      paramString4.putInt(bbcl.jdField_a_of_type_JavaLangString, bbcl.jdField_b_of_type_Int);
      paramString4.putLong(bbcl.jdField_b_of_type_JavaLangString, paramMessageForUniteGrayTip.uniseq);
      paramString4.putInt("key_action", 28);
      paramString4.putString("troop_mem_uin", String.valueOf(paramString2));
      paramString4.putBoolean("need_update_nick", true);
      paramString3.a(i, j, paramString4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke message wording", paramString1, Integer.valueOf(i), " end:", Integer.valueOf(j) });
      }
      return paramString3;
      if (paramInt == 3000) {
        localObject1 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 2, 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, akom> paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramQQAppInterface = (agvz)paramQQAppInterface.getManager(125);
    paramQQAppInterface.a(false);
    if (paramQQAppInterface.h.isEmpty()) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      akom localakom1 = (akom)localEntry.getValue();
      if (localakom1.jdField_b_of_type_Boolean)
      {
        String str = (String)paramQQAppInterface.h.get(localEntry.getKey());
        if ((!TextUtils.isEmpty(str)) && (paramHashMap.containsKey(str)))
        {
          akom localakom2 = (akom)paramHashMap.get(str);
          localHashSet.add(str);
          localakom1.jdField_a_of_type_Int += localakom2.jdField_a_of_type_Int;
          localakom1.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(localakom2.jdField_a_of_type_JavaUtilLinkedHashSet);
          if ((localakom1.jdField_a_of_type_Boolean) || (localakom2.jdField_a_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            localakom1.jdField_a_of_type_Boolean = bool;
            if (localakom1.jdField_b_of_type_Long < localakom2.jdField_b_of_type_Long)
            {
              localakom1.jdField_b_of_type_Long = localakom2.jdField_b_of_type_Long;
              localakom1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localakom2.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
              localakom1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            }
            if (localakom1.jdField_a_of_type_Long <= localakom2.jdField_a_of_type_Long) {
              break;
            }
            localakom1.jdField_a_of_type_Long = localakom2.jdField_a_of_type_Long;
            localakom1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localakom2.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            localakom1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            break;
          }
        }
      }
    }
    paramHashMap.keySet().removeAll(localHashSet);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (bbjv.a()) && (paramList1 != null) && (paramList1.size() > 0))
    {
      localObject1 = new StringBuilder(paramList1.size() * 48 + 64);
      ((StringBuilder)localObject1).append("BaseMessageManager mergeFoldMsgGrayTips(),searchList size=").append(paramList1.size()).append(":");
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
    }
    agvz localagvz = (agvz)paramQQAppInterface.getManager(125);
    Object localObject4 = new HashMap();
    Object localObject5 = paramList1.iterator();
    label533:
    label535:
    label955:
    label961:
    label965:
    for (;;)
    {
      label208:
      MessageForFoldMsg localMessageForFoldMsg;
      boolean bool;
      if (((Iterator)localObject5).hasNext())
      {
        localObject1 = (MessageRecord)((Iterator)localObject5).next();
        if (!(localObject1 instanceof MessageForFoldMsg)) {
          continue;
        }
        localMessageForFoldMsg = (MessageForFoldMsg)localObject1;
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          localagvz.a(true, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex);
        }
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) || (TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          break label961;
        }
        if (localagvz.g.containsKey(localMessageForFoldMsg.redBagId))
        {
          localMessageForFoldMsg.redBagIndex = ((String)localagvz.g.get(localMessageForFoldMsg.redBagId));
          bool = true;
        }
      }
      for (;;)
      {
        label345:
        if (((!paramBoolean1) && (localagvz.a(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex))) || ((localMessageForFoldMsg.isSend()) && (!localMessageForFoldMsg.foldFlag) && (localMessageForFoldMsg.msgtype == -2006))) {
          break label965;
        }
        if (bool) {}
        for (localObject1 = localMessageForFoldMsg.redBagIndex;; localObject1 = localMessageForFoldMsg.redBagId)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label533;
          }
          localObject3 = (akom)((HashMap)localObject4).get(localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new akom();
            ((HashMap)localObject4).put(localObject1, localObject2);
          }
          ((akom)localObject2).jdField_b_of_type_Boolean = bool;
          if (localMessageForFoldMsg.foldFlag) {
            break label535;
          }
          ((akom)localObject2).jdField_a_of_type_Boolean = true;
          if (localMessageForFoldMsg.shmsgseq <= ((akom)localObject2).jdField_b_of_type_Long) {
            break;
          }
          ((akom)localObject2).jdField_b_of_type_Long = localMessageForFoldMsg.shmsgseq;
          ((akom)localObject2).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
          break;
          bool = false;
          break label345;
        }
        break label208;
        ((akom)localObject2).jdField_a_of_type_Int += 1;
        ((akom)localObject2).jdField_a_of_type_JavaUtilLinkedHashSet.add(localMessageForFoldMsg.senderuin);
        if (localMessageForFoldMsg.shmsgseq >= ((akom)localObject2).jdField_a_of_type_Long) {
          break label208;
        }
        ((akom)localObject2).jdField_a_of_type_Long = localMessageForFoldMsg.shmsgseq;
        ((akom)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
        break label208;
        if (((HashMap)localObject4).isEmpty()) {
          break;
        }
        a(paramQQAppInterface, (HashMap)localObject4);
        localObject2 = ((HashMap)localObject4).entrySet().iterator();
        label621:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (akom)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (((akom)localObject3).jdField_a_of_type_Int > 0)
          {
            if (((akom)localObject3).jdField_a_of_type_Boolean) {
              ((akom)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = ((akom)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            }
            if (paramList2 != null) {
              break label955;
            }
          }
        }
        for (localObject1 = (List)akpu.a(paramQQAppInterface.getAccount()).b().get(akpy.a(((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop));; localObject1 = paramList2)
        {
          if (localObject1 == null)
          {
            QLog.e("Q.msg.BaseMessageManager", 1, "mergeFoldMsgGrayTips null aioList");
            return;
          }
          localObject1 = localagvz.a((List)localObject1, ((akom)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg, ((akom)localObject3).jdField_a_of_type_JavaUtilLinkedHashSet, ((akom)localObject3).jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
          if ((localObject1 == null) || (paramList2 != null)) {
            break label621;
          }
          if ((QLog.isColorLevel()) && (bbjv.a()) && (paramList2 != null) && (paramList2.size() > 0))
          {
            localObject3 = new StringBuilder(paramList2.size() * 48 + 32);
            ((StringBuilder)localObject3).append("insert to clone list,addlist size=").append(paramList2.size()).append(":");
            localObject4 = paramList2.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MessageRecord)((Iterator)localObject4).next();
              ((StringBuilder)localObject3).append("(").append(((MessageRecord)localObject5).time).append(",").append(((MessageRecord)localObject5).shmsgseq).append(",").append(((MessageRecord)localObject5).msgtype).append(") ");
            }
            QLog.d("msgFold", 2, ((StringBuilder)localObject3).toString());
          }
          akpy.c(paramList1, (MessageRecord)localObject1, true);
          break label621;
          break;
        }
        bool = true;
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new BaseMessageManager.4(this, paramMessageRecord, l));
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (akpc.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (!akpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (ajsf.H.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(ajsf.w)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(ajsf.ab)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else if (paramInt == 10)
      {
        if (((paramConversationInfo.type == 0) || (paramConversationInfo.type == 1) || (paramConversationInfo.type == 3000)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (!akpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return akpc.a(paramConversationInfo);
        }
      }
      else {
        return akpc.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, akpy.a(paramInt))))
      {
        if (akpy.a(paramInt) != 1009) {
          break label332;
        }
        a(ajsf.w, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.w, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((RecentUser)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(akpy.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
      break;
      label332:
      if (akpy.a(paramInt) == 1001)
      {
        a(ajsf.H, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.H, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (akpy.a(paramInt) == 1010)
      {
        a(ajsf.ab, 1010, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ab, 1010);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (akpy.a(paramInt) == 10002)
      {
        a(ajsf.H, 10002, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.H, 10002);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (akpy.a(paramInt) == 1044)
      {
        a(ajsf.aT, 1044, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.aT, 1044);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, aukn paramaukn)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    if (akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt))
    {
      QLog.e("MsgInvalidTypeErr", 1, "find invalid refreshSingleLastMsg" + paramString);
      akpt.b(paramString);
    }
    String str = akpy.a(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(ajsf.z))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      if (paramString.equals(String.valueOf(ajsf.A))) {
        localObject1 = DataLineMsgRecord.tableName(1);
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject1, paramaukn);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!akpy.c(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject3, paramaukn);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramaukn);
          localObject1 = paramaukn;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramaukn);
            localObject1 = paramaukn;
          }
        }
      }
      if (localObject1 != null)
      {
        if (((paramString.equals(String.valueOf(ajsf.z))) || (paramString.equals(String.valueOf(ajsf.A)))) && (((QQMessageFacade.Message)localObject1).msgData != null))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        if ((ajsf.H.equals(((QQMessageFacade.Message)localObject1).frienduin)) || ((akpy.a(((QQMessageFacade.Message)localObject1).istroop) != 1001) && (akpy.a(((QQMessageFacade.Message)localObject1).istroop) != 10002)))
        {
          paramString = (String)localObject1;
          if (!ajsf.ab.equals(((QQMessageFacade.Message)localObject1).frienduin))
          {
            paramString = (String)localObject1;
            if (akpy.a(((QQMessageFacade.Message)localObject1).istroop) != 1010) {}
          }
        }
        else
        {
          paramaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramString = (String)localObject1;
          if (paramaukn != null)
          {
            paramString = (String)localObject1;
            if (paramaukn.size() > 0)
            {
              paramaukn = paramaukn.iterator();
              do
              {
                paramString = (String)localObject1;
                if (!paramaukn.hasNext()) {
                  break;
                }
                paramString = (MessageRecord)paramaukn.next();
              } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)) || (axas.a(paramString.msgtype)));
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramaukn = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
        if (paramaukn != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
        paramaukn = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramaukn = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramaukn = paramString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramString = paramaukn;
      if (paramaukn == null) {
        break;
      }
      paramString = paramaukn;
      if (!akpy.a(paramaukn.frienduin, paramaukn.istroop)) {
        break;
      }
      paramaukn.istroop = akpy.a(paramaukn.istroop);
      return paramaukn;
      paramaukn = new QQMessageFacade.Message();
      paramaukn.frienduin = paramString;
      paramaukn.istroop = paramInt;
      paramString = paramaukn;
      continue;
      if (a(paramaukn) < a(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else if ((!paramaukn.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramaukn.isCacheValid = true;
        paramString = paramaukn;
        continue;
        paramaukn = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramaukn = localThrowable;
        }
      }
    }
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt1, aukn paramaukn, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramaukn, paramInt2);
    }
    return a(paramString, paramInt1, paramaukn);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramLong >= 0L) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    }
    while (localObject1 == null)
    {
      return new ArrayList();
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, true, true);
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramInt2, true);
      }
    }
    if (akrz.jdField_a_of_type_Boolean) {
      akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().addCacheOpWeight(akpy.a(paramString, paramInt1), akrz.k);
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    if (agvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject2, null, false, true);
    }
    akpy.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    akpy.a(paramString, paramInt1, (List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!((List)localObject2).isEmpty()) && ((((List)localObject2).get(((List)localObject2).size() - 1) instanceof MessageForLongMsg)) && (akpy.a((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt1, (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject1, true, 3);
        b(paramString, paramInt1, (MessageRecord)localObject1, 3);
      }
    }
    Object localObject3;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    label482:
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject2 != null)
      {
        localObject1 = Integer.valueOf(((List)localObject2).size());
        QLog.d("Q.msg.BaseMessageManager", 2, localObject1);
      }
    }
    else
    {
      localObject3 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      Iterator localIterator = ((List)localObject2).iterator();
      if (!localIterator.hasNext()) {
        break label1161;
      }
      localObject1 = (MessageRecord)localIterator.next();
      if (!(localObject1 instanceof MessageForArkApp)) {
        break label1448;
      }
      localObject2 = aluc.a().a();
      if ((localObject2 == null) || (((MessageRecord)localObject1).uniseq != ((MessageForArkApp)localObject2).uniseq)) {
        break label1448;
      }
      localObject4 = aluc.a().a();
      if (localObject4 != null)
      {
        ((MessageForArkApp)localObject2).arkContainer = ((adlk)localObject4);
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "refill ark msg: " + ((MessageForArkApp)localObject2).uniseq + " ark c=" + ((MessageForArkApp)localObject2).arkContainer);
      }
    }
    label1161:
    label1426:
    label1434:
    label1443:
    label1448:
    for (;;)
    {
      for (;;)
      {
        if ((localObject1 instanceof ChatMessage))
        {
          ((List)localObject3).add((ChatMessage)localObject1);
          localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("sens_msg_ctrl_info");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label885;
          }
          if (!((MessageRecord)localObject1).isSend()) {
            break label723;
          }
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
          break label482;
          localObject1 = "clone is null";
          break;
        }
        QLog.e("MsgInvalidTypeErr", 1, "err msg" + ((MessageRecord)localObject1).getBaseInfoString());
        akpt.a((MessageRecord)localObject1);
        break label482;
        label723:
        localObject4 = new bankcode_info.BankcodeCtrlInfo();
        try
        {
          ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.hexStr2Bytes((String)localObject2));
          paramInt2 = 0;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has()) {
            paramInt2 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
          }
          if (paramInt2 != 1) {
            break label482;
          }
          ((ChatMessage)localObject1).parse();
          localObject2 = axaq.a(-1014);
          ((MessageRecord)localObject2).msgtype = -1046;
          ((MessageRecord)localObject2).senderuin = ((MessageRecord)localObject2).selfuin;
          ((MessageRecord)localObject2).frienduin = paramString;
          ((MessageRecord)localObject2).istroop = ((MessageRecord)localObject1).istroop;
          ((MessageRecord)localObject2).msg = "";
          ((MessageRecord)localObject2).isread = true;
          ((MessageRecord)localObject2).shmsgseq = ((MessageRecord)localObject1).shmsgseq;
          ((MessageRecord)localObject2).time = ((MessageRecord)localObject1).time;
          ((MessageRecord)localObject2).saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(((MessageRecord)localObject1).uniseq));
          ((List)localObject3).add((ChatMessage)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label885:
            String str;
            localException.printStackTrace();
          }
        }
      }
      if ((paramInt1 == 1008) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject4 = ((MessageRecord)localObject1).getExtInfoFromExtStr("pa_phone_msg_tip");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject2).optContent = ((String)localObject4);
          ((bamj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81)).a((TroopTipsEntity)localObject2);
          localObject4 = new MessageForGrayTips();
          paramLong = ((MessageRecord)localObject1).time;
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((MessageForGrayTips)localObject4).init(str, paramString, str, ((TroopTipsEntity)localObject2).optContent, paramLong, -1048, paramInt1, paramLong);
          ((MessageForGrayTips)localObject4).isread = true;
          bamj.a((MessageForGrayTips)localObject4, ((TroopTipsEntity)localObject2).highlightItems);
          ((List)localObject3).add(localObject4);
        }
      }
      if (paramBoolean) {
        break label482;
      }
      if ((paramInt1 == 0) && ((localObject1 instanceof MessageForPoke)))
      {
        localObject2 = (MessageForPoke)localObject1;
        if (!((MessageForPoke)localObject2).isSend()) {
          localArrayList2.add(localObject2);
        }
        if ((((MessageForPoke)localObject2).interactType == 126) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          break label482;
        }
        if ((((MessageForPoke)localObject2).isread) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          ((MessageForPoke)localObject2).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if ((paramInt1 != 0) || (!(localObject1 instanceof MessageForPokeEmo))) {
        break label482;
      }
      localArrayList1.add((MessageForPokeEmo)localObject1);
      break label482;
      if (!paramBoolean)
      {
        paramInt2 = localArrayList2.size();
        if (paramInt2 <= 1) {
          break label1443;
        }
        paramString = (MessageForPoke)localArrayList2.get(paramInt2 - 1);
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          localObject1 = (MessageForPoke)localArrayList2.get(paramInt1);
          if ((localObject1 != null) && (!((MessageForPoke)localObject1).isPlayed) && (!((MessageForPoke)localObject1).isSend())) {
            ((MessageForPoke)localObject1).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        paramInt2 = localArrayList1.size();
        if (paramInt2 > 1) {}
        for (localObject1 = (MessageForPokeEmo)localArrayList1.get(paramInt2 - 1);; localObject1 = null)
        {
          paramInt1 = 0;
          if ((paramString != null) && (localObject1 != null))
          {
            if (paramString.time < ((MessageForPokeEmo)localObject1).time)
            {
              paramString.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramInt1 = 1;
            }
            if ((paramString != null) && (paramString.isread) && (!paramString.isPlayed)) {
              paramString.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if ((localObject1 == null) || (paramInt1 == 0)) {
              break label1434;
            }
            if (paramInt2 - 3 >= 0) {
              break label1426;
            }
          }
          for (paramInt1 = 0;; paramInt1 = paramInt2 - 3)
          {
            if (paramInt2 <= 3) {
              break label1434;
            }
            paramInt2 -= 1;
            while (paramInt2 >= paramInt1)
            {
              paramString = (MessageForPokeEmo)localArrayList1.get(paramInt2);
              if (!paramString.isread) {
                paramString.setIsNeedPlayed(true);
              }
              paramInt2 -= 1;
            }
            if (paramString != null) {
              break;
            }
            paramInt1 = 1;
            break;
          }
          return localObject3;
        }
        paramString = null;
      }
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList, String paramString, int paramInt, ArrayList<RevokeMsgInfo> paramArrayList)
  {
    if ((paramInt == 3000) || (paramInt == 1)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((paramInt != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long))
          {
            if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!akpy.a(localMessageRecord))) {
              paramString.add(localMessageRecord);
            }
          }
          else if ((paramInt == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long) && (localMessageRecord.msgUid == localRevokeMsgInfo.jdField_b_of_type_Long)) {
            paramString.add(localMessageRecord);
          }
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    synchronized (this.b)
    {
      try
      {
        this.b.wait(15000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
          }
        }
      }
    }
  }
  
  public void a(akqs paramakqs)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramakqs.i)
      {
        paramakqs.i = false;
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(akqs paramakqs, int paramInt)
  {
    if ((paramakqs.jdField_a_of_type_JavaUtilList != null) && (paramakqs.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      do
      {
        synchronized (paramakqs.jdField_a_of_type_JavaUtilList)
        {
          akpy.a(paramakqs.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramakqs.jdField_a_of_type_JavaUtilList.size() > 0) {
            akpy.a(paramakqs.jdField_a_of_type_JavaLangString, paramakqs.jdField_d_of_type_Int, paramakqs.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          ??? = paramakqs.jdField_a_of_type_JavaLangString;
          int j = paramakqs.e;
          if ((paramakqs.jdField_d_of_type_Boolean) && (i != 0) && (paramakqs.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramakqs.jdField_a_of_type_Int < 9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramakqs.jdField_a_of_type_Int + " ]");
            }
            paramakqs.jdField_a_of_type_Int += 1;
            b((String)???, paramInt, j, paramakqs);
            return;
          }
        }
        paramakqs.jdField_a_of_type_Int = 0;
        paramakqs.jdField_b_of_type_Int = 0;
      } while (!paramakqs.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqs);
      return;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    a(paramMessage, false);
  }
  
  public void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    label324:
    label840:
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
                            for (;;)
                            {
                              return;
                              if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && ((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002))) {}
                              for (;;)
                              {
                                try
                                {
                                  paramMessage.msg = bbbg.a(paramMessage.msg).msg;
                                  if (paramMessage.msgtype != -2018) {
                                    if (paramMessage.msgtype != -2050) {
                                      break label324;
                                    }
                                  }
                                }
                                catch (Exception paramMessage)
                                {
                                  for (;;)
                                  {
                                    Object localObject1;
                                    try
                                    {
                                      localObject1 = new structmsg.StructMsg();
                                      ((structmsg.StructMsg)localObject1).mergeFrom(paramMessage.msgData);
                                      paramMessage.msg = MessageForSystemMsg.getSysMsgDesc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), (structmsg.StructMsg)localObject1);
                                      if ((!bbbg.a(paramMessage.msgtype)) && (paramMessage.msgtype != -3001) && (paramMessage.msgtype != -30002)) {
                                        if (paramMessage.msgtype != -30003) {
                                          continue;
                                        }
                                      }
                                    }
                                    catch (Exception paramMessage)
                                    {
                                      throw paramMessage;
                                    }
                                    try
                                    {
                                      localObject1 = bbbg.a(paramMessage.msg);
                                      paramMessage.msg = ((MsgBody)localObject1).msg;
                                      paramMessage.action = ((MsgBody)localObject1).action;
                                      paramMessage.shareAppID = ((MsgBody)localObject1).shareAppID;
                                      paramMessage.actMsgContentValue = ((MsgBody)localObject1).actMsgContentValue;
                                      localObject1 = null;
                                      if ((!ajsf.J.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
                                        localObject1 = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
                                      }
                                      if (!paramBoolean) {
                                        break label832;
                                      }
                                      c(paramMessage);
                                      if (localObject1 == null) {
                                        break label840;
                                      }
                                      paramMessage.msg = ((SystemMsg)localObject1).message;
                                      if (!QLog.isDevelopLevel()) {
                                        break;
                                      }
                                      QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
                                      return;
                                    }
                                    catch (Exception paramMessage)
                                    {
                                      AbsStructMsg localAbsStructMsg;
                                      UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg;
                                      throw paramMessage;
                                    }
                                  }
                                  paramMessage = paramMessage;
                                  throw paramMessage;
                                }
                                if (paramMessage.msgtype == -2011)
                                {
                                  localAbsStructMsg = axuy.a(paramMessage.msgData);
                                  localObject1 = "";
                                  if (localAbsStructMsg != null) {
                                    localObject1 = localAbsStructMsg.mMsgBrief;
                                  }
                                  paramMessage.msg = ((String)localObject1);
                                }
                                else if (paramMessage.msgtype == -5003)
                                {
                                  localObject1 = new SubMsgType0x76.MsgBody();
                                  ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramMessage.msgData);
                                  paramMessage.msg = akjw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
                                }
                                else if (paramMessage.msgtype == -1000)
                                {
                                  if ((paramMessage.getExtInfoFromExtStr("redbag_fold_msg").equals("true")) && (paramMessage.msgData != null))
                                  {
                                    localObject1 = new RichMsg.FoldMsg();
                                    try
                                    {
                                      ((RichMsg.FoldMsg)localObject1).mergeFrom(paramMessage.msgData);
                                      paramMessage.msg = ((RichMsg.FoldMsg)localObject1).msg_content.get().toStringUtf8();
                                    }
                                    catch (Exception localException1)
                                    {
                                      localException1.printStackTrace();
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.e("msgFold", 2, "MessageForFoldMsg decodeMsg error， " + localException1.getMessage());
                                    }
                                  }
                                }
                                else if (paramMessage.msgtype == -5012)
                                {
                                  if (paramMessage.msgData != null) {
                                    try
                                    {
                                      paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
                                    }
                                    catch (JSONException localJSONException1)
                                    {
                                      localJSONException1.printStackTrace();
                                    }
                                  }
                                }
                                else if (paramMessage.msgtype == -5018)
                                {
                                  if (paramMessage.msgData != null) {
                                    try
                                    {
                                      paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
                                    }
                                    catch (JSONException localJSONException2)
                                    {
                                      localJSONException2.printStackTrace();
                                    }
                                  }
                                }
                                else if (akpy.i(paramMessage.msgtype))
                                {
                                  if (paramMessage.msgData != null)
                                  {
                                    localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
                                    try
                                    {
                                      localUniteGrayTipMsg.mergeFrom(paramMessage.msgData);
                                      paramMessage.msg = localUniteGrayTipMsg.content.get();
                                      if ((!localUniteGrayTipMsg.graytip_id.has()) || (!asxk.b(localUniteGrayTipMsg.graytip_id.get()))) {
                                        continue;
                                      }
                                      paramMessage.emoRecentMsg = asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage.msg);
                                    }
                                    catch (Exception localException2)
                                    {
                                      localException2.printStackTrace();
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.e(aqva.jdField_a_of_type_JavaLangString, 2, "MessageForUniteGrayTip, docodeMsg failed, " + localException2.getMessage());
                                    }
                                  }
                                  else if (QLog.isColorLevel())
                                  {
                                    QLog.e(aqva.jdField_a_of_type_JavaLangString, 2, "MessageForUniteGrayTip, docodeMsg msgData == null, msg: " + paramMessage.msg);
                                    continue;
                                    b(paramMessage);
                                  }
                                }
                              }
                              Object localObject2;
                              if (paramMessage.msgtype == -2007) {
                                try
                                {
                                  MarkFaceMessage localMarkFaceMessage = (MarkFaceMessage)akwb.a(paramMessage.msgData);
                                  if ((localMarkFaceMessage != null) && (!TextUtils.isEmpty(localMarkFaceMessage.faceName)))
                                  {
                                    paramMessage.msg = ("[" + localMarkFaceMessage.faceName + "]");
                                    return;
                                  }
                                }
                                catch (Exception localException3)
                                {
                                  for (;;)
                                  {
                                    QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", localException3);
                                    localObject2 = null;
                                  }
                                  paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692043);
                                  return;
                                }
                              }
                              if (paramMessage.msgtype == -2058)
                              {
                                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719771);
                                return;
                              }
                              if (paramMessage.msgtype == -1035)
                              {
                                localObject2 = new MessageForMixedMsg();
                                ((MessageForMixedMsg)localObject2).frienduin = paramMessage.frienduin;
                                ((MessageForMixedMsg)localObject2).msgData = paramMessage.msgData;
                                ((MessageForMixedMsg)localObject2).extStr = paramMessage.extStr;
                                ((MessageForMixedMsg)localObject2).extLong |= 0x1;
                                ((MessageForMixedMsg)localObject2).parse();
                                paramMessage.msg = ((MessageForMixedMsg)localObject2).msg;
                                paramMessage.msg2 = ((MessageForMixedMsg)localObject2).msg2;
                                if ((paramMessage.msg2 != null) && (!"".equals(paramMessage.msg2)))
                                {
                                  paramMessage.emoRecentMsg = new ayki(paramMessage.msg2, 3, 16);
                                  return;
                                }
                                if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
                                  paramMessage.emoRecentMsg = new ayki(paramMessage.msg, 3, 16);
                                }
                              }
                              else if ((paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001))
                              {
                                localObject2 = new MessageForNewGrayTips();
                                ((MessageForNewGrayTips)localObject2).msgData = paramMessage.msgData;
                                ((MessageForNewGrayTips)localObject2).parse();
                                paramMessage.msg = ((MessageForNewGrayTips)localObject2).msg;
                                if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
                                  paramMessage.emoRecentMsg = new ayki(paramMessage.msg, 3, 16);
                                }
                              }
                              else if ((paramMessage.msgtype == -4500) || (paramMessage.msgtype == -4502) || (paramMessage.msgtype == -4503) || (paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4509))
                              {
                                if (paramMessage.msgData != null)
                                {
                                  localObject2 = null;
                                  switch (paramMessage.msgtype)
                                  {
                                  }
                                  while (localObject2 != null)
                                  {
                                    ((ChatMessage)localObject2).msgData = paramMessage.msgData;
                                    ((ChatMessage)localObject2).parse();
                                    paramMessage.msg = ((ChatMessage)localObject2).msg;
                                    if (paramMessage.msgtype != -4501) {
                                      break label1471;
                                    }
                                    paramMessage.msg = ((MessageForDevPtt)localObject2).getSummary();
                                    return;
                                    localObject2 = new MessageForDeviceFile();
                                    continue;
                                    localObject2 = new MessageForDeviceSingleStruct();
                                    continue;
                                    localObject2 = new MessageForDevPtt();
                                    continue;
                                    localObject2 = new MessageForDevShortVideo();
                                    continue;
                                    localObject2 = new MessageForDevLittleVideo();
                                    continue;
                                    localObject2 = new MessageForNewGrayTips();
                                  }
                                  continue;
                                  if (paramMessage.msgtype == -4503)
                                  {
                                    paramMessage.msg = ((MessageForDevShortVideo)localObject2).getSummary();
                                    return;
                                  }
                                  if (paramMessage.msgtype == -4509) {
                                    paramMessage.msg = ((MessageForDevLittleVideo)localObject2).getSummary();
                                  }
                                }
                              }
                              else if (paramMessage.msgtype != -2011)
                              {
                                if ((paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004))
                                {
                                  if (paramMessage.msgtype == -3006)
                                  {
                                    paramMessage.msg = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
                                    if (paramMessage.istroop == 1) {
                                      paramMessage.nickName = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
                                    }
                                  }
                                  else
                                  {
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694950);
                                  }
                                }
                                else if (paramMessage.msgtype == -2010)
                                {
                                  localObject2 = new FunnyFaceMessage();
                                  try
                                  {
                                    ((FunnyFaceMessage)localObject2).readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
                                    if (localObject2 == null) {
                                      continue;
                                    }
                                    if (((FunnyFaceMessage)localObject2).faceId == 1)
                                    {
                                      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694115);
                                      return;
                                    }
                                  }
                                  catch (Exception localException4)
                                  {
                                    for (;;)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.e("Q.msg.BaseMessageManager", 2, localException4.toString());
                                      }
                                      localObject3 = null;
                                    }
                                  }
                                  if (((FunnyFaceMessage)localObject3).faceId == 2) {
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694116);
                                  }
                                }
                                else
                                {
                                  if (paramMessage.msgtype == -2000)
                                  {
                                    localObject3 = new MessageForPic();
                                    ((MessageForPic)localObject3).msgData = paramMessage.msgData;
                                    ((MessageForPic)localObject3).istroop = paramMessage.istroop;
                                    ((MessageForPic)localObject3).parse();
                                    paramMessage.msg = ((MessageForPic)localObject3).getSummaryMsg();
                                    return;
                                  }
                                  if (paramMessage.msgtype == -2005)
                                  {
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692397);
                                    return;
                                  }
                                  if (paramMessage.msgtype == -2020)
                                  {
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719404);
                                    if (bbet.a(paramMessage.issend))
                                    {
                                      localObject3 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, "", 0, 0);
                                      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719405, new Object[] { localObject3 });
                                      return;
                                    }
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719404);
                                    return;
                                  }
                                  if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
                                  {
                                    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691298);
                                    try
                                    {
                                      localObject3 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
                                      if (localObject3 != null)
                                      {
                                        paramMessage.pttUrl = ((MessageForPtt)localObject3).url;
                                        paramMessage.msg = ((MessageForPtt)localObject3).getSummaryMsg();
                                        return;
                                      }
                                    }
                                    catch (Exception paramMessage)
                                    {
                                      paramMessage.printStackTrace();
                                      return;
                                    }
                                  }
                                }
                              }
                            }
                            if (paramMessage.msgtype != -2025) {
                              break;
                            }
                          } while (paramMessage.msgData == null);
                          try
                          {
                            localObject3 = new MessageForQQWalletMsg();
                            ((MessageForQQWalletMsg)localObject3).msgData = paramMessage.msgData;
                            ((MessageForQQWalletMsg)localObject3).parse();
                            paramMessage.msg = ((MessageForQQWalletMsg)localObject3).getMsgSummary();
                            return;
                          }
                          catch (Exception paramMessage) {}
                        } while (!QLog.isColorLevel());
                        QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
                        return;
                        if (paramMessage.msgtype != -2072) {
                          break;
                        }
                      } while (paramMessage.msgData == null);
                      try
                      {
                        localObject3 = new MessageForFuDai();
                        ((MessageForFuDai)localObject3).msgData = paramMessage.msgData;
                        ((MessageForFuDai)localObject3).parse();
                        paramMessage.msg = ((MessageForFuDai)localObject3).getSummaryMsg();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        QLog.e("Q.msg.BaseMessageManager", 1, paramMessage, new Object[0]);
                        return;
                      }
                      if (paramMessage.msgtype != -2039) {
                        break;
                      }
                      paramMessage.msg = ajyc.a(2131701009);
                    } while (paramMessage.msgData == null);
                    localObject3 = new MessageForApollo();
                    ((MessageForApollo)localObject3).msgData = paramMessage.msgData;
                    ((MessageForApollo)localObject3).parse();
                    paramMessage.msg = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForApollo)localObject3);
                    return;
                    if (paramMessage.msgtype != -5008) {
                      break;
                    }
                  } while (paramMessage.msgData == null);
                  localObject3 = new ArkAppMessage();
                  ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
                  paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
                  return;
                  if (paramMessage.msgtype != -5016) {
                    break;
                  }
                } while (paramMessage.msgData == null);
                localObject3 = new MessageForArkBabyqReply();
                ((MessageForArkBabyqReply)localObject3).fromBytes(paramMessage.msgData);
                paramMessage.msg = ((MessageForArkBabyqReply)localObject3).getSummery();
                return;
                if (paramMessage.msgtype != -5017) {
                  break;
                }
              } while (paramMessage.msgData == null);
              localObject3 = new ArkAppMessage();
              ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
              paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
              return;
              if (paramMessage.msgtype != -5013) {
                break;
              }
            } while (paramMessage.msgData == null);
            localObject3 = new ArkFlashChatMessage();
            ((ArkFlashChatMessage)localObject3).fromBytes(paramMessage.msgData);
            paramMessage.msg = ((ArkFlashChatMessage)localObject3).getSummery();
            return;
            if (paramMessage.msgtype != -5014) {
              break;
            }
          } while (paramMessage.msgData == null);
          paramMessage.msg = ((HiBoomMessage)akwb.a(paramMessage.msgData)).text;
          return;
          if (paramMessage.msgtype == -2048)
          {
            localObject3 = new MessageForTroopReward();
            ((MessageForTroopReward)localObject3).msgData = paramMessage.msgData;
            ((MessageForTroopReward)localObject3).parse();
            paramMessage.msg = ((MessageForTroopReward)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -2051)
          {
            localObject3 = new MessageForQQStory();
            ((MessageForQQStory)localObject3).msgData = paramMessage.msgData;
            ((MessageForQQStory)localObject3).parse();
            paramMessage.msg = ((MessageForQQStory)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -7002)
          {
            localObject3 = new MessageForTribeShortVideo();
            ((MessageForTribeShortVideo)localObject3).msgData = paramMessage.msgData;
            ((MessageForTribeShortVideo)localObject3).parse();
            paramMessage.msg = ((MessageForTribeShortVideo)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -2054)
          {
            localObject3 = new MessageForTroopSign();
            ((MessageForTroopSign)localObject3).msgData = paramMessage.msgData;
            ((MessageForTroopSign)localObject3).parse();
            paramMessage.msg = ((MessageForTroopSign)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -5015)
          {
            paramMessage.msg = ajyc.a(2131701010);
            return;
          }
          if (paramMessage.msgtype != -2067) {
            break;
          }
          localObject3 = new MessageForTroopConfess();
          ((MessageForTroopConfess)localObject3).msgData = paramMessage.msgData;
          ((MessageForTroopConfess)localObject3).doParse();
          paramMessage.msg = ((MessageForTroopConfess)localObject3).msg;
          localObject3 = bajb.a(paramMessage);
          if (localObject3 != null) {
            paramMessage.nickName = ((bajc)localObject3).jdField_c_of_type_JavaLangString;
          }
        } while (!TextUtils.isEmpty(paramMessage.nickName));
        paramMessage.nickName = ajyc.a(2131701012);
        return;
      } while ((paramMessage.msg == null) || ("".equals(paramMessage.msg)));
      localObject3 = paramMessage.msg;
      if (!b((String)localObject3)) {
        break;
      }
      localObject3 = localObject3.split("\026")[1].split("\\|");
    } while (localObject3 == null);
    label832:
    int i;
    label1471:
    if (localObject3.length < 2)
    {
      i = 1;
      label2763:
      paramMessage.fileType = i;
    }
    for (;;)
    {
      try
      {
        if (localObject3.length < 2)
        {
          l = -1L;
          paramMessage.fileSize = l;
        }
      }
      catch (Exception localException5)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException5);
        paramMessage.fileSize = -1L;
        continue;
        if (paramMessage.msgtype != -3001) {
          continue;
        }
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694969);
        return;
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693370);
        return;
      }
      switch (i)
      {
      case 3: 
      default: 
        return;
      case 0: 
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692397);
        return;
        i = Integer.valueOf(localObject3[2]).intValue();
        break label2763;
        l = Long.valueOf(localObject3[1]).longValue();
      }
    }
    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691298);
    paramMessage.pttUrl = localObject3[0];
    return;
    if (paramMessage.msgtype == -2006)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
      }
      paramMessage.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691298) + "(0x7f)");
      return;
    }
    if (paramMessage.msgtype == -2008)
    {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719131);
      return;
    }
    if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
    {
      localObject6 = axas.a(paramMessage.msg);
      localObject4 = "";
      localObject3 = localObject4;
      if (localObject6 != null)
      {
        localObject3 = localObject4;
        if (localObject6[2] != null) {
          localObject3 = localObject6[2];
        }
      }
      paramMessage.fileType = 65536;
      paramMessage.msg = ("[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720363) + "] " + (String)localObject3);
      return;
    }
    if (paramMessage.msgtype == -2029)
    {
      localObject3 = new MessageForQQWalletTips();
      ((MessageForQQWalletTips)localObject3).init(paramMessage.selfuin, paramMessage.frienduin, paramMessage.senderuin, "[QQWallet Tips]", awzw.a(), paramMessage.msgtype, paramMessage.istroop, awzw.a());
      ((MessageForQQWalletTips)localObject3).msgData = paramMessage.msgData;
      ((MessageForQQWalletTips)localObject3).isread = true;
      ((MessageForQQWalletTips)localObject3).parse();
      ((MessageForQQWalletTips)localObject3).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), null);
      paramMessage.msg = ((MessageForQQWalletTips)localObject3).summary;
      return;
    }
    if (paramMessage.msgtype == -2068)
    {
      localObject3 = new MessageForDarenAssistant();
      ((MessageForDarenAssistant)localObject3).msgData = paramMessage.msgData;
      ((MessageForDarenAssistant)localObject3).parse();
      paramMessage.msg = ((MessageForDarenAssistant)localObject3).msg;
      return;
    }
    if (asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))
    {
      paramMessage.emoRecentMsg = asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage.msg);
      return;
    }
    Object localObject3 = new StringBuilder(paramMessage.msg);
    Object localObject6 = paramMessage.getExtInfoFromExtStr("disc_at_info_list");
    Object localObject4 = localObject3;
    if (paramMessage.istroop == 3000)
    {
      localObject4 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject6)) {}
    }
    for (;;)
    {
      try
      {
        localObject4 = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(localObject4)) {
          continue;
        }
        localObject4 = bafh.a((QQAppInterface)localObject4, (StringBuilder)localObject3, (String)localObject6, paramMessage.frienduin, paramMessage.isSend());
        localObject3 = localObject4;
        localObject4 = localObject3;
      }
      catch (Exception localException6)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "replaceAtMsgByMarkName", localException6);
        Object localObject5 = localObject3;
        continue;
        paramMessage.emoRecentMsg = new ayki(localObject5, 3, 16);
      }
      if (paramMessage.msgtype != -1000) {
        continue;
      }
      paramMessage.emoRecentMsg = new ayki(bbet.c(((StringBuilder)localObject4).toString()), 3, 16);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
    }
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i = akpy.a(paramMessageRecord.istroop);
      if ((i == 1001) || (i == 10002)) {
        if (akpy.d(paramMessageRecord))
        {
          a(ajsf.aj, i, paramMessageRecord.frienduin, (String)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.aj, i);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject3).senderuin != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
              {
                ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).senderuin != null) && (((QQMessageFacade.Message)localObject1).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject1).cleanMessageRecordBaseField();
        return;
        a(ajsf.H, i, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.H, i);
        continue;
        if (akpy.a(paramMessageRecord.istroop) == 1009)
        {
          a(ajsf.w, 1009, paramMessageRecord.frienduin, (String)localObject3);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.w, 1009);
        }
        else
        {
          localObject1 = localObject2;
          if (akpy.a(paramMessageRecord.istroop) == 1010) {
            if (akpy.d(paramMessageRecord))
            {
              a(ajsf.ak, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ak, 1010);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject3).senderuin != null)
                {
                  localObject1 = localObject2;
                  if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
                  {
                    ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                    localObject1 = localObject2;
                  }
                }
              }
            }
            else
            {
              a(ajsf.ab, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ab, 1010);
            }
          }
        }
      }
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, akte paramakte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramakte, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, aukn paramaukn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, akol paramakol)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramaukn = paramakol.d;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awzw.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramakol = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
      }
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    Object localObject;
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if (((MessageForUniteGrayTip)localObject).callback != null) {
        ((MessageForUniteGrayTip)localObject).callback.a((MessageForUniteGrayTip)localObject);
      }
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((localObject != null) && (((AbsStructMsg)localObject).mMsgServiceID == 61)) {
        paramMessageRecord.extInt = 61;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgUrl != null) && (((MessageForStructing)localObject).structingMsg.mMsgUrl.startsWith("https://docs.qq.com"))) {
        annl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).senderuin, ((MessageForStructing)localObject).istroop, ((MessageForStructing)localObject).time, ((MessageForStructing)localObject).msgseq, ((MessageForStructing)localObject).msgUid);
      }
    }
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) {
      if (a(paramMessageRecord, false, 1))
      {
        if ((paramaukn.containsKey(akpy.a(paramakol, i))) && (!paramMessageRecord.isSendFromLocal())) {
          break label555;
        }
        paramaukn.put(akpy.a(paramakol, i), paramMessageRecord);
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1051) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
          {
            paramaukn = (asts)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
              continue;
            }
            paramaukn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
          }
        }
        catch (Exception paramaukn)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramaukn);
          continue;
          ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.3(this, paramaukn, paramMessageRecord), 10000L);
        }
        try
        {
          if ((paramMessageRecord.isSendFromLocal()) || ((paramMessageRecord.msgtype != -1036) && (paramMessageRecord.msgtype != -1035))) {
            break;
          }
          paramaukn = (asjs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
            continue;
          }
          paramaukn.a(paramMessageRecord);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramMessageRecord);
          return;
        }
      }
      label555:
      localObject = (MessageRecord)paramaukn.get(akpy.a(paramakol, i));
      if (a(paramMessageRecord) >= a((MessageRecord)localObject))
      {
        paramaukn.put(akpy.a(paramakol, i), paramMessageRecord);
        continue;
        a(paramMessageRecord, true, 1);
        continue;
        ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.2(this, paramaukn, paramMessageRecord), 10000L);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, nqq paramnqq)
  {
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = akpy.a(str, i);
    int j = 0;
    Object localObject;
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord))
    {
      localObject = paramnqq.a();
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(str, i);
      if (localMessageRecord == null) {
        break label159;
      }
      a(localMessageRecord, true, 4);
      i = j;
      paramMessageRecord = localMessageRecord;
    }
    for (;;)
    {
      if (((localObject != null) && (str.equals(((EcShopData)localObject).mUin))) || (i != 0))
      {
        paramnqq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(9970L), 7120);
        if (paramnqq != null)
        {
          if (paramMessageRecord != null)
          {
            paramnqq.lastmsgtime = paramMessageRecord.time;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramnqq);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramnqq);
        }
      }
      return;
      label159:
      paramnqq.b(str);
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramMessageRecord = localMessageRecord;
      i = j;
      if (localQQMessageFacade != null)
      {
        paramnqq = paramnqq.a();
        paramMessageRecord = localMessageRecord;
        localObject = paramnqq;
        i = j;
        if (paramnqq != null)
        {
          paramMessageRecord = localQQMessageFacade.a(paramnqq.mUin, 1008);
          i = 1;
          localObject = paramnqq;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    Object localObject1 = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!akpy.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label450;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + paramMessageRecord);
      }
      Object localObject2 = akpy.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))
      {
        localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((!paramMessageRecord.isread) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, (MessageRecord)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      int k = ((List)localObject1).size();
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramBoolean2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject2);
          j += 1;
          continue;
          ((List)localObject1).add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        localObject1 = (nqq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        if (!akpy.r(paramMessageRecord.istroop)) {
          break label352;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label352:
        if (sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))
        {
          a(paramMessageRecord, (nqq)localObject1);
        }
        else if ((paramMessageRecord.istroop == 1008) && (sbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
          sbc.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((paramMessageRecord.istroop != 1008) || (!sbc.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
        }
      }
      label450:
      i = 0;
    }
  }
  
  protected void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, akqs paramakqs)
  {
    paramakqs.jdField_d_of_type_Boolean = true;
    paramakqs.jdField_a_of_type_JavaLangString = paramString;
    paramakqs.jdField_d_of_type_Int = paramInt1;
    paramakqs.e = paramInt2;
    if (akpy.a(paramInt1) != 1032) {}
    for (String str = akpy.a(paramString, paramInt1); this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(str); str = amns.a(paramString, paramInt1, paramakqs.jdField_f_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramakqs.i) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramakqs.i + ", refreshActionMap[" + akpy.a(paramString, paramInt1) + "] = " + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(str));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqs);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(str, Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new BaseMessageManager.1(this, paramString, paramInt1, paramInt2, paramakqs, str));
  }
  
  protected void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong + ",force=" + paramBoolean);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
    ((aggl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(147)).a(paramString, paramInt, -1);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((akpy.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    String str;
    if (akpy.c(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, 0);
      str = "";
      if (paramInt1 == 1010) {
        str = ajsf.ab;
      }
    }
    label40:
    label48:
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
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                if (TextUtils.isEmpty(str)) {}
                for (;;)
                {
                  return;
                  if ((paramInt1 != 1001) && (paramInt1 != 10002)) {
                    break label40;
                  }
                  str = ajsf.H;
                  break label40;
                  QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt1);
                  if ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString2))) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(str, paramInt1, paramString1, paramString3, 0);
                  paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString1, paramInt1);
                  if ((paramString2 != null) && (!paramString2.isEmpty()))
                  {
                    paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
                    paramString3 = axaq.a(paramString2.msgtype);
                    MessageRecord.copyMessageRecordBaseField(paramString3, paramString2);
                    paramString3.frienduin = str;
                    paramString3.senderuin = paramString1;
                    if (!akpy.g(paramString2.msgtype)) {
                      a(paramString3, null, false, true, 1);
                    }
                    MessageRecord.copyMessageRecordBaseField(localMessage, paramString2);
                    localMessage.frienduin = paramString1;
                    localMessage.emoRecentMsg = null;
                  }
                  try
                  {
                    a(localMessage);
                    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(str, paramInt1);
                    if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1)))
                    {
                      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(str, paramInt1);
                      if ((paramString1 != null) && (!paramString1.isEmpty()))
                      {
                        MessageRecord.copyMessageRecordBaseField(paramString2, (MessageRecord)paramString1.get(paramString1.size() - 1));
                        paramString2.frienduin = str;
                        paramString2.emoRecentMsg = null;
                        try
                        {
                          a(paramString2);
                          return;
                        }
                        catch (Throwable paramString1) {}
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
                      }
                    }
                  }
                  catch (Throwable paramString2)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", paramString2);
                      }
                    }
                    paramString2.emoRecentMsg = null;
                    paramString2.msg = null;
                  }
                }
              } while (!paramBoolean);
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, paramInt1);
            } while (paramString1 == null);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
            return;
            paramInt2 = akpy.a(paramInt2, paramInt3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
            paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt1);
          } while ((paramString3.senderuin == null) || (!paramString3.senderuin.equals(paramString2)) || ((paramInt2 != 0) && ((paramInt2 == 0) || (paramInt2 != paramString3.getExtraKey()))));
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString1, paramInt1);
          if ((paramString2 == null) || (paramString2.isEmpty())) {
            break;
          }
          MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
          paramString3.frienduin = paramString1;
          paramString3.emoRecentMsg = null;
          try
          {
            a(paramString3);
            return;
          }
          catch (Throwable paramString1) {}
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
        return;
        paramString3.emoRecentMsg = null;
        paramString3.msg = null;
        amns.a(paramString3);
      } while (!paramBoolean);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt1);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (sdf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt))) {}
    do
    {
      do
      {
        return;
        if ((paramInt != 1008) || (!sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
          break;
        }
        paramString2 = (nqq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      } while (paramString2 == null);
      paramString2.a(paramString1, paramLong);
      return;
    } while (akpy.a(paramInt) == 1032);
    aktg localaktg;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!akpy.r(paramInt)))
    {
      localaktg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (0L == paramLong)
      {
        paramString2 = localaktg.b(paramString1, paramInt);
        if (paramString2 == null) {
          break label235;
        }
        paramString2.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString2.lastmsgtime != 0L)) {
          break label220;
        }
        localaktg.b(paramString2);
      }
    }
    for (;;)
    {
      if ((paramInt == 1008) && (sbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
        sbc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3, paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString2);
      return;
      RecentUser localRecentUser = localaktg.a(paramString1, paramInt);
      localRecentUser.troopUin = paramString2;
      paramString2 = localRecentUser;
      break;
      label220:
      asyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localaktg.a(paramString2);
      label235:
      continue;
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l = 0L;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    for (;;)
    {
      return;
      int i = 0;
      if (aver.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt1)) {
        i = 1;
      }
      MessageRecord localMessageRecord;
      akpc localakpc;
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1) > 0)
        {
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1);
          localakpc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localMessageRecord != null) {
            l = a(localMessageRecord);
          }
          localakpc.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
          a(paramString, paramInt1);
          i = j;
        }
      }
      while (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1, paramInt2));
        ((aggl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(147)).a(paramString, paramInt1, -1);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramInt2) > 0)
          {
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramInt2);
            localakpc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (localMessageRecord != null) {
              l = a(localMessageRecord);
            }
            localakpc.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
            a(paramString, paramInt1);
            i = j;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          }
        }
      }
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    ??? = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)???).jdField_a_of_type_Int;
    String str = ((RevokeMsgInfo)???).jdField_a_of_type_JavaLangString;
    int j = ((RevokeMsgInfo)???).e;
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify frienduin = " + str + ", istroop = " + i);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).e(str, i);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, i, akri.jdField_d_of_type_Int, akri.j);
    }
    List localList;
    do
    {
      return;
      localList = a((List)localObject2, str, i, paramArrayList);
      if ((localList == null) || (localList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, i, akri.jdField_d_of_type_Int, akri.k);
        return;
      }
      if ((localList == null) || (localList.size() != 1) || (!aqva.a((MessageRecord)localList.get(0)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
      }
      paramArrayList = (MessageRecord)localList.get(0);
    } while (!(paramArrayList instanceof MessageForUniteGrayTip));
    aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)paramArrayList, i);
    return;
    Object localObject3 = (MessageRecord)localList.get(0);
    localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramArrayList = (MessageRecord)((Iterator)localObject2).next();
      if ((paramArrayList.shmsgseq == ((RevokeMsgInfo)???).jdField_a_of_type_Long) && (paramArrayList.msgUid == ((RevokeMsgInfo)???).jdField_b_of_type_Long)) {
        localObject3 = paramArrayList;
      }
    }
    for (;;)
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      long l;
      if ((j == 1) || (j == 2))
      {
        localObject2 = ajyc.a(2131701016);
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (((MessageRecord)localList.get(0)).msgtype != -2006)
        {
          l = ((MessageRecord)localList.get(0)).time;
          if ((((RevokeMsgInfo)???).jdField_c_of_type_JavaLangString == null) || (a(((RevokeMsgInfo)???).jdField_c_of_type_JavaLangString))) {
            break label734;
          }
          localObject2 = a(i, (String)localObject2, ((RevokeMsgInfo)???).jdField_c_of_type_JavaLangString, str, paramArrayList, localMessageForUniteGrayTip, l);
          ??? = ((aquz)localObject2).jdField_c_of_type_JavaLangString;
          label477:
          ((aquz)localObject2).e = true;
          ((aquz)localObject2).jdField_f_of_type_Boolean = false;
          localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aquz)localObject2);
          localMessageForUniteGrayTip.msgUid = ((MessageRecord)localObject3).msgUid;
          localMessageForUniteGrayTip.shmsgseq = ((MessageRecord)localObject3).shmsgseq;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", paramArrayList, ",frienduin=", str });
          }
          aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip, localList, i, (String)???, (aquz)localObject2);
          paramArrayList = localList.iterator();
          label581:
          do
          {
            if (!paramArrayList.hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
          } while (((MessageRecord)localObject2).msgtype != -2005);
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject2 = ((aoza)???).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject2 != null)
          {
            ((aoza)???).b((FileManagerEntity)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject2).nSessionId);
          }
          if (((MessageRecord)localObject3).istroop != 3000) {
            break label868;
          }
          apuc.a("0X8005E50");
        }
      }
      for (;;)
      {
        apuc.a("0X8005E4C");
        break label581;
        l = ((RevokeMsgInfo)???).jdField_c_of_type_Long;
        break;
        label734:
        ??? = ajyc.a(2131701013) + BaseApplicationImpl.getApplication().getString(2131697946);
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = new aquz(str, paramArrayList, (String)???, i, -5040, 1, ((MessageRecord)localObject3).time);
        break label477;
        ??? = ajyc.a(2131701011) + BaseApplicationImpl.getApplication().getString(2131694428);
        paramArrayList = ((MessageRecord)localObject3).senderuin;
        localObject2 = new aquz(str, paramArrayList, (String)???, i, -5040, 1, ((MessageRecord)localObject3).time);
        break label477;
        label868:
        apuc.a("0X8005E4D");
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).f(str, i);
      synchronized (akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(str, i))
      {
        akpy.a(paramArrayList, localMessageForUniteGrayTip, true);
        aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(null, true);
        return;
      }
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    int i;
    int n;
    Object localObject2;
    Object localObject4;
    String str2;
    int k;
    String str1;
    Object localObject3;
    if (localRevokeMsgInfo.jdField_c_of_type_Int > 1)
    {
      i = 1;
      n = localRevokeMsgInfo.jdField_a_of_type_Int;
      localObject2 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
      ??? = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
      localObject4 = localRevokeMsgInfo.jdField_c_of_type_JavaLangString;
      str2 = localRevokeMsgInfo.d;
      k = localRevokeMsgInfo.e;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify fromUin = " + (String)localObject2 + ", istroop = " + n + ",toUin=" + (String)??? + ",groupUin=" + (String)localObject4 + ",authorUin=" + str2 + ",opType= " + k);
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject3 = localObject4;
      if (n != 1004)
      {
        if (n != 1000) {
          break label302;
        }
        localObject3 = localObject4;
      }
      label184:
      paramBoolean = TextUtils.equals(str1, (CharSequence)localObject2);
      if ((n != 3000) && (n != 1)) {
        break label309;
      }
    }
    ArrayList localArrayList;
    Object localObject6;
    label302:
    label309:
    while (paramBoolean)
    {
      localArrayList = new ArrayList();
      localObject4 = paramArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (RevokeMsgInfo)((Iterator)localObject4).next();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)???, n, ((RevokeMsgInfo)localObject6).jdField_a_of_type_Long, ((RevokeMsgInfo)localObject6).jdField_b_of_type_Long);
        if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
          localArrayList.addAll((Collection)localObject6);
        }
      }
      i = 0;
      break;
      localObject3 = localObject2;
      break label184;
    }
    for (;;)
    {
      ??? = localObject2;
    }
    if (i != 0) {}
    try
    {
      Collections.sort(localArrayList, akpy.a);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        if (aqva.a((MessageRecord)localArrayList.get(0))) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
            }
          }
          if (((MessageRecord)localArrayList.get(0)).msgtype != -2006) {
            break label457;
          }
          if (!(localArrayList.get(0) instanceof MessageForFoldMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: same revoke msg");
      return;
      label457:
      int j = 1;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        j = 0;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList);
          return;
        }
      }
      localObject6 = new MessageForUniteGrayTip();
      long l;
      label564:
      label629:
      label761:
      int m;
      label722:
      label869:
      Object localObject5;
      if ((j != 0) && (((MessageRecord)localArrayList.get(0)).msgtype != -2006))
      {
        l = ((MessageRecord)localArrayList.get(0)).time;
        if (!paramBoolean) {
          break label1033;
        }
        paramArrayList = ajyc.a(2131701015);
        if ((k != 1) && (k != 2)) {
          break label1401;
        }
        if (!TextUtils.equals((CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label1210;
        }
        if ((str2 == null) || (a(str2))) {
          break label1170;
        }
        paramArrayList = a(n, paramArrayList, str2, (String)???, (String)localObject3, (MessageForUniteGrayTip)localObject6, l);
        localObject3 = paramArrayList.jdField_c_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ", Boolean.valueOf(paramBoolean), ",selfuin=", str1, ",fromUin=", localObject2 });
        }
        paramArrayList.e = true;
        paramArrayList.jdField_f_of_type_Boolean = false;
        ((MessageForUniteGrayTip)localObject6).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
        if (j == 0) {
          break label1478;
        }
        l = ((MessageRecord)localArrayList.get(0)).msgUid;
        ((MessageForUniteGrayTip)localObject6).msgUid = l;
        ((MessageForUniteGrayTip)localObject6).shmsgseq = localRevokeMsgInfo.jdField_a_of_type_Long;
        if (paramBoolean) {
          aqva.a(localArrayList);
        }
        if (j == 0) {
          break label1652;
        }
        paramArrayList = localArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label1652;
        }
        localObject2 = (MessageRecord)paramArrayList.next();
        m = 0;
        k = m;
        if (i != 0)
        {
          k = m;
          if (!((MessageRecord)localObject2).isread)
          {
            k = m;
            if (localObject2 != localArrayList.get(0))
            {
              ((MessageRecord)localObject2).isread = true;
              if (n != 1)
              {
                k = m;
                if (n != 3000) {}
              }
              else
              {
                k = 1;
              }
            }
          }
        }
        if (k == 0) {
          break label1488;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).a((MessageRecord)localObject2, false);
        if ((((MessageRecord)localObject2).msgtype == -2005) || ((localObject2 instanceof MessageForTroopFile)))
        {
          if (((MessageRecord)localObject2).msgtype != -2005) {
            break label1562;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject5 = ((aoza)localObject3).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject5 == null) {
            break label1517;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
          }
          ((aoza)localObject3).b((FileManagerEntity)localObject5);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject5).nSessionId);
        }
      }
      label1033:
      label1170:
      label1562:
      for (;;)
      {
        ((aygv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).b((MessageRecord)localObject2);
        localObject2 = EmojiStickerManager.a((MessageRecord)localObject2);
        if (localObject2 == null) {
          break label761;
        }
        EmojiStickerManager.a().b.put(localObject2, Boolean.valueOf(true));
        break label761;
        l = localRevokeMsgInfo.jdField_c_of_type_Long;
        break;
        if (n == 1)
        {
          paramArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).d((String)???);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt(bbcl.jdField_a_of_type_JavaLangString, bbcl.jdField_b_of_type_Int);
          ((Bundle)localObject5).putLong(bbcl.jdField_b_of_type_JavaLangString, ((MessageForUniteGrayTip)localObject6).uniseq);
          localObject5 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, paramArrayList, true, (Bundle)localObject5);
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            paramArrayList = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, 1, 0);
          }
          break label564;
        }
        if (n == 3000)
        {
          paramArrayList = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, 2, 0);
          break label564;
        }
        paramArrayList = ajyc.a(2131701007);
        break label564;
        paramArrayList = new aquz((String)???, (String)localObject3, paramArrayList.concat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697946)), n, -5040, 1, l);
        break label629;
        label1210:
        if (k == 2) {}
        for (localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697974);; localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697973))
        {
          k = ((String)localObject5).length();
          m = ((String)localObject5).length();
          int i1 = paramArrayList.length();
          paramArrayList = new aquz((String)???, (String)localObject3, (String)localObject5 + paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697946), n, -5040, 1, l);
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(bbcl.jdField_a_of_type_JavaLangString, bbcl.jdField_b_of_type_Int);
          ((Bundle)localObject3).putLong(bbcl.jdField_b_of_type_JavaLangString, ((MessageForUniteGrayTip)localObject6).uniseq);
          ((Bundle)localObject3).putInt("key_action", 5);
          ((Bundle)localObject3).putString("troop_mem_uin", String.valueOf(localObject2));
          ((Bundle)localObject3).putBoolean("need_update_nick", true);
          paramArrayList.a(k, m + i1, (Bundle)localObject3);
          break;
        }
        label1401:
        localObject5 = paramArrayList;
        if (paramArrayList.length() > 12) {
          localObject5 = paramArrayList.substring(0, 11) + "...";
        }
        paramArrayList = new aquz((String)???, (String)localObject3, ((String)localObject5).concat(BaseApplicationImpl.getApplication().getString(2131694428)), n, -5040, 1, l);
        break label629;
        label1478:
        l = localRevokeMsgInfo.jdField_b_of_type_Long;
        break label722;
        label1488:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
        break label869;
        label1517:
        if (QLog.isColorLevel())
        {
          QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + ((MessageRecord)localObject2).uniseq + "],");
          continue;
          if ((localObject2 instanceof MessageForTroopFile))
          {
            localObject5 = (MessageForTroopFile)localObject2;
            localObject3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(((MessageForTroopFile)localObject5).frienduin));
            localObject5 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject5);
            if ((localObject5 != null) && (((azqt)localObject5).a != null) && (localObject3 != null))
            {
              localObject5 = ((TroopFileTransferManager)localObject3).a(((azqt)localObject5).a);
              if (localObject5 != null) {
                ((TroopFileTransferManager)localObject3).a((TroopFileTransferManager.Item)localObject5, 12);
              }
            }
          }
        }
      }
      label1652:
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).f((String)???, n);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
        }
      }
      for (;;)
      {
        aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject6);
        if (j != 0)
        {
          paramArrayList = localArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            ??? = (MessageRecord)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Aksd.a((MessageRecord)???);
          }
          synchronized (akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a((String)???, n))
          {
            akpy.a(paramArrayList, (MessageRecord)localObject6, true);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Aksd.a((MessageRecord)localObject6);
      if ((j != 0) && (!((MessageRecord)localArrayList.get(0)).isread)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList, paramBoolean);
    }
  }
  
  protected void a(List<MessageRecord> paramList)
  {
    if ((Looper.myLooper() == Looper.getMainLooper()) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForText)) {
          ((MessageForText)localMessageRecord).parse();
        }
      }
    }
  }
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (paramList.size() == 0) {}
    label774:
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = (MessageRecord)paramList.get(0);
      int i = 1;
      Object localObject2;
      if (i < paramList.size())
      {
        localObject2 = (MessageRecord)paramList.get(i);
        if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 3000)) {
          if (((MessageRecord)localObject2).shmsgseq > ((MessageRecord)localObject3).shmsgseq) {
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject1;
          break;
          localObject1 = localObject3;
          if (((MessageRecord)localObject2).shmsgseq == ((MessageRecord)localObject3).shmsgseq)
          {
            localObject1 = localObject3;
            if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId())
            {
              localObject1 = localObject2;
              continue;
              if (((MessageRecord)localObject2).time > ((MessageRecord)localObject3).time)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject3;
                if (((MessageRecord)localObject2).time == ((MessageRecord)localObject3).time)
                {
                  localObject1 = localObject3;
                  if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId()) {
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = paramList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForLongMsg)) {
          localArrayList.addAll(((MessageForLongMsg)localObject2).longMsgFragmentList);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + localObject2);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject2);
          break;
          localArrayList.add(localObject2);
        }
      }
      localObject1 = akpy.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
      {
        localObject1 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramList.next();
            if (!localMessageRecord.isread) {
              ((List)localObject2).add(localMessageRecord);
            }
          }
          if (((List)localObject2).size() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, (List)localObject2);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).a(localArrayList, paramBoolean2);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject1);
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList);
      }
      if ((localObject3 instanceof MessageForLongMsg))
      {
        if (!akpy.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop))) {
          break label665;
        }
        i = j;
        if (i != 0)
        {
          paramList = (nqq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
          if (!akpy.r(((MessageRecord)localObject3).istroop)) {
            break label671;
          }
          a((MessageRecord)localObject3);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label774;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).f();
        return;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject3)) {
          break;
        }
        label665:
        i = 0;
        break;
        label671:
        if (sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin))
        {
          a((MessageRecord)localObject3, paramList);
        }
        else if ((((MessageRecord)localObject3).istroop == 1008) && (sbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
          sbc.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((((MessageRecord)localObject3).istroop != 1008) || (!sbc.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if (localMessageForShortVideo.busiType == 0)
      {
        if ((localMessageForShortVideo.videoFileStatus == 1007) || ((localMessageForShortVideo.videoFileStatus == 1003) && (localMessageForShortVideo.extraflag == 32772))) {}
        for (boolean bool = true; !bool; bool = false) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, holdFlag: " + bool);
        }
        e(paramMessageRecord);
        return true;
      }
    }
    else if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if (paramMessageRecord.extraflag == 32772)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, msgForPic");
        }
        e(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    if (paramMessageRecord == null) {
      return false;
    }
    if (paramMessageRecord.isLongMsg())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord))
      {
        if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(ajsf.D).equals(paramMessageRecord.frienduin))) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(null);
        }
        return false;
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
    }
    for (;;)
    {
      if (paramMessageRecord.istroop == 1036) {
        return false;
      }
      if (bdto.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)) {
        return false;
      }
      if ((!paramMessageRecord.isValid) || (akpy.g(paramMessageRecord.msgtype)) || ((paramMessageRecord.frienduin.equals(ajsf.ax)) && (paramMessageRecord.istroop == 0)) || ((paramMessageRecord.frienduin.equals(ajsf.aE)) && (paramMessageRecord.istroop == 0))) {
        break;
      }
      QQMessageFacade.Message localMessage1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + localMessage1.getBaseInfoString());
      }
      int i;
      if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (bbet.a(paramMessageRecord.issend)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab isBlessMsg:" + paramMessageRecord.isBlessMsg + " needUpdateMsgTag:" + paramMessageRecord.needUpdateMsgTag + " isCheckNeedShowInListTypeMsg:" + paramMessageRecord.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + paramMessageRecord.needNeedShowInList);
        }
        int j = 1;
        i = j;
        if (paramMessageRecord.isBlessMsg)
        {
          i = j;
          if (paramMessageRecord.needUpdateMsgTag) {
            i = 0;
          }
        }
        j = i;
        if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
        {
          j = i;
          if (paramMessageRecord.needNeedShowInList) {
            j = 0;
          }
        }
        if (j != 0) {
          return false;
        }
      }
      boolean bool2;
      boolean bool1;
      if (paramInt == 1)
      {
        bool2 = false;
        bool1 = false;
        if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1))
        {
          paramInt = (int)(localMessage1.shmsgseq - paramMessageRecord.shmsgseq);
          if (paramMessageRecord.msgtype != -1012)
          {
            i = paramInt;
            bool2 = bool1;
            if (paramMessageRecord.msgtype != -5021) {}
          }
          else
          {
            if ((localMessage1.msgtype != -1012) && (localMessage1.msgtype != -5021)) {
              break label663;
            }
            i = 1;
            if (paramInt != 0) {
              break label1469;
            }
            if (i == 0) {
              break label669;
            }
            paramInt = (int)(localMessage1.time - paramMessageRecord.time);
          }
        }
      }
      label533:
      label663:
      label669:
      label1460:
      label1469:
      for (;;)
      {
        if (paramInt > 0) {}
        for (bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsForTroop", 2, "updateMsgTab mrIsOld " + bool1);
          }
          bool2 = bool1;
          i = paramInt;
          bool1 = bool2;
          if (!paramMessageRecord.isSendFromLocal())
          {
            bool1 = bool2;
            if (i > 0) {
              bool1 = true;
            }
          }
          for (;;)
          {
            bool2 = bool1;
            if (akpy.d(paramMessageRecord.senderuin))
            {
              bool2 = bool1;
              if (TextUtils.equals(paramMessageRecord.senderuin, localMessage1.senderuin)) {
                bool2 = false;
              }
            }
            if (!akpy.a(paramMessageRecord, localMessage1)) {
              break label1460;
            }
            if (paramMessageRecord.longMsgIndex < localMessage1.longMsgIndex) {
              break label722;
            }
            return false;
            i = 0;
            break;
            paramInt = -1;
            break label533;
            bool1 = bool2;
            if (akpy.c(paramMessageRecord.istroop))
            {
              bool1 = bool2;
              if (!paramMessageRecord.isSendFromLocal())
              {
                bool1 = bool2;
                if (paramMessageRecord.time < localMessage1.time) {
                  bool1 = true;
                }
              }
            }
          }
          label722:
          bool2 = false;
          for (;;)
          {
            if (!bool2)
            {
              MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
              localMessage1.emoRecentMsg = null;
              localMessage1.fileType = -1;
              localMessage1.lastMsg = null;
              bool1 = paramBoolean;
              if (!paramBoolean)
              {
                bool1 = paramBoolean;
                if (asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage1)) {
                  bool1 = true;
                }
              }
              if (!bool1) {}
            }
            for (;;)
            {
              try
              {
                a(localMessage1);
                bool1 = true;
                if ((!paramMessageRecord.isSend()) && (!axas.a(paramMessageRecord.msgtype)))
                {
                  localMessage1.hasReply = true;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + localMessage1 + ",hasReply=" + localMessage1.hasReply);
                  }
                }
                if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034))
                {
                  paramInt = 1;
                  if (((paramMessageRecord.isSendFromLocal()) || (paramMessageRecord.isread) || (paramInt != 0)) && (paramMessageRecord.msgtype != -1013) && (paramMessageRecord.msgtype != -1019))
                  {
                    paramBoolean = bool1;
                    if (paramMessageRecord.msgtype != -1018) {}
                  }
                  else
                  {
                    if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(localMessage1);
                    }
                    if ((!String.valueOf(ajsf.D).equals(localMessage1.frienduin)) && ((!akpy.d(localMessage1)) || (akpy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))
                    {
                      if ((paramMessageRecord instanceof MessageForNearbyLiveTip)) {
                        localMessage1.nickName = ((MessageForNearbyLiveTip)paramMessageRecord).nickName;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(localMessage1);
                    }
                    if (((localMessage1.msgtype == -2009) || (localMessage1.msgtype == -2016)) && (bool2))
                    {
                      QQMessageFacade.Message localMessage2 = new QQMessageFacade.Message();
                      MessageRecord.copyMessageRecordBaseField(localMessage2, paramMessageRecord);
                      localMessage2.emoRecentMsg = null;
                      localMessage2.fileType = -1;
                      localMessage1.lastMsg = null;
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(localMessage2);
                    }
                    paramBoolean = bool1;
                    if (ajsf.N.equals(localMessage1.frienduin))
                    {
                      paramInt = aydb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      if (paramInt <= 0) {
                        continue;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
                      paramBoolean = bool1;
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + localMessage1.getBaseInfoString() + " , result = " + paramBoolean);
                  }
                  if (akpy.a(localMessage1.frienduin, localMessage1.istroop)) {
                    localMessage1.istroop = akpy.a(localMessage1.istroop);
                  }
                  return paramBoolean;
                }
              }
              catch (Throwable localThrowable)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable);
                continue;
                paramInt = 0;
                continue;
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(null);
                paramBoolean = bool1;
                continue;
              }
              if ((paramInt == 4) || (paramInt == 2))
              {
                MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
                localMessage1.emoRecentMsg = null;
                localMessage1.fileType = -1;
                localMessage1.lastMsg = null;
                bool1 = paramBoolean;
                if (!paramBoolean)
                {
                  bool1 = paramBoolean;
                  if (asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage1)) {
                    bool1 = true;
                  }
                }
                if (bool1) {}
                try
                {
                  a(localMessage1);
                  paramBoolean = true;
                }
                catch (Throwable paramMessageRecord)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                    }
                  }
                }
              }
              else
              {
                if (paramInt == 3)
                {
                  if (localMessage1.uniseq == paramMessageRecord.uniseq) {
                    MessageRecord.copyMessageRecordStatusField(localMessage1, paramMessageRecord);
                  }
                  for (;;)
                  {
                    paramBoolean = true;
                    break;
                    MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
                    localMessage1.emoRecentMsg = null;
                    localMessage1.fileType = -1;
                    localMessage1.lastMsg = null;
                    try
                    {
                      a(localMessage1);
                    }
                    catch (Throwable paramMessageRecord) {}
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                    }
                  }
                }
                paramBoolean = false;
                continue;
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    balw localbalw = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (localbalw.b(paramString));
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, aukn paramaukn, int paramInt2)
  {
    if (paramString == null)
    {
      paramaukn = new QQMessageFacade.Message();
      return paramaukn;
    }
    String str1 = akpy.a(paramString, paramInt1);
    Object localObject = null;
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt1);
    if ((localMessage == null) || (!localMessage.isCacheValid) || (localMessage.getConfessTopicId() != paramInt2))
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(str2, paramaukn, paramInt2);
      localObject = localMessage;
      if (localMessage != null)
      {
        localObject = localMessage;
        if (localMessage.uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage.istroop).b(localMessage.frienduin, localMessage.istroop);
          paramaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage.istroop).a(str2, paramaukn, paramInt2);
          localObject = paramaukn;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramaukn);
            localObject = paramaukn;
          }
        }
      }
      paramaukn = (aukn)localObject;
      if (localObject == null)
      {
        paramaukn = new QQMessageFacade.Message();
        paramaukn.frienduin = paramString;
        paramaukn.istroop = paramInt1;
        paramaukn.setConfessTopicId(paramInt2);
      }
    }
    for (;;)
    {
      try
      {
        paramString = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
        if (paramString != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramaukn);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramaukn);
        paramString = paramaukn;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramaukn;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramString = paramaukn;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramaukn = paramString;
      if (paramString == null) {
        break;
      }
      paramaukn = paramString;
      if (!akpy.a(paramString.frienduin, paramString.istroop)) {
        break;
      }
      paramString.istroop = akpy.a(paramString.istroop);
      return paramString;
      if (a(paramString) < a(paramaukn))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramaukn);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramaukn);
        paramString = paramaukn;
      }
      else if ((!paramString.isCacheValid) && (paramaukn.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramaukn);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramaukn);
        paramString = paramaukn;
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramString.isCacheValid = true;
        continue;
        paramString = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localMessage);
          paramString = localThrowable;
        }
      }
    }
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  public void b(akqs paramakqs)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramakqs.i;
      if (bool) {}
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(40000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
        return;
      }
      catch (InterruptedException paramakqs)
      {
        for (;;)
        {
          paramakqs.printStackTrace();
        }
      }
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = akpy.a((String)localObject, j);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord)) {
      if (j != 1026) {
        break label237;
      }
    }
    label237:
    for (int i = 1;; i = j)
    {
      RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.setType(i);
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          asyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localRecentUser);
        }
      }
      for (;;)
      {
        if (localRecentUser != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
        }
        return;
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(paramMessageRecord);
        }
      }
    }
  }
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, akqs paramakqs);
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    Object localObject;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = a(paramString, paramInt1);
      if (l != 0L)
      {
        if (akpy.a(paramInt1) != 1009) {
          break label273;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.w, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString)))
        {
          paramString = axaq.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = ajsf.w;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.w, 1009, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.w, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label181:
    do
    {
      do
      {
        MessageRecord localMessageRecord;
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
                    int i;
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
                                  do
                                  {
                                    return;
                                    if (paramInt2 == 2)
                                    {
                                      a(paramString, true, paramInt2);
                                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.w, 1009, l, paramMessageRecord.msg);
                                      return;
                                    }
                                  } while (paramInt2 != 4);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.w, 1009, paramString.senderuin, paramString.selfuin, 0);
                                  a(paramString, null, false, true, paramInt2);
                                  a(paramString, true, paramInt2);
                                  return;
                                  if ((akpy.a(paramInt1) != 1001) && (akpy.a(paramInt1) != 10002)) {
                                    break label1072;
                                  }
                                  i = akpy.a(paramInt1);
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                                  bool2 = akpy.d(paramMessageRecord);
                                  bool1 = false;
                                  if (bool2) {
                                    bool1 = ((akpc)localObject).a(paramString, i, ajsf.H);
                                  }
                                  if ((!bool2) || (bool1)) {
                                    break;
                                  }
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.aj, i);
                                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                                paramString = axaq.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                                paramString.frienduin = ajsf.aj;
                                paramString.senderuin = paramMessageRecord.frienduin;
                                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localMessageRecord = axaq.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                                localMessageRecord.frienduin = ajsf.H;
                                localMessageRecord.senderuin = ajsf.aj;
                                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.H, i);
                                if (paramInt2 != 3) {
                                  break;
                                }
                                a(paramString, true, paramInt2);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.aj, i, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.aj, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.aj)));
                              a(localMessageRecord, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              return;
                              if (paramInt2 != 2) {
                                break;
                              }
                              a(paramString, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.aj, i, l, paramMessageRecord.msg);
                            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.aj)));
                            a(localMessageRecord, true, paramInt2);
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.msg);
                            return;
                          } while (paramInt2 != 4);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.aj, i, paramString.senderuin, paramString.selfuin, 0);
                          a(paramString, null, false, true, 1);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                          a(localMessageRecord, null, false, true, 1);
                          a(paramString, true, paramInt2);
                        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.aj)));
                        a(localMessageRecord, true, paramInt2);
                        return;
                        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.H, i);
                      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                      paramString = axaq.a(paramMessageRecord.msgtype);
                      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                      paramString.selfuin = paramMessageRecord.selfuin;
                      paramString.senderuin = paramMessageRecord.frienduin;
                      paramString.frienduin = ajsf.H;
                      if (paramInt2 == 3)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                        return;
                      }
                      if (paramInt2 == 2)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, l, paramMessageRecord.msg);
                        return;
                      }
                    } while (paramInt2 != 4);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.H, i, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                    return;
                  } while (akpy.a(paramInt1) != 1010);
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  boolean bool2 = akpy.d(paramMessageRecord);
                  boolean bool1 = false;
                  if (bool2) {
                    bool1 = ((akpc)localObject).a(paramString, 1010, ajsf.ab);
                  }
                  if ((!bool2) || (bool1)) {
                    break;
                  }
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ak, 1010);
                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                paramString = axaq.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = ajsf.ak;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localMessageRecord = axaq.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = ajsf.ab;
                localMessageRecord.senderuin = ajsf.ak;
                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ab, 1010);
                if (paramInt2 != 3) {
                  break;
                }
                a(paramString, true, paramInt2);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ak, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ak, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.ak)));
              a(localMessageRecord, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
              if (paramInt2 != 2) {
                break;
              }
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ak, 1010, l, paramMessageRecord.msg);
            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.ak)));
            a(localMessageRecord, true, paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.msg);
            return;
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ak, 1010, paramString.senderuin, paramString.selfuin, 0);
          a(paramString, null, false, true, 1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
          a(localMessageRecord, null, false, true, 1);
          a(paramString, true, paramInt2);
        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(ajsf.ak)));
        a(localMessageRecord, true, paramInt2);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(ajsf.ab, 1010);
      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
      paramString = axaq.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = ajsf.ab;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label273:
    label1072:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(ajsf.ab, 1010, paramString.senderuin, paramString.selfuin, 0);
    a(paramString, null, false, true, paramInt2);
    a(paramString, true, paramInt2);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded boxUin=" + paramString + ",boxType=" + paramInt + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
      }
    }
    do
    {
      return;
      if (akpy.a(paramString, paramInt)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
    return;
    Object localObject = null;
    if (paramString.equals(ajsf.H)) {
      localObject = ajsf.aj;
    }
    akpc localakpc;
    while (localObject != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, paramInt) > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject, paramInt);
        localakpc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (paramString != null) {
          l = a(paramString);
        }
        localakpc.a((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        a((String)localObject, paramInt);
        return;
        if (paramString.equals(ajsf.ab)) {
          localObject = ajsf.ak;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
      localakpc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      }
      localakpc.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      a(paramString, paramInt);
    }
    for (int i = 1;; i = 0)
    {
      if (paramString.equals(ajsf.aM))
      {
        amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
        amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
      }
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
      }
    }
  }
  
  protected void c(QQMessageFacade.Message paramMessage) {}
  
  public void c(MessageRecord paramMessageRecord) {}
  
  public void d(MessageRecord paramMessageRecord)
  {
    Object localObject = ajyc.a(2131701006);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localObject = new aquz(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((aquz)localObject).jdField_f_of_type_Boolean = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aquz)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).e(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, akri.jdField_d_of_type_Int, akri.l);
      return;
    }
    aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akok
 * JD-Core Version:    0.7.0.1
 */