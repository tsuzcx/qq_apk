import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class aeuf
  extends bdul
{
  public aeuf(PokePanel paramPokePanel) {}
  
  protected void onPokeAuth(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (((Bundle)localObject).getInt("fromType") != 0) {
      return;
    }
    int j = ((Bundle)localObject).getInt("id");
    int i = ((Bundle)localObject).getInt("feeType");
    String str1 = "free";
    if (i == 4)
    {
      str1 = "vip";
      label47:
      if (!paramBoolean) {
        break label160;
      }
      paramObject = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      acjm.a(PokePanel.a(this.a), BaseApplicationImpl.getContext(), PokePanel.a(this.a), 126, j, paramObject, (String)localObject);
      if (true == afxl.a) {
        afxl.a = false;
      }
      label106:
      if (!paramBoolean) {
        break label421;
      }
    }
    label160:
    label419:
    label421:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (i != 5) {
        break label47;
      }
      str1 = "svip";
      break label47;
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.a.a = paramObject.getInt("id", 0);
      String str2 = alud.a(2131708718);
      if (l == 0L)
      {
        this.a.b = 1;
        if (true != afxl.a) {
          break;
        }
        afxl.a = false;
        return;
      }
      if (l == 4002L)
      {
        this.a.b = 2;
        paramObject = alud.a(2131708721);
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label419;
        }
        afxl.a(PokePanel.a(this.a), (Activity)this.a.getContext(), paramObject, (String)localObject, this.a.a, this.a.b);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.a.b = 4;
          paramObject = alud.a(2131708720);
          localObject = str2;
        }
        else
        {
          this.a.b = 1;
          str2 = alud.a(2131708719);
          QLog.e("Q.aio.PokePanel", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuf
 * JD-Core Version:    0.7.0.1
 */