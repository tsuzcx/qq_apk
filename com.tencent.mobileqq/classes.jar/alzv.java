import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import java.util.Comparator;

class alzv
  implements Comparator<QIMNotifyAddFriend>
{
  alzv(alzu paramalzu) {}
  
  public int a(QIMNotifyAddFriend paramQIMNotifyAddFriend1, QIMNotifyAddFriend paramQIMNotifyAddFriend2)
  {
    return (int)(paramQIMNotifyAddFriend2.pushTime - paramQIMNotifyAddFriend1.pushTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzv
 * JD-Core Version:    0.7.0.1
 */