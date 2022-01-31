import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.qphone.base.util.QLog;

public class akng
  extends ajxl
{
  public akng(HiddenChatFragment paramHiddenChatFragment) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      QLog.e("tag_hidden_chat", 1, "data not right");
    }
    do
    {
      do
      {
        return;
        String[] arrayOfString = (String[])paramArrayOfObject[0];
        paramArrayOfObject = (boolean[])paramArrayOfObject[1];
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, new Object[] { "res:", Boolean.valueOf(paramBoolean), " len1:", Integer.valueOf(arrayOfString.length), " len2:", Integer.valueOf(paramArrayOfObject.length) });
        }
      } while (!paramBoolean);
      this.a.a();
    } while (!QLog.isColorLevel());
    QLog.d("tag_hidden_chat", 2, "onSetHiddenChatSwitch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */