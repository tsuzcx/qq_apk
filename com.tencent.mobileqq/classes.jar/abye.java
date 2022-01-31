import android.view.ViewGroup;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;

public class abye
  implements Runnable
{
  public abye(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout) {}
  
  public void run()
  {
    EmoticonPanelLinearLayout.a(this.a).removeView(EmoticonPanelLinearLayout.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abye
 * JD-Core Version:    0.7.0.1
 */