import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.widget.AbsListView;

public class aaqw
  implements bfos
{
  public aaqw(ChatHistory paramChatHistory) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.m = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((this.a.a != null) && (this.a.a.jdField_a_of_type_Int == 1) && (!this.a.a.jdField_a_of_type_Boolean)) {
      this.a.a.d();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqw
 * JD-Core Version:    0.7.0.1
 */