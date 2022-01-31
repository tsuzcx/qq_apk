import android.content.Intent;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

public class adli
  extends ShieldListObserver
{
  public adli(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (this.a.a == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.h(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", false);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    if (this.a.a == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.h(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", true);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adli
 * JD-Core Version:    0.7.0.1
 */