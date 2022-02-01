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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class agap
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel;
  ArrayList<agao> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public agap(Context paramContext)
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
  
  public ArrayList<agao> a()
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
      agao localagao;
      if (localIterator.hasNext())
      {
        localagao = (agao)localIterator.next();
        if (!paramString.equals("poke.item.effect.")) {
          break label63;
        }
        if (localagao.jdField_b_of_type_Int == paramInt) {
          localagao.jdField_c_of_type_Boolean = paramBoolean1;
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
        if (localagao.jdField_b_of_type_Int == paramInt)
        {
          localagao.jdField_b_of_type_Boolean = paramBoolean2;
          localagao.jdField_c_of_type_Boolean = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<agao> paramArrayList)
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
      Object localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558871, null);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new agaq(this);
      ((agaq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131368270));
      ((agaq)localObject1).b = ((ImageView)((View)localObject3).findViewById(2131366734));
      ((agaq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131378460));
      ((agaq)localObject1).c = ((ImageView)((View)localObject3).findViewById(2131366291));
      ((agaq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject3).findViewById(2131370215));
      ((agaq)localObject1).d = ((ImageView)((View)localObject3).findViewById(2131365673));
      ((View)localObject3).setTag(localObject1);
      i += 1;
      break;
      localObject1 = paramView;
      paramView = (ViewGroup)localObject1;
      agao localagao;
      if (paramInt == 0)
      {
        paramView.setPadding(afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        i = 0;
        if (i >= j) {
          break label979;
        }
        int k = j * paramInt + i;
        localObject2 = paramView.getChildAt(i);
        localObject3 = (agaq)((View)localObject2).getTag();
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label888;
        }
        localagao = (agao)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((ClickedWaveView)((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView).setCustomDrawable(localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("type", localagao.jdField_a_of_type_Int);
        ((Bundle)localObject4).putInt("id", localagao.jdField_b_of_type_Int);
        ((Bundle)localObject4).putString("name", localagao.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject4).putInt("feeType", localagao.jdField_c_of_type_Int);
        ((Bundle)localObject4).putBoolean("isShowDownload", localagao.jdField_b_of_type_Boolean);
        ((Bundle)localObject4).putBoolean("isShowLoading", localagao.jdField_c_of_type_Boolean);
        ((Bundle)localObject4).putString("minVersion", localagao.jdField_c_of_type_JavaLangString);
        ((ClickedWaveView)((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView).setExtraInfo((Bundle)localObject4);
        ((ClickedWaveView)((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView).setOnTouchReceive(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
        if (!(localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
          break label759;
        }
        localObject4 = (URLDrawable)localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (((URLDrawable)localObject4).getStatus() == 2) {
          ((URLDrawable)localObject4).restartDownload();
        }
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(localagao.jdField_a_of_type_JavaLangString);
        if (!localagao.jdField_a_of_type_Boolean) {
          break label794;
        }
        ((agaq)localObject3).b.setVisibility(0);
        if (localagao.jdField_c_of_type_Int != 4) {
          break label807;
        }
        ((agaq)localObject3).c.setVisibility(0);
        ((agaq)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847402));
        if (!localagao.jdField_b_of_type_Boolean) {
          break label862;
        }
        ((agaq)localObject3).d.setVisibility(0);
        ((agaq)localObject3).d.setTag(Integer.valueOf(localagao.jdField_b_of_type_Int));
        if (!localagao.jdField_c_of_type_Boolean) {
          break label875;
        }
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((View)localObject2).setContentDescription(localagao.jdField_a_of_type_JavaLangString);
        ((View)localObject2).setEnabled(true);
        bgfz.a((View)localObject2, true);
      }
      for (;;)
      {
        bgfz.a(((agaq)localObject3).jdField_a_of_type_AndroidWidgetTextView, false);
        i += 1;
        break label290;
        paramView.setPadding(afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        break;
        label759:
        if (!(localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
          break label544;
        }
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((CustomFrameAnimationDrawable)localagao.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
        break label544;
        ((agaq)localObject3).b.setVisibility(8);
        break label574;
        if (localagao.jdField_c_of_type_Int == 5)
        {
          ((agaq)localObject3).c.setVisibility(0);
          ((agaq)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847401));
          break label613;
        }
        ((agaq)localObject3).c.setVisibility(8);
        break label613;
        ((agaq)localObject3).d.setVisibility(8);
        break label646;
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break label663;
        label888:
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(null);
        ((agaq)localObject3).b.setVisibility(8);
        ((agaq)localObject3).c.setVisibility(8);
        ((agaq)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((agaq)localObject3).d.setVisibility(8);
        ((agaq)localObject3).d.setTag(null);
        ((View)localObject2).setEnabled(false);
        bgfz.a((View)localObject2, false);
      }
      ((View)localObject1).setOnLongClickListener(null);
      bgfz.a((View)localObject1, false);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agap
 * JD-Core Version:    0.7.0.1
 */