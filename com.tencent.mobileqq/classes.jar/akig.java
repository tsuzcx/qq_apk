import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkElement;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class akig
  extends akic
{
  private anyw jdField_a_of_type_Anyw;
  public Object a;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
  private ArrayList<C2CLinkElement> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected List<akjl> a;
  public Set<Long> a;
  
  public akig(Context paramContext, blha paramblha, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramblha, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Anyw = ((anyw)paramQQAppInterface.getManager(51));
  }
  
  public C2CLinkElement a(int paramInt)
  {
    Object localObject = ((akjl)getItem(paramInt)).a;
    try
    {
      localObject = bfmb.a(((MessageRecord)localObject).msgData);
      if (localObject != null)
      {
        localObject = (C2CLinkElement)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("C2CLinkMessageResultAdapter", 2, new Object[] { "getLinkElement, e:", localException.toString() });
      return null;
    }
    return null;
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramString.hasNext())
    {
      C2CLinkElement localC2CLinkElement = (C2CLinkElement)paramString.next();
      MessageForText localMessageForText = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localC2CLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localC2CLinkElement.description());
      localMessageForText.msgData = bfmb.a(localC2CLinkElement);
      localMessageForText.senderuin = localC2CLinkElement.sendUin;
      localMessageForText.issend = localC2CLinkElement.isSend;
      paramSessionInfo.mSearchData1.add(localMessageForText);
    }
    paramSessionInfo.mSearchData2 = new ArrayList();
    return paramSessionInfo;
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new C2CLinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<Object> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      localObject = C2CLinkElement.parseFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject, this.jdField_a_of_type_Anyw, this.jdField_a_of_type_JavaTextSimpleDateFormat, i);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void a(List<akjl> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setMessageItems loadType: ").append(paramInt1).append(", searchMode: ").append(paramInt2).append(", cloudGetCompleted: ").append(paramBoolean).append(", messageItems size: ");
      if (paramList == null)
      {
        i = 0;
        QLog.d("C2CLinkMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label98;
      }
      this.b = paramList;
    }
    label98:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          this.b.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      if ((this.b.size() <= 0) || (paramList.size() <= 0)) {
        break label237;
      }
      localObject = (akjl)paramList.get(0);
      akjl localakjl = (akjl)this.b.get(this.b.size() - 1);
      if (((akjl)localObject).a.time <= localakjl.a.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CLinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.b.addAll(paramList);
  }
  
  public void a(List<akjl> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CLinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akjl localakjl = (akjl)getItem(paramInt);
    akid localakid;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559337, null);
      localakid = new akid();
      localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131379042));
      localakid.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365412));
      localakid.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368212));
      paramView.setTag(localakid);
    }
    for (;;)
    {
      localObject = localakjl.a;
      try
      {
        localObject = bfmb.a(((MessageRecord)localObject).msgData);
        if (localObject == null) {
          break;
        }
        localObject = (C2CLinkElement)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CharSequence localCharSequence;
          continue;
          localObject = null;
        }
      }
      if (localObject != null)
      {
        localCharSequence = localakjl.a(((C2CLinkElement)localObject).title, -11353092);
        localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localCharSequence);
        localakid.jdField_a_of_type_AndroidWidgetTextView.setText(localakjl.a(((C2CLinkElement)localObject).timeSecond, -11353092));
        akfw.a(localakid.jdField_a_of_type_AndroidWidgetImageView, ((C2CLinkElement)localObject).iconUrl);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localakid = (akid)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akig
 * JD-Core Version:    0.7.0.1
 */