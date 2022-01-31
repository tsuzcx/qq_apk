import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public class afxa
  extends apwz
{
  public afxa(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
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
      ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
      return;
      if (!bbfj.d(BaseApplication.getContext()))
      {
        aptx.a(2131692666);
        return;
      }
      aptd.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new afxb(this, localFileManagerEntity));
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
        aptd.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new afxc(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxa
 * JD-Core Version:    0.7.0.1
 */