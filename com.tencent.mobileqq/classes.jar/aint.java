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

public class aint
  extends BaseAdapter
  implements View.OnClickListener, baxz, bfsm
{
  private int jdField_a_of_type_Int;
  aiob jdField_a_of_type_Aiob;
  ajxj jdField_a_of_type_Ajxj = new aioa(this);
  ajxl jdField_a_of_type_Ajxl;
  akaa jdField_a_of_type_Akaa;
  Activity jdField_a_of_type_AndroidAppActivity;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ainu(this);
  protected baxy a;
  private bfso jdField_a_of_type_Bfso = new ainy(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new ainv(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MayKnowAdapter.7(this);
  private int c;
  private int d;
  
  public aint(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, aiob paramaiob, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRunnable = new MayKnowAdapter.5(this);
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Aiob = paramaiob;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Akaa = ((akaa)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Baxy = new baxy(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = actj.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    g();
    this.d = akaa.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_Bfso);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "MayKnowAdapter ,mFriendObserver = " + this.jdField_a_of_type_Ajxj);
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      return;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
    }
  }
  
  private View a()
  {
    int i = 0;
    View localView;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof ainz)))
      {
        ainz localainz = (ainz)localView.getTag();
        if ((localainz == null) || (localainz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (localainz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus == 0)) {}
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
      if ((localView != null) && ((localView.getTag() instanceof ainz)))
      {
        ainz localainz = (ainz)localView.getTag();
        if ((localainz == null) || (localainz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (!TextUtils.equals(localainz.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin, paramString))) {}
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
    a(paramView, new ainw(this, paramView));
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    ainx localainx = new ainx(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      localainx.setAnimationListener(paramAnimationListener);
    }
    localainx.setDuration(240L);
    paramView.startAnimation(localainx);
  }
  
  private void f()
  {
    c();
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Akaa.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Aiob != null) {
        this.jdField_a_of_type_Aiob.a();
      }
    }
    while (this.jdField_a_of_type_Aiob == null) {
      return;
    }
    this.jdField_a_of_type_Aiob.b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Akaa.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Aiob != null) {
        this.jdField_a_of_type_Aiob.a();
      }
    }
    while (this.jdField_a_of_type_Aiob == null) {
      return;
    }
    this.jdField_a_of_type_Aiob.b();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Baxy.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.a(paramString, paramInt, true, (byte)0);
    }
    return bbef.a();
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
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Akaa != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Akaa.a(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_Akaa.b(a(paramInt), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Akaa != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Akaa.b(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(null);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_Ajxl = null;
      this.jdField_a_of_type_Akaa = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).removeObserver(this.jdField_a_of_type_Ajxj);
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
      localObject1 = (ainz)paramView.getTag();
    }
    Object localObject2;
    if ((paramView != null) && (localObject1 != null) && (!((ainz)localObject1).jdField_a_of_type_Boolean))
    {
      localObject2 = localObject1;
      if (TextUtils.equals(((ainz)localObject1).jdField_b_of_type_JavaLangString, ThemeUtil.curThemeId)) {}
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558464, paramViewGroup, false);
      localObject2 = new ainz();
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367407));
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370830));
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.getPaint();
      ((ainz)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366840));
      ((ainz)localObject2).c = ((TextView)paramView.findViewById(2131361892));
      ((ainz)localObject2).d = ((TextView)paramView.findViewById(2131362073));
      ((ainz)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364258);
      ((ainz)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((ainz)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.setTag(localObject2);
      if (this.jdField_a_of_type_Int != 25)
      {
        ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166854));
        ((ainz)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166941));
      }
      ((ainz)localObject2).jdField_b_of_type_JavaLangString = ThemeUtil.curThemeId;
    }
    paramViewGroup = a(paramInt);
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_Akaa.a(paramViewGroup, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
    localObject1 = new StringBuilder();
    ((ainz)localObject2).jdField_a_of_type_JavaLangString = paramViewGroup.uin;
    ((ainz)localObject2).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramViewGroup;
    ((ainz)localObject2).jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
    ((ainz)localObject2).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
    ((ainz)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((ainz)localObject2).jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Akaa != null) {}
    for (boolean bool = this.jdField_a_of_type_Akaa.a();; bool = false)
    {
      String str = paramViewGroup.getDisplayName(bool);
      ((ainz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if ((AppSetting.d) && (!TextUtils.isEmpty(str))) {
        ((StringBuilder)localObject1).append(str);
      }
      if (!TextUtils.isEmpty(paramViewGroup.recommendReason))
      {
        ((ainz)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(paramViewGroup.recommendReason);
        if (AppSetting.d) {
          ((StringBuilder)localObject1).append(",你们有").append(paramViewGroup.recommendReason);
        }
        if (paramViewGroup.friendStatus != 0) {
          break label657;
        }
        ((ainz)localObject2).c.setVisibility(0);
        ((ainz)localObject2).c.setTag(paramViewGroup);
        ((ainz)localObject2).d.setVisibility(8);
        ((ainz)localObject2).c.setOnClickListener(this);
        if (AppSetting.d)
        {
          ((ainz)localObject2).c.setContentDescription(ajya.a(2131689628));
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
        if (AppSetting.d) {
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
        return paramView;
        ((ainz)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText("");
        break;
        label657:
        if (paramViewGroup.friendStatus == 1)
        {
          ((ainz)localObject2).c.setVisibility(8);
          ((ainz)localObject2).d.setVisibility(0);
          ((ainz)localObject2).d.setText(2131718754);
          if (!AppSetting.d) {
            break label606;
          }
          ((ainz)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718754));
          ((StringBuilder)localObject1).append(",等待验证");
          break label606;
        }
        ((ainz)localObject2).c.setVisibility(8);
        ((ainz)localObject2).d.setVisibility(0);
        ((ainz)localObject2).d.setText(2131690035);
        if (!AppSetting.d) {
          break label606;
        }
        ((ainz)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690035));
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
            if ((this.jdField_a_of_type_Ajxl != null) && (!this.jdField_a_of_type_Ajxl.b(paramView.uin)) && (!this.jdField_a_of_type_Ajxl.d(paramView.uin)))
            {
              bool = false;
              if (this.jdField_a_of_type_Akaa != null) {
                bool = this.jdField_a_of_type_Akaa.a();
              }
              localObject1 = paramView.getDisplayName(bool);
              localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramView.uin, null, 3045, this.jdField_a_of_type_Int, (String)localObject1, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131689628), null);
              ((Intent)localObject1).putExtra("key_param_age_area", bbac.a(this.jdField_a_of_type_AndroidAppActivity, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
              this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                switch (this.jdField_b_of_type_Int)
                {
                }
              }
            }
            for (;;)
            {
              if (this.jdField_a_of_type_Akaa != null) {
                this.jdField_a_of_type_Akaa.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 3);
              }
              if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", this.jdField_a_of_type_Int, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 1);
              return;
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
              continue;
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
              continue;
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
              continue;
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
              continue;
              if ((this.jdField_a_of_type_Ajxl != null) && (this.jdField_a_of_type_Ajxl.b(paramView.uin)))
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
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
                continue;
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
                continue;
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
                continue;
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
              }
            }
          }
        }
        paramView = (ainz)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    int i = 84;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      label828:
      int j = i;
      if (this.jdField_a_of_type_Ajxl != null)
      {
        j = i;
        if (this.jdField_a_of_type_Ajxl.b(paramView.uin)) {
          j = 1;
        }
      }
      localObject1 = new ProfileActivity.AllInOne(paramView.uin, j);
      bool = false;
      if (this.jdField_a_of_type_Akaa != null) {
        bool = this.jdField_a_of_type_Akaa.a();
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
      if (this.jdField_a_of_type_Akaa != null) {
        this.jdField_a_of_type_Akaa.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2);
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
      continue;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
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
        if ((paramString != null) && ((paramString instanceof ainz)))
        {
          paramString = (ainz)paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aint
 * JD-Core Version:    0.7.0.1
 */