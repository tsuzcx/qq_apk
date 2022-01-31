import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ajhy
  extends bbwt
{
  ajhy(File paramFile) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if ((3 == parambbwu.a()) && (this.a.exists())) {}
    try
    {
      nav.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambbwu)
    {
      parambbwu = parambbwu;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambbwu.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambbwu)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambbwu)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambbwu.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambbwu)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambbwu;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhy
 * JD-Core Version:    0.7.0.1
 */