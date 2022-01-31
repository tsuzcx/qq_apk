import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class aask
  implements View.OnClickListener
{
  aask(aash paramaash) {}
  
  public void onClick(View paramView)
  {
    paramView = (aimb)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      apug.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aima.notifyDataSetChanged();
      return;
      if (!bbfj.d(BaseApplication.getContext()))
      {
        aptx.a(2131692666);
        return;
      }
      aptd.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new aasl(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((ajum)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        continue;
        if (!bbfj.d(BaseApplication.getContext()))
        {
          aptx.a(2131692666);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        aptd.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new aasm(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aask
 * JD-Core Version:    0.7.0.1
 */