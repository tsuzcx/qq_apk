import com.tencent.qphone.base.util.QLog;

class akze
  extends bead
{
  akze(akzc paramakzc) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambeae.a());
  }
  
  public void onDoneFile(beae parambeae)
  {
    if ((parambeae == null) || (akzc.a(this.a) == null)) {
      return;
    }
    if (parambeae.a() != 3)
    {
      akzc.a(this.a, 2);
      if (akzc.a(this.a) != null) {
        akzc.a(this.a).c(-1005, akzc.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambeae.a());
      return;
    }
    akzc.a(this.a);
  }
  
  public void onProgress(beae parambeae)
  {
    int i = (int)parambeae.a;
    if (akzc.a(this.a) != null) {
      akzc.a(this.a).a(i, akzc.a(this.a).jdField_b_of_type_Int, akzc.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akze
 * JD-Core Version:    0.7.0.1
 */