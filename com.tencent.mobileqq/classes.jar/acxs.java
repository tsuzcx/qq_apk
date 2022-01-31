import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.PoiMapActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.List<Lahcz;>;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class acxs
{
  private static int jdField_a_of_type_Int = -1;
  private static akil jdField_a_of_type_Akil;
  public static String a;
  public static String b;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int a(SessionInfo paramSessionInfo)
  {
    if (bbbx.a(paramSessionInfo.jdField_a_of_type_Int)) {}
    for (int i = 5;; i = 6)
    {
      if (myb.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        i = 1;
      }
      return i;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent1, Intent paramIntent2)
  {
    int i = -1;
    Object localObject;
    if ((paramIntent1 == null) || (!paramIntent1.hasExtra("showFlashPic")))
    {
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      paramIntent2.putExtra("showFlashPic", ajwb.a(paramSessionInfo.jdField_a_of_type_Int, (HotChatManager)localObject, paramSessionInfo.b));
    }
    paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    int j;
    boolean bool2;
    boolean bool1;
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)) && (!LiteActivity.class.isInstance(paramActivity)))
    {
      paramIntent2.putExtras(paramActivity.getIntent());
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + paramIntent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      }
      paramIntent2.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      if (paramIntent1 == null) {
        break label1217;
      }
      i = paramIntent1.getIntExtra("peakconstant.request_code", -1);
      paramIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent1.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      j = paramIntent1.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent1.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent1.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int k = paramIntent1.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (k == 1039) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (k == 1040) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      paramIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", paramIntent1.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.a(paramIntent1, paramIntent2);
      paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", paramIntent1.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false));
      paramIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", paramIntent1.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false));
      paramIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent1.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      paramIntent2.putExtra("fromPhotoListPanel", paramIntent1.getBooleanExtra("fromPhotoListPanel", false));
      paramIntent2.putExtra("KEY_IS_ANONYMOUS", paramIntent1.getBooleanExtra("KEY_IS_ANONYMOUS", false));
      paramIntent2.putExtra("PhotoConst.SEND_NO_PRESEND", paramIntent1.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false));
    }
    for (;;)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + j);
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
        paramIntent2.putExtra("isdevicesupportmultiupload", true);
      }
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      paramIntent2.putExtra("filter_photolist_troopalbum_toolbar", bool1);
      paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      paramIntent2.putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      paramIntent2.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramIntent2.putExtra("album_enter_directly", true);
      paramIntent2.putExtra("ALBUM_ID", bbbx.a(paramActivity));
      paramIntent2.putExtra("ALBUM_NAME", bbbx.b(paramActivity));
      paramIntent2.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramIntent2.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent2.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent2.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent2.putExtra("uinname", paramSessionInfo.d);
      paramIntent2.putExtra("entrance", paramSessionInfo.jdField_c_of_type_Int);
      paramIntent2.putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        paramIntent2.putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().j);
      }
      paramIntent2.putExtra("is_anonymous", myb.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      paramIntent2.getExtras().remove("forward_type");
      if ((paramIntent1 != null) && (paramIntent1.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
      {
        paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        paramIntent2.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        paramIntent2.putExtra("session_info", paramSessionInfo);
        paramIntent2.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(avpj.b(paramQQAppInterface), j));
      }
      paramIntent2.putExtra("session_info", paramSessionInfo);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        paramIntent2.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      return i;
      label864:
      yah localyah;
      label928:
      long l1;
      if ((paramActivity instanceof SplashActivity))
      {
        paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramIntent2 = actj.a(paramIntent2, null);
        paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
        if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
          break label1160;
        }
        if (!(paramActivity instanceof SplashActivity)) {
          break label1133;
        }
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramIntent2 = actj.a(paramIntent2, null);
        paramIntent2.putExtra(bbbw.h, 80);
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        paramIntent2.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        localyah = (yah)paramQQAppInterface.a(51);
        localObject = paramIntent2;
        if (localyah != null)
        {
          localObject = paramIntent2;
          if (localyah.a()) {
            l1 = 0L;
          }
        }
      }
      try
      {
        long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localObject = paramIntent2;
      if (localyah.a(l1, 1)) {
        paramIntent2.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      }
      label1133:
      Intent localIntent;
      for (localObject = paramIntent2;; localIntent = paramIntent2)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2 = (Intent)localObject;
        break;
        if ((paramActivity instanceof LiteActivity))
        {
          paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
          break label864;
        }
        paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        break label864;
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        break label928;
        label1160:
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        paramIntent2.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        paramIntent2.putExtra("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
      }
      label1217:
      bool1 = false;
      bool2 = false;
      j = 20;
    }
  }
  
  public static String a()
  {
    return a(ajsd.bj);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(((Calendar)localObject).get(1));
    int j = ((Calendar)localObject).get(2) + 1;
    if (j < 10)
    {
      paramString = "0" + j;
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(5);
      if (j >= 10) {
        break label322;
      }
      paramString = "0" + j;
      label115:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(11);
      if (j >= 10) {
        break label330;
      }
      paramString = "0" + j;
      label157:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(12);
      if (j >= 10) {
        break label338;
      }
      paramString = "0" + j;
      label199:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(13);
      if (j >= 10) {
        break label346;
      }
      paramString = "0" + j;
      label241:
      localStringBuilder.append(paramString);
      if (!paramBoolean) {
        break label354;
      }
    }
    label322:
    label330:
    label338:
    label346:
    label354:
    for (paramString = ".mp4";; paramString = ".jpg")
    {
      if (new File(localStringBuilder.toString() + paramString).exists()) {
        break label361;
      }
      return localStringBuilder.toString() + paramString;
      paramString = Integer.valueOf(j);
      break;
      paramString = Integer.valueOf(j);
      break label115;
      paramString = Integer.valueOf(j);
      break label157;
      paramString = Integer.valueOf(j);
      break label199;
      paramString = Integer.valueOf(j);
      break label241;
    }
    label361:
    localObject = new StringBuilder(localStringBuilder);
    j = localStringBuilder.length();
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(paramString);
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = paramString.indexOf(':');
        } while (i == -1);
        localObject = paramString.substring(0, i);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = ((String)localObject).toLowerCase();
    } while ((((String)localObject).compareTo("http") != 0) && (((String)localObject).compareTo("https") != 0));
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.a(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new auoj(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramQQAppInterface.getAccount(), paramSessionInfo.jdField_e_of_type_Int).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).c())) {}
    for (;;)
    {
      return;
      if (!bbbr.a())
      {
        bcql.a(paramActivity, paramActivity.getResources().getString(2131719055), 0).a();
        return;
      }
      paramAppInterface = ajsd.bj;
      boolean bool;
      label56:
      Object localObject;
      if (paramInt2 == 1)
      {
        bool = true;
        paramAppInterface = a(paramAppInterface, bool);
        localObject = new File(ajsd.bj);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
        localObject = new Intent();
        if (paramInt2 != 0) {
          break label201;
        }
        FileProvider7Helper.setSystemCapture(paramActivity, new File(paramAppInterface), (Intent)localObject);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_camera");
        ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
        ((Intent)localObject).setFlags(536870912);
      }
      try
      {
        paramActivity.startActivityForResult((Intent)localObject, paramInt1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PlusPanelUtils", 2, "enter sys camera");
        return;
        bool = false;
        break label56;
        label201:
        ((Intent)localObject).setAction("android.media.action.VIDEO_CAPTURE");
        ((Intent)localObject).putExtra("output", Uri.fromFile(new File(paramAppInterface)));
        ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface.printStackTrace();
          bcql.a(paramActivity, 2131690593, 0).a();
        }
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    a(paramBaseActivity.app, paramBaseActivity, paramSessionInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      BaseChatPie localBaseChatPie = ((FragmentActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.aL();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      localIntent.putExtra("sessionType", localBaseChatPie.a.jdField_a_of_type_Int);
      boolean bool = ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, true, null);
      localIntent.putExtra("int_unread_msgs_num", paramQQAppInterface.a().b());
      localIntent.putExtra("boolean_is_default_theme", bool);
      paramActivity.startActivityForResult(localIntent, 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("enterQQMap", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    localIntent = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface = (yah)paramQQAppInterface.a(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localIntent.putExtra("from_aio", true);
        localIntent.addFlags(536870912);
        localIntent.putExtra("selectMode", true);
        localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.b);
        }
        for (;;)
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 0) {
            break label358;
          }
          localIntent.putExtra("qfile_entrance_type_key", 1);
          break;
          if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_e_of_type_JavaLangString);
          } else {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_c_of_type_JavaLangString);
          }
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
          localIntent.putExtra("qfile_entrance_type_key", 5);
        } else if (paramSessionInfo.jdField_a_of_type_Int == 1) {
          localIntent.putExtra("qfile_entrance_type_key", 3);
        }
      }
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.a(l1));
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800L);
      }
      if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
        localIntent.putExtra("select_file_support_send_docs_file", ancv.a().a());
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771979, 2130771980);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    bgxb.a(paramQQAppInterface, "tenpay.com", new acxv(paramInt1, paramSessionInfo, paramQQAppInterface, paramInt2, paramString, paramActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (yah)paramQQAppInterface.a(51);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        localException.printStackTrace();
        continue;
        int i = paramQQAppInterface.a(l1);
      }
    }
    if (paramBoolean)
    {
      i = 2;
      localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", i);
      localIntent.putExtra("smart_device_switch_tab_flag", paramInt);
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800);
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771979, 2130771980);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ahcz paramahcz, List<ahcz> paramList, int paramInt)
  {
    if (paramahcz == null) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      RedPacketManager.CURRENT_PANEL_DATA.clear();
      RedPacketManager.CURRENT_PANEL_DATA.addAll(paramList);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    localIntent.putExtra("isFromPanel", true);
    Object localObject1 = String.valueOf(2);
    int j = 1;
    int i = 0;
    Object localObject2 = "";
    paramList = (agvx)paramQQAppInterface.getManager(125);
    if (paramList != null) {}
    label1422:
    label1561:
    label1569:
    for (String str = paramList.a();; str = null)
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        i = 1;
        paramList = "entrance.click.c2c";
        j = 1;
      }
      label165:
      label1503:
      label1523:
      for (;;)
      {
        int k;
        if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramahcz.jdField_a_of_type_Int)) == null) {
          k = 1;
        }
        Object localObject3;
        switch (paramahcz.jdField_a_of_type_Int)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          localObject3 = "";
          paramahcz = (ahcz)localObject1;
          localObject1 = localObject3;
        case 0: 
        case 1: 
        case 2: 
        case 6: 
        case 7: 
          for (;;)
          {
            localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
            localObject3 = new JSONObject();
            try
            {
              ((JSONObject)localObject3).put("recv_type", i);
              ((JSONObject)localObject3).put("recv_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject3).put("channel", k);
              ((JSONObject)localObject3).put("bus_type", paramahcz);
              if (j > 0) {
                ((JSONObject)localObject3).put("people_num", j);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((JSONObject)localObject3).put("session_token", localObject2);
              }
              if (str != null) {
                ((JSONObject)localObject3).put("placeholder", str);
              }
              if (0 != 0) {
                ((JSONObject)localObject3).put("extra_info", null);
              }
            }
            catch (JSONException paramahcz)
            {
              for (;;)
              {
                long l;
                paramahcz.printStackTrace();
                continue;
                if (paramInt == 1)
                {
                  aeft.a(paramQQAppInterface, "0X8005FC9", paramSessionInfo.jdField_a_of_type_Int);
                  continue;
                  if (jdField_a_of_type_Int == 1)
                  {
                    paramActivity = paramList + ".quick";
                  }
                  else
                  {
                    paramActivity = paramList;
                    continue;
                    paramList = "";
                  }
                }
              }
              paramList = "";
              j = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanel", 2, "click HongBao:params=" + ((JSONObject)localObject3).toString());
            }
            localIntent.putExtra("extra_data", ((JSONObject)localObject3).toString());
            paramActivity.startActivity(localIntent);
            if (paramInt != 0) {
              break label1503;
            }
            aeft.a(paramQQAppInterface, "0X8005CAF", paramSessionInfo.jdField_a_of_type_Int);
            if (jdField_a_of_type_Int != 0) {
              break label1523;
            }
            paramActivity = paramList + ".plus";
            axqy.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramActivity, 0, 0, (String)localObject1, "", "", "");
            return;
            if (paramSessionInfo.jdField_a_of_type_Int == 3000)
            {
              i = 2;
              paramList = "entrance.click.group";
              j = ((ajvi)paramQQAppInterface.getManager(53)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
              break;
            }
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramList = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
              i = j;
              if (paramList != null)
              {
                i = paramList.wMemberNum;
                if (QLog.isColorLevel()) {
                  QLog.d("PlusPanelUtils", 2, "troop uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " people_num：" + i);
                }
              }
              if (QWalletHelper.isNeedUpdateTroopMemberNum(paramSessionInfo.jdField_a_of_type_JavaLangString)) {}
              try
              {
                l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
                paramList = (akhp)paramQQAppInterface.a(20);
                if (jdField_a_of_type_Akil == null) {
                  jdField_a_of_type_Akil = new acxu(paramSessionInfo);
                }
                paramQQAppInterface.addObserver(jdField_a_of_type_Akil);
                paramList.b(l, 32, 0);
              }
              catch (NumberFormatException paramList)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.d("angelzhuang", 2, "群uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " 解析失败");
                    continue;
                    j = 3;
                  }
                }
              }
              paramList = (HotChatManager)paramQQAppInterface.getManager(60);
              if ((paramList != null) && (paramList.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
              {
                axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
                j = 6;
                paramList = "entrance.click.chatgroup";
                k = i;
                i = j;
                j = k;
                break;
              }
            }
            if (paramSessionInfo.jdField_a_of_type_Int == 1000)
            {
              i = 4;
              localObject2 = paramSessionInfo.b;
              paramList = "entrance.click.c2c";
              j = 1;
              break;
            }
            if (paramSessionInfo.jdField_a_of_type_Int == 1004)
            {
              i = 5;
              localObject2 = paramSessionInfo.b;
              paramList = "entrance.click.c2c";
              j = 1;
              break;
            }
            if ((paramSessionInfo.jdField_a_of_type_Int != 1001) && (paramSessionInfo.jdField_a_of_type_Int != 10002) && (paramSessionInfo.jdField_a_of_type_Int != 10004)) {
              break label1569;
            }
            if (paramSessionInfo.jdField_a_of_type_Int == 10004) {}
            for (paramList = paramQQAppInterface.a().l(paramSessionInfo.jdField_a_of_type_JavaLangString);; paramList = paramQQAppInterface.a().m(paramSessionInfo.jdField_a_of_type_JavaLangString))
            {
              if (paramList == null) {
                break label1561;
              }
              paramList = bbco.encodeToString(paramList, 2);
              axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
              localObject3 = "entrance.click.c2c";
              localObject2 = paramList;
              i = 7;
              j = 1;
              paramList = (List<ahcz>)localObject3;
              break;
            }
            k = ((Integer)RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramahcz.jdField_a_of_type_Int))).intValue();
            break label165;
            localObject1 = "13140";
            paramahcz = String.valueOf(1);
            continue;
            localObject1 = "13141";
            paramahcz = String.valueOf(2);
            continue;
            localObject3 = "13142";
            paramahcz = (ahcz)localObject1;
            localObject1 = localObject3;
            continue;
            localObject3 = "13146";
            paramahcz = (ahcz)localObject1;
            localObject1 = localObject3;
            continue;
            localObject3 = "13147";
            paramahcz = (ahcz)localObject1;
            localObject1 = localObject3;
          }
        case 5: 
          l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
          paramSessionInfo = new Intent(paramActivity, QrcodeHbGuiderActivity.class);
          paramSessionInfo.putExtra("appInfo", "");
          paramSessionInfo.putExtra("vacreport_key_seq", l);
          paramActivity.startActivity(paramSessionInfo);
          axqy.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
          return;
        case 3: 
          if (paramahcz.jdField_a_of_type_OrgJsonJSONObject != null) {}
          for (paramahcz = paramahcz.jdField_a_of_type_OrgJsonJSONObject.optString("theme_id", "");; paramahcz = "")
          {
            localIntent.putExtra("theme_type", paramahcz);
            localIntent.putExtra("theme", true);
            k = 1;
            localObject3 = "";
            paramahcz = (ahcz)localObject1;
            localObject1 = localObject3;
            break;
          }
        case 4: 
          if (paramahcz.jdField_a_of_type_OrgJsonJSONObject == null) {
            break;
          }
          paramList = paramahcz.jdField_a_of_type_OrgJsonJSONObject.optString("url", "");
          paramQQAppInterface = paramList;
          if (paramahcz.jdField_a_of_type_OrgJsonJSONObject.optInt("subtype", 0) == 1) {
            if (paramList.indexOf("?") != -1) {
              break label1422;
            }
          }
          for (paramQQAppInterface = paramList + "?recv_uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&recv_type=" + i;; paramQQAppInterface = paramList + "&recv_uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&recv_type=" + i)
          {
            a(paramActivity, paramQQAppInterface);
            return;
          }
        case 12: 
          paramahcz = paramahcz.jdField_a_of_type_OrgJsonJSONObject.optString("schema");
          if (TextUtils.isEmpty(paramahcz)) {
            break;
          }
          a(paramQQAppInterface, paramActivity, paramSessionInfo, i, j, paramahcz);
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    axqy.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.putExtra("url", "https://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&uintype=" + paramSessionInfo.jdField_a_of_type_Int + "&_wv=1&entry=aio&_bid=203");
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("hide_left_button", true);
      paramQQAppInterface.putExtra("show_right_close_button", true);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramActivity.startActivity(paramQQAppInterface);
      paramActivity.overridePendingTransition(2130771979, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$CurType$", String.valueOf(paramSessionInfo.jdField_a_of_type_Int)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramActivity, AlbumListActivity.class);
    int i = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, localIntent);
    if (i == -1) {
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterPhotoPicker");
      }
      bbbx.a(paramActivity, false, true);
      if (bgky.a != null) {
        bgky.a.b();
      }
      return;
      paramActivity.startActivityForResult(localIntent, i);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 1);
    int i = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, localIntent);
    if (i == -1) {
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterPhotoPicker");
      }
      bbbx.a(paramActivity, false, true);
      if (bgky.a != null) {
        bgky.a.b();
      }
      return;
      localIntent.putExtra("PhotoConst.editPathMap", agpk.a(paramHashMap));
      paramActivity.startActivityForResult(localIntent, i);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new acxx(paramSessionInfo, paramQQAppInterface, paramContext, bbef.b(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (muf.a()) {
      return;
    }
    muf localmuf = muf.a(paramContext);
    int[] arrayOfInt = new int[5];
    localmuf.a(2131689581);
    if (((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004)) && (((bduf)paramQQAppInterface.getManager(165)).d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      arrayOfInt[0] = 5;
      localmuf.b(2131698252);
    }
    for (int i = 1;; i = 0)
    {
      arrayOfInt[i] = 1;
      localmuf.b(2131720362);
      i += 1;
      arrayOfInt[i] = 2;
      localmuf.b(2131720384);
      localmuf.c(2131690596);
      localmuf.a(new acxt(paramQQAppInterface));
      localmuf.a(new acxw(localmuf, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
      localmuf.show();
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80049C5";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        str1 = "0";
      }
    }
    for (;;)
    {
      axqy.b(paramQQAppInterface, "CliOper", "", "", str2, str2, 0, 0, str1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      str2 = "0X80049C7";
      break;
      str1 = "0";
      continue;
      str1 = "1";
      continue;
      str1 = "2";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
      continue;
      str1 = "5";
      continue;
      str1 = "6";
      continue;
      str1 = "7";
      continue;
      str1 = "4";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter Camera");
    }
    if (AudioHelper.b(0))
    {
      bbdj.a(paramContext, 230, paramContext.getString(2131698463), paramContext.getString(2131698464), new acxy(), null).show();
      return;
    }
    if (AudioHelper.a(0))
    {
      bbdj.a(paramContext, 230, paramContext.getString(2131698463), paramContext.getString(2131698465), new acxz(), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      bbdj.a(paramContext, 230, paramContext.getString(2131698463), ajya.a(2131708316), new acya(), null).show();
      return;
    }
    paramQQAppInterface.a().b();
    if (paramInt2 == 0) {}
    for (int i = 1;; i = 17000)
    {
      a(paramQQAppInterface, paramBaseActivity, i, paramInt2);
      ahvx.k();
      paramBaseActivity.setCanLock(false);
      if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
        break;
      }
      ymt.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 2, 0, paramInt1);
      return;
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      bool1 = bool2;
      if (bool2)
      {
        long l = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
          }
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
          bool1 = false;
        }
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
        }
        bool1 = false;
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1001)
      {
        bool2 = bool1;
        if (paramSessionInfo.jdField_a_of_type_Int != 10002) {}
      }
      else
      {
        bool2 = bool1;
        if (!paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
          }
          bool2 = true;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 9500)
      {
        paramBoolean = bool2;
        if (paramSessionInfo.jdField_a_of_type_Int != 9501) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
        }
        paramBoolean = true;
      }
      paramSessionInfo = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
      bool1 = paramBoolean;
      if (!paramBoolean)
      {
        bool1 = paramBoolean;
        if (paramSessionInfo != null)
        {
          bool1 = paramBoolean;
          if (paramSessionInfo.length() > 0)
          {
            paramSessionInfo = paramSessionInfo.split("\\|");
            bool1 = paramBoolean;
            if (paramSessionInfo.length >= 4)
            {
              bool2 = paramSessionInfo[0].equals("1");
              bool5 = paramSessionInfo[1].equals("1");
              bool6 = paramSessionInfo[2].equals("1");
              bool7 = paramSessionInfo[3].equals("1");
              i = bbfj.a(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (i)
      {
      default: 
        label388:
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + i + ",enablePreCompress_WIFI:" + bool2 + ", enablePreCompress_2G = " + bool5 + ", enablePreCompress_3G = " + bool6 + ", enablePreCompress_4G = " + bool7 + ", presendOFF  = " + paramBoolean);
          bool1 = paramBoolean;
        }
        if ((bool4) || (bool1)) {
          break;
        }
      }
    }
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + bool4 + ", presendOFF = " + bool1 + ", result  = " + paramBoolean);
      }
      return paramBoolean;
      i = 0;
      break;
      if (!bool2)
      {
        paramBoolean = true;
        break label388;
      }
      paramBoolean = false;
      break label388;
      if (!bool5)
      {
        paramBoolean = true;
        break label388;
      }
      paramBoolean = false;
      break label388;
      if (!bool6)
      {
        paramBoolean = true;
        break label388;
      }
      paramBoolean = false;
      break label388;
      if (!bool7)
      {
        paramBoolean = true;
        break label388;
      }
      paramBoolean = false;
      break label388;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    bgpw.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    bgqi.b(paramQQAppInterface, 3, paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject = (askn)paramQQAppInterface.getManager(11);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((askn)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (localObject = paramSessionInfo.jdField_a_of_type_JavaLangString; paramString == null; localObject = ((askn)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("category", 15);
    paramQQAppInterface.putExtra("busiType", 5);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("STRING_Show_Music_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Video_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Apk_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Pic_Category", false);
    paramQQAppInterface.putExtra("STRING_SingleSelect", false);
    paramQQAppInterface.putExtra("max_select_count", 5);
    paramQQAppInterface.putExtra(bbbw.h, 84);
    paramQQAppInterface.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(paramQQAppInterface, 84);
    bbbx.a(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxs
 * JD-Core Version:    0.7.0.1
 */