import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aemt
  implements aivw
{
  public aemt(CustomizeStrategyFactory.SkinRedPacketStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    Object localObject1 = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      if (this.a.a.skinType != 1) {
        break label372;
      }
      paramPathResult = (String)localObject1 + File.separator;
      str1 = paramPathResult + "corner.png";
      localObject2 = paramPathResult + "base_bg.png";
      String str2 = paramPathResult + "anim_fg";
      paramInt = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.a * 300.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      BitmapFactory.Options localOptions = bdda.a(str1, paramInt);
      this.a.a.corner = SafeBitmapFactory.decodeFile(str1, localOptions);
      this.a.a.resPath = ((String)localObject1);
      this.a.a.background = ((String)localObject2);
      this.a.a.animInfo = AnimationView.AnimationInfo.loadFromFolder(str2);
      localObject1 = agin.a;
      j = localObject1.length;
      paramInt = 0;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        String str1;
        Object localObject2;
        int i;
        int j;
        label372:
        paramPathResult.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < j)
    {
      str1 = localObject1[paramInt];
      localObject2 = paramPathResult + str1 + ".png";
      localObject2 = SafeBitmapFactory.decodeFile((String)localObject2, bdda.a((String)localObject2, i));
      if (localObject2 != null) {
        this.a.a.attribute.putParcelable(str1, (Parcelable)localObject2);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.a.a.background + ",animInfo=" + this.a.a.animInfo);
      }
      for (;;)
      {
        CustomizeStrategyFactory.a().a(this.a.a);
        return;
        if (this.a.a.skinType == 2)
        {
          this.a.a.resPath = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_REDPACKET path=" + (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemt
 * JD-Core Version:    0.7.0.1
 */