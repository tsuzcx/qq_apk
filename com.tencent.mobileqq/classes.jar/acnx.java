import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class acnx
  implements View.OnClickListener
{
  acnx(acnu paramacnu) {}
  
  public void onClick(View paramView)
  {
    paramView = (akib)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      arrr.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Akia.notifyDataSetChanged();
      return;
      if (!bdin.d(BaseApplication.getContext()))
      {
        arri.a(2131692747);
        return;
      }
      arqo.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new acny(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((alqo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        continue;
        if (!bdin.d(BaseApplication.getContext()))
        {
          arri.a(2131692747);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        arqo.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new acnz(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnx
 * JD-Core Version:    0.7.0.1
 */