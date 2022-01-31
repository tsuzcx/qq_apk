import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class aaiw
  implements View.OnClickListener
{
  aaiw(aait paramaait) {}
  
  public void onClick(View paramView)
  {
    paramView = (ahzk)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      apck.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ahzj.notifyDataSetChanged();
      return;
      if (!badq.d(BaseApplication.getContext()))
      {
        apcb.a(2131627028);
        return;
      }
      apbf.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new aaix(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((ajgm)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        continue;
        if (!badq.d(BaseApplication.getContext()))
        {
          apcb.a(2131627028);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        apbf.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new aaiy(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaiw
 * JD-Core Version:    0.7.0.1
 */