import android.app.Activity;
import android.content.Context;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class agem
{
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    apke localapke = (apke)paramContext.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localapke.a();
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
        localapke.a((CustomEmotionData)((List)localObject).get(j), j);
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
      localapke.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(aljq.bU))) {
        azmj.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (apkf)paramContext.getManager(103);
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
    Object localObject = (apke)localQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((apke)localObject).a();
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
            ((apke)localObject).a((CustomEmotionData)localList.get(j), j);
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
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(aljq.bU))) {
      azmj.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new apjn(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (apkf)localQQAppInterface.getManager(103);
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
    Object localObject = (apke)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((apke)localObject).a();
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
        ((apke)localObject).a((CustomEmotionData)localList.get(j), j);
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
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(aljq.bU))) {
        azmj.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new apjn(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (apkf)paramQQAppInterface.getManager(103);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    bbpe localbbpe = bcjk.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localbbpe == null) {
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
          if (arni.a(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localbbpe.jdField_b_of_type_Int != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbbpe.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
        return null;
        if ((localbbpe.jdField_b_of_type_Int != 4) && (localbbpe.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbbpe.jdField_a_of_type_JavaUtilUUID + " file is:" + localbbpe.jdField_b_of_type_Int);
      return null;
      if ((!bdcs.b(localbbpe.jdField_a_of_type_JavaLangString)) || ((localbbpe.jdField_b_of_type_Int != 1) && (localbbpe.jdField_b_of_type_Int != 2) && (localbbpe.jdField_b_of_type_Int != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbbpe.jdField_a_of_type_JavaUtilUUID + " file is:" + localbbpe.jdField_b_of_type_Int);
    return null;
    ((aqpu)paramQQAppInterface.getManager(317)).a(bcgk.a(localbbpe.jdField_g_of_type_JavaLangString));
    Object localObject = localbbpe.jdField_d_of_type_JavaLangString;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      arni.a(paramMessageForTroopFile);
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
    ((AIOFilePicData)localObject).jdField_e_of_type_Int = localbbpe.jdField_i_of_type_Int;
    ((AIOFilePicData)localObject).jdField_h_of_type_JavaLangString = paramMessageForTroopFile.url;
    if (localbbpe.jdField_b_of_type_Int == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = bool;
      ((AIOFilePicData)localObject).a(localbbpe);
      ((AIOFilePicData)localObject).m = alsh.b(paramMessageForTroopFile);
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
    if (nav.a(paramMessageForPic))
    {
      localObject1 = nav.a(paramMessageForPic);
      if ((((naw)localObject1).jdField_a_of_type_JavaLangString != null) || (((naw)localObject1).jdField_a_of_type_Int == 2)) {
        break label437;
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
      localAIOImageData.jdField_a_of_type_JavaLangString = bame.d(baul.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label515;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = bame.d(baul.a(paramMessageForPic, 131075, null).toString());
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
        localAIOImageData.o = paramMessageForPic.picExtraData.mTemplateId;
        localAIOImageData.p = paramMessageForPic.picExtraData.mTemplateName;
      }
      localAIOImageData.jdField_l_of_type_Boolean = paramMessageForPic.isInMixedMsg;
      localAIOImageData.m = alsh.b(paramMessageForPic);
      return localAIOImageData;
      label437:
      Object localObject2 = ((naw)localObject1).a();
      if ((localObject2 == null) || (((naw)localObject1).jdField_a_of_type_Int == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      nav.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.jdField_j_of_type_Boolean = true;
      localAIOImageData.n = nav.a().a(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label515:
      localObject1 = baul.a(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = bame.d(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = bame.e(((URL)localObject1).toString());
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
    bbpe localbbpe = bcjk.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localbbpe.jdField_d_of_type_JavaLangString != null)
    {
      localObject = localbbpe.jdField_d_of_type_JavaLangString;
      localAIOImageData.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (localAIOImageData.jdField_a_of_type_JavaLangString == null) {
        localAIOImageData.jdField_a_of_type_JavaLangString = "I:N";
      }
      if (!TextUtils.isEmpty(localbbpe.jdField_c_of_type_JavaLangString)) {
        localAIOImageData.jdField_b_of_type_JavaLangString = localbbpe.jdField_c_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(localbbpe.jdField_a_of_type_JavaLangString)) && (bdcs.a(localbbpe.jdField_a_of_type_JavaLangString))) {
        localAIOImageData.jdField_c_of_type_JavaLangString = localbbpe.jdField_a_of_type_JavaLangString;
      }
      if (localbbpe.jdField_b_of_type_Int != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool;
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localbbpe.jdField_a_of_type_Int;
      try
      {
        localObject = afzs.a(paramQQAppInterface.getApplication(), localbbpe, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = baul.b();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = baul.b();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = baul.b();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_g_of_type_JavaLangString = localbbpe.jdField_g_of_type_JavaLangString;
      localAIOImageData.jdField_h_of_type_JavaLangString = localbbpe.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_e_of_type_Long = localbbpe.jdField_c_of_type_Long;
      localAIOImageData.jdField_c_of_type_Int = localbbpe.jdField_h_of_type_Int;
      localAIOImageData.jdField_b_of_type_Int = 3;
      return localAIOImageData;
      localObject = localbbpe.jdField_b_of_type_JavaLangString;
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
    //   13: instanceof 680
    //   16: ifeq +865 -> 881
    //   19: aload_0
    //   20: checkcast 680	com/tencent/mobileqq/data/MessageForFile
    //   23: astore 7
    //   25: aload_1
    //   26: invokevirtual 683	com/tencent/mobileqq/app/QQAppInterface:a	()Laqsc;
    //   29: aload 7
    //   31: getfield 684	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   34: aload 7
    //   36: getfield 685	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   39: aload 7
    //   41: getfield 686	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   44: invokevirtual 691	aqsc:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   47: astore 8
    //   49: aload 8
    //   51: ifnull -41 -> 10
    //   54: aload 8
    //   56: getfield 696	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   59: ifne +199 -> 258
    //   62: new 297	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   65: dup
    //   66: invokespecial 298	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: aload 7
    //   75: getfield 684	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   78: putfield 305	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   81: aload 4
    //   83: aload 7
    //   85: getfield 697	com/tencent/mobileqq/data/MessageForFile:time	J
    //   88: putfield 310	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   91: aload 4
    //   93: aload 7
    //   95: getfield 698	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   98: putfield 315	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_Long	J
    //   101: aload 4
    //   103: aload 7
    //   105: getfield 699	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   108: putfield 321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_Long	J
    //   111: aload 4
    //   113: aload 7
    //   115: getfield 685	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   118: putfield 325	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload 4
    //   123: aload 7
    //   125: getfield 686	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   128: putfield 330	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Int	I
    //   131: aload 4
    //   133: aload_1
    //   134: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   137: putfield 332	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload 4
    //   142: aload 7
    //   144: getfield 700	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   147: putfield 336	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_b_of_type_Int	I
    //   150: aload 4
    //   152: aload_0
    //   153: getfield 703	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   156: putfield 338	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Int	I
    //   159: aload 4
    //   161: aload_0
    //   162: getfield 704	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   165: putfield 341	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_k_of_type_Boolean	Z
    //   168: aload 4
    //   170: aload 8
    //   172: getfield 707	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   175: putfield 360	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload 8
    //   180: getfield 710	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   183: iconst_2
    //   184: if_icmpne +69 -> 253
    //   187: iconst_1
    //   188: istore_3
    //   189: aload 4
    //   191: iload_3
    //   192: putfield 362	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   195: aload 4
    //   197: aload 8
    //   199: getfield 713	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   202: putfield 714	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   205: aload 4
    //   207: aload 8
    //   209: getfield 717	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   212: putfield 346	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_Int	I
    //   215: aload 4
    //   217: aload 8
    //   219: getfield 720	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   222: putfield 351	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Int	I
    //   225: aload 4
    //   227: aload 8
    //   229: getfield 723	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   232: putfield 355	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_e_of_type_Int	I
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 726	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   241: aload 4
    //   243: aload_0
    //   244: invokestatic 370	alsh:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   247: putfield 729	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:m	Z
    //   250: aload 4
    //   252: areturn
    //   253: iconst_0
    //   254: istore_3
    //   255: goto -66 -> 189
    //   258: aload 8
    //   260: getfield 696	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   263: iconst_2
    //   264: if_icmpne +606 -> 870
    //   267: aload 8
    //   269: getfield 710	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   272: bipush 16
    //   274: if_icmpne +47 -> 321
    //   277: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -270 -> 10
    //   283: ldc_w 731
    //   286: iconst_1
    //   287: new 241	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   294: ldc 244
    //   296: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 8
    //   301: getfield 734	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   304: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc_w 739
    //   310: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: aload 8
    //   323: invokevirtual 742	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   326: ifeq +47 -> 373
    //   329: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -322 -> 10
    //   335: ldc_w 731
    //   338: iconst_1
    //   339: new 241	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   346: ldc 244
    //   348: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 8
    //   353: getfield 734	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   356: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: ldc_w 744
    //   362: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aconst_null
    //   372: areturn
    //   373: aload 8
    //   375: invokevirtual 747	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   378: invokestatic 273	bdcs:b	(Ljava/lang/String;)Z
    //   381: istore_3
    //   382: iload_3
    //   383: ifeq +56 -> 439
    //   386: aload 8
    //   388: getfield 710	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   391: iconst_1
    //   392: if_icmpeq +47 -> 439
    //   395: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -388 -> 10
    //   401: ldc_w 731
    //   404: iconst_1
    //   405: new 241	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   412: ldc 244
    //   414: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 8
    //   419: getfield 734	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   422: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: ldc_w 749
    //   428: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aconst_null
    //   438: areturn
    //   439: aload_1
    //   440: sipush 317
    //   443: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   446: checkcast 275	aqpu
    //   449: aload 8
    //   451: getfield 750	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   454: invokestatic 283	bcgk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   457: invokevirtual 286	aqpu:a	(Ljava/lang/String;)Laopc;
    //   460: astore 4
    //   462: aload 8
    //   464: getfield 753	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   467: invokestatic 756	arof:b	(Ljava/lang/String;)Z
    //   470: ifeq +306 -> 776
    //   473: aload 8
    //   475: getfield 753	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   478: astore_1
    //   479: aload_1
    //   480: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +39 -> 522
    //   486: ldc 44
    //   488: iconst_1
    //   489: new 241	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 758
    //   499: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 8
    //   504: getfield 734	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   507: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: ldc_w 760
    //   513: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   525: dup
    //   526: aload_1
    //   527: invokespecial 761	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   530: astore 6
    //   532: aload 6
    //   534: aload 7
    //   536: getfield 685	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   539: putfield 762	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   542: aload 6
    //   544: aload 7
    //   546: getfield 686	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   549: putfield 763	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Int	I
    //   552: aload 6
    //   554: aload 7
    //   556: getfield 700	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   559: putfield 764	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_d_of_type_Int	I
    //   562: aload 6
    //   564: aload 8
    //   566: getfield 707	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   569: putfield 765	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   572: aload 6
    //   574: aload 8
    //   576: getfield 713	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   579: putfield 766	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   582: aload 6
    //   584: aload 7
    //   586: getfield 684	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   589: putfield 767	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   592: aload 6
    //   594: aload 7
    //   596: getfield 697	com/tencent/mobileqq/data/MessageForFile:time	J
    //   599: putfield 768	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   602: aload 6
    //   604: aload 7
    //   606: getfield 698	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   609: putfield 769	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   612: aload 6
    //   614: aload 8
    //   616: getfield 770	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   619: putfield 771	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   622: aload 6
    //   624: aload 8
    //   626: getfield 750	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   629: putfield 772	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   632: aload 6
    //   634: aload_0
    //   635: getfield 703	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   638: putfield 773	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   641: aload 6
    //   643: aload 4
    //   645: getfield 776	aopc:jdField_b_of_type_Int	I
    //   648: i2l
    //   649: putfield 777	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   652: iload_3
    //   653: ifeq +107 -> 760
    //   656: aload 6
    //   658: aload 8
    //   660: invokevirtual 747	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   663: putfield 778	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   666: aload 6
    //   668: iconst_1
    //   669: putfield 780	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   672: new 782	android/media/MediaMetadataRetriever
    //   675: dup
    //   676: invokespecial 783	android/media/MediaMetadataRetriever:<init>	()V
    //   679: astore_1
    //   680: aload_1
    //   681: aload 6
    //   683: getfield 778	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   686: invokevirtual 786	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   689: aload_1
    //   690: bipush 24
    //   692: invokevirtual 790	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   695: astore 4
    //   697: aload_1
    //   698: bipush 19
    //   700: invokevirtual 790	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   703: astore 5
    //   705: aload_1
    //   706: bipush 18
    //   708: invokevirtual 790	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   711: astore 7
    //   713: aload 4
    //   715: invokestatic 795	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   718: istore_2
    //   719: iload_2
    //   720: bipush 90
    //   722: if_icmpeq +10 -> 732
    //   725: iload_2
    //   726: sipush 270
    //   729: if_icmpne +87 -> 816
    //   732: aload 6
    //   734: aload 5
    //   736: invokestatic 795	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   739: putfield 796	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   742: aload 6
    //   744: aload 7
    //   746: invokestatic 795	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   749: putfield 797	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   752: aload_1
    //   753: ifnull +7 -> 760
    //   756: aload_1
    //   757: invokevirtual 800	android/media/MediaMetadataRetriever:release	()V
    //   760: aload 6
    //   762: aload_0
    //   763: getfield 704	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   766: putfield 801	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   769: aload 6
    //   771: astore 4
    //   773: goto -532 -> 241
    //   776: aload 8
    //   778: getfield 804	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   781: invokestatic 756	arof:b	(Ljava/lang/String;)Z
    //   784: ifeq +12 -> 796
    //   787: aload 8
    //   789: getfield 804	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   792: astore_1
    //   793: goto -314 -> 479
    //   796: aload 8
    //   798: getfield 807	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   801: invokestatic 756	arof:b	(Ljava/lang/String;)Z
    //   804: ifeq +619 -> 1423
    //   807: aload 8
    //   809: getfield 807	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   812: astore_1
    //   813: goto -334 -> 479
    //   816: aload 6
    //   818: aload 7
    //   820: invokestatic 795	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   823: putfield 796	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   826: aload 6
    //   828: aload 5
    //   830: invokestatic 795	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   833: putfield 797	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   836: goto -84 -> 752
    //   839: astore 4
    //   841: aload 4
    //   843: invokevirtual 810	java/lang/Exception:printStackTrace	()V
    //   846: aload_1
    //   847: ifnull -87 -> 760
    //   850: aload_1
    //   851: invokevirtual 800	android/media/MediaMetadataRetriever:release	()V
    //   854: goto -94 -> 760
    //   857: astore_0
    //   858: aconst_null
    //   859: astore_1
    //   860: aload_1
    //   861: ifnull +7 -> 868
    //   864: aload_1
    //   865: invokevirtual 800	android/media/MediaMetadataRetriever:release	()V
    //   868: aload_0
    //   869: athrow
    //   870: ldc 44
    //   872: iconst_1
    //   873: ldc 230
    //   875: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: goto -637 -> 241
    //   881: aload_0
    //   882: instanceof 220
    //   885: ifeq -644 -> 241
    //   888: aload_0
    //   889: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   892: astore 5
    //   894: aload_1
    //   895: aload 5
    //   897: invokestatic 211	bcjk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForTroopFile;)Lbbpe;
    //   900: astore 6
    //   902: aload 6
    //   904: ifnonnull +19 -> 923
    //   907: invokestatic 214	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   910: ifeq -900 -> 10
    //   913: ldc 44
    //   915: iconst_4
    //   916: ldc 216
    //   918: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   921: aconst_null
    //   922: areturn
    //   923: aload_0
    //   924: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   927: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   930: invokestatic 228	arni:a	(Ljava/lang/String;)I
    //   933: iconst_2
    //   934: if_icmpeq +13 -> 947
    //   937: ldc 44
    //   939: iconst_1
    //   940: ldc 230
    //   942: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: aconst_null
    //   946: areturn
    //   947: aload 6
    //   949: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   952: bipush 12
    //   954: if_icmpne +47 -> 1001
    //   957: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq -950 -> 10
    //   963: ldc_w 731
    //   966: iconst_1
    //   967: new 241	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   974: ldc 244
    //   976: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload 6
    //   981: getfield 251	bbpe:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   984: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: ldc_w 256
    //   990: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   999: aconst_null
    //   1000: areturn
    //   1001: aload 6
    //   1003: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1006: iconst_4
    //   1007: if_icmpeq +12 -> 1019
    //   1010: aload 6
    //   1012: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1015: iconst_5
    //   1016: if_icmpne +55 -> 1071
    //   1019: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq -1012 -> 10
    //   1025: ldc_w 731
    //   1028: iconst_1
    //   1029: new 241	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1036: ldc 244
    //   1038: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 6
    //   1043: getfield 251	bbpe:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1046: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 264
    //   1052: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 6
    //   1057: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1060: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1069: aconst_null
    //   1070: areturn
    //   1071: aload 6
    //   1073: getfield 269	bbpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1076: invokestatic 273	bdcs:b	(Ljava/lang/String;)Z
    //   1079: ifeq +82 -> 1161
    //   1082: aload 6
    //   1084: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1087: iconst_1
    //   1088: if_icmpeq +21 -> 1109
    //   1091: aload 6
    //   1093: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1096: iconst_2
    //   1097: if_icmpeq +12 -> 1109
    //   1100: aload 6
    //   1102: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1105: iconst_3
    //   1106: if_icmpne +55 -> 1161
    //   1109: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq -1102 -> 10
    //   1115: ldc_w 731
    //   1118: iconst_1
    //   1119: new 241	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1126: ldc 244
    //   1128: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload 6
    //   1133: getfield 251	bbpe:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1136: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1139: ldc_w 264
    //   1142: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: aload 6
    //   1147: getfield 237	bbpe:jdField_b_of_type_Int	I
    //   1150: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: aconst_null
    //   1160: areturn
    //   1161: aload_1
    //   1162: sipush 317
    //   1165: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1168: checkcast 275	aqpu
    //   1171: aload 6
    //   1173: getfield 278	bbpe:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1176: invokestatic 283	bcgk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1179: invokevirtual 286	aqpu:a	(Ljava/lang/String;)Laopc;
    //   1182: astore 7
    //   1184: aload 6
    //   1186: getfield 288	bbpe:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1189: astore 4
    //   1191: aload 4
    //   1193: astore_1
    //   1194: aload 4
    //   1196: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1199: ifeq +9 -> 1208
    //   1202: aload 6
    //   1204: getfield 591	bbpe:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1207: astore_1
    //   1208: aload_1
    //   1209: astore 4
    //   1211: aload 5
    //   1213: getfield 292	com/tencent/mobileqq/data/MessageForTroopFile:isMultiMsg	Z
    //   1216: ifeq +20 -> 1236
    //   1219: aload_1
    //   1220: astore 4
    //   1222: aload_1
    //   1223: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1226: ifeq +10 -> 1236
    //   1229: aload 5
    //   1231: invokestatic 295	arni:a	(Lcom/tencent/mobileqq/data/ChatMessage;)Ljava/lang/String;
    //   1234: astore 4
    //   1236: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   1239: dup
    //   1240: aload 4
    //   1242: invokespecial 761	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   1245: astore 4
    //   1247: aload 4
    //   1249: aload 5
    //   1251: getfield 324	com/tencent/mobileqq/data/MessageForTroopFile:frienduin	Ljava/lang/String;
    //   1254: putfield 762	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1257: aload 4
    //   1259: aload 5
    //   1261: getfield 328	com/tencent/mobileqq/data/MessageForTroopFile:istroop	I
    //   1264: putfield 763	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Int	I
    //   1267: aload 4
    //   1269: aload 5
    //   1271: getfield 335	com/tencent/mobileqq/data/MessageForTroopFile:issend	I
    //   1274: putfield 764	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_d_of_type_Int	I
    //   1277: aload 4
    //   1279: aload 5
    //   1281: getfield 302	com/tencent/mobileqq/data/MessageForTroopFile:uniseq	J
    //   1284: putfield 767	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   1287: aload 4
    //   1289: aload 5
    //   1291: getfield 308	com/tencent/mobileqq/data/MessageForTroopFile:time	J
    //   1294: putfield 768	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   1297: aload 4
    //   1299: aload 5
    //   1301: getfield 313	com/tencent/mobileqq/data/MessageForTroopFile:shmsgseq	J
    //   1304: putfield 769	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   1307: aload 4
    //   1309: aload 5
    //   1311: getfield 318	com/tencent/mobileqq/data/MessageForTroopFile:fileSize	J
    //   1314: putfield 771	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   1317: aload 4
    //   1319: aload 5
    //   1321: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   1324: putfield 772	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1327: aload 4
    //   1329: aload 5
    //   1331: getfield 328	com/tencent/mobileqq/data/MessageForTroopFile:istroop	I
    //   1334: putfield 773	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   1337: aload 4
    //   1339: aload 7
    //   1341: getfield 776	aopc:jdField_b_of_type_Int	I
    //   1344: i2l
    //   1345: putfield 777	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   1348: aload 4
    //   1350: aload 5
    //   1352: getfield 344	com/tencent/mobileqq/data/MessageForTroopFile:width	I
    //   1355: putfield 796	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   1358: aload 4
    //   1360: aload 5
    //   1362: getfield 349	com/tencent/mobileqq/data/MessageForTroopFile:height	I
    //   1365: putfield 797	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   1368: aload 6
    //   1370: getfield 269	bbpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1373: invokestatic 273	bdcs:b	(Ljava/lang/String;)Z
    //   1376: ifeq +19 -> 1395
    //   1379: aload 4
    //   1381: aload 6
    //   1383: getfield 269	bbpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1386: putfield 778	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1389: aload 4
    //   1391: iconst_1
    //   1392: putfield 780	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   1395: aload 4
    //   1397: aload_0
    //   1398: getfield 704	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   1401: putfield 801	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   1404: goto -1163 -> 241
    //   1407: astore_0
    //   1408: goto -548 -> 860
    //   1411: astore_0
    //   1412: goto -552 -> 860
    //   1415: astore 4
    //   1417: aload 5
    //   1419: astore_1
    //   1420: goto -579 -> 841
    //   1423: aconst_null
    //   1424: astore_1
    //   1425: goto -946 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1428	0	paramChatMessage	com.tencent.mobileqq.data.ChatMessage
    //   0	1428	1	paramQQAppInterface	QQAppInterface
    //   718	12	2	i	int
    //   188	465	3	bool	boolean
    //   4	768	4	localObject1	Object
    //   839	3	4	localException1	Exception
    //   1189	207	4	localObject2	Object
    //   1415	1	4	localException2	Exception
    //   1	1417	5	localObject3	Object
    //   530	852	6	localObject4	Object
    //   23	1317	7	localObject5	Object
    //   47	761	8	localFileManagerEntity	com.tencent.mobileqq.filemanager.data.FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   680	719	839	java/lang/Exception
    //   732	752	839	java/lang/Exception
    //   816	836	839	java/lang/Exception
    //   672	680	857	finally
    //   680	719	1407	finally
    //   732	752	1407	finally
    //   816	836	1407	finally
    //   841	846	1411	finally
    //   672	680	1415	java/lang/Exception
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
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = abot.c(paramMessageForShortVideo);
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
      localAIOShortVideoData.jdField_g_of_type_JavaLangString = paramMessageForShortVideo.templateName;
      localAIOShortVideoData.m = alsh.b(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (apke)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(149);
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
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, ager paramager)
  {
    if (!CheckPermission.isHasStoragePermission(paramActivity)) {
      CheckPermission.requestStorePermission(paramActivity, null);
    }
    do
    {
      for (;;)
      {
        return;
        new File(aljq.bd).mkdirs();
        String str = paramString;
        if (paramString.indexOf(".") == -1)
        {
          str = bdcs.b(paramFile.getAbsolutePath());
          str = paramString + "." + str;
        }
        paramString = new File(aljq.bd, str);
        if (paramString.exists()) {
          break label145;
        }
        try
        {
          if (paramString.createNewFile())
          {
            b(paramActivity, paramFile, paramString, paramager);
            return;
          }
        }
        catch (IOException paramFile)
        {
          QQToast.a(paramActivity, paramActivity.getString(2131695348), 0).a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOGalleryUtils", 2, "", paramFile);
    return;
    label145:
    bdcd.a(paramActivity, 230).setTitle(paramActivity.getString(2131719323)).setMessage(paramActivity.getString(2131695341)).setPositiveButton(paramActivity.getString(2131719197), new ageo(paramActivity, paramFile, paramString, paramager)).setNegativeButton(paramActivity.getString(2131694804), new agen()).show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, agfq paramagfq, boolean paramBoolean, String paramString3)
  {
    if ((paramagfq == null) || (!AIOImageData.class.isInstance(paramagfq.a))) {
      return;
    }
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramagfq.a;
    paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
    if (!paramString1.endsWith("_hd"))
    {
      paramagfq = paramString1 + "_hd";
      if (new File(paramagfq).exists()) {
        paramString1 = paramagfq;
      }
    }
    for (;;)
    {
      paramagfq = localAIOImageData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOImageData.jdField_c_of_type_Long;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.jdField_d_of_type_Long;
      }
      bizm.a(paramActivity, localbizt, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramagfq, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<agfq> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (agfq)localIterator.next();
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
      bizm.a(paramActivity, localbizt, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    bizm.a(paramActivity, localbizt, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    bizm.a(paramActivity, localbizt, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new ageq(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = agej.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (apli)paramQQAppInterface.getManager(141);
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
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, ager paramager)
  {
    new agep(paramFile1, paramFile2, paramActivity, paramager).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = agej.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (apli)paramQQAppInterface.getManager(141);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agem
 * JD-Core Version:    0.7.0.1
 */