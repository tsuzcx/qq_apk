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

public class ajsi
  extends Dialog
  implements View.OnClickListener
{
  ajsj jdField_a_of_type_Ajsj;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public ajsi(@NonNull Context paramContext)
  {
    super(paramContext, 2131755933);
    paramContext = getLayoutInflater().inflate(2131562650, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!bdnn.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131373328);
      float f = (int)getContext().getResources().getDimension(2131297957);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!bdnn.a(this.b)) {
      ((TextView)findViewById(2131373330)).setText(this.b);
    }
    int i;
    if (!bdnn.a(this.c))
    {
      ((TextView)findViewById(2131373332)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131373331);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!bdnn.a(this.d)) {
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
    Object localObject = (ImageView)findViewById(2131364337);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(ajsj paramajsj)
  {
    this.jdField_a_of_type_Ajsj = paramajsj;
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
    if ((this.jdField_a_of_type_Ajsj == null) || (paramView == null)) {}
    do
    {
      return;
      if (paramView.getId() == 2131373331)
      {
        this.jdField_a_of_type_Ajsj.a();
        return;
      }
    } while (paramView.getId() != 2131364337);
    this.jdField_a_of_type_Ajsj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsi
 * JD-Core Version:    0.7.0.1
 */