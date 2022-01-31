import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.util.Deque;

public class alnb
  implements PopupWindow.OnDismissListener
{
  public alnb(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      alng localalng = (alng)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localalng != null) {
        ApolloPanel.a(this.a, localalng.jdField_a_of_type_AndroidViewView, localalng.jdField_a_of_type_Int, localalng.jdField_a_of_type_JavaLangString, localalng.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnb
 * JD-Core Version:    0.7.0.1
 */