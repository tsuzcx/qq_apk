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

public class ajnt
  extends Dialog
  implements View.OnClickListener
{
  ajnu jdField_a_of_type_Ajnu;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public ajnt(@NonNull Context paramContext)
  {
    super(paramContext, 2131755933);
    paramContext = getLayoutInflater().inflate(2131562632, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!bdje.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131373276);
      float f = (int)getContext().getResources().getDimension(2131297957);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!bdje.a(this.b)) {
      ((TextView)findViewById(2131373278)).setText(this.b);
    }
    int i;
    if (!bdje.a(this.c))
    {
      ((TextView)findViewById(2131373280)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131373279);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!bdje.a(this.d)) {
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
    Object localObject = (ImageView)findViewById(2131364335);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(ajnu paramajnu)
  {
    this.jdField_a_of_type_Ajnu = paramajnu;
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
    if ((this.jdField_a_of_type_Ajnu == null) || (paramView == null)) {}
    do
    {
      return;
      if (paramView.getId() == 2131373279)
      {
        this.jdField_a_of_type_Ajnu.a();
        return;
      }
    } while (paramView.getId() != 2131364335);
    this.jdField_a_of_type_Ajnu.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnt
 * JD-Core Version:    0.7.0.1
 */