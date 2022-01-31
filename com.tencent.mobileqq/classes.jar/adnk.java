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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class adnk
  extends actm
  implements bfpt
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<adnp> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public adnk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690114)).setPositiveButton(2131690096, new adnm(this, paramApolloGameData)).setNegativeButton(2131690097, new adnl(this)).show();
  }
  
  private void b()
  {
    bcql.a(BaseApplicationImpl.getContext(), 1, 2131690095, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690099)).setPositiveButton(2131690097, new adnn(this)).show();
  }
  
  protected actn a()
  {
    return new adno();
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramactn instanceof adno)) {
      return paramView;
    }
    paramactn = (adno)paramactn;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramactn != null)
      {
        paramMessageRecord = paramView;
        if (paramactn.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558789, null, true);
      paramMessageRecord.setId(2131372879);
      paramactn.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramactn, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      adnp localadnp = (adnp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localadnp != null)
      {
        ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadnp);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(adno paramadno, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramadno.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, actj.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramadno.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramadno.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramadno.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375379));
      }
      if (paramadno.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramadno.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramadno.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378126));
      }
      if (paramadno.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramadno.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramadno.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367289));
        paramadno.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(actj.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(actj.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new aizn(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = actj.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = actj.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, actj.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131378126);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramadno.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramadno.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramadno.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, actj.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bbmh[] a(View paramView)
  {
    return new bbmh[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new adnp(this);
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
    ((adnp)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    aize.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnk
 * JD-Core Version:    0.7.0.1
 */