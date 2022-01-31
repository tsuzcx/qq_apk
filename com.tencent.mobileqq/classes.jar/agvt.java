import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class agvt
  implements agve, agvy
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private aelz jdField_a_of_type_Aelz;
  private agwa jdField_a_of_type_Agwa;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<QQOperationViopTipTask> a;
  private long jdField_b_of_type_Long = -1L;
  private WeakReference<XPanelContainer> jdField_b_of_type_JavaLangRefWeakReference;
  
  public agvt(QQAppInterface paramQQAppInterface, agwa paramagwa, Context paramContext, XPanelContainer paramXPanelContainer, List<QQOperationViopTipTask> paramList, SessionInfo paramSessionInfo, aelz paramaelz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramXPanelContainer);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Agwa = paramagwa;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Aelz = paramaelz;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new QQOperateTips.1(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new QQOperateTips.2(this));
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    List localList = this.jdField_a_of_type_Aelz.a();
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = j - 1;
    label27:
    if (i >= 0) {
      if (i < j - 10) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQOperateTips", 2, " findExcludeMsg, just return ");
        return;
        if (((ChatMessage)localList.get(i)).msgtype == -1043)
        {
          i = 1;
          continue;
        }
        i -= 1;
        break label27;
      }
      this.jdField_a_of_type_Agwa.a(this, new Object[] { paramQQOperationViopTipTask });
      return;
      i = 0;
    }
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        return null;
      }
      View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131560806, null);
      TextView localTextView = (TextView)localView.findViewById(2131373397);
      Button localButton = (Button)localView.findViewById(2131373394);
      localTextView.setText(paramVarArgs.adwords);
      localButton.setText(paramVarArgs.clickableWord);
      localButton.setOnClickListener(new agvu(this, paramVarArgs));
      return localView;
    }
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      MessageRecord localMessageRecord = ayvw.a(-1041);
      long l = ayvc.a();
      localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramVarArgs.adwords + "|" + paramVarArgs.clickableWord + "|" + paramVarArgs.linkOffset + "|" + paramVarArgs.url + "|" + paramVarArgs.taskid, l, -1041, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      if (!alsh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
        return localMessageRecord;
      }
      return null;
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {}
    do
    {
      return;
      if (paramInt == 1000)
      {
        a();
        return;
      }
    } while (paramInt != 1001);
    b();
  }
  
  public void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    this.jdField_a_of_type_Agwa.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public void a(List<QQOperationViopTipTask> paramList)
  {
    aouu localaouu = aouu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramList = paramList.iterator();
    label195:
    label198:
    for (;;)
    {
      int i;
      QQOperationViopTipTask localQQOperationViopTipTask;
      if (paramList.hasNext())
      {
        i = ((QQOperationViopTipTask)paramList.next()).taskid;
        localQQOperationViopTipTask = localaouu.a(i);
        if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null)) {
          QLog.d("QQOperateVoIP", 4, "on showTips, voipTask is null, taskId=" + i);
        }
        XPanelContainer localXPanelContainer = (XPanelContainer)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (localXPanelContainer == null) {
          break label195;
        }
        if (localXPanelContainer.a() == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (localQQOperationViopTipTask == null) {
          break label198;
        }
        if (localQQOperationViopTipTask.isBlueTipsTask())
        {
          if (i != 0)
          {
            a(localQQOperationViopTipTask);
            break;
            i = 0;
            continue;
          }
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(localQQOperationViopTipTask);
          break;
        }
        if ((!localQQOperationViopTipTask.isGryTipsTask()) || (localaouu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))) {
          break;
        }
        b(localQQOperationViopTipTask);
        break;
        return;
        i = 1;
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvt
 * JD-Core Version:    0.7.0.1
 */