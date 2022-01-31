import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class akpm
  implements albo, Manager
{
  int jdField_a_of_type_Int = 0;
  akpq jdField_a_of_type_Akpq;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akpn(this);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  Comparator<ApolloActionData> jdField_a_of_type_JavaUtilComparator = new akpo(this);
  
  public akpm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  int a(ApolloActionData paramApolloActionData)
  {
    switch (paramApolloActionData.feeType)
    {
    case 8: 
    default: 
      return 1;
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).removeView(this.jdField_a_of_type_ComTencentWidgetListView);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetListView = null;
      this.jdField_a_of_type_Akpq = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloActionData paramApolloActionData, int paramInt, String paramString)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null) || (paramApolloActionData == null)) {
      return;
    }
    if (aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1) {
        paramApolloActionData = paramApolloActionData.pkIds;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResponseManager", 2, "[showQuickResponseView] Ids:" + paramApolloActionData);
      }
      if (TextUtils.isEmpty(paramApolloActionData)) {
        break;
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
      this.jdField_a_of_type_JavaLangString = paramString;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramBaseChatPie.a != null)) {
        this.jdField_a_of_type_Int = paramBaseChatPie.a.jdField_a_of_type_Int;
      }
      BaseActivity localBaseActivity = paramBaseChatPie.a();
      paramBaseChatPie = (RelativeLayout)paramBaseChatPie.a().findViewById(2131364139);
      int i;
      if (this.jdField_a_of_type_ComTencentWidgetListView == null)
      {
        this.jdField_a_of_type_ComTencentWidgetListView = new ListView(localBaseActivity);
        this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
        this.jdField_a_of_type_ComTencentWidgetListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetListView.setSelector(localBaseActivity.getResources().getDrawable(2130850072));
        this.jdField_a_of_type_ComTencentWidgetListView.setCacheColorHint(2131165449);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(localBaseActivity);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localBaseActivity);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        i = aepi.a(9.0F, localBaseActivity.getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, i);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localBaseActivity.getResources().getColor(2131166910));
        Object localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 1;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Akpq = new akpq(this, localBaseActivity);
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Akpq);
        localObject = new RelativeLayout.LayoutParams(aepi.a(99.0F, localBaseActivity.getResources()), -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368344);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = aepi.a(10.0F, localBaseActivity.getResources());
        paramBaseChatPie.addView(this.jdField_a_of_type_ComTencentWidgetListView, (ViewGroup.LayoutParams)localObject);
      }
      paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      switch (this.jdField_a_of_type_Int)
      {
      }
      try
      {
        for (;;)
        {
          paramBaseChatPie = new ArrayList();
          paramApolloActionData = paramApolloActionData.split(",");
          int j = paramApolloActionData.length;
          i = 0;
          while (i < j)
          {
            paramString = paramApolloActionData[i];
            if (!TextUtils.isEmpty(paramString)) {
              paramBaseChatPie.add(Integer.valueOf(Integer.parseInt(paramString.trim())));
            }
            i += 1;
          }
          paramApolloActionData = paramApolloActionData.pk3DIds;
          break;
          if (ApolloActionData.isAction3DModel(paramApolloActionData.actionId))
          {
            paramApolloActionData = "";
            break;
          }
          paramApolloActionData = paramApolloActionData.pkIds;
          break;
          if (paramBaseChatPie.getBoolean("first_show_resp", true))
          {
            paramBaseChatPie.edit().putBoolean("first_show_resp", false).commit();
            this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700898));
            this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838334, 0);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
            paramBaseChatPie = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
            paramBaseChatPie = String.format(alud.a(2131700900), new Object[] { paramBaseChatPie });
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatPie);
            this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
        }
        this.jdField_a_of_type_Akpq.a(paramBaseChatPie, paramInt);
        return;
      }
      catch (Exception paramBaseChatPie)
      {
        QLog.e("ApolloResponseManager", 1, "update Quick Response View error:", paramBaseChatPie);
      }
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    int i;
    ApolloActionData localApolloActionData;
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
        i = paramSpriteTaskParam.f;
        localApolloActionData = ((aliw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(i);
      } while ((localApolloActionData == null) || ((localApolloActionData.pkIds == null) && (localApolloActionData.pk3DIds == null)) || (paramSpriteTaskParam.jdField_a_of_type_Boolean) || (paramSpriteTaskParam.g != 1));
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (localMqqHandler == null);
    localMqqHandler.removeMessages(82);
    localMqqHandler.removeMessages(83);
    Message localMessage = localMqqHandler.obtainMessage();
    localMessage.what = 82;
    localMessage.obj = localApolloActionData;
    localMessage.arg1 = i;
    localMessage.getData().putString("senderUin", paramSpriteTaskParam.jdField_a_of_type_JavaLangString);
    localMqqHandler.sendMessageDelayed(localMessage, 500L);
    localMqqHandler.sendEmptyMessageDelayed(83, 4000L);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Akpq = null;
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpm
 * JD-Core Version:    0.7.0.1
 */