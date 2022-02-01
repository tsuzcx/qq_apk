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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForFile;
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
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ahth
{
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    arro localarro = (arro)paramContext.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localarro.a();
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
        localarro.a((CustomEmotionData)((List)localObject).get(j), j);
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
      localarro.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(anhk.bX))) {
        bcst.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (arrp)paramContext.getManager(103);
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
    Object localObject = (arro)localQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((arro)localObject).a();
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
            ((arro)localObject).a((CustomEmotionData)localList.get(j), j);
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
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(anhk.bX))) {
      bcst.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new arqx(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (arrp)localQQAppInterface.getManager(103);
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
    Object localObject = (arro)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((arro)localObject).a();
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
        ((arro)localObject).a((CustomEmotionData)localList.get(j), j);
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
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(anhk.bX))) {
        bcst.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new arqx(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (arrp)paramQQAppInterface.getManager(103);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    bety localbety = bfsj.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localbety == null) {
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
          if (atvo.a(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localbety.jdField_b_of_type_Int != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
        return null;
        if ((localbety.jdField_b_of_type_Int != 4) && (localbety.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is:" + localbety.jdField_b_of_type_Int);
      return null;
      if ((!bgmg.b(localbety.jdField_a_of_type_JavaLangString)) || ((localbety.jdField_b_of_type_Int != 1) && (localbety.jdField_b_of_type_Int != 2) && (localbety.jdField_b_of_type_Int != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is:" + localbety.jdField_b_of_type_Int);
    return null;
    ((atam)paramQQAppInterface.getManager(317)).a(bfpj.a(localbety.jdField_g_of_type_JavaLangString));
    Object localObject = localbety.jdField_d_of_type_JavaLangString;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      atvo.a(paramMessageForTroopFile);
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
    ((AIOFilePicData)localObject).jdField_e_of_type_Int = localbety.j;
    ((AIOFilePicData)localObject).jdField_h_of_type_JavaLangString = paramMessageForTroopFile.url;
    if (localbety.jdField_b_of_type_Int == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = bool;
      ((AIOFilePicData)localObject).a(localbety);
      ((AIOFilePicData)localObject).m = anqc.b(paramMessageForTroopFile);
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
    if (njo.a(paramMessageForPic))
    {
      localObject1 = njo.a(paramMessageForPic);
      if ((((njp)localObject1).jdField_a_of_type_JavaLangString != null) || (((njp)localObject1).jdField_a_of_type_Int == 2)) {
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
      localAIOImageData.jdField_a_of_type_JavaLangString = bdsh.d(bdzx.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label515;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = bdsh.d(bdzx.a(paramMessageForPic, 131075, null).toString());
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
      localAIOImageData.m = anqc.b(paramMessageForPic);
      return localAIOImageData;
      label437:
      Object localObject2 = ((njp)localObject1).a();
      if ((localObject2 == null) || (((njp)localObject1).jdField_a_of_type_Int == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      njo.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.jdField_j_of_type_Boolean = true;
      localAIOImageData.n = njo.a().a(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label515:
      localObject1 = bdzx.a(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = bdsh.d(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = bdsh.e(((URL)localObject1).toString());
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
    bety localbety = bfsj.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localbety.jdField_d_of_type_JavaLangString != null)
    {
      localObject = localbety.jdField_d_of_type_JavaLangString;
      localAIOImageData.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (localAIOImageData.jdField_a_of_type_JavaLangString == null) {
        localAIOImageData.jdField_a_of_type_JavaLangString = "I:N";
      }
      if (!TextUtils.isEmpty(localbety.jdField_c_of_type_JavaLangString)) {
        localAIOImageData.jdField_b_of_type_JavaLangString = localbety.jdField_c_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(localbety.jdField_a_of_type_JavaLangString)) && (bgmg.a(localbety.jdField_a_of_type_JavaLangString))) {
        localAIOImageData.jdField_c_of_type_JavaLangString = localbety.jdField_a_of_type_JavaLangString;
      }
      if (localbety.jdField_b_of_type_Int != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool;
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localbety.jdField_a_of_type_Int;
      try
      {
        localObject = ahlz.a(paramQQAppInterface.getApplication(), localbety, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = bdzx.b();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = bdzx.b();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = bdzx.b();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_g_of_type_JavaLangString = localbety.jdField_g_of_type_JavaLangString;
      localAIOImageData.jdField_h_of_type_JavaLangString = localbety.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_e_of_type_Long = localbety.jdField_c_of_type_Long;
      localAIOImageData.jdField_c_of_type_Int = localbety.jdField_h_of_type_Int;
      localAIOImageData.jdField_b_of_type_Int = 3;
      return localAIOImageData;
      localObject = localbety.jdField_b_of_type_JavaLangString;
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
  
  public static AIORichMediaData a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramChatMessage == null)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      return paramQQAppInterface;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      localObject1 = b(paramChatMessage, paramQQAppInterface);
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localObject1 == null) {
        break;
      }
      QLog.i("AIOGalleryUtils<QFile>", 1, "toAIOFileMediaData: media data is null.");
      ((AIORichMediaData)localObject1).m = anqc.b(paramChatMessage);
      return localObject1;
      localObject1 = localObject2;
      if ((paramChatMessage instanceof MessageForTroopFile)) {
        localObject1 = c(paramChatMessage, paramQQAppInterface);
      }
    }
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
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = acwh.c(paramMessageForShortVideo);
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
      localAIOShortVideoData.m = anqc.b(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (arro)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(149);
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
    baxi.a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, ahui paramahui, boolean paramBoolean, String paramString3)
  {
    if ((paramahui == null) || (!AIOImageData.class.isInstance(paramahui.a))) {
      return;
    }
    blsi localblsi = blsi.a();
    localblsi.jdField_a_of_type_JavaLangString = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramahui.a;
    paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
    if (!paramString1.endsWith("_hd"))
    {
      paramahui = paramString1 + "_hd";
      if (new File(paramahui).exists()) {
        paramString1 = paramahui;
      }
    }
    for (;;)
    {
      paramahui = localAIOImageData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOImageData.jdField_c_of_type_Long;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.jdField_d_of_type_Long;
      }
      blsb.a(paramActivity, localblsi, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramahui, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<ahui> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    blsi localblsi = blsi.a();
    localblsi.jdField_a_of_type_JavaLangString = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (ahui)localIterator.next();
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
      blsb.a(paramActivity, localblsi, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    blsi localblsi = blsi.a();
    localblsi.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    blsb.a(paramActivity, localblsi, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    blsi localblsi = blsi.a();
    localblsi.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    blsb.a(paramActivity, localblsi, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new ahti(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = ahte.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (arss)paramQQAppInterface.getManager(141);
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
  
  /* Error */
  private static AIORichMediaData b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: checkcast 680	com/tencent/mobileqq/data/MessageForFile
    //   7: astore 4
    //   9: aload_1
    //   10: invokevirtual 894	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   13: aload 4
    //   15: getfield 895	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   18: aload 4
    //   20: getfield 896	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   23: aload 4
    //   25: getfield 897	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   28: invokevirtual 902	atcv:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnonnull +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: aload 7
    //   42: getfield 907	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   45: ifne +190 -> 235
    //   48: new 297	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   51: dup
    //   52: invokespecial 298	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: aload 4
    //   61: getfield 895	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   64: putfield 305	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   67: aload 5
    //   69: aload 4
    //   71: getfield 908	com/tencent/mobileqq/data/MessageForFile:time	J
    //   74: putfield 310	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   77: aload 5
    //   79: aload 4
    //   81: getfield 909	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   84: putfield 315	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_Long	J
    //   87: aload 5
    //   89: aload 4
    //   91: getfield 910	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   94: putfield 321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_Long	J
    //   97: aload 5
    //   99: aload 4
    //   101: getfield 896	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   104: putfield 325	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: aload 5
    //   109: aload 4
    //   111: getfield 897	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   114: putfield 330	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Int	I
    //   117: aload 5
    //   119: aload_1
    //   120: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   123: putfield 332	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload 5
    //   128: aload 4
    //   130: getfield 911	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   133: putfield 336	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_b_of_type_Int	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 914	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   142: putfield 338	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Int	I
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 915	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   151: putfield 341	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_k_of_type_Boolean	Z
    //   154: aload 5
    //   156: aload 7
    //   158: getfield 918	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   161: putfield 361	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload 7
    //   166: getfield 921	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   169: iconst_2
    //   170: if_icmpne +60 -> 230
    //   173: iconst_1
    //   174: istore_3
    //   175: aload 5
    //   177: iload_3
    //   178: putfield 363	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   181: aload 5
    //   183: aload 7
    //   185: getfield 924	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   188: putfield 925	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload 5
    //   193: aload 7
    //   195: getfield 928	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   198: putfield 346	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_Int	I
    //   201: aload 5
    //   203: aload 7
    //   205: getfield 931	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   208: putfield 351	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Int	I
    //   211: aload 5
    //   213: aload 7
    //   215: getfield 934	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   218: putfield 356	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_e_of_type_Int	I
    //   221: aload 5
    //   223: aload_1
    //   224: invokevirtual 937	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   227: aload 5
    //   229: areturn
    //   230: iconst_0
    //   231: istore_3
    //   232: goto -57 -> 175
    //   235: aload 7
    //   237: getfield 907	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   240: iconst_2
    //   241: if_icmpne +602 -> 843
    //   244: aload 7
    //   246: getfield 921	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   249: bipush 16
    //   251: if_icmpne +47 -> 298
    //   254: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -219 -> 38
    //   260: ldc_w 939
    //   263: iconst_1
    //   264: new 241	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   271: ldc 244
    //   273: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 7
    //   278: getfield 942	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   281: invokevirtual 825	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: ldc_w 944
    //   287: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aconst_null
    //   297: areturn
    //   298: aload 7
    //   300: invokevirtual 947	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   303: ifeq +47 -> 350
    //   306: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -271 -> 38
    //   312: ldc_w 939
    //   315: iconst_1
    //   316: new 241	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   323: ldc 244
    //   325: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 7
    //   330: getfield 942	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   333: invokevirtual 825	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc_w 949
    //   339: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: areturn
    //   350: aload 7
    //   352: invokevirtual 952	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   355: invokestatic 273	bgmg:b	(Ljava/lang/String;)Z
    //   358: istore_3
    //   359: iload_3
    //   360: ifeq +56 -> 416
    //   363: aload 7
    //   365: getfield 921	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   368: iconst_1
    //   369: if_icmpeq +47 -> 416
    //   372: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -337 -> 38
    //   378: ldc_w 939
    //   381: iconst_1
    //   382: new 241	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   389: ldc 244
    //   391: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 7
    //   396: getfield 942	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   399: invokevirtual 825	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: ldc_w 954
    //   405: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aconst_null
    //   415: areturn
    //   416: aload_1
    //   417: sipush 317
    //   420: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   423: checkcast 275	atam
    //   426: aload 7
    //   428: getfield 955	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   431: invokestatic 283	bfpj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 286	atam:a	(Ljava/lang/String;)Laqvx;
    //   437: astore 8
    //   439: aload 7
    //   441: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   444: invokestatic 961	atwl:b	(Ljava/lang/String;)Z
    //   447: ifeq +302 -> 749
    //   450: aload 7
    //   452: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   455: astore_1
    //   456: aload_1
    //   457: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifeq +39 -> 499
    //   463: ldc 44
    //   465: iconst_1
    //   466: new 241	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 963
    //   476: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 7
    //   481: getfield 942	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   484: invokevirtual 825	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc_w 965
    //   490: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 262	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: new 200	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 966	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   507: astore 6
    //   509: aload 6
    //   511: aload 4
    //   513: getfield 896	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   516: putfield 967	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   519: aload 6
    //   521: aload 4
    //   523: getfield 897	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   526: putfield 968	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Int	I
    //   529: aload 6
    //   531: aload 4
    //   533: getfield 911	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   536: putfield 969	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_d_of_type_Int	I
    //   539: aload 6
    //   541: aload 7
    //   543: getfield 918	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   546: putfield 970	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   549: aload 6
    //   551: aload 7
    //   553: getfield 924	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   556: putfield 971	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   559: aload 6
    //   561: aload 4
    //   563: getfield 895	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   566: putfield 972	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   569: aload 6
    //   571: aload 4
    //   573: getfield 908	com/tencent/mobileqq/data/MessageForFile:time	J
    //   576: putfield 973	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   579: aload 6
    //   581: aload 4
    //   583: getfield 909	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   586: putfield 974	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   589: aload 6
    //   591: aload 7
    //   593: getfield 975	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   596: putfield 976	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   599: aload 6
    //   601: aload 7
    //   603: getfield 955	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   606: putfield 977	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: aload 6
    //   611: aload_0
    //   612: getfield 914	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   615: putfield 978	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   618: aload 6
    //   620: aload 8
    //   622: getfield 981	aqvx:jdField_b_of_type_Int	I
    //   625: i2l
    //   626: putfield 982	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   629: iload_3
    //   630: ifeq +107 -> 737
    //   633: aload 6
    //   635: aload 7
    //   637: invokevirtual 952	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   640: putfield 983	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   643: aload 6
    //   645: iconst_1
    //   646: putfield 985	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   649: new 987	android/media/MediaMetadataRetriever
    //   652: dup
    //   653: invokespecial 988	android/media/MediaMetadataRetriever:<init>	()V
    //   656: astore_1
    //   657: aload_1
    //   658: aload 6
    //   660: getfield 983	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   663: invokevirtual 991	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   666: aload_1
    //   667: bipush 24
    //   669: invokevirtual 995	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   672: astore 4
    //   674: aload_1
    //   675: bipush 19
    //   677: invokevirtual 995	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   680: astore 5
    //   682: aload_1
    //   683: bipush 18
    //   685: invokevirtual 995	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   688: astore 7
    //   690: aload 4
    //   692: invokestatic 1000	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   695: istore_2
    //   696: iload_2
    //   697: bipush 90
    //   699: if_icmpeq +10 -> 709
    //   702: iload_2
    //   703: sipush 270
    //   706: if_icmpne +83 -> 789
    //   709: aload 6
    //   711: aload 5
    //   713: invokestatic 1000	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   716: putfield 1001	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   719: aload 6
    //   721: aload 7
    //   723: invokestatic 1000	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   726: putfield 1002	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   729: aload_1
    //   730: ifnull +7 -> 737
    //   733: aload_1
    //   734: invokevirtual 1005	android/media/MediaMetadataRetriever:release	()V
    //   737: aload 6
    //   739: aload_0
    //   740: getfield 915	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   743: putfield 1006	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   746: aload 6
    //   748: areturn
    //   749: aload 7
    //   751: getfield 1009	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   754: invokestatic 961	atwl:b	(Ljava/lang/String;)Z
    //   757: ifeq +12 -> 769
    //   760: aload 7
    //   762: getfield 1009	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   765: astore_1
    //   766: goto -310 -> 456
    //   769: aload 7
    //   771: getfield 1012	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   774: invokestatic 961	atwl:b	(Ljava/lang/String;)Z
    //   777: ifeq +92 -> 869
    //   780: aload 7
    //   782: getfield 1012	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   785: astore_1
    //   786: goto -330 -> 456
    //   789: aload 6
    //   791: aload 7
    //   793: invokestatic 1000	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   796: putfield 1001	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   799: aload 6
    //   801: aload 5
    //   803: invokestatic 1000	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   806: putfield 1002	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   809: goto -80 -> 729
    //   812: astore 4
    //   814: aload 4
    //   816: invokevirtual 1015	java/lang/Exception:printStackTrace	()V
    //   819: aload_1
    //   820: ifnull -83 -> 737
    //   823: aload_1
    //   824: invokevirtual 1005	android/media/MediaMetadataRetriever:release	()V
    //   827: goto -90 -> 737
    //   830: astore_0
    //   831: aconst_null
    //   832: astore_1
    //   833: aload_1
    //   834: ifnull +7 -> 841
    //   837: aload_1
    //   838: invokevirtual 1005	android/media/MediaMetadataRetriever:release	()V
    //   841: aload_0
    //   842: athrow
    //   843: ldc 44
    //   845: iconst_1
    //   846: ldc 230
    //   848: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: aconst_null
    //   852: areturn
    //   853: astore_0
    //   854: goto -21 -> 833
    //   857: astore_0
    //   858: goto -25 -> 833
    //   861: astore 4
    //   863: aload 5
    //   865: astore_1
    //   866: goto -52 -> 814
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -415 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	paramChatMessage	ChatMessage
    //   0	874	1	paramQQAppInterface	QQAppInterface
    //   695	12	2	i	int
    //   174	456	3	bool	boolean
    //   7	684	4	localObject1	Object
    //   812	3	4	localException1	Exception
    //   861	1	4	localException2	Exception
    //   1	863	5	localObject2	Object
    //   507	293	6	localAIOFileVideoData	AIOFileVideoData
    //   31	761	7	localObject3	Object
    //   437	184	8	localaqvx	aqvx
    // Exception table:
    //   from	to	target	type
    //   657	696	812	java/lang/Exception
    //   709	729	812	java/lang/Exception
    //   789	809	812	java/lang/Exception
    //   649	657	830	finally
    //   657	696	853	finally
    //   709	729	853	finally
    //   789	809	853	finally
    //   814	819	857	finally
    //   649	657	861	java/lang/Exception
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = ahte.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (arss)paramQQAppInterface.getManager(141);
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
  
  private static AIORichMediaData c(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    bety localbety = bfsj.a(paramQQAppInterface, localMessageForTroopFile);
    if (localbety == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
      return null;
    }
    if (atvo.a(((MessageForTroopFile)paramChatMessage).fileName) != 2)
    {
      QLog.e("AIOGalleryUtils", 1, "unknow file Type");
      return null;
    }
    if (localbety.jdField_b_of_type_Int == 12)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
      }
      return null;
    }
    if ((localbety.jdField_b_of_type_Int == 4) || (localbety.jdField_b_of_type_Int == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is:" + localbety.jdField_b_of_type_Int);
      }
      return null;
    }
    if ((bgmg.b(localbety.jdField_a_of_type_JavaLangString)) && ((localbety.jdField_b_of_type_Int == 1) || (localbety.jdField_b_of_type_Int == 2) || (localbety.jdField_b_of_type_Int == 3)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localbety.jdField_a_of_type_JavaUtilUUID + " file is:" + localbety.jdField_b_of_type_Int);
      }
      return null;
    }
    aqvx localaqvx = ((atam)paramQQAppInterface.getManager(317)).a(bfpj.a(localbety.jdField_g_of_type_JavaLangString));
    Object localObject = localbety.jdField_d_of_type_JavaLangString;
    paramQQAppInterface = (QQAppInterface)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramQQAppInterface = localbety.jdField_c_of_type_JavaLangString;
    }
    localObject = paramQQAppInterface;
    if (localMessageForTroopFile.isMultiMsg)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = atvo.a(localMessageForTroopFile);
      }
    }
    paramQQAppInterface = new AIOFileVideoData((String)localObject);
    paramQQAppInterface.jdField_h_of_type_JavaLangString = localMessageForTroopFile.frienduin;
    paramQQAppInterface.jdField_c_of_type_Int = localMessageForTroopFile.istroop;
    paramQQAppInterface.jdField_d_of_type_Int = localMessageForTroopFile.issend;
    paramQQAppInterface.jdField_f_of_type_Long = localMessageForTroopFile.uniseq;
    paramQQAppInterface.jdField_g_of_type_Long = localMessageForTroopFile.time;
    paramQQAppInterface.jdField_i_of_type_Long = localMessageForTroopFile.shmsgseq;
    paramQQAppInterface.jdField_h_of_type_Long = localMessageForTroopFile.fileSize;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localMessageForTroopFile.fileName;
    paramQQAppInterface.jdField_g_of_type_Int = localMessageForTroopFile.istroop;
    paramQQAppInterface.jdField_a_of_type_Long = localaqvx.jdField_b_of_type_Int;
    paramQQAppInterface.jdField_a_of_type_Int = localMessageForTroopFile.width;
    paramQQAppInterface.jdField_b_of_type_Int = localMessageForTroopFile.height;
    if (bgmg.b(localbety.jdField_a_of_type_JavaLangString))
    {
      paramQQAppInterface.jdField_c_of_type_JavaLangString = localbety.jdField_a_of_type_JavaLangString;
      paramQQAppInterface.jdField_c_of_type_Boolean = true;
    }
    paramQQAppInterface.jdField_k_of_type_Boolean = paramChatMessage.isMultiMsg;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahth
 * JD-Core Version:    0.7.0.1
 */