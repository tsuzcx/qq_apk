import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class alge
  implements Runnable
{
  alge(algd paramalgd, String paramString) {}
  
  public void run()
  {
    algf localalgf = new algf(this);
    WXShareHelper.a().a(localalgf);
    WorldCupShareFragment.b(this.jdField_a_of_type_Algd.a, String.valueOf(System.currentTimeMillis()));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, WorldCupShareFragment.a(this.jdField_a_of_type_Algd.a), 0, true, WorldCupShareFragment.c(this.jdField_a_of_type_Algd.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alge
 * JD-Core Version:    0.7.0.1
 */