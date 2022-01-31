import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ajqh
  extends BroadcastReceiver
{
  ajqh(ajqg paramajqg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-onReceive:" + hashCode() + ", action=" + paramContext);
    }
    if (paramContext.equals("com.tencent.mobileqq.addLbsObserver")) {
      if (ajqg.a(this.a) != null) {
        ajqg.a(this.a).addObserver(ajqg.a(this.a));
      }
    }
    do
    {
      do
      {
        int i;
        int j;
        int k;
        int m;
        int n;
        do
        {
          String str;
          int i1;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!paramContext.equals("com.tencent.mobileqq.removeLbsObserver")) {
                    break;
                  }
                } while (ajqg.a(this.a) == null);
                ajqg.a(this.a).removeObserver(ajqg.a(this.a));
                return;
                if (!paramContext.equals("com.tencent.mobileqq.getStreetViewUrl")) {
                  break;
                }
              } while (ajqg.a(this.a) == null);
              ((ajlf)ajqg.a(this.a).a(3)).b((int)(paramIntent.getDoubleExtra("latitude", 0.0D) * 1000000.0D), (int)(paramIntent.getDoubleExtra("longitude", 0.0D) * 1000000.0D));
              return;
              if (!paramContext.equals("com.tencent.mobileqq.unregisterReceiver")) {
                break;
              }
              try
              {
                ajqg.a(this.a).unregisterReceiver(ajqg.a(this.a));
                return;
              }
              catch (Exception paramContext) {}
            } while (!QLog.isColorLevel());
            QLog.w("QQMapActivityProxy", 2, "mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + paramContext.toString());
            return;
            if (!paramContext.equals("com.tencent.mobileqq.getLbsShareSearch")) {
              break;
            }
            i = paramIntent.getIntExtra("latitude", 0);
            j = paramIntent.getIntExtra("longitude", 0);
            k = paramIntent.getIntExtra("coordinate", 0);
            paramContext = paramIntent.getStringExtra("keyword");
            str = paramIntent.getStringExtra("category");
            m = paramIntent.getIntExtra("page", 0);
            n = paramIntent.getIntExtra("count", 0);
            i1 = paramIntent.getIntExtra("requireMyLbs", 0);
          } while (ajqg.a(this.a) == null);
          ((ajlf)ajqg.a(this.a).a(3)).a(i, j, k, paramContext, str, m, n, i1);
          return;
          if (!paramContext.equals("com.tencent.mobileqq.getLbsShareShop")) {
            break;
          }
          i = paramIntent.getIntExtra("latitude", 0);
          j = paramIntent.getIntExtra("longitude", 0);
          k = paramIntent.getIntExtra("coordinate", 0);
          m = paramIntent.getIntExtra("begin", 0);
          n = paramIntent.getIntExtra("count", 0);
        } while (ajqg.a(this.a) == null);
        ((ajlf)ajqg.a(this.a).a(3)).a(i, j, k, m, n);
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.getShareShopDetail"));
      paramContext = paramIntent.getStringExtra("shop_id");
    } while ((TextUtils.isEmpty(paramContext)) || (ajqg.a(this.a) == null));
    paramIntent = new ArrayList();
    paramIntent.add(paramContext);
    ((ajlf)ajqg.a(this.a).a(3)).a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqh
 * JD-Core Version:    0.7.0.1
 */