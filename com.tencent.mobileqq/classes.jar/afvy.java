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
import java.util.ArrayList;
import java.util.List;

public class afvy
  extends BaseAdapter
{
  private afwa jdField_a_of_type_Afwa;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public afvy(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(afwa paramafwa)
  {
    this.jdField_a_of_type_Afwa = paramafwa;
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
    Object localObject = getItem(paramInt);
    if ((localObject instanceof String)) {
      if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
      {
        paramViewGroup = (TextView)paramView.getTag();
        paramViewGroup.setText((String)localObject);
        localView = paramView;
      }
    }
    do
    {
      return localView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560472, paramViewGroup, false);
      paramViewGroup = (TextView)paramView.findViewById(2131377045);
      paramView.setTag(paramViewGroup);
      break;
      localView = paramView;
    } while (!(localObject instanceof TencentDocItem));
    localView = paramView;
    for (;;)
    {
      try
      {
        TencentDocItem localTencentDocItem = (TencentDocItem)localObject;
        if (paramView != null)
        {
          localView = paramView;
          if ((paramView.getTag() instanceof afvz))
          {
            localView = paramView;
            paramViewGroup = (afvz)paramView.getTag();
          }
        }
        try
        {
          paramView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTencentDocItem = localTencentDocItem;
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTencentDocItem.mTitle);
          agbj.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTencentDocItem.mIcon);
          if (this.jdField_a_of_type_Boolean)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            boolean bool1 = bool2;
            if (this.jdField_a_of_type_Afwa != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_Afwa.a(localTencentDocItem)) {
                bool1 = true;
              }
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool1);
            paramViewGroup.b.setText(localTencentDocItem.mDescription);
            return paramView;
            localView = paramView;
            localObject = new afvz();
            localView = paramView;
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560449, paramViewGroup, false);
            localView = paramView;
            ((afvz)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366225));
            localView = paramView;
            ((afvz)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366211));
            localView = paramView;
            ((afvz)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366223));
            localView = paramView;
            ((afvz)localObject).b = ((TextView)paramView.findViewById(2131366209));
            localView = paramView;
            ((afvz)localObject).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
            localView = paramView;
            ((afvz)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            localView = paramView;
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView = paramView;
            paramView.setTag(localObject);
            paramViewGroup = (ViewGroup)localObject;
          }
          else
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
            continue;
            QLog.e("ChatHistoryBaseTenDocAdapter", 4, "getView failed", paramViewGroup);
          }
        }
        catch (Exception paramViewGroup) {}
      }
      catch (Exception paramViewGroup)
      {
        paramView = localView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvy
 * JD-Core Version:    0.7.0.1
 */