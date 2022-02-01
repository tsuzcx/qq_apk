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

public class aauz
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<aujx> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public aauz(List<aujx> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<aujx> paramList)
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
    aavb localaavb;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560938, null);
      localaavb = new aavb();
      localaavb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366629));
      localaavb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366632));
      localaavb.b = ((TextView)paramView.findViewById(2131366635));
      localaavb.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376654);
      paramView.setTag(localaavb);
      paramView.setOnClickListener(new aava(this));
    }
    for (;;)
    {
      localaavb = (aavb)paramView.getTag();
      aujx localaujx = (aujx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localaujx.jdField_a_of_type_Boolean)
      {
        localaavb.b.setText(anzj.a(2131715818));
        localaavb.jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(localaujx.jdField_a_of_type_JavaLangString));
        localaavb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844292);
        localaavb.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        localaavb.jdField_a_of_type_Aujx = localaujx;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localaavb.b.setText(auog.a(localaujx.jdField_a_of_type_Long));
        localaavb.jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(localaujx.jdField_a_of_type_JavaLangString));
        aunj.a(localaavb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localaujx.jdField_a_of_type_JavaLangString);
        localaavb.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (aunj.a(localaujx.jdField_a_of_type_JavaLangString) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(localaujx.b);
          localFileManagerEntity.isZipInnerFile = true;
          aunj.b(localaavb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.a().c(localFileManagerEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauz
 * JD-Core Version:    0.7.0.1
 */