import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class adrp
  implements Runnable
{
  public adrp(SendBottomBar paramSendBottomBar) {}
  
  public void run()
  {
    new adrq(this).execute(new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */