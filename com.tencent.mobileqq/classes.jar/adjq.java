import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class adjq
  implements Runnable
{
  public adjq(SendBottomBar paramSendBottomBar) {}
  
  public void run()
  {
    new adjr(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adjq
 * JD-Core Version:    0.7.0.1
 */