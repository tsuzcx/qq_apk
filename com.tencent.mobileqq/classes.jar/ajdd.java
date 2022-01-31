import com.tencent.qphone.base.util.QLog;

class ajdd
  extends bbwt
{
  ajdd(ajdb paramajdb) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambbwu.a());
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    if ((parambbwu == null) || (ajdb.a(this.a) == null)) {
      return;
    }
    if (parambbwu.a() != 3)
    {
      ajdb.a(this.a, 2);
      if (ajdb.a(this.a) != null) {
        ajdb.a(this.a).c(-1005, ajdb.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambbwu.a());
      return;
    }
    ajdb.a(this.a);
  }
  
  public void onProgress(bbwu parambbwu)
  {
    int i = (int)parambbwu.a;
    if (ajdb.a(this.a) != null) {
      ajdb.a(this.a).a(i, ajdb.a(this.a).jdField_b_of_type_Int, ajdb.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdd
 * JD-Core Version:    0.7.0.1
 */