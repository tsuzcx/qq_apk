import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter.2;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter.6;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aibw
  extends aiab
  implements View.OnClickListener, beno
{
  int jdField_a_of_type_Int;
  aibk jdField_a_of_type_Aibk;
  ajjh jdField_a_of_type_Ajjh = new aiby(this);
  private ajls jdField_a_of_type_Ajls;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private avck jdField_a_of_type_Avck = new aibx(this);
  private avev jdField_a_of_type_Avev;
  private begh jdField_a_of_type_Begh = new aica(this);
  bens jdField_a_of_type_Bens;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private String jdField_a_of_type_JavaLangString = "";
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  protected Runnable b;
  private int c;
  private int d;
  
  public aibw(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, aibk paramaibk)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new RecommendFriendAdapter.2(this);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangRunnable = new RecommendFriendAdapter.6(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Ajls = ((ajls)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.c = paramInt;
    this.d = 3;
    if (this.c == 8) {
      this.d = 24;
    }
    for (;;)
    {
      this.jdField_a_of_type_Avev = ((avev)paramQQAppInterface.getManager(15));
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avck);
      this.jdField_a_of_type_Aibk = paramaibk;
      a(this.jdField_a_of_type_Begh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_Bens = a(paramContext);
      return;
      if ((this.c == 3) || (this.c == 6)) {
        this.d = 21;
      } else if (this.c == 10) {
        this.d = 28;
      }
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131309584) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131309584);
      localObject = paramView.getTag(2131302356);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131302356, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839106);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130839101);
  }
  
  private void f()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Ajls.c();
    if ((this.jdField_a_of_type_Aibk != null) && ((this.jdField_a_of_type_Aibk instanceof aibl))) {
      ((aibl)this.jdField_a_of_type_Aibk).a(localArrayList);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      a(localArrayList);
      if (this.jdField_a_of_type_Aibk != null) {
        this.jdField_a_of_type_Aibk.b();
      }
    }
    do
    {
      return;
      a(new ArrayList());
    } while (this.jdField_a_of_type_Aibk == null);
    this.jdField_a_of_type_Aibk.a();
  }
  
  protected View a(Context paramContext, int paramInt, aicb paramaicb)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bens.a(paramContext, localView, paramaicb, -1);
  }
  
  protected bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    paramContext = aeyf.c;
    int[] arrayOfInt1 = aeyf.a;
    int[] arrayOfInt2 = aeyf.b;
    return new aibz(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_Ajls.b(localMayKnowRecommend, this.d, this.c, 1);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {}
    for (int i = this.jdField_a_of_type_Bens.a(paramContext, paramView, paramInt, paramObject, parambent, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_b_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    MayKnowRecommend localMayKnowRecommend;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      } while (!this.jdField_a_of_type_JavaLangString.equals(localMayKnowRecommend.uin));
    }
    for (;;)
    {
      if (localMayKnowRecommend != null)
      {
        paramList.remove(localMayKnowRecommend);
        paramList.add(0, localMayKnowRecommend);
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      notifyDataSetChanged();
      return;
      localMayKnowRecommend = null;
    }
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_Ajls.a(localMayKnowRecommend, this.d, this.c, 1);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avck);
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void d()
  {
    int j = 2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      i = k;
      while (i <= m)
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
        QLog.d("RecommendFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + k + " lastVisibleItem: " + m + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        if (this.d != 21) {
          break label364;
        }
      }
    }
    label364:
    for (int i = j;; i = 0)
    {
      String str = "";
      if (this.d == 24) {
        str = "2";
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, localArrayList1, localArrayList2, localArrayList3, localArrayList4, i, str);
      return;
    }
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean) {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new MayKnowRecommend();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MayKnowRecommend localMayKnowRecommend;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      paramViewGroup = new aicb();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495537, paramViewGroup);
      paramViewGroup.d = ((TextView)paramView.findViewById(2131304161));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131312004));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305159));
      paramViewGroup.b = ((Button)paramView.findViewById(2131309433));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309443));
      paramView.setTag(paramViewGroup);
      if ((paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      aeyf.b(paramViewGroup.g, false);
      localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(512);
        localStringBuilder.append("getView position: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", mobile_name : ");
        localStringBuilder.append(localMayKnowRecommend.mobile_name);
        localStringBuilder.append(", remark : ");
        localStringBuilder.append(localMayKnowRecommend.remark);
        localStringBuilder.append(", nick : ");
        localStringBuilder.append(localMayKnowRecommend.nick);
        localStringBuilder.append(", gender : ");
        localStringBuilder.append(localMayKnowRecommend.gender);
        localStringBuilder.append(", age : ");
        localStringBuilder.append(localMayKnowRecommend.age);
        localStringBuilder.append(", category : ");
        localStringBuilder.append(localMayKnowRecommend.category);
        localStringBuilder.append(", recommendReason : ");
        localStringBuilder.append(localMayKnowRecommend.recommendReason);
        localStringBuilder.append(", hasQZoneUpdate : ");
        localStringBuilder.append(localMayKnowRecommend.hasQZoneUpdate);
        localStringBuilder.append(", signature : ");
        localStringBuilder.append(localMayKnowRecommend.richSingature);
        QLog.d("RecommendFriendAdapter", 2, localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder(512);
      paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      this.jdField_a_of_type_Ajls.a(localMayKnowRecommend, this.d, this.c, 1);
      Object localObject = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Ajls.a());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label786;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label484:
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, paramViewGroup, this);
      paramViewGroup.g.setTag(localMayKnowRecommend);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.category).append(" ");
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
      }
      localObject = ((StringBuilder)localObject).toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label798;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      label627:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label810;
      }
      paramViewGroup.b.setOnClickListener(this);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setTag(localMayKnowRecommend);
      paramViewGroup.b.setText(ajjy.a(2131624088));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        paramViewGroup.b.setContentDescription(ajjy.a(2131624088));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      paramViewGroup.g.setOnClickListener(this);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      return paramView;
      paramViewGroup = (aicb)paramView.getTag();
      break;
      label786:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label484;
      label798:
      paramViewGroup.d.setVisibility(8);
      break label627;
      label810:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131652918);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131652918));
        }
      }
      else
      {
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131624481);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624481));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    MayKnowRecommend localMayKnowRecommend;
    Object localObject;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
          {
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            return;
          }
          localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
        } while (localMayKnowRecommend == null);
        localObject = localMayKnowRecommend.uin;
        if (QLog.isColorLevel()) {
          QLog.d("RecommendFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject);
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f((String)localObject);
        this.jdField_a_of_type_JavaUtilList.remove(localMayKnowRecommend);
        notifyDataSetChanged();
        i = 0;
        if (this.d == 21) {
          i = 2;
        }
        paramView = "";
        if (this.d == 24) {
          paramView = "2";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "frd_list_dlt", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, paramView);
        return;
        localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
      } while (localMayKnowRecommend == null);
      paramView = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!paramView.b(localMayKnowRecommend.uin)) && (!paramView.d(localMayKnowRecommend.uin)))
      {
        bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
        paramView = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Ajls.a());
        int j = 3045;
        switch (this.c)
        {
        case 5: 
        case 6: 
        case 7: 
        case 9: 
        default: 
          i = 3;
          if (bool)
          {
            j = 3083;
            i = 1;
          }
          paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localMayKnowRecommend.uin, null, j, i, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131624088), null);
          paramView.putExtra("key_param_age_area", azyk.a(this.jdField_a_of_type_AndroidContentContext, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
          paramView.putExtra("from_babyq", bool);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(paramView);
          switch (this.c)
          {
          }
          break;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Ajls.a(localMayKnowRecommend, this.d, this.c, 3);
        i = 0;
        if (this.d == 21) {
          i = 2;
        }
        paramView = "";
        if (this.d == 24) {
          paramView = "2";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_add", this.d, 1, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, paramView);
        return;
        i = 24;
        break;
        i = 21;
        break;
        i = 28;
        break;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
        continue;
        if (paramView.b(localMayKnowRecommend.uin))
        {
          localMayKnowRecommend.friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          localMayKnowRecommend.friendStatus = 1;
          notifyDataSetChanged();
        }
      }
      localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
    } while (localMayKnowRecommend == null);
    paramView = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Bundle localBundle;
    if ((paramView != null) && (paramView.b(localMayKnowRecommend.uin)))
    {
      i = 1;
      localObject = new ProfileActivity.AllInOne(localMayKnowRecommend.uin, i);
      paramView = localMayKnowRecommend.getRecommendName(this.jdField_a_of_type_Ajls.a());
      if (!TextUtils.isEmpty(paramView)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView;
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = localMayKnowRecommend.nick;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 88;
      bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      localBundle = new Bundle();
      if (bool) {
        localBundle.putBoolean("from_babyq", true);
      }
      if (this.d != 21) {
        break label1410;
      }
    }
    label1410:
    for (int i = 2;; i = 0)
    {
      paramView = "";
      if (this.d == 24) {
        paramView = "2";
      }
      localBundle.putString("recommend_entry_type", paramView);
      localBundle.putInt("key_display_type", i);
      localBundle.putString("recommend_reason", localMayKnowRecommend.recommendReason);
      localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend));
      localBundle.putByteArray("recommend_algh_id", localMayKnowRecommend.algBuffer);
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, localBundle);
      this.jdField_a_of_type_Ajls.a(localMayKnowRecommend, this.d, this.c, 2);
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendAdapter", 2, "onClick_ open profile item uin = " + localMayKnowRecommend.uin);
      }
      switch (this.c)
      {
      }
      for (;;)
      {
        paramView = "";
        if (this.d == 24) {
          paramView = "2";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_clk", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, paramView);
        return;
        if (this.c == 8)
        {
          i = 101;
          break;
        }
        if ((this.c == 3) || (this.c == 4))
        {
          i = 82;
          break;
        }
        if (this.c == 10)
        {
          i = 107;
          break;
        }
        i = 83;
        if (this.d != 21) {
          break;
        }
        i = 82;
        break;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_Ajls.b(paramAbsListView, this.d, this.c, 1);
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_Ajls.b(paramAbsListView, this.d, this.c, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibw
 * JD-Core Version:    0.7.0.1
 */