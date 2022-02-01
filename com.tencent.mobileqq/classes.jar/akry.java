import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.1;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.3;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.4;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.5;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.6;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class akry
  extends aksb
{
  private akps jdField_a_of_type_Akps;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new akrz(this);
  private akps b;
  
  public akry(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.jdField_c_of_type_Int = 1;
  }
  
  public akps a()
  {
    if (this.jdField_b_of_type_Akps != null) {
      return this.jdField_b_of_type_Akps;
    }
    return this.jdField_a_of_type_Akps;
  }
  
  public List<akps> a()
  {
    return null;
  }
  
  public void a()
  {
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    String str = bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = null;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(akps paramakps) {}
  
  public void a(akps paramakps, bgup parambgup)
  {
    super.a(paramakps, parambgup);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = null;
    bguu localbguu = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramBoolean) {
        e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopAvatarId) }));
        }
        if (!paramBoolean) {
          break label435;
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopAvatarId;
        if (i <= 0) {
          break label430;
        }
        localObject1 = new akps();
        ((akps)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((akps)localObject1).jdField_d_of_type_Int = 1;
        ((akps)localObject1).jdField_b_of_type_Int = 1;
        ((akps)localObject1).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.contains(((akps)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label424;
        }
        localObject2 = new akps();
        ((akps)localObject2).jdField_c_of_type_JavaLangString = akps.jdField_a_of_type_JavaLangString;
        ((akps)localObject2).jdField_d_of_type_Int = 1;
        ((akps)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Bgqu.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localbguu;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localbguu = (bguu)localIterator.next();
          if (localbguu != null)
          {
            localObject3 = localObject1;
            if (localbguu.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new akps();
                ((akps)localObject3).jdField_b_of_type_JavaLangString = localbguu.jdField_a_of_type_JavaLangString;
                ((akps)localObject3).jdField_c_of_type_Int = localbguu.jdField_a_of_type_Int;
                ((akps)localObject3).jdField_d_of_type_Int = localbguu.jdField_b_of_type_Int;
                ((akps)localObject3).jdField_b_of_type_Int = 2;
                ((akps)localObject3).jdField_a_of_type_Boolean = true;
                ((akps)localObject3).jdField_a_of_type_Long = localbguu.jdField_a_of_type_Long;
                ((akps)localObject3).jdField_d_of_type_JavaLangString = localbguu.jdField_b_of_type_JavaLangString;
              }
            }
            else {
              localObject1 = localObject3;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList uploadItems=%s", new Object[] { localArrayList }));
      }
      localObject1 = new TroopAvatarController.1(this, (akps)localObject2, (akps)localObject3);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ((Runnable)localObject1).run();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject1);
      return;
      label424:
      localObject2 = localObject1;
      continue;
      label430:
      localObject1 = null;
      break;
      label435:
      localObject2 = null;
    }
  }
  
  public boolean a(int paramInt, akps paramakps)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramakps }));
    }
    if (this.jdField_a_of_type_Akps != null)
    {
      localObject = this.jdField_a_of_type_Akps.jdField_c_of_type_JavaLangString;
      try
      {
        i = Integer.parseInt((String)localObject);
        if ((localObject != null) && (i >= 0) && (i == paramInt)) {
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
    Object localObject = new HashSet();
    if (paramakps.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramakps.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramakps = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (paramakps != null)
      {
        TroopInfo localTroopInfo = paramakps.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramakps, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (b(paramString1)) {}
    while (b(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.jdField_c_of_type_Int;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    paramString1 = new akps();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.jdField_a_of_type_Bgqu.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        bguu localbguu = (bguu)paramString2.next();
        if ((localbguu != null) && (localbguu.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.jdField_b_of_type_Akps = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    b();
    a();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aksg)localIterator.next()).a();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(akps paramakps) {}
  
  public void c(int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    bgup localbgup;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bgup));
        localbgup = (bgup)paramObject;
      } while (localbgup.jdField_d_of_type_Int != this.jdField_c_of_type_Int);
      long l = localbgup.jdField_a_of_type_Long;
      paramObject = this.jdField_b_of_type_Akps;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localbgup.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localbgup.jdField_b_of_type_Int;
          this.jdField_a_of_type_AndroidOsHandler.post(new TroopAvatarController.3(this, paramObject, localbgup));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localbgup.jdField_b_of_type_Int), Integer.valueOf(localbgup.jdField_c_of_type_Int), paramObject }));
          }
          int i = localbgup.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localbgup, paramObject, i);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          aksj.a(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          return;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(localbgup.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localbgup.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = aksj.a(this.jdField_a_of_type_AndroidAppActivity, localbgup.jdField_b_of_type_Int);; paramObservable = localbgup.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localbgup.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          return;
        }
      }
    } while (localbgup.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_Bgqu.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akry
 * JD-Core Version:    0.7.0.1
 */