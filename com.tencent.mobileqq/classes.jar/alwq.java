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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class alwq
  extends ReportDialog
  implements View.OnClickListener
{
  alwr jdField_a_of_type_Alwr;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public alwq(@NonNull Context paramContext)
  {
    super(paramContext, 2131755955);
    paramContext = getLayoutInflater().inflate(2131562922, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!bhsr.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131374167);
      float f = (int)getContext().getResources().getDimension(2131298050);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!bhsr.a(this.b)) {
      ((TextView)findViewById(2131374169)).setText(this.b);
    }
    int i;
    if (!bhsr.a(this.c))
    {
      ((TextView)findViewById(2131374171)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131374170);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!bhsr.a(this.d)) {
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
    Object localObject = (ImageView)findViewById(2131364593);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(alwr paramalwr)
  {
    this.jdField_a_of_type_Alwr = paramalwr;
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
    if ((this.jdField_a_of_type_Alwr == null) || (paramView == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131374170) {
        this.jdField_a_of_type_Alwr.a();
      } else if (paramView.getId() == 2131364593) {
        this.jdField_a_of_type_Alwr.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwq
 * JD-Core Version:    0.7.0.1
 */