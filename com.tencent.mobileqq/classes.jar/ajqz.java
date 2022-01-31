import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.util.Deque;

public class ajqz
  implements PopupWindow.OnDismissListener
{
  public ajqz(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ajre localajre = (ajre)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localajre != null) {
        ApolloPanel.a(this.a, localajre.jdField_a_of_type_AndroidViewView, localajre.jdField_a_of_type_Int, localajre.jdField_a_of_type_JavaLangString, localajre.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajqz
 * JD-Core Version:    0.7.0.1
 */