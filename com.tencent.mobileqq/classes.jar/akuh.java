import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class akuh
{
  protected static axrs a;
  private axrr jdField_a_of_type_Axrr;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<akul> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Axrs = new akuj();
  }
  
  public akuh(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axrr = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
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
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((akul)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Axrr.b(((akul)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Axro);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(akul paramakul, akuk arg2)
  {
    if ((paramakul == null) || (??? == null)) {
      return false;
    }
    ??? = new akui(this, paramakul, ???);
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = ???;
    localaxro.jdField_a_of_type_JavaLangString = paramakul.jdField_a_of_type_JavaLangString;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.c = paramakul.c;
    localaxro.e = 1;
    localaxro.jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
    this.jdField_a_of_type_Axrr.a(localaxro);
    paramakul.jdField_a_of_type_Axro = localaxro;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramakul);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramakul.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akuh
 * JD-Core Version:    0.7.0.1
 */