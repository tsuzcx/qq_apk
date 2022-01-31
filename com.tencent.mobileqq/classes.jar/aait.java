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

public class aait
  extends aaji
  implements ahzl, Handler.Callback
{
  private int jdField_a_of_type_Int;
  ahzj jdField_a_of_type_Ahzj;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aodp jdField_a_of_type_Aodp;
  public QQAppInterface a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  final String jdField_a_of_type_JavaLangString = "ChatHistoryFileView<FileAssistant>";
  private List<Object> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  
  public aait()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
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
              String str = apea.a(localFileManagerEntity.srvTime);
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
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    paramLinkedHashMap = paramLinkedHashMap.values().iterator();
    while (paramLinkedHashMap.hasNext()) {
      Collections.sort((List)paramLinkedHashMap.next(), new aaiu(this));
    }
  }
  
  private void a(JSONObject paramJSONObject, LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = a(paramJSONObject);
      if (axfs.a(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFileView<FileAssistant>", 1, "tencent doc size: " + paramJSONObject.size());
        }
        paramJSONObject = paramJSONObject.iterator();
        while (paramJSONObject.hasNext())
        {
          TencentDocData localTencentDocData = (TencentDocData)paramJSONObject.next();
          String str = apea.a(localTencentDocData.aioTime);
          if (!paramLinkedHashMap.containsKey(str)) {
            paramLinkedHashMap.put(str, new ArrayList());
          }
          ((List)paramLinkedHashMap.get(str)).add(localTencentDocData);
        }
        apci.a("0X8009A9E");
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
  
  private void f()
  {
    ThreadManager.post(new ChatHistoryFileView.1(this), 8, null, true);
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
      this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
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
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aaiv(this);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aaiw(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aodp != null) {
      return;
    }
    this.jdField_a_of_type_Aodp = new aaiz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    j();
    i();
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ahzj = new ahzj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this);
    this.jdField_a_of_type_Ahzj.a(this);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131494891, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303648));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305214));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahzj);
    paramIntent = this.jdField_a_of_type_AndroidViewView.findViewById(2131300639);
    paramQQAppInterface = paramIntent.findViewById(2131307084);
    paramIntent.setVisibility(8);
    paramQQAppInterface.setVisibility(8);
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (a()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramTencentDocData);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData);
      continue;
      axfs.a(paramTencentDocData.docUrl, this.jdField_a_of_type_AndroidContentContext);
      apci.a("0X8009A9F");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (a()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        if ((paramFileManagerEntity.cloudType == 3) && (!apdh.b(paramFileManagerEntity.strFilePath)))
        {
          apcb.a(apck.d(paramFileManagerEntity.fileName) + ajjy.a(2131635806));
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
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
      if (b()) {
        break label146;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
    return;
    label146:
    k();
    Object localObject = new apcj();
    ((apcj)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((apcj)localObject).jdField_a_of_type_Int = 73;
    ((apcj)localObject).c = apdh.a(paramFileManagerEntity.fileName);
    ((apcj)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject);
    apci.a("0X8004AE4");
    localObject = new aowq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("file_browser_extra_params_uin", this.jdField_b_of_type_JavaLangString);
    }
    ((aowq)localObject).a(localBundle);
    localObject = new aows(this.jdField_a_of_type_AndroidContentContext, (aowv)localObject);
    ((aows)localObject).a(7);
    if (paramFileManagerEntity.peerType == 0) {
      ((aows)localObject).a(2);
    }
    for (;;)
    {
      ((aows)localObject).a(true);
      ((aows)localObject).a();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((aows)localObject).a(6);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aodp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      this.jdField_a_of_type_Aodp = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aodp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      this.jdField_a_of_type_Aodp = null;
    }
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ahzj.a(true);
    this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ahzj.a(false);
    this.jdField_a_of_type_Ahzj.notifyDataSetChanged();
  }
  
  public void h_(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1)
    {
      f();
      return;
    }
    g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aait
 * JD-Core Version:    0.7.0.1
 */