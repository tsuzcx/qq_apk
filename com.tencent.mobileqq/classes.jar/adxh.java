import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;

class adxh
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  adxh(adxg paramadxg) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    paramView = (MessageForQQStoryComment)((acun)actn.a(paramView)).a;
    if (vws.a(paramView.vid))
    {
      tvf.a(this.jdField_a_of_type_Adxg.a, paramView.vid, "CommentItemBuilder_Feed_Id", 1004);
      vel.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    tvf.b((Activity)this.jdField_a_of_type_Adxg.a, paramView.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxh
 * JD-Core Version:    0.7.0.1
 */