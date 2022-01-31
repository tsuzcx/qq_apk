import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class afiv
  implements View.OnDragListener
{
  private int jdField_a_of_type_Int;
  
  public afiv(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
      continue;
      RelativeLayout localRelativeLayout = NearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel);
      int i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.indexOfChild(paramView);
      int j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.indexOfChild(localRelativeLayout);
      if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.jdField_a_of_type_Int / 2)) || ((i < j) && (paramDragEvent.getX() < this.jdField_a_of_type_Int / 2))))
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.removeView(localRelativeLayout);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.addView(localRelativeLayout, i);
          NearbyProfileEditTribePanel.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel);
        }
        catch (Exception paramView) {}
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
          continue;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.post(new afiw(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afiv
 * JD-Core Version:    0.7.0.1
 */