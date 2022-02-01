import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class agrc
  implements AdapterView.OnItemClickListener
{
  agrc(agra paramagra, List paramList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Agra.a, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", new ArrayList(this.jdField_a_of_type_JavaUtilList));
    localBundle.putBoolean("from_photo_wall", false);
    localBundle.putBoolean("SHOW_MENU", true);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", true);
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_Agra.a.startActivity(localIntent);
    bcef.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", agra.a(this.jdField_a_of_type_Agra), "精选照片");
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrc
 * JD-Core Version:    0.7.0.1
 */