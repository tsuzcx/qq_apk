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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class afxz
  extends aexf
  implements AdapterView.OnItemClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<afye> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public afxz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690060)).setPositiveButton(2131690048, new afyb(this, paramApolloGameData)).setNegativeButton(2131690049, new afya(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690047, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690050)).setPositiveButton(2131690049, new afyc(this)).show();
  }
  
  protected aexg a()
  {
    return new afyd();
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramaexg instanceof afyd)) {
      return paramView;
    }
    paramaexg = (afyd)paramaexg;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramaexg != null)
      {
        paramMessageRecord = paramView;
        if (paramaexg.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558903, null, true);
      paramMessageRecord.setId(2131373956);
      paramaexg.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramaexg, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      afye localafye = (afye)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localafye != null)
      {
        ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localafye);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(afyd paramafyd, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramafyd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.dp2px(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramafyd.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramafyd.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramafyd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376559));
      }
      if (paramafyd.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramafyd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramafyd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379559));
      }
      if (paramafyd.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramafyd.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramafyd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367840));
        paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(AIOUtils.dp2px(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new alvi(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = AIOUtils.dp2px(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = AIOUtils.dp2px(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, AIOUtils.dp2px((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131379559);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramafyd.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramafyd.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramafyd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new afye(this);
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
    ((afye)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    aluz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxz
 * JD-Core Version:    0.7.0.1
 */