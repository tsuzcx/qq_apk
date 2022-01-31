import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agii
  extends aggx
{
  private final String a;
  
  private agii(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_JavaLangString = "PhotoPreviewLogicAEPlay";
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Aggs.a >= 700L)
    {
      this.jdField_a_of_type_Aggs.a = l;
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString, 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
    }
  }
  
  public static aggt b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Aggt = new agii(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Aggt;
    }
    finally {}
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Aggf.jdField_a_of_type_Int;
  }
  
  protected void a(View paramView)
  {
    if ((!this.jdField_a_of_type_Aggf.b.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()))) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Aggf.jdField_a_of_type_Int))
    {
      a(String.format(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131624248), new Object[] { Integer.valueOf(this.jdField_a_of_type_Aggf.jdField_a_of_type_Int) }));
      return;
    }
    super.a(paramView);
  }
  
  protected void b()
  {
    super.b();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setOnClickListener(new agij(this));
  }
  
  protected void c()
  {
    super.c();
    String str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131651310);
    int i = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();
    str = str + " " + i + "/" + this.jdField_a_of_type_Aggf.jdField_a_of_type_Int;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setText(str);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setEnabled(true);
    if (d())
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setBackgroundResource(2130848461);
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setBackgroundResource(2130837660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agii
 * JD-Core Version:    0.7.0.1
 */