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

public class ahwj
  extends Dialog
  implements View.OnClickListener
{
  ahwk jdField_a_of_type_Ahwk;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public ahwj(@NonNull Context paramContext)
  {
    super(paramContext, 2131755916);
    paramContext = getLayoutInflater().inflate(2131562428, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!bbkk.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131372838);
      float f = (int)getContext().getResources().getDimension(2131297936);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!bbkk.a(this.b)) {
      ((TextView)findViewById(2131372840)).setText(this.b);
    }
    int i;
    if (!bbkk.a(this.c))
    {
      ((TextView)findViewById(2131372842)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131372841);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!bbkk.a(this.d)) {
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
    Object localObject = (ImageView)findViewById(2131364268);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(ahwk paramahwk)
  {
    this.jdField_a_of_type_Ahwk = paramahwk;
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
    if ((this.jdField_a_of_type_Ahwk == null) || (paramView == null)) {}
    do
    {
      return;
      if (paramView.getId() == 2131372841)
      {
        this.jdField_a_of_type_Ahwk.a();
        return;
      }
    } while (paramView.getId() != 2131364268);
    this.jdField_a_of_type_Ahwk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwj
 * JD-Core Version:    0.7.0.1
 */