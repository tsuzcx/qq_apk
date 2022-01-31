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
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class aaiu
  extends Dialog
  implements aaje
{
  protected aais a;
  protected aajc a;
  protected aajd a;
  protected Activity a;
  protected View a;
  protected GridLayout a;
  
  public aaiu(@NonNull Context paramContext)
  {
    super(paramContext, 2131755801);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aajc = new aajc();
    this.jdField_a_of_type_Aajd = new aajd(this, this.jdField_a_of_type_Aajc);
    this.jdField_a_of_type_Aajd.a();
  }
  
  private void c()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559143, (ViewGroup)localObject, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener(new aaiv(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131367229));
    a();
    localObject = findViewById(2131379423);
    ((View)localObject).setOnClickListener(new aaiw(this));
    ((View)localObject).setContentDescription(alpo.a(2131690884));
    setCanceledOnTouchOutside(false);
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, LinearLayout paramLinearLayout)
  {
    Object localObject1 = this.jdField_a_of_type_Aais.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131367808);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    aanp.a("GdtAdBoxDialog", "bindView() i = [" + paramInt7 + "], j = [" + paramInt8 + "], url = [" + (String)localObject2 + "]");
    try
    {
      localImageView.setImageDrawable(MiniAppUtils.getIcon(localImageView.getContext(), (String)localObject2, true, 2130840897, 65));
      localObject2 = (TextView)paramLinearLayout.findViewById(2131370958);
      String str = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
      ((TextView)localObject2).setText(str);
      localImageView.setContentDescription(str);
      ((TextView)localObject2).setContentDescription(str);
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
      localImageView.setOnClickListener(new aaix(this));
      localImageView.setTag(2131367066, localObject1);
      localImageView.setTag(2131379911, localObject1);
      localImageView.setTag(2131379910, new aaiy(this));
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new aaiz(this, localImageView));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aanp.d("GdtAdBoxDialog", "bad url params", localException);
      }
    }
  }
  
  public void a(aais paramaais)
  {
    this.jdField_a_of_type_Aais = paramaais;
  }
  
  protected void a(aajc paramaajc)
  {
    aanp.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramaajc + "]");
    int i = this.jdField_a_of_type_Aais.a().getAds().size();
    if (i == 0)
    {
      aanp.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
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
      int n = aapa.a(23.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = aapa.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = aapa.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = aapa.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = aapa.a(65.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + aapa.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = aapa.a(22.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramaajc = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
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
          LinearLayout localLinearLayout = (LinearLayout)paramaajc.inflate(2131559140, null);
          a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramaajc = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramaajc.width = (3 * (i4 + i6) + n + i2);
      paramaajc.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramaajc);
      return;
    }
  }
  
  public void b(aajc paramaajc)
  {
    a(paramaajc);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Aajd.a()) {
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
    this.jdField_a_of_type_Aajd.b();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Aajd.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    aanp.a("GdtAdBoxDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiu
 * JD-Core Version:    0.7.0.1
 */