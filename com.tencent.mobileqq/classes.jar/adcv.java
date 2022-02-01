import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;

public class adcv
  implements CompoundButton.OnCheckedChangeListener
{
  public adcv(TestAppFragment paramTestAppFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    File localFile;
    if (paramBoolean)
    {
      new File(this.a.a).mkdirs();
      localFile = new File(this.a.a, this.a.b);
    }
    for (;;)
    {
      try
      {
        localFile.createNewFile();
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      new File(this.a.a, this.a.b).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcv
 * JD-Core Version:    0.7.0.1
 */