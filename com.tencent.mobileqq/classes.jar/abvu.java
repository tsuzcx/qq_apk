import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class abvu
{
  public abwp a;
  public amsw a;
  public anuz a;
  public avtd a;
  public Map<String, RecentUser> a;
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  
  public abvu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Avtd = ((avtd)paramQQAppInterface.getManager(37));
    this.jdField_a_of_type_Anuz = paramQQAppInterface.getProxyManager().a();
    this.jdField_a_of_type_Abwp = paramQQAppInterface.getConversationFacade();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvu
 * JD-Core Version:    0.7.0.1
 */