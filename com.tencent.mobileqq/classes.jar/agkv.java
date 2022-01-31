import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class agkv
  implements View.OnClickListener
{
  agkv(agkt paramagkt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((agkt.a(this.jdField_a_of_type_Agkt) != null) && (agkt.a(this.jdField_a_of_type_Agkt).isShowing())) {
      agkt.a(this.jdField_a_of_type_Agkt).dismiss();
    }
    if ((this.jdField_a_of_type_Agkt.a != null) && (this.jdField_a_of_type_Agkt.a.isShowing()))
    {
      this.jdField_a_of_type_Agkt.a.dismiss();
      this.jdField_a_of_type_Agkt.a = null;
    }
    agkt.a(this.jdField_a_of_type_Agkt, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */