import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class acxs
  implements View.OnClickListener
{
  public acxs(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileBaseExpandableListAdapter.CloudItemHolder localCloudItemHolder = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localCloudItemHolder.a;
    paramView = QfileBaseCloudFileTabView.c(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localCloudItemHolder.c == 1)
      {
        this.a.a.a().ac();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131428327);
          return;
        }
        FileModel.a(paramView).a(false, this.a.a, new acxt(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localCloudItemHolder.c == 3)
      {
        this.a.a.a().ae();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131428327);
          return;
        }
        FileModel.a(paramView).a(false, this.a.a, new acxu(this, paramView));
      }
      else if (localCloudItemHolder.c == 0)
      {
        this.a.a.a().ab();
        localObject = new FileManagerReporter.fileAssistantReportData();
        ((FileManagerReporter.fileAssistantReportData)localObject).b = "file_viewer_in";
        ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
        ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(paramView.fileName);
        ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = paramView.fileSize;
        FileManagerReporter.a(QfileBaseCloudFileTabView.f(this.a).getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject);
        localObject = new ForwardFileInfo();
        ((ForwardFileInfo)localObject).d(paramView.getCloudType());
        ((ForwardFileInfo)localObject).b(10001);
        ((ForwardFileInfo)localObject).b(paramView.nSessionId);
        ((ForwardFileInfo)localObject).c(paramView.uniseq);
        ((ForwardFileInfo)localObject).d(paramView.fileName);
        ((ForwardFileInfo)localObject).d(paramView.fileSize);
        ((ForwardFileInfo)localObject).b(paramView.Uuid);
        paramView = new Intent(QfileBaseCloudFileTabView.a(this.a), FileBrowserActivity.class);
        paramView.putExtra("fileinfo", (Parcelable)localObject);
        QfileBaseCloudFileTabView.b(this.a).startActivityForResult(paramView, 102);
      }
      else if (localCloudItemHolder.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.g(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new acxv(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > FMConfig.a()) && (FileManagerUtil.a())) {
          FileManagerUtil.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxs
 * JD-Core Version:    0.7.0.1
 */