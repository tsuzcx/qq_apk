import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;

class aeii
  implements bfpt
{
  aeii(aeid paramaeid) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = this.a.a.a(paramInt);
    if (!aeiy.class.isInstance(localObject1)) {}
    label646:
    for (;;)
    {
      return;
      localObject1 = (aeiy)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + aeid.a(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + aeid.b(this.a).getLastVisiblePosition());
      }
      Object localObject2;
      int i;
      if (aeid.a(this.a))
      {
        localObject2 = ((aeiy)localObject1).a;
        if (AIOFilePicData.class.isInstance(localObject2))
        {
          if ((((AIOFilePicData)localObject2).a(20) == null) && (((AIOFilePicData)localObject2).a(18) == null) && (((AIOFilePicData)localObject2).a(16) == null))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path,onItemClick: " + paramInt);
          }
        }
        else if (AIOLightVideoData.class.isInstance(((aeiy)localObject1).a))
        {
          bcql.a(aeid.n(this.a), ajya.a(2131700089), 0).a();
          return;
        }
        i = this.a.a();
        if (i == 1)
        {
          if (AIOShortVideoData.class.isInstance(localObject2)) {
            bcql.a(aeid.o(this.a), ajya.a(2131700096), 0).a();
          }
        }
        else if (i == 2)
        {
          if (AIOImageData.class.isInstance(localObject2)) {
            bcql.a(aeid.p(this.a), ajya.a(2131700094), 0).a();
          }
        }
        else {
          if ((i == 0) && (!AIOImageData.class.isInstance(localObject2))) {
            break label481;
          }
        }
        if (((aeiy)localObject1).b() == 1)
        {
          i = 1;
          label343:
          localObject2 = this.a;
          if (i != 0) {
            break label510;
          }
          label354:
          ((aeid)localObject2).a((aeiy)localObject1, bool, false);
          if (!this.a.a(paramView, (xpv)localObject1)) {
            ((AbstractImageAdapter)paramAdapterView.getAdapter()).notifyDataSetChanged();
          }
          this.a.w();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label646;
        }
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + aeid.e(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + aeid.f(this.a).getLastVisiblePosition() + " SelectedIndex = " + this.a.a.b());
        return;
        label481:
        if ((AIOFilePicData.class.isInstance(localObject2)) || (!AIOShortVideoData.class.isInstance(localObject2))) {
          break;
        }
        break;
        i = 0;
        break label343;
        label510:
        bool = false;
        break label354;
        if (AIOLightVideoData.class.isInstance(((aeiy)localObject1).a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "lightvideo could not be opened");
          }
          bcql.a(aeid.q(this.a), ajya.a(2131700099), 0).a();
          return;
        }
        if (AIOShortVideoData.class.isInstance(((aeiy)localObject1).a)) {}
        this.a.a.e(paramInt);
        this.a.a.b(aeid.c(this.a).getFirstVisiblePosition());
        this.a.a.c(aeid.d(this.a).getLastVisiblePosition());
        this.a.t();
        this.a.a("Multi_Pic_big", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeii
 * JD-Core Version:    0.7.0.1
 */