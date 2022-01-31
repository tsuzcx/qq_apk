import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;

public class ajbx
{
  public float a;
  public int a;
  public ApolloActionData a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return axku.a(paramContext.getResources(), this.h);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public String toString()
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append("id: ").append(this.a.actionId).append(", name: ").append(this.a.actionName).append(", peerUin: ").append(this.a.peerUin).append(", peopleNum: ").append(this.a.personNum).append(", feeType: ").append(this.a.feeType).append(", inputText: ").append(this.a.inputText).append(",actionText: ").append(this.b).append(",textType: ").append(this.d).append("]");
      return localStringBuilder.toString();
    }
    return "ApolloActionData is null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbx
 * JD-Core Version:    0.7.0.1
 */