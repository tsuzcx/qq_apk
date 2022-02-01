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

public class agrz
  extends afuu
  implements bkij
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<agse> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public agrz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690033)).setPositiveButton(2131690021, new agsb(this, paramApolloGameData)).setNegativeButton(2131690022, new agsa(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690020, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690023)).setPositiveButton(2131690022, new agsc(this)).show();
  }
  
  protected afuv a()
  {
    return new agsd();
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramafuv instanceof agsd)) {
      return paramView;
    }
    paramafuv = (agsd)paramafuv;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramafuv != null)
      {
        paramMessageRecord = paramView;
        if (paramafuv.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558896, null, true);
      paramMessageRecord.setId(2131374072);
      paramafuv.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramafuv, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      agse localagse = (agse)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localagse != null)
      {
        ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localagse);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(agsd paramagsd, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramagsd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, afur.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramagsd.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramagsd.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramagsd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376657));
      }
      if (paramagsd.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramagsd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramagsd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379603));
      }
      if (paramagsd.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramagsd.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramagsd.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367739));
        paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(afur.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(afur.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(afur.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new amou(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = afur.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = afur.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, afur.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131379603);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramagsd.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramagsd.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramagsd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new agse(this);
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
    ((agse)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    amol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrz
 * JD-Core Version:    0.7.0.1
 */