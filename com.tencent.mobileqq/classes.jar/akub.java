import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class akub
{
  public String a;
  public boolean a;
  public byte[] a;
  public String b;
  
  public WebResourceResponse a()
  {
    try
    {
      if (this.b != null)
      {
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (!this.jdField_a_of_type_Boolean)) {
          return new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", new ByteArrayInputStream(this.jdField_a_of_type_ArrayOfByte));
        }
        if (!bdhb.a(this.b)) {
          break label102;
        }
        WebResourceResponse localWebResourceResponse = new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", new FileInputStream(this.b));
        return localWebResourceResponse;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameResManager", 1, localThrowable, new Object[] { "[getResponse]" });
    }
    return null;
    label102:
    return null;
  }
  
  public String a()
  {
    return "file://" + this.b;
  }
  
  public void a()
  {
    try
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (bdhb.a(this.b)))
      {
        if (bdhb.b(this.b) <= 8388608L) {
          break label84;
        }
        this.jdField_a_of_type_Boolean = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloGameResManager", 2, "[initData] " + this.b);
        return;
        label84:
        this.jdField_a_of_type_ArrayOfByte = bdhb.a(this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameResManager", 1, localThrowable, new Object[] { "[initData]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akub
 * JD-Core Version:    0.7.0.1
 */