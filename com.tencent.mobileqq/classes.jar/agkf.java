import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class agkf
  extends BaseAdapter
{
  private float jdField_a_of_type_Float = 1.25F;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ArrayList<airp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public agkf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841475);
  }
  
  private int a()
  {
    return 4;
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public void a(List<airp> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
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
    int k = a();
    int i = (XPanelContainer.jdField_a_of_type_Int - agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2) / 3;
    int j;
    if (i >= 0)
    {
      j = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (i >= j) {
        break label611;
      }
      i = j;
    }
    label419:
    label576:
    label585:
    label611:
    for (;;)
    {
      j = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4) / 8;
      Object localObject2;
      Object localObject3;
      if (paramView == null)
      {
        localObject1 = new StickerBubbleLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        ((LinearLayout)localObject1).setMinimumHeight(agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + i);
        ((LinearLayout)localObject1).setOrientation(0);
        j = 0;
        for (;;)
        {
          paramView = (View)localObject1;
          if (j >= k) {
            break;
          }
          paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setGravity(17);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          if (j == 0) {}
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          localObject2 = new LinearLayout.LayoutParams(agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject2).topMargin = (i / 2);
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = (i / 2);
          localObject3 = new StickerBubbleImageView(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject3).setPadding(14, 14, 14, 14);
          int m = agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
          localShapeDrawable.setIntrinsicHeight(m);
          localShapeDrawable.setIntrinsicWidth(n);
          localShapeDrawable.getPaint().setColor(1728053247);
          ((View)localObject3).setBackgroundDrawable(localShapeDrawable);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramView.addView((View)localObject3);
          ((LinearLayout)localObject1).addView(paramView);
          j += 1;
        }
        i = 0;
        break;
      }
      Object localObject1 = (ViewGroup)paramView;
      if (paramInt == 0)
      {
        ((ViewGroup)localObject1).setPadding(0, i / 2, 0, 0);
        i = 0;
        if (i >= k) {
          break label585;
        }
        j = k * paramInt + i;
        localObject2 = ((ViewGroup)((ViewGroup)localObject1).getChildAt(i)).getChildAt(0);
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label576;
        }
        ((View)localObject2).setVisibility(0);
        localObject3 = (airp)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject3 != null) {
          ((ImageView)localObject2).setImageDrawable(a(((airp)localObject3).jdField_a_of_type_JavaLangString));
        }
        ((View)localObject2).setTag(Integer.valueOf(j));
        if (AppSetting.c) {
          ((View)localObject2).setContentDescription(airq.a(((airp)localObject3).jdField_a_of_type_Int) + anzj.a(2131707200));
        }
      }
      for (;;)
      {
        i += 1;
        break label419;
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
        break;
        ((View)localObject2).setVisibility(4);
      }
      paramView.setOnLongClickListener(null);
      bhga.a(paramView, false);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkf
 * JD-Core Version:    0.7.0.1
 */