import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aite
  extends airj
{
  private final String a;
  
  aite(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_JavaLangString = "PhotoPreviewLogicAEPlay";
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Airg.lastTimeShowToast >= 700L)
    {
      this.jdField_a_of_type_Airg.lastTimeShowToast = l;
      QQToast.a(this.mActivity, paramString, 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
    }
  }
  
  private boolean c()
  {
    return this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum;
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new aitf(this));
  }
  
  public void onSelectClick(View paramView)
  {
    if ((!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()))) && (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      c(String.format(((NewPhotoPreviewActivity)this.mActivity).getString(2131689820), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    super.onSelectClick(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoPreviewActivity)this.mActivity).getString(2131717497);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText(str);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
    if (c())
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130849207);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130837724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aite
 * JD-Core Version:    0.7.0.1
 */