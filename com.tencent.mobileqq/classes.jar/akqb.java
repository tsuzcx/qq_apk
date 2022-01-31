import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgItem;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgNew;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class akqb
  extends aksv
{
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForQQStoryComment.class, MessageForArkApp.class, MessageForArkFlashChat.class };
  aukv jdField_a_of_type_Aukv = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public akqb(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private aukv a()
  {
    if ((this.jdField_a_of_type_Aukv == null) || (!this.jdField_a_of_type_Aukv.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Aukv == null) || (!this.jdField_a_of_type_Aukv.a())) {
        this.jdField_a_of_type_Aukv = ((aukv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_Aukv;
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 3) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of max recurTime");
      }
    }
    label271:
    for (;;)
    {
      return;
      if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of null structmsg");
        }
      }
      else
      {
        String str = a(paramInt, paramMessageForStructing);
        ArrayList localArrayList;
        if (paramHashMap.containsKey(str))
        {
          localArrayList = (ArrayList)paramHashMap.get(str);
          localObject = localArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(localArrayList.size()), str }));
          }
        }
        for (Object localObject = localArrayList;; localObject = null)
        {
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label271;
          }
          a(paramMessageForStructing, (List)localObject, null);
          paramInt += 1;
          paramMessageForStructing = ((ArrayList)localObject).iterator();
          while (paramMessageForStructing.hasNext())
          {
            localObject = (MessageRecord)paramMessageForStructing.next();
            if (asuf.a((ChatMessage)localObject))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(((MessageRecord)localObject).uniseq), Integer.valueOf(paramInt) }));
              }
              a((MessageForStructing)localObject, paramHashMap, paramInt);
            }
          }
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str, Integer.valueOf(paramInt) }));
          }
        }
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap1, HashMap<String, ArrayList<MessageRecord>> paramHashMap2, int paramInt, akte paramakte, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramInt > 3) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of max recurTime");
      }
    }
    label385:
    label386:
    for (;;)
    {
      return;
      if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of null structmsg");
        }
      }
      else
      {
        String str1 = a(paramInt, paramMessageForStructing);
        Object localObject;
        int i;
        if (paramHashMap1.containsKey(str1))
        {
          localObject = (ArrayList)paramHashMap1.get(str1);
          if (!QLog.isColorLevel()) {
            break label385;
          }
          if (localObject != null)
          {
            i = ((ArrayList)localObject).size();
            QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(i), str1 }));
          }
        }
        for (;;)
        {
          label122:
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label386;
          }
          paramMessageForStructing = a(paramMessageForStructing, (ArrayList)localObject, paramakte, paramBoolean1, paramBoolean2, paramArrayList);
          if (paramMessageForStructing == null) {
            break;
          }
          localObject = paramMessageForStructing.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (asuf.a((ChatMessage)localMessageRecord))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
                String str2 = localMessageForStructing.structingMsg.mFileName;
                String str3 = String.valueOf(localMessageForStructing.uniseq);
                localMessageForStructing.structingMsg.mFileName = str3;
                a(localMessageRecord, null);
                paramHashMap1.put(str3, (ArrayList)paramHashMap1.remove(str2));
                continue;
                i = 0;
                break;
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str1, Integer.valueOf(paramInt) }));
                }
                localObject = null;
                break label122;
              }
            }
          }
          paramHashMap2.put(str1, paramMessageForStructing);
          if ((paramMessageForStructing == null) || (paramMessageForStructing.size() <= 0)) {
            break;
          }
          paramMessageForStructing = paramMessageForStructing.iterator();
          while (paramMessageForStructing.hasNext())
          {
            localObject = (MessageRecord)paramMessageForStructing.next();
            if (asuf.a((ChatMessage)localObject)) {
              a((MessageForStructing)localObject, paramHashMap1, paramHashMap2, paramInt + 1, paramakte, paramBoolean1, paramBoolean2, paramArrayList);
            }
          }
          break;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      return true;
      if (!MessageForFile.class.isInstance(paramChatMessage)) {
        break;
      }
    } while (!apue.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
    return false;
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return (MessageForMarketFace.class.isInstance(paramChatMessage)) || (MessageForPic.class.isInstance(paramChatMessage));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (mye.a(paramMessageRecord)) {
      return false;
    }
    if ((MessageForShortVideo.class.isInstance(paramMessageRecord)) && (((MessageForShortVideo)paramMessageRecord).busiType == 2)) {
      return false;
    }
    if ((MessageForLongTextMsg.class.isInstance(paramMessageRecord)) && ((paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) {
      return false;
    }
    if (!MessageForArkApp.isAllowedArkForward(false, paramMessageRecord)) {
      return false;
    }
    if (MessageForTroopConfess.class.isInstance(paramMessageRecord)) {
      return false;
    }
    if (MessageForLightVideo.class.isInstance(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForFuDai)) {
      return false;
    }
    Object localObject = jdField_a_of_type_ArrayOfJavaLangClass;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramMessageRecord)) {
        return true;
      }
      i += 1;
    }
    if (MessageForStructing.class.isInstance(paramMessageRecord))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 82)) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction))) {
        return false;
      }
      if (paramMessageRecord.msgtype != -2011) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.fwFlag == 1)) {
        return false;
      }
      return (((MessageForStructing)localObject).structingMsg == null) || (!((MessageForStructing)localObject).structingMsg.hasFlag(1));
    }
    if ((paramMessageRecord instanceof MessageForArkBabyqReply))
    {
      paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
      return (paramMessageRecord.mArkBabyqReplyCardList != null) && (paramMessageRecord.mArkBabyqReplyCardList.size() > 0);
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 76
    //   8: iconst_2
    //   9: new 285	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 288
    //   19: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: arraylength
    //   24: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 301	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 304	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore_3
    //   42: new 306	java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial 307	java/io/ByteArrayOutputStream:<init>	()V
    //   49: astore 4
    //   51: sipush 1024
    //   54: newarray byte
    //   56: astore_0
    //   57: new 309	java/util/zip/GZIPOutputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 312	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_3
    //   68: aload_0
    //   69: iconst_0
    //   70: sipush 1024
    //   73: invokevirtual 316	java/io/ByteArrayInputStream:read	([BII)I
    //   76: istore_1
    //   77: iload_1
    //   78: iconst_m1
    //   79: if_icmpeq +64 -> 143
    //   82: aload_2
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 320	java/util/zip/GZIPOutputStream:write	([BII)V
    //   89: goto -22 -> 67
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_0
    //   95: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +32 -> 130
    //   101: ldc 76
    //   103: iconst_2
    //   104: new 285	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 322
    //   114: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 325	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 4
    //   132: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_3
    //   136: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   139: aload_0
    //   140: astore_2
    //   141: aload_2
    //   142: areturn
    //   143: aload_2
    //   144: invokevirtual 332	java/util/zip/GZIPOutputStream:flush	()V
    //   147: aload_2
    //   148: invokevirtual 333	java/util/zip/GZIPOutputStream:close	()V
    //   151: aload 4
    //   153: invokevirtual 337	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   156: astore_0
    //   157: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +30 -> 190
    //   163: ldc 76
    //   165: iconst_2
    //   166: new 285	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 339
    //   176: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: arraylength
    //   181: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload 4
    //   192: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   195: aload_3
    //   196: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   199: aload_0
    //   200: areturn
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -66 -> 141
    //   210: ldc 76
    //   212: iconst_2
    //   213: new 285	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 341
    //   223: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_3
    //   227: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload_0
    //   240: areturn
    //   241: astore_3
    //   242: aload_0
    //   243: astore_2
    //   244: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq -106 -> 141
    //   250: ldc 76
    //   252: iconst_2
    //   253: new 285	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 341
    //   263: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_3
    //   267: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: areturn
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_0
    //   284: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +32 -> 319
    //   290: ldc 76
    //   292: iconst_2
    //   293: new 285	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 344
    //   303: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_2
    //   307: invokevirtual 345	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   324: aload_3
    //   325: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   328: aload_0
    //   329: areturn
    //   330: astore_3
    //   331: aload_0
    //   332: astore_2
    //   333: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -195 -> 141
    //   339: ldc 76
    //   341: iconst_2
    //   342: new 285	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 341
    //   352: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: areturn
    //   370: astore_0
    //   371: aload 4
    //   373: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   376: aload_3
    //   377: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   380: aload_0
    //   381: athrow
    //   382: astore_2
    //   383: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq -6 -> 380
    //   389: ldc 76
    //   391: iconst_2
    //   392: new 285	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 341
    //   402: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_2
    //   406: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -38 -> 380
    //   421: astore_2
    //   422: goto -138 -> 284
    //   425: astore_2
    //   426: goto -331 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramArrayOfByte	byte[]
    //   76	10	1	i	int
    //   66	17	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   92	26	2	localException1	Exception
    //   140	104	2	arrayOfByte1	byte[]
    //   281	26	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   332	1	2	arrayOfByte2	byte[]
    //   382	24	2	localIOException1	java.io.IOException
    //   421	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   425	1	2	localException2	Exception
    //   41	155	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   201	26	3	localIOException2	java.io.IOException
    //   241	84	3	localIOException3	java.io.IOException
    //   330	47	3	localIOException4	java.io.IOException
    //   49	323	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	67	92	java/lang/Exception
    //   67	77	92	java/lang/Exception
    //   82	89	92	java/lang/Exception
    //   143	157	92	java/lang/Exception
    //   190	199	201	java/io/IOException
    //   130	139	241	java/io/IOException
    //   51	67	281	java/lang/OutOfMemoryError
    //   67	77	281	java/lang/OutOfMemoryError
    //   82	89	281	java/lang/OutOfMemoryError
    //   143	157	281	java/lang/OutOfMemoryError
    //   319	328	330	java/io/IOException
    //   51	67	370	finally
    //   67	77	370	finally
    //   82	89	370	finally
    //   95	130	370	finally
    //   143	157	370	finally
    //   157	190	370	finally
    //   284	319	370	finally
    //   371	380	382	java/io/IOException
    //   157	190	421	java/lang/OutOfMemoryError
    //   157	190	425	java/lang/Exception
  }
  
  private void b(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of max recurTime");
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (paramMessageForStructing != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of null structmsg");
      return;
      localArrayList = a(paramMessageForStructing.uniseq);
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    paramHashMap.put(a(paramInt, paramMessageForStructing), localArrayList);
    paramInt += 1;
    paramMessageForStructing = localArrayList.iterator();
    label87:
    label226:
    for (;;)
    {
      MessageRecord localMessageRecord1;
      if (paramMessageForStructing.hasNext())
      {
        localMessageRecord1 = (MessageRecord)paramMessageForStructing.next();
        if (!asuf.a((ChatMessage)localMessageRecord1)) {
          continue;
        }
        if (paramInt != 2) {
          break label214;
        }
        MessageRecord localMessageRecord2 = a(localMessageRecord1, astw.jdField_a_of_type_JavaLangString, false);
        localMessageRecord2.setStatus(1000);
        localMessageRecord2.msgData = localMessageRecord2.msg.getBytes();
        localArrayList.set(localArrayList.indexOf(localMessageRecord1), localMessageRecord2);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label226;
        }
        QLog.d("MultiMsg_TAG", 2, String.format("recursiveQueryMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(localMessageRecord1.uniseq), Integer.valueOf(paramInt) }));
        break label87;
        break;
        b((MessageForStructing)localMessageRecord1, paramHashMap, paramInt);
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!MessageForFile.class.isInstance(paramChatMessage)) {
              break;
            }
          } while (!apue.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
          return false;
        } while (MessageForPic.class.isInstance(paramChatMessage));
        if (!MessageForShortVideo.class.isInstance(paramChatMessage)) {
          break;
        }
      } while (((MessageForShortVideo)paramChatMessage).checkForward());
      return false;
    } while (b(paramChatMessage));
    return false;
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((StructMsgForImageShare.class.isInstance(paramChatMessage.structingMsg)) && (((StructMsgForImageShare)paramChatMessage.structingMsg).getFirstImageElement() != null)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 76
    //   8: iconst_2
    //   9: new 285	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 399
    //   19: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: arraylength
    //   24: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 5
    //   36: aconst_null
    //   37: astore 4
    //   39: new 301	java/io/ByteArrayInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 304	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: astore 6
    //   49: new 306	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: invokespecial 307	java/io/ByteArrayOutputStream:<init>	()V
    //   56: astore 7
    //   58: aload 4
    //   60: astore_2
    //   61: aload 5
    //   63: astore_3
    //   64: sipush 1024
    //   67: newarray byte
    //   69: astore 8
    //   71: aload 4
    //   73: astore_2
    //   74: aload 5
    //   76: astore_3
    //   77: new 401	java/util/zip/GZIPInputStream
    //   80: dup
    //   81: aload 6
    //   83: invokespecial 404	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore 9
    //   88: aload 4
    //   90: astore_2
    //   91: aload 5
    //   93: astore_3
    //   94: aload 9
    //   96: aload 8
    //   98: iconst_0
    //   99: sipush 1024
    //   102: invokevirtual 405	java/util/zip/GZIPInputStream:read	([BII)I
    //   105: istore_1
    //   106: iload_1
    //   107: iconst_m1
    //   108: if_icmpeq +73 -> 181
    //   111: aload 4
    //   113: astore_2
    //   114: aload 5
    //   116: astore_3
    //   117: aload 7
    //   119: aload 8
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 406	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore_3
    //   130: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +32 -> 165
    //   136: ldc 76
    //   138: iconst_2
    //   139: new 285	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 408
    //   149: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 325	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 7
    //   167: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   170: aload 6
    //   172: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   175: aload_2
    //   176: ifnonnull +316 -> 492
    //   179: aload_0
    //   180: areturn
    //   181: aload 4
    //   183: astore_2
    //   184: aload 5
    //   186: astore_3
    //   187: aload 9
    //   189: invokevirtual 409	java/util/zip/GZIPInputStream:close	()V
    //   192: aload 4
    //   194: astore_2
    //   195: aload 5
    //   197: astore_3
    //   198: aload 7
    //   200: invokevirtual 337	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   203: astore 4
    //   205: aload 4
    //   207: astore_2
    //   208: aload 4
    //   210: astore_3
    //   211: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +37 -> 251
    //   217: aload 4
    //   219: astore_2
    //   220: aload 4
    //   222: astore_3
    //   223: ldc 76
    //   225: iconst_2
    //   226: new 285	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 411
    //   236: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 4
    //   241: arraylength
    //   242: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload 7
    //   253: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   256: aload 6
    //   258: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   261: aload 4
    //   263: astore_2
    //   264: goto -89 -> 175
    //   267: astore_2
    //   268: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +32 -> 303
    //   274: ldc 76
    //   276: iconst_2
    //   277: new 285	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 413
    //   287: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_2
    //   291: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 4
    //   305: astore_2
    //   306: goto -131 -> 175
    //   309: astore_3
    //   310: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +32 -> 345
    //   316: ldc 76
    //   318: iconst_2
    //   319: new 285	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 413
    //   329: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_3
    //   333: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -170 -> 175
    //   348: astore_2
    //   349: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +32 -> 384
    //   355: ldc 76
    //   357: iconst_2
    //   358: new 285	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 408
    //   368: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_2
    //   372: invokevirtual 345	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   375: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 7
    //   386: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   389: aload 6
    //   391: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   394: aload_3
    //   395: astore_2
    //   396: goto -221 -> 175
    //   399: astore_2
    //   400: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +32 -> 435
    //   406: ldc 76
    //   408: iconst_2
    //   409: new 285	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 413
    //   419: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_2
    //   423: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   426: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: aload_3
    //   436: astore_2
    //   437: goto -262 -> 175
    //   440: astore_0
    //   441: aload 7
    //   443: invokevirtual 328	java/io/ByteArrayOutputStream:close	()V
    //   446: aload 6
    //   448: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
    //   451: aload_0
    //   452: athrow
    //   453: astore_2
    //   454: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq -6 -> 451
    //   460: ldc 76
    //   462: iconst_2
    //   463: new 285	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 413
    //   473: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_2
    //   477: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: goto -38 -> 451
    //   492: aload_2
    //   493: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	paramArrayOfByte	byte[]
    //   105	18	1	i	int
    //   60	204	2	arrayOfByte1	byte[]
    //   267	24	2	localIOException1	java.io.IOException
    //   305	1	2	arrayOfByte2	byte[]
    //   348	24	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   395	1	2	localObject1	Object
    //   399	24	2	localIOException2	java.io.IOException
    //   436	1	2	localObject2	Object
    //   453	40	2	localIOException3	java.io.IOException
    //   63	54	3	localObject3	Object
    //   129	24	3	localException	Exception
    //   186	37	3	localObject4	Object
    //   309	127	3	localIOException4	java.io.IOException
    //   37	267	4	arrayOfByte3	byte[]
    //   34	162	5	localObject5	Object
    //   47	400	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   56	386	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   69	51	8	arrayOfByte4	byte[]
    //   86	102	9	localGZIPInputStream	java.util.zip.GZIPInputStream
    // Exception table:
    //   from	to	target	type
    //   64	71	129	java/lang/Exception
    //   77	88	129	java/lang/Exception
    //   94	106	129	java/lang/Exception
    //   117	126	129	java/lang/Exception
    //   187	192	129	java/lang/Exception
    //   198	205	129	java/lang/Exception
    //   211	217	129	java/lang/Exception
    //   223	251	129	java/lang/Exception
    //   251	261	267	java/io/IOException
    //   165	175	309	java/io/IOException
    //   64	71	348	java/lang/OutOfMemoryError
    //   77	88	348	java/lang/OutOfMemoryError
    //   94	106	348	java/lang/OutOfMemoryError
    //   117	126	348	java/lang/OutOfMemoryError
    //   187	192	348	java/lang/OutOfMemoryError
    //   198	205	348	java/lang/OutOfMemoryError
    //   211	217	348	java/lang/OutOfMemoryError
    //   223	251	348	java/lang/OutOfMemoryError
    //   384	394	399	java/io/IOException
    //   64	71	440	finally
    //   77	88	440	finally
    //   94	106	440	finally
    //   117	126	440	finally
    //   130	165	440	finally
    //   187	192	440	finally
    //   198	205	440	finally
    //   211	217	440	finally
    //   223	251	440	finally
    //   349	384	440	finally
    //   441	451	453	java/io/IOException
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "queryLastMsg,delNum:" + paramInt);
    }
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      return null;
    }
    return (MessageRecord)localArrayList.get(0);
  }
  
  public MessageRecord a(long paramLong)
  {
    List localList = a().a(MessageRecord.class, "select * from mr_multimessage where uniseq=?", new String[] { String.valueOf(paramLong) });
    if ((localList == null) || (localList.size() < 1)) {
      return null;
    }
    ((MessageRecord)localList.get(0)).isMultiMsg = true;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "queryOneMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localList.get(0)).msgseq);
    }
    return (MessageRecord)localList.get(0);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = axaq.a(-1000);
    localMessageRecord.msg = paramString;
    localMessageRecord.uniseq = paramMessageRecord.uniseq;
    localMessageRecord.msgseq = paramMessageRecord.msgseq;
    localMessageRecord.time = paramMessageRecord.time;
    localMessageRecord.shmsgseq = paramMessageRecord.shmsgseq;
    localMessageRecord.msgUid = paramMessageRecord.msgUid;
    localMessageRecord.selfuin = paramMessageRecord.selfuin;
    localMessageRecord.senderuin = paramMessageRecord.senderuin;
    localMessageRecord.frienduin = paramMessageRecord.frienduin;
    localMessageRecord.istroop = paramMessageRecord.istroop;
    localMessageRecord.vipBubbleDiyTextId = paramMessageRecord.vipBubbleDiyTextId;
    localMessageRecord.vipBubbleID = paramMessageRecord.vipBubbleID;
    localMessageRecord.isMultiMsg = paramMessageRecord.isMultiMsg;
    localMessageRecord.extLong = paramMessageRecord.extLong;
    localMessageRecord.extStr = paramMessageRecord.extStr;
    if (paramBoolean)
    {
      localMessageRecord.setId(paramMessageRecord.getId());
      localMessageRecord.setStatus(paramMessageRecord.getStatus());
      a().a(localMessageRecord);
    }
    return localMessageRecord;
  }
  
  public String a(int paramInt, MessageForStructing paramMessageForStructing)
  {
    String str = "MultiMsg";
    if (paramInt > 0)
    {
      if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mFileName))) {
        str = paramMessageForStructing.structingMsg.mFileName;
      }
    }
    else {
      return str;
    }
    paramMessageForStructing = new StringBuilder();
    paramMessageForStructing.append("MultiMsg");
    paramMessageForStructing.append("_");
    paramMessageForStructing.append(paramInt);
    paramMessageForStructing = paramMessageForStructing.toString();
    QLog.d("MultiMsg_TAG", 1, "resid is null! " + paramMessageForStructing);
    return paramMessageForStructing;
  }
  
  public ArrayList<MessageRecord> a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    Object localObject1;
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      localObject1 = new ArrayList();
    }
    do
    {
      return localObject1;
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isMultiMsg = true;
        if (((MessageRecord)localObject2).msgtype == -1035)
        {
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MessageRecord)((Iterator)localObject2).next()).isMultiMsg = true;
          }
        }
      }
      localObject1 = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localArrayList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localArrayList.get(0)).msgseq);
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, akte paramakte, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMessageRecord = a(paramMessageRecord, paramArrayList, paramakte, paramBoolean1, paramBoolean2, new ArrayList(0));
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    return paramMessageRecord;
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, akte paramakte, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      Object localObject1;
      Object localObject2;
      if (paramBoolean2)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramArrayList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        while (paramArrayList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
          if (localMessageRecord.msgtype == -1036)
          {
            paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
          }
          else if (localMessageRecord.msgtype == -1035)
          {
            paramArrayList = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
            localObject1 = (MessageForMixedMsg)paramArrayList;
            if (((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null)
            {
              paramArrayList1.add(((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              localObject1 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localObject2 = ((MessageForMixedMsg)paramArrayList).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((localObject1 != null) && (localObject2 != null)) {
                apvk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject1).getSourceMessage(), ((MessageForReplyText)localObject2).getSourceMessage());
              }
            }
          }
          else if (localMessageRecord.msgtype == -2011)
          {
            paramArrayList = new MessageForStructing(localMessageRecord);
          }
          else if (localMessageRecord.msgtype == -1049)
          {
            paramArrayList = (MessageRecord)localMessageRecord.deepCopyByReflect();
            ((MessageForReplyText)paramArrayList).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
            ((MessageForReplyText)paramArrayList).isBarrageMsg = false;
            ((MessageForReplyText)paramArrayList).barrageTimeLocation = 0L;
            paramArrayList.removeExtInfoToExtStr("barrage_time_location");
            paramArrayList.removeExtInfoToExtStr("barrage_source_msg_type");
          }
          else
          {
            paramArrayList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          }
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramArrayList.atInfoList = null;
        if ((mye.a(paramArrayList)) && (mye.b(paramArrayList))) {
          paramArrayList.senderuin = "80000000";
        }
        paramArrayList.extLong = localMessageRecord.extLong;
      }
      while (paramArrayList == null)
      {
        return null;
        paramArrayList = localMessageRecord;
      }
      paramArrayList.createMessageUniseq();
      paramArrayList.msgseq = paramMessageRecord.uniseq;
      paramArrayList.isMultiMsg = true;
      paramArrayList.extraflag = 32770;
      if (paramArrayList.msgtype == -1035)
      {
        localObject1 = ((MessageForMixedMsg)paramArrayList).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          ((MessageRecord)localObject2).msgseq = paramArrayList.msgseq;
          ((MessageRecord)localObject2).isMultiMsg = true;
        }
      }
      apvk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, paramArrayList);
      if (paramArrayList.msgtype == -1049)
      {
        localObject1 = (MessageForReplyText)localMessageRecord;
        localObject2 = (MessageForReplyText)paramArrayList;
        apvk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject1).getSourceMessage(), ((MessageForReplyText)localObject2).getSourceMessage());
      }
      if (paramArrayList.msgtype == -2022) {
        ((MessageForShortVideo)paramArrayList).redBagType = 0;
      }
      localArrayList.add(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord.toString());
      }
      if (paramBoolean1) {
        if (paramArrayList.getStatus() == 1000) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramArrayList.frienduin, paramArrayList.istroop, paramArrayList.getTableName(), paramArrayList, 0, paramakte);
        } else {
          a(paramArrayList, null);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, azmj paramazmj)
  {
    if ((!paramMsg.msg_body.has()) || ((!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, no msg_body or rich_text, msg_body.has():" + paramMsg.msg_body.has());
      }
      return null;
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l3 = localMsgHead.from_uin.get();
    long l4 = localMsgHead.msg_seq.get();
    long l5 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int j = localMsgHead.msg_type.get();
    Object localObject1 = String.valueOf(l3);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = axao.a((MessageHandler)localObject3, paramMsg, String.valueOf(l3), String.valueOf(l3));
    long l1;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      if (l1 != -1L) {
        break label1504;
      }
    }
    label328:
    label1498:
    label1504:
    for (long l2 = 0L;; l2 = l1)
    {
      localObject2 = new ArrayList();
      int i;
      if (((axas.c(j)) || (j == 208) || (j == 529)) && (localMsgHead.c2c_cmd.has()))
      {
        i = localMsgHead.c2c_cmd.get();
        if ((j == 529) && (i == 4))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject2, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
          if ((!localMsgHead.from_nick.has()) || (paramHashMap == null)) {
            break label1498;
          }
          paramazmj = localMsgHead.from_nick.get();
          paramHashMap.put(String.valueOf(l3), localMsgHead.from_nick.get());
        }
      }
      for (paramHashMap = paramazmj;; paramHashMap = (HashMap<String, String>)localObject1)
      {
        if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
          axao.a((MessageHandler)localObject3, (List)localObject2, paramMsg);
        }
        l1 = l3;
        int k = axao.a(paramMsg);
        localObject1 = ((ArrayList)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          paramazmj = (MessageRecord)((Iterator)localObject1).next();
          paramMsg = paramazmj;
          if (!avph.a(paramMessageRecord))
          {
            paramMsg = paramazmj;
            if (!asuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)paramazmj))
            {
              paramMsg = paramazmj;
              if (!(paramazmj instanceof MessageForArkApp))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "not support multi forward msg! " + paramazmj.toString());
                }
                paramMsg = axaq.a(-1000);
                paramMsg.msg = localMsgHead.multi_compatible_text.get();
                ((ArrayList)localObject2).set(i, paramMsg);
              }
            }
          }
          paramMsg.time = l5;
          paramMsg.shmsgseq = l4;
          paramMsg.msgUid = l6;
          paramMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramMsg.senderuin = String.valueOf(l3);
          paramMsg.frienduin = String.valueOf(l1);
          paramMsg.vipBubbleDiyTextId = k;
          paramMsg.vipBubbleID = akfw.a((int)l2, k);
          asuf.a(paramMsg, paramHashMap, paramMessageRecord);
          if ((j == 82) || (j == 43)) {
            paramMsg.istroop = 1;
          }
          for (;;)
          {
            i += 1;
            break label434;
            l1 = ((Long)((Pair)localObject2).second).longValue();
            break;
            if ((i != 175) && (i != 11)) {
              break label328;
            }
            axao.a((MessageHandler)localObject3, (List)localObject2, paramMsg, true, false, paramazmj);
            break label328;
            if (((j == 82) || (j == 43)) && (localMsgHead.group_info.has()))
            {
              l1 = localMsgHead.group_info.group_code.get();
              localMsgHead.group_info.group_code.get();
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject2, paramMsg)) {
                axao.a((MessageHandler)localObject3, (List)localObject2, paramMsg, false, false, paramazmj);
              }
              paramazmj = (azmj)localObject1;
              if (localMsgHead.group_info.group_card.has())
              {
                paramazmj = (azmj)localObject1;
                if (paramHashMap != null)
                {
                  localObject1 = localMsgHead.group_info.group_card.get().toStringUtf8();
                  paramazmj = (azmj)localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    paramHashMap.put(String.valueOf(l3), localObject1);
                    paramazmj = (azmj)localObject1;
                  }
                }
              }
              if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
                axao.a((MessageHandler)localObject3, paramMsg, (List)localObject2);
              }
              paramHashMap = (im_msg_body.MsgBody)paramMsg.msg_body.get();
              if (paramHashMap.rich_text.has())
              {
                paramHashMap = (im_msg_body.RichText)paramHashMap.rich_text.get();
                if (paramHashMap.elems.has())
                {
                  paramHashMap = paramHashMap.elems.get();
                  if (paramHashMap != null)
                  {
                    paramHashMap = paramHashMap.iterator();
                    while (paramHashMap.hasNext())
                    {
                      localObject1 = (im_msg_body.Elem)paramHashMap.next();
                      if (((im_msg_body.Elem)localObject1).anon_group_msg.has())
                      {
                        localObject1 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject1).anon_group_msg.get();
                        i = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_flags.get();
                        paramHashMap = ((im_msg_body.AnonymousGroupMsg)localObject1).str_anon_id.get().toByteArray();
                        localObject3 = ((im_msg_body.AnonymousGroupMsg)localObject1).str_anon_nick.get().toByteArray();
                        k = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_head_portrait.get();
                        int m = ((im_msg_body.AnonymousGroupMsg)localObject1).uint32_expire_time.get();
                        String str = ((im_msg_body.AnonymousGroupMsg)localObject1).str_rank_color.get().toStringUtf8();
                        if (paramHashMap != null) {}
                        for (;;)
                        {
                          try
                          {
                            paramHashMap = new String(paramHashMap, "ISO-8859-1");
                            Iterator localIterator = ((ArrayList)localObject2).iterator();
                            if (!localIterator.hasNext()) {
                              break;
                            }
                            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                            if (localObject3 != null) {
                              break label1172;
                            }
                            localObject1 = "";
                            localMessageRecord.saveExtInfoToExtStr("anonymous", mye.a(i, paramHashMap, (String)localObject1, k, m, str));
                            localMessageRecord.extLong |= 0x3;
                            continue;
                            paramHashMap = "";
                          }
                          catch (UnsupportedEncodingException paramHashMap)
                          {
                            paramHashMap.printStackTrace();
                          }
                          continue;
                          localObject1 = new String((byte[])localObject3);
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
                        }
                      }
                    }
                  }
                }
              }
              paramHashMap = paramazmj;
              break label418;
            }
            if (((j == 83) || (j == 42)) && (localMsgHead.discuss_info.has()))
            {
              l1 = localMsgHead.discuss_info.discuss_uin.get();
              localMsgHead.discuss_info.discuss_uin.get();
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b((ArrayList)localObject2, paramMsg)) {
                axao.a((MessageHandler)localObject3, (List)localObject2, paramMsg, false, false, paramazmj);
              }
              paramazmj = (azmj)localObject1;
              if (localMsgHead.discuss_info.discuss_remark.has())
              {
                paramazmj = (azmj)localObject1;
                if (paramHashMap != null)
                {
                  localObject1 = localMsgHead.discuss_info.discuss_remark.get().toStringUtf8();
                  paramazmj = (azmj)localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    paramHashMap.put(String.valueOf(l3), localObject1);
                    paramazmj = (azmj)localObject1;
                  }
                }
              }
              if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
                axao.a((MessageHandler)localObject3, paramMsg, (List)localObject2);
              }
              paramHashMap = paramazmj;
              break label418;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + j);
            }
            return null;
            if ((j == 83) || (j == 42)) {
              paramMsg.istroop = 3000;
            } else {
              paramMsg.istroop = 0;
            }
          }
        }
        akau.a((List)localObject2);
        return localObject2;
      }
    }
  }
  
  public ArrayList<MessageRecord> a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, azmj paramazmj)
  {
    long l4 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, start unpack, startTime:" + l4);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, data is null or data.lenght is 0");
      }
      return null;
    }
    Object localObject1 = b(paramArrayOfByte);
    if (localObject1 == null) {
      return null;
    }
    paramArrayOfByte = new ArrayList();
    Object localObject2 = new msg_transmit.PbMultiMsgTransmit();
    int i;
    Object localObject3;
    try
    {
      localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject2).mergeFrom((byte[])localObject1);
      i = 0;
      if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size()) {
        break label1167;
      }
      localObject3 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i);
      if ((!((msg_comm.Msg)localObject3).msg_body.has()) || ((!((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.has())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, no msg_body or rich_text, msg_body.has():" + ((msg_comm.Msg)localObject3).msg_body.has());
        }
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramArrayOfByte);
      }
      return null;
    }
    Object localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
    long l3 = ((msg_comm.MsgHead)localObject4).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject4).msg_seq.get();
    long l6 = ((msg_comm.MsgHead)localObject4).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject4).msg_uid.get();
    int j = ((msg_comm.MsgHead)localObject4).msg_type.get();
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject2 = axao.a(localMessageHandler, (msg_comm.Msg)localObject3, String.valueOf(l3), String.valueOf(l3));
    long l1;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      if (l1 != -1L) {
        break label1262;
      }
    }
    label575:
    label1262:
    for (long l2 = 0L;; l2 = l1)
    {
      localObject2 = new ArrayList();
      int k;
      if (((axas.c(j)) || (j == 208)) && (((msg_comm.MsgHead)localObject4).c2c_cmd.has()))
      {
        k = ((msg_comm.MsgHead)localObject4).c2c_cmd.get();
        if ((k == 175) || (k == 11))
        {
          if (((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.has()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject2, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.get());
          }
        }
        else
        {
          label497:
          if ((((msg_comm.MsgHead)localObject4).from_nick.has()) && (paramHashMap != null)) {
            paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).from_nick.get());
          }
          if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
            axao.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3);
          }
          l1 = l3;
          k = axao.a((msg_comm.Msg)localObject3);
          localObject3 = ((ArrayList)localObject2).iterator();
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label1146;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        ((MessageRecord)localObject4).time = l6;
        ((MessageRecord)localObject4).shmsgseq = l5;
        ((MessageRecord)localObject4).msgUid = l7;
        ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject4).senderuin = String.valueOf(l3);
        ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject4).vipBubbleDiyTextId = k;
        ((MessageRecord)localObject4).vipBubbleID = akfw.a((int)l2, k);
        if ((j == 82) || (j == 43))
        {
          ((MessageRecord)localObject4).istroop = 1;
          continue;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break;
          axao.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, true, false, paramazmj);
          break label497;
          if (((j == 82) || (j == 43)) && (((msg_comm.MsgHead)localObject4).group_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject2, (msg_comm.Msg)localObject3)) {
              axao.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramazmj);
            }
            if ((((msg_comm.MsgHead)localObject4).group_info.group_card.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).group_info.group_card.get().toStringUtf8());
            }
            if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
              axao.a(localMessageHandler, (msg_comm.Msg)localObject3, (List)localObject2);
            }
            break label575;
          }
          if (((j == 83) || (j == 42)) && (((msg_comm.MsgHead)localObject4).discuss_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b((ArrayList)localObject2, (msg_comm.Msg)localObject3)) {
              axao.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramazmj);
            }
            if ((((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.get().toStringUtf8());
            }
            if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
              axao.a(localMessageHandler, (msg_comm.Msg)localObject3, (List)localObject2);
            }
            break label575;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, illegal msgType:" + j);
          }
          return null;
        }
        if ((j == 83) || (j == 42)) {
          ((MessageRecord)localObject4).istroop = 3000;
        } else {
          ((MessageRecord)localObject4).istroop = 0;
        }
      }
      label1146:
      akau.a((List)localObject2);
      paramArrayOfByte.addAll((Collection)localObject2);
      i += 1;
      break;
      if ((paramMessageRecord == null) && (paramArrayOfByte.size() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg end unpack, type: longText");
        }
        return paramArrayOfByte;
      }
      if (!a(paramMessageRecord, paramArrayOfByte, null)) {
        return null;
      }
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, end unpack,endTime:" + l1 + " cost:" + (l1 - l4));
      }
      return paramArrayOfByte;
    }
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMessageRecord == null) || (!MessageForStructing.class.isInstance(paramMessageRecord)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "queryMultiMsgWithNest error before of null msg or not structMsg type");
      }
      return localHashMap;
    }
    b((MessageForStructing)paramMessageRecord, localHashMap, 0);
    return localHashMap;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, akte paramakte, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord == null) || (paramHashMap == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of null msg or map");
      }
    }
    do
    {
      do
      {
        return localHashMap;
        if (asuf.a((ChatMessage)paramMessageRecord)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of not structMsg");
      return localHashMap;
      a((MessageForStructing)paramMessageRecord, paramHashMap, localHashMap, 0, paramakte, paramBoolean1, paramBoolean2, localArrayList);
      if (localArrayList.size() > 0) {
        localHashMap.put("reply_msg", localArrayList);
      }
    } while (!paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return localHashMap;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, azmj paramazmj)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, start unpack, startTime:" + l1);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, data is null or data.lenght is 0");
      }
      return null;
    }
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = new msg_transmit.PbMultiMsgTransmit();
    Object localObject2;
    int i;
    Object localObject3;
    try
    {
      paramArrayOfByte = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject1).mergeFrom(paramArrayOfByte);
      localObject1 = new HashMap();
      if (paramArrayOfByte.pbItemList.has()) {
        break label301;
      }
      localObject2 = new ArrayList();
      if (paramArrayOfByte.msg.has())
      {
        i = 0;
        while (i < paramArrayOfByte.msg.size())
        {
          localObject3 = a((msg_comm.Msg)paramArrayOfByte.msg.get(i), paramHashMap, paramMessageRecord, paramazmj);
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            ((ArrayList)localObject2).addAll((Collection)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, String.format("unpackPbToMultiMsgWithNest for old version, msgsize:%d, msgtype:%d", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), Integer.valueOf(((MessageRecord)((ArrayList)localObject3).get(0)).msgtype) }));
            }
          }
          i += 1;
        }
      }
      if (((ArrayList)localObject2).size() <= 0) {
        break label288;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgTransmit", paramArrayOfByte);
      }
      return null;
    }
    ((HashMap)localObject1).put("MultiMsg", localObject2);
    label288:
    if (!a(paramMessageRecord, (HashMap)localObject1, null))
    {
      return null;
      label301:
      i = 0;
      label304:
      Object localObject4;
      if (i < paramArrayOfByte.pbItemList.size())
      {
        localObject4 = (msg_transmit.PbMultiMsgItem)paramArrayOfByte.pbItemList.get(i);
        localObject2 = ((msg_transmit.PbMultiMsgItem)localObject4).fileName.get();
        localObject3 = new msg_transmit.PbMultiMsgNew();
        try
        {
          ((msg_transmit.PbMultiMsgNew)localObject3).mergeFrom(((msg_transmit.PbMultiMsgItem)localObject4).buffer.get().toByteArray());
          localObject4 = new ArrayList();
          int j = 0;
          while (j < ((msg_transmit.PbMultiMsgNew)localObject3).msg.size())
          {
            ArrayList localArrayList = a((msg_comm.Msg)((msg_transmit.PbMultiMsgNew)localObject3).msg.get(j), paramHashMap, paramMessageRecord, paramazmj);
            if ((localArrayList != null) && (localArrayList.size() > 0)) {
              ((ArrayList)localObject4).addAll(localArrayList);
            }
            j += 1;
            continue;
            i += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgNew", localInvalidProtocolBufferMicroException);
          }
        }
      }
      for (;;)
      {
        break label304;
        break;
        ((HashMap)localObject1).put(localInvalidProtocolBufferMicroException, localObject4);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, end unpack,endTime:" + l2 + " cost:" + (l2 - l1));
    }
    return localObject1;
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap<String, String> paramHashMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(akpy.c(paramMessageRecord)).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject1 = new msg_comm.MutilTransHead();
    Object localObject2 = ((msg_comm.MutilTransHead)localObject1).status;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      ((PBUInt32Field)localObject2).set(i);
      ((msg_comm.MutilTransHead)localObject1).msgId.set(paramInt);
      localMsgHead.mutiltrans_head.set((MessageMicro)localObject1);
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("self_nickname");
      String str = akpy.c(paramMessageRecord);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (paramHashMap != null)
        {
          localObject1 = localObject2;
          if (paramHashMap.containsKey(str)) {
            localObject1 = (String)paramHashMap.get(str);
          }
        }
      }
      asuf.a("step:packPb.getMsgHead.nickName = %s", new Object[] { localObject1 });
      if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022)) {
        break label378;
      }
      if (!(paramMessageRecord instanceof MessageForPtt)) {
        break label301;
      }
      localMsgHead.msg_type.set(208);
      label250:
      if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        break label340;
      }
      localMsgHead.c2c_cmd.set(11);
      label274:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localMsgHead.from_nick.set((String)localObject1);
      }
    }
    for (;;)
    {
      return localMsgHead;
      i = -1;
      break;
      label301:
      if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile)))
      {
        localMsgHead.msg_type.set(529);
        break label250;
      }
      localMsgHead.msg_type.set(9);
      break label250;
      label340:
      if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile)))
      {
        localMsgHead.c2c_cmd.set(4);
        break label274;
      }
      localMsgHead.c2c_cmd.set(175);
      break label274;
      label378:
      if (paramMessageRecord.istroop == 3000)
      {
        localMsgHead.msg_type.set(83);
        paramHashMap = new msg_comm.DiscussInfo();
        paramHashMap.discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.discuss_remark.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.discuss_info.set(paramHashMap);
      }
      else
      {
        if (paramMessageRecord.istroop != 1) {
          break label530;
        }
        localMsgHead.msg_type.set(82);
        paramHashMap = new msg_comm.GroupInfo();
        paramHashMap.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.group_card.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.group_info.set(paramHashMap);
      }
    }
    label530:
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
    }
    return null;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000)) {
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
        localObject1 = axao.a(paramMessageRecord);
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((im_msg_body.RichText)localObject1).elems.isEmpty()))
      {
        Object localObject3 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject3).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        Object localObject4 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject4).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject4);
        if (mye.a(paramMessageRecord))
        {
          localObject3 = new im_msg_body.Elem();
          localObject4 = new im_msg_body.AnonymousGroupMsg();
          myf localmyf = mye.a(paramMessageRecord);
          ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_flags.set(localmyf.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localmyf.jdField_a_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_id.set(ByteStringMicro.copyFrom(localmyf.jdField_a_of_type_JavaLangString.getBytes()));
          }
          if (!TextUtils.isEmpty(localmyf.jdField_b_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_nick.set(ByteStringMicro.copyFrom(localmyf.jdField_b_of_type_JavaLangString.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_head_portrait.set(localmyf.jdField_b_of_type_Int);
          ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_expire_time.set(localmyf.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(localmyf.jdField_c_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject4).str_rank_color.set(ByteStringMicro.copyFrom(localmyf.jdField_c_of_type_JavaLangString.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
          ((im_msg_body.Elem)localObject3).anon_group_msg.set((MessageMicro)localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
          }
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
        }
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set((MessageMicro)localObject1);
        return paramMessageRecord;
        localObject1 = axao.a((MessageForText)paramMessageRecord);
        continue;
        if (paramMessageRecord.msgtype == -1049)
        {
          localObject1 = axao.a((MessageForReplyText)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2005)
        {
          if (paramBoolean)
          {
            localObject1 = ajyc.a(2131707011);
            if ((paramMessageRecord instanceof MessageForFile)) {
              localObject1 = ((MessageForFile)paramMessageRecord).getSummaryMsg();
            }
            localObject1 = axao.a((MessageForText)a(paramMessageRecord, (String)localObject1, false));
            continue;
          }
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(1, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2017)
        {
          if (paramBoolean)
          {
            localObject1 = ajyc.a(2131707009);
            if ((paramMessageRecord instanceof MessageForTroopFile)) {
              localObject1 = ((MessageForTroopFile)paramMessageRecord).getSummaryMsg();
            }
            localObject1 = axao.a((MessageForText)a(paramMessageRecord, (String)localObject1, false));
            continue;
          }
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(1, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2052)
        {
          localObject1 = axao.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2000)
        {
          localObject1 = axao.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5008)
        {
          localObject1 = axao.a((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5016)
        {
          localObject1 = axao.c((MessageForArkBabyqReply)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5017)
        {
          localObject1 = axao.b((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5013)
        {
          localObject1 = axao.c((MessageForArkFlashChat)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5014)
        {
          localObject1 = axao.d((MessageForHiBoom)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          localObject3 = axao.a((MessageForStructing)paramMessageRecord);
          if (localObject3 == null) {
            return null;
          }
          localObject4 = (MessageForStructing)paramMessageRecord;
          localObject1 = localObject3;
          try
          {
            if (((MessageForStructing)localObject4).structingMsg == null) {
              continue;
            }
            localObject1 = localObject3;
            if (!(((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)) {
              continue;
            }
            localObject4 = ((StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg).getFirstImageElement();
            localObject1 = localObject3;
            if (localObject4 == null) {
              continue;
            }
            localObject1 = ((axwt)localObject4).a.richText;
            if (localObject1 == null) {
              return null;
            }
            ((im_msg_body.RichText)localObject3).elems.add(((im_msg_body.RichText)localObject1).elems.get(0));
            localObject1 = localObject3;
          }
          catch (Exception localException)
          {
            localObject2 = localObject3;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MultiMsg_TAG", 2, " packMultiMsg.structMsg.exception...");
          localObject2 = localObject3;
          continue;
        }
        if (paramMessageRecord.msgtype == -1035)
        {
          localObject2 = new im_msg_body.RichText();
          int k = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
          int i = 0;
          if (i < k)
          {
            localObject3 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
            int j;
            if ((localObject3 instanceof MessageForText))
            {
              localObject3 = axao.a((MessageForText)localObject3);
              if (localObject3 == null) {
                return null;
              }
              j = 0;
              while (j < ((im_msg_body.RichText)localObject3).elems.size())
              {
                ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject3).elems.get(j));
                j += 1;
              }
            }
            if ((localObject3 instanceof MessageForRichText))
            {
              localObject3 = ((MessageForPic)localObject3).richText;
              if (localObject3 == null) {
                return null;
              }
              ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject3).elems.get(0));
            }
            for (;;)
            {
              i += 1;
              break;
              if ((localObject3 instanceof MessageForReplyText))
              {
                localObject3 = axao.a((MessageForReplyText)localObject3);
                if (localObject3 != null)
                {
                  j = 0;
                  while (j < ((im_msg_body.RichText)localObject3).elems.size())
                  {
                    ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject3).elems.get(j));
                    j += 1;
                  }
                }
              }
            }
          }
          continue;
        }
        if (paramMessageRecord.msgtype == -1051)
        {
          localObject2 = axao.a((MessageForLongTextMsg)paramMessageRecord, false);
          continue;
        }
        if (paramMessageRecord.msgtype == -2022)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            localObject2 = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else if ((paramMessageRecord.msgtype == -2002) && ((paramMessageRecord instanceof MessageForRichText))) {
          localObject2 = ((MessageForRichText)paramMessageRecord).richText;
        }
      }
      else
      {
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  protected void a() {}
  
  protected void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, akte paramakte)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (paramMessageRecord.senderuin.equals(localMessageRecord1.senderuin))
      {
        localMessageRecord1.issend = 1;
        localMessageRecord1.selfuin = localMessageRecord1.senderuin;
      }
      if ((localMessageRecord1 instanceof MessageForPtt)) {
        localMessageRecord1.issend = paramMessageRecord.issend;
      }
      localMessageRecord1.msgseq = paramMessageRecord.uniseq;
      localMessageRecord1.isMultiMsg = true;
      if (localMessageRecord1.msgtype == -1035)
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        QLog.d("MultiMsg_TAG", 2, "addMultiMsgSingle, time:" + localMessageRecord1.time + " senderuin:" + localMessageRecord1.senderuin + " istroop:" + localMessageRecord1.istroop + " shmsgseq:" + localMessageRecord1.shmsgseq + " msgseq:" + localMessageRecord1.msgseq + " msgData:" + localMessageRecord1.msgData);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramakte);
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  public boolean a(MessageRecord paramMessageRecord, akte paramakte)
  {
    if (paramMessageRecord.getStatus() == 1000) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 3, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 4, null);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, akte paramakte)
  {
    if ((paramMessageRecord == null) || (paramHashMap == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of null msg or map");
      }
    }
    do
    {
      return false;
      if (MessageForStructing.class.isInstance(paramMessageRecord)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of not structMsg");
    return false;
    a((MessageForStructing)paramMessageRecord, paramHashMap, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, akte paramakte)
  {
    a(paramMessageRecord, paramList, paramakte);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return true;
  }
  
  public boolean a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      boolean bool = false;
      if (localIterator1.hasNext())
      {
        ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator1.next());
        Iterator localIterator2 = localArrayList.iterator();
        int i = 0;
        label63:
        MessageRecord localMessageRecord1;
        if (localIterator2.hasNext())
        {
          localMessageRecord1 = (MessageRecord)localIterator2.next();
          if ((localMessageRecord1 instanceof MessageForReplyText))
          {
            MessageRecord localMessageRecord2 = ((MessageForReplyText)localMessageRecord1).getSourceMessage();
            if ((localMessageRecord2 != null) && (((localMessageRecord2 instanceof MessageForPic)) || ((localMessageRecord2 instanceof MessageForShortVideo))) && (localMessageRecord2.uniseq == paramMessageRecord.uniseq)) {
              bool = true;
            }
          }
        }
        for (;;)
        {
          if (bool)
          {
            if ((localArrayList.get(i) instanceof MessageForReplyText))
            {
              ((MessageForReplyText)localArrayList.get(i)).setSourceMessageRecord(paramMessageRecord);
              return bool;
              if (localMessageRecord1.uniseq == paramMessageRecord.uniseq)
              {
                bool = true;
                continue;
              }
              i += 1;
              break label63;
            }
            localArrayList.set(i, paramMessageRecord);
            return bool;
          }
          break;
          bool = false;
        }
      }
      return bool;
    }
    return false;
  }
  
  public boolean a(List<MessageRecord> paramList, akte paramakte)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramakte = (MessageRecord)paramList.next();
      if (paramakte.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramakte.frienduin, paramakte.istroop, paramakte.getTableName(), paramakte, 3, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramakte.frienduin, paramakte.istroop, paramakte.getTableName(), paramakte, 4, null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return true;
  }
  
  public byte[] a(MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, start pack, startTime:" + l1);
    }
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put(paramMessageRecord.senderuin, localObject1);
    localObject1 = new msg_comm.Msg();
    localObject2 = a(paramMessageRecord, (HashMap)localObject2, true, 1, false);
    im_msg_body.MsgBody localMsgBody = a(paramMessageRecord, false);
    if ((localObject2 != null) && (localMsgBody != null))
    {
      ((msg_comm.Msg)localObject1).msg_head.set((MessageMicro)localObject2);
      ((msg_comm.Msg)localObject1).msg_body.set(localMsgBody);
      localPbMultiMsgTransmit.msg.add((MessageMicro)localObject1);
    }
    for (;;)
    {
      paramMessageRecord = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, end pack, endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:" + paramMessageRecord.uniseq);
      }
    }
  }
  
  public byte[] a(ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, new Object[] { "packPbToMultiMsg, start pack, startTime:", Long.valueOf(l1) });
    }
    MessageRecord localMessageRecord = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = localMessageRecord;
    int j;
    while (localIterator.hasNext())
    {
      localMessageRecord = (MessageRecord)localIterator.next();
      msg_comm.Msg localMsg = new msg_comm.Msg();
      j = i + 1;
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean, i, false);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        localMsg.msg_head.set(localMsgHead);
        localMsg.msg_body.set(localMsgBody);
        localPbMultiMsgTransmit.msg.add(localMsg);
        i = j;
      }
      else
      {
        if (paramArrayList != null) {
          break label298;
        }
        paramArrayList = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
      }
    }
    label298:
    for (;;)
    {
      paramArrayList.append(localMessageRecord.uniseq).append("|");
      i = j;
      break;
      if ((paramArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("MultiMsg_TAG", 2, paramArrayList.toString());
      }
      paramArrayList = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbToMultiMsg, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramArrayList;
    }
  }
  
  public byte[] a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, HashMap<String, String> paramHashMap1, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, new Object[] { "packPbFromMultiMsgWithNest, start pack, startTime:", Long.valueOf(l1) });
    }
    Object localObject1 = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Object localObject2 = paramHashMap.keySet().iterator();
    Object localObject3;
    Object localObject4;
    msg_transmit.PbMultiMsgNew localPbMultiMsgNew;
    label131:
    MessageRecord localMessageRecord;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      Object localObject5 = (ArrayList)paramHashMap.get(localObject3);
      localObject4 = new msg_transmit.PbMultiMsgItem();
      localPbMultiMsgNew = new msg_transmit.PbMultiMsgNew();
      localObject5 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
        msg_comm.Msg localMsg = new msg_comm.Msg();
        j = i + 1;
        msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap1, paramBoolean, i, false);
        im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
        if ((localMsgHead != null) && (localMsgBody != null))
        {
          localMsg.msg_head.set(localMsgHead);
          localMsg.msg_body.set(localMsgBody);
          localPbMultiMsgNew.msg.add(localMsg);
          i = j;
        }
        else
        {
          if (localObject1 != null) {
            break label613;
          }
          localObject1 = new StringBuilder("packPbFromMultiMsgWithNest error:msg_head or msg_body is null, uniseq:");
        }
      }
    }
    label610:
    label613:
    for (;;)
    {
      ((StringBuilder)localObject1).append(localMessageRecord.uniseq).append("|");
      i = j;
      break label131;
      ((msg_transmit.PbMultiMsgItem)localObject4).fileName.set((String)localObject3);
      ((msg_transmit.PbMultiMsgItem)localObject4).buffer.set(ByteStringMicro.copyFrom(localPbMultiMsgNew.toByteArray()));
      localPbMultiMsgTransmit.pbItemList.add((MessageMicro)localObject4);
      break;
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      paramHashMap = (ArrayList)paramHashMap.get("MultiMsg");
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        localObject1 = paramHashMap.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          paramHashMap = (MessageRecord)((Iterator)localObject1).next();
          if (!asuf.a((ChatMessage)paramHashMap)) {
            break label610;
          }
          paramHashMap = a(paramHashMap, astw.jdField_b_of_type_JavaLangString, false);
        }
      }
      for (;;)
      {
        localObject2 = new msg_comm.Msg();
        j = i + 1;
        localObject3 = a(paramHashMap, paramHashMap1, paramBoolean, i, true);
        localObject4 = a(paramHashMap, true);
        if ((localObject3 != null) && (localObject4 != null))
        {
          ((msg_comm.Msg)localObject2).msg_head.set((MessageMicro)localObject3);
          ((msg_comm.Msg)localObject2).msg_body.set((MessageMicro)localObject4);
          localPbMultiMsgTransmit.msg.add((MessageMicro)localObject2);
          i = j;
          break;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:" + paramHashMap.uniseq);
          new StringBuilder();
          i = j;
          break;
          paramHashMap = a(localPbMultiMsgTransmit.toByteArray());
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsgWithNest, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
          }
          return paramHashMap;
        }
        i = j;
        break;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aukv != null) && (this.jdField_a_of_type_Aukv.a())) {
      this.jdField_a_of_type_Aukv.a();
    }
  }
  
  public void c()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        i = localSQLiteDatabase.a("mr_multimessage");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "checkMsgCounts, count:" + i);
        }
      } while (i <= 1000000);
      i = Math.max(i - 1000000, 200);
      localMessageRecord = a(i);
    } while (localMessageRecord == null);
    String str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "checkMsgCounts, delNum:" + i + "mr.msgseq:" + localMessageRecord.msgseq);
    }
    try
    {
      localSQLiteDatabase.a(str);
      label165:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgseq);
      return;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqb
 * JD-Core Version:    0.7.0.1
 */