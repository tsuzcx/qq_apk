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

public class ajue
  extends asti
{
  private ajug jdField_a_of_type_Ajug;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public ajue(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(ajuf paramajuf, FileManagerEntity paramFileManagerEntity)
  {
    if (atvo.a(paramFileManagerEntity.fileName) == 0)
    {
      if (bgmg.b(paramFileManagerEntity.getFilePath()))
      {
        atvo.a(paramajuf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (bgmg.b(paramFileManagerEntity.strThumbPath))
      {
        paramajuf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844302);
        paramajuf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      atvo.a(paramajuf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    atvo.a(paramajuf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(ajuf paramajuf, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajuf.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajuf.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = atwl.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramajuf.jdField_a_of_type_Int = 0;
        return;
      }
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajuf.jdField_a_of_type_Int = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramajuf.jdField_a_of_type_Int = 0;
      return;
    case 4: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajuf.jdField_a_of_type_Int = 1;
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      return;
    case -1: 
    case 13: 
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramajuf.jdField_a_of_type_Int = 1;
      return;
    }
    paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
    paramajuf.jdField_a_of_type_Int = 2;
  }
  
  private void c(ajuf paramajuf, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramajuf.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramajuf.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramajuf.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_Ajug != null)
      {
        bool = this.jdField_a_of_type_Ajug.a(paramFileManagerEntity);
        this.jdField_a_of_type_Ajug.b(paramFileManagerEntity);
      }
      paramajuf.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramajuf.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(ajug paramajug)
  {
    this.jdField_a_of_type_Ajug = paramajug;
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
    if ((paramView != null) && ((paramView.getTag() instanceof ajuf)))
    {
      ajuf localajuf = (ajuf)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localajuf;
    }
    for (;;)
    {
      atvo.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        atvo.b(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      atvo.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new ajuf(this);
      paramViewGroup = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131560842, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376115));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361941));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366568));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366555));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366566));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366553));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(afur.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), afur.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajue
 * JD-Core Version:    0.7.0.1
 */