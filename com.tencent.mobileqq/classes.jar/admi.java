import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;

class admi
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  admi(admh paramadmh) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    paramView = (MessageForQQStoryComment)((acju)aciy.a(paramView)).a;
    if (vjw.a(paramView.vid))
    {
      tij.a(this.jdField_a_of_type_Admh.a, paramView.vid, "CommentItemBuilder_Feed_Id", 1004);
      urp.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    tij.b((Activity)this.jdField_a_of_type_Admh.a, paramView.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admi
 * JD-Core Version:    0.7.0.1
 */