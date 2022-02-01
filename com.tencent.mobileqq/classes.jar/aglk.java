import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aglk
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  aglk(aglj paramaglj) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((aezf)AIOUtils.getHolder(paramView)).a;
      if (yns.a(localMessageForQQStoryComment.vid))
      {
        wmu.a(this.jdField_a_of_type_Aglj.a, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id", 1004);
        xwa.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      }
      else
      {
        wmu.b((Activity)this.jdField_a_of_type_Aglj.a, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglk
 * JD-Core Version:    0.7.0.1
 */