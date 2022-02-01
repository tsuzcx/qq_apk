import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class akae
  extends BaseAdapter
{
  private akag jdField_a_of_type_Akag;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public akae(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(akag paramakag)
  {
    this.jdField_a_of_type_Akag = paramakag;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof String)) {
      if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
      {
        localObject1 = (TextView)paramView.getTag();
        ((TextView)localObject1).setText((String)localObject2);
      }
    }
    for (localObject1 = paramView;; localObject1 = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560897, paramViewGroup, false);
      localObject1 = (TextView)paramView.findViewById(2131378617);
      paramView.setTag(localObject1);
      break;
      if ((localObject2 instanceof TencentDocItem))
      {
        localObject1 = paramView;
        for (;;)
        {
          try
          {
            for (;;)
            {
              TencentDocItem localTencentDocItem = (TencentDocItem)localObject2;
              if (paramView != null)
              {
                localObject1 = paramView;
                if ((paramView.getTag() instanceof akaf))
                {
                  localObject1 = paramView;
                  localObject2 = (akaf)paramView.getTag();
                  localObject1 = localObject2;
                }
              }
              try
              {
                label154:
                paramView.setVisibility(0);
                ((akaf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTencentDocItem = localTencentDocItem;
                ((akaf)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localTencentDocItem.mTitle);
                akfw.a(((akaf)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTencentDocItem.mIcon);
                if (this.jdField_a_of_type_Boolean)
                {
                  ((akaf)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
                  boolean bool1 = bool2;
                  if (this.jdField_a_of_type_Akag != null)
                  {
                    bool1 = bool2;
                    if (this.jdField_a_of_type_Akag.a(localTencentDocItem)) {
                      bool1 = true;
                    }
                  }
                  ((akaf)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool1);
                }
                for (;;)
                {
                  ((akaf)localObject1).b.setText(localTencentDocItem.mDescription);
                  localObject2 = paramView;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break;
                  localObject1 = paramView;
                  localObject2 = new akaf();
                  localObject1 = paramView;
                  paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560873, paramViewGroup, false);
                  localObject1 = paramView;
                  ((akaf)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366617));
                  localObject1 = paramView;
                  ((akaf)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366604));
                  localObject1 = paramView;
                  ((akaf)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366615));
                  localObject1 = paramView;
                  ((akaf)localObject2).b = ((TextView)paramView.findViewById(2131366602));
                  localObject1 = paramView;
                  ((akaf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
                  localObject1 = paramView;
                  ((akaf)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  localObject1 = paramView;
                  paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  localObject1 = paramView;
                  paramView.setTag(localObject2);
                  localObject1 = localObject2;
                  break label154;
                  ((akaf)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
                }
                QLog.e("ChatHistoryBaseTenDocAdapter", 4, "getView failed", localException1);
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException2)
          {
            paramView = (View)localObject1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akae
 * JD-Core Version:    0.7.0.1
 */