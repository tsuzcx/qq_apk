import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class alig
  extends BaseAdapter
{
  private aczw jdField_a_of_type_Aczw;
  private alii jdField_a_of_type_Alii;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString = "ChatHistoryFileAdapter";
  private List<Object> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public alig(Context paramContext, List<Object> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, aczw paramaczw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_Aczw = paramaczw;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(alii paramalii)
  {
    this.jdField_a_of_type_Alii = paramalii;
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
    if ((localObject2 instanceof FileManagerEntity))
    {
      localObject1 = paramView;
      try
      {
        localFileManagerEntity = (FileManagerEntity)localObject2;
        if (paramView == null) {
          break label465;
        }
        localObject1 = paramView;
        if (!(paramView.getTag() instanceof alih)) {
          break label465;
        }
        localObject1 = paramView;
        localObject2 = (alih)paramView.getTag();
        localObject1 = paramView;
        aszt.a(((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_JavaLangObject = localFileManagerEntity;
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localObject2);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
        localObject1 = paramView;
        if (aszt.a(localFileManagerEntity.fileName) != 0) {
          break label763;
        }
        localObject1 = paramView;
        if (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          break label693;
        }
        localObject1 = paramView;
        aszt.a(((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          FileManagerEntity localFileManagerEntity;
          paramView.printStackTrace();
          paramView = (View)localObject1;
          continue;
          localObject1 = paramView;
          if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))
          {
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844201);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strThumbPath);
          }
          else
          {
            localObject1 = paramView;
            aszt.a(((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
            continue;
            localObject1 = paramView;
            aszt.a(((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 2;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 3;
            continue;
            localObject1 = paramView;
            bool = FileUtil.isFileExists(localFileManagerEntity.getFilePath());
            localObject1 = paramView;
            if (localFileManagerEntity.getCloudType() != 3)
            {
              localObject1 = paramView;
              if ((localFileManagerEntity.getCloudType() != 5) && (!bool)) {}
            }
            else
            {
              localObject1 = paramView;
              ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
              localObject1 = paramView;
              ((alih)localObject2).jdField_a_of_type_Int = 0;
              continue;
            }
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 1;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 3;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 0;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 1;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 0;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 0;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 1;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 2;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_Int = 1;
            continue;
            localObject1 = paramView;
            ((alih)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
        }
      }
      localObject1 = paramView;
      ((alih)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      localObject1 = paramView;
      if (5 != localFileManagerEntity.cloudType)
      {
        localObject1 = paramView;
        aszt.b(localFileManagerEntity);
      }
      localObject1 = paramView;
      switch (localFileManagerEntity.status)
      {
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      localObject1 = paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localObject1 = paramView;
        if (this.jdField_a_of_type_Alii == null) {
          break label1312;
        }
        localObject1 = paramView;
      }
      label1312:
      for (boolean bool = this.jdField_a_of_type_Alii.a(localFileManagerEntity);; bool = false)
      {
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        localObject1 = paramView;
        aszt.a(((alih)localObject2).b, localFileManagerEntity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label465:
        localObject1 = paramView;
        localObject2 = new alih(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560753, paramViewGroup, false);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376021));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361941));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366644));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366631));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366642));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject1 = paramView;
        ((alih)localObject2).b = ((TextView)paramView.findViewById(2131366629));
        localObject1 = paramView;
        ((alih)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        break;
        label693:
        label763:
        localObject1 = paramView;
        if ((localObject2 instanceof String))
        {
          if ((paramView == null) || (!(paramView.getTag() instanceof TextView))) {
            break label1279;
          }
          localObject1 = (TextView)paramView.getTag();
        }
        for (;;)
        {
          ((TextView)localObject1).setText((String)localObject2);
          localObject1 = paramView;
          paramView = (View)localObject1;
          break;
          label1279:
          paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560777, null);
          localObject1 = (TextView)paramView.findViewById(2131378381);
          paramView.setTag(localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alig
 * JD-Core Version:    0.7.0.1
 */