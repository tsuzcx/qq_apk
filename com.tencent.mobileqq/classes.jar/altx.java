import android.text.TextUtils;
import com.tencent.ark.ArkAppPanelList.AppDetail;
import com.tencent.ark.ArkAppPanelList.RespBody;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class altx
  implements ajtg
{
  public altx(ArkMessageServerLogic.1 param1) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      localObject1 = new ArkAppPanelList.RespBody();
      try
      {
        ((ArkAppPanelList.RespBody)localObject1).mergeFrom((byte[])paramObject);
        localArrayList = new ArrayList();
        if (((ArkAppPanelList.RespBody)localObject1).apps.has())
        {
          paramObject = ((ArkAppPanelList.RespBody)localObject1).apps.get();
          if ((paramObject == null) || (paramObject.size() <= 0)) {
            break label234;
          }
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            localObject2 = (ArkAppPanelList.AppDetail)paramObject.next();
            if (localObject2 != null)
            {
              localObject1 = ((ArkAppPanelList.AppDetail)localObject2).appName.get();
              str = ((ArkAppPanelList.AppDetail)localObject2).cnName.get();
              localObject2 = ((ArkAppPanelList.AppDetail)localObject2).iconUrl.get();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                localArrayList.add(new alth((String)localObject1, str, (String)localObject2));
                continue;
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList mergeFrom exception=" + paramObject);
        if (this.a.a != null) {
          this.a.a.b(null);
        }
      }
    }
    label234:
    while (this.a.a == null)
    {
      ArrayList localArrayList;
      do
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          String str;
          paramObject = null;
        }
      } while (this.a.a == null);
      this.a.a.b(localArrayList);
      return;
    }
    this.a.a.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altx
 * JD-Core Version:    0.7.0.1
 */