import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.util.HashMap;

public class accz
  implements aufy<bdtm>
{
  public accz(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(bdtm parambdtm)
  {
    if (parambdtm.jdField_a_of_type_Int == AddFriendVerifyActivity.a(this.a).a())
    {
      Object localObject = (Bitmap)parambdtm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131379543));
      AddFriendVerifyActivity.b(this.a).setVisibility(0);
      AddFriendVerifyActivity.b(this.a).setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parambdtm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131379538));
      localObject = bdwn.a(this.a.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.a).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.a).setTextColor(parambdtm.b);
      AddFriendVerifyActivity.a(this.a).setTextColor(parambdtm.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accz
 * JD-Core Version:    0.7.0.1
 */