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
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahur
  extends akis
  implements View.OnClickListener
{
  private ahus jdField_a_of_type_Ahus;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahur(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, ahus paramahus)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_Ahus = paramahus;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ahut paramahut, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramahut.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentRecommendTroopItem.name);
    paramahut.b.setText(paramRecentRecommendTroopItem.labelStr);
    paramahut.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131713660));
    paramahut.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramahut.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem = paramRecentRecommendTroopItem;
    paramahut.jdField_a_of_type_JavaLangString = paramRecentRecommendTroopItem.uin;
    paramahut.jdField_c_of_type_Int = 4;
    azqs.b(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.c)
    {
      paramahut.jdField_a_of_type_AndroidViewView.setContentDescription(paramRecentRecommendTroopItem.name + " " + paramRecentRecommendTroopItem.labelStr);
      paramahut.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecentRecommendTroopItem.name);
      paramahut.b.setContentDescription(paramRecentRecommendTroopItem.labelStr);
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
    if (paramView == null)
    {
      paramView = new ahut();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558898, null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371161));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131375729));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131375716));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375726));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365082));
      paramView.jdField_a_of_type_AndroidViewView = localView;
      ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.setOnClickListener(this);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      if (ahuu.a)
      {
        azqs.b(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
        ahuu.a = false;
      }
      a(paramViewGroup, a(paramInt));
      return localView;
      paramViewGroup = (ahut)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131375716: 
      paramView = ((ahut)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      localObject1 = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + paramView.uin + "&subsource_id=10019";
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinGroupTransitActivity.class);
      ((Intent)localObject2).putExtra("source_scheme", (String)localObject1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      azqs.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
      return;
    case 2131375872: 
      paramView = ((ahut)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem;
      localObject1 = new GroupInfo();
    }
    try
    {
      ((GroupInfo)localObject1).lCode = Long.valueOf(paramView.uin).longValue();
      ((GroupInfo)localObject1).strName = paramView.name;
      if (TextUtils.isEmpty(paramView.recommendReason)) {}
      for (((GroupInfo)localObject1).strIntro = paramView.intro;; ((GroupInfo)localObject1).strIntro = paramView.recommendReason)
      {
        ((GroupInfo)localObject1).iMemberCnt = paramView.memberNum;
        localObject2 = nau.a(paramView);
        if (localObject2 != null) {
          ((GroupInfo)localObject1).labels = ((ArrayList)localObject2);
        }
        ((GroupInfo)localObject1).strJoinSig = paramView.authSig;
        localObject1 = bcpx.a(108, (GroupInfo)localObject1, 10020, false);
        bcpx.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
        azqs.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
        return;
      }
      paramView = (ahut)paramView.getTag();
      this.jdField_a_of_type_JavaUtilList.remove(paramView.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem);
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ahus != null) {
        this.jdField_a_of_type_Ahus.a(paramView.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, this.jdField_a_of_type_JavaUtilList.size());
      }
      azqs.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.uin, paramView.jdField_a_of_type_ComTencentMobileqqTroopDataRecentRecommendTroopItem.recomAlgol, "", "");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahur
 * JD-Core Version:    0.7.0.1
 */