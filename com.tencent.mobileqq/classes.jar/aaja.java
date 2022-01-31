import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.adbox.GdtAdBoxDialogCompact.1;
import java.util.List;

public class aaja
  extends aaiu
{
  private final boolean a;
  
  public aaja(@NonNull Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      aanp.a("GdtAdBoxDialog", "landscape");
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368914);
        Object localObject = localImageView.getLayoutParams();
        if ((localObject instanceof FrameLayout.LayoutParams))
        {
          localObject = (FrameLayout.LayoutParams)localObject;
          ((FrameLayout.LayoutParams)localObject).width = aapa.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          ((FrameLayout.LayoutParams)localObject).height = aapa.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localImageView = (ImageView)findViewById(2131379423);
        int i = aapa.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localImageView.setPadding(i, i, i, i);
      }
      return;
    }
    super.a();
    aanp.a("GdtAdBoxDialog", "portrait");
  }
  
  protected void a(aajc paramaajc)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      aanp.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramaajc + "]");
      i = this.jdField_a_of_type_Aais.a().getAds().size();
      if (i == 0)
      {
        aanp.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
        this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialogCompact.1(this));
        return;
      }
      if (i <= 9) {
        break label399;
      }
      i = 9;
    }
    label399:
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = aapa.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = aapa.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = aapa.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = aapa.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = aapa.a(55.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + aapa.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = aapa.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramaajc = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramaajc.inflate(2131559141, null);
          super.a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramaajc = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramaajc.width = (3 * (i4 + i6) + n + i2);
      paramaajc.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramaajc);
      return;
      super.a(paramaajc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaja
 * JD-Core Version:    0.7.0.1
 */