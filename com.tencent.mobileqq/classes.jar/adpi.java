import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;

public class adpi
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public ImageView a;
  OnHolderItemClickListener a;
  public ImageView b;
  public ImageView c;
  
  public adpi(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375444));
    this.b = ((ImageView)paramView.findViewById(2131375446));
    this.c = ((ImageView)paramView.findViewById(2131375445));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375447);
    paramView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener.a(paramView, getPosition(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpi
 * JD-Core Version:    0.7.0.1
 */