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

public class aksk
  extends Dialog
  implements baxz
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = ajya.a(2131706961);
  private static String c = ajya.a(2131706958);
  private alxf jdField_a_of_type_Alxf;
  private alxj jdField_a_of_type_Alxj;
  private Context jdField_a_of_type_AndroidContentContext;
  private baxy jdField_a_of_type_Baxy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public aksk(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131755791);
    super.getWindow().setWindowAnimations(2131755124);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    if (this.jdField_a_of_type_Alxf != null)
    {
      this.jdField_a_of_type_Alxf.b(this.jdField_a_of_type_Alxj);
      this.jdField_a_of_type_Alxf.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558915);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365139));
    paramBundle = (TextView)findViewById(2131365150);
    TextView localTextView = (TextView)findViewById(2131365118);
    Button localButton = (Button)findViewById(2131365115);
    ImageView localImageView = (ImageView)findViewById(2131364268);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Baxy.a(this);
      localBitmap = this.jdField_a_of_type_Baxy.a(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Baxy.a()) {
          this.jdField_a_of_type_Baxy.a(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bbef.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(ajya.a(2131706960));
      localButton.setOnClickListener(new aksm(this));
      localImageView.setOnClickListener(new aksn(this));
      localImageView.setOnTouchListener(new akso(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Alxf = new alxf(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Alxf.a();
      this.jdField_a_of_type_Alxj = new aksl(this);
      this.jdField_a_of_type_Alxf.a(this.jdField_a_of_type_Alxj);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Alxf.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Baxy.a())) {
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
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */