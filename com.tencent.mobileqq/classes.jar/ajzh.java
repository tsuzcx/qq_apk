import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajzh
  implements acve
{
  private QQAppInterface a;
  
  public ajzh(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo == null) || (TextUtils.isEmpty(paramRedPacketInfo.templateId))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ajzd.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = (ajzd)this.a.getManager(131);
    if ((localObject == null) || (!((ajzd)localObject).c()) || (((ajzd)localObject).c.get()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = ajzd.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject != null) {
          break label150;
        }
      }
      label150:
      for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((ajzd)localObject).a().jdField_a_of_type_Boolean + ", PacketEnable:" + ((ajzd)localObject).b() + ", mIsSDCardError:" + ((ajzd)localObject).c.get())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.post(new IndividualRedPacketManager.VIPHBStrategy.1(this, (ajzd)localObject, paramRedPacketInfo), 8, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aels paramaels)
  {
    if ((paramRedPacketInfo != null) && ((paramaels instanceof aely)))
    {
      paramaels = (aely)paramaels;
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramaels.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramaels.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      paramRedPacketInfo.jdField_a_of_type_Acvd = paramaels.jdField_a_of_type_Acvd;
      paramRedPacketInfo.b = paramaels.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzh
 * JD-Core Version:    0.7.0.1
 */