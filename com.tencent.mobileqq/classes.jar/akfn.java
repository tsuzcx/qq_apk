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

public class akfn
  extends atjm
{
  private akfp jdField_a_of_type_Akfp;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  
  public akfn(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(akfo paramakfo, FileManagerEntity paramFileManagerEntity)
  {
    if (aunj.a(paramFileManagerEntity.fileName) == 0)
    {
      if (bhmi.b(paramFileManagerEntity.getFilePath()))
      {
        aunj.a(paramakfo.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (bhmi.b(paramFileManagerEntity.strThumbPath))
      {
        paramakfo.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844316);
        paramakfo.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      aunj.a(paramakfo.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    aunj.a(paramakfo.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(akfo paramakfo, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramakfo.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramakfo.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = auog.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramakfo.jdField_a_of_type_Int = 0;
        return;
      }
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramakfo.jdField_a_of_type_Int = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramakfo.jdField_a_of_type_Int = 0;
      return;
    case 4: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramakfo.jdField_a_of_type_Int = 1;
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      return;
    case -1: 
    case 13: 
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramakfo.jdField_a_of_type_Int = 1;
      return;
    }
    paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
    paramakfo.jdField_a_of_type_Int = 2;
  }
  
  private void c(akfo paramakfo, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramakfo.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramakfo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramakfo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_Akfp != null)
      {
        bool = this.jdField_a_of_type_Akfp.a(paramFileManagerEntity);
        this.jdField_a_of_type_Akfp.b(paramFileManagerEntity);
      }
      paramakfo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramakfo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(akfp paramakfp)
  {
    this.jdField_a_of_type_Akfp = paramakfp;
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
    if ((paramView != null) && ((paramView.getTag() instanceof akfo)))
    {
      akfo localakfo = (akfo)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localakfo;
    }
    for (;;)
    {
      aunj.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        aunj.b(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      aunj.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new akfo(this);
      paramViewGroup = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131560873, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376255));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361941));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366617));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366604));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366615));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366602));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(agej.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), agej.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfn
 * JD-Core Version:    0.7.0.1
 */