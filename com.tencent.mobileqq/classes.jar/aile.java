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

public class aile
  extends ailh
{
  private aiiy jdField_a_of_type_Aiiy;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ailf(this);
  private aiiy b;
  
  public aile(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.jdField_c_of_type_Int = 1;
  }
  
  public aiiy a()
  {
    if (this.jdField_b_of_type_Aiiy != null) {
      return this.jdField_b_of_type_Aiiy;
    }
    return this.jdField_a_of_type_Aiiy;
  }
  
  public List<aiiy> a()
  {
    return null;
  }
  
  public void a()
  {
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    String str = bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = null;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(aiiy paramaiiy) {}
  
  public void a(aiiy paramaiiy, bcln parambcln)
  {
    super.a(paramaiiy, parambcln);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = null;
    bcls localbcls = null;
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
        localObject1 = new aiiy();
        ((aiiy)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((aiiy)localObject1).jdField_d_of_type_Int = 1;
        ((aiiy)localObject1).jdField_b_of_type_Int = 1;
        ((aiiy)localObject1).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.contains(((aiiy)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label424;
        }
        localObject2 = new aiiy();
        ((aiiy)localObject2).jdField_c_of_type_JavaLangString = aiiy.jdField_a_of_type_JavaLangString;
        ((aiiy)localObject2).jdField_d_of_type_Int = 1;
        ((aiiy)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Bchs.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localbcls;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localbcls = (bcls)localIterator.next();
          if (localbcls != null)
          {
            localObject3 = localObject1;
            if (localbcls.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new aiiy();
                ((aiiy)localObject3).jdField_b_of_type_JavaLangString = localbcls.jdField_a_of_type_JavaLangString;
                ((aiiy)localObject3).jdField_c_of_type_Int = localbcls.jdField_a_of_type_Int;
                ((aiiy)localObject3).jdField_d_of_type_Int = localbcls.jdField_b_of_type_Int;
                ((aiiy)localObject3).jdField_b_of_type_Int = 2;
                ((aiiy)localObject3).jdField_a_of_type_Boolean = true;
                ((aiiy)localObject3).jdField_a_of_type_Long = localbcls.jdField_a_of_type_Long;
                ((aiiy)localObject3).jdField_d_of_type_JavaLangString = localbcls.jdField_b_of_type_JavaLangString;
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
      localObject1 = new TroopAvatarController.1(this, (aiiy)localObject2, (aiiy)localObject3);
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
  
  public boolean a(int paramInt, aiiy paramaiiy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramaiiy }));
    }
    if (this.jdField_a_of_type_Aiiy != null)
    {
      localObject = this.jdField_a_of_type_Aiiy.jdField_c_of_type_JavaLangString;
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
    if (paramaiiy.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramaiiy.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramaiiy = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (paramaiiy != null)
      {
        TroopInfo localTroopInfo = paramaiiy.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramaiiy, localTroopInfo), 8, null, false);
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
    paramString1 = new aiiy();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.jdField_a_of_type_Bchs.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        bcls localbcls = (bcls)paramString2.next();
        if ((localbcls != null) && (localbcls.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.jdField_b_of_type_Aiiy = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    b();
    a();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ailm)localIterator.next()).a();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(aiiy paramaiiy) {}
  
  public void c(int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    bcln localbcln;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bcln));
        localbcln = (bcln)paramObject;
      } while (localbcln.jdField_d_of_type_Int != this.jdField_c_of_type_Int);
      long l = localbcln.jdField_a_of_type_Long;
      paramObject = this.jdField_b_of_type_Aiiy;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localbcln.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localbcln.jdField_b_of_type_Int;
          this.jdField_a_of_type_AndroidOsHandler.post(new TroopAvatarController.3(this, paramObject, localbcln));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localbcln.jdField_b_of_type_Int), Integer.valueOf(localbcln.jdField_c_of_type_Int), paramObject }));
          }
          int i = localbcln.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localbcln, paramObject, i);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          ailp.a(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          return;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(localbcln.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localbcln.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = ailp.a(this.jdField_a_of_type_AndroidAppActivity, localbcln.jdField_b_of_type_Int);; paramObservable = localbcln.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localbcln.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          return;
        }
      }
    } while (localbcln.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_Bchs.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aile
 * JD-Core Version:    0.7.0.1
 */