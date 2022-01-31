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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ahjd
  extends aked
  implements View.OnClickListener, bhww
{
  int jdField_a_of_type_Int = -1;
  private ahpq jdField_a_of_type_Ahpq;
  private allb jdField_a_of_type_Allb = new ahjg(this);
  private alox jdField_a_of_type_Alox = new ahjf(this);
  private alro jdField_a_of_type_Alro;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axxi jdField_a_of_type_Axxi = new ahje(this);
  private axzt jdField_a_of_type_Axzt;
  private bhpo jdField_a_of_type_Bhpo = new ahjj(this);
  private bhxa jdField_a_of_type_Bhxa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private Comparator<MayKnowRecommend> jdField_a_of_type_JavaUtilComparator = new ahji(this);
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  protected Runnable b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public ahjd(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alro = ((alro)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365724));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367375);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839129);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367372);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(bhxo.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Axzt = ((axzt)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_Axzt.a(this.jdField_a_of_type_Axxi);
    a(this.jdField_a_of_type_Bhpo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_Bhxa = a(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ahpq = ((ahpq)paramQQAppInterface.getManager(295));
    this.jdField_a_of_type_Alro = ((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(ahjk paramahjk)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramahjk.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839128);
      paramahjk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramahjk.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramahjk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramahjk.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839129);
    paramahjk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramahjk.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramahjk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131375820) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131375820);
      localObject = paramView.getTag(2131368113);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131368113, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839218);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839216);
      return;
    }
    paramView.setBackgroundResource(2130839213);
  }
  
  protected View a(Context paramContext, int paramInt, ahjk paramahjk)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bhxa.a(paramContext, localView, paramahjk, -1);
  }
  
  protected View a(Context paramContext, int paramInt, ahjl paramahjl)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bhxa.a(paramContext, localView, paramahjl, -1);
  }
  
  protected bhxa a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    paramContext = ahgy.c;
    int[] arrayOfInt1 = ahgy.a;
    int[] arrayOfInt2 = ahgy.b;
    return new ahjh(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int != 0) {
      a(true);
    }
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, bhxb parambhxb, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {}
    for (int i = this.jdField_a_of_type_Bhxa.a(paramContext, paramView, paramInt, paramObject, parambhxb, paramOnClickListener);; i = 0)
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
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Alro.a());
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
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_Ahpq.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699562);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
    }
    Object localObject = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = ((anuj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
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
    this.jdField_a_of_type_Axzt.b(this.jdField_a_of_type_Axxi);
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
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
      paramViewGroup = new ahjk();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561312, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368701));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378742));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363516));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(paramViewGroup);
      ahgy.b(paramViewGroup.g, false);
      a(paramViewGroup);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, paramViewGroup, this);
      paramViewGroup.g.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      paramViewGroup.g.setOnClickListener(this);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      paramViewGroup = null;
      if (paramViewGroup != null)
      {
        localStringBuilder = new StringBuilder(512);
        paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Alro.a());
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label778;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (AppSetting.c) {
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
        if (AppSetting.c) {
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
        paramViewGroup.b.setText(alpo.a(2131689628));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          localStringBuilder.append(",点击添加");
          paramViewGroup.b.setContentDescription(alpo.a(2131689628));
        }
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
      a(paramViewGroup.e, localMayKnowRecommend);
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof ahjl)))
      {
        paramViewGroup = new ahjl();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561311, paramViewGroup);
        paramViewGroup.d = ((TextView)paramView.findViewById(2131370102));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131378376));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371142));
        paramViewGroup.b = ((Button)paramView.findViewById(2131375665));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375675));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131377169));
        paramView.setTag(paramViewGroup);
        if ((paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        ahgy.b(paramViewGroup.g, false);
        break;
      }
      paramViewGroup = (ahjl)paramView.getTag();
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
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131719227);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719227));
        }
      }
      else
      {
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131690082);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690082));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370179: 
    case 2131375665: 
    case 2131363516: 
    case 2131375820: 
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
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
        localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!((aloz)localObject).b(paramView.uin)) && (!((aloz)localObject).d(paramView.uin)))
        {
          boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          localObject = paramView.getDisplayName(this.jdField_a_of_type_Alro.a());
          i = this.jdField_b_of_type_Int;
          localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
          ((Intent)localObject).putExtra("key_param_age_area", bcyw.a(this.jdField_a_of_type_AndroidContentContext, paramView.gender, paramView.age, paramView.country, paramView.province, paramView.city));
          ((Intent)localObject).putExtra("from_babyq", bool);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject);
        }
        for (;;)
        {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", this.jdField_b_of_type_Int, 1, paramView.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramView), paramView.algBuffer, 0, "4");
          return;
          if (((aloz)localObject).b(paramView.uin))
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
        localObject = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
        paramView.getContext().startActivity((Intent)localObject);
        return;
        localObject = (MayKnowRecommend)paramView.getTag();
        if ((localObject instanceof ConnectsExplorationBanner))
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
          localObject = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
          paramView.getContext().startActivity((Intent)localObject);
          return;
        }
      } while (localObject == null);
      paramView = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramView != null) && (paramView.b(((MayKnowRecommend)localObject).uin))) {}
      for (int i = 1;; i = 110)
      {
        paramView = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject).uin, i);
        String str = ((MayKnowRecommend)localObject).getRecommendName(this.jdField_a_of_type_Alro.a());
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
    if (bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
      this.jdField_a_of_type_Ahpq.b(true);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjd
 * JD-Core Version:    0.7.0.1
 */