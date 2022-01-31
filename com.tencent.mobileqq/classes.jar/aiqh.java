import com.tencent.qphone.base.util.QLog;

class aiqh
  extends batl
{
  aiqh(aiqf paramaiqf) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambatm.a());
  }
  
  public void onDoneFile(batm parambatm)
  {
    if ((parambatm == null) || (aiqf.a(this.a) == null)) {
      return;
    }
    if (parambatm.a() != 3)
    {
      aiqf.a(this.a, 2);
      if (aiqf.a(this.a) != null) {
        aiqf.a(this.a).c(-1005, aiqf.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambatm.a());
      return;
    }
    aiqf.a(this.a);
  }
  
  public void onProgress(batm parambatm)
  {
    int i = (int)parambatm.a;
    if (aiqf.a(this.a) != null) {
      aiqf.a(this.a).a(i, aiqf.a(this.a).jdField_b_of_type_Int, aiqf.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqh
 * JD-Core Version:    0.7.0.1
 */