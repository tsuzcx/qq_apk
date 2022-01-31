import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;

public class aduh
  implements Runnable
{
  public aduh(HuayangPluginLauncher paramHuayangPluginLauncher, boolean paramBoolean) {}
  
  public void run()
  {
    if (HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher) == null) {
      HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher, HuayangPluginLauncher.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher));
    }
    if ((HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher) != null) && (HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher)))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label108;
      }
      Message localMessage = Message.obtain(HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher), 2);
      HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher).sendMessage(localMessage);
      HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher, HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher));
      this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher, false);
      return;
      label108:
      HuayangPluginLauncher.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher, HuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduh
 * JD-Core Version:    0.7.0.1
 */