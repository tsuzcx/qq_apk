package org.libpag.reporter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reporter
{
  private static final String TAG;
  private Boolean auto;
  private File dir;
  private Handler ioHandler;
  private Runnable uploadRunnable;
  
  static
  {
    AppMethodBeat.i(187458);
    TAG = Reporter.class.getSimpleName() + "-" + Integer.toHexString(Reporter.class.hashCode());
    AppMethodBeat.o(187458);
  }
  
  public Reporter(File paramFile, Boolean paramBoolean, Looper paramLooper)
  {
    AppMethodBeat.i(187407);
    this.uploadRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187435);
        for (;;)
        {
          int i;
          File localFile;
          FileInputStream localFileInputStream;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          int m;
          int j;
          try
          {
            File[] arrayOfFile = Reporter.this.dir.listFiles();
            int k = arrayOfFile.length;
            i = 0;
            if (i >= k) {
              continue;
            }
            localFile = arrayOfFile[i];
            if ((!localFile.exists()) || (!localFile.isFile())) {
              break label156;
            }
            localFileInputStream = new FileInputStream(localFile);
            arrayOfByte = new byte[1024];
            localStringBuilder = new StringBuilder();
            m = localFileInputStream.read(arrayOfByte);
            if (m == -1) {
              break label133;
            }
            j = 0;
          }
          finally
          {
            Reporter.access$200(Reporter.this);
            AppMethodBeat.o(187435);
            return;
          }
          localStringBuilder.append(new String(arrayOfByte, 0, m));
          continue;
          label133:
          localFileInputStream.close();
          localFile.delete();
          Reporter.access$100(Reporter.this, localStringBuilder.toString());
          label156:
          i += 1;
          continue;
          while (j < m)
          {
            arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ 0xFFFFFFE9));
            j += 1;
          }
        }
      }
    };
    this.dir = paramFile;
    this.auto = paramBoolean;
    paramFile = paramLooper;
    if (paramLooper == null)
    {
      paramFile = new HandlerThread(TAG);
      paramFile.setDaemon(true);
      paramFile.start();
      while (!paramFile.isAlive()) {}
      paramFile = paramFile.getLooper();
    }
    this.ioHandler = new Handler(paramFile);
    schedule();
    AppMethodBeat.o(187407);
  }
  
  private void report(String paramString)
  {
    AppMethodBeat.i(187423);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://h.trace.qq.com/kv").openConnection();
      localHttpURLConnection.setConnectTimeout(1000);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setDoInput(false);
      localHttpURLConnection.setDoOutput(true);
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      localBufferedWriter.write(paramString);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localHttpURLConnection.disconnect();
      AppMethodBeat.o(187423);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(187423);
    }
  }
  
  private void schedule()
  {
    AppMethodBeat.i(187416);
    if ((this.auto.booleanValue()) && (this.ioHandler != null)) {
      this.ioHandler.postDelayed(this.uploadRunnable, 30000L);
    }
    AppMethodBeat.o(187416);
  }
  
  public void flush()
  {
    AppMethodBeat.i(187467);
    if (this.ioHandler != null)
    {
      this.ioHandler.removeCallbacks(this.uploadRunnable);
      this.ioHandler.post(this.uploadRunnable);
    }
    AppMethodBeat.o(187467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.libpag.reporter.Reporter
 * JD-Core Version:    0.7.0.1
 */