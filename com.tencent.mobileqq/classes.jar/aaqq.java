import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aaqq
  extends aaqz
{
  public aaqq(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, besl parambesl)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131298998);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambesl);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839304);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755341);
      MoveFileActivity.a(this.a).i(parambesl);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      bcst.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambesl.b, "", "");
      QQToast.a(this.a.getActivity(), 2, anni.a(2131705685), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambesl = this.a.getString(2131695381);
      QQToast.a(this.a.getActivity(), 1, parambesl, 0).b(i);
      return;
    case -313: 
      parambesl = this.a.getString(2131696646);
      bcst.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131696815), null, this.a.jdField_a_of_type_JavaLangString, parambesl);
      return;
      parambesl = this.a.getString(2131696651);
      bcst.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambesl = this.a.getString(2131696649);
      QQToast.a(this.a.getActivity(), 1, parambesl, 0).b(i);
      return;
      parambesl = this.a.getString(2131696648);
      QQToast.a(this.a.getActivity(), 1, parambesl, 0).b(i);
      return;
      parambesl = this.a.getString(2131696652);
      QQToast.a(this.a.getActivity(), 1, parambesl, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */