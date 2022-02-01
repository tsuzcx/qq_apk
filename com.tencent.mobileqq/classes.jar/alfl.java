import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetAvailableListListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketProxy.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketProxy.2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class alfl
  implements IRedPacket
{
  public alfl()
  {
    aleb.a().a();
  }
  
  public JSONObject getPopAd(int paramInt1, int paramInt2)
  {
    aleb.a().a();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_func", 4);
    ((Bundle)localObject1).putInt("key_skin_id", paramInt1);
    ((Bundle)localObject1).putInt("key_channel", paramInt2);
    localObject2 = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject1);
    if ((localObject2 != null) && (((EIPCResult)localObject2).isSuccess()))
    {
      localObject1 = ((EIPCResult)localObject2).data.getString("pop_ad_tips");
      String str = ((EIPCResult)localObject2).data.getString("pop_ad_url");
      paramInt1 = ((EIPCResult)localObject2).data.getInt("pop_ad_url_type");
      try
      {
        localObject2 = new JSONObject();
        return null;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject2).putOpt("pop_ad_tips", localObject1);
          ((JSONObject)localObject2).putOpt("pop_ad_url", str);
          ((JSONObject)localObject2).putOpt("pop_ad_url_type", Integer.valueOf(paramInt1));
          return localObject2;
        }
        catch (JSONException localJSONException2)
        {
          return localObject2;
        }
        localJSONException1 = localJSONException1;
        return null;
      }
    }
  }
  
  public List<String> getReadyResList()
  {
    return null;
  }
  
  public void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "getSkin | skinId = " + paramRedPacketInfoBase.skinId + ",skinType=" + paramRedPacketInfoBase.skinType);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_func", 1);
    localBundle.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
    localBundle.putParcelable("key_callback", aldt.a(new RedPacketProxy.1(this, null, paramOnGetSkinListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", localBundle, null);
  }
  
  public JSONObject getTail(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_func", 5);
    localBundle.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
    localBundle.putParcelable("key_callback", aldt.a(new RedPacketProxy.2(this, null, paramOnGetSkinListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", localBundle, null);
  }
  
  public boolean isRiskSwitchOpen()
  {
    aleb.a().a();
    boolean bool2 = false;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_func", 2);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).isSuccess()) {
        bool1 = ((EIPCResult)localObject).data.getBoolean("key_is_risk_switch_open");
      }
    }
    return bool1;
  }
  
  public void onActiveAccount() {}
  
  public boolean onGetThemeConfig(int paramInt)
  {
    aleb.a().a();
    boolean bool2 = false;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_func", 6);
    ((Bundle)localObject).putInt("theme_id", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).isSuccess()) {
        bool1 = ((EIPCResult)localObject).data.getBoolean("key_theme_exist");
      }
    }
    return bool1;
  }
  
  public void onUpdate(int paramInt) {}
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver) {}
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener) {}
  
  public void requestRedPacketSkinList()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_func", 3);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", localBundle, null);
  }
  
  public void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt) {}
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfl
 * JD-Core Version:    0.7.0.1
 */