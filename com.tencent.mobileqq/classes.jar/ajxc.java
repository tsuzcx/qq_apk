import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;
import java.util.Collections;

public class ajxc
  extends VipFunCallObserver
{
  public ajxc(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList);
    this.a.d = this.a.jdField_a_of_type_JavaUtilArrayList.toString();
    this.a.a(false, 0);
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject1;
    int i;
    int j;
    String str;
    Object localObject2;
    Object localObject3;
    if (!paramBoolean)
    {
      localObject1 = (Bundle)paramObject;
      i = ((Bundle)localObject1).getInt("result");
      j = ((Bundle)localObject1).getInt("callId", this.a.jdField_a_of_type_Int);
      paramObject = ((Bundle)localObject1).getString("message");
      str = ((Bundle)localObject1).getString("svr_url");
      localObject2 = ((Bundle)localObject1).getString("svr_actStr");
      if (i != 9002) {
        break label278;
      }
      paramInt = 11;
      localObject3 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject3 = "你选择的来电动画为年费会员专享，开通即可使用此来电动画";
      }
      paramObject = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label554;
      }
      localObject2 = null;
      localObject1 = "立即开通";
      paramInt = 11;
      paramObject = localObject3;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramObject)) {
        if ((i == 22001) || (i == 6002))
        {
          paramObject = "未参加活动";
          label213:
          VipFunCallPreviewActivity localVipFunCallPreviewActivity = this.a;
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(str))
          {
            localObject3 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject3 = "了解详情";
            }
          }
          localVipFunCallPreviewActivity.a(paramInt, j, null, paramObject, (String)localObject2, (String)localObject3, str);
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(50);
          return;
          label278:
          if (i == 9003)
          {
            paramInt = 12;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = "你选择的来电动画为年费超级会员专享，开通即可使用此来电动画";
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label554;
            }
            localObject2 = null;
            localObject3 = "立即开通";
            paramInt = 12;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005011) || (i == 5002))
          {
            paramInt = 2;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = "你选择的来电动画为超级会员专享，开通即可使用此来电动画";
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label554;
            }
            localObject2 = null;
            localObject3 = "立即开通";
            paramInt = 2;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005012) || (i == 4002))
          {
            paramInt = 1;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = "你选择的来电动画为QQ会员专享，开通即可使用此来电动画";
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label554;
            }
            localObject2 = null;
            localObject3 = "立即开通";
            paramInt = 1;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if (i == 461001) {
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label548;
            }
          }
        }
      }
      label548:
      for (paramObject = "立即开通";; paramObject = localObject2)
      {
        localObject2 = "确定";
        str = IndividuationUrlHelper.a("funCallMine");
        paramInt = 6;
        localObject3 = "指定来电群组已达上限（5个）请在“我的来电”里删除其他来电群组后再添加新的分组。";
        localObject1 = paramObject;
        paramObject = localObject3;
        break;
        localObject3 = null;
        localObject1 = localObject2;
        paramInt = 4;
        localObject2 = localObject3;
        break;
        if (i == 3002)
        {
          paramObject = "已过试用期";
          break label213;
        }
        if (i == 8002)
        {
          paramObject = "未开通专区会员";
          break label213;
        }
        break label213;
      }
      label554:
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajxc
 * JD-Core Version:    0.7.0.1
 */