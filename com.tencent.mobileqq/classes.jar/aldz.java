import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aldz
  extends bead
{
  aldz(File paramFile) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if ((3 == parambeae.a()) && (this.a.exists())) {}
    try
    {
      ndr.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambeae)
    {
      parambeae = parambeae;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambeae.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambeae)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambeae)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambeae.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambeae)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambeae;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldz
 * JD-Core Version:    0.7.0.1
 */