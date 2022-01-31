import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.GroupItem;
import com.tencent.qidian.data.PublicAccountItem;
import com.tencent.qidian.data.QidianExternalInfo;
import java.util.Iterator;
import java.util.List;

public class akxh
  implements Runnable
{
  public akxh(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    int j = 0;
    LinearLayout localLinearLayout1 = (LinearLayout)this.a.getLayoutInflater().inflate(2130970051, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131362823);
    int i = j;
    Object localObject1;
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
    {
      i = j;
      if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems() != null)
      {
        i = j;
        if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().size() > 0)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().iterator();
          i = 0;
          if (!((Iterator)localObject1).hasNext()) {
            break label837;
          }
          localObject2 = (GroupItem)((Iterator)localObject1).next();
          if (i < 4) {
            break label388;
          }
        }
      }
    }
    label388:
    label558:
    label698:
    label832:
    label837:
    for (;;)
    {
      j = i;
      if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
      {
        j = i;
        if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems() != null)
        {
          j = i;
          if (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().size() > 0)
          {
            localObject1 = this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label832;
            }
            localObject2 = (PublicAccountItem)((Iterator)localObject1).next();
            if (i < 4) {
              break label558;
            }
          }
        }
      }
      for (j = i;; j = i)
      {
        if (j > 0) {
          this.a.b.addView(localLinearLayout1);
        }
        if ((this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos() != null) && (this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
        {
          localLinearLayout1 = (LinearLayout)this.a.getLayoutInflater().inflate(2130970050, null);
          localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131362823);
          localObject1 = new PhotoWallViewForQiDianProfile(this.a.getApplicationContext());
          ((PhotoWallViewForQiDianProfile)localObject1).setPhotoWallCallback(this.a.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback);
          localObject2 = this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
          ((PhotoWallViewForQiDianProfile)localObject1).a(this.a.getApplicationContext(), (List)localObject2);
          ((PhotoWallViewForQiDianProfile)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          localLinearLayout2.addView((View)localObject1);
          this.a.b.addView(localLinearLayout1);
        }
        return;
        RelativeLayout localRelativeLayout = (RelativeLayout)this.a.getLayoutInflater().inflate(2130970052, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131362701);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131362736);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131362702);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131363561);
        localURLImageView.post(new akxi(this, (GroupItem)localObject2, localURLImageView));
        localTextView1.setText(String.valueOf(((GroupItem)localObject2).jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.a));
        localTextView2.setText("企业群");
        localRelativeLayout.setTag(new DataTag(51, String.valueOf(((GroupItem)localObject2).jdField_a_of_type_Long)));
        localImageView.setVisibility(8);
        localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        localRelativeLayout = (RelativeLayout)this.a.getLayoutInflater().inflate(2130970052, null);
        localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131362701);
        localTextView1 = (TextView)localRelativeLayout.findViewById(2131362736);
        localImageView = (ImageView)localRelativeLayout.findViewById(2131362702);
        localTextView2 = (TextView)localRelativeLayout.findViewById(2131363561);
        localURLImageView.post(new akxj(this, (PublicAccountItem)localObject2, localURLImageView));
        localTextView1.setText(((PublicAccountItem)localObject2).jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.a));
        if (((PublicAccountItem)localObject2).jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131427333);
          localRelativeLayout.setTag(new DataTag(49, ((PublicAccountItem)localObject2).jdField_a_of_type_JavaLangString));
          if ((((PublicAccountItem)localObject2).jdField_a_of_type_Int != 0) || (((PublicAccountItem)localObject2).jdField_b_of_type_Int != 1)) {
            break label788;
          }
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130840648);
        }
        for (;;)
        {
          localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
          i += 1;
          break;
          if (((PublicAccountItem)localObject2).jdField_a_of_type_Int != 1) {
            break label698;
          }
          localTextView2.setText(2131427334);
          localRelativeLayout.setTag(new DataTag(50, localObject2));
          break label698;
          if ((((PublicAccountItem)localObject2).jdField_a_of_type_Int == 1) && (((PublicAccountItem)localObject2).jdField_b_of_type_Int == 1))
          {
            localImageView.setVisibility(0);
            localImageView.setBackgroundResource(2130841689);
          }
          else
          {
            localImageView.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akxh
 * JD-Core Version:    0.7.0.1
 */