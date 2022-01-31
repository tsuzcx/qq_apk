import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;

class alqm
  implements Runnable
{
  alqm(alql paramalql) {}
  
  public void run()
  {
    if (CommonDataAdapter.a().a() != null)
    {
      Object localObject1 = new DisplayMetrics();
      ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      float f = ((DisplayMetrics)localObject1).density;
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new RelativeLayout(CommonDataAdapter.a().a());
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setBackgroundColor(-855638017);
      ((RelativeLayout)localObject1).setGravity(17);
      ((RelativeLayout)localObject1).setPadding((int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F));
      localObject2 = new TextView(CommonDataAdapter.a().a());
      ((TextView)localObject2).setWidth((int)(i * 0.9D));
      ((TextView)localObject2).setHeight((int)(96.0F * f + 0.5F));
      ((TextView)localObject2).setBackgroundColor(CommonDataAdapter.a().a().getResources().getColor(2131492924));
      ((TextView)localObject2).setText(2131428540);
      ((TextView)localObject2).setTextColor(CommonDataAdapter.a().a().getResources().getColor(2131492971));
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setGravity(17);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      ToastUtil.a().a((View)localObject1, 1);
      LogUtility.c("MyAppApi", "弹出应用宝的安装Toast，当前时间 = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alqm
 * JD-Core Version:    0.7.0.1
 */