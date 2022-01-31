import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQBlurView;

public class acwl
  implements View.OnClickListener
{
  public acwl(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692332);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_Apoy.a(true);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_Apoy.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.setTitle(String.format(this.a.getResources().getString(2131692331), new Object[] { Integer.valueOf(0) }));
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, bdoo.a(44.0F));
      azqs.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.a.jdField_b_of_type_Int == 1) {
        azqs.b(this.a.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      }
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 1)) {
      for (;;)
      {
        this.a.a(this.a.jdField_b_of_type_Boolean);
        return;
        azqs.b(this.a.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692330);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_Apoy.a(false);
    this.a.f();
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Apoy.notifyDataSetChanged();
    this.a.jdField_a_of_type_Apoy.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    if (this.a.jdField_b_of_type_Int == 2) {
      this.a.setTitle(2131692094);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, 0);
      break;
      this.a.setTitle(2131692341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwl
 * JD-Core Version:    0.7.0.1
 */