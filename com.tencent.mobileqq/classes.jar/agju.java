import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.PatchedButton;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

public class agju
  implements agma, agmn
{
  private BaseChatPie a;
  protected PatchedButton a;
  public AIOLongCaptureCtrl a;
  
  agju(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131380577));
      this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = new AIOLongCaptureCtrl(new agjv(this));
      bowj.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl);
      return;
    }
    bowj.b(this.jdField_a_of_type_ComTencentWidgetPatchedButton, this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl != null) {
      this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public int[] a()
  {
    return new int[] { 0, 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agju
 * JD-Core Version:    0.7.0.1
 */