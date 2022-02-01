import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class acry
  extends ReportDialog
{
  private acsg jdField_a_of_type_Acsg;
  private acsz jdField_a_of_type_Acsz;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private Intent b;
  
  public acry(@NonNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void a()
  {
    this.b = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_a_of_type_AndroidAppActivity.setIntent(this.jdField_a_of_type_AndroidContentIntent);
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Bundle)localObject).getSerializable("data");
    } while (!(localObject instanceof GdtMotiveVideoPageData));
    this.jdField_a_of_type_Acsg = new acsg((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Acsz = new acsz(new acrz(this), this.jdField_a_of_type_Acsg, true);
    Object localObject1 = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).layoutInDisplayCutoutMode = 1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    }
    ((Window)localObject1).setFlags(1024, 1024);
    ((Window)localObject1).setVolumeControlStream(3);
    localObject1 = (ViewGroup)((Window)localObject1).getDecorView();
    ((ViewGroup)localObject1).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener(new acsa(this, (ViewGroup)localObject1));
    }
    Object localObject2 = this.jdField_a_of_type_Acsz.a(LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity), (ViewGroup)localObject1);
    setContentView((View)localObject2);
    setOnDismissListener(new acsb(this));
    ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new acsc(this, (ViewGroup)localObject1, (View)localObject2));
    this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new acsd(this);
    this.jdField_a_of_type_AndroidAppActivity.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
    this.jdField_a_of_type_Acsz.m();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(ResultReceiver paramResultReceiver)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Acsz.c()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    b();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Acsz.k();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Acsz.j();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    acvc.a("GdtMotiveVideoDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acry
 * JD-Core Version:    0.7.0.1
 */