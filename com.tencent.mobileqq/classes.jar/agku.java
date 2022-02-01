import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class agku
  extends aofu
{
  agku(agkt paramagkt) {}
  
  protected void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (this.a.b == null) {}
    while ((!this.a.b.equals(String.valueOf(paramLong1))) || (paramBoolean)) {
      return;
    }
    String str = paramString;
    if (" onModifyTroopGameCardSwitch fail. errCode = " + paramLong2 + ", errInfo = " + paramString == null) {
      str = "";
    }
    QLog.e("TroopGameGuideHelper", 2, str);
    QQToast.a(agkt.a(this.a).getActivity(), 1, anvx.a(2131697148), 0).b(agkt.a(this.a).getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agku
 * JD-Core Version:    0.7.0.1
 */