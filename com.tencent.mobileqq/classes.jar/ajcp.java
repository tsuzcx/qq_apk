import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

class ajcp
  extends WtloginObserver
{
  public int a;
  public int b;
  
  ajcp(ajco paramajco) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      paramString = util.buf_to_string(paramArrayOfByte2);
      if (QLog.isColorLevel()) {
        QLog.i("cmgame_process.CmGameMainManager", 2, "OnGetOpenKeyWithoutPasswd token:" + paramString);
      }
      paramArrayOfByte1 = this.jdField_a_of_type_Ajco.a();
      if (paramArrayOfByte1 != null) {
        break label57;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label57:
        paramArrayOfByte2 = new JSONObject();
        paramArrayOfByte2.put("appId", paramLong2);
        paramArrayOfByte2.put("gameId", this.jdField_a_of_type_Int);
        paramArrayOfByte2.put("openKey", paramString);
        CmGameCmdChannel.a(paramArrayOfByte1).a(0, "cs.on_get_open_key.local", paramArrayOfByte2.toString(), this.b);
        paramArrayOfByte1 = ((ajmw)paramArrayOfByte1.getManager(155)).a(this.jdField_a_of_type_Ajco.a.gameId);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1.openKey = paramString;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "OpenKeyObserver error:", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */