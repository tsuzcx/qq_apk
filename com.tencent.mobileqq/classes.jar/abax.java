import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQBlurView;

public class abax
  implements View.OnClickListener
{
  public abax(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692255);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_Anth.a(true);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_Anth.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.setTitle(String.format(this.a.getResources().getString(2131692254), new Object[] { Integer.valueOf(0) }));
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, bbll.a(44.0F));
      axqy.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.a.jdField_b_of_type_Int == 1) {
        axqy.b(this.a.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      }
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 1)) {
      for (;;)
      {
        this.a.a(this.a.jdField_b_of_type_Boolean);
        return;
        axqy.b(this.a.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692253);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_Anth.a(false);
    this.a.f();
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Anth.notifyDataSetChanged();
    this.a.jdField_a_of_type_Anth.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    if (this.a.jdField_b_of_type_Int == 2) {
      this.a.setTitle(2131692038);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, 0);
      break;
      this.a.setTitle(2131692264);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abax
 * JD-Core Version:    0.7.0.1
 */