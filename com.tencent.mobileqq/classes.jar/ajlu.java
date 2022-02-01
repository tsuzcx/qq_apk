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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajlu
  extends amck
  implements View.OnClickListener
{
  private ajlv jdField_a_of_type_Ajlv;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ajlu(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, ajlv paramajlv)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_Ajlv = paramajlv;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ajlw paramajlw, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramajlw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentRecommendTroopItem.name);
    paramajlw.b.setText(paramRecentRecommendTroopItem.labelStr);
    paramajlw.jdField_a_of_type_AndroidWidgetButton.setText(anni.a(2131712039));
    paramajlw.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramajlw.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem = paramRecentRecommendTroopItem;
    paramajlw.jdField_a_of_type_JavaLangString = paramRecentRecommendTroopItem.uin;
    paramajlw.jdField_c_of_type_Int = 4;
    bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.c)
    {
      paramajlw.jdField_a_of_type_AndroidViewView.setContentDescription(paramRecentRecommendTroopItem.name + " " + paramRecentRecommendTroopItem.labelStr);
      paramajlw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecentRecommendTroopItem.name);
      paramajlw.b.setContentDescription(paramRecentRecommendTroopItem.labelStr);
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
      paramView = new ajlw();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558965, null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371720));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131376456));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376443));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376453));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365319));
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
      if (ajlx.a)
      {
        bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
        ajlx.a = false;
      }
      a((ajlw)localObject, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ajlw)paramView.getTag();
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
      Object localObject1 = ((ajlw)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      Object localObject2 = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + ((RecentRecommendTroopItem)localObject1).uin + "&subsource_id=10019";
      Object localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinGroupTransitActivity.class);
      ((Intent)localObject3).putExtra("source_scheme", (String)localObject2);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
      continue;
      localObject1 = ((ajlw)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      localObject2 = new GroupInfo();
      try
      {
        ((GroupInfo)localObject2).lCode = Long.valueOf(((RecentRecommendTroopItem)localObject1).uin).longValue();
        ((GroupInfo)localObject2).strName = ((RecentRecommendTroopItem)localObject1).name;
        if (TextUtils.isEmpty(((RecentRecommendTroopItem)localObject1).recommendReason)) {}
        for (((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).intro;; ((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).recommendReason)
        {
          ((GroupInfo)localObject2).iMemberCnt = ((RecentRecommendTroopItem)localObject1).memberNum;
          localObject3 = njn.a((RecommendTroopItem)localObject1);
          if (localObject3 != null) {
            ((GroupInfo)localObject2).labels = ((ArrayList)localObject3);
          }
          ((GroupInfo)localObject2).strJoinSig = ((RecentRecommendTroopItem)localObject1).authSig;
          localObject2 = bfup.a(108, (GroupInfo)localObject2, 10020, false);
          bfup.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, 2);
          bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
          break;
        }
        localObject1 = (ajlw)paramView.getTag();
        this.jdField_a_of_type_JavaUtilList.remove(((ajlw)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem);
        notifyDataSetChanged();
        if (this.jdField_a_of_type_Ajlv != null) {
          this.jdField_a_of_type_Ajlv.a(((ajlw)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, this.jdField_a_of_type_JavaUtilList.size());
        }
        bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, ((ajlw)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, ((ajlw)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.recomAlgol, "", "");
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlu
 * JD-Core Version:    0.7.0.1
 */