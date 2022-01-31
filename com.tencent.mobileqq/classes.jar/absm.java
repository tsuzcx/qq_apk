import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;

public class absm
  extends ServerConfigObserver
{
  public absm(AboutConfig paramAboutConfig) {}
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    int i = 0;
    int m = 0;
    if ((paramInt & 0x20) == 0) {
      return;
    }
    paramInt = i;
    Object localObject1;
    Object localObject2;
    int j;
    label60:
    GetResourceRespInfoV2 localGetResourceRespInfoV2;
    if (paramBoolean)
    {
      paramInt = i;
      if (paramGetResourceRespV2 != null)
      {
        localObject1 = AboutConfig.a(this.a).getEntityManagerFactory().createEntityManager();
        localObject2 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        paramInt = 0;
        j = 0;
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          if (localGetResourceRespInfoV2.iPluginType == 32)
          {
            if ((localGetResourceRespInfoV2.sResSubType != 0) && (localGetResourceRespInfoV2.sResSubType != 2)) {
              break label524;
            }
            if (ConfigManager.a((EntityManager)localObject1, AboutConfig.a(this.a), localGetResourceRespInfoV2).cDefaultState != 0) {
              break label515;
            }
            paramInt = 1;
            i = 1;
            j = 1;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break label60;
        localObject2 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          if ((localGetResourceRespInfoV2.iPluginType == 32) && ((localGetResourceRespInfoV2.sResSubType == 0) || (localGetResourceRespInfoV2.sResSubType == 2)))
          {
            ResourcePluginInfo.remove((EntityManager)localObject1, localGetResourceRespInfoV2.strPkgName);
            i = 1;
          }
        }
        paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
          if ((((GetResourceRespInfoV2)localObject2).iPluginType == 32) && ((((GetResourceRespInfoV2)localObject2).sResSubType == 0) || (((GetResourceRespInfoV2)localObject2).sResSubType == 2)))
          {
            ConfigManager.a((EntityManager)localObject1, AboutConfig.a(this.a), (GetResourceRespInfoV2)localObject2);
            i = 1;
          }
        }
        ((EntityManager)localObject1).a();
        this.a.a(true, false);
        k = m;
        if (i != 0)
        {
          paramGetResourceRespV2 = new ArrayList(AboutConfig.a(this.a)).iterator();
          while (paramGetResourceRespV2.hasNext())
          {
            localObject1 = (ResourcePluginListener)paramGetResourceRespV2.next();
            if (j != 0)
            {
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)3, 2);
              if (paramInt != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AboutConfig", 2, "inform STATE_NEW_OPEN_PLUGIN");
                }
                ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)4, 2);
              }
            }
            else
            {
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)2, 2);
            }
          }
          break;
        }
        label415:
        if (k >= AboutConfig.a(this.a).size()) {
          break;
        }
        try
        {
          ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(this.a).get(k), (byte)1, 2);
          label454:
          k += 1;
          break label415;
          while (paramInt < AboutConfig.a(this.a).size()) {
            try
            {
              ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(this.a).get(paramInt), (byte)-1, 2);
              label500:
              paramInt += 1;
            }
            catch (Exception paramGetResourceRespV2)
            {
              break label500;
            }
          }
        }
        catch (Exception paramGetResourceRespV2)
        {
          break label454;
        }
      }
      label515:
      j = 1;
      i = 1;
      continue;
      label524:
      int k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     absm
 * JD-Core Version:    0.7.0.1
 */