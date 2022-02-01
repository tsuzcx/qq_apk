import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;

public class ajwc
  extends atab
{
  private ajwe jdField_a_of_type_Ajwe;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public ajwc(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(ajwd paramajwd, FileManagerEntity paramFileManagerEntity)
  {
    if (auea.a(paramFileManagerEntity.fileName) == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        auea.a(paramajwd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath))
      {
        paramajwd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844268);
        paramajwd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      auea.a(paramajwd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    auea.a(paramajwd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(ajwd paramajwd, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajwd.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajwd.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = FileUtil.isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramajwd.jdField_a_of_type_Int = 0;
        return;
      }
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajwd.jdField_a_of_type_Int = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramajwd.jdField_a_of_type_Int = 0;
      return;
    case 4: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajwd.jdField_a_of_type_Int = 1;
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      return;
    case -1: 
    case 13: 
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajwd.jdField_a_of_type_Int = 1;
      return;
    }
    paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
    paramajwd.jdField_a_of_type_Int = 2;
  }
  
  private void c(ajwd paramajwd, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramajwd.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramajwd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramajwd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_Ajwe != null)
      {
        bool = this.jdField_a_of_type_Ajwe.a(paramFileManagerEntity);
        this.jdField_a_of_type_Ajwe.b(paramFileManagerEntity);
      }
      paramajwd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramajwd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(ajwe paramajwe)
  {
    this.jdField_a_of_type_Ajwe = paramajwe;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)getChild(paramInt1, paramInt2);
    if ((paramView != null) && ((paramView.getTag() instanceof ajwd)))
    {
      ajwd localajwd = (ajwd)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localajwd;
    }
    for (;;)
    {
      auea.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        auea.b(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      auea.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new ajwd(this);
      paramViewGroup = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131560813, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376268));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361943));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366755));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366742));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366753));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366740));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.dp2px(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwc
 * JD-Core Version:    0.7.0.1
 */