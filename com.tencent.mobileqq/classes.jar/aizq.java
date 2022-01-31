import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class aizq
  implements aifp
{
  public aizq(Context paramContext, AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void a()
  {
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
    localHashMap.put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
    awrn.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "cmgame_data_init_duration", true, l, 0L, localHashMap, "", false);
    QLog.d("CmGameStat", 1, new Object[] { "cmgame_data_init_duration=", Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizq
 * JD-Core Version:    0.7.0.1
 */