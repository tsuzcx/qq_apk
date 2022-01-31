import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.1;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class agbp
  extends agdg
{
  public Object a;
  private SimpleDateFormat a;
  public List<agep> a;
  public Set<Long> a;
  
  public agbp(Context paramContext, bfnk parambfnk, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambfnk, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new TroopAllMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<agep> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
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
      localObject = (agep)paramList.get(0);
      agep localagep = (agep)this.b.get(this.b.size() - 1);
      if (((agep)localObject).a.time <= localagep.a.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.b.addAll(paramList);
  }
  
  public void a(List<agep> paramList, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new TroopAllMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void a(List<agep> paramList, boolean paramBoolean)
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
    agep localagep = (agep)getItem(paramInt);
    MessageRecord localMessageRecord;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559216, null);
      paramViewGroup = new agdh();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131377033));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377035));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131368885));
      paramView.setTag(paramViewGroup);
      localMessageRecord = localagep.a;
      localObject = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localagep.a(localMessageRecord.msg, -11353092));
      if (!localMessageRecord.isSend()) {
        break label259;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      label155:
      if (!myb.a(localMessageRecord)) {
        break label271;
      }
      localObject = myb.a(localMessageRecord);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697495) + ((myc)localObject).jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(myb.a(((myc)localObject).jdField_b_of_type_Int)));
    }
    for (;;)
    {
      paramViewGroup.b.setText(localagep.a(localMessageRecord.time));
      return paramView;
      paramViewGroup = (agdh)paramView.getTag();
      break;
      label259:
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break label155;
      label271:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localagep.a((String)localObject, -11353092));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localMessageRecord.senderuin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbp
 * JD-Core Version:    0.7.0.1
 */