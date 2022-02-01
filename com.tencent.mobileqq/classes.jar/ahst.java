import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;

class ahst
  implements AdapterView.OnItemClickListener
{
  ahst(ahso paramahso) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = this.a.a.a(paramInt);
    if (!ahtm.class.isInstance(localObject1)) {}
    label646:
    for (;;)
    {
      return;
      localObject1 = (ahtm)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + ahso.a(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + ahso.b(this.a).getLastVisiblePosition());
      }
      Object localObject2;
      int i;
      if (ahso.a(this.a))
      {
        localObject2 = ((ahtm)localObject1).a;
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
        else if (AIOLightVideoData.class.isInstance(((ahtm)localObject1).a))
        {
          QQToast.a(ahso.l(this.a), anvx.a(2131699589), 0).a();
          return;
        }
        i = this.a.a();
        if (i == 1)
        {
          if (AIOShortVideoData.class.isInstance(localObject2)) {
            QQToast.a(ahso.m(this.a), anvx.a(2131699596), 0).a();
          }
        }
        else if (i == 2)
        {
          if (AIOImageData.class.isInstance(localObject2)) {
            QQToast.a(ahso.n(this.a), anvx.a(2131699594), 0).a();
          }
        }
        else {
          if ((i == 0) && (!AIOImageData.class.isInstance(localObject2))) {
            break label481;
          }
        }
        if (((ahtm)localObject1).getSelected() == 1)
        {
          i = 1;
          label343:
          localObject2 = this.a;
          if (i != 0) {
            break label510;
          }
          label354:
          ((ahso)localObject2).a((ahtm)localObject1, bool, false);
          if (!this.a.a(paramView, (aawa)localObject1)) {
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
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + ahso.e(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + ahso.f(this.a).getLastVisiblePosition() + " SelectedIndex = " + this.a.a.b());
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
        if (AIOLightVideoData.class.isInstance(((ahtm)localObject1).a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "lightvideo could not be opened");
          }
          QQToast.a(ahso.o(this.a), anvx.a(2131699599), 0).a();
          return;
        }
        if (AIOShortVideoData.class.isInstance(((ahtm)localObject1).a)) {}
        this.a.a.e(paramInt);
        this.a.a.b(ahso.c(this.a).getFirstVisiblePosition());
        this.a.a.c(ahso.d(this.a).getLastVisiblePosition());
        this.a.t();
        this.a.a("Multi_Pic_big", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahst
 * JD-Core Version:    0.7.0.1
 */