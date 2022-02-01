import com.tencent.qphone.base.util.QLog;

class alyw
  extends bgod
{
  alyw(alyu paramalyu) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambgoe.a());
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    if ((parambgoe == null) || (alyu.a(this.a) == null)) {
      return;
    }
    if (parambgoe.a() != 3)
    {
      alyu.a(this.a, 2);
      if (alyu.a(this.a) != null) {
        alyu.a(this.a).c(-1005, alyu.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambgoe.a());
      return;
    }
    alyu.a(this.a);
  }
  
  public void onProgress(bgoe parambgoe)
  {
    int i = (int)parambgoe.a;
    if (alyu.a(this.a) != null) {
      alyu.a(this.a).a(i, alyu.a(this.a).jdField_b_of_type_Int, alyu.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyw
 * JD-Core Version:    0.7.0.1
 */