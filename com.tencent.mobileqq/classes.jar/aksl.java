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

public class aksl
  extends Dialog
  implements baxl
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = ajyc.a(2131706950);
  private static String c = ajyc.a(2131706947);
  private alxg jdField_a_of_type_Alxg;
  private alxk jdField_a_of_type_Alxk;
  private Context jdField_a_of_type_AndroidContentContext;
  private baxk jdField_a_of_type_Baxk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public aksl(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
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
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    if (this.jdField_a_of_type_Alxg != null)
    {
      this.jdField_a_of_type_Alxg.b(this.jdField_a_of_type_Alxk);
      this.jdField_a_of_type_Alxg.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558915);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365140));
    paramBundle = (TextView)findViewById(2131365151);
    TextView localTextView = (TextView)findViewById(2131365119);
    Button localButton = (Button)findViewById(2131365116);
    ImageView localImageView = (ImageView)findViewById(2131364269);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Baxk.a(this);
      localBitmap = this.jdField_a_of_type_Baxk.a(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Baxk.a()) {
          this.jdField_a_of_type_Baxk.a(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bbdr.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(ajyc.a(2131706949));
      localButton.setOnClickListener(new aksn(this));
      localImageView.setOnClickListener(new akso(this));
      localImageView.setOnTouchListener(new aksp(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Alxg.a();
      this.jdField_a_of_type_Alxk = new aksm(this);
      this.jdField_a_of_type_Alxg.a(this.jdField_a_of_type_Alxk);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Alxg.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Baxk.a())) {
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
 * Qualified Name:     aksl
 * JD-Core Version:    0.7.0.1
 */