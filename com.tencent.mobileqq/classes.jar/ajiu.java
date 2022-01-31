import android.app.Dialog;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.ShowPicPrice;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.List;

public class ajiu
  extends TroopGiftCallback
{
  public ajiu(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = (TroopGiftManager.ShowPicPrice)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if ((paramString == null) || (paramString.jdField_a_of_type_Int == 0)) {}
    for (paramInt2 = 30; paramInt1 >= paramInt2; paramInt2 = paramString.jdField_a_of_type_Int)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.c();
    DialogUtil.a(this.a, 230, this.a.getResources().getString(2131430738), this.a.getResources().getString(2131430739), this.a.getResources().getString(2131432998), this.a.getResources().getString(2131430740), new ajiv(this), new ajiw(this)).show();
    TroopPicEffectsController.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajiu
 * JD-Core Version:    0.7.0.1
 */