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

public class aidq
  extends aqni
{
  private aids jdField_a_of_type_Aids;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public aidq(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(aidr paramaidr, FileManagerEntity paramFileManagerEntity)
  {
    if (arrr.a(paramFileManagerEntity.fileName) == 0)
    {
      if (bdhb.b(paramFileManagerEntity.getFilePath()))
      {
        arrr.a(paramaidr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (bdhb.b(paramFileManagerEntity.strThumbPath))
      {
        paramaidr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843911);
        paramaidr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      arrr.a(paramaidr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    arrr.a(paramaidr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(aidr paramaidr, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramaidr.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramaidr.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = arso.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramaidr.jdField_a_of_type_Int = 0;
        return;
      }
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramaidr.jdField_a_of_type_Int = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramaidr.jdField_a_of_type_Int = 0;
      return;
    case 4: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramaidr.jdField_a_of_type_Int = 1;
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      return;
    case -1: 
    case 13: 
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramaidr.jdField_a_of_type_Int = 1;
      return;
    }
    paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
    paramaidr.jdField_a_of_type_Int = 2;
  }
  
  private void c(aidr paramaidr, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramaidr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramaidr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramaidr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_Aids != null) {
        bool = this.jdField_a_of_type_Aids.a(paramFileManagerEntity);
      }
      paramaidr.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramaidr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(aids paramaids)
  {
    this.jdField_a_of_type_Aids = paramaids;
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
    if ((paramView != null) && ((paramView.getTag() instanceof aidr)))
    {
      aidr localaidr = (aidr)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localaidr;
    }
    for (;;)
    {
      arrr.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        arrr.c(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      arrr.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new aidr(this);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560642, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375387));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361889));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366315));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366301));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366313));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366299));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidq
 * JD-Core Version:    0.7.0.1
 */