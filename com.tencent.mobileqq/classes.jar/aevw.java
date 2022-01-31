import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.widget.NearbyFacePowerDialog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class aevw
  implements View.OnClickListener
{
  public aevw(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    int i;
    if ((NearbyProfileFragment.a(this.a).nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)NearbyProfileFragment.a(this.a).nearbyNowData.get()).master_state.get() != null))
    {
      i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)NearbyProfileFragment.a(this.a).nearbyNowData.get()).master_state.get()).uint32_state.get();
      paramView = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)NearbyProfileFragment.a(this.a).nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
    }
    for (;;)
    {
      if ((i == 1) || (!NearbyDataManager.a(this.a.a.app)))
      {
        paramView = new Intent(this.a.a, NearbyVisitorListActivity.class);
        paramView.putExtra("charmlevel", NearbyProfileFragment.a(this.a).charmLevel);
        paramView.putExtra("download_tribe_app_url", NearbyProfileFragment.a(this.a).tribeAppDownloadPageUrl);
        paramView.putExtra("is_show_tribeapp_download_layout", NearbyProfileFragment.a(this.a).isAddPicBtnDownloadAppOpen());
        this.a.a.startActivity(paramView);
        NearbyProfileFragment.a(this.a, null);
        ThreadManager.post(new aevx(this), 5, null, false);
      }
      for (;;)
      {
        ReportController.b(this.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
        return;
        NearbyFacePowerDialog localNearbyFacePowerDialog = new NearbyFacePowerDialog(this.a.a);
        localNearbyFacePowerDialog.a(new aevy(this, paramView, localNearbyFacePowerDialog));
        localNearbyFacePowerDialog.show();
      }
      paramView = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevw
 * JD-Core Version:    0.7.0.1
 */