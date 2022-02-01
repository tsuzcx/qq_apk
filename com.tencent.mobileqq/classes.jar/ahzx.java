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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
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

public class ahzx
  extends BaseChatPie
{
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int jdField_d_of_type_Int;
  static int jdField_e_of_type_Int;
  static int f;
  public static boolean f;
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aiae(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected Boolean a;
  int jdField_b_of_type_Int = 0;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public volatile boolean c;
  boolean jdField_d_of_type_Boolean = false;
  boolean jdField_e_of_type_Boolean = false;
  boolean g = false;
  public boolean h;
  private boolean i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    jdField_d_of_type_Int = 100100;
    jdField_e_of_type_Int = 10;
    jdField_f_of_type_Int = 11;
  }
  
  public ahzx(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = PreferenceManager.getDefaultSharedPreferences(this.mActivity.getApplicationContext()).getString("device_video_path", "");
    PreferenceManager.getDefaultSharedPreferences(this.mActivity.getApplicationContext()).edit().remove("device_video_path").commit();
    if (paramInt == -1)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        QQCustomDialog localQQCustomDialog = bhdj.a(this.mActivity, 230);
        localQQCustomDialog.setNegativeButton(2131690697, new aiaa(this));
        localQQCustomDialog.setPositiveButton(2131694399, new aiab(this));
        localQQCustomDialog.setTitle(anvx.a(2131702664));
        Object localObject = new File(this.jdField_b_of_type_JavaLangString);
        localObject = ShortVideoUtils.stringForFileSize(this.mActivity, ((File)localObject).length());
        localQQCustomDialog.setMessage(anvx.a(2131702670) + (String)localObject + anvx.a(2131702662));
        localQQCustomDialog.show();
      }
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      FileUtils.deleteFile(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_JavaLangString = "";
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
        this.panelicons.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.input.setLayoutParams(paramLayoutParams);
        return;
      }
      if ((paramProductInfo.supportMainMsgType & 0xF) == 3)
      {
        this.panelicons.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.input.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportMainMsgType(1))
      {
        if (paramProductInfo.isSupportFuncMsgType(3))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.input.setLayoutParams(paramLayoutParams);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.input.setLayoutParams(paramLayoutParams);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          paramLayoutParams.rightMargin = paramInt;
          this.input.setLayoutParams(paramLayoutParams);
          return;
        }
        this.panelicons.setAllEnable(false);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(0.6F);
        }
        paramLayoutParams.leftMargin = paramInt;
        this.input.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportMainMsgType(2))
      {
        if (paramProductInfo.isSupportFuncMsgType(3))
        {
          this.input.setHint(this.mActivity.getResources().getString(2131719819));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
          this.input.setGravity(17);
          this.input.setFocusable(false);
          this.input.setFocusableInTouchMode(false);
          this.mInputBar.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          this.input.setHint(this.mActivity.getResources().getString(2131719819));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
          this.input.setGravity(17);
          this.input.setFocusable(false);
          this.input.setFocusableInTouchMode(false);
          this.mInputBar.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          this.input.setHint(this.mActivity.getResources().getString(2131719819));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
          this.input.setGravity(17);
          this.input.setFocusable(false);
          this.input.setFocusableInTouchMode(false);
          this.mInputBar.setVisibility(8);
          return;
        }
        this.input.setVisibility(8);
        this.mInputBar.setVisibility(8);
        this.panelicons.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(0.6F);
        }
        this.mFunBtn.setVisibility(8);
        return;
      }
      this.input.setVisibility(0);
      this.panelicons.setAllEnable(true);
      if (VersionUtils.isHoneycomb()) {
        this.panelicons.setAllAlpha(1.0F);
      }
      if (paramProductInfo.isSupportFuncMsgType(3))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.input.setHint(this.mActivity.getResources().getString(2131719819));
        this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
        this.input.setGravity(17);
        this.input.setFocusable(false);
        this.input.setFocusableInTouchMode(false);
        this.input.setLayoutParams(paramLayoutParams);
        this.mFunBtn.setVisibility(8);
        this.mInputBar.setVisibility(8);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(1))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.input.setHint(this.mActivity.getResources().getString(2131719819));
        this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
        this.input.setGravity(17);
        this.input.setFocusable(false);
        this.input.setFocusableInTouchMode(false);
        this.input.setLayoutParams(paramLayoutParams);
        this.mFunBtn.setVisibility(8);
        this.mInputBar.setVisibility(8);
        return;
      }
    } while (!paramProductInfo.isSupportFuncMsgType(2));
    paramLayoutParams.rightMargin = paramInt;
    this.input.setHint(this.mActivity.getResources().getString(2131719819));
    this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167247));
    this.input.setGravity(17);
    this.input.setFocusable(false);
    this.input.setFocusableInTouchMode(false);
    this.input.setLayoutParams(paramLayoutParams);
    this.mFunBtn.setVisibility(8);
    this.mInputBar.setVisibility(8);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  private void a(DeviceInfo paramDeviceInfo)
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean) && (paramDeviceInfo != null)) {
      absy.a(this.app, paramDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, paramDeviceInfo.productId);
    }
  }
  
  private void a(DeviceInfo paramDeviceInfo, ProductInfo paramProductInfo, boolean paramBoolean)
  {
    if (paramProductInfo != null)
    {
      if ((paramProductInfo.supportMainMsgType & 0xF) != 0) {
        this.jdField_d_of_type_Boolean = true;
      }
      if ((paramBoolean) || ((paramDeviceInfo.SSOBid_Platform != 1027) && ((StringUtil.isEmpty(paramDeviceInfo.SSOBid_Version)) || (Double.valueOf(paramDeviceInfo.SSOBid_Version).doubleValue() < 1.1D)))) {
        break label85;
      }
      this.jdField_e_of_type_Boolean = true;
      SettingCloneUtil.writeValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_openchat_firsttrue", true);
    }
    label85:
    while ((!paramBoolean) && (!jdField_f_of_type_Boolean)) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int j = paramString2.optInt("num", 1);
      int k = paramString2.optInt("face", 1);
      int m = paramString2.optInt("mediaSize", 1);
      int n = paramString2.optInt("mediaType", 1);
      int i1 = paramString2.optInt("scaling", 1);
      int i2 = paramString2.optInt("orientation", 1);
      int i3 = paramString2.optInt("color", 1);
      int i4 = paramString2.optInt("quality", 1);
      localBundle.putInt("copies", j);
      localBundle.putInt("duplexMode", k);
      localBundle.putInt("mediaSize", m);
      localBundle.putInt("mediaType", n);
      localBundle.putInt("scaling", i1);
      localBundle.putInt("orientation", i2);
      localBundle.putInt("color", i3);
      localBundle.putInt("quality", i4);
      ((abkw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(abkw.c, paramString1, paramArrayList, localBundle);
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
    //   10: getfield 315	ahzx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: getstatic 461	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	I
    //   16: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   19: checkcast 463	abgm
    //   22: astore 11
    //   24: aload 11
    //   26: aload_0
    //   27: getfield 357	ahzx:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   30: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   33: invokestatic 469	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: invokevirtual 472	abgm:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   39: astore 9
    //   41: aload 9
    //   43: ifnull +464 -> 507
    //   46: aload 11
    //   48: aload 9
    //   50: getfield 326	com/tencent/device/datadef/DeviceInfo:productId	I
    //   53: invokevirtual 475	abgm:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   56: astore 11
    //   58: aload 11
    //   60: ifnull +447 -> 507
    //   63: aload 11
    //   65: iconst_2
    //   66: invokevirtual 206	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   69: ifeq +438 -> 507
    //   72: iconst_1
    //   73: istore_2
    //   74: lconst_0
    //   75: lstore 6
    //   77: aload 9
    //   79: ifnull +423 -> 502
    //   82: aload 9
    //   84: getfield 321	com/tencent/device/datadef/DeviceInfo:din	J
    //   87: lstore 6
    //   89: aload 9
    //   91: getfield 326	com/tencent/device/datadef/DeviceInfo:productId	I
    //   94: istore_3
    //   95: iload_2
    //   96: ifne +39 -> 135
    //   99: aload_0
    //   100: getfield 315	ahzx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: getstatic 416	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	I
    //   106: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   109: checkcast 424	abkw
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 315	ahzx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   117: lload 6
    //   119: ldc_w 477
    //   122: bipush 7
    //   124: iconst_0
    //   125: iload_3
    //   126: invokestatic 331	absy:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ireturn
    //   135: aload_0
    //   136: getfield 82	ahzx:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   139: aload_0
    //   140: getfield 357	ahzx:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   143: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   146: aconst_null
    //   147: ldc_w 479
    //   150: iconst_1
    //   151: invokestatic 483	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   154: istore 4
    //   156: getstatic 372	ahzx:jdField_f_of_type_Boolean	Z
    //   159: ifeq +62 -> 221
    //   162: iload 4
    //   164: ifeq +57 -> 221
    //   167: aload_0
    //   168: getfield 315	ahzx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   171: getstatic 416	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	I
    //   174: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   177: checkcast 424	abkw
    //   180: aload_0
    //   181: getfield 357	ahzx:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   184: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   187: ldc_w 484
    //   190: invokestatic 150	anvx:a	(I)Ljava/lang/String;
    //   193: invokestatic 488	bcrg:a	()J
    //   196: iconst_1
    //   197: iconst_0
    //   198: iconst_1
    //   199: invokevirtual 491	abkw:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   202: aload_0
    //   203: getfield 82	ahzx:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   206: aload_0
    //   207: getfield 357	ahzx:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   210: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   213: aconst_null
    //   214: ldc_w 479
    //   217: iconst_0
    //   218: invokestatic 370	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   221: iload 5
    //   223: istore 4
    //   225: getstatic 496	android/os/Build$VERSION:SDK_INT	I
    //   228: bipush 10
    //   230: if_icmpgt -98 -> 132
    //   233: aload_0
    //   234: getfield 82	ahzx:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   237: invokevirtual 500	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   240: aload_1
    //   241: invokevirtual 506	android/content/Intent:getData	()Landroid/net/Uri;
    //   244: ldc_w 508
    //   247: invokevirtual 514	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +124 -> 376
    //   255: aload_1
    //   256: invokevirtual 520	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   259: astore_1
    //   260: new 522	java/io/FileOutputStream
    //   263: dup
    //   264: new 156	java/io/File
    //   267: dup
    //   268: aload_0
    //   269: getfield 82	ahzx:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   272: invokevirtual 88	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   275: invokestatic 94	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   278: ldc 96
    //   280: ldc 46
    //   282: invokeinterface 102 3 0
    //   287: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: invokespecial 525	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   293: astore 9
    //   295: sipush 1024
    //   298: newarray byte
    //   300: astore 11
    //   302: aload_1
    //   303: aload 11
    //   305: invokevirtual 531	java/io/FileInputStream:read	([B)I
    //   308: istore_2
    //   309: aload 9
    //   311: astore 10
    //   313: aload_1
    //   314: astore 8
    //   316: iload_2
    //   317: ifle +65 -> 382
    //   320: aload 9
    //   322: aload 11
    //   324: iconst_0
    //   325: iload_2
    //   326: invokevirtual 535	java/io/FileOutputStream:write	([BII)V
    //   329: goto -27 -> 302
    //   332: astore 10
    //   334: aload_1
    //   335: astore 8
    //   337: aload 9
    //   339: astore_1
    //   340: aload 10
    //   342: astore 9
    //   344: aload 9
    //   346: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   349: aload 8
    //   351: ifnull +8 -> 359
    //   354: aload 8
    //   356: invokevirtual 541	java/io/FileInputStream:close	()V
    //   359: iload 5
    //   361: istore 4
    //   363: aload_1
    //   364: ifnull -232 -> 132
    //   367: aload_1
    //   368: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   371: iconst_0
    //   372: ireturn
    //   373: astore_1
    //   374: iconst_0
    //   375: ireturn
    //   376: aconst_null
    //   377: astore 10
    //   379: aconst_null
    //   380: astore 8
    //   382: aload 8
    //   384: ifnull +8 -> 392
    //   387: aload 8
    //   389: invokevirtual 541	java/io/FileInputStream:close	()V
    //   392: iload 5
    //   394: istore 4
    //   396: aload 10
    //   398: ifnull -266 -> 132
    //   401: aload 10
    //   403: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   406: iconst_0
    //   407: ireturn
    //   408: astore_1
    //   409: iconst_0
    //   410: ireturn
    //   411: astore 8
    //   413: aconst_null
    //   414: astore_1
    //   415: aload 10
    //   417: astore 9
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 541	java/io/FileInputStream:close	()V
    //   427: aload 9
    //   429: ifnull +8 -> 437
    //   432: aload 9
    //   434: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   437: aload 8
    //   439: athrow
    //   440: astore_1
    //   441: goto -4 -> 437
    //   444: astore 8
    //   446: aload 10
    //   448: astore 9
    //   450: goto -31 -> 419
    //   453: astore 8
    //   455: goto -36 -> 419
    //   458: astore 11
    //   460: aload 8
    //   462: astore 9
    //   464: aload_1
    //   465: astore 10
    //   467: aload 11
    //   469: astore 8
    //   471: aload 9
    //   473: astore_1
    //   474: aload 10
    //   476: astore 9
    //   478: goto -59 -> 419
    //   481: astore 9
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -141 -> 344
    //   488: astore 9
    //   490: aconst_null
    //   491: astore 10
    //   493: aload_1
    //   494: astore 8
    //   496: aload 10
    //   498: astore_1
    //   499: goto -155 -> 344
    //   502: iconst_0
    //   503: istore_3
    //   504: goto -409 -> 95
    //   507: iconst_0
    //   508: istore_2
    //   509: goto -435 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	ahzx
    //   0	512	1	paramIntent	Intent
    //   73	436	2	j	int
    //   94	410	3	k	int
    //   130	265	4	bool1	boolean
    //   7	386	5	bool2	boolean
    //   75	43	6	l	long
    //   4	384	8	localIntent1	Intent
    //   411	27	8	localObject1	Object
    //   444	1	8	localObject2	Object
    //   453	8	8	localObject3	Object
    //   469	26	8	localObject4	Object
    //   39	438	9	localObject5	Object
    //   481	1	9	localException1	Exception
    //   488	1	9	localException2	Exception
    //   1	311	10	localObject6	Object
    //   332	9	10	localException3	Exception
    //   377	120	10	localIntent2	Intent
    //   22	301	11	localObject7	Object
    //   458	10	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   295	302	332	java/lang/Exception
    //   302	309	332	java/lang/Exception
    //   320	329	332	java/lang/Exception
    //   354	359	373	java/lang/Exception
    //   367	371	373	java/lang/Exception
    //   387	392	408	java/lang/Exception
    //   401	406	408	java/lang/Exception
    //   233	251	411	finally
    //   255	260	411	finally
    //   423	427	440	java/lang/Exception
    //   432	437	440	java/lang/Exception
    //   260	295	444	finally
    //   295	302	453	finally
    //   302	309	453	finally
    //   320	329	453	finally
    //   344	349	458	finally
    //   233	251	481	java/lang/Exception
    //   255	260	481	java/lang/Exception
    //   260	295	488	java/lang/Exception
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    this.root.a();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int m = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    int k = 0;
    Object localObject2 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject2).a(Long.parseLong(this.sessionInfo.curFriendUin));
    int j = k;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((abgm)localObject2).a(localDeviceInfo.productId);
      j = k;
      if (localObject3 != null)
      {
        j = k;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          j = 1;
        }
      }
    }
    long l = 0L;
    k = 0;
    if (localDeviceInfo != null)
    {
      l = localDeviceInfo.din;
      k = localDeviceInfo.productId;
    }
    if ((j == 0) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 3))
    {
      paramIntent = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      absy.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, k);
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
        if ((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 3))
        {
          paramIntent = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((abgm)localObject2).a((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          finish();
          return;
        }
        if (this.jdField_b_of_type_Int != 9) {
          break;
        }
      } while (((ArrayList)localObject3).size() <= 0);
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra(bhcc.h, paramIntent.getIntExtra(bhcc.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      bmij.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        ((abkw)localObject2).a().a(this.sessionInfo.curFriendUin, (List)localObject1);
        absy.a(this.app, l, "Usr_AIO_SendGroupMsg", 3, 0, k);
        return;
      }
      if (!this.h) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(bhcc.h, paramIntent.getIntExtra(bhcc.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    bmij.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    return;
    if (m == 2)
    {
      a((List)localObject1);
      return;
    }
    b((List)localObject1);
  }
  
  private void c()
  {
    int j = 1;
    Object localObject2;
    if (!this.mActivity.isFinishing())
    {
      localObject1 = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ((abkw)localObject1).a().a();
      ((abkw)localObject1).a().a();
      this.panelicons.setAllEnable(false);
      if (VersionUtils.isHoneycomb()) {
        this.panelicons.setAllAlpha(0.6F);
      }
      a();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
      this.mActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      this.jdField_c_of_type_Boolean = true;
      localObject2 = this.mActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.jdField_b_of_type_Int = ((Bundle)localObject2).getInt("operType", 0);
        this.jdField_c_of_type_Int = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      localObject1 = (ImageView)this.mAIORootView.findViewById(2131369245);
      if (localObject1 == null) {
        break label658;
      }
      ((ImageView)localObject1).setImageResource(2130839625);
    }
    label653:
    label658:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.mAIORootView.findViewById(2131369240);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839624);
        ((ImageView)localObject3).setOnClickListener(new ahzz(this));
      }
      long l = Long.parseLong(this.sessionInfo.curFriendUin);
      localObject3 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      boolean bool;
      if ((((abgm)localObject3).c(l)) && (((abgm)localObject3).a(l, 17)))
      {
        bool = true;
        this.h = bool;
        if (this.h) {
          ((abgm)localObject3).a(l, "", "", "", 0, null);
        }
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            b(this.mActivity.getIntent());
          }
          localObject2 = this.mActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            c(this.mActivity.getIntent());
          }
        }
        bool = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((asll.a().a(this.app, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.sessionInfo.curFriendUin + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), false))) {
          break label653;
        }
      }
      for (;;)
      {
        if (((bool) && (((abgm)localObject3).d(l))) || (j != 0))
        {
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131369245);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131369245);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850428);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return;
        bool = false;
        break;
        j = 0;
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin))) {
      QQToast.a(this.mContext, anvx.a(2131702657), 2000).a();
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
      if (NetworkUtil.isWifiEnabled(this.mContext)) {
        break;
      }
      paramIntent = bhdj.a(this.mActivity, 230, this.mContext.getString(2131697353), this.mContext.getString(2131697130), anvx.a(2131702672), anvx.a(2131702673), new aiac(this, localArrayList, paramIntent), new aiad(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    a(this.app, this.sessionInfo.curFriendUin, localArrayList, paramIntent);
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    int j;
    if (paramIntent != null)
    {
      j = paramIntent.getInt("cookie", 0);
      int k = paramIntent.getInt("err_code", 1);
      if ((j != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(j))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(j));
        if (k != 0) {
          break label289;
        }
        if (!(paramIntent instanceof MessageForDevPtt)) {
          break label165;
        }
        paramIntent = (MessageForDevPtt)paramIntent;
        paramIntent.extraflag = 32770;
        paramIntent.fileSize = auea.a(paramIntent.url);
        paramIntent.extStr = "device_groupchat";
        paramIntent.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
        ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
      }
    }
    label289:
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(j));
      return;
      label165:
      if ((paramIntent instanceof MessageForDeviceFile))
      {
        ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
      }
      else if ((paramIntent instanceof MessageForDevLittleVideo))
      {
        MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
        localMessageForDevLittleVideo.videoFileStatus = 1003;
        localMessageForDevLittleVideo.videoFileProgress = 100;
        localMessageForDevLittleVideo.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
        continue;
        if ((paramIntent instanceof MessageForDevPtt))
        {
          paramIntent = (MessageForDevPtt)paramIntent;
          paramIntent.extraflag = 32768;
          paramIntent.extStr = "device_groupchat";
          paramIntent.serial();
          this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDeviceFile))
        {
          paramIntent = (MessageForDeviceFile)paramIntent;
          ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDevLittleVideo))
        {
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
          localMessageForDevLittleVideo.videoFileStatus = 1005;
          localMessageForDevLittleVideo.videoFileProgress = 0;
          localMessageForDevLittleVideo.serial();
          this.app.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
          ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    float f1;
    if (paramIntent != null)
    {
      int j = paramIntent.getInt("cookie", 0);
      f1 = paramIntent.getFloat("percent", 0.0F);
      if ((j != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(j))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(j));
        if (!(paramIntent instanceof MessageForDeviceFile)) {
          break label111;
        }
        paramIntent = (MessageForDeviceFile)paramIntent;
        paramIntent.nFileStatus = 3;
        paramIntent.progress = f1;
        paramIntent.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
      }
    }
    label111:
    while (!(paramIntent instanceof MessageForDevLittleVideo)) {
      return;
    }
    paramIntent = (MessageForDevLittleVideo)paramIntent;
    paramIntent.videoFileStatus = 1002;
    paramIntent.videoFileProgress = ((int)(100.0F * f1));
    paramIntent.serial();
    this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
    ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, f1);
  }
  
  public void a()
  {
    int j = (int)(6.0F * this.mActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.input.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = j;
    this.input.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject1).a(Long.parseLong(this.sessionInfo.curFriendUin));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((abgm)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.panelicons.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(1.0F);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        this.input.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_a_of_type_Int = localDeviceInfo.productId;
    }
    for (;;)
    {
      jdField_f_of_type_Boolean = ((abgm)localObject1).a(Long.parseLong(this.sessionInfo.curFriendUin)).booleanValue();
      boolean bool = SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_showsupporttips_first", true);
      a(localDeviceInfo, localProductInfo, SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_openchat_firsttrue", false));
      a(localDeviceInfo);
      if ((localProductInfo != null) && (bool))
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          break label424;
        }
        localObject1 = this.app.getApp().getString(2131691534);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          if ((this.jdField_d_of_type_Boolean) && (localDeviceInfo.isAdmin == 1) && (this.jdField_e_of_type_Boolean) && (!jdField_f_of_type_Boolean))
          {
            localObject2 = this.app.getApp().getString(2131691558);
            ((abkw)localObject1).a(this.sessionInfo.curFriendUin, (String)localObject2, bcrg.a(), true, false, true);
          }
          SettingCloneUtil.writeValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_showsupporttips_first", false);
        }
      }
      if (QLog.isColorLevel())
      {
        if (localProductInfo == null) {
          break label751;
        }
        QLog.d(this.tag, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
      }
      for (;;)
      {
        b();
        return;
        label424:
        localObject2 = this.app.getApp().getString(2131691556);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691557) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131691487) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691493) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131691536) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691561) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.app.getApp().getString(2131691555);
        break;
        label751:
        QLog.d(this.tag, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void a(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra(bhcc.h, -1);
    if ((80 == j) || (82 == j)) {
      b(paramIntent);
    }
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(localArrayList);
  }
  
  public void a(List<String> paramList)
  {
    abkw localabkw = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      localabkw.a().a(this.sessionInfo.curFriendUin, paramList);
      paramList = ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      absy.a(this.app, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localabkw.a().a(abkw.d, this.sessionInfo.curFriendUin, paramList);
  }
  
  public boolean a()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    int j = (int)(6.0F * this.mActivity.getResources().getDisplayMetrics().density);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.input.getLayoutParams();
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null) {}
    for (localObject = ((abgm)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
        {
          this.mInputBar.setVisibility(8);
          this.panelicons.setVisibility(8);
        }
        for (;;)
        {
          if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
            this.mInputBar.setVisibility(8);
          }
          return;
          a(j, localLayoutParams, (ProductInfo)localObject);
        }
      }
      this.mInputBar.setVisibility(8);
      return;
    }
  }
  
  public void b(List<String> paramList)
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
        localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
        localIntent.putExtra("uintype", this.sessionInfo.curType);
        localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        azke localazke1 = azjv.a(2, 1007);
        azjv.a(1007, localIntent);
        azke localazke2 = azjv.a(1, 1007);
        localazke2.a(localazke1.jdField_a_of_type_JavaLangString);
        if (localazke2.a(azjv.a(1007, localIntent)))
        {
          localazke2.jdField_a_of_type_Ahtv = new aiaf(this);
          azjv.a(localazke2, this.app);
        }
        else
        {
          a(str);
        }
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    if (b()) {
      return true;
    }
    try
    {
      l = Long.parseLong(this.sessionInfo.curFriendUin);
      abgm localabgm = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localabgm != null) && (localabgm.c(l)) && (localabgm.a(l, 17))) {
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
  
  public boolean d()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((84 == paramInt1) && (paramIntent != null))
    {
      localObject = ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
      localIntent.putExtra("sIsCloudPrinter", true);
      localIntent.putExtra("device_info", (Parcelable)localObject);
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      localIntent.putExtra("filetype", "file");
      bmij.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Int == 4) && (paramInt2 == -1) && (paramInt1 == 1)) {
        this.g = false;
      }
      return;
      if (paramInt1 == 102)
      {
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break;
        }
        c(paramIntent);
        break;
      }
      if ((81 == paramInt1) || (83 == paramInt1))
      {
        if (!a(paramIntent)) {
          break;
        }
        return;
      }
      if (paramInt1 != jdField_d_of_type_Int) {
        break;
      }
      if (paramInt2 == jdField_e_of_type_Int) {
        finish();
      }
      for (;;)
      {
        localObject = absz.a(((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin)));
        if (localObject == null) {
          break;
        }
        this.mTitleText.setText((CharSequence)localObject);
        break;
        if (paramInt2 == jdField_f_of_type_Int) {
          this.i = true;
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          this.jdField_b_of_type_JavaLangString = ((SendInfo)paramIntent.get(0)).a();
          abht.a(this.app, this.mActivity, this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString);
          continue;
          a(paramInt2);
        }
      }
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.needAutoInput = false;
    this.hasDestory = false;
    if (this.mActivity.getIntent().getExtras() == null)
    {
      super.finish();
      return true;
    }
    super.doOnCreate(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this.mActivity))
      {
        CheckPermission.requestStorePermission(this.mActivity, new ahzy(this));
        return true;
      }
      c();
      return true;
    }
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.hasDestory) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.doOnDestroy();
      try
      {
        this.mActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.tag, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (this.mActivity.getIntent().getExtras() == null) {
      super.finish();
    }
    do
    {
      return;
      super.doOnNewIntent(paramIntent);
    } while (this.mActivity.isFinishing());
    a(paramIntent);
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    bhfr.a();
    this.helperProvider.a(21);
    AIOUtils.setIsNotLoadSuit(false);
    this.isBack2Root = false;
    this.speakerPhoneOn = true;
    this.isFromManageStranger = false;
    this.isBeingInputDraft = false;
    this.hasSentRecvMsg = false;
    this.mCacnelSellPttPanle = false;
    this.mIsCurrentSession = true;
    this.hasDestory = false;
    this.mSingleTitle = true;
    this.showOnlineStatus = false;
    if (this.mTipsContainer != null)
    {
      this.mTipsContainer.removeAllViews();
      this.mMsgbox = null;
    }
    if (this.mTipsMgr != null) {
      this.mTipsMgr.a();
    }
    if (this.speakerPhoneLayout != null)
    {
      this.speakerPhoneLayout.setVisibility(4);
      this.speakerPhoneLayout = null;
    }
    if (this.mEmoPanel != null)
    {
      this.mEmoPanel.onDestory();
      this.mEmoPanel = null;
    }
    if (this.root != null)
    {
      this.root.a();
      this.root.d();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4))
    {
      if (!this.g) {
        this.g = true;
      }
    }
    else {
      return;
    }
    super.finish();
  }
  
  public boolean e()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    Object localObject = ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin));
    localObject = new absn().a((DeviceInfo)localObject);
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
        localObject = new QQRecorder.RecorderParam(bhhd.jdField_b_of_type_Int, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(bhhd.jdField_a_of_type_Int, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  public void handleForwardData(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("forward_type", 2147483647);
    if (j == 2147483647) {}
    String str;
    abkw localabkw;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (j != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localabkw = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    } while (TextUtils.isEmpty(str));
    this.sessionInfo.curFriendUin = paramIntent.getStringExtra("uin");
    this.sessionInfo.curType = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.app;
    SessionInfo localSessionInfo = this.sessionInfo;
    if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localabkw.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.handleForwardData(paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.uiHandler.removeMessages(20);
      this.uiHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.uiHandler.removeMessages(20);
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + j + "currentID=" + this.root.a());
    }
    if (j == this.root.a())
    {
      this.root.a();
      return;
    }
    switch (j)
    {
    }
    for (;;)
    {
      super.onPanelIconClick(paramObject);
      return;
      this.root.a();
      aftr.a(this.app, getActivity(), this.sessionInfo, 2, true);
      continue;
      this.root.a();
      doShowPtv();
      continue;
      ahpt.a(this.app, "0X800407C", this.sessionInfo.curType);
      Object localObject = new audz();
      ((audz)localObject).jdField_b_of_type_JavaLangString = "send_file";
      ((audz)localObject).jdField_a_of_type_Int = 1;
      audy.a(this.app.getCurrentAccountUin(), (audz)localObject);
      localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      long l = Long.parseLong(this.sessionInfo.curFriendUin);
      if ((localObject != null) && (((abgm)localObject).c(l)) && (((abgm)localObject).a(l, 17))) {
        aftr.c(this.app, getActivity(), this.sessionInfo);
      } else {
        aftr.a(this.app, getActivity(), this.sessionInfo);
      }
    }
  }
  
  public void openOptionActivity()
  {
    if (this.sessionInfo.curFriendUin.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      bmij.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", jdField_d_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      int j = 0;
      long l = 0L;
      if (localObject != null)
      {
        j = ((DeviceInfo)localObject).productId;
        l = ((DeviceInfo)localObject).din;
      }
      absy.a(this.app, l, "Usr_AIO_Menu", 1, 0, j);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new absn(this.mActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    bmij.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", jdField_d_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.sessionInfo.curFriendUin + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  public void recorderPrepared(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject1 = ((abgm)localObject2).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localObject1 != null)
    {
      localObject2 = ((abgm)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l = 0L;
      int j = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        j = ((DeviceInfo)localObject1).productId;
      }
      absy.a(this.app, l, "Usr_AIO_SendMsg", 1, 0, j);
      this.jdField_b_of_type_Boolean = bool;
      if (!bool)
      {
        paramString = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        absy.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, j);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = bhhd.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        j = 1;
        label207:
        if (j != 0) {
          break label278;
        }
        bdnl.a(this.app, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        bdnl.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label245:
        if (paramString == null) {
          break label294;
        }
        if (paramBoolean) {
          break label296;
        }
        this.recordingUniseq = 0L;
        playPersonalSound(2131230745);
      }
      for (;;)
      {
        instantUpdate(true, false);
        return;
        j = 0;
        break label207;
        label278:
        bahi.a(paramString);
        bahi.a(paramString, (byte[])localObject1, localObject1.length);
        break label245;
        label294:
        break;
        label296:
        paramString = abhq.a(this.app, paramString, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, -2L);
        if (j == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.recordingUniseq = paramString.uniseq;
        }
        playPersonalSound(2131230733);
      }
    }
  }
  
  public void recorderTimeTooShort(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      super.recorderTimeTooShort(paramString);
    }
  }
  
  public void refresh(int paramInt)
  {
    super.refresh(paramInt);
    this.uiHandler.sendEmptyMessage(20);
  }
  
  public void send()
  {
    boolean bool = true;
    Object localObject1;
    if (this.input.getText().length() > 0)
    {
      localObject1 = this.input.getText().toString();
      azkc.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.mActivity, 2131718520, 1);
        return;
      }
    }
    for (;;)
    {
      this.input.setText("");
      Object localObject3 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      Object localObject2 = ((abgm)localObject3).a(Long.parseLong(this.sessionInfo.curFriendUin));
      if (localObject2 != null)
      {
        localObject3 = ((abgm)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int j = 1;; j = 0)
      {
        long l = 0L;
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        for (int k = ((DeviceInfo)localObject2).productId;; k = 0)
        {
          if (j == 0)
          {
            localObject1 = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
            absy.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, k);
            return;
          }
          localObject2 = (abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.app;
            localSessionInfo = this.sessionInfo;
            if ((!jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
              break label270;
            }
          }
          for (;;)
          {
            ((abkw)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            absy.a(this.app, l, "Usr_AIO_SendMsg", 6, 0, k);
            return;
            label270:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void sendPttInner(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label298;
      }
      bdnl.a(paramString, false);
      bdnl.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label530;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= bicj.jdField_a_of_type_Int) {
        break label524;
      }
      paramRecorderParam = bicj.a(paramString, paramInt1);
      if (!new File(paramRecorderParam).exists()) {
        break label306;
      }
      paramString = paramRecorderParam;
    }
    label524:
    label530:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      abgm localabgm = null;
      paramRecorderParam = localabgm;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localabgm;
        if (this.sessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.app.getMessageFacade().getMsgItemByUniseq(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong);; paramRecorderParam = abhq.a(this.app, paramString, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.checkOrUpdatePttRecord(0, paramString, paramRecorderParam.uniseq);
        if ((!jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
          break label468;
        }
        if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
          break label352;
        }
        paramString = (MessageForDevPtt)paramRecorderParam;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
        return;
        paramInt1 = 0;
        break;
        bahi.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localabgm = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      paramInt1 = localabgm.a(Long.parseLong(this.sessionInfo.curFriendUin), paramString, QQRecorder.a(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localabgm.a(Long.parseLong(this.sessionInfo.curFriendUin));
      if (paramString == null) {
        break;
      }
      absy.a(this.app, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label468:
      ((abkw)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(abkw.f, paramString, Long.parseLong(this.sessionInfo.curFriendUin), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void setTag()
  {
    this.tag = "DeviceMsgChatPie";
  }
  
  public void updateSession_updatePanel()
  {
    super.updateSession_updatePanel();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 9)) {
      if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372419) != null) {
        onPanelIconClick(Integer.valueOf(4));
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
          QLog.d(this.tag, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_b_of_type_Int + "], find view panelicons failed!!");
          return;
          if ((this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372419) != null)
          {
            onPanelIconClick(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.tag, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_b_of_type_Int + "], find view panelicons failed!!");
        return;
      } while (this.jdField_b_of_type_Int == 5);
      if (this.jdField_b_of_type_Int == 6)
      {
        ahpt.a(this.app, this, this.sessionInfo);
        return;
      }
      audz localaudz;
      if (this.jdField_b_of_type_Int == 7)
      {
        localaudz = new audz();
        localaudz.jdField_b_of_type_JavaLangString = "send_file";
        localaudz.jdField_a_of_type_Int = 1;
        audy.a(this.app.getCurrentAccountUin(), localaudz);
        aftr.a(this.app, getActivity(), this.sessionInfo, this.jdField_c_of_type_Int, false);
        return;
      }
      if (this.jdField_b_of_type_Int == 8)
      {
        this.root.a(2);
        return;
      }
      if (this.jdField_b_of_type_Int == 10)
      {
        localaudz = new audz();
        localaudz.jdField_b_of_type_JavaLangString = "send_file";
        localaudz.jdField_a_of_type_Int = 1;
        audy.a(this.app.getCurrentAccountUin(), localaudz);
        aftr.c(this.app, getActivity(), this.sessionInfo);
        return;
      }
    } while (this.jdField_b_of_type_Int != 11);
    onPanelIconClick(Integer.valueOf(13));
  }
  
  public boolean updateSession_updatePttBar()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    Object localObject = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((abgm)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((abgm)localObject).a(localDeviceInfo.productId);
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
  
  public void updateSession_updateTitleBtnCall()
  {
    if (this.mTitleBtnCall != null)
    {
      if (mbl.a().a(this.app.getCurrentAccountUin())) {
        this.mTitleBtnCall.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mTitleBtnCall.setVisibility(8);
  }
  
  public void updateSession_updateTitleRightView()
  {
    if (this.mTitleBtnRight != null)
    {
      updateViewForTheme(this.mTitleBtnRight, 2130839625, 2130839625);
      this.mTitleBtnRight.setContentDescription(this.mActivity.getText(2131696155));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzx
 * JD-Core Version:    0.7.0.1
 */