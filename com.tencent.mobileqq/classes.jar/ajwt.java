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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ajwt
  extends akbp
{
  public Object a;
  private SimpleDateFormat a;
  public List<akcy> a;
  public Set<Long> a;
  
  public ajwt(Context paramContext, bkyc parambkyc, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambkyc, paramSessionInfo, paramQQAppInterface);
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
    ThreadManager.post(new TroopAllMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
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
    View localView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559396, null);
      paramView = new akbq();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378659));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378661));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      paramView.b = ((TextView)localView.findViewById(2131369774));
      localView.setTag(paramView);
      localObject1 = localakcy.a;
      localObject2 = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRecord)localObject1).isSend(), ((MessageRecord)localObject1).senderuin);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localakcy.a(((MessageRecord)localObject1).msg, -11353092));
      if (!((MessageRecord)localObject1).isSend()) {
        break label288;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      label161:
      if (!nty.a((MessageRecord)localObject1)) {
        break label300;
      }
      localObject2 = nty.a((MessageRecord)localObject1);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696965) + ((ntz)localObject2).jdField_b_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(nty.a(((ntz)localObject2).jdField_b_of_type_Int)));
    }
    for (;;)
    {
      paramView.b.setText(localakcy.a(((MessageRecord)localObject1).time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (akbq)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label288:
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      break label161;
      label300:
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localakcy.a((String)localObject2, -11353092));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((MessageRecord)localObject1).senderuin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwt
 * JD-Core Version:    0.7.0.1
 */