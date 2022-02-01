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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class ahpt
{
  public static final int[] A = { 9, 2131698207, 2130844772, 2131374221, 0 };
  public static final int[] B = { 10, 2131698195, 2130838177, 2131374204, 0, 2130849900, 2130849901 };
  public static final int[] C = { 10, 2131698195, 2130844775, 2131374204, 0 };
  public static final int[] D = { 12, 2131698189, 2130838234, 2131374191, 0 };
  public static final int[] E = { 13, 2131698190, 2130838231, 2131374192, 0 };
  public static final int[] F = { 14, 2131698197, 2130838172, 2131374209, 0 };
  public static final int[] G = { 14, 2131698197, 2130844774, 2131374209, 0 };
  public static final int[] H = { 19, 2131698198, 2130838213, 2131374211, 0 };
  public static final int[] I = { 19, 2131698198, 2130844779, 2131374211, 0 };
  public static final int[] J = { 16, 2131698193, 2130838169, 2131374201, 0 };
  public static final int[] K = { 17, 2131698201, 2130838210, 2131374215, 0 };
  public static int[] L = { 23, 2131698203, 2130838222, 2131374220, 0, 2130849945, 2130849946 };
  public static final int[] M = { 26, 2131698213, 2130838222, 2131374235, 0 };
  public static final int[] N = { 24, 2131698196, 2130838178, 2131374205, 2130838102, 2130838198, 2130838200 };
  public static final int[] O = { 24, 2131698196, 2130844772, 2131374205, 0 };
  public static final int[] P = { 31, 2131698202, 2130838214, 2131374216, 0 };
  public static final int[] Q = { 32, 2131698194, 2130838176, 2131374203, 0 };
  public static final int[] R = { 24, 2131698196, 2130838180, 2131374206, 0 };
  public static final int[] S = { 24, 2131698196, 2130838179, 2131374206, 0 };
  public static final int[] T = { 29, 2131694499, 2130849865, 2131374187, 0 };
  public static final int[] U = { 29, 2131694499, 2130844771, 2131374187, 0 };
  public static final int[] V = { 21, 2131690488, 2130838444, 2131374186, 0 };
  public static final int[] W = { 21, 2131690488, 2130844769, 2131374186, 0 };
  public static final int[] X = { 21, 2131690488, 2130838489, 2131374190, 0 };
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131698208, 2130838224, 2131374222, 2130838106, 2130849962, 2130849963 };
    b = new int[] { 2, 2131698208, 2130838228, 2131374223, 0 };
    c = new int[] { 2, 2131698208, 2130838226, 2131374223, 0 };
    d = new int[] { 2, 2131698208, 2130844782, 2131374222, 0 };
    e = new int[] { 3, 2131698191, 2130838160, 2131374194, 2130838100, 2130849890, 2130849891 };
    f = new int[] { 3, 2131698191, 2130838164, 2131374195, 0 };
    g = new int[] { 3, 2131698191, 2130838162, 2131374195, 0 };
    h = new int[] { 3, 2131698191, 2130844773, 2131374194, 0 };
    i = new int[] { 3, 2131698191, 2130838167, 2131374194, 2130838101, 2130849888, 2130849889 };
    j = new int[] { 3, 2131698191, 2130838165, 2131374195, 0 };
    k = new int[] { 3, 2131698191, 2130838163, 2131374195, 0 };
    l = new int[] { 4, 2131698199, 2130838202, 2131374212, 2130838103, 2130849919, 2130849920 };
    m = new int[] { 4, 2131698199, 2130838207, 2131374213, 0 };
    n = new int[] { 4, 2131698199, 2130838204, 2131374213, 0 };
    o = new int[] { 4, 2131698199, 2130844778, 2131374212, 0 };
    p = new int[] { 4, 2131698199, 2130838209, 2131374212, 2130838104, 2130849917, 2130849918 };
    q = new int[] { 4, 2131698199, 2130838208, 2131374213, 0 };
    r = new int[] { 4, 2131698199, 2130838205, 2131374213, 0 };
    s = new int[] { 5, 2131698188, 2130838154, 2131374188, 0, 2130849870, 2130849871 };
    t = new int[] { 5, 2131698188, 2130838158, 2131374189, 0 };
    u = new int[] { 5, 2131698188, 2130838156, 2131374189, 0 };
    v = new int[] { 6, 2131698209, 2130838231, 2131374225, 0, 2130849968, 2130849969 };
    w = new int[] { 8, 2131698204, 2130838217, 2131374217, 2130838105, 2130849939, 2130849940 };
    x = new int[] { 8, 2131698204, 2130838219, 2131374218, 0 };
    y = new int[] { 8, 2131698204, 2130844780, 2131374217, 0 };
    z = new int[] { 9, 2131698207, 2130838223, 2131374221, 0 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.mContext, 2131560993, null);
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
    Object localObject = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
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
    if ((paramBaseChatPie.sessionInfo.curType == 1) && (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramBaseChatPie.sessionInfo.curFriendUin))) {
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", aftr.a(paramBaseChatPie.sessionInfo));
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
      paramIntent = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
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
    localPhotoListPanel.setOnSwipeUpAndDragListener(new ahuu(paramBaseChatPie.mActivity, paramBaseChatPie.afRoot, paramQQAppInterface, paramBaseChatPie.getTitleBarHeight(), null, localPhotoListPanel));
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
      bdla.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
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
        bdla.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        bdla.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.curType == 1)
      {
        bdla.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        bdla.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
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
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    aftr.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    bbbq localbbbq = (bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    paramString = localbbbq.a(paramInt1, paramString);
    if (paramString != null)
    {
      if (paramString.iNewFlag.get() == 1) {
        localbbbq.a(paramString, "");
      }
    }
    else {
      return;
    }
    int i1;
    label78:
    int i2;
    label89:
    boolean bool;
    if ((paramSessionInfo.curType == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.curFriendUin)))
    {
      paramInt1 = 1;
      if (paramSessionInfo.curType != 3000) {
        break label151;
      }
      i1 = 1;
      if (paramSessionInfo.curType != 1) {
        break label157;
      }
      i2 = 1;
      bool = ChatActivityUtils.a(paramSessionInfo.curType);
      if (paramInt1 == 0) {
        break label163;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
      return;
      paramInt1 = 0;
      break;
      label151:
      i1 = 0;
      break label78;
      label157:
      i2 = 0;
      break label89;
      label163:
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
      bdla.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
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
    if (((bjxa)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.curFriendUin)) {
      bdla.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.curFriendUin, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((bjxa)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.curFriendUin)) {
      bdla.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.curFriendUin, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpt
 * JD-Core Version:    0.7.0.1
 */