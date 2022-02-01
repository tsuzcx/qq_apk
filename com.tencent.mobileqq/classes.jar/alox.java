import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class alox
  extends alnv
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
  
  public void a(RecentItemRecommendTroopData paramRecentItemRecommendTroopData, alno paramalno)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemRecommendTroopData = paramRecentItemRecommendTroopData;
    if (paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title"))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a() + " " + this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131712090));
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentItemRecommendTroopData.mUser.displayName);
    QLog.d("RecentRecommendTroopItemBuilder", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
    QLog.i("RecentAdapter", 2, "faceDecoder getFaceDrawable uin: " + paramRecentItemRecommendTroopData.mUser.uin);
    if (paramalno == null)
    {
      paramalno = null;
      label225:
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramalno);
      if ((paramRecentItemRecommendTroopData.mUser == null) || (!(paramRecentItemRecommendTroopData.mUser.extraInfo instanceof RecentRecommendTroopItem))) {
        break label621;
      }
    }
    label312:
    label445:
    label609:
    label621:
    for (paramalno = (RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo;; paramalno = null)
    {
      if (paramalno == null)
      {
        QLog.d("RecentRecommendTroopIte", 1, "bindData, troopItem == null");
        return;
        paramalno = paramalno.a(paramRecentItemRecommendTroopData);
        break label225;
      }
      if (paramalno.activity > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramalno.activity);
        ArrayList localArrayList = nli.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
        if ((localArrayList == null) || (localArrayList.size() <= 0)) {
          break label523;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localArrayList);
        label366:
        if (!paramalno.isJoined()) {
          break label535;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131698508);
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bhtq.a(60.0F));
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bhtq.a(29.0F));
        this.jdField_a_of_type_AndroidWidgetButton.setPadding(0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        if (TextUtils.isEmpty(paramalno.intro)) {
          break label609;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new begp(paramalno.intro, 11, 16));
      }
      for (;;)
      {
        QLog.d("", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
        break;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
        break label312;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
        break label366;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131698506);
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
        this.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
        int i = bhtq.a(16.0F);
        this.jdField_a_of_type_AndroidWidgetButton.setPadding(i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
        break label445;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alox
 * JD-Core Version:    0.7.0.1
 */