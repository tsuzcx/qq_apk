import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.C2CMessageProcessor.4;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.searcher.oidb_c2c_searcher.RspBody;

public class abwi
  extends abvx
{
  public int a;
  public Comparator a;
  HashSet<String> jdField_a_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  public int c;
  public int d;
  public int e;
  public int f = 1;
  public int g = 5;
  public int h = 10;
  public int i = 50;
  public int j;
  
  public abwi(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 10;
    this.jdField_d_of_type_Int = 30;
    this.jdField_a_of_type_JavaUtilComparator = new abwj(this);
  }
  
  private int a(byte paramByte, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    byte b1;
    int k;
    if ((paramUinPairMsg.c2c_type.has()) && (paramUinPairMsg.service_type.has()))
    {
      b1 = paramUinPairMsg.c2c_type.get();
      k = paramUinPairMsg.service_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + paramString + "c2cType:" + b1 + " serviceType:" + k + " channelType:" + paramByte);
      }
      if ((b1 == 1) && (k == 130)) {
        paramByte = 1006;
      }
    }
    for (;;)
    {
      b1 = a(paramUinPairMsg, paramString, paramInt);
      paramInt = paramByte;
      if (b1 != paramByte) {
        paramInt = b1;
      }
      return paramInt;
      if ((b1 == 1) && (k == 164))
      {
        paramByte = 10007;
      }
      else
      {
        paramByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramString, paramInt).istroop;
        continue;
        paramByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramString, paramInt).istroop;
      }
    }
  }
  
  private int a(msg_comm.Msg paramMsg)
  {
    k = -1;
    m = k;
    for (;;)
    {
      try
      {
        paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        n = k;
        if (paramMsg != null)
        {
          n = k;
          m = k;
          if (paramMsg.size() > 0)
          {
            i2 = 0;
            n = k;
            m = k;
            if (i2 < paramMsg.size())
            {
              m = k;
              localElem = (im_msg_body.Elem)paramMsg.get(i2);
              m = k;
              if (!localElem.general_flags.has()) {
                continue;
              }
              m = k;
              boolean bool = localElem.general_flags.bytes_pb_reserve.has();
              if (!bool) {
                continue;
              }
              i1 = k;
              m = k;
            }
          }
        }
      }
      catch (Throwable paramMsg)
      {
        int n;
        int i2;
        im_msg_body.Elem localElem;
        int i1;
        generalflags.ResvAttr localResvAttr;
        k = m;
        continue;
        continue;
      }
      try
      {
        localResvAttr = new generalflags.ResvAttr();
        i1 = k;
        m = k;
        localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
        i1 = k;
        m = k;
        if (localResvAttr.uint32_show_in_msg_list.has())
        {
          i1 = k;
          m = k;
          k = localResvAttr.uint32_show_in_msg_list.get();
          n = k;
          i1 = k;
          m = k;
          if (QLog.isColorLevel())
          {
            i1 = k;
            m = k;
            QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster has uint32ShowInMsgList:" + k);
            n = k;
          }
          return n;
        }
      }
      catch (Exception localException)
      {
        k = i1;
        try
        {
          QLog.e("msgFold", 1, "prase ResvAttr error, ", localException);
        }
        catch (Throwable paramMsg)
        {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", paramMsg);
          return k;
        }
      }
      i2 += 1;
    }
  }
  
  private int a(msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getRegistry().b();
    int[] arrayOfInt = new int[1];
    localObject = ((List)localObject).iterator();
    abyi localabyi;
    do
    {
      k = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localabyi = (abyi)((Iterator)localObject).next();
      arrayOfInt[0] = paramInt;
    } while (!localabyi.a(paramUinPairMsg, paramString, arrayOfInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int k = arrayOfInt[0];
    return k;
  }
  
  private int a(msg_svc.PbGetMsgResp paramPbGetMsgResp, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    if (paramPbGetMsgResp.pubaccount_cookie.has()) {
      arrayOfByte = paramPbGetMsgResp.pubaccount_cookie.get().toByteArray();
    }
    int k = 0;
    if (paramPbGetMsgResp.msg_rsp_type.has()) {
      k = paramPbGetMsgResp.msg_rsp_type.get();
    }
    a(paramArrayOfByte, arrayOfByte, k);
    return k;
  }
  
  /* Error */
  private long a(byte paramByte, boolean paramBoolean1, boolean paramBoolean2, long paramLong, StringBuilder paramStringBuilder, List<msg_comm.UinPairMsg> paramList, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iload 9
    //   5: aload 7
    //   7: invokeinterface 177 1 0
    //   12: if_icmpge +443 -> 455
    //   15: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   18: lstore 4
    //   20: aload 7
    //   22: iload 9
    //   24: invokeinterface 180 2 0
    //   29: checkcast 65	msf/msgcomm/msg_comm$UinPairMsg
    //   32: astore 17
    //   34: aload 17
    //   36: getfield 275	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   39: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   42: invokestatic 285	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   45: astore 16
    //   47: aload 17
    //   49: getfield 288	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   55: i2l
    //   56: ldc2_w 289
    //   59: land
    //   60: lstore 13
    //   62: aload 17
    //   64: getfield 293	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   67: invokevirtual 172	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   70: astore 18
    //   72: aload 17
    //   74: getfield 296	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   80: ifeq +284 -> 364
    //   83: aload 17
    //   85: getfield 296	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   88: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   91: ifeq +273 -> 364
    //   94: iconst_1
    //   95: istore 11
    //   97: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +81 -> 181
    //   103: aload 6
    //   105: iconst_0
    //   106: invokevirtual 300	java/lang/StringBuilder:setLength	(I)V
    //   109: aload 6
    //   111: ldc_w 302
    //   114: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 16
    //   119: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 304
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload 11
    //   130: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: ldc_w 309
    //   136: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: lload 13
    //   141: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: ldc_w 314
    //   147: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: astore 19
    //   152: aload 18
    //   154: ifnonnull +216 -> 370
    //   157: ldc_w 316
    //   160: astore 15
    //   162: aload 19
    //   164: aload 15
    //   166: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc 89
    //   172: iconst_2
    //   173: aload 6
    //   175: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iconst_0
    //   182: istore 12
    //   184: aload 18
    //   186: ifnull +247 -> 433
    //   189: aload 18
    //   191: invokeinterface 177 1 0
    //   196: ifle +237 -> 433
    //   199: aload 18
    //   201: invokeinterface 177 1 0
    //   206: iconst_1
    //   207: if_icmple +12 -> 219
    //   210: aload 18
    //   212: aload_0
    //   213: getfield 48	abwi:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   216: invokestatic 325	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   219: aload_0
    //   220: getfield 120	abwi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: bipush 51
    //   225: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   228: checkcast 331	amsw
    //   231: aload 18
    //   233: iconst_0
    //   234: invokeinterface 180 2 0
    //   239: checkcast 147	msf/msgcomm/msg_comm$Msg
    //   242: getfield 335	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   245: invokevirtual 338	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   248: checkcast 337	msf/msgcomm/msg_comm$MsgHead
    //   251: getfield 341	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   254: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   257: invokevirtual 344	amsw:a	(J)V
    //   260: aload_0
    //   261: getfield 347	abwi:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   264: aload 16
    //   266: iconst_0
    //   267: invokevirtual 352	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   270: astore 19
    //   272: aload 19
    //   274: monitorenter
    //   275: aload_0
    //   276: aload 16
    //   278: aload 17
    //   280: lload 13
    //   282: iload 11
    //   284: iload_2
    //   285: iload_3
    //   286: invokespecial 355	abwi:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   289: astore 16
    //   291: aload 16
    //   293: getfield 361	android/util/Pair:first	Ljava/lang/Object;
    //   296: checkcast 281	java/lang/String
    //   299: astore 15
    //   301: aload 16
    //   303: getfield 364	android/util/Pair:second	Ljava/lang/Object;
    //   306: checkcast 366	java/lang/Integer
    //   309: invokevirtual 369	java/lang/Integer:intValue	()I
    //   312: istore 10
    //   314: aload 19
    //   316: monitorexit
    //   317: aload_0
    //   318: iload_1
    //   319: aload 15
    //   321: aload 18
    //   323: iload 11
    //   325: invokespecial 372	abwi:a	(BLjava/lang/String;Ljava/util/List;Z)V
    //   328: iload 12
    //   330: istore 11
    //   332: iload_2
    //   333: ifeq +22 -> 355
    //   336: aload_0
    //   337: iload_1
    //   338: iload 8
    //   340: lload 13
    //   342: aload 17
    //   344: aload 15
    //   346: iload 10
    //   348: aload 18
    //   350: iload 11
    //   352: invokespecial 375	abwi:a	(BIJLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;ILjava/util/List;Z)V
    //   355: iload 9
    //   357: iconst_1
    //   358: iadd
    //   359: istore 9
    //   361: goto -358 -> 3
    //   364: iconst_0
    //   365: istore 11
    //   367: goto -270 -> 97
    //   370: aload 18
    //   372: invokeinterface 177 1 0
    //   377: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: astore 15
    //   382: goto -220 -> 162
    //   385: astore 15
    //   387: aload 19
    //   389: monitorexit
    //   390: aload 15
    //   392: athrow
    //   393: astore 15
    //   395: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -43 -> 355
    //   401: ldc 89
    //   403: iconst_2
    //   404: new 91	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 380
    //   414: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 15
    //   419: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aload 15
    //   427: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -75 -> 355
    //   433: aload_0
    //   434: iload_1
    //   435: aload 17
    //   437: aload 16
    //   439: iconst_0
    //   440: invokespecial 382	abwi:a	(BLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;I)I
    //   443: istore 10
    //   445: iconst_1
    //   446: istore 11
    //   448: aload 16
    //   450: astore 15
    //   452: goto -120 -> 332
    //   455: lload 4
    //   457: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	abwi
    //   0	458	1	paramByte	byte
    //   0	458	2	paramBoolean1	boolean
    //   0	458	3	paramBoolean2	boolean
    //   0	458	4	paramLong	long
    //   0	458	6	paramStringBuilder	StringBuilder
    //   0	458	7	paramList	List<msg_comm.UinPairMsg>
    //   0	458	8	paramInt	int
    //   1	359	9	k	int
    //   312	132	10	m	int
    //   95	352	11	bool1	boolean
    //   182	147	12	bool2	boolean
    //   60	281	13	l	long
    //   160	221	15	localObject1	Object
    //   385	6	15	localObject2	Object
    //   393	33	15	localException	Exception
    //   450	1	15	localObject3	Object
    //   45	404	16	localObject4	Object
    //   32	404	17	localUinPairMsg	msg_comm.UinPairMsg
    //   70	301	18	localList	List
    // Exception table:
    //   from	to	target	type
    //   275	317	385	finally
    //   387	390	385	finally
    //   260	275	393	java/lang/Exception
    //   390	393	393	java/lang/Exception
  }
  
  private long a(String paramString, int paramInt)
  {
    long l = -1L;
    if (paramInt == 1006)
    {
      paramString = ContactUtils.getUinByPhoneNum(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.valueOf(paramString).longValue();
      }
      return l;
    }
    return Long.valueOf(paramString).longValue();
  }
  
  /* Error */
  private long a(msg_comm.Msg paramMsg, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 151	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   4: invokevirtual 156	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 153	tencent/im/msg/im_msg_body$MsgBody
    //   10: getfield 160	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   13: invokevirtual 163	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 162	tencent/im/msg/im_msg_body$RichText
    //   19: getfield 167	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 172	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore_1
    //   26: lload_2
    //   27: lstore 5
    //   29: aload_1
    //   30: ifnull +121 -> 151
    //   33: aload_1
    //   34: invokeinterface 177 1 0
    //   39: istore 4
    //   41: lload_2
    //   42: lstore 5
    //   44: iload 4
    //   46: ifle +105 -> 151
    //   49: iconst_0
    //   50: istore 4
    //   52: iload 4
    //   54: aload_1
    //   55: invokeinterface 177 1 0
    //   60: if_icmpge +101 -> 161
    //   63: aload_1
    //   64: iload 4
    //   66: invokeinterface 180 2 0
    //   71: checkcast 182	tencent/im/msg/im_msg_body$Elem
    //   74: astore 7
    //   76: aload 7
    //   78: getfield 412	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   81: invokevirtual 415	tencent/im/msg/im_msg_body$ElemFlags2:has	()Z
    //   84: ifeq +74 -> 158
    //   87: aload 7
    //   89: getfield 412	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   92: invokevirtual 416	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: checkcast 414	tencent/im/msg/im_msg_body$ElemFlags2
    //   98: getfield 419	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   101: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   104: ifeq +54 -> 158
    //   107: aload 7
    //   109: getfield 412	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   112: invokevirtual 416	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 414	tencent/im/msg/im_msg_body$ElemFlags2
    //   118: getfield 419	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   121: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   124: lstore 5
    //   126: lload 5
    //   128: lstore_2
    //   129: iload 4
    //   131: iconst_1
    //   132: iadd
    //   133: istore 4
    //   135: goto -83 -> 52
    //   138: astore_1
    //   139: ldc 89
    //   141: iconst_2
    //   142: ldc 226
    //   144: aload_1
    //   145: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: lload_2
    //   149: lstore 5
    //   151: lload 5
    //   153: lreturn
    //   154: astore_1
    //   155: goto -16 -> 139
    //   158: goto -29 -> 129
    //   161: lload_2
    //   162: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	abwi
    //   0	163	1	paramMsg	msg_comm.Msg
    //   0	163	2	paramLong	long
    //   39	95	4	k	int
    //   27	125	5	l	long
    //   74	34	7	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	26	138	java/lang/Throwable
    //   33	41	138	java/lang/Throwable
    //   52	126	154	java/lang/Throwable
  }
  
  private long a(msg_svc.PbGetRoamMsgResp paramPbGetRoamMsgResp, ArrayList<msg_comm.Msg> paramArrayList, long paramLong)
  {
    if (!paramArrayList.isEmpty())
    {
      paramArrayList = (msg_comm.Msg)paramArrayList.get(0);
      paramLong = amwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)paramArrayList.msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)paramArrayList.msg_head.get()).to_uin.get(), paramPbGetRoamMsgResp.peer_uin.get());
    }
    return paramLong;
  }
  
  private Pair<String, Integer> a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    bbkm localbbkm = new bbkm(l5, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localbbkm.jdField_e_of_type_Boolean = true;
    localbbkm.a(1000, localHashMap);
    localbbkm.a(1001, localHashSet);
    int n = 0;
    long l2 = -1L;
    Object localObject2 = paramString;
    int k = 0;
    long l1 = -1L;
    for (;;)
    {
      if (n < localArrayList2.size()) {}
      for (;;)
      {
        long l4;
        int m;
        try
        {
          localObject4 = (msg_comm.Msg)localArrayList2.get(n);
          localObject1 = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
          if (!((msg_comm.Msg)localObject4).msg_head.has())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + n + "] : msg doesn't has msgHead.");
            break;
          }
          l3 = ((msg_comm.MsgHead)localObject1).to_uin.get();
          l6 = ((msg_comm.MsgHead)localObject1).from_uin.get();
          l4 = ((msg_comm.MsgHead)localObject1).from_uin.get();
          l8 = ((msg_comm.MsgHead)localObject1).msg_time.get();
          if (l8 <= paramLong) {
            break label874;
          }
          paramBoolean3 = false;
          bool = false;
          l7 = amwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l4, l3, paramUinPairMsg.peer_uin.get(), paramUinPairMsg);
          localbbkm.i = true;
          localObject1 = String.valueOf(l7);
          m = k;
          l4 = l1;
          l3 = l2;
        }
        catch (Exception localException4)
        {
          Object localObject4;
          long l6;
          long l8;
          long l7;
          int i1;
          localObject1 = localObject2;
          l3 = l2;
          l2 = l1;
          localObject2 = localException4;
        }
        try
        {
          if (a(localStringBuilder, n, bool, l8, l7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label887;
          }
          m = k;
          l4 = l1;
          l3 = l2;
          localbbkm.jdField_a_of_type_Boolean = bool;
          m = k;
          l4 = l1;
          l3 = l2;
          localbbkm.jdField_e_of_type_Long = l7;
          m = k;
          l4 = l1;
          l3 = l2;
          localbbkm.h = paramBoolean3;
          m = k;
          l4 = l1;
          l3 = l2;
          localObject2 = a((msg_comm.Msg)localObject4, localbbkm).iterator();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            k = m;
            l2 = l4;
          }
        }
        try
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject2).next();
            l3 = ((MessageRecord)localObject4).vipBubbleID;
            if (l3 != -1L)
            {
              paramBoolean3 = bfwr.a(((MessageRecord)localObject4).issend);
              if (paramBoolean3)
              {
                l1 = l2;
                l2 = l3;
              }
            }
          }
        }
        catch (Exception localException2)
        {
          l3 = l2;
          l2 = l1;
          break label706;
        }
        try
        {
          i1 = ((MessageRecord)localObject4).istroop;
          m = i1;
          l4 = l2;
          l3 = l1;
          paramBoolean3 = a((MessageRecord)localObject4, true);
          m = i1;
          l4 = l2;
          l3 = l1;
          a(localArrayList1, (MessageRecord)localObject4, paramBoolean3, b((MessageRecord)localObject4));
          m = i1;
          l4 = l2;
          l3 = l1;
          b((MessageRecord)localObject4, paramBoolean3);
          m = i1;
          l4 = l2;
          l3 = l1;
          a((MessageRecord)localObject4, paramBoolean3);
          k = i1;
          l3 = l2;
          l2 = l1;
          l1 = l3;
        }
        catch (Exception localException3)
        {
          l3 = l1;
          break label706;
        }
        l2 = l1;
        l1 = l3;
        continue;
        a(l2, l1, l6, l7, (MessageRecord)localObject4);
        long l3 = l2;
        l2 = l1;
        l1 = l3;
        continue;
        break label887;
        label706:
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", (Throwable)localObject2);
        }
        l1 = l2;
        l2 = l3;
        break label887;
        paramUinPairMsg = a(paramString, (String)localObject2);
        a(l5, localHashMap, localHashSet);
        a(paramBoolean1, paramBoolean2, localArrayList1, str, paramUinPairMsg);
        a(localArrayList1, k);
        a(paramString, localArrayList1, k);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + k);
        }
        return new Pair(paramUinPairMsg, Integer.valueOf(k));
        label874:
        paramBoolean3 = true;
        boolean bool = true;
      }
      localObject1 = localException3;
      label887:
      n += 1;
      Object localObject3 = localObject1;
    }
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((amwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList = paramList.iterator();
      Object localObject;
      int k;
      while (paramList.hasNext())
      {
        localObject = (msg_comm.Msg)paramList.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          k = 0;
          while (k < localList.size())
          {
            localObject = (MessageRecord)localList.get(k);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList.remove();
            }
            k += 1;
          }
        }
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        k = 0;
        while (k < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(k);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList.remove();
          }
          k += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList1);
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {
      for (;;)
      {
        int k;
        try
        {
          if (this.jdField_a_of_type_JavaUtilHashSet == null)
          {
            this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
            paramSharedPreferences = paramSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgDateRecentUinList", "");
            String[] arrayOfString = paramSharedPreferences.split("\\|");
            int m = arrayOfString.length;
            k = 0;
            paramString = paramSharedPreferences;
            if (k < m)
            {
              paramString = arrayOfString[k];
              if ((paramString.length() <= 0) || (Long.parseLong(paramString) <= 0L)) {
                break label129;
              }
              this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
              break label129;
            }
          }
          return paramString;
        }
        finally {}
        label129:
        k += 1;
      }
    }
    return paramString;
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString, MessageRecord paramMessageRecord)
  {
    if (!this.jdField_b_of_type_JavaUtilHashSet.contains(paramMessageRecord.frienduin))
    {
      this.jdField_b_of_type_JavaUtilHashSet.add(paramMessageRecord.frienduin);
      if (paramString.length() == 0) {}
      for (paramString = paramMessageRecord.frienduin;; paramString = paramString + "|" + paramMessageRecord.frienduin)
      {
        paramSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgLBSFriendRecentUinList", paramString);
        paramSharedPreferences.edit().commit();
        return paramString;
      }
    }
    return paramString;
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (!paramString2.equals("0")) {}
    }
    else
    {
      str = paramString1;
    }
    return str;
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetMsgResp localPbGetMsgResp = new msg_svc.PbGetMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetMsgResp)localPbGetMsgResp.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB : decode pb:", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  @Nullable
  private oidb_c2c_searcher.RspBody a(msg_svc.PbSearchRoamMsgInCloudResp paramPbSearchRoamMsgInCloudResp, oidb_c2c_searcher.RspBody paramRspBody)
  {
    if (paramPbSearchRoamMsgInCloudResp.serialize_rspbody.has()) {
      try
      {
        paramPbSearchRoamMsgInCloudResp = (oidb_c2c_searcher.RspBody)paramRspBody.mergeFrom(paramPbSearchRoamMsgInCloudResp.serialize_rspbody.get().toByteArray());
        return paramPbSearchRoamMsgInCloudResp;
      }
      catch (InvalidProtocolBufferMicroException paramPbSearchRoamMsgInCloudResp)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException oidb_search! ", paramPbSearchRoamMsgInCloudResp);
        }
        return null;
      }
      catch (OutOfMemoryError paramPbSearchRoamMsgInCloudResp)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! oidb_search!", paramPbSearchRoamMsgInCloudResp);
        }
        return null;
      }
    }
    return null;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
      Object localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
      localObject2 = ((String)localObject2).split("\\|");
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject2.length >= 6) && (localObject1.length >= 6))
      {
        this.jdField_a_of_type_Int = Integer.parseInt(localObject2[0]);
        this.jdField_b_of_type_Int = Integer.parseInt(localObject2[1]);
        this.jdField_c_of_type_Int = Integer.parseInt(localObject2[2]);
        this.jdField_d_of_type_Int = Integer.parseInt(localObject2[3]);
        this.f = Integer.parseInt(localObject1[0]);
        this.g = Integer.parseInt(localObject1[1]);
        this.h = Integer.parseInt(localObject1[2]);
        this.i = Integer.parseInt(localObject1[3]);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_bank", 4, "DealOneWayMessageNotify,date:[" + this.jdField_a_of_type_Int + "|" + this.jdField_b_of_type_Int + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_d_of_type_Int + "],LBS:[" + this.f + "|" + this.g + "|" + this.h + "|" + this.i + "]");
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt2, List<msg_comm.Msg> paramList, boolean paramBoolean)
  {
    if (((paramInt2 != 1006) || (((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(paramString) == null)) || (abwz.a(paramInt2) == 1032)) {}
    for (int k = 0;; k = paramInt2)
    {
      paramUinPairMsg = atym.a(paramUinPairMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "update c2c unread , pkguin=" + paramUinPairMsg + ", pkgUinType=" + paramInt2 + ", lastReadTime=" + paramLong);
      }
      a(paramUinPairMsg, paramList, paramBoolean, k);
      paramString = new Message();
      paramString.what = 1;
      paramList = new Bundle();
      paramList.putLong("update_unread_time", paramLong);
      paramList.putString("update_unread_uin", paramUinPairMsg);
      paramList.putInt("update_unread_type", k);
      paramString.setData(paramList);
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      if (paramByte <= 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramList.a(paramString, paramBoolean);
        if (paramInt1 != 2) {
          break;
        }
        this.jdField_b_of_type_JavaUtilSet.add(paramUinPairMsg);
        return;
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramUinPairMsg);
      return;
    }
  }
  
  private void a(byte paramByte, String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(paramString);
      long l2 = ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_time.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + paramString + "lastBreakTime:" + l1 + " currentBreakTime:" + l2 + " channelType:" + paramByte);
      }
      if ((l1 == 0L) || (l2 < l1))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramString, l2, 0L);
        if (paramByte > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(paramString, l2);
        }
      }
      if (paramByte == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c();
      }
    }
  }
  
  private void a(byte paramByte, boolean paramBoolean, int paramInt)
  {
    if (paramByte <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c();
      if (paramBoolean)
      {
        a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a());
        if (paramInt != 2) {
          break label100;
        }
        this.jdField_b_of_type_JavaUtilSet.clear();
      }
    }
    for (;;)
    {
      MsgAutoMonitorUtil.getInstance().markC2CFinishTime();
      a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().i();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB handleMsgNew()");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false, 0);
      }
      return;
      label100:
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(4016, true, null);
      a(4001, true, null);
      return;
    case 1: 
      a(4001, true, null);
      return;
    }
    a(4016, true, null);
  }
  
  private void a(int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramArrayList.size() == 0) && (paramInt > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
      }
      MessageForText localMessageForText = (MessageForText)bbli.a(-1000);
      localMessageForText.msgtype = -1000;
      localMessageForText.msg = "";
      paramArrayList.add(localMessageForText);
    }
  }
  
  private void a(int paramInt, Set<ConversationInfo> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)paramSet.next();
      if ((localConversationInfo.uin != null) && (localConversationInfo.type != 1036) && (abwz.a(localConversationInfo.type) != 1032) && ((paramInt != 1) || (localConversationInfo.type != 1008)) && ((paramInt != 2) || (localConversationInfo.type == 1008)) && ((paramInt == 2) || (this.jdField_a_of_type_JavaUtilSet.size() <= 0) || (!this.jdField_a_of_type_JavaUtilSet.contains(localConversationInfo.uin))) && ((paramInt != 2) || (this.jdField_b_of_type_JavaUtilSet.size() <= 0) || (!this.jdField_b_of_type_JavaUtilSet.contains(localConversationInfo.uin)))) {
        a(localConversationInfo);
      }
    }
  }
  
  private void a(int paramInt, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, MessageHandler paramMessageHandler, bbkm parambbkm)
  {
    bbls localbbls = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getRegistry().a(paramInt);
    if (localbbls != null) {
      localbbls.a(paramMessageHandler, paramMsg, paramArrayList, parambbkm);
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2002)
    {
      b(paramLong1, paramLong2, paramLong3, paramLong4, paramMessageRecord);
      return;
    }
    paramMessageRecord.vipBubbleID = 0L;
  }
  
  private void a(long paramLong, HashMap<Long, msg_comm.Msg> paramHashMap, HashSet<Long> paramHashSet)
  {
    if (!paramHashMap.isEmpty())
    {
      paramHashSet = paramHashSet.iterator();
      Object localObject;
      while (paramHashSet.hasNext())
      {
        localObject = (Long)paramHashSet.next();
        paramHashMap.remove(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject);
        }
      }
      paramHashSet = paramHashMap.keySet().iterator();
      while (paramHashSet.hasNext())
      {
        localObject = (msg_comm.Msg)paramHashMap.get((Long)paramHashSet.next());
        if ((((msg_comm.Msg)localObject).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject).msg_body.get()).msg_content.has())) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).msg_time.get());
        }
      }
    }
  }
  
  private void a(bbkm parambbkm, MessageRecord paramMessageRecord)
  {
    if ((1 == parambbkm.jdField_d_of_type_Int) && (abwz.t(paramMessageRecord.istroop)) && (abwz.a(paramMessageRecord.istroop) != 1032) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramMessageRecord.frienduin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramMessageRecord.frienduin, abwz.a(paramMessageRecord.istroop), abwz.a(abwz.a(paramMessageRecord.istroop)))))
    {
      abwz.a(paramMessageRecord, true);
      return;
    }
    abwz.a(paramMessageRecord, false);
  }
  
  private void a(ConversationInfo paramConversationInfo)
  {
    if ((abwz.d(paramConversationInfo.type)) && (abwp.c(paramConversationInfo) > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "update c2c unread , frienduin=" + paramConversationInfo.uin + ", friendUinType=" + paramConversationInfo.type);
      }
      if (paramConversationInfo.uin.length() > 4) {
        break label77;
      }
    }
    label77:
    do
    {
      Object localObject;
      do
      {
        return;
        if (paramConversationInfo.type != 1001) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().n(paramConversationInfo.uin);
      } while ((localObject == null) || (localObject.length <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "clean the unreadcount of lbs : " + localObject);
      }
      do
      {
        for (;;)
        {
          localObject = new Message();
          ((Message)localObject).what = 1;
          Bundle localBundle = new Bundle();
          localBundle.putLong("update_unread_time", 9223372036854775807L);
          localBundle.putString("update_unread_uin", paramConversationInfo.uin);
          localBundle.putInt("update_unread_type", paramConversationInfo.type);
          ((Message)localObject).setData(localBundle);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((Message)localObject, true);
          return;
          if (paramConversationInfo.type != 10002) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "processOffline : ");
          }
        }
      } while (!paramConversationInfo.isImax);
    } while (!QLog.isColorLevel());
    QLog.d("ImaxAdvertisement", 2, "processOffline 0xf9 no need syn unreadtime");
  }
  
  private void a(MessageForApollo paramMessageForApollo, alnr paramalnr)
  {
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      k = paramalnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (paramMessageForApollo.msgType != 0) {
        break label110;
      }
      paramalnr = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    for (;;)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(paramMessageForApollo.mApolloMessage.peer_uin), 0, paramMessageForApollo.msgType, new String[] { paramalnr, Integer.toString(k), Integer.toString(alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      label110:
      if (paramMessageForApollo.msgType == 2) {
        paramalnr = "" + paramMessageForApollo.gameId;
      } else {
        paramalnr = "";
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPoke))
    {
      if ((!paramMessageRecord.isread) && (!paramMessageRecord.isSend())) {
        ((MessageForPoke)paramMessageRecord).isPlayed = false;
      }
      ((MessageForPoke)paramMessageRecord).initMsg();
    }
  }
  
  private void a(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, alnr paramalnr, StringBuilder paramStringBuilder)
  {
    boolean bool2 = paramMessageForApollo.isSend();
    ApolloBaseInfo localApolloBaseInfo;
    long l;
    if (paramMessageForApollo.mApolloMessage.peer_uin != 0L)
    {
      boolean bool1 = true;
      if ((!(bool1 & bool2)) || (paramMessageForApollo.mApolloMessage.peer_uin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
        break label323;
      }
      localApolloBaseInfo = paramalnr.b(paramMessageForApollo.mApolloMessage.peer_uin + "");
      l = paramMessageForApollo.mApolloMessage.peer_ts;
    }
    for (int k = paramMessageForApollo.mApolloMessage.peer_status;; k = paramMessageForApollo.mApolloMessage.sender_status)
    {
      if ((QLog.isColorLevel()) && (localApolloBaseInfo != null)) {
        paramStringBuilder.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(paramMessageRecord.time).append(", msg ts: ").append(l).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(k);
      }
      if (a(paramMessageRecord, paramMessageForApollo, localApolloBaseInfo, l, k))
      {
        paramalnr.a(localApolloBaseInfo);
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
        }
      }
      return;
      k = 0;
      break;
      label323:
      localApolloBaseInfo = paramalnr.b(paramMessageForApollo.senderuin);
      l = paramMessageForApollo.mApolloMessage.sender_ts;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramMessageRecord.istroop == 1008)) {
      anxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte b1 = 0;
    int k = 2;
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isPullRoamMsg", true);
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("needNofityConversation", true);
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    long l = System.currentTimeMillis();
    msg_svc.PbGetMsgResp localPbGetMsgResp = a((byte[])paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localPbGetMsgResp == null) || (!localPbGetMsgResp.result.has()) || (localPbGetMsgResp.result.get() != 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder.setLength(0);
        localObject = localStringBuilder.append("<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" msgStruct.cReplyCode: ");
        if (localPbGetMsgResp != null) {
          break label216;
        }
        paramObject = "null";
        localObject = ((StringBuilder)localObject).append(paramObject).append(",hasSyncCookie:");
        if (localPbGetMsgResp != null) {
          break label231;
        }
      }
      label216:
      label231:
      for (paramObject = "null";; paramObject = Boolean.valueOf(localPbGetMsgResp.sync_cookie.has()))
      {
        ((StringBuilder)localObject).append(paramObject).append(",isPullRoam:").append(bool2).append(",needNofityConversation:").append(bool3);
        QLog.e("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
        paramObject = Integer.valueOf(localPbGetMsgResp.result.get());
        break;
      }
    }
    Object localObject = localPbGetMsgResp.uin_pair_msgs.get();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.g = 0;
    if (localPbGetMsgResp.sync_flag.has()) {
      k = localPbGetMsgResp.sync_flag.get();
    }
    if (k < 2) {
      b1 = (byte)1;
    }
    paramFromServiceMsg = null;
    if (localPbGetMsgResp.sync_cookie.has()) {
      paramFromServiceMsg = localPbGetMsgResp.sync_cookie.get().toByteArray();
    }
    int m = a(localPbGetMsgResp, paramFromServiceMsg);
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a()) {
      bool1 = true;
    }
    if (b1 > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(b1, paramFromServiceMsg, k, bool2, bool3, bool1, null, m, null);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" msgStruct.cReplyCode: ").append(localPbGetMsgResp.result.get()).append(" hasSyncCookie:").append(localPbGetMsgResp.sync_cookie.has()).append(" channelType:").append(b1).append(" cSyncFlag:").append(k).append(" isPullRoam").append(bool2).append(",needNofityConversation:").append(bool3).append(" uinPairMsg size:").append(((List)localObject).size()).append(", dataHash=@").append(Integer.toHexString(paramObject.hashCode())).append("pullMsgType").append(m);
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
    l = a(b1, bool2, bool4, l, localStringBuilder, (List)localObject, m);
    a(b1, bool2, m);
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "decodecMsg costTime = [" + l + "]");
    }
    anll.a("actC2cDecodeCost", l);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int k = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (k < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + k);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", k + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().sendPbReq(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetRoamMsgResp paramPbGetRoamMsgResp, Long paramLong, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString, int paramInt2, List<msg_comm.Msg> paramList)
  {
    amwo localamwo = (amwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    int k = 0;
    if (((paramInt2 != 0) && (paramInt2 != 1)) || (paramInt2 == 0)) {}
    try
    {
      a(paramString, paramList);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramString, paramLong.longValue(), paramPbGetRoamMsgResp.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramPbGetRoamMsgResp.random.get(), 1, localamwo.a(), localamwo.b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), paramInt1, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (!QLog.isColorLevel()) {
        break label227;
      }
      QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
      for (k = 0; k == 0; k = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(paramString);
        paramBundle.putInt("SVR_CODE", paramInt2);
        if (paramPbGetRoamMsgResp.errmsg.has()) {
          paramBundle.putString("SVR_MSG", paramPbGetRoamMsgResp.errmsg.get());
        }
        a(1004, false, paramBundle);
        return;
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        ArrayList localArrayList1 = new ArrayList();
        a(paramList, l1, l2, localArrayList1);
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList1, Long.valueOf(paramString).longValue(), true);
        ArrayList localArrayList2 = new ArrayList();
        l1 = a(paramPbGetRoamMsgResp, localArrayList1, Long.parseLong(paramString));
        localArrayList2.addAll((Collection)a(localArrayList1, localList, l1, paramLong.longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        paramLong = new bbkm(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        paramLong.h = true;
        a(localArrayList1, localArrayList2, paramLong);
        a(paramBoolean2, paramString, localamwo, localArrayList2);
        paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(paramPbGetRoamMsgResp.peer_uin.get()));
        if ((paramLong == null) || (((Long)paramLong.first).longValue() > paramPbGetRoamMsgResp.last_msgtime.get())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(paramPbGetRoamMsgResp.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
        }
        localamwo.a().b(paramString, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + paramList.size() + ", dayList size = " + localArrayList1.size() + ", loopList size=" + localArrayList2.size());
        }
        paramBundle.putInt("MSG_COUNT", paramInt1 - localArrayList2.size());
        a(1004, true, paramBundle);
      }
    }
    catch (OutOfMemoryError paramToServiceMsg)
    {
      for (;;)
      {
        label227:
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
        }
        k = 0;
      }
    }
    paramList = new ArrayList(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramString))
    {
      paramList.addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(paramString));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(paramString);
    }
    if (paramList.isEmpty())
    {
      new Object[2][0] = Boolean.valueOf(true);
      paramBundle.putBoolean("NO_MSG", Boolean.TRUE.booleanValue());
      a(1004, false, paramBundle);
      return;
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramLong == 0L) {}
    long l;
    do
    {
      do
      {
        return;
        if (AppConstants.SYSTEM_MSG_UIN.equals(paramString))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
          return;
        }
      } while ((paramInt == 1001) && (Long.valueOf(paramString).longValue() > AppConstants.NOW_LIVE_TIP_UIN_BASE));
      if ((paramInt == 1001) && ((abwz.c(paramString)) || (abwz.d(paramString))))
      {
        if (abwz.e(paramString))
        {
          aquu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
          return;
        }
        if (abwz.d(paramString))
        {
          aquu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
        aquu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
        return;
      }
      l = a(paramString, paramInt);
    } while (l == -1L);
    if (paramInt == 10007)
    {
      atym.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbMsgReadedReportReq, paramString, paramLong);
      return;
    }
    Object localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l);
    ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
    a(paramString, paramInt, (msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject);
    paramString = new msg_svc.PbC2CReadedReportReq();
    paramString.pair_info.add((MessageMicro)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
    if (localObject != null) {
      paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
    }
    paramPbMsgReadedReportReq.c2c_read_report.set(paramString);
  }
  
  private void a(String paramString, int paramInt, msg_svc.PbC2CReadedReportReq.UinPairReadInfo paramUinPairReadInfo)
  {
    if (paramInt == 1024)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(paramString);
      if (paramString != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.bytes2HexStr(paramString) + ",length:" + paramString.length);
        }
        paramUinPairReadInfo.crm_sig.set(ByteStringMicro.copyFrom(paramString));
      }
    }
  }
  
  private void a(String paramString, ArrayList<MessageRecord> paramArrayList, int paramInt)
  {
    if ((paramInt == 0) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        azxb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0, localMessageRecord);
      }
    }
  }
  
  private void a(String paramString, List<msg_comm.Msg> paramList)
  {
    if (paramList.size() > 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramString)) {
        break label174;
      }
      paramString = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(paramString);
      if (paramString.size() != 0) {
        break label57;
      }
      paramString.addAll(0, paramList);
    }
    label57:
    while ((((msg_comm.MsgHead)((msg_comm.Msg)paramString.get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)paramString.get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_seq.get())) {
      return;
    }
    paramString.addAll(0, paramList);
    return;
    label174:
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(paramString, paramList);
  }
  
  private void a(String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (ConversationInfo.reportPublicaccoutTypeError(paramString, paramInt)))
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("reportPublicaccoutTypeError").append(" uin :").append(paramString);
      localStringBuilder.append(" type :").append(paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramString = (msg_comm.Msg)paramList.get(0);
        if (paramString.msg_head.has())
        {
          paramString = (msg_comm.MsgHead)paramString.msg_head.get();
          localStringBuilder.append(" msgType :").append(paramString.msg_type.get());
          localStringBuilder.append(" msgSeq :").append(paramString.msg_seq.get());
          localStringBuilder.append(" msgUid :").append(paramString.msg_uid.get());
          localStringBuilder.append(" msgTime :").append(paramString.msg_time.get());
          if (paramString.c2c_tmp_msg_head.has())
          {
            paramString = (msg_comm.C2CTmpMsgHead)paramString.c2c_tmp_msg_head.get();
            localStringBuilder.append(" serviceType :").append(paramString.service_type.get());
            localStringBuilder.append(" c2cType :").append(paramString.c2c_type.get());
          }
        }
      }
      QLog.e("Q.msg.C2CMessageProcessor", 1, localStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, int paramInt)
  {
    if (paramInt == 1008)
    {
      amxz localamxz = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localamxz != null) {
        localamxz.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList1, long paramLong1, long paramLong2, ArrayList<msg_comm.Msg> paramArrayList2)
  {
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      msg_comm.Msg localMsg = (msg_comm.Msg)paramArrayList1.next();
      if (!localMsg.msg_head.has())
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
        }
      }
      else
      {
        long l = ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.get();
        if ((l >= paramLong1) && (l <= paramLong2)) {
          paramArrayList2.add(localMsg);
        }
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, long paramLong, bbkm parambbkm, ArrayList<MessageRecord> paramArrayList1)
  {
    Iterator localIterator = paramArrayList.iterator();
    label118:
    long l1;
    label161:
    long l2;
    while (localIterator.hasNext())
    {
      paramArrayList = (msg_comm.Msg)localIterator.next();
      if (paramArrayList != null) {}
      for (;;)
      {
        try
        {
          if ((paramArrayList.msg_head.has()) && (paramArrayList.msg_body.has())) {
            break label161;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
          if (paramArrayList != null) {
            break label118;
          }
          paramArrayList = " msg=null";
          QLog.d("Q.msg.C2CMessageProcessor", 2, paramArrayList);
        }
        catch (Exception paramArrayList) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud decodeSinglePBMsg_C2C error,", paramArrayList);
        break;
        paramArrayList = " msg.msg_head:" + paramArrayList.msg_head + " msg.msg_body:" + paramArrayList.msg_body.has();
      }
      Object localObject = (msg_comm.MsgHead)paramArrayList.msg_head.get();
      l1 = ((msg_comm.MsgHead)localObject).to_uin.get();
      l2 = ((msg_comm.MsgHead)localObject).from_uin.get();
      if ((l1 == paramLong) || (l2 == paramLong)) {
        break label267;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C msg uin not selfUin and toUin : ");
      }
    }
    for (;;)
    {
      parambbkm.jdField_e_of_type_Long = l1;
      paramArrayList = a(paramArrayList, parambbkm);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break;
      }
      paramArrayList1.addAll(paramArrayList);
      break;
      label267:
      do
      {
        break;
        return;
      } while (l1 != paramLong);
      l1 = l2;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      d(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForMarketFace)) {
        avsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)paramMessageRecord);
      }
      if (AppConstants.NEW_KANDIAN_UIN.equals(paramMessageRecord.frienduin)) {
        paramMessageRecord.time = NetConnInfoCenter.getServerTime();
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessageRecord.frienduin)) {
        ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).b(paramMessageRecord);
      }
      paramArrayList.add(paramMessageRecord);
      int k = KandianMergeManager.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((k == 0) || (k == 1))
      {
        paramMessageRecord = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(paramMessageRecord);
        if (paramMessageRecord != null) {
          paramArrayList.add(paramMessageRecord);
        }
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, bbkm parambbkm)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (msg_comm.Msg)paramArrayList.next();
      try
      {
        localObject = a((msg_comm.Msg)localObject, parambbkm);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        paramArrayList1.addAll((Collection)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<DelMsgInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList2)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int m = paramArrayList1.size();
      int k = 0;
      if (k < m)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
        }
        if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2)) {}
        for (;;)
        {
          k += 1;
          break;
          localMessageRecord.isread = false;
          paramArrayList2.add(localMessageRecord);
          DelMsgInfo localDelMsgInfo = new DelMsgInfo();
          localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
          localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
          localDelMsgInfo.uMsgTime = localMessageRecord.time;
          paramArrayList.add(localDelMsgInfo);
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean1, QQMessageFacade paramQQMessageFacade, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((a(localMessageRecord)) && (paramQQMessageFacade != null)) {
        if (localMessageRecord.istroop == 1010)
        {
          paramString1 = b(paramSharedPreferences, paramString1, localMessageRecord);
          a(paramBoolean1, paramShort, paramBoolean2, paramSharedPreferences, localMessageRecord);
        }
        else if ((localMessageRecord.istroop == 1001) || (localMessageRecord.istroop == 10002))
        {
          paramString2 = a(paramSharedPreferences, paramString2, localMessageRecord);
          b(paramBoolean1, paramShort, paramBoolean2, paramSharedPreferences, localMessageRecord);
        }
      }
    }
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, ArrayList<MessageRecord> paramArrayList, bbkm parambbkm)
  {
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (msg_comm.Msg)localIterator.next();
        try
        {
          paramList = a(paramList, parambbkm);
          paramList1 = paramList;
          if (paramList != null)
          {
            paramList1 = paramList;
            if (paramList.size() > 0)
            {
              paramArrayList.addAll(paramList);
              paramList1 = paramList;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramList = paramList1;
            if (QLog.isColorLevel())
            {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
              paramList = paramList1;
            }
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, bbkm parambbkm, MessageRecord paramMessageRecord)
  {
    if (parambbkm.jdField_b_of_type_Int > 0) {
      paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(parambbkm.jdField_b_of_type_Int));
    }
    int k = bblf.c(paramMsg);
    if (k > 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(k));
    }
    k = bblf.b(paramMsg);
    if (k >= 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(k));
    }
    k = bblf.d(paramMsg);
    if (k >= 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_face_id", String.valueOf(k));
    }
  }
  
  private void a(msg_comm.Msg paramMsg, bbkm parambbkm, ArrayList<MessageRecord> paramArrayList)
  {
    if ((parambbkm.jdField_c_of_type_Int == 1008) && (paramMsg.msg_body.has()))
    {
      paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
      if (paramMsg.rich_text.has())
      {
        paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
        if (paramMsg.elems.has())
        {
          paramMsg = paramMsg.elems.get().iterator();
          while (paramMsg.hasNext())
          {
            parambbkm = (im_msg_body.Elem)paramMsg.next();
            if (parambbkm.pub_acc_info.has())
            {
              int k = parambbkm.pub_acc_info.uint32_is_inter_num.get();
              paramMsg = parambbkm.pub_acc_info.string_msg_template_id.get();
              if (k != 0)
              {
                parambbkm = paramArrayList.iterator();
                while (parambbkm.hasNext()) {
                  ((MessageRecord)parambbkm.next()).saveExtInfoToExtStr("inter_num", String.valueOf(k));
                }
              }
              parambbkm = paramArrayList.iterator();
              while (parambbkm.hasNext()) {
                ((MessageRecord)parambbkm.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, bbkm parambbkm, ArrayList<MessageRecord> paramArrayList1, msg_comm.MsgHead paramMsgHead, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, ArrayList<MessageRecord> paramArrayList2, long paramLong4)
  {
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList2.next();
      if ((!a(parambbkm, localMessageRecord)) && (!a(parambbkm, paramInt1, paramLong1, paramLong2, paramInt2)))
      {
        localMessageRecord.selfuin = String.valueOf(parambbkm.jdField_a_of_type_Long);
        localMessageRecord.frienduin = String.valueOf(parambbkm.jdField_e_of_type_Long);
        localMessageRecord.senderuin = String.valueOf(parambbkm.jdField_b_of_type_Long);
        localMessageRecord.time = parambbkm.jdField_c_of_type_Long;
        localMessageRecord.shmsgseq = paramInt1;
        localMessageRecord.msgUid = paramLong2;
        localMessageRecord.istroop = parambbkm.jdField_c_of_type_Int;
        localMessageRecord.longMsgId = paramInt3;
        localMessageRecord.longMsgCount = paramInt4;
        localMessageRecord.longMsgIndex = paramInt5;
        a(parambbkm, localMessageRecord);
        if (localMessageRecord.msgtype == -2058) {
          EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (!a(parambbkm, paramInt1, paramLong1, paramLong2, paramInt2, localMessageRecord))
        {
          a(paramMsgHead, localMessageRecord);
          if ((parambbkm.jdField_c_of_type_Int == 0) && ((localMessageRecord instanceof MessageForPic))) {
            ((MessageForPic)localMessageRecord).bEnableEnc = true;
          }
          if (!a(parambbkm, paramMsgHead, paramLong1, localMessageRecord))
          {
            b(parambbkm, localMessageRecord);
            a(localMessageRecord);
            localMessageRecord.vipBubbleID = parambbkm.jdField_d_of_type_Long;
            localMessageRecord.vipBubbleDiyTextId = parambbkm.jdField_a_of_type_Int;
            localMessageRecord.vipSubBubbleId = parambbkm.jdField_b_of_type_Int;
            a(paramMsg, parambbkm, localMessageRecord);
            a(paramMsgHead, paramLong4, localMessageRecord);
            b(localMessageRecord);
            if (localMessageRecord.msgtype == -7005)
            {
              auyo.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramArrayList1.add(localMessageRecord);
              if (parambbkm.jdField_c_of_type_Int == 1036) {
                bblf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong3, paramInt1, paramLong2, paramInt2);
              }
              c(localMessageRecord);
            }
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush: no C2CCmd.");
      }
    }
    for (;;)
    {
      return;
      long l1 = localMsgHead.c2c_cmd.get();
      long l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      int k = localMsgHead.user_active.get();
      int m = localMsgHead.from_instid.get();
      Object localObject1;
      long l7;
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + k + ",fromInstid:" + m + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus = k;
        localObject1 = new ArrayList();
      }
      try
      {
        Object localObject2 = new bbkm(l7, l2, true, false, false, false);
        ((bbkm)localObject2).h = true;
        paramMsg = a(paramMsg, (bbll)localObject2);
        amwh.a(paramMsg);
        if ((paramMsg == null) || (paramMsg.size() == 0)) {
          continue;
        }
        a(paramMsg, (ArrayList)localObject1, true);
        paramMsg = new ArrayList();
        localObject2 = new ArrayList();
        a((ArrayList)localObject1, paramMsg, (ArrayList)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b((List)localObject2);
        boolean bool2 = amwh.a((ArrayList)localObject2);
        k = abwz.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
        {
          bool1 = true;
          ((QQMessageFacade)localObject1).addMessage((ArrayList)localObject2, String.valueOf(l7), bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMsgHead.msg_seq.get());
          m = paramFromServiceMsg.getRequestSsoSeq();
          paramFromServiceMsg = paramPbPushMsg.bytes_push_token.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, new Object[] { "----------handleMsgPush_PB_C2CPush get Push token = ", paramFromServiceMsg, " and use ", "OnlinePush.RespPush", " send back to server" });
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), m, paramPbPushMsg);
          if (l1 == 127L) {
            continue;
          }
          a("handleMsgPush_PB_C2CPush", true, k, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handleMsgPush_PB_C2CPush decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
          continue;
          boolean bool1 = false;
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, bbkm parambbkm, MessageHandler paramMessageHandler)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getRegistry().a().a().iterator();
    while (localIterator.hasNext()) {
      ((bbls)localIterator.next()).a(paramMessageHandler, paramMsg, paramArrayList, parambbkm);
    }
  }
  
  private void a(msg_comm.MsgHead paramMsgHead, long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1008) {}
    try
    {
      if (paramMsgHead.public_account_group_send_flag.has()) {
        paramMessageRecord.saveExtInfoToExtStr("public_account_send_flag", String.valueOf(paramMsgHead.public_account_group_send_flag.get()));
      }
      if (paramLong != -1L) {
        paramMessageRecord.saveExtInfoToExtStr("public_account_msg_id", String.valueOf(paramLong));
      }
      return;
    }
    catch (Throwable paramMsgHead)
    {
      for (;;)
      {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramMsgHead);
      }
    }
  }
  
  private void a(msg_comm.MsgHead paramMsgHead, MessageRecord paramMessageRecord)
  {
    paramMsgHead = (msg_comm.C2CTmpMsgHead)paramMsgHead.c2c_tmp_msg_head.get();
    if ((paramMsgHead != null) && (paramMsgHead.lock_display.has()) && (paramMsgHead.lock_display.get() == 1))
    {
      paramMessageRecord.extLong |= 0x1;
      paramMessageRecord.saveExtInfoToExtStr("lockDisplay", "true");
    }
  }
  
  private void a(msg_svc.PbGetOneDayRoamMsgResp paramPbGetOneDayRoamMsgResp, Bundle paramBundle, ArrayList<MessageRecord> paramArrayList, long paramLong, int paramInt)
  {
    long l;
    boolean bool3;
    boolean bool1;
    if (paramBundle != null)
    {
      l = paramBundle.getLong("UIN", 0L);
      bool3 = paramBundle.getBoolean("canUpdateEct", true);
      if (paramPbGetOneDayRoamMsgResp.iscomplete.get() == 0) {
        break label165;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label57:
      label89:
      ArrayList localArrayList;
      if ((paramInt == 0) || (paramInt == 1) || (paramInt == 4))
      {
        bool2 = true;
        if ((!bool2) || (!bool3)) {
          break label214;
        }
        if (!bool1) {
          break label177;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(l), 0L, 0L);
        paramBundle.putBoolean("complete", bool1);
        paramBundle.putBoolean("success", bool2);
        paramBundle.putLong("lowTime", paramLong);
        localArrayList = new ArrayList();
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().handleRefreshMessagelistHeadResult(String.valueOf(paramPbGetOneDayRoamMsgResp.peer_uin.get()), 0, paramArrayList, localArrayList, paramBundle);
        if (paramArrayList != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localArrayList, false);
        }
        return;
        label165:
        bool1 = false;
        continue;
        bool2 = false;
        break label57;
        label177:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(paramPbGetOneDayRoamMsgResp.peer_uin.get()), paramPbGetOneDayRoamMsgResp.last_msgtime.get(), paramPbGetOneDayRoamMsgResp.random.get());
        break label89;
        label214:
        if (bool3) {
          break label89;
        }
        if (bool1)
        {
          paramBundle.putLong("tempEct", 0L);
          paramBundle.putLong("tempRandom", 0L);
          break label89;
        }
        paramBundle.putLong("tempEct", paramPbGetOneDayRoamMsgResp.last_msgtime.get());
        paramBundle.putLong("tempRandom", paramPbGetOneDayRoamMsgResp.random.get());
      }
      catch (Exception paramPbGetOneDayRoamMsgResp)
      {
        for (;;)
        {
          paramPbGetOneDayRoamMsgResp.printStackTrace();
        }
      }
    }
  }
  
  private void a(msg_svc.PbSearchRoamMsgInCloudResp paramPbSearchRoamMsgInCloudResp, oidb_c2c_searcher.RspBody paramRspBody, int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    paramPbSearchRoamMsgInCloudResp = paramPbSearchRoamMsgInCloudResp.msg.get();
    if (paramPbSearchRoamMsgInCloudResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud pb error search result == null");
      }
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    a(paramPbSearchRoamMsgInCloudResp, localArrayList2);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    bbkm localbbkm = new bbkm(l, 0L, true, true, false, false);
    localbbkm.h = true;
    ArrayList localArrayList1 = new ArrayList();
    a(localArrayList2, l, localbbkm, localArrayList1);
    if (localArrayList1.size() > 0) {
      Collections.sort(localArrayList1, new abwm(this));
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud resultList size:" + paramPbSearchRoamMsgInCloudResp.size() + ",outList size:" + localArrayList2.size() + ",loopList size:" + localArrayList1.size());
    }
    if (paramRspBody.friends.has())
    {
      paramPbSearchRoamMsgInCloudResp = paramRspBody.friends.get();
      if (paramPbSearchRoamMsgInCloudResp == null) {
        break label320;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo size:" + paramPbSearchRoamMsgInCloudResp.size());
      }
    }
    for (;;)
    {
      if ((localArrayList1.size() == 0) && (paramInt1 != 1))
      {
        paramInt1 = paramToServiceMsg.extraData.getInt("retryIndex");
        if (paramInt1 < 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramInt2, null, paramToServiceMsg.extraData.getString("keyword"), paramToServiceMsg.extraData.getLong("sequence"), paramPbSearchRoamMsgInCloudResp, paramInt1 + 1, 0L);
          return;
          paramPbSearchRoamMsgInCloudResp = null;
          break;
          label320:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo == null");
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud retry extend 5 times, do not request again");
        }
        paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
        a(8015, false, paramHashMap);
        return;
      }
    }
    paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
    paramHashMap.put("SEARCHRESULT", localArrayList1);
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramHashMap.put("SEARCHCOMPLETE", Boolean.valueOf(bool));
      a(8015, true, paramHashMap);
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString, amwo paramamwo, ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Collections.sort(paramArrayList, new abwk(this));
      if (paramamwo == null) {}
    }
    try
    {
      paramamwo.a(paramArrayList, paramString, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramArrayList, false);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramString);
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramString);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, MessageRecord paramMessageRecord)
  {
    if (paramShort == 0) {
      if (paramBoolean2) {
        paramShort = this.jdField_c_of_type_Int;
      }
    }
    for (;;)
    {
      this.e = this.jdField_a_of_type_JavaUtilHashSet.size();
      if (this.e % paramShort == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.oneWayMessageNotifyVibert(paramMessageRecord, paramBoolean1);
        this.jdField_a_of_type_JavaUtilHashSet.clear();
        paramSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgDateRecentUinList");
        paramSharedPreferences.edit().commit();
        if (paramBoolean2) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005296", "0X8005296", 0, 0, "", "", "", "");
        }
      }
      return;
      paramShort = this.jdField_a_of_type_Int;
      continue;
      if (paramBoolean2) {
        paramShort = this.jdField_d_of_type_Int;
      } else {
        paramShort = this.jdField_b_of_type_Int;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList, String paramString1, String paramString2)
  {
    boolean bool;
    int k;
    if (paramArrayList.size() > 0)
    {
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramArrayList);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setAutoPullC2CMsgResult(paramString2, 0, paramArrayList, paramBoolean1);
      bool = a(paramArrayList);
      k = abwz.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if ((!bool) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {
        break label149;
      }
    }
    label149:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString2.addMessage(paramArrayList, paramString1, paramBoolean1);
      odq.a(paramArrayList);
      nsf.a.a(paramArrayList);
      b(paramArrayList);
      a("handleGetBuddyMessageResp", true, k, bool, paramBoolean2);
      a(paramArrayList, paramBoolean2);
      anll.a((MessageRecord)paramArrayList.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(false);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramArrayOfByte2);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(false);
  }
  
  private boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg.mMsgServiceID == 52) && ((amxb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124) != null))
    {
      paramMessageForStructing = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForStructing);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramMessageForStructing.sUin)) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
      }
      while ("4".equals(paramMessageForStructing.version))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
        }
        bblf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong1, paramInt1, paramLong2, paramInt2);
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramMessageForStructing.rUin)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
        }
      }
    }
    return false;
  }
  
  private boolean a(bbkm parambbkm, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (abwz.a(parambbkm.jdField_c_of_type_Int) == 1032)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        bbko localbbko = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
        localObject1 = localObject2;
        if (localbbko != null) {
          localObject1 = localbbko.a(String.valueOf(parambbkm.jdField_e_of_type_Long), String.valueOf(parambbkm.jdField_a_of_type_Long));
        }
      }
      bblf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramLong1, paramInt1, paramLong2, paramInt2, (byte[])localObject1);
      if (parambbkm.jdField_c_of_type_Int == 1032)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bbkm parambbkm, int paramInt1, long paramLong1, long paramLong2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((abwz.t(parambbkm.jdField_c_of_type_Int)) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      int k = anlf.a(paramMessageRecord, 1);
      if (k > 0) {
        paramMessageRecord.saveExtInfoToExtStr("nearby_gift_msg", "1|" + k);
      }
      if (a(paramInt1, paramLong1, paramLong2, paramInt2, (MessageForStructing)paramMessageRecord)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bbkm parambbkm, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      do
      {
        return true;
      } while (((parambbkm.jdField_b_of_type_Long == 3338705755L) && (ugf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((parambbkm.jdField_b_of_type_Long == 2171946401L) && (pay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))));
      if (parambbkm.jdField_b_of_type_Long == 2171946401L) {
        ugf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      }
    } while (((parambbkm.jdField_c_of_type_Int == 1025) || (parambbkm.jdField_c_of_type_Int == 1024)) && (paramMessageRecord.msgtype == -1000) && (paramMessageRecord.msg.startsWith("default:SigT=")));
    return false;
  }
  
  private boolean a(bbkm parambbkm, msg_comm.MsgHead paramMsgHead, long paramLong, MessageRecord paramMessageRecord)
  {
    if (parambbkm.jdField_c_of_type_Int == 1006)
    {
      if (paramMsgHead.from_nick.has()) {
        ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(String.valueOf(parambbkm.jdField_e_of_type_Long), paramMsgHead.from_nick.get());
      }
      paramMessageRecord.frienduin = ContactUtils.getPhoneNumByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(parambbkm.jdField_e_of_type_Long));
      paramMessageRecord.senderuin = ContactUtils.getPhoneNumByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong));
      if ((TextUtils.isEmpty(paramMessageRecord.frienduin)) && (parambbkm.jdField_d_of_type_Boolean)) {
        paramMessageRecord.frienduin = String.valueOf(parambbkm.jdField_e_of_type_Long);
      }
      if (paramMessageRecord.frienduin == null)
      {
        QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(parambbkm.jdField_e_of_type_Long), Long.valueOf(paramLong), Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.msgtype) }));
        return true;
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ApolloBaseInfo paramApolloBaseInfo, long paramLong, int paramInt)
  {
    if ((paramApolloBaseInfo != null) && (paramMessageRecord.time > paramApolloBaseInfo.apolloUpdateTime) && (paramApolloBaseInfo.apolloServerTS < paramLong))
    {
      paramApolloBaseInfo.apolloStatus = paramInt;
      paramApolloBaseInfo.apolloServerTS = paramLong;
      paramApolloBaseInfo.apolloVipFlag = (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1);
      paramApolloBaseInfo.apolloUpdateTime = paramMessageRecord.time;
      if ((!paramMessageForApollo.isSend()) && (paramMessageForApollo.signTs > NetConnInfoCenter.getServerTime()) && (paramMessageForApollo.signTs != paramApolloBaseInfo.apolloSignValidTS))
      {
        paramApolloBaseInfo.apolloSignValidTS = paramMessageForApollo.signTs;
        paramApolloBaseInfo.apolloSignStr = "";
        return true;
      }
    }
    else if ((paramApolloBaseInfo != null) && (!paramMessageForApollo.isSend()) && (paramMessageForApollo.signTs > NetConnInfoCenter.getServerTime()) && (paramMessageForApollo.signTs != paramApolloBaseInfo.apolloSignValidTS))
    {
      paramApolloBaseInfo.apolloSignValidTS = paramMessageForApollo.signTs;
      paramApolloBaseInfo.apolloSignStr = "";
      return true;
    }
    return false;
  }
  
  private static boolean a(StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramLong2 = paramQQAppInterface.getMsgCache().a(String.valueOf(paramLong2), 0);
    boolean bool1 = bool2;
    if (paramLong1 <= paramLong2)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          paramStringBuilder.setLength(0);
          paramStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(paramInt).append("] : filter msg by del time delTime =").append(paramLong2).append(", msgTime = ").append(paramLong1);
          QLog.d("Q.msg.C2CMessageProcessor", 2, paramStringBuilder.toString());
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String b(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashSet == null) {
      for (;;)
      {
        int k;
        try
        {
          if (this.jdField_b_of_type_JavaUtilHashSet == null)
          {
            this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
            paramSharedPreferences = paramSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgLBSFriendRecentUinList", "");
            String[] arrayOfString = paramSharedPreferences.split("\\|");
            int m = arrayOfString.length;
            k = 0;
            paramString = paramSharedPreferences;
            if (k < m)
            {
              paramString = arrayOfString[k];
              if ((paramString.length() <= 0) || (Long.parseLong(paramString) <= 0L)) {
                break label129;
              }
              this.jdField_b_of_type_JavaUtilHashSet.add(paramString);
              break label129;
            }
          }
          return paramString;
        }
        finally {}
        label129:
        k += 1;
      }
    }
    return paramString;
  }
  
  private String b(SharedPreferences paramSharedPreferences, String paramString, MessageRecord paramMessageRecord)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramMessageRecord.frienduin))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramMessageRecord.frienduin);
      if (paramString.length() == 0) {}
      for (paramString = paramMessageRecord.frienduin;; paramString = paramString + "|" + paramMessageRecord.frienduin)
      {
        paramSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgDateRecentUinList", paramString);
        paramSharedPreferences.edit().commit();
        return paramString;
      }
    }
    return paramString;
  }
  
  private void b(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      b((msg_comm.Msg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], (msg_onlinepush.PbPushMsg)paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, MessageRecord paramMessageRecord)
  {
    if (bfwr.a(paramMessageRecord.issend))
    {
      if (paramLong2 != -1L)
      {
        paramMessageRecord.vipBubbleID = paramLong2;
        return;
      }
      paramMessageRecord.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastC2CBubbleIDFromCache(String.valueOf(paramLong4), String.valueOf(paramLong3));
      return;
    }
    if (paramLong1 != -1L)
    {
      paramMessageRecord.vipBubbleID = paramLong1;
      return;
    }
    paramMessageRecord.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastC2CBubbleIDFromCache(String.valueOf(paramLong4), String.valueOf(paramLong3));
  }
  
  private void b(bbkm parambbkm, MessageRecord paramMessageRecord)
  {
    if (parambbkm.f)
    {
      paramMessageRecord.issend = 2;
      paramMessageRecord.isread = true;
    }
    while (paramMessageRecord.msgtype == -2037) {
      return;
    }
    paramMessageRecord.isread = parambbkm.jdField_a_of_type_Boolean;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && (paramMessageRecord.structingMsg.mMsgServiceID == 76)) {
        ((nru)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(paramMessageRecord);
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == -2002)
    {
      if ((!paramBoolean) && (bcgn.a(paramMessageRecord.msgUid, paramMessageRecord.shmsgseq) != null)) {
        PttInfoCollector.reportPttDownloadStream2Offline(true);
      }
      if ((paramBoolean) && ((paramMessageRecord instanceof MessageForPtt)) && (abwz.d(paramMessageRecord.istroop)))
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop).iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (((localMessageRecord instanceof MessageForPtt)) && (localMessageRecord.msgUid == paramMessageRecord.msgUid) && (localMessageRecord.shmsgseq == paramMessageRecord.shmsgseq)) {
            a((MessageForPtt)localMessageRecord, (MessageForPtt)paramMessageRecord);
          }
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    Bundle localBundle;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramObject = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
      bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
      k = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      bool3 = paramToServiceMsg.extraData.getBoolean("notify", true);
      localBundle = new Bundle();
      localBundle.putLong("BEGTIME", paramObject.longValue());
      localBundle.putBoolean("FETCH_MORE", bool1);
      localBundle.putInt("MSG_COUNT", k);
      localBundle.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      localBundle.putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        m = paramFromServiceMsg.result.get();
        localList = paramFromServiceMsg.msg.get();
        if (localList == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + m + ", msgList is null !");
          }
          a(1004, false, localBundle);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      boolean bool1;
      int k;
      boolean bool2;
      boolean bool3;
      String str;
      int m;
      List localList;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      ArrayList localArrayList = new ArrayList();
      a(localList, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + paramObject + ", code=" + m + " ,errMsg=" + paramFromServiceMsg.errmsg.get() + ", msgList.size()=" + localArrayList.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + k);
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, k, bool2, bool3, localBundle, str, m, localArrayList);
      return;
    }
    a(1004, false, localBundle);
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = afdj.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessor.4(this, localMessageRecord));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  private void b(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    for (;;)
    {
      return;
      long l1 = localMsgHead.c2c_cmd.get();
      long l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      int k = localMsgHead.user_active.get();
      int m = localMsgHead.from_instid.get();
      Object localObject1;
      long l7;
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + k + ",fromInstid:" + m + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus = k;
        localArrayList1 = new ArrayList();
      }
      try
      {
        localObject1 = new bbkm(l7, l3, true, false, false, false);
        ((bbkm)localObject1).h = true;
        localObject1 = a(paramMsg, (bbll)localObject1);
        amwh.a((List)localObject1);
        if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
          continue;
        }
        if (localArrayList1 != null) {
          a((List)localObject1, localArrayList1, true);
        }
        localObject1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        paramMsg = new abwn(this, paramMsg, localArrayList1, false, null, (ArrayList)localObject1, localArrayList2).a();
        boolean bool = abwn.a(paramMsg);
        paramMsg = abwn.a(paramMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(localArrayList2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localArrayList2, String.valueOf(l7), false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMsgHead.msg_seq.get());
        k = paramFromServiceMsg.getRequestSsoSeq();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, (ArrayList)localObject1, paramPbPushMsg.svrip.get(), k, null);
        if (l1 == 127L) {
          continue;
        }
        a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false), false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList2);
        if ((!bool) || (TextUtils.isEmpty(paramMsg))) {
          continue;
        }
        bblk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsg);
        return;
        localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, MessageRecord paramMessageRecord)
  {
    if (paramShort == 0) {
      if (paramBoolean2) {
        paramShort = this.h;
      }
    }
    for (;;)
    {
      this.j = this.jdField_b_of_type_JavaUtilHashSet.size();
      if (this.j % paramShort == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.oneWayMessageNotifyVibert(paramMessageRecord, paramBoolean1);
        this.jdField_b_of_type_JavaUtilHashSet.clear();
        paramSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_OneWayMsgLBSFriendRecentUinList");
        paramSharedPreferences.edit().commit();
        if (paramBoolean2) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005296", "0X8005296", 0, 0, "", "", "", "");
        }
      }
      return;
      paramShort = this.f;
      continue;
      if (paramBoolean2) {
        paramShort = this.i;
      } else {
        paramShort = this.g;
      }
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void c(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      c((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2039)
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramMessageRecord;
      alnr localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(localMessageForApollo.mApolloMessage.id).append(", name: ").append(new String(localMessageForApollo.mApolloMessage.name)).append(", doubleAction: ").append(localMessageForApollo.isDoubleAction()).append(", signTS: ").append(localMessageForApollo.signTs);
      }
      a(paramMessageRecord, localMessageForApollo, localalnr, localStringBuilder);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
      a(localMessageForApollo, localalnr);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramObject = paramToServiceMsg.extraData.getBundle("context");
      ArrayList localArrayList;
      if (paramFromServiceMsg != null)
      {
        k = paramFromServiceMsg.result.get();
        paramToServiceMsg = paramFromServiceMsg.msg.get();
        localArrayList = new ArrayList();
        a(paramToServiceMsg, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + k + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + localArrayList.size() + ", context" + paramObject);
        }
        if (k == 0) {
          paramToServiceMsg = new ArrayList();
        }
      }
      else
      {
        try
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList, paramFromServiceMsg.peer_uin.get(), true);
          if (localObject != null) {
            paramToServiceMsg.addAll((Collection)localObject);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException);
            }
          }
        }
        l = paramFromServiceMsg.peer_uin.get();
        if (!localArrayList.isEmpty())
        {
          localObject = (msg_comm.Msg)localArrayList.get(0);
          l = amwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        localObject = new bbkm(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l, true, true, false, false);
        ((bbkm)localObject).h = true;
        a(localArrayList, null, paramToServiceMsg, (bbkm)localObject);
        if (paramToServiceMsg.size() <= 0) {
          break label472;
        }
        Collections.sort(paramToServiceMsg, new abwl(this));
        l = ((MessageRecord)paramToServiceMsg.get(0)).time;
        a(paramFromServiceMsg, paramObject, paramToServiceMsg, l, k);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        int k;
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        continue;
        if ((k == 1) && (QLog.isColorLevel())) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
        }
        long l = 0L;
        paramToServiceMsg = null;
        continue;
        label472:
        l = 0L;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void d(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      d((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(paramMessageRecord)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramMessageRecord))))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
      if ((str == null) || (!String.valueOf(3).equals(str))) {}
    }
    else
    {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
    StructLongMessageDownloadProcessor.getStructLongMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_c2c_searcher.RspBody localRspBody = null;
    int k = paramToServiceMsg.extraData.getInt("loadType");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    localHashMap.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    localHashMap.put("LOADTYPE", Integer.valueOf(k));
    msg_svc.PbSearchRoamMsgInCloudResp localPbSearchRoamMsgInCloudResp = new msg_svc.PbSearchRoamMsgInCloudResp();
    try
    {
      paramObject = (msg_svc.PbSearchRoamMsgInCloudResp)localPbSearchRoamMsgInCloudResp.mergeFrom((byte[])paramObject);
      if (paramObject != null)
      {
        localRspBody = a(paramObject, new oidb_c2c_searcher.RspBody());
        if (localRspBody == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "<----processSearchRoamMsgInCloud error oidb_search null----> ");
          }
          a(paramToServiceMsg, paramFromServiceMsg, false);
        }
      }
      else
      {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        paramObject = localRspBody;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException ! ", localInvalidProtocolBufferMicroException);
          paramObject = localRspBody;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramObject = localRspBody;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! ", localOutOfMemoryError);
          paramObject = localRspBody;
        }
      }
      int m = localRspBody.result.get();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud result--------->>>>>> " + m + ", loadType: " + k);
      }
      if ((m == 0) || (m == 1))
      {
        a(paramObject, localRspBody, m, paramToServiceMsg, k, localHashMap);
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg, false);
    }
  }
  
  private void e(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      b((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void f(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      a((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void g(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      a((msg_comm.Msg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], (msg_onlinepush.PbPushMsg)paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, bbll parambbll)
  {
    if (!(parambbll instanceof bbkm)) {
      parambbll = new ArrayList();
    }
    long l2;
    ArrayList localArrayList;
    do
    {
      return parambbll;
      parambbll = (bbkm)parambbll;
      l2 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      if ((paramMsg != null) && (paramMsg.msg_head.has()) && (paramMsg.msg_body.has())) {
        break;
      }
      parambbll = localArrayList;
    } while (!QLog.isColorLevel());
    parambbll = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
    if (paramMsg == null) {}
    for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
    {
      QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
      return localArrayList;
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i1 = (short)localMsgHead.msg_seq.get();
    long l3 = localMsgHead.to_uin.get();
    long l4 = localMsgHead.from_uin.get();
    long l5 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i2 = localMsgHead.msg_type.get();
    int i3 = paramMsg.msg_head.c2c_cmd.get();
    parambbll.jdField_c_of_type_Int = 0;
    parambbll.jdField_d_of_type_Int = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject;
    if (paramMsg.content_head.has())
    {
      localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject).div_seq.get();
      m = ((msg_comm.ContentHead)localObject).pkg_num.get();
      n = ((msg_comm.ContentHead)localObject).pkg_index.get();
    }
    long l1 = -1L;
    if (!parambbll.jdField_d_of_type_Boolean) {
      l1 = bblf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(parambbll.jdField_e_of_type_Long), String.valueOf(l4));
    }
    parambbll.jdField_b_of_type_Long = l4;
    parambbll.jdField_c_of_type_Long = l5;
    int i4 = bblf.a(paramMsg);
    parambbll.jdField_a_of_type_Int = i4;
    parambbll.jdField_d_of_type_Long = anaj.a((int)l1, i4);
    parambbll.jdField_b_of_type_Int = bblf.e(paramMsg);
    if (l4 == parambbll.jdField_a_of_type_Long)
    {
      parambbll.jdField_a_of_type_Boolean = true;
      parambbll.f = true;
      if (!QLog.isColorLevel()) {
        break label817;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l5).append(" shortSeq:").append(i1).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l3).append(" senderUin:").append(l4).append(" friendUin:").append(parambbll.jdField_e_of_type_Long).append(" isReaded:").append(parambbll.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(parambbll.f).append(" msgType:0x").append(Integer.toHexString(i2)).append(" c2CCmd:0x").append(Integer.toHexString(i3)).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:").append(l1).append(" longMsgID:").append(k).append(" longMsgCount:").append(m).append(" longMsgIndex:").append(n).append("init_direction_flag").append(parambbll.jdField_d_of_type_Int);
      QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
      label661:
      localObject = new ArrayList();
      a(i2, paramMsg, (ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, parambbll);
      a(paramMsg, (ArrayList)localObject, parambbll, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
      a(m, (ArrayList)localObject);
      a(paramMsg, parambbll, localArrayList, localMsgHead, i1, l4, l6, i2, l4, k, m, n, (ArrayList)localObject, a(paramMsg, -1L));
      a(paramMsg, parambbll, localArrayList);
      MsgAutoMonitorUtil.getInstance().addDecodeC2CMsgTime(System.currentTimeMillis() - l2);
      m = 0;
      paramMsg = localArrayList.iterator();
      k = 0;
      label770:
      if (!paramMsg.hasNext()) {
        break label838;
      }
      parambbll = (MessageRecord)paramMsg.next();
      m = parambbll.istroop;
      if (parambbll.isread) {
        break label849;
      }
      k += 1;
    }
    label817:
    label838:
    label849:
    for (;;)
    {
      break label770;
      parambbll.f = false;
      break;
      if (parambbll.jdField_e_of_type_Long != 0L) {
        break label661;
      }
      QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
      break label661;
      bcdm.a(0, 1, m, k);
      return localArrayList;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      g(paramInt, paramVarArgs);
      return;
    case 1002: 
      f(paramInt, paramVarArgs);
      return;
    case 2001: 
      e(paramInt, paramVarArgs);
      return;
    case 2005: 
      d(paramInt, paramVarArgs);
      return;
    case 1003: 
      c(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public void a(C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    String str = String.valueOf(paramC2CMsgReadedNotify.lPeerUin);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processPushReadedNotify is called. uAioType = " + paramC2CMsgReadedNotify.uAioType);
    }
    if (paramC2CMsgReadedNotify.uAioType == 3L) {
      atym.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramC2CMsgReadedNotify);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReadFrom(str, 0, paramC2CMsgReadedNotify.lLastReadTime);
    } while (paramC2CMsgReadedNotify.lLastReadTime < 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a(str, 0);
  }
  
  public void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramMessageForPtt1.getPttStreamFlag() == 10001)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForPtt2.directUrl))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageForPtt1.directUrl)) {}
      }
    }
    try
    {
      paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
      paramMessageForPtt1.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
      bool1 = true;
    }
    catch (Exception paramMessageForPtt1)
    {
      for (;;)
      {
        paramMessageForPtt1.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + bool1);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if (abwz.d(paramInt))
    {
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      a(paramString, paramInt, paramLong, localPbMsgReadedReportReq);
      a(localPbMsgReadedReportReq);
    }
  }
  
  public void a(ArrayList<Pair<Long, Long>> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
      localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
      localStringBuilder.append("-uin:").append(localPair.first).append("-ReadTime-").append(localPair.second);
      localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
    if (paramArrayList != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + localStringBuilder.toString());
    }
    a(localPbMsgReadedReportReq);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    short s2 = 1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if ((!UserguideActivity.a(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (bfrf.a(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        Object localObject1 = paramArrayList.iterator();
        Object localObject2;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while ((!abwz.t(((MessageRecord)localObject2).istroop)) || (!abwz.d((MessageRecord)localObject2)) || (abwz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2)) || (((MessageRecord)localObject2).isSend()) || (((MessageRecord)localObject2).isread));
        for (int k = 1; k != 0; k = 0)
        {
          localObject2 = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
          if (localObject2 == null)
          {
            s1 = s2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "findFriendCardByUin card is null");
            }
          }
          for (short s1 = s2;; s1 = ((Card)localObject2).shGender)
          {
            boolean bool = ((awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)).a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg_box", 2, "DealOneWayMessageNotify,gender:" + s1 + ",isGod:" + bool);
            }
            a();
            localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "OneWayMsgRecentUinList", 0);
            a(paramArrayList, paramBoolean, (QQMessageFacade)localObject1, s1, bool, (SharedPreferences)localObject2, a((SharedPreferences)localObject2, ""), b((SharedPreferences)localObject2, ""));
            return;
          }
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!abwz.d(paramMessageRecord)) || (abwz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((abwz.d(localMessageRecord)) && (!abwz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (FriendsStatusUtil.a(localMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!akhg.a(localMessageRecord.frienduin)) || (!atym.a(localMessageRecord)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwi
 * JD-Core Version:    0.7.0.1
 */