import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class agwt
{
  public static final int[] A = { 9, 2131697924, 2130844703, 2131373992, 0 };
  public static final int[] B = { 10, 2131697912, 2130838163, 2131373975, 0, 2130849807, 2130849808 };
  public static final int[] C = { 10, 2131697912, 2130844706, 2131373975, 0 };
  public static final int[] D = { 12, 2131697906, 2130838220, 2131373962, 0 };
  public static final int[] E = { 13, 2131697907, 2130838217, 2131373963, 0 };
  public static final int[] F = { 14, 2131697914, 2130838158, 2131373980, 0 };
  public static final int[] G = { 14, 2131697914, 2130844705, 2131373980, 0 };
  public static final int[] H = { 19, 2131697915, 2130838199, 2131373982, 0 };
  public static final int[] I = { 19, 2131697915, 2130844710, 2131373982, 0 };
  public static final int[] J = { 16, 2131697910, 2130838155, 2131373972, 0 };
  public static final int[] K = { 17, 2131697918, 2130838196, 2131373986, 0 };
  public static int[] L = { 23, 2131697920, 2130838208, 2131373991, 0, 2130849852, 2130849853 };
  public static final int[] M = { 26, 2131697930, 2130838208, 2131374006, 0 };
  public static final int[] N = { 24, 2131697913, 2130838164, 2131373976, 2130838088, 2130838184, 2130838186 };
  public static final int[] O = { 24, 2131697913, 2130844703, 2131373976, 0 };
  public static final int[] P = { 31, 2131697919, 2130838200, 2131373987, 0 };
  public static final int[] Q = { 32, 2131697911, 2130838162, 2131373974, 0 };
  public static final int[] R = { 24, 2131697913, 2130838166, 2131373977, 0 };
  public static final int[] S = { 24, 2131697913, 2130838165, 2131373977, 0 };
  public static final int[] T = { 29, 2131694301, 2130849772, 2131373958, 0 };
  public static final int[] U = { 29, 2131694301, 2130844702, 2131373958, 0 };
  public static final int[] V = { 21, 2131690416, 2130838431, 2131373957, 0 };
  public static final int[] W = { 21, 2131690416, 2130844700, 2131373957, 0 };
  public static final int[] X = { 21, 2131690416, 2130838473, 2131373961, 0 };
  public static boolean a;
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  public static final int[] j;
  public static final int[] k;
  public static final int[] l;
  public static final int[] m;
  public static final int[] n;
  public static final int[] o;
  public static final int[] p;
  public static final int[] q;
  public static final int[] r;
  public static final int[] s;
  public static final int[] t;
  public static final int[] u;
  public static final int[] v;
  public static final int[] w;
  public static final int[] x;
  public static final int[] y;
  public static final int[] z;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131697925, 2130838210, 2131373993, 2130838092, 2130849869, 2130849870 };
    b = new int[] { 2, 2131697925, 2130838214, 2131373994, 0 };
    c = new int[] { 2, 2131697925, 2130838212, 2131373994, 0 };
    d = new int[] { 2, 2131697925, 2130844713, 2131373993, 0 };
    e = new int[] { 3, 2131697908, 2130838146, 2131373965, 2130838086, 2130849797, 2130849798 };
    f = new int[] { 3, 2131697908, 2130838150, 2131373966, 0 };
    g = new int[] { 3, 2131697908, 2130838148, 2131373966, 0 };
    h = new int[] { 3, 2131697908, 2130844704, 2131373965, 0 };
    i = new int[] { 3, 2131697908, 2130838153, 2131373965, 2130838087, 2130849795, 2130849796 };
    j = new int[] { 3, 2131697908, 2130838151, 2131373966, 0 };
    k = new int[] { 3, 2131697908, 2130838149, 2131373966, 0 };
    l = new int[] { 4, 2131697916, 2130838188, 2131373983, 2130838089, 2130849826, 2130849827 };
    m = new int[] { 4, 2131697916, 2130838193, 2131373984, 0 };
    n = new int[] { 4, 2131697916, 2130838190, 2131373984, 0 };
    o = new int[] { 4, 2131697916, 2130844709, 2131373983, 0 };
    p = new int[] { 4, 2131697916, 2130838195, 2131373983, 2130838090, 2130849824, 2130849825 };
    q = new int[] { 4, 2131697916, 2130838194, 2131373984, 0 };
    r = new int[] { 4, 2131697916, 2130838191, 2131373984, 0 };
    s = new int[] { 5, 2131697905, 2130838140, 2131373959, 0, 2130849777, 2130849778 };
    t = new int[] { 5, 2131697905, 2130838144, 2131373960, 0 };
    u = new int[] { 5, 2131697905, 2130838142, 2131373960, 0 };
    v = new int[] { 6, 2131697926, 2130838217, 2131373996, 0, 2130849875, 2130849876 };
    w = new int[] { 8, 2131697921, 2130838203, 2131373988, 2130838091, 2130849846, 2130849847 };
    x = new int[] { 8, 2131697921, 2130838205, 2131373989, 0 };
    y = new int[] { 8, 2131697921, 2130844711, 2131373988, 0 };
    z = new int[] { 9, 2131697924, 2130838209, 2131373992, 0 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.mContext, 2131560932, null);
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = paramIntent;
      if (paramIntent != null) {}
    }
    else
    {
      localIntent = new Intent();
    }
    String str = paramQQAppInterface.getAccount();
    Object localObject = ((amsw)paramQQAppInterface.getManager(51)).e(str);
    paramIntent = "";
    if (localObject != null) {
      paramIntent = ((Friends)localObject).name;
    }
    localObject = paramQQAppInterface.getCustomFaceFilePath(1, str, 0);
    boolean bool = paramQQAppInterface.isLBSFriendNewClient(paramBaseChatPie.sessionInfo.curFriendUin);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", paramIntent);
    localIntent.putExtra("key_my_head_dir", (String)localObject);
    localIntent.putExtra("key_new_lbs_client", bool);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramBaseChatPie.getCurType() == 9500) || (paramBaseChatPie.getCurType() == 9501)) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramBaseChatPie.sessionInfo.curType == 1) && (((HotChatManager)paramQQAppInterface.getManager(60)).b(paramBaseChatPie.sessionInfo.curFriendUin))) {
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", afcm.a(paramBaseChatPie.sessionInfo));
    if (paramBoolean)
    {
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("key_disable_edit_btn", true);
      localIntent.putExtra("key_disable_send_btn", true);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      localIntent.putExtra("custom_photopreview_sendbtn_report", true);
      localIntent.putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005978");
      localIntent.putExtra("custom_photopreview_sendbtn_album_reportReverse2", "1");
      paramIntent = (anca)paramQQAppInterface.getBusinessHandler(20);
      if ((!TextUtils.isEmpty(paramBaseChatPie.sessionInfo.curFriendUin)) && (paramBaseChatPie.sessionInfo.curType == 1))
      {
        paramIntent.e(paramBaseChatPie.sessionInfo.curFriendUin, true);
        localIntent.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramBaseChatPie.getActivity(), paramBaseChatPie.sessionInfo, localIntent);
    paramQQAppInterface = new int[2];
    paramBaseChatPie.afRoot.getLocationInWindow(paramQQAppInterface);
    paramQQAppInterface[0] += paramBaseChatPie.afRoot.getWidth();
    paramQQAppInterface[1] -= paramLinearLayout.getHeight() + paramPanelIconLinearLayout.getHeight();
    localPhotoListPanel.setOnSwipeUpAndDragListener(new ahbu(paramBaseChatPie.mActivity, paramBaseChatPie.afRoot, paramQQAppInterface, paramBaseChatPie.getTitleBarHeight(), null, localPhotoListPanel));
    return localPhotoListPanel;
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto start");
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_presend_cancel_type", 1021);
    RichmediaService.d((Bundle)localObject1);
    Object localObject2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i1 = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new Intent(paramActivity, SendPhotoActivity.class);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052));
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
    ((Intent)localObject2).putExtra("PhotoConst.VIDEO_INFOS", paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
    ((Intent)localObject2).putExtra("uin", paramSessionInfo.curFriendUin);
    ((Intent)localObject2).putExtra("uintype", paramSessionInfo.curType);
    ((Intent)localObject2).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject2).putExtra("key_confess_topicid", paramSessionInfo.topicId);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
    ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject2).putExtra("entrance", paramSessionInfo.entrance);
    ((Intent)localObject2).putExtra("video_sync_to_story", paramIntent.getBooleanExtra("video_sync_to_story", false));
    if (((ArrayList)localObject1).size() == 1) {
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject1);
    }
    ((Intent)localObject2).addFlags(603979776);
    ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    ((Intent)localObject2).putExtra("session_info", paramSessionInfo);
    String str1 = paramIntent.getStringExtra("widgetinfo");
    String str2 = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str1)) {
      ((Intent)localObject2).putExtra("widgetinfo", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      ((Intent)localObject2).putExtra("key_camera_material_name", str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto selectedPhotoList = " + ((ArrayList)localObject1).toString());
    }
    if (paramActivity.getIntent().getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007) == 1040)
    {
      if (paramSessionInfo.curType != 0) {
        break label507;
      }
      bcef.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramIntent.removeExtra("PhotoConst.CURRENT_QUALITY_TYPE");
      paramIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      paramActivity.startActivity((Intent)localObject2);
      return;
      label507:
      if (paramSessionInfo.curType == 3000)
      {
        bcef.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        bcef.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.curType == 1)
      {
        bcef.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        bcef.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, "aio_pia");
        if ("0".equals(paramQQAppInterface)) {
          break label98;
        }
        bool = true;
        jdField_a_of_type_Boolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIO_Panel", 2, "getAIOPanelConfig = " + paramQQAppInterface + " isShowQwalletHbEntry = " + jdField_a_of_type_Boolean);
        return;
      }
      catch (Throwable paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOPanelUtiles", 2, paramQQAppInterface, new Object[0]);
      return;
      label98:
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    afcm.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    azvi localazvi = (azvi)paramQQAppInterface.getManager(36);
    paramString = localazvi.a(paramInt1, paramString);
    if (paramString != null)
    {
      if (paramString.iNewFlag.get() == 1) {
        localazvi.a(paramString, "");
      }
    }
    else {
      return;
    }
    int i1;
    label77:
    int i2;
    label88:
    boolean bool;
    if ((paramSessionInfo.curType == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.curFriendUin)))
    {
      paramInt1 = 1;
      if (paramSessionInfo.curType != 3000) {
        break label150;
      }
      i1 = 1;
      if (paramSessionInfo.curType != 1) {
        break label156;
      }
      i2 = 1;
      bool = ChatActivityUtils.a(paramSessionInfo.curType);
      if (paramInt1 == 0) {
        break label162;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
      return;
      paramInt1 = 0;
      break;
      label150:
      i1 = 0;
      break label77;
      label156:
      i2 = 0;
      break label88;
      label162:
      if (i1 != 0) {
        paramInt1 = 2;
      } else if (i2 != 0) {
        paramInt1 = 3;
      } else if (bool) {
        paramInt1 = 4;
      } else {
        paramInt1 = 5;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i1 = 1;
    if (paramInt == 0) {
      paramInt = i1;
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 3000) {
        paramInt = 2;
      } else if (paramInt == 1) {
        paramInt = 3;
      } else if ((paramInt == 6000) || (paramInt == 6001) || (paramInt == 6002) || (paramInt == 1008) || (paramInt == 9500)) {
        paramInt = 5;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    if (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin)) {
      bcef.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.curFriendUin, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin)) {
      bcef.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.curFriendUin, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwt
 * JD-Core Version:    0.7.0.1
 */