import android.util.Base64;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class alwu
  extends LruCache
{
  private File jdField_a_of_type_JavaIoFile;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private File jdField_b_of_type_JavaIoFile;
  private boolean jdField_b_of_type_Boolean;
  
  public alwu(String paramString, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
    this.jdField_b_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaIoFile.getPath() + ".bak");
    b();
  }
  
  private void a(alwz paramalwz)
  {
    if (this.jdField_b_of_type_JavaIoFile.exists())
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      this.jdField_b_of_type_JavaIoFile.renameTo(this.jdField_a_of_type_JavaIoFile);
    }
    if ((this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.isFile()))
    {
      int i = 0;
      if (this.jdField_a_of_type_JavaIoFile.length() > 10485760L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Cache file too big: " + this.jdField_a_of_type_JavaIoFile.length());
        }
        i = 1;
      }
      new alwy(this.jdField_a_of_type_JavaIoFile, paramalwz).a();
      if (i != 0)
      {
        CommTvRpt.a(2, 2);
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
  }
  
  private void a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle, XmlSerializer paramXmlSerializer)
  {
    if (paramResultBundle.jdField_a_of_type_Long > new Date().getTime()) {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Write entry: " + paramResultBundle.toString());
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramXmlSerializer.startTag(null, "CacheEntry");
        paramXmlSerializer.attribute(null, "Key", paramString);
        paramXmlSerializer.attribute(null, "AttrType", Integer.toString(paramResultBundle.jdField_a_of_type_Int));
        paramXmlSerializer.attribute(null, "Category", Integer.toString(paramResultBundle.b));
        paramXmlSerializer.attribute(null, "SubCategory", Integer.toString(paramResultBundle.c));
        paramXmlSerializer.attribute(null, "Action", Integer.toString(paramResultBundle.d));
        paramXmlSerializer.attribute(null, "ExpireTime", Long.toString(paramResultBundle.jdField_a_of_type_Long));
        if (paramResultBundle.jdField_a_of_type_ArrayOfByte != null) {
          paramXmlSerializer.attribute(null, "ExtraInfo", Base64.encodeToString(paramResultBundle.jdField_a_of_type_ArrayOfByte, 0));
        }
        paramXmlSerializer.endTag(null, "CacheEntry");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    QLog.d("QSec.AVEngine", 2, "Discard expired entry for write: " + paramResultBundle.toString());
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      if (!this.jdField_b_of_type_JavaIoFile.exists())
      {
        if (!this.jdField_a_of_type_JavaIoFile.renameTo(this.jdField_b_of_type_JavaIoFile)) {
          return false;
        }
      }
      else {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    new alwy(this.jdField_b_of_type_JavaIoFile, new alwx(this, this.jdField_a_of_type_JavaIoFile)).a();
    return true;
  }
  
  private ICloudAVEngine.ResultBundle b(String paramString)
  {
    paramString = new alww(this, paramString);
    a(paramString);
    return paramString.a;
  }
  
  private void b()
  {
    a(new alwv(this));
  }
  
  public ICloudAVEngine.ResultBundle a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    ICloudAVEngine.ResultBundle localResultBundle;
    do
    {
      do
      {
        do
        {
          return localObject;
          localResultBundle = (ICloudAVEngine.ResultBundle)super.get(paramString);
          if (localResultBundle == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Hit memory cache for key: " + paramString);
          }
          localObject = localResultBundle;
        } while (localResultBundle.jdField_a_of_type_Long >= new Date().getTime());
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Memory cache expired for key: " + paramString);
        }
        remove(paramString);
        return null;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = localResultBundle;
      } while (this.jdField_b_of_type_Boolean != true);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Look from cache file for key: " + paramString);
      }
      localResultBundle = b(paramString);
      localObject = localResultBundle;
    } while (localResultBundle == null);
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Hit file cache for key: " + paramString);
    }
    if (localResultBundle.jdField_a_of_type_Long < new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "File cache expired for key: " + paramString);
      }
      return null;
    }
    put(paramString, localResultBundle);
    return localResultBundle;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      a();
    }
  }
  
  public void a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if ((paramString != null) && (paramResultBundle != null))
    {
      if (put(paramString, paramResultBundle) == null) {
        this.jdField_a_of_type_JavaUtilList.add(new Pair(paramString, paramResultBundle));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Put to cache, key: %s, result: %s ", new Object[] { paramString, paramResultBundle.toString() }));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Trigger rebuild cache file");
        }
        a();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, ICloudAVEngine.ResultBundle paramResultBundle1, ICloudAVEngine.ResultBundle paramResultBundle2)
  {
    super.entryRemoved(paramBoolean, paramString, paramResultBundle1, paramResultBundle2);
    if (!paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Memory cache overflow.");
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alwu
 * JD-Core Version:    0.7.0.1
 */