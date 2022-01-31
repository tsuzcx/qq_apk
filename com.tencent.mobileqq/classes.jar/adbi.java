import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class adbi
  implements View.OnClickListener
{
  public adbi(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ac();
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131428327);
        return;
      }
      if (localFileManagerEntity.status == 16)
      {
        FMToastUtil.a(2131428188);
        return;
      }
      FileModel.a(localFileManagerEntity).a(false, this.a.getContext(), new adbj(this, localFileManagerEntity));
      continue;
      this.a.a.a().ab();
      this.a.c(localFileManagerEntity);
      continue;
      this.a.a.a().ad();
      if (localFileManagerEntity.getCloudType() == 0)
      {
        QfileBaseRecentFileTabView.v(this.a).a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((DataLineHandler)QfileBaseRecentFileTabView.w(this.a).a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        QfileBaseRecentFileTabView.x(this.a).a().a(localFileManagerEntity.nSessionId);
        continue;
        this.a.a.a().ae();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131428327);
          return;
        }
        if (localFileManagerEntity.status == 16)
        {
          FMToastUtil.a(2131428188);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        FileModel.a(localFileManagerEntity).a(bool, this.a.a, new adbk(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbi
 * JD-Core Version:    0.7.0.1
 */