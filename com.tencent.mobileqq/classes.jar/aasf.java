import android.app.ProgressDialog;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackStatsCollector;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.PoiExtraMng;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander.OnResCheckResultListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskCommonInfo;

public class aasf
  implements OpenBoxCheckHander.OnResCheckResultListener
{
  public aasf(ARMapActivity paramARMapActivity) {}
  
  public void a(boolean paramBoolean1, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    if (paramBoolean1)
    {
      if ((!this.a.isFinishing()) && (this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      Object localObject = ((PoiExtraMng)this.a.app.getManager(212)).a(paramLong1);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARMapActivity", 2, "onClickPoi taskType is: " + paramInt1 + " taskInfo is null.");
        }
        localObject = ((cmd0x7b4.TaskCommonInfo)localObject).bytes_config.get().toStringUtf8();
        this.a.a((String)localObject, paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramBoolean2, paramString2, paramString3);
      }
      while (paramInt1 != 12) {
        return;
      }
      if ((!TextUtils.isEmpty(paramString2)) && (new File(paramString2 + "/res/lbscaishen").exists()))
      {
        ((LbsPackManager)this.a.app.getManager(214)).b(paramString2);
        this.a.a("{}", paramInt1, paramLong1, paramLong2, paramInt2, paramString1, paramBoolean2, paramString2, paramString3);
        LbsPackStatsCollector.a("actLbsCaiShenResourceFailure");
        return;
      }
      QQToast.a(BaseApplication.getContext(), "加载失败", 1).b(this.a.getTitleBarHeight());
      LbsPackStatsCollector.a("actLbsCaiShenResourceFailure", -10009);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ARMapActivity", 2, "openbox resource check failed!");
    }
    if ((!this.a.isFinishing()) && (this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    QQToast.a(BaseApplication.getContext(), "加载失败", 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasf
 * JD-Core Version:    0.7.0.1
 */