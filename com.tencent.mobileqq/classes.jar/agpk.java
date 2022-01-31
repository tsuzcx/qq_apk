import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class agpk
  implements View.OnClickListener
{
  agpk(agpi paramagpi, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((agpi.a(this.jdField_a_of_type_Agpi) != null) && (agpi.a(this.jdField_a_of_type_Agpi).isShowing())) {
      agpi.a(this.jdField_a_of_type_Agpi).dismiss();
    }
    if ((this.jdField_a_of_type_Agpi.a != null) && (this.jdField_a_of_type_Agpi.a.isShowing()))
    {
      this.jdField_a_of_type_Agpi.a.dismiss();
      this.jdField_a_of_type_Agpi.a = null;
    }
    agpi.a(this.jdField_a_of_type_Agpi, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpk
 * JD-Core Version:    0.7.0.1
 */