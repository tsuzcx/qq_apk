import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aitz
  extends batl
{
  aitz(File paramFile) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if ((3 == parambatm.a()) && (this.a.exists())) {}
    try
    {
      mpx.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambatm)
    {
      parambatm = parambatm;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambatm.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambatm)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambatm)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambatm.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambatm)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambatm;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aitz
 * JD-Core Version:    0.7.0.1
 */