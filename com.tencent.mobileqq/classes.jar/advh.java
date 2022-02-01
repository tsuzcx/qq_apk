import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class advh
  implements View.OnClickListener
{
  advh(adve paramadve) {}
  
  public void onClick(View paramView)
  {
    ambt localambt = (ambt)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localambt.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      atvo.b(localFileManagerEntity);
    }
    switch (localambt.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ambs.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!bgnt.d(BaseApplication.getContext()))
        {
          atvf.a(2131692314);
        }
        else
        {
          atul.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new advi(this, localFileManagerEntity));
          break;
          this.a.a(localFileManagerEntity);
          break;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((anjx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          break;
          if (bgnt.d(BaseApplication.getContext())) {
            break label246;
          }
          atvf.a(2131692314);
        }
      }
      label246:
      boolean bool = localFileManagerEntity.isSend();
      atul.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new advj(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advh
 * JD-Core Version:    0.7.0.1
 */