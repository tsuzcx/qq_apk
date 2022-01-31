import android.os.Handler;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;

public class adui
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public adui(HuayangPluginLauncher paramHuayangPluginLauncher) {}
  
  public void run()
  {
    HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 20;
    if (this.jdField_a_of_type_Int < 80) {
      HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher).postDelayed(this, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adui
 * JD-Core Version:    0.7.0.1
 */