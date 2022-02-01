import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class acmb
{
  public acmw a;
  public anvk a;
  public aoxz a;
  public awzf a;
  public Map<String, RecentUser> a;
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  
  public acmb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Anvk = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_Awzf = ((awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_Aoxz = paramQQAppInterface.getProxyManager().a();
    this.jdField_a_of_type_Acmw = paramQQAppInterface.getConversationFacade();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmb
 * JD-Core Version:    0.7.0.1
 */