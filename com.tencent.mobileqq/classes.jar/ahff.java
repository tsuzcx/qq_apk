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

public class ahff
  extends BaseChatPie
{
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int jdField_d_of_type_Int;
  static int jdField_e_of_type_Int;
  static int f;
  public static boolean f;
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahfm(this);
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
  
  public ahff(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
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
        QQCustomDialog localQQCustomDialog = bfur.a(this.mActivity, 230);
        localQQCustomDialog.setNegativeButton(2131690620, new ahfi(this));
        localQQCustomDialog.setPositiveButton(2131694201, new ahfj(this));
        localQQCustomDialog.setTitle(amtj.a(2131702313));
        Object localObject = new File(this.jdField_b_of_type_JavaLangString);
        localObject = ShortVideoUtils.stringForFileSize(this.mActivity, ((File)localObject).length());
        localQQCustomDialog.setMessage(amtj.a(2131702319) + (String)localObject + amtj.a(2131702311));
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
          this.input.setHint(this.mActivity.getResources().getString(2131719391));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
          this.input.setGravity(17);
          this.input.setFocusable(false);
          this.input.setFocusableInTouchMode(false);
          this.mInputBar.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          this.input.setHint(this.mActivity.getResources().getString(2131719391));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
          this.input.setGravity(17);
          this.input.setFocusable(false);
          this.input.setFocusableInTouchMode(false);
          this.mInputBar.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          this.input.setHint(this.mActivity.getResources().getString(2131719391));
          this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
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
        this.input.setHint(this.mActivity.getResources().getString(2131719391));
        this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
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
        this.input.setHint(this.mActivity.getResources().getString(2131719391));
        this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
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
    this.input.setHint(this.mActivity.getResources().getString(2131719391));
    this.input.setHintTextColor(this.mActivity.getResources().getColor(2131167233));
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
      abdm.a(this.app, paramDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, paramDeviceInfo.productId);
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
      ((aavk)paramQQAppInterface.getBusinessHandler(49)).a().a(aavk.c, paramString1, paramArrayList, localBundle);
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
    //   10: getfield 315	ahff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 51
    //   15: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   18: checkcast 455	aara
    //   21: astore 11
    //   23: aload 11
    //   25: aload_0
    //   26: getfield 357	ahff:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   29: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   32: invokestatic 461	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: invokevirtual 464	aara:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   38: astore 9
    //   40: aload 9
    //   42: ifnull +462 -> 504
    //   45: aload 11
    //   47: aload 9
    //   49: getfield 326	com/tencent/device/datadef/DeviceInfo:productId	I
    //   52: invokevirtual 467	aara:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   55: astore 11
    //   57: aload 11
    //   59: ifnull +445 -> 504
    //   62: aload 11
    //   64: iconst_2
    //   65: invokevirtual 206	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   68: ifeq +436 -> 504
    //   71: iconst_1
    //   72: istore_2
    //   73: lconst_0
    //   74: lstore 6
    //   76: aload 9
    //   78: ifnull +421 -> 499
    //   81: aload 9
    //   83: getfield 321	com/tencent/device/datadef/DeviceInfo:din	J
    //   86: lstore 6
    //   88: aload 9
    //   90: getfield 326	com/tencent/device/datadef/DeviceInfo:productId	I
    //   93: istore_3
    //   94: iload_2
    //   95: ifne +38 -> 133
    //   98: aload_0
    //   99: getfield 315	ahff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: bipush 49
    //   104: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   107: checkcast 419	aavk
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 315	ahff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   115: lload 6
    //   117: ldc_w 469
    //   120: bipush 7
    //   122: iconst_0
    //   123: iload_3
    //   124: invokestatic 331	abdm:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   127: iconst_1
    //   128: istore 4
    //   130: iload 4
    //   132: ireturn
    //   133: aload_0
    //   134: getfield 82	ahff:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   137: aload_0
    //   138: getfield 357	ahff:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   141: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   144: aconst_null
    //   145: ldc_w 471
    //   148: iconst_1
    //   149: invokestatic 475	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   152: istore 4
    //   154: getstatic 372	ahff:jdField_f_of_type_Boolean	Z
    //   157: ifeq +61 -> 218
    //   160: iload 4
    //   162: ifeq +56 -> 218
    //   165: aload_0
    //   166: getfield 315	ahff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: bipush 49
    //   171: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   174: checkcast 419	aavk
    //   177: aload_0
    //   178: getfield 357	ahff:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   181: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   184: ldc_w 476
    //   187: invokestatic 150	amtj:a	(I)Ljava/lang/String;
    //   190: invokestatic 480	bbko:a	()J
    //   193: iconst_1
    //   194: iconst_0
    //   195: iconst_1
    //   196: invokevirtual 483	aavk:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   199: aload_0
    //   200: getfield 82	ahff:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   203: aload_0
    //   204: getfield 357	ahff:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   207: getfield 362	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   210: aconst_null
    //   211: ldc_w 471
    //   214: iconst_0
    //   215: invokestatic 370	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   218: iload 5
    //   220: istore 4
    //   222: getstatic 488	android/os/Build$VERSION:SDK_INT	I
    //   225: bipush 10
    //   227: if_icmpgt -97 -> 130
    //   230: aload_0
    //   231: getfield 82	ahff:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   234: invokevirtual 492	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   237: aload_1
    //   238: invokevirtual 498	android/content/Intent:getData	()Landroid/net/Uri;
    //   241: ldc_w 500
    //   244: invokevirtual 506	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull +124 -> 373
    //   252: aload_1
    //   253: invokevirtual 512	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   256: astore_1
    //   257: new 514	java/io/FileOutputStream
    //   260: dup
    //   261: new 156	java/io/File
    //   264: dup
    //   265: aload_0
    //   266: getfield 82	ahff:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   269: invokevirtual 88	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   272: invokestatic 94	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   275: ldc 96
    //   277: ldc 46
    //   279: invokeinterface 102 3 0
    //   284: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   287: invokespecial 517	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   290: astore 9
    //   292: sipush 1024
    //   295: newarray byte
    //   297: astore 11
    //   299: aload_1
    //   300: aload 11
    //   302: invokevirtual 523	java/io/FileInputStream:read	([B)I
    //   305: istore_2
    //   306: aload 9
    //   308: astore 10
    //   310: aload_1
    //   311: astore 8
    //   313: iload_2
    //   314: ifle +65 -> 379
    //   317: aload 9
    //   319: aload 11
    //   321: iconst_0
    //   322: iload_2
    //   323: invokevirtual 527	java/io/FileOutputStream:write	([BII)V
    //   326: goto -27 -> 299
    //   329: astore 10
    //   331: aload_1
    //   332: astore 8
    //   334: aload 9
    //   336: astore_1
    //   337: aload 10
    //   339: astore 9
    //   341: aload 9
    //   343: invokevirtual 530	java/lang/Exception:printStackTrace	()V
    //   346: aload 8
    //   348: ifnull +8 -> 356
    //   351: aload 8
    //   353: invokevirtual 533	java/io/FileInputStream:close	()V
    //   356: iload 5
    //   358: istore 4
    //   360: aload_1
    //   361: ifnull -231 -> 130
    //   364: aload_1
    //   365: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   368: iconst_0
    //   369: ireturn
    //   370: astore_1
    //   371: iconst_0
    //   372: ireturn
    //   373: aconst_null
    //   374: astore 10
    //   376: aconst_null
    //   377: astore 8
    //   379: aload 8
    //   381: ifnull +8 -> 389
    //   384: aload 8
    //   386: invokevirtual 533	java/io/FileInputStream:close	()V
    //   389: iload 5
    //   391: istore 4
    //   393: aload 10
    //   395: ifnull -265 -> 130
    //   398: aload 10
    //   400: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_1
    //   406: iconst_0
    //   407: ireturn
    //   408: astore 8
    //   410: aconst_null
    //   411: astore_1
    //   412: aload 10
    //   414: astore 9
    //   416: aload_1
    //   417: ifnull +7 -> 424
    //   420: aload_1
    //   421: invokevirtual 533	java/io/FileInputStream:close	()V
    //   424: aload 9
    //   426: ifnull +8 -> 434
    //   429: aload 9
    //   431: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   434: aload 8
    //   436: athrow
    //   437: astore_1
    //   438: goto -4 -> 434
    //   441: astore 8
    //   443: aload 10
    //   445: astore 9
    //   447: goto -31 -> 416
    //   450: astore 8
    //   452: goto -36 -> 416
    //   455: astore 11
    //   457: aload 8
    //   459: astore 9
    //   461: aload_1
    //   462: astore 10
    //   464: aload 11
    //   466: astore 8
    //   468: aload 9
    //   470: astore_1
    //   471: aload 10
    //   473: astore 9
    //   475: goto -59 -> 416
    //   478: astore 9
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -141 -> 341
    //   485: astore 9
    //   487: aconst_null
    //   488: astore 10
    //   490: aload_1
    //   491: astore 8
    //   493: aload 10
    //   495: astore_1
    //   496: goto -155 -> 341
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -407 -> 94
    //   504: iconst_0
    //   505: istore_2
    //   506: goto -433 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	ahff
    //   0	509	1	paramIntent	Intent
    //   72	434	2	j	int
    //   93	408	3	k	int
    //   128	264	4	bool1	boolean
    //   7	383	5	bool2	boolean
    //   74	42	6	l	long
    //   4	381	8	localIntent1	Intent
    //   408	27	8	localObject1	Object
    //   441	1	8	localObject2	Object
    //   450	8	8	localObject3	Object
    //   466	26	8	localObject4	Object
    //   38	436	9	localObject5	Object
    //   478	1	9	localException1	Exception
    //   485	1	9	localException2	Exception
    //   1	308	10	localObject6	Object
    //   329	9	10	localException3	Exception
    //   374	120	10	localIntent2	Intent
    //   21	299	11	localObject7	Object
    //   455	10	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   292	299	329	java/lang/Exception
    //   299	306	329	java/lang/Exception
    //   317	326	329	java/lang/Exception
    //   351	356	370	java/lang/Exception
    //   364	368	370	java/lang/Exception
    //   384	389	405	java/lang/Exception
    //   398	403	405	java/lang/Exception
    //   230	248	408	finally
    //   252	257	408	finally
    //   420	424	437	java/lang/Exception
    //   429	434	437	java/lang/Exception
    //   257	292	441	finally
    //   292	299	450	finally
    //   299	306	450	finally
    //   317	326	450	finally
    //   341	346	455	finally
    //   230	248	478	java/lang/Exception
    //   252	257	478	java/lang/Exception
    //   257	292	485	java/lang/Exception
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
    Object localObject2 = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject2).a(Long.parseLong(this.sessionInfo.curFriendUin));
    int j = k;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((aara)localObject2).a(localDeviceInfo.productId);
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
      paramIntent = (aavk)this.app.getBusinessHandler(49);
      abdm.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, k);
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
          paramIntent = (aara)this.app.getBusinessHandler(51);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((aara)localObject2).a((String)paramIntent.next(), 2154);
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
      ((Intent)localObject1).putExtra(bftk.h, paramIntent.getIntExtra(bftk.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      bkxa.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (aavk)this.app.getBusinessHandler(49);
      if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        ((aavk)localObject2).a().a(this.sessionInfo.curFriendUin, (List)localObject1);
        abdm.a(this.app, l, "Usr_AIO_SendGroupMsg", 3, 0, k);
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
    ((Intent)localObject1).putExtra(bftk.h, paramIntent.getIntExtra(bftk.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    bkxa.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
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
      localObject1 = (aavk)this.app.getBusinessHandler(49);
      ((aavk)localObject1).a().a();
      ((aavk)localObject1).a().a();
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
      localObject1 = (ImageView)this.mAIORootView.findViewById(2131369082);
      if (localObject1 == null) {
        break label656;
      }
      ((ImageView)localObject1).setImageResource(2130839604);
    }
    label651:
    label656:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.mAIORootView.findViewById(2131369077);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839603);
        ((ImageView)localObject3).setOnClickListener(new ahfh(this));
      }
      long l = Long.parseLong(this.sessionInfo.curFriendUin);
      localObject3 = (aara)this.app.getBusinessHandler(51);
      boolean bool;
      if ((((aara)localObject3).c(l)) && (((aara)localObject3).a(l, 17)))
      {
        bool = true;
        this.h = bool;
        if (this.h) {
          ((aara)localObject3).a(l, "", "", "", 0, null);
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
        if ((arhf.a().a(this.app, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.sessionInfo.curFriendUin + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), false))) {
          break label651;
        }
      }
      for (;;)
      {
        if (((bool) && (((aara)localObject3).d(l))) || (j != 0))
        {
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131369082);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131369082);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850322);
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
    if (!((DeviceFileHandler)this.app.getBusinessHandler(50)).a(Long.parseLong(this.sessionInfo.curFriendUin))) {
      QQToast.a(this.mContext, amtj.a(2131702306), 2000).a();
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
      paramIntent = bfur.a(this.mActivity, 230, this.mContext.getString(2131697076), this.mContext.getString(2131696862), amtj.a(2131702321), amtj.a(2131702322), new ahfk(this, localArrayList, paramIntent), new ahfl(this));
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
          break label286;
        }
        if (!(paramIntent instanceof MessageForDevPtt)) {
          break label164;
        }
        paramIntent = (MessageForDevPtt)paramIntent;
        paramIntent.extraflag = 32770;
        paramIntent.fileSize = aszt.a(paramIntent.url);
        paramIntent.extStr = "device_groupchat";
        paramIntent.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
        ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(true));
      }
    }
    label286:
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(j));
      return;
      label164:
      if ((paramIntent instanceof MessageForDeviceFile))
      {
        ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(true));
      }
      else if ((paramIntent instanceof MessageForDevLittleVideo))
      {
        MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
        localMessageForDevLittleVideo.videoFileStatus = 1003;
        localMessageForDevLittleVideo.videoFileProgress = 100;
        localMessageForDevLittleVideo.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(true));
        continue;
        if ((paramIntent instanceof MessageForDevPtt))
        {
          paramIntent = (MessageForDevPtt)paramIntent;
          paramIntent.extraflag = 32768;
          paramIntent.extStr = "device_groupchat";
          paramIntent.serial();
          this.app.getMessageFacade().updateMsgContentByUniseq(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDeviceFile))
        {
          paramIntent = (MessageForDeviceFile)paramIntent;
          ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDevLittleVideo))
        {
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
          localMessageForDevLittleVideo.videoFileStatus = 1005;
          localMessageForDevLittleVideo.videoFileProgress = 0;
          localMessageForDevLittleVideo.serial();
          this.app.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
          ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, Boolean.valueOf(false));
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
    ((aavk)this.app.getBusinessHandler(49)).a().a(paramIntent, f1);
  }
  
  public void a()
  {
    int j = (int)(6.0F * this.mActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.input.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = j;
    this.input.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject1).a(Long.parseLong(this.sessionInfo.curFriendUin));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((aara)localObject1).a(localDeviceInfo.productId);
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
      jdField_f_of_type_Boolean = ((aara)localObject1).a(Long.parseLong(this.sessionInfo.curFriendUin)).booleanValue();
      boolean bool = SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_showsupporttips_first", true);
      a(localDeviceInfo, localProductInfo, SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_openchat_firsttrue", false));
      a(localDeviceInfo);
      if ((localProductInfo != null) && (bool))
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          break label422;
        }
        localObject1 = this.app.getApp().getString(2131691449);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = (aavk)this.app.getBusinessHandler(49);
          if ((this.jdField_d_of_type_Boolean) && (localDeviceInfo.isAdmin == 1) && (this.jdField_e_of_type_Boolean) && (!jdField_f_of_type_Boolean))
          {
            localObject2 = this.app.getApp().getString(2131691473);
            ((aavk)localObject1).a(this.sessionInfo.curFriendUin, (String)localObject2, bbko.a(), true, false, true);
          }
          SettingCloneUtil.writeValue(this.mActivity, this.sessionInfo.curFriendUin, null, "devicemsg_showsupporttips_first", false);
        }
      }
      if (QLog.isColorLevel())
      {
        if (localProductInfo == null) {
          break label749;
        }
        QLog.d(this.tag, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
      }
      for (;;)
      {
        b();
        return;
        label422:
        localObject2 = this.app.getApp().getString(2131691471);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691472) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131691402) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691408) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131691451) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131691476) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.app.getApp().getString(2131691470);
        break;
        label749:
        QLog.d(this.tag, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void a(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra(bftk.h, -1);
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
    aavk localaavk = (aavk)this.app.getBusinessHandler(49);
    if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      localaavk.a().a(this.sessionInfo.curFriendUin, paramList);
      paramList = ((aara)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      abdm.a(this.app, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localaavk.a().a(aavk.d, this.sessionInfo.curFriendUin, paramList);
  }
  
  public boolean a()
  {
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
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
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null) {}
    for (localObject = ((aara)localObject).a(localDeviceInfo.productId);; localObject = null)
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
        ayds localayds1 = aydj.a(2, 1007);
        aydj.a(1007, localIntent);
        ayds localayds2 = aydj.a(1, 1007);
        localayds2.a(localayds1.jdField_a_of_type_JavaLangString);
        if (localayds2.a(aydj.a(1007, localIntent)))
        {
          localayds2.jdField_a_of_type_Ahav = new ahfn(this);
          aydj.a(localayds2, this.app);
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
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
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
      aara localaara = (aara)this.app.getBusinessHandler(51);
      if ((localaara != null) && (localaara.c(l)) && (localaara.a(l, 17))) {
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
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
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
      localObject = ((aara)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
      localIntent.putExtra("sIsCloudPrinter", true);
      localIntent.putExtra("device_info", (Parcelable)localObject);
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      localIntent.putExtra("filetype", "file");
      bkxa.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
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
        localObject = abdn.a(((aara)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.curFriendUin)));
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
          aash.a(this.app, this.mActivity, this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString);
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
        CheckPermission.requestStorePermission(this.mActivity, new ahfg(this));
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
    bfwz.a();
    this.helperProvider.a(20);
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
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    Object localObject = ((aara)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.curFriendUin));
    localObject = new abdb().a((DeviceInfo)localObject);
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
        localObject = new QQRecorder.RecorderParam(bfyl.jdField_b_of_type_Int, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(bfyl.jdField_a_of_type_Int, 0, 0);
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
    aavk localaavk;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (j != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localaavk = (aavk)this.app.getBusinessHandler(49);
    } while (TextUtils.isEmpty(str));
    this.sessionInfo.curFriendUin = paramIntent.getStringExtra("uin");
    this.sessionInfo.curType = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.app;
    SessionInfo localSessionInfo = this.sessionInfo;
    if ((jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localaavk.a(paramIntent, localSessionInfo, str, bool);
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
      afcm.a(this.app, getActivity(), this.sessionInfo, 2, true);
      continue;
      this.root.a();
      doShowPtv();
      continue;
      agwt.a(this.app, "0X800407C", this.sessionInfo.curType);
      Object localObject = new aszs();
      ((aszs)localObject).jdField_b_of_type_JavaLangString = "send_file";
      ((aszs)localObject).jdField_a_of_type_Int = 1;
      aszr.a(this.app.getCurrentAccountUin(), (aszs)localObject);
      localObject = (aara)this.app.getBusinessHandler(51);
      long l = Long.parseLong(this.sessionInfo.curFriendUin);
      if ((localObject != null) && (((aara)localObject).c(l)) && (((aara)localObject).a(l, 17))) {
        afcm.c(this.app, getActivity(), this.sessionInfo);
      } else {
        afcm.a(this.app, getActivity(), this.sessionInfo);
      }
    }
  }
  
  public void openOptionActivity()
  {
    if (this.sessionInfo.curFriendUin.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      bkxa.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", jdField_d_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((aara)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.curFriendUin));
      int j = 0;
      long l = 0L;
      if (localObject != null)
      {
        j = ((DeviceInfo)localObject).productId;
        l = ((DeviceInfo)localObject).din;
      }
      abdm.a(this.app, l, "Usr_AIO_Menu", 1, 0, j);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new abdb(this.mActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    bkxa.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", jdField_d_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.sessionInfo.curFriendUin + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  public void recorderPrepared(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (aara)this.app.getBusinessHandler(51);
    Object localObject1 = ((aara)localObject2).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localObject1 != null)
    {
      localObject2 = ((aara)localObject2).a(((DeviceInfo)localObject1).productId);
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
      abdm.a(this.app, l, "Usr_AIO_SendMsg", 1, 0, j);
      this.jdField_b_of_type_Boolean = bool;
      if (!bool)
      {
        paramString = (aavk)this.app.getBusinessHandler(49);
        abdm.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, j);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = bfyl.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        j = 1;
        label205:
        if (j != 0) {
          break label276;
        }
        bcgn.a(this.app, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        bcgn.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label243:
        if (paramString == null) {
          break label292;
        }
        if (paramBoolean) {
          break label294;
        }
        this.recordingUniseq = 0L;
        playPersonalSound(2131230745);
      }
      for (;;)
      {
        instantUpdate(true, false);
        return;
        j = 0;
        break label205;
        label276:
        azbu.a(paramString);
        azbu.a(paramString, (byte[])localObject1, localObject1.length);
        break label243;
        label292:
        break;
        label294:
        paramString = aase.a(this.app, paramString, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, -2L);
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
      aydq.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.mActivity, 2131718135, 1);
        return;
      }
    }
    for (;;)
    {
      this.input.setText("");
      Object localObject3 = (aara)this.app.getBusinessHandler(51);
      Object localObject2 = ((aara)localObject3).a(Long.parseLong(this.sessionInfo.curFriendUin));
      if (localObject2 != null)
      {
        localObject3 = ((aara)localObject3).a(((DeviceInfo)localObject2).productId);
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
            localObject1 = (aavk)this.app.getBusinessHandler(49);
            abdm.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, k);
            return;
          }
          localObject2 = (aavk)this.app.getBusinessHandler(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.app;
            localSessionInfo = this.sessionInfo;
            if ((!jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
              break label267;
            }
          }
          for (;;)
          {
            ((aavk)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            abdm.a(this.app, l, "Usr_AIO_SendMsg", 6, 0, k);
            return;
            label267:
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
      bcgn.a(paramString, false);
      bcgn.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label528;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= bgrt.jdField_a_of_type_Int) {
        break label522;
      }
      paramRecorderParam = bgrt.a(paramString, paramInt1);
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
      aara localaara = null;
      paramRecorderParam = localaara;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localaara;
        if (this.sessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.app.getMessageFacade().getMsgItemByUniseq(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong);; paramRecorderParam = aase.a(this.app, paramString, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.checkOrUpdatePttRecord(0, paramString, paramRecorderParam.uniseq);
        if ((!jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
          break label467;
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
        azbu.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localaara = (aara)this.app.getBusinessHandler(51);
      paramInt1 = localaara.a(Long.parseLong(this.sessionInfo.curFriendUin), paramString, QQRecorder.a(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localaara.a(Long.parseLong(this.sessionInfo.curFriendUin));
      if (paramString == null) {
        break;
      }
      abdm.a(this.app, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label467:
      ((aavk)this.app.getBusinessHandler(49)).a().a(aavk.f, paramString, Long.parseLong(this.sessionInfo.curFriendUin), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
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
      if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372228) != null) {
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
          if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372228) != null)
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
        agwt.a(this.app, this, this.sessionInfo);
        return;
      }
      aszs localaszs;
      if (this.jdField_b_of_type_Int == 7)
      {
        localaszs = new aszs();
        localaszs.jdField_b_of_type_JavaLangString = "send_file";
        localaszs.jdField_a_of_type_Int = 1;
        aszr.a(this.app.getCurrentAccountUin(), localaszs);
        afcm.a(this.app, getActivity(), this.sessionInfo, this.jdField_c_of_type_Int, false);
        return;
      }
      if (this.jdField_b_of_type_Int == 8)
      {
        this.root.a(2);
        return;
      }
      if (this.jdField_b_of_type_Int == 10)
      {
        localaszs = new aszs();
        localaszs.jdField_b_of_type_JavaLangString = "send_file";
        localaszs.jdField_a_of_type_Int = 1;
        aszr.a(this.app.getCurrentAccountUin(), localaszs);
        afcm.c(this.app, getActivity(), this.sessionInfo);
        return;
      }
    } while (this.jdField_b_of_type_Int != 11);
    onPanelIconClick(Integer.valueOf(13));
  }
  
  public boolean updateSession_updatePttBar()
  {
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    Object localObject = (aara)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((aara)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
    if (localDeviceInfo != null)
    {
      localObject = ((aara)localObject).a(localDeviceInfo.productId);
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
      if (maq.a().a(this.app.getCurrentAccountUin())) {
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
      updateViewForTheme(this.mTitleBtnRight, 2130839604, 2130839604);
      this.mTitleBtnRight.setContentDescription(this.mActivity.getText(2131695903));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahff
 * JD-Core Version:    0.7.0.1
 */