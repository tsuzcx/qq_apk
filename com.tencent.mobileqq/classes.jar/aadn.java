import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;

public class aadn
  implements Runnable
{
  public aadn(PokeBigResHandler paramPokeBigResHandler) {}
  
  public void run()
  {
    PokeBigResHandler.a(true);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a.b.getApp());
    String str = this.a.b.getAccount();
    PokeBigResHandler.a(localSharedPreferences.getString(str + "_" + "aio_poke_res_url", ""));
    PokeBigResHandler.b(localSharedPreferences.getString(str + "_" + "aio_poke_res_md5", ""));
    if (TextUtils.isEmpty(PokeBigResHandler.a()))
    {
      PokeBigResHandler.a(false);
      return;
    }
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = PokeBigResHandler.a(this.a);
    localHttpNetReq.jdField_a_of_type_JavaLangString = PokeBigResHandler.a();
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = (PokeBigResHandler.b() + "poke.zip");
    ((OldHttpEngine)this.a.a.getNetEngine(0)).a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aadn
 * JD-Core Version:    0.7.0.1
 */