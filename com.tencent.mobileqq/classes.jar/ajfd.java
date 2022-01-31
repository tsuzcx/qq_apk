import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class ajfd
  extends TroopFeedViewFactory.ViewProvider
{
  public ajfd(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130969843, null);
    }
    ajfe localajfe = (ajfe)localView3.getTag();
    if (localajfe == null)
    {
      localajfe = new ajfe(this);
      localajfe.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131366616));
      localajfe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131363360));
      localajfe.b = ((TextView)localView3.findViewById(2131363039));
      localajfe.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131368224));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localajfe);
    }
    for (;;)
    {
      localajfe.jdField_a_of_type_Int = paramInt;
      localajfe.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localajfe.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localajfe.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localajfe.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localajfe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localajfe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localajfe.b.setVisibility(0);
      localajfe.b.setSingleLine(false);
      localajfe.b.setMaxLines(2);
      localajfe.b.setText("");
      localajfe.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localajfe.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841196);
        }
        paramView = this.a.b;
        if (StringUtil.a(paramTroopFeedItem.picPath)) {
          break label1146;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = AIOUtils.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          Object localObject;
          if (!paramTroopFeedItem.isStoryType())
          {
            localObject = str;
            if (paramTroopFeedItem.type != 5)
            {
              localObject = str;
              if (paramTroopFeedItem.type != 19)
              {
                localObject = str;
                if (paramTroopFeedItem.type == 99) {}
              }
            }
          }
          else
          {
            paramView = str;
            if (!StringUtil.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localajfe.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362876)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!StringUtil.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = " 发表于 " + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localajfe.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368225)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localajfe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localajfe.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
                }
                localView3.setContentDescription(paramTroopFeedItem);
                return localView3;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localView2 = paramView;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + paramTroopFeedItem.feedTime);
                localView2 = paramView;
              }
              if (paramTroopFeedItem.type == 132)
              {
                if (this.a.c == null) {
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841198);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841196);
              }
              paramView = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          View localView2;
          paramInt = 0;
          continue;
          if ((paramTroopFeedItem.type == 5) || (paramTroopFeedItem.type == 19))
          {
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localajfe.b.setText(paramTroopFeedItem.content);
            localajfe.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localajfe.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841201);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841200);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localajfe.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localajfe.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals("群日历"))
          {
            localajfe.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localajfe.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
          }
          paramView = localView2 + " " + paramTroopFeedItem.content;
          continue;
        }
        label1146:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajfd
 * JD-Core Version:    0.7.0.1
 */