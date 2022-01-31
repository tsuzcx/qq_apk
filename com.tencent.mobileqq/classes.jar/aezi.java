import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.PublishCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl;

public class aezi
  implements CommentsDataSource.PublishCommentCallback
{
  public aezi(CommentsPresenterImpl paramCommentsPresenterImpl) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (CommentsPresenterImpl.a(this.a) != null) {
      CommentsPresenterImpl.a(this.a).a(paramComment);
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (CommentsPresenterImpl.a(this.a) != null) {
      CommentsPresenterImpl.a(this.a).a(paramComment, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezi
 * JD-Core Version:    0.7.0.1
 */