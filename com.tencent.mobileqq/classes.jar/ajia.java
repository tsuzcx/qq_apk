import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ajia
  extends bbwf
{
  ajia(File paramFile) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if ((3 == parambbwg.a()) && (this.a.exists())) {}
    try
    {
      nay.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambbwg)
    {
      parambbwg = parambbwg;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambbwg.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambbwg)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambbwg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambbwg.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambbwg)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambbwg;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajia
 * JD-Core Version:    0.7.0.1
 */