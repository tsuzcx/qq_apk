import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppPanel.2;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class alra
{
  private static int jdField_a_of_type_Int = 3;
  private adlo jdField_a_of_type_Adlo = new alrb(this);
  private alrf jdField_a_of_type_Alrf;
  private alri jdField_a_of_type_Alri;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new alre(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppRootLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList<adlk> jdField_a_of_type_JavaUtilArrayList;
  private List<alsb> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ArrayList<Boolean> jdField_b_of_type_JavaUtilArrayList;
  
  public alra(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiAppPanel", 2, "initArkApp.chatPie == null!");
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_JavaUtilList.size() <= this.jdField_b_of_type_Int)) {
      return;
    }
    Object localObject1 = (alsb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    int i = BaseChatItemLayout.y;
    int k = XPanelContainer.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent() != null)) {
      i = ((View)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent()).getMeasuredWidth();
    }
    for (;;)
    {
      localObject2 = (adlk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      ((adlk)localObject2).a(((alsb)localObject1).a, ((alsb)localObject1).b, ((alsb)localObject1).c, ((alsb)localObject1).f, alta.a(), null, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      Object localObject3;
      int j;
      if (Boolean.FALSE.equals(this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)))
      {
        altd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ShowView", ((alsb)localObject1).a, null, altd.g, 0, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject3 = (altg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
            if (localObject3 != null) {
              break label451;
            }
          }
        }
        this.jdField_b_of_type_JavaUtilArrayList.set(this.jdField_b_of_type_Int, Boolean.TRUE);
      }
      else
      {
        if (!paramBoolean) {
          break label460;
        }
        j = MessageForArkApp.dp2px(36.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      for (;;)
      {
        k -= j;
        ((adlk)localObject2).setViewRect(((adlk)localObject2).descaleRect(new Rect(0, 0, i, k)));
        ((adlk)localObject2).setFixSize(i, k);
        ((adlk)localObject2).setMaxSize(i, k);
        ((adlk)localObject2).a(this.jdField_a_of_type_Adlo);
        QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s width:%d height:%d.", new Object[] { ((alsb)localObject1).a, ((alsb)localObject1).b, Integer.valueOf(i), Integer.valueOf(k) }));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((adll)localObject2, null);
        localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams());
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        return;
        label451:
        localObject3.toString();
        break;
        label460:
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        j = 0;
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label214;
      }
    }
    label214:
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      int j = 0;
      while ((j < jdField_a_of_type_Int) && (j < i))
      {
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilList.get(j));
        adlk localadlk = new adlk();
        localadlk.a = new ArkAppMessage.Config();
        localadlk.a.round = Integer.valueOf(1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localadlk);
        this.jdField_b_of_type_JavaUtilArrayList.add(Boolean.FALSE);
        j += 1;
      }
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (adlk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject != null) {
          ((adlk)localObject).doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
    }
    this.jdField_a_of_type_Alrf.a((List)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    if ((this.jdField_b_of_type_Int < 0) || (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_b_of_type_Int = 0;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setSelection(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new ArkAiAppPanel.2(this), 500L);
  }
  
  private void e()
  {
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)LayoutInflater.from(localContext).inflate(2131559142, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setDisableParentReturn(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362769));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new alrc(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362771));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_Alrf = new alrf(this, localContext);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Alrf);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362781));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new alrd(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362783));
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout == null) {
      e();
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    this.jdField_a_of_type_Boolean = true;
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        adlk localadlk = (adlk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localadlk != null) {
          localadlk.doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(List<alsb> paramList, int paramInt, alri paramalri)
  {
    this.jdField_a_of_type_Alri = paramalri;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() != 22)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(22));
      return;
    }
    d();
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    d();
    a(this.jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(null);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        alsb localalsb = (alsb)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localalsb != null) {
          alsx.a(localalsb.a);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Alri != null) {
        this.jdField_a_of_type_Alri.a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilList = null;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alra
 * JD-Core Version:    0.7.0.1
 */