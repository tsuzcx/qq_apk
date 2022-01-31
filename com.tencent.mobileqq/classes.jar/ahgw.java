import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ahgw
  extends Dialog
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public ahgw(@NonNull Context paramContext)
  {
    super(paramContext, 2131755163);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, RelativeLayout paramRelativeLayout)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    for (;;)
    {
      return;
      int i = (int)(paramInt2 * 1.0F / paramInt1 * paramInt3);
      if (i > 0) {}
      try
      {
        ViewGroup.LayoutParams localLayoutParams = paramRelativeLayout.getLayoutParams();
        localLayoutParams.height = i;
        localLayoutParams.width = paramInt3;
        paramRelativeLayout.setLayoutParams(localLayoutParams);
        if (QLog.isColorLevel())
        {
          QLog.d("SpringHbCountDownDialog", 2, "outWidth:" + paramInt1 + ",outHeight:" + paramInt2 + ",calc height: " + i);
          return;
        }
      }
      catch (Throwable paramRelativeLayout)
      {
        QLog.e("SpringHbCountDownDialog", 1, paramRelativeLayout, new Object[0]);
      }
    }
  }
  
  public ahgw a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    if (QLog.isColorLevel()) {
      QLog.i("SpringHbCountDownDialog", 2, "init -->,mBgUrl:" + this.jdField_a_of_type_JavaLangString + ",mCurrentTime:" + this.jdField_a_of_type_Long + ",mSpecifyTime:" + this.b);
    }
    return this;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpringHbCountDownDialog", 2, "startCountDown:-->mCurrentTime:" + paramLong1 + ",mSpecifyTime" + paramLong2 + ",totalTime:" + l);
      }
      a();
      this.jdField_a_of_type_AndroidOsCountDownTimer = new ahgz(this, l, 1000L);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SpringHbCountDownDialog", 1, localThrowable, new Object[0]);
    }
  }
  
  public void dismiss()
  {
    try
    {
      a();
      super.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SpringHbCountDownDialog", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368550) {
      cancel();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    paramBundle = View.inflate(getContext(), 2131561574, null);
    setContentView(paramBundle, new ViewGroup.LayoutParams(bbll.a() - bbll.b(20.0F), -2));
    setCanceledOnTouchOutside(true);
    findViewById(2131368550).setOnClickListener(this);
    int i = bbll.a();
    int j = bbll.a(20.0F);
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130846444);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378130));
    ImageView localImageView = (ImageView)findViewById(2131368549);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131375351);
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 0;
    localDownloadParam.url = this.jdField_a_of_type_JavaLangString;
    paramBundle.setVisibility(4);
    setOnCancelListener(new ahgx(this));
    PreloadManager.a().a(localDownloadParam, new ahgy(this, localDrawable, i - j * 2, localRelativeLayout, localImageView, paramBundle));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SpringHbCountDownDialog", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgw
 * JD-Core Version:    0.7.0.1
 */