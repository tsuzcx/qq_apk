import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.widget.XListView;

public class ahfq
  implements ahfg
{
  public ahfq(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.a.jdField_b_of_type_Boolean) && (AddContactViewPagerTroopFragment.a(this.a) != null)) {
      AddContactViewPagerTroopFragment.b(this.a).a(this.a.b(), paramBoolean, null);
    }
    if (paramBoolean)
    {
      if (paramInt <= 0) {
        break label73;
      }
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    label73:
    Object localObject;
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131689704);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131689710);
      this.a.c.setText(2131689705);
      this.a.c.setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.a.c.setOnClickListener(new ahfr(this));
      localObject = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    } while ((localObject == null) || (!(localObject instanceof ViewGroup)));
    ((ViewGroup)localObject).setBackgroundResource(2130839217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfq
 * JD-Core Version:    0.7.0.1
 */