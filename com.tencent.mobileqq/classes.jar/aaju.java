import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaju
  implements View.OnClickListener
{
  aaju(aajt paramaajt, agrp paramagrp) {}
  
  public void onClick(View paramView)
  {
    aajt.a(this.jdField_a_of_type_Aajt).removeCallbacks(aajt.a(this.jdField_a_of_type_Aajt));
    aajt.a(this.jdField_a_of_type_Aajt, true);
    aajt.a(this.jdField_a_of_type_Aajt, this.jdField_a_of_type_Agrp, this.jdField_a_of_type_Agrp.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaju
 * JD-Core Version:    0.7.0.1
 */