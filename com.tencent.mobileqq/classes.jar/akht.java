import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Collection;
import java.util.Iterator;

public class akht
  extends MqqWeakReferenceHandler
{
  public akht(PendantInfo paramPendantInfo, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l;
    Object localObject;
    if (paramMessage.what == 16)
    {
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.g == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if (localObject != null) {
            ((Drawable)localObject).invalidateSelf();
          }
        }
      }
      paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      return;
      if (paramMessage.what != 17) {
        break label527;
      }
      this.a.b = true;
      this.a.q = this.a.a(this.a.q);
      if (!(paramMessage.obj instanceof Bitmap)) {
        break label489;
      }
      localObject = (Bitmap)paramMessage.obj;
      if ((localObject != null) && (this.a.b() != localObject))
      {
        localBitmap = this.a.a();
        if (localBitmap != null)
        {
          if ((!localBitmap.isMutable()) || (Build.VERSION.SDK_INT <= 11)) {
            break label435;
          }
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        }
        label217:
        this.a.a((Bitmap)localObject);
      }
      l = paramMessage.getData().getLong("targetId");
      try
      {
        if (PendantInfo.g != l) {
          break label451;
        }
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if (localObject != null) {
            ((Drawable)localObject).invalidateSelf();
          }
        }
        if (2 != this.a.o) {}
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "handleMessage, exception:" + paramMessage.getMessage());
        }
      }
    }
    label329:
    if (this.a.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "cancel decode pendant in market:" + this.a.jdField_a_of_type_Long);
      }
      this.a.c = false;
      l = PendantInfo.g;
      this.a.q = 0;
      this.a.r = 3;
    }
    for (;;)
    {
      if (this.a.r == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
        return;
        label435:
        localBitmap.recycle();
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
        break label217;
        label451:
        paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break label329;
        }
        paramMessage.invalidateSelf();
        break label329;
      }
      this.a.b(l);
      return;
      label489:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PendantInfo", 2, "wrong type , msg.obj = " + paramMessage.obj.getClass());
      return;
      label527:
      if (paramMessage.what == 18)
      {
        if ((!this.a.jdField_a_of_type_Boolean) && (this.a.o == 2) && (this.a.r > 0))
        {
          this.a.b(paramMessage.getData().getLong("targetId"));
          return;
        }
        if ((this.a.jdField_a_of_type_Boolean) || (this.a.o != 1)) {
          break;
        }
        this.a.d();
        return;
      }
      if (paramMessage.what == 19)
      {
        l = paramMessage.getData().getLong("targetId");
        if (PendantInfo.g == l)
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
          while (paramMessage.hasNext())
          {
            localObject = (Drawable)paramMessage.next();
            if (localObject != null) {
              this.a.a((Drawable)localObject, true, 0L);
            }
          }
          break;
        }
        paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break;
        }
        this.a.a(paramMessage, false, 0L);
        return;
      }
      if (paramMessage.what != 20) {
        break;
      }
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.g == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if ((localObject != null) && ((localObject instanceof VipPendantDrawable))) {
            this.a.a((VipPendantDrawable)localObject, l);
          }
        }
        break;
      }
      paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if ((paramMessage == null) || (!(paramMessage instanceof VipPendantDrawable))) {
        break;
      }
      this.a.a((VipPendantDrawable)paramMessage, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akht
 * JD-Core Version:    0.7.0.1
 */