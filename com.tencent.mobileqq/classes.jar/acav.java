import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.adbox.GdtAdBoxDialog.3;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class acav
  extends ReportDialog
  implements acbg
{
  protected acat a;
  protected acbe a;
  protected acbf a;
  private final acds jdField_a_of_type_Acds = new acds();
  protected Activity a;
  protected View a;
  protected GridLayout a;
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback;
  private final List<AdExposureChecker> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public acav(@NonNull Context paramContext)
  {
    super(paramContext, 2131755829);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private boolean a(GdtAd paramGdtAd)
  {
    boolean bool = paramGdtAd.useExposureChecker();
    QLog.i("GdtAdBoxDialog", 1, "useExposureChecker=" + bool);
    return bool;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Acbe = new acbe();
    this.jdField_a_of_type_Acbf = new acbf(this, this.jdField_a_of_type_Acbe);
    this.jdField_a_of_type_Acbf.a();
  }
  
  private void d()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559264, (ViewGroup)localObject, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener(new acaw(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131367756));
    a();
    localObject = findViewById(2131380656);
    ((View)localObject).setOnClickListener(new acax(this));
    ((View)localObject).setContentDescription(anvx.a(2131690845));
    setCanceledOnTouchOutside(false);
  }
  
  public acdt a(View paramView)
  {
    try
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      paramView = new acdt(paramView.getWidth(), paramView.getHeight(), arrayOfInt[0], arrayOfInt[1]);
      return paramView;
    }
    catch (Exception paramView)
    {
      QLog.i("GdtAdBoxDialog", 1, "gdiReportExposure", paramView);
    }
    return null;
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, LinearLayout paramLinearLayout)
  {
    Object localObject1 = this.jdField_a_of_type_Acat.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131368381);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    acho.a("GdtAdBoxDialog", "bindView() i = [" + paramInt7 + "], j = [" + paramInt8 + "], url = [" + (String)localObject2 + "]");
    try
    {
      localImageView.setImageDrawable(MiniAppUtils.getIcon(localImageView.getContext(), (String)localObject2, true, 2130841184, 65));
      localObject2 = (TextView)paramLinearLayout.findViewById(2131371803);
      String str = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
      ((TextView)localObject2).setText(str);
      localImageView.setContentDescription(str);
      ((TextView)localObject2).setContentDescription(str);
      this.jdField_a_of_type_Acds.a(localImageView);
      localObject2 = new GridLayout.LayoutParams();
      ((GridLayout.LayoutParams)localObject2).rowSpec = GridLayout.spec(paramInt7, 1, GridLayout.LEFT);
      ((GridLayout.LayoutParams)localObject2).columnSpec = GridLayout.spec(paramInt8, 1, GridLayout.TOP);
      ((GridLayout.LayoutParams)localObject2).width = paramInt4;
      ((GridLayout.LayoutParams)localObject2).rightMargin = paramInt6;
      ((GridLayout.LayoutParams)localObject2).bottomMargin = paramInt6;
      if (paramInt7 == 0) {
        ((GridLayout.LayoutParams)localObject2).topMargin = paramInt3;
      }
      if (paramInt8 % paramInt1 == 0) {
        ((GridLayout.LayoutParams)localObject2).leftMargin = paramInt2;
      }
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView.setOnClickListener(new acay(this));
      localImageView.setTag(2131367584, localObject1);
      localImageView.setTag(2131381181, localObject1);
      if (a((GdtAd)localObject1))
      {
        b();
        paramLinearLayout = new AdExposureChecker((Ad)localObject1, new WeakReference(localImageView));
        paramLinearLayout.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
        this.jdField_a_of_type_JavaUtilList.add(paramLinearLayout);
        paramLinearLayout.startCheck();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        acho.d("GdtAdBoxDialog", "bad url params", localException);
      }
      localImageView.setTag(2131381180, new acaz(this));
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new acba(this, localImageView));
    }
  }
  
  public void a(acat paramacat)
  {
    this.jdField_a_of_type_Acat = paramacat;
  }
  
  protected void a(acbe paramacbe)
  {
    acho.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramacbe + "]");
    int i = this.jdField_a_of_type_Acat.a().getAds().size();
    if (i == 0)
    {
      acho.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
      this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialog.3(this));
      return;
    }
    if (i > 9) {
      i = 9;
    }
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = aciv.a(23.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = aciv.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = aciv.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = aciv.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = aciv.a(65.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + aciv.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = aciv.a(22.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramacbe = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramacbe.inflate(2131559257, null);
          a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramacbe = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramacbe.width = (3 * (i4 + i6) + n + i2);
      paramacbe.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramacbe);
      return;
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = paramView.getTag(2131381181);
    if ((localObject != null) && ((localObject instanceof GdtAd)))
    {
      localObject = (GdtAd)localObject;
      GdtReporter.doCgiReport(this.jdField_a_of_type_Acds.b(((GdtAd)localObject).getUrlForImpression(), a(paramView)));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new acbb(this);
    }
  }
  
  public void b(acbe paramacbe)
  {
    a(paramacbe);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Acbf.a()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    c();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Acbf.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Acbf.c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    acho.a("GdtAdBoxDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acav
 * JD-Core Version:    0.7.0.1
 */