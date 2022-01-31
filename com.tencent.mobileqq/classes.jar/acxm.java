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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;

public class acxm
  implements acxg
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ImageView a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public acxm(BaseChatPie paramBaseChatPie)
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
  
  /* Error */
  private atmo a(atmo paramatmo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +31 -> 40
    //   12: ldc 76
    //   14: iconst_2
    //   15: new 78	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   22: ldc 81
    //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 89	java/lang/Object:toString	()Ljava/lang/String;
    //   31: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: invokevirtual 103	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   47: checkcast 105	atmo
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: ifnull +121 -> 179
    //   61: aload_1
    //   62: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
    //   65: invokevirtual 109	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   68: astore 6
    //   70: aload 6
    //   72: arraylength
    //   73: istore_3
    //   74: iconst_0
    //   75: istore_2
    //   76: aload 5
    //   78: astore 4
    //   80: iload_2
    //   81: iload_3
    //   82: if_icmpge +97 -> 179
    //   85: aload 6
    //   87: iload_2
    //   88: aaload
    //   89: astore 4
    //   91: aload 4
    //   93: invokevirtual 114	java/lang/reflect/Field:isAccessible	()Z
    //   96: ifne +9 -> 105
    //   99: aload 4
    //   101: iconst_1
    //   102: invokevirtual 118	java/lang/reflect/Field:setAccessible	(Z)V
    //   105: aload 4
    //   107: aload 5
    //   109: aload 4
    //   111: aload_1
    //   112: invokevirtual 122	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: invokevirtual 126	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   118: iload_2
    //   119: iconst_1
    //   120: iadd
    //   121: istore_2
    //   122: goto -46 -> 76
    //   125: astore 4
    //   127: ldc 128
    //   129: iconst_1
    //   130: new 78	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   137: ldc 130
    //   139: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
    //   146: invokevirtual 133	java/lang/Class:getName	()Ljava/lang/String;
    //   149: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 135
    //   154: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 4
    //   159: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   176: aconst_null
    //   177: astore 4
    //   179: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +29 -> 211
    //   185: ldc 76
    //   187: iconst_2
    //   188: new 78	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   195: ldc 143
    //   197: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 4
    //   202: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 4
    //   213: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	acxm
    //   0	214	1	paramatmo	atmo
    //   75	47	2	i	int
    //   73	10	3	j	int
    //   54	56	4	localatmo1	atmo
    //   125	47	4	localException	Exception
    //   177	35	4	localObject	Object
    //   50	58	5	localatmo2	atmo
    //   68	18	6	arrayOfField	java.lang.reflect.Field[]
    // Exception table:
    //   from	to	target	type
    //   6	40	125	java/lang/Exception
    //   40	52	125	java/lang/Exception
    //   61	74	125	java/lang/Exception
    //   91	105	125	java/lang/Exception
    //   105	118	125	java/lang/Exception
  }
  
  public static FileManagerEntity a(ayqd paramayqd)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = apck.a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramayqd.g;
    if (apdh.a(paramayqd.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(paramayqd.jdField_a_of_type_JavaLangString);
    }
    if (apdh.a(paramayqd.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = paramayqd.jdField_c_of_type_JavaLangString;
    }
    if (apdh.a(paramayqd.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramayqd.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramayqd.jdField_c_of_type_Long;
      localFileManagerEntity.fProgress = ((float)paramayqd.jdField_d_of_type_Long / (float)paramayqd.jdField_c_of_type_Long);
      localFileManagerEntity.nFileType = apck.a(paramayqd.g);
      if ((6 <= paramayqd.jdField_b_of_type_Int) && (13 != paramayqd.jdField_b_of_type_Int)) {
        break label305;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramayqd.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramayqd.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramayqd.e;
      localFileManagerEntity.strTroopFileSha1 = paramayqd.f;
      localFileManagerEntity.busId = paramayqd.h;
      localFileManagerEntity.TroopUin = paramayqd.jdField_b_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramayqd.jdField_b_of_type_Long);
      QLog.i("MultiFavoriteHelper", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramayqd.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      return localFileManagerEntity;
      if (!apdh.a(paramayqd.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramayqd.jdField_d_of_type_JavaLangString;
      break;
      label305:
      if (12 == paramayqd.jdField_b_of_type_Int) {
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
        ((FileManagerEntity)localObject).nSessionId = apck.a().longValue();
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
            label148:
            ((FileManagerEntity)localObject).peerNick = apck.a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
            ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
            ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              ((FileManagerEntity)localObject).fileSize = Long.parseLong(paramQQAppInterface);
            }
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label400;
              }
              ((FileManagerEntity)localObject).nOpType = 0;
            }
            label244:
            ((FileManagerEntity)localObject).status = -1;
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label408;
              }
              ((FileManagerEntity)localObject).bSend = false;
            }
            label283:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
            if (!bace.b(paramQQAppInterface)) {
              break label416;
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
            label346:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
            try
            {
              ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(paramQQAppInterface);
              label362:
              return localObject;
              ((FileManagerEntity)localObject).busId = -1;
              continue;
              if (i == 2)
              {
                ((FileManagerEntity)localObject).peerType = 3000;
                break label148;
              }
              if (i != 3) {
                break label148;
              }
              ((FileManagerEntity)localObject).peerType = 1;
              break label148;
              label400:
              ((FileManagerEntity)localObject).nOpType = 1;
              break label244;
              label408:
              ((FileManagerEntity)localObject).bSend = true;
              break label283;
              label416:
              ((FileManagerEntity)localObject).setCloudType(1);
            }
            catch (NumberFormatException paramQQAppInterface)
            {
              break label362;
            }
          }
          catch (NumberFormatException paramQQAppInterface)
          {
            break label346;
          }
        }
      }
    }
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
      str3 = akbm.c(paramChatMessage);
      String str2 = "";
      String str1 = str2;
      if (paramChatMessage.isMultiMsg)
      {
        str1 = str2;
        if (!mnf.a(paramChatMessage))
        {
          str2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = arxu.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, paramQQAppInterface);
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
        paramQQAppInterface = aryb.a(paramChatMessage.senderuin);
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
    //   6: new 440	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 441	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_2
    //   16: invokevirtual 442	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore 6
    //   21: aload 6
    //   23: invokeinterface 54 1 0
    //   28: ifeq +576 -> 604
    //   31: aload 6
    //   33: invokeinterface 58 1 0
    //   38: checkcast 60	com/tencent/mobileqq/data/ChatMessage
    //   41: astore 7
    //   43: aload 7
    //   45: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   48: sipush -1037
    //   51: if_icmpne +221 -> 272
    //   54: aload 7
    //   56: checkcast 447	com/tencent/mobileqq/data/MessageForLongMsg
    //   59: invokevirtual 451	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   62: checkcast 453	com/tencent/mobileqq/data/MessageForText
    //   65: checkcast 453	com/tencent/mobileqq/data/MessageForText
    //   68: astore_2
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: ifnonnull +179 -> 251
    //   75: aload_2
    //   76: astore_3
    //   77: aload 7
    //   79: instanceof 453
    //   82: ifeq +169 -> 251
    //   85: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +12 -> 100
    //   91: ldc 76
    //   93: iconst_2
    //   94: ldc_w 455
    //   97: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: aload 7
    //   103: invokespecial 457	acxm:a	(Latmo;)Latmo;
    //   106: checkcast 60	com/tencent/mobileqq/data/ChatMessage
    //   109: astore_2
    //   110: aload 7
    //   112: ifnull +53 -> 165
    //   115: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +47 -> 165
    //   121: ldc 76
    //   123: iconst_2
    //   124: new 78	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 459
    //   134: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 7
    //   139: getfield 462	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   142: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 464
    //   148: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 7
    //   153: getfield 468	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   156: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_2
    //   166: ifnull +51 -> 217
    //   169: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +45 -> 217
    //   175: ldc 76
    //   177: iconst_2
    //   178: new 78	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 470
    //   188: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: getfield 462	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   195: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 464
    //   201: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: getfield 468	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   208: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_2
    //   218: ifnull +145 -> 363
    //   221: aload_2
    //   222: getfield 462	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   225: ifnull +138 -> 363
    //   228: aload_2
    //   229: getfield 468	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   232: ifnonnull +131 -> 363
    //   235: aload_2
    //   236: aload_2
    //   237: getfield 462	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   240: ldc_w 472
    //   243: invokevirtual 476	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   246: putfield 468	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   249: aload_2
    //   250: astore_3
    //   251: aload_3
    //   252: ifnonnull +167 -> 419
    //   255: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -254 -> 4
    //   261: ldc 76
    //   263: iconst_2
    //   264: ldc_w 478
    //   267: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aconst_null
    //   271: areturn
    //   272: aload 7
    //   274: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   277: sipush -1036
    //   280: if_icmpne +21 -> 301
    //   283: aload 7
    //   285: checkcast 447	com/tencent/mobileqq/data/MessageForLongMsg
    //   288: invokevirtual 451	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   291: checkcast 480	com/tencent/mobileqq/data/MessageForMixedMsg
    //   294: checkcast 480	com/tencent/mobileqq/data/MessageForMixedMsg
    //   297: astore_2
    //   298: goto -229 -> 69
    //   301: aload 7
    //   303: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   306: sipush -1035
    //   309: if_icmpne +18 -> 327
    //   312: aload 7
    //   314: checkcast 480	com/tencent/mobileqq/data/MessageForMixedMsg
    //   317: invokevirtual 483	com/tencent/mobileqq/data/MessageForMixedMsg:rebuildMixedMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   320: checkcast 60	com/tencent/mobileqq/data/ChatMessage
    //   323: astore_2
    //   324: goto -255 -> 69
    //   327: aload 7
    //   329: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   332: sipush -2011
    //   335: if_icmpne +16 -> 351
    //   338: new 485	com/tencent/mobileqq/data/MessageForStructing
    //   341: dup
    //   342: aload 7
    //   344: invokespecial 488	com/tencent/mobileqq/data/MessageForStructing:<init>	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   347: astore_2
    //   348: goto -279 -> 69
    //   351: aload 7
    //   353: invokevirtual 492	com/tencent/mobileqq/data/ChatMessage:deepCopyByReflect	()Latmo;
    //   356: checkcast 60	com/tencent/mobileqq/data/ChatMessage
    //   359: astore_2
    //   360: goto -291 -> 69
    //   363: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +12 -> 378
    //   369: ldc 76
    //   371: iconst_2
    //   372: ldc_w 494
    //   375: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aconst_null
    //   379: astore_2
    //   380: goto -131 -> 249
    //   383: astore 4
    //   385: aload_2
    //   386: astore_3
    //   387: aload 4
    //   389: astore_2
    //   390: ldc 76
    //   392: iconst_2
    //   393: new 78	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 496
    //   403: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: goto -165 -> 251
    //   419: aload_3
    //   420: ldc_w 498
    //   423: invokevirtual 313	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   426: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifne +10 -> 439
    //   432: aload_3
    //   433: ldc_w 498
    //   436: invokevirtual 501	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   439: aload_3
    //   440: ldc_w 503
    //   443: invokevirtual 313	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +10 -> 459
    //   452: aload_3
    //   453: ldc_w 503
    //   456: invokevirtual 501	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   459: aload_3
    //   460: aconst_null
    //   461: putfield 507	com/tencent/mobileqq/data/ChatMessage:atInfoList	Ljava/util/ArrayList;
    //   464: aload_3
    //   465: aload_1
    //   466: getfield 508	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   469: putfield 426	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   472: aload_3
    //   473: ldc_w 509
    //   476: putfield 512	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   479: aload_3
    //   480: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   483: sipush -1035
    //   486: if_icmpne +54 -> 540
    //   489: aload_3
    //   490: checkcast 480	com/tencent/mobileqq/data/MessageForMixedMsg
    //   493: getfield 516	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   496: invokeinterface 48 1 0
    //   501: astore_2
    //   502: aload_2
    //   503: invokeinterface 54 1 0
    //   508: ifeq +32 -> 540
    //   511: aload_2
    //   512: invokeinterface 58 1 0
    //   517: checkcast 518	com/tencent/mobileqq/data/MessageRecord
    //   520: astore 4
    //   522: aload 4
    //   524: aload_3
    //   525: getfield 426	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   528: putfield 519	com/tencent/mobileqq/data/MessageRecord:msgseq	J
    //   531: aload 4
    //   533: iconst_1
    //   534: putfield 520	com/tencent/mobileqq/data/MessageRecord:isMultiMsg	Z
    //   537: goto -35 -> 502
    //   540: aload_3
    //   541: getfield 445	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   544: sipush -2022
    //   547: if_icmpne +11 -> 558
    //   550: aload_3
    //   551: checkcast 522	com/tencent/mobileqq/data/MessageForShortVideo
    //   554: iconst_0
    //   555: putfield 525	com/tencent/mobileqq/data/MessageForShortVideo:redBagType	I
    //   558: aload 5
    //   560: aload_3
    //   561: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   564: pop
    //   565: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq -547 -> 21
    //   571: ldc 76
    //   573: iconst_2
    //   574: new 78	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 530
    //   584: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 7
    //   589: invokevirtual 531	com/tencent/mobileqq/data/ChatMessage:toString	()Ljava/lang/String;
    //   592: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: goto -580 -> 21
    //   604: aload 5
    //   606: areturn
    //   607: astore_2
    //   608: aconst_null
    //   609: astore_3
    //   610: goto -220 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	acxm
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
  
  private void a(acka paramacka, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (paramacka == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "favorSingleMsg");
      }
      bfia.a().a = false;
      paramacka.a.a(paramChatMessage, paramacka).a(2131300328, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      if (bfia.a().a) {
        bfia.a().a = false;
      }
      while (ahox.a().c())
      {
        ahox.a().d();
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
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext)) {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131626719, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    do
    {
      return;
      arxu.a().b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(2131632731);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList);
    arxu.a().jdField_a_of_type_JavaUtilArrayList.clear();
    arxu.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    arxu.a().jdField_a_of_type_Int = 6;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aege)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = arxu.a().a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
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
        String str = akbm.c((ChatMessage)paramList.next());
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
        } while (!aryb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage));
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break;
        }
      } while (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 35);
      return true;
    } while (((paramChatMessage instanceof MessageForArkApp)) || (((paramChatMessage instanceof MessageForPic)) && (aeor.a((MessageForPic)paramChatMessage))));
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
        if (bfid.a(localChatMessage)) {
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
      bfia.a().a(l);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, acka paramacka, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onClickMultiFavoriteBtn");
    }
    int i = arxu.a().c();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C5B", "0X8009C5B", 0, i, "", "", "", "");
    if (paramMessageForStructing == null)
    {
      paramMessageForStructing = arxu.a().a();
      if (paramMessageForStructing.size() == 1)
      {
        localArrayList = aryb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramMessageForStructing);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramMessageForStructing = (ChatMessage)localArrayList.get(0);
          a(paramacka, paramMessageForStructing);
          paramBaseChatPie.a(false, null, false);
        }
      }
    }
    while (!bfid.a(paramMessageForStructing))
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
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131632729, 0).b(paramBaseChatPie.a());
      return;
    }
    paramacka = new ArrayList();
    paramacka.add(paramMessageForStructing);
    for (;;)
    {
      bfia.a().a = true;
      if (!a(paramacka, arxu.a().a()))
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131628440, 0).b(paramBaseChatPie.a());
        return;
      }
      i = a(paramacka);
      paramMessageForStructing = paramacka;
      if (i > 0)
      {
        if (paramacka.size() == i)
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131628774, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
        paramMessageForStructing = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        if (!bfid.a(paramMessageForStructing))
        {
          bfid.b(paramMessageForStructing);
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131627766), this.jdField_a_of_type_AndroidContentContext.getString(2131628775), new acxn(this, paramacka, paramBaseChatPie));
          return;
        }
        paramacka = aryb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramacka);
        if (paramacka != null)
        {
          paramMessageForStructing = paramacka;
          if (paramacka.size() != 0) {}
        }
        else
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131628774, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
      }
      a(paramMessageForStructing);
      paramBaseChatPie.a(false, null, false);
      return;
      label423:
      paramacka = paramMessageForStructing;
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
        this.jdField_a_of_type_AndroidWidgetImageView.setId(2131298599);
        if (AppSetting.c) {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131641210));
        }
      }
      Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramBaseChatPie);
      paramBaseChatPie = new StateListDrawable();
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839074);
      paramBaseChatPie.addState(new int[] { 16842919 }, (Drawable)localObject);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839073);
      paramBaseChatPie.addState(new int[] { 16842910 }, (Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseChatPie);
    } while (paramLinearLayout == null);
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    try
    {
      babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, paramString1, "", paramString2, new acxo(this, paramOnClickListener), null).show();
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
      localObject1 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() == 1) && (bfid.a((ChatMessage)paramArrayList.get(0))))
      {
        localObject1 = (MessageForStructing)paramArrayList.get(0);
        localObject2 = null;
        label87:
        paramArrayList = bfhl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject1, (List)localObject2, paramMap);
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
        bfia.a().a(-1L);
        paramArrayList = paramArrayList.a();
        if (paramArrayList == null) {
          break;
        }
        paramArrayList = this.jdField_a_of_type_AndroidContentContext.getString(paramArrayList.getIntExtra("nReasonInt", 2131626724));
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
        localObject1 = aael.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
        if (localObject1 == null) {
          break;
        }
        MessageForStructing localMessageForStructing = arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, (AbsStructMsg)localObject1);
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
      bfhn.a(this.jdField_a_of_type_AndroidContentContext, paramMap, bool, null, false);
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
    return new int[] { 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxm
 * JD-Core Version:    0.7.0.1
 */