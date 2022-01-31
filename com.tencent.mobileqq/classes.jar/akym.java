import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class akym
  implements Runnable
{
  akym(akyl paramakyl, String paramString) {}
  
  public void run()
  {
    akyn localakyn = new akyn(this);
    WXShareHelper.a().a(localakyn);
    WorldCupShareFragment.b(this.jdField_a_of_type_Akyl.a, String.valueOf(System.currentTimeMillis()));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, WorldCupShareFragment.a(this.jdField_a_of_type_Akyl.a), 0, true, WorldCupShareFragment.c(this.jdField_a_of_type_Akyl.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akym
 * JD-Core Version:    0.7.0.1
 */