import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.FileMsg;

public class afwf
  implements FileTransferManager.Callback
{
  public afwf(OpenApiManager paramOpenApiManager) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    this.a.onFileTransStatusChanged(paramFileMsg, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afwf
 * JD-Core Version:    0.7.0.1
 */