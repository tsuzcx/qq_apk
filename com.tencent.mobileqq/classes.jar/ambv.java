import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ambv
  extends BaseAdapter
{
  advt jdField_a_of_type_Advt;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public ArrayList<Object> a;
  View.OnClickListener b;
  
  public ambv(Context paramContext, ArrayList<Object> paramArrayList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, advt paramadvt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_Advt = paramadvt;
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramString.equals("cover"))
    {
      localObject1 = paramAbsShareMsg.mContentCover;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
          localObject2 = localObject1;
          if (paramAbsShareMsg.mStructMsgItemLists != null)
          {
            localObject2 = localObject1;
            if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
            {
              Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
              paramAbsShareMsg = (AbsShareMsg)localObject1;
              if (!localIterator.hasNext()) {
                return paramAbsShareMsg;
              }
              localObject2 = (bcvs)localIterator.next();
              if (!(localObject2 instanceof bcvt)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((bcvt)localObject2).jdField_a_of_type_JavaUtilArrayList == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((bcvt)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label248;
              }
              localObject2 = ((bcvt)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (bcvs)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label206;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label248;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label206:
    label214:
    label228:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label176;
      if (!paramString.equals("cover")) {
        break label240;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((bcvs)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((bcvs)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      Object localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if (localObject == null) {
        ((MessageForStructing)paramMessageRecord).parse();
      }
      if (njo.a(paramMessageRecord)) {
        return false;
      }
      if (localObject != null)
      {
        if ((((AbsStructMsg)localObject).fwFlag == 1) || (((AbsStructMsg)localObject).hasFlag(1))) {
          return false;
        }
        if ((localObject instanceof StructMsgForAudioShare)) {
          return true;
        }
        if ((localObject instanceof StructMsgForGeneralShare))
        {
          paramMessageRecord = a((StructMsgForGeneralShare)localObject, "cover");
          localObject = a((StructMsgForGeneralShare)localObject, "title");
          if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    String str = a(paramAbsShareMsg, "cover");
    int i = 2130850447;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130850457;
    }
    localObject = ((Resources)localObject).getDrawable(i);
    if (TextUtils.isEmpty(str))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if ((!str.startsWith("http://")) && (!str.startsWith("https://"))) {}
    for (paramAbsShareMsg = Uri.fromFile(new File(str)).toString();; paramAbsShareMsg = str)
    {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject, (Drawable)localObject));
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject2 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof ambw)))
      {
        localObject1 = (ambw)paramView.getTag();
        ((ambw)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
        ((ambw)localObject1).jdField_a_of_type_JavaLangString = ((advr)this.jdField_a_of_type_Advt).c;
        if (!(localObject2 instanceof MessageForStructing)) {
          break label336;
        }
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((ambw)localObject1).jdField_a_of_type_ComTencentImageURLImageView, localAbsShareMsg);
          ((ambw)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(a(localAbsShareMsg, "title"));
          ((ambw)localObject1).b.setText(localAbsShareMsg.mSourceName);
        }
        label153:
        if (!this.jdField_a_of_type_Advt.b()) {
          break label361;
        }
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Advt.a.a((ChatMessage)localObject2));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = new ambw(this);
        paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562914, null);
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376116));
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131377916));
        ((ambw)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377914));
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363645));
        ((ambw)localObject1).b = ((TextView)paramView.findViewById(2131371397));
        paramView.setTag(localObject1);
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
        label336:
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        ((ambw)localObject1).b.setText("");
        break label153;
        label361:
        ((ambw)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
    Object localObject1 = paramView;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof TextView))) {
        break label427;
      }
      localObject1 = (TextView)paramView.getTag();
    }
    for (;;)
    {
      ((TextView)localObject1).setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label427:
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562915, null);
      localObject1 = (TextView)paramView.findViewById(2131378459);
      paramView.setTag(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */