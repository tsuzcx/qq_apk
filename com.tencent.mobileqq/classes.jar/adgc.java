import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adgc
  implements View.OnClickListener
{
  public adgc(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691982);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_Arbl.a(true);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_Arbl.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.setTitle(String.format(this.a.getResources().getString(2131691981), new Object[] { Integer.valueOf(0) }));
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, ViewUtils.dip2px(44.0F));
      bcef.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.a.jdField_b_of_type_Int == 1) {
        bcef.b(this.a.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      }
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 1)) {
      for (;;)
      {
        this.a.a(this.a.jdField_b_of_type_Boolean);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bcef.b(this.a.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691980);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_Arbl.a(false);
    this.a.f();
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Arbl.notifyDataSetChanged();
    this.a.jdField_a_of_type_Arbl.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    if (this.a.jdField_b_of_type_Int == 2) {
      this.a.setTitle(2131691783);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, 0);
      break;
      this.a.setTitle(2131691989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgc
 * JD-Core Version:    0.7.0.1
 */