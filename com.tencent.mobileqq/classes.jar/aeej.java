import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class aeej
  implements Runnable
{
  public aeej(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func run, magicValue:" + this.a.a.magicValue);
    }
    this.a.a(this.a.a, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeej
 * JD-Core Version:    0.7.0.1
 */