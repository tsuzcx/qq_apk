import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.1;
import com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ajdd
{
  private int jdField_a_of_type_Int;
  private ajdg jdField_a_of_type_Ajdg;
  private ajdm jdField_a_of_type_Ajdm;
  public bbwf a;
  
  public ajdd(ajdg paramajdg, ajdm paramajdm)
  {
    this.jdField_a_of_type_Bbwf = new ajdf(this);
    this.jdField_a_of_type_Ajdg = paramajdg;
    this.jdField_a_of_type_Ajdm = paramajdm;
  }
  
  private void a(int paramInt)
  {
    Object localObject = ajae.a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameRscDownloader", 1, "[handleLoadSuppack], launcher is null, mGameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((ajch)localObject).a();
    } while (localObject == null);
    ((ajdh)localObject).a();
  }
  
  private void a(String paramString)
  {
    Object localObject = ajae.a();
    if ((localObject == null) || (this.jdField_a_of_type_Ajdg == null)) {
      return;
    }
    ajae.c(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int);
    bbwl localbbwl = null;
    localObject = (bbwi)((AppInterface)localObject).getManager(47);
    if (localObject != null) {
      localbbwl = ((bbwi)localObject).a(3);
    }
    if (localbbwl == null)
    {
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "updateGameRes no downloaderInterface");
      return;
    }
    localObject = bbct.b();
    if ((localObject != null) && (localObject.length == 2) && (localObject[1] <= 50L))
    {
      ApolloItemBuilder.a(ajyc.a(2131702102), 1, BaseApplicationImpl.getContext());
      QLog.w("cmgame_process.CmGameRscDownloader", 2, "updateGameRes:available space on SD card is less than 50M. ====> Stop download game rsc.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(ajmu.s).append(this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString);
    int k;
    if (this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean)
    {
      localObject = ".patch";
      paramString = new bbwg(paramString, new File((String)localObject));
      paramString.p = true;
      paramString.j = false;
      paramString.n = true;
      paramString.s = false;
      paramString.q = true;
      paramString.r = true;
      paramString.jdField_b_of_type_Boolean = true;
      paramString.f = "apollo_res";
      localObject = new Bundle();
      localbbwl.a(paramString, this.jdField_a_of_type_Bbwf, (Bundle)localObject);
      k = this.jdField_a_of_type_Ajdg.jdField_c_of_type_Int;
      if ((k != 2) && (k != 1)) {
        break label372;
      }
    }
    label372:
    for (int i = 1;; i = 0)
    {
      int j;
      if ((k != 4) && (k != 5))
      {
        j = k;
        if (k != 3) {}
      }
      else
      {
        j = 1;
      }
      this.jdField_a_of_type_Int = 1;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_start", i, j, new String[] { String.valueOf(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ajdg.jdField_a_of_type_Int), this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ajdg.jdField_d_of_type_Int) });
      return;
      localObject = ".zip";
      break;
    }
  }
  
  private void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "[doOnGameResFileDone]");
    }
    if (this.jdField_a_of_type_Ajdg == null) {}
    do
    {
      String str1;
      do
      {
        return;
        QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], download rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Ajdg.jdField_c_of_type_Long));
        boolean bool = this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean;
        String str2 = this.jdField_a_of_type_Ajdg.jdField_c_of_type_JavaLangString;
        str1 = ajmu.s + this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString + ".zip";
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
        try
        {
          localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString, false).commit();
          if (!bool) {
            break;
          }
          bool = airz.a(String.valueOf(this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString), str2);
          QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], patch rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Ajdg.jdField_c_of_type_Long));
          if (bool) {
            break;
          }
          QLog.e("cmgame_process.CmGameRscDownloader", 1, "fail to patch, download complete pack.");
          this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean = false;
          a(this.jdField_a_of_type_Ajdg.jdField_d_of_type_JavaLangString);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("cmgame_process.CmGameRscDownloader", 1, "uncompressZip fail zip file: " + str1, localException);
          localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString, true).commit();
        }
      } while (this.jdField_a_of_type_Ajdm == null);
      this.jdField_a_of_type_Ajdm.c(-1006, this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString);
      return;
      if (this.jdField_a_of_type_Ajdm != null) {
        bbdj.a(str1, this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int, this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString), false);
      }
      ApolloUtil.a();
      QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], unzip rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Ajdg.jdField_c_of_type_Long));
      ajae.a(new Object[] { "[downloadRes], done packName:", this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString, ", cost:", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Ajdg.jdField_c_of_type_Long) });
      a(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Ajdm != null) {
        this.jdField_a_of_type_Ajdm.b(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int, this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = 0;
    } while (this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean);
    int k = this.jdField_a_of_type_Ajdg.jdField_c_of_type_Int;
    if (k != 2) {
      if (k != 1) {
        break label626;
      }
    }
    for (;;)
    {
      int j;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_succeed", i, j, new String[] { String.valueOf(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ajdg.jdField_a_of_type_Int), this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ajdg.jdField_d_of_type_Int) });
      return;
      i = 1;
      label626:
      if ((k != 2) && (k != 5))
      {
        j = k;
        if (k != 3) {}
      }
      else
      {
        j = 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajdm != null) {
      this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int, this.jdField_a_of_type_Ajdg.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Ajdg.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Ajdg.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      ThreadManager.excute(new CmGameRscDownloader.2(this), 192, null, true);
      return;
    }
    boolean bool = bbev.h(BaseApplicationImpl.getApplication().getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.i("cmgame_process.CmGameRscDownloader", 2, "is wifi:" + bool + ",pkg size:" + this.jdField_a_of_type_Ajdg.jdField_b_of_type_Long + ",tip size:" + this.jdField_a_of_type_Ajdg.jdField_a_of_type_Long);
    }
    if ((bool) || (this.jdField_a_of_type_Ajdg.jdField_b_of_type_Long < this.jdField_a_of_type_Ajdg.jdField_a_of_type_Long))
    {
      if (this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean) {}
      for (localObject = this.jdField_a_of_type_Ajdg.jdField_e_of_type_JavaLangString;; localObject = this.jdField_a_of_type_Ajdg.jdField_d_of_type_JavaLangString)
      {
        a((String)localObject);
        return;
      }
    }
    Object localObject = new ajde(this);
    if (this.jdField_a_of_type_Ajdm != null) {
      this.jdField_a_of_type_Ajdm.a((aiwk)localObject, this.jdField_a_of_type_Ajdg.jdField_b_of_type_Long);
    }
    if ("message".equals(this.jdField_a_of_type_Ajdg.f)) {}
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", i, 3, new String[] { String.valueOf(this.jdField_a_of_type_Ajdg.jdField_b_of_type_Int) });
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ajdg == null) {}
    boolean bool;
    do
    {
      return false;
      bool = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Ajdg.jdField_a_of_type_JavaLangString, false);
      if (bool) {}
      QLog.i("cmgame_process.CmGameRscDownloader", 1, "isVerifyFail:" + bool + ",isUpdate:" + this.jdField_a_of_type_Ajdg.jdField_a_of_type_Boolean + ",isPatch:" + this.jdField_a_of_type_Ajdg.jdField_b_of_type_Boolean + "packType:" + this.jdField_a_of_type_Ajdg.jdField_d_of_type_Int + ",delay:" + this.jdField_a_of_type_Ajdg.jdField_e_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameRscDownloader", 2, new Object[] { "patchUrl:", this.jdField_a_of_type_Ajdg.jdField_e_of_type_JavaLangString });
      }
    } while ((!bool) && (!this.jdField_a_of_type_Ajdg.jdField_a_of_type_Boolean));
    ThreadManager.getSubThreadHandler().postDelayed(new CmGameRscDownloader.1(this), this.jdField_a_of_type_Ajdg.jdField_e_of_type_Int);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdd
 * JD-Core Version:    0.7.0.1
 */