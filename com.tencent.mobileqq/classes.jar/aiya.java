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
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.2;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.9;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aiya
  extends amgy
  implements View.OnClickListener, blfg
{
  int jdField_a_of_type_Int = -1;
  private ajmy jdField_a_of_type_Ajmy;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new aiyc(this);
  private anyb jdField_a_of_type_Anyb;
  private bbtd jdField_a_of_type_Bbtd = new aiyb(this);
  private bbvn jdField_a_of_type_Bbvn;
  private blfk jdField_a_of_type_Blfk;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aiyd(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new aiyg(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private Comparator<MayKnowRecommend> jdField_a_of_type_JavaUtilComparator = new aiyf(this);
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  protected Runnable b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public aiya(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anyb = ((anyb)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366144));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367931);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839369);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367927);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(blfw.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Bbvn = ((bbvn)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Bbtd);
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ajmy = ((ajmy)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
    this.jdField_a_of_type_Anyb = ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(aiyh paramaiyh)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramaiyh.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839368);
      paramaiyh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramaiyh.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramaiyh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramaiyh.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839369);
    paramaiyh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramaiyh.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramaiyh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131376771) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131376771);
      localObject = paramView.getTag(2131368706);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131368706, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839460);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839458);
      return;
    }
    paramView.setBackgroundResource(2130839455);
  }
  
  protected View a(Context paramContext, int paramInt, aiyh paramaiyh)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramaiyh, -1);
  }
  
  protected View a(Context paramContext, int paramInt, aiyi paramaiyi)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramaiyi, -1);
  }
  
  protected blfk a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298795);
    int j = paramContext.getResources().getDimensionPixelSize(2131298796);
    paramContext = aiyz.c;
    int[] arrayOfInt1 = aiyz.a;
    int[] arrayOfInt2 = aiyz.b;
    return new aiye(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int != 0) {
      a(true);
    }
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blfk != null) {}
    for (int i = this.jdField_a_of_type_Blfk.a(paramContext, paramView, paramInt, paramObject, paramblfl, paramOnClickListener);; i = 0)
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
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Anyb.a());
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
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_Ajmy.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698673);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
    }
    Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = ((aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a();
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
        break label202;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      if (paramBoolean) {
        notifyDataSetChanged();
      }
      return true;
      label202:
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
    this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Bbtd);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
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
  
  public void e(boolean paramBoolean) {}
  
  public void g() {}
  
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
    Object localObject1;
    StringBuilder localStringBuilder;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      localObject1 = new aiyh();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561544, (aiyh)localObject1);
      ((aiyh)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369329));
      ((aiyh)localObject1).b = ((TextView)paramView.findViewById(2131379930));
      ((aiyh)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380210));
      ((aiyh)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363841));
      ((aiyh)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
      aiyz.b(((aiyh)localObject1).g, false);
      a((aiyh)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (blfl)localObject1, this);
      ((aiyh)localObject1).g.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((aiyh)localObject1).g.setOnClickListener(this);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
      if (localObject1 != null)
      {
        localStringBuilder = new StringBuilder(512);
        ((aiyi)localObject1).jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
        ((aiyi)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject2 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Anyb.a());
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label841;
        }
        ((aiyi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((aiyi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append((String)localObject2);
        }
        label307:
        paramView.setTag(-1, Integer.valueOf(paramInt));
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (blfl)localObject1, this);
        ((aiyi)localObject1).g.setTag(localMayKnowRecommend);
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.category).append(" ");
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label854;
        }
        ((aiyi)localObject1).d.setVisibility(0);
        ((aiyi)localObject1).d.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label454:
        ((aiyi)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
        if (localMayKnowRecommend.friendStatus != 0) {
          break label867;
        }
        ((aiyi)localObject1).b.setOnClickListener(this);
        ((aiyi)localObject1).b.setVisibility(0);
        ((aiyi)localObject1).b.setTag(localMayKnowRecommend);
        ((aiyi)localObject1).b.setText(anvx.a(2131689550));
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          localStringBuilder.append(",点击添加");
          ((aiyi)localObject1).b.setContentDescription(anvx.a(2131689550));
        }
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((aiyi)localObject1).g.setOnClickListener(this);
      ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((aiyi)localObject1).jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(((aiyi)localObject1).e, localMayKnowRecommend);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof aiyi)))
      {
        localObject1 = new aiyi();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561543, (aiyi)localObject1);
        ((aiyi)localObject1).d = ((TextView)paramView.findViewById(2131370817));
        ((aiyi)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379521));
        ((aiyi)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
        ((aiyi)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371981));
        ((aiyi)localObject1).b = ((Button)paramView.findViewById(2131376596));
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376606));
        ((aiyi)localObject1).e = ((TextView)paramView.findViewById(2131378247));
        paramView.setTag(localObject1);
        if ((((aiyi)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)((aiyi)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        aiyz.b(((aiyi)localObject1).g, false);
        break;
      }
      localObject1 = (aiyi)paramView.getTag();
      break;
      label841:
      ((aiyi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label307;
      label854:
      ((aiyi)localObject1).d.setVisibility(8);
      break label454;
      label867:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        ((aiyi)localObject1).b.setVisibility(8);
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131718061);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718061));
        }
      }
      else
      {
        ((aiyi)localObject1).b.setVisibility(8);
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131690030);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          ((aiyi)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690030));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      }
      else
      {
        Object localObject1 = (MayKnowRecommend)paramView.getTag();
        if (localObject1 != null)
        {
          Object localObject2 = ((MayKnowRecommend)localObject1).uin;
          if (QLog.isColorLevel()) {
            QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject2);
          }
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
          continue;
          localObject1 = (MayKnowRecommend)paramView.getTag();
          if (localObject1 != null)
          {
            localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            int i;
            if ((!((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((anvk)localObject2).d(((MayKnowRecommend)localObject1).uin)))
            {
              boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
              localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.jdField_a_of_type_Anyb.a());
              i = this.jdField_b_of_type_Int;
              localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689550), null);
              ((Intent)localObject2).putExtra("key_param_age_area", bhaa.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
              ((Intent)localObject2).putExtra("from_babyq", bool);
              ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject2);
            }
            for (;;)
            {
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_b_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
              break;
              if (((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin))
              {
                ((MayKnowRecommend)localObject1).friendStatus = 2;
                notifyDataSetChanged();
              }
              else
              {
                ((MayKnowRecommend)localObject1).friendStatus = 1;
                notifyDataSetChanged();
              }
            }
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
            localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
            paramView.getContext().startActivity((Intent)localObject1);
            continue;
            localObject1 = (MayKnowRecommend)paramView.getTag();
            if ((localObject1 instanceof ConnectsExplorationBanner))
            {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
              localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
              paramView.getContext().startActivity((Intent)localObject1);
            }
            else if (localObject1 != null)
            {
              localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if ((localObject2 != null) && (((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin))) {}
              for (i = 1;; i = 110)
              {
                localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
                String str = ((MayKnowRecommend)localObject1).getRecommendName(this.jdField_a_of_type_Anyb.a());
                if (!TextUtils.isEmpty(str)) {
                  ((ProfileActivity.AllInOne)localObject2).l = str;
                }
                if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
                  ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
                }
                ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
                str = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
                Bundle localBundle = new Bundle();
                localBundle.putString("recommend_entry_type", "4");
                localBundle.putInt("key_display_type", 0);
                localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
                localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
                localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
                localBundle.putString("recommend_label", str);
                localBundle.putInt("tabID", this.jdField_b_of_type_Int);
                ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, localBundle);
                if (QLog.isColorLevel()) {
                  QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ open profile item uin = " + ((MayKnowRecommend)localObject1).uin);
                }
                ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, str, 0, "4");
                break;
              }
              if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
              {
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
                this.jdField_a_of_type_Ajmy.b(true);
              }
              else
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiya
 * JD-Core Version:    0.7.0.1
 */