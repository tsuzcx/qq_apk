import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

class aibn
  implements View.OnClickListener
{
  aibn(aiav paramaiav) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bilj == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.a.jdField_a_of_type_Bilj.a();
      if (localObject != null)
      {
        HashMap localHashMap = ((bili)localObject).b();
        localObject = ((bili)localObject).a();
        if (paramView == this.a.jdField_a_of_type_AndroidWidgetImageView)
        {
          if (this.a.input.getVisibility() != 0)
          {
            if (localHashMap != null) {
              this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.input.setVisibility(0);
            this.a.mFunBtn.setVisibility(0);
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            aiav.a(this.a).a(25);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) && (localObject != null)) {
              this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
            }
          }
          else
          {
            if (localHashMap != null) {
              this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("textIcon"));
            }
            this.a.input.setVisibility(4);
            this.a.mFunBtn.setVisibility(4);
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.a.hideAllPanels();
          }
        }
        else if (paramView == this.a.b) {
          if (aiav.b(this.a).a() != 3)
          {
            this.a.onPanelIconClick(Integer.valueOf(3));
            if (localHashMap != null) {
              this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.input.setVisibility(0);
            this.a.mFunBtn.setVisibility(0);
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          }
          else
          {
            this.a.hideAllPanels();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibn
 * JD-Core Version:    0.7.0.1
 */