import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.PreviewInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.10;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.11;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.12;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.13;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.14;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.15;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.16;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.17;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.18;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.19;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.2;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.20;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.21;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.3;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.7;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.8;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSpringEntryInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

public class ahfx
  implements Manager
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ahfo jdField_a_of_type_Ahfo;
  private ahfq jdField_a_of_type_Ahfq;
  private ahgd jdField_a_of_type_Ahgd;
  private volatile ahgk jdField_a_of_type_Ahgk;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
  private SpringFestivalRedpakcetPreviewConfBean.BreathLight jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile DesktopDataManager.HongBaoResBuilder jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile String jdField_a_of_type_JavaLangString = "";
  private List<ahgi> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  
  public ahfx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new ahfy(this));
    this.jdField_a_of_type_Ahfo = ((ahfo)paramQQAppInterface.getManager(341));
    this.jdField_a_of_type_Ahfq = ((ahfq)paramQQAppInterface.getManager(343));
    b(new SpringHbEntryManager.2(this));
  }
  
  private long a(SpringFestivalRedpakcetPreviewConfBean.BreathLight paramBreathLight)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4).getLong("first_enter_time_" + a(paramBreathLight.breathTimeInfo.beginTime, paramBreathLight.breathTimeInfo.endTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0L);
  }
  
  private Bitmap a(String paramString, boolean paramBoolean)
  {
    return ahgj.a(paramString, paramBoolean);
  }
  
  private SpringFestivalRedpacketConfBean.TimeInfo a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.entryShowTime))) {
      return null;
    }
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.entryShowTime, new ahgc(this));
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.entryShowTime.iterator();
    while (localIterator.hasNext())
    {
      SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = (SpringFestivalRedpacketConfBean.TimeInfo)localIterator.next();
      if (a(localTimeInfo, paramLong)) {
        return localTimeInfo;
      }
    }
    return null;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo == null)) {
      return null;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.defaultVideoUrl;
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = a(b());
    String str1 = str2;
    if (localActivityInfo != null)
    {
      str1 = str2;
      if (!bbkk.a(localActivityInfo.videoUrl)) {
        str1 = localActivityInfo.videoUrl;
      }
    }
    str2 = PreloadManager.e(str1);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getTransitionVideoResUrl -->" + str1 + ",resPath:" + str2);
    }
    return str2;
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    paramString = paramLong1 + "_" + paramLong2 + "_" + paramString + "_" + "spring_breath_light_show";
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "generateLightKey:" + paramString);
    }
    return paramString;
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("springHb_SpringEntryManager", 2, "runCurrentTask. isPeedUp: " + i() + " currentTime is: " + bbkp.b(paramLong) + " taskSize:" + this.jdField_a_of_type_JavaUtilList.size());
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahgi localahgi = (ahgi)((Iterator)localObject).next();
        QLog.w("springHb_SpringEntryManager", 2, "runCurrentTask current task is: " + localahgi.a() + ": time is" + ahfl.a(localahgi.jdField_a_of_type_Long));
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.entryShowTime;
    if ((a((List)localObject)) || (a(this.jdField_a_of_type_JavaUtilList)))
    {
      b(4);
      a("", 1002);
      a("", 2002);
      a("", 3002);
      if (QLog.isColorLevel()) {
        QLog.w("springHb_SpringEntryManager", 2, "runCurrentTask,entryShowTimeList is empty ,just return");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (ahfl.a((SpringFestivalRedpacketConfBean.TimeInfo)((Iterator)localObject).next(), paramLong)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("springHb_SpringEntryManager", 2, "runCurrentTask,isInEntryShowTime ：false,currentTime:" + paramLong);
      }
      b(4);
      a("", 1002);
      a("", 2002);
      a("", 3002);
      return;
    }
    b(2);
    localObject = b(paramLong);
    if (localObject == null)
    {
      a("", 1001);
      a("", 2002);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "runCurrentTask. mCurrentActivityInfo is null,hide pendent and return.");
      }
    }
    for (;;)
    {
      localObject = a(paramLong);
      if (localObject != null) {
        break;
      }
      a("", 3002);
      return;
      a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).id, 1001);
      a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).id, 2001);
    }
    a("", 3001, (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject);
  }
  
  private void a(Message paramMessage)
  {
    QLog.i("springHb_SpringEntryManager", 2, "handleTaskMsg isSpeedUp: " + i() + " currentTime is: " + bbkp.b(b()));
    if (paramMessage.arg1 != 1)
    {
      paramMessage = (ahgi)this.jdField_a_of_type_JavaUtilList.remove(0);
      QLog.i("springHb_SpringEntryManager", 2, "handleTaskMsg task is: " + paramMessage.toString());
      if (paramMessage.jdField_a_of_type_Int == 3001) {
        a(paramMessage.b, paramMessage.jdField_a_of_type_Int, a(b()));
      }
    }
    while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      m();
      return;
      a(paramMessage.b, paramMessage.jdField_a_of_type_Int);
      continue;
      QLog.i("springHb_SpringEntryManager", 2, "handleTaskMsg just loop check. do nothing.");
    }
    b(3);
  }
  
  private void a(SpringFestivalRedpakcetPreviewConfBean paramSpringFestivalRedpakcetPreviewConfBean)
  {
    for (;;)
    {
      try
      {
        localObject = paramSpringFestivalRedpakcetPreviewConfBean.jdField_a_of_type_JavaUtilArrayList;
        int i;
        if (a((List)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringEntryManager", 2, "isShowPreview activityPreviewList is Empty!! return false!");
          }
        }
        else
        {
          i = paramSpringFestivalRedpakcetPreviewConfBean.jdField_a_of_type_Int;
          paramSpringFestivalRedpakcetPreviewConfBean = ((ArrayList)localObject).iterator();
        }
        if (paramSpringFestivalRedpakcetPreviewConfBean.hasNext())
        {
          localObject = (SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)paramSpringFestivalRedpakcetPreviewConfBean.next();
          if (localObject == null) {
            continue;
          }
          if (!a(((SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)localObject).prewTimeInfo)) {
            paramSpringFestivalRedpakcetPreviewConfBean.remove();
          }
        }
        else
        {
          continue;
        }
        if (i != 1) {
          continue;
        }
      }
      finally {}
      Object localObject = ((SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)localObject).prewTimeInfo;
      ((SpringFestivalRedpacketConfBean.TimeInfo)localObject).beginTime += a();
    }
  }
  
  private void a(String paramString, int paramInt, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "onTaskNeed2Execute -->entryId:" + paramString + ",action:" + ahgi.a(paramInt));
    }
    long l = b();
    switch (paramInt)
    {
    default: 
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
    case 3001: 
    case 3002: 
    case 4001: 
      label394:
      boolean bool1;
      boolean bool2;
      boolean bool3;
      do
      {
        do
        {
          return;
          paramString = b();
          a(new SpringHbEntryManager.7(this, paramString));
        } while (!QLog.isColorLevel());
        QLog.i("springHb_SpringEntryManager", 2, "onTaskNeed2Execute --> action_show_entry, wording: ，transitionBitmap is" + paramString);
        return;
        a(new SpringHbEntryManager.8(this));
        return;
        QLog.i("springHb_SpringEntryManager", 2, "onTaskNeed2Execute --> action_show_default_pendant,entryId:" + paramString + ",mCurrentShowPendantId:" + this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangString = paramString;
        a(new SpringHbEntryManager.9(this));
        return;
        QLog.i("springHb_SpringEntryManager", 2, "onTaskNeed2Execute --> action_hide_default_pendant,entryId:" + paramString + ",mCurrentShowPendantId:" + this.jdField_a_of_type_JavaLangString);
        if ((!bbkk.a(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
        {
          QLog.i("springHb_SpringEntryManager", 1, "onTaskNeed2Execute --> hide pendant failed,entryId:" + paramString + ",mCurrentShowPendantId:" + this.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_JavaLangString = "";
        a(new SpringHbEntryManager.10(this));
        return;
        if (paramBannerInfo != null)
        {
          if (!ahfl.a(paramBannerInfo.soonTime, l)) {
            break label394;
          }
          paramBannerInfo.status = 0;
        }
        for (;;)
        {
          a(true, paramBannerInfo);
          return;
          if (ahfl.a(paramBannerInfo.bannerTime, l)) {
            paramBannerInfo.status = 1;
          }
        }
        a(false, null);
        return;
        paramBannerInfo = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
        bool1 = paramBannerInfo.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "spring_active_dialog_show", false);
        bool2 = a(l);
        bool3 = k();
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "hasActiveDialogShow: " + bool1 + " canShow: " + bool2 + " isFirstLogin: " + bool3);
        }
      } while ((bool1) || (!bool2) || (bool3));
      a(new SpringHbEntryManager.11(this, l, paramBannerInfo, paramString));
      return;
    }
    QLog.i("springHb_SpringEntryManager", 2, "onTaskNeed2Execute --> action_hide_preview");
    a(new SpringHbEntryManager.12(this));
  }
  
  private void a(boolean paramBoolean, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo)
  {
    try
    {
      if (ahgj.jdField_a_of_type_Int == 1)
      {
        QLog.w("springHb_SpringEntryManager", 1, "updateBannerView failed，entryMode is no mini");
        return;
      }
      c(paramBoolean);
      if (ahgj.jdField_a_of_type_Int == 3)
      {
        a(new SpringHbEntryManager.19(this, paramBoolean, paramBannerInfo));
        return;
      }
    }
    catch (Throwable paramBannerInfo)
    {
      QLog.e("springHb_SpringEntryManager", 1, paramBannerInfo, new Object[0]);
      return;
    }
    DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(336);
    if (paramBoolean)
    {
      DesktopSpringEntryInfo localDesktopSpringEntryInfo = new DesktopSpringEntryInfo();
      paramBannerInfo.bannerHeight = a();
      localDesktopSpringEntryInfo.bannerInfo = paramBannerInfo;
      a(new SpringHbEntryManager.20(this, localDesktopDataManager, localDesktopSpringEntryInfo));
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "updateBannerView --> show:true,info:" + localDesktopSpringEntryInfo);
      }
    }
    else
    {
      a(new SpringHbEntryManager.21(this, localDesktopDataManager));
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "updateBannerView --> show:false");
      }
    }
  }
  
  private boolean a(SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo)
  {
    return (paramTimeInfo != null) && (paramTimeInfo.beginTime != 0L) && (paramTimeInfo.endTime != 0L) && (paramTimeInfo.beginTime < paramTimeInfo.endTime);
  }
  
  private boolean a(SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo, long paramLong)
  {
    if (paramTimeInfo == null) {
      QLog.w("springHb_SpringEntryManager", 2, "isInTime --> timeInfo is null");
    }
    do
    {
      return false;
      QLog.w("springHb_SpringEntryManager", 2, "isInTime -->beginTime: " + paramTimeInfo.beginTime + "endTime: " + paramTimeInfo.endTime);
    } while ((!a(paramTimeInfo)) || (paramTimeInfo.beginTime > paramLong) || (paramLong > paramTimeInfo.endTime));
    return true;
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private Bitmap b()
  {
    try
    {
      Object localObject1 = c();
      Object localObject2;
      if (!bbkk.a((String)localObject1))
      {
        localObject2 = PreloadManager.e((String)localObject1);
        if ((!bbkk.a((String)localObject2)) && (new File((String)localObject2).exists())) {
          break label142;
        }
        localObject2 = new DownloadParam();
        ((DownloadParam)localObject2).filePos = 0;
        ((DownloadParam)localObject2).url = ((String)localObject1);
        PreloadManager.a().a((DownloadParam)localObject2, new ahfz(this));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.b(BaseApplicationImpl.getContext().getResources().getDrawable(2130846357));
          this.jdField_c_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "getTransitionOrDefaultBitmap -->transitionBgUrl:,is load default:" + this.jdField_c_of_type_Boolean);
        }
        return this.jdField_a_of_type_AndroidGraphicsBitmap;
        label142:
        localObject1 = a((String)localObject2, false);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
          this.jdField_c_of_type_Boolean = false;
        }
      }
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.b(BaseApplicationImpl.getContext().getResources().getDrawable(2130846357));
          this.jdField_c_of_type_Boolean = true;
        }
        return this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("springHb_SpringEntryManager", 1, localThrowable2, new Object[0]);
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("springHb_SpringEntryManager", 1, localThrowable1, new Object[0]);
    }
  }
  
  @NotNull
  private DesktopDataManager.HongBaoResBuilder b()
  {
    DesktopDataManager.HongBaoResBuilder localHongBaoResBuilder = new DesktopDataManager.HongBaoResBuilder();
    localHongBaoResBuilder.setTextColor(Color.parseColor("#FFFFFF")).setSearchTitleColor(Color.parseColor("#FFFFFF")).setCapsuleLeftNormalResId(2130846553).setCapsuleLeftPressResId(2130846543).setCapsuleRightNormalResId(2130846552).setCapsuleRightPressResId(2130846542).setMoveUpGuideIconResId(2130846555).setModuleMoreIconResId(2130846554).setSearchBackgroundResId(2130846550).setSearchIconResId(2130846551).setMoveUpGuideBgIconResId(2131166397).setFullScreenRefreshBgColor(Color.parseColor("#CE5068")).setRefreshProgressResId(2130839142).setRefreshTextColor(Color.parseColor("#FFFFFF")).setBackgroundUrl(b()).setBackgroundResId(2130846357).setBackgroundLoadingResId(2130849561).setBackgroundFailedResId(2130846357).setRefreshArrowColor(1);
    return localHongBaoResBuilder;
  }
  
  private String b()
  {
    String str2 = c();
    String str1 = str2;
    if (ahgj.jdField_a_of_type_Int == 3)
    {
      str1 = str2;
      if (!bbkk.a(d())) {
        str1 = d();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getMiniSkinUrl -->" + str1 + " SpringHbHelper.mEntryMode:" + ahgj.jdField_a_of_type_Int);
    }
    return str1;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "updatePartyState....oldState:" + ahgh.a(this.jdField_a_of_type_Int) + ",currentState:" + ahgh.a(paramInt));
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(long paramLong)
  {
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "clearOutOfDataTask before:" + this.jdField_a_of_type_JavaUtilList);
        }
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (((ahgi)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long <= paramLong) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringEntryManager", 2, "clearOutOfDataTask end:" + this.jdField_a_of_type_JavaUtilList);
          }
          return;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  private void b(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo paramSpringFestivalHbEntryInfo)
  {
    String str = paramSpringFestivalHbEntryInfo.activityPrefix;
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "activityPref : " + str);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bbkk.a(str)) {
      localStringBuilder.append(str.trim());
    }
    paramSpringFestivalHbEntryInfo = paramSpringFestivalHbEntryInfo.branchActivityPrefix;
    if (!bbkk.a(paramSpringFestivalHbEntryInfo))
    {
      if (!paramSpringFestivalHbEntryInfo.trim().startsWith("|")) {
        localStringBuilder.append("|");
      }
      localStringBuilder.append(paramSpringFestivalHbEntryInfo.trim());
    }
    paramSpringFestivalHbEntryInfo = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "color note prefs: " + paramSpringFestivalHbEntryInfo);
    }
    if (!bbkk.a(paramSpringFestivalHbEntryInfo)) {
      BaseApplicationImpl.getApplication().getSharedPreferences("activity_pref_entry_sp", 4).edit().putString("activity_pref", paramSpringFestivalHbEntryInfo.trim()).apply();
    }
  }
  
  private String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.transitionBg;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getTransitionBgUrl -->" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void c(boolean paramBoolean)
  {
    DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(336);
    try
    {
      this.d = paramBoolean;
      if (paramBoolean) {
        localDesktopDataManager.setHongBaoResBuilder(a());
      }
      while (QLog.isColorLevel())
      {
        QLog.i("springHb_SpringEntryManager", 2, "updateMiniAppSpringSkin...show:" + paramBoolean);
        return;
        localDesktopDataManager.setHongBaoResBuilder(null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
      this.d = false;
      localDesktopDataManager.setHongBaoResBuilder(null);
    }
  }
  
  private String d()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.miniSmallBg;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getMiniSmallURL -->" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "doRunTaskQueue," + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    b(new SpringHbEntryManager.3(this));
  }
  
  private void f()
  {
    g();
    h();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList)) && (this.jdField_a_of_type_Ahfq != null))
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.iterator();
        while (localIterator.hasNext()) {
          if (!ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localIterator.next()).activityTime))
          {
            if (QLog.isColorLevel()) {
              QLog.i("springHb_SpringEntryManager", 2, "preHandleEntryConfig remove ilegal activity<<<<");
            }
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  private void h()
  {
    label430:
    label433:
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo == null)) {
          break label430;
        }
        long l = a();
        SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo localFixedEntryInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo;
        if ((localFixedEntryInfo != null) && (!a(localFixedEntryInfo.entryBannerList)))
        {
          Object localObject1 = localFixedEntryInfo.entryBannerList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)((Iterator)localObject1).next();
            if (!ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject3).bannerTime))
            {
              if (QLog.isColorLevel()) {
                QLog.i("springHb_SpringEntryManager", 2, "preHandleEntryConfig remove illegal activity<<<<");
              }
              ((Iterator)localObject1).remove();
              break label433;
            }
            if (QLog.isColorLevel()) {
              QLog.i("springHb_SpringEntryManager", 2, "stagger time more than end time!!!" + l);
            }
            if (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject3).bannerTime.beginTime + l <= ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject3).bannerTime.endTime) {
              break label433;
            }
            l = ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject3).bannerTime.endTime - ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject3).bannerTime.beginTime + l;
            break label433;
          }
          Collections.sort(localFixedEntryInfo.entryBannerList, new ahga(this));
          Object localObject3 = a(b());
          int j = localFixedEntryInfo.entryBannerList.size();
          localObject1 = null;
          int i = 0;
          if (i >= j) {
            break label430;
          }
          SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo localBannerInfo = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localFixedEntryInfo.entryBannerList.get(i);
          if (i == 0)
          {
            if (localObject3 != null)
            {
              localObject1 = new SpringFestivalRedpacketConfBean.TimeInfo();
              ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1).beginTime = ((SpringFestivalRedpacketConfBean.TimeInfo)localObject3).beginTime;
              ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1).endTime = (localBannerInfo.bannerTime.beginTime + l - 1L);
              localBannerInfo.soonTime = ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1);
              localObject1 = localBannerInfo.bannerTime;
              ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1).beginTime += l;
            }
            localObject1 = localBannerInfo.bannerTime;
            i += 1;
            continue;
          }
          if (localObject1 == null) {
            continue;
          }
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1).endTime;
          localTimeInfo.endTime = (localBannerInfo.bannerTime.beginTime + l - 1L);
          localBannerInfo.soonTime = localTimeInfo;
          localObject1 = localBannerInfo.bannerTime;
          ((SpringFestivalRedpacketConfBean.TimeInfo)localObject1).beginTime += l;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label430;
        }
      }
      finally {}
      QLog.i("springHb_SpringEntryManager", 2, "banner cfg content is empty!!");
      return;
    }
  }
  
  private void i()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        SpringFestivalRedpakcetPreviewConfBean localSpringFestivalRedpakcetPreviewConfBean;
        if (this.jdField_a_of_type_Ahfq != null)
        {
          localSpringFestivalRedpakcetPreviewConfBean = this.jdField_a_of_type_Ahfq.a();
          if (localSpringFestivalRedpakcetPreviewConfBean != null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringEntryManager", 2, "isShowPreview previewConfBean is Empty!! return false!");
          }
        }
        return;
        localObject2 = localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_JavaUtilArrayList;
        if (a((List)localObject2))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("springHb_SpringEntryManager", 2, "isShowPreview activityPreviewList is Empty!! return false!");
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
      }
      finally {}
      while (((Iterator)localObject2).hasNext())
      {
        SpringFestivalRedpakcetPreviewConfBean.BreathLight localBreathLight = (SpringFestivalRedpakcetPreviewConfBean.BreathLight)((Iterator)localObject2).next();
        if (localBreathLight != null) {
          if (!a(localBreathLight.breathTimeInfo)) {
            ((Iterator)localObject2).remove();
          } else {
            localBreathLight.resUrl = localObject1.jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
  }
  
  private boolean i()
  {
    return false;
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	ahfx:jdField_a_of_type_Ahfq	Lahfq;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 104	ahfx:jdField_a_of_type_Ahfq	Lahfq;
    //   13: invokevirtual 828	ahfq:a	()Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +21 -> 39
    //   21: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +12 -> 36
    //   27: ldc 253
    //   29: iconst_2
    //   30: ldc_w 830
    //   33: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 838	ahfx:a	(Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean;)V
    //   44: goto -8 -> 36
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ahfx
    //   16	25	1	localSpringFestivalRedpakcetPreviewConfBean	SpringFestivalRedpakcetPreviewConfBean
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	47	finally
    //   21	36	47	finally
    //   39	44	47	finally
  }
  
  private boolean j()
  {
    boolean bool = ahgj.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "isShowingPendant->>" + bool);
    }
    return bool;
  }
  
  private void k()
  {
    Iterator localIterator;
    Object localObject;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        LinkedList localLinkedList = new LinkedList();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList))) {
          break;
        }
        localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        localObject = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localIterator.next();
        if (localObject == null) {
          continue;
        }
        if ((ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).activityTime)) && (ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).activityTime, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).pendantEndTime)))
        {
          localLinkedList.add(new ahgi(2001, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).activityTime.beginTime + a(), ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).id));
          localLinkedList.add(new ahgi(2002, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).pendantEndTime, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).id));
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.i("springHb_SpringEntryManager", 2, "pendant entry's timeinfo is not valid time>>>" + ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).id + "<<<" + ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject).activityTime);
    }
    QLog.e("springHb_SpringEntryManager", 2, "build And Sort pendantEntryInfo.activityList fail because config is empty");
    label239:
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo != null) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.entryBannerList))) {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.entryBannerList.iterator();
    }
    while (localIterator.hasNext())
    {
      localObject = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localIterator.next();
      if ((localObject != null) && (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).soonTime != null) && (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).bannerTime != null)) {
        if ((ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).bannerTime)) && (ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).soonTime)) && (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).soonTime.endTime < ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).bannerTime.beginTime))
        {
          localList.add(new ahgi(3001, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).soonTime.beginTime, ""));
          localList.add(new ahgi(3001, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).bannerTime.beginTime, ""));
          localList.add(new ahgi(3002, ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject).bannerTime.endTime, ""));
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("springHb_SpringEntryManager", 2, "timeinfo is not valid time");
          continue;
          QLog.e("springHb_SpringEntryManager", 2, "build And Sort fixedEntryInfo.entryBannerList fail because config is empty");
        }
      }
    }
    if (!a(localList))
    {
      Collections.sort(localList, new ahgb(this));
      this.jdField_a_of_type_JavaUtilList.addAll(localList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "buildAndSortPartyTaskQueue, full task list is: " + this.jdField_a_of_type_JavaUtilList.toString());
    }
  }
  
  private boolean k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("loginwelcome_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject).getInt("first_login", 0);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "requestIsFirstLogin state=" + i);
    }
    if (i != 1)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject).apply();
      return true;
    }
    return false;
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 253
    //   4: iconst_2
    //   5: ldc_w 895
    //   8: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 227	ahfx:b	()J
    //   15: lstore_1
    //   16: aload_0
    //   17: lload_1
    //   18: invokespecial 897	ahfx:a	(J)V
    //   21: aload_0
    //   22: lload_1
    //   23: invokespecial 899	ahfx:b	(J)V
    //   26: aload_0
    //   27: invokespecial 371	ahfx:m	()V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_3
    //   34: ldc 253
    //   36: iconst_1
    //   37: aload_3
    //   38: invokestatic 903	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   41: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: goto -14 -> 30
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ahfx
    //   15	8	1	l	long
    //   33	5	3	localThrowable	Throwable
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	30	33	java/lang/Throwable
    //   2	11	47	finally
    //   11	30	47	finally
    //   34	44	47	finally
  }
  
  private boolean l()
  {
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      long l4;
      boolean bool;
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList != null))
        {
          l1 = ahfl.a(b());
          l2 = ahfl.b(b());
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.size();
          int i = 0;
          if (i < j)
          {
            SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.get(i);
            if (localActivityInfo.activityTime != null)
            {
              l3 = localActivityInfo.activityTime.beginTime;
              l4 = localActivityInfo.activityTime.endTime;
              if (!QLog.isColorLevel()) {
                break label243;
              }
              QLog.i("springHb_SpringEntryManager", 2, "hasActivityToday:beginTime,:" + l3 + "endTime,:" + l4 + ",startTimeOfDay:" + l1 + ",endTimeOfDay:" + l2);
              break label243;
              if (QLog.isColorLevel()) {
                QLog.i("springHb_SpringEntryManager", 2, "hasActivityToday:" + bool);
              }
              return bool;
            }
            i += 1;
            continue;
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label243:
      if ((l1 <= l4) && (l2 > l3)) {
        bool = true;
      }
    }
  }
  
  private void m()
  {
    long l1 = 300000L;
    long l2;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask.");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask. task list is empty. return.");
        }
      }
      for (;;)
      {
        return;
        ahgi localahgi = (ahgi)this.jdField_a_of_type_JavaUtilList.get(0);
        l2 = localahgi.jdField_a_of_type_Long - b();
        if (l2 >= -300000L) {
          break;
        }
        l();
        QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask. delay time < -5 minute, checkAndScheduleTask.");
      }
      if (l2 >= 86400000L) {
        break label316;
      }
    }
    finally {}
    Object localObject2 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1001);
    if (l2 > 300000L) {
      ((Message)localObject2).arg1 = 1;
    }
    for (;;)
    {
      l2 = l1;
      if (i()) {
        l2 = l1 / this.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, l2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask. delay time is: " + l2 + " next task is: " + localObject1.a());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (ahgi)localIterator.next();
        QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask current task is: " + ((ahgi)localObject2).a() + ": time is" + ahfl.a(((ahgi)localObject2).jdField_a_of_type_Long));
      }
      break;
      label316:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("springHb_SpringEntryManager", 2, "scheduleNextTask. delay time beyond 24 hour. do nothing.");
      break;
      l1 = l2;
    }
  }
  
  private void n()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "initLocalCacheInfo->>,isTimeSpeedUp:" + i());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(localThrowable));
    }
  }
  
  private void o()
  {
    for (;;)
    {
      try
      {
        if ((j()) || (!e()))
        {
          a(new SpringHbEntryManager.15(this));
          QLog.i("springHb_SpringEntryManager", 2, "checkBreathLight...isShowingPendant or close by user return");
          return;
        }
        i();
        SpringFestivalRedpakcetPreviewConfBean.BreathLight localBreathLight1 = a(b());
        if (localBreathLight1 == null) {
          a(new SpringHbEntryManager.16(this, localBreathLight1));
        } else {
          a(new SpringHbEntryManager.17(this, localBreathLight2));
        }
      }
      finally {}
    }
  }
  
  private void p()
  {
    QLog.i("springHb_SpringEntryManager", 2, "refreshPartyTask.");
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 3)) {
      return;
    }
    b(new SpringHbEntryManager.18(this));
  }
  
  private void q()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "isShowMiniAppSpringSkin -->mEntryConfigInfo == null,try use old");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo = this.jdField_a_of_type_Ahfq.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = ((int)((bbll.a() - bbll.b(18.0F) * 2) * 0.412D));
    }
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_Ahfq == null) {
      QLog.e("springHb_SpringEntryManager", 2, "getFinalDelayBeginTime failed,mSpringFestivalRedpacketConfigProvider is null");
    }
    long l2;
    do
    {
      return l1;
      ahfq localahfq = this.jdField_a_of_type_Ahfq;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantDelay;
      }
      l2 = localahfq.a(l1);
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.i("springHb_SpringEntryManager", 2, "getFinalDelayBeginTime:" + l2);
    return l2;
  }
  
  public ahgg a()
  {
    ahgg localahgg = new ahgg();
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = a(b());
    if (localActivityInfo != null)
    {
      localahgg.b = localActivityInfo.resUrl;
      localahgg.c = localActivityInfo.logoUrl;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null)) {
      localahgg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.defaultResUrl;
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getDrumResInfo -- >" + localahgg + ",mCurrentActivityInfo:" + localActivityInfo);
    }
    return localahgg;
  }
  
  public Bitmap a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "getTransitionBitmap..." + this.jdField_a_of_type_AndroidGraphicsBitmap + ",mEntryMode:" + ahgj.jdField_a_of_type_Int + ",mLoadBgDefault：" + this.jdField_c_of_type_Boolean);
    }
    if (ahgj.jdField_a_of_type_Int == 3) {}
    while (this.jdField_c_of_type_Boolean) {
      return null;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = null;
          return localObject1;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.get(i);
          boolean bool = ahfl.a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime, paramLong);
          if (!bool) {
            i += 1;
          }
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
  }
  
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo a(long paramLong)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo localBannerInfo;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo != null))
        {
          bool = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.entryBannerList);
          if (!bool) {}
        }
        else
        {
          localBannerInfo = null;
          return localBannerInfo;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.entryBannerList.iterator();
        if (localIterator.hasNext())
        {
          localBannerInfo = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localIterator.next();
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = localBannerInfo.soonTime.beginTime;
          localTimeInfo.endTime = localBannerInfo.bannerTime.endTime;
          bool = ahfl.a(localTimeInfo, paramLong);
          if (!bool) {}
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  public SpringFestivalRedpakcetPreviewConfBean.BreathLight a(long paramLong)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = this.jdField_a_of_type_Ahfq.a().jdField_b_of_type_JavaUtilArrayList;
        if (localArrayList == null) {
          continue;
        }
        i = 0;
        if (i >= localArrayList.size()) {
          continue;
        }
        localBreathLight = (SpringFestivalRedpakcetPreviewConfBean.BreathLight)localArrayList.get(i);
        if (localBreathLight == null) {
          continue;
        }
        boolean bool = ahfl.a(localBreathLight.breathTimeInfo, paramLong);
        if (!bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        SpringFestivalRedpakcetPreviewConfBean.BreathLight localBreathLight;
        QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
        Object localObject1 = null;
        continue;
      }
      finally {}
      return localBreathLight;
      i += 1;
    }
  }
  
  public SpringFestivalRedpakcetPreviewConfBean.PreviewInfo a(long paramLong)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = this.jdField_a_of_type_Ahfq.a().jdField_a_of_type_JavaUtilArrayList;
        if (localArrayList == null) {
          continue;
        }
        i = 0;
        if (i >= localArrayList.size()) {
          continue;
        }
        localPreviewInfo = (SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)localArrayList.get(i);
        if (localPreviewInfo == null) {
          continue;
        }
        boolean bool = ahfl.a(localPreviewInfo.prewTimeInfo, paramLong);
        if (!bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        SpringFestivalRedpakcetPreviewConfBean.PreviewInfo localPreviewInfo;
        QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
        Object localObject1 = null;
        continue;
      }
      finally {}
      return localPreviewInfo;
      i += 1;
    }
  }
  
  public DesktopDataManager.HongBaoResBuilder a()
  {
    if (h())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder = b();
      }
      return this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder;
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    String str1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.activityUrl;
    }
    String str2 = str1;
    if (paramBoolean)
    {
      SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo localBannerInfo = a(b());
      str2 = str1;
      if (localBannerInfo != null)
      {
        str2 = str1;
        if (!bbkk.a(localBannerInfo.previewActivityUrl)) {
          str2 = localBannerInfo.previewActivityUrl;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("springHb_SpringEntryManager", 2, "getSpringJumpUrl-->" + str2);
    }
    return str2;
  }
  
  public void a()
  {
    QLog.i("springHb_SpringEntryManager", 2, "onConversationFragmentResume partyStatus is: " + ahgh.a(this.jdField_a_of_type_Int) + ",mCallback:" + this.jdField_a_of_type_Ahgk);
    if (this.jdField_a_of_type_Ahgk == null) {}
    do
    {
      return;
      if (j()) {
        ahif.a("sq.dz", 0, 0, null);
      }
      ThreadManager.excute(new SpringHbEntryManager.13(this), 16, null, true);
    } while (this.jdField_a_of_type_Int == 0);
    b(new SpringHbEntryManager.14(this));
  }
  
  public void a(int paramInt)
  {
    long l1 = b();
    label290:
    do
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.useStagger == 1))
        {
          Object localObject1 = c(l1);
          if (localObject1 != null)
          {
            Object localObject2 = ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime;
            if (localObject2 != null)
            {
              long l2 = ((SpringFestivalRedpacketConfBean.TimeInfo)localObject2).beginTime;
              long l3 = a();
              if (QLog.isColorLevel()) {
                QLog.i("springHb_SpringEntryManager", 2, "notifyMiniBannerClick...type:" + paramInt + ",mCallbackProxy:" + this.jdField_a_of_type_Ahgk + ",manager:" + this + ",beginTime:" + bbkp.b(l2) + ",delayTime:" + l3 + "currentTime:" + bbkp.b(l1) + ",activityId:" + ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).id + "staggerPeakIntervalBefore:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.staggerPeakIntervalBefore);
              }
              if ((l2 - this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.staggerPeakIntervalBefore < l1) && (l1 < l2 + l3))
              {
                localObject1 = a(b());
                if (localObject1 != null)
                {
                  localObject2 = BaseActivity.sTopActivity;
                  if (localObject2 != null)
                  {
                    try
                    {
                      localObject1 = new ahgw(BaseActivity.sTopActivity).a(((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)localObject1).popUpBgUrl, l1, l2 + l3);
                      QLog.e("springHb_SpringEntryManager", 1, localThrowable2, new Object[0]);
                    }
                    catch (Throwable localThrowable2)
                    {
                      try
                      {
                        ((ahgw)localObject1).show();
                        return;
                      }
                      catch (Throwable localThrowable3)
                      {
                        break label290;
                      }
                      localThrowable2 = localThrowable2;
                      localObject1 = null;
                    }
                    if (localObject1 != null) {
                      ((ahgw)localObject1).dismiss();
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("springHb_SpringEntryManager", 1, localThrowable1, new Object[0]);
        }
        QLog.e("springHb_SpringEntryManager", 1, "notifyMiniBannerClick... failed, type:" + paramInt + ",mCallbackProxy:" + this.jdField_a_of_type_Ahgk + ",manager:" + this);
        continue;
      }
      if (this.jdField_a_of_type_Ahgk == null) {
        break;
      }
      this.jdField_a_of_type_Ahgk.a(paramInt);
    } while (!QLog.isColorLevel());
    QLog.i("springHb_SpringEntryManager", 2, "notifyMiniBannerClick... success, type:" + paramInt + ",mCallbackProxy:" + this.jdField_a_of_type_Ahgk + ",manager:" + this);
  }
  
  /* Error */
  public void a(ahgk paramahgk)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 35	ahfx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: new 1125	ahgd
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 1127	ahgd:<init>	(Lahgk;)V
    //   21: putfield 1129	ahfx:jdField_a_of_type_Ahgd	Lahgd;
    //   24: aload_0
    //   25: ldc_w 1116
    //   28: invokevirtual 1135	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   31: aload_1
    //   32: invokevirtual 1139	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: invokevirtual 1143	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   38: aload_0
    //   39: getfield 1129	ahfx:jdField_a_of_type_Ahgd	Lahgd;
    //   42: invokestatic 1149	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   45: checkcast 1116	ahgk
    //   48: putfield 165	ahfx:jdField_a_of_type_Ahgk	Lahgk;
    //   51: aload_2
    //   52: monitorexit
    //   53: aload_0
    //   54: invokespecial 1151	ahfx:p	()V
    //   57: ldc 253
    //   59: iconst_2
    //   60: new 126	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 1153
    //   70: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: ldc_w 1076
    //   80: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 165	ahfx:jdField_a_of_type_Ahgk	Lahgk;
    //   87: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1078
    //   93: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: return
    //   107: astore_3
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_3
    //   111: athrow
    //   112: astore_2
    //   113: ldc 253
    //   115: iconst_1
    //   116: aload_2
    //   117: invokestatic 903	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   120: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: goto -66 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ahfx
    //   0	126	1	paramahgk	ahgk
    //   112	5	2	localThrowable	Throwable
    //   107	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	53	107	finally
    //   108	110	107	finally
    //   5	12	112	java/lang/Throwable
    //   53	57	112	java/lang/Throwable
    //   110	112	112	java/lang/Throwable
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Ahgk != null) && (this.jdField_a_of_type_Int == 2))
      {
        Object localObject = a(paramBoolean);
        if (bbkk.a((String)localObject))
        {
          QLog.e("springHb_SpringEntryManager", 1, "need2LoadTransferPage...url is empty");
          return;
        }
        String str2 = (String)localObject + "&f=1";
        String str3 = a();
        Bitmap localBitmap = b();
        SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = a(b());
        String str1 = "";
        localObject = str1;
        if (localActivityInfo != null)
        {
          localObject = str1;
          if (!bbkk.a(localActivityInfo.id)) {
            localObject = localActivityInfo.id;
          }
        }
        this.jdField_a_of_type_Ahgk.a(paramViewGroup, localBitmap, str2, (String)localObject, str3, "");
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("springHb_SpringEntryManager", 2, "need2LoadTransferPage --> ,jumpUrl:" + str2 + "entryId:" + (String)localObject + ",videoLocalPath:" + str3 + "，frameLocalPath:" + "" + ",isMiniBanner:" + paramBoolean + ",bannerBitmap:" + localBitmap);
        return;
      }
    }
    catch (Throwable paramViewGroup)
    {
      QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(paramViewGroup));
      return;
    }
    QLog.i("springHb_SpringEntryManager", 1, "mCallbackProxy is null or not in party，mPartyStatus：" + ahgh.a(this.jdField_a_of_type_Int));
  }
  
  public void a(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo paramSpringFestivalHbEntryInfo)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringEntryManager", 2, "onEntryConfigReady config is: " + paramSpringFestivalHbEntryInfo);
        }
        if (paramSpringFestivalHbEntryInfo == null) {
          return;
        }
        if (AppSetting.d)
        {
          QLog.i("springHb_SpringEntryManager", 1, "onEntryConfigReady enableTalkBack, return.");
          continue;
        }
        b(paramSpringFestivalHbEntryInfo);
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo = paramSpringFestivalHbEntryInfo;
      if (ahgj.jdField_a_of_type_Int == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        QLog.i("springHb_SpringEntryManager", 1, "onEntryConfigReady earlier than initUiLater，hold taskQueue");
      }
      else
      {
        e();
      }
    }
  }
  
  public void a(SpringFestivalRedpakcetPreviewConfBean.BreathLight paramBreathLight)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight = paramBreathLight;
    QLog.i("springHb_SpringEntryManager", 2, "setCurrentLight -->mBreathLight:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight);
  }
  
  public void a(MiniAppPullInterface paramMiniAppPullInterface)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder = null;
        if ((paramMiniAppPullInterface instanceof MiniAppDesktop))
        {
          ahgj.jdField_a_of_type_Int = 2;
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          e();
          return;
        }
        if ((paramMiniAppPullInterface instanceof QQMessagePageMiniAppEntryManager)) {
          ahgj.jdField_a_of_type_Int = 3;
        } else {
          ahgj.jdField_a_of_type_Int = 1;
        }
      }
      catch (Throwable paramMiniAppPullInterface)
      {
        QLog.e("springHb_SpringEntryManager", 1, paramMiniAppPullInterface, new Object[0]);
        return;
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, null);
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putBoolean("key_show_pendant_by_user_" + str, paramBoolean).apply();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList))) {
      return false;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.iterator();
    while (localIterator.hasNext())
    {
      SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localIterator.next();
      if ((localActivityInfo != null) && (a(localActivityInfo.activityTime)) && ((ahfl.a(l, localActivityInfo.activityTime.beginTime)) || (ahfl.a(l, localActivityInfo.activityTime.endTime)))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Ahfq == null) {}
    do
    {
      do
      {
        return false;
        localObject1 = this.jdField_a_of_type_Ahfq.a();
        if (localObject1 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("springHb_SpringEntryManager", 2, "isShowPreview previewConfBean is Empty!! return false!");
      return false;
      localObject1 = ((SpringFestivalRedpakcetPreviewConfBean)localObject1).jdField_a_of_type_JavaUtilArrayList;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("springHb_SpringEntryManager", 2, "isShowPreview activityPreviewList is Empty!! return false!");
    return false;
    Object localObject1 = ((ArrayList)localObject1).iterator();
    boolean bool1 = false;
    Object localObject2;
    Object localObject3;
    boolean bool2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)((Iterator)localObject1).next();
      if (ahfl.a(((SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)localObject2).prewTimeInfo, paramLong))
      {
        localObject3 = ((SpringFestivalRedpakcetPreviewConfBean.PreviewInfo)localObject2).matchRule;
        if (bbkk.a((String)localObject3)) {
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      return bool2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject3 = ((String)localObject3).split("\\|");
      int j = localObject3.length;
      int i = 0;
      label168:
      if (i < j) {
        if (((String)localObject2).endsWith(localObject3[i]))
        {
          bool1 = true;
          label189:
          bool2 = bool1;
          if (bool1) {
            continue;
          }
        }
      }
      for (;;)
      {
        break;
        i += 1;
        break label168;
        break label189;
      }
      bool2 = bool1;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) || (bbkk.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.activityUrl)) || (bbkk.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.activityPrefix)))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("springHb_SpringEntryManager", 2, "shouldInterceptUrl...intercept false,mEntryConfigInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo);
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (!bbkk.a(paramString))
      {
        bool1 = bool2;
        if (paramString.startsWith(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.activityPrefix)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.i("springHb_SpringEntryManager", 2, "shouldInterceptUrl...intercept:" + bool1 + ",activityPrefix:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.activityPrefix + ",url:" + paramString);
    return bool1;
  }
  
  public long b()
  {
    if (i()) {}
    for (long l = (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) * this.jdField_b_of_type_Int + this.jdField_b_of_type_Long;; l = NetConnInfoCenter.getServerTimeMillis())
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "getCurrentTime -->" + bbkp.b(l));
      }
      return l;
    }
  }
  
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = null;
          return localObject1;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.get(i);
          if ((localObject1 != null) && (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime != null) && (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime.beginTime + a() <= paramLong))
          {
            long l = ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).pendantEndTime;
            if (paramLong <= l) {}
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.breathTimeInfo == null))
        {
          QLog.e("springHb_SpringEntryManager", 2, "onBreathLightOver failed..." + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", "2");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.type == 0)
        {
          String str1 = "1";
          localHashMap.put("ext2", str1);
          ahif.a("sq.hxd", 0, 0, localHashMap);
          str1 = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.breathTimeInfo.beginTime, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.breathTimeInfo.endTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4).edit().putBoolean(str1, true).apply();
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringEntryManager", 2, "onBreathLightOver:mBreathLight:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight = null;
          if (this.jdField_a_of_type_Ahgk == null) {
            break;
          }
          this.jdField_a_of_type_Ahgk.a(false, null);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
        return;
      }
      String str2 = "2";
    }
  }
  
  public void b(ahgk paramahgk)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Ahgd != null) && (this.jdField_a_of_type_Ahgd.jdField_a_of_type_Ahgk == paramahgk))
      {
        this.jdField_a_of_type_Ahgd.jdField_a_of_type_Ahgk = null;
        this.jdField_a_of_type_Ahgd = null;
        this.jdField_a_of_type_Ahgk = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "removeCallback callback is : " + paramahgk + ",mCallbackProxy:" + this.jdField_a_of_type_Ahgk + ",manager:" + this);
      }
      return;
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 16, null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putBoolean("key_show_light_by_user_" + str, paramBoolean).apply();
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Ahfq == null) || (this.jdField_a_of_type_Ahfq.a() == null) || (a(this.jdField_a_of_type_Ahfq.a().c))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_Ahfq.a().c.iterator();
    while (localIterator.hasNext()) {
      if (ahfl.a((SpringFestivalRedpacketConfBean.TimeInfo)localIterator.next(), b())) {
        return true;
      }
    }
    return false;
  }
  
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo c(long paramLong)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = null;
          return localObject1;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantEntryInfo.activityList.get(i);
          if (((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime.beginTime - this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.fixedEntryInfo.staggerPeakIntervalBefore <= paramLong)
          {
            long l = ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo)localObject1).activityTime.endTime;
            if (paramLong <= l) {}
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    if (!f()) {
      return;
    }
    ahif.a("sq.dzxl", 2, 0, null);
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore_3
    //   5: iconst_1
    //   6: istore_1
    //   7: iconst_1
    //   8: istore 4
    //   10: iconst_1
    //   11: istore 8
    //   13: iconst_1
    //   14: istore 9
    //   16: aload_0
    //   17: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   20: ifnull +26 -> 46
    //   23: aload_0
    //   24: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   27: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   30: ifnull +16 -> 46
    //   33: aload_0
    //   34: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   37: getfield 185	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:entryShowTime	Ljava/util/ArrayList;
    //   40: invokestatic 188	ahfx:a	(Ljava/util/List;)Z
    //   43: ifeq +9 -> 52
    //   46: iconst_1
    //   47: istore 8
    //   49: iload 8
    //   51: ireturn
    //   52: aload_0
    //   53: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   56: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   59: getfield 1287	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo:forbidRefresh	I
    //   62: ifne +5 -> 67
    //   65: iconst_1
    //   66: ireturn
    //   67: aload_0
    //   68: invokevirtual 227	ahfx:b	()J
    //   71: lstore 10
    //   73: aload_0
    //   74: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   77: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   80: getfield 793	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo:activityList	Ljava/util/ArrayList;
    //   83: invokestatic 188	ahfx:a	(Ljava/util/List;)Z
    //   86: ifne +476 -> 562
    //   89: aload_0
    //   90: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   93: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   96: getfield 793	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo:activityList	Ljava/util/ArrayList;
    //   99: astore 15
    //   101: iload_3
    //   102: istore_2
    //   103: aload_0
    //   104: getfield 41	ahfx:jdField_a_of_type_ArrayOfByte	[B
    //   107: astore 14
    //   109: iload_3
    //   110: istore_2
    //   111: aload 14
    //   113: monitorenter
    //   114: iload 5
    //   116: istore_2
    //   117: aload 15
    //   119: invokevirtual 821	java/util/ArrayList:size	()I
    //   122: istore 6
    //   124: iconst_0
    //   125: istore_3
    //   126: iload 4
    //   128: istore_1
    //   129: iload_3
    //   130: iload 6
    //   132: if_icmpge +107 -> 239
    //   135: iload 5
    //   137: istore_2
    //   138: aload 15
    //   140: iload_3
    //   141: invokevirtual 822	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   144: checkcast 232	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$ActivityInfo
    //   147: getfield 796	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$ActivityInfo:activityTime	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo;
    //   150: astore 16
    //   152: iload 5
    //   154: istore_2
    //   155: aload 16
    //   157: invokestatic 797	ahfl:a	(Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo;)Z
    //   160: ifeq +408 -> 568
    //   163: iload 5
    //   165: istore_2
    //   166: lload 10
    //   168: aload 16
    //   170: getfield 144	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo:beginTime	J
    //   173: aload_0
    //   174: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   177: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   180: getfield 1290	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo:forbidRefreshIntervalBefore	I
    //   183: i2l
    //   184: lsub
    //   185: lcmp
    //   186: iflt +382 -> 568
    //   189: iload 5
    //   191: istore_2
    //   192: lload 10
    //   194: aload 16
    //   196: getfield 144	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo:beginTime	J
    //   199: aload_0
    //   200: getfield 179	ahfx:jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo;
    //   203: getfield 219	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo:pendantEntryInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo;
    //   206: getfield 1293	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo:forbidRefreshIntervalAfter	I
    //   209: i2l
    //   210: ladd
    //   211: lcmp
    //   212: ifgt +356 -> 568
    //   215: iload 5
    //   217: istore_2
    //   218: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +336 -> 557
    //   224: iload 5
    //   226: istore_2
    //   227: ldc 253
    //   229: iconst_2
    //   230: ldc_w 1295
    //   233: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: goto +321 -> 557
    //   239: iload_1
    //   240: istore_2
    //   241: aload 14
    //   243: monitorexit
    //   244: goto +318 -> 562
    //   247: astore 15
    //   249: aload 14
    //   251: monitorexit
    //   252: aload 15
    //   254: athrow
    //   255: astore 14
    //   257: ldc 253
    //   259: iconst_1
    //   260: aload 14
    //   262: invokestatic 903	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   265: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iload_2
    //   269: istore_1
    //   270: goto +292 -> 562
    //   273: aload_0
    //   274: getfield 104	ahfx:jdField_a_of_type_Ahfq	Lahfq;
    //   277: ifnull +274 -> 551
    //   280: aload_0
    //   281: getfield 104	ahfx:jdField_a_of_type_Ahfq	Lahfq;
    //   284: invokevirtual 828	ahfq:a	()Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean;
    //   287: astore 14
    //   289: aload 14
    //   291: ifnull +260 -> 551
    //   294: aload 14
    //   296: getfield 832	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   299: invokestatic 188	ahfx:a	(Ljava/util/List;)Z
    //   302: ifne +249 -> 551
    //   305: aload 14
    //   307: getfield 832	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   310: astore 16
    //   312: iload 8
    //   314: istore 7
    //   316: aload_0
    //   317: getfield 41	ahfx:jdField_a_of_type_ArrayOfByte	[B
    //   320: astore 15
    //   322: iload 8
    //   324: istore 7
    //   326: aload 15
    //   328: monitorenter
    //   329: iload 9
    //   331: istore 8
    //   333: aload 16
    //   335: invokevirtual 821	java/util/ArrayList:size	()I
    //   338: istore_2
    //   339: iconst_0
    //   340: istore_1
    //   341: iload_1
    //   342: iload_2
    //   343: if_icmpge +202 -> 545
    //   346: iload 9
    //   348: istore 8
    //   350: aload 16
    //   352: iload_1
    //   353: invokevirtual 822	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   356: checkcast 135	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean$BreathLight
    //   359: getfield 139	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean$BreathLight:breathTimeInfo	Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo;
    //   362: invokestatic 797	ahfl:a	(Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean$TimeInfo;)Z
    //   365: ifeq +136 -> 501
    //   368: iload 9
    //   370: istore 8
    //   372: aload_0
    //   373: aload 16
    //   375: iload_1
    //   376: invokevirtual 822	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   379: checkcast 135	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean$BreathLight
    //   382: invokespecial 1297	ahfx:a	(Lcom/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean$BreathLight;)J
    //   385: lstore 12
    //   387: lload 10
    //   389: lload 12
    //   391: lcmp
    //   392: iflt +109 -> 501
    //   395: iload 9
    //   397: istore 8
    //   399: lload 10
    //   401: aload 14
    //   403: getfield 1298	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpakcetPreviewConfBean:jdField_b_of_type_Int	I
    //   406: i2l
    //   407: lload 12
    //   409: ladd
    //   410: lcmp
    //   411: ifgt +90 -> 501
    //   414: iload 9
    //   416: istore 8
    //   418: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +34 -> 455
    //   424: iload 9
    //   426: istore 8
    //   428: ldc 253
    //   430: iconst_2
    //   431: new 126	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1300
    //   441: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload 12
    //   446: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: iconst_0
    //   456: istore 7
    //   458: aload 15
    //   460: monitorexit
    //   461: iload 7
    //   463: istore 8
    //   465: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq -419 -> 49
    //   471: ldc 253
    //   473: iconst_2
    //   474: new 126	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 1302
    //   484: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload 7
    //   489: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: iload 7
    //   500: ireturn
    //   501: iload_1
    //   502: iconst_1
    //   503: iadd
    //   504: istore_1
    //   505: goto -164 -> 341
    //   508: astore 14
    //   510: iload 8
    //   512: istore 7
    //   514: iload 7
    //   516: istore 8
    //   518: aload 15
    //   520: monitorexit
    //   521: aload 14
    //   523: athrow
    //   524: astore 14
    //   526: ldc 253
    //   528: iconst_1
    //   529: aload 14
    //   531: invokestatic 903	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   534: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: goto -76 -> 461
    //   540: astore 14
    //   542: goto -28 -> 514
    //   545: iconst_1
    //   546: istore 7
    //   548: goto -90 -> 458
    //   551: iconst_1
    //   552: istore 7
    //   554: goto -93 -> 461
    //   557: iconst_0
    //   558: istore_1
    //   559: goto -320 -> 239
    //   562: iload_1
    //   563: ifne -290 -> 273
    //   566: iconst_0
    //   567: ireturn
    //   568: iload_3
    //   569: iconst_1
    //   570: iadd
    //   571: istore_3
    //   572: goto -446 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	ahfx
    //   6	557	1	i	int
    //   102	242	2	j	int
    //   4	568	3	k	int
    //   8	119	4	m	int
    //   1	224	5	n	int
    //   122	11	6	i1	int
    //   314	239	7	bool1	boolean
    //   11	506	8	bool2	boolean
    //   14	411	9	bool3	boolean
    //   71	329	10	l1	long
    //   385	60	12	l2	long
    //   107	143	14	arrayOfByte1	byte[]
    //   255	6	14	localThrowable1	Throwable
    //   287	115	14	localSpringFestivalRedpakcetPreviewConfBean	SpringFestivalRedpakcetPreviewConfBean
    //   508	14	14	localObject1	Object
    //   524	6	14	localThrowable2	Throwable
    //   540	1	14	localObject2	Object
    //   99	40	15	localArrayList	ArrayList
    //   247	6	15	localObject3	Object
    //   320	199	15	arrayOfByte2	byte[]
    //   150	224	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   117	124	247	finally
    //   138	152	247	finally
    //   155	163	247	finally
    //   166	189	247	finally
    //   192	215	247	finally
    //   218	224	247	finally
    //   227	236	247	finally
    //   241	244	247	finally
    //   249	252	247	finally
    //   103	109	255	java/lang/Throwable
    //   111	114	255	java/lang/Throwable
    //   252	255	255	java/lang/Throwable
    //   333	339	508	finally
    //   350	368	508	finally
    //   372	387	508	finally
    //   399	414	508	finally
    //   418	424	508	finally
    //   428	455	508	finally
    //   518	521	508	finally
    //   316	322	524	java/lang/Throwable
    //   326	329	524	java/lang/Throwable
    //   521	524	524	java/lang/Throwable
    //   458	461	540	finally
  }
  
  public void d()
  {
    try
    {
      b();
      if ((!f()) || (!h())) {
        return;
      }
      if (ahgj.jdField_a_of_type_Int == 1) {
        return;
      }
      if (ahgj.jdField_a_of_type_Int == 3)
      {
        ahif.a("sq.xcx.bp", 0, 0, null);
        BaseApplicationImpl.getApplication().getRuntime().notifyObservers(QQMessagePageMiniAppEntryManager.class, 104, true, null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringEntryManager", 1, localThrowable, new Object[0]);
      return;
    }
    ahif.a("sq.xcx.qp", 0, 0, null);
  }
  
  public boolean d()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.getBoolean("key_show_pendant_by_user_" + str, true);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "isShowPendantByUser -->" + bool);
    }
    return bool;
  }
  
  public boolean e()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.getBoolean("key_show_light_by_user_" + str, true);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "isShowPendantByUser -->" + bool);
    }
    return bool;
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringEntryManager", 2, "isInEntryShowTime..." + this.jdField_a_of_type_Boolean);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean g()
  {
    label98:
    label103:
    label108:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo == null) {
          break label103;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo.pendantSwitch == 1)
        {
          bool1 = true;
          break label108;
          if (!bool1) {
            break label98;
          }
          bool2 = l();
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringEntryManager", 2, "isShowByPendantSwitchAndActivity...pendantSwitch：" + bool1 + ",hasActivityToday:" + bool2);
          }
          if ((bool1) && (bool2)) {
            return true;
          }
        }
        else
        {
          bool1 = false;
          break label108;
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
      boolean bool2 = false;
      continue;
      boolean bool1 = false;
    }
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public void onDestroy()
  {
    QLog.i("springHb_SpringEntryManager", 2, "onDestroy.");
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      ahgj.b();
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopItemDesktopDataManager$HongBaoResBuilder = null;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfx
 * JD-Core Version:    0.7.0.1
 */