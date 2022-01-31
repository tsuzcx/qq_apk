import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;

class afyh
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  afyh(afyg paramafyg) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    paramView = (MessageForQQStoryComment)((aeqi)aepi.a(paramView)).a;
    if (xpq.a(paramView.vid))
    {
      vod.a(this.jdField_a_of_type_Afyg.a, paramView.vid, "CommentItemBuilder_Feed_Id", 1004);
      wxj.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    vod.b((Activity)this.jdField_a_of_type_Afyg.a, paramView.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyh
 * JD-Core Version:    0.7.0.1
 */