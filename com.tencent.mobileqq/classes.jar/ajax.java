import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajax
  extends ajce
{
  public ajax(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
  }
  
  public ajbx a(String paramString)
  {
    return new ajaw(paramString);
  }
  
  public View a()
  {
    if (this.c == 0) {
      return new ApolloLinearLayout(this.b, null, this.d, 4, 2);
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajax
 * JD-Core Version:    0.7.0.1
 */