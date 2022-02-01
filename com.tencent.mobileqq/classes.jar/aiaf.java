import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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

public class aiaf
{
  public static final int[] A = { 9, 2131697778, 2130844827, 2131374247, 0 };
  public static final int[] B = { 10, 2131697766, 2130838138, 2131374230, 0, 2130849890, 2130849891 };
  public static final int[] C = { 10, 2131697766, 2130844830, 2131374230, 0 };
  public static final int[] D = { 12, 2131697760, 2130838195, 2131374217, 0 };
  public static final int[] E = { 13, 2131697761, 2130838192, 2131374218, 0 };
  public static final int[] F = { 14, 2131697768, 2130838133, 2131374235, 0 };
  public static final int[] G = { 14, 2131697768, 2130844829, 2131374235, 0 };
  public static final int[] H = { 19, 2131697769, 2130838174, 2131374237, 0 };
  public static final int[] I = { 19, 2131697769, 2130844834, 2131374237, 0 };
  public static final int[] J = { 16, 2131697764, 2130838130, 2131374227, 0 };
  public static final int[] K = { 17, 2131697772, 2130838171, 2131374241, 0 };
  public static int[] L = { 23, 2131697774, 2130838183, 2131374246, 0, 2130849935, 2130849936 };
  public static final int[] M = { 26, 2131697784, 2130838183, 2131374261, 0 };
  public static final int[] N = { 24, 2131697767, 2130838139, 2131374231, 2130838063, 2130838159, 2130838161 };
  public static final int[] O = { 24, 2131697767, 2130844827, 2131374231, 0 };
  public static final int[] P = { 31, 2131697773, 2130838175, 2131374242, 0 };
  public static final int[] Q = { 32, 2131697765, 2130838137, 2131374229, 0 };
  public static final int[] R = { 24, 2131697767, 2130838141, 2131374232, 0 };
  public static final int[] S = { 24, 2131697767, 2130838140, 2131374232, 0 };
  public static final int[] T = { 29, 2131694187, 2130849855, 2131374213, 0 };
  public static final int[] U = { 29, 2131694187, 2130844826, 2131374213, 0 };
  public static final int[] V = { 21, 2131690376, 2130838406, 2131374212, 0 };
  public static final int[] W = { 21, 2131690376, 2130844824, 2131374212, 0 };
  public static final int[] X = { 21, 2131690376, 2130838448, 2131374216, 0 };
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131697779, 2130838185, 2131374248, 2130838067, 2130849952, 2130849953 };
    b = new int[] { 2, 2131697779, 2130838189, 2131374249, 0 };
    c = new int[] { 2, 2131697779, 2130838187, 2131374249, 0 };
    d = new int[] { 2, 2131697779, 2130844837, 2131374248, 0 };
    e = new int[] { 3, 2131697762, 2130838121, 2131374220, 2130838061, 2130849880, 2130849881 };
    f = new int[] { 3, 2131697762, 2130838125, 2131374221, 0 };
    g = new int[] { 3, 2131697762, 2130838123, 2131374221, 0 };
    h = new int[] { 3, 2131697762, 2130844828, 2131374220, 0 };
    i = new int[] { 3, 2131697762, 2130838128, 2131374220, 2130838062, 2130849878, 2130849879 };
    j = new int[] { 3, 2131697762, 2130838126, 2131374221, 0 };
    k = new int[] { 3, 2131697762, 2130838124, 2131374221, 0 };
    l = new int[] { 4, 2131697770, 2130838163, 2131374238, 2130838064, 2130849909, 2130849910 };
    m = new int[] { 4, 2131697770, 2130838168, 2131374239, 0 };
    n = new int[] { 4, 2131697770, 2130838165, 2131374239, 0 };
    o = new int[] { 4, 2131697770, 2130844833, 2131374238, 0 };
    p = new int[] { 4, 2131697770, 2130838170, 2131374238, 2130838065, 2130849907, 2130849908 };
    q = new int[] { 4, 2131697770, 2130838169, 2131374239, 0 };
    r = new int[] { 4, 2131697770, 2130838166, 2131374239, 0 };
    s = new int[] { 5, 2131697759, 2130838115, 2131374214, 0, 2130849860, 2130849861 };
    t = new int[] { 5, 2131697759, 2130838119, 2131374215, 0 };
    u = new int[] { 5, 2131697759, 2130838117, 2131374215, 0 };
    v = new int[] { 6, 2131697780, 2130838192, 2131374251, 0, 2130849958, 2130849959 };
    w = new int[] { 8, 2131697775, 2130838178, 2131374243, 2130838066, 2130849929, 2130849930 };
    x = new int[] { 8, 2131697775, 2130838180, 2131374244, 0 };
    y = new int[] { 8, 2131697775, 2130844835, 2131374243, 0 };
    z = new int[] { 9, 2131697778, 2130838184, 2131374247, 0 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561061, null);
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
    Object localObject = ((anyw)paramQQAppInterface.getManager(51)).e(str);
    paramIntent = "";
    if (localObject != null) {
      paramIntent = ((Friends)localObject).name;
    }
    localObject = paramQQAppInterface.a(1, str, 0);
    boolean bool = paramQQAppInterface.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", paramIntent);
    localIntent.putExtra("key_my_head_dir", (String)localObject);
    localIntent.putExtra("key_new_lbs_client", bool);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramBaseChatPie.b() == 9500) || (paramBaseChatPie.b() == 9501)) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)paramQQAppInterface.getManager(60)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", agju.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
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
      paramIntent = (aoip)paramQQAppInterface.a(20);
      if ((!TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        paramIntent.e(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
        localIntent.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
    paramQQAppInterface = new int[2];
    paramBaseChatPie.d.getLocationInWindow(paramQQAppInterface);
    paramQQAppInterface[0] += paramBaseChatPie.d.getWidth();
    paramQQAppInterface[1] -= paramLinearLayout.getHeight() + paramPanelIconLinearLayout.getHeight();
    localPhotoListPanel.setOnSwipeUpAndDragListener(new aife(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBaseChatPie.d, paramQQAppInterface, paramBaseChatPie.a(), null, localPhotoListPanel));
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
    ((Intent)localObject2).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", paramSessionInfo.b);
    ((Intent)localObject2).putExtra("key_confess_topicid", paramSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
    ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject2).putExtra("entrance", paramSessionInfo.c);
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
      if (paramSessionInfo.jdField_a_of_type_Int != 0) {
        break label507;
      }
      bdll.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramIntent.removeExtra("PhotoConst.CURRENT_QUALITY_TYPE");
      paramIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      paramActivity.startActivity((Intent)localObject2);
      return;
      label507:
      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
      {
        bdll.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        bdll.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        bdll.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        bdll.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
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
        paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "aio_pia");
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
    agju.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    bdll.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    bbav localbbav = (bbav)paramQQAppInterface.getManager(36);
    paramString = localbbav.a(paramInt1, paramString);
    if (paramString != null)
    {
      if (paramString.iNewFlag.get() == 1) {
        localbbav.a(paramString, "");
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
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramInt1 = 1;
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        break label150;
      }
      i1 = 1;
      if (paramSessionInfo.jdField_a_of_type_Int != 1) {
        break label156;
      }
      i2 = 1;
      bool = ChatActivityUtils.a(paramSessionInfo.jdField_a_of_type_Int);
      if (paramInt1 == 0) {
        break label162;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i1 = 1;
    if (paramInt == 0) {
      paramInt = i1;
    }
    for (;;)
    {
      bdll.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
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
    if (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      bdll.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      bdll.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaf
 * JD-Core Version:    0.7.0.1
 */