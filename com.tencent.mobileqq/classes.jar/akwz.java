import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class akwz
  extends altm
{
  akwz(akwy paramakwy) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((akwy.a(this.a) != null) && (akwy.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)akwy.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwz
 * JD-Core Version:    0.7.0.1
 */