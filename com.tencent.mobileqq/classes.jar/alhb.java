import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoListLogicArk.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import mqq.util.WeakReference;

public class alhb
  extends aggm
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private alhb(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new alhb(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.b);
    localIntent.putExtra("enter_from", 3);
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.b = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  protected void a(View paramView)
  {
    algw.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    super.a(paramView);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    paramIntent.putExtra("enter_from", 3);
    super.b(paramIntent);
  }
  
  protected void c()
  {
    super.c();
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localNewPhotoListActivity != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListLogicArk", 2, "ArkApp ark app res:" + this.jdField_a_of_type_JavaLangString);
      }
      localNewPhotoListActivity.findViewById(2131306214).setVisibility(4);
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  protected void d(View paramView)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setClickable(false);
    if (!this.jdField_a_of_type_Aggf.a.isEmpty()) {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggf.a.get(this.jdField_a_of_type_Aggf.a.size() - 1));
    }
    baaf.a();
    if (this.jdField_a_of_type_Aggf.a.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Aggf.a.iterator();
      for (long l = 0L; paramView.hasNext(); l = bace.a((String)paramView.next()) + l) {}
      if (apck.a())
      {
        apbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131627035, 2131627040, new alhc(this));
        return;
      }
    }
    if (this.jdField_a_of_type_Aggf.a.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(this.jdField_a_of_type_Aggf.a.size() * 128);
        int i = 0;
        while (i < this.jdField_a_of_type_Aggf.a.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_Aggf.a.get(i) }));
          i += 1;
        }
        QLog.d("PhotoListLogicArk", 2, paramView.toString());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
      ThreadManagerV2.executeOnSubThread(new PhotoListLogicArk.2(this));
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      return;
      algw.a().a("callbackArk", null, null);
    }
  }
  
  protected void g()
  {
    algw.a().a("callbackArk", null, null);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alhb
 * JD-Core Version:    0.7.0.1
 */