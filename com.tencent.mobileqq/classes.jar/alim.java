import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.util.Deque;

public class alim
  implements PopupWindow.OnDismissListener
{
  public alim(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      alir localalir = (alir)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localalir != null) {
        ApolloPanel.a(this.a, localalir.jdField_a_of_type_AndroidViewView, localalir.jdField_a_of_type_Int, localalir.jdField_a_of_type_JavaLangString, localalir.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alim
 * JD-Core Version:    0.7.0.1
 */