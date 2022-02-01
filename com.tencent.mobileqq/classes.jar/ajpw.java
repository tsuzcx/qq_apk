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
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnDataChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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

public class ajpw
  extends TroopPhotoController
{
  private ajnr jdField_a_of_type_Ajnr;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ajpx(this);
  private ajnr b;
  
  public ajpw(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.mType = 1;
  }
  
  public ajnr getAvatar()
  {
    if (this.b != null) {
      return this.b;
    }
    return this.jdField_a_of_type_Ajnr;
  }
  
  public List<ajnr> getCoverList()
  {
    return null;
  }
  
  public void notifyAdd(ajnr paramajnr) {}
  
  public void notifyDataSetChanged()
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onDataSetChanged();
    }
  }
  
  public void notifyDel(ajnr paramajnr) {}
  
  public void notifyItemSelect(int paramInt) {}
  
  public void notifyUpdate(ajnr paramajnr, bfed parambfed)
  {
    super.notifyUpdate(paramajnr, parambfed);
  }
  
  public void onDeleteItem(int paramInt) {}
  
  public void onItemSelect(int paramInt) {}
  
  public boolean onPicPicked(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (filterPicsUpload(paramString1)) {}
    while (checkEnterTroopAvatarWallEdit(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.mType;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    paramString1 = new ajnr();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.mManger.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        bfef localbfef = (bfef)paramString2.next();
        if ((localbfef != null) && (localbfef.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    notifyDataSetChanged();
    startUpload();
    bcef.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.mTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void onUpdateTroopAvatarWallList(boolean paramBoolean)
  {
    Object localObject3 = null;
    bfef localbfef = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    Object localObject2;
    if (this.mApp != null)
    {
      if (paramBoolean) {
        updateTroopInfo();
      }
      if (this.mTroopInfo != null)
      {
        paramBoolean = this.mTroopInfoData.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mTroopInfo.mTroopAvatarId) }));
        }
        if (!paramBoolean) {
          break label436;
        }
        int i = this.mTroopInfo.mTroopAvatarId;
        if (i <= 0) {
          break label431;
        }
        localObject1 = new ajnr();
        ((ajnr)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((ajnr)localObject1).jdField_d_of_type_Int = 1;
        ((ajnr)localObject1).jdField_b_of_type_Int = 1;
        ((ajnr)localObject1).jdField_c_of_type_Boolean = this.mTroopInfo.mTroopVerifyingPics.contains(((ajnr)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label425;
        }
        localObject2 = new ajnr();
        ((ajnr)localObject2).jdField_c_of_type_JavaLangString = ajnr.jdField_a_of_type_JavaLangString;
        ((ajnr)localObject2).jdField_d_of_type_Int = 1;
        ((ajnr)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.mManger.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localbfef;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localbfef = (bfef)localIterator.next();
          if (localbfef != null)
          {
            localObject3 = localObject1;
            if (localbfef.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new ajnr();
                ((ajnr)localObject3).jdField_b_of_type_JavaLangString = localbfef.jdField_a_of_type_JavaLangString;
                ((ajnr)localObject3).jdField_c_of_type_Int = localbfef.jdField_a_of_type_Int;
                ((ajnr)localObject3).jdField_d_of_type_Int = localbfef.jdField_b_of_type_Int;
                ((ajnr)localObject3).jdField_b_of_type_Int = 2;
                ((ajnr)localObject3).jdField_a_of_type_Boolean = true;
                ((ajnr)localObject3).jdField_a_of_type_Long = localbfef.jdField_a_of_type_Long;
                ((ajnr)localObject3).jdField_d_of_type_JavaLangString = localbfef.jdField_b_of_type_JavaLangString;
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
      localObject1 = new TroopAvatarController.1(this, (ajnr)localObject2, (ajnr)localObject3);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ((Runnable)localObject1).run();
        return;
      }
      this.handler.post((Runnable)localObject1);
      return;
      label425:
      localObject2 = localObject1;
      continue;
      label431:
      localObject1 = null;
      break;
      label436:
      localObject2 = null;
    }
  }
  
  public void startUpload()
  {
    AccountManager localAccountManager = (AccountManager)this.mApp.getManager(0);
    String str = TroopUtils.getLocalSkey(this.mApp);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    startUpload(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic, this.mTroopInfo.troopcode, str, this.mApp.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = null;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    bfed localbfed;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bfed));
        localbfed = (bfed)paramObject;
      } while (localbfed.jdField_d_of_type_Int != this.mType);
      long l = localbfed.jdField_a_of_type_Long;
      paramObject = this.b;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localbfed.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localbfed.jdField_b_of_type_Int;
          this.handler.post(new TroopAvatarController.3(this, paramObject, localbfed));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localbfed.jdField_b_of_type_Int), Integer.valueOf(localbfed.jdField_c_of_type_Int), paramObject }));
          }
          int i = localbfed.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localbfed, paramObject, i);
          this.handler.post(paramObservable);
          ajpz.a(i, paramObject.jdField_b_of_type_JavaLangString, this.mTroopInfo.troopuin);
          return;
        }
        bcef.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.mTroopInfo.troopuin, String.valueOf(localbfed.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localbfed.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = ajpz.a(this.mActivity, localbfed.jdField_b_of_type_Int);; paramObservable = localbfed.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localbfed.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.handler.post(paramObservable);
          return;
        }
      }
    } while (localbfed.jdField_a_of_type_Int != 1);
    this.mManger.a(this.mTroopInfo.troopuin);
  }
  
  public boolean update2DB(int paramInt, ajnr paramajnr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramajnr }));
    }
    if (this.jdField_a_of_type_Ajnr != null)
    {
      localObject = this.jdField_a_of_type_Ajnr.jdField_c_of_type_JavaLangString;
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
    if (paramajnr.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramajnr.jdField_c_of_type_JavaLangString);
    }
    if (this.mApp != null)
    {
      paramajnr = (TroopManager)this.mApp.getManager(52);
      if (paramajnr != null)
      {
        TroopInfo localTroopInfo = paramajnr.b(String.valueOf(this.mTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramajnr, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpw
 * JD-Core Version:    0.7.0.1
 */