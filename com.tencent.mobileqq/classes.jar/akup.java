import com.tencent.qphone.base.util.QLog;

class akup
  extends bdvu
{
  akup(akun paramakun) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambdvv.a());
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    if ((parambdvv == null) || (akun.a(this.a) == null)) {
      return;
    }
    if (parambdvv.a() != 3)
    {
      akun.a(this.a, 2);
      if (akun.a(this.a) != null) {
        akun.a(this.a).c(-1005, akun.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambdvv.a());
      return;
    }
    akun.a(this.a);
  }
  
  public void onProgress(bdvv parambdvv)
  {
    int i = (int)parambdvv.a;
    if (akun.a(this.a) != null) {
      akun.a(this.a).a(i, akun.a(this.a).jdField_b_of_type_Int, akun.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akup
 * JD-Core Version:    0.7.0.1
 */