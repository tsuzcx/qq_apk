import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aagr
  extends aahb
{
  public aagr(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, bfif parambfif)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131299080);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambfif);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839368);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755343);
      MoveFileActivity.a(this.a).i(parambfif);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      bdla.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambfif.b, "", "");
      QQToast.a(this.a.getActivity(), 2, anvx.a(2131706374), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambfif = this.a.getString(2131695815);
      QQToast.a(this.a.getActivity(), 1, parambfif, 0).b(i);
      return;
    case -313: 
      parambfif = this.a.getString(2131697104);
      bdla.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697279), null, this.a.jdField_a_of_type_JavaLangString, parambfif);
      return;
      parambfif = this.a.getString(2131697109);
      bdla.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambfif = this.a.getString(2131697107);
      QQToast.a(this.a.getActivity(), 1, parambfif, 0).b(i);
      return;
      parambfif = this.a.getString(2131697106);
      QQToast.a(this.a.getActivity(), 1, parambfif, 0).b(i);
      return;
      parambfif = this.a.getString(2131697110);
      QQToast.a(this.a.getActivity(), 1, parambfif, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagr
 * JD-Core Version:    0.7.0.1
 */