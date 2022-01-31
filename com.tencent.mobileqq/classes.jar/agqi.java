import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.1;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.2;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.3;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.4;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.6;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class agqi
  implements Observer
{
  public static Uri a;
  protected static int d;
  int jdField_a_of_type_Int = 0;
  akil jdField_a_of_type_Akil = new agqm(this);
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  public baje a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TroopInfo a;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  String jdField_a_of_type_JavaLangString;
  WeakReference<agqp> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<TroopClipPic> a;
  public List<agle> a;
  protected int[] a;
  protected String[] a;
  int jdField_b_of_type_Int = -1;
  WeakReference<agqo> jdField_b_of_type_JavaLangRefWeakReference;
  List<agqn> jdField_b_of_type_JavaUtilList = new ArrayList();
  AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new agql(this);
  int c;
  
  static
  {
    jdField_d_of_type_Int = 7;
  }
  
  public agqi(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
    paramContext = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_Baje = new baje(this.jdField_a_of_type_JavaLangString, bamz.class, paramContext);
    this.jdField_a_of_type_Baje.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil, true);
  }
  
  private agle a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      agle localagle = (agle)localIterator.next();
      if (localagle.jdField_a_of_type_Long == paramLong) {
        return localagle;
      }
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865);
    bcql.a(BaseApplicationImpl.getContext(), paramInt, paramString, 1).b(i);
  }
  
  private void g()
  {
    jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 257);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    if (this.jdField_b_of_type_Int < 0) {
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (this.jdField_b_of_type_Int != i) {
        break label86;
      }
    }
    label86:
    for (((agle)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Boolean = true;; ((agle)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Boolean = false)
    {
      i += 1;
      break label41;
      break;
    }
  }
  
  public agle a()
  {
    return null;
  }
  
  @NonNull
  public List<agle> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    String str = banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_b_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agqn)localIterator.next()).a(paramInt);
    }
  }
  
  protected void a(agle paramagle)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agqn)localIterator.next()).a(paramagle);
    }
  }
  
  public void a(agle paramagle, bana parambana)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agqn)localIterator.next()).a(paramagle, parambana);
    }
  }
  
  public void a(agqn paramagqn)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramagqn)) {
      this.jdField_b_of_type_JavaUtilList.add(paramagqn);
    }
  }
  
  public void a(agqo paramagqo)
  {
    if (paramagqo != null) {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramagqo);
    }
  }
  
  public void a(agqp paramagqp)
  {
    if (paramagqp != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagqp);
    }
  }
  
  public void a(TroopClipPic paramTroopClipPic, String paramString1, String paramString2, String paramString3)
  {
    if ((paramTroopClipPic == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramTroopClipPic);
    this.jdField_a_of_type_Baje.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)paramArrayList.next();
        agle localagle = a(localTroopClipPic.ts);
        if ((localagle != null) && (!localagle.jdField_b_of_type_Boolean))
        {
          localagle.jdField_b_of_type_Boolean = true;
          localArrayList.add(localTroopClipPic);
        }
      }
    } while (localArrayList.size() == 0);
    this.jdField_a_of_type_Baje.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramBoolean) {
        e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        localObject1 = new ArrayList();
        agqq.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
        Object localObject2 = this.jdField_a_of_type_Baje.a();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            banf localbanf = (banf)((Iterator)localObject2).next();
            if ((localbanf != null) && (localbanf.jdField_b_of_type_Int != 1)) {
              if (((List)localObject1).size() == 7)
              {
                ((Iterator)localObject2).remove();
              }
              else
              {
                agle localagle = new agle();
                localagle.jdField_b_of_type_JavaLangString = localbanf.jdField_a_of_type_JavaLangString;
                localagle.jdField_c_of_type_Int = localbanf.jdField_a_of_type_Int;
                localagle.jdField_d_of_type_Int = localbanf.jdField_b_of_type_Int;
                localagle.jdField_b_of_type_Int = 2;
                localagle.jdField_a_of_type_Boolean = true;
                localagle.jdField_a_of_type_Long = localbanf.jdField_a_of_type_Long;
                localagle.jdField_d_of_type_JavaLangString = localbanf.jdField_b_of_type_JavaLangString;
                ((List)localObject1).add(localagle);
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bserver=%b size=%d info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((List)localObject1).size()), localObject1.toString() }));
        }
        localObject1 = new TroopPhotoController.7(this, (List)localObject1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label298;
        }
        ((Runnable)localObject1).run();
      }
    }
    return;
    label298:
    this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject1);
  }
  
  public boolean a(int paramInt, agle paramagle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramagle }));
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    agle localagle;
    String str;
    while (((Iterator)localObject).hasNext())
    {
      localagle = (agle)((Iterator)localObject).next();
      if (localagle != null) {
        str = localagle.jdField_c_of_type_JavaLangString;
      }
    }
    label439:
    for (;;)
    {
      try
      {
        j = Integer.parseInt(str);
        if ((str == null) || (j < 0)) {
          break label439;
        }
        if (localagle.jdField_b_of_type_Int == 1)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = str;
          localTroopClipPic.clipInfo = localagle.jdField_d_of_type_JavaLangString;
          localTroopClipPic.type = localagle.jdField_d_of_type_Int;
          localArrayList.add(localTroopClipPic);
          if (localagle.jdField_c_of_type_Boolean) {
            localHashSet.add(str);
          }
        }
        if (!str.equals(String.valueOf(paramInt))) {
          break label439;
        }
        i = 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j = -1;
        continue;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramagle);
        b(paramagle);
        return false;
      }
      paramagle.jdField_c_of_type_JavaLangString = String.valueOf(paramInt);
      paramagle.jdField_b_of_type_Int = 1;
      paramagle.jdField_a_of_type_Boolean = false;
      localObject = new TroopClipPic();
      ((TroopClipPic)localObject).id = paramagle.jdField_c_of_type_JavaLangString;
      ((TroopClipPic)localObject).type = paramagle.jdField_d_of_type_Int;
      ((TroopClipPic)localObject).clipInfo = paramagle.jdField_d_of_type_JavaLangString;
      localArrayList.add(localObject);
      if (paramagle.jdField_c_of_type_Boolean) {
        localHashSet.add(paramagle.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramagle = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramagle != null)
        {
          localObject = paramagle.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
          if ((localObject != null) && (localArrayList.size() > 0))
          {
            ((TroopInfo)localObject).mTroopPicList.clear();
            ((TroopInfo)localObject).mTroopPicList.addAll(localArrayList);
            ((TroopInfo)localObject).mTroopVerifyingPics.clear();
            ((TroopInfo)localObject).mTroopVerifyingPics.addAll(localHashSet);
            ThreadManager.post(new TroopPhotoController.4(this, paramagle, (TroopInfo)localObject), 8, null, false);
          }
        }
      }
      return true;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() == 0;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (b(paramString1)) {}
    TroopClipPic localTroopClipPic;
    do
    {
      do
      {
        return false;
      } while (b(paramString1, paramString2));
      localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = paramString1;
      localTroopClipPic.clipInfo = paramString2;
      localTroopClipPic.type = this.jdField_c_of_type_Int;
      localTroopClipPic.ts = SystemClock.uptimeMillis();
    } while (this.jdField_a_of_type_JavaUtilList.size() >= 7);
    paramString1 = new agle();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = null;
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaUtilArrayList.add(localTroopClipPic);
    a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()) }));
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      paramString1 = localObject;
      if ((paramString1 == null) || (!paramString1.a(this.jdField_c_of_type_Int))) {
        break label332;
      }
    }
    label332:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        a();
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return true;
      paramString1 = (agqp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agqn)localIterator.next()).a();
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      a(this.jdField_b_of_type_Int);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    h();
    a(paramInt);
  }
  
  public void b(agle paramagle)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agqn)localIterator.next()).b(paramagle);
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      h();
      a(this.jdField_b_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    bbgu localbbgu = bbdj.a(localActivity, 230);
    localbbgu.setTitle(null);
    if (paramBoolean) {
      localbbgu.setMessage(localActivity.getResources().getString(2131693447));
    }
    for (;;)
    {
      localbbgu.setPositiveButton(localActivity.getResources().getString(2131693471), new bbdt());
      localbbgu.setPositiveButtonContentDescription(localActivity.getResources().getString(2131693471));
      localbbgu.show();
      return;
      localbbgu.setMessage(localActivity.getResources().getString(2131693446));
    }
  }
  
  protected boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 4))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100))
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131697508, 1).a();
        return true;
      }
    }
    return false;
  }
  
  protected boolean b(String paramString1, String paramString2)
  {
    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof TroopAvatarWallEditActivity))
    {
      agqo localagqo;
      Bundle localBundle;
      if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        localagqo = (agqo)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (localagqo != null)
        {
          localBundle = new Bundle();
          localBundle.putString("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
          localBundle.putString("key_clip_info", paramString2);
          if (this.jdField_c_of_type_Int != 0) {
            break label105;
          }
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        localBundle.putBoolean("IS_COVER", bool);
        localBundle.putBoolean("IS_EDIT", true);
        localagqo.a(localBundle);
        return true;
        localagqo = null;
        break;
      }
    }
    return false;
  }
  
  public void c()
  {
    int i = 3;
    int j = 0;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) || (this.jdField_a_of_type_Int > 0))
    {
      if (this.jdField_a_of_type_Int > 0) {}
      for (boolean bool = true;; bool = false)
      {
        b(bool);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
        return;
      }
    }
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_d_of_type_Int];
    }
    this.jdField_a_of_type_ArrayOfInt[0] = 13;
    this.jdField_a_of_type_ArrayOfInt[1] = 14;
    this.jdField_a_of_type_ArrayOfInt[2] = 16;
    while (i < jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = -1;
      i += 1;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968634);
    }
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidAppActivity, null);
    i = j;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] == 16) {
        localbfpc.d(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_ArrayOfInt[i] >= 0) && (this.jdField_a_of_type_ArrayOfInt[i] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localbfpc.a(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]], 1);
        }
      }
    }
    localbfpc.a(new agqj(this, localbfpc));
    localbfpc.show();
  }
  
  public void c(int paramInt)
  {
    Object localObject = (agle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ArrayList localArrayList;
    if (bahv.b(((agle)localObject).jdField_c_of_type_JavaLangString))
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(((agle)localObject).jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_Baje.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 2, localArrayList);
    }
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    b((agle)localObject);
    if ((((agle)localObject).jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(((agle)localObject).jdField_c_of_type_JavaLangString)) && (bahv.b(((agle)localObject).jdField_c_of_type_JavaLangString)))
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList);
      Iterator localIterator = localArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
          if (((agle)localObject).jdField_c_of_type_JavaLangString.equals(localTroopClipPic.id))
          {
            localArrayList.remove(localTroopClipPic);
            paramInt = 1;
            i = paramInt;
            if (paramInt != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList.clear();
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList.addAll(localArrayList);
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.remove(((agle)localObject).jdField_c_of_type_JavaLangString);
            }
          }
        }
      }
    }
    for (int i = paramInt;; i = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i != 0))
      {
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject != null) {
          ThreadManager.post(new TroopPhotoController.6(this, (TroopManager)localObject), 8, null, false);
        }
      }
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void c(agle paramagle)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()))
    {
      paramagle.jdField_c_of_type_Boolean = true;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
      {
        bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131696384), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131696374), new bbdt(), null).show();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
      }
    }
  }
  
  public void d()
  {
    if (jdField_a_of_type_AndroidNetUri != null)
    {
      Object localObject = jdField_a_of_type_AndroidNetUri;
      localObject = bbef.b(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        agqq.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, agqq.d(this.jdField_c_of_type_Int));
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "onInsertAvatarFailed " + paramInt);
    }
    a(agqq.a(BaseApplicationImpl.getContext(), -1));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      agle localagle = (agle)localIterator.next();
      if ((localagle.jdField_b_of_type_Int == 2) || (localagle.jdField_a_of_type_Boolean))
      {
        localIterator.remove();
        b(localagle);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Baje.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Baje.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bana));
        paramObservable = (bana)paramObject;
      } while (paramObservable.jdField_d_of_type_Int != this.jdField_c_of_type_Int);
      paramObject = a(paramObservable.jdField_a_of_type_Long);
    } while (paramObject == null);
    switch (paramObservable.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramObject.jdField_c_of_type_Int = paramObservable.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopPhotoController.1(this, paramObject, paramObservable));
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(paramObservable.jdField_b_of_type_Int), Integer.valueOf(paramObservable.jdField_c_of_type_Int), paramObject }));
      }
      int i = paramObservable.jdField_b_of_type_Int;
      paramObservable = new TroopPhotoController.2(this, paramObservable, paramObject, i);
      this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
      agqq.a(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramObservable.jdField_b_of_type_Int), "", "");
    if (TextUtils.isEmpty(paramObservable.jdField_a_of_type_JavaLangString)) {}
    for (paramObservable = agqq.a(this.jdField_a_of_type_AndroidAppActivity, paramObservable.jdField_b_of_type_Int);; paramObservable = paramObservable.jdField_a_of_type_JavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
      }
      paramObservable = new TroopPhotoController.3(this, paramObject, paramObservable);
      this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqi
 * JD-Core Version:    0.7.0.1
 */