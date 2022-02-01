import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.widget.QQToast;

public class aiuc
  extends Handler
{
  public aiuc(Face2FaceAddContactFragment paramFace2FaceAddContactFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5)
    {
      Face2FaceAddContactFragment.a(this.a).setText(2131691964);
      Face2FaceAddContactFragment.a(this.a).setVisibility(8);
      Face2FaceAddContactFragment.a(this.a).setVisibility(0);
    }
    do
    {
      return;
      if (paramMessage.what == 301)
      {
        Face2FaceAddContactFragment.a(this.a);
        return;
      }
      if (paramMessage.what == 500)
      {
        Face2FaceAddContactFragment.b(this.a);
        return;
      }
      if (paramMessage.what == 401)
      {
        removeMessages(301);
        this.a.d();
        return;
      }
    } while (paramMessage.what != 6);
    Face2FaceAddContactFragment.c(this.a);
    QQToast.a(this.a.getActivity(), this.a.getString(2131690896), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuc
 * JD-Core Version:    0.7.0.1
 */