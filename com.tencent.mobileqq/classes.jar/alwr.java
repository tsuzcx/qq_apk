import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class alwr
  extends amsu
{
  alwr(alwq paramalwq) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((alwq.a(this.a) != null) && (alwq.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)alwq.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwr
 * JD-Core Version:    0.7.0.1
 */