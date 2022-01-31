import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class ahjt
  extends Dialog
  implements View.OnClickListener
{
  ahju jdField_a_of_type_Ahju;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public ahjt(@NonNull Context paramContext)
  {
    super(paramContext, 2131690305);
    paramContext = getLayoutInflater().inflate(2131496829, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!baip.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131307124);
      float f = (int)getContext().getResources().getDimension(2131166846);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!baip.a(this.b)) {
      ((TextView)findViewById(2131307126)).setText(this.b);
    }
    int i;
    if (!baip.a(this.c))
    {
      ((TextView)findViewById(2131307128)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131307127);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!baip.a(this.d)) {
        i = Color.parseColor("#57d4d9");
      }
    }
    try
    {
      int j = Color.parseColor(this.d);
      i = j;
    }
    catch (Exception localException)
    {
      label190:
      break label190;
    }
    ((GradientDrawable)((RelativeLayout)localObject).getBackground()).setColor(i);
    Object localObject = (ImageView)findViewById(2131298711);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(ahju paramahju)
  {
    this.jdField_a_of_type_Ahju = paramahju;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.d = paramString4;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Ahju == null) || (paramView == null)) {}
    do
    {
      return;
      if (paramView.getId() == 2131307127)
      {
        this.jdField_a_of_type_Ahju.a();
        return;
      }
    } while (paramView.getId() != 2131298711);
    this.jdField_a_of_type_Ahju.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahjt
 * JD-Core Version:    0.7.0.1
 */