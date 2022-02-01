import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ajdk
  extends bkps
{
  public int a;
  private aixy jdField_a_of_type_Aixy;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajdl(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected SlideDetectListView a;
  public List<MessageRecord> a;
  private List<MessageRecord> b = new ArrayList();
  
  public ajdk(Context paramContext, QQAppInterface paramQQAppInterface, aixy paramaixy, int paramInt, SlideDetectListView paramSlideDetectListView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aixy = paramaixy;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = paramSlideDetectListView;
  }
  
  private boolean a(structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      int k = paramStructMsg.msg.src_id.get();
      int m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
      localSystemMsgActionInfo.group_code.set(paramStructMsg.msg.group_code.get());
      localSystemMsgActionInfo.sig.set(ByteStringMicro.EMPTY);
      localSystemMsgActionInfo.type.set(15);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localSystemMsgActionInfo.get(), 3);
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    HashSet localHashSet = new HashSet();
    if ((paramList == null) || (this.b == null)) {}
    for (;;)
    {
      return;
      this.b.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.b.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.b != null) {
      i = this.b.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b == null) || (paramInt > this.b.size()) || (paramInt < 0)) {
      return null;
    }
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajdm localajdm;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559902, paramViewGroup, false);
      localajdm = new ajdm();
      localajdm.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373561));
      localajdm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373551));
      localajdm.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373558));
      localajdm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373565));
      localajdm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373556));
      localajdm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373562));
      localajdm.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373564));
      localajdm.d = ((TextView)paramView.findViewById(2131373557));
      localajdm.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373560));
      localajdm.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131379328));
      ((Button)paramView.findViewById(2131379327)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(localajdm);
      localajdm.jdField_b_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label272;
      }
      aiyi.a(paramView, true);
      aiyi.a(localajdm.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    }
    MessageRecord localMessageRecord;
    for (;;)
    {
      localMessageRecord = (MessageRecord)getItem(paramInt);
      if (localMessageRecord == null) {
        break label354;
      }
      if ((localMessageRecord instanceof MessageForSystemMsg)) {
        break label289;
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localajdm = (ajdm)paramView.getTag();
      break;
      label272:
      aiyi.a(paramView, false);
      aiyi.a(localajdm.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    }
    label289:
    localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
    localajdm.jdField_c_of_type_Long = localMessageRecord.uniseq;
    if (localMessageRecord != null) {}
    for (int i = ((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_type.get();; i = 2)
    {
      if (i == 2) {
        this.jdField_a_of_type_Aixy.a(localajdm, paramInt);
      }
      break;
      label354:
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdk
 * JD-Core Version:    0.7.0.1
 */