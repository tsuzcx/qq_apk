import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloSlaveViewBinder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ajrk
  extends ajrp
  implements View.OnClickListener
{
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private int jdField_a_of_type_Int = 2;
  Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int b = 2;
  
  public ajrk(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = 4;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label525:
    label1321:
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_Int;
      int i3 = this.b;
      int k = 0;
      int m = 0;
      for (;;)
      {
        if (m >= this.b) {
          break label1321;
        }
        LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(m);
        int n = 0;
        if (n < this.jdField_a_of_type_Int)
        {
          View localView = localLinearLayout.getChildAt(n);
          ajqb localajqb = (ajqb)localView.getTag();
          int i1 = i2 * i3 * paramInt + k;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          label311:
          float f;
          label362:
          int i4;
          Object localObject1;
          if (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            ApolloActionData localApolloActionData = ((ajpz)this.jdField_a_of_type_JavaUtilList.get(i1)).a;
            localajqb.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838419);
            localajqb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localajqb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ajpz)this.jdField_a_of_type_JavaUtilList.get(i1)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
            localajqb.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
            localajqb.jdField_a_of_type_Ajpz = ((ajpz)this.jdField_a_of_type_JavaUtilList.get(i1));
            if (!TextUtils.isEmpty(localApolloActionData.iconUrl))
            {
              localajqb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(ajhu.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
              localajqb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            }
            if (!TextUtils.isEmpty(localajqb.jdField_a_of_type_Ajpz.b)) {
              if (XPanelContainer.d == 0)
              {
                i1 = 1;
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                localajqb.e.setVisibility(0);
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setText(localajqb.jdField_a_of_type_Ajpz.b);
                if (i1 == 0) {
                  break label1011;
                }
                f = 3.0F;
                i4 = actn.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
                localObject1 = (RelativeLayout.LayoutParams)localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject1).topMargin = i4;
                ((RelativeLayout.LayoutParams)localObject1).width = (ApolloLinearLayout.e - i4 * 2);
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 3);
                localObject1 = (RelativeLayout.LayoutParams)localajqb.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
                if (i1 == 0) {
                  break label1018;
                }
                f = 2.0F;
                label444:
                ((RelativeLayout.LayoutParams)localObject1).topMargin = actn.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
                localajqb.e.setBackgroundResource(2130838255);
                if (localajqb.jdField_a_of_type_Ajpz.d != 1) {
                  break label1083;
                }
                if (i1 == 0) {
                  break label1025;
                }
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
                if (i == 0) {
                  i = aiwc.a(localajqb.jdField_c_of_type_AndroidWidgetTextView.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject1).width = i;
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
                localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
                localObject1 = localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout;
                if (i1 == 0) {
                  break label1223;
                }
                f = 3.0F;
                label559:
                ((RelativeLayout)localObject1).setPadding(0, 0, 0, actn.a(f, this.jdField_a_of_type_AndroidContentContext.getResources()));
                localajqb.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
                label587:
                ApolloLinearLayout.setApolloActionIcon(localajqb.jdField_a_of_type_Ajpz.g, localajqb.jdField_a_of_type_Ajpz.a, localajqb);
                if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
                  localajqb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                }
                i1 = this.b;
                i4 = this.jdField_a_of_type_Int;
                int i5 = this.jdField_a_of_type_Int;
                localObject1 = (RelativeLayout)localView;
                if ((this.f == -1) || (this.f != i1 * paramInt * i4 + i5 * m + n)) {
                  break label1272;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloSlaveViewBinder", 2, new Object[] { "[updateBinderPanel] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.f), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId), ", pkgId=", Integer.valueOf(this.e) });
                }
                if (localajqb.jdField_a_of_type_AndroidViewView != null)
                {
                  ((RelativeLayout)localObject1).removeView(localajqb.jdField_a_of_type_AndroidViewView);
                  localajqb.jdField_a_of_type_AndroidViewView = null;
                }
                Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131362961);
                ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362961);
                ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131362961);
                ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131362961);
                RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                localRelativeLayout.setId(2131362589);
                localRelativeLayout.setBackgroundDrawable(null);
                ((RelativeLayout)localObject1).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
                localajqb.jdField_a_of_type_AndroidViewView = localRelativeLayout;
                localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                ((ImageView)localObject2).setImageResource(2130838416);
                ((ImageView)localObject2).setVisibility(8);
                localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
                ((ImageView)localObject2).postDelayed(new ApolloSlaveViewBinder.1(this, (ImageView)localObject2, localRelativeLayout, (RelativeLayout)localObject1, localajqb), 200L);
                this.f = -1;
                label980:
                localView.setContentDescription(localApolloActionData.actionName);
              }
            }
          }
          for (;;)
          {
            k += 1;
            n += 1;
            break;
            i1 = 0;
            break label311;
            label1011:
            f = 5.0F;
            break label362;
            label1018:
            f = 5.0F;
            break label444;
            localajqb.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 2);
            localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
            if (g == 0) {
              g = aiwc.a(localajqb.jdField_c_of_type_AndroidWidgetTextView.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject1).width = g;
            break label525;
            label1083:
            if (i1 != 0)
            {
              localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
              if (j == 0) {
                j = aiwc.a(localajqb.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = j;
              label1127:
              localObject1 = localajqb.jdField_c_of_type_AndroidWidgetTextView;
              if (i1 == 0) {
                break label1216;
              }
            }
            label1216:
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject1).setTextSize(f);
              localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
              localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838256);
              break;
              localajqb.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
              if (h == 0) {
                h = aiwc.a(localajqb.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = h;
              break label1127;
            }
            label1223:
            f = 9.0F;
            break label559;
            localajqb.e.setBackgroundDrawable(null);
            localajqb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            localajqb.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            localajqb.e.setVisibility(8);
            break label587;
            label1272:
            if (localajqb.jdField_a_of_type_AndroidViewView == null) {
              break label980;
            }
            ((RelativeLayout)localObject1).removeView(localajqb.jdField_a_of_type_AndroidViewView);
            localajqb.jdField_a_of_type_AndroidViewView = null;
            break label980;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        m += 1;
      }
    }
  }
  
  public int a()
  {
    int n = this.jdField_a_of_type_Int * this.b;
    int k;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      k = 1;
    }
    int i1;
    int m;
    do
    {
      return k;
      i1 = this.jdField_a_of_type_JavaUtilList.size();
      m = 0 + i1 / n;
      k = m;
    } while (i1 % n == 0);
    return m + 1;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    return paramInt / (this.b * this.jdField_a_of_type_Int);
  }
  
  public ajpz a(String paramString)
  {
    return new ajqf(paramString);
  }
  
  public View a()
  {
    return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.b);
  }
  
  public ArrayList<ajpz> a(int paramInt)
  {
    if ((this.c != 9) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      k = a();
    } while ((paramInt < 0) || (paramInt >= k));
    int k = this.jdField_a_of_type_Int;
    int m = this.b * k;
    k = paramInt * m;
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Int * this.b);
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
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramView, paramInt);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajrk
 * JD-Core Version:    0.7.0.1
 */