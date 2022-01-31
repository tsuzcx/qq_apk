import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alis
{
  protected static aysb a;
  private aysa jdField_a_of_type_Aysa;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<aliw> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Aysb = new aliu();
  }
  
  public alis(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aysa = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
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
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((aliw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aysa.b(((aliw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Ayrx);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(aliw paramaliw, aliv arg2)
  {
    if ((paramaliw == null) || (??? == null)) {
      return false;
    }
    ??? = new alit(this, paramaliw, ???);
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = ???;
    localayrx.jdField_a_of_type_JavaLangString = paramaliw.jdField_a_of_type_JavaLangString;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = paramaliw.c;
    localayrx.e = 1;
    localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
    this.jdField_a_of_type_Aysa.a(localayrx);
    paramaliw.jdField_a_of_type_Ayrx = localayrx;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaliw);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramaliw.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alis
 * JD-Core Version:    0.7.0.1
 */