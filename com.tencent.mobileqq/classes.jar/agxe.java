import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class agxe
  implements bjvm
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<agxf<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  
  public agxe(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public <T extends View> T a(int paramInt)
  {
    agxf localagxf = (agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localagxf != null) {
      return localagxf.a();
    }
    return null;
  }
  
  public void a()
  {
    a(new agxl(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new agxm(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new agwv(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new agwu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new agxg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    a(new agxn(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahhp))) {
      a(new agxq(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie));
    }
  }
  
  public void a(int paramInt)
  {
    agxf localagxf = (agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localagxf != null) {
      localagxf.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    }
  }
  
  void a(agxf<? extends View> paramagxf)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramagxf.a(), paramagxf);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
  }
  
  public boolean isNeedRecreatePanel(int paramInt)
  {
    agxf localagxf = (agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localagxf != null) {
      return localagxf.a();
    }
    return false;
  }
  
  public View onCreatePanel(int paramInt)
  {
    agxf localagxf = (agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localagxf != null) {
      return localagxf.a(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public void onHideAllPanel()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a();
      i += 1;
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((agxf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a(paramInt1, paramInt2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxe
 * JD-Core Version:    0.7.0.1
 */