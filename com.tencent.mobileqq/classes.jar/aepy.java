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

class aepy
  implements View.OnClickListener
{
  aepy(aepg paramaepg) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bcis == null) {}
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
          localObject = this.a.jdField_a_of_type_Bcis.a();
        } while (localObject == null);
        localHashMap = ((bcir)localObject).b();
        localObject = ((bcir)localObject).a();
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
        aepg.a(this.a).a(25);
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel == null) || (localObject == null));
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
      return;
      if (localHashMap != null) {
        this.a.p.setImageDrawable((Drawable)localHashMap.get("textIcon"));
      }
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
      this.a.l.setVisibility(0);
      this.a.aK();
      return;
    } while (paramView != this.a.q);
    if (aepg.b(this.a).a() != 3)
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
    this.a.aK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepy
 * JD-Core Version:    0.7.0.1
 */