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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afki
  extends aimu
  implements View.OnClickListener, bfob, bfvg, bfvi
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691507 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839239 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131369915 };
  private int jdField_a_of_type_Int;
  private ajxl jdField_a_of_type_Ajxl = new afkj(this);
  private akbo jdField_a_of_type_Akbo;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<byte[]> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(20);
  private View jdField_a_of_type_AndroidViewView;
  private bfvm jdField_a_of_type_Bfvm;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<SysSuspiciousMsg> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private int d = -1;
  
  public afki(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
  {
    super(paramContext, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfvm = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramSwipListView.setRightIconMenuListener(this);
    a(this);
    this.jdField_a_of_type_Akbo = ((akbo)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.j();
  }
  
  private bfvm a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new afkk(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
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
  
  private void a(afkl paramafkl, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg == null)
    {
      paramafkl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramafkl.b.setVisibility(8);
      paramafkl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramafkl.d.setVisibility(8);
      paramafkl.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    paramafkl.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = paramSysSuspiciousMsg;
    paramafkl.jdField_a_of_type_JavaLangString = (paramSysSuspiciousMsg.uin + "");
    paramafkl.g.setOnClickListener(this);
    paramafkl.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramafkl.jdField_c_of_type_Int, paramafkl.jdField_a_of_type_JavaLangString));
    paramafkl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = paramafkl.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    if (paramSysSuspiciousMsg.nick == null)
    {
      str = "";
      localTextView.setText(str);
      b(paramafkl, paramSysSuspiciousMsg);
      if (paramSysSuspiciousMsg.msg != null) {
        break label222;
      }
      paramafkl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label160:
      if (paramSysSuspiciousMsg.reason != null) {
        break label244;
      }
      paramafkl.d.setVisibility(8);
    }
    for (;;)
    {
      paramafkl.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramafkl.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131707502));
      paramafkl.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramafkl.jdField_a_of_type_AndroidWidgetButton.setTag(paramafkl);
      return;
      str = paramSysSuspiciousMsg.nick;
      break;
      label222:
      paramafkl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramafkl.jdField_c_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.msg);
      break label160;
      label244:
      paramafkl.d.setVisibility(0);
      paramafkl.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846890);
      paramSysSuspiciousMsg.setBounds(0, 0, bbkx.a(16.0F), bbkx.a(16.0F));
      paramafkl.d.setCompoundDrawablePadding(bbkx.a(5.0F));
      paramafkl.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bfvn parambfvn, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfvm != null) {}
    for (int i = this.jdField_a_of_type_Bfvm.a(paramContext, paramView, paramInt, paramObject, parambfvn, paramOnClickListener);; i = 0)
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
  
  private void b(afkl paramafkl, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int j = 1;
    int i;
    switch (paramSysSuspiciousMsg.sex)
    {
    default: 
      paramafkl.b.setBackgroundResource(2130845021);
      i = 0;
      j = 0;
    }
    for (;;)
    {
      paramafkl.b.setText(paramSysSuspiciousMsg.age + "");
      paramafkl.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (j == 0) {
        break;
      }
      paramafkl.b.setVisibility(0);
      return;
      i = 2130845020;
      paramafkl.b.setBackgroundResource(2130845021);
      continue;
      i = 2130845018;
      paramafkl.b.setBackgroundResource(2130845019);
    }
    paramafkl.b.setVisibility(8);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.jdField_c_of_type_Int);
    }
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext)) {}
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
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(50, arrayOfByte, Integer.valueOf(this.jdField_c_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
  }
  
  public void b(View paramView)
  {
    a(true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    super.c();
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2(this));
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean) {}
  
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
    if (paramView == null)
    {
      paramViewGroup = new afkl();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561123, null);
      paramView = this.jdField_a_of_type_Bfvm.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131362196));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375194));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131376339));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375181));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131375191));
      if ((paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      if (ThemeUtil.isDefaultTheme())
      {
        ((View)localObject).setBackgroundResource(2130839132);
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, null, paramViewGroup, this);
        localObject = getItem(paramInt);
        if (!(localObject instanceof SysSuspiciousMsg)) {
          break label283;
        }
      }
    }
    label283:
    for (Object localObject = (SysSuspiciousMsg)localObject;; localObject = null)
    {
      a(paramViewGroup, (SysSuspiciousMsg)localObject);
      paramViewGroup.g.setTag(paramViewGroup);
      if (paramInt == 0)
      {
        paramView.setPadding(0, bbkx.a(12.0F), 0, 0);
        return paramView;
        ((View)localObject).setBackgroundResource(2130839129);
        break;
        paramViewGroup = (afkl)paramView.getTag();
        break;
      }
      paramView.setPadding(0, 0, 0, 0);
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!(localObject instanceof afkl));
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
              paramView = (afkl)localObject;
              localObject = new Intent();
              ((Intent)localObject).putExtra("msg_extra", paramView.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg);
              PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, AddRequestSuspiciousMsgFragment.class);
              return;
            } while (!(localObject instanceof afkl));
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
            paramView = (afkl)localObject;
            if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
            {
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694620, 0).a();
              return;
            }
            if (((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramView.jdField_a_of_type_JavaLangString))
            {
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131707497), 0).a();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null);
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(paramView.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
          return;
          paramView = paramView.getTag(-1);
        } while (!(paramView instanceof Integer));
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
        int i = ((Integer)paramView).intValue();
        if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694620, 0).a();
          return;
        }
        paramView = getItem(i);
      } while (!(paramView instanceof SysSuspiciousMsg));
      paramView = (SysSuspiciousMsg)paramView;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramView.uin);
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
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afki
 * JD-Core Version:    0.7.0.1
 */