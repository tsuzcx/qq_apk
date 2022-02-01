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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class afdb
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel;
  ArrayList<afda> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public afdb(Context paramContext)
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
  
  public ArrayList<afda> a()
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
      afda localafda;
      if (localIterator.hasNext())
      {
        localafda = (afda)localIterator.next();
        if (!paramString.equals("poke.item.effect.")) {
          break label63;
        }
        if (localafda.jdField_b_of_type_Int == paramInt) {
          localafda.jdField_c_of_type_Boolean = paramBoolean1;
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
        if (localafda.jdField_b_of_type_Int == paramInt)
        {
          localafda.jdField_b_of_type_Boolean = paramBoolean2;
          localafda.jdField_c_of_type_Boolean = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<afda> paramArrayList)
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
    Object localObject2;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((LinearLayout)localObject2).setOrientation(0);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      localObject1 = localObject2;
      if (i >= j) {
        break label225;
      }
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
      if (paramView != null) {
        break label1009;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    }
    label225:
    label613:
    label875:
    label1009:
    for (;;)
    {
      Object localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558877, null);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new afdc(this);
      ((afdc)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131368368));
      ((afdc)localObject1).b = ((ImageView)((View)localObject3).findViewById(2131366809));
      ((afdc)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131378382));
      ((afdc)localObject1).c = ((ImageView)((View)localObject3).findViewById(2131366367));
      ((afdc)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject3).findViewById(2131370284));
      ((afdc)localObject1).d = ((ImageView)((View)localObject3).findViewById(2131365749));
      ((View)localObject3).setTag(localObject1);
      i += 1;
      break;
      localObject1 = paramView;
      paramView = (ViewGroup)localObject1;
      afda localafda;
      if (paramInt == 0)
      {
        paramView.setPadding(AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        i = 0;
        if (i >= j) {
          break label979;
        }
        int k = j * paramInt + i;
        localObject2 = paramView.getChildAt(i);
        localObject3 = (afdc)((View)localObject2).getTag();
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label888;
        }
        localafda = (afda)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((ClickedWaveView)((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView).setCustomDrawable(localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("type", localafda.jdField_a_of_type_Int);
        ((Bundle)localObject4).putInt("id", localafda.jdField_b_of_type_Int);
        ((Bundle)localObject4).putString("name", localafda.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject4).putInt("feeType", localafda.jdField_c_of_type_Int);
        ((Bundle)localObject4).putBoolean("isShowDownload", localafda.jdField_b_of_type_Boolean);
        ((Bundle)localObject4).putBoolean("isShowLoading", localafda.jdField_c_of_type_Boolean);
        ((Bundle)localObject4).putString("minVersion", localafda.jdField_c_of_type_JavaLangString);
        ((ClickedWaveView)((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView).setExtraInfo((Bundle)localObject4);
        ((ClickedWaveView)((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView).setOnTouchReceive(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
        if (!(localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
          break label759;
        }
        localObject4 = (URLDrawable)localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (((URLDrawable)localObject4).getStatus() == 2) {
          ((URLDrawable)localObject4).restartDownload();
        }
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(localafda.jdField_a_of_type_JavaLangString);
        if (!localafda.jdField_a_of_type_Boolean) {
          break label794;
        }
        ((afdc)localObject3).b.setVisibility(0);
        if (localafda.jdField_c_of_type_Int != 4) {
          break label807;
        }
        ((afdc)localObject3).c.setVisibility(0);
        ((afdc)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847328));
        if (!localafda.jdField_b_of_type_Boolean) {
          break label862;
        }
        ((afdc)localObject3).d.setVisibility(0);
        ((afdc)localObject3).d.setTag(Integer.valueOf(localafda.jdField_b_of_type_Int));
        if (!localafda.jdField_c_of_type_Boolean) {
          break label875;
        }
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((View)localObject2).setContentDescription(localafda.jdField_a_of_type_JavaLangString);
        ((View)localObject2).setEnabled(true);
        bfpm.a((View)localObject2, true);
      }
      for (;;)
      {
        bfpm.a(((afdc)localObject3).jdField_a_of_type_AndroidWidgetTextView, false);
        i += 1;
        break label290;
        paramView.setPadding(AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        break;
        label759:
        if (!(localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
          break label544;
        }
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((CustomFrameAnimationDrawable)localafda.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
        break label544;
        ((afdc)localObject3).b.setVisibility(8);
        break label574;
        if (localafda.jdField_c_of_type_Int == 5)
        {
          ((afdc)localObject3).c.setVisibility(0);
          ((afdc)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847327));
          break label613;
        }
        ((afdc)localObject3).c.setVisibility(8);
        break label613;
        ((afdc)localObject3).d.setVisibility(8);
        break label646;
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break label663;
        label888:
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(null);
        ((afdc)localObject3).b.setVisibility(8);
        ((afdc)localObject3).c.setVisibility(8);
        ((afdc)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((afdc)localObject3).d.setVisibility(8);
        ((afdc)localObject3).d.setTag(null);
        ((View)localObject2).setEnabled(false);
        bfpm.a((View)localObject2, false);
      }
      ((View)localObject1).setOnLongClickListener(null);
      bfpm.a((View)localObject1, false);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */