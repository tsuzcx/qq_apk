import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class aagd
  extends aabp<CertifiedAccountMeta.StFollowRcmd>
{
  public static int a;
  public static String a;
  private boolean a;
  private int jdField_b_of_type_Int = ImmersiveUtils.a(20.0F);
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = ImmersiveUtils.a(12.5F);
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BlankRecommendFeedsAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.a(12.0F);
  }
  
  public aagd(Bundle paramBundle)
  {
    super(paramBundle);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131558761, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131369351);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localURLImageView.setColorFilter(-1728053248);
      ((TextView)paramViewGroup.findViewById(2131380215)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131365642).setBackgroundColor(-14540254);
      return paramViewGroup;
    }
    localURLImageView.clearColorFilter();
    return paramViewGroup;
  }
  
  private View b(ViewGroup paramViewGroup)
  {
    abbe.b("auth_follow", "exp_more", 0, 0, new String[0]);
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131558760, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131370228);
    GradientDrawable localGradientDrawable;
    if (localLinearLayout != null)
    {
      localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      if (!this.jdField_c_of_type_Boolean) {
        break label102;
      }
    }
    label102:
    for (int i = -13224394;; i = -460552)
    {
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new aage(this));
      if (this.jdField_c_of_type_Boolean) {
        ((TextView)paramViewGroup.findViewById(2131380214)).setTextColor(-5723992);
      }
      return paramViewGroup;
    }
  }
  
  public COMM.StCommonExt a()
  {
    if (getLoadInfo().a() != null) {
      return getLoadInfo().a();
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void clearData()
  {
    super.clearData();
    this.e = false;
  }
  
  public int getItemCount()
  {
    int j = this.mDataList.size();
    if (!this.e)
    {
      if (j > 0)
      {
        int i = j;
        if (this.jdField_a_of_type_Boolean) {
          i = j + 1;
        }
        j = i;
        if (this.jdField_b_of_type_Boolean) {
          j = i + 1;
        }
        return j;
      }
      return 0;
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.jdField_b_of_type_Int;
      paramRect.left = jdField_a_of_type_Int;
      paramRect.right = jdField_a_of_type_Int;
      paramRect.bottom = this.jdField_c_of_type_Int;
    }
    while (paramView.getId() != 2131376941) {
      return;
    }
    paramRect.top = ImmersiveUtils.a(19.5F);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = (-ImmersiveUtils.a(30.0F));
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (!blgn.a(i, getDataList())) {
      return 100002;
    }
    return 100001;
  }
  
  public int getSpanCount(int paramInt)
  {
    return 1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (blgn.a(i, getDataList())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
      return;
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)getDataList().get(i);
      ((aagf)paramViewHolder).a(localStFollowRcmd, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new aagf(this, a(paramViewGroup));
    }
    if (paramInt == 100001) {
      return new aagf(this, b(paramViewGroup));
    }
    paramViewGroup = new BlankRecommendItemView(paramViewGroup.getContext());
    paramViewGroup.setIsInNightMode(this.jdField_c_of_type_Boolean);
    return new aagf(this, paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagd
 * JD-Core Version:    0.7.0.1
 */