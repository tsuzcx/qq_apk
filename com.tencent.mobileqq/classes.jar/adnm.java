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

public class adnm
  extends actq
  implements bfpc
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<adnr> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public adnm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690114)).setPositiveButton(2131690096, new adno(this, paramApolloGameData)).setNegativeButton(2131690097, new adnn(this)).show();
  }
  
  private void b()
  {
    bcpw.a(BaseApplicationImpl.getContext(), 1, 2131690095, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690099)).setPositiveButton(2131690097, new adnp(this)).show();
  }
  
  protected actr a()
  {
    return new adnq();
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramactr instanceof adnq)) {
      return paramView;
    }
    paramactr = (adnq)paramactr;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramactr != null)
      {
        paramMessageRecord = paramView;
        if (paramactr.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558789, null, true);
      paramMessageRecord.setId(2131372877);
      paramactr.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramactr, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      adnr localadnr = (adnr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localadnr != null)
      {
        ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadnr);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(adnq paramadnq, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramadnq.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, actn.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramadnq.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramadnq.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramadnq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375377));
      }
      if (paramadnq.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramadnq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramadnq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378123));
      }
      if (paramadnq.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramadnq.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramadnq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367289));
        paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(actn.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(actn.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(actn.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new aizp(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = actn.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = actn.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, actn.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131378123);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramadnq.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramadnq.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramadnq.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public bblt[] a(View paramView)
  {
    return new bblt[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new adnr(this);
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
    ((adnr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    aizg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnm
 * JD-Core Version:    0.7.0.1
 */