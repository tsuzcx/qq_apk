import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajzj
  implements acvi
{
  private QQAppInterface a;
  
  public ajzj(QQAppInterface paramQQAppInterface)
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
      QLog.d(ajzf.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = (ajzf)this.a.getManager(131);
    if ((localObject == null) || (!((ajzf)localObject).c()) || (((ajzf)localObject).c.get()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = ajzf.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject != null) {
          break label150;
        }
      }
      label150:
      for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((ajzf)localObject).a().jdField_a_of_type_Boolean + ", PacketEnable:" + ((ajzf)localObject).b() + ", mIsSDCardError:" + ((ajzf)localObject).c.get())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.post(new IndividualRedPacketManager.VIPHBStrategy.1(this, (ajzf)localObject, paramRedPacketInfo), 8, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aelu paramaelu)
  {
    if ((paramRedPacketInfo != null) && ((paramaelu instanceof aema)))
    {
      paramaelu = (aema)paramaelu;
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramaelu.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramaelu.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      paramRedPacketInfo.jdField_a_of_type_Acvh = paramaelu.jdField_a_of_type_Acvh;
      paramRedPacketInfo.b = paramaelu.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzj
 * JD-Core Version:    0.7.0.1
 */