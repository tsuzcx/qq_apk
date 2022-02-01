import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aaqw
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<atsc> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public aaqw(List<atsc> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<atsc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, String paramString, short paramShort)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramString;
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aaqy localaaqy;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560907, null);
      localaaqy = new aaqy();
      localaaqy.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366579));
      localaaqy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366582));
      localaaqy.b = ((TextView)paramView.findViewById(2131366585));
      localaaqy.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376522);
      paramView.setTag(localaaqy);
      paramView.setOnClickListener(new aaqx(this));
    }
    for (;;)
    {
      localaaqy = (aaqy)paramView.getTag();
      atsc localatsc = (atsc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localatsc.jdField_a_of_type_Boolean)
      {
        localaaqy.b.setText(anni.a(2131715709));
        localaaqy.jdField_a_of_type_AndroidWidgetTextView.setText(atvo.d(localatsc.jdField_a_of_type_JavaLangString));
        localaaqy.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844278);
        localaaqy.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        localaaqy.jdField_a_of_type_Atsc = localatsc;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localaaqy.b.setText(atwl.a(localatsc.jdField_a_of_type_Long));
        localaaqy.jdField_a_of_type_AndroidWidgetTextView.setText(atvo.d(localatsc.jdField_a_of_type_JavaLangString));
        atvo.a(localaaqy.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localatsc.jdField_a_of_type_JavaLangString);
        localaaqy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (atvo.a(localatsc.jdField_a_of_type_JavaLangString) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(localatsc.b);
          localFileManagerEntity.isZipInnerFile = true;
          atvo.b(localaaqy.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.a().c(localFileManagerEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqw
 * JD-Core Version:    0.7.0.1
 */