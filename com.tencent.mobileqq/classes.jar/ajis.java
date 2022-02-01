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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ajis
  extends amoe
  implements View.OnClickListener, blpr
{
  int jdField_a_of_type_Int = -1;
  private ajwm jdField_a_of_type_Ajwm;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new ajiv(this);
  private anyu jdField_a_of_type_Anyu = new ajiu(this);
  private aobl jdField_a_of_type_Aobl;
  private bbst jdField_a_of_type_Bbst = new ajit(this);
  private bbvd jdField_a_of_type_Bbvd;
  private blih jdField_a_of_type_Blih = new ajiy(this);
  private blpv jdField_a_of_type_Blpv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private Comparator<MayKnowRecommend> jdField_a_of_type_JavaUtilComparator = new ajix(this);
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  protected Runnable b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public ajis(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aobl = ((aobl)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366013));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367762);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839313);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367758);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(blqj.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Bbvd = ((bbvd)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbst);
    a(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ajwm = ((ajwm)paramQQAppInterface.getManager(295));
    this.jdField_a_of_type_Aobl = ((aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(ajiz paramajiz)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramajiz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839312);
      paramajiz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramajiz.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramajiz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramajiz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839313);
    paramajiz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramajiz.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramajiz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131376742) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131376742);
      localObject = paramView.getTag(2131368523);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131368523, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839404);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839402);
      return;
    }
    paramView.setBackgroundResource(2130839399);
  }
  
  protected View a(Context paramContext, int paramInt, ajiz paramajiz)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blpv.a(paramContext, localView, paramajiz, -1);
  }
  
  protected View a(Context paramContext, int paramInt, ajja paramajja)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blpv.a(paramContext, localView, paramajja, -1);
  }
  
  protected blpv a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298726);
    int j = paramContext.getResources().getDimensionPixelSize(2131298727);
    paramContext = ajjr.c;
    int[] arrayOfInt1 = ajjr.a;
    int[] arrayOfInt2 = ajjr.b;
    return new ajiw(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int != 0) {
      a(true);
    }
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blpv != null) {}
    for (int i = this.jdField_a_of_type_Blpv.a(paramContext, paramView, paramInt, paramObject, paramblpw, paramOnClickListener);; i = 0)
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
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Aobl.a());
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
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_Ajwm.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698212);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
    }
    Object localObject = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = ((aqmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
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
    this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbst);
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
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
  
  public void f() {}
  
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
      localObject1 = new ajiz();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561604, (ajiz)localObject1);
      ((ajiz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369139));
      ((ajiz)localObject1).b = ((TextView)paramView.findViewById(2131379839));
      ((ajiz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
      ((ajiz)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363741));
      ((ajiz)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
      ajjr.b(((ajiz)localObject1).g, false);
      a((ajiz)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (blpw)localObject1, this);
      ((ajiz)localObject1).g.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((ajiz)localObject1).g.setOnClickListener(this);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
      if (localObject1 != null)
      {
        localStringBuilder = new StringBuilder(512);
        ((ajja)localObject1).jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
        ((ajja)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject2 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Aobl.a());
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label841;
        }
        ((ajja)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ajja)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append((String)localObject2);
        }
        label307:
        paramView.setTag(-1, Integer.valueOf(paramInt));
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (blpw)localObject1, this);
        ((ajja)localObject1).g.setTag(localMayKnowRecommend);
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
        ((ajja)localObject1).d.setVisibility(0);
        ((ajja)localObject1).d.setText((CharSequence)localObject2);
        if (AppSetting.c) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label454:
        ((ajja)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
        if (localMayKnowRecommend.friendStatus != 0) {
          break label867;
        }
        ((ajja)localObject1).b.setOnClickListener(this);
        ((ajja)localObject1).b.setVisibility(0);
        ((ajja)localObject1).b.setTag(localMayKnowRecommend);
        ((ajja)localObject1).b.setText(anzj.a(2131689551));
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.c)
        {
          localStringBuilder.append(",点击添加");
          ((ajja)localObject1).b.setContentDescription(anzj.a(2131689551));
        }
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((ajja)localObject1).g.setOnClickListener(this);
      ((ajja)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((ajja)localObject1).jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(((ajja)localObject1).e, localMayKnowRecommend);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof ajja)))
      {
        localObject1 = new ajja();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561603, (ajja)localObject1);
        ((ajja)localObject1).d = ((TextView)paramView.findViewById(2131370666));
        ((ajja)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379447));
        ((ajja)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
        ((ajja)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371827));
        ((ajja)localObject1).b = ((Button)paramView.findViewById(2131376575));
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376585));
        ((ajja)localObject1).e = ((TextView)paramView.findViewById(2131378189));
        paramView.setTag(localObject1);
        if ((((ajja)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)((ajja)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        ajjr.b(((ajja)localObject1).g, false);
        break;
      }
      localObject1 = (ajja)paramView.getTag();
      break;
      label841:
      ((ajja)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label307;
      label854:
      ((ajja)localObject1).d.setVisibility(8);
      break label454;
      label867:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        ((ajja)localObject1).b.setVisibility(8);
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131717458);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717458));
        }
      }
      else
      {
        ((ajja)localObject1).b.setVisibility(8);
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131689982);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          ((ajja)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689982));
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
      if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
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
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f((String)localObject2);
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
          continue;
          localObject1 = (MayKnowRecommend)paramView.getTag();
          if (localObject1 != null)
          {
            localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            int i;
            if ((!((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((anyw)localObject2).d(((MayKnowRecommend)localObject1).uin)))
            {
              boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
              localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.jdField_a_of_type_Aobl.a());
              i = this.jdField_b_of_type_Int;
              localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689551), null);
              ((Intent)localObject2).putExtra("key_param_age_area", bhhz.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
              ((Intent)localObject2).putExtra("from_babyq", bool);
              ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject2);
            }
            for (;;)
            {
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_b_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
              break;
              if (((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin))
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
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
            localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
            paramView.getContext().startActivity((Intent)localObject1);
            continue;
            localObject1 = (MayKnowRecommend)paramView.getTag();
            if ((localObject1 instanceof ConnectsExplorationBanner))
            {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
              localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
              paramView.getContext().startActivity((Intent)localObject1);
            }
            else if (localObject1 != null)
            {
              localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if ((localObject2 != null) && (((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin))) {}
              for (i = 1;; i = 110)
              {
                localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
                String str = ((MayKnowRecommend)localObject1).getRecommendName(this.jdField_a_of_type_Aobl.a());
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
              if (bhnv.d(this.jdField_a_of_type_AndroidContentContext))
              {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
                this.jdField_a_of_type_Ajwm.b(true);
              }
              else
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajis
 * JD-Core Version:    0.7.0.1
 */