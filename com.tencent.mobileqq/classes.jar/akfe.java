import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.adapter.MayKnowAdapter.5;
import com.tencent.mobileqq.adapter.MayKnowAdapter.7;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;

public class akfe
  extends BaseAdapter
  implements View.OnClickListener, bcwt, bhtj
{
  private int jdField_a_of_type_Int;
  akfm jdField_a_of_type_Akfm;
  alox jdField_a_of_type_Alox = new akfl(this);
  aloz jdField_a_of_type_Aloz;
  alro jdField_a_of_type_Alro;
  Activity jdField_a_of_type_AndroidAppActivity;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new akff(this);
  protected bcws a;
  private bhtl jdField_a_of_type_Bhtl = new akfj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new akfg(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MayKnowAdapter.7(this);
  private int c;
  private int d;
  
  public akfe(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, akfm paramakfm, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRunnable = new MayKnowAdapter.5(this);
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Akfm = paramakfm;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Alro = ((alro)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Bcws = new bcws(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = aekt.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    g();
    this.d = alro.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_Bhtl);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "MayKnowAdapter ,mFriendObserver = " + this.jdField_a_of_type_Alox);
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      return;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
    }
  }
  
  private View a()
  {
    int i = 0;
    View localView;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof akfk)))
      {
        akfk localakfk = (akfk)localView.getTag();
        if ((localakfk == null) || (localakfk.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (localakfk.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus == 0)) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetChangeStatusView view:" + localView);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private View a(String paramString)
  {
    int i = 0;
    View localView;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof akfk)))
      {
        akfk localakfk = (akfk)localView.getTag();
        if ((localakfk == null) || (localakfk.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (!TextUtils.equals(localakfk.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin, paramString))) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetDeleteView view:" + localView + "   uin:" + paramString);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private void a(View paramView)
  {
    a(paramView, new akfh(this, paramView));
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    akfi localakfi = new akfi(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      localakfi.setAnimationListener(paramAnimationListener);
    }
    localakfi.setDuration(240L);
    paramView.startAnimation(localakfi);
  }
  
  private void f()
  {
    c();
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Alro.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Akfm != null) {
        this.jdField_a_of_type_Akfm.a();
      }
    }
    while (this.jdField_a_of_type_Akfm == null) {
      return;
    }
    this.jdField_a_of_type_Akfm.b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Alro.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Akfm != null) {
        this.jdField_a_of_type_Akfm.a();
      }
    }
    while (this.jdField_a_of_type_Akfm == null) {
      return;
    }
    this.jdField_a_of_type_Akfm.b();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, paramInt, true, (byte)0);
    }
    return bdda.a();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getItem Illegal Adapter with overflowed data,position =  " + paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "startVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Alro != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Alro.a(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_Alro.b(a(paramInt), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Alro != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Alro.b(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(null);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_Aloz = null;
      this.jdField_a_of_type_Alro = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).removeObserver(this.jdField_a_of_type_Alox);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if ((!localArrayList1.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 1, null);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.d) {
      return this.d;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getView position: " + paramInt);
    }
    Object localObject1 = null;
    if (paramView != null) {
      localObject1 = (akfk)paramView.getTag();
    }
    Object localObject2;
    if ((paramView != null) && (localObject1 != null) && (!((akfk)localObject1).jdField_a_of_type_Boolean))
    {
      localObject2 = localObject1;
      if (TextUtils.equals(((akfk)localObject1).jdField_b_of_type_JavaLangString, ThemeUtil.curThemeId)) {}
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558464, paramViewGroup, false);
      localObject2 = new akfk();
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367536));
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371141));
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.getPaint();
      ((akfk)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366959));
      ((akfk)localObject2).c = ((TextView)paramView.findViewById(2131361892));
      ((akfk)localObject2).d = ((TextView)paramView.findViewById(2131362076));
      ((akfk)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364325);
      ((akfk)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((akfk)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.setTag(localObject2);
      if (this.jdField_a_of_type_Int != 25)
      {
        ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166901));
        ((akfk)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166989));
      }
      ((akfk)localObject2).jdField_b_of_type_JavaLangString = ThemeUtil.curThemeId;
    }
    paramViewGroup = a(paramInt);
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_Alro.a(paramViewGroup, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
    localObject1 = new StringBuilder();
    ((akfk)localObject2).jdField_a_of_type_JavaLangString = paramViewGroup.uin;
    ((akfk)localObject2).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramViewGroup;
    ((akfk)localObject2).jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
    ((akfk)localObject2).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
    ((akfk)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((akfk)localObject2).jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Alro != null) {}
    for (boolean bool = this.jdField_a_of_type_Alro.a();; bool = false)
    {
      String str = paramViewGroup.getDisplayName(bool);
      ((akfk)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if ((AppSetting.c) && (!TextUtils.isEmpty(str))) {
        ((StringBuilder)localObject1).append(str);
      }
      if (!TextUtils.isEmpty(paramViewGroup.recommendReason))
      {
        ((akfk)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(paramViewGroup.recommendReason);
        if (AppSetting.c) {
          ((StringBuilder)localObject1).append(",你们有").append(paramViewGroup.recommendReason);
        }
        if (paramViewGroup.friendStatus != 0) {
          break label657;
        }
        ((akfk)localObject2).c.setVisibility(0);
        ((akfk)localObject2).c.setTag(paramViewGroup);
        ((akfk)localObject2).d.setVisibility(8);
        ((akfk)localObject2).c.setOnClickListener(this);
        if (AppSetting.c)
        {
          ((akfk)localObject2).c.setContentDescription(alpo.a(2131689628));
          ((StringBuilder)localObject1).append(",添加他为好友");
        }
        label606:
        if (paramInt != getCount() - 1) {
          break label803;
        }
        paramView.setPadding(0, 0, this.c, 0);
      }
      for (;;)
      {
        if (AppSetting.c) {
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
        return paramView;
        ((akfk)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText("");
        break;
        label657:
        if (paramViewGroup.friendStatus == 1)
        {
          ((akfk)localObject2).c.setVisibility(8);
          ((akfk)localObject2).d.setVisibility(0);
          ((akfk)localObject2).d.setText(2131719227);
          if (!AppSetting.c) {
            break label606;
          }
          ((akfk)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719227));
          ((StringBuilder)localObject1).append(",等待验证");
          break label606;
        }
        ((akfk)localObject2).c.setVisibility(8);
        ((akfk)localObject2).d.setVisibility(0);
        ((akfk)localObject2).d.setText(2131690082);
        if (!AppSetting.c) {
          break label606;
        }
        ((akfk)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690082));
        ((StringBuilder)localObject1).append(",已添加");
        break label606;
        label803:
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    boolean bool;
    Object localObject1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramView = (MayKnowRecommend)paramView.getTag();
          if (paramView != null)
          {
            if ((this.jdField_a_of_type_Aloz != null) && (!this.jdField_a_of_type_Aloz.b(paramView.uin)) && (!this.jdField_a_of_type_Aloz.d(paramView.uin)))
            {
              bool = false;
              if (this.jdField_a_of_type_Alro != null) {
                bool = this.jdField_a_of_type_Alro.a();
              }
              localObject1 = paramView.getDisplayName(bool);
              localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramView.uin, null, 3045, this.jdField_a_of_type_Int, (String)localObject1, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131689628), null);
              ((Intent)localObject1).putExtra("key_param_age_area", bcyw.a(this.jdField_a_of_type_AndroidAppActivity, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
              this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                switch (this.jdField_b_of_type_Int)
                {
                }
              }
            }
            for (;;)
            {
              if (this.jdField_a_of_type_Alro != null) {
                this.jdField_a_of_type_Alro.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 3);
              }
              if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", this.jdField_a_of_type_Int, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 1);
              return;
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
              continue;
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
              continue;
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
              continue;
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
              continue;
              if ((this.jdField_a_of_type_Aloz != null) && (this.jdField_a_of_type_Aloz.b(paramView.uin)))
              {
                paramView.friendStatus = 2;
                notifyDataSetChanged();
              }
              else
              {
                paramView.friendStatus = 1;
                notifyDataSetChanged();
              }
            }
            paramView = (MayKnowRecommend)paramView.getTag();
            if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
            {
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(paramView.uin);
              switch (this.jdField_b_of_type_Int)
              {
              }
              while ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
              {
                ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_dlt", this.jdField_a_of_type_Int, 0, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 1);
                return;
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
                continue;
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
                continue;
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
                continue;
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
              }
            }
          }
        }
        paramView = (akfk)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    int i = 84;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      label828:
      int j = i;
      if (this.jdField_a_of_type_Aloz != null)
      {
        j = i;
        if (this.jdField_a_of_type_Aloz.b(paramView.uin)) {
          j = 1;
        }
      }
      localObject1 = new ProfileActivity.AllInOne(paramView.uin, j);
      bool = false;
      if (this.jdField_a_of_type_Alro != null) {
        bool = this.jdField_a_of_type_Alro.a();
      }
      Object localObject2 = paramView.getRecommendName(bool);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ProfileActivity.AllInOne)localObject1).l = ((String)localObject2);
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 88;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("recommend_reason", paramView.recommendReason);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((Bundle)localObject2).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(paramView));
      }
      ((Bundle)localObject2).putByteArray("recommend_algh_id", paramView.algBuffer);
      ((Bundle)localObject2).putInt("key_display_type", 1);
      ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      if (this.jdField_a_of_type_Alro != null) {
        this.jdField_a_of_type_Alro.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      break;
    }
    while ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", this.jdField_a_of_type_Int, 0, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 1);
      return;
      i = 82;
      break label828;
      i = 81;
      break label828;
      i = 83;
      break label828;
      i = 102;
      break label828;
      i = 107;
      break label828;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
      continue;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof akfk)))
        {
          paramString = (akfk)paramString;
          if ((paramString != null) && (paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfe
 * JD-Core Version:    0.7.0.1
 */