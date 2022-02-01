import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aczk
  implements View.OnClickListener
{
  aczk(aczh paramaczh) {}
  
  public void onClick(View paramView)
  {
    alih localalih = (alih)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localalih.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      aszt.b(localFileManagerEntity);
    }
    switch (localalih.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Alig.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          aszk.a(2131692367);
        }
        else
        {
          asyq.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new aczl(this, localFileManagerEntity));
          break;
          this.a.a(localFileManagerEntity);
          break;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((amqd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            break label246;
          }
          aszk.a(2131692367);
        }
      }
      label246:
      boolean bool = localFileManagerEntity.isSend();
      asyq.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new aczm(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczk
 * JD-Core Version:    0.7.0.1
 */