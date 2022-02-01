package mqq.app;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MainService$7
  implements IAuthHandler
{
  MainService$7(MainService paramMainService) {}
  
  public void onDelLoginedAccountResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onGetKeyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onGetSidResp(int paramInt1, int paramInt2, String paramString1, String paramString2, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.attributes.put("sid", paramString2);
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onGetUinSignResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramFromServiceMsg.attributes.put(paramFromServiceMsg.getServiceCmd(), paramArrayOfByte);
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onReceVerifyCode(VerifyCodeInfo paramVerifyCodeInfo, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.addAttribute("VerifyCodeInfo", paramVerifyCodeInfo);
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRecvChangeTokenResp(int paramInt1, int paramInt2, String paramString, RespondCustomSig paramRespondCustomSig, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramRespondCustomSig != null)
    {
      paramString = paramRespondCustomSig.SigList.iterator();
      while (paramString.hasNext())
      {
        paramRespondCustomSig = (CustomSigContent)paramString.next();
        if (paramRespondCustomSig.ulSigType == 14L)
        {
          if (paramRespondCustomSig.sResult == 0)
          {
            paramRespondCustomSig = HexUtil.bytes2HexStr(paramRespondCustomSig.SigContent);
            paramFromServiceMsg.attributes.put("vkey", paramRespondCustomSig);
          }
        }
        else if (paramRespondCustomSig.ulSigType == 8L)
        {
          if (paramRespondCustomSig.sResult == 0)
          {
            paramRespondCustomSig = HexUtil.bytes2HexStr(paramRespondCustomSig.SigContent);
            paramFromServiceMsg.attributes.put("STwxWeb", paramRespondCustomSig);
          }
        }
        else if (paramRespondCustomSig.ulSigType == 13L)
        {
          if (paramRespondCustomSig.sResult == 0)
          {
            paramRespondCustomSig = paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
            if ((paramRespondCustomSig != null) && ((paramRespondCustomSig instanceof ArrayList)))
            {
              paramRespondCustomSig = (ArrayList)paramRespondCustomSig;
              paramFromServiceMsg.attributes.put("arrD3", paramRespondCustomSig);
            }
          }
        }
        else if (paramRespondCustomSig.ulSigType == 19L)
        {
          if ((paramRespondCustomSig.sResult == 0) && (paramRespondCustomSig.SigContent != null))
          {
            paramRespondCustomSig = new String(paramRespondCustomSig.SigContent);
            paramFromServiceMsg.attributes.put("skey", paramRespondCustomSig);
          }
          else
          {
            try
            {
              paramRespondCustomSig = new String(paramRespondCustomSig.SigContent, "utf-8");
              paramFromServiceMsg.attributes.put("skeyError", paramRespondCustomSig);
            }
            catch (UnsupportedEncodingException paramRespondCustomSig)
            {
              paramRespondCustomSig.printStackTrace();
            }
          }
        }
        else if ((paramRespondCustomSig.ulSigType == 21L) && (paramRespondCustomSig.sResult == 0))
        {
          paramRespondCustomSig = paramRespondCustomSig.SigContent;
          paramFromServiceMsg.attributes.put("superkey", paramRespondCustomSig);
        }
      }
    }
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRecvChangeUinLoginResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
    paramString = (String)paramToServiceMsg.getAttribute("from_where");
    if ((!"subaccount".equals(paramString)) && (!"ssoAccountAction".equals(paramString))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramInt1 != 0))
    {
      paramString = SimpleAccount.parseSimpleAccount((String)paramFromServiceMsg.getAttribute("resp_simpleAccount"));
      MainService.access$000(this.this$0).createNewRuntime(paramString, true, true, 4, null);
    }
  }
  
  public void onRecvChangeUinResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRecvLoginResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
    paramString = (String)paramToServiceMsg.getAttribute("from_where");
    if ((!"subaccount".equals(paramString)) && (!"ssoAccountAction".equals(paramString))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramInt1 != 0))
    {
      paramString = SimpleAccount.parseSimpleAccount((String)paramFromServiceMsg.getAttribute("resp_simpleAccount"));
      MainService.access$000(this.this$0).createNewRuntime(paramString, true, true, 3, null);
    }
  }
  
  public void onRefreSidResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.attributes.put("sid", paramString);
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.7
 * JD-Core Version:    0.7.0.1
 */