import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;

public class agod
  extends RecyclerView.ItemDecoration
{
  private final int jdField_a_of_type_Int = (int)(3.0F * PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
  
  private agod(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agod
 * JD-Core Version:    0.7.0.1
 */