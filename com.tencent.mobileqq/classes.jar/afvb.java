import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.List;

public class afvb
  extends afup
{
  private afup jdField_a_of_type_Afup;
  private afvx jdField_a_of_type_Afvx;
  private afwg jdField_a_of_type_Afwg;
  
  public afvb(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean b(Object... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVarArgs.length == 4)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetListView != null)
        {
          if (this.jdField_a_of_type_Afup == null) {
            this.jdField_a_of_type_Afup = new aqhx(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          }
          bool1 = this.jdField_a_of_type_Afup.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean c(Object... paramVarArgs)
  {
    boolean bool1 = ((Boolean)paramVarArgs[4]).booleanValue();
    if ((this.jdField_a_of_type_Afvx != null) && ((paramVarArgs[5] != null) || (bool1))) {
      this.jdField_a_of_type_Afvx.a(true);
    }
    boolean bool2 = false;
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        this.jdField_a_of_type_Afvx = new afvx(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
        bool1 = this.jdField_a_of_type_Afvx.a(paramVarArgs);
      }
    }
    return bool1;
  }
  
  private boolean d(Object... paramVarArgs)
  {
    Pair localPair = null;
    if (paramVarArgs.length == 3) {
      localPair = (Pair)paramVarArgs[2];
    }
    if ((localPair == null) || (localPair.first == null)) {
      return false;
    }
    if (((aqhj)localPair.first).a.e == 1)
    {
      if (this.jdField_a_of_type_Afwg != null) {
        this.jdField_a_of_type_Afwg.e();
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        this.jdField_a_of_type_Afwg = new afwg(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
        return this.jdField_a_of_type_Afwg.a(paramVarArgs);
      }
    }
    return false;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Afvx != null) {
      this.jdField_a_of_type_Afvx.a();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Afwg != null) {
      this.jdField_a_of_type_Afwg.a(paramInt);
    }
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a(paramInt);
    }
    if (this.jdField_a_of_type_Afvx != null) {
      this.jdField_a_of_type_Afvx.a(paramInt);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_Afup != null) {}
    for (boolean bool2 = this.jdField_a_of_type_Afup.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);; bool2 = false)
    {
      if (this.jdField_a_of_type_Afwg != null) {
        if ((!this.jdField_a_of_type_Afwg.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {}
      }
      for (bool1 = true;; bool1 = bool2)
      {
        if (this.jdField_a_of_type_Afvx != null) {
          bool1 = this.jdField_a_of_type_Afvx.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        return bool1;
      }
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs.length >= 2) {}
    for (;;)
    {
      int i;
      try
      {
        long l = ((Long)paramVarArgs[1]).longValue();
        if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() != null) && (l > 0L))
        {
          ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
          i = localListAdapter.getCount() - 1;
          if (i < 0) {
            break label243;
          }
          Object localObject1 = localListAdapter.getItem(i);
          if ((localObject1 instanceof ChatMessage))
          {
            localObject1 = (ChatMessage)localObject1;
            if (((ChatMessage)localObject1).uniseq == l)
            {
              if (localObject1 == null) {
                break label162;
              }
              localObject1 = EmojiStickerManager.a().a((MessageRecord)localObject1);
              if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
                break label162;
              }
              if (QLog.isColorLevel()) {
                QLog.i("BubbleAnimation", 2, "contain sticker, so stop bubble animation!");
              }
              return false;
            }
          }
          i -= 1;
          continue;
        }
        i = ((Integer)paramVarArgs[0]).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("BubbleAnimation", 1, "", localException);
      }
      label162:
      boolean bool;
      if ((i == 0) || (i == 1) || (i == 6)) {
        bool = d(paramVarArgs);
      }
      for (;;)
      {
        return bool;
        if ((i == 5) || (i == 3) || (i == 2)) {
          bool = b(paramVarArgs);
        } else if (i == 4) {
          bool = c(paramVarArgs);
        } else {
          bool = false;
        }
      }
      label243:
      Object localObject2 = null;
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Afvx != null) {
      this.jdField_a_of_type_Afvx.b();
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Afwg != null) {
      this.jdField_a_of_type_Afwg.e();
    }
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.c();
    }
    if (this.jdField_a_of_type_Afvx != null) {
      this.jdField_a_of_type_Afvx.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvb
 * JD-Core Version:    0.7.0.1
 */