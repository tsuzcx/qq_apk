import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;

public class ahjm
  implements View.OnClickListener
{
  public ahjm(Face2FaceAddContactFragment paramFace2FaceAddContactFragment) {}
  
  public void onClick(View paramView)
  {
    int i = Face2FaceAddContactFragment.a(this.a).length();
    if (i >= 4) {
      return;
    }
    Face2FaceAddContactFragment.a(this.a, paramView, i);
    i = Face2FaceAddContactFragment.a(this.a).length();
    Face2FaceAddContactFragment.a(this.a, i);
    Face2FaceAddContactFragment.b(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjm
 * JD-Core Version:    0.7.0.1
 */