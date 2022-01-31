import android.annotation.TargetApi;
import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

class agsy
  implements bfpt
{
  agsy(agsu paramagsu) {}
  
  @TargetApi(11)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)paramAdapterView.getAdapter().getItem(paramInt);
    if (((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramAdapterView) == 1)
    {
      if (((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a != null) {
        ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a.f();
      }
      return;
    }
    if (this.a.jdField_a_of_type_Agso.a)
    {
      ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a();
      return;
    }
    ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsy
 * JD-Core Version:    0.7.0.1
 */