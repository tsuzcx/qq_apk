import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.DeleteCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl;

public class aezj
  implements CommentsDataSource.DeleteCommentCallback
{
  public aezj(CommentsPresenterImpl paramCommentsPresenterImpl) {}
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      if (paramInt == 0)
      {
        CommentsPresenterImpl.a(this.a).b(paramComment);
        CommentsPresenterImpl.a(this.a).a(BaseApplicationImpl.getApplication().getString(2131430835));
      }
    }
    else {
      return;
    }
    CommentsPresenterImpl.a(this.a).a(BaseApplicationImpl.getApplication().getString(2131430836));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezj
 * JD-Core Version:    0.7.0.1
 */