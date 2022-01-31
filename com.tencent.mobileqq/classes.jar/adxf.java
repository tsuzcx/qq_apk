import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;

class adxf
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  adxf(adxe paramadxe) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    paramView = (MessageForQQStoryComment)((acuj)actj.a(paramView)).a;
    if (vwp.a(paramView.vid))
    {
      tvc.a(this.jdField_a_of_type_Adxe.a, paramView.vid, "CommentItemBuilder_Feed_Id", 1004);
      vei.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    tvc.b((Activity)this.jdField_a_of_type_Adxe.a, paramView.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxf
 * JD-Core Version:    0.7.0.1
 */