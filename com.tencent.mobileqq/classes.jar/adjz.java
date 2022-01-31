import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class adjz
  implements TbsReaderView.ReaderCallback
{
  public adjz(LocalTbsViewManager paramLocalTbsViewManager, Activity paramActivity, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, String paramString) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = 10386;
    switch (paramInteger.intValue())
    {
    case 19: 
    default: 
    case 12: 
    case 5000: 
    case 5012: 
    case 5045: 
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adkd(this, paramInteger));
        return;
        if (paramObject1 != null)
        {
          i = ((Bundle)paramObject1).getInt("function_id");
          paramObject1 = TbsReaderView.getResString(this.jdField_a_of_type_AndroidAppActivity, i);
          paramObject2 = TbsReaderView.getResDrawable(this.jdField_a_of_type_AndroidAppActivity, i + 1);
          Drawable localDrawable = TbsReaderView.getResDrawable(this.jdField_a_of_type_AndroidAppActivity, i + 2);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback.a(paramObject1, paramObject2, localDrawable, new adka(this, i));
          continue;
          if ((paramObject2 instanceof Bundle)) {}
          for (paramObject1 = (Bundle)paramObject2;; paramObject1 = new Bundle())
          {
            paramObject1.putBoolean("is_bar_animating", false);
            break;
          }
          if (((Integer)paramObject1).intValue() == 0)
          {
            paramObject1 = new Bundle();
            paramObject1.putString("filePath", this.jdField_a_of_type_JavaLangString);
            paramObject1.putString("tempPath", Environment.getExternalStorageDirectory() + "/TbsReaderTemp");
            LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).openFile(paramObject1);
            continue;
            QLog.e("TestTbs", 1, "WEBVIEW_GET_TITLE_HEIGHT");
            if ((paramObject2 != null) && ((paramObject2 instanceof Bundle))) {
              ((Bundle)paramObject2).putInt("TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131558448));
            }
          }
        }
      }
    }
    paramInteger = this.jdField_a_of_type_AndroidAppActivity.getString(2131435122);
    if ((paramObject1 != null) && ((paramObject1 instanceof Bundle)))
    {
      paramObject2 = (Bundle)paramObject1;
      paramInteger = paramObject2.getString("tip");
      paramObject1 = paramObject2.getString("statistics");
      i = paramObject2.getInt("channel_id", 10386);
    }
    for (;;)
    {
      paramObject2 = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=" + i;
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 233, this.jdField_a_of_type_AndroidAppActivity.getString(2131435012), paramInteger, new adkb(this, paramObject1, paramObject2), new adkc(this)).show();
      return;
      paramObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */