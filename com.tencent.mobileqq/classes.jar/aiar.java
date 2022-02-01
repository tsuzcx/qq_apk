import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class aiar
  implements aiaq<PhotoListPanel>
{
  private agvq jdField_a_of_type_Agvq;
  private aiev jdField_a_of_type_Aiev;
  private aiex jdField_a_of_type_Aiex;
  private aiey jdField_a_of_type_Aiey;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  
  aiar(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agvq = ((agvq)paramBaseChatPie.a(7));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
      }
    }
    PhotoListPanel localPhotoListPanel;
    if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J))
      {
        Object localObject = new ArrayList();
        localObject = bgme.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
        localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label227;
        }
      }
    }
    for (;;)
    {
      localPhotoListPanel.setMixedMsgMode(bool);
      return;
      label227:
      bool = false;
    }
  }
  
  public int a()
  {
    return 4;
  }
  
  public PhotoListPanel a()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_Agvq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
    localObject = aiaf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, (Intent)localObject);
    if (this.jdField_a_of_type_Aiex == null) {
      this.jdField_a_of_type_Aiex = new aias(this);
    }
    if (this.jdField_a_of_type_Aiev == null) {
      this.jdField_a_of_type_Aiev = new aiat(this);
    }
    ((PhotoListPanel)localObject).setImageCountChangedListener(this.jdField_a_of_type_Aiex);
    ((PhotoListPanel)localObject).setCustomOnClickListener(this.jdField_a_of_type_Aiev);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J);
    this.jdField_a_of_type_Aiey = new aiau(this);
    ((PhotoListPanel)localObject).setImageSentListener(this.jdField_a_of_type_Aiey);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l));
    }
    return localObject;
  }
  
  public PhotoListPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = a();
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  }
  
  public void a()
  {
    if ((4 == this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public PhotoListPanel b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiar
 * JD-Core Version:    0.7.0.1
 */