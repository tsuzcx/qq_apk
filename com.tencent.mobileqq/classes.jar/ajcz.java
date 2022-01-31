import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.util.Deque;

public class ajcz
  implements PopupWindow.OnDismissListener
{
  public ajcz(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ajde localajde = (ajde)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localajde != null) {
        ApolloPanel.a(this.a, localajde.jdField_a_of_type_AndroidViewView, localajde.jdField_a_of_type_Int, localajde.jdField_a_of_type_JavaLangString, localajde.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcz
 * JD-Core Version:    0.7.0.1
 */