import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class alti
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  alsg jdField_a_of_type_Alsg;
  alte jdField_a_of_type_Alte;
  altf jdField_a_of_type_Altf;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public View b;
  public TextView b;
  
  public alti(alte paramalte, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Alte = paramalte;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131305254);
    azve.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131305255);
    azve.a(localView2, false);
    localView2.setOnClickListener(this);
    if (alte.a(paramalte))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!alte.a(paramalte)) {
        break label329;
      }
    }
    label329:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131305247);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131625299));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131305244);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305248));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305258));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      azve.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305256));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      azve.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131305249));
      this.jdField_a_of_type_Altf = new altf(paramalte, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Altf);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new altg(paramalte, this));
      this.jdField_a_of_type_Alsg = new alsg();
      this.jdField_a_of_type_Alsg.a(paramView.getContext(), aciy.a(15.0F, localResources), aciy.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)alte.a(this.jdField_a_of_type_Alte).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (alte.a(this.jdField_a_of_type_Alte) == null);
    alte.a(this.jdField_a_of_type_Alte).a();
    awqx.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alti
 * JD-Core Version:    0.7.0.1
 */