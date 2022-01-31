import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adrr
  implements View.OnClickListener
{
  public adrr(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    int i = TroopFileUtils.a(SendBottomBar.a(this.a));
    if (i == 0)
    {
      TroopFileError.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131429788));
      this.a.c();
      return;
    }
    if (1 == i)
    {
      adru localadru = new adru(this);
      DialogUtil.b(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131429769), SendBottomBar.a(this.a).getString(2131429774), 2131433029, 2131429732, localadru, localadru).show();
      return;
    }
    this.a.c();
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (SendBottomBar.a(this.a)) {
      return;
    }
    SendBottomBar.a(this.a, true);
    new Handler().postDelayed(new adrs(this), 800L);
    int j;
    switch (SendBottomBar.a(this.a).b())
    {
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      j = SendBottomBar.a(this.a).a();
      if (j != 1) {
        break;
      }
    }
    for (;;)
    {
      if (j != 5) {
        break label374;
      }
      this.a.c();
      return;
      if (SendBottomBar.a(this.a).c())
      {
        paramView = new Intent();
        paramView.putParcelableArrayListExtra("reslut_select_file_info_list", FMDataCache.b());
        paramView.putExtra("approval_attachment_customid", SendBottomBar.a(this.a).e());
        SendBottomBar.a(this.a).setResult(-1, paramView);
      }
      SendBottomBar.a(this.a).finish();
      return;
      SendBottomBar.b(this.a);
      return;
      if ((FileManagerUtil.a()) && (FMDataCache.b() > FMConfig.a()))
      {
        FMDialogUtil.a(SplashActivity.sTopActivity, 2131428241, 2131428237, new adrt(this));
        return;
      }
      paramView = FMDataCache.b();
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
      SendBottomBar.a(this.a).setResult(-1, localIntent);
      SendBottomBar.a(this.a).finish();
      return;
      paramView = SendBottomBar.a(this.a).getIntent();
      if (paramView == null) {
        break;
      }
      if (paramView.getStringExtra("posturl") != null)
      {
        paramView.putParcelableArrayListExtra("fileinfo", FMDataCache.b());
        SendBottomBar.a(this.a).setResult(-1, paramView);
        SendBottomBar.a(this.a).finish();
        return;
      }
      SendBottomBar.a(this.a).setResult(-1, paramView);
      SendBottomBar.a(this.a).finish();
      return;
      i = 0;
    }
    label374:
    if (i != 0)
    {
      a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adrr
 * JD-Core Version:    0.7.0.1
 */