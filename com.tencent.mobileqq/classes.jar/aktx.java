import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class aktx
{
  protected static axrs a;
  private axrr jdField_a_of_type_Axrr;
  private axxj jdField_a_of_type_Axxj;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<akud> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, akuc> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Axrs = new akub();
  }
  
  public aktx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Axrr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Axxj = ((axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(akud paramakud, akuc paramakuc)
  {
    if ((paramakud == null) || (paramakuc == null)) {
      return false;
    }
    Object localObject1 = new akty(this, paramakud);
    ??? = new aktz(this);
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = ((axrt)???);
    localaxro.jdField_a_of_type_JavaLangString = paramakud.jdField_a_of_type_JavaLangString;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.c = paramakud.c;
    localaxro.e = 1;
    localaxro.jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
    paramakud.jdField_a_of_type_Axro = localaxro;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramakud);
        switch (badq.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new akua(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramakud.b, (axxi)localObject1, localaxro, paramakud, paramakuc);
          this.jdField_a_of_type_Axxj.a(10065, "prd", paramakud.b, 0, paramakud.jdField_a_of_type_JavaLangString, localaxro.c, i, 0, false, (axxg)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramakud.b, paramakuc);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramakud.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     aktx
 * JD-Core Version:    0.7.0.1
 */