import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class affu
  extends aekw
  implements bhqp
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<affz> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public affu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameData null");
      return;
    }
    if (TextUtils.isEmpty(paramApolloGameData.gameAppid))
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameAppid null");
      return;
    }
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690161)).setPositiveButton(2131690143, new affw(this, paramApolloGameData)).setNegativeButton(2131690144, new affv(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690142, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690146)).setPositiveButton(2131690144, new affx(this)).show();
  }
  
  protected aekx a()
  {
    return new affy();
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramaekx instanceof affy)) {
      return paramView;
    }
    paramaekx = (affy)paramaekx;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramaekx != null)
      {
        paramMessageRecord = paramView;
        if (paramaekx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558825, null, true);
      paramMessageRecord.setId(2131373317);
      paramaekx.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramaekx, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      affz localaffz = (affz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaffz != null)
      {
        ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localaffz);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(affy paramaffy, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramaffy.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, aekt.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aekt.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramaffy.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramaffy.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaffy.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375864));
      }
      if (paramaffy.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramaffy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramaffy.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378684));
      }
      if (paramaffy.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramaffy.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramaffy.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367420));
        paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(aekt.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(aekt.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new akqz(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = aekt.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = aekt.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, aekt.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131378684);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramaffy.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramaffy.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramaffy.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, aekt.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aekt.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bdlb[] a(View paramView)
  {
    return new bdlb[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new affz(this);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
      paramAdapterView.a(paramView);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramView = (ApolloGameData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramView == null) {
        QLog.e("ChatItemBuilder", 1, "[onClick] no game data for id:" + paramInt);
      }
    }
    else
    {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "mutualhobby", 0, 0, new String[] { paramView.gameId + "" });
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    ((affz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    akqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affu
 * JD-Core Version:    0.7.0.1
 */