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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class agqp
  extends afor
  implements AdapterView.OnItemClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<agqu> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public agqp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690094)).setPositiveButton(2131690082, new agqr(this, paramApolloGameData)).setNegativeButton(2131690083, new agqq(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690081, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690084)).setPositiveButton(2131690083, new agqs(this)).show();
  }
  
  protected afos a()
  {
    return new agqt();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramafos instanceof agqt)) {
      return paramView;
    }
    paramafos = (agqt)paramafos;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramafos != null)
      {
        paramMessageRecord = paramView;
        if (paramafos.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558930, null, true);
      paramMessageRecord.setId(2131374185);
      paramafos.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramafos, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      agqu localagqu = (agqu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localagqu != null)
      {
        ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(localagqu);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(agqt paramagqt, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramagqt.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.dp2px(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramagqt.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramagqt.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramagqt.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376818));
      }
      if (paramagqt.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramagqt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramagqt.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379871));
      }
      if (paramagqt.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramagqt.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramagqt.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367976));
        paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(AIOUtils.dp2px(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new amuk(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = AIOUtils.dp2px(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = AIOUtils.dp2px(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, AIOUtils.dp2px((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131379871);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramagqt.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramagqt.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramagqt.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new agqu(this);
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
    ((agqu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqp
 * JD-Core Version:    0.7.0.1
 */