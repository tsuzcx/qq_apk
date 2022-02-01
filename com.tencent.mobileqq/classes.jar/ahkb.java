import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ahkb
  implements View.OnClickListener
{
  ahkb(ahjx paramahjx, azzl paramazzl, ahjz paramahjz) {}
  
  public final void onClick(View paramView)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = (int)this.jdField_a_of_type_Azzl.e;
      Object localObject = this.jdField_a_of_type_Azzl;
      long l;
      if (this.jdField_a_of_type_Azzl.jdField_b_of_type_Boolean)
      {
        l = i - 1;
        label114:
        ((azzl)localObject).e = l;
        azzu.a(this.jdField_a_of_type_Ahjx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azzl);
        localObject = this.jdField_a_of_type_Azzl;
        if (this.jdField_a_of_type_Azzl.jdField_b_of_type_Boolean) {
          break label321;
        }
      }
      label321:
      for (boolean bool = true;; bool = false)
      {
        ((azzl)localObject).jdField_b_of_type_Boolean = bool;
        if (ahjx.a(this.jdField_a_of_type_Ahjx, ahjx.a(this.jdField_a_of_type_Ahjx)))
        {
          ahjx.a(this.jdField_a_of_type_Ahjx).b(this.jdField_a_of_type_Azzl.jdField_b_of_type_Boolean);
          ahjx.a(this.jdField_a_of_type_Ahjx).a(this.jdField_a_of_type_Azzl.e);
        }
        localObject = this.jdField_a_of_type_Ahjx;
        bool = this.jdField_a_of_type_Azzl.jdField_b_of_type_Boolean;
        TextView localTextView = this.jdField_a_of_type_Ahjz.d();
        if (localTextView == null) {
          Intrinsics.throwNpe();
        }
        ImageView localImageView = this.jdField_a_of_type_Ahjz.i();
        if (localImageView == null) {
          Intrinsics.throwNpe();
        }
        ahjx.a((ahjx)localObject, bool, localTextView, localImageView, this.jdField_a_of_type_Azzl.e);
        bdla.b(null, "dc00898", "", ahjx.a(this.jdField_a_of_type_Ahjx).a(), "0X800B5C2", "0X800B5C2", 0, 0, "", "", "", "");
        break;
        l = i + 1L;
        break label114;
      }
      azsy.a(paramView);
      localObject = this.jdField_a_of_type_Ahjx.jdField_a_of_type_AndroidContentContext;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      azzu.a((BaseActivity)localObject, this.jdField_a_of_type_Ahjz.a(), this.jdField_a_of_type_Azzl.a, "", 11, this.jdField_a_of_type_Azzl.jdField_b_of_type_Long);
      bdla.b(null, "dc00898", "", ahjx.a(this.jdField_a_of_type_Ahjx).a(), "0X800B5C3", "0X800B5C3", 0, 0, "", "", "", "");
      continue;
      azsy.a(paramView);
      localObject = this.jdField_a_of_type_Ahjx.jdField_a_of_type_AndroidContentContext;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      azzu.a((BaseActivity)localObject, this.jdField_a_of_type_Ahjz.a(), 10);
      bdla.b(null, "dc00898", "", ahjx.a(this.jdField_a_of_type_Ahjx).a(), "0X800B5C1", "0X800B5C1", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */