import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class aknf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new akng(this, Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString = "antiphishingConfig";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c = 1;
  private int d = 2;
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  private String a()
  {
    new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Tencent/com/tencent/mobileqq/antiphishingconfig.xml").toString();
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<String> a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Context paramContext)
  {
    if (paramInt <= this.jdField_a_of_type_Int)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "nNewVersion:" + paramInt + "nLocalConfigVer:" + this.jdField_a_of_type_Int + "Do not Need Update!");
      return;
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Int == paramInt) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 7200000L))
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "Config Updata, Frequence limited!");
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = paramInt;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "filehash:" + paramString2 + "downloadurl:" + paramString1);
    ThreadManager.post(new AntiphishingUrlConfig.2(this, paramContext, paramString1, paramString2), 5, null, true);
  }
  
  public void a(String paramString, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Parase Config!");
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    aknj localaknj = new aknj();
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream((File)localObject), "UTF-8")), localaknj);
      this.jdField_a_of_type_Int = localaknj.a();
      this.jdField_a_of_type_JavaUtilArrayList = localaknj.a();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aknf
 * JD-Core Version:    0.7.0.1
 */