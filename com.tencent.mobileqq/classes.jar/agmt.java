import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

class agmt
  implements View.OnClickListener
{
  agmt(agmb paramagmb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Beih == null) {}
    HashMap localHashMap;
    label229:
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = this.a.jdField_a_of_type_Beih.a();
        } while (localObject == null);
        localHashMap = ((beig)localObject).b();
        localObject = ((beig)localObject).a();
        if (paramView != this.a.p) {
          break label229;
        }
        if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
          break;
        }
        if (localHashMap != null) {
          this.a.p.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
        }
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
        this.a.l.setVisibility(4);
        agmb.a(this.a).a(25);
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel == null) || (localObject == null));
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
      return;
      if (localHashMap != null) {
        this.a.p.setImageDrawable((Drawable)localHashMap.get("textIcon"));
      }
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
      this.a.l.setVisibility(0);
      this.a.aM();
      return;
    } while (paramView != this.a.q);
    if (agmb.b(this.a).a() != 3)
    {
      this.a.a(Integer.valueOf(3));
      if (localHashMap != null) {
        this.a.p.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
      }
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
      this.a.l.setVisibility(4);
      return;
    }
    this.a.aM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmt
 * JD-Core Version:    0.7.0.1
 */