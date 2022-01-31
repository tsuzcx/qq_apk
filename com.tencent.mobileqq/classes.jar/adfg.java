import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import mqq.os.MqqHandler;

public class adfg
  extends VasQuickUpdateManager.CallBacker
{
  public adfg(HiBoomPanelView paramHiBoomPanelView) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 5L) && (paramString1.startsWith("font.hifont.android.")))
    {
      paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
      if (TextUtils.isDigitsOnly(paramString1))
      {
        paramInt2 = Integer.parseInt(paramString1);
        if (this.a.a != null) {
          ThreadManager.getUIHandler().post(new adfh(this, paramInt1, paramInt2));
        }
      }
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 5L) && (paramString1.startsWith("font.hifont.android.")))
    {
      paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
      if (TextUtils.isDigitsOnly(paramString1))
      {
        int i = Integer.parseInt(paramString1);
        if (this.a.a != null) {
          ThreadManager.getUIHandler().post(new adfi(this, i, paramLong2, paramLong3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adfg
 * JD-Core Version:    0.7.0.1
 */