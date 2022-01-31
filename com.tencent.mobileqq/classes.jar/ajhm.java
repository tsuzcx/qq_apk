import com.tencent.qphone.base.util.QLog;

class ajhm
  implements ajic
{
  ajhm(ajhk paramajhk) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "res download sucess roleId=" + paramInt1 + "dressIds=" + paramArrayOfInt);
      }
      if (ajhk.a(this.a) != null) {
        ajhk.a(this.a).e();
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhm
 * JD-Core Version:    0.7.0.1
 */