import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ajrx
  extends aufo
{
  public ajrx(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    paramView = (ajwd)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      auea.b(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
      return;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        audr.a(2131692469);
        return;
      }
      aucx.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new ajry(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((ansr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
        continue;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          audr.a(2131692469);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        aucx.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new ajrz(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrx
 * JD-Core Version:    0.7.0.1
 */