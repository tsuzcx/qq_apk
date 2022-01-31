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

public class aeys
  extends aiab
  implements View.OnClickListener, begh, benm, beno
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131625931 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839215 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131304236 };
  private int jdField_a_of_type_Int;
  private ajjh jdField_a_of_type_Ajjh = new aeyt(this);
  private ajnf jdField_a_of_type_Ajnf;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<byte[]> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(20);
  private View jdField_a_of_type_AndroidViewView;
  private bens jdField_a_of_type_Bens;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<SysSuspiciousMsg> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private int d = -1;
  
  public aeys(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
  {
    super(paramContext, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bens = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramSwipListView.setRightIconMenuListener(this);
    a(this);
    this.jdField_a_of_type_Ajnf = ((ajnf)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.j();
  }
  
  private bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aeyu(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
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
  
  private void a(aeyv paramaeyv, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg == null)
    {
      paramaeyv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaeyv.b.setVisibility(8);
      paramaeyv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaeyv.d.setVisibility(8);
      paramaeyv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    paramaeyv.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = paramSysSuspiciousMsg;
    paramaeyv.jdField_a_of_type_JavaLangString = (paramSysSuspiciousMsg.uin + "");
    paramaeyv.g.setOnClickListener(this);
    paramaeyv.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramaeyv.jdField_c_of_type_Int, paramaeyv.jdField_a_of_type_JavaLangString));
    paramaeyv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = paramaeyv.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    if (paramSysSuspiciousMsg.nick == null)
    {
      str = "";
      localTextView.setText(str);
      b(paramaeyv, paramSysSuspiciousMsg);
      if (paramSysSuspiciousMsg.msg != null) {
        break label222;
      }
      paramaeyv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label160:
      if (paramSysSuspiciousMsg.reason != null) {
        break label244;
      }
      paramaeyv.d.setVisibility(8);
    }
    for (;;)
    {
      paramaeyv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramaeyv.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131641717));
      paramaeyv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramaeyv.jdField_a_of_type_AndroidWidgetButton.setTag(paramaeyv);
      return;
      str = paramSysSuspiciousMsg.nick;
      break;
      label222:
      paramaeyv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaeyv.jdField_c_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.msg);
      break label160;
      label244:
      paramaeyv.d.setVisibility(0);
      paramaeyv.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846702);
      paramSysSuspiciousMsg.setBounds(0, 0, bajq.a(16.0F), bajq.a(16.0F));
      paramaeyv.d.setCompoundDrawablePadding(bajq.a(5.0F));
      paramaeyv.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {}
    for (int i = this.jdField_a_of_type_Bens.a(paramContext, paramView, paramInt, paramObject, parambent, paramOnClickListener);; i = 0)
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
  
  private void b(aeyv paramaeyv, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int j = 1;
    int i;
    switch (paramSysSuspiciousMsg.sex)
    {
    default: 
      paramaeyv.b.setBackgroundResource(2130844934);
      i = 0;
      j = 0;
    }
    for (;;)
    {
      paramaeyv.b.setText(paramSysSuspiciousMsg.age + "");
      paramaeyv.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (j == 0) {
        break;
      }
      paramaeyv.b.setVisibility(0);
      return;
      i = 2130844933;
      paramaeyv.b.setBackgroundResource(2130844934);
      continue;
      i = 2130844931;
      paramaeyv.b.setBackgroundResource(2130844932);
    }
    paramaeyv.b.setVisibility(8);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.jdField_c_of_type_Int);
    }
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext)) {}
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void b(View paramView)
  {
    a(true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
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
      paramViewGroup = new aeyv();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495535, null);
      paramView = this.jdField_a_of_type_Bens.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305159));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131296655));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309446));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131310547));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131309433));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131309443));
      if ((paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      if (ThemeUtil.isDefaultTheme())
      {
        ((View)localObject).setBackgroundResource(2130839104);
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
        paramView.setPadding(0, bajq.a(12.0F), 0, 0);
        return paramView;
        ((View)localObject).setBackgroundResource(2130839101);
        break;
        paramViewGroup = (aeyv)paramView.getTag();
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
              } while (!(localObject instanceof aeyv));
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
              paramView = (aeyv)localObject;
              localObject = new Intent();
              ((Intent)localObject).putExtra("msg_extra", paramView.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg);
              PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, AddRequestSuspiciousMsgFragment.class);
              return;
            } while (!(localObject instanceof aeyv));
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
            paramView = (aeyv)localObject;
            if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
            {
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131628956, 0).a();
              return;
            }
            if (((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramView.jdField_a_of_type_JavaLangString))
            {
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131641712), 0).a();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null);
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(paramView.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
          return;
          paramView = paramView.getTag(-1);
        } while (!(paramView instanceof Integer));
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
        int i = ((Integer)paramView).intValue();
        if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131628956, 0).a();
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
 * Qualified Name:     aeys
 * JD-Core Version:    0.7.0.1
 */