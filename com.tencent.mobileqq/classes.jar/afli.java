import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SimpleTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class afli
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected axpb a;
  azwm jdField_a_of_type_Azwm;
  public String a;
  public List<CardProfile> a;
  public boolean a;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  private int f;
  private int g;
  private int h;
  
  public afli(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, azwm paramazwm, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = AIOUtils.dp2px(17.0F, paramContext);
    this.h = AIOUtils.dp2px(15.0F, paramContext);
    this.jdField_a_of_type_Azwm = paramazwm;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = AIOUtils.dp2px(38.0F, paramContext);
    this.jdField_c_of_type_Int = AIOUtils.dp2px(86.0F, paramContext);
    this.d = AIOUtils.dp2px(60.0F, paramContext);
    this.jdField_a_of_type_Axpb = ((axpb)paramVisitorsActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559520, null);
    aflh localaflh = new aflh();
    localaflh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371586));
    localaflh.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376461));
    localaflh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370440));
    localView.setTag(localaflh);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559363, paramViewGroup, false);
    aflf localaflf = new aflf();
    localaflf.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131379295));
    localaflf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368381));
    localaflf.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131381243));
    localaflf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378659));
    localaflf.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131381630));
    localaflf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369774));
    localaflf.d = ((TextView)paramViewGroup.findViewById(2131380261));
    localaflf.e = ((TextView)paramViewGroup.findViewById(2131365449));
    localaflf.f = ((TextView)paramViewGroup.findViewById(2131380264));
    localaflf.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369600));
    localaflf.g = ((TextView)paramViewGroup.findViewById(2131367395));
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131364021));
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692540));
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localaflf.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new afll(this, localaflf));
    paramViewGroup.findViewById(2131365119).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localaflf);
    return paramViewGroup;
  }
  
  private void a()
  {
    Rect localRect;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int == 0)
    {
      localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() != 0)) {
        break label141;
      }
    }
    label141:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c;; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView)
    {
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i = localRect.bottom;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "init empty h " + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - AIOUtils.dp2px(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(aflf paramaflf, CardProfile paramCardProfile)
  {
    TextView localTextView = paramaflf.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramaflf.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramaflf.jdField_c_of_type_AndroidWidgetImageView.getTag(2131369600)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramaflf.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramaflf.jdField_b_of_type_Int = 0;
      paramaflf.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramaflf = anvx.a(2131716184);; paramaflf = anvx.a(2131716185))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramaflf, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramaflf.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramaflf.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramaflf.d.setText((CharSequence)localObject);
  }
  
  private void a(aflh paramaflh)
  {
    int j = 8;
    Object localObject = paramaflh.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693679;
      ((TextView)localObject).setText(i);
      localObject = paramaflh.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramaflh = paramaflh.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramaflh.setVisibility(i);
      return;
      i = 2131694053;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, aflf paramaflf)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramaflf.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = StringUtil.trim(String.valueOf(paramObject.strNick));
    paramaflf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramaflf.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramaflf.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840528;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramaflf.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845539);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramaflf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_Axpb.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842642);
      label214:
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramaflf, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramaflf.f.setText(paramObject.strTime);
      paramaflf.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramaflf.jdField_b_of_type_AndroidWidgetImageView, paramaflf.jdField_a_of_type_AndroidWidgetTextView);
      if (!alik.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramaflf.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramaflf.e.getLayoutParams();
      if (paramaflf.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramaflf.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramaflf.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramaflf.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramaflf.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840533;
      break label84;
      label397:
      paramaflf.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845548);
      break label111;
      label410:
      paramaflf.jdField_c_of_type_AndroidWidgetTextView.setText(bhaa.a(paramObject.bConstellation));
      paramaflf.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845549);
      paramaflf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842644);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramaflf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845868);
        break label214;
      }
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845878);
      break label214;
      label493:
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845865);
      break label214;
      label506:
      paramaflf.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramaflf.f.setVisibility(8);
      break label260;
      label530:
      paramaflf.g.setVisibility(8);
      break label298;
      label542:
      if (paramaflf.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaflf.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  public CardProfile a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<CardProfile> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + paramArrayList);
      }
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramArrayList;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.j = -1;
      i = this.jdField_c_of_type_Int * this.jdField_a_of_type_JavaUtilList.size();
    } while (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g);
    this.e = (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getTitleBarHeight() - i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public CardProfile b(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (CardProfile)this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label54;
      }
      if (this.f != 0) {
        break label42;
      }
      i = 3;
    }
    label42:
    do
    {
      return i;
      i = j;
    } while (this.f != 1);
    return 4;
    label54:
    if (this.jdField_c_of_type_Boolean) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof aflf)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(new aflj(this));
      }
      paramView = (aflf)localView.getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131369600, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(localView, paramInt);
      paramView = localView;
      continue;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof aflh)) {}
      }
      else
      {
        localView = a();
        localView.setOnClickListener(new aflk(this));
      }
      a((aflh)localView.getTag());
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561293, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131365187)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131563059, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      TextView localTextView = (TextView)localView.findViewById(2131366174);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Anxs.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720053);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720052);
      }
      localTextView.setText(paramView);
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131561292, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return !this.jdField_a_of_type_Boolean;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afli
 * JD-Core Version:    0.7.0.1
 */