import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ajst
  extends ajsk
  implements ajti, ajtv, ajwd, bduz
{
  private int jdField_a_of_type_Int;
  private ajtk jdField_a_of_type_Ajtk;
  private ajwi jdField_a_of_type_Ajwi;
  private View jdField_a_of_type_AndroidViewView;
  private anyu jdField_a_of_type_Anyu = new ajta(this);
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  protected QQAppInterface a;
  private ContactsMiniAppEntryManager jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new ajsu(this));
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public ajst(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    this.jdField_a_of_type_Ajtk = new ajtk(localaobl.b("sp_mayknow_entry_list_recommend"));
    int i;
    if (localaobl.b())
    {
      i = 2;
      this.jdField_d_of_type_Int = i;
      if (this.jdField_d_of_type_Int != 2) {
        break label189;
      }
    }
    label189:
    for (paramActivity = new ajxg(paramActivity);; paramActivity = new ajwz(paramActivity))
    {
      this.jdField_a_of_type_Ajwi = paramActivity;
      this.jdField_a_of_type_Ajwi.a(new ajsv(this));
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager.ContactsViewController", 2, "ContactsViewController headType is: " + this.jdField_d_of_type_Int);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private int a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Ajtk.b(1);
    if (this.jdField_a_of_type_Ajtk.a())
    {
      int m = bhsi.ah(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      int j = 0;
      anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localanyw != null) {
        j = localanyw.a();
      }
      if ((paramBoolean) && (j == 0)) {
        this.h = true;
      }
      if (((paramBoolean) && (j == 0)) || (j > m))
      {
        i = this.jdField_a_of_type_Ajtk.b(1);
        k = i;
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "getDefaultTabPosition ShowRecommendTab friendCount:" + j + " boundaryCount:" + m);
        }
      }
    }
    for (int k = i;; k = i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "getDefaultTabPosition. defaultPos:" + k);
      }
      return k;
      break;
    }
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "checkTabsNeedChange. causeSwitchAccount:" + paramBoolean1 + " moveToDefault:" + paramBoolean2 + " mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      int i = this.jdField_a_of_type_Ajtk.a(this.jdField_b_of_type_Int);
      if (a())
      {
        i = this.jdField_a_of_type_Ajtk.b(i);
        if ((i == -1) || (paramBoolean2)) {
          i = a(paramBoolean1);
        }
        c(i);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_Ajtk.jdField_a_of_type_JavaUtilArrayList.size());
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  private boolean a()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_Ajtk == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null))
    {
      bool2 = false;
      return bool2;
    }
    aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localaobl != null) {
      bool1 = localaobl.b("sp_mayknow_entry_list_recommend");
    }
    for (boolean bool1 = this.jdField_a_of_type_Ajtk.a(bool1);; bool1 = false)
    {
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_Ajtk.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Ajtk.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Ajtk.jdField_a_of_type_ArrayOfInt);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ContactsViewController", 2, "checkAndUpdateRecommendTabShow. mCurrentTabPos:" + this.jdField_b_of_type_Int + " isShowRecommendTab:" + this.jdField_a_of_type_Ajtk.a() + " changed:" + bool1);
      return bool1;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt + " oldType: " + this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Ajwi.d();
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int == 2) {}
    for (Object localObject = new ajxg(this.jdField_a_of_type_AndroidAppActivity);; localObject = new ajwz(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ajwi = ((ajwi)localObject);
      this.jdField_a_of_type_Ajwi.a(new ajsw(this));
      this.jdField_a_of_type_Ajwi.b();
      this.jdField_a_of_type_Ajwi.a(this.jdField_a_of_type_AndroidViewView);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Ajwi.b(false);
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onAccountChanged(paramQQAppInterface);
    }
    if ((!b()) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout, MainFragment.jdField_d_of_type_Int);
    }
  }
  
  private static boolean b()
  {
    arfc localarfc = arfd.a();
    return (localarfc != null) && (localarfc.e());
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_Ajtk == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "switchToTabPos mCurrentTabPos:" + this.jdField_b_of_type_Int + "  pos:" + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_b_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(this.jdField_b_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_b_of_type_Int, true));
  }
  
  private void d(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onPageChange. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(paramInt, this.jdField_c_of_type_Int);
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (this.jdField_b_of_type_Boolean) {
      bool = false;
    }
    localSimpleSlidingIndicator.setCurrentPosition(paramInt, bool);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendUserAppListRequest(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager = new ContactsMiniAppEntryManager(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setMiniAppScrollListener(this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager);
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.showMicroAppPanel(MainFragment.jdField_d_of_type_Int);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    if (this.jdField_c_of_type_Int != paramInt) {
      this.g = true;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(paramInt, false);
    String str;
    if (paramBoolean)
    {
      str = "";
      switch (this.jdField_a_of_type_Ajtk.a(paramInt))
      {
      }
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return 0;
      str = "0X8007F19";
      continue;
      str = "0X8007F1A";
      continue;
      str = "0X8007F1C";
      continue;
      str = "0X8007F1D";
      continue;
      str = "0X8007F1E";
      continue;
      str = "0X800A1F6";
    }
  }
  
  public void a()
  {
    if (bhnv.g(BaseApplication.getContext()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(4, paramInt, i);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramObject);
      return;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)paramView.findViewById(2131377801));
    k();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)paramView.findViewById(2131364993));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)paramView.findViewById(2131364996));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new ContactsViewPagerAdapter(((SplashActivity)a()).getSupportFragmentManager(), ((SplashActivity)a()).app, (BaseActivity)a(), this.jdField_a_of_type_Ajtk.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_Ajtk.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new ajsx(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Ajtk.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Ajtk.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setInterceptListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131378278));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131378276));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new ajsy(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_Ajwi.a(paramView);
    if (b()) {
      n();
    }
    c(a(false));
    if (this.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new ajsz(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
        }
        paramQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if ((localaobl == null) || (localaobl.b("sp_mayknow_entry_list_recommend") == this.jdField_a_of_type_Ajtk.a())) {
        break label251;
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "fillData. tabsChanged:" + bool + " mIsResumed:" + this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(6);
      if (bool) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 500L);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramQQAppInterface);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
        }
        this.jdField_a_of_type_Ajwi.a(paramQQAppInterface);
        b(paramQQAppInterface);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
        }
        return;
        this.jdField_b_of_type_Boolean = true;
        c(a(true));
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(false, false);
  }
  
  public void ao_()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    }
    this.jdField_a_of_type_Ajwi.b();
    bduy.a(this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.F();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setAccessibilityMsg();
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem(), paramBoolean);
      }
    }
    else
    {
      this.jdField_a_of_type_Ajwi.b(paramBoolean);
      i = this.jdField_b_of_type_Int;
      if (!this.jdField_d_of_type_Boolean) {
        break label279;
      }
      a(this.e, this.f);
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.setDrawerFrameEvent(MainFragment.jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8, 500L);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onResume. oldPos:" + i + " mCurrentTabPos:" + this.jdField_b_of_type_Int + " isBackground_Stop:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop + " isBackground_Pause:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
      }
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      label279:
      int j = a(false);
      if ((j != this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
      {
        this.jdField_b_of_type_Boolean = true;
        c(j);
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onPause. mCurrentTabPos:" + this.jdField_b_of_type_Int + " isBackground_Stop:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop + " isBackground_Pause:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
    }
    this.jdField_a_of_type_Ajwi.c();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b();
    }
    this.jdField_a_of_type_Ajwi.d();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    }
    bduy.b(this);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_Ajwi.e();
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(2131365005, tyi.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ContactsViewController", 2, "updateContactsTabPubAccount error! " + QLog.getStackTraceString(localThrowable));
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.findViewById(2131371731);
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY() > localView.getTop())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, localView.getTop());
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(i);
      if ((i == this.jdField_a_of_type_Ajtk.b(1)) || (i == this.jdField_a_of_type_Ajtk.b(2)) || (i == this.jdField_a_of_type_Ajtk.b(0))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
      }
    }
    this.h = false;
  }
  
  public void i()
  {
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(bool);
    }
    this.jdField_a_of_type_Ajwi.a(bool);
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onPostThemeChanged();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Ajtk.b(3), false);
    }
  }
  
  protected void k()
  {
    int m = 2131166997;
    boolean bool1;
    int k;
    boolean bool2;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      k = 25;
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (!bdgb.a()) {
        break label96;
      }
      if (!bool2) {
        break label89;
      }
      i = 2131166452;
      k = 2131167074;
      int n = 255;
      j = i;
      i = k;
      k = n;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.d(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(m, i, j);
      return;
      label89:
      i = 2131166451;
      break;
      label96:
      if (bool2)
      {
        m = 2131165580;
        i = 2131165579;
        j = 2131165578;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131167074;
        j = 2131166997;
      }
      else
      {
        m = 2131165581;
        i = 2131167074;
        j = 2131165581;
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null) && (ContactsBaseFragment.a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getHeight() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getWidth() > 0))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getLocationOnScreen(arrayOfInt);
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getResources().getDisplayMetrics();
      int i = (int)(54.0F * localDisplayMetrics.density);
      ContactsBaseFragment.a = new Rect(arrayOfInt[0], arrayOfInt[1], localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels - i);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", new Object[] { ContactsBaseFragment.a.toString(), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels), Float.valueOf(localDisplayMetrics.density) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajst
 * JD-Core Version:    0.7.0.1
 */