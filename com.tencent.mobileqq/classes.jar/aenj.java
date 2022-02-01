import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aenj
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private aenl jdField_a_of_type_Aenl;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private aenl jdField_b_of_type_Aenl;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private boolean jdField_b_of_type_Boolean;
  private aenl c;
  private aenl d;
  
  public aenj(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2, ImageView paramImageView, MqqHandler paramMqqHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher1;
    this.jdField_b_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher2;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aenl a(String paramString)
  {
    if (this.d != null)
    {
      if (!this.d.a(paramString)) {
        break label54;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "命中预加载faceDrawable  uin:" + paramString);
      }
    }
    for (;;)
    {
      return this.d;
      label54:
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "没有命中预加载，回收预加载:" + paramString);
      }
      this.d.a();
      this.d = null;
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return anni.a(2131704809);
    case 0: 
      return anni.a(2131704811);
    case 1: 
      return anni.a(2131704813);
    case 2: 
      return anni.a(2131704812);
    }
    return anni.a(2131704814);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
      }
    }
    do
    {
      return false;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin没有uin数据");
    return false;
    return true;
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int >= paramInt;
  }
  
  private static boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, " equal arrayList1==null&&arrayList2==null");
      }
      return true;
    }
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
      }
      return false;
    }
    if (paramArrayList1.size() != paramArrayList2.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal arrayList1.size()!=arrayList2.size()");
      }
      return false;
    }
    int i = 0;
    try
    {
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        if (!str1.equals(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("not equal index: %d,uin1:%s,uin2:%s", new Object[] { Integer.valueOf(i), str1, str2 }));
          }
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramArrayList1)
    {
      QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, paramArrayList1, new Object[0]);
      return false;
    }
  }
  
  private boolean b()
  {
    String str;
    if ((this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 2)) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1))) {
      if ((this.d != null) && (this.jdField_b_of_type_Int != 4))
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label478;
        }
        if ((this.c != null) && (!this.c.a())) {
          break label302;
        }
        str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        if ((this.d.a()) || (!this.d.jdField_a_of_type_JavaLangString.equals(str))) {
          break label287;
        }
        this.c = this.d;
        this.d = null;
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.c.jdField_a_of_type_Aoch);
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play two" + this.c.jdField_a_of_type_JavaLangString);
        }
        str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((this.d == null) || (this.d.a()) || (!this.d.jdField_a_of_type_JavaLangString.equals(str))) {
          break label412;
        }
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.d.jdField_a_of_type_Aoch);
        this.jdField_a_of_type_Aenl = this.jdField_b_of_type_Aenl;
        this.jdField_b_of_type_Aenl = this.d;
        this.d = null;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 4;
      if (this.jdField_b_of_type_Int != 4) {
        break label553;
      }
      return true;
      label287:
      this.c = aenl.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label302:
      if (this.c.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaUtilArrayList.get(1))) {
        break;
      }
      if (!this.c.a())
      {
        this.c.a();
        this.c = null;
      }
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(1);
      if ((!this.d.a()) && (this.d.jdField_a_of_type_JavaLangString.equals(str)))
      {
        this.c = this.d;
        this.d = null;
        break;
      }
      this.c = aenl.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label412:
      this.jdField_a_of_type_Aenl = this.jdField_b_of_type_Aenl;
      if ((this.d != null) && (!this.d.a()))
      {
        this.d.a();
        this.d = null;
      }
      this.jdField_b_of_type_Aenl = aenl.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.jdField_b_of_type_Aenl.jdField_a_of_type_Aoch);
      continue;
      label478:
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.d.jdField_a_of_type_Aoch);
      this.jdField_a_of_type_Aenl = this.jdField_b_of_type_Aenl;
      this.jdField_b_of_type_Aenl = this.d;
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "isPlayFinished play one" + this.jdField_b_of_type_Aenl.jdField_a_of_type_JavaLangString);
      }
    }
    label553:
    return false;
  }
  
  private boolean b(int paramInt)
  {
    return this.jdField_b_of_type_Int < paramInt;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Aenl != null) && (!this.jdField_a_of_type_Aenl.a()))
    {
      this.jdField_a_of_type_Aenl.a();
      this.jdField_a_of_type_Aenl = null;
    }
    if ((this.jdField_b_of_type_Aenl != null) && (!this.jdField_b_of_type_Aenl.a()))
    {
      this.jdField_b_of_type_Aenl.a();
      this.jdField_b_of_type_Aenl = null;
    }
    if ((this.c != null) && (!this.c.a()))
    {
      this.c.a();
      this.c = null;
    }
    if ((this.d != null) && (!this.d.a()))
    {
      this.d.a();
      this.d = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getInAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getOutAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ("1000".equals(ThemeUtil.curThemeId)) {
        break label28;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label28:
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        if (!a()) {
          break label808;
        }
        if (b())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "已经播放完毕，不再轮播头像");
          return;
        }
        if (!a(2)) {
          break label772;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_Int > 0))
        {
          a(true);
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
          }
          this.jdField_a_of_type_Aenl = this.jdField_b_of_type_Aenl;
          Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
          if (!this.jdField_a_of_type_Boolean) {
            break label587;
          }
          if ((this.c == null) || (this.c.a())) {
            break label541;
          }
          if (!this.c.jdField_a_of_type_JavaLangString.equals(localObject)) {
            break label516;
          }
          this.jdField_b_of_type_Aenl = this.c;
          this.c = null;
          localObject = this.jdField_b_of_type_Aenl.a();
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.jdField_b_of_type_Aenl.jdField_a_of_type_JavaLangString);
          }
          this.c = a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1));
          if (this.c == null) {
            this.c = aenl.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localObject = this.c.a();
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play two" + this.c.jdField_a_of_type_JavaLangString);
            }
          }
          if (this.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1688002, 1400L);
          }
          this.jdField_a_of_type_Int += 1;
          if (((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) && ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()))) {
            break;
          }
          localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_Boolean) {
            localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
          }
          this.d = aenl.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, "播放头像过程中出现错误，请关注异常信息", localThrowable);
        bmjj.a(localThrowable, anni.a(2131704810));
        return;
      }
      g();
      continue;
      label516:
      if (!this.c.a())
      {
        this.c.a();
        this.c = null;
        continue;
        label541:
        if ((this.jdField_b_of_type_Aenl == null) || ((!this.jdField_b_of_type_Aenl.a()) && (!this.jdField_b_of_type_Aenl.jdField_a_of_type_JavaLangString.equals(localThrowable))))
        {
          this.jdField_b_of_type_Aenl = aenl.a(localThrowable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          label587:
          this.jdField_b_of_type_Aenl = a(localThrowable);
          if (this.jdField_b_of_type_Aenl == null) {
            this.jdField_b_of_type_Aenl = aenl.a(localThrowable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          aoch localaoch = this.jdField_b_of_type_Aenl.a();
          if (localaoch != null)
          {
            this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(localaoch);
            if (QLog.isColorLevel()) {
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "play one" + this.jdField_b_of_type_Aenl.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
    }
    if (((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size())) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      this.d = aenl.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Boolean)
      {
        this.c = aenl.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        label772:
        if (QLog.isColorLevel())
        {
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "播放状态不对，不进行播放 playState:" + this.jdField_b_of_type_Int);
          return;
          label808:
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "非法状态，不进行播放下一张头像");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("start play qzone face pre list:%s, current list:%s, currentPlayState:%s, currentIndex:%d", new Object[] { String.valueOf(this.jdField_a_of_type_JavaUtilArrayList), String.valueOf(paramArrayList), a(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      if ((!b(2)) && (a(this.jdField_a_of_type_JavaUtilArrayList, paramArrayList))) {
        break label339;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label314;
      }
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label269;
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramArrayList = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean) {
        paramArrayList = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      }
      this.d = aenl.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label279;
      }
      if (this.jdField_b_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      }
      h();
      a();
    }
    label269:
    label279:
    label314:
    label339:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        continue;
        if (this.jdField_b_of_type_AndroidWidgetImageSwitcher != null) {
          this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "start play qzone face 更新数据为 null，隐藏头像");
      }
      d();
      this.jdField_b_of_type_Int = 0;
      return;
    }
    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "数据没有发生变化，保持原有的播放状态:" + this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setAnimateFirstView(false);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setAnimateFirstView(false);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1400L);
    localAlphaAnimation1.setAnimationListener(new aenk(this, paramBoolean));
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(1400L);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(localAlphaAnimation2);
    localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(1400L);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "pausePlayFace pre playState=" + a(this.jdField_b_of_type_Int));
    }
    if ((a(2)) && (b(4)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public void c()
  {
    h();
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "resumePlayFace pre playState=" + a(this.jdField_b_of_type_Int));
    }
    if (!b(4))
    {
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Int = 0;
      a();
    }
    while (!a(1)) {
      return;
    }
    this.jdField_b_of_type_Int = 2;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_Int = 0;
    }
    a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Int = 0;
    }
    g();
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageSwitcher != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    f();
  }
  
  public void e()
  {
    h();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1688002: 
      a();
      return true;
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenj
 * JD-Core Version:    0.7.0.1
 */