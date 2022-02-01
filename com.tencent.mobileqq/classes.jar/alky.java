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

public class alky
  extends ReportDialog
  implements View.OnClickListener
{
  alkz jdField_a_of_type_Alkz;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public alky(@NonNull Context paramContext)
  {
    super(paramContext, 2131755954);
    paramContext = getLayoutInflater().inflate(2131562888, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!bgsp.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131374028);
      float f = (int)getContext().getResources().getDimension(2131298038);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!bgsp.a(this.b)) {
      ((TextView)findViewById(2131374030)).setText(this.b);
    }
    int i;
    if (!bgsp.a(this.c))
    {
      ((TextView)findViewById(2131374032)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131374031);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!bgsp.a(this.d)) {
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
    Object localObject = (ImageView)findViewById(2131364548);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(alkz paramalkz)
  {
    this.jdField_a_of_type_Alkz = paramalkz;
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
    if ((this.jdField_a_of_type_Alkz == null) || (paramView == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131374031) {
        this.jdField_a_of_type_Alkz.a();
      } else if (paramView.getId() == 2131364548) {
        this.jdField_a_of_type_Alkz.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alky
 * JD-Core Version:    0.7.0.1
 */