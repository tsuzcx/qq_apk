import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public class ahqk
  extends agem
  implements bbst, bbwe, bbwi
{
  public static long a;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  ahqm jdField_a_of_type_Ahqm = new ahqm(null);
  protected Handler a;
  bbvd jdField_a_of_type_Bbvd;
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
  SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  public MessageForRichState a;
  HashSet<ahql> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  long b;
  long c;
  
  ahqk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Ahqm.a = new WeakReference(this);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_a_of_type_Bbvd = ((bbvd)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(58));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
    if (this.jdField_a_of_type_Bbvd != null) {
      this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Ahqm);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(MessageForRichState paramMessageForRichState)
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId = paramMessageForRichState.feedId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId = paramMessageForRichState.tplId;
    RichStatus localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId))
    {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId;
      localRichStatus.actionId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = paramMessageForRichState.actionText;
      localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.dataId)) {
        break label268;
      }
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId;
      label94:
      localRichStatus.dataId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramMessageForRichState.dataText;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramMessageForRichState.locText;
      localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.locPos)) {
        break label279;
      }
    }
    label268:
    label279:
    for (int i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationPosition;; i = Integer.parseInt(paramMessageForRichState.locPos))
    {
      localRichStatus.locationPosition = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time = paramMessageForRichState.time;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId = paramMessageForRichState.fontId;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType = paramMessageForRichState.fontType;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
      if ((paramMessageForRichState.plainText == null) || (paramMessageForRichState.plainText.length() <= 0)) {
        break label290;
      }
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
      i = Integer.parseInt(paramMessageForRichState.actionId);
      break;
      i = Integer.parseInt(paramMessageForRichState.dataId);
      break label94;
    }
    label290:
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicFromJson(paramMessageForRichState.topics);
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicPosFromJson(paramMessageForRichState.topicsPos);
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("key_open_via", "history-liaotian");
    afez.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_clk_his", 0, 0, "", "", "", "");
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "1", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "signature_aio", "click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void c()
  {
    if (System.currentTimeMillis() - this.b > 2000L)
    {
      this.b = System.currentTimeMillis();
      bdll.b(null, "dc00898", "", "", "0X800A4EB", "0X800A4EB", 0, 0, "0", "0", "", "");
    }
  }
  
  protected agen a()
  {
    ahql localahql = new ahql();
    this.jdField_a_of_type_JavaUtilHashSet.add(localahql);
    return localahql;
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout = (ahql)paramagen;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSignViewHolder", 2, "convertView is null, create SignatureView.");
      }
      paramMessageRecord = new BoxShadowLayout(this.jdField_a_of_type_AndroidContentContext);
      paramagen = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramagen.leftMargin = i;
      paramagen.rightMargin = i;
      paramMessageRecord.setLayoutParams(paramagen);
      paramLinearLayout.a = new bbvy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin);
      paramLinearLayout.a.a(this);
      paramLinearLayout.a.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
    paramLinearLayout.a.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout.a.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
    paramLinearLayout.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
    paramLinearLayout.a.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedId;
    paramLinearLayout.a.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.tplId;
    paramLinearLayout.a.d = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.count;
    paramLinearLayout.a.f = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.zanFlag;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a != null) {
      paramLinearLayout.a.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a.getDefaultColor();
    }
    paramagen = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
    if ((paramagen != null) && (paramagen.equals("1.0"))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time <= 0L) {
        break label608;
      }
    }
    label576:
    label608:
    for (paramagen = bhsw.a(this.jdField_a_of_type_AndroidContentContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);; paramagen = null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        paramView = bekk.a(20, paramView);
        paramagjk = paramView + anzj.a(2131712328);
        paramLinearLayout.a.jdField_a_of_type_JavaLangString = paramagjk;
        if (e)
        {
          paramagjk = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText();
          if (paramLinearLayout.b != null) {
            break label576;
          }
          paramLinearLayout.b = new StringBuilder();
        }
      }
      for (;;)
      {
        paramLinearLayout.b.append(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
          paramLinearLayout.b.append("于").append(paramagen);
        }
        paramLinearLayout.b.append("更新了签名，内容是：").append(paramagjk);
        paramMessageRecord.setContentDescription(paramLinearLayout.b.toString());
        paramLinearLayout.a.a(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time);
        ThreadManager.post(new RichStatItemBuilder.1(this), 8, null, true);
        c();
        return paramMessageRecord;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break;
        if (paramLinearLayout.b.length() > 0) {
          paramLinearLayout.b.delete(0, paramLinearLayout.b.length());
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatItemBuilder", 2, "RichStatItemBuilder destroy");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ahql localahql = (ahql)((Iterator)localObject).next();
      if (localahql.a != null) {
        localahql.a.k();
      }
    }
    if (this.jdField_a_of_type_Bbvd != null) {
      this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Ahqm);
    }
    localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    this.jdField_a_of_type_Bbvd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(View paramView, int paramInt, bbwd parambbwd)
  {
    int i = 2;
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      b();
      paramInt = i;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A98E", "0X800A98E", paramInt, 0, "0", "0", "", "");
      return;
      if (paramInt == 4)
      {
        a(parambbwd);
        paramInt = 3;
      }
      else
      {
        b();
        paramInt = 1;
      }
    }
  }
  
  public void a(bbwd parambbwd)
  {
    Resources localResources;
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId))
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (bhnv.d(this.jdField_a_of_type_AndroidContentContext)) {
        break label62;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131691989), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    }
    label62:
    int i;
    int j;
    do
    {
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.c) < 200L)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131690725), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
      }
      this.c = l;
      try
      {
        parambbwd = (bbvy)parambbwd;
        i = parambbwd.d;
        if (parambbwd.f != 0) {
          break;
        }
        parambbwd.f = 1;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
        i += 1;
        j = 1;
        parambbwd.d = i;
        parambbwd.j();
        ((SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, parambbwd.jdField_b_of_type_JavaLangString, 255, j);
        return;
      }
      catch (Exception parambbwd) {}
    } while (!QLog.isColorLevel());
    QLog.i("ChatItemBuilder", 2, parambbwd.getMessage(), parambbwd);
    return;
    parambbwd.f = 0;
    i -= 1;
    if (i > 0) {}
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
      j = 0;
      break;
      i = 0;
    }
  }
  
  public void a(bbwh parambbwh, View paramView)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick topic=", parambbwh });
    parambbwh = parambbwh.a();
    if ((parambbwh instanceof Pair))
    {
      parambbwh = (Pair)parambbwh;
      if (QLog.isColorLevel()) {
        QLog.i("ChatItemBuilder", 2, String.format("aio onTopicClick [%d,%s]", new Object[] { parambbwh.first, parambbwh.second }));
      }
      bbwn.a(this.jdField_a_of_type_AndroidContentContext, bbwn.a(((Integer)parambbwh.first).intValue(), (String)parambbwh.second), -1);
    }
  }
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqk
 * JD-Core Version:    0.7.0.1
 */