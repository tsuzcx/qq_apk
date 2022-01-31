import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ajce
  extends ajdn
  implements View.OnClickListener
{
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private int jdField_a_of_type_Int = 4;
  private ajau jdField_a_of_type_Ajau;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 2;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ajce(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    int m = 1;
    int n = this.jdField_a_of_type_Int * this.jdField_b_of_type_Int;
    int k = m;
    switch (this.c)
    {
    case 2: 
    default: 
      k = 0;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return k;
          k = m;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        k = m;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      i1 = this.jdField_a_of_type_JavaUtilList.size();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (i1 <= 0)) {
        break;
      }
      m = i1 / n + 0;
      k = m;
    } while (i1 % n == 0);
    return m + 1;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    return paramInt / (this.jdField_b_of_type_Int * this.jdField_a_of_type_Int);
  }
  
  public ajbx a(String paramString)
  {
    return new ajcd(paramString);
  }
  
  public View a()
  {
    switch (this.c)
    {
    case 2: 
    default: 
      return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    case 0: 
      return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    case 1: 
      return LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131493058, null);
    }
    return LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131493053, null);
  }
  
  public ArrayList<ajbx> a(int paramInt)
  {
    if ((this.c != 0) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      k = a();
    } while ((paramInt < 0) || (paramInt >= k));
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int * k;
    k = paramInt * m;
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
    paramInt = k;
    while ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt <= m + k - 1))
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajau = null;
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  public void a(ajau paramajau)
  {
    this.jdField_a_of_type_Ajau = paramajau;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131297060);
    URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131297093);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297092));
    localURLImageView1.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131634667));
    }
    Object localObject = new ColorDrawable();
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
    localLayoutParams.height = ((int)(XPanelContainer.jdField_a_of_type_Int - 85.0F * paramView.getResources().getDisplayMetrics().density));
    localLayoutParams.width = (localLayoutParams.height * 602 / 366);
    localLayoutParams.bottomMargin = ((int)(5.0F * paramView.getResources().getDisplayMetrics().density));
    localURLImageView1.setBackgroundDrawable(localURLDrawable);
    localURLImageView2.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(View paramView, int paramInt)
  {
    switch (this.c)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 0: 
      b(paramView, paramInt);
      return;
    }
    b(paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131308974));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "panel is not jsonFail and panelView.class=" + paramView.getClass().getSimpleName());
    return;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303120));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303118));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303119));
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label1413:
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_Int;
      int i3 = this.jdField_b_of_type_Int;
      int k = 0;
      int m = 0;
      for (;;)
      {
        if (m >= this.jdField_b_of_type_Int) {
          break label1413;
        }
        LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(m);
        int n = 0;
        if (n < this.jdField_a_of_type_Int)
        {
          View localView = localLinearLayout.getChildAt(n);
          ajbz localajbz = (ajbz)localView.getTag();
          int i1 = i2 * i3 * paramInt + k;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          Object localObject1;
          label242:
          float f;
          label355:
          int i4;
          if (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            ApolloActionData localApolloActionData = ((ajbx)this.jdField_a_of_type_JavaUtilList.get(i1)).a;
            localajbz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (((ajbx)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_b_of_type_Int == 1)
            {
              localObject1 = new RedTouch(this.jdField_b_of_type_AndroidContentContext, localajbz.jdField_a_of_type_AndroidWidgetImageView).a(5).a();
              ((RedTouch)localObject1).a(((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103200"));
              localajbz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838412);
              localajbz.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = ((RedTouch)localObject1);
              localajbz.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
              localajbz.jdField_a_of_type_Ajbx = ((ajbx)this.jdField_a_of_type_JavaUtilList.get(i1));
              localajbz.jdField_a_of_type_Ajbx.c = 0;
              if (!TextUtils.isEmpty(localApolloActionData.iconUrl))
              {
                localajbz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(aitu.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
                localajbz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
              }
              if (TextUtils.isEmpty(localajbz.jdField_a_of_type_Ajbx.jdField_b_of_type_JavaLangString)) {
                break label1322;
              }
              if (XPanelContainer.d != 0) {
                break label1099;
              }
              i1 = 1;
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              localajbz.e.setVisibility(0);
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setText(localajbz.jdField_a_of_type_Ajbx.jdField_b_of_type_JavaLangString);
              if (i1 == 0) {
                break label1105;
              }
              f = 3.0F;
              label407:
              i4 = aciy.a(f, this.jdField_b_of_type_AndroidContentContext.getResources());
              localObject1 = (RelativeLayout.LayoutParams)localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).topMargin = i4;
              ((RelativeLayout.LayoutParams)localObject1).width = (ApolloLinearLayout.e - i4 * 2);
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 3);
              localObject1 = (RelativeLayout.LayoutParams)localajbz.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
              if (i1 == 0) {
                break label1111;
              }
              f = 2.0F;
              label489:
              ((RelativeLayout.LayoutParams)localObject1).topMargin = aciy.a(f, this.jdField_b_of_type_AndroidContentContext.getResources());
              localajbz.e.setBackgroundResource(2130838247);
              if (localajbz.jdField_a_of_type_Ajbx.d != 1) {
                break label1175;
              }
              if (i1 == 0) {
                break label1117;
              }
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
              if (i == 0) {
                i = aijj.a(localajbz.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = i;
              label572:
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
              localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
              localObject1 = localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout;
              if (i1 == 0) {
                break label1315;
              }
              f = 3.0F;
              label608:
              ((RelativeLayout)localObject1).setPadding(0, 0, 0, aciy.a(f, this.jdField_b_of_type_AndroidContentContext.getResources()));
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
              label636:
              ApolloLinearLayout.setApolloActionIcon(localajbz.jdField_a_of_type_Ajbx.g, localajbz.jdField_a_of_type_Ajbx.a, localajbz);
              if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
                localajbz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              }
              i1 = this.jdField_b_of_type_Int;
              i4 = this.jdField_a_of_type_Int;
              int i5 = this.jdField_a_of_type_Int;
              localObject1 = (RelativeLayout)localView;
              if ((this.f == -1) || (this.f != i1 * paramInt * i4 + i5 * m + n)) {
                break label1364;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloMainViewBinder", 2, new Object[] { "[updateBinderPanel] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.f), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId), ", pkgId=", Integer.valueOf(this.e) });
              }
              if (localajbz.jdField_a_of_type_AndroidViewView != null)
              {
                ((RelativeLayout)localObject1).removeView(localajbz.jdField_a_of_type_AndroidViewView);
                localajbz.jdField_a_of_type_AndroidViewView = null;
              }
              Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
              ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131297421);
              ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131297421);
              ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131297421);
              ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131297421);
              RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
              localRelativeLayout.setId(2131297050);
              localRelativeLayout.setBackgroundDrawable(null);
              ((RelativeLayout)localObject1).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
              localajbz.jdField_a_of_type_AndroidViewView = localRelativeLayout;
              localObject2 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
              ((ImageView)localObject2).setImageResource(2130838407);
              ((ImageView)localObject2).setVisibility(8);
              localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
              ((ImageView)localObject2).postDelayed(new ApolloMainViewBinder.1(this, (ImageView)localObject2, localRelativeLayout, (RelativeLayout)localObject1, localajbz), 200L);
              this.f = -1;
              label1029:
              localView.setContentDescription(localApolloActionData.actionName);
            }
          }
          for (;;)
          {
            k += 1;
            n += 1;
            break;
            localajbz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ajbx)this.jdField_a_of_type_JavaUtilList.get(i1)).a(this.jdField_b_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
            break label242;
            label1099:
            i1 = 0;
            break label355;
            label1105:
            f = 5.0F;
            break label407;
            label1111:
            f = 5.0F;
            break label489;
            label1117:
            localajbz.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 2);
            localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
            if (g == 0) {
              g = aijj.a(localajbz.jdField_c_of_type_AndroidWidgetTextView.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject1).width = g;
            break label572;
            label1175:
            if (i1 != 0)
            {
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
              if (j == 0) {
                j = aijj.a(localajbz.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = j;
              label1219:
              localObject1 = localajbz.jdField_c_of_type_AndroidWidgetTextView;
              if (i1 == 0) {
                break label1308;
              }
            }
            label1308:
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject1).setTextSize(f);
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
              localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838248);
              break;
              localajbz.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
              if (h == 0) {
                h = aijj.a(localajbz.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = h;
              break label1219;
            }
            label1315:
            f = 9.0F;
            break label608;
            label1322:
            localajbz.e.setBackgroundDrawable(null);
            localajbz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            localajbz.e.setVisibility(8);
            break label636;
            label1364:
            if (localajbz.jdField_a_of_type_AndroidViewView == null) {
              break label1029;
            }
            ((RelativeLayout)localObject1).removeView(localajbz.jdField_a_of_type_AndroidViewView);
            localajbz.jdField_a_of_type_AndroidViewView = null;
            break label1029;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        m += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
  
  public void c_(List<ajbx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Ajau == null);
        this.jdField_a_of_type_Ajau.d();
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Ajau.b();
          return;
        }
      } while (this.jdField_a_of_type_Ajau == null);
      paramView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)paramView.getParent()).findViewById(2131311530));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Ajau.a();
      return;
    } while (this.jdField_a_of_type_Ajau == null);
    this.jdField_a_of_type_Ajau.c();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    paramView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajce
 * JD-Core Version:    0.7.0.1
 */