import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;

class aiqg
  implements aijr
{
  aiqg(aiqf paramaiqf) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    aiqf localaiqf = this.a;
    if (aiqf.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = aiqf.a(this.a).e;
      aiqf.a(localaiqf, paramStartCheckParam);
      if (!"message".equals(aiqf.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      bajr.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(aiqf.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = aiqf.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (aiqf.a(this.a) != null) {
      aiqf.a(this.a).c(-10001, aiqf.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqg
 * JD-Core Version:    0.7.0.1
 */