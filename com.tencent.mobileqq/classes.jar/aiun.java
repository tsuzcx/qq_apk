import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.RspReciteScore;
import com.tencent.qphone.base.util.QLog;

public class aiun
  extends ProtoUtils.TroopProtocolObserver
{
  public aiun(ReciteFragment paramReciteFragment, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      paramBundle = new hw_recite_score.RspReciteScore();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.score_grade.get();
        ReciteFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment).post(new aiuo(this, paramInt - 1));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ReciteFragment", 2, "InvalidProtocolBufferMicroException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiun
 * JD-Core Version:    0.7.0.1
 */