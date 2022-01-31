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

public class alcm
{
  private static int jdField_a_of_type_Int = 3;
  private adam jdField_a_of_type_Adam = new alcn(this);
  private alcr jdField_a_of_type_Alcr;
  private alcu jdField_a_of_type_Alcu;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new alcq(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppRootLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList<adai> jdField_a_of_type_JavaUtilArrayList;
  private List<aldn> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ArrayList<Boolean> jdField_b_of_type_JavaUtilArrayList;
  
  public alcm(BaseChatPie paramBaseChatPie)
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
    Object localObject1 = (aldn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    int i = BaseChatItemLayout.y;
    int k = XPanelContainer.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent() != null)) {
      i = ((View)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent()).getMeasuredWidth();
    }
    for (;;)
    {
      localObject2 = (adai)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      ((adai)localObject2).a(((aldn)localObject1).a, ((aldn)localObject1).b, ((aldn)localObject1).c, ((aldn)localObject1).f, alem.a(), null, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      Object localObject3;
      int j;
      if (Boolean.FALSE.equals(this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)))
      {
        alep.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ShowView", ((aldn)localObject1).a, null, alep.g, 0, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject3 = (ales)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
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
        ((adai)localObject2).setViewRect(((adai)localObject2).descaleRect(new Rect(0, 0, i, k)));
        ((adai)localObject2).setFixSize(i, k);
        ((adai)localObject2).setMaxSize(i, k);
        ((adai)localObject2).a(this.jdField_a_of_type_Adam);
        QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s width:%d height:%d.", new Object[] { ((aldn)localObject1).a, ((aldn)localObject1).b, Integer.valueOf(i), Integer.valueOf(k) }));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((adaj)localObject2, null);
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
        adai localadai = new adai();
        localadai.a = new ArkAppMessage.Config();
        localadai.a.round = Integer.valueOf(1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localadai);
        this.jdField_b_of_type_JavaUtilArrayList.add(Boolean.FALSE);
        j += 1;
      }
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (adai)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject != null) {
          ((adai)localObject).doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
    }
    this.jdField_a_of_type_Alcr.a((List)localObject);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)LayoutInflater.from(localContext).inflate(2131493573, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setDisableParentReturn(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131297229));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new alco(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131297231));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_Alcr = new alcr(this, localContext);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Alcr);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131297241));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new alcp(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131297243));
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
        adai localadai = (adai)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localadai != null) {
          localadai.doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(List<aldn> paramList, int paramInt, alcu paramalcu)
  {
    this.jdField_a_of_type_Alcu = paramalcu;
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
        aldn localaldn = (aldn)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localaldn != null) {
          alej.a(localaldn.a);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Alcu != null) {
        this.jdField_a_of_type_Alcu.a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilList = null;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alcm
 * JD-Core Version:    0.7.0.1
 */