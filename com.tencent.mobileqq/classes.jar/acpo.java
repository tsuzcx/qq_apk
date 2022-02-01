import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class acpo
  extends LinearLayout
{
  private acxm jdField_a_of_type_Acxm;
  private acxo jdField_a_of_type_Acxo = new acpp(this);
  
  public acpo(Context paramContext, String paramString)
  {
    super(paramContext);
    setGravity(17);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setStroke(1, Color.parseColor("#EFEFEF"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      acvc.d("GdtBannerImageView", "constructor");
      return;
    }
    paramContext = new URLImageView(paramContext);
    addView(paramContext);
    this.jdField_a_of_type_Acxm = new acxm(paramString, new WeakReference(this.jdField_a_of_type_Acxo));
    this.jdField_a_of_type_Acxm.a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Acxm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpo
 * JD-Core Version:    0.7.0.1
 */