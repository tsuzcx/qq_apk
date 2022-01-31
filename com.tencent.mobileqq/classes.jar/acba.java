import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class acba
  implements DialogInterface.OnClickListener
{
  public acba(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a = false;
    this.a.l = false;
    this.a.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acba
 * JD-Core Version:    0.7.0.1
 */