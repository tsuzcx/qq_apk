import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiuw
  implements View.OnClickListener
{
  public aiuw(Face2FaceAddContactFragment paramFace2FaceAddContactFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuw
 * JD-Core Version:    0.7.0.1
 */