import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afpz
  extends ajxj
{
  afpz(afpy paramafpy) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    super.onCancelMayKnowRecommend(paramBoolean, paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("delete mayKnowData ");
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (String str = "success";; str = "false")
    {
      QLog.d("CardViewController", 2, str + ", delete uin is " + paramString);
      this.a.b();
      return;
    }
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    super.onMayKnowEntryStateChanged(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("do network checkUpdate, rsp ");
      if (paramBoolean)
      {
        paramBundle = "success";
        QLog.d("CardViewController", 2, paramBundle + ". msg: \"send network respond done\"");
      }
    }
    else
    {
      if (paramBoolean) {
        break label82;
      }
      afpy.a(this.a, System.currentTimeMillis());
    }
    for (;;)
    {
      afpy.a(this.a, true, paramBoolean);
      return;
      paramBundle = "false";
      break;
      label82:
      afpy.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("recv mayKnowData push add ");
      if (!paramBoolean) {
        break label108;
      }
      localObject = "success";
      localObject = localStringBuilder.append((String)localObject).append(", push uin size is ");
      if (paramList == null) {
        break label115;
      }
    }
    label108:
    label115:
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("CardViewController", 2, i);
      if ((paramList != null) && (!paramList.isEmpty())) {
        afpy.a(this.a, paramList.size());
      }
      this.a.b();
      return;
      localObject = "false";
      break;
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("recv mayKnowData push del ");
      if (!paramBoolean) {
        break label82;
      }
      localObject = "success";
      localObject = localStringBuilder.append((String)localObject).append(", push uin size is ");
      if (paramList == null) {
        break label89;
      }
    }
    label82:
    label89:
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("CardViewController", 2, i);
      this.a.b();
      return;
      localObject = "false";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpz
 * JD-Core Version:    0.7.0.1
 */