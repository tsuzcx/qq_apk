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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class akzg
  extends RecyclerView.Adapter<akzf>
{
  private akze jdField_a_of_type_Akze;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  private List<List<akze>> jdField_a_of_type_JavaUtilList;
  
  public akzg(@NonNull List<List<akze>> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private View a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 13.0F);
    localTextView.setGravity(16);
    int i = DisplayUtil.dip2px(paramContext, 13.0F);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    albw.a(localTextView, 0.6F);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 30.0F)));
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 30.0F));
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(paramContext, 12.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(localTextView);
    localTextView.setId(2131374995);
    localObject = new View(paramContext);
    ((View)localObject).setBackgroundResource(2130847361);
    ((View)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = DisplayUtil.dip2px(paramContext, 9.2F);
    localLayoutParams.height = DisplayUtil.dip2px(paramContext, 8.9F);
    localLayoutParams.addRule(7, 2131374995);
    localLayoutParams.addRule(6, 2131374995);
    localRelativeLayout.setTag(2131374891, localTextView);
    localRelativeLayout.setTag(2131374892, localObject);
    return localRelativeLayout;
  }
  
  private void a(View paramView, akze paramakze)
  {
    TextView localTextView = (TextView)paramView.getTag(2131374891);
    paramView = (View)paramView.getTag(2131374892);
    localTextView.setText(paramakze.jdField_a_of_type_JavaLangString);
    int i;
    if (paramakze.jdField_a_of_type_Boolean)
    {
      i = 0;
      paramView.setVisibility(i);
      if ((!paramakze.b) && ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramakze.jdField_a_of_type_JavaLangString)))) {
        break label108;
      }
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130847298);
      this.jdField_a_of_type_JavaLangString = "";
    }
    for (;;)
    {
      localTextView.setTag(2131374894, paramakze);
      return;
      i = 4;
      break;
      label108:
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130847297);
    }
  }
  
  public akzf a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    paramInt = DisplayUtil.dip2px(paramViewGroup.getContext(), 6.0F);
    localLinearLayout.setPadding(0, paramInt, 0, paramInt);
    return new akzf(localLinearLayout);
  }
  
  public void a(akzf paramakzf, int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    LinearLayout localLinearLayout = paramakzf.a;
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
      akze localakze = (akze)localList.get(i);
      View localView = localLinearLayout.getChildAt(i);
      a(localView, localakze);
      localView.setVisibility(0);
      i += 1;
    }
    while (j < localLinearLayout.getChildCount())
    {
      localLinearLayout.getChildAt(j).setVisibility(8);
      j += 1;
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramakzf, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Akze != null) {
      this.jdField_a_of_type_Akze.b = false;
    }
    paramView = (akze)paramView.getTag(2131374894);
    paramView.b = true;
    this.jdField_a_of_type_Akze = paramView;
    notifyDataSetChanged();
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(@NonNull List<List<akze>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Akze != null)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((List)paramList.next()).iterator();
        while (localIterator.hasNext())
        {
          akze localakze = (akze)localIterator.next();
          if (TextUtils.equals(localakze.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Akze.jdField_a_of_type_JavaLangString))
          {
            localakze.b = true;
            this.jdField_a_of_type_Akze = localakze;
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
 * Qualified Name:     akzg
 * JD-Core Version:    0.7.0.1
 */