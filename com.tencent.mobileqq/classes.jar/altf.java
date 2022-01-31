import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.List;

class altf
  implements View.OnClickListener
{
  alte jdField_a_of_type_Alte;
  alti jdField_a_of_type_Alti;
  
  altf(alte paramalte, alti paramalti)
  {
    this.jdField_a_of_type_Alte = paramalte;
    this.jdField_a_of_type_Alti = paramalti;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Alti.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)alte.a(this.jdField_a_of_type_Alte).get(i);
    alrz.b(localColorNote.mServiceType, localColorNote.mSubType);
    alte.a(this.jdField_a_of_type_Alte).remove(i);
    this.jdField_a_of_type_Alte.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (alsr.b(localColorNote))
      {
        if ((alsq.a().a()) && (alsb.b())) {
          alte.a(this.jdField_a_of_type_Alte).a(paramView);
        }
        awqx.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Alte.getItemCount() == 0) && (alte.a(this.jdField_a_of_type_Alte) != null)) {
        alte.a(this.jdField_a_of_type_Alte).a();
      }
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      awqx.b(null, "dc00898", "", "", "0X800A747", "0X800A747", alru.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altf
 * JD-Core Version:    0.7.0.1
 */