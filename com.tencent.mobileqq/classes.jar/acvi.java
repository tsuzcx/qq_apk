import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class acvi
{
  public acvy a;
  public anmw a;
  public aong a;
  public awne a;
  public Map<String, RecentUser> a;
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  
  public acvi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Awne = ((awne)paramQQAppInterface.getManager(37));
    this.jdField_a_of_type_Aong = paramQQAppInterface.a().a();
    this.jdField_a_of_type_Acvy = paramQQAppInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvi
 * JD-Core Version:    0.7.0.1
 */