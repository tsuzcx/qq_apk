import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class adqj
  extends bbri
{
  adqj(adqe paramadqe) {}
  
  protected void onPokeAuth(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (1 != ((Bundle)localObject).getInt("fromType")) {
      return;
    }
    int j = ((Bundle)localObject).getInt("id");
    int i = ((Bundle)localObject).getInt("feeType");
    String str1 = "free";
    if (4 == i)
    {
      str1 = "vip";
      label48:
      if (!paramBoolean) {
        break label161;
      }
      paramObject = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      aanz.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 126, j, paramObject, (String)localObject);
      if (true == adwj.a) {
        adwj.a = false;
      }
      label107:
      if (!paramBoolean) {
        break label422;
      }
    }
    label161:
    label420:
    label422:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (5 != i) {
        break label48;
      }
      str1 = "svip";
      break label48;
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.a.c = paramObject.getInt("id", 0);
      String str2 = ajya.a(2131705284);
      if (l == 0L)
      {
        this.a.d = 1;
        if (true != adwj.a) {
          break;
        }
        adwj.a = false;
        return;
      }
      if (l == 4002L)
      {
        this.a.d = 2;
        paramObject = ajya.a(2131705289);
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label420;
        }
        adwj.a(this.a.b, (Activity)this.a.jdField_a_of_type_AndroidContentContext, paramObject, (String)localObject, this.a.c, this.a.d);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.a.d = 4;
          paramObject = ajya.a(2131705288);
          localObject = str2;
        }
        else
        {
          this.a.d = 1;
          str2 = ajya.a(2131705287);
          QLog.e("GivingHeart", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adqj
 * JD-Core Version:    0.7.0.1
 */