import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aaut
  extends aavc
{
  public aaut(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, bfrs parambfrs)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131299011);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambfrs);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839312);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755342);
      MoveFileActivity.a(this.a).i(parambfrs);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      bdll.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambfrs.b, "", "");
      QQToast.a(this.a.getActivity(), 2, anzj.a(2131705792), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambfrs = this.a.getString(2131695424);
      QQToast.a(this.a.getActivity(), 1, parambfrs, 0).b(i);
      return;
    case -313: 
      parambfrs = this.a.getString(2131696695);
      bdll.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131696864), null, this.a.jdField_a_of_type_JavaLangString, parambfrs);
      return;
      parambfrs = this.a.getString(2131696700);
      bdll.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambfrs = this.a.getString(2131696698);
      QQToast.a(this.a.getActivity(), 1, parambfrs, 0).b(i);
      return;
      parambfrs = this.a.getString(2131696697);
      QQToast.a(this.a.getActivity(), 1, parambfrs, 0).b(i);
      return;
      parambfrs = this.a.getString(2131696701);
      QQToast.a(this.a.getActivity(), 1, parambfrs, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaut
 * JD-Core Version:    0.7.0.1
 */