import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aioc
  extends ajjh
{
  aioc(aiob paramaiob) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((aiob.a(this.a) != null) && (aiob.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)aiob.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */