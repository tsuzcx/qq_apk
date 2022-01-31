import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.bless.BlessManager.1;
import com.tencent.mobileqq.activity.bless.BlessManager.4;
import com.tencent.mobileqq.activity.bless.BlessManager.5;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class afaz
  implements Manager
{
  private static int jdField_a_of_type_Int;
  public static final String a;
  private long jdField_a_of_type_Long;
  private afbu jdField_a_of_type_Afbu;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private BlessTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  protected Runnable a;
  private ArrayList<BlessPtvModule> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, bbwg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private afbu jdField_b_of_type_Afbu;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private BlessTask jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask;
  public String b;
  private ArrayList<BlessWording> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "bless" + File.separator;
  }
  
  public afaz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new BlessManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = ajsf.aW + jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + File.separator + "history" + File.separator + "ptvHistory");
    i();
    h();
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private Set<String> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).getStringSet("config_list", null);
  }
  
  private void a(aktg paramaktg)
  {
    RecentUser localRecentUser = paramaktg.a(ajsf.au, 9003);
    long l = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = ajsf.au;
    localRecentUser.setType(9003);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    paramaktg.a(localRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(aktg paramaktg, RecentUser paramRecentUser)
  {
    paramaktg.b(paramRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {}
    String[] arrayOfString;
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfString = new String[11];
      arrayOfString[0] = paramBlessTask.mainBanner;
      arrayOfString[1] = paramBlessTask.mainCenter;
      arrayOfString[2] = paramBlessTask.typeBanner;
      arrayOfString[3] = paramBlessTask.succeededBanner;
      arrayOfString[4] = paramBlessTask.defaultVoice;
      arrayOfString[5] = paramBlessTask.starAvator;
      arrayOfString[6] = paramBlessTask.starVideo;
      arrayOfString[7] = paramBlessTask.recentHeadImgUrl;
      arrayOfString[8] = paramBlessTask.ptvAnimationUrl;
      arrayOfString[9] = paramBlessTask.starAvatorSimple;
      arrayOfString[10] = paramBlessTask.recentHeadImgUrlSimple;
      arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    } while (arrayOfFile == null);
    int k = 0;
    label129:
    if (k < arrayOfFile.length) {
      if ((!arrayOfFile[k].getName().endsWith(".zip")) && (!arrayOfFile[k].isDirectory())) {
        break label173;
      }
    }
    label513:
    label529:
    for (;;)
    {
      k += 1;
      break label129;
      break;
      label173:
      int m = 0;
      int i = 0;
      int j = 0;
      label199:
      Object localObject;
      label246:
      int n;
      for (;;)
      {
        if (m < arrayOfString.length) {
          if (TextUtils.isEmpty(arrayOfString[m]))
          {
            m += 1;
          }
          else
          {
            localObject = a(arrayOfString[m]);
            if (arrayOfString[m].equals(paramBlessTask.starVideo))
            {
              localObject = bdhv.b(arrayOfString[m]);
              j = 1;
              if (!arrayOfFile[k].getName().equals(localObject)) {
                break label513;
              }
              n = 0;
              m = i;
            }
          }
        }
      }
      for (i = n;; i = n)
      {
        if (i == 0) {
          break label529;
        }
        arrayOfFile[k].delete();
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "deleteOldBanner=" + arrayOfFile[k].getName());
        }
        if (j != 0)
        {
          localObject = this.jdField_b_of_type_JavaLangString + paramBlessTask.starVideoCoverFolderName + File.separator;
          localObject = new File((String)localObject + paramBlessTask.starVideoCoverFileName);
          if ((((File)localObject).exists()) && (((File)localObject).isFile()))
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "deleteOldCover=" + ((File)localObject).getName());
            }
          }
        }
        if (m == 0) {
          break;
        }
        localObject = new File(g());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break;
        }
        ((File)localObject).delete();
        break;
        if (arrayOfString[m].equals(paramBlessTask.ptvAnimationUrl))
        {
          i = 1;
          break label246;
          break label199;
        }
        break label246;
        n = 1;
        m = i;
      }
    }
  }
  
  private void a(BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    aukp localaukp = localaukn.a();
    for (;;)
    {
      try
      {
        localaukp.a();
        localaukn.a(BlessTask.class);
        if (paramBlessTask != null) {
          localaukn.b(paramBlessTask);
        }
        localaukn.a(BlessPtvModule.class);
        if (paramArrayList != null)
        {
          paramBlessTask = paramArrayList.iterator();
          if (paramBlessTask.hasNext())
          {
            localaukn.b((BlessPtvModule)paramBlessTask.next());
            continue;
          }
        }
      }
      catch (Exception paramBlessTask)
      {
        paramBlessTask.printStackTrace();
        localaukp.b();
        return;
        localaukn.a(BlessWording.class);
        if (paramArrayList1 != null)
        {
          paramBlessTask = paramArrayList1.iterator();
          if (paramBlessTask.hasNext())
          {
            localaukn.b((BlessWording)paramBlessTask.next());
            continue;
          }
        }
      }
      finally
      {
        localaukp.b();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "save task and modules to db");
      }
      localaukp.b();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  private void a(String paramString, BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "processReceivedConfig newTask=" + paramBlessTask);
    }
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label153;
        }
        localObject2 = (BlessPtvModule)((Iterator)localObject1).next();
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
          if (!((BlessPtvModule)localObject2).id.equals(localBlessPtvModule.id)) {
            break;
          }
          if (((BlessPtvModule)localObject2).data.equals(localBlessPtvModule.data)) {
            localBlessPtvModule.broken = ((BlessPtvModule)localObject2).broken;
          } else {
            localBlessPtvModule.broken = true;
          }
        }
      }
    }
    label153:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo);
      localObject2 = a(paramBlessTask.starVideo);
      if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
        paramBlessTask.videoPlayed = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!TextUtils.isEmpty(paramBlessTask.starAvator)) && (!paramBlessTask.starAvator.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator))) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (paramBlessTask.festival_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.festival_id) && (paramBlessTask.task_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.task_id))
    {
      paramBlessTask.isNew = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew;
      paramBlessTask.isDeleted = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = paramBlessTask;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList1;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
    d(this.jdField_c_of_type_Boolean);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
    this.jdField_a_of_type_Afbu.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    afbu.a((SharedPreferences)localObject1, this.jdField_a_of_type_Afbu, 1);
    a(paramBlessTask, paramArrayList, paramArrayList1);
    ((SharedPreferences)localObject1).edit().remove("bless_send_wording").commit();
    this.jdField_d_of_type_JavaLangString = null;
    b(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (bbev.a(BaseApplicationImpl.getApplication()) == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download 2g give up " + paramString2);
      }
    }
    do
    {
      return;
      localbbwg = (bbwg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
      if (localbbwg == null) {
        break label147;
      }
      if ((localbbwg.a() != 2) && (localbbwg.a() != 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "download duplicated " + paramString2);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "download task status error, cancel it " + paramString2);
    }
    localbbwg.a(true);
    label147:
    bbwg localbbwg = new bbwg(paramString1, new File(paramString2));
    localbbwg.n = true;
    bbwl localbbwl = ((bbwi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localbbwg);
    localbbwl.a(localbbwg, new afba(this, paramString2, paramString1), null);
  }
  
  private void a(ArrayList<BlessPtvModule> paramArrayList)
  {
    if (paramArrayList == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    } while (arrayOfFile == null);
    int j = 0;
    label28:
    if (j < arrayOfFile.length) {
      if ((arrayOfFile[j].getName().endsWith(".zip")) && (!arrayOfFile[j].isDirectory())) {
        break label67;
      }
    }
    label67:
    label76:
    label251:
    for (;;)
    {
      j += 1;
      break label28;
      break;
      String str1 = null;
      Iterator localIterator = paramArrayList.iterator();
      int i;
      if (localIterator.hasNext())
      {
        BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
        str1 = localBlessPtvModule.id;
        String str2 = localBlessPtvModule.id + ".zip";
        if (arrayOfFile[j].getName().equals(str2)) {
          if (localBlessPtvModule.broken)
          {
            localBlessPtvModule.broken = false;
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label251;
        }
        arrayOfFile[j].delete();
        bbdj.a(this.jdField_b_of_type_JavaLangString + str1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "deleteOldModules=" + arrayOfFile[j].getName());
        break;
        i = 0;
        continue;
        break label76;
        i = 1;
      }
    }
  }
  
  private boolean a(BlessTask paramBlessTask, boolean paramBoolean)
  {
    if (paramBlessTask == null) {
      return false;
    }
    Object localObject2;
    Object localObject1;
    label68:
    String str1;
    if (paramBoolean)
    {
      localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.starAvator, paramBlessTask.starVideo }));
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramBlessTask.starAvatorSimple))
      {
        ((ArrayList)localObject2).add(paramBlessTask.starAvatorSimple);
        localObject1 = localObject2;
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      paramBoolean = true;
      if (!((Iterator)localObject2).hasNext()) {
        break label554;
      }
      str1 = (String)((Iterator)localObject2).next();
      localObject1 = a(str1);
      if ((TextUtils.isEmpty(str1)) || (!str1.equals(paramBlessTask.starVideo))) {
        break label559;
      }
      localObject1 = bdhv.b(str1);
      paramBlessTask.ex1 = ((String)localObject1);
    }
    label549:
    label554:
    label559:
    for (int i = 1;; i = 0)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "checkBannersReady error banner: " + str1);
        return false;
        localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.mainBanner, paramBlessTask.mainCenter, paramBlessTask.typeBanner, paramBlessTask.succeededBanner, paramBlessTask.defaultVoice }));
        if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrl)) {
          ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrl);
        }
        if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrlSimple)) {
          ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrlSimple);
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramBlessTask.ptvAnimationUrl)) {
          break label68;
        }
        ((ArrayList)localObject2).add(paramBlessTask.ptvAnimationUrl);
        localObject1 = localObject2;
        break label68;
      }
      String str2 = this.jdField_b_of_type_JavaLangString + (String)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "checkBannersReady: " + str1 + " urlPath=" + str2 + "  fileName=" + (String)localObject1);
      }
      if (!new File(str2).exists())
      {
        a(str1, str2);
        if (!QLog.isColorLevel()) {
          break label549;
        }
        QLog.d("BlessManager", 2, "checkBannersReady no banner: " + str2);
        paramBoolean = false;
      }
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.jdField_b_of_type_JavaLangString + paramBlessTask.starVideoCoverFolderName + File.separator + paramBlessTask.starVideoCoverFileName;
          if ((bfni.d()) && (!new File((String)localObject1).exists()))
          {
            k();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + str2);
            }
            paramBoolean = false;
            continue;
            return paramBoolean;
          }
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Date localDate1 = a(paramString1);
    Date localDate2 = a(paramString2);
    if ((localDate1 == null) || (localDate2 == null)) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "isInTime now=" + l + "  beginDate.getTime():" + localDate1.getTime() + "  endDate.getTime():" + localDate2.getTime());
      }
      if ((l > localDate1.getTime()) && (l < localDate2.getTime())) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "not in time" + paramString1 + " " + paramString2);
    return false;
  }
  
  private void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).edit();
    localEditor.putString("config_content", paramString);
    localEditor.commit();
  }
  
  private void b(Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).edit();
    if (paramSet == null) {
      localEditor.remove("config_list");
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putStringSet("config_list", paramSet);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = true;
    aktg localaktg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localaktg.b(ajsf.au, 9003);
    int i;
    label78:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      i = 1;
      if ((i == 0) || (!c()) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted)) {
        break label190;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initEntrance show=").append(bool).append(" hasConfig=").append(paramBoolean).append(" task=").append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask).append(" isDeleted=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
          break label195;
        }
        localObject = "";
        label144:
        QLog.d("BlessManager", 2, localObject);
      }
      if (!bool) {
        break label237;
      }
      if (localRecentUser != null) {
        break label210;
      }
      a(localaktg);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew = false;
    }
    label190:
    label195:
    label210:
    label237:
    while (localRecentUser == null) {
      for (;;)
      {
        return;
        i = 0;
        break;
        bool = false;
        break label78;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted);
        break label144;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew)
        {
          a(localaktg, localRecentUser);
          a(localaktg);
        }
      }
    }
    a(localaktg, localRecentUser);
  }
  
  public static int g()
  {
    if (jdField_a_of_type_Int <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_a_of_type_Int;
    }
  }
  
  private void h()
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_Afbu = afbu.a((SharedPreferences)localObject1, 1);
    this.jdField_b_of_type_Afbu = afbu.a((SharedPreferences)localObject1, 2);
    Object localObject3 = bbjo.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    if (localObject3 != null)
    {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject3);
      this.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("initUinSendRecordFromSp sendWording=").append(this.jdField_d_of_type_JavaLangString).append(" uinListToSend=");
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          break label184;
        }
        localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
        label112:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" blessUinList=");
        if (this.jdField_a_of_type_Afbu != null) {
          break label198;
        }
        localObject1 = null;
        label133:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" webUinList=");
        if (this.jdField_b_of_type_Afbu != null) {
          break label212;
        }
      }
    }
    label184:
    label198:
    label212:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(this.jdField_b_of_type_Afbu.a()))
    {
      QLog.d("BlessManager", 2, localObject1);
      return;
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      break;
      localObject1 = Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size());
      break label112;
      localObject1 = Integer.valueOf(this.jdField_a_of_type_Afbu.a());
      break label133;
    }
  }
  
  public static String i()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("bless_config", 4).getString("config_content", "");
  }
  
  private void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (ArrayList)((aukn)localObject1).a(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((aukn)localObject1).a(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)((aukn)localObject1).a(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((aukn)localObject1).a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("initTaskAndModuleFromDB task=");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
        break label249;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" blessWordings=").append(this.jdField_b_of_type_JavaUtilArrayList).append(" module=");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label260;
      }
    }
    label260:
    for (localObject1 = this.jdField_a_of_type_JavaUtilArrayList;; localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      QLog.d("BlessManager", 2, localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
        break label274;
      }
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
      d(this.jdField_c_of_type_Boolean);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
      return;
      label249:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.toString();
      break;
    }
    label274:
    d(false);
  }
  
  private boolean i()
  {
    String str1 = d();
    String str2 = c();
    if ((str1 == null) || (str2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "isStarVideoFileReady() videoCoverPath=" + str1 + ", videoPath=" + str2);
      }
      return false;
    }
    return true;
  }
  
  private void j()
  {
    Object localObject;
    label150:
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject = new ArrayList(Arrays.asList(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice }));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
      }
      Iterator localIterator = ((ArrayList)localObject).iterator();
      break label217;
      if (!localIterator.hasNext()) {
        break label469;
      }
      str = (String)localIterator.next();
      localObject = a(str);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo))) {
        break label464;
      }
      localObject = bdhv.b(str);
      i = 1;
      label208:
      if (localObject != null) {
        break label218;
      }
      d(false);
    }
    label459:
    label464:
    label469:
    label472:
    for (;;)
    {
      label217:
      return;
      label218:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label150;
      }
      localObject = this.jdField_b_of_type_JavaLangString + (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label150;
      }
      if (!new File((String)localObject).exists())
      {
        if (!QLog.isColorLevel()) {
          break label459;
        }
        QLog.d("BlessManager", 2, "checkAllDownloaded no banner: " + (String)localObject);
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label472;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "check Modules and banners all ready");
        }
        if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        this.jdField_c_of_type_Boolean = true;
        d(true);
        return;
        if (i == 0) {
          break label150;
        }
        str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
        if ((!bfni.d()) || (new File(str).exists())) {
          break label150;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + (String)localObject);
          i = 0;
        }
        else
        {
          i = 0;
          continue;
          i = 0;
          break label208;
          i = 1;
        }
      }
    }
  }
  
  @TargetApi(10)
  private void k()
  {
    if ((bfni.d()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new BlessManager.4(this), 5, null, false);
    }
  }
  
  public int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      i = -1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread > 1) {
      return i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread;
  }
  
  public aaoh a(int paramInt1, int paramInt2)
  {
    aaoh localaaoh = new aaoh();
    localaaoh.jdField_a_of_type_Int = 0;
    if (paramInt1 == 2) {
      localaaoh.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      localaaoh.jdField_b_of_type_Long = paramInt2;
      return localaaoh;
      if (paramInt1 == 3) {
        localaaoh.jdField_b_of_type_Int = 4;
      } else {
        localaaoh.jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public Drawable a()
  {
    Object localObject2 = BaseApplication.getContext().getResources().getDrawable(2130838545);
    boolean bool = axmt.a();
    Object localObject3;
    Object localObject1;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null))
    {
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_d_of_type_Boolean != bool))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl;
        localObject1 = localObject3;
        if (bool)
        {
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple;
          }
        }
        localObject1 = a((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.jdField_b_of_type_JavaLangString + (String)localObject1;
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          i = actn.a(50.0F, BaseApplication.getContext().getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        this.jdField_d_of_type_Boolean = bool;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (h())
      {
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_d_of_type_Boolean != bool))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator;
          localObject2 = localObject3;
          if (bool)
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple)) {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple;
            }
          }
          localObject2 = a((String)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = this.jdField_b_of_type_JavaLangString + (String)localObject2;
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            i = actn.a(50.0F, BaseApplication.getContext().getResources());
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3);
          }
        }
        localObject2 = localObject1;
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          this.jdField_d_of_type_Boolean = bool;
        }
      }
      return localObject2;
      localObject1 = localObject2;
    }
  }
  
  public BlessTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  }
  
  public MessageForShortVideo a()
  {
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getPtvMessage: " + localMessageForShortVideo);
    }
    return localMessageForShortVideo;
  }
  
  public Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationSwtich);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter);
    } while (str == null);
    return this.jdField_b_of_type_JavaLangString + File.separator + str;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return null;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
    }
    while (str != null)
    {
      return this.jdField_b_of_type_JavaLangString + File.separator + str;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner);
      continue;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner);
    }
  }
  
  public String a(String paramString)
  {
    for (;;)
    {
      try
      {
        String str;
        int i;
        if (paramString.startsWith("http://"))
        {
          str = paramString.substring("http://".length(), paramString.length());
          i = str.lastIndexOf('/');
          if (i == -1) {
            return null;
          }
        }
        else
        {
          if (!paramString.startsWith("https://")) {
            break;
          }
          str = paramString.substring("https://".length(), paramString.length());
          continue;
        }
        int j = str.substring(0, i).lastIndexOf('/');
        if (j != -1)
        {
          i = j;
          j = str.lastIndexOf("?");
          if (j > i) {
            return str.substring(i + 1, j);
          }
          str = str.substring(i + 1);
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "getFileNameFromUrl failed: " + paramString, localThrowable);
        }
        return null;
      }
    }
    return paramString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = e() + "&uuid=" + paramString1 + "&md5=" + paramString2 + "&nick=";
    return paramString1 + bbca.encodeToString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname().getBytes(), 2);
  }
  
  public String a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareQzoneTitle;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareWeixinTitle;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "clearBlessConfigs");
    }
    b(null);
    a(null, null, null);
    d(false);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {}
    int i;
    do
    {
      return;
      i = paramInt1;
      if (paramInt2 == this.jdField_b_of_type_JavaUtilArrayList.size() + 1) {
        i = paramInt1 - 1;
      }
    } while ((i < 0) || (i >= this.jdField_b_of_type_JavaUtilArrayList.size()));
    ((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(i)).setEditingWording(paramString);
  }
  
  public void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 3000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    String str = h();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", str);
    acqz.a(paramContext, localIntent, str);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "setPtvMessage: " + paramMessageForShortVideo);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        str = paramString;
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          str = paramString;
          if (paramString.equals(((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(0)).wording)) {
            str = "";
          }
        }
      }
    } while ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(str)));
    this.jdField_d_of_type_JavaLangString = str;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str;
    if (paramInt == 1)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.jdField_a_of_type_Afbu.a(str);
      }
      afbu.a(localSharedPreferences, this.jdField_a_of_type_Afbu, 1);
    }
    while (paramInt != 2) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      this.jdField_b_of_type_Afbu.a(str);
    }
    afbu.a(localSharedPreferences, this.jdField_b_of_type_Afbu, 2);
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramList);
    bbjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
  }
  
  public void a(Set<String> paramSet)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramSet.iterator();
    Object localObject6;
    Object localObject8;
    Object localObject7;
    while (localIterator.hasNext())
    {
      localObject6 = (String)localIterator.next();
      localObject8 = new BlessTask();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      boolean bool = BlessTask.parse((String)localObject6, (BlessTask)localObject8, localArrayList1, localArrayList2);
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "onNewConfigReceived tmpNewTask=" + localObject8 + " tmpNewBlessWordings=" + localArrayList2.size() + " tmpNewPtvModules=" + localArrayList1.size() + " result=" + bool);
      }
      if (!bool) {
        break label578;
      }
      localObject7 = a(((BlessTask)localObject8).entranceBegin);
      Date localDate = a(((BlessTask)localObject8).entranceEnd);
      if ((localObject7 != null) && (localDate != null) && (localDate.getTime() >= l1) && (((BlessTask)localObject8).entranceEnabled == 1))
      {
        localArrayList3.add(localObject8);
        if ((localObject2 == null) || (localObject5 == null) || (((((Date)localObject7).getTime() <= ((Date)localObject5).getTime()) || (((Date)localObject7).getTime() <= l1)) && ((((Date)localObject7).getTime() >= ((Date)localObject5).getTime()) || (((Date)localObject5).getTime() >= l1))))
        {
          localObject5 = localArrayList2;
          localObject4 = localArrayList1;
          localObject3 = localObject8;
          localObject1 = localObject7;
          localObject2 = localObject6;
        }
      }
    }
    for (;;)
    {
      localObject6 = localObject5;
      localObject7 = localObject4;
      localObject8 = localObject3;
      localObject5 = localObject1;
      localObject4 = localObject2;
      localObject1 = localObject6;
      localObject3 = localObject7;
      localObject2 = localObject8;
      break;
      if ((localObject4 != null) && (localObject2 != null))
      {
        a((String)localObject4, localObject2, (ArrayList)localObject3, localObject1);
        localObject4 = null;
        localObject3 = null;
        localObject1 = null;
        if (localArrayList3.size() <= 1) {
          break label518;
        }
        localObject3 = localObject4;
        if (localObject2 == null) {
          break label513;
        }
        localObject4 = a(localObject2.entranceBegin);
        l1 = 9223372036854775807L;
        localObject5 = localArrayList3.iterator();
        label416:
        localObject3 = localObject1;
        if (!((Iterator)localObject5).hasNext()) {
          break label513;
        }
        localObject3 = (BlessTask)((Iterator)localObject5).next();
        if (localObject3 == localObject2) {
          break label575;
        }
        localObject6 = a(((BlessTask)localObject3).entranceBegin);
        if ((localObject6 == null) || (localObject4 == null)) {
          break label575;
        }
        long l2 = ((Date)localObject6).getTime() - ((Date)localObject4).getTime();
        if ((l2 <= 0L) || (l2 >= l1)) {
          break label575;
        }
        localObject1 = localObject3;
        l1 = l2;
      }
      label513:
      label518:
      label575:
      for (;;)
      {
        break label416;
        a();
        break;
        b(paramSet);
        this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "onNewConfigReceived validCount=" + localArrayList3.size() + "  nextTask:" + this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
        }
        return;
      }
      label578:
      localObject6 = localObject2;
      localObject7 = localObject1;
      localObject1 = localObject5;
      localObject2 = localObject4;
      localObject5 = localObject7;
      localObject4 = localObject3;
      localObject3 = localObject6;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(ajsf.au, 9003) != null;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_Afbu.a();
    return this.jdField_a_of_type_Afbu.a(paramString);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread < 1) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getUnreadNum=1");
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceHint;
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localArrayList.add(this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BlessWording localBlessWording = (BlessWording)localIterator.next();
        if (localBlessWording.hasEditingWording()) {
          localArrayList.add(localBlessWording.getEditingWording());
        } else {
          localArrayList.add(localBlessWording.wording);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    bbjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread == 0) {}
      }
      else {
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("BlessManager", 4, "update task to db read=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread + " videoPlayed=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread = -1;
          aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          localaukp = localaukn.a();
          try
          {
            localaukp.a();
            localaukn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
            localaukp.c();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              localaukp.b();
            }
          }
          finally
          {
            localaukp.b();
          }
          localaukn.a();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed = true;
        }
      }
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {}
    for (int i = 1; (i != 0) && (c()) && (this.jdField_c_of_type_Boolean); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    this.jdField_b_of_type_Afbu.a();
    return this.jdField_b_of_type_Afbu.a(paramString);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.uinTotalLimit;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.jdField_b_of_type_JavaLangString + a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ex1);
      File localFile = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "getStarVideoPath: " + str);
      }
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStarVideoPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((BlessWording)localIterator.next()).setEditingWording(null);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onPushCmd: " + paramBoolean);
    }
    if (paramBoolean)
    {
      d();
      return;
    }
    e();
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isEntranceTime");
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int d()
  {
    this.jdField_a_of_type_Afbu.a();
    return c() - this.jdField_a_of_type_Afbu.a();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
      if (new File(str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStartVideoCoverPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public void d()
  {
    aukn localaukn;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = true;
      localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localaukp = localaukn.a();
    }
    try
    {
      localaukp.a();
      localaukn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localaukp.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localaukp.b();
      }
    }
    finally
    {
      localaukp.b();
    }
    localaukn.a();
    d(false);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isStarTime");
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starEnd);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.sendTotalLimit;
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl))) {
      return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl;
  }
  
  public void e()
  {
    aukn localaukn;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted false");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = false;
      localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localaukp = localaukn.a();
    }
    try
    {
      localaukp.a();
      localaukn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localaukp.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localaukp.b();
      }
    }
    finally
    {
      localaukp.b();
    }
    localaukn.a();
  }
  
  public boolean e()
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.BlessPTVEnable.name()).equals("1");
    boolean bool3 = VideoEnvironment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool4 = VideoEnvironment.c();
    boolean bool5 = lmb.e();
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isPTVEnabled task=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled + " ptvRecord=" + bool3 + " isX86=" + bool4 + " frontCamera=" + true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled == 1) && (bool3) && (!bool4) && (bool5) && (!bool2)) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public int f()
  {
    this.jdField_a_of_type_Afbu.a();
    int j = e();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_a_of_type_Afbu.b();
    }
    return i;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {
      return "";
    }
    String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
    if (str == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString + File.separator + str;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "check entrance.  nextTask:" + this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
    }
    if (!c())
    {
      aktg localaktg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localaktg.b(ajsf.au, 9003);
      if (localRecentUser != null) {
        a(localaktg, localRecentUser);
      }
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (a(this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1) && (!this.e))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled != 1) {
      return true;
    }
    return false;
  }
  
  public String g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {}
    String str;
    do
    {
      return "";
      str = f();
    } while (!str.endsWith(".zip"));
    return str.substring(0, str.length() - 4) + File.separator;
  }
  
  public void g()
  {
    ThreadManager.post(new BlessManager.5(this), 5, null, true);
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int h()
  {
    return 100;
  }
  
  public String h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.webBlessUrl))) {
      return "http://ti.qq.com/mass-blessing/index.html?_wv=16777223";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.webBlessUrl;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while ((!bfni.d()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed) || (!d()) || (!i())) {
      return false;
    }
    return true;
  }
  
  public int i()
  {
    return 30;
  }
  
  public int j()
  {
    this.jdField_b_of_type_Afbu.a();
    return i() - this.jdField_b_of_type_Afbu.a();
  }
  
  public int k()
  {
    this.jdField_b_of_type_Afbu.a();
    int j = h();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_b_of_type_Afbu.b();
    }
    return i;
  }
  
  public int l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCount;
  }
  
  public int m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 2000;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCost;
  }
  
  public void onDestroy()
  {
    Object localObject = (bbwi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    if (localObject != null)
    {
      localObject = ((bbwi)localObject).a(1);
      if (localObject != null) {
        ((bbwl)localObject).a(true, null);
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afaz
 * JD-Core Version:    0.7.0.1
 */