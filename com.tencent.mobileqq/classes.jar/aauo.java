import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class aauo
  extends aavk
{
  public aauo(MoveFileActivity paramMoveFileActivity, bfrs parambfrs) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
    localIntent.putExtra("folderId", this.jdField_a_of_type_Bfrs.b);
    int i = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity().getResources().getDimensionPixelSize(2131299011);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
      String str = Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a);
      if (MoveFileActivity.c(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).equals("/"))
      {
        paramString = "0";
        bdll.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 2, anzj.a(2131705793), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.finish();
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.overridePendingTransition(0, 2130772001);
      return;
      paramString = "1";
      break;
      switch (paramInt)
      {
      default: 
        paramString = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getString(2131695424);
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, paramString, 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -302: 
      case -301: 
      case -103: 
        bdll.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anzj.a(2131705786), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -136: 
        bdll.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anzj.a(2131705790), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -107: 
      case -102: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anzj.a(2131705789), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -406: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anzj.a(2131705785), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -407: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anzj.a(2131705787), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauo
 * JD-Core Version:    0.7.0.1
 */