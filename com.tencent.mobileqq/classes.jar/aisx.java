import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;

public class aisx
  implements View.OnClickListener
{
  public aisx(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.a(this.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().app, "dc00899", "Grp_tribe", "", "post", "save_video", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisx
 * JD-Core Version:    0.7.0.1
 */