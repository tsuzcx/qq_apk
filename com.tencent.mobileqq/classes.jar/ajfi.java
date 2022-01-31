import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;

public class ajfi
  implements bdmd, bdmf
{
  private static ajfi jdField_a_of_type_Ajfi;
  public int a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString = "";
  public WeakReference<ajfq> a;
  public HashMap<MessageForPtt, MessageForQQWalletMsg> a;
  public Map<MessageForPtt, ajfs> a;
  boolean jdField_a_of_type_Boolean;
  public byte[] a;
  int b;
  public boolean b;
  public int c;
  public boolean c;
  int jdField_d_of_type_Int = -1;
  boolean jdField_d_of_type_Boolean;
  
  private ajfi()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(MessageForPtt paramMessageForPtt)
  {
    int i = 1;
    if (paramMessageForPtt != null)
    {
      switch (paramMessageForPtt.voiceRedPacketFlag)
      {
      default: 
        i = 0;
      case 1: 
      case 2: 
        return i;
      }
      return 3;
    }
    return 0;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    try
    {
      int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("ksong_redpacket_voice_type"));
      return i;
    }
    catch (Throwable paramMessageRecord) {}
    return 0;
  }
  
  public static ajfi a()
  {
    try
    {
      if (jdField_a_of_type_Ajfi == null) {
        jdField_a_of_type_Ajfi = new ajfi();
      }
      ajfi localajfi = jdField_a_of_type_Ajfi;
      return localajfi;
    }
    finally {}
  }
  
  private ajfr a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    ajfr localajfr = new ajfr();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return localajfr;
    }
    ajfh.a().a();
    if (ajfh.a().a(paramArrayOfByte, paramArrayOfByte.length) == 1) {}
    for (;;)
    {
      localajfr.jdField_a_of_type_Boolean = bool;
      localajfr.jdField_a_of_type_Float = ajfh.a().a();
      localajfr.jdField_a_of_type_JavaLangString = a(localajfr.jdField_a_of_type_Float);
      ajfh.a().b();
      this.jdField_b_of_type_Int += 1;
      return localajfr;
      bool = false;
    }
  }
  
  private ajfr a(byte[] paramArrayOfByte, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    long l1 = System.currentTimeMillis();
    paramArrayOfByte = a(paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "checkInPhone:" + paramArrayOfByte);
    }
    if (paramArrayOfByte.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      a(i, l2 - l1, 0, paramMessageForQQWalletMsg, paramArrayOfByte.jdField_a_of_type_Float);
      return paramArrayOfByte;
    }
  }
  
  public static ByteStringMicro a(MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageForPtt != null) {}
    try
    {
      paramMessageForPtt = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessageForPtt)) {
        localObject1 = ByteStringMicro.copyFromUtf8(paramMessageForPtt);
      }
      return localObject1;
    }
    catch (Throwable paramMessageForPtt)
    {
      paramMessageForPtt.printStackTrace();
    }
    return null;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("ksong_feeds_id");
    }
    return str;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    a(paramInt1, paramLong, paramInt2, paramMessageForQQWalletMsg, 0.0F);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg, float paramFloat)
  {
    if (paramMessageForQQWalletMsg == null) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append("|").append(paramLong);
    localStringBuilder1.append("|").append(paramInt2);
    localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    QQAppInterface localQQAppInterface = ajeu.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("|");
    if (localQQAppInterface == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localStringBuilder2.append(paramInt1);
      localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.istroop);
      localStringBuilder1.append("|").append(paramFloat);
      VACDReportUtil.a(localStringBuilder1.toString(), "QWalletStat", "voiceRedPackMatch", null, null, 0, null);
      return;
      if (ajfh.a().a(localQQAppInterface)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_redpacket_voice_type", paramInt + "");
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    ajfq localajfq = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localajfq != null) && (!localajfq.c())) {
      localajfq.a(paramInt, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "uploadKSongMixRecord is call");
    }
    paramMessageRecord = (MessageForPtt)paramMessageRecord;
    try
    {
      MessageForPtt localMessageForPtt = acjm.a(ajeu.a(), paramMessageRecord.getLocalFilePath(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramMessageRecord.voiceType);
      if (localMessageForPtt != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localMessageForPtt, new ajfs(paramMessageRecord, paramLong, paramArrayOfByte, paramString));
        paramArrayOfByte = new QQRecorder.RecorderParam(bdml.jdField_b_of_type_Int, 16000, 1);
        if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, paramMessageRecord.getLocalFilePath(), paramArrayOfByte))
        {
          paramString = ajeu.a();
          if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (localMessageForPtt != null))
          {
            a(2, localMessageForPtt);
            localMessageForPtt.voiceRedPacketFlag = 3;
            localMessageForPtt.serial();
            Bundle localBundle = new Bundle();
            localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
            acjm.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.getLocalFilePath(), localMessageForPtt.uniseq, false, paramMessageRecord.voiceLength, paramArrayOfByte.jdField_c_of_type_Int, true, 0, 5, true, localMessageForPtt.vipSubBubbleId, localBundle, null, null, false, localMessageForPtt, 0);
            paramArrayOfByte = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_Int = paramArrayOfByte.hashCode();
            }
            paramArrayOfByte = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord);
            this.jdField_a_of_type_JavaUtilHashMap.put(localMessageForPtt, paramArrayOfByte);
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageRecord);
          }
        }
        else
        {
          c("Mix song error!");
          return;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public static void a(String paramString, MessageForPtt paramMessageForPtt, bark parambark)
  {
    b(paramString, paramMessageForPtt);
    if (parambark != null)
    {
      if (!(parambark instanceof bart)) {
        break label38;
      }
      paramString = ((bart)parambark).a();
      if ((paramString != null) && (paramMessageForPtt != null)) {
        paramMessageForPtt.richText = paramString;
      }
    }
    label38:
    do
    {
      do
      {
        do
        {
          return;
          if (!(parambark instanceof batj)) {
            break;
          }
          paramString = ((batj)parambark).a(paramMessageForPtt);
        } while ((paramString == null) || (paramMessageForPtt == null));
        paramMessageForPtt.richText = paramString;
        return;
      } while (!(parambark instanceof batn));
      paramString = ((batn)parambark).a(paramMessageForPtt);
    } while ((paramString == null) || (paramMessageForPtt == null));
    paramMessageForPtt.richText = paramString;
  }
  
  public static void a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_feeds_id", paramString);
    }
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.voiceRedPacketFlag == 1) || (paramMessageForPtt.voiceRedPacketFlag == 2) || (paramMessageForPtt.voiceRedPacketFlag == 3);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        bool1 = bool2;
        if (paramMessageRecord.voiceRedPacketFlag != 0)
        {
          bool1 = bool2;
          if (!paramMessageRecord.isResend) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "isNeedInterceptSend:" + bool1);
    }
    return bool1;
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, QQRecorder.RecorderParam paramRecorderParam)
  {
    long l;
    int i;
    int j;
    int k;
    label453:
    for (;;)
    {
      try
      {
        String str = paramString1 + "m";
        Object localObject = new File(str);
        mpu localmpu;
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin convert mp3 to pcm");
          }
          localmpu = new mpu(paramRecorderParam.jdField_a_of_type_Int, 16, 1);
          localmpu.a(new ajfj(this));
          l = System.currentTimeMillis();
        }
        try
        {
          localmpu.a(paramString1, str);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mp3 to pcm time:" + (System.currentTimeMillis() - l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin mix pcm :" + ((File)localObject).exists());
          }
          if (!((File)localObject).exists()) {
            break;
          }
          localObject = bdhb.a((File)localObject);
          i = Math.min(paramArrayOfByte.length, localObject.length);
          paramString1 = new byte[i];
          l = System.currentTimeMillis();
          ajeu.a(paramString1, paramArrayOfByte, (byte[])localObject, i);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mix pcm time:" + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          paramArrayOfByte = new awyt();
          localObject = new WechatNsWrapper(BaseApplicationImpl.getContext());
          if (WechatNsWrapper.jdField_a_of_type_Boolean) {
            paramArrayOfByte.a((awyp)localObject);
          }
          paramArrayOfByte.a((awyp)localObject);
          paramArrayOfByte.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.jdField_b_of_type_Int, paramRecorderParam.jdField_c_of_type_Int);
          awxp.a(paramString2);
          paramRecorderParam = bdml.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
          awxp.a(paramString2, paramRecorderParam, paramRecorderParam.length);
          i = paramString1.length;
          paramRecorderParam = new byte[800];
          j = 0;
          break label511;
          i -= k;
          System.arraycopy(paramString1, j, paramRecorderParam, 0, k);
          localObject = paramArrayOfByte.a(paramRecorderParam, 0, k);
          if (localObject == null) {
            break label531;
          }
          awxp.a(paramString2, ((awyq)localObject).jdField_a_of_type_ArrayOfByte, ((awyq)localObject).jdField_a_of_type_Int);
        }
        catch (Throwable paramString1)
        {
          QLog.e("VoiceRedPacketHelper", 1, "convertMp3ToPcm decode exception:" + paramString1, paramString1);
          continue;
        }
        k = 800;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
    label531:
    label539:
    for (;;)
    {
      awxp.b(paramString2);
      paramArrayOfByte.a();
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "pcm 2 silk time:" + (System.currentTimeMillis() - l));
      }
      return true;
      return false;
      for (;;)
      {
        label511:
        if (i <= 0) {
          break label539;
        }
        if (i >= 800) {
          break label453;
        }
        k = i;
        break;
        j = k + j;
      }
    }
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("voice_score_id");
    }
    return str;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  public static void b(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("voice_score_id", paramString);
    }
  }
  
  private void d(String paramString)
  {
    a(2, paramString);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderStart() is called");
    }
    ajfq localajfq = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajfq != null) {
      localajfq.i();
    }
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onBeginReceiveData() is called");
    }
    paramString = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null) {
      return paramString.a();
    }
    return 0;
  }
  
  public String a(float paramFloat)
  {
    int k = (int)(100.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cfdToScoreId:" + paramFloat + "|" + k);
    }
    Object localObject1 = ajeu.a();
    if (localObject1 != null)
    {
      localObject1 = (aixs)((QQAppInterface)localObject1).getManager(245);
      if (localObject1 != null)
      {
        localObject1 = ((aixs)localObject1).a("voice_pwd", new String[] { "scoreIdMap" });
        if (localObject1 == null) {}
      }
    }
    int i;
    int j;
    label313:
    label361:
    do
    {
      try
      {
        if (((JSONObject)localObject1).length() > 0)
        {
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator != null) {
            for (;;)
            {
              if (localIterator.hasNext())
              {
                String str2 = (String)localIterator.next();
                String str1 = ((JSONObject)localObject1).getString(str2);
                if (!str2.contains("-")) {
                  continue;
                }
                Object localObject2 = str2.split("-");
                if ((localObject2 == null) || (localObject2.length <= 0) || (localObject2.length > 2)) {
                  continue;
                }
                boolean bool = TextUtils.isEmpty(str1);
                if (bool) {
                  continue;
                }
                i = -2147483648;
                j = 2147483647;
                try
                {
                  if (localObject2.length == 1)
                  {
                    i = Integer.parseInt(localObject2[0].trim());
                    break label361;
                  }
                  if (localObject2.length == 2)
                  {
                    str2 = localObject2[0].trim();
                    localObject2 = localObject2[1].trim();
                    if (TextUtils.isEmpty(str2)) {}
                    for (;;)
                    {
                      j = Integer.parseInt((String)localObject2);
                      break;
                      i = Integer.parseInt(str2);
                    }
                  }
                }
                catch (Throwable localThrowable2)
                {
                  localThrowable2.printStackTrace();
                }
              }
            }
          }
        }
        if (k >= 65) {
          break label313;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      return "c";
      if (k < 70) {
        return "b";
      }
      if (k < 75) {
        return "a";
      }
      if (k < 80) {
        return "s";
      }
      if (k < 90) {
        return "ss";
      }
      return "sss";
    } while ((k < i) || (k > j));
    return localThrowable2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void a(ajfp paramajfp)
  {
    Object localObject = ajeu.a();
    if ((localObject == null) || (paramajfp == null)) {}
    do
    {
      return;
      localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).GetSkey(((QQAppInterface)localObject).getCurrentAccountUin(), 16L, new ajfo(this, paramajfp));
    } while ((localObject == null) || (((Ticket)localObject)._sig == null) || (((Ticket)localObject)._sig.length == 0));
    paramajfp.a(new String(((Ticket)localObject)._sig));
  }
  
  public void a(ajfq paramajfq)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajfq);
  }
  
  public void a(awyp paramawyp, awyq paramawyq) {}
  
  public void a(SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    int i;
    String str1;
    QQRecorder.RecorderParam localRecorderParam;
    try
    {
      localQQAppInterface = ajeu.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      i = agmv.a(paramMessageForQQWalletMsg.messageType);
      str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
      }
      if ((localQQAppInterface == null) || (paramSessionInfo == null)) {
        break label687;
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      localRecorderParam = new QQRecorder.RecorderParam(bdml.jdField_b_of_type_Int, 16000, 1);
      if (!bdhb.a())
      {
        b(2131694853);
        c("no sdcard");
        return;
      }
    }
    catch (Exception paramSessionInfo)
    {
      c(paramSessionInfo.toString());
      paramSessionInfo.printStackTrace();
      return;
    }
    if (!QQRecorder.d())
    {
      b(2131719552);
      c("sdcard full");
      return;
    }
    if (!QQRecorder.a(localRecorderParam.jdField_c_of_type_Int))
    {
      b(2131693703);
      c("internal storage full");
      return;
    }
    if (localQQAppInterface.c())
    {
      b(2131695682);
      c("ppt play error on video chatting");
      return;
    }
    if (i == 2)
    {
      this.jdField_c_of_type_Boolean = true;
      if (!ajfh.a().a(localQQAppInterface)) {
        this.jdField_c_of_type_Boolean = false;
      }
      if (!ajfh.a().a(b(str1))) {
        this.jdField_c_of_type_Boolean = false;
      }
    }
    boolean bool2 = true;
    long l1 = aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      bool1 = bool2;
      if (l1 > l2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "startRecord() is checkInPhone:" + paramBoolean + ",isInitSuccess:" + this.jdField_c_of_type_Boolean + ",isServerAvailable:" + bool1 + ",redpkgType:" + i);
    }
    if ((!this.jdField_c_of_type_Boolean) && (!bool1)) {
      a(2, aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", BaseApplicationImpl.getContext().getResources().getString(2131695804)));
    }
    if (paramBoolean)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_d_of_type_Boolean = false;
      if ((i != 2) || (!this.jdField_c_of_type_Boolean)) {
        break label688;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      label687:
      label688:
      do
      {
        str1 = barl.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
        String str2 = MessageForPtt.getLocalFilePath(localRecorderParam.jdField_c_of_type_Int, str1);
        paramString = str1;
        if (str1 != null)
        {
          paramString = str1;
          if (!str1.equals(str2))
          {
            new File(str1).deleteOnExit();
            paramString = str2;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(BaseApplication.getContext());
        }
        paramSessionInfo = acjm.a(localQQAppInterface, paramString, paramSessionInfo, -2, localRecorderParam.jdField_c_of_type_Int);
        if (paramSessionInfo == null)
        {
          c("messageRecord create is null");
          return;
          if (bool1) {
            break;
          }
          this.jdField_a_of_type_Boolean = true;
          break;
        }
        if (i == 8)
        {
          a(1, paramSessionInfo);
          paramSessionInfo.voiceRedPacketFlag = 3;
          this.jdField_a_of_type_JavaUtilHashMap.put(paramSessionInfo, paramMessageForQQWalletMsg);
          localRecorderParam.jdField_a_of_type_JavaLangObject = paramSessionInfo;
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(localRecorderParam);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramString, true);
          paramSessionInfo = MediaPlayerManager.a(localQQAppInterface);
          if (paramSessionInfo != null) {
            paramSessionInfo.a(true);
          }
          this.jdField_b_of_type_Boolean = false;
          this.jdField_d_of_type_Int = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "startRecord() is called");
          }
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {}
          for (i = 1;; i = 2)
          {
            paramSessionInfo.voiceRedPacketFlag = i;
            break;
          }
        }
        return;
      } while (i != 8);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, alwx paramalwx, long paramLong, byte[] paramArrayOfByte, String paramString, bark parambark)
  {
    QQAppInterface localQQAppInterface;
    Object localObject1;
    Object localObject2;
    try
    {
      localQQAppInterface = ajeu.a();
      localObject1 = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      i = 0;
      if (localObject1 != null) {
        i = localObject1.hashCode();
      }
      if ((localQQAppInterface == null) || (paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForPtt)) || (localObject1 == null) || (((ajfq)localObject1).c()) || (this.jdField_b_of_type_Boolean) || (i != this.jdField_a_of_type_Int)) {
        return;
      }
      localObject2 = (MessageForPtt)paramMessageRecord;
      i = ((MessageForPtt)localObject2).voiceRedPacketFlag;
      localObject1 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "checkAndSend MessagemessageForPtt flag:" + i);
      }
      if (i == 1)
      {
        paramMessageRecord = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramMessageRecord != null) && (!paramMessageRecord.c())) {
          paramMessageRecord.a(true, ((MessageForPtt)localObject2).getExtInfoFromExtStr("voice_score_id"));
        }
        b(b((MessageRecord)localObject2), (MessageRecord)localObject1);
        localQQAppInterface.a().a((MessageRecord)localObject2, paramalwx);
        return;
      }
      if (i != 2) {
        break label307;
      }
      if ((localObject1 == null) || (((MessageForQQWalletMsg)localObject1).mQQWalletRedPacketMsg == null))
      {
        c("MessageForQQWalletMsg is null");
        return;
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      c(paramMessageRecord.toString());
      return;
    }
    int i = 0;
    if (((MessageForQQWalletMsg)localObject1).istroop == 1) {
      i = 1;
    }
    for (;;)
    {
      a(new ajfk(this, localQQAppInterface, (MessageForQQWalletMsg)localObject1, i, paramLong, paramArrayOfByte, paramString, (MessageForPtt)localObject2, parambark, paramalwx));
      return;
      if (((MessageForQQWalletMsg)localObject1).istroop == 3000) {
        i = 2;
      }
    }
    label307:
    if (i == 3)
    {
      if (a(paramMessageRecord) == 1)
      {
        a(paramMessageRecord, paramLong, paramArrayOfByte, paramString);
        return;
      }
      if (a(paramMessageRecord) == 2)
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        localObject2 = (ajfs)this.jdField_a_of_type_JavaUtilMap.get(paramMessageRecord);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord);
        if ((localMessageForQQWalletMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null))
        {
          c("MessageForQQWalletMsg is null");
          return;
        }
        i = 0;
        if (localMessageForQQWalletMsg.istroop == 1) {
          i = 1;
        }
        for (;;)
        {
          a(new ajfm(this, localMessageForQQWalletMsg, localQQAppInterface, i, (ajfs)localObject2, paramLong, paramArrayOfByte, paramString, (MessageForQQWalletMsg)localObject1, paramMessageRecord, parambark, paramalwx));
          return;
          int j = localMessageForQQWalletMsg.istroop;
          if (j == 3000) {
            i = 2;
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderNotReady() is called");
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderPrepare() is called :" + this.jdField_d_of_type_Boolean);
    }
    bdfi.b(2131230745, false);
    byte[] arrayOfByte = bdml.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    awxp.a(paramString);
    awxp.a(paramString, arrayOfByte, arrayOfByte.length);
    paramString = (MessageForPtt)paramRecorderParam.jdField_a_of_type_JavaLangObject;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
      if (paramString.voiceRedPacketFlag == 3)
      {
        paramString = new byte[QQRecorder.a(paramRecorderParam.jdField_a_of_type_Int, 2, 2) / 1000 * 200];
        Arrays.fill(paramString, (byte)0);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramString, 0, paramString.length);
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderEnd() is called, isCancel:" + this.jdField_b_of_type_Boolean + "|" + this.jdField_d_of_type_Int);
    }
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        awxp.a(paramString);
        return;
      }
      localObject1 = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        ((ajfq)localObject1).j();
      }
      awxp.b(paramString);
      if (paramDouble < 500.0D)
      {
        b(2131690070);
        c("record time too short");
        return;
      }
    }
    catch (Exception paramString)
    {
      c(paramString.toString());
      paramString.printStackTrace();
      return;
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.flush();
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    }
    Object localObject1 = (MessageForPtt)paramRecorderParam.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    boolean bool;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      localObject2 = a(this.jdField_a_of_type_ArrayOfByte, (MessageForQQWalletMsg)localObject2);
      bool = ((ajfr)localObject2).jdField_a_of_type_Boolean;
      if (bool) {
        b(((ajfr)localObject2).jdField_a_of_type_JavaLangString, (MessageRecord)localObject1);
      }
      localObject2 = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject2 == null) || (((ajfq)localObject2).c()) || (bool)) {
        break label679;
      }
      ((ajfq)localObject2).a(false, "");
      break label679;
      localObject2 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      if (localObject2 == null)
      {
        c("messageForQQWalletMsg is null!");
        return;
      }
      j = agmv.a(((MessageForQQWalletMsg)localObject2).messageType);
      if (j == 8) {
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 0) {
          if (this.jdField_d_of_type_Int == -1) {
            if (!ajeu.a(BaseApplicationImpl.getContext())) {
              break label682;
            }
          }
        }
      }
    }
    label679:
    label682:
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if ((this.jdField_d_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 18) && (!a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, paramString, paramRecorderParam)))
      {
        c("mix song error!");
        return;
      }
      a(2, (MessageRecord)localObject1);
      for (;;)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = 3;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "isCheckInPhone:" + this.jdField_a_of_type_Boolean + ",isRecognizedInPhone:" + bool + ",redpkgType:" + j + "songFlag:" + ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag);
        }
        if ((!bool) && (this.jdField_a_of_type_Boolean)) {
          break;
        }
        localObject2 = ajeu.a();
        if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localObject1 == null)) {
          break;
        }
        ((MessageForPtt)localObject1).serial();
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", ((MessageForPtt)localObject1).vipBubbleDiyTextId);
        acjm.a((QQAppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, ((MessageForPtt)localObject1).uniseq, false, (int)paramDouble, paramRecorderParam.jdField_c_of_type_Int, true, 0, 5, true, ((MessageForPtt)localObject1).vipSubBubbleId, localBundle, null, null, false, (MessageRecord)localObject1, 0);
        paramString = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramString == null) {
          break;
        }
        this.jdField_a_of_type_Int = paramString.hashCode();
        return;
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 1) {
          a(1, (MessageRecord)localObject1);
        }
      }
      if (this.jdField_a_of_type_Boolean) {}
      for (i = 1;; i = 2)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = i;
        break;
      }
      bool = false;
      break;
      return;
      break;
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    c("onRecorderError");
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    awxp.a(paramString, paramArrayOfByte, paramInt1);
    paramString = (ajfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString != null) && (!paramString.c())) {
      paramString.a(AudioPanel.a(paramInt2));
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "stopRecord() is called");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
  }
  
  public void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = ajeu.a();
    if (localQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localQQAppInterface.runOnUiThread(new VoiceRedPacketHelper.1(this, localBaseApplication, paramInt, localBaseApplication.getResources().getDimensionPixelSize(2131298914)));
  }
  
  public void b(awyp paramawyp, awyq paramawyq)
  {
    if (((paramawyp instanceof WechatNsWrapper)) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null) && (paramawyq != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramawyq.jdField_a_of_type_ArrayOfByte, 0, paramawyq.jdField_a_of_type_Int);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(3, "onRecorderAbnormal");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cancelRecord() is called");
    }
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void c(String paramString)
  {
    a(1, paramString);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(3, "onInitFailed");
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfi
 * JD-Core Version:    0.7.0.1
 */