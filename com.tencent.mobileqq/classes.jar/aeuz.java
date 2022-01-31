import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.List;

public class aeuz
  extends aeun
{
  private aeun jdField_a_of_type_Aeun;
  private aevn jdField_a_of_type_Aevn;
  private aevw jdField_a_of_type_Aevw;
  
  public aeuz(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
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
          if (this.jdField_a_of_type_Aeun == null) {
            this.jdField_a_of_type_Aeun = new anxd(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          }
          bool1 = this.jdField_a_of_type_Aeun.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean c(Object... paramVarArgs)
  {
    boolean bool1 = ((Boolean)paramVarArgs[4]).booleanValue();
    if ((this.jdField_a_of_type_Aevn != null) && ((paramVarArgs[5] != null) || (bool1))) {
      this.jdField_a_of_type_Aevn.a(true);
    }
    boolean bool2 = false;
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        this.jdField_a_of_type_Aevn = new aevn(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
        bool1 = this.jdField_a_of_type_Aevn.a(paramVarArgs);
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
    if (((anwp)localPair.first).a.e == 1)
    {
      if (this.jdField_a_of_type_Aevw != null) {
        this.jdField_a_of_type_Aevw.e();
      }
      this.jdField_a_of_type_Aevw = new aevw(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
      return this.jdField_a_of_type_Aevw.a(paramVarArgs);
    }
    return false;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aevn != null) {
      this.jdField_a_of_type_Aevn.a();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aevw != null) {
      this.jdField_a_of_type_Aevw.a(paramInt);
    }
    if (this.jdField_a_of_type_Aeun != null) {
      this.jdField_a_of_type_Aeun.a(paramInt);
    }
    if (this.jdField_a_of_type_Aevn != null) {
      this.jdField_a_of_type_Aevn.a(paramInt);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_Aeun != null) {}
    for (boolean bool2 = this.jdField_a_of_type_Aeun.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);; bool2 = false)
    {
      if (this.jdField_a_of_type_Aevw != null) {
        if ((!this.jdField_a_of_type_Aevw.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {}
      }
      for (bool1 = true;; bool1 = bool2)
      {
        if (this.jdField_a_of_type_Aevn != null) {
          bool1 = this.jdField_a_of_type_Aevn.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    if (this.jdField_a_of_type_Aevn != null) {
      this.jdField_a_of_type_Aevn.b();
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aevw != null) {
      this.jdField_a_of_type_Aevw.e();
    }
    if (this.jdField_a_of_type_Aeun != null) {
      this.jdField_a_of_type_Aeun.c();
    }
    if (this.jdField_a_of_type_Aevn != null) {
      this.jdField_a_of_type_Aevn.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuz
 * JD-Core Version:    0.7.0.1
 */