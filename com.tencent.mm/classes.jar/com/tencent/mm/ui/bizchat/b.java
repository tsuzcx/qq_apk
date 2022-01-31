package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.q;
import java.util.HashMap;

public final class b
  extends r<com.tencent.mm.ai.a.a>
  implements m.b
{
  private com.tencent.mm.as.a.a.c drd = null;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  private final String idQ;
  private final MMFragmentActivity veA;
  private float veB = -1.0F;
  private float veC = -1.0F;
  private float veD = -1.0F;
  private ColorStateList[] veE = new ColorStateList[5];
  HashMap<String, a> veF;
  
  public b(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.ai.a.a());
    this.uMi = parama;
    this.veA = ((MMFragmentActivity)paramContext);
    this.idQ = paramString;
    this.veF = new HashMap();
    this.veE[0] = com.tencent.mm.cb.a.h(paramContext, R.e.hint_text_color);
    this.veE[1] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_unread);
    this.veE[3] = com.tencent.mm.cb.a.h(paramContext, R.e.normal_text_color);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[4] = com.tencent.mm.cb.a.h(paramContext, R.e.light_text_color);
    this.veB = com.tencent.mm.cb.a.aa(paramContext, R.f.NormalTextSize);
    this.veC = com.tencent.mm.cb.a.aa(paramContext, R.f.HintTextSize);
    this.veD = com.tencent.mm.cb.a.aa(paramContext, R.f.SmallestTextSize);
    paramContext = new c.a();
    paramContext.eri = e.bT(this.idQ);
    paramContext.erf = true;
    paramContext.erC = true;
    paramContext.eru = R.k.default_avatar;
    this.drd = paramContext.OV();
  }
  
  private CharSequence a(com.tencent.mm.ai.a.a parama, int paramInt, String paramString)
  {
    if ((!bk.bl(parama.field_editingMsg)) && ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.veA.getString(R.l.main_conversation_last_editing_msg_prefix));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.veA, parama.field_editingMsg, paramInt));
      return paramString;
    }
    Object localObject = parama.field_digest;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = adj(parama.field_digest);
      str1 = "";
      if (localObject != null) {
        return "[" + (String)localObject + "]";
      }
      localObject = str1;
      if (parama.field_digest != null)
      {
        localObject = str1;
        if (parama.field_digest.contains(":"))
        {
          str1 = parama.field_digest.substring(0, parama.field_digest.indexOf(":"));
          String str2 = adj(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bk.bl(str1)) {
              return parama;
            }
            return str1 + ": " + parama;
          }
        }
      }
      str1 = this.veA.getString(R.l.app_emoji);
      if (bk.bl((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bk.bl(parama.field_digest)) {
        break label504;
      }
      if (bk.bl(parama.field_digestUser)) {
        break label496;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)) {
          break label510;
        }
        parama = new SpannableStringBuilder(this.veA.getString(R.l.main_conversation_chatroom_at_hint));
        parama.setSpan(new ForegroundColorSpan(-5569532), 0, parama.length(), 33);
        parama.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.veA, paramString, paramInt));
        return parama;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label496:
      paramString = parama.field_digest;
      continue;
      label504:
      paramString = "";
    }
    label510:
    return com.tencent.mm.pluginsdk.ui.d.j.b(this.veA, paramString, paramInt);
  }
  
  private static String adj(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return null;
  }
  
  private static int xP(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    super.a(paramInt, paramm, paramObject);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = (com.tencent.mm.ai.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b.b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b.b();
        if (com.tencent.mm.cb.a.fh(this.veA))
        {
          paramView = View.inflate(this.veA, R.i.conversation_item_large, null);
          paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
          paramViewGroup.veJ = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
          paramViewGroup.veK = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
          paramViewGroup.veL = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
          paramViewGroup.hZk = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
          paramViewGroup.hZk.setBackgroundResource(q.hh(this.veA));
          paramViewGroup.veM = ((ImageView)paramView.findViewById(R.h.image_mute));
          paramViewGroup.veO = paramView.findViewById(R.h.avatar_prospect_iv);
          paramViewGroup.veN = ((ImageView)paramView.findViewById(R.h.talkroom_iv));
          paramView.setTag(paramViewGroup);
          paramViewGroup.veL.setTextSize(0, this.veC);
          paramViewGroup.veK.setTextSize(0, this.veD);
          paramViewGroup.veJ.setTextSize(0, this.veB);
          paramViewGroup.veL.setTextColor(this.veE[0]);
          paramViewGroup.veK.setTextColor(this.veE[4]);
          paramViewGroup.veJ.setTextColor(this.veE[3]);
          paramViewGroup.veL.setShouldEllipsize(true);
          paramViewGroup.veK.setShouldEllipsize(false);
          paramViewGroup.veJ.setShouldEllipsize(true);
          paramViewGroup.veK.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.ai.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.veF.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          z.MB();
          ((a)localObject1).veG = com.tencent.mm.ai.a.b.c((com.tencent.mm.ai.a.a)localObject3);
          localObject2 = z.MA().aj(l);
          if (((com.tencent.mm.ai.a.c)localObject2).isGroup())
          {
            ((a)localObject1).dmh = ((com.tencent.mm.ai.a.c)localObject2).field_chatName;
            ((a)localObject1).dnJ = ((com.tencent.mm.ai.a.c)localObject2).il(1);
            ((a)localObject1).krI = ((com.tencent.mm.ai.a.c)localObject2).field_headImageUrl;
            label402:
            if (bk.bl(((a)localObject1).dmh)) {
              ((a)localObject1).dmh = this.veA.getString(R.l.room_head_name);
            }
            ((a)localObject1).veH = ((com.tencent.mm.ai.a.a)localObject3);
            this.veF.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          paramViewGroup.veN.setVisibility(8);
          localObject3 = paramViewGroup.veK;
          if (((a)localObject1).veH.field_status != 1) {
            break label889;
          }
          localObject2 = this.veA.getString(R.l.main_sending);
          label489:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          o.ON().a(((a)localObject1).krI, paramViewGroup.doU, this.drd);
          if (!((a)localObject1).dnJ) {
            break label910;
          }
          paramViewGroup.veM.setVisibility(0);
          label531:
          paramViewGroup.veJ.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.veA, ((a)localObject1).dmh, (int)paramViewGroup.veJ.getTextSize()));
          localObject2 = a(((a)localObject1).veH, (int)paramViewGroup.veL.getTextSize(), ((a)localObject1).dmh);
          switch (((a)localObject1).veH.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label630:
            paramViewGroup.veJ.setDrawRightDrawable(false);
            if (paramInt != -1)
            {
              paramViewGroup.veL.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.veL.setDrawLeftDrawable(true);
              label659:
              paramViewGroup.veL.setText((CharSequence)localObject2);
              paramViewGroup.veL.setTextColor(com.tencent.mm.cb.a.h(this.veA, R.e.mm_list_textcolor_two));
              if ((xP(((a)localObject1).veH.field_msgType) == 34) && (((a)localObject1).veH.field_isSend == 0) && (!bk.bl(((a)localObject1).veH.field_content)) && (!new n(((a)localObject1).veH.field_content).eHB)) {
                paramViewGroup.veL.setTextColor(com.tencent.mm.cb.a.h(this.veA, R.e.mm_list_textcolor_unread));
              }
              if (!((a)localObject1).dnJ) {
                break label968;
              }
              if (((a)localObject1).veH.field_unReadCount <= 0) {
                break label957;
              }
              paramViewGroup.veO.setVisibility(0);
              label791:
              paramViewGroup.hZk.setVisibility(4);
            }
            break;
          }
        }
        for (;;)
        {
          if (!((a)localObject1).veG) {
            break label1098;
          }
          paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
          return paramView;
          paramView = View.inflate(this.veA, R.i.conversation_item, null);
          break;
          localObject2 = z.MC().bY(((com.tencent.mm.ai.a.c)localObject2).field_bizChatServId);
          if (localObject2 == null) {
            break label402;
          }
          ((a)localObject1).dmh = ((com.tencent.mm.ai.a.j)localObject2).field_userName;
          ((a)localObject1).dnJ = ((com.tencent.mm.ai.a.j)localObject2).il(1);
          ((a)localObject1).krI = ((com.tencent.mm.ai.a.j)localObject2).field_headImageUrl;
          break label402;
          label889:
          localObject2 = h.c(this.veA, ((a)localObject1).veH.field_lastMsgTime, true);
          break label489;
          label910:
          paramViewGroup.veM.setVisibility(8);
          break label531;
          paramInt = -1;
          break label630;
          paramInt = R.k.msg_state_sending;
          break label630;
          paramInt = -1;
          break label630;
          paramInt = R.k.msg_state_failed;
          break label630;
          paramViewGroup.veL.setDrawLeftDrawable(false);
          break label659;
          label957:
          paramViewGroup.veO.setVisibility(4);
          break label791;
          label968:
          paramViewGroup.veO.setVisibility(4);
          if (((a)localObject1).veH.field_unReadCount > 99)
          {
            paramViewGroup.hZk.setText(R.l.unread_count_overt_100);
            paramViewGroup.hZk.setVisibility(0);
            y.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
          }
          else if (((a)localObject1).veH.field_unReadCount > 0)
          {
            paramViewGroup.hZk.setText(((a)localObject1).veH.field_unReadCount);
            paramViewGroup.hZk.setVisibility(0);
            y.v("MicroMsg.BizChatConversationAdapter", "has unread");
          }
          else
          {
            paramViewGroup.hZk.setVisibility(4);
            y.v("MicroMsg.BizChatConversationAdapter", "no unread");
          }
        }
        label1098:
        paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        return paramView;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void hK(long paramLong)
  {
    if (this.veF != null) {
      this.veF.remove(String.valueOf(paramLong));
    }
  }
  
  public final void onPause()
  {
    if (this.hZg != null) {
      this.hZg.bdb();
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    bcS();
    setCursor(z.MB().ln(this.idQ));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
  
  private final class a
  {
    String dmh = null;
    public boolean dnJ;
    String krI = null;
    public boolean veG;
    public com.tencent.mm.ai.a.a veH;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */