import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class afxg
  extends BaseAdapter
{
  private agbd jdField_a_of_type_Agbd;
  private ajxl jdField_a_of_type_Ajxl;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ChatHistoryC2CLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public ArrayList<Object> a;
  View.OnClickListener b;
  
  public afxg(Context paramContext, ArrayList<Object> paramArrayList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, agbd paramagbd)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment = paramChatHistoryC2CLinkFragment;
    this.jdField_a_of_type_Agbd = paramagbd;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
    this.jdField_a_of_type_Ajxl = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app.getManager(51));
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
              localObject2 = (axup)localIterator.next();
              if (!(localObject2 instanceof axuq)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((axuq)localObject2).jdField_a_of_type_JavaUtilArrayList == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((axuq)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label248;
              }
              localObject2 = ((axuq)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (axup)((Iterator)localObject2).next();
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
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((axup)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((axup)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = ChatHistoryC2CLinkFragment.a.matcher(paramString);
      if (localMatcher.find()) {
        return paramString.substring(localMatcher.start(), localMatcher.end());
      }
    }
    return "";
  }
  
  private void a(afxj paramafxj, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {}
    for (;;)
    {
      try
      {
        Object localObject = ((MessageForArkApp)paramMessageRecord).getPreview();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          break label374;
        }
        String str2;
        TextView localTextView;
        QLog.e("Q.history.C2CLinkAdapter", 1, localException1, new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          a(afxj.a(paramafxj), (String)localObject);
          i = 1;
          if (i == 0) {
            afxj.a(paramafxj).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849354));
          }
          str1 = a(agbe.a(paramMessageRecord));
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label300;
          }
          str2 = ((MessageForArkApp)paramMessageRecord).getTitle();
          localTextView = afxj.a(paramafxj);
          localObject = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject = str1;
          }
          localTextView.setText((CharSequence)localObject);
          localObject = new Date(paramMessageRecord.time * 1000L);
          localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
          afxj.b(paramafxj).setText((CharSequence)localObject);
          afxj.c(paramafxj).setText(bbcz.m(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app, paramMessageRecord.senderuin));
          afxj.a(paramafxj).setOnClickListener(new afxh(this, str1, paramafxj, paramMessageRecord));
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
            break label312;
          }
          afxj.a(paramafxj).setVisibility(0);
          bool = this.jdField_a_of_type_Agbd.a(paramMessageRecord);
          afxj.a(paramafxj).setChecked(bool);
          paramMessageRecord = (LinearLayout.LayoutParams)afxj.a(paramafxj).getLayoutParams();
          paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, vzl.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramMessageRecord.bottomMargin);
          afxj.a(paramafxj).setLayoutParams(paramMessageRecord);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            String str1;
            i = 1;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      continue;
      label300:
      afxj.a(paramafxj).setText(str1);
      continue;
      label312:
      afxj.a(paramafxj).setVisibility(8);
      paramMessageRecord = (LinearLayout.LayoutParams)afxj.a(paramafxj).getLayoutParams();
      paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, vzl.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramMessageRecord.bottomMargin);
      afxj.a(paramafxj).setLayoutParams(paramMessageRecord);
      return;
      label374:
      int i = 0;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130849354);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bavw.b(localLayoutParams.width, localLayoutParams.height, vzl.a(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(bavw.i);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = a(paramAbsShareMsg, "cover");
    int i = 2130849354;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130849363;
    }
    localObject2 = ((Resources)localObject2).getDrawable(i);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject2);
      return;
    }
    if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {}
    for (paramAbsShareMsg = Uri.fromFile(new File((String)localObject1)).toString();; paramAbsShareMsg = (AbsShareMsg)localObject1)
    {
      paramAbsShareMsg = URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject2, (Drawable)localObject2);
      localObject1 = paramURLImageView.getLayoutParams();
      paramAbsShareMsg.setTag(bavw.b(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, vzl.a(this.jdField_a_of_type_AndroidContentContext, 6.0F)));
      paramAbsShareMsg.setDecodeHandler(bavw.i);
      paramURLImageView.setImageDrawable(paramAbsShareMsg);
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
    Object localObject1;
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof afxi)))
      {
        paramViewGroup = (afxi)paramView.getTag();
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
        paramViewGroup.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.d;
        if (!(localObject1 instanceof MessageForStructing)) {
          break label370;
        }
        if (localObject1 == null) {
          ((MessageForStructing)localObject1).parse();
        }
        if ((((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
        {
          localObject2 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
          a(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, (AbsShareMsg)localObject2);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(a((AbsShareMsg)localObject2, "title"));
          localObject2 = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app, ((MessageForStructing)localObject1).senderuin);
          paramViewGroup.b.setText((CharSequence)localObject2);
          localObject2 = new Date(((MessageForStructing)localObject1).time * 1000L);
          localObject2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject2);
          paramViewGroup.c.setText((CharSequence)localObject2);
        }
        label200:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
          break label391;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Agbd.a(localObject1));
        paramViewGroup = paramView;
      }
    }
    label370:
    do
    {
      return paramViewGroup;
      paramViewGroup = new afxi(this);
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558776, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131376555));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131376553));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363410));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131370510));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131364917));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramViewGroup.b.setText("");
      break label200;
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return paramView;
      if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForReplyText)) || ((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForArkApp)))
      {
        if ((paramView != null) && ((paramView.getTag() instanceof afxj)))
        {
          localObject1 = (afxj)paramView.getTag();
          paramViewGroup = paramView;
          paramView = (View)localObject1;
        }
        for (;;)
        {
          a(paramView, (MessageRecord)localObject2);
          return paramViewGroup;
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558724, null);
          paramView = new afxj(this, paramViewGroup);
          paramViewGroup.setTag(paramView);
        }
      }
      paramViewGroup = paramView;
    } while (!(localObject2 instanceof String));
    label391:
    if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
    {
      localObject1 = (TextView)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      paramView.setText((String)localObject2);
      return paramViewGroup;
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558723, null);
      paramView = (TextView)paramViewGroup.findViewById(2131377045);
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxg
 * JD-Core Version:    0.7.0.1
 */