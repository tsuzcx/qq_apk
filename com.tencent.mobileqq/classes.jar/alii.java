import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class alii
{
  protected static aysb a;
  private aysa jdField_a_of_type_Aysa;
  private ayxs jdField_a_of_type_Ayxs;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<alio> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, alin> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Aysb = new alim();
  }
  
  public alii(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aysa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ayxs = ((ayxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(alio paramalio, alin paramalin)
  {
    if ((paramalio == null) || (paramalin == null)) {
      return false;
    }
    Object localObject1 = new alij(this, paramalio);
    ??? = new alik(this);
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = ((aysc)???);
    localayrx.jdField_a_of_type_JavaLangString = paramalio.jdField_a_of_type_JavaLangString;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = paramalio.c;
    localayrx.e = 1;
    localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
    paramalio.jdField_a_of_type_Ayrx = localayrx;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramalio);
        switch (bbfj.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new alil(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramalio.b, (ayxr)localObject1, localayrx, paramalio, paramalin);
          this.jdField_a_of_type_Ayxs.a(10065, "prd", paramalio.b, 0, paramalio.jdField_a_of_type_JavaLangString, localayrx.c, i, 0, false, (ayxp)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramalio.b, paramalin);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramalio.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
      int i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alii
 * JD-Core Version:    0.7.0.1
 */