package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.a.a.a;
import com.tencent.mm.ao.a.b.a.b;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends v<com.tencent.mm.ao.a.a>
  implements com.tencent.mm.ao.a.b.a, MStorageEx.IOnStorageChange
{
  private static float syM = 0.1F;
  public final MMFragmentActivity AVp;
  private float WtD;
  private final int WtE;
  private HashMap<a.a, Integer> WtF;
  private float WtG;
  private float WtH;
  private ColorStateList[] WtI;
  private com.tencent.mm.ay.a.a.c WtJ;
  private HashMap<String, a> WtK;
  private boolean WtL;
  private boolean WtM;
  private long WtN;
  private com.tencent.mm.ay.a.a.c jjH;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  private final String syN;
  
  public b(Context paramContext, v.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.ao.a.a());
    AppMethodBeat.i(33902);
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.WtD = -1.0F;
    this.WtF = new LinkedHashMap();
    this.WtG = -1.0F;
    this.WtH = -1.0F;
    this.WtI = new ColorStateList[5];
    this.jjH = null;
    this.WtJ = null;
    this.WtL = false;
    this.WtM = false;
    this.WtN = 0L;
    super.a(parama);
    this.AVp = ((MMFragmentActivity)paramContext);
    this.syN = paramString;
    this.WtK = new HashMap();
    this.WtI[0] = com.tencent.mm.ci.a.l(paramContext, R.e.hint_text_color);
    this.WtI[1] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_unread);
    this.WtI[3] = com.tencent.mm.ci.a.l(paramContext, R.e.normal_text_color);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.WtI[4] = com.tencent.mm.ci.a.l(paramContext, R.e.light_text_color);
    this.WtF.put(a.a.lFI, Integer.valueOf(R.g.dnA));
    this.WtF.put(a.a.lFJ, Integer.valueOf(R.g.dnB));
    this.WtF.put(a.a.lFK, Integer.valueOf(R.g.dnC));
    this.WtE = com.tencent.mm.ci.a.fromDPToPix(paramContext, 8);
    this.WtD = com.tencent.mm.ci.a.aY(paramContext, R.f.NormalTextSize);
    this.WtG = com.tencent.mm.ci.a.aY(paramContext, R.f.HintTextSize);
    this.WtH = com.tencent.mm.ci.a.aY(paramContext, R.f.SmallestTextSize);
    paramContext = new c.a();
    paramContext.prefixPath = e.fU(this.syN);
    paramContext.lRD = true;
    paramContext.kOl = true;
    paramContext.lRP = R.k.default_avatar;
    paramContext.kPz = true;
    paramContext.lRW = (syM * auQ(R.f.NormalAvatarSize));
    this.jjH = paramContext.bmL();
    paramContext.lRW = (syM * auQ(R.f.BigLargeAvatarSize));
    this.WtJ = paramContext.bmL();
    AppMethodBeat.o(33902);
  }
  
  private CharSequence a(com.tencent.mm.ao.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!Util.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.AVp.getString(R.l.eLh));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.AVp, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = byO(parama.field_digest);
      str1 = "";
      if (localObject != null)
      {
        parama = "[" + (String)localObject + "]";
        AppMethodBeat.o(33907);
        return parama;
      }
      localObject = str1;
      if (parama.field_digest != null)
      {
        localObject = str1;
        if (parama.field_digest.contains(":"))
        {
          str1 = parama.field_digest.substring(0, parama.field_digest.indexOf(":"));
          String str2 = byO(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (Util.isNullOrNil(str1))
            {
              AppMethodBeat.o(33907);
              return parama;
            }
            parama = str1 + ": " + parama;
            AppMethodBeat.o(33907);
            return parama;
          }
        }
      }
      str1 = this.AVp.getString(R.l.app_emoji);
      if (Util.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (Util.isNullOrNil(parama.field_digest)) {
        break label603;
      }
      if (Util.isNullOrNil(parama.field_digestUser)) {
        break label595;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)) {
          break label610;
        }
        localObject = new SpannableStringBuilder();
        if (parama.field_atCount > 0) {
          ((SpannableStringBuilder)localObject).append(this.AVp.getString(R.l.eLd));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.AVp.getString(R.l.eLc));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.AVp, paramString, paramInt));
        AppMethodBeat.o(33907);
        return localObject;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label595:
      paramString = parama.field_digest;
      continue;
      label603:
      paramString = "";
    }
    label610:
    parama = com.tencent.mm.pluginsdk.ui.span.l.d(this.AVp, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static int aoT(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(33908);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(33908);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private int auQ(int paramInt)
  {
    AppMethodBeat.i(285001);
    paramInt = com.tencent.mm.ci.a.aZ(this.AVp, paramInt);
    AppMethodBeat.o(285001);
    return paramInt;
  }
  
  private static String byO(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private void hLg()
  {
    AppMethodBeat.i(285012);
    if (this.WtL)
    {
      super.onNotifyChange(null, null);
      AppMethodBeat.o(285012);
      return;
    }
    this.WtM = true;
    AppMethodBeat.o(285012);
  }
  
  public final void Vx(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.WtK != null) {
      this.WtK.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  public final com.tencent.mm.ao.a.a a(com.tencent.mm.ao.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(285008);
    com.tencent.mm.ao.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.ao.a.a();
      this.WtN = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.WtN;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(285008);
    return locala;
  }
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(285009);
    hLg();
    AppMethodBeat.o(285009);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(33903);
    eKd();
    v(af.bjy().UX(this.syN));
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(33909);
    atr();
    AppMethodBeat.o(33909);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33905);
    Object localObject3 = (com.tencent.mm.ao.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b();
        if (com.tencent.mm.ci.a.ko(this.AVp))
        {
          paramView = View.inflate(this.AVp, R.i.efG, null);
          paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
          paramViewGroup.WtR = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
          paramViewGroup.WtS = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
          paramViewGroup.WtT = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
          paramViewGroup.sno = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
          paramViewGroup.sno.setBackgroundResource(w.lE(this.AVp));
          paramViewGroup.sno.setTextSize(0, com.tencent.mm.ci.a.aZ(this.AVp, R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(this.AVp));
          paramViewGroup.WtU = ((ImageView)paramView.findViewById(R.h.dIR));
          paramViewGroup.WtW = paramView.findViewById(R.h.dse);
          paramViewGroup.WtV = ((ImageView)paramView.findViewById(R.h.dWs));
          paramView.setTag(paramViewGroup);
          paramViewGroup.WtT.setTextSize(0, this.WtG);
          paramViewGroup.WtS.setTextSize(0, this.WtH);
          paramViewGroup.WtR.setTextSize(0, this.WtD);
          paramViewGroup.WtT.setTextColor(this.WtI[0]);
          paramViewGroup.WtS.setTextColor(this.WtI[4]);
          paramViewGroup.WtR.setTextColor(this.WtI[3]);
          paramViewGroup.WtT.setShouldEllipsize(true);
          paramViewGroup.WtS.setShouldEllipsize(false);
          paramViewGroup.WtR.setShouldEllipsize(true);
          paramViewGroup.WtS.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.ao.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.WtK.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = af.bjx().bF(l);
          if (((com.tencent.mm.ao.a.c)localObject2).bjM())
          {
            ((a)localObject1).iVe = ((com.tencent.mm.ao.a.c)localObject2).field_chatName;
            ((a)localObject1).iYs = ((com.tencent.mm.ao.a.c)localObject2).jQ(1);
            ((a)localObject1).lqp = ((com.tencent.mm.ao.a.c)localObject2).field_headImageUrl;
            label421:
            if (Util.isNullOrNil(((a)localObject1).iVe)) {
              ((a)localObject1).iVe = this.AVp.getString(R.l.eRh);
            }
            ((a)localObject1).jmC = ((com.tencent.mm.ao.a.c)localObject2).field_roomflag;
            ((a)localObject1).WtP = ((com.tencent.mm.ao.a.a)localObject3);
            this.WtK.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          af.bjy();
          ((a)localObject1).WtO = com.tencent.mm.ao.a.b.c((com.tencent.mm.ao.a.a)localObject3);
          paramViewGroup.WtV.setVisibility(8);
          localObject3 = paramViewGroup.WtS;
          if (((a)localObject1).WtP.field_status != 1) {
            break label995;
          }
          localObject2 = this.AVp.getString(R.l.eLv);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.ci.a.ko(this.AVp)) {
            break label1016;
          }
          q.bml().a(((a)localObject1).lqp, paramViewGroup.iZG, this.WtJ);
          label568:
          if (!((a)localObject1).iYs) {
            break label1038;
          }
          paramViewGroup.WtU.setVisibility(0);
          label584:
          paramViewGroup.WtR.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this.AVp, ((a)localObject1).iVe, (int)paramViewGroup.WtR.getTextSize()));
          localObject2 = a(((a)localObject1).WtP, (int)paramViewGroup.WtT.getTextSize(), ((a)localObject1).iVe);
          switch (((a)localObject1).WtP.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.WtF.get(a.a.vO(((a)localObject1).jmC));
            if (localObject3 != null)
            {
              paramViewGroup.WtR.setCompoundDrawablePadding(this.WtE);
              paramViewGroup.WtR.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.WtR.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1085;
              }
              paramViewGroup.WtT.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.WtT.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.WtT.setText((CharSequence)localObject2);
              paramViewGroup.WtT.setTextColor(com.tencent.mm.ci.a.l(this.AVp, R.e.mm_list_textcolor_two));
              if ((aoT(((a)localObject1).WtP.field_msgType) == 34) && (((a)localObject1).WtP.field_isSend == 0) && (!Util.isNullOrNil(((a)localObject1).WtP.field_content)) && (!new p(((a)localObject1).WtP.field_content).mhL)) {
                paramViewGroup.WtT.setTextColor(com.tencent.mm.ci.a.l(this.AVp, R.e.mm_list_textcolor_unread));
              }
              if (!((a)localObject1).iYs) {
                break label1107;
              }
              if (((a)localObject1).WtP.field_unReadCount <= 0) {
                break label1096;
              }
              paramViewGroup.WtW.setVisibility(0);
              label891:
              paramViewGroup.sno.setVisibility(4);
              label899:
              if (!((a)localObject1).WtO) {
                break label1269;
              }
              paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_item_highlight_selector);
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(33905);
          return paramView;
          paramView = View.inflate(this.AVp, R.i.efF, null);
          break;
          k localk = af.bjz().gm(((com.tencent.mm.ao.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).iVe = localk.field_userName;
          ((a)localObject1).iYs = localk.jQ(1);
          ((a)localObject1).lqp = localk.field_headImageUrl;
          break label421;
          label995:
          localObject2 = f.d(this.AVp, ((a)localObject1).WtP.field_lastMsgTime, true);
          break label532;
          label1016:
          q.bml().a(((a)localObject1).lqp, paramViewGroup.iZG, this.jjH);
          break label568;
          label1038:
          paramViewGroup.WtU.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = R.k.msg_state_sending;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = R.k.msg_state_failed;
          break label682;
          paramViewGroup.WtR.setDrawRightDrawable(false);
          break label738;
          label1085:
          paramViewGroup.WtT.setDrawLeftDrawable(false);
          break label759;
          label1096:
          paramViewGroup.WtW.setVisibility(4);
          break label891;
          label1107:
          paramViewGroup.WtW.setVisibility(4);
          if (((a)localObject1).WtP.field_unReadCount > 99)
          {
            paramViewGroup.sno.setText("");
            paramViewGroup.sno.setBackgroundResource(R.k.badge_count_more);
            paramViewGroup.sno.setVisibility(0);
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label899;
          }
          if (((a)localObject1).WtP.field_unReadCount > 0)
          {
            paramViewGroup.sno.setText(((a)localObject1).WtP.field_unReadCount);
            paramViewGroup.sno.setVisibility(0);
            paramViewGroup.sno.setBackgroundResource(w.bj(this.AVp, ((a)localObject1).WtP.field_unReadCount));
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label899;
          }
          paramViewGroup.sno.setVisibility(4);
          Log.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label899;
          label1269:
          paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_list_item_selector);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final Cursor hK()
  {
    AppMethodBeat.i(285002);
    Cursor localCursor = super.hK();
    AppMethodBeat.o(285002);
    return localCursor;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285013);
    if (this.WtK != null)
    {
      this.WtK.clear();
      this.WtK = null;
    }
    af.bjy().remove(this);
    af.bjy().a(this);
    AppMethodBeat.o(285013);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33910);
    super.onNotifyChange(paramInt, paramMStorageEx, paramObject);
    AppMethodBeat.o(33910);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(285010);
    hLg();
    AppMethodBeat.o(285010);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.snk != null) {
      this.snk.eKm();
    }
    this.WtL = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285004);
    this.WtL = true;
    if (this.WtM)
    {
      super.onNotifyChange(null, null);
      this.WtM = false;
    }
    AppMethodBeat.o(285004);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  final class a
  {
    public boolean WtO;
    public com.tencent.mm.ao.a.a WtP;
    String iVe = null;
    public boolean iYs;
    int jmC = 0;
    String lqp = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView WtR;
    public NoMeasuredTextView WtS;
    public NoMeasuredTextView WtT;
    public ImageView WtU;
    public ImageView WtV;
    public View WtW;
    public ImageView iZG;
    public TextView sno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */