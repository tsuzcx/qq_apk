import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adpw
  implements View.OnClickListener
{
  adpw(adpt paramadpt) {}
  
  public void onClick(View paramView)
  {
    amgh localamgh = (amgh)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localamgh.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      auea.b(localFileManagerEntity);
    }
    switch (localamgh.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Amgg.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          audr.a(2131692469);
        }
        else
        {
          aucx.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new adpx(this, localFileManagerEntity));
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
            ((ansr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            break label247;
          }
          audr.a(2131692469);
        }
      }
      label247:
      boolean bool = localFileManagerEntity.isSend();
      aucx.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new adpy(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpw
 * JD-Core Version:    0.7.0.1
 */