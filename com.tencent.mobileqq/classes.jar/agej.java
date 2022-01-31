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

public class agej
  extends agem
{
  private afzi jdField_a_of_type_Afzi;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new agek(this);
  private afzi b;
  
  public agej(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.jdField_c_of_type_Int = 1;
  }
  
  public afzi a()
  {
    if (this.jdField_b_of_type_Afzi != null) {
      return this.jdField_b_of_type_Afzi;
    }
    return this.jdField_a_of_type_Afzi;
  }
  
  public List<afzi> a()
  {
    return null;
  }
  
  public void a()
  {
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    String str = azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = null;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(afzi paramafzi) {}
  
  public void a(afzi paramafzi, azli paramazli)
  {
    super.a(paramafzi, paramazli);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = null;
    azln localazln = null;
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
        localObject1 = new afzi();
        ((afzi)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((afzi)localObject1).jdField_d_of_type_Int = 1;
        ((afzi)localObject1).jdField_b_of_type_Int = 1;
        ((afzi)localObject1).jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.contains(((afzi)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label424;
        }
        localObject2 = new afzi();
        ((afzi)localObject2).jdField_c_of_type_JavaLangString = afzi.jdField_a_of_type_JavaLangString;
        ((afzi)localObject2).jdField_d_of_type_Int = 1;
        ((afzi)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Azhn.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localazln;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localazln = (azln)localIterator.next();
          if (localazln != null)
          {
            localObject3 = localObject1;
            if (localazln.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new afzi();
                ((afzi)localObject3).jdField_b_of_type_JavaLangString = localazln.jdField_a_of_type_JavaLangString;
                ((afzi)localObject3).jdField_c_of_type_Int = localazln.jdField_a_of_type_Int;
                ((afzi)localObject3).jdField_d_of_type_Int = localazln.jdField_b_of_type_Int;
                ((afzi)localObject3).jdField_b_of_type_Int = 2;
                ((afzi)localObject3).jdField_a_of_type_Boolean = true;
                ((afzi)localObject3).jdField_a_of_type_Long = localazln.jdField_a_of_type_Long;
                ((afzi)localObject3).jdField_d_of_type_JavaLangString = localazln.jdField_c_of_type_JavaLangString;
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
      localObject1 = new TroopAvatarController.1(this, (afzi)localObject2, (afzi)localObject3);
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
  
  public boolean a(int paramInt, afzi paramafzi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramafzi }));
    }
    if (this.jdField_a_of_type_Afzi != null)
    {
      localObject = this.jdField_a_of_type_Afzi.jdField_c_of_type_JavaLangString;
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
    if (paramafzi.jdField_b_of_type_Boolean) {
      ((Set)localObject).add(paramafzi.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramafzi = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (paramafzi != null)
      {
        TroopInfo localTroopInfo = paramafzi.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramafzi, localTroopInfo), 8, null, false);
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
    paramString1 = new afzi();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.jdField_a_of_type_Azhn.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        azln localazln = (azln)paramString2.next();
        if ((localazln != null) && (localazln.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.jdField_b_of_type_Afzi = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    b();
    a();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ager)localIterator.next()).a();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(afzi paramafzi) {}
  
  public void c(int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    azli localazli;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof azli));
        localazli = (azli)paramObject;
      } while (localazli.jdField_d_of_type_Int != this.jdField_c_of_type_Int);
      long l = localazli.jdField_a_of_type_Long;
      paramObject = this.jdField_b_of_type_Afzi;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localazli.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localazli.jdField_b_of_type_Int;
          this.jdField_a_of_type_AndroidOsHandler.post(new TroopAvatarController.3(this, paramObject, localazli));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localazli.jdField_b_of_type_Int), Integer.valueOf(localazli.jdField_c_of_type_Int), paramObject }));
          }
          int i = localazli.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localazli, paramObject, i);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          ageu.a(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          return;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(localazli.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localazli.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = ageu.a(this.jdField_a_of_type_AndroidAppActivity, localazli.jdField_b_of_type_Int);; paramObservable = localazli.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localazli.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          return;
        }
      }
    } while (localazli.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_Azhn.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agej
 * JD-Core Version:    0.7.0.1
 */