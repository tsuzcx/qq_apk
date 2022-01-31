import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.map.MapEngineCallback;
import com.tencent.mobileqq.armap.test.ARMainActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class abop
  implements View.OnLongClickListener
{
  public abop(ARMainActivity paramARMainActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    FileUtils.a(MapEngineCallback.getRootPath());
    if (QLog.isColorLevel()) {
      QLog.d("ARMainActivity", 2, "clear map cache");
    }
    QQToast.a(this.a, "map cache deleted", 0).a();
    ArMapUtil.a(this.a.a).edit().clear().commit();
    ArMapUtil.b(this.a.a).edit().clear().commit();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abop
 * JD-Core Version:    0.7.0.1
 */