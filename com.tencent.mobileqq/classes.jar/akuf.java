import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class akuf
  extends RecyclerView.Adapter<akue>
{
  private akud jdField_a_of_type_Akud;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<List<akud>> jdField_a_of_type_JavaUtilList;
  
  public akuf(@NonNull List<List<akud>> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private View a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 13.0F);
    localTextView.setGravity(16);
    int i = bggq.a(paramContext, 13.0F);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    akww.a(localTextView, 0.6F);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, bggq.a(paramContext, 30.0F)));
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new LinearLayout.LayoutParams(-2, bggq.a(paramContext, 30.0F));
    ((LinearLayout.LayoutParams)localObject).leftMargin = bggq.a(paramContext, 12.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(localTextView);
    localTextView.setId(2131374852);
    localObject = new View(paramContext);
    ((View)localObject).setBackgroundResource(2130847348);
    ((View)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = bggq.a(paramContext, 9.2F);
    localLayoutParams.height = bggq.a(paramContext, 8.9F);
    localLayoutParams.addRule(7, 2131374852);
    localLayoutParams.addRule(6, 2131374852);
    localRelativeLayout.setTag(2131374748, localTextView);
    localRelativeLayout.setTag(2131374749, localObject);
    return localRelativeLayout;
  }
  
  private void a(View paramView, akud paramakud)
  {
    TextView localTextView = (TextView)paramView.getTag(2131374748);
    paramView = (View)paramView.getTag(2131374749);
    localTextView.setText(paramakud.jdField_a_of_type_JavaLangString);
    int i;
    if (paramakud.jdField_a_of_type_Boolean)
    {
      i = 0;
      paramView.setVisibility(i);
      if (!paramakud.b) {
        break label78;
      }
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130847275);
    }
    for (;;)
    {
      localTextView.setTag(2131374751, paramakud);
      return;
      i = 4;
      break;
      label78:
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130847274);
    }
  }
  
  public akue a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    paramInt = bggq.a(paramViewGroup.getContext(), 6.0F);
    localLinearLayout.setPadding(0, paramInt, 0, paramInt);
    return new akue(localLinearLayout);
  }
  
  public void a(akue paramakue, int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    LinearLayout localLinearLayout = paramakue.a;
    while (localLinearLayout.getChildCount() < localList.size()) {
      localLinearLayout.addView(a(localLinearLayout.getContext()));
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= localList.size()) {
        break;
      }
      akud localakud = (akud)localList.get(i);
      View localView = localLinearLayout.getChildAt(i);
      a(localView, localakud);
      localView.setVisibility(0);
      i += 1;
    }
    while (j < localLinearLayout.getChildCount())
    {
      localLinearLayout.getChildAt(j).setVisibility(8);
      j += 1;
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramakue, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    paramView = (akud)paramView.getTag(2131374751);
    paramView.b = true;
    if (this.jdField_a_of_type_Akud != null) {
      this.jdField_a_of_type_Akud.b = false;
    }
    this.jdField_a_of_type_Akud = paramView;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull List<List<akud>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Akud != null)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((List)paramList.next()).iterator();
        while (localIterator.hasNext())
        {
          akud localakud = (akud)localIterator.next();
          if (TextUtils.equals(localakud.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Akud.jdField_a_of_type_JavaLangString))
          {
            localakud.b = true;
            this.jdField_a_of_type_Akud = localakud;
          }
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */