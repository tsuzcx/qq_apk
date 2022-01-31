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
import java.util.HashMap;

public class afsm
  extends RecyclerView.Adapter<afso>
  implements View.OnClickListener, aubp<bdpd>
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2000, 2131695371, 0, 4 }, { 2001, 2131695373, 2130846538, 1 }, { 2002, 2131695372, 2130846537, 2 }, { 2003, 2131695370, 2130846536, 3 } };
  private int jdField_a_of_type_Int = 2000;
  private afsn jdField_a_of_type_Afsn;
  
  public afsm(afsn paramafsn)
  {
    this.jdField_a_of_type_Afsn = paramafsn;
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
  
  public afso a(ViewGroup paramViewGroup, int paramInt)
  {
    return new afso(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561785, paramViewGroup, false));
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
          if (this.jdField_a_of_type_Afsn != null) {
            this.jdField_a_of_type_Afsn.a(paramInt);
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
  
  public void a(afso paramafso, int paramInt)
  {
    boolean bool = true;
    int i = 0;
    Object localObject1 = jdField_a_of_type_Array2dOfInt[paramInt];
    int j = localObject1[0];
    paramInt = localObject1[2];
    paramafso.jdField_a_of_type_AndroidWidgetTextView.setText(localObject1[1]);
    paramafso.b.setImageResource(paramInt);
    localObject1 = paramafso.b;
    Object localObject2;
    if (paramInt != 0)
    {
      paramInt = 0;
      ((ImageView)localObject1).setVisibility(paramInt);
      localObject1 = (bdpd)BaseApplicationImpl.sImageCache.get(bdse.a(j));
      paramafso.jdField_a_of_type_AndroidWidgetImageView.setId(j);
      paramafso.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localObject2 = paramafso.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 == null) {
        break label207;
      }
      label104:
      ((ImageView)localObject2).setClickable(bool);
      localObject2 = paramafso.jdField_a_of_type_AndroidWidgetImageView;
      if (j != this.jdField_a_of_type_Int) {
        break label213;
      }
      paramInt = 2130840305;
      label129:
      ((ImageView)localObject2).setImageResource(paramInt);
      localObject2 = paramafso.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject1 != null) {
        break label218;
      }
    }
    label207:
    label213:
    label218:
    for (paramInt = i;; paramInt = 8)
    {
      ((ProgressBar)localObject2).setVisibility(paramInt);
      if (localObject1 == null) {
        break label224;
      }
      localObject2 = paramafso.jdField_a_of_type_AndroidWidgetImageView.getResources();
      paramafso.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Resources)localObject2, (Bitmap)((bdpd)localObject1).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131372111))));
      return;
      paramInt = 8;
      break;
      bool = false;
      break label104;
      paramInt = 0;
      break label129;
    }
    label224:
    paramafso.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    new PobingDecoder(j, bdse.jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(bdpd parambdpd)
  {
    BaseApplicationImpl.sImageCache.put(bdse.a(parambdpd.jdField_a_of_type_Int), parambdpd);
    b(parambdpd.jdField_a_of_type_Int);
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
    azmj.b(null, "dc00898", "", "", "qq_vip", "0X800A4F9", a(i), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsm
 * JD-Core Version:    0.7.0.1
 */