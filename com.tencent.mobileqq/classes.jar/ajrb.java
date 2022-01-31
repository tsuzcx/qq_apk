import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.util.Deque;

public class ajrb
  implements PopupWindow.OnDismissListener
{
  public ajrb(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ajrg localajrg = (ajrg)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localajrg != null) {
        ApolloPanel.a(this.a, localajrg.jdField_a_of_type_AndroidViewView, localajrg.jdField_a_of_type_Int, localajrg.jdField_a_of_type_JavaLangString, localajrg.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajrb
 * JD-Core Version:    0.7.0.1
 */