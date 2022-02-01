import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class ahec
  extends VasQuickUpdateManager.CallBacker
{
  public ahec(ahdk paramahdk) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    int i = 1;
    String str;
    if (paramLong == 21L)
    {
      paramString3 = "";
      paramString2 = Integer.valueOf(0);
      if (!paramString1.startsWith("poke.item.effect.")) {
        break label245;
      }
      str = paramString1.substring("poke.item.effect.".length(), paramString1.length());
      paramVasQuickUpdateManager = Integer.valueOf(str);
      paramString2 = paramVasQuickUpdateManager;
      paramString3 = str;
      if (!ahnt.c.contains(paramVasQuickUpdateManager)) {
        break label337;
      }
      ahnt.c.remove(paramVasQuickUpdateManager);
      paramString3 = str;
      paramString2 = paramVasQuickUpdateManager;
      paramInt2 = 1;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (paramInt2 != 0) && (!ahnt.c.contains(paramString2)) && (!ahnt.c.contains(paramString2)))
      {
        if (ahnt.a("bubble", paramString2.intValue())) {
          break label318;
        }
        paramInt2 = 1;
        label142:
        if (ahnt.a("/normal.png", paramString2.intValue())) {
          break label324;
        }
        label155:
        boolean bool = ahnt.b.contains(paramString2);
        paramString3 = this.a.a;
        if ((paramInt2 == 0) || (i == 0) || (!bool)) {
          break label330;
        }
      }
      label318:
      label324:
      label330:
      for (paramString2 = anzj.a(2131704177);; paramString2 = "")
      {
        bhto.a(paramString3, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "vas poke download id: " + paramString1 + " , errorcode: " + paramInt1);
        }
        return;
        label245:
        if (!paramString1.startsWith("poke.item.res.")) {
          break label337;
        }
        str = paramString1.substring("poke.item.res.".length(), paramString1.length());
        paramVasQuickUpdateManager = Integer.valueOf(str);
        paramString2 = paramVasQuickUpdateManager;
        paramString3 = str;
        if (!ahnt.d.contains(paramVasQuickUpdateManager)) {
          break label337;
        }
        ahnt.d.remove(paramVasQuickUpdateManager);
        paramString3 = str;
        paramString2 = paramVasQuickUpdateManager;
        paramInt2 = 1;
        break;
        paramInt2 = 0;
        break label142;
        i = 0;
        break label155;
      }
      label337:
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahec
 * JD-Core Version:    0.7.0.1
 */