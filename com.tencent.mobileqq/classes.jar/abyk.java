import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.util.HashMap;

public class abyk
  implements aubp<bdpd>
{
  public abyk(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(bdpd parambdpd)
  {
    if (parambdpd.jdField_a_of_type_Int == AddFriendVerifyActivity.a(this.a).a())
    {
      Object localObject = (Bitmap)parambdpd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131379485));
      AddFriendVerifyActivity.b(this.a).setVisibility(0);
      AddFriendVerifyActivity.b(this.a).setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parambdpd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131379480));
      localObject = bdse.a(this.a.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.a).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.a).setTextColor(parambdpd.b);
      AddFriendVerifyActivity.a(this.a).setTextColor(parambdpd.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyk
 * JD-Core Version:    0.7.0.1
 */