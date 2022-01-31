import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ajba
  extends ajxl
{
  ajba(ajaz paramajaz) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((ajaz.a(this.a) != null) && (ajaz.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)ajaz.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajba
 * JD-Core Version:    0.7.0.1
 */