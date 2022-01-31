import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.flashchat.FlashChatPanel.PluginData;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;

public class adjy
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public FlashChatItem a;
  public FlashChatPanel.PluginData a;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  public int b;
  public ImageView b;
  int c;
  public ImageView c;
  public ImageView d;
  
  public adjy(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363702));
    this.b = ((ImageView)paramView.findViewById(2131363701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362961));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362745));
    this.d = ((ImageView)paramView.findViewById(2131370106));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnLongClickListener(this);
    this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener.a(paramView, getPosition(), this.jdField_c_of_type_Int);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener.b(paramView, getPosition(), this.jdField_c_of_type_Int);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjy
 * JD-Core Version:    0.7.0.1
 */