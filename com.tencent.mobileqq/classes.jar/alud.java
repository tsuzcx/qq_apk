import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

class alud
  extends RecyclerView.ViewHolder
{
  alsg jdField_a_of_type_Alsg;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  View b;
  
  public alud(alub paramalub, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramalub = paramView.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304926));
    this.b = paramView.findViewById(2131305259);
    this.jdField_a_of_type_Alsg = new alsg();
    this.jdField_a_of_type_Alsg.a(paramView.getContext(), aciy.a(15.0F, paramalub), aciy.a(9.5F, paramalub), paramalub.getColor(2131099873));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alud
 * JD-Core Version:    0.7.0.1
 */