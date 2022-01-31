import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agiy
  extends aggx
{
  private agiy(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static aggt b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Aggt = new agiy(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Aggt;
    }
    finally {}
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = (NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((paramAdapterView != null) && (!paramAdapterView.isFinishing())) {
      paramAdapterView.d.setText(ajjy.a(2131642355));
    }
  }
  
  protected void d()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (localObject != null)
    {
      ageh.a(((ArrayList)localObject).size(), this.jdField_a_of_type_Aggs.d);
      ageh.a(localIntent, ((ArrayList)localObject).size(), this.jdField_a_of_type_Aggs.c);
    }
    localObject = (NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localObject == null) || (((NewPhotoPreviewActivity)localObject).isFinishing())) {
      return;
    }
    ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
    ((NewPhotoPreviewActivity)localObject).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agiy
 * JD-Core Version:    0.7.0.1
 */