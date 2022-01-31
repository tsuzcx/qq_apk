import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import java.util.ArrayList;
import java.util.Iterator;

public class acyf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel;
  ArrayList<acye> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public acyf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 3) || ((this.jdField_a_of_type_JavaUtilArrayList.size() > 3) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 6)) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 6)) {
      return 3;
    }
    return 4;
  }
  
  public ArrayList<acye> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(PokePanel paramPokePanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel = paramPokePanel;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      acye localacye;
      if (localIterator.hasNext())
      {
        localacye = (acye)localIterator.next();
        if (!paramString.equals("poke.item.effect.")) {
          break label63;
        }
        if (localacye.jdField_b_of_type_Int == paramInt) {
          localacye.jdField_c_of_type_Boolean = paramBoolean1;
        }
      }
      else
      {
        return;
      }
      notifyDataSetChanged();
      continue;
      label63:
      if (paramString.equals("poke.item.res."))
      {
        if (localacye.jdField_b_of_type_Int == paramInt)
        {
          localacye.jdField_b_of_type_Boolean = paramBoolean2;
          localacye.jdField_c_of_type_Boolean = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<acye> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = a();
      return (this.jdField_a_of_type_JavaUtilArrayList.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = a();
    int i;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      paramViewGroup.setOrientation(0);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      while (i < j)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        if (paramView != null) {
          break label982;
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558763, null);
        paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new acyg(this);
        ((acyg)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131367800));
        ((acyg)localObject1).b = ((ImageView)((View)localObject2).findViewById(2131366359));
        ((acyg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131377046));
        ((acyg)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131365948));
        ((acyg)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject2).findViewById(2131369498));
        ((acyg)localObject1).d = ((ImageView)((View)localObject2).findViewById(2131365349));
        ((View)localObject2).setTag(localObject1);
        i += 1;
      }
      paramView = paramViewGroup;
    }
    for (;;)
    {
      paramViewGroup = (ViewGroup)paramView;
      label281:
      acye localacye;
      if (paramInt == 0)
      {
        paramViewGroup.setPadding(actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        i = 0;
        if (i >= j) {
          break label970;
        }
        int k = j * paramInt + i;
        localObject1 = paramViewGroup.getChildAt(i);
        localObject2 = (acyg)((View)localObject1).getTag();
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label879;
        }
        localacye = (acye)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((ClickedWaveView)((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView).setCustomDrawable(localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("type", localacye.jdField_a_of_type_Int);
        ((Bundle)localObject3).putInt("id", localacye.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("name", localacye.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("feeType", localacye.jdField_c_of_type_Int);
        ((Bundle)localObject3).putBoolean("isShowDownload", localacye.jdField_b_of_type_Boolean);
        ((Bundle)localObject3).putBoolean("isShowLoading", localacye.jdField_c_of_type_Boolean);
        ((Bundle)localObject3).putString("minVersion", localacye.jdField_c_of_type_JavaLangString);
        ((ClickedWaveView)((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView).setExtraInfo((Bundle)localObject3);
        ((ClickedWaveView)((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView).setOnTouchReceive(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
        if (!(localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
          break label750;
        }
        localObject3 = (URLDrawable)localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        label535:
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localacye.jdField_a_of_type_JavaLangString);
        if (!localacye.jdField_a_of_type_Boolean) {
          break label785;
        }
        ((acyg)localObject2).b.setVisibility(0);
        label565:
        if (localacye.jdField_c_of_type_Int != 4) {
          break label798;
        }
        ((acyg)localObject2).c.setVisibility(0);
        ((acyg)localObject2).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846491));
        label604:
        if (!localacye.jdField_b_of_type_Boolean) {
          break label853;
        }
        ((acyg)localObject2).d.setVisibility(0);
        ((acyg)localObject2).d.setTag(Integer.valueOf(localacye.jdField_b_of_type_Int));
        label637:
        if (!localacye.jdField_c_of_type_Boolean) {
          break label866;
        }
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label654:
        ((View)localObject1).setContentDescription(localacye.jdField_a_of_type_JavaLangString);
        ((View)localObject1).setEnabled(true);
        baww.a((View)localObject1, true);
      }
      for (;;)
      {
        baww.a(((acyg)localObject2).jdField_a_of_type_AndroidWidgetTextView, false);
        i += 1;
        break label281;
        paramViewGroup.setPadding(actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        break;
        label750:
        if (!(localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
          break label535;
        }
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((CustomFrameAnimationDrawable)localacye.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
        break label535;
        label785:
        ((acyg)localObject2).b.setVisibility(8);
        break label565;
        label798:
        if (localacye.jdField_c_of_type_Int == 5)
        {
          ((acyg)localObject2).c.setVisibility(0);
          ((acyg)localObject2).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846490));
          break label604;
        }
        ((acyg)localObject2).c.setVisibility(8);
        break label604;
        label853:
        ((acyg)localObject2).d.setVisibility(8);
        break label637;
        label866:
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break label654;
        label879:
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(null);
        ((acyg)localObject2).b.setVisibility(8);
        ((acyg)localObject2).c.setVisibility(8);
        ((acyg)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((acyg)localObject2).d.setVisibility(8);
        ((acyg)localObject2).d.setTag(null);
        ((View)localObject1).setEnabled(false);
        baww.a((View)localObject1, false);
      }
      label970:
      paramView.setOnLongClickListener(null);
      baww.a(paramView, false);
      return paramView;
      label982:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyf
 * JD-Core Version:    0.7.0.1
 */