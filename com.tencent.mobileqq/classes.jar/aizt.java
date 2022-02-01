import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aizt
  extends amgy
  implements View.OnClickListener, blfe, blfg, AbsListView.OnScrollListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691448 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839570 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370896 };
  private int jdField_a_of_type_Int;
  private aizi jdField_a_of_type_Aizi;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<byte[]> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(20);
  private View jdField_a_of_type_AndroidViewView;
  private anvi jdField_a_of_type_Anvi = new aizu(this);
  private blfk jdField_a_of_type_Blfk;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<SysSuspiciousMsg> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private int d = -1;
  
  public aizt(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
  {
    super(paramContext, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blfk = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramSwipListView.setRightIconMenuListener(this);
    a(this);
    this.jdField_a_of_type_Aizi = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.sendReadReportSuspicious();
  }
  
  private blfk a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298795);
    int j = paramContext.getResources().getDimensionPixelSize(2131298796);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aizv(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    SysSuspiciousMsg localSysSuspiciousMsg;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)((Iterator)localObject).next();
    } while (localSysSuspiciousMsg.uin != paramLong);
    for (;;)
    {
      if (localSysSuspiciousMsg != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("base_uin", String.valueOf(localSysSuspiciousMsg.uin));
        ((Bundle)localObject).putString("base_nick", localSysSuspiciousMsg.nick);
        ((Bundle)localObject).putInt("verfy_type", 0);
        ((Bundle)localObject).putString("verfy_msg", localSysSuspiciousMsg.msg);
        AutoRemarkActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0, localSysSuspiciousMsg.uin + "", 0L, (Bundle)localObject);
      }
      return;
      localSysSuspiciousMsg = null;
    }
  }
  
  private void a(aizw paramaizw, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg == null)
    {
      paramaizw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaizw.b.setVisibility(8);
      paramaizw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaizw.d.setVisibility(8);
      paramaizw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    paramaizw.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = paramSysSuspiciousMsg;
    paramaizw.jdField_a_of_type_JavaLangString = (paramSysSuspiciousMsg.uin + "");
    paramaizw.g.setOnClickListener(this);
    paramaizw.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramaizw.jdField_c_of_type_Int, paramaizw.jdField_a_of_type_JavaLangString));
    paramaizw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = paramaizw.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    if (paramSysSuspiciousMsg.nick == null)
    {
      str = "";
      localTextView.setText(str);
      b(paramaizw, paramSysSuspiciousMsg);
      if (paramSysSuspiciousMsg.msg != null) {
        break label222;
      }
      paramaizw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label160:
      if (paramSysSuspiciousMsg.reason != null) {
        break label244;
      }
      paramaizw.d.setVisibility(8);
    }
    for (;;)
    {
      paramaizw.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramaizw.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131706977));
      paramaizw.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramaizw.jdField_a_of_type_AndroidWidgetButton.setTag(paramaizw);
      return;
      str = paramSysSuspiciousMsg.nick;
      break;
      label222:
      paramaizw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaizw.jdField_c_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.msg);
      break label160;
      label244:
      paramaizw.d.setVisibility(0);
      paramaizw.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847815);
      paramSysSuspiciousMsg.setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      paramaizw.d.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      paramaizw.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blfk != null) {}
    for (int i = this.jdField_a_of_type_Blfk.a(paramContext, paramView, paramInt, paramObject, paramblfl, paramOnClickListener);; i = 0)
    {
      if (this.d != -1)
      {
        if (paramInt != this.d) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(aizw paramaizw, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int j = 1;
    int i;
    switch (paramSysSuspiciousMsg.sex)
    {
    default: 
      paramaizw.b.setBackgroundResource(2130845859);
      i = 0;
      j = 0;
    }
    for (;;)
    {
      paramaizw.b.setText(paramSysSuspiciousMsg.age + "");
      paramaizw.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (j == 0) {
        break;
      }
      paramaizw.b.setVisibility(0);
      return;
      i = 2130845858;
      paramaizw.b.setBackgroundResource(2130845859);
      continue;
      i = 2130845856;
      paramaizw.b.setBackgroundResource(2130845857);
    }
    paramaizw.b.setVisibility(8);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.jdField_c_of_type_Int);
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {}
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = (byte[])this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
      if ((this.jdField_c_of_type_Int < 0) || (arrayOfByte != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
    return;
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getSuspiciousMsgList(50, arrayOfByte, Integer.valueOf(this.jdField_c_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void a(View paramView)
  {
    a(false);
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.d = i;
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void b(View paramView)
  {
    a(true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    super.c();
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2(this));
  }
  
  public void e(boolean paramBoolean) {}
  
  public void g() {}
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aizw localaizw;
    if (paramView == null)
    {
      localaizw = new aizw();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561541, null);
      paramView = this.jdField_a_of_type_Blfk.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, localaizw, -1);
      localaizw.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localaizw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371981));
      localaizw.b = ((TextView)paramView.findViewById(2131362310));
      localaizw.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376609));
      localaizw.d = ((TextView)paramView.findViewById(2131377905));
      localaizw.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376596));
      localaizw.e = ((TextView)paramView.findViewById(2131376606));
      if ((localaizw.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localaizw.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(localaizw);
      if (ThemeUtil.isDefaultTheme())
      {
        ((View)localObject).setBackgroundResource(2130839458);
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, null, localaizw, this);
        localObject = getItem(paramInt);
        if (!(localObject instanceof SysSuspiciousMsg)) {
          break label315;
        }
      }
    }
    label315:
    for (Object localObject = (SysSuspiciousMsg)localObject;; localObject = null)
    {
      a(localaizw, (SysSuspiciousMsg)localObject);
      localaizw.g.setTag(localaizw);
      if (paramInt == 0) {
        paramView.setPadding(0, ViewUtils.dip2px(12.0F), 0, 0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        ((View)localObject).setBackgroundResource(2130839455);
        break;
        localaizw = (aizw)paramView.getTag();
        break;
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof aizw))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
        localObject = (aizw)localObject;
        Intent localIntent = new Intent();
        localIntent.putExtra("msg_extra", ((aizw)localObject).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg);
        PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, AddRequestSuspiciousMsgFragment.class);
        continue;
        if ((localObject instanceof aizw))
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
          localObject = (aizw)localObject;
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694264, 0).a();
          }
          else if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((aizw)localObject).jdField_a_of_type_JavaLangString))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131706972), 0).a();
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.agreeSuspiciousMsg(((aizw)localObject).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
            continue;
            localObject = paramView.getTag(-1);
            if ((localObject instanceof Integer))
            {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
              int i = ((Integer)localObject).intValue();
              if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694264, 0).a();
              }
              else
              {
                localObject = getItem(i);
                if ((localObject instanceof SysSuspiciousMsg))
                {
                  localObject = (SysSuspiciousMsg)localObject;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.deleteSuspiciousMsg(((SysSuspiciousMsg)localObject).uin);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onScrollStateChanged " + this.jdField_a_of_type_Int + " " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_a_of_type_Int == getCount() - 1) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizt
 * JD-Core Version:    0.7.0.1
 */