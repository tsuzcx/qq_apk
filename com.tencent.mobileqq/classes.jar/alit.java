import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alit
{
  protected static ayrz a;
  private ayry jdField_a_of_type_Ayry;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<alix> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Ayrz = new aliv();
  }
  
  public alit(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ayry = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((alix)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Ayry.b(((alix)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Ayrv);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(alix paramalix, aliw arg2)
  {
    if ((paramalix == null) || (??? == null)) {
      return false;
    }
    ??? = new aliu(this, paramalix, ???);
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = ???;
    localayrv.jdField_a_of_type_JavaLangString = paramalix.jdField_a_of_type_JavaLangString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = paramalix.c;
    localayrv.e = 1;
    localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
    this.jdField_a_of_type_Ayry.a(localayrv);
    paramalix.jdField_a_of_type_Ayrv = localayrv;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramalix);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramalix.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alit
 * JD-Core Version:    0.7.0.1
 */