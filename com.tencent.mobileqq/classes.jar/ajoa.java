import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class ajoa
  implements CompoundButton.OnCheckedChangeListener
{
  ajoa(ajnz paramajnz, ajod paramajod) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Ajod.a).troopuin.equals(ajnz.a(this.jdField_a_of_type_Ajnz)))) {
      this.jdField_a_of_type_Ajod.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */