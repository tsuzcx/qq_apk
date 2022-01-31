import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class akdz
  extends Dialog
  implements azwh
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = ajjy.a(2131641165);
  private static String c = ajjy.a(2131641162);
  private alis jdField_a_of_type_Alis;
  private aliw jdField_a_of_type_Aliw;
  private Context jdField_a_of_type_AndroidContentContext;
  private azwg jdField_a_of_type_Azwg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public akdz(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131690181);
    super.getWindow().setWindowAnimations(2131689588);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    if (this.jdField_a_of_type_Alis != null)
    {
      this.jdField_a_of_type_Alis.b(this.jdField_a_of_type_Aliw);
      this.jdField_a_of_type_Alis.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131493354);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131299572));
    paramBundle = (TextView)findViewById(2131299583);
    TextView localTextView = (TextView)findViewById(2131299551);
    Button localButton = (Button)findViewById(2131299548);
    ImageView localImageView = (ImageView)findViewById(2131298711);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Azwg.a(this);
      localBitmap = this.jdField_a_of_type_Azwg.a(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Azwg.a()) {
          this.jdField_a_of_type_Azwg.a(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bacm.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(ajjy.a(2131641164));
      localButton.setOnClickListener(new akeb(this));
      localImageView.setOnClickListener(new akec(this));
      localImageView.setOnTouchListener(new aked(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Alis = new alis(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Alis.a();
      this.jdField_a_of_type_Aliw = new akea(this);
      this.jdField_a_of_type_Alis.a(this.jdField_a_of_type_Aliw);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Alis.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Azwg.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akdz
 * JD-Core Version:    0.7.0.1
 */