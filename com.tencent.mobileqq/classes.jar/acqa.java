import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.util.HashMap;

public class acqa
  implements avtb<bgfe>
{
  public acqa(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(bgfe parambgfe)
  {
    if (parambgfe.jdField_a_of_type_Int == AddFriendVerifyActivity.a(this.a).a())
    {
      Object localObject = (Bitmap)parambgfe.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131380390));
      AddFriendVerifyActivity.b(this.a).setVisibility(0);
      AddFriendVerifyActivity.b(this.a).setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parambgfe.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131380385));
      localObject = bgiy.a(this.a.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.a).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.a).setTextColor(parambgfe.b);
      AddFriendVerifyActivity.a(this.a).setTextColor(parambgfe.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqa
 * JD-Core Version:    0.7.0.1
 */