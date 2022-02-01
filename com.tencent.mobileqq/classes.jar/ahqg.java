import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class ahqg
  implements ahqf<PhotoListPanel>
{
  private agje jdField_a_of_type_Agje;
  private ahul jdField_a_of_type_Ahul;
  private ahun jdField_a_of_type_Ahun;
  private ahuo jdField_a_of_type_Ahuo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  ahqg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_Agje = ((agje)paramBaseChatPie.getHelper(7));
  }
  
  private void a(ahzx paramahzx)
  {
    if (paramahzx.h) {
      aftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, null, null);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
      }
    }
    PhotoListPanel localPhotoListPanel;
    if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.receiptMode))
      {
        Object localObject = new ArrayList();
        localObject = bgcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getEditableText(), (ArrayList)localObject);
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
  
  private void b(XPanelContainer paramXPanelContainer)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().requestPermissions(new ahqk(this, paramXPanelContainer), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        c(paramXPanelContainer);
        return;
        i = 1;
      }
    }
  }
  
  private void c(XPanelContainer paramXPanelContainer)
  {
    int i = 0;
    aght localaght = (aght)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(24);
    boolean bool = localaght.a();
    int j = localaght.a();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelProvider", 2, "doPhotoListAction fullStatus:" + bool + ", cnt:" + j);
    }
    if (bool)
    {
      if (j >= 20) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694649, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
      }
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1034)) {
          i = 1;
        }
        if ((i != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isReplyTextMode()))
        {
          localaght.a(true);
          return;
        }
        aftr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), j);
        paramXPanelContainer = (agje)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(7);
      } while (paramXPanelContainer == null);
      paramXPanelContainer.d();
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694624, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
      return;
    }
    paramXPanelContainer.a(4);
    ahpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
  }
  
  public int a()
  {
    return 4;
  }
  
  public PhotoListPanel a()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_Agje.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    localObject = ahpt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons, false, (Intent)localObject);
    if (this.jdField_a_of_type_Ahun == null) {
      this.jdField_a_of_type_Ahun = new ahqh(this);
    }
    if (this.jdField_a_of_type_Ahul == null) {
      this.jdField_a_of_type_Ahul = new ahqi(this);
    }
    ((PhotoListPanel)localObject).setImageCountChangedListener(this.jdField_a_of_type_Ahun);
    ((PhotoListPanel)localObject).setCustomOnClickListener(this.jdField_a_of_type_Ahul);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.switchPhotoListFilterForReceiptMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.receiptMode);
    this.jdField_a_of_type_Ahuo = new ahqj(this);
    ((PhotoListPanel)localObject).setImageSentListener(this.jdField_a_of_type_Ahuo);
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
    if ((4 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahzx)) {
      a((ahzx)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    b(paramXPanelContainer);
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
 * Qualified Name:     ahqg
 * JD-Core Version:    0.7.0.1
 */