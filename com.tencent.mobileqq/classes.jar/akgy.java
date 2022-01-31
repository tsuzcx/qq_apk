import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.util.QLog;

public class akgy
  implements Runnable
{
  public akgy(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss arrow postDelayed 500 run and set isLastDropDown false");
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgy
 * JD-Core Version:    0.7.0.1
 */