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

public class adwz
{
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    ancg localancg = (ancg)paramContext.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localancg.a();
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
        localancg.a((CustomEmotionData)((List)localObject).get(j), j);
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
      localancg.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajed.bL))) {
        awqx.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (anch)paramContext.getManager(103);
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
    Object localObject = (ancg)localQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((ancg)localObject).a();
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
            ((ancg)localObject).a((CustomEmotionData)localList.get(j), j);
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
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajed.bL))) {
      awqx.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new anbp(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (anch)localQQAppInterface.getManager(103);
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
    Object localObject = (ancg)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((ancg)localObject).a();
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
        ((ancg)localObject).a((CustomEmotionData)localList.get(j), j);
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
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajed.bL))) {
        awqx.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new anbp(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (anch)paramQQAppInterface.getManager(103);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    ayqd localayqd = azjg.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localayqd == null) {
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
          if (apck.a(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localayqd.jdField_b_of_type_Int != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localayqd.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
        return null;
        if ((localayqd.jdField_b_of_type_Int != 4) && (localayqd.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localayqd.jdField_a_of_type_JavaUtilUUID + " file is:" + localayqd.jdField_b_of_type_Int);
      return null;
      if ((!bace.b(localayqd.jdField_a_of_type_JavaLangString)) || ((localayqd.jdField_b_of_type_Int != 1) && (localayqd.jdField_b_of_type_Int != 2) && (localayqd.jdField_b_of_type_Int != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localayqd.jdField_a_of_type_JavaUtilUUID + " file is:" + localayqd.jdField_b_of_type_Int);
    return null;
    ((aofy)paramQQAppInterface.getManager(317)).a(azgh.a(localayqd.jdField_g_of_type_JavaLangString));
    Object localObject = localayqd.jdField_d_of_type_JavaLangString;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      apck.a(paramMessageForTroopFile);
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
    ((AIOFilePicData)localObject).jdField_h_of_type_JavaLangString = paramMessageForTroopFile.url;
    if (localayqd.jdField_b_of_type_Int == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = bool;
      ((AIOFilePicData)localObject).a(localayqd);
      ((AIOFilePicData)localObject).m = ajml.b(paramMessageForTroopFile);
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
    if (mnf.a(paramMessageForPic))
    {
      localObject1 = mnf.a(paramMessageForPic);
      if ((((mng)localObject1).jdField_a_of_type_JavaLangString != null) || (((mng)localObject1).jdField_a_of_type_Int == 2)) {
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
      localAIOImageData.jdField_a_of_type_JavaLangString = axoa.d(axwd.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label516;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = axoa.d(axwd.a(paramMessageForPic, 131075, null).toString());
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
      localAIOImageData.m = ajml.b(paramMessageForPic);
      return localAIOImageData;
      label438:
      Object localObject2 = ((mng)localObject1).a();
      if ((localObject2 == null) || (((mng)localObject1).jdField_a_of_type_Int == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      mnf.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.jdField_j_of_type_Boolean = true;
      localAIOImageData.n = mnf.a().a(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label516:
      localObject1 = axwd.a(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = axoa.d(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = axoa.e(((URL)localObject1).toString());
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
    ayqd localayqd = azjg.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localayqd.jdField_d_of_type_JavaLangString != null)
    {
      localObject = localayqd.jdField_d_of_type_JavaLangString;
      localAIOImageData.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (localAIOImageData.jdField_a_of_type_JavaLangString == null) {
        localAIOImageData.jdField_a_of_type_JavaLangString = "I:N";
      }
      if (!TextUtils.isEmpty(localayqd.jdField_c_of_type_JavaLangString)) {
        localAIOImageData.jdField_b_of_type_JavaLangString = localayqd.jdField_c_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(localayqd.jdField_a_of_type_JavaLangString)) && (bace.a(localayqd.jdField_a_of_type_JavaLangString))) {
        localAIOImageData.jdField_c_of_type_JavaLangString = localayqd.jdField_a_of_type_JavaLangString;
      }
      if (localayqd.jdField_b_of_type_Int != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool;
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localayqd.jdField_a_of_type_Int;
      try
      {
        localObject = adsh.a(paramQQAppInterface.getApplication(), localayqd, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = axwd.b();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = axwd.b();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = axwd.b();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_g_of_type_JavaLangString = localayqd.jdField_g_of_type_JavaLangString;
      localAIOImageData.jdField_h_of_type_JavaLangString = localayqd.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_e_of_type_Long = localayqd.jdField_c_of_type_Long;
      localAIOImageData.jdField_c_of_type_Int = localayqd.jdField_h_of_type_Int;
      localAIOImageData.jdField_b_of_type_Int = 3;
      return localAIOImageData;
      localObject = localayqd.jdField_b_of_type_JavaLangString;
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
    //   13: instanceof 665
    //   16: ifeq +775 -> 791
    //   19: aload_0
    //   20: checkcast 665	com/tencent/mobileqq/data/MessageForFile
    //   23: astore 7
    //   25: aload_1
    //   26: invokevirtual 668	com/tencent/mobileqq/app/QQAppInterface:a	()Laoig;
    //   29: aload 7
    //   31: getfield 669	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   34: aload 7
    //   36: getfield 670	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   39: aload 7
    //   41: getfield 671	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   44: invokevirtual 676	aoig:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   47: astore 8
    //   49: aload 8
    //   51: ifnull -41 -> 10
    //   54: aload 8
    //   56: getfield 681	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   59: ifne +159 -> 218
    //   62: new 297	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   65: dup
    //   66: invokespecial 298	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: aload 7
    //   75: getfield 669	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   78: putfield 305	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   81: aload 4
    //   83: aload 7
    //   85: getfield 682	com/tencent/mobileqq/data/MessageForFile:time	J
    //   88: putfield 310	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   91: aload 4
    //   93: aload 7
    //   95: getfield 683	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   98: putfield 315	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_Long	J
    //   101: aload 4
    //   103: aload 7
    //   105: getfield 684	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   108: putfield 321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_Long	J
    //   111: aload 4
    //   113: aload 7
    //   115: getfield 670	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   118: putfield 325	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload 4
    //   123: aload 7
    //   125: getfield 671	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   128: putfield 330	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Int	I
    //   131: aload 4
    //   133: aload_1
    //   134: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   137: putfield 332	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload 4
    //   142: aload 7
    //   144: getfield 685	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   147: putfield 336	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_b_of_type_Int	I
    //   150: aload 4
    //   152: aload_0
    //   153: getfield 688	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   156: putfield 338	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Int	I
    //   159: aload 4
    //   161: aload_0
    //   162: getfield 689	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   165: putfield 341	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_k_of_type_Boolean	Z
    //   168: aload 4
    //   170: aload 8
    //   172: getfield 692	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   175: putfield 346	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload 8
    //   180: getfield 695	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   183: iconst_2
    //   184: if_icmpne +29 -> 213
    //   187: iconst_1
    //   188: istore_3
    //   189: aload 4
    //   191: iload_3
    //   192: putfield 348	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   195: aload 4
    //   197: aload_1
    //   198: invokevirtual 698	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   201: aload 4
    //   203: aload_0
    //   204: invokestatic 356	ajml:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   207: putfield 701	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:m	Z
    //   210: aload 4
    //   212: areturn
    //   213: iconst_0
    //   214: istore_3
    //   215: goto -26 -> 189
    //   218: aload 8
    //   220: getfield 681	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   223: iconst_2
    //   224: if_icmpne +556 -> 780
    //   227: aload 8
    //   229: getfield 695	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   232: bipush 16
    //   234: if_icmpne +47 -> 281
    //   237: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -230 -> 10
    //   243: ldc_w 703
    //   246: iconst_1
    //   247: new 241	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   254: ldc 244
    //   256: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 8
    //   261: getfield 706	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   264: invokevirtual 709	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: ldc_w 711
    //   270: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aconst_null
    //   280: areturn
    //   281: aload 8
    //   283: invokevirtual 714	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   286: ifeq +47 -> 333
    //   289: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -282 -> 10
    //   295: ldc_w 703
    //   298: iconst_1
    //   299: new 241	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   306: ldc 244
    //   308: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 8
    //   313: getfield 706	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   316: invokevirtual 709	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc_w 716
    //   322: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aconst_null
    //   332: areturn
    //   333: aload 8
    //   335: invokevirtual 719	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   338: invokestatic 273	bace:b	(Ljava/lang/String;)Z
    //   341: istore_3
    //   342: iload_3
    //   343: ifeq +56 -> 399
    //   346: aload 8
    //   348: getfield 695	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   351: iconst_1
    //   352: if_icmpeq +47 -> 399
    //   355: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq -348 -> 10
    //   361: ldc_w 703
    //   364: iconst_1
    //   365: new 241	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   372: ldc 244
    //   374: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 8
    //   379: getfield 706	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   382: invokevirtual 709	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc_w 721
    //   388: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aconst_null
    //   398: areturn
    //   399: aload_1
    //   400: sipush 317
    //   403: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   406: checkcast 275	aofy
    //   409: aload 8
    //   411: getfield 722	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   414: invokestatic 283	azgh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokevirtual 286	aofy:a	(Ljava/lang/String;)Lamhq;
    //   420: astore 4
    //   422: aload 8
    //   424: getfield 725	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   427: invokestatic 728	apdh:b	(Ljava/lang/String;)Z
    //   430: ifeq +256 -> 686
    //   433: aload 8
    //   435: getfield 725	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   438: astore_1
    //   439: aload_1
    //   440: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifeq +39 -> 482
    //   446: ldc 44
    //   448: iconst_1
    //   449: new 241	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 730
    //   459: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 8
    //   464: getfield 706	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   467: invokevirtual 709	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 732
    //   473: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   485: dup
    //   486: aload_1
    //   487: invokespecial 733	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   490: astore 6
    //   492: aload 6
    //   494: aload 7
    //   496: getfield 669	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   499: putfield 734	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   502: aload 6
    //   504: aload 7
    //   506: getfield 682	com/tencent/mobileqq/data/MessageForFile:time	J
    //   509: putfield 735	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   512: aload 6
    //   514: aload 7
    //   516: getfield 683	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   519: putfield 736	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   522: aload 6
    //   524: aload 8
    //   526: getfield 737	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   529: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   532: aload 6
    //   534: aload 8
    //   536: getfield 722	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   539: putfield 739	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   542: aload 6
    //   544: aload_0
    //   545: getfield 688	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   548: putfield 740	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   551: aload 6
    //   553: aload 4
    //   555: getfield 743	amhq:jdField_b_of_type_Int	I
    //   558: i2l
    //   559: putfield 744	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   562: iload_3
    //   563: ifeq +107 -> 670
    //   566: aload 6
    //   568: aload 8
    //   570: invokevirtual 719	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   573: putfield 745	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   576: aload 6
    //   578: iconst_1
    //   579: putfield 747	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   582: new 749	android/media/MediaMetadataRetriever
    //   585: dup
    //   586: invokespecial 750	android/media/MediaMetadataRetriever:<init>	()V
    //   589: astore_1
    //   590: aload_1
    //   591: aload 6
    //   593: getfield 745	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   596: invokevirtual 753	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   599: aload_1
    //   600: bipush 24
    //   602: invokevirtual 757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   605: astore 4
    //   607: aload_1
    //   608: bipush 19
    //   610: invokevirtual 757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   613: astore 5
    //   615: aload_1
    //   616: bipush 18
    //   618: invokevirtual 757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   621: astore 7
    //   623: aload 4
    //   625: invokestatic 762	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   628: istore_2
    //   629: iload_2
    //   630: bipush 90
    //   632: if_icmpeq +10 -> 642
    //   635: iload_2
    //   636: sipush 270
    //   639: if_icmpne +87 -> 726
    //   642: aload 6
    //   644: aload 5
    //   646: invokestatic 762	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   649: putfield 763	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   652: aload 6
    //   654: aload 7
    //   656: invokestatic 762	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   659: putfield 764	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   662: aload_1
    //   663: ifnull +7 -> 670
    //   666: aload_1
    //   667: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   670: aload 6
    //   672: aload_0
    //   673: getfield 689	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   676: putfield 768	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   679: aload 6
    //   681: astore 4
    //   683: goto -482 -> 201
    //   686: aload 8
    //   688: getfield 771	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   691: invokestatic 728	apdh:b	(Ljava/lang/String;)Z
    //   694: ifeq +12 -> 706
    //   697: aload 8
    //   699: getfield 771	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   702: astore_1
    //   703: goto -264 -> 439
    //   706: aload 8
    //   708: getfield 774	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   711: invokestatic 728	apdh:b	(Ljava/lang/String;)Z
    //   714: ifeq +589 -> 1303
    //   717: aload 8
    //   719: getfield 774	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   722: astore_1
    //   723: goto -284 -> 439
    //   726: aload 6
    //   728: aload 7
    //   730: invokestatic 762	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   733: putfield 763	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   736: aload 6
    //   738: aload 5
    //   740: invokestatic 762	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   743: putfield 764	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   746: goto -84 -> 662
    //   749: astore 4
    //   751: aload 4
    //   753: invokevirtual 777	java/lang/Exception:printStackTrace	()V
    //   756: aload_1
    //   757: ifnull -87 -> 670
    //   760: aload_1
    //   761: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   764: goto -94 -> 670
    //   767: astore_0
    //   768: aconst_null
    //   769: astore_1
    //   770: aload_1
    //   771: ifnull +7 -> 778
    //   774: aload_1
    //   775: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   778: aload_0
    //   779: athrow
    //   780: ldc 44
    //   782: iconst_1
    //   783: ldc 230
    //   785: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   788: goto -587 -> 201
    //   791: aload_0
    //   792: instanceof 220
    //   795: ifeq -594 -> 201
    //   798: aload_0
    //   799: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   802: astore 5
    //   804: aload_1
    //   805: aload 5
    //   807: invokestatic 211	azjg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForTroopFile;)Layqd;
    //   810: astore 6
    //   812: aload 6
    //   814: ifnonnull +19 -> 833
    //   817: invokestatic 214	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   820: ifeq -810 -> 10
    //   823: ldc 44
    //   825: iconst_4
    //   826: ldc 216
    //   828: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aconst_null
    //   832: areturn
    //   833: aload_0
    //   834: checkcast 220	com/tencent/mobileqq/data/MessageForTroopFile
    //   837: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   840: invokestatic 228	apck:a	(Ljava/lang/String;)I
    //   843: iconst_2
    //   844: if_icmpeq +13 -> 857
    //   847: ldc 44
    //   849: iconst_1
    //   850: ldc 230
    //   852: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   855: aconst_null
    //   856: areturn
    //   857: aload 6
    //   859: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   862: bipush 12
    //   864: if_icmpne +47 -> 911
    //   867: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq -860 -> 10
    //   873: ldc_w 703
    //   876: iconst_1
    //   877: new 241	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   884: ldc 244
    //   886: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload 6
    //   891: getfield 251	ayqd:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   894: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   897: ldc_w 256
    //   900: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   909: aconst_null
    //   910: areturn
    //   911: aload 6
    //   913: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   916: iconst_4
    //   917: if_icmpeq +12 -> 929
    //   920: aload 6
    //   922: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   925: iconst_5
    //   926: if_icmpne +55 -> 981
    //   929: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq -922 -> 10
    //   935: ldc_w 703
    //   938: iconst_1
    //   939: new 241	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   946: ldc 244
    //   948: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload 6
    //   953: getfield 251	ayqd:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   956: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   959: ldc_w 264
    //   962: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload 6
    //   967: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   970: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   973: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: aconst_null
    //   980: areturn
    //   981: aload 6
    //   983: getfield 269	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   986: invokestatic 273	bace:b	(Ljava/lang/String;)Z
    //   989: ifeq +82 -> 1071
    //   992: aload 6
    //   994: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   997: iconst_1
    //   998: if_icmpeq +21 -> 1019
    //   1001: aload 6
    //   1003: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   1006: iconst_2
    //   1007: if_icmpeq +12 -> 1019
    //   1010: aload 6
    //   1012: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   1015: iconst_3
    //   1016: if_icmpne +55 -> 1071
    //   1019: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq -1012 -> 10
    //   1025: ldc_w 703
    //   1028: iconst_1
    //   1029: new 241	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1036: ldc 244
    //   1038: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 6
    //   1043: getfield 251	ayqd:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1046: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 264
    //   1052: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 6
    //   1057: getfield 237	ayqd:jdField_b_of_type_Int	I
    //   1060: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1069: aconst_null
    //   1070: areturn
    //   1071: aload_1
    //   1072: sipush 317
    //   1075: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1078: checkcast 275	aofy
    //   1081: aload 6
    //   1083: getfield 278	ayqd:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1086: invokestatic 283	azgh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1089: invokevirtual 286	aofy:a	(Ljava/lang/String;)Lamhq;
    //   1092: astore 7
    //   1094: aload 6
    //   1096: getfield 288	ayqd:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1099: astore 4
    //   1101: aload 4
    //   1103: astore_1
    //   1104: aload 4
    //   1106: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1109: ifeq +9 -> 1118
    //   1112: aload 6
    //   1114: getfield 574	ayqd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1117: astore_1
    //   1118: aload_1
    //   1119: astore 4
    //   1121: aload 5
    //   1123: getfield 292	com/tencent/mobileqq/data/MessageForTroopFile:isMultiMsg	Z
    //   1126: ifeq +20 -> 1146
    //   1129: aload_1
    //   1130: astore 4
    //   1132: aload_1
    //   1133: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1136: ifeq +10 -> 1146
    //   1139: aload 5
    //   1141: invokestatic 295	apck:a	(Lcom/tencent/mobileqq/data/ChatMessage;)Ljava/lang/String;
    //   1144: astore 4
    //   1146: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   1149: dup
    //   1150: aload 4
    //   1152: invokespecial 733	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   1155: astore 4
    //   1157: aload 4
    //   1159: aload 5
    //   1161: getfield 302	com/tencent/mobileqq/data/MessageForTroopFile:uniseq	J
    //   1164: putfield 734	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   1167: aload 4
    //   1169: aload 5
    //   1171: getfield 308	com/tencent/mobileqq/data/MessageForTroopFile:time	J
    //   1174: putfield 735	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   1177: aload 4
    //   1179: aload 5
    //   1181: getfield 313	com/tencent/mobileqq/data/MessageForTroopFile:shmsgseq	J
    //   1184: putfield 736	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   1187: aload 4
    //   1189: aload 5
    //   1191: getfield 318	com/tencent/mobileqq/data/MessageForTroopFile:fileSize	J
    //   1194: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   1197: aload 4
    //   1199: aload 5
    //   1201: getfield 223	com/tencent/mobileqq/data/MessageForTroopFile:fileName	Ljava/lang/String;
    //   1204: putfield 739	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1207: aload 4
    //   1209: aload 5
    //   1211: getfield 328	com/tencent/mobileqq/data/MessageForTroopFile:istroop	I
    //   1214: putfield 740	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   1217: aload 4
    //   1219: aload 7
    //   1221: getfield 743	amhq:jdField_b_of_type_Int	I
    //   1224: i2l
    //   1225: putfield 744	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   1228: aload 4
    //   1230: aload 5
    //   1232: getfield 779	com/tencent/mobileqq/data/MessageForTroopFile:width	I
    //   1235: putfield 763	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   1238: aload 4
    //   1240: aload 5
    //   1242: getfield 781	com/tencent/mobileqq/data/MessageForTroopFile:height	I
    //   1245: putfield 764	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   1248: aload 6
    //   1250: getfield 269	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1253: invokestatic 273	bace:b	(Ljava/lang/String;)Z
    //   1256: ifeq +19 -> 1275
    //   1259: aload 4
    //   1261: aload 6
    //   1263: getfield 269	ayqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1266: putfield 745	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1269: aload 4
    //   1271: iconst_1
    //   1272: putfield 747	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   1275: aload 4
    //   1277: aload_0
    //   1278: getfield 689	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   1281: putfield 768	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   1284: goto -1083 -> 201
    //   1287: astore_0
    //   1288: goto -518 -> 770
    //   1291: astore_0
    //   1292: goto -522 -> 770
    //   1295: astore 4
    //   1297: aload 5
    //   1299: astore_1
    //   1300: goto -549 -> 751
    //   1303: aconst_null
    //   1304: astore_1
    //   1305: goto -866 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1308	0	paramChatMessage	com.tencent.mobileqq.data.ChatMessage
    //   0	1308	1	paramQQAppInterface	QQAppInterface
    //   628	12	2	i	int
    //   188	375	3	bool	boolean
    //   4	678	4	localObject1	Object
    //   749	3	4	localException1	Exception
    //   1099	177	4	localObject2	Object
    //   1295	1	4	localException2	Exception
    //   1	1297	5	localObject3	Object
    //   490	772	6	localObject4	Object
    //   23	1197	7	localObject5	Object
    //   47	671	8	localFileManagerEntity	com.tencent.mobileqq.filemanager.data.FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   590	629	749	java/lang/Exception
    //   642	662	749	java/lang/Exception
    //   726	746	749	java/lang/Exception
    //   582	590	767	finally
    //   590	629	1287	finally
    //   642	662	1287	finally
    //   726	746	1287	finally
    //   751	756	1291	finally
    //   582	590	1295	java/lang/Exception
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
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = akbm.c(paramMessageForShortVideo);
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
      localAIOShortVideoData.m = ajml.b(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (ancg)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(149);
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
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = paramString1;
    bfpr.a(paramActivity, localbfpy, paramIntent, paramString2, paramString3, paramString4, paramString5, paramInt1, paramArrayList, 7001, paramInt2);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, adxe paramadxe)
  {
    new File(ajed.ba).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = bace.b(paramFile.getAbsolutePath());
      str = paramString + "." + str;
    }
    paramString = new File(ajed.ba, str);
    if (!paramString.exists()) {
      try
      {
        if (paramString.createNewFile()) {
          b(paramActivity, paramFile, paramString, paramadxe);
        }
        return;
      }
      catch (IOException paramFile)
      {
        do
        {
          bbmy.a(paramActivity, paramActivity.getString(2131629508), 0).a();
        } while (!QLog.isColorLevel());
        QLog.e("AIOGalleryUtils", 2, "", paramFile);
        return;
      }
    }
    babr.a(paramActivity, 230).setTitle(paramActivity.getString(2131653010)).setMessage(paramActivity.getString(2131629501)).setPositiveButton(paramActivity.getString(2131652888), new adxb(paramActivity, paramFile, paramString, paramadxe)).setNegativeButton(paramActivity.getString(2131628983), new adxa()).show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, adyb paramadyb, boolean paramBoolean, String paramString3)
  {
    if ((paramadyb == null) || (!AIOImageData.class.isInstance(paramadyb.a))) {
      return;
    }
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramadyb.a;
    paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
    if (!paramString1.endsWith("_hd"))
    {
      paramadyb = paramString1 + "_hd";
      if (new File(paramadyb).exists()) {
        paramString1 = paramadyb;
      }
    }
    for (;;)
    {
      paramadyb = localAIOImageData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOImageData.jdField_c_of_type_Long;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.jdField_d_of_type_Long;
      }
      bfpr.a(paramActivity, localbfpy, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramadyb, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<adyb> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (adyb)localIterator.next();
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
      bfpr.a(paramActivity, localbfpy, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    bfpr.a(paramActivity, localbfpy, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    bfpr.a(paramActivity, localbfpy, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new adxd(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = adww.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (andn)paramQQAppInterface.getManager(141);
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
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, adxe paramadxe)
  {
    new adxc(paramFile1, paramFile2, paramActivity, paramadxe).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = adww.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (andn)paramQQAppInterface.getManager(141);
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
 * Qualified Name:     adwz
 * JD-Core Version:    0.7.0.1
 */