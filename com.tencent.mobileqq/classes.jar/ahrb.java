import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class ahrb
  implements bkqk
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<ahrc<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public ahrb(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    a();
  }
  
  private void a()
  {
    a(new ahrh(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new ahri(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new ahqt(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new ahqs(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new ahrd(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    a(new ahrj(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      a(new ahrm(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
    }
  }
  
  private void a(ahrc<? extends View> paramahrc)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramahrc.a(), paramahrc);
  }
  
  public View a(int paramInt)
  {
    ahrc localahrc = (ahrc)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahrc != null) {
      return localahrc.a(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((ahrc)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    ahrc localahrc = (ahrc)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahrc != null) {
      return localahrc.a();
    }
    return false;
  }
  
  public <T extends View> T b(int paramInt)
  {
    ahrc localahrc = (ahrc)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localahrc != null) {
      return localahrc.a();
    }
    return null;
  }
  
  public void s()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((ahrc)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i))).a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrb
 * JD-Core Version:    0.7.0.1
 */