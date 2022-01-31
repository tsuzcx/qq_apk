import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;

class afts
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  afts(aftr paramaftr) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    paramView = (MessageForQQStoryComment)((aelt)aekt.a(paramView)).a;
    if (xlh.a(paramView.vid))
    {
      vju.a(this.jdField_a_of_type_Aftr.a, paramView.vid, "CommentItemBuilder_Feed_Id", 1004);
      wta.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    vju.b((Activity)this.jdField_a_of_type_Aftr.a, paramView.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afts
 * JD-Core Version:    0.7.0.1
 */