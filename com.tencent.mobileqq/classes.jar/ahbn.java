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

public class ahbn
  extends agem
  implements bljm
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<ahbs> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public ahbn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690041)).setPositiveButton(2131690029, new ahbp(this, paramApolloGameData)).setNegativeButton(2131690030, new ahbo(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690028, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690031)).setPositiveButton(2131690030, new ahbq(this)).show();
  }
  
  protected agen a()
  {
    return new ahbr();
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramagen instanceof ahbr)) {
      return paramView;
    }
    paramagen = (ahbr)paramagen;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramagen != null)
      {
        paramMessageRecord = paramView;
        if (paramagen.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558895, null, true);
      paramMessageRecord.setId(2131374211);
      paramagen.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramagen, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ahbs localahbs = (ahbs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localahbs != null)
      {
        ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localahbs);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(ahbr paramahbr, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramahbr.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, agej.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramahbr.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramahbr.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramahbr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376791));
      }
      if (paramahbr.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramahbr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramahbr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379777));
      }
      if (paramahbr.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramahbr.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramahbr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367808));
        paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(agej.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(agej.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new anao(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = agej.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = agej.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, agej.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131379777);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramahbr.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramahbr.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramahbr.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, agej.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bhum[] a(View paramView)
  {
    return new bhum[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new ahbs(this);
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
    ((ahbs)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    anaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbn
 * JD-Core Version:    0.7.0.1
 */