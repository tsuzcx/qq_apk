import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aent
  extends BaseChatPie
{
  public static boolean X;
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int t;
  static int u;
  static int v;
  boolean T = false;
  public volatile boolean U;
  boolean V = false;
  boolean W = false;
  boolean Y = false;
  boolean Z = false;
  BroadcastReceiver a;
  protected Boolean a;
  private boolean aa;
  public String g = "";
  private ImageView p;
  public int q;
  int r;
  int s;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    t = 100100;
    jdField_u_of_type_Int = 10;
    jdField_v_of_type_Int = 11;
  }
  
  public aent(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeoa(this);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("num", 1);
      int j = paramString2.optInt("face", 1);
      int k = paramString2.optInt("mediaSize", 1);
      int m = paramString2.optInt("mediaType", 1);
      int n = paramString2.optInt("scaling", 1);
      int i1 = paramString2.optInt("orientation", 1);
      int i2 = paramString2.optInt("color", 1);
      int i3 = paramString2.optInt("quality", 1);
      localBundle.putInt("copies", i);
      localBundle.putInt("duplexMode", j);
      localBundle.putInt("mediaSize", k);
      localBundle.putInt("mediaType", m);
      localBundle.putInt("scaling", n);
      localBundle.putInt("orientation", i1);
      localBundle.putInt("color", i2);
      localBundle.putInt("quality", i3);
      ((yer)paramQQAppInterface.a(49)).a().a(yer.c, paramString1, paramArrayList, localBundle);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json JSONException error:" + paramString2.getMessage());
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json Exception error:" + paramString2.getMessage());
        }
      }
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  private void bq()
  {
    int i = 1;
    Object localObject2;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      localObject1 = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ((yer)localObject1).a().a();
      ((yer)localObject1).a().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      if (bfnz.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      bo();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      this.U = true;
      localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.jdField_r_of_type_Int = ((Bundle)localObject2).getInt("operType", 0);
        this.jdField_s_of_type_Int = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      localObject1 = (ImageView)this.c.findViewById(2131368441);
      if (localObject1 == null) {
        break label657;
      }
      ((ImageView)localObject1).setImageResource(2130839291);
    }
    label652:
    label657:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.c.findViewById(2131368436);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839290);
        ((ImageView)localObject3).setOnClickListener(new aenv(this));
      }
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject3 = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      boolean bool;
      if ((((yah)localObject3).c(l)) && (((yah)localObject3).a(l, 17)))
      {
        bool = true;
        this.Z = bool;
        if (this.Z) {
          ((yah)localObject3).a(l, "", "", "", 0, null);
        }
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
          localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            i(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
        }
        bool = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((aoes.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))) {
          break label652;
        }
      }
      for (;;)
      {
        if (((bool) && (((yah)localObject3).d(l))) || (i != 0))
        {
          this.p = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368441);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368441);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.p, (ViewGroup.LayoutParams)localObject2);
            this.p.setImageResource(2130849298);
          }
          this.p.setVisibility(0);
        }
        return;
        bool = false;
        break;
        i = 0;
      }
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int k = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = 0;
    Object localObject2 = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    int i = j;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((yah)localObject2).a(localDeviceInfo.productId);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          i = 1;
        }
      }
    }
    long l = 0L;
    j = 0;
    if (localDeviceInfo != null)
    {
      l = localDeviceInfo.din;
      j = localDeviceInfo.productId;
    }
    if ((i == 0) && (this.jdField_r_of_type_Int != 4) && (this.jdField_r_of_type_Int != 3))
    {
      paramIntent = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, j);
    }
    do
    {
      do
      {
        return;
        localObject3 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            ((ArrayList)localObject3).add(new FileInfo(str));
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
        if ((this.jdField_r_of_type_Int == 4) || (this.jdField_r_of_type_Int == 3))
        {
          paramIntent = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((yah)localObject2).a((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          H();
          return;
        }
        if (this.jdField_r_of_type_Int != 9) {
          break;
        }
      } while (((ArrayList)localObject3).size() <= 0);
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra(bbbw.h, paramIntent.getIntExtra(bbbw.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      bhwm.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      if ((X) && (this.W))
      {
        ((yer)localObject2).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject1);
        ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendGroupMsg", 3, 0, j);
        return;
      }
      if (!this.Z) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(bbbw.h, paramIntent.getIntExtra(bbbw.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    bhwm.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    return;
    if (k == 2)
    {
      b((List)localObject1);
      return;
    }
    c((List)localObject1);
  }
  
  private void i(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, ajya.a(2131703183), 2000).a();
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
      localArrayList = new ArrayList();
      Object localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      if (bbfj.a(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      paramIntent = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697860), this.jdField_a_of_type_AndroidContentContext.getString(2131697653), ajya.a(2131703198), ajya.a(2131703199), new aeny(this, localArrayList, paramIntent), new aenz(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, paramIntent);
  }
  
  public boolean D()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean E()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean F()
  {
    if (E()) {
      return true;
    }
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      yah localyah = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localyah != null) && (localyah.c(l)) && (localyah.a(l, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
    return false;
  }
  
  public void G()
  {
    if (this.N) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.G();
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_a_of_type_JavaLangString, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public boolean G()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean H()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public void O()
  {
    super.O();
    if ((this.jdField_r_of_type_Int == 3) || (this.jdField_r_of_type_Int == 4))
    {
      if (!this.Y) {
        this.Y = true;
      }
    }
    else {
      return;
    }
    super.H();
  }
  
  public void P()
  {
    bbfv.a();
    actj.a(false);
    this.j = false;
    this.l = true;
    this.m = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.M = true;
    this.N = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.i = null;
    }
    if (this.jdField_a_of_type_Aeyv != null) {
      this.jdField_a_of_type_Aeyv.a();
    }
    if (this.f != null)
    {
      this.f.setVisibility(4);
      this.f = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
    }
  }
  
  public QQRecorder.RecorderParam a()
  {
    Object localObject = ((yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localObject = new ymi().a((DeviceInfo)localObject);
    if ((localObject != null) && (((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007)) != null)) {}
    try
    {
      String str = (String)((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      if (new JSONObject(((String)localObject).replace("&quot;", "\"")).optString("Audio", "").toLowerCase().equals("slk"))
      {
        localObject = new QQRecorder.RecorderParam(bbjg.b, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(bbjg.jdField_a_of_type_Int, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "DeviceMsgChatPie";
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 810	com/tencent/mobileqq/activity/BaseChatPie:a	(IILandroid/content/Intent;)V
    //   7: bipush 84
    //   9: iload_1
    //   10: if_icmpne +190 -> 200
    //   13: aload_3
    //   14: ifnull +186 -> 200
    //   17: aload_0
    //   18: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 51
    //   23: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   26: checkcast 367	yah
    //   29: aload_0
    //   30: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   33: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokestatic 365	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   39: invokevirtual 475	yah:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   42: astore 9
    //   44: aload_3
    //   45: ldc_w 394
    //   48: invokevirtual 397	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   51: astore 10
    //   53: new 301	android/content/Intent
    //   56: dup
    //   57: invokespecial 523	android/content/Intent:<init>	()V
    //   60: astore 11
    //   62: aload 11
    //   64: ldc_w 394
    //   67: aload 10
    //   69: invokevirtual 527	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   72: pop
    //   73: aload 11
    //   75: ldc_w 529
    //   78: iconst_1
    //   79: invokevirtual 533	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   82: pop
    //   83: aload 11
    //   85: ldc_w 535
    //   88: aload 9
    //   90: invokevirtual 538	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload 11
    //   96: ldc_w 557
    //   99: ldc_w 559
    //   102: invokevirtual 555	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   105: pop
    //   106: aload 11
    //   108: ldc_w 550
    //   111: ldc_w 812
    //   114: invokevirtual 555	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   117: pop
    //   118: invokestatic 564	bhwm:a	()Lbhwm;
    //   121: aload_0
    //   122: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   125: aload_0
    //   126: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: aload_0
    //   130: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   133: invokevirtual 567	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   136: aload 11
    //   138: ldc_w 569
    //   141: bipush 102
    //   143: aconst_null
    //   144: ldc_w 571
    //   147: invokevirtual 574	bhwm:a	(Landroid/app/Activity;Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;ILandroid/content/DialogInterface$OnDismissListener;Ljava/lang/Class;)V
    //   150: iload_1
    //   151: tableswitch	default:+25 -> 176, 81:+602->753, 82:+25->176, 83:+670->821
    //   177: getfield 65	aent:jdField_r_of_type_Int	I
    //   180: iconst_4
    //   181: if_icmpne +18 -> 199
    //   184: iload_2
    //   185: iconst_m1
    //   186: if_icmpne +13 -> 199
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpne +8 -> 199
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 73	aent:Y	Z
    //   199: return
    //   200: iload_1
    //   201: bipush 102
    //   203: if_icmpne +20 -> 223
    //   206: iload_2
    //   207: iconst_m1
    //   208: if_icmpne -58 -> 150
    //   211: aload_3
    //   212: ifnull -62 -> 150
    //   215: aload_0
    //   216: aload_3
    //   217: invokespecial 403	aent:i	(Landroid/content/Intent;)V
    //   220: goto -70 -> 150
    //   223: bipush 81
    //   225: iload_1
    //   226: if_icmpeq +9 -> 235
    //   229: bipush 83
    //   231: iload_1
    //   232: if_icmpne +441 -> 673
    //   235: aload_0
    //   236: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 51
    //   241: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   244: checkcast 367	yah
    //   247: astore 10
    //   249: aload 10
    //   251: aload_0
    //   252: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   255: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   258: invokestatic 365	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   261: invokevirtual 475	yah:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +834 -> 1102
    //   271: aload 10
    //   273: aload 9
    //   275: getfield 480	com/tencent/device/datadef/DeviceInfo:productId	I
    //   278: invokevirtual 483	yah:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   281: astore 10
    //   283: aload 10
    //   285: ifnull +817 -> 1102
    //   288: aload 10
    //   290: iconst_2
    //   291: invokevirtual 489	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   294: ifeq +808 -> 1102
    //   297: iconst_1
    //   298: istore 4
    //   300: lconst_0
    //   301: lstore 6
    //   303: iconst_0
    //   304: istore 5
    //   306: aload 9
    //   308: ifnull +17 -> 325
    //   311: aload 9
    //   313: getfield 492	com/tencent/device/datadef/DeviceInfo:din	J
    //   316: lstore 6
    //   318: aload 9
    //   320: getfield 480	com/tencent/device/datadef/DeviceInfo:productId	I
    //   323: istore 5
    //   325: iload 4
    //   327: ifne +34 -> 361
    //   330: aload_0
    //   331: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 49
    //   336: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   339: checkcast 148	yer
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: lload 6
    //   349: ldc_w 494
    //   352: bipush 7
    //   354: iconst_0
    //   355: iload 5
    //   357: invokestatic 499	ymt:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   360: return
    //   361: aload_0
    //   362: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   365: aload_0
    //   366: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   369: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   372: aconst_null
    //   373: ldc_w 814
    //   376: iconst_1
    //   377: invokestatic 820	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   380: istore 8
    //   382: getstatic 576	aent:X	Z
    //   385: ifeq +61 -> 446
    //   388: iload 8
    //   390: ifeq +56 -> 446
    //   393: aload_0
    //   394: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   397: bipush 49
    //   399: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   402: checkcast 148	yer
    //   405: aload_0
    //   406: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   409: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: ldc_w 821
    //   415: invokestatic 596	ajya:a	(I)Ljava/lang/String;
    //   418: invokestatic 826	awzy:a	()J
    //   421: iconst_1
    //   422: iconst_0
    //   423: iconst_1
    //   424: invokevirtual 829	yer:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   427: aload_0
    //   428: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   431: aload_0
    //   432: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   435: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   438: aconst_null
    //   439: ldc_w 814
    //   442: iconst_0
    //   443: invokestatic 833	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   446: getstatic 838	android/os/Build$VERSION:SDK_INT	I
    //   449: bipush 10
    //   451: if_icmpgt -301 -> 150
    //   454: aconst_null
    //   455: astore 10
    //   457: aload_0
    //   458: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   461: invokevirtual 842	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   464: aload_3
    //   465: invokevirtual 846	android/content/Intent:getData	()Landroid/net/Uri;
    //   468: ldc_w 847
    //   471: invokevirtual 853	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   474: astore 9
    //   476: aload 9
    //   478: ifnull +135 -> 613
    //   481: aload 9
    //   483: invokevirtual 859	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   486: astore 9
    //   488: new 861	java/io/FileOutputStream
    //   491: dup
    //   492: new 863	java/io/File
    //   495: dup
    //   496: aload_0
    //   497: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   500: invokevirtual 867	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   503: invokestatic 873	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   506: ldc_w 875
    //   509: ldc 53
    //   511: invokeinterface 877 3 0
    //   516: invokespecial 878	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: invokespecial 881	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   522: astore 11
    //   524: sipush 1024
    //   527: newarray byte
    //   529: astore 13
    //   531: aload 9
    //   533: aload 13
    //   535: invokevirtual 887	java/io/FileInputStream:read	([B)I
    //   538: istore 4
    //   540: aload 11
    //   542: astore 12
    //   544: aload 9
    //   546: astore 10
    //   548: iload 4
    //   550: ifle +69 -> 619
    //   553: aload 11
    //   555: aload 13
    //   557: iconst_0
    //   558: iload 4
    //   560: invokevirtual 891	java/io/FileOutputStream:write	([BII)V
    //   563: goto -32 -> 531
    //   566: astore 12
    //   568: aload 9
    //   570: astore 10
    //   572: aload 11
    //   574: astore 9
    //   576: aload 12
    //   578: astore 11
    //   580: aload 11
    //   582: invokevirtual 661	java/lang/Exception:printStackTrace	()V
    //   585: aload 10
    //   587: ifnull +8 -> 595
    //   590: aload 10
    //   592: invokevirtual 894	java/io/FileInputStream:close	()V
    //   595: aload 9
    //   597: ifnull -447 -> 150
    //   600: aload 9
    //   602: invokevirtual 895	java/io/FileOutputStream:close	()V
    //   605: goto -455 -> 150
    //   608: astore 9
    //   610: goto -460 -> 150
    //   613: aconst_null
    //   614: astore 10
    //   616: aconst_null
    //   617: astore 12
    //   619: aload 10
    //   621: ifnull +8 -> 629
    //   624: aload 10
    //   626: invokevirtual 894	java/io/FileInputStream:close	()V
    //   629: aload 12
    //   631: ifnull -481 -> 150
    //   634: aload 12
    //   636: invokevirtual 895	java/io/FileOutputStream:close	()V
    //   639: goto -489 -> 150
    //   642: astore 9
    //   644: goto -494 -> 150
    //   647: astore_3
    //   648: aconst_null
    //   649: astore 9
    //   651: aload 9
    //   653: ifnull +8 -> 661
    //   656: aload 9
    //   658: invokevirtual 894	java/io/FileInputStream:close	()V
    //   661: aload 10
    //   663: ifnull +8 -> 671
    //   666: aload 10
    //   668: invokevirtual 895	java/io/FileOutputStream:close	()V
    //   671: aload_3
    //   672: athrow
    //   673: iload_1
    //   674: getstatic 41	aent:t	I
    //   677: if_icmpne -527 -> 150
    //   680: iload_2
    //   681: getstatic 43	aent:jdField_u_of_type_Int	I
    //   684: if_icmpne +54 -> 738
    //   687: aload_0
    //   688: invokevirtual 522	aent:H	()V
    //   691: aload_0
    //   692: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   695: bipush 51
    //   697: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   700: checkcast 367	yah
    //   703: aload_0
    //   704: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   707: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   710: invokestatic 365	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   713: invokevirtual 475	yah:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   716: invokestatic 900	ymu:a	(Lcom/tencent/device/datadef/DeviceInfo;)Ljava/lang/String;
    //   719: astore 9
    //   721: aload 9
    //   723: ifnull -573 -> 150
    //   726: aload_0
    //   727: getfield 902	aent:e	Landroid/widget/TextView;
    //   730: aload 9
    //   732: invokevirtual 908	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   735: goto -585 -> 150
    //   738: iload_2
    //   739: getstatic 45	aent:jdField_v_of_type_Int	I
    //   742: if_icmpne -51 -> 691
    //   745: aload_0
    //   746: iconst_1
    //   747: putfield 195	aent:aa	Z
    //   750: goto -59 -> 691
    //   753: iload_2
    //   754: iconst_m1
    //   755: if_icmpne -579 -> 176
    //   758: aload_3
    //   759: ifnull -583 -> 176
    //   762: aload_3
    //   763: ldc_w 910
    //   766: invokevirtual 397	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   769: astore_3
    //   770: aload_3
    //   771: ifnull -595 -> 176
    //   774: aload_3
    //   775: invokevirtual 400	java/util/ArrayList:size	()I
    //   778: ifle -602 -> 176
    //   781: aload_0
    //   782: aload_3
    //   783: iconst_0
    //   784: invokevirtual 913	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   787: checkcast 915	com/dataline/util/file/SendInfo
    //   790: invokevirtual 917	com/dataline/util/file/SendInfo:a	()Ljava/lang/String;
    //   793: putfield 55	aent:g	Ljava/lang/String;
    //   796: aload_0
    //   797: getfield 238	aent:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   800: aload_0
    //   801: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   804: aload_0
    //   805: getfield 355	aent:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   808: getfield 359	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   811: aload_0
    //   812: getfield 55	aent:g	Ljava/lang/String;
    //   815: invokestatic 922	ybo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   818: goto -642 -> 176
    //   821: aload_0
    //   822: aload_0
    //   823: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   826: invokevirtual 867	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   829: invokestatic 873	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   832: ldc_w 875
    //   835: ldc 53
    //   837: invokeinterface 877 3 0
    //   842: putfield 55	aent:g	Ljava/lang/String;
    //   845: aload_0
    //   846: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   849: invokevirtual 867	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   852: invokestatic 873	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   855: invokeinterface 926 1 0
    //   860: ldc_w 875
    //   863: invokeinterface 932 2 0
    //   868: invokeinterface 935 1 0
    //   873: pop
    //   874: iload_2
    //   875: iconst_m1
    //   876: if_icmpne +139 -> 1015
    //   879: aload_0
    //   880: getfield 55	aent:g	Ljava/lang/String;
    //   883: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   886: ifne -710 -> 176
    //   889: aload_0
    //   890: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   893: sipush 230
    //   896: invokestatic 938	bbdj:a	(Landroid/content/Context;I)Lbbgu;
    //   899: astore_3
    //   900: aload_3
    //   901: ldc_w 939
    //   904: new 941	aenw
    //   907: dup
    //   908: aload_0
    //   909: invokespecial 942	aenw:<init>	(Laent;)V
    //   912: invokevirtual 946	bbgu:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbbgu;
    //   915: pop
    //   916: aload_3
    //   917: ldc_w 947
    //   920: new 949	aenx
    //   923: dup
    //   924: aload_0
    //   925: invokespecial 950	aenx:<init>	(Laent;)V
    //   928: invokevirtual 953	bbgu:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbbgu;
    //   931: pop
    //   932: aload_3
    //   933: ldc_w 954
    //   936: invokestatic 596	ajya:a	(I)Ljava/lang/String;
    //   939: invokevirtual 958	bbgu:setTitle	(Ljava/lang/String;)Lbbgu;
    //   942: pop
    //   943: new 863	java/io/File
    //   946: dup
    //   947: aload_0
    //   948: getfield 55	aent:g	Ljava/lang/String;
    //   951: invokespecial 878	java/io/File:<init>	(Ljava/lang/String;)V
    //   954: astore 9
    //   956: aload_0
    //   957: getfield 230	aent:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   960: aload 9
    //   962: invokevirtual 961	java/io/File:length	()J
    //   965: invokestatic 966	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;J)Ljava/lang/String;
    //   968: astore 9
    //   970: aload_3
    //   971: new 169	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 967
    //   981: invokestatic 596	ajya:a	(I)Ljava/lang/String;
    //   984: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload 9
    //   989: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 968
    //   995: invokestatic 596	ajya:a	(I)Ljava/lang/String;
    //   998: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokevirtual 972	bbgu:setMessage	(Ljava/lang/CharSequence;)Lbbgu;
    //   1007: pop
    //   1008: aload_3
    //   1009: invokevirtual 648	bbgu:show	()V
    //   1012: goto -836 -> 176
    //   1015: aload_0
    //   1016: getfield 55	aent:g	Ljava/lang/String;
    //   1019: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1022: ifne +11 -> 1033
    //   1025: aload_0
    //   1026: getfield 55	aent:g	Ljava/lang/String;
    //   1029: invokestatic 977	bbdx:d	(Ljava/lang/String;)Z
    //   1032: pop
    //   1033: aload_0
    //   1034: ldc 53
    //   1036: putfield 55	aent:g	Ljava/lang/String;
    //   1039: goto -863 -> 176
    //   1042: astore 9
    //   1044: goto -373 -> 671
    //   1047: astore_3
    //   1048: goto -397 -> 651
    //   1051: astore_3
    //   1052: aload 11
    //   1054: astore 10
    //   1056: goto -405 -> 651
    //   1059: astore_3
    //   1060: aload 10
    //   1062: astore 11
    //   1064: aload 9
    //   1066: astore 10
    //   1068: aload 11
    //   1070: astore 9
    //   1072: goto -421 -> 651
    //   1075: astore 11
    //   1077: aconst_null
    //   1078: astore 10
    //   1080: aconst_null
    //   1081: astore 9
    //   1083: goto -503 -> 580
    //   1086: astore 11
    //   1088: aconst_null
    //   1089: astore 12
    //   1091: aload 9
    //   1093: astore 10
    //   1095: aload 12
    //   1097: astore 9
    //   1099: goto -519 -> 580
    //   1102: iconst_0
    //   1103: istore 4
    //   1105: goto -805 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1108	0	this	aent
    //   0	1108	1	paramInt1	int
    //   0	1108	2	paramInt2	int
    //   0	1108	3	paramIntent	Intent
    //   298	806	4	i	int
    //   304	52	5	j	int
    //   301	47	6	l	long
    //   380	9	8	bool	boolean
    //   42	559	9	localObject1	Object
    //   608	1	9	localException1	Exception
    //   642	1	9	localException2	Exception
    //   649	339	9	localObject2	Object
    //   1042	23	9	localException3	Exception
    //   1070	28	9	localObject3	Object
    //   51	1043	10	localObject4	Object
    //   60	1009	11	localObject5	Object
    //   1075	1	11	localException4	Exception
    //   1086	1	11	localException5	Exception
    //   542	1	12	localObject6	Object
    //   566	11	12	localException6	Exception
    //   617	479	12	localObject7	Object
    //   529	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   524	531	566	java/lang/Exception
    //   531	540	566	java/lang/Exception
    //   553	563	566	java/lang/Exception
    //   590	595	608	java/lang/Exception
    //   600	605	608	java/lang/Exception
    //   624	629	642	java/lang/Exception
    //   634	639	642	java/lang/Exception
    //   457	476	647	finally
    //   481	488	647	finally
    //   656	661	1042	java/lang/Exception
    //   666	671	1042	java/lang/Exception
    //   488	524	1047	finally
    //   524	531	1051	finally
    //   531	540	1051	finally
    //   553	563	1051	finally
    //   580	585	1059	finally
    //   457	476	1075	java/lang/Exception
    //   481	488	1075	java/lang/Exception
    //   488	524	1086	java/lang/Exception
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    if (i == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        super.a(paramObject);
        return;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        acxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, true);
        continue;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        aO();
        continue;
        aeft.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Object localObject = new apuf();
        ((apuf)localObject).b = "send_file";
        ((apuf)localObject).jdField_a_of_type_Int = 1;
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apuf)localObject);
        localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((yah)localObject).c(l)) && (((yah)localObject).a(l, 17))) {
          acxs.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          acxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
    } while (!this.Z);
    acxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (!this.T) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label298;
      }
      axug.a(paramString, false);
      axug.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label528;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= bcaj.jdField_a_of_type_Int) {
        break label522;
      }
      paramRecorderParam = bcaj.a(paramString, paramInt1);
      if (!new File(paramRecorderParam).exists()) {
        break label306;
      }
      paramString = paramRecorderParam;
    }
    label522:
    label528:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      yah localyah = null;
      paramRecorderParam = localyah;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localyah;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);; paramRecorderParam = ybl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.a(0, paramString, paramRecorderParam.uniseq);
        if ((!X) || (!this.W)) {
          break label467;
        }
        if ((bbfj.d(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
          break label352;
        }
        paramString = (MessageForDevPtt)paramRecorderParam;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
        return;
        paramInt1 = 0;
        break;
        avbt.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localyah = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramInt1 = localyah.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramString, QQRecorder.a(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localyah.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (paramString == null) {
        break;
      }
      ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label467:
      ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(yer.f, paramString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject1 = ((yah)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((yah)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 1, 0, i);
      this.T = bool;
      if (!bool)
      {
        paramString = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = bbjg.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        i = 1;
        label205:
        if (i != 0) {
          break label276;
        }
        axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        axug.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label243:
        if (paramString == null) {
          break label292;
        }
        if (paramBoolean) {
          break label294;
        }
        this.jdField_b_of_type_Long = 0L;
        l(2131230745);
      }
      for (;;)
      {
        b(true, false);
        return;
        i = 0;
        break label205;
        label276:
        avbt.a(paramString);
        avbt.a(paramString, (byte[])localObject1, localObject1.length);
        break label243;
        label292:
        break;
        label294:
        paramString = ybl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_b_of_type_Long = paramString.uniseq;
        }
        l(2131230733);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.G = false;
    this.N = false;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null)
    {
      super.H();
      return true;
    }
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!akwf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        CheckPermission.requestStorePermission(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new aenu(this));
        return true;
      }
      bq();
      return true;
    }
    bq();
    return true;
  }
  
  public void b(String paramString)
  {
    if (this.T) {
      super.b(paramString);
    }
  }
  
  public void b(List<String> paramList)
  {
    yer localyer = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    if ((X) && (this.W))
    {
      localyer.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localyer.a().a(yer.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public void bo()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = i;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((yah)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (bfnz.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.q = localDeviceInfo.productId;
    }
    for (;;)
    {
      X = ((yah)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      boolean bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
      if (localProductInfo != null)
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          this.V = true;
        }
        if ((!bool2) && ((localDeviceInfo.SSOBid_Platform == 1027) || ((!bbkk.a(localDeviceInfo.SSOBid_Version)) && (Double.valueOf(localDeviceInfo.SSOBid_Version).doubleValue() >= 1.1D))))
        {
          this.W = true;
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
        }
      }
      else
      {
        if ((this.V) && (this.W) && (localDeviceInfo != null)) {
          ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, localDeviceInfo.productId);
        }
        if ((localProductInfo != null) && (bool1))
        {
          if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
            break label565;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691605);
          label380:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            if ((this.V) && (localDeviceInfo.isAdmin == 1) && (this.W) && (!X))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691633);
              ((yer)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, awzy.a(), true, false, true);
            }
            SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
          }
        }
        if (QLog.isColorLevel())
        {
          if (localProductInfo == null) {
            break label907;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
        }
      }
      for (;;)
      {
        bp();
        return;
        if ((!bool2) && (!X)) {
          break;
        }
        this.W = true;
        break;
        label565:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691631);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691632) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691553) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691559) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691609) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691636) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691630);
        break label380;
        label907:
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void bp()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {}
    for (localObject = ((yah)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
        }
        for (;;)
        {
          if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          return;
          if (((ProductInfo)localObject).isSupportMainMsgType(15))
          {
            if ((((ProductInfo)localObject).isSupportFuncMsgType(3)) || (((ProductInfo)localObject).isSupportFuncMsgType(1)) || (!((ProductInfo)localObject).isSupportFuncMsgType(2))) {}
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(8))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (bfnz.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (bfnz.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(1))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
              if (bfnz.e()) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              localLayoutParams.leftMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(2))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
              if (bfnz.e()) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (bfnz.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
            }
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720671));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167055));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void c()
  {
    boolean bool = true;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      auns.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719284, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      Object localObject2 = ((yah)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject2 != null)
      {
        localObject3 = ((yah)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l = 0L;
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        for (int j = ((DeviceInfo)localObject2).productId;; j = 0)
        {
          if (i == 0)
          {
            localObject1 = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, j);
            return;
          }
          localObject2 = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if ((!X) || (!this.W)) {
              break label267;
            }
          }
          for (;;)
          {
            ((yer)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 6, 0, j);
            return;
            label267:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void c(List<String> paramList)
  {
    Intent localIntent = new Intent();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", str);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        aunv localaunv1 = aunl.a(2, 1007);
        aunl.a(1007, localIntent);
        aunv localaunv2 = aunl.a(1, 1007);
        localaunv2.a(localaunv1.jdField_a_of_type_JavaLangString);
        if (localaunv2.a(aunl.a(1007, localIntent)))
        {
          localaunv2.jdField_a_of_type_Aejh = new aeob(this);
          aunl.a(localaunv2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else
        {
          f(str);
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
  }
  
  public void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if (i == 2147483647) {}
    String str;
    yer localyer;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (i != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localyer = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((X) && (this.W)) {}
    for (boolean bool = true;; bool = false)
    {
      localyer.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.f(paramIntent);
  }
  
  public void f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  public boolean f()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean g()
  {
    Object localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((yah)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((yah)localObject).a(localDeviceInfo.productId);
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 1) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 1)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 2)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 3)) {
          return true;
        }
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 9) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
    }
  }
  
  public void q()
  {
    super.q();
    if ((this.jdField_r_of_type_Int == 1) || (this.jdField_r_of_type_Int == 3) || (this.jdField_r_of_type_Int == 9)) {
      if ((PanelIconLinearLayout)this.c.findViewById(2131371243) != null) {
        a(Integer.valueOf(4));
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_r_of_type_Int + "], find view panelicons failed!!");
          return;
          if ((this.jdField_r_of_type_Int != 2) && (this.jdField_r_of_type_Int != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.c.findViewById(2131371243) != null)
          {
            a(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_r_of_type_Int + "], find view panelicons failed!!");
        return;
      } while (this.jdField_r_of_type_Int == 5);
      if (this.jdField_r_of_type_Int == 6)
      {
        aeft.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      apuf localapuf;
      if (this.jdField_r_of_type_Int == 7)
      {
        localapuf = new apuf();
        localapuf.b = "send_file";
        localapuf.jdField_a_of_type_Int = 1;
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapuf);
        acxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_s_of_type_Int, false);
        return;
      }
      if (this.jdField_r_of_type_Int == 8)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
      }
      if (this.jdField_r_of_type_Int == 10)
      {
        localapuf = new apuf();
        localapuf.b = "send_file";
        localapuf.jdField_a_of_type_Int = 1;
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapuf);
        acxs.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    } while (this.jdField_r_of_type_Int != 11);
    a(Integer.valueOf(13));
  }
  
  public void s()
  {
    if (this.d != null)
    {
      if (mau.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.d.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(ajsd.y))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      bhwm.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", t, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      int i = 0;
      long l = 0L;
      if (localObject != null)
      {
        i = ((DeviceInfo)localObject).productId;
        l = ((DeviceInfo)localObject).din;
      }
      ymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_Menu", 1, 0, i);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new ymi(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    bhwm.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", t, null, SmartDevicePluginProxyActivity.class);
    if (this.p != null) {
      this.p.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130839291, 2130839291);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131696721));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aent
 * JD-Core Version:    0.7.0.1
 */