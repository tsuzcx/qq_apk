import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class aivb
  extends SosoInterface.OnLocationListener
{
  public aivb(Face2FaceAddContactPresenter.3 param3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onLocationFinish errCode = " + paramInt + " info = " + paramSosoLbsInfo);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null)) {
      if (aiuz.a(this.a.this$0) != null) {
        aiuz.a(this.a.this$0).b();
      }
    }
    while ((TextUtils.isEmpty(this.a.a)) || (this.a.a.length() != 4)) {
      return;
    }
    aiuz.a(this.a.this$0, paramSosoLbsInfo, this.a.a, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivb
 * JD-Core Version:    0.7.0.1
 */