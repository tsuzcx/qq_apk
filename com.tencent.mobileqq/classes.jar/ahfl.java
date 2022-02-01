import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahfl
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  ahfl(ahfk paramahfk) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((afwr)afur.a(paramView)).a;
      if (zjb.a(localMessageForQQStoryComment.vid))
      {
        xho.a(this.jdField_a_of_type_Ahfk.a, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id", 1004);
        yqu.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      }
      else
      {
        xho.b((Activity)this.jdField_a_of_type_Ahfk.a, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfl
 * JD-Core Version:    0.7.0.1
 */