import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.weiyun.AlbumBackupProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class acyx
  implements View.OnClickListener
{
  public acyx(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFileAssistantActivity.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i(QfileFileAssistantActivity.e, 2, "click too fast , wait a minute.");
      }
    }
    Object localObject1;
    long l;
    do
    {
      do
      {
        return;
        QfileFileAssistantActivity.a(this.a);
        switch (paramView.getId())
        {
        default: 
          localObject1 = (FileCategoryAdapter.ItemHolder)paramView.getTag();
        }
      } while (((FileCategoryAdapter.ItemHolder)localObject1).a == 0);
      l = ((FileCategoryAdapter.ItemHolder)localObject1).a;
      paramView = (RedTouchManager)this.a.app.getManager(35);
      switch ((int)l)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileFileAssistantActivity.e, 2, "unknow category!!! return onClick");
    return;
    paramView = FMConfig.b();
    FileManagerUtil.a(this.a, paramView);
    FileManagerReporter.a("0X8007FA3");
    return;
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.b = "file_assistant_in";
    paramView.a = 1;
    FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramView);
    paramView = new Intent(this.a.getApplicationContext(), LiteActivity.class);
    if (this.a.g) {
      FileManagerReporter.a("0X8005534");
    }
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("category", l);
        paramView.putExtra("bundle", (Bundle)localObject1);
        paramView.putExtra("from", "FileAssistant");
        this.a.startActivityForResult(paramView, 101);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      FileManagerReporter.a("0X800681A");
      continue;
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.b = "file_assistant_in";
      paramView.a = 2;
      FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramView);
      paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramView.putExtra("tab_tab_type", 7);
      if (this.a.g)
      {
        FileManagerReporter.a("0X8005537");
      }
      else
      {
        FileManagerReporter.a("0X800681D");
        continue;
        paramView = new FileManagerReporter.fileAssistantReportData();
        paramView.b = "file_assistant_in";
        paramView.a = 3;
        FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramView);
        QfileFileAssistantActivity.b(this.a);
        if (this.a.g)
        {
          FileManagerReporter.a("0X800553A");
          return;
        }
        FileManagerReporter.a("0X8006820");
        return;
        localObject1 = paramView.a(String.valueOf("100160.100163"));
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
          paramView.b(String.valueOf("100160.100163"));
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("service_type", 2);
          ((JSONObject)localObject2).put("act_id", 1002);
          ((JSONObject)localObject2).put("obj_id", "");
          ((JSONObject)localObject2).put("pay_amt", 0);
          paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
          QfileFileAssistantActivity.c(this.a);
          return;
        }
        catch (JSONException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
        paramView = new Bundle();
        paramView.putBoolean("string_from", false);
        paramView.putBoolean("string_uin", false);
        paramView.putLong("device_din", 0L);
        paramView.putInt("sTitleID", 0);
        QQProxyForDataline.a(this.a, paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
        if (this.a.g)
        {
          FileManagerReporter.a("0X8005539");
          return;
        }
        FileManagerReporter.a("0X800681F");
        return;
        paramView = new FileManagerReporter.fileAssistantReportData();
        paramView.b = "file_assistant_in";
        paramView.a = 10;
        FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramView);
        paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
        paramView.putExtra("tab_tab_type", 1);
        if (this.a.g) {
          FileManagerReporter.a("0X8005538");
        } else {
          FileManagerReporter.a("0X800681E");
        }
      }
    }
    AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
    this.a.overridePendingTransition(2131034132, 2131034133);
    ReportController.b(this.a.app, "CliOper", "", "", "Weiyun_Backup", "Enter_Backup", 0, 0, "", "", "", "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    JSONObject localJSONObject;
    if (((FileCategoryAdapter.ItemHolder)localObject1).c != null)
    {
      localObject2 = String.valueOf("100160.100162");
      localAppInfo = paramView.a((String)localObject2);
      if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("service_type", 2);
      localJSONObject.put("act_id", 1002);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      paramView.b(localAppInfo, localJSONObject.toString());
      label912:
      paramView.b((String)localObject2);
      ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(8);
      CustomWidgetUtil.a(((FileCategoryAdapter.ItemHolder)localObject1).c, 0, 0, 0);
      if (this.a.g)
      {
        FileManagerReporter.a("0X8005536");
        return;
      }
      FileManagerReporter.a("0X800681C");
      return;
      QfileFileAssistantActivity.d(this.a);
      localObject1 = paramView.a(String.valueOf("100160.100161"));
      if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
        paramView.b(String.valueOf("100160.100161"));
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("service_type", 2);
        ((JSONObject)localObject2).put("act_id", 1002);
        paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
        if (this.a.g)
        {
          FileManagerReporter.a("0X8005535");
          return;
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
        FileManagerReporter.a("0X800681B");
        return;
      }
      if (Build.VERSION.SDK_INT < 26)
      {
        FileManagerUtil.a(this.a, "_is_from_qfile_shortcut", this.a.getString(2131428093), 2130841686);
        FMToastUtil.b(2131428092);
      }
      for (;;)
      {
        ((FileCategoryAdapter.ItemHolder)localObject1).e.setClickable(false);
        ((FileCategoryAdapter.ItemHolder)localObject1).e.setOnClickListener(null);
        ((FileCategoryAdapter.ItemHolder)localObject1).e.setText(this.a.getString(2131428091));
        FileManagerReporter.a("0X8005532");
        return;
        FileManagerUtil.b(this.a, "_is_from_qfile_shortcut", this.a.getString(2131428093), 2130841686);
      }
    }
    catch (JSONException localJSONException)
    {
      break label912;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyx
 * JD-Core Version:    0.7.0.1
 */