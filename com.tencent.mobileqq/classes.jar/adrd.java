import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class adrd
  implements Runnable
{
  public adrd(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func run, magicValue:" + this.a.a.magicValue);
    }
    this.a.a(this.a.a, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adrd
 * JD-Core Version:    0.7.0.1
 */