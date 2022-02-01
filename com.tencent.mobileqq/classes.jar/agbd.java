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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SimpleTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class agbd
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected axvr a;
  badb jdField_a_of_type_Badb;
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
  
  public agbd(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, badb parambadb, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = agej.a(17.0F, paramContext);
    this.h = agej.a(15.0F, paramContext);
    this.jdField_a_of_type_Badb = parambadb;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = agej.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = agej.a(86.0F, paramContext);
    this.d = agej.a(60.0F, paramContext);
    this.jdField_a_of_type_Axvr = ((axvr)paramVisitorsActivity.app.getManager(207));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559485, null);
    agbc localagbc = new agbc();
    localagbc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371433));
    localagbc.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376445));
    localagbc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370293));
    localView.setTag(localagbc);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559307, paramViewGroup, false);
    agba localagba = new agba();
    localagba.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131379232));
    localagba.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368212));
    localagba.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131381172));
    localagba.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378604));
    localagba.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131381550));
    localagba.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369615));
    localagba.d = ((TextView)paramViewGroup.findViewById(2131380191));
    localagba.e = ((TextView)paramViewGroup.findViewById(2131365326));
    localagba.f = ((TextView)paramViewGroup.findViewById(2131380194));
    localagba.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369446));
    localagba.g = ((TextView)paramViewGroup.findViewById(2131367248));
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131363921));
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692390));
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localagba.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new agbg(this, localagba));
    paramViewGroup.findViewById(2131365008).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localagba);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - agej.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(agba paramagba, CardProfile paramCardProfile)
  {
    TextView localTextView = paramagba.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramagba.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramagba.jdField_c_of_type_AndroidWidgetImageView.getTag(2131369446)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramagba.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramagba.jdField_b_of_type_Int = 0;
      paramagba.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramagba = anzj.a(2131715602);; paramagba = anzj.a(2131715603))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramagba, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramagba.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramagba.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramagba.d.setText((CharSequence)localObject);
  }
  
  private void a(agbc paramagbc)
  {
    int j = 8;
    Object localObject = paramagbc.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693403;
      ((TextView)localObject).setText(i);
      localObject = paramagbc.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramagbc = paramagbc.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramagbc.setVisibility(i);
      return;
      i = 2131693764;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, agba paramagba)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramagba.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = bhsr.d(String.valueOf(paramObject.strNick));
    paramagba.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramagba.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramagba.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840449;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramagba.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845575);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramagba.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_Axvr.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842567);
      label214:
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramagba, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramagba.f.setText(paramObject.strTime);
      paramagba.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramagba.jdField_b_of_type_AndroidWidgetImageView, paramagba.jdField_a_of_type_AndroidWidgetTextView);
      if (!alpb.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramagba.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramagba.e.getLayoutParams();
      if (paramagba.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramagba.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramagba.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramagba.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramagba.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840454;
      break label84;
      label397:
      paramagba.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845584);
      break label111;
      label410:
      paramagba.jdField_c_of_type_AndroidWidgetTextView.setText(bhhz.a(paramObject.bConstellation));
      paramagba.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845585);
      paramagba.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842569);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramagba.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845880);
        break label214;
      }
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845890);
      break label214;
      label493:
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845877);
      break label214;
      label506:
      paramagba.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramagba.f.setVisibility(8);
      break label260;
      label530:
      paramagba.g.setVisibility(8);
      break label298;
      label542:
      if (paramagba.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramagba.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
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
        if ((paramView.getTag() instanceof agba)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(new agbe(this));
      }
      paramView = (agba)localView.getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131369446, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(localView, paramInt);
      paramView = localView;
      continue;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof agbc)) {}
      }
      else
      {
        localView = a();
        localView.setOnClickListener(new agbf(this));
      }
      a((agbc)localView.getTag());
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561357, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131365075)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131563101, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      TextView localTextView = (TextView)localView.findViewById(2131366043);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Aobc.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131719282);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131719281);
      }
      localTextView.setText(paramView);
      paramView = localView;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131561356, null);
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
 * Qualified Name:     agbd
 * JD-Core Version:    0.7.0.1
 */