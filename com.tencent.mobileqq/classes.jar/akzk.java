import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class akzk
  extends bdvu
{
  akzk(File paramFile) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if ((3 == parambdvv.a()) && (this.a.exists())) {}
    try
    {
      ndr.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambdvv)
    {
      parambdvv = parambdvv;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambdvv.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambdvv)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambdvv)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambdvv.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambdvv)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambdvv;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzk
 * JD-Core Version:    0.7.0.1
 */