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
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import com.dataline.util.file.SendInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
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

public class ahzf
  extends BaseChatPie
{
  public static boolean W;
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int t;
  static int u;
  static int v = 11;
  boolean S = false;
  public volatile boolean T;
  boolean U = false;
  boolean V = false;
  boolean X = false;
  boolean Y = false;
  private boolean Z;
  BroadcastReceiver a;
  protected Boolean a;
  public String g = "";
  private ImageView l;
  public int q;
  int r;
  int s = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    jdField_t_of_type_Int = 100100;
    jdField_u_of_type_Int = 10;
  }
  
  public ahzf(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ahzm(this);
  }
  
  private void a(int paramInt, FrameLayout.LayoutParams paramLayoutParams, ProductInfo paramProductInfo)
  {
    if (paramProductInfo.isSupportMainMsgType(15)) {
      if (!paramProductInfo.isSupportFuncMsgType(3)) {}
    }
    do
    {
      do
      {
        return;
      } while ((paramProductInfo.isSupportFuncMsgType(1)) || (!paramProductInfo.isSupportFuncMsgType(2)));
      return;
      if (paramProductInfo.isSupportMainMsgType(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      if ((paramProductInfo.supportMainMsgType & 0xF) == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportMainMsgType(1))
      {
        if (paramProductInfo.isSupportFuncMsgType(3))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportMainMsgType(2))
      {
        if (paramProductInfo.isSupportFuncMsgType(3))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
      }
      if (paramProductInfo.isSupportFuncMsgType(3))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(1))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
    } while (!paramProductInfo.isSupportFuncMsgType(2));
    paramLayoutParams.rightMargin = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718956));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167192));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  private void a(DeviceInfo paramDeviceInfo)
  {
    if ((this.U) && (this.V) && (paramDeviceInfo != null)) {
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, paramDeviceInfo.productId);
    }
  }
  
  private void a(DeviceInfo paramDeviceInfo, ProductInfo paramProductInfo, boolean paramBoolean)
  {
    if (paramProductInfo != null)
    {
      if ((paramProductInfo.supportMainMsgType & 0xF) != 0) {
        this.U = true;
      }
      if ((paramBoolean) || ((paramDeviceInfo.SSOBid_Platform != 1027) && ((bgsp.a(paramDeviceInfo.SSOBid_Version)) || (Double.valueOf(paramDeviceInfo.SSOBid_Version).doubleValue() < 1.1D)))) {
        break label85;
      }
      this.V = true;
      SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
    }
    label85:
    while ((!paramBoolean) && (!W)) {
      return;
    }
    this.V = true;
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
      ((abux)paramQQAppInterface.a(49)).a().a(abux.c, paramString1, paramArrayList, localBundle);
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
  
  /* Error */
  private boolean a(Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 210	ahzf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 51
    //   15: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   18: checkcast 364	abqn
    //   21: astore 11
    //   23: aload 11
    //   25: aload_0
    //   26: getfield 252	ahzf:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   29: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: invokestatic 370	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: invokevirtual 373	abqn:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   38: astore 9
    //   40: aload 9
    //   42: ifnull +463 -> 505
    //   45: aload 11
    //   47: aload 9
    //   49: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   52: invokevirtual 376	abqn:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   55: astore 11
    //   57: aload 11
    //   59: ifnull +446 -> 505
    //   62: aload 11
    //   64: iconst_2
    //   65: invokevirtual 96	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   68: ifeq +437 -> 505
    //   71: iconst_1
    //   72: istore_2
    //   73: lconst_0
    //   74: lstore 6
    //   76: aload 9
    //   78: ifnull +422 -> 500
    //   81: aload 9
    //   83: getfield 216	com/tencent/device/datadef/DeviceInfo:din	J
    //   86: lstore 6
    //   88: aload 9
    //   90: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   93: istore_3
    //   94: iload_2
    //   95: ifne +38 -> 133
    //   98: aload_0
    //   99: getfield 210	ahzf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: bipush 49
    //   104: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   107: checkcast 315	abux
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 210	ahzf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   115: lload 6
    //   117: ldc_w 378
    //   120: bipush 7
    //   122: iconst_0
    //   123: iload_3
    //   124: invokestatic 226	accz:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   127: iconst_1
    //   128: istore 4
    //   130: iload 4
    //   132: ireturn
    //   133: aload_0
    //   134: getfield 139	ahzf:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   137: aload_0
    //   138: getfield 252	ahzf:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   141: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: aconst_null
    //   145: ldc_w 380
    //   148: iconst_1
    //   149: invokestatic 384	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   152: istore 4
    //   154: getstatic 266	ahzf:W	Z
    //   157: ifeq +61 -> 218
    //   160: iload 4
    //   162: ifeq +56 -> 218
    //   165: aload_0
    //   166: getfield 210	ahzf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: bipush 49
    //   171: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   174: checkcast 315	abux
    //   177: aload_0
    //   178: getfield 252	ahzf:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   181: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: ldc_w 385
    //   187: invokestatic 389	anni:a	(I)Ljava/lang/String;
    //   190: invokestatic 394	bbyp:a	()J
    //   193: iconst_1
    //   194: iconst_0
    //   195: iconst_1
    //   196: invokevirtual 397	abux:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   199: aload_0
    //   200: getfield 139	ahzf:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   203: aload_0
    //   204: getfield 252	ahzf:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   207: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: aconst_null
    //   211: ldc_w 380
    //   214: iconst_0
    //   215: invokestatic 264	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   218: iload 5
    //   220: istore 4
    //   222: getstatic 402	android/os/Build$VERSION:SDK_INT	I
    //   225: bipush 10
    //   227: if_icmpgt -97 -> 130
    //   230: aload_0
    //   231: getfield 139	ahzf:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   234: invokevirtual 406	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   237: aload_1
    //   238: invokevirtual 412	android/content/Intent:getData	()Landroid/net/Uri;
    //   241: ldc_w 413
    //   244: invokevirtual 419	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull +125 -> 374
    //   252: aload_1
    //   253: invokevirtual 425	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   256: astore_1
    //   257: new 427	java/io/FileOutputStream
    //   260: dup
    //   261: new 429	java/io/File
    //   264: dup
    //   265: aload_0
    //   266: getfield 139	ahzf:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   269: invokevirtual 433	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   272: invokestatic 439	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   275: ldc_w 441
    //   278: ldc 53
    //   280: invokeinterface 446 3 0
    //   285: invokespecial 447	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: invokespecial 450	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   291: astore 9
    //   293: sipush 1024
    //   296: newarray byte
    //   298: astore 11
    //   300: aload_1
    //   301: aload 11
    //   303: invokevirtual 456	java/io/FileInputStream:read	([B)I
    //   306: istore_2
    //   307: aload 9
    //   309: astore 10
    //   311: aload_1
    //   312: astore 8
    //   314: iload_2
    //   315: ifle +65 -> 380
    //   318: aload 9
    //   320: aload 11
    //   322: iconst_0
    //   323: iload_2
    //   324: invokevirtual 460	java/io/FileOutputStream:write	([BII)V
    //   327: goto -27 -> 300
    //   330: astore 10
    //   332: aload_1
    //   333: astore 8
    //   335: aload 9
    //   337: astore_1
    //   338: aload 10
    //   340: astore 9
    //   342: aload 9
    //   344: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   347: aload 8
    //   349: ifnull +8 -> 357
    //   352: aload 8
    //   354: invokevirtual 466	java/io/FileInputStream:close	()V
    //   357: iload 5
    //   359: istore 4
    //   361: aload_1
    //   362: ifnull -232 -> 130
    //   365: aload_1
    //   366: invokevirtual 467	java/io/FileOutputStream:close	()V
    //   369: iconst_0
    //   370: ireturn
    //   371: astore_1
    //   372: iconst_0
    //   373: ireturn
    //   374: aconst_null
    //   375: astore 10
    //   377: aconst_null
    //   378: astore 8
    //   380: aload 8
    //   382: ifnull +8 -> 390
    //   385: aload 8
    //   387: invokevirtual 466	java/io/FileInputStream:close	()V
    //   390: iload 5
    //   392: istore 4
    //   394: aload 10
    //   396: ifnull -266 -> 130
    //   399: aload 10
    //   401: invokevirtual 467	java/io/FileOutputStream:close	()V
    //   404: iconst_0
    //   405: ireturn
    //   406: astore_1
    //   407: iconst_0
    //   408: ireturn
    //   409: astore 8
    //   411: aconst_null
    //   412: astore_1
    //   413: aload 10
    //   415: astore 9
    //   417: aload_1
    //   418: ifnull +7 -> 425
    //   421: aload_1
    //   422: invokevirtual 466	java/io/FileInputStream:close	()V
    //   425: aload 9
    //   427: ifnull +8 -> 435
    //   430: aload 9
    //   432: invokevirtual 467	java/io/FileOutputStream:close	()V
    //   435: aload 8
    //   437: athrow
    //   438: astore_1
    //   439: goto -4 -> 435
    //   442: astore 8
    //   444: aload 10
    //   446: astore 9
    //   448: goto -31 -> 417
    //   451: astore 8
    //   453: goto -36 -> 417
    //   456: astore 11
    //   458: aload 8
    //   460: astore 9
    //   462: aload_1
    //   463: astore 10
    //   465: aload 11
    //   467: astore 8
    //   469: aload 9
    //   471: astore_1
    //   472: aload 10
    //   474: astore 9
    //   476: goto -59 -> 417
    //   479: astore 9
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -141 -> 342
    //   486: astore 9
    //   488: aconst_null
    //   489: astore 10
    //   491: aload_1
    //   492: astore 8
    //   494: aload 10
    //   496: astore_1
    //   497: goto -155 -> 342
    //   500: iconst_0
    //   501: istore_3
    //   502: goto -408 -> 94
    //   505: iconst_0
    //   506: istore_2
    //   507: goto -434 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	ahzf
    //   0	510	1	paramIntent	Intent
    //   72	435	2	i	int
    //   93	409	3	j	int
    //   128	265	4	bool1	boolean
    //   7	384	5	bool2	boolean
    //   74	42	6	l1	long
    //   4	382	8	localIntent1	Intent
    //   409	27	8	localObject1	Object
    //   442	1	8	localObject2	Object
    //   451	8	8	localObject3	Object
    //   467	26	8	localObject4	Object
    //   38	437	9	localObject5	Object
    //   479	1	9	localException1	Exception
    //   486	1	9	localException2	Exception
    //   1	309	10	localObject6	Object
    //   330	9	10	localException3	Exception
    //   375	120	10	localIntent2	Intent
    //   21	300	11	localObject7	Object
    //   456	10	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   293	300	330	java/lang/Exception
    //   300	307	330	java/lang/Exception
    //   318	327	330	java/lang/Exception
    //   352	357	371	java/lang/Exception
    //   365	369	371	java/lang/Exception
    //   385	390	406	java/lang/Exception
    //   399	404	406	java/lang/Exception
    //   230	248	409	finally
    //   252	257	409	finally
    //   421	425	438	java/lang/Exception
    //   430	435	438	java/lang/Exception
    //   257	293	442	finally
    //   293	300	451	finally
    //   300	307	451	finally
    //   318	327	451	finally
    //   342	347	456	finally
    //   230	248	479	java/lang/Exception
    //   252	257	479	java/lang/Exception
    //   257	293	486	java/lang/Exception
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
      localObject1 = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ((abux)localObject1).a().a();
      ((abux)localObject1).a().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      if (VersionUtils.isHoneycomb()) {
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
      this.T = true;
      localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.jdField_r_of_type_Int = ((Bundle)localObject2).getInt("operType", 0);
        this.s = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      localObject1 = (ImageView)this.c.findViewById(2131368961);
      if (localObject1 == null) {
        break label656;
      }
      ((ImageView)localObject1).setImageResource(2130839560);
    }
    label651:
    label656:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.c.findViewById(2131368956);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839559);
        ((ImageView)localObject3).setOnClickListener(new ahzh(this));
      }
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject3 = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      boolean bool;
      if ((((abqn)localObject3).c(l1)) && (((abqn)localObject3).a(l1, 17)))
      {
        bool = true;
        this.Y = bool;
        if (this.Y) {
          ((abqn)localObject3).a(l1, "", "", "", 0, null);
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
        if ((asfr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))) {
          break label651;
        }
      }
      for (;;)
      {
        if (((bool) && (((abqn)localObject3).d(l1))) || (i != 0))
        {
          this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368961);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368961);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.jdField_l_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
            this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850389);
          }
          this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
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
    Object localObject2 = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    int i = j;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((abqn)localObject2).a(localDeviceInfo.productId);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          i = 1;
        }
      }
    }
    long l1 = 0L;
    j = 0;
    if (localDeviceInfo != null)
    {
      l1 = localDeviceInfo.din;
      j = localDeviceInfo.productId;
    }
    if ((i == 0) && (this.jdField_r_of_type_Int != 4) && (this.jdField_r_of_type_Int != 3))
    {
      paramIntent = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, j);
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
          paramIntent = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((abqn)localObject2).a((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          I();
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
      ((Intent)localObject1).putExtra(bgkb.h, paramIntent.getIntExtra(bgkb.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      bmqo.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      if ((W) && (this.V))
      {
        ((abux)localObject2).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject1);
        accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendGroupMsg", 3, 0, j);
        return;
      }
      if (!this.Y) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(bgkb.h, paramIntent.getIntExtra(bgkb.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    bmqo.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131701964), 2000).a();
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
      if (bgnt.a(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      paramIntent = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696885), this.jdField_a_of_type_AndroidContentContext.getString(2131696672), anni.a(2131701979), anni.a(2131701980), new ahzk(this, localArrayList, paramIntent), new ahzl(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, paramIntent);
  }
  
  private void j(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getInt("cookie", 0);
      int j = paramIntent.getInt("err_code", 1);
      if ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        if (j != 0) {
          break label286;
        }
        if (!(paramIntent instanceof MessageForDevPtt)) {
          break label164;
        }
        paramIntent = (MessageForDevPtt)paramIntent;
        paramIntent.extraflag = 32770;
        paramIntent.fileSize = atvo.a(paramIntent.url);
        paramIntent.extStr = "device_groupchat";
        paramIntent.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
        ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(true));
      }
    }
    label286:
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(i));
      return;
      label164:
      if ((paramIntent instanceof MessageForDeviceFile))
      {
        ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(true));
      }
      else if ((paramIntent instanceof MessageForDevLittleVideo))
      {
        MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
        localMessageForDevLittleVideo.videoFileStatus = 1003;
        localMessageForDevLittleVideo.videoFileProgress = 100;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(true));
        continue;
        if ((paramIntent instanceof MessageForDevPtt))
        {
          paramIntent = (MessageForDevPtt)paramIntent;
          paramIntent.extraflag = 32768;
          paramIntent.extStr = "device_groupchat";
          paramIntent.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDeviceFile))
        {
          paramIntent = (MessageForDeviceFile)paramIntent;
          ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDevLittleVideo))
        {
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
          localMessageForDevLittleVideo.videoFileStatus = 1005;
          localMessageForDevLittleVideo.videoFileProgress = 0;
          localMessageForDevLittleVideo.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
          ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void k(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    float f;
    if (paramIntent != null)
    {
      int i = paramIntent.getInt("cookie", 0);
      f = paramIntent.getFloat("percent", 0.0F);
      if ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        if (!(paramIntent instanceof MessageForDeviceFile)) {
          break label111;
        }
        paramIntent = (MessageForDeviceFile)paramIntent;
        paramIntent.nFileStatus = 3;
        paramIntent.progress = f;
        paramIntent.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
      }
    }
    label111:
    while (!(paramIntent instanceof MessageForDevLittleVideo)) {
      return;
    }
    paramIntent = (MessageForDevLittleVideo)paramIntent;
    paramIntent.videoFileStatus = 1002;
    paramIntent.videoFileProgress = ((int)(100.0F * f));
    paramIntent.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
    ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramIntent, f);
  }
  
  private void z(int paramInt)
  {
    this.g = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()).getString("device_video_path", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()).edit().remove("device_video_path").commit();
    if (paramInt == -1)
    {
      if (!TextUtils.isEmpty(this.g))
      {
        bgpa localbgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
        localbgpa.setNegativeButton(2131690582, new ahzi(this));
        localbgpa.setPositiveButton(2131694081, new ahzj(this));
        localbgpa.setTitle(anni.a(2131701971));
        Object localObject = new File(this.g);
        localObject = ShortVideoUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ((File)localObject).length());
        localbgpa.setMessage(anni.a(2131701977) + (String)localObject + anni.a(2131701969));
        localbgpa.show();
      }
      return;
    }
    if (!TextUtils.isEmpty(this.g)) {
      bgmg.d(this.g);
    }
    this.g = "";
  }
  
  public boolean E()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean F()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean G()
  {
    if (F()) {
      return true;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      abqn localabqn = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localabqn != null) && (localabqn.c(l1)) && (localabqn.a(l1, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l1 = 0L;
      }
    }
    return false;
  }
  
  public void H()
  {
    if (this.M) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.H();
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_a_of_type_JavaLangString, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public boolean H()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean I()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public void P()
  {
    super.P();
    if ((this.jdField_r_of_type_Int == 3) || (this.jdField_r_of_type_Int == 4))
    {
      if (!this.X) {
        this.X = true;
      }
    }
    else {
      return;
    }
    super.I();
  }
  
  public void Q()
  {
    bgoa.a();
    this.jdField_a_of_type_Aglu.a(20);
    afur.a(false);
    this.j = false;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.L = true;
    this.M = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.i = null;
    }
    if (this.jdField_a_of_type_Aimj != null) {
      this.jdField_a_of_type_Aimj.a();
    }
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
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
    Object localObject = ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localObject = new acco().a((DeviceInfo)localObject);
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
        localObject = new QQRecorder.RecorderParam(bgrn.b, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(bgrn.jdField_a_of_type_Int, 0, 0);
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((84 == paramInt1) && (paramIntent != null))
    {
      localObject = ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
      localIntent.putExtra("sIsCloudPrinter", true);
      localIntent.putExtra("device_info", (Parcelable)localObject);
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      localIntent.putExtra("filetype", "file");
      bmqo.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_r_of_type_Int == 4) && (paramInt2 == -1) && (paramInt1 == 1)) {
        this.X = false;
      }
      return;
      if (paramInt1 == 102)
      {
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break;
        }
        i(paramIntent);
        break;
      }
      if ((81 == paramInt1) || (83 == paramInt1))
      {
        if (!a(paramIntent)) {
          break;
        }
        return;
      }
      if (paramInt1 != jdField_t_of_type_Int) {
        break;
      }
      if (paramInt2 == jdField_u_of_type_Int) {
        I();
      }
      for (;;)
      {
        localObject = acda.a(((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
        if (localObject == null) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
        if (paramInt2 == v) {
          this.Z = true;
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          this.g = ((SendInfo)paramIntent.get(0)).a();
          abru.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g);
          continue;
          z(paramInt2);
        }
      }
    }
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
        agaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, true);
        continue;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        aN();
        continue;
        ahqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Object localObject = new atvn();
        ((atvn)localObject).b = "send_file";
        ((atvn)localObject).jdField_a_of_type_Int = 1;
        atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (atvn)localObject);
        localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((abqn)localObject).c(l1)) && (((abqn)localObject).a(l1, 17))) {
          agaa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          agaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
    } while (!this.Y);
    agaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (!this.S) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label298;
      }
      bcvj.a(paramString, false);
      bcvj.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label528;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= bhkv.jdField_a_of_type_Int) {
        break label522;
      }
      paramRecorderParam = bhkv.a(paramString, paramInt1);
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
      abqn localabqn = null;
      paramRecorderParam = localabqn;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localabqn;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);; paramRecorderParam = abrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.a(0, paramString, paramRecorderParam.uniseq);
        if ((!W) || (!this.V)) {
          break label467;
        }
        if ((bgnt.d(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
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
        azte.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localabqn = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramInt1 = localabqn.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramString, QQRecorder.a(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localabqn.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (paramString == null) {
        break;
      }
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label467:
      ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(abux.f, paramString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject1 = ((abqn)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((abqn)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l1 = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l1 = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 1, 0, i);
      this.S = bool;
      if (!bool)
      {
        paramString = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = bgrn.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        i = 1;
        label205:
        if (i != 0) {
          break label276;
        }
        bcvj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        bcvj.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label243:
        if (paramString == null) {
          break label292;
        }
        if (paramBoolean) {
          break label294;
        }
        this.jdField_b_of_type_Long = 0L;
        m(2131230745);
      }
      for (;;)
      {
        b(true, false);
        return;
        i = 0;
        break label205;
        label276:
        azte.a(paramString);
        azte.a(paramString, (byte[])localObject1, localObject1.length);
        break label243;
        label292:
        break;
        label294:
        paramString = abrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_b_of_type_Long = paramString.uniseq;
        }
        m(2131230733);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.F = false;
    this.M = false;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null)
    {
      super.I();
      return true;
    }
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!aoqb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        CheckPermission.requestStorePermission(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new ahzg(this));
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
    if (this.S) {
      super.b(paramString);
    }
  }
  
  public void b(List<String> paramList)
  {
    abux localabux = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    if ((W) && (this.V))
    {
      localabux.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localabux.a().a(abux.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public void bo()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = i;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((abqn)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_q_of_type_Int = localDeviceInfo.productId;
    }
    for (;;)
    {
      W = ((abqn)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      a(localDeviceInfo, localProductInfo, SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false));
      a(localDeviceInfo);
      if ((localProductInfo != null) && (bool))
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          break label422;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691406);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          if ((this.U) && (localDeviceInfo.isAdmin == 1) && (this.V) && (!W))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691430);
            ((abux)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, bbyp.a(), true, false, true);
          }
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
        }
      }
      if (QLog.isColorLevel())
      {
        if (localProductInfo == null) {
          break label749;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
      }
      for (;;)
      {
        bp();
        return;
        label422:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691428);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691429) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691359) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691365) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691408) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691433) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691427);
        break;
        label749:
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void bp()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {}
    for (localObject = ((abqn)localObject).a(localDeviceInfo.productId);; localObject = null)
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
          a(i, localLayoutParams, (ProductInfo)localObject);
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
      ayxu.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131717764, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      Object localObject2 = ((abqn)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject2 != null)
      {
        localObject3 = ((abqn)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l1 = 0L;
        if (localObject2 != null) {
          l1 = ((DeviceInfo)localObject2).din;
        }
        for (int j = ((DeviceInfo)localObject2).productId;; j = 0)
        {
          if (i == 0)
          {
            localObject1 = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, j);
            return;
          }
          localObject2 = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if ((!W) || (!this.V)) {
              break label267;
            }
          }
          for (;;)
          {
            ((abux)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 6, 0, j);
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
        ayxx localayxx1 = ayxn.a(2, 1007);
        ayxn.a(1007, localIntent);
        ayxx localayxx2 = ayxn.a(1, 1007);
        localayxx2.a(localayxx1.jdField_a_of_type_JavaLangString);
        if (localayxx2.a(ayxn.a(1007, localIntent)))
        {
          localayxx2.jdField_a_of_type_Ahur = new ahzn(this);
          ayxn.a(localayxx2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else
        {
          g(str);
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    super.f(paramInt);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
  }
  
  public void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if (i == 2147483647) {}
    String str;
    abux localabux;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (i != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localabux = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((W) && (this.V)) {}
    for (boolean bool = true;; bool = false)
    {
      localabux.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.f(paramIntent);
  }
  
  public boolean f()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public void g(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  public boolean g()
  {
    Object localObject = (abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((abqn)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((abqn)localObject).a(localDeviceInfo.productId);
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
      if ((PanelIconLinearLayout)this.c.findViewById(2131372148) != null) {
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
          if ((PanelIconLinearLayout)this.c.findViewById(2131372148) != null)
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
        ahqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      atvn localatvn;
      if (this.jdField_r_of_type_Int == 7)
      {
        localatvn = new atvn();
        localatvn.b = "send_file";
        localatvn.jdField_a_of_type_Int = 1;
        atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatvn);
        agaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.s, false);
        return;
      }
      if (this.jdField_r_of_type_Int == 8)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
      }
      if (this.jdField_r_of_type_Int == 10)
      {
        localatvn = new atvn();
        localatvn.b = "send_file";
        localatvn.jdField_a_of_type_Int = 1;
        atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatvn);
        agaa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    } while (this.jdField_r_of_type_Int != 11);
    a(Integer.valueOf(13));
  }
  
  public void r()
  {
    if (this.d != null)
    {
      if (mal.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(anhk.y))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      bmqo.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", jdField_t_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      int i = 0;
      long l1 = 0L;
      if (localObject != null)
      {
        i = ((DeviceInfo)localObject).productId;
        l1 = ((DeviceInfo)localObject).din;
      }
      accz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_Menu", 1, 0, i);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new acco(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    bmqo.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", jdField_t_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    if (this.jdField_l_of_type_AndroidWidgetImageView != null) {
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130839560, 2130839560);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131695720));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzf
 * JD-Core Version:    0.7.0.1
 */