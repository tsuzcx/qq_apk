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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class aklk
  extends TroopPhotoController
{
  private akjf jdField_a_of_type_Akjf;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new akll(this);
  private akjf b;
  
  public aklk(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.mType = 1;
  }
  
  public akjf getAvatar()
  {
    if (this.b != null) {
      return this.b;
    }
    return this.jdField_a_of_type_Akjf;
  }
  
  public List<akjf> getCoverList()
  {
    return null;
  }
  
  public void notifyAdd(akjf paramakjf) {}
  
  public void notifyDataSetChanged()
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onDataSetChanged();
    }
  }
  
  public void notifyDel(akjf paramakjf) {}
  
  public void notifyItemSelect(int paramInt) {}
  
  public void notifyUpdate(akjf paramakjf, bgmj parambgmj)
  {
    super.notifyUpdate(paramakjf, parambgmj);
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
    paramString1 = new akjf();
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
        bgml localbgml = (bgml)paramString2.next();
        if ((localbgml != null) && (localbgml.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    notifyDataSetChanged();
    startUpload();
    bdla.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.mTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void onUpdateTroopAvatarWallList(boolean paramBoolean)
  {
    Object localObject3 = null;
    bgml localbgml = null;
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
        localObject1 = new akjf();
        ((akjf)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((akjf)localObject1).jdField_d_of_type_Int = 1;
        ((akjf)localObject1).jdField_b_of_type_Int = 1;
        ((akjf)localObject1).jdField_c_of_type_Boolean = this.mTroopInfo.mTroopVerifyingPics.contains(((akjf)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label425;
        }
        localObject2 = new akjf();
        ((akjf)localObject2).jdField_c_of_type_JavaLangString = akjf.jdField_a_of_type_JavaLangString;
        ((akjf)localObject2).jdField_d_of_type_Int = 1;
        ((akjf)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.mManger.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localbgml;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localbgml = (bgml)localIterator.next();
          if (localbgml != null)
          {
            localObject3 = localObject1;
            if (localbgml.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new akjf();
                ((akjf)localObject3).jdField_b_of_type_JavaLangString = localbgml.jdField_a_of_type_JavaLangString;
                ((akjf)localObject3).jdField_c_of_type_Int = localbgml.jdField_a_of_type_Int;
                ((akjf)localObject3).jdField_d_of_type_Int = localbgml.jdField_b_of_type_Int;
                ((akjf)localObject3).jdField_b_of_type_Int = 2;
                ((akjf)localObject3).jdField_a_of_type_Boolean = true;
                ((akjf)localObject3).jdField_a_of_type_Long = localbgml.jdField_a_of_type_Long;
                ((akjf)localObject3).jdField_d_of_type_JavaLangString = localbgml.jdField_b_of_type_JavaLangString;
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
      localObject1 = new TroopAvatarController.1(this, (akjf)localObject2, (akjf)localObject3);
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
    bgmj localbgmj;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bgmj));
        localbgmj = (bgmj)paramObject;
      } while (localbgmj.jdField_d_of_type_Int != this.mType);
      long l = localbgmj.jdField_a_of_type_Long;
      paramObject = this.b;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localbgmj.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localbgmj.jdField_b_of_type_Int;
          this.handler.post(new TroopAvatarController.3(this, paramObject, localbgmj));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localbgmj.jdField_b_of_type_Int), Integer.valueOf(localbgmj.jdField_c_of_type_Int), paramObject }));
          }
          int i = localbgmj.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localbgmj, paramObject, i);
          this.handler.post(paramObservable);
          akln.a(i, paramObject.jdField_b_of_type_JavaLangString, this.mTroopInfo.troopuin);
          return;
        }
        bdla.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.mTroopInfo.troopuin, String.valueOf(localbgmj.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localbgmj.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = akln.a(this.mActivity, localbgmj.jdField_b_of_type_Int);; paramObservable = localbgmj.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localbgmj.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.handler.post(paramObservable);
          return;
        }
      }
    } while (localbgmj.jdField_a_of_type_Int != 1);
    this.mManger.a(this.mTroopInfo.troopuin);
  }
  
  public boolean update2DB(int paramInt, akjf paramakjf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramakjf }));
    }
    if (this.jdField_a_of_type_Akjf != null)
    {
      localObject = this.jdField_a_of_type_Akjf.jdField_c_of_type_JavaLangString;
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
    if (paramakjf.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramakjf.jdField_c_of_type_JavaLangString);
    }
    if (this.mApp != null)
    {
      paramakjf = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramakjf != null)
      {
        TroopInfo localTroopInfo = paramakjf.b(String.valueOf(this.mTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramakjf, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklk
 * JD-Core Version:    0.7.0.1
 */