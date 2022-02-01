import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/helper/CreatePlusPanelHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "mPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "TAG", "", "mViewModel", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PlusPanelViewModel;", "getAppList", "", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PlusPanelAppInfo;", "getTag", "interestedIn", "", "onMoveToState", "", "state", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aghg
  implements agin
{
  private ahvi jdField_a_of_type_Ahvi;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final String jdField_a_of_type_JavaLangString;
  
  public aghg(@Nullable BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaLangString = "CreatePlusPanelHelper";
  }
  
  @Nullable
  public final List<PlusPanelAppInfo> a()
  {
    ahvi localahvi = this.jdField_a_of_type_Ahvi;
    if (localahvi != null) {
      return localahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    label120:
    for (;;)
    {
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onShowFirst create pluspanel");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null) {}
      for (localObject = ((BaseChatPie)localObject).getActivity();; localObject = null)
      {
        if (!(localObject instanceof FragmentActivity)) {
          break label120;
        }
        this.jdField_a_of_type_Ahvi = ((ahvi)axne.a((ViewModelStoreOwner)axnd.a((FragmentActivity)localObject)).get(ahvi.class));
        localObject = this.jdField_a_of_type_Ahvi;
        if (localObject != null) {
          ((ahvi)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (localObject == null) {
          break;
        }
        localObject = ((BaseChatPie)localObject).panelicons;
        if (localObject == null) {
          break;
        }
        ((PanelIconLinearLayout)localObject).c();
        return;
      }
    }
  }
  
  @NotNull
  public int[] a()
  {
    return new int[] { 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghg
 * JD-Core Version:    0.7.0.1
 */