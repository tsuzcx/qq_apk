import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class agfn
{
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfn
 * JD-Core Version:    0.7.0.1
 */