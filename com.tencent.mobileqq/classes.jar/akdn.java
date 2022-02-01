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

public class akdn
  extends RecyclerView.Adapter<akdm>
{
  private akdl jdField_a_of_type_Akdl;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  private List<List<akdl>> jdField_a_of_type_JavaUtilList;
  
  public akdn(@NonNull List<List<akdl>> paramList, View.OnClickListener paramOnClickListener)
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
    akgd.a(localTextView, 0.6F);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 30.0F)));
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 30.0F));
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(paramContext, 12.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(localTextView);
    localTextView.setId(2131374754);
    localObject = new View(paramContext);
    ((View)localObject).setBackgroundResource(2130847274);
    ((View)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = DisplayUtil.dip2px(paramContext, 9.2F);
    localLayoutParams.height = DisplayUtil.dip2px(paramContext, 8.9F);
    localLayoutParams.addRule(7, 2131374754);
    localLayoutParams.addRule(6, 2131374754);
    localRelativeLayout.setTag(2131374650, localTextView);
    localRelativeLayout.setTag(2131374651, localObject);
    return localRelativeLayout;
  }
  
  private void a(View paramView, akdl paramakdl)
  {
    TextView localTextView = (TextView)paramView.getTag(2131374650);
    paramView = (View)paramView.getTag(2131374651);
    localTextView.setText(paramakdl.jdField_a_of_type_JavaLangString);
    int i;
    if (paramakdl.jdField_a_of_type_Boolean)
    {
      i = 0;
      paramView.setVisibility(i);
      if ((!paramakdl.b) && ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramakdl.jdField_a_of_type_JavaLangString)))) {
        break label108;
      }
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130847200);
      this.jdField_a_of_type_JavaLangString = "";
    }
    for (;;)
    {
      localTextView.setTag(2131374653, paramakdl);
      return;
      i = 4;
      break;
      label108:
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130847199);
    }
  }
  
  public akdm a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    paramInt = DisplayUtil.dip2px(paramViewGroup.getContext(), 6.0F);
    localLinearLayout.setPadding(0, paramInt, 0, paramInt);
    return new akdm(localLinearLayout);
  }
  
  public void a(akdm paramakdm, int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    LinearLayout localLinearLayout = paramakdm.a;
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
      akdl localakdl = (akdl)localList.get(i);
      View localView = localLinearLayout.getChildAt(i);
      a(localView, localakdl);
      localView.setVisibility(0);
      i += 1;
    }
    while (j < localLinearLayout.getChildCount())
    {
      localLinearLayout.getChildAt(j).setVisibility(8);
      j += 1;
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramakdm, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Akdl != null) {
      this.jdField_a_of_type_Akdl.b = false;
    }
    paramView = (akdl)paramView.getTag(2131374653);
    paramView.b = true;
    this.jdField_a_of_type_Akdl = paramView;
    notifyDataSetChanged();
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(@NonNull List<List<akdl>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Akdl != null)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((List)paramList.next()).iterator();
        while (localIterator.hasNext())
        {
          akdl localakdl = (akdl)localIterator.next();
          if (TextUtils.equals(localakdl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Akdl.jdField_a_of_type_JavaLangString))
          {
            localakdl.b = true;
            this.jdField_a_of_type_Akdl = localakdl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdn
 * JD-Core Version:    0.7.0.1
 */