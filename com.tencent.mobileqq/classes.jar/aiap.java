import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class aiap
  implements blrn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<aiaq<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public aiap(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public View a(int paramInt)
  {
    aiaq localaiaq = (aiaq)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localaiaq != null) {
      return localaiaq.a(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public void a()
  {
    a(new aiav(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new aiaw(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new aiah(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new aiag(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new aiar(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new aiax(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aimd))) {
      a(new aiba(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((aiaq)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  void a(aiaq<? extends View> paramaiaq)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramaiaq.a(), paramaiaq);
  }
  
  public boolean a(int paramInt)
  {
    aiaq localaiaq = (aiaq)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localaiaq != null) {
      return localaiaq.a();
    }
    return false;
  }
  
  public <T extends View> T b(int paramInt)
  {
    aiaq localaiaq = (aiaq)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localaiaq != null) {
      return localaiaq.a();
    }
    return null;
  }
  
  public void s()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((aiaq)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiap
 * JD-Core Version:    0.7.0.1
 */