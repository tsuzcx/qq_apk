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

public class aeib
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected auri a;
  awsr jdField_a_of_type_Awsr;
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
  
  public aeib(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, awsr paramawsr, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = aekt.a(17.0F, paramContext);
    this.h = aekt.a(15.0F, paramContext);
    this.jdField_a_of_type_Awsr = paramawsr;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = aekt.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = aekt.a(86.0F, paramContext);
    this.d = aekt.a(60.0F, paramContext);
    this.jdField_a_of_type_Auri = ((auri)paramVisitorsActivity.app.getManager(207));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559365, null);
    aeia localaeia = new aeia();
    localaeia.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370748));
    localaeia.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131375537));
    localaeia.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369742));
    localView.setTag(localaeia);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131559227, paramViewGroup, false);
    aehy localaehy = new aehy();
    localaehy.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131378159));
    localaehy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367808));
    localaehy.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131379973));
    localaehy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377553));
    localaehy.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380298));
    localaehy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369115));
    localaehy.d = ((TextView)paramViewGroup.findViewById(2131379028));
    localaehy.e = ((TextView)paramViewGroup.findViewById(2131365043));
    localaehy.f = ((TextView)paramViewGroup.findViewById(2131379031));
    localaehy.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368954));
    localaehy.g = ((TextView)paramViewGroup.findViewById(2131366919));
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramViewGroup.findViewById(2131363692));
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(17);
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131692820));
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 16.0F);
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(-1);
    localaehy.jdField_a_of_type_ComTencentWidgetSimpleTextView.setOnClickListener(new aeie(this, localaehy));
    paramViewGroup.findViewById(2131364735).getLayoutParams().width = VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
    paramViewGroup.setTag(localaehy);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - aekt.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(aehy paramaehy, CardProfile paramCardProfile)
  {
    TextView localTextView = paramaehy.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramaehy.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramaehy.jdField_c_of_type_AndroidWidgetImageView.getTag(2131368954)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramaehy.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label219;
      }
      paramaehy.jdField_b_of_type_Int = 0;
      paramaehy.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label209;
      }
    }
    label209:
    for (paramaehy = alpo.a(2131717204);; paramaehy = alpo.a(2131717205))
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramaehy, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramaehy.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label219:
    paramaehy.jdField_b_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramaehy.d.setText((CharSequence)localObject);
  }
  
  private void a(aeia paramaeia)
  {
    int j = 8;
    Object localObject = paramaeia.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131694094;
      ((TextView)localObject).setText(i);
      localObject = paramaeia.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramaeia = paramaeia.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramaeia.setVisibility(i);
      return;
      i = 2131694476;
      break;
      i = 8;
      break label41;
    }
  }
  
  private void a(Object paramObject, aehy paramaehy)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramaehy.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = bdje.d(String.valueOf(paramObject.strNick));
    paramaehy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramaehy.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramaehy.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130840257;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramaehy.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845092);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramaehy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramObject, str);
      if ((i != 0) && (i != 2)) {
        break label506;
      }
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label493;
      }
      if (!this.jdField_a_of_type_Auri.c(paramObject.lEctID)) {
        break label458;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label445;
      }
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842231);
      label214:
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramaehy, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label518;
      }
      paramaehy.f.setText(paramObject.strTime);
      paramaehy.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramaehy.jdField_b_of_type_AndroidWidgetImageView, paramaehy.jdField_a_of_type_AndroidWidgetTextView);
      if (!ajgm.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label530;
      }
      paramaehy.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramaehy.e.getLayoutParams();
      if (paramaehy.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label542;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramaehy.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramaehy.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramaehy.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramaehy.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130840262;
      break label84;
      label397:
      paramaehy.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845101);
      break label111;
      label410:
      paramaehy.jdField_c_of_type_AndroidWidgetTextView.setText(bcyw.a(paramObject.bConstellation));
      paramaehy.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845102);
      paramaehy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842233);
      break label214;
      label458:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramaehy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845396);
        break label214;
      }
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845406);
      break label214;
      label493:
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845393);
      break label214;
      label506:
      paramaehy.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label518:
      paramaehy.f.setVisibility(8);
      break label260;
      label530:
      paramaehy.g.setVisibility(8);
      break label298;
      label542:
      if (paramaehy.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramaehy.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
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
        if ((paramView.getTag() instanceof aehy)) {}
      }
      else
      {
        localObject = a(paramViewGroup);
        ((View)localObject).setOnClickListener(new aeic(this));
      }
      paramView = (aehy)((View)localObject).getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131368954, Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_Int = paramInt;
      a(a(paramInt), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a((View)localObject, paramInt);
      paramView = (View)localObject;
      continue;
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof aeia)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(new aeid(this));
      }
      a((aeia)paramViewGroup.getTag());
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561090, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131364797)).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131562811, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
      Object localObject = (TextView)paramViewGroup.findViewById(2131365754);
      LikeRankingInfo localLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Alre.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131721398);
      if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131721397);
      }
      ((TextView)localObject).setText(paramView);
      paramView = paramViewGroup;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2131561089, null);
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
 * Qualified Name:     aeib
 * JD-Core Version:    0.7.0.1
 */