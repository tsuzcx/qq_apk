import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import java.util.Comparator;

class akds
  implements Comparator<QIMNotifyAddFriend>
{
  akds(akdr paramakdr) {}
  
  public int a(QIMNotifyAddFriend paramQIMNotifyAddFriend1, QIMNotifyAddFriend paramQIMNotifyAddFriend2)
  {
    return (int)(paramQIMNotifyAddFriend2.pushTime - paramQIMNotifyAddFriend1.pushTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akds
 * JD-Core Version:    0.7.0.1
 */