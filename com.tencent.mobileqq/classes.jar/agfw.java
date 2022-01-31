import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.IArFaceResourceListener;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agfw
  implements IArFaceResourceListener
{
  public agfw(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("onFaceDownloadSuccess type=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((ScanTorchActivity.d(this.a)) && (ScanTorchActivity.e(this.a)) && (this.a.a != null) && (this.a.a.a != null) && (this.a.a.a.a != null) && (this.a.a.a.a.a != null)) {
        this.a.a.a.a.a.a();
      }
      ScanTorchActivity.e(this.a);
      ScanTorchActivity.f(this.a);
      return;
      ScanTorchActivity.c(this.a, true);
      ScanTorchActivity.d(this.a, false);
      ScanTorchActivity.a(this.a, 100);
      continue;
      ScanTorchActivity.e(this.a, true);
      ScanTorchActivity.f(this.a, false);
      ScanTorchActivity.b(this.a, 100);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("onFaceDownloadProcess type=%s process=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ScanTorchActivity.e(this.a);
      return;
      ScanTorchActivity.a(this.a, paramInt2);
      continue;
      ScanTorchActivity.b(this.a, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("onFaceDownloadError type=%s error=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ScanTorchActivity.f(this.a);
      return;
      ScanTorchActivity.c(this.a, false);
      ScanTorchActivity.d(this.a, false);
      continue;
      ScanTorchActivity.e(this.a, false);
      ScanTorchActivity.f(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfw
 * JD-Core Version:    0.7.0.1
 */