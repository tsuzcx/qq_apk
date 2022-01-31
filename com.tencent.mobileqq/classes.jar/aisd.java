import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.util.ArrayList;

public class aisd
  extends aira
{
  aisd(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.lastTimeShowToast >= 1000L)
    {
      this.a.lastTimeShowToast = l;
      QQToast.a(this.mActivity, paramString, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    }
  }
  
  private boolean a()
  {
    if ((this.mActivity != null) && (((NewPhotoListActivity)this.mActivity).getIntent() != null)) {
      return ((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("pic_back_type_result", false);
    }
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.mActivity).finish();
  }
  
  private boolean b()
  {
    return this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum;
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!b()))
    {
      a(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689820), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return false;
    }
    return super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    paramView = new Intent();
    if (a())
    {
      if (paramAdapterView == null) {}
      for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
      {
        paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
        b(paramView);
        return;
      }
    }
    if (paramAdapterView == null) {}
    for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
    {
      paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
      paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      paramView.putExtra("pic_result_back_type", 1);
      AETemplateInfoFragment.a(this.mActivity, paramView);
      break;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!b()) && (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1))
    {
      a(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689820), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
  }
  
  public void onSendBtnClick(View paramView)
  {
    if (b())
    {
      a(String.format(((NewPhotoListActivity)this.mActivity).getString(2131689821), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    AETemplateInfoFragment.a(this.mActivity, paramView);
    bliu.a().D();
    b(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131717497);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
    if (b())
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130849207);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130837724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisd
 * JD-Core Version:    0.7.0.1
 */