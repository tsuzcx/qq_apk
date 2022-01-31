import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;

final class aajn
  extends FrameLayout
  implements aajj
{
  aajj a;
  
  public aajn(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      aanp.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    setBackgroundResource(2130839780);
    int k = -2147483648;
    int m = -2147483648;
    int i;
    int j;
    if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184) || (paramGdtAd.getCreativeSize() == 193) || (paramGdtAd.getCreativeSize() == 194) || (paramGdtAd.getCreativeSize() == 210))
    {
      i = k;
      j = m;
      if (paramGdtAd.getImageData() != null)
      {
        i = paramGdtAd.getImageData().jdField_a_of_type_Int;
        j = paramGdtAd.getImageData().b;
      }
      if ((i > 0) && (j > 0)) {
        break label248;
      }
      aanp.d("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
    }
    for (;;)
    {
      paramContext = new ImageView(getContext());
      paramContext.setImageResource(2130839781);
      addView(paramContext, -1, -1);
      return;
      i = k;
      j = m;
      if (paramGdtAd.getCreativeSize() != 285) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(0) == null) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(1) == null) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(2) == null) {
        break;
      }
      i = paramGdtAd.getImageData(0).jdField_a_of_type_Int;
      j = paramGdtAd.getImageData(0).b;
      break;
      label248:
      if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184) || (paramGdtAd.getCreativeSize() == 210)) {
        this.a = new aajq(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());
      }
      for (;;)
      {
        addView(this.a.a());
        break;
        if (paramGdtAd.getCreativeSize() == 193)
        {
          this.a = new aajp(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j);
        }
        else if (paramGdtAd.getCreativeSize() == 194)
        {
          this.a = new aajr(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText(), paramGdtAd.getDescription());
        }
        else
        {
          if (paramGdtAd.getCreativeSize() != 285) {
            break label453;
          }
          this.a = new aajs(paramContext, paramGdtAd.getImageData(0).jdField_a_of_type_JavaLangString, paramGdtAd.getImageData(1).jdField_a_of_type_JavaLangString, paramGdtAd.getImageData(2).jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());
        }
      }
      label453:
      aanp.d("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (this.a.a() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      aanp.d("GdtBannerViewWithLetterStyle", "setSize error");
      return;
    }
    int i = Double.valueOf(0.7076023391812866D * paramInt1).intValue();
    int j = Double.valueOf(0.9036144578313253D * paramInt2).intValue();
    paramInt1 = Double.valueOf((paramInt1 - i) * 1.0D / 2.0D).intValue();
    paramInt2 = Double.valueOf((paramInt2 - j) * 1.0D / 2.0D).intValue();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.bottomMargin = paramInt2;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
    this.a.a().setLayoutParams(localLayoutParams);
    this.a.a(i, j);
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramContext);
  }
  
  public void b(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramContext);
  }
  
  public void c(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.c(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajn
 * JD-Core Version:    0.7.0.1
 */