import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class aagm
  extends aahj
{
  public aagm(MoveFileActivity paramMoveFileActivity, bfif parambfif) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
    localIntent.putExtra("folderId", this.jdField_a_of_type_Bfif.b);
    int i = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity().getResources().getDimensionPixelSize(2131299080);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
      String str = Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a);
      if (MoveFileActivity.c(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).equals("/"))
      {
        paramString = "0";
        bdla.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 2, anvx.a(2131706375), 0).b(i);
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
        paramString = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getString(2131695815);
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, paramString, 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -302: 
      case -301: 
      case -103: 
        bdla.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anvx.a(2131706368), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -136: 
        bdla.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anvx.a(2131706372), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -107: 
      case -102: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anvx.a(2131706371), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -406: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anvx.a(2131706367), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -407: 
        QQToast.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, anvx.a(2131706369), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagm
 * JD-Core Version:    0.7.0.1
 */