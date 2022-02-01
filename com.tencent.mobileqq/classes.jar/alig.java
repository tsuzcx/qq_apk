import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class alig
  extends alhf
{
  public Button a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public RecentItemRecommendTroopData a;
  TroopActiveLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
  TroopLabelLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  public FolderTextView a;
  public SingleLineTextView a;
  public ThemeImageView a;
  public TextView b;
  
  public void a(RecentItemRecommendTroopData paramRecentItemRecommendTroopData, algy paramalgy)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemRecommendTroopData = paramRecentItemRecommendTroopData;
    if (paramRecentItemRecommendTroopData.mUser != null) {}
    label534:
    label546:
    for (boolean bool = paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title");; bool = true)
    {
      if (bool)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (AppSetting.c)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText() + " " + this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
          this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131712669));
        }
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (paramRecentItemRecommendTroopData.mUser != null)
      {
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentItemRecommendTroopData.mUser.displayName);
        QLog.d("RecentRecommendTroopItemBuilder", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
        QLog.i("RecentAdapter", 2, "faceDecoder getFaceDrawable uin: " + paramRecentItemRecommendTroopData.mUser.uin);
        if (paramalgy == null)
        {
          paramalgy = null;
          label243:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramalgy);
          if (!(paramRecentItemRecommendTroopData.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
            break label632;
          }
        }
      }
      label323:
      label456:
      label620:
      label632:
      for (paramalgy = (RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo;; paramalgy = null)
      {
        if (paramalgy == null)
        {
          QLog.d("RecentRecommendTroopIte", 1, "bindData, troopItem == null");
          return;
          paramalgy = paramalgy.a(paramRecentItemRecommendTroopData);
          break label243;
        }
        if (paramalgy.activity > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramalgy.activity);
          ArrayList localArrayList = ntx.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label534;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localArrayList);
          label377:
          if (!paramalgy.isJoined()) {
            break label546;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131699038);
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.dip2px(60.0F));
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.dip2px(29.0F));
          this.jdField_a_of_type_AndroidWidgetButton.setPadding(0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
          if (TextUtils.isEmpty(paramalgy.intro)) {
            break label620;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramalgy.intro, 11, 16));
        }
        for (;;)
        {
          QLog.d("", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
          break;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
          break label323;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
          break label377;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131699036);
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
          this.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
          int i = ViewUtils.dip2px(16.0F);
          this.jdField_a_of_type_AndroidWidgetButton.setPadding(i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
          break label456;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alig
 * JD-Core Version:    0.7.0.1
 */