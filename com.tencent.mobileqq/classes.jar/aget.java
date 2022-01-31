import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Observable;
import java.util.Observer;

public abstract class aget
  extends aeqi
  implements Observer
{
  public ViewGroup a;
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private QQAppInterface a;
  public MessageForTroopGift a;
  public BubbleImageView a;
  public ViewGroup b;
  public Button b;
  public TextView b;
  public View c;
  public ViewGroup c;
  public Button c;
  public View d;
  public Button d;
  public Button e;
  
  public aget(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (bckm)paramObject;
    if ((paramObservable.a.equals(bcoq.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading)) {
      this.d.post(new TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1(this, paramObservable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aget
 * JD-Core Version:    0.7.0.1
 */