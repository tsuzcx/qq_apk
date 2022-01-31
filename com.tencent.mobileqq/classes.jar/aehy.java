import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aehy
{
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    ansr localansr = (ansr)paramContext.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localansr.a();
    int j;
    int i;
    int k;
    int n;
    if (localObject != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= ((List)localObject).size()) {
        break label260;
      }
      n = ((CustomEmotionData)((List)localObject).get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(j)).emoPath))) {
        i = 2;
      }
    }
    label234:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)((List)localObject).get(j)).md5 == null) || (!str.equals(((CustomEmotionData)((List)localObject).get(j)).md5))) {
          break label234;
        }
        if (!"needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {
          break;
        }
        localansr.a((CustomEmotionData)((List)localObject).get(j), j);
        paramContext = paramContext.getHandler(ChatActivity.class);
        i = m;
      } while (paramContext == null);
      paramContext.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramContext.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      localansr.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajsf.bT))) {
        axqw.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (anss)paramContext.getManager(103);
      i = m;
    } while (paramContext == null);
    label260:
    paramContext.d((CustomEmotionData)localObject);
    return 0;
  }
  
  public static int a(Context paramContext, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (ansr)localQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((ansr)localObject).a();
    if (localList != null)
    {
      int i = 1;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        int m = ((CustomEmotionData)localList.get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)localList.get(j)).md5 != null) && (str.equals(((CustomEmotionData)localList.get(j)).md5)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          if ("needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType))
          {
            ((ansr)localObject).a((CustomEmotionData)localList.get(j), j);
            paramContext = localQQAppInterface.getHandler(ChatActivity.class);
            if (paramContext != null) {
              paramContext.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
        i = k;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajsf.bT))) {
      axqw.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new ansa(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (anss)localQQAppInterface.getManager(103);
    if (paramString != null) {
      paramString.b((CustomEmotionData)localObject, paramContext);
    }
    return 0;
  }
  
  public static int a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOLightVideoData.class.isInstance(paramAIORichMediaData)) {
      return 3;
    }
    if ((AIOShortVideoData.class.isInstance(paramAIORichMediaData)) || (AIOFileVideoData.class.isInstance(paramAIORichMediaData))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 0;
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (ansr)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((ansr)localObject).a();
    int j;
    int i;
    int k;
    int n;
    if (localList != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= localList.size()) {
        break label250;
      }
      n = ((CustomEmotionData)localList.get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath))) {
        i = 2;
      }
    }
    label224:
    label250:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)localList.get(j)).md5 == null) || (!str.equals(((CustomEmotionData)localList.get(j)).md5))) {
          break label224;
        }
        if (!"needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType)) {
          break;
        }
        ((ansr)localObject).a((CustomEmotionData)localList.get(j), j);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        i = m;
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajsf.bT))) {
        axqw.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new ansa(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (anss)paramQQAppInterface.getManager(103);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    azqt localazqt = bakj.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localazqt == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (apue.a(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localazqt.jdField_b_of_type_Int != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localazqt.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
        return null;
        if ((localazqt.jdField_b_of_type_Int != 4) && (localazqt.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localazqt.jdField_a_of_type_JavaUtilUUID + " file is:" + localazqt.jdField_b_of_type_Int);
      return null;
      if ((!bbdj.b(localazqt.jdField_a_of_type_JavaLangString)) || ((localazqt.jdField_b_of_type_Int != 1) && (localazqt.jdField_b_of_type_Int != 2) && (localazqt.jdField_b_of_type_Int != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localazqt.jdField_a_of_type_JavaUtilUUID + " file is:" + localazqt.jdField_b_of_type_Int);
    return null;
    ((aows)paramQQAppInterface.getManager(317)).a(bahk.a(localazqt.jdField_g_of_type_JavaLangString));
    Object localObject = localazqt.jdField_d_of_type_JavaLangString;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      apue.a(paramMessageForTroopFile);
    }
    localObject = new AIOFilePicData();
    ((AIOFilePicData)localObject).jdField_f_of_type_Long = paramMessageForTroopFile.uniseq;
    ((AIOFilePicData)localObject).jdField_g_of_type_Long = paramMessageForTroopFile.time;
    ((AIOFilePicData)localObject).jdField_i_of_type_Long = paramMessageForTroopFile.shmsgseq;
    ((AIOFilePicData)localObject).jdField_h_of_type_Long = paramMessageForTroopFile.fileSize;
    ((AIOFilePicData)localObject).jdField_a_of_type_JavaLangString = paramMessageForTroopFile.frienduin;
    ((AIOFilePicData)localObject).jdField_a_of_type_Int = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).jdField_f_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    ((AIOFilePicData)localObject).jdField_b_of_type_Int = paramMessageForTroopFile.issend;
    ((AIOFilePicData)localObject).jdField_g_of_type_Int = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).jdField_k_of_type_Boolean = paramMessageForTroopFile.isMultiMsg;
    ((AIOFilePicData)localObject).jdField_c_of_type_Int = paramMessageForTroopFile.width;
    ((AIOFilePicData)localObject).jdField_d_of_type_Int = paramMessageForTroopFile.height;
    ((AIOFilePicData)localObject).jdField_e_of_type_Int = localazqt.jdField_i_of_type_Int;
    ((AIOFilePicData)localObject).jdField_h_of_type_JavaLangString = paramMessageForTroopFile.url;
    if (localazqt.jdField_b_of_type_Int == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = bool;
      ((AIOFilePicData)localObject).a(localazqt);
      ((AIOFilePicData)localObject).m = akau.b(paramMessageForTroopFile);
      return localObject;
    }
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_f_of_type_Long = paramMessageForPic.uniseq;
    localAIOImageData.jdField_f_of_type_Int = paramMessageForPic.subMsgId;
    localAIOImageData.jdField_g_of_type_Long = paramMessageForPic.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForPic.shmsgseq;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForPic.size;
    localAIOImageData.jdField_g_of_type_Int = paramMessageForPic.istroop;
    localAIOImageData.jdField_f_of_type_JavaLangString = paramMessageForPic.md5;
    localAIOImageData.jdField_j_of_type_JavaLangString = paramMessageForPic.rawMsgUrl;
    localAIOImageData.jdField_k_of_type_JavaLangString = paramMessageForPic.senderuin;
    localAIOImageData.jdField_l_of_type_JavaLangString = paramMessageForPic.frienduin;
    Object localObject1;
    if (mye.a(paramMessageForPic))
    {
      localObject1 = mye.a(paramMessageForPic);
      if ((((myf)localObject1).jdField_a_of_type_JavaLangString != null) || (((myf)localObject1).jdField_a_of_type_Int == 2)) {
        break label438;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryUtils", 2, "toAIOImageData anonymousExtInfo : an_id is null");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData, pic_server_url = " + localAIOImageData.jdField_j_of_type_JavaLangString + "  send_uin = " + localAIOImageData.jdField_k_of_type_JavaLangString);
    }
    if (paramMessageForPic.picExtraData != null) {
      localAIOImageData.jdField_i_of_type_JavaLangString = paramMessageForPic.picExtraData.doutuSupplier;
    }
    int i;
    if (paramMessageForPic.isMixed)
    {
      i = 1;
      label222:
      localAIOImageData.jdField_a_of_type_JavaLangString = ayog.d(aywk.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label516;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = ayog.d(aywk.a(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForPic.uuid;
      localAIOImageData.jdField_d_of_type_Long = paramMessageForPic.groupFileID;
      localAIOImageData.jdField_a_of_type_Long = paramMessageForPic.width;
      localAIOImageData.jdField_b_of_type_Long = paramMessageForPic.height;
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForPic.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = paramMessageForPic.imageType;
      localAIOImageData.jdField_k_of_type_Boolean = paramMessageForPic.isMultiMsg;
      localAIOImageData.jdField_i_of_type_Boolean = paramMessageForPic.isSend();
      if (paramMessageForPic.picExtraData != null)
      {
        if (paramMessageForPic.picExtraData.isHotPics()) {
          localAIOImageData.jdField_b_of_type_Int = 4;
        }
        localAIOImageData.jdField_e_of_type_Int = paramMessageForPic.picExtraData.imageBizType;
        if (!TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId)) {
          localAIOImageData.o = paramMessageForPic.picExtraData.mTemplateId;
        }
      }
      localAIOImageData.jdField_l_of_type_Boolean = paramMessageForPic.isInMixedMsg;
      localAIOImageData.m = akau.b(paramMessageForPic);
      return localAIOImageData;
      label438:
      Object localObject2 = ((myf)localObject1).a();
      if ((localObject2 == null) || (((myf)localObject1).jdField_a_of_type_Int == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      mye.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.jdField_j_of_type_Boolean = true;
      localAIOImageData.n = mye.a().a(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label516:
      localObject1 = aywk.a(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = ayog.d(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = ayog.e(((URL)localObject1).toString());
        if ((paramMessageForPic.mShowLength > 0) && (paramMessageForPic.mShowLength < paramMessageForPic.mDownloadLength)) {
          localAIOImageData.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static AIOImageData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_f_of_type_Long = paramMessageForTroopFile.uniseq;
    localAIOImageData.jdField_f_of_type_Int = 0;
    localAIOImageData.jdField_g_of_type_Long = paramMessageForTroopFile.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForTroopFile.shmsgseq;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForTroopFile.fileSize;
    localAIOImageData.jdField_g_of_type_Int = paramMessageForTroopFile.istroop;
    localAIOImageData.jdField_h_of_type_Boolean = true;
    localAIOImageData.jdField_k_of_type_JavaLangString = paramMessageForTroopFile.senderuin;
    localAIOImageData.jdField_k_of_type_Boolean = paramMessageForTroopFile.isMultiMsg;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData file, isFromFile = " + localAIOImageData.jdField_h_of_type_Boolean + "  send_uin = " + localAIOImageData.jdField_k_of_type_JavaLangString);
    }
    azqt localazqt = bakj.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localazqt.jdField_d_of_type_JavaLangString != null)
    {
      localObject = localazqt.jdField_d_of_type_JavaLangString;
      localAIOImageData.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (localAIOImageData.jdField_a_of_type_JavaLangString == null) {
        localAIOImageData.jdField_a_of_type_JavaLangString = "I:N";
      }
      if (!TextUtils.isEmpty(localazqt.jdField_c_of_type_JavaLangString)) {
        localAIOImageData.jdField_b_of_type_JavaLangString = localazqt.jdField_c_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(localazqt.jdField_a_of_type_JavaLangString)) && (bbdj.a(localazqt.jdField_a_of_type_JavaLangString))) {
        localAIOImageData.jdField_c_of_type_JavaLangString = localazqt.jdField_a_of_type_JavaLangString;
      }
      if (localazqt.jdField_b_of_type_Int != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool;
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localazqt.jdField_a_of_type_Int;
      try
      {
        localObject = aedg.a(paramQQAppInterface.getApplication(), localazqt, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = aywk.b();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = aywk.b();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = aywk.b();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_g_of_type_JavaLangString = localazqt.jdField_g_of_type_JavaLangString;
      localAIOImageData.jdField_h_of_type_JavaLangString = localazqt.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_e_of_type_Long = localazqt.jdField_c_of_type_Long;
      localAIOImageData.jdField_c_of_type_Int = localazqt.jdField_h_of_type_Int;
      localAIOImageData.jdField_b_of_type_Int = 3;
      return localAIOImageData;
      localObject = localazqt.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public static AIOLightVideoData a(MessageForLightVideo paramMessageForLightVideo)
  {
    AIOLightVideoData localAIOLightVideoData = new AIOLightVideoData();
    localAIOLightVideoData.jdField_f_of_type_Long = paramMessageForLightVideo.uniseq;
    localAIOLightVideoData.jdField_g_of_type_Long = paramMessageForLightVideo.time;
    localAIOLightVideoData.jdField_i_of_type_Long = paramMessageForLightVideo.shmsgseq;
    localAIOLightVideoData.jdField_h_of_type_Long = paramMessageForLightVideo.videoFileSize;
    String str1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localAIOLightVideoData.jdField_a_of_type_JavaLangString = str1;
    localAIOLightVideoData.jdField_b_of_type_JavaLangString = str2;
    localAIOLightVideoData.jdField_a_of_type_Int = paramMessageForLightVideo.videoFileTime;
    localAIOLightVideoData.jdField_b_of_type_Int = paramMessageForLightVideo.busiType;
    localAIOLightVideoData.jdField_c_of_type_Int = paramMessageForLightVideo.thumbWidth;
    localAIOLightVideoData.jdField_d_of_type_Int = paramMessageForLightVideo.thumbHeight;
    localAIOLightVideoData.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localAIOLightVideoData.jdField_k_of_type_Boolean = paramMessageForLightVideo.isMultiMsg;
    return localAIOLightVideoData;
  }
  
  /* Error */
  public static AIORichMediaData a(com.tencent.mobileqq.data.ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: instanceof 674
    //   16: ifeq +815 -> 831
    //   19: aload_0
    //   20: checkcast 674	com/tencent/mobileqq/data/MessageForFile
    //   23: astore 7
    //   25: aload_1
    //   26: invokevirtual 677	com/tencent/mobileqq/app/QQAppInterface:a	()Laoza;
    //   29: aload 7
    //   31: getfield 678	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   34: aload 7
    //   36: getfield 679	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   39: aload 7
    //   41: getfield 680	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   44: invokevirtual 685	aoza:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   47: astore 8
    //   49: aload 8
    //   51: ifnull -41 -> 10
    //   54: aload 8
    //   56: getfield 690	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   59: ifne +199 -> 258
    //   62: new 297	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   65: dup
    //   66: invokespecial 298	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: aload 7
    //   75: getfield 678	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   78: putfield 305	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   81: aload 4
    //   83: aload 7
    //   85: getfield 691	com/tencent/mobileqq/data/MessageForFile:time	J
    //   88: putfield 310	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   91: aload 4
    //   93: aload 7
    //   95: getfield 692	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   98: putfield 315	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_Long	J
    //   101: aload 4
    //   103: aload 7
    //   105: getfield 693	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   108: putfield 321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_Long	J
    //   111: aload 4
    //   113: aload 7
    //   115: getfield 679	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   118: putfield 325	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload 4
    //   123: aload 7
    //   125: getfield 680	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   128: putfield 330	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Int	I
    //   131: aload 4
    //   133: aload_1
    //   134: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   137: putfield 332	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload 4
    //   142: aload 7
    //   144: getfield 694	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   147: putfield 336	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_b_of_type_Int	I
    //   150: aload 4
    //   152: aload_0
    //   153: getfield 697	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   156: putfield 338	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Int	I
    //   159: aload 4
    //   161: aload_0
    //   162: getfield 698	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   165: putfield 341	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_k_of_type_Boolean	Z
    //   168: aload 4
    //   170: aload 8
    //   172: getfield 701	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   175: putfield 360	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload 8
    //   180: getfield 704	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   183: iconst_2
    //   184: if_icmpne +69 -> 253
    //   187: iconst_1
    //   188: istore_3
    //   189: aload 4
    //   191: iload_3
    //   192: putfield 362	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   195: aload 4
    //   197: aload 8
    //   199: getfield 707	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   202: putfield 708	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   205: aload 4
    //   207: aload 8
    //   209: getfield 711	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   212: putfield 346	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_Int	I
    //   215: aload 4
    //   217: aload 8
    //   219: getfield 714	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   222: putfield 351	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Int	I
    //   225: aload 4
    //   227: aload 8
    //   229: getfield 717	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   232: putfield 355	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_e_of_type_Int	I
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 720	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   241: aload 4
    //   243: aload_0
    //   244: invokestatic 370	akau:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   247: putfield 723	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:m	Z
    //   250: aload 4
    //   252: areturn
    //   253: iconst_0
    //   254: istore_3
    //   255: goto -66 -> 189
    //   258: aload 8
    //   260: getfield 690	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   263: iconst_2
    //   264: if_icmpne +556 -> 820
    //   267: aload 8
    //   269: getfield 704	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   272: bipush 16
    //   274: if_icmpne +47 -> 321
    //   277: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -270 -> 10
    //   283: ldc_w 725
    //   286: iconst_1
    //   287: new 241	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   294: ldc 244
    //   296: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 8
    //   301: getfield 728	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   304: invokevirtual 731	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc_w 733
    //   310: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: aload 8
    //   323: invokevirtual 736	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   326: ifeq +47 -> 373
    //   329: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -322 -> 10
    //   335: ldc_w 725
    //   338: iconst_1
    //   339: new 241	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   346: ldc 244
    //   348: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 8
    //   353: getfield 728	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   356: invokevirtual 731	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: ldc_w 738
    //   362: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aconst_null
    //   372: areturn
    //   373: aload 8
    //   375: invokevirtual 741	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   378: invokestatic 273	bbdj:b	(Ljava/lang/String;)Z
    //   381: istore_3
    //   382: iload_3
    //   383: ifeq +56 -> 439
    //   386: aload 8
    //   388: getfield 704	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   391: iconst_1
    //   392: if_icmpeq +47 -> 439
    //   395: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -388 -> 10
    //   401: ldc_w 725
    //   404: iconst_1
    //   405: new 241	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   412: ldc 244
    //   414: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 8
    //   419: getfield 728	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   422: invokevirtual 731	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: ldc_w 743
    //   428: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aconst_null
    //   438: areturn
    //   439: aload_1
    //   440: sipush 317
    //   443: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   446: checkcast 275	aows
    //   449: aload 8
    //   451: getfield 744	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   454: invokestatic 283	bahk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   457: invokevirtual 286	aows:a	(Ljava/lang/String;)Lamxu;
    //   460: astore 4
    //   462: aload 8
    //   464: getfield 747	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   467: invokestatic 750	apvb:b	(Ljava/lang/String;)Z
    //   470: ifeq +256 -> 726
    //   473: aload 8
    //   475: getfield 747	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   478: astore_1
    //   479: aload_1
    //   480: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +39 -> 522
    //   486: ldc 44
    //   488: iconst_1
    //   489: new 241	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 752
    //   499: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 8
    //   504: getfield 728	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   507: invokevirtual 731	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: ldc_w 754
    //   513: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   525: dup
    //   526: aload_1
    //   527: invokespecial 755	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   530: astore 6
    //   532: aload 6
    //   534: aload 7
    //   536: getfield 678	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   539: putfield 756	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   542: aload 6
    //   544: aload 7
    //   546: getfield 691	com/tencent/mobileqq/data/MessageForFile:time	J
    //   549: putfield 757	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   552: aload 6
    //   554: aload 7
    //   556: getfield 692	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   559: putfield 758	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   562: aload 6
    //   564: aload 8
    //   566: getfield 759	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   569: putfield 760	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   572: aload 6
    //   574: aload 8
    //   576: getfield 744	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   579: putfield 761	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   582: aload 6
    //   584: aload_0
    //   585: getfield 697	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   588: putfield 762	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   591: aload 6
    //   593: aload 4
    //   595: getfield 765	amxu:jdField_b_of_type_Int	I
    //   598: i2l
    //   599: putfield 766	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   602: iload_3
    //   603: ifeq +107 -> 710
    //   606: aload 6
    //   608: aload 8
    //   610: invokevirtual 741	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   613: putfield 767	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   616: aload 6
    //   618: iconst_1
    //   619: putfield 769	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   622: new 771	android/media/MediaMetadataRetriever
    //   625: dup
    //   626: invokespecial 772	android/media/MediaMetadataRetriever:<init>	()V
    //   629: astore_1
    //   630: aload_1
    //   631: aload 6
    //   633: getfield 767	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   636: invokevirtual 775	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   639: aload_1
    //   640: bipush 24
    //   642: invokevirtual 779	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   645: astore 4
    //   647: aload_1
    //   648: bipush 19
    //   650: invokevirtual 779	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   653: astore 5
    //   655: aload_1
    //   656: bipush 18
    //   658: invokevirtual 779	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   661: astore 7
    //   663: aload 4
    //   665: invokestatic 784	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   668: istore_2
    //   669: iload_2
    //   670: bipush 90
    //   672: if_icmpeq +10 -> 682
    //   675: iload_2
    //   676: sipush 270
    //   679: if_icmpne +87 -> 766
    //   682: aload 6
    //   684: aload 5
    //   686: invokestatic 784	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   689: putfield 785	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   692: aload 6
    //   694: aload 7
    //   696: invokestatic 784	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   699: putfield 786	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   702: aload_1
    //   703: ifnull +7 -> 710
    //   706: aload_1
    //   707: invokevirtual 789	android/media/MediaMetadataRetriever:release	()V
    //   710: aload 6
    //   712: aload_0
    //   713: getfield 698	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   716: putfield 790	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   719: aload 6
    //   721: astore 4
    //   723: goto -482 -> 241
    //   726: aload 8
    //   728: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   731: invokestatic 750	apvb:b	(Ljava/lang/String;)Z
    //   734: ifeq +12 -> 746
    //   737: aload 8
    //   739: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   742: astore_1
    //   743: goto -264 -> 479
    //   746: aload 8
    //   748: getfield 796	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   751: invokestatic 750	apvb:b	(Ljava/lang/String;)Z
    //   754: ifeq +589 -> 1343
    //   757: aload 8
    //   759: getfield 796	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   762: astore_1
    //   763: goto -284 -> 479
    //   766: aload 6
    //   768: aload 7
    //   770: invokestatic 784	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   773: putfield 785	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   776: aload 6
    //   778: aload 5
    //   780: invokestatic 784	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   783: putfield 786	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   786: goto -84 -> 702
    //   789: astore 4
    //   791: aload 4
    //   793: invokevirtual 799	java/lang/Exception:printStackTrace	()V
    //   796: aload_1
    //   797: ifnull -87 -> 710
    //   800: aload_1
    //   801: invokevirtual 789	android/media/MediaMetadataRetriever:release	()V
    //   804: goto -94 -> 710
    //   807: astore_0
    //   808: aconst_null
    //   809: astore_1
    //   810: aload_1
    //   811: ifnull +7 -> 818
    //   814: aload_1
    //   815: invokevirtual 789	android/media/MediaMetadataRetriever:release	()V
    //   818: aload_0
    //   819: athrow
    //   820: ldc 44
    //   822: iconst_1
    //   823: ldc 230
    //   825: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: goto -587 -> 241
    //   831: aload_0
    //   832: instanceof 220
    //   835: ifeq -594 -> 241
    //   838: aload_0
    //   839: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   842: astore 5
    //   844: aload_1
    //   845: aload 5
    //   847: invokestatic 211	bakj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForTroopFile;)Lazqt;
    //   850: astore 6
    //   852: aload 6
    //   854: ifnonnull +19 -> 873
    //   857: invokestatic 214	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   860: ifeq -850 -> 10
    //   863: ldc 44
    //   865: iconst_4
    //   866: ldc 216
    //   868: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aconst_null
    //   872: areturn
    //   873: aload_0
    //   874: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   877: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   880: invokestatic 228	apue:a	(Ljava/lang/String;)I
    //   883: iconst_2
    //   884: if_icmpeq +13 -> 897
    //   887: ldc 44
    //   889: iconst_1
    //   890: ldc 230
    //   892: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: aconst_null
    //   896: areturn
    //   897: aload 6
    //   899: getfield 237	azqt:jdField_b_of_type_Int	I
    //   902: bipush 12
    //   904: if_icmpne +47 -> 951
    //   907: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   910: ifeq -900 -> 10
    //   913: ldc_w 725
    //   916: iconst_1
    //   917: new 241	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   924: ldc 244
    //   926: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload 6
    //   931: getfield 251	azqt:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   934: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   937: ldc_w 256
    //   940: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   949: aconst_null
    //   950: areturn
    //   951: aload 6
    //   953: getfield 237	azqt:jdField_b_of_type_Int	I
    //   956: iconst_4
    //   957: if_icmpeq +12 -> 969
    //   960: aload 6
    //   962: getfield 237	azqt:jdField_b_of_type_Int	I
    //   965: iconst_5
    //   966: if_icmpne +55 -> 1021
    //   969: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq -962 -> 10
    //   975: ldc_w 725
    //   978: iconst_1
    //   979: new 241	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   986: ldc 244
    //   988: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload 6
    //   993: getfield 251	azqt:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   996: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   999: ldc_w 264
    //   1002: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: aload 6
    //   1007: getfield 237	azqt:jdField_b_of_type_Int	I
    //   1010: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1019: aconst_null
    //   1020: areturn
    //   1021: aload 6
    //   1023: getfield 269	azqt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1026: invokestatic 273	bbdj:b	(Ljava/lang/String;)Z
    //   1029: ifeq +82 -> 1111
    //   1032: aload 6
    //   1034: getfield 237	azqt:jdField_b_of_type_Int	I
    //   1037: iconst_1
    //   1038: if_icmpeq +21 -> 1059
    //   1041: aload 6
    //   1043: getfield 237	azqt:jdField_b_of_type_Int	I
    //   1046: iconst_2
    //   1047: if_icmpeq +12 -> 1059
    //   1050: aload 6
    //   1052: getfield 237	azqt:jdField_b_of_type_Int	I
    //   1055: iconst_3
    //   1056: if_icmpne +55 -> 1111
    //   1059: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1062: ifeq -1052 -> 10
    //   1065: ldc_w 725
    //   1068: iconst_1
    //   1069: new 241	java/lang/StringBuilder
    //   1072: dup
    //   1073: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1076: ldc 244
    //   1078: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload 6
    //   1083: getfield 251	azqt:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1086: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1089: ldc_w 264
    //   1092: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload 6
    //   1097: getfield 237	azqt:jdField_b_of_type_Int	I
    //   1100: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: aconst_null
    //   1110: areturn
    //   1111: aload_1
    //   1112: sipush 317
    //   1115: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1118: checkcast 275	aows
    //   1121: aload 6
    //   1123: getfield 278	azqt:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1126: invokestatic 283	bahk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1129: invokevirtual 286	aows:a	(Ljava/lang/String;)Lamxu;
    //   1132: astore 7
    //   1134: aload 6
    //   1136: getfield 288	azqt:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1139: astore 4
    //   1141: aload 4
    //   1143: astore_1
    //   1144: aload 4
    //   1146: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1149: ifeq +9 -> 1158
    //   1152: aload 6
    //   1154: getfield 585	azqt:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1157: astore_1
    //   1158: aload_1
    //   1159: astore 4
    //   1161: aload 5
    //   1163: getfield 292	com/tencent/mobileqq/data/MessageForTroopFile:isMultiMsg	Z
    //   1166: ifeq +20 -> 1186
    //   1169: aload_1
    //   1170: astore 4
    //   1172: aload_1
    //   1173: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1176: ifeq +10 -> 1186
    //   1179: aload 5
    //   1181: invokestatic 295	apue:a	(Lcom/tencent/mobileqq/data/ChatMessage;)Ljava/lang/String;
    //   1184: astore 4
    //   1186: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   1189: dup
    //   1190: aload 4
    //   1192: invokespecial 755	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   1195: astore 4
    //   1197: aload 4
    //   1199: aload 5
    //   1201: getfield 302	com/tencent/mobileqq/data/MessageForTroopFile:uniseq	J
    //   1204: putfield 756	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   1207: aload 4
    //   1209: aload 5
    //   1211: getfield 308	com/tencent/mobileqq/data/MessageForTroopFile:time	J
    //   1214: putfield 757	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   1217: aload 4
    //   1219: aload 5
    //   1221: getfield 313	com/tencent/mobileqq/data/MessageForTroopFile:shmsgseq	J
    //   1224: putfield 758	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   1227: aload 4
    //   1229: aload 5
    //   1231: getfield 318	com/tencent/mobileqq/data/MessageForTroopFile:fileSize	J
    //   1234: putfield 760	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   1237: aload 4
    //   1239: aload 5
    //   1241: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   1244: putfield 761	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1247: aload 4
    //   1249: aload 5
    //   1251: getfield 328	com/tencent/mobileqq/data/MessageForTroopFile:istroop	I
    //   1254: putfield 762	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   1257: aload 4
    //   1259: aload 7
    //   1261: getfield 765	amxu:jdField_b_of_type_Int	I
    //   1264: i2l
    //   1265: putfield 766	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   1268: aload 4
    //   1270: aload 5
    //   1272: getfield 344	com/tencent/mobileqq/data/MessageForTroopFile:width	I
    //   1275: putfield 785	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   1278: aload 4
    //   1280: aload 5
    //   1282: getfield 349	com/tencent/mobileqq/data/MessageForTroopFile:height	I
    //   1285: putfield 786	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   1288: aload 6
    //   1290: getfield 269	azqt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1293: invokestatic 273	bbdj:b	(Ljava/lang/String;)Z
    //   1296: ifeq +19 -> 1315
    //   1299: aload 4
    //   1301: aload 6
    //   1303: getfield 269	azqt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1306: putfield 767	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1309: aload 4
    //   1311: iconst_1
    //   1312: putfield 769	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   1315: aload 4
    //   1317: aload_0
    //   1318: getfield 698	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   1321: putfield 790	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   1324: goto -1083 -> 241
    //   1327: astore_0
    //   1328: goto -518 -> 810
    //   1331: astore_0
    //   1332: goto -522 -> 810
    //   1335: astore 4
    //   1337: aload 5
    //   1339: astore_1
    //   1340: goto -549 -> 791
    //   1343: aconst_null
    //   1344: astore_1
    //   1345: goto -866 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1348	0	paramChatMessage	com.tencent.mobileqq.data.ChatMessage
    //   0	1348	1	paramQQAppInterface	QQAppInterface
    //   668	12	2	i	int
    //   188	415	3	bool	boolean
    //   4	718	4	localObject1	Object
    //   789	3	4	localException1	Exception
    //   1139	177	4	localObject2	Object
    //   1335	1	4	localException2	Exception
    //   1	1337	5	localObject3	Object
    //   530	772	6	localObject4	Object
    //   23	1237	7	localObject5	Object
    //   47	711	8	localFileManagerEntity	com.tencent.mobileqq.filemanager.data.FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   630	669	789	java/lang/Exception
    //   682	702	789	java/lang/Exception
    //   766	786	789	java/lang/Exception
    //   622	630	807	finally
    //   630	669	1327	finally
    //   682	702	1327	finally
    //   766	786	1327	finally
    //   791	796	1331	finally
    //   622	630	1335	java/lang/Exception
  }
  
  public static AIOShortVideoData a(MessageForShortVideo paramMessageForShortVideo)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.jdField_f_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_g_of_type_Long = paramMessageForShortVideo.time;
    localAIOShortVideoData.jdField_h_of_type_Long = paramMessageForShortVideo.videoFileSize;
    localAIOShortVideoData.jdField_i_of_type_Long = paramMessageForShortVideo.shmsgseq;
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localAIOShortVideoData.jdField_a_of_type_JavaLangString = str1;
    localAIOShortVideoData.jdField_b_of_type_JavaLangString = str2;
    localAIOShortVideoData.jdField_a_of_type_Int = paramMessageForShortVideo.videoFileTime;
    localAIOShortVideoData.jdField_b_of_type_Int = paramMessageForShortVideo.busiType;
    localAIOShortVideoData.jdField_c_of_type_Int = paramMessageForShortVideo.thumbWidth;
    localAIOShortVideoData.jdField_d_of_type_Int = paramMessageForShortVideo.thumbHeight;
    localAIOShortVideoData.jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_e_of_type_Int = paramMessageForShortVideo.redBagType;
    localAIOShortVideoData.jdField_c_of_type_JavaLangString = paramMessageForShortVideo.shortVideoId;
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = akpy.c(paramMessageForShortVideo);
    localAIOShortVideoData.jdField_h_of_type_Int = paramMessageForShortVideo.redBagStat;
    localAIOShortVideoData.jdField_e_of_type_JavaLangString = paramMessageForShortVideo.frienduin;
    localAIOShortVideoData.jdField_g_of_type_Int = paramMessageForShortVideo.istroop;
    if (paramMessageForShortVideo.isSend()) {}
    for (int i = 1;; i = 0)
    {
      localAIOShortVideoData.jdField_i_of_type_Int = i;
      localAIOShortVideoData.jdField_k_of_type_Int = paramMessageForShortVideo.specialVideoType;
      localAIOShortVideoData.j = paramMessageForShortVideo.videoFileStatus;
      localAIOShortVideoData.jdField_k_of_type_Boolean = paramMessageForShortVideo.isMultiMsg;
      localAIOShortVideoData.jdField_f_of_type_JavaLangString = paramMessageForShortVideo.templateId;
      localAIOShortVideoData.m = akau.b(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (ansr)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
    }
    List localList = paramContext.a();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(i);
          paramContext.a(paramString, i);
          return paramString;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
  {
    bgyf localbgyf = bgyf.a();
    localbgyf.jdField_a_of_type_JavaLangString = paramString1;
    bgxy.a(paramActivity, localbgyf, paramIntent, paramString2, paramString3, paramString4, paramString5, paramInt1, paramArrayList, 7001, paramInt2);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, aeid paramaeid)
  {
    if (!CheckPermission.isHasStoragePermission(paramActivity)) {
      CheckPermission.requestStorePermission(paramActivity, null);
    }
    do
    {
      for (;;)
      {
        return;
        new File(ajsf.bc).mkdirs();
        String str = paramString;
        if (paramString.indexOf(".") == -1)
        {
          str = bbdj.b(paramFile.getAbsolutePath());
          str = paramString + "." + str;
        }
        paramString = new File(ajsf.bc, str);
        if (paramString.exists()) {
          break label145;
        }
        try
        {
          if (paramString.createNewFile())
          {
            b(paramActivity, paramFile, paramString, paramaeid);
            return;
          }
        }
        catch (IOException paramFile)
        {
          bcpw.a(paramActivity, paramActivity.getString(2131695189), 0).a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOGalleryUtils", 2, "", paramFile);
    return;
    label145:
    bbcv.a(paramActivity, 230).setTitle(paramActivity.getString(2131718837)).setMessage(paramActivity.getString(2131695182)).setPositiveButton(paramActivity.getString(2131718713), new aeia(paramActivity, paramFile, paramString, paramaeid)).setNegativeButton(paramActivity.getString(2131694647), new aehz()).show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, aeja paramaeja, boolean paramBoolean, String paramString3)
  {
    if ((paramaeja == null) || (!AIOImageData.class.isInstance(paramaeja.a))) {
      return;
    }
    bgyf localbgyf = bgyf.a();
    localbgyf.jdField_a_of_type_JavaLangString = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramaeja.a;
    paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
    if (!paramString1.endsWith("_hd"))
    {
      paramaeja = paramString1 + "_hd";
      if (new File(paramaeja).exists()) {
        paramString1 = paramaeja;
      }
    }
    for (;;)
    {
      paramaeja = localAIOImageData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOImageData.jdField_c_of_type_Long;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.jdField_d_of_type_Long;
      }
      bgxy.a(paramActivity, localbgyf, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramaeja, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<aeja> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    bgyf localbgyf = bgyf.a();
    localbgyf.jdField_a_of_type_JavaLangString = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (aeja)localIterator.next();
      if (AIOImageData.class.isInstance(paramString1.a))
      {
        localAIOImageData = (AIOImageData)paramString1.a;
        localArrayList2.add(localAIOImageData.jdField_e_of_type_JavaLangString);
        localArrayList3.add(Long.valueOf(localAIOImageData.jdField_c_of_type_Long));
        if (paramBoolean) {
          localArrayList4.add(Long.valueOf(localAIOImageData.jdField_d_of_type_Long));
        }
        paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
        if (paramString1.endsWith("_hd")) {
          break label298;
        }
        paramList = paramString1 + "_hd";
        if (!new File(paramList).exists()) {
          break label298;
        }
        paramString1 = paramList;
      }
    }
    label298:
    for (;;)
    {
      localArrayList1.add(paramString1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryUtils", 2, "fowardToQZoneGroupAlbums(), uuid:" + localAIOImageData.jdField_e_of_type_JavaLangString + " time:" + localAIOImageData.jdField_c_of_type_Long + " path:" + paramString1);
      break;
      bgxy.a(paramActivity, localbgyf, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    bgyf localbgyf = bgyf.a();
    localbgyf.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    bgxy.a(paramActivity, localbgyf, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    bgyf localbgyf = bgyf.a();
    localbgyf.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    bgxy.a(paramActivity, localbgyf, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new aeic(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = aehv.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (antv)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      if (!localVipComicFavorEmoStructMsgInfo.equals(paramQQAppInterface.a(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
        paramQQAppInterface.a(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, aeid paramaeid)
  {
    new aeib(paramFile1, paramFile2, paramActivity, paramaeid).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = aehv.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (antv)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
      paramQQAppInterface.a(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "handleComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehy
 * JD-Core Version:    0.7.0.1
 */