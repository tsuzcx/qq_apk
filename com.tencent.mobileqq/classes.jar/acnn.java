import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;

class acnn
  implements View.OnClickListener
{
  acnn(acnm paramacnm, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Acnm.a.d = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Acnm.a.b.get(this.jdField_a_of_type_Acnm.a.d);
    if ((!FileUtil.a(paramView.c())) || (FileUtil.c(paramView.c())))
    {
      FileManagerUtil.d(paramView.c());
      this.jdField_a_of_type_Acnm.a.b.remove(this.jdField_a_of_type_Acnm.a.d);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Acnm.a);
      return;
    }
    FMToastUtil.a(2131428144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnn
 * JD-Core Version:    0.7.0.1
 */