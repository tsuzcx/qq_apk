import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class algh
  implements Runnable
{
  algh(algg paramalgg, String paramString) {}
  
  public void run()
  {
    algi localalgi = new algi(this);
    WXShareHelper.a().a(localalgi);
    WorldCupShareFragment.b(this.jdField_a_of_type_Algg.a, String.valueOf(System.currentTimeMillis()));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, WorldCupShareFragment.a(this.jdField_a_of_type_Algg.a), 1, true, WorldCupShareFragment.c(this.jdField_a_of_type_Algg.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algh
 * JD-Core Version:    0.7.0.1
 */