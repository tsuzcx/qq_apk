import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class ahqe
  implements blgx
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<ahqf<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  
  public ahqe(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public <T extends View> T a(int paramInt)
  {
    ahqf localahqf = (ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahqf != null) {
      return localahqf.a();
    }
    return null;
  }
  
  public void a()
  {
    a(new ahql(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ahqm(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ahpv(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ahpu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ahqg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new ahqo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aici))) {
      a(new ahqr(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    }
    a(new ahqn());
  }
  
  public void a(int paramInt)
  {
    ahqf localahqf = (ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahqf != null) {
      localahqf.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    }
  }
  
  void a(ahqf<? extends View> paramahqf)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramahqf.a(), paramahqf);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
  }
  
  public boolean isNeedRecreatePanel(int paramInt)
  {
    ahqf localahqf = (ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahqf != null) {
      return localahqf.a();
    }
    return false;
  }
  
  public View onCreatePanel(int paramInt)
  {
    ahqf localahqf = (ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahqf != null) {
      return localahqf.a(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public void onHideAllPanel()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a();
      i += 1;
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((ahqf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a(paramInt1, paramInt2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqe
 * JD-Core Version:    0.7.0.1
 */