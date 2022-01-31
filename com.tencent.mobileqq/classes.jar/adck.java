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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class adck
  extends acjb
  implements behi
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<adcp> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public adck(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624560)).setPositiveButton(2131624542, new adcm(this, paramApolloGameData)).setNegativeButton(2131624543, new adcl(this)).show();
  }
  
  private void b()
  {
    bbmy.a(BaseApplicationImpl.getContext(), 1, 2131624541, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624545)).setPositiveButton(2131624543, new adcn(this)).show();
  }
  
  protected acjc a()
  {
    return new adco();
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramacjc instanceof adco)) {
      return paramView;
    }
    paramacjc = (adco)paramacjc;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramacjc != null)
      {
        paramMessageRecord = paramView;
        if (paramacjc.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493233, null, true);
      paramMessageRecord.setId(2131307165);
      paramacjc.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramacjc, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      adcp localadcp = (adcp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localadcp != null)
      {
        ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadcp);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(adco paramadco, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramadco.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, aciy.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aciy.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramadco.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramadco.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramadco.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131309626));
      }
      if (paramadco.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramadco.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramadco.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131312303));
      }
      if (paramadco.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramadco.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramadco.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301677));
        paramadco.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(aciy.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(aciy.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new aimw(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = aciy.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = aciy.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, aciy.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131312303);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramadco.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramadco.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramadco.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, aciy.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aciy.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bakj[] a(View paramView)
  {
    return new bakj[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new adcp(this);
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
    bajr.a(null, "cmshow", "Apollo", "mutualhobby", 0, 0, new String[] { paramView.gameId + "" });
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    ((adcp)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    aimn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adck
 * JD-Core Version:    0.7.0.1
 */