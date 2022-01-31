import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agut
  extends agtc
{
  private final String a;
  
  private agut(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_JavaLangString = "PhotoPreviewLogicAEPlay";
  }
  
  public static agss b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agss = new agut(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agss;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Agsr.a >= 700L)
    {
      this.jdField_a_of_type_Agsr.a = l;
      bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString, 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agsb.jdField_a_of_type_Int;
  }
  
  protected void a(View paramView)
  {
    if ((!this.jdField_a_of_type_Agsb.b.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()))) && (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Agsb.jdField_a_of_type_Int))
    {
      c(String.format(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131689790), new Object[] { Integer.valueOf(this.jdField_a_of_type_Agsb.jdField_a_of_type_Int) }));
      return;
    }
    super.a(paramView);
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setOnClickListener(new aguu(this));
  }
  
  protected void d()
  {
    super.d();
    String str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131717102);
    int i = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size();
    str = str + " " + i + "/" + this.jdField_a_of_type_Agsb.jdField_a_of_type_Int;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setText(str);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setEnabled(true);
    if (d())
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setBackgroundResource(2130848697);
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setBackgroundResource(2130837669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agut
 * JD-Core Version:    0.7.0.1
 */