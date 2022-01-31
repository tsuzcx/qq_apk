import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryFileView.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class acjf
  extends acju
  implements akdn, Handler.Callback
{
  private int jdField_a_of_type_Int;
  akdl jdField_a_of_type_Akdl;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aqnl jdField_a_of_type_Aqnl;
  public QQAppInterface a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  final String jdField_a_of_type_JavaLangString = "ChatHistoryFileView<FileAssistant>";
  private List<Object> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  
  public acjf()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  }
  
  private ArrayList<TencentDocData> a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") == 0)
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("recent_file_list");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i);
          TencentDocData localTencentDocData = new TencentDocData();
          JSONObject localJSONObject2 = (JSONObject)localJSONObject1.get("doc_info");
          localTencentDocData.peerTips = localJSONObject1.getString("peer_tips");
          TencentDocData.obtainFromJsonObject(localJSONObject2, (JSONObject)localJSONObject1.get("qq_share_common_msg"), localTencentDocData);
          localArrayList.add(localTencentDocData);
          i += 1;
        }
        return localArrayList;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFileView<FileAssistant>", 1, paramJSONObject.getMessage());
      }
    }
    return null;
  }
  
  private LinkedHashMap<String, List<Object>> a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio)) {
        if (this.jdField_a_of_type_Int == 1)
        {
          if ((localFileManagerEntity.nFileType != 3) && (localFileManagerEntity.nFileType != 9) && (localFileManagerEntity.nFileType != 7) && (localFileManagerEntity.nFileType != 6) && (localFileManagerEntity.nFileType != 10)) {}
        }
        else {
          do
          {
            do
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("ChatHistoryFileView<FileAssistant>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
              }
              String str = aroy.a(localFileManagerEntity.srvTime);
              if (!localLinkedHashMap.containsKey(str)) {
                localLinkedHashMap.put(str, new ArrayList());
              }
              ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
              break;
            } while (this.jdField_a_of_type_Int != 3);
            if ((localFileManagerEntity.nFileType == 3) || (localFileManagerEntity.nFileType == 9) || (localFileManagerEntity.nFileType == 7) || (localFileManagerEntity.nFileType == 6) || (localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 10)) {
              break;
            }
          } while (localFileManagerEntity.nFileType != 2);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void a()
  {
    ThreadManager.post(new ChatHistoryFileView.1(this), 8, null, true);
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    paramLinkedHashMap = paramLinkedHashMap.values().iterator();
    while (paramLinkedHashMap.hasNext()) {
      Collections.sort((List)paramLinkedHashMap.next(), new acjg(this));
    }
  }
  
  private void a(JSONObject paramJSONObject, LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = a(paramJSONObject);
      if (badt.a(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFileView<FileAssistant>", 1, "tencent doc size: " + paramJSONObject.size());
        }
        paramJSONObject = paramJSONObject.iterator();
        while (paramJSONObject.hasNext())
        {
          TencentDocData localTencentDocData = (TencentDocData)paramJSONObject.next();
          String str = aroy.a(localTencentDocData.aioTime);
          if (!paramLinkedHashMap.containsKey(str)) {
            paramLinkedHashMap.put(str, new ArrayList());
          }
          ((List)paramLinkedHashMap.get(str)).add(localTencentDocData);
        }
        arng.a("0X8009A9E");
      }
      a(paramLinkedHashMap);
    }
    paramJSONObject = new Message();
    paramJSONObject.what = 1;
    paramJSONObject.obj = paramLinkedHashMap;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramJSONObject);
  }
  
  private void b(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        Iterator localIterator = paramLinkedHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(str);
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramLinkedHashMap.get(str));
        }
      }
    }
  }
  
  private void g()
  {
    b(a());
    h();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Akdl.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new acjh(this);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acji(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    g();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
    i();
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Akdl = new akdl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this);
    this.jdField_a_of_type_Akdl.a(this);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560637, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369552));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371196));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akdl);
    paramIntent = this.jdField_a_of_type_AndroidViewView.findViewById(2131366329);
    paramQQAppInterface = paramIntent.findViewById(2131373235);
    paramIntent.setVisibility(8);
    paramQQAppInterface.setVisibility(8);
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (b()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramTencentDocData);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Akdl.notifyDataSetChanged();
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData);
      continue;
      badt.a(paramTencentDocData.docUrl, this.jdField_a_of_type_AndroidContentContext);
      arng.a("0X8009A9F");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (b()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        if ((paramFileManagerEntity.cloudType == 3) && (!arof.b(paramFileManagerEntity.strFilePath)))
        {
          armz.a(arni.d(paramFileManagerEntity.fileName) + alpo.a(2131701974));
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Akdl.notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
      break;
      if (c()) {
        break label146;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
    return;
    label146:
    k();
    Object localObject = new arnh();
    ((arnh)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((arnh)localObject).jdField_a_of_type_Int = 73;
    ((arnh)localObject).c = arof.a(paramFileManagerEntity.fileName);
    ((arnh)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (arnh)localObject);
    arng.a("0X8004AE4");
    localObject = new arhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("file_browser_extra_params_uin", this.jdField_b_of_type_JavaLangString);
    }
    ((arhh)localObject).a(localBundle);
    localObject = new arhj(this.jdField_a_of_type_AndroidContentContext, (arhm)localObject);
    ((arhj)localObject).a(7);
    if (paramFileManagerEntity.peerType == 0) {
      ((arhj)localObject).a(2);
    }
    for (;;)
    {
      ((arhj)localObject).a(true);
      ((arhj)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((arhj)localObject).a(6);
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      return;
    }
    this.jdField_a_of_type_Aqnl = new acjl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aqnl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
      this.jdField_a_of_type_Aqnl = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aqnl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
      this.jdField_a_of_type_Aqnl = null;
    }
    super.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Akdl.a(true);
    this.jdField_a_of_type_Akdl.notifyDataSetChanged();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Akdl.a(false);
    this.jdField_a_of_type_Akdl.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    b((LinkedHashMap)paramMessage.obj);
    h();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjf
 * JD-Core Version:    0.7.0.1
 */