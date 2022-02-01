import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class ahdx
  extends RecyclerView.Adapter<ahdz>
  implements View.OnClickListener, awnc<bgyp>
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2000, 2131694347, 0, 4 }, { 2001, 2131694349, 2130847053, 1 }, { 2002, 2131694348, 2130847052, 2 }, { 2003, 2131694346, 2130847050, 3 } };
  private int jdField_a_of_type_Int = 2000;
  private ahdy jdField_a_of_type_Ahdy;
  
  public ahdx(ahdy paramahdy)
  {
    this.jdField_a_of_type_Ahdy = paramahdy;
  }
  
  public static int a(int paramInt)
  {
    int k = 0;
    int[][] arrayOfInt = jdField_a_of_type_Array2dOfInt;
    int m = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        if (arrayOfInt1[0] == paramInt) {
          j = arrayOfInt1[3];
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ahdz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahdz(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562046, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_Array2dOfInt.length)
      {
        if (paramInt == jdField_a_of_type_Array2dOfInt[i][0])
        {
          this.jdField_a_of_type_Int = paramInt;
          if (this.jdField_a_of_type_Ahdy != null) {
            this.jdField_a_of_type_Ahdy.a(paramInt);
          }
          notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a(ahdz paramahdz, int paramInt)
  {
    boolean bool = true;
    int j = 0;
    Object localObject1 = jdField_a_of_type_Array2dOfInt[paramInt];
    int k = localObject1[0];
    int i = localObject1[2];
    paramahdz.jdField_a_of_type_AndroidWidgetTextView.setText(localObject1[1]);
    paramahdz.b.setImageResource(i);
    localObject1 = paramahdz.b;
    if (i != 0)
    {
      i = 0;
      ((ImageView)localObject1).setVisibility(i);
      localObject1 = (bgyp)BaseApplicationImpl.sImageCache.get(bhcb.a(k));
      paramahdz.jdField_a_of_type_AndroidWidgetImageView.setId(k);
      paramahdz.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      Object localObject2 = paramahdz.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 == null) {
        break label222;
      }
      label105:
      ((ImageView)localObject2).setClickable(bool);
      localObject2 = paramahdz.jdField_a_of_type_AndroidWidgetImageView;
      if (k != this.jdField_a_of_type_Int) {
        break label228;
      }
      i = 2130840485;
      label130:
      ((ImageView)localObject2).setImageResource(i);
      localObject2 = paramahdz.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject1 != null) {
        break label233;
      }
      i = j;
      label150:
      ((ProgressBar)localObject2).setVisibility(i);
      if (localObject1 == null) {
        break label239;
      }
      localObject2 = paramahdz.jdField_a_of_type_AndroidWidgetImageView.getResources();
      paramahdz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Resources)localObject2, (Bitmap)((bgyp)localObject1).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131372709))));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramahdz, paramInt, getItemId(paramInt));
      return;
      i = 8;
      break;
      label222:
      bool = false;
      break label105;
      label228:
      i = 0;
      break label130;
      label233:
      i = 8;
      break label150;
      label239:
      paramahdz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      new PobingDecoder(k, bhcb.jdField_a_of_type_JavaUtilHashMap, this);
    }
  }
  
  public void a(bgyp parambgyp)
  {
    BaseApplicationImpl.sImageCache.put(bhcb.a(parambgyp.jdField_a_of_type_Int), parambgyp);
    b(parambgyp.jdField_a_of_type_Int);
  }
  
  void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_Array2dOfInt.length)
      {
        if (paramInt == jdField_a_of_type_Array2dOfInt[i][0]) {
          notifyItemChanged(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return jdField_a_of_type_Array2dOfInt.length;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    a(i);
    bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A4F9", a(i), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdx
 * JD-Core Version:    0.7.0.1
 */