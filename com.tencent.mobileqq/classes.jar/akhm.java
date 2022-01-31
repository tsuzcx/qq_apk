import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class akhm
  extends TroopGiftCallback
{
  public akhm(ProfileCardMoreInfoView paramProfileCardMoreInfoView, View paramView, TextView paramTextView, ImageView paramImageView) {}
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("礼物积分 %d分", new Object[] { Long.valueOf(paramLong) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a("map_key_troop_mem_gift_entry", null, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("礼物积分");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akhm
 * JD-Core Version:    0.7.0.1
 */