import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.theme.ThemeAuth.DiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeInfo;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2ReqCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2RspCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class alyu
  extends alko
{
  private static String jdField_a_of_type_JavaLangString;
  public Bundle a;
  public baks a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicBoolean b = new AtomicBoolean(true);
  AtomicBoolean c = new AtomicBoolean(false);
  
  public alyu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap<String, String> a(String paramString)
  {
    paramString = bdcs.a(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      int j = new Random().nextInt(paramString.size() - 1);
      String str1 = (String)paramString.get(j);
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = bdcs.b(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3 + ", files=" + paramString.size() + ", index=" + j);
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ThemeAuth.DiyThemeDetail paramDiyThemeDetail)
  {
    MobileQQ localMobileQQ = this.mApp.getApplication();
    Object localObject = ThemeBackground.getSharedPreferences(localMobileQQ, this.mApp.getAccount(), 0);
    if ((paramInt1 == 2) && (!ChatBackgroundManager.a(localMobileQQ, this.mApp.getAccount(), null).equals("null"))) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramDiyThemeDetail.str_bg_url.get();
    }
    for (;;)
    {
      int i = paramInt2;
      if (1 > paramInt2) {
        i = paramDiyThemeDetail.uin32_id.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "update sv ThemeBackground, page=" + paramInt1 + ", id=" + i + ", url=" + paramString1);
      }
      String str1;
      boolean bool;
      if (!TextUtils.isEmpty(paramString1))
      {
        str1 = ((SharedPreferences)localObject).getString(paramString3 + "_id", "");
        localObject = ((SharedPreferences)localObject).getString(paramString3 + "_url", "");
        if ((!("" + i).equals(str1)) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label606;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "updateThemeBackgroundPic, bgType=" + paramString3 + ", notChange=" + bool + ", localId=" + str1 + ", id=" + i + ", url=" + paramString1 + ", page=" + paramInt1);
        }
        if (bool) {
          break;
        }
        if (paramDiyThemeDetail == null) {
          break label612;
        }
        localObject = paramDiyThemeDetail.str_name.get();
        label343:
        if (paramDiyThemeDetail == null) {
          break label637;
        }
        paramInt2 = paramDiyThemeDetail.uin32_feetype.get();
        label357:
        if (paramDiyThemeDetail == null) {
          break label642;
        }
        str1 = paramDiyThemeDetail.str_bg_thumbnail_url.get();
        label372:
        String str2 = ChatBackgroundManager.a(true, "" + i);
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.mApp.getAccount(), str2, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        if (!paramString3.equals(paramString2))
        {
          String str3 = ChatBackgroundManager.a(true, "" + i);
          ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString2, this.mApp.getAccount(), str3, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        }
        if (paramInt1 == 2) {
          aemb.a(localMobileQQ, this.app.getAccount(), null, str2);
        }
      }
      if ((!"100".equals(String.valueOf(i))) && (!"0".equals(String.valueOf(i)))) {
        break;
      }
      if (paramDiyThemeDetail != null) {}
      for (paramInt1 = paramDiyThemeDetail.uin32_feetype.get();; paramInt1 = 1)
      {
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.mApp.getAccount(), "", "", "", "", paramInt1, null, true);
        return;
        label606:
        bool = false;
        break;
        label612:
        localObject = "" + i;
        break label343;
        label637:
        paramInt2 = 1;
        break label357;
        label642:
        str1 = null;
        break label372;
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mApp == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    Object localObject1 = this.mApp.getApplication();
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("themePath");
    Object localObject2;
    Object localObject3;
    String str3;
    try
    {
      localObject2 = new ThemeAuth.SubCmd0x1ReqAuth();
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_op_type.set(1);
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_theme_id.set(Integer.parseInt(str1));
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_version.set("20000000");
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
      localObject3 = ThemeUtil.getUinThemePreferences(this.mApp);
      str3 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", null);
      l1 = ((SharedPreferences)localObject3).getLong("themeSetTimeKey", 0L);
      QLog.d("Theme.ThemeHandler", 1, "Theme Auth themeId=" + str1 + ",version=" + "20000000" + ", userThemeId=" + str3 + ",currentThemeResPath=" + str2 + ", usr=" + baiy.a(this.mApp.getAccount(), 2) + ", oldTime=" + l1);
      if ("1000".equals(str1)) {
        break label964;
      }
      Object localObject4 = a(str2);
      if (((HashMap)localObject4).size() < 3) {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth fileMD5 size error:size=" + ((HashMap)localObject4).size());
      }
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)localEntry.getKey() + ",FileMd5=" + (String)localEntry.getValue());
          }
          ThemeAuth.ThemeFileInfo localThemeFileInfo = new ThemeAuth.ThemeFileInfo();
          localThemeFileInfo.str_file_path.set((String)localEntry.getKey());
          localThemeFileInfo.str_file_md5.set((String)localEntry.getValue());
          ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).rpt_msg_topic_file_info.add(localThemeFileInfo);
          continue;
          if (BaseApplicationImpl.IS_SUPPORT_THEME) {
            break;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("Theme.ThemeHandler", 1, "Theme Auth send Exception:" + paramBundle.getMessage() + ", themeId=" + str1 + ", version=" + "20000000");
    }
    label516:
    label564:
    do
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
      int j = bdee.a(null);
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        break;
      }
      i = 1;
      bakg.a(null, "theme_detail", "205", 157, j, i, str1, "20000000", "1", "");
      return;
      ((SharedPreferences)localObject3).edit().putLong("authTime", 0L).commit();
      localObject3 = new ThemeAuth.ReqBody();
      ((ThemeAuth.ReqBody)localObject3).uint32_sub_cmd.set(1);
      ((ThemeAuth.ReqBody)localObject3).int32_plat_id.set(109);
      ((ThemeAuth.ReqBody)localObject3).str_qq_version.set("8.3.3.4515");
      ((ThemeAuth.ReqBody)localObject3).uint32_qq_version.set(Integer.parseInt("4515"));
      ((ThemeAuth.ReqBody)localObject3).msg_subcmd0x1_req_auth.set((MessageMicro)localObject2);
      ((ThemeAuth.ReqBody)localObject3).setHasFlag(true);
      localObject2 = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
      ((ToServiceMsg)localObject2).putWupBuffer(((ThemeAuth.ReqBody)localObject3).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putAll(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request, themeID=" + str1 + ", userThemeId=" + str3);
      }
      super.sendPbReq((ToServiceMsg)localObject2);
    } while (("1000".equals(str1)) || (TextUtils.isEmpty(str2)));
    paramBundle = new File(str2);
    long l1 = System.currentTimeMillis();
    localObject1 = ThemeUtil.getThemeInfo((Context)localObject1, str1);
    long l2 = System.currentTimeMillis();
    if (localObject1 != null) {}
    for (int i = 1;; i = -1)
    {
      bakg.a(null, "theme_sp_speed", "204", 153, -1, i, String.valueOf(l2 - l1), "6653", "read", "");
      if ((paramBundle.isDirectory()) && (localObject1 != null))
      {
        i = ThemeUtil.getFileNumInFile(paramBundle);
        if ((i > 0) && ((((ThemeUtil.ThemeInfo)localObject1).fileNum <= 0) || (i >= ((ThemeUtil.ThemeInfo)localObject1).fileNum))) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ", themeId=" + str1 + ", version=" + "20000000" + ", currentThemeResPath:" + str2);
        bakg.a(this.app, "theme_detail", "204", 157, bdee.a(null), 101, str1, "665", String.valueOf(i), String.valueOf(((ThemeUtil.ThemeInfo)localObject1).fileNum));
        break;
        label964:
        if ((!TextUtils.isEmpty(str3)) && (!"1000".equals(str3))) {
          break label564;
        }
        l1 = ((SharedPreferences)localObject3).getLong("authTime", 0L);
        l2 = System.currentTimeMillis();
        if (l2 > l1 + 7200000L)
        {
          ((SharedPreferences)localObject3).edit().putLong("authTime", l2).commit();
          break label564;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
        }
        bajd.b(true);
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + str2);
      break;
      i = -40;
      break label516;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ("204".equalsIgnoreCase(paramString2))
    {
      if (!bajd.a(paramString1, paramString2)) {
        a(paramString1, paramString2);
      }
      while (ThemeUtil.isFixTheme(paramString1)) {
        return;
      }
      bakj.a(this.app, paramString1, "20000000");
      return;
    }
    a(paramString1, paramString2);
  }
  
  public void a()
  {
    if (this.mApp == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    MobileQQ localMobileQQ = this.mApp.getApplication();
    Object localObject1 = ThemeUtil.getThemePreferences(localMobileQQ);
    Object localObject4;
    Object localObject3;
    if (1 > ((SharedPreferences)localObject1).getInt("themeSpVersion", 0))
    {
      localObject4 = ((SharedPreferences)localObject1).edit();
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("userDownloadTheme", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          JSONObject localJSONObject1 = new JSONObject((String)localObject1);
          Iterator localIterator = localJSONObject1.keys();
          while (localIterator.hasNext())
          {
            String str1 = String.valueOf(localIterator.next());
            if ((!TextUtils.isEmpty(str1)) && (!"1000".equals(str1)) && (!"999".equals(str1)))
            {
              JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str1);
              if (localJSONObject2 != null)
              {
                String str2 = localJSONObject2.optString("version");
                localObject3 = ThemeUtil.getThemeInfo(localMobileQQ, str1);
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  localObject1 = new ThemeUtil.ThemeInfo();
                  ((ThemeUtil.ThemeInfo)localObject1).themeId = str1;
                  ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = localJSONObject2.optBoolean("sound");
                  ((ThemeUtil.ThemeInfo)localObject1).fileNum = localJSONObject2.optInt("fileNum");
                }
                ((ThemeUtil.ThemeInfo)localObject1).version = str2;
                ((ThemeUtil.ThemeInfo)localObject1).zipVer = Integer.parseInt(str2);
                ((ThemeUtil.ThemeInfo)localObject1).status = "1";
                ThemeUtil.setThemeInfo(localMobileQQ, (ThemeUtil.ThemeInfo)localObject1);
              }
            }
          }
        }
        ((SharedPreferences.Editor)localObject4).putInt("themeSpVersion", 1).commit();
      }
      catch (Exception localException)
      {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth themeUpdate error:" + localException.getMessage());
      }
    }
    else
    {
      localObject4 = ThemeUtil.getCurrentThemeInfo();
      ((Bundle)localObject4).putString("oldEnginePath", ((Bundle)localObject4).getString("themePath"));
      QLog.d("Theme.ThemeHandler", 1, "sendThemeAuth init: , skThemeId:" + ((Bundle)localObject4).getString("themeId") + ", skVersion:" + ((Bundle)localObject4).getString("version") + ", qqVersion:" + "8.3.3");
      localObject3 = ((Bundle)localObject4).getString("themeId");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = "1000";
        ((Bundle)localObject4).putString("themeId", "1000");
      }
      if (azib.a((String)localObject2))
      {
        localObject3 = bakj.a(this.app).getString("themeID");
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth isThemeSimpleUI:" + (String)localObject2 + " pre:" + (String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label520;
        }
        localObject2 = "1000";
        label473:
        ((Bundle)localObject4).putString("themeId", (String)localObject2);
        if (!"1000".equals(localObject3)) {
          break label525;
        }
        ((Bundle)localObject4).remove("themePath");
      }
    }
    for (;;)
    {
      a((Bundle)localObject4);
      return;
      ((SharedPreferences.Editor)localObject4).remove("userDownloadTheme");
      break;
      label520:
      localObject2 = localObject3;
      break label473;
      label525:
      if (!"999".equals(localObject3)) {
        break label559;
      }
      ((Bundle)localObject4).putString("themePath", new bakf().a().d());
    }
    label559:
    Object localObject2 = new bakf().a((String)localObject3);
    ((VasQuickUpdateManager)this.app.getManager(184)).queryItemVersion(3, ((bakf)localObject2).b(), true, false, 0L, new alyw(this, (bakf)localObject2, localMobileQQ, (Bundle)localObject4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    boolean bool2 = azib.b();
    if (!bool2)
    {
      if (!bool1) {
        break label110;
      }
      ThemeSwitcher.a("1103", paramString2, null);
    }
    for (;;)
    {
      QLog.e("Theme.ThemeHandler", 1, "onGetServerTheme: " + paramString1 + "," + bool2 + "," + bool1 + "," + paramString2);
      if (!ThemeUtil.isFixTheme(paramString1)) {
        bakj.a(this.app, paramString1, "20000000");
      }
      return;
      label110:
      ThemeSwitcher.a(paramString1, paramString2, new alyv(this));
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, baks parambaks)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 87
    //   11: iconst_2
    //   12: new 89	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 732
    //   22: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 401
    //   32: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 734
    //   42: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +8 -> 67
    //   62: aload 4
    //   64: ifnonnull +13 -> 77
    //   67: ldc 87
    //   69: iconst_2
    //   70: ldc_w 736
    //   73: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: aload 4
    //   79: ldc 254
    //   81: aload_1
    //   82: invokevirtual 652	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload 5
    //   88: putfield 738	alyu:jdField_a_of_type_Baks	Lbaks;
    //   91: aload_0
    //   92: aload 4
    //   94: putfield 740	alyu:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   97: new 742	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet
    //   100: dup
    //   101: invokespecial 743	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: getfield 744	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: aload_1
    //   110: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   116: aload_3
    //   117: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: istore 8
    //   122: iload 7
    //   124: istore 6
    //   126: iload 8
    //   128: ifne +9 -> 137
    //   131: aload_3
    //   132: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   135: istore 6
    //   137: aload_2
    //   138: getfield 747	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_suit_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   141: iload 6
    //   143: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   146: aload 4
    //   148: ldc_w 749
    //   151: invokevirtual 753	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload 4
    //   161: aload_1
    //   162: invokevirtual 498	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   165: ldc_w 755
    //   168: aload 4
    //   170: ldc_w 757
    //   173: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +277 -> 456
    //   182: new 759	com/tencent/pb/theme/ThemeAuth$diyThemeInfo
    //   185: dup
    //   186: invokespecial 760	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:<init>	()V
    //   189: astore_1
    //   190: aload_1
    //   191: getfield 763	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_drawer_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   194: aload 4
    //   196: ldc_w 765
    //   199: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   208: aload_1
    //   209: getfield 768	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_message_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: aload 4
    //   214: ldc_w 770
    //   217: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   226: aload_1
    //   227: getfield 773	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_aio_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   230: aload 4
    //   232: ldc_w 775
    //   235: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   244: aload_1
    //   245: getfield 778	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_freind_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: aload 4
    //   250: ldc_w 780
    //   253: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   259: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload_1
    //   263: getfield 783	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_dynamics_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   266: aload 4
    //   268: ldc_w 785
    //   271: invokevirtual 259	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   280: aload_2
    //   281: getfield 789	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:diy_theme_info	Lcom/tencent/pb/theme/ThemeAuth$diyThemeInfo;
    //   284: aload_1
    //   285: invokevirtual 790	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   288: aload_2
    //   289: getfield 793	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   292: iconst_1
    //   293: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   296: new 442	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   299: dup
    //   300: invokespecial 443	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   303: astore_1
    //   304: aload_1
    //   305: getfield 446	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: iconst_3
    //   309: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   312: aload_1
    //   313: getfield 450	com/tencent/pb/theme/ThemeAuth$ReqBody:int32_plat_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   316: bipush 109
    //   318: invokevirtual 453	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   321: aload_1
    //   322: getfield 456	com/tencent/pb/theme/ThemeAuth$ReqBody:str_qq_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   325: ldc_w 458
    //   328: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   331: aload_1
    //   332: getfield 461	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_qq_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   335: ldc_w 463
    //   338: invokestatic 280	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   344: aload_1
    //   345: getfield 797	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x3_req_set	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet;
    //   348: aload_2
    //   349: invokevirtual 798	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   352: aload_1
    //   353: iconst_1
    //   354: invokevirtual 472	com/tencent/pb/theme/ThemeAuth$ReqBody:setHasFlag	(Z)V
    //   357: new 474	com/tencent/qphone/base/remote/ToServiceMsg
    //   360: dup
    //   361: ldc_w 476
    //   364: aload_0
    //   365: getfield 126	alyu:mApp	Lcom/tencent/common/app/AppInterface;
    //   368: invokevirtual 479	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   371: ldc_w 481
    //   374: invokespecial 484	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   377: astore_2
    //   378: aload_2
    //   379: aload_1
    //   380: invokevirtual 488	com/tencent/pb/theme/ThemeAuth$ReqBody:toByteArray	()[B
    //   383: invokevirtual 492	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   386: aload_0
    //   387: aload_2
    //   388: invokespecial 504	alko:sendPbReq	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   391: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -318 -> 76
    //   397: ldc 87
    //   399: iconst_2
    //   400: ldc_w 800
    //   403: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: return
    //   407: astore_1
    //   408: ldc 87
    //   410: iconst_2
    //   411: new 89	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 802
    //   421: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_1
    //   425: invokevirtual 803	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: return
    //   438: astore_1
    //   439: ldc 87
    //   441: iconst_1
    //   442: ldc_w 805
    //   445: aload_1
    //   446: invokestatic 808	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   449: iload 7
    //   451: istore 6
    //   453: goto -316 -> 137
    //   456: aload_2
    //   457: getfield 793	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   460: iconst_0
    //   461: invokevirtual 271	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   464: goto -168 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	alyu
    //   0	467	1	paramString1	String
    //   0	467	2	paramString2	String
    //   0	467	3	paramString3	String
    //   0	467	4	paramBundle	Bundle
    //   0	467	5	parambaks	baks
    //   124	328	6	i	int
    //   1	449	7	j	int
    //   120	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	122	407	java/lang/Exception
    //   137	155	407	java/lang/Exception
    //   159	165	407	java/lang/Exception
    //   165	296	407	java/lang/Exception
    //   296	406	407	java/lang/Exception
    //   439	449	407	java/lang/Exception
    //   456	464	407	java/lang/Exception
    //   131	137	438	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    label12:
    String str;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      else
      {
        paramString2 = ThemeUtil.getCurrentThemeInfo();
        paramString1 = paramString2.getString("themeId");
        str = paramString2.getString("version");
      }
    } while ((TextUtils.isEmpty(paramString1)) || ("1000".equals(paramString1)) || ("999".equals(paramString1)) || (TextUtils.isEmpty(str)));
    jdField_a_of_type_JavaLangString = paramString1;
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(str) % 10000;
        paramString2 = ThemeUtil.getThemeDensity(this.mApp.getApp());
        if (!"m".equals(paramString2)) {
          break label377;
        }
        i -= 1000;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "ver = " + i);
        }
        paramString2 = new ThemeAuth.SubCmd0x2ReqCheck();
        paramString2.str_theme_version.set(String.valueOf(i));
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(2);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("8.3.3.4515");
        paramString1.uint32_qq_version.set(Integer.parseInt("4515"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.sendPbReq(paramString2);
        if (!QLog.isColorLevel()) {
          break label12;
        }
        QLog.i("Theme.ThemeHandler", 2, "ThemeVersion Check sent,cur_ver = " + i);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 2, "Exception:" + paramString1.toString());
      return;
      label377:
      paramBoolean = "h".equals(paramString2);
      if (paramBoolean) {
        i -= 2000;
      } else {
        i -= 3000;
      }
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {}
    Object localObject1;
    int k;
    int j;
    boolean bool;
    label995:
    label1001:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "onReceive~ handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + bdlr.a((byte[])paramObject));
      }
      String str1;
      String str2;
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = new ThemeAuth.RspBody();
          if (paramObject != null) {
            ((ThemeAuth.RspBody)localObject1).mergeFrom((byte[])paramObject);
          }
          if (((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.has())
          {
            i = ((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.get();
            if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
              break label995;
            }
            k = 1;
            j = i;
            if (k == 0)
            {
              j = i;
              if (-1 == i)
              {
                paramFromServiceMsg = new ThemeAuth.ReqBody();
                paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
                j = paramFromServiceMsg.uint32_sub_cmd.get();
              }
              if (1 == j) {
                ThemeUtil.getUinThemePreferences(this.mApp).edit().putLong("authTime", 0L).commit();
              }
              QLog.e("Theme.ThemeHandler", 1, "onReceive Error: isSuccess=false, data=" + bdlr.a((byte[])paramObject) + ", subCmd=" + j);
              if (3 != j) {
                break;
              }
            }
            if (1 != j) {
              break label2052;
            }
            paramObject = (ThemeAuth.SubCmd0x1RspAuth)((ThemeAuth.RspBody)localObject1).msg_subcmd0x1_rsp_auth.get();
            j = paramObject.int32_result.get();
            paramFromServiceMsg = new ThemeAuth.ReqBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
            paramFromServiceMsg = (ThemeAuth.SubCmd0x1ReqAuth)paramFromServiceMsg.msg_subcmd0x1_req_auth.get();
            str1 = String.valueOf(paramFromServiceMsg.uint32_theme_id.get());
            str2 = paramFromServiceMsg.str_theme_version.get();
            if (j == 0) {
              break label1001;
            }
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, error, ret:" + j + ", reqthemeId:" + str1 + ", reqVersion:" + str2);
            bdqk.a(this.app, "individual_v2_theme_auth_fail", String.valueOf(j), String.valueOf(j), null, 0.0F);
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("authResult", String.valueOf(j));
            azmz.a(BaseApplication.getContext()).a("", "individual_v2_theme_auth_fail", false, 0L, -1L, paramFromServiceMsg, "", true);
            bakg.a(this.app, "theme_detail", "204", 157, bdee.a(null), 0 - j, str1, str2, "1", "");
          }
        }
        catch (Exception paramToServiceMsg)
        {
          String str3;
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Exception=" + paramToServiceMsg.getMessage());
          return;
        }
        try
        {
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_themeId", str1);
          paramFromServiceMsg.put("param_themeVersion", str2);
          paramFromServiceMsg.put("param_FailCode", String.valueOf(j));
          localObject2 = azmz.a(this.mApp.getApplication());
          str3 = this.mApp.getAccount();
          if (j != 0) {
            break label2737;
          }
          bool = true;
          ((azmz)localObject2).a(str3, "VipThemeAuthHandleError", bool, 1L, 0L, paramFromServiceMsg, "", false);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, StatisticCollector error=" + paramFromServiceMsg.toString());
          continue;
          if (j == 4) {
            break label1087;
          }
          ThemeUtil.setWeekLoopTheme(this.mApp, null, null, 0L);
          bool = SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), null);
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
          if (j == 1) {
            break label2743;
          }
        }
        if ((j < 1) || (j == 5) || (j == 14) || (j > 20)) {
          break label1410;
        }
        ThemeUtil.getUinThemePreferences(this.mApp).edit().putInt("themeAuthResult", j).commit();
        ThemeUtil.setCurrentThemeIdVersion(this.mApp, "1000", "0");
        paramToServiceMsg = ((ThemeAuth.RspBody)localObject1).msg_subcmd0x1_rsp_auth.str_err_msg.get();
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, authResult=" + j + ", reqthemeId:" + str1 + ", err_msg=" + paramToServiceMsg);
        if ((3 != j) || ("1000".equals(str1))) {
          break label1070;
        }
        ThemeUtil.setErrorThemeId(this.mApp.getApplication(), str1, false);
        ThemeUtil.getUserCurrentThemeVersion(this.mApp);
        bool = SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), null);
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, set default theme");
        if (bool == true) {
          ThreadManager.getUIHandler().post(new ThemeHandler.1(this));
        }
        paramToServiceMsg = ThemeUtil.getThemeInfo(this.mApp.getApplication(), str1);
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg.status = "1";
          ThemeUtil.setThemeInfo(this.mApp.getApplication(), paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=" + str1);
          }
        }
        try
        {
          paramToServiceMsg = new bakf().a(str1).a(this.mApp.getApplication());
          bdcs.a(paramToServiceMsg, true);
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth no right, delete: " + paramToServiceMsg);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth delete Error, msg=" + paramToServiceMsg.getMessage());
          return;
        }
        i = -1;
        continue;
        k = 0;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + j);
        }
      }
      if (j != 2) {
        break label2749;
      }
      break label2743;
      if (bool) {
        azmj.b(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i), "", "", "");
      }
      if (!TextUtils.isEmpty(paramToServiceMsg)) {
        break label2728;
      }
      paramToServiceMsg = alpo.a(2131715294);
      if (bool)
      {
        paramFromServiceMsg = this.mApp.getHandler(Conversation.class);
        paramObject = new Message();
        paramObject.what = 1049;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("expireMsg", paramToServiceMsg);
        ((Bundle)localObject1).putString("themeId", str1);
        ((Bundle)localObject1).putInt("authResult", j);
        ((Bundle)localObject1).putInt("expireType", i);
        paramObject.obj = localObject1;
        paramFromServiceMsg.sendMessage(paramObject);
      }
      if (ThemeBackground.getMarkOfAioBgFromDiy(this.mApp.getApplication(), "theme_bg_aio_path", this.mApp.getAccount()))
      {
        aemb.a(this.mApp.getApplication(), this.app.getAccount(), null, "null");
        ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_aio_path", this.app.getAccount());
      }
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_setting_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_message_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_friend_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_dynamic_path_png", this.app.getAccount());
      return;
      if (j == 0)
      {
        localObject1 = String.valueOf(paramObject.uint32_theme_id.get());
        paramFromServiceMsg = paramObject.str_version.get();
        localObject2 = paramObject.str_download_url.get();
        i = paramObject.int32_suit_id.get();
        if ((QLog.isColorLevel()) || ((str2 != null) && (!str1.equals(localObject1)))) {
          QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + (String)localObject1 + ",ver=" + paramFromServiceMsg + ",Url=" + (String)localObject2 + ", seriesId=" + i + ", reqthemeId:" + str1 + ", reqVersion:" + str2);
        }
        if (("999".equals(localObject1)) || ("1000".equals(localObject1))) {
          break label2782;
        }
        if ((TextUtils.isEmpty(paramFromServiceMsg)) || ("0".equals(localObject1))) {
          paramFromServiceMsg = String.valueOf(200);
        }
        paramToServiceMsg = paramToServiceMsg.extraData.getString("oldEnginePath", null);
        str1 = SkinEngine.getInstances().getSkinRootPath();
        QLog.e("Theme.ThemeHandler", 1, "engine path old is : " + paramToServiceMsg + " new is " + str1);
        if ((!TextUtils.isEmpty(str1)) && (!str1.equals(paramToServiceMsg)))
        {
          QLog.e("Theme.ThemeHandler", 1, "engine init during auth, resend auth");
          a();
          return;
        }
        if (i <= 0)
        {
          QLog.e("Theme.ThemeHandler", 1, "clear weekTheme because seriesId=" + i);
          ThemeUtil.setWeekLoopTheme(this.mApp, null, null, 0L);
        }
        if (i > 0)
        {
          paramToServiceMsg = ThemeUtil.getWeekLoopTheme(this.app);
          if (!TextUtils.isEmpty(paramToServiceMsg))
          {
            b(paramToServiceMsg, "203");
            return;
          }
        }
        if ((!"0".equals(localObject1)) && (!TextUtils.isEmpty(paramFromServiceMsg)) && (!this.c.get()))
        {
          if (paramObject.uint32_diy_theme_flag.get() == 1)
          {
            paramToServiceMsg = (ThemeAuth.RspDiyThemeInfo)paramObject.rsp_diy_theme_info.get();
            paramFromServiceMsg = (ThemeAuth.RspDiyThemeDetail)paramObject.rsp_diy_theme_detail.get();
            a(0, paramToServiceMsg.uin32_drawer_tab_id.get(), paramToServiceMsg.str_drawer_tab_url.get(), "theme_bg_setting_path", "theme_bg_setting_path_png", (ThemeAuth.DiyThemeDetail)paramFromServiceMsg.drawer_tab_detail.get());
            a(1, paramToServiceMsg.uin32_message_tab_id.get(), paramToServiceMsg.str_message_tab_url.get(), "theme_bg_message_path", "theme_bg_message_path_png", (ThemeAuth.DiyThemeDetail)paramFromServiceMsg.message_tab_detail.get());
            a(2, paramToServiceMsg.uin32_aio_tab_id.get(), paramToServiceMsg.str_aio_tab_url.get(), "theme_bg_aio_path", "theme_bg_aio_path", (ThemeAuth.DiyThemeDetail)paramFromServiceMsg.aio_tab_detail.get());
            a(3, paramToServiceMsg.uin32_friend_tab_id.get(), paramToServiceMsg.str_friend_tab_url.get(), "theme_bg_friend_path", "theme_bg_friend_path_png", (ThemeAuth.DiyThemeDetail)paramFromServiceMsg.friend_tab_detail.get());
            a(4, paramToServiceMsg.uin32_dynamic_tab_id.get(), paramToServiceMsg.str_dynamic_tab_url.get(), "theme_bg_dynamic_path", "theme_bg_dynamic_path_png", (ThemeAuth.DiyThemeDetail)paramFromServiceMsg.dynamic_tab_detail.get());
          }
          b((String)localObject1, "204");
          return;
        }
        a(null, null, true);
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth unknow type ret=" + j);
      a(null, null, true);
      return;
      if (2 != j) {
        break;
      }
      i = ((ThemeAuth.SubCmd0x2RspCheck)((ThemeAuth.RspBody)localObject1).msg_subcmd0x2_rsp_check.get()).int32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i);
      }
      paramToServiceMsg = this.mApp.getAccount();
      if (!TextUtils.isEmpty(paramToServiceMsg))
      {
        paramToServiceMsg = this.mApp.getApplication().getSharedPreferences(paramToServiceMsg, 0);
        if (i == 6) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", true).commit();
        }
        if (paramToServiceMsg.getBoolean("need_check_theme_ver", false)) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", false).commit();
        }
      }
    } while (i != 0);
    label1070:
    label1087:
    label1127:
    paramToServiceMsg = this.mApp.getHandler(Conversation.class);
    label1176:
    label1580:
    paramFromServiceMsg = new Message();
    label1410:
    label2052:
    paramFromServiceMsg.what = 1038;
    paramFromServiceMsg.obj = jdField_a_of_type_JavaLangString;
    paramToServiceMsg.sendMessage(paramFromServiceMsg);
    azmj.b(this.app, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
    paramFromServiceMsg = new Message();
    paramFromServiceMsg.what = 1039;
    paramToServiceMsg.sendMessageDelayed(paramFromServiceMsg, 90000L);
    return;
    if (3 == j)
    {
      paramFromServiceMsg = alpo.a(2131715297);
      if (k != 0)
      {
        paramToServiceMsg = (ThemeAuth.SubCmd0x3RspSet)((ThemeAuth.RspBody)localObject1).msg_subcmd0x3_rsp_set.get();
        i = paramToServiceMsg.int32_result.get();
        paramFromServiceMsg = String.valueOf(paramToServiceMsg.uint32_theme_id.get());
        paramToServiceMsg = paramToServiceMsg.str_diy_theme_err_msg.get();
      }
      for (;;)
      {
        if ((QLog.isColorLevel()) || (i != 0)) {
          QLog.d("Theme.ThemeHandler", 1, "handleThemeAuth Set result:" + i + ", themeId:" + paramFromServiceMsg);
        }
        if ((this.jdField_a_of_type_Baks != null) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i);
        this.jdField_a_of_type_AndroidOsBundle = null;
        this.jdField_a_of_type_Baks = null;
        return;
        paramObject = new ThemeAuth.ReqBody();
        paramObject.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        j = ((ThemeAuth.SubCmd0x3ReqSet)paramObject.msg_subcmd0x3_req_set.get()).uint32_theme_id.get();
        i = -404;
        paramObject = String.valueOf(j);
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("message", paramToServiceMsg);
      this.jdField_a_of_type_AndroidOsBundle.putInt("result_int", i);
      if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals(this.jdField_a_of_type_AndroidOsBundle.getString("themeId"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + paramFromServiceMsg + ", result=" + i);
        }
        paramToServiceMsg = this.jdField_a_of_type_Baks;
        if (i != 0) {
          break label2789;
        }
      }
    }
    label2728:
    label2737:
    label2743:
    label2749:
    label2782:
    label2789:
    for (int i = 4;; i = 8)
    {
      paramToServiceMsg.callback(16, i, this.jdField_a_of_type_AndroidOsBundle, null);
      this.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_a_of_type_Baks = null;
      this.c.set(true);
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + paramFromServiceMsg + ", rbThemeid=" + this.jdField_a_of_type_AndroidOsBundle.getString("themeId"));
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth subCmd error, subCmd:" + j);
      return;
      break label1176;
      do
      {
        i = 4;
        break label1127;
        bool = false;
        break;
        i = 1;
        break label1127;
        if ((j == 10) || (j == 11))
        {
          i = 2;
          break label1127;
        }
      } while (j != 6);
      i = 3;
      break label1127;
      paramFromServiceMsg = "20000000";
      break label1580;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyu
 * JD-Core Version:    0.7.0.1
 */