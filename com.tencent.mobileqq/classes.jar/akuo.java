import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class akuo
  implements aknu
{
  akuo(akun paramakun) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    akun localakun = this.a;
    if (akun.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = akun.a(this.a).e;
      akun.a(localakun, paramStartCheckParam);
      if (!"message".equals(akun.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(akun.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = akun.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (akun.a(this.a) != null) {
      akun.a(this.a).c(-10001, akun.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuo
 * JD-Core Version:    0.7.0.1
 */