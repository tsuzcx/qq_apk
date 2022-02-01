import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class akbo
  extends BaseAdapter
{
  private akfq jdField_a_of_type_Akfq;
  Context jdField_a_of_type_AndroidContentContext;
  private ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private anyw jdField_a_of_type_Anyw;
  ChatHistoryC2CLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedHashMap<String, List<MessageRecord>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  View.OnClickListener b;
  
  public akbo(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, akfq paramakfq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment = paramChatHistoryC2CLinkFragment;
    this.jdField_a_of_type_Akfq = paramakfq;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
    this.jdField_a_of_type_Anyw = ((anyw)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app.getManager(51));
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
              localObject2 = (bdol)localIterator.next();
              if (!(localObject2 instanceof bdom)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((bdom)localObject2).jdField_a_of_type_JavaUtilArrayList == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((bdom)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label248;
              }
              localObject2 = ((bdom)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (bdol)((Iterator)localObject2).next();
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
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((bdol)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((bdol)localObject2);
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
  
  private void a(akbt paramakbt, MessageRecord paramMessageRecord)
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
          a(akbt.a(paramakbt), (String)localObject);
          i = 1;
          if (i == 0) {
            akbt.a(paramakbt).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850461));
          }
          str1 = a(akfr.a(paramMessageRecord));
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label300;
          }
          str2 = ((MessageForArkApp)paramMessageRecord).getTitle();
          localTextView = akbt.a(paramakbt);
          localObject = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject = str1;
          }
          localTextView.setText((CharSequence)localObject);
          localObject = new Date(paramMessageRecord.time * 1000L);
          localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
          akbt.b(paramakbt).setText((CharSequence)localObject);
          akbt.c(paramakbt).setText(bhlg.m(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app, paramMessageRecord.senderuin));
          akbt.a(paramakbt).setOnClickListener(new akbq(this, str1, paramakbt, paramMessageRecord));
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
            break label312;
          }
          akbt.a(paramakbt).setVisibility(0);
          bool = this.jdField_a_of_type_Akfq.a(paramMessageRecord);
          akbt.a(paramakbt).setChecked(bool);
          paramMessageRecord = (LinearLayout.LayoutParams)akbt.a(paramakbt).getLayoutParams();
          paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, zps.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramMessageRecord.bottomMargin);
          akbt.a(paramakbt).setLayoutParams(paramMessageRecord);
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
      akbt.a(paramakbt).setText(str1);
      continue;
      label312:
      akbt.a(paramakbt).setVisibility(8);
      paramMessageRecord = (LinearLayout.LayoutParams)akbt.a(paramakbt).getLayoutParams();
      paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramMessageRecord.bottomMargin);
      akbt.a(paramakbt).setLayoutParams(paramMessageRecord);
      return;
      label374:
      int i = 0;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130850461);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bhez.b(localLayoutParams.width, localLayoutParams.height, zps.a(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(bhez.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  private void a(String paramString)
  {
    boolean bool1 = false;
    if ((!this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString)) || (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramString))) {
      return;
    }
    boolean bool2 = ((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).booleanValue();
    Object localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (bool2)
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(i + 1, (Collection)localObject);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "2", "", "");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap;
      if (!bool2) {
        bool1 = true;
      }
      ((ArrayMap)localObject).put(paramString, Boolean.valueOf(bool1));
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.removeAll((Collection)localObject);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "1", "", "");
    }
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = a(paramAbsShareMsg, "cover");
    int i = 2130850461;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130850470;
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
      paramAbsShareMsg.setTag(bhez.b(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, zps.a(this.jdField_a_of_type_AndroidContentContext, 6.0F)));
      paramAbsShareMsg.setDecodeHandler(bhez.j);
      paramURLImageView.setImageDrawable(paramAbsShareMsg);
      return;
    }
  }
  
  public void a(LinkedHashMap<String, List<MessageRecord>> paramLinkedHashMap)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramLinkedHashMap;
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramLinkedHashMap = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (paramLinkedHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramLinkedHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(str, Boolean.valueOf(false));
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CLinkAdapter", 2, "[setData]data size: " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + " header size: " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() + " elements size: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CLinkAdapter", 2, "[getCount]data size: " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + " header size: " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() + " elements size: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject3;
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject2 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof akbs)))
      {
        localObject1 = (akbs)paramView.getTag();
        ((akbs)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
        ((akbs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.d;
        if (!(localObject2 instanceof MessageForStructing)) {
          break label402;
        }
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          localObject3 = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((akbs)localObject1).jdField_a_of_type_ComTencentImageURLImageView, (AbsShareMsg)localObject3);
          ((akbs)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(a((AbsShareMsg)localObject3, "title"));
          localObject3 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.getActivity().app, ((MessageForStructing)localObject2).senderuin);
          ((akbs)localObject1).b.setText((CharSequence)localObject3);
          localObject3 = new Date(((MessageForStructing)localObject2).time * 1000L);
          localObject3 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject3);
          ((akbs)localObject1).c.setText((CharSequence)localObject3);
        }
        label207:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
          break label425;
        }
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Akfq.a(localObject2));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = new akbs(this);
        paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558882, null);
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376256));
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131378070));
        ((akbs)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378068));
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363669));
        ((akbs)localObject1).b = ((TextView)paramView.findViewById(2131371504));
        ((akbs)localObject1).c = ((TextView)paramView.findViewById(2131365286));
        paramView.setTag(localObject1);
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
        label402:
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        ((akbs)localObject1).b.setText("");
        break label207;
        label425:
        ((akbs)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
    if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForReplyText)) || ((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForArkApp)))
    {
      if ((paramView != null) && ((paramView.getTag() instanceof akbt))) {
        localObject1 = (akbt)paramView.getTag();
      }
      for (;;)
      {
        a((akbt)localObject1, (MessageRecord)localObject2);
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558823, null);
        localObject1 = new akbt(this, paramView);
        paramView.setTag(localObject1);
      }
    }
    Object localObject1 = paramView;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof akbr))) {
        break label633;
      }
      localObject1 = (akbr)paramView.getTag();
      label576:
      localObject3 = ((akbr)localObject1).jdField_a_of_type_AndroidWidgetCheckBox;
      if (((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject2)).booleanValue()) {
        break label710;
      }
    }
    label710:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject3).setChecked(bool);
      ((akbr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label633:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558822, null);
      localObject1 = new akbr();
      ((akbr)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369210));
      ((akbr)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378764));
      paramView.setTag(localObject1);
      paramView.setOnClickListener(new akbp(this, (akbr)localObject1));
      break label576;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbo
 * JD-Core Version:    0.7.0.1
 */