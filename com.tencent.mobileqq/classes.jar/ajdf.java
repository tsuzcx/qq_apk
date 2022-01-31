import com.tencent.qphone.base.util.QLog;

class ajdf
  extends bbwf
{
  ajdf(ajdd paramajdd) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambbwg.a());
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    if ((parambbwg == null) || (ajdd.a(this.a) == null)) {
      return;
    }
    if (parambbwg.a() != 3)
    {
      ajdd.a(this.a, 2);
      if (ajdd.a(this.a) != null) {
        ajdd.a(this.a).c(-1005, ajdd.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambbwg.a());
      return;
    }
    ajdd.a(this.a);
  }
  
  public void onProgress(bbwg parambbwg)
  {
    int i = (int)parambbwg.a;
    if (ajdd.a(this.a) != null) {
      ajdd.a(this.a).a(i, ajdd.a(this.a).jdField_b_of_type_Int, ajdd.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdf
 * JD-Core Version:    0.7.0.1
 */