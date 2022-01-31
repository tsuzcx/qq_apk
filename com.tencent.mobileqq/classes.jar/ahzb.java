import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;

public class ahzb
  extends aqiz
{
  private ahzd jdField_a_of_type_Ahzd;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public ahzb(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(ahzc paramahzc, FileManagerEntity paramFileManagerEntity)
  {
    if (arni.a(paramFileManagerEntity.fileName) == 0)
    {
      if (bdcs.b(paramFileManagerEntity.getFilePath()))
      {
        arni.a(paramahzc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (bdcs.b(paramFileManagerEntity.strThumbPath))
      {
        paramahzc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843839);
        paramahzc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      arni.a(paramahzc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    arni.a(paramahzc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(ahzc paramahzc, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramahzc.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramahzc.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = arof.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramahzc.jdField_a_of_type_Int = 0;
        return;
      }
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramahzc.jdField_a_of_type_Int = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramahzc.jdField_a_of_type_Int = 0;
      return;
    case 4: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramahzc.jdField_a_of_type_Int = 1;
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      return;
    case -1: 
    case 13: 
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramahzc.jdField_a_of_type_Int = 1;
      return;
    }
    paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
    paramahzc.jdField_a_of_type_Int = 2;
  }
  
  private void c(ahzc paramahzc, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramahzc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramahzc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramahzc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_Ahzd != null) {
        bool = this.jdField_a_of_type_Ahzd.a(paramFileManagerEntity);
      }
      paramahzc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramahzc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(ahzd paramahzd)
  {
    this.jdField_a_of_type_Ahzd = paramahzd;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
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
    if ((paramView != null) && ((paramView.getTag() instanceof ahzc)))
    {
      ahzc localahzc = (ahzc)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localahzc;
    }
    for (;;)
    {
      arni.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        arni.c(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      arni.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new ahzc(this);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560624, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375336));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361889));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366313));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366299));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366311));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366297));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aekt.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzb
 * JD-Core Version:    0.7.0.1
 */