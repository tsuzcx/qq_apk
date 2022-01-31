import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class amal
  extends alko
{
  private ArrayList<amam> a = new ArrayList();
  
  public amal(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((amam)localIterator.next()).a();
    }
  }
  
  public void a(amam paramamam)
  {
    if (paramamam == null) {}
    while (this.a.contains(paramamam)) {
      return;
    }
    this.a.add(paramamam);
  }
  
  public void a(String paramString)
  {
    if (this.app == null) {
      paramString = new UniPayRequest(this.mApp.getCurrentAccountUin(), "android" + paramString);
    }
    for (ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "VipSTCheckServer.UinPay");; localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VipSTCheckServer.UinPay"))
    {
      localToServiceMsg.extraData.putSerializable("UniPayRequest", paramString);
      super.send(localToServiceMsg);
      return;
      paramString = new UniPayRequest(this.app.getCurrentAccountUin(), "android" + paramString);
    }
  }
  
  public void b(amam paramamam)
  {
    if ((paramamam != null) && (this.a.contains(paramamam))) {
      this.a.remove(paramamam);
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {}
    do
    {
      do
      {
        return;
        str1 = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(str1));
      if ((str1.compareTo("VipSTCheckServer.UinPay") == 0) && (QLog.isColorLevel())) {
        QLog.i("UniPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str1.compareTo("VipSTCheckServer.UinPay") != 0);
    paramFromServiceMsg = (UniPayResponse)paramObject;
    paramToServiceMsg = paramFromServiceMsg.getSUin();
    int i = paramFromServiceMsg.getIShowOpen();
    int j = paramFromServiceMsg.getIUniPayType();
    new HashMap();
    Object localObject = paramFromServiceMsg.getMapResponse();
    paramFromServiceMsg = (String)((Map)localObject).get("cur_st");
    paramObject = (String)((Map)localObject).get("net_mobile_club");
    String str1 = (String)((Map)localObject).get("open_month");
    String str2 = (String)((Map)localObject).get("platform");
    String str3 = (String)((Map)localObject).get("ret");
    String str4 = (String)((Map)localObject).get("show_open");
    String str5 = (String)((Map)localObject).get("uin");
    localObject = (String)((Map)localObject).get("uin_pay_type");
    if (QLog.isColorLevel()) {
      QLog.d("UniPayHandler", 2, "sUin==" + paramToServiceMsg + ",isShowOpen==" + i + ",iUniPayType==" + j);
    }
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("uniPaySp_" + paramToServiceMsg, 4).edit();
    localEditor.putString("sUin", paramToServiceMsg);
    localEditor.putInt("isShowOpen", i);
    localEditor.putInt("iUinpPayType", j);
    localEditor.putString("cur_st", paramFromServiceMsg);
    localEditor.putString("net_mobile_club", paramObject);
    localEditor.putString("open_month", str1);
    localEditor.putString("platform", str2);
    localEditor.putString("ret", str3);
    localEditor.putString("show_open", str4);
    localEditor.putString("uin", str5);
    localEditor.putString("uin_pay_type", (String)localObject);
    localEditor.commit();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amal
 * JD-Core Version:    0.7.0.1
 */