import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper.1;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper.2;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper.3;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;

public class agmg
  implements agma, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ImageView a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agmg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private int a(List<ChatMessage> paramList)
  {
    int j;
    if ((paramList == null) || (paramList.size() == 0)) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      paramList = paramList.iterator();
      i = 0;
      j = i;
    } while (!paramList.hasNext());
    if (!a((ChatMessage)paramList.next())) {
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public static FileManagerEntity a(bety parambety)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = atvo.a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = parambety.g;
    if (atwl.a(parambety.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(parambety.jdField_a_of_type_JavaLangString);
    }
    if (atwl.a(parambety.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = parambety.jdField_c_of_type_JavaLangString;
    }
    if (atwl.a(parambety.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = parambety.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = parambety.jdField_c_of_type_Long;
      localFileManagerEntity.fProgress = ((float)parambety.jdField_d_of_type_Long / (float)parambety.jdField_c_of_type_Long);
      localFileManagerEntity.nFileType = atvo.a(parambety.g);
      if ((6 <= parambety.jdField_b_of_type_Int) && (13 != parambety.jdField_b_of_type_Int)) {
        break label300;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (parambety.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = parambety.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = parambety.e;
      localFileManagerEntity.strTroopFileSha1 = parambety.f;
      localFileManagerEntity.busId = parambety.h;
      localFileManagerEntity.TroopUin = parambety.jdField_b_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(parambety.jdField_b_of_type_Long);
      QLog.i("MultiFavoriteHelper", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + parambety.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      return localFileManagerEntity;
      if (!atwl.a(parambety.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = parambety.jdField_d_of_type_JavaLangString;
      break;
      label300:
      if (12 == parambety.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {}
    for (;;)
    {
      return null;
      Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (int i = Integer.parseInt((String)localObject); (i == 1) || (i == 2) || (i == 3); i = -1)
      {
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = atvo.a().longValue();
        ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
        ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
        ((FileManagerEntity)localObject).isReaded = false;
        String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
        if (!TextUtils.isEmpty(str)) {
          ((FileManagerEntity)localObject).busId = Integer.valueOf(str).intValue();
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          if (i == 1)
          {
            ((FileManagerEntity)localObject).peerType = 0;
            ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            label147:
            ((FileManagerEntity)localObject).peerNick = atvo.a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
            ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
            ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
            ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              ((FileManagerEntity)localObject).fileSize = Long.parseLong(paramQQAppInterface);
            }
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label410;
              }
              ((FileManagerEntity)localObject).nOpType = 0;
            }
            label254:
            ((FileManagerEntity)localObject).status = -1;
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label418;
              }
              ((FileManagerEntity)localObject).bSend = false;
            }
            label293:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
            if (!bgmg.b(paramQQAppInterface)) {
              break label426;
            }
            ((FileManagerEntity)localObject).setFilePath(paramQQAppInterface);
            ((FileManagerEntity)localObject).setCloudType(3);
            ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
            ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
          }
          try
          {
            ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(paramQQAppInterface);
            label356:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
            try
            {
              ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(paramQQAppInterface);
              label372:
              return localObject;
              ((FileManagerEntity)localObject).busId = -1;
              continue;
              if (i == 2)
              {
                ((FileManagerEntity)localObject).peerType = 3000;
                break label147;
              }
              if (i != 3) {
                break label147;
              }
              ((FileManagerEntity)localObject).peerType = 1;
              break label147;
              label410:
              ((FileManagerEntity)localObject).nOpType = 1;
              break label254;
              label418:
              ((FileManagerEntity)localObject).bSend = true;
              break label293;
              label426:
              ((FileManagerEntity)localObject).setCloudType(1);
            }
            catch (NumberFormatException paramQQAppInterface)
            {
              break label372;
            }
          }
          catch (NumberFormatException paramQQAppInterface)
          {
            break label356;
          }
        }
      }
    }
  }
  
  /* Error */
  private com.tencent.mobileqq.persistence.Entity a(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +32 -> 41
    //   12: ldc 198
    //   14: iconst_2
    //   15: new 200	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 352
    //   25: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 353	java/lang/Object:toString	()Ljava/lang/String;
    //   32: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   45: invokevirtual 364	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   48: checkcast 366	com/tencent/mobileqq/persistence/Entity
    //   51: astore 5
    //   53: aload 5
    //   55: astore 4
    //   57: aload 5
    //   59: ifnull +124 -> 183
    //   62: aload_1
    //   63: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   66: invokevirtual 370	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   69: astore 6
    //   71: aload 6
    //   73: arraylength
    //   74: istore_3
    //   75: iconst_0
    //   76: istore_2
    //   77: aload 5
    //   79: astore 4
    //   81: iload_2
    //   82: iload_3
    //   83: if_icmpge +100 -> 183
    //   86: aload 6
    //   88: iload_2
    //   89: aaload
    //   90: astore 4
    //   92: aload 4
    //   94: invokevirtual 375	java/lang/reflect/Field:isAccessible	()Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: iconst_1
    //   103: invokevirtual 379	java/lang/reflect/Field:setAccessible	(Z)V
    //   106: aload 4
    //   108: aload 5
    //   110: aload 4
    //   112: aload_1
    //   113: invokevirtual 383	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: invokevirtual 387	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: istore_2
    //   123: goto -46 -> 77
    //   126: astore 4
    //   128: ldc_w 389
    //   131: iconst_1
    //   132: new 200	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 391
    //   142: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 394	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 396
    //   158: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 4
    //   163: invokevirtual 399	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 4
    //   177: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   180: aconst_null
    //   181: astore 4
    //   183: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +30 -> 216
    //   189: ldc 198
    //   191: iconst_2
    //   192: new 200	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 404
    //   202: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 4
    //   218: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	agmg
    //   0	219	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   76	47	2	i	int
    //   74	10	3	j	int
    //   55	56	4	localEntity1	com.tencent.mobileqq.persistence.Entity
    //   126	50	4	localException	Exception
    //   181	36	4	localObject	Object
    //   51	58	5	localEntity2	com.tencent.mobileqq.persistence.Entity
    //   69	18	6	arrayOfField	java.lang.reflect.Field[]
    // Exception table:
    //   from	to	target	type
    //   6	41	126	java/lang/Exception
    //   41	53	126	java/lang/Exception
    //   62	75	126	java/lang/Exception
    //   92	106	126	java/lang/Exception
    //   106	119	126	java/lang/Exception
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (paramQQAppInterface == null)) {
      paramQQAppInterface = null;
    }
    String str3;
    do
    {
      return paramQQAppInterface;
      str3 = acwh.c(paramChatMessage);
      String str2 = "";
      String str1 = str2;
      if (paramChatMessage.isMultiMsg)
      {
        str1 = str2;
        if (!njo.a(paramChatMessage))
        {
          str2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = awwm.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, paramQQAppInterface);
          }
        }
      }
      if (str1 != null)
      {
        paramQQAppInterface = str1;
        if (TextUtils.getTrimmedLength(str1) != 0) {}
      }
      else
      {
        paramQQAppInterface = awwt.a(paramChatMessage.senderuin);
      }
    } while (!TextUtils.isEmpty(str3));
    return str3;
  }
  
  /* Error */
  private ArrayList<ChatMessage> a(MessageForStructing paramMessageForStructing, ArrayList<ChatMessage> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 447	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 448	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_2
    //   16: invokevirtual 449	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore 6
    //   21: aload 6
    //   23: invokeinterface 56 1 0
    //   28: ifeq +576 -> 604
    //   31: aload 6
    //   33: invokeinterface 60 1 0
    //   38: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   41: astore 7
    //   43: aload 7
    //   45: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   48: sipush -1037
    //   51: if_icmpne +221 -> 272
    //   54: aload 7
    //   56: checkcast 454	com/tencent/mobileqq/data/MessageForLongMsg
    //   59: invokevirtual 458	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   62: checkcast 460	com/tencent/mobileqq/data/MessageForText
    //   65: checkcast 460	com/tencent/mobileqq/data/MessageForText
    //   68: astore_2
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: ifnonnull +179 -> 251
    //   75: aload_2
    //   76: astore_3
    //   77: aload 7
    //   79: instanceof 460
    //   82: ifeq +169 -> 251
    //   85: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +12 -> 100
    //   91: ldc 198
    //   93: iconst_2
    //   94: ldc_w 462
    //   97: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: aload 7
    //   103: invokespecial 464	agmg:a	(Lcom/tencent/mobileqq/persistence/Entity;)Lcom/tencent/mobileqq/persistence/Entity;
    //   106: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   109: astore_2
    //   110: aload 7
    //   112: ifnull +53 -> 165
    //   115: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +47 -> 165
    //   121: ldc 198
    //   123: iconst_2
    //   124: new 200	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 466
    //   134: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 7
    //   139: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   142: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 471
    //   148: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 7
    //   153: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   156: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_2
    //   166: ifnull +51 -> 217
    //   169: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +45 -> 217
    //   175: ldc 198
    //   177: iconst_2
    //   178: new 200	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 477
    //   188: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   195: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 471
    //   201: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   208: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_2
    //   218: ifnull +145 -> 363
    //   221: aload_2
    //   222: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   225: ifnull +138 -> 363
    //   228: aload_2
    //   229: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   232: ifnonnull +131 -> 363
    //   235: aload_2
    //   236: aload_2
    //   237: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   240: ldc_w 479
    //   243: invokevirtual 483	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   246: putfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   249: aload_2
    //   250: astore_3
    //   251: aload_3
    //   252: ifnonnull +167 -> 419
    //   255: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -254 -> 4
    //   261: ldc 198
    //   263: iconst_2
    //   264: ldc_w 485
    //   267: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aconst_null
    //   271: areturn
    //   272: aload 7
    //   274: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   277: sipush -1036
    //   280: if_icmpne +21 -> 301
    //   283: aload 7
    //   285: checkcast 454	com/tencent/mobileqq/data/MessageForLongMsg
    //   288: invokevirtual 458	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   291: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   294: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   297: astore_2
    //   298: goto -229 -> 69
    //   301: aload 7
    //   303: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   306: sipush -1035
    //   309: if_icmpne +18 -> 327
    //   312: aload 7
    //   314: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   317: invokevirtual 490	com/tencent/mobileqq/data/MessageForMixedMsg:rebuildMixedMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   320: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   323: astore_2
    //   324: goto -255 -> 69
    //   327: aload 7
    //   329: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   332: sipush -2011
    //   335: if_icmpne +16 -> 351
    //   338: new 492	com/tencent/mobileqq/data/MessageForStructing
    //   341: dup
    //   342: aload 7
    //   344: invokespecial 495	com/tencent/mobileqq/data/MessageForStructing:<init>	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   347: astore_2
    //   348: goto -279 -> 69
    //   351: aload 7
    //   353: invokevirtual 499	com/tencent/mobileqq/data/ChatMessage:deepCopyByReflect	()Lcom/tencent/mobileqq/persistence/Entity;
    //   356: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   359: astore_2
    //   360: goto -291 -> 69
    //   363: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +12 -> 378
    //   369: ldc 198
    //   371: iconst_2
    //   372: ldc_w 501
    //   375: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aconst_null
    //   379: astore_2
    //   380: goto -131 -> 249
    //   383: astore 4
    //   385: aload_2
    //   386: astore_3
    //   387: aload 4
    //   389: astore_2
    //   390: ldc 198
    //   392: iconst_2
    //   393: new 200	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 503
    //   403: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: goto -165 -> 251
    //   419: aload_3
    //   420: ldc_w 505
    //   423: invokevirtual 252	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   426: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifne +10 -> 439
    //   432: aload_3
    //   433: ldc_w 505
    //   436: invokevirtual 508	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   439: aload_3
    //   440: ldc_w 510
    //   443: invokevirtual 252	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +10 -> 459
    //   452: aload_3
    //   453: ldc_w 510
    //   456: invokevirtual 508	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   459: aload_3
    //   460: aconst_null
    //   461: putfield 514	com/tencent/mobileqq/data/ChatMessage:atInfoList	Ljava/util/ArrayList;
    //   464: aload_3
    //   465: aload_1
    //   466: getfield 515	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   469: putfield 433	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   472: aload_3
    //   473: ldc_w 516
    //   476: putfield 519	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   479: aload_3
    //   480: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   483: sipush -1035
    //   486: if_icmpne +54 -> 540
    //   489: aload_3
    //   490: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   493: getfield 523	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   496: invokeinterface 50 1 0
    //   501: astore_2
    //   502: aload_2
    //   503: invokeinterface 56 1 0
    //   508: ifeq +32 -> 540
    //   511: aload_2
    //   512: invokeinterface 60 1 0
    //   517: checkcast 525	com/tencent/mobileqq/data/MessageRecord
    //   520: astore 4
    //   522: aload 4
    //   524: aload_3
    //   525: getfield 433	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   528: putfield 526	com/tencent/mobileqq/data/MessageRecord:msgseq	J
    //   531: aload 4
    //   533: iconst_1
    //   534: putfield 527	com/tencent/mobileqq/data/MessageRecord:isMultiMsg	Z
    //   537: goto -35 -> 502
    //   540: aload_3
    //   541: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   544: sipush -2022
    //   547: if_icmpne +11 -> 558
    //   550: aload_3
    //   551: checkcast 529	com/tencent/mobileqq/data/MessageForShortVideo
    //   554: iconst_0
    //   555: putfield 532	com/tencent/mobileqq/data/MessageForShortVideo:redBagType	I
    //   558: aload 5
    //   560: aload_3
    //   561: invokevirtual 535	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   564: pop
    //   565: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq -547 -> 21
    //   571: ldc 198
    //   573: iconst_2
    //   574: new 200	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 537
    //   584: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 7
    //   589: invokevirtual 538	com/tencent/mobileqq/data/ChatMessage:toString	()Ljava/lang/String;
    //   592: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: goto -580 -> 21
    //   604: aload 5
    //   606: areturn
    //   607: astore_2
    //   608: aconst_null
    //   609: astore_3
    //   610: goto -220 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	agmg
    //   0	613	1	paramMessageForStructing	MessageForStructing
    //   0	613	2	paramArrayList	ArrayList<ChatMessage>
    //   70	540	3	localArrayList	ArrayList<ChatMessage>
    //   383	5	4	localException	Exception
    //   520	12	4	localMessageRecord	MessageRecord
    //   13	592	5	localArrayList1	ArrayList
    //   19	13	6	localIterator	Iterator
    //   41	547	7	localChatMessage	ChatMessage
    // Exception table:
    //   from	to	target	type
    //   115	165	383	java/lang/Exception
    //   169	217	383	java/lang/Exception
    //   221	249	383	java/lang/Exception
    //   363	378	607	java/lang/Exception
  }
  
  private void a(afwy paramafwy, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (paramafwy == null)) {}
    for (;;)
    {
      return;
      agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "favorSingleMsg");
      }
      bljw.a().a = false;
      paramafwy.a.a(paramChatMessage, paramafwy).a(2131366271, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      if (bljw.a().a) {
        bljw.a().a = false;
      }
      while (alqc.a().c())
      {
        alqc.a().d();
        return;
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.1(this));
      }
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, MessageForTroopFile paramMessageForTroopFile)
  {
    if ((paramFileManagerEntity == null) || (paramMessageForTroopFile == null)) {}
    do
    {
      do
      {
        return;
        if ((paramFileManagerEntity.fileSize == 0L) && (paramMessageForTroopFile.fileSize > 0L))
        {
          paramFileManagerEntity.fileSize = paramMessageForTroopFile.fileSize;
          if (QLog.isColorLevel()) {
            QLog.d("qqfav", 2, "checkPatchEntity, patch size:" + paramFileManagerEntity.fileSize);
          }
        }
      } while ((!TextUtils.isEmpty(paramFileManagerEntity.fileName)) || (TextUtils.isEmpty(paramMessageForTroopFile.fileName)));
      paramFileManagerEntity.fileName = paramMessageForTroopFile.fileName;
    } while (!QLog.isColorLevel());
    QLog.d("qqfav", 2, "checkPatchEntity, patch name:" + paramFileManagerEntity.fileName);
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131691985, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, 4);
      awwm.a().b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(2131697670);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList);
    awwm.a().jdField_a_of_type_JavaUtilArrayList.clear();
    awwm.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    awwm.a().jdField_a_of_type_Int = 6;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aicv)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = awwm.a().a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
    }
    for (;;)
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      Message localMessage = paramList.obtainMessage(24);
      localMessage.arg1 = localArrayList.size();
      paramList.sendMessageDelayed(localMessage, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(localArrayList);
      }
    }
  }
  
  private void a(List<ChatMessage> paramList, List<String> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = acwh.c((ChatMessage)paramList.next());
        if (!paramList1.contains(str)) {
          paramList1.add(str);
        }
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!awwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage));
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break;
        }
      } while (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 35);
      return true;
    } while (((paramChatMessage instanceof MessageForArkApp)) || (((paramChatMessage instanceof MessageForPic)) && (ains.a((MessageForPic)paramChatMessage))));
    return true;
  }
  
  private boolean a(List<ChatMessage> paramList, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList == null) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramList.size() > paramInt);
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (bljz.a(localChatMessage)) {
          i = ((MessageForStructing)localChatMessage).structingMsg.mTSum + i;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      }
      bool1 = bool2;
    } while (i > paramInt);
    return true;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onActivityResult");
    }
    if (paramIntent != null)
    {
      long l = paramIntent.getExtras().getLong("requestId", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "onActivityResult, id:" + l);
      }
      bljw.a().a(l);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, afwy paramafwy, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onClickMultiFavoriteBtn");
    }
    int i = awwm.a().c();
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C5B", "0X8009C5B", 0, i, "", "", "", "");
    if (paramMessageForStructing == null)
    {
      paramMessageForStructing = awwm.a().a();
      if (paramMessageForStructing.size() == 1)
      {
        localArrayList = awwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramMessageForStructing);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramMessageForStructing = (ChatMessage)localArrayList.get(0);
          a(paramafwy, paramMessageForStructing);
          paramBaseChatPie.a(false, null, false);
        }
      }
    }
    while (!bljz.a(paramMessageForStructing))
    {
      for (;;)
      {
        ArrayList localArrayList;
        return;
        paramMessageForStructing = (ChatMessage)paramMessageForStructing.get(0);
      }
      if (paramMessageForStructing.size() != 0) {
        break label423;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697668, 0).b(paramBaseChatPie.a());
      return;
    }
    paramafwy = new ArrayList();
    paramafwy.add(paramMessageForStructing);
    for (;;)
    {
      bljw.a().a = true;
      if (!a(paramafwy, awwm.a().a()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131693467, 0).b(paramBaseChatPie.a());
        return;
      }
      i = a(paramafwy);
      paramMessageForStructing = paramafwy;
      if (i > 0)
      {
        if (paramafwy.size() == i)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131693856, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
        paramMessageForStructing = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        if (!bljz.a(paramMessageForStructing))
        {
          bljz.b(paramMessageForStructing);
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131692966), this.jdField_a_of_type_AndroidContentContext.getString(2131693857), new agmh(this, paramafwy, paramBaseChatPie));
          return;
        }
        paramafwy = awwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramafwy);
        if (paramafwy != null)
        {
          paramMessageForStructing = paramafwy;
          if (paramafwy.size() != 0) {}
        }
        else
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131693856, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
      }
      a(paramMessageForStructing);
      paramBaseChatPie.a(false, null, false);
      return;
      label423:
      paramafwy = paramMessageForStructing;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364427);
        if (AppSetting.c) {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131705781));
        }
      }
      paramBaseChatPie = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      paramBaseChatPie.setMargins(paramInt3, 0, 0, 0);
      paramBaseChatPie.gravity = 16;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatPie);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatPie = new StateListDrawable();
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839359);
      paramBaseChatPie.addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839358);
      paramBaseChatPie.addState(new int[] { 16842910 }, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseChatPie);
    } while (paramLinearLayout == null);
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    try
    {
      bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, paramString1, "", paramString2, new agmi(this, paramOnClickListener), null).show();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "favorMultiMsg");
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      localObject1 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() == 1) && (bljz.a((ChatMessage)paramArrayList.get(0))))
      {
        localObject1 = (MessageForStructing)paramArrayList.get(0);
        localObject2 = null;
        label87:
        paramArrayList = bljl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject1, (List)localObject2, paramMap);
        if (paramArrayList == null) {
          break label412;
        }
        if (-1L >= 0L) {
          paramArrayList.a(-1L);
        }
        paramArrayList.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
        paramMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        bool = paramArrayList.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramMap, 18000, null);
        if (bool) {
          break label399;
        }
        bljw.a().a(-1L);
        paramArrayList = paramArrayList.a();
        if (paramArrayList == null) {
          break;
        }
        paramArrayList = this.jdField_a_of_type_AndroidContentContext.getString(paramArrayList.getIntExtra("nReasonInt", 2131691988));
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.3(this, paramMap, bool, paramArrayList));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
          break label422;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        continue;
      }
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt != 1) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = adrm.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
        if (localObject1 == null) {
          break;
        }
        MessageForStructing localMessageForStructing = awwm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, (AbsStructMsg)localObject1);
        ArrayList localArrayList = a(localMessageForStructing, paramArrayList);
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (localArrayList != null) {
          break label87;
        }
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (paramArrayList == null) {
          break label87;
        }
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (paramArrayList.size() <= 0) {
          break label87;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.2(this));
        return;
      }
      label399:
      bljn.a(this.jdField_a_of_type_AndroidContentContext, paramMap, bool, null, false);
      return;
      label412:
      QLog.e("MultiFavoriteHelper", 2, "builder == null");
      return;
      label422:
      localObject1 = " ";
    }
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((agmg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afwy, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmg
 * JD-Core Version:    0.7.0.1
 */