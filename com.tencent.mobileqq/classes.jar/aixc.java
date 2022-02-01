import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class aixc
  extends SosoInterface.OnLocationListener
{
  public aixc(PublicView paramPublicView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "onLocationFinish() errCode=" + paramInt);
    }
    PublicView.a(this.a, true);
    PublicView.a(this.a, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixc
 * JD-Core Version:    0.7.0.1
 */