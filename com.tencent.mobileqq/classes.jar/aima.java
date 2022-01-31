import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.List;

public class aima
  extends BaseAdapter
{
  private aasw jdField_a_of_type_Aasw;
  private aimc jdField_a_of_type_Aimc;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString = "ChatHistoryFileAdapter";
  private List<Object> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public aima(Context paramContext, List<Object> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, aasw paramaasw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_Aasw = paramaasw;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(aimc paramaimc)
  {
    this.jdField_a_of_type_Aimc = paramaimc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
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
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if ((localObject2 instanceof FileManagerEntity)) {
      localObject1 = paramView;
    }
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      boolean bool;
      try
      {
        localFileManagerEntity = (FileManagerEntity)localObject2;
        if (paramView != null)
        {
          localObject1 = paramView;
          if ((paramView.getTag() instanceof aimb))
          {
            localObject1 = paramView;
            paramViewGroup = (aimb)paramView.getTag();
            localObject1 = paramView;
            apug.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
            localObject1 = paramView;
            if (apug.a(localFileManagerEntity.fileName) != 0) {
              break label732;
            }
            localObject1 = paramView;
            if (!bbdx.b(localFileManagerEntity.getFilePath())) {
              break label665;
            }
            localObject1 = paramView;
            apug.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
            localObject1 = paramView;
            if (5 != localFileManagerEntity.cloudType)
            {
              localObject1 = paramView;
              apug.c(localFileManagerEntity);
            }
            localObject1 = paramView;
          }
        }
        switch (localFileManagerEntity.status)
        {
        case 16: 
        case 17: 
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          if (!this.jdField_a_of_type_Boolean) {
            break label1146;
          }
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          localObject1 = paramView;
          if (this.jdField_a_of_type_Aimc == null) {
            break label1239;
          }
          localObject1 = paramView;
          bool = this.jdField_a_of_type_Aimc.a(localFileManagerEntity);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
          localObject1 = paramView;
          apug.a(paramViewGroup.b, localFileManagerEntity);
          return paramView;
          localObject1 = paramView;
          localObject2 = new aimb(this);
          localObject1 = paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560449, paramViewGroup, false);
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374868));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361889));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366225));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366211));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366223));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          localObject1 = paramView;
          ((aimb)localObject2).b = ((TextView)paramView.findViewById(2131366209));
          localObject1 = paramView;
          ((aimb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localObject1 = paramView;
          paramView.setTag(localObject2);
          paramViewGroup = (ViewGroup)localObject2;
          continue;
          localObject1 = paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return localObject1;
      }
      label665:
      if (bbdx.b(localFileManagerEntity.strThumbPath))
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843480);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strThumbPath);
      }
      else
      {
        localObject1 = paramView;
        apug.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
        continue;
        label732:
        localObject1 = paramView;
        apug.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 2;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 3;
        continue;
        localObject1 = paramView;
        bool = apvd.a(localFileManagerEntity.getFilePath());
        localObject1 = paramView;
        if (localFileManagerEntity.getCloudType() != 3)
        {
          localObject1 = paramView;
          if ((localFileManagerEntity.getCloudType() != 5) && (!bool)) {}
        }
        else
        {
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_Int = 0;
          continue;
        }
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 3;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 1;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 2;
        continue;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        label1146:
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
        if (!(localObject2 instanceof String)) {
          break;
        }
        if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
        {
          localObject1 = (TextView)paramView.getTag();
          paramViewGroup = paramView;
          paramView = (View)localObject1;
        }
        for (;;)
        {
          paramView.setText((String)localObject2);
          return paramViewGroup;
          paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560472, null);
          paramView = (TextView)paramViewGroup.findViewById(2131377045);
          paramViewGroup.setTag(paramView);
        }
        label1239:
        bool = false;
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aima
 * JD-Core Version:    0.7.0.1
 */