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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SimpleTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class acqr
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected ataj a;
  avbe jdField_a_of_type_Avbe;
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
  
  public acqr(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, avbe paramavbe, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = actj.a(17.0F, paramContext);
    this.h = actj.a(15.0F, paramContext);
    this.jdField_a_of_type_Avbe = paramavbe;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = actj.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = actj.a(86.0F, paramContext);
    this.d = actj.a(60.0F, paramContext);
    this.jdField_a_of_type_Ataj = ((ataj)paramVisitorsActivity.app.getManager(207));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559314, null);
    acqq localacqq = new acqq();
    localacqq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370442));
    localacqq.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131375056));
    localacqq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369480));
    localView.setTag(localacqq);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559184, paramViewGroup, false);
    acqo localacqo = new acqo();
    localacqo.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131377617));
    localacqo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367679));
    localacqo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131379272));
    localacqo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377033));
    localacqo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379555));
    localacqo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368885));
    localacqo.d = ((TextView)paramViewGroup.findViewById(2131378416));
    localacqo.e = ((TextView)paramViewGroup.findViewById(2131364956));
    localacqo.f = ((TextView)paramViewGroup.findViewById(2131378419));
    localacqo.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368737));
    localacqo.g = ((TextView)paramViewGroup.findViewById(2131366800));
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131363639));
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692738));
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localacqo.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new acqu(this, localacqo));
    paramViewGroup.findViewById(2131364656).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localacqo);
    return paramViewGroup;
  }
  
  private void a()
  {
    Rect localRect;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int == 0)
    {
      localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() != 0)) {
        break label140;
      }
    }
    label140:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c;; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView)
    {
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i = localRect.bottom;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "init empty h " + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - actj.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(acqo paramacqo, CardProfile paramCardProfile)
  {
    TextView localTextView = paramacqo.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramacqo.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramacqo.jdField_c_of_type_AndroidWidgetImageView.getTag(2131368737)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramacqo.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramacqo.jdField_b_of_type_Int = 0;
      paramacqo.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramacqo = ajya.a(2131716832);; paramacqo = ajya.a(2131716833))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramacqo, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramacqo.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramacqo.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramacqo.d.setText((CharSequence)localObject);
  }
  
  private void a(acqq paramacqq)
  {
    int j = 8;
    Object localObject = paramacqq.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693978;
      ((TextView)localObject).setText(i);
      localObject = paramacqq.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramacqq = paramacqq.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramacqq.setVisibility(i);
      return;
      i = 2131694319;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, acqo paramacqo)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramacqo.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = bbkk.d(String.valueOf(paramObject.strNick));
    paramacqo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramacqo.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramacqo.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840154;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramacqo.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844728);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramacqo.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_Ataj.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842078);
      label214:
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramacqo, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramacqo.f.setText(paramObject.strTime);
      paramacqo.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramacqo.jdField_b_of_type_AndroidWidgetImageView, paramacqo.jdField_a_of_type_AndroidWidgetTextView);
      if (!ahpd.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramacqo.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramacqo.e.getLayoutParams();
      if (paramacqo.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramacqo.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramacqo.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramacqo.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramacqo.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840159;
      break label84;
      label397:
      paramacqo.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844737);
      break label111;
      label410:
      paramacqo.jdField_c_of_type_AndroidWidgetTextView.setText(bbac.a(paramObject.bConstellation));
      paramacqo.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130844738);
      paramacqo.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842080);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramacqo.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845031);
        break label214;
      }
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845041);
      break label214;
      label493:
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845028);
      break label214;
      label506:
      paramacqo.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramacqo.f.setVisibility(8);
      break label260;
      label530:
      paramacqo.g.setVisibility(8);
      break label298;
      label542:
      if (paramacqo.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacqo.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
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
      return paramView;
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      if (paramView != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof acqo)) {}
      }
      else
      {
        localObject = a(paramViewGroup);
        ((View)localObject).setOnClickListener(new acqs(this));
      }
      paramView = (acqo)((View)localObject).getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131368737, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a((View)localObject, paramInt);
      paramView = (View)localObject;
      continue;
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof acqq)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(new acqt(this));
      }
      a((acqq)paramViewGroup.getTag());
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560907, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131364718)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131562606, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      Object localObject = (TextView)paramViewGroup.findViewById(2131365670);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Ajzq.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720853);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131720852);
      }
      ((TextView)localObject).setText(paramView);
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131560906, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */