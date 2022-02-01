import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.1;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.2;
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
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ajws
  extends akbp
{
  public Object a;
  private SimpleDateFormat a;
  public List<akcy> a;
  public Set<Long> a;
  private List<TroopLinkElement> c;
  
  public ajws(Context paramContext, bkyc parambkyc, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambkyc, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      MessageForText localMessageForText = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localTroopLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localTroopLinkElement.description());
      localMessageForText.msgData = bfce.a(localTroopLinkElement);
      localMessageForText.shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      if (localMessageForText.msg.contains(paramString)) {
        paramSessionInfo.mSearchData1.add(localMessageForText);
      }
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
    ThreadManager.post(new LinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<TroopLinkElement> paramList)
  {
    this.c = paramList;
  }
  
  public void a(List<akcy> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setMessageItems loadType: ").append(paramInt1).append(", searchMode: ").append(paramInt2).append(", cloudGetCompleted: ").append(paramBoolean).append(", messageItems size: ");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LinkMessageResultAdapter", 2, i);
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
      localObject = (akcy)paramList.get(0);
      akcy localakcy = (akcy)this.b.get(this.b.size() - 1);
      if (((akcy)localObject).a.time <= localakcy.a.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.b.addAll(paramList);
  }
  
  public void a(List<akcy> paramList, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new LinkMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void a(List<akcy> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akcy localakcy = (akcy)getItem(paramInt);
    akbq localakbq;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559394, null);
      localakbq = new akbq();
      localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131379104));
      localakbq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365537));
      localakbq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      paramView.setTag(localakbq);
    }
    for (;;)
    {
      Object localObject1 = localakcy.a;
      TroopLinkElement localTroopLinkElement = new TroopLinkElement();
      try
      {
        localObject1 = bfce.a(((MessageRecord)localObject1).msgData);
        if (localObject1 == null) {
          break label331;
        }
        localTroopLinkElement = (TroopLinkElement)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          localException.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850492));
        }
      }
      localObject2 = localTroopLinkElement.nickname;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localTroopLinkElement.uin;
      }
      localObject2 = localakcy.a(localTroopLinkElement.title, -11353092);
      localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject2);
      localObject2 = new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L);
      localObject2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject2);
      localObject1 = String.format(anvx.a(2131705602), new Object[] { localObject2, localObject1 });
      localakbq.jdField_a_of_type_AndroidWidgetTextView.setText(localakcy.a((String)localObject1, -11353092));
      if (TextUtils.isEmpty(localTroopLinkElement.iconUrl)) {
        break;
      }
      ajwl.a(localakbq.jdField_a_of_type_AndroidWidgetImageView, localTroopLinkElement.iconUrl);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localakbq = (akbq)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajws
 * JD-Core Version:    0.7.0.1
 */