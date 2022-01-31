import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class ajdc
  implements aiwi
{
  ajdc(ajdb paramajdb) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    ajdb localajdb = this.a;
    if (ajdb.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = ajdb.a(this.a).e;
      ajdb.a(localajdb, paramStartCheckParam);
      if (!"message".equals(ajdb.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(ajdb.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = ajdb.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ajdb.a(this.a) != null) {
      ajdb.a(this.a).c(-10001, ajdb.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdc
 * JD-Core Version:    0.7.0.1
 */