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

public class acgg
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected ased a;
  aubw jdField_a_of_type_Aubw;
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
  
  public acgg(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, aubw paramaubw, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = aciy.a(17.0F, paramContext);
    this.h = aciy.a(15.0F, paramContext);
    this.jdField_a_of_type_Aubw = paramaubw;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = aciy.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = aciy.a(86.0F, paramContext);
    this.d = aciy.a(60.0F, paramContext);
    this.jdField_a_of_type_Ased = ((ased)paramVisitorsActivity.app.getManager(207));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131493742, null);
    acgf localacgf = new acgf();
    localacgf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304782));
    localacgf.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131309309));
    localacgf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131303806));
    localView.setTag(localacgf);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131493614, paramViewGroup, false);
    acgd localacgd = new acgd();
    localacgd.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131311802));
    localacgd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302061));
    localacgd.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131313433));
    localacgd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131311221));
    localacgd.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131313715));
    localacgd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131303219));
    localacgd.d = ((TextView)paramViewGroup.findViewById(2131312587));
    localacgd.e = ((TextView)paramViewGroup.findViewById(2131299391));
    localacgd.f = ((TextView)paramViewGroup.findViewById(2131312590));
    localacgd.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303097));
    localacgd.g = ((TextView)paramViewGroup.findViewById(2131301190));
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131298088));
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131627099));
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localacgd.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new acgj(this, localacgd));
    paramViewGroup.findViewById(2131299097).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localacgd);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - aciy.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(acgd paramacgd, CardProfile paramCardProfile)
  {
    TextView localTextView = paramacgd.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramacgd.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramacgd.jdField_c_of_type_AndroidWidgetImageView.getTag(2131303097)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramacgd.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramacgd.jdField_b_of_type_Int = 0;
      paramacgd.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramacgd = ajjy.a(2131651030);; paramacgd = ajjy.a(2131651031))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramacgd, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramacgd.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramacgd.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramacgd.d.setText((CharSequence)localObject);
  }
  
  private void a(acgf paramacgf)
  {
    int j = 8;
    Object localObject = paramacgf.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131628336;
      ((TextView)localObject).setText(i);
      localObject = paramacgf.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramacgf = paramacgf.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramacgf.setVisibility(i);
      return;
      i = 2131628666;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, acgd paramacgd)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramacgd.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = baip.d(String.valueOf(paramObject.strNick));
    paramacgd.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramacgd.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramacgd.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840108;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramacgd.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844646);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramacgd.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_Ased.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841985);
      label214:
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramacgd, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramacgd.f.setText(paramObject.strTime);
      paramacgd.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramacgd.jdField_b_of_type_AndroidWidgetImageView, paramacgd.jdField_a_of_type_AndroidWidgetTextView);
      if (!ahcq.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramacgd.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramacgd.e.getLayoutParams();
      if (paramacgd.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramacgd.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramacgd.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramacgd.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramacgd.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840113;
      break label84;
      label397:
      paramacgd.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844655);
      break label111;
      label410:
      paramacgd.jdField_c_of_type_AndroidWidgetTextView.setText(azyk.a(paramObject.bConstellation));
      paramacgd.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130844656);
      paramacgd.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841987);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramacgd.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844943);
        break label214;
      }
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844953);
      break label214;
      label493:
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844940);
      break label214;
      label506:
      paramacgd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramacgd.f.setVisibility(8);
      break label260;
      label530:
      paramacgd.g.setVisibility(8);
      break label298;
      label542:
      if (paramacgd.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramacgd.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
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
        if ((paramView.getTag() instanceof acgd)) {}
      }
      else
      {
        localObject = a(paramViewGroup);
        ((View)localObject).setOnClickListener(new acgh(this));
      }
      paramView = (acgd)((View)localObject).getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131303097, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a((View)localObject, paramInt);
      paramView = (View)localObject;
      continue;
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof acgf)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(new acgi(this));
      }
      a((acgf)paramViewGroup.getTag());
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495330, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131299158)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131497010, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      Object localObject = (TextView)paramViewGroup.findViewById(2131300074);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Ajll.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131654944);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131654943);
      }
      ((TextView)localObject).setText(paramView);
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131495329, null);
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
 * Qualified Name:     acgg
 * JD-Core Version:    0.7.0.1
 */