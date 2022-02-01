import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.1;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.2;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.io.IOException;

public class agci
  extends agax
{
  private long jdField_a_of_type_Long;
  private afwr jdField_a_of_type_Afwr;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public apwu a;
  public VipPngPlayAnimationDrawable a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  public View b;
  public apwu b;
  public VipPngPlayAnimationDrawable b;
  public boolean b;
  public boolean c;
  
  public agci(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      return new int[] { paramInt2, paramInt1 };
    case 0: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 6: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
    {
      paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  protected void a(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.jdField_b_of_type_AndroidViewView.getBottom() > 0)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
        if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d)
        {
          paramInt = j;
          if (this.jdField_a_of_type_AndroidViewView.getBottom() > 0) {
            break label78;
          }
        }
      }
      for (paramInt = 1;; paramInt = i)
      {
        label78:
        if ((paramInt != 0) && (this.jdField_b_of_type_Int != 0)) {
          this.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.2(this));
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean1) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = paramBoolean1;
      } while (this.jdField_a_of_type_Afwr == null);
      localDrawable = this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView.getBackground();
    } while (!(localDrawable instanceof apym));
    apxz localapxz;
    if (this.jdField_a_of_type_Afwr.jdField_a_of_type_Apwt != null)
    {
      localapxz = this.jdField_a_of_type_Afwr.jdField_a_of_type_Apwt.a;
      label62:
      if ((localapxz != null) && (((this.jdField_a_of_type_Apwu != null) && (this.jdField_a_of_type_Apwu.jdField_a_of_type_Apwn.jdField_b_of_type_Boolean)) || ((this.jdField_b_of_type_Apwu != null) && (this.jdField_b_of_type_Apwu.jdField_a_of_type_Apwn.jdField_b_of_type_Boolean))))
      {
        if (!paramBoolean1) {
          break label172;
        }
        ((apym)localDrawable).c(true);
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        ((apym)localDrawable).a(paramBoolean1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("XBubbleAnimation", 2, "background alpha changed:" + String.valueOf(paramBoolean1));
      return;
      localapxz = null;
      break label62;
      label172:
      ((apym)localDrawable).c(false);
    }
  }
  
  protected boolean a()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewView == null)) {
      return false;
    }
    this.jdField_a_of_type_Afwr = null;
    int i = afur.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject = afur.a(afur.a(this.jdField_a_of_type_ComTencentWidgetListView, i));
    boolean bool1;
    label371:
    boolean bool2;
    if ((localObject != null) && ((localObject instanceof afwr)))
    {
      this.jdField_a_of_type_Afwr = ((afwr)localObject);
      if ((this.jdField_b_of_type_Int != 0) && ((this.jdField_a_of_type_Afwr == null) || (this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null))) {
        e();
      }
      if ((this.jdField_a_of_type_Afwr == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Apwu == null)) {
        break label1455;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.top = (this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView.getLeft() + this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView.getBottom() + this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_Afwr.jdField_a_of_type_AndroidViewView.getRight() + this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "bindView bubbleRect top=" + this.jdField_a_of_type_AndroidGraphicsRect.top + ",left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + ",bottom=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + ",right=" + this.jdField_a_of_type_AndroidGraphicsRect.right + ",listView height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
      }
      if (this.jdField_a_of_type_Afwr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
        break label538;
      }
      bool1 = true;
      if ((this.jdField_a_of_type_Apwu == null) || (this.jdField_a_of_type_Apwu.jdField_a_of_type_Apwn == null) || (this.jdField_a_of_type_Apwu.jdField_a_of_type_Apwn.c)) {
        break label544;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = false;
      label409:
      if (this.jdField_b_of_type_Apwu != null)
      {
        if (!this.jdField_a_of_type_Apwu.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_Apwu.jdField_b_of_type_JavaLangString)) {
          break label562;
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
        if (bool1) {
          break label556;
        }
        bool2 = true;
      }
    }
    label450:
    for (((VipPngPlayAnimationDrawable)localObject).c = bool2;; this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1)
    {
      if (this.jdField_b_of_type_Int != 6) {
        break label574;
      }
      this.jdField_b_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      return true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("XBubbleAnimation", 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      bool1 = false;
      break label371;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1;
      break label409;
      bool2 = false;
      break label450;
    }
    label538:
    label544:
    label556:
    label562:
    label574:
    localObject = a(this.jdField_a_of_type_Apwu.d, this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
    i = localObject[1];
    int n = this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.top + i;
    int k;
    int j;
    int m;
    if (!bool1)
    {
      i = localObject[0];
      i = this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.left + i;
      k = i;
      if (this.jdField_b_of_type_Apwu == null) {
        break label1489;
      }
      localObject = a(this.jdField_b_of_type_Apwu.d, this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
      j = localObject[0] - this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right;
      m = localObject[1] + this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.top;
      k = i;
      i = m;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "bindView mView master_x=" + k + ",master_y=" + n + ",mAttrsFirst.mRect.right=" + this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right + ",mAttrsFirst.mRect.bottom=" + this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
      }
      if ((k >= -this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right) && (k <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) && (n >= -this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom))
      {
        k -= this.jdField_b_of_type_AndroidViewView.getLeft();
        m = n - this.jdField_b_of_type_AndroidViewView.getTop();
        if ((k != 0) || (m != 0))
        {
          this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(k);
          this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(m);
          if (QLog.isColorLevel()) {
            QLog.d("XBubbleAnimation", 2, "bindView mView.offsetLeftAndRight " + k + ",mView.offsetTopAndBottom " + m);
          }
        }
      }
      label990:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.jdField_b_of_type_Apwu != null) && (this.jdField_a_of_type_AndroidViewView != null) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("XBubbleAnimation", 2, "bindView mLinkView x=" + j + ",y=" + i + ",mRect.right=" + this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right + ",mRect.bottom=" + this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
          }
          if ((j < -this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right) || (j > this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) || (i < -this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom)) {
            break;
          }
          j -= this.jdField_a_of_type_AndroidViewView.getLeft();
          i -= this.jdField_a_of_type_AndroidViewView.getTop();
          if ((j != 0) || (i != 0))
          {
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(j);
            this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i);
            if (QLog.isColorLevel()) {
              QLog.d("XBubbleAnimation", 2, "bindView mLinkView.offsetLeftAndRight " + j + ",mLinkView.offsetTopAndBottom " + i);
            }
          }
          for (;;)
          {
            return true;
            m = localObject[0] - this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right;
            k = m;
            if (this.jdField_b_of_type_Apwu == null) {
              break label1489;
            }
            localObject = a(this.jdField_b_of_type_Apwu.d, this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
            j = localObject[0] + this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.left;
            i = localObject[1] + this.jdField_b_of_type_Apwu.jdField_a_of_type_AndroidGraphicsRect.top;
            k = m;
            break;
            if (!QLog.isColorLevel()) {
              break label990;
            }
            QLog.d("XBubbleAnimation", 2, "bindView mView dx=" + k + ",dy=" + m);
            break label990;
            if (QLog.isColorLevel()) {
              QLog.d("XBubbleAnimation", 2, "bindView mLinkView dx=" + j + ",dy=" + i);
            }
          }
          if (this.jdField_b_of_type_Int == 0) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.1(this));
          return false;
        }
        return bool1;
      }
      label1455:
      label1489:
      i = 0;
      j = 0;
    }
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XBubbleAnimation", 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    ThreadManager.post(new XBubbleAnimation.3(this, paramVarArgs), 8, null, true);
    return true;
  }
  
  public boolean b(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != 3) {
      return false;
    }
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    if ((((Long)paramArrayOfObject[1]).longValue() != this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Int != i))
    {
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
      if ((paramArrayOfObject == null) || (paramArrayOfObject.first == null) || (((apwu)paramArrayOfObject.first).jdField_a_of_type_ArrayOfJavaLangString == null)) {
        return false;
      }
      this.jdField_a_of_type_Apwu = ((apwu)paramArrayOfObject.first);
      this.jdField_b_of_type_Apwu = ((apwu)paramArrayOfObject.second);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_a_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString);
        if ((this.jdField_b_of_type_Apwu != null) && (this.jdField_b_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString != null)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString);
        }
        return true;
      }
      catch (IOException paramArrayOfObject)
      {
        QLog.e("XBubbleAnimation", 1, "VipPngPlayAnimationDrawable measure exception", paramArrayOfObject);
      }
    }
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public boolean c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject.length != 3) || (this.c)) {
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "start XBubbleAnimation failed. args.length=" + paramArrayOfObject.length + ", mIsStop=" + this.c);
      }
    }
    int j;
    long l;
    int i;
    Object localObject;
    do
    {
      return false;
      j = ((Integer)paramArrayOfObject[0]).intValue();
      l = ((Long)paramArrayOfObject[1]).longValue();
      i = afur.a(l, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      localObject = afur.a(afur.a(this.jdField_a_of_type_ComTencentWidgetListView, i));
      if ((localObject == null) || (!(localObject instanceof afwr))) {
        break;
      }
      this.jdField_a_of_type_Afwr = ((afwr)localObject);
      if ((l == this.jdField_a_of_type_Long) && (this.jdField_b_of_type_Int == j)) {
        break label532;
      }
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.first == null) || (((apwu)paramArrayOfObject.first).jdField_a_of_type_ArrayOfJavaLangString == null));
    e();
    this.jdField_a_of_type_Long = l;
    this.jdField_b_of_type_Int = j;
    this.jdField_a_of_type_Apwu = ((apwu)paramArrayOfObject.first);
    this.jdField_b_of_type_Apwu = ((apwu)paramArrayOfObject.second);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_a_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Apwu.c);
    label258:
    label392:
    boolean bool;
    if (j != 0)
    {
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
      if (this.jdField_a_of_type_Apwu.jdField_a_of_type_Boolean)
      {
        i = 1;
        paramArrayOfObject.f = i;
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView = new agcj(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.h);
      if ((this.jdField_b_of_type_Apwu != null) && (this.jdField_b_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_Apwu.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_Apwu.c);
        if (j != 0)
        {
          paramArrayOfObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
          if (!this.jdField_b_of_type_Apwu.jdField_a_of_type_Boolean) {
            break label521;
          }
          i = 1;
          paramArrayOfObject.f = i;
        }
        this.jdField_a_of_type_AndroidViewView = new agck(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.h);
      }
      bool = a();
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      return bool;
      QLog.e("XBubbleAnimation", 1, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      i = this.jdField_a_of_type_Apwu.jdField_b_of_type_Int;
      break label258;
      label521:
      i = this.jdField_b_of_type_Apwu.jdField_b_of_type_Int;
      break label392;
      label532:
      bool = false;
    }
  }
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XBubbleAnimation", 2, "now stop current animation!");
    }
    this.jdField_b_of_type_Boolean = false;
    this.c = true;
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agci
 * JD-Core Version:    0.7.0.1
 */