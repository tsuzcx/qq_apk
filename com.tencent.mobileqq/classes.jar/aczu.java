import android.os.AsyncTask;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;

class aczu
  extends AsyncTask
{
  aczu(aczt paramaczt) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.a).a();
    int i = SendBottomBar.a(this.a.a).a();
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(FMDataCache.b());
      return null;
    }
    if (paramVarArgs.equals(AppConstants.y))
    {
      paramVarArgs = FMDataCache.b();
      ((DataLineHandler)SendBottomBar.a(this.a.a).a(8)).a(paramVarArgs);
      return null;
    }
    if (i == 6002)
    {
      localObject = FMDataCache.b();
      ((RouterHandler)SendBottomBar.a(this.a.a).a(48)).a((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
      return null;
    }
    if (i == 9501)
    {
      ((DeviceMsgHandle)SendBottomBar.a(this.a.a).a(49)).a().a(paramVarArgs, FMDataCache.b());
      return null;
    }
    Object localObject = SendBottomBar.a(this.a.a).b();
    SendBottomBar.a(this.a.a).a().a((String)localObject, paramVarArgs, i);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.a.d();
    FMDataCache.b();
    SendBottomBar.d(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczu
 * JD-Core Version:    0.7.0.1
 */