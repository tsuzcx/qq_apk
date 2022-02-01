import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahvi
  extends ViewModel
{
  int jdField_a_of_type_Int = 0;
  private ahvh jdField_a_of_type_Ahvh;
  private MutableLiveData<Boolean> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private MutableLiveData<ArrayList<ahvd>> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  
  public ahvi()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  private LifecycleOwner a(BaseChatPie paramBaseChatPie)
  {
    try
    {
      paramBaseChatPie = paramBaseChatPie.mActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_fragment");
      if ((paramBaseChatPie instanceof LifeCycleFragment))
      {
        paramBaseChatPie = (LifeCycleFragment)paramBaseChatPie;
        return paramBaseChatPie;
      }
    }
    catch (Exception paramBaseChatPie)
    {
      QLog.d("PlusPanelViewModel", 1, paramBaseChatPie, new Object[0]);
    }
    return null;
  }
  
  private void a(int paramInt, ahvd paramahvd, bbbq parambbbq)
  {
    paramahvd = parambbbq.a(10, paramahvd.c, paramahvd.f);
    if (paramahvd != null) {
      parambbbq.a(paramahvd.uiAppId.get(), 30);
    }
  }
  
  private void a(SessionInfo paramSessionInfo, PlusPanelAppInfo paramPlusPanelAppInfo, QQAppInterface paramQQAppInterface)
  {
    if (!((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.curFriendUin))
    {
      bgig localbgig = (bgig)paramQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR);
      if (paramPlusPanelAppInfo.redPoint)
      {
        bfbz.a(paramQQAppInterface).a(paramPlusPanelAppInfo.getAppID());
        ThreadManager.excute(new PlusPanelViewModel.1(this, localbgig, paramPlusPanelAppInfo), 128, null, false);
      }
      boolean bool = paramPlusPanelAppInfo.canRemove;
      a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramPlusPanelAppInfo.getAppID(), bool);
      if (localbgig != null) {
        localbgig.a(paramPlusPanelAppInfo.getAppID(), false, paramSessionInfo.curFriendUin);
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt > 0)
    {
      bbbq localbbbq = (bbbq)paramBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      paramBaseChatPie = localbbbq.a(10, String.valueOf(paramInt), paramBaseChatPie.sessionInfo.troopUin);
      if (paramBaseChatPie != null) {
        localbbbq.a(paramBaseChatPie.uiAppId.get(), 31);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_Ahvh.a(paramInt);
    if (!TextUtils.isEmpty(str)) {
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, paramString, str, "", "");
    }
    if ((paramBoolean) && (paramInt != 0)) {
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, paramString, String.valueOf(paramInt), "", "");
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.sessionInfo.curType != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.h(paramBaseChatPie.sessionInfo.troopUin))
    {
      localTroopManager.j(paramBaseChatPie.sessionInfo.troopUin);
      return true;
    }
    return false;
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    if (this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData != null) {
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData != null) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    MutableLiveData localMutableLiveData = this.jdField_a_of_type_Ahvh.a();
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, ahvd paramahvd)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo, paramahvd);
  }
  
  public MutableLiveData<ArrayList<ahvd>> a()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  PlusPanelAppInfo a(int paramInt)
  {
    return this.jdField_a_of_type_Ahvh.a(paramInt);
  }
  
  public List<PlusPanelAppInfo> a(BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_Ahvh.a != null)
    {
      this.jdField_a_of_type_Ahvh.a.a(paramBaseChatPie);
      return this.jdField_a_of_type_Ahvh.a.a();
    }
    return new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Ahvh.a().observe(paramLifecycleOwner, new ahvj(this));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_Ahvh == null) {
      this.jdField_a_of_type_Ahvh = new ahvh();
    }
    this.jdField_a_of_type_Ahvh.a(paramBaseChatPie, this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Ahvh.a(paramBaseChatPie.getClass());
  }
  
  public void a(BaseChatPie paramBaseChatPie, int paramInt, List<ahvd> paramList)
  {
    if (this.jdField_c_of_type_Int != 1) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Int = 0;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.sessionInfo.curType == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanelViewModel", 2, new Object[] { "onRedpointExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", zdz.a(5) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ahvd localahvd = (ahvd)paramList.next();
          a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin, localahvd);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, ahvd paramahvd)
  {
    if (a(paramBaseChatPie)) {}
    SessionInfo localSessionInfo;
    PlusPanelAppInfo localPlusPanelAppInfo;
    do
    {
      return;
      localSessionInfo = paramBaseChatPie.sessionInfo;
      localPlusPanelAppInfo = a(paramahvd.jdField_b_of_type_Int);
    } while (localPlusPanelAppInfo == null);
    if (localSessionInfo.curType == 1) {}
    a(paramBaseChatPie, localPlusPanelAppInfo.getRedDotID());
    b(paramBaseChatPie, paramahvd);
    paramBaseChatPie.disableZhitu();
    localPlusPanelAppInfo.handlePanelClick(this, paramBaseChatPie, localSessionInfo);
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if ((localSessionInfo.curType == 1001) || (localSessionInfo.curType == 10002)) {
      if (localSessionInfo.curType == 1001)
      {
        paramahvd = "0";
        bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramahvd, this.jdField_a_of_type_Ahvh.b(localPlusPanelAppInfo.getAppID()), "", "");
      }
    }
    for (;;)
    {
      b(paramBaseChatPie);
      return;
      paramahvd = "1";
      break;
      if (localSessionInfo.curType == 1) {
        a(localSessionInfo, localPlusPanelAppInfo, localQQAppInterface);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ahvd> paramList, int paramInt)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin, paramBaseChatPie.sessionInfo.curType, paramList, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      c(paramBaseChatPie);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 2) {
      bdla.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        bdla.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 7);
    bdla.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1106717414) {
      bhbu.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    bhbu.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Clk");
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ahvd paramahvd)
  {
    bbbq localbbbq = (bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (!TextUtils.isEmpty(paramahvd.c)) {
      a(paramInt, paramahvd, localbbbq);
    }
    int j;
    label103:
    int k;
    label111:
    boolean bool;
    if ((paramahvd.jdField_b_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramahvd.jdField_b_of_type_Int))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramahvd.jdField_b_of_type_Int));
      if ((paramInt != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramString))) {
        break label175;
      }
      i = 1;
      if (paramInt != 3000) {
        break label181;
      }
      j = 1;
      if (paramInt != 1) {
        break label187;
      }
      k = 1;
      bool = a(paramInt);
      if (i == 0) {
        break label193;
      }
      paramInt = 1;
      label125:
      j = paramahvd.jdField_b_of_type_Int;
      if (!paramahvd.jdField_a_of_type_Boolean) {
        break label228;
      }
    }
    label175:
    label181:
    label187:
    label193:
    label228:
    for (int i = 1;; i = 0)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800A46B", "0X800A46B", j, i, String.valueOf(paramInt), "", "", "");
      return;
      i = 0;
      break;
      j = 0;
      break label103;
      k = 0;
      break label111;
      if (j != 0)
      {
        paramInt = 2;
        break label125;
      }
      if (k != 0)
      {
        paramInt = 3;
        break label125;
      }
      if (bool)
      {
        paramInt = 4;
        break label125;
      }
      paramInt = 5;
      break label125;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ahvd paramahvd)
  {
    int k = 0;
    int i;
    int j;
    label44:
    boolean bool;
    if (paramahvd.jdField_b_of_type_Int > 0)
    {
      if ((paramSessionInfo.curType != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.curFriendUin))) {
        break label115;
      }
      i = 1;
      if (paramSessionInfo.curType != 3000) {
        break label121;
      }
      j = 1;
      bool = a(paramSessionInfo.curType);
      if (i == 0) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      int m = paramahvd.jdField_b_of_type_Int;
      j = k;
      if (paramahvd.jdField_a_of_type_Boolean) {
        j = 1;
      }
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800A46C", "0X800A46C", m, j, String.valueOf(i), "", "", "");
      return;
      label115:
      i = 0;
      break;
      label121:
      j = 0;
      break label44;
      label127:
      if (j != 0) {
        i = 2;
      } else if (paramSessionInfo.curType == 1) {
        i = 3;
      } else if (bool) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {}
    for (localObject = ((TroopManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = "" + ((TroopInfo)localObject).dwGroupClassExt;; localObject = "")
      {
        bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        return;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, List<ahvd> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelViewModel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt2), " Stack: ", zdz.a(5) });
    }
    if ((paramList != null) && (paramList.size() == 0) && (this.jdField_c_of_type_Int == -1)) {
      this.jdField_c_of_type_Int = 1;
    }
    paramList = paramList.iterator();
    label266:
    while (paramList.hasNext())
    {
      ahvd localahvd = (ahvd)paramList.next();
      a(paramQQAppInterface, paramInt1, paramString, localahvd);
      switch (localahvd.jdField_b_of_type_Int)
      {
      }
      for (;;)
      {
        if (localahvd.jdField_b_of_type_Int != 209) {
          break label266;
        }
        bdla.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
        break;
        bhbu.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Show");
        continue;
        bhbu.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Show");
        continue;
        a(paramQQAppInterface, paramString);
        bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
      }
    }
    if (paramInt2 == this.jdField_b_of_type_Int) {
      TroopGiftPanel.a(paramInt2, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ahvh.a(paramString1, paramString2);
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = this.jdField_a_of_type_Ahvh.a();
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = this.jdField_a_of_type_Ahvh.a(paramBaseChatPie);
    if ((paramBaseChatPie != null) && (!paramBaseChatPie.isEmpty())) {
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(paramBaseChatPie);
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        ((TroopChatPie)paramBaseChatPie).q();
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label32;
      }
      if (!QLog.isColorLevel()) {}
    }
    return;
    label32:
    this.jdField_a_of_type_Boolean = false;
    String str = paramBaseChatPie.sessionInfo.curFriendUin;
    if ((((TroopManager)paramBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      QQToast.a(paramBaseChatPie.getActivity(), aqwc.a, 0).a();
      return;
    }
    f(paramBaseChatPie);
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie);
    b(paramBaseChatPie);
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
    }
    paramBaseChatPie = a(paramBaseChatPie);
    if (paramBaseChatPie != null) {
      b(paramBaseChatPie);
    }
  }
  
  void f(BaseChatPie paramBaseChatPie)
  {
    if ((a(1106865772) != null) && (!TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")))
    {
      String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", axqj.a(paramBaseChatPie.sessionInfo.curFriendUin));
      Intent localIntent = paramBaseChatPie.getActivity().getIntent();
      localIntent.putExtra("url", str);
      localIntent.putExtra("confess_half_screen_web", true);
      if ((paramBaseChatPie instanceof TroopChatPie)) {
        this.jdField_b_of_type_Boolean = aqwc.a(paramBaseChatPie);
      }
      a(paramBaseChatPie.app, 1106865772, paramBaseChatPie.sessionInfo.curFriendUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvi
 * JD-Core Version:    0.7.0.1
 */