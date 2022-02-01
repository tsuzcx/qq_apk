import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiuu
  implements View.OnClickListener
{
  public aiuu(Face2FaceAddContactFragment paramFace2FaceAddContactFragment) {}
  
  public void onClick(View paramView)
  {
    int i = Face2FaceAddContactFragment.a(this.a).length();
    if (i >= 4) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Face2FaceAddContactFragment.a(this.a, paramView, i);
      i = Face2FaceAddContactFragment.a(this.a).length();
      Face2FaceAddContactFragment.a(this.a, i);
      Face2FaceAddContactFragment.b(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuu
 * JD-Core Version:    0.7.0.1
 */