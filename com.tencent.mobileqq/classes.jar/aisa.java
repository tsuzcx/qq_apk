import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aisa
  extends aliy
  implements View.OnClickListener
{
  private aisb jdField_a_of_type_Aisb;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aisa(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, aisb paramaisb)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_Aisb = paramaisb;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(aisc paramaisc, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramaisc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentRecommendTroopItem.name);
    paramaisc.b.setText(paramRecentRecommendTroopItem.labelStr);
    paramaisc.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131712380));
    paramaisc.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramaisc.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem = paramRecentRecommendTroopItem;
    paramaisc.jdField_a_of_type_JavaLangString = paramRecentRecommendTroopItem.uin;
    paramaisc.jdField_c_of_type_Int = 4;
    bcef.b(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.c)
    {
      paramaisc.jdField_a_of_type_AndroidViewView.setContentDescription(paramRecentRecommendTroopItem.name + " " + paramRecentRecommendTroopItem.labelStr);
      paramaisc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecentRecommendTroopItem.name);
      paramaisc.b.setContentDescription(paramRecentRecommendTroopItem.labelStr);
    }
  }
  
  public RecentRecommendTroopItem a(int paramInt)
  {
    return (RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    super.c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<RecentRecommendTroopItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((RecentRecommendTroopItem)localIterator.next()).uin.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new aisc();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558972, null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371791));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131376354));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376341));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376351));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365396));
      paramView.jdField_a_of_type_AndroidViewView = localView;
      ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.setOnClickListener(this);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      if (aisd.a)
      {
        bcef.b(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
        aisd.a = false;
      }
      a((aisc)localObject, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aisc)paramView.getTag();
      localView = paramView;
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
      Object localObject1 = ((aisc)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      Object localObject2 = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + ((RecentRecommendTroopItem)localObject1).uin + "&subsource_id=10019";
      Object localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinGroupTransitActivity.class);
      ((Intent)localObject3).putExtra("source_scheme", (String)localObject2);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      bcef.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
      continue;
      localObject1 = ((aisc)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      localObject2 = new GroupInfo();
      try
      {
        ((GroupInfo)localObject2).lCode = Long.valueOf(((RecentRecommendTroopItem)localObject1).uin).longValue();
        ((GroupInfo)localObject2).strName = ((RecentRecommendTroopItem)localObject1).name;
        if (TextUtils.isEmpty(((RecentRecommendTroopItem)localObject1).recommendReason)) {}
        for (((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).intro;; ((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).recommendReason)
        {
          ((GroupInfo)localObject2).iMemberCnt = ((RecentRecommendTroopItem)localObject1).memberNum;
          localObject3 = nmx.a((RecommendTroopItem)localObject1);
          if (localObject3 != null) {
            ((GroupInfo)localObject2).labels = ((ArrayList)localObject3);
          }
          ((GroupInfo)localObject2).strJoinSig = ((RecentRecommendTroopItem)localObject1).authSig;
          localObject2 = TroopUtils.getTroopProfileExtra(108, (GroupInfo)localObject2, 10020, false);
          TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, 2);
          bcef.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
          break;
        }
        localObject1 = (aisc)paramView.getTag();
        this.jdField_a_of_type_JavaUtilList.remove(((aisc)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem);
        notifyDataSetChanged();
        if (this.jdField_a_of_type_Aisb != null) {
          this.jdField_a_of_type_Aisb.a(((aisc)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, this.jdField_a_of_type_JavaUtilList.size());
        }
        bcef.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, ((aisc)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, ((aisc)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.recomAlgol, "", "");
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisa
 * JD-Core Version:    0.7.0.1
 */