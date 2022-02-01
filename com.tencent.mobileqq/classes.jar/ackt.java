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
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.adbox.GdtAdBoxDialog.3;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class ackt
  extends ReportDialog
  implements acld
{
  protected ackr a;
  protected aclb a;
  protected aclc a;
  private final acnt a;
  protected Activity a;
  protected View a;
  protected GridLayout a;
  
  public ackt(@NonNull Context paramContext)
  {
    super(paramContext, 2131755823);
    this.jdField_a_of_type_Acnt = new acnt();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aclb = new aclb();
    this.jdField_a_of_type_Aclc = new aclc(this, this.jdField_a_of_type_Aclb);
    this.jdField_a_of_type_Aclc.a();
  }
  
  private void c()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559219, (ViewGroup)localObject, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener(new acku(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131367532));
    a();
    localObject = findViewById(2131380410);
    ((View)localObject).setOnClickListener(new ackv(this));
    ((View)localObject).setContentDescription(anni.a(2131690728));
    setCanceledOnTouchOutside(false);
  }
  
  public acnu a(View paramView)
  {
    try
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      paramView = new acnu(paramView.getWidth(), paramView.getHeight(), arrayOfInt[0], arrayOfInt[1]);
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
    Object localObject1 = this.jdField_a_of_type_Ackr.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131368138);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    acqy.a("GdtAdBoxDialog", "bindView() i = [" + paramInt7 + "], j = [" + paramInt8 + "], url = [" + (String)localObject2 + "]");
    try
    {
      localImageView.setImageDrawable(MiniAppUtils.getIcon(localImageView.getContext(), (String)localObject2, true, 2130841127, 65));
      localObject2 = (TextView)paramLinearLayout.findViewById(2131371539);
      String str = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
      ((TextView)localObject2).setText(str);
      localImageView.setContentDescription(str);
      ((TextView)localObject2).setContentDescription(str);
      this.jdField_a_of_type_Acnt.a(localImageView);
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
      localImageView.setOnClickListener(new ackw(this));
      localImageView.setTag(2131367365, localObject1);
      localImageView.setTag(2131380927, localObject1);
      localImageView.setTag(2131380926, new ackx(this, localImageView));
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new acky(this, localImageView));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        acqy.d("GdtAdBoxDialog", "bad url params", localException);
      }
    }
  }
  
  public void a(ackr paramackr)
  {
    this.jdField_a_of_type_Ackr = paramackr;
  }
  
  protected void a(aclb paramaclb)
  {
    acqy.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramaclb + "]");
    int i = this.jdField_a_of_type_Ackr.a().getAds().size();
    if (i == 0)
    {
      acqy.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
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
      int n = acsj.a(23.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = acsj.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = acsj.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = acsj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = acsj.a(65.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + acsj.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = acsj.a(22.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramaclb = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
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
          LinearLayout localLinearLayout = (LinearLayout)paramaclb.inflate(2131559212, null);
          a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramaclb = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramaclb.width = (3 * (i4 + i6) + n + i2);
      paramaclb.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramaclb);
      return;
    }
  }
  
  public void b(aclb paramaclb)
  {
    a(paramaclb);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Aclc.a()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    b();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Aclc.b();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Aclc.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    acqy.a("GdtAdBoxDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackt
 * JD-Core Version:    0.7.0.1
 */