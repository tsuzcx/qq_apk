import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class alto<T extends alqw>
  extends BaseAdapter
  implements adlm
{
  public int a;
  public acxj a;
  public Context a;
  public SessionInfo a;
  private ArkHorizontalListView jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView;
  private LinkedList<T> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public int b;
  
  public alto(Context paramContext, SessionInfo paramSessionInfo, ArkHorizontalListView paramArkHorizontalListView, acxj paramacxj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView = paramArkHorizontalListView;
    this.jdField_a_of_type_Acxj = paramacxj;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public T a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= getCount() - 1)) {
      return null;
    }
    return (alqw)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
    int i = 0;
    while ((i < paramInt) && (i < j))
    {
      alqw localalqw = (alqw)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      if (localalqw != null) {
        localalqw.destroyContainerByRemove();
      }
      i += 1;
    }
    notifyDataSetChanged();
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.b != paramInt2)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.b = paramInt2;
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramInt, paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(adli paramadli, int paramInt)
  {
    int i;
    if ((paramInt == 1) || (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = BaseChatItemLayout.n;
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296291);
      int m = localResources.getDimensionPixelSize(2131296283);
      int n = MessageForArkApp.dp2px(paramadli.getWidth());
      i = alsz.d - (i * 2 + j + k) - n - m;
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) || (paramInt != 1)) {
        break label185;
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        paramadli = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
        if ((paramadli != null) && (!(paramadli instanceof LinearLayout)))
        {
          paramadli.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, -1));
          paramadli.requestLayout();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
        }
      }
      return;
      label185:
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) && (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()) && (this.b != i))
      {
        this.b = i;
        paramadli = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(paramInt + 1);
        if ((paramadli != null) && (!(paramadli instanceof LinearLayout)))
        {
          paramadli.setLayoutParams(new ViewGroup.LayoutParams(this.b, -1));
          paramadli.requestLayout();
        }
      }
    }
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(alts paramalts, T paramT)
  {
    Object localObject2 = paramT.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramT.clickTail(paramalts, null, this.jdField_a_of_type_AndroidContentContext);
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new altp(this, paramalts));
      paramT = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramT != null)
      {
        paramalts.b.setVisibility(0);
        paramalts.jdField_a_of_type_AndroidWidgetTextView.setText(paramT);
      }
    }
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new altq(this, str, paramalts));
  }
  
  public boolean a(adlj paramadlj)
  {
    return false;
  }
  
  public boolean a(adlj paramadlj, String paramString1, String paramString2)
  {
    QLog.d("ArkOpenView", 1, "ArkHorizontalListViewAdapter OpenCardView containerWrapper=" + paramadlj + ", view=" + paramString1 + ", meta=" + paramString2);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
      {
        alqw localalqw = ((alqw)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).extendArkCardByOpen(paramadlj, paramString1, paramString2);
        if (localalqw != null) {
          a(i + 1, localalqw);
        }
      }
      else
      {
        return false;
      }
      i += 1;
    }
  }
  
  public T b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      return null;
    }
    return (alqw)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size()) || (paramT == null)) {}
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilLinkedList.set(paramInt, paramT);
          paramInt += 1;
          i = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getFirstVisiblePosition();
        } while ((paramInt < i) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getLastVisiblePosition()));
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChildAt(paramInt - i);
      } while (localObject == null);
      localObject = (alts)((View)localObject).getTag();
    } while (localObject == null);
    paramT.attachArkView(this, (alts)localObject, paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + 2;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getCount() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      alqw localalqw = a(paramInt);
      if (paramView == null)
      {
        paramView = new alts();
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558631, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362776));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)localView.findViewById(2131362778));
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362789));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131369476));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362768));
        paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131362781);
        paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362777));
        paramView.b = ((LinearLayout)localView.findViewById(2131362774));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362773));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362775));
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getParent();
        if ((paramViewGroup instanceof BaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)paramViewGroup);
        }
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        if (localalqw != null) {
          localalqw.attachArkView(this, paramViewGroup, paramInt);
        }
        return localView;
        paramViewGroup = (alts)paramView.getTag();
        localView = paramView;
      }
    }
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramViewGroup.getContext());
    }
    if (paramInt == 0) {}
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = this.b)
    {
      localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, -1));
      localView.setVisibility(0);
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alto
 * JD-Core Version:    0.7.0.1
 */