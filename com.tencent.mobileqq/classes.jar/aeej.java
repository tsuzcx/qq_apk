import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aeej
  implements View.OnClickListener
{
  aeej(aeeg paramaeeg) {}
  
  public void onClick(View paramView)
  {
    amnn localamnn = (amnn)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localamnn.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      aunj.b(localFileManagerEntity);
    }
    switch (localamnn.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Amnm.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!bhnv.d(BaseApplication.getContext()))
        {
          auna.a(2131692319);
        }
        else
        {
          aumg.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new aeek(this, localFileManagerEntity));
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
            ((anvu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          break;
          if (bhnv.d(BaseApplication.getContext())) {
            break label246;
          }
          auna.a(2131692319);
        }
      }
      label246:
      boolean bool = localFileManagerEntity.isSend();
      aumg.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new aeel(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeej
 * JD-Core Version:    0.7.0.1
 */