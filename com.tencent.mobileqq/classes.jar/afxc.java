import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public class afxc
  extends apwx
{
  public afxc(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    paramView = (aimd)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      apue.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
      return;
      if (!bbev.d(BaseApplication.getContext()))
      {
        aptv.a(2131692665);
        return;
      }
      apsz.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new afxd(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((ajuo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        continue;
        if (!bbev.d(BaseApplication.getContext()))
        {
          aptv.a(2131692665);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        apsz.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new afxe(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxc
 * JD-Core Version:    0.7.0.1
 */