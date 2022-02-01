import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aagx
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<auao> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public aagx(List<auao> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<auao> paramList)
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
    aagz localaagz;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560878, null);
      localaagz = new aagz();
      localaagz.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366767));
      localaagz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366771));
      localaagz.b = ((TextView)paramView.findViewById(2131366774));
      localaagz.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376674);
      paramView.setTag(localaagz);
      paramView.setOnClickListener(new aagy(this));
    }
    for (;;)
    {
      localaagz = (aagz)paramView.getTag();
      auao localauao = (auao)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localauao.jdField_a_of_type_Boolean)
      {
        localaagz.b.setText(anvx.a(2131716400));
        localaagz.jdField_a_of_type_AndroidWidgetTextView.setText(auea.d(localauao.jdField_a_of_type_JavaLangString));
        localaagz.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844244);
        localaagz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        localaagz.jdField_a_of_type_Auao = localauao;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localaagz.b.setText(FileUtil.filesizeToString(localauao.jdField_a_of_type_Long));
        localaagz.jdField_a_of_type_AndroidWidgetTextView.setText(auea.d(localauao.jdField_a_of_type_JavaLangString));
        auea.a(localaagz.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localauao.jdField_a_of_type_JavaLangString);
        localaagz.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (auea.a(localauao.jdField_a_of_type_JavaLangString) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localauao.b);
          localFileManagerEntity.isZipInnerFile = true;
          auea.b(localaagz.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagx
 * JD-Core Version:    0.7.0.1
 */