import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.util.HashMap;

public class adki
  implements awnc<bgyp>
{
  public adki(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(bgyp parambgyp)
  {
    if (parambgyp.jdField_a_of_type_Int == AddFriendVerifyActivity.a(this.a).a())
    {
      Object localObject = (Bitmap)parambgyp.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131380478));
      AddFriendVerifyActivity.b(this.a).setVisibility(0);
      AddFriendVerifyActivity.b(this.a).setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parambgyp.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131380473));
      localObject = bhcb.a(this.a.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.a).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.a).setTextColor(parambgyp.b);
      AddFriendVerifyActivity.a(this.a).setTextColor(parambgyp.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adki
 * JD-Core Version:    0.7.0.1
 */