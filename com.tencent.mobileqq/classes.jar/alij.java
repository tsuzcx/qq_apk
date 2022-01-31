import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class alij
{
  protected static ayrz a;
  private ayry jdField_a_of_type_Ayry;
  private ayxq jdField_a_of_type_Ayxq;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<alip> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, alio> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Ayrz = new alin();
  }
  
  public alij(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayry = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ayxq = ((ayxq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(alip paramalip, alio paramalio)
  {
    if ((paramalip == null) || (paramalio == null)) {
      return false;
    }
    Object localObject1 = new alik(this, paramalip);
    ??? = new alil(this);
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = ((aysa)???);
    localayrv.jdField_a_of_type_JavaLangString = paramalip.jdField_a_of_type_JavaLangString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = paramalip.c;
    localayrv.e = 1;
    localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
    paramalip.jdField_a_of_type_Ayrv = localayrv;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramalip);
        switch (bbev.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new alim(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramalip.b, (ayxp)localObject1, localayrv, paramalip, paramalio);
          this.jdField_a_of_type_Ayxq.a(10065, "prd", paramalip.b, 0, paramalip.jdField_a_of_type_JavaLangString, localayrv.c, i, 0, false, (ayxn)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramalip.b, paramalio);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramalip.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     alij
 * JD-Core Version:    0.7.0.1
 */