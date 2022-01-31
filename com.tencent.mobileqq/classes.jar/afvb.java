import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.binhai.BinHaiConstants;
import com.tencent.mobileqq.binhai.BinHaiFuDaiProgressView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.qphone.base.util.QLog;

public class afvb
  implements Runnable
{
  public afvb(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    Object localObject1 = new int[3];
    Object tmp7_5 = localObject1;
    tmp7_5[0] = 2131362431;
    Object tmp12_7 = tmp7_5;
    tmp12_7[1] = 2131362433;
    Object tmp17_12 = tmp12_7;
    tmp17_12[2] = 2131362434;
    tmp17_12;
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(localObject1[i]);
      if (localObject2 != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject2);
      }
      i += 1;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    l = ScanTorchActivity.c(this.a) - l;
    if (l < 1000L)
    {
      QLog.i("ScanTorchActivity", 1, "startBinHaiFuDaiTimeDown diff <1000, diff=" + l);
      return;
    }
    ScanTorchActivity.a(this.a, new BinHaiFuDaiProgressView(this.a));
    localObject1 = ScanTorchActivity.b(this.a);
    localObject1 = ((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + ((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
    ScanTorchActivity.a(this.a).setBitmap(BinHaiConstants.a(this.a.getResources(), (String)localObject1));
    ScanTorchActivity.a(this.a).setBackgroundDrawable(new BitmapDrawable(ScanTorchActivity.a(this.a, "res/fudai/progress/loadingbar.png", false)));
    ScanTorchActivity.a(this.a).setId(2131362433);
    localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(44.0F, this.a.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(12.0F, this.a.getResources());
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(48.0F, this.a.getResources());
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(84.0F, this.a.getResources());
    Object localObject3 = new StrokeTextView(this.a);
    ((StrokeTextView)localObject3).setTextSize(1, 18.0F);
    ((StrokeTextView)localObject3).setGravity(17);
    ((StrokeTextView)localObject3).setInnerTextColor(-1);
    ((StrokeTextView)localObject3).setStrokeColor(-37823);
    ((StrokeTextView)localObject3).setTextBold(true);
    ((StrokeTextView)localObject3).setStrokeSize(AIOUtils.a(2.5F, this.a.getResources()));
    ((StrokeTextView)localObject3).setStrokeEnable(true);
    ((StrokeTextView)localObject3).setText("红包雨还需要等待");
    ((StrokeTextView)localObject3).setIncludeFontPadding(false);
    ((StrokeTextView)localObject3).setPadding(AIOUtils.a(5.0F, this.a.getResources()), AIOUtils.a(2.0F, this.a.getResources()), AIOUtils.a(5.0F, this.a.getResources()), AIOUtils.a(2.0F, this.a.getResources()));
    Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
    ScanTorchActivity.a(this.a, new StrokeTextView(this.a));
    ScanTorchActivity.a(this.a).setId(2131362432);
    ScanTorchActivity.a(this.a).setTextSize(1, 18.0F);
    ScanTorchActivity.a(this.a).setGravity(17);
    ScanTorchActivity.a(this.a).setTextBold(true);
    ScanTorchActivity.a(this.a).setInnerTextColor(-1);
    ScanTorchActivity.a(this.a).setStrokeColor(-37823);
    ScanTorchActivity.a(this.a).setStrokeSize(AIOUtils.a(2.5F, this.a.getResources()));
    ScanTorchActivity.a(this.a).setStrokeEnable(true);
    ScanTorchActivity.a(this.a).setIncludeFontPadding(false);
    ScanTorchActivity.a(this.a).setPadding(AIOUtils.a(5.0F, this.a.getResources()), AIOUtils.a(2.0F, this.a.getResources()), AIOUtils.a(5.0F, this.a.getResources()), AIOUtils.a(2.0F, this.a.getResources()));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    Object localObject2 = new LinearLayout(this.a);
    ((LinearLayout)localObject2).setId(2131362431);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(17);
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject2).addView(ScanTorchActivity.a(this.a), localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14);
    ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131362433);
    ScanTorchActivity.a(this.a, new ImageView(this.a));
    ScanTorchActivity.b(this.a).setId(2131362434);
    ScanTorchActivity.b(this.a).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ScanTorchActivity.b(this.a).setImageBitmap(ScanTorchActivity.a(this.a, "res/fudai/progress/loadingbar_hongbao.png", false));
    localObject4 = new RelativeLayout.LayoutParams(AIOUtils.a(60.0F, this.a.getResources()), AIOUtils.a(60.0F, this.a.getResources()));
    ((RelativeLayout.LayoutParams)localObject4).addRule(12);
    ((RelativeLayout.LayoutParams)localObject4).addRule(11);
    ((RelativeLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.a(80.0F, this.a.getResources());
    ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(8.0F, this.a.getResources());
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(ScanTorchActivity.a(this.a), (ViewGroup.LayoutParams)localObject1);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(ScanTorchActivity.b(this.a), (ViewGroup.LayoutParams)localObject4);
    localObject1 = BinHaiConstants.a(l);
    ScanTorchActivity.a(this.a).setText((CharSequence)localObject1);
    if ((ScanTorchActivity.d(this.a) > 0L) && (l >= 0L)) {
      ScanTorchActivity.a(this.a).a(ScanTorchActivity.d(this.a) - l, ScanTorchActivity.d(this.a));
    }
    localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject1).setRepeatMode(2);
    ((ScaleAnimation)localObject1).setRepeatCount(-1);
    ((ScaleAnimation)localObject1).setDuration(300L);
    ScanTorchActivity.b(this.a).startAnimation((Animation)localObject1);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(343);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(343, 66L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvb
 * JD-Core Version:    0.7.0.1
 */