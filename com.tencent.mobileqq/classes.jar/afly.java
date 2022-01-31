import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.2;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.7;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.9;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afly
  extends aims
  implements View.OnClickListener, bfvz
{
  int jdField_a_of_type_Int = -1;
  private afry jdField_a_of_type_Afry;
  private ajto jdField_a_of_type_Ajto = new afmb(this);
  private ajxj jdField_a_of_type_Ajxj = new afma(this);
  private akaa jdField_a_of_type_Akaa;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awcf jdField_a_of_type_Awcf = new aflz(this);
  private aweq jdField_a_of_type_Aweq;
  private bfos jdField_a_of_type_Bfos = new afme(this);
  private bfwd jdField_a_of_type_Bfwd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private Comparator<MayKnowRecommend> jdField_a_of_type_JavaUtilComparator = new afmd(this);
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  protected Runnable b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public afly(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akaa = ((akaa)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365640));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367245);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839048);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367242);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(bfwr.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Aweq = ((aweq)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Awcf);
    a(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto);
    this.jdField_a_of_type_Bfwd = a(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Afry = ((afry)paramQQAppInterface.getManager(295));
    this.jdField_a_of_type_Akaa = ((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
    if (this.jdField_c_of_type_Int == 0) {
      a(true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(afmf paramafmf)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramafmf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839047);
      paramafmf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramafmf.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramafmf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramafmf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839048);
    paramafmf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramafmf.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramafmf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131375335) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131375335);
      localObject = paramView.getTag(2131367976);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131367976, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839134);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839132);
      return;
    }
    paramView.setBackgroundResource(2130839129);
  }
  
  protected View a(Context paramContext, int paramInt, afmf paramafmf)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bfwd.a(paramContext, localView, paramafmf, -1);
  }
  
  protected View a(Context paramContext, int paramInt, afmg paramafmg)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bfwd.a(paramContext, localView, paramafmg, -1);
  }
  
  protected bfwd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    paramContext = afjt.c;
    int[] arrayOfInt1 = afjt.a;
    int[] arrayOfInt2 = afjt.b;
    return new afmc(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int != 0) {
      a(true);
    }
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, bfwe parambfwe, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfwd != null) {}
    for (int i = this.jdField_a_of_type_Bfwd.a(paramContext, paramView, paramInt, paramObject, parambfwe, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Akaa.a());
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData " + this.jdField_b_of_type_Int + " " + paramBoolean);
    }
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_Afry.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699216);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
    }
    Object localObject = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = ((amdj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((MayKnowRecommend)localIterator.next() instanceof ConnectsExplorationBanner)) {
        localIterator.remove();
      }
    }
    if ((TextUtils.isEmpty(((Card)localObject).strSchool)) && ((localArrayList == null) || (localArrayList.isEmpty())))
    {
      localObject = new ConnectsExplorationBanner();
      ((ConnectsExplorationBanner)localObject).setBanner(true);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 4) {
        break label200;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      if (paramBoolean) {
        notifyDataSetChanged();
      }
      return true;
      label200:
      this.jdField_a_of_type_JavaUtilList.add(4, localObject);
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
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if (this.jdField_a_of_type_Boolean) {
      a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Awcf);
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      if (i <= k)
      {
        if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(i) == null) || ((this.jdField_a_of_type_JavaUtilList.get(i) instanceof ConnectsExplorationBanner))) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConnectsExplorationFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "4");
      }
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
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    StringBuilder localStringBuilder;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      paramViewGroup = new afmf();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561125, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368510));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378178));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378383));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363475));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(paramViewGroup);
      afjt.b(paramViewGroup.g, false);
      a(paramViewGroup);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, paramViewGroup, this);
      paramViewGroup.g.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      paramViewGroup.g.setOnClickListener(this);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      paramViewGroup = null;
      if (paramViewGroup != null)
      {
        localStringBuilder = new StringBuilder(512);
        paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Akaa.a());
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label778;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (AppSetting.d) {
          localStringBuilder.append((String)localObject);
        }
        label288:
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
          break label790;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText((CharSequence)localObject);
        if (AppSetting.d) {
          localStringBuilder.append(",").append((String)localObject);
        }
        label431:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
        if (localMayKnowRecommend.friendStatus != 0) {
          break label802;
        }
        paramViewGroup.b.setOnClickListener(this);
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setTag(localMayKnowRecommend);
        paramViewGroup.b.setText(ajya.a(2131689628));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.d)
        {
          localStringBuilder.append(",点击添加");
          paramViewGroup.b.setContentDescription(ajya.a(2131689628));
        }
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      paramViewGroup.g.setOnClickListener(this);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(paramViewGroup.e, localMayKnowRecommend);
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof afmg)))
      {
        paramViewGroup = new afmg();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561124, paramViewGroup);
        paramViewGroup.d = ((TextView)paramView.findViewById(2131369838));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131377832));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
        paramViewGroup.b = ((Button)paramView.findViewById(2131375183));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375193));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131376659));
        paramView.setTag(paramViewGroup);
        if ((paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        afjt.b(paramViewGroup.g, false);
        break;
      }
      paramViewGroup = (afmg)paramView.getTag();
      break;
      label778:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label288;
      label790:
      paramViewGroup.d.setVisibility(8);
      break label431;
      label802:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131718754);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718754));
        }
      }
      else
      {
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131690035);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690035));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369914: 
    case 2131375183: 
    case 2131363475: 
    case 2131375335: 
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
            {
              bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
              return;
            }
            paramView = (MayKnowRecommend)paramView.getTag();
          } while (paramView == null);
          localObject = paramView.uin;
          if (QLog.isColorLevel()) {
            QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject);
          }
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f((String)localObject);
          this.jdField_a_of_type_JavaUtilList.remove(paramView);
          notifyDataSetChanged();
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "frd_list_dlt", this.jdField_b_of_type_Int, 0, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "4");
          return;
          paramView = (MayKnowRecommend)paramView.getTag();
        } while (paramView == null);
        localObject = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!((ajxl)localObject).b(paramView.uin)) && (!((ajxl)localObject).d(paramView.uin)))
        {
          boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          localObject = paramView.getDisplayName(this.jdField_a_of_type_Akaa.a());
          i = this.jdField_b_of_type_Int;
          localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
          ((Intent)localObject).putExtra("key_param_age_area", bbac.a(this.jdField_a_of_type_AndroidContentContext, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
          ((Intent)localObject).putExtra("from_babyq", bool);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject);
        }
        for (;;)
        {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", this.jdField_b_of_type_Int, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0, "4");
          return;
          if (((ajxl)localObject).b(paramView.uin))
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
        localObject = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
        paramView.getContext().startActivity((Intent)localObject);
        return;
        localObject = (MayKnowRecommend)paramView.getTag();
        if ((localObject instanceof ConnectsExplorationBanner))
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
          localObject = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
          paramView.getContext().startActivity((Intent)localObject);
          return;
        }
      } while (localObject == null);
      paramView = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramView != null) && (paramView.b(((MayKnowRecommend)localObject).uin))) {}
      for (int i = 1;; i = 110)
      {
        paramView = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject).uin, i);
        String str = ((MayKnowRecommend)localObject).getRecommendName(this.jdField_a_of_type_Akaa.a());
        if (!TextUtils.isEmpty(str)) {
          paramView.l = str;
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject).nick)) {
          paramView.jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject).nick;
        }
        paramView.jdField_h_of_type_Int = 88;
        str = ContactReportUtils.a(((MayKnowRecommend)localObject).msgLabel);
        Bundle localBundle = new Bundle();
        localBundle.putString("recommend_entry_type", "4");
        localBundle.putInt("key_display_type", 0);
        localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject).recommendReason);
        localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject));
        localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject).algBuffer);
        localBundle.putString("recommend_label", str);
        localBundle.putInt("tabID", this.jdField_b_of_type_Int);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, paramView, localBundle);
        if (QLog.isColorLevel()) {
          QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ open profile item uin = " + ((MayKnowRecommend)localObject).uin);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject).uin, "frd_list_clk", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject), ((MayKnowRecommend)localObject).algBuffer, str, 0, "4");
        return;
      }
    }
    if (bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
      this.jdField_a_of_type_Afry.b(true);
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afly
 * JD-Core Version:    0.7.0.1
 */