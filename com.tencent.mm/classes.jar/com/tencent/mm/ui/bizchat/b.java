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
import com.tencent.mm.an.a.a.a;
import com.tencent.mm.an.a.b.a.b;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.platformtools.f;
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
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends x<com.tencent.mm.an.a.a>
  implements com.tencent.mm.an.a.b.a, MStorageEx.IOnStorageChange
{
  private static float vEt = 0.1F;
  public final MMFragmentActivity FYB;
  private float aeaW;
  private final int aeaX;
  private HashMap<a.a, Integer> aeaY;
  private float aeaZ;
  private float aeba;
  private ColorStateList[] aebb;
  private com.tencent.mm.modelimage.loader.a.c aebc;
  private HashMap<String, a> aebd;
  private boolean aebe;
  private long aebf;
  private com.tencent.mm.modelimage.loader.a.c lMm;
  private final String vEu;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  private boolean xhA;
  
  public b(Context paramContext, x.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.an.a.a());
    AppMethodBeat.i(33902);
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.aeaW = -1.0F;
    this.aeaY = new LinkedHashMap();
    this.aeaZ = -1.0F;
    this.aeba = -1.0F;
    this.aebb = new ColorStateList[5];
    this.lMm = null;
    this.aebc = null;
    this.xhA = false;
    this.aebe = false;
    this.aebf = 0L;
    super.a(parama);
    this.FYB = ((MMFragmentActivity)paramContext);
    this.vEu = paramString;
    this.aebd = new HashMap();
    this.aebb[0] = com.tencent.mm.cd.a.l(paramContext, R.e.hint_text_color);
    this.aebb[1] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_unread);
    this.aebb[3] = com.tencent.mm.cd.a.l(paramContext, R.e.normal_text_color);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.aebb[4] = com.tencent.mm.cd.a.l(paramContext, R.e.light_text_color);
    this.aeaY.put(a.a.oxp, Integer.valueOf(R.g.fnQ));
    this.aeaY.put(a.a.oxq, Integer.valueOf(R.g.fnR));
    this.aeaY.put(a.a.oxr, Integer.valueOf(R.g.fnS));
    this.aeaX = com.tencent.mm.cd.a.fromDPToPix(paramContext, 8);
    this.aeaW = com.tencent.mm.cd.a.br(paramContext, R.f.NormalTextSize);
    this.aeaZ = com.tencent.mm.cd.a.br(paramContext, R.f.HintTextSize);
    this.aeba = com.tencent.mm.cd.a.br(paramContext, R.f.SmallestTextSize);
    paramContext = new c.a();
    paramContext.prefixPath = e.hx(this.vEu);
    paramContext.oKp = true;
    paramContext.nqa = true;
    paramContext.oKB = R.k.default_avatar;
    paramContext.nrc = true;
    paramContext.oKI = (vEt * aBs(R.f.NormalAvatarSize));
    this.lMm = paramContext.bKx();
    paramContext.oKI = (vEt * aBs(R.f.BigLargeAvatarSize));
    this.aebc = paramContext.bKx();
    AppMethodBeat.o(33902);
  }
  
  private CharSequence a(com.tencent.mm.an.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!Util.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.FYB.getString(R.l.gNc));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.FYB, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = bAr(parama.field_digest);
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
          String str2 = bAr(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
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
      str1 = this.FYB.getString(R.l.app_emoji);
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
          ((SpannableStringBuilder)localObject).append(this.FYB.getString(R.l.gMY));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.FYB.getString(R.l.gMX));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.FYB, paramString, paramInt));
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
    parama = com.tencent.mm.pluginsdk.ui.span.p.d(this.FYB, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private int aBs(int paramInt)
  {
    AppMethodBeat.i(250759);
    paramInt = com.tencent.mm.cd.a.bs(this.FYB, paramInt);
    AppMethodBeat.o(250759);
    return paramInt;
  }
  
  private static int aip(String paramString)
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
  
  private static String bAr(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private void jnI()
  {
    AppMethodBeat.i(250763);
    if (this.xhA)
    {
      super.onNotifyChange(null, null);
      AppMethodBeat.o(250763);
      return;
    }
    this.aebe = true;
    AppMethodBeat.o(250763);
  }
  
  public final Cursor Fv()
  {
    AppMethodBeat.i(250766);
    Cursor localCursor = super.Fv();
    AppMethodBeat.o(250766);
    return localCursor;
  }
  
  public final com.tencent.mm.an.a.a a(com.tencent.mm.an.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(250783);
    com.tencent.mm.an.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.an.a.a();
      this.aebf = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.aebf;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(250783);
    return locala;
  }
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(250785);
    jnI();
    AppMethodBeat.o(250785);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vzh = paramf;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(33903);
    fSd();
    w(af.bHi().MW(this.vEu));
    if (this.adDx != null) {
      this.adDx.bWC();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(33909);
    aNy();
    AppMethodBeat.o(33909);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33905);
    Object localObject3 = (com.tencent.mm.an.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b();
        if (com.tencent.mm.cd.a.mp(this.FYB))
        {
          paramView = View.inflate(this.FYB, R.i.giF, null);
          paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
          paramViewGroup.aebj = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
          paramViewGroup.aebk = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
          paramViewGroup.aebl = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
          paramViewGroup.vzm = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
          paramViewGroup.vzm.setBackgroundResource(v.nH(this.FYB));
          paramViewGroup.vzm.setTextSize(0, com.tencent.mm.cd.a.bs(this.FYB, R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(this.FYB));
          paramViewGroup.aebm = ((ImageView)paramView.findViewById(R.h.fKm));
          paramViewGroup.aebo = paramView.findViewById(R.h.fsw);
          paramViewGroup.aebn = ((ImageView)paramView.findViewById(R.h.fYY));
          paramView.setTag(paramViewGroup);
          paramViewGroup.aebl.setTextSize(0, this.aeaZ);
          paramViewGroup.aebk.setTextSize(0, this.aeba);
          paramViewGroup.aebj.setTextSize(0, this.aeaW);
          paramViewGroup.aebl.setTextColor(this.aebb[0]);
          paramViewGroup.aebk.setTextColor(this.aebb[4]);
          paramViewGroup.aebj.setTextColor(this.aebb[3]);
          paramViewGroup.aebl.setShouldEllipsize(true);
          paramViewGroup.aebk.setShouldEllipsize(false);
          paramViewGroup.aebj.setShouldEllipsize(true);
          paramViewGroup.aebk.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.an.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.aebd.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = af.bHh().dW(l);
          if ((localObject2 != null) && (((com.tencent.mm.an.a.c)localObject2).bHx()))
          {
            ((a)localObject1).lxj = ((com.tencent.mm.an.a.c)localObject2).field_chatName;
            ((a)localObject1).lAj = ((com.tencent.mm.an.a.c)localObject2).nG(1);
            ((a)localObject1).nVs = ((com.tencent.mm.an.a.c)localObject2).field_headImageUrl;
            label426:
            if (Util.isNullOrNil(((a)localObject1).lxj)) {
              ((a)localObject1).lxj = this.FYB.getString(R.l.gTN);
            }
            if (localObject2 == null) {
              break label1012;
            }
            ((a)localObject1).lPN = ((com.tencent.mm.an.a.c)localObject2).field_roomflag;
            label467:
            ((a)localObject1).aebh = ((com.tencent.mm.an.a.a)localObject3);
            this.aebd.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          af.bHi();
          ((a)localObject1).aebg = com.tencent.mm.an.a.b.c((com.tencent.mm.an.a.a)localObject3);
          paramViewGroup.aebn.setVisibility(8);
          localObject3 = paramViewGroup.aebk;
          if (((a)localObject1).aebh.field_status != 1) {
            break label1021;
          }
          localObject2 = this.FYB.getString(R.l.gNp);
          label542:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cd.a.mp(this.FYB)) {
            break label1042;
          }
          r.bKe().a(((a)localObject1).nVs, paramViewGroup.lBC, this.aebc);
          label578:
          if (!((a)localObject1).lAj) {
            break label1064;
          }
          paramViewGroup.aebm.setVisibility(0);
          label594:
          paramViewGroup.aebj.setText(com.tencent.mm.pluginsdk.ui.span.p.d(this.FYB, ((a)localObject1).lxj, (int)paramViewGroup.aebj.getTextSize()));
          localObject2 = a(((a)localObject1).aebh, (int)paramViewGroup.aebl.getTextSize(), ((a)localObject1).lxj);
          switch (((a)localObject1).aebh.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label694:
            localObject3 = (Integer)this.aeaY.get(a.a.vT(((a)localObject1).lPN));
            if (localObject3 != null)
            {
              paramViewGroup.aebj.setCompoundDrawablePadding(this.aeaX);
              paramViewGroup.aebj.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.aebj.setDrawRightDrawable(true);
              label750:
              if (paramInt == -1) {
                break label1111;
              }
              paramViewGroup.aebl.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.aebl.setDrawLeftDrawable(true);
              label771:
              paramViewGroup.aebl.setText((CharSequence)localObject2);
              paramViewGroup.aebl.setTextColor(com.tencent.mm.cd.a.l(this.FYB, R.e.mm_list_textcolor_two));
              if ((aip(((a)localObject1).aebh.field_msgType) == 34) && (((a)localObject1).aebh.field_isSend == 0) && (!Util.isNullOrNil(((a)localObject1).aebh.field_content)) && (!new com.tencent.mm.modelvoice.p(((a)localObject1).aebh.field_content).paW)) {
                paramViewGroup.aebl.setTextColor(com.tencent.mm.cd.a.l(this.FYB, R.e.mm_list_textcolor_unread));
              }
              if (!((a)localObject1).lAj) {
                break label1133;
              }
              if (((a)localObject1).aebh.field_unReadCount <= 0) {
                break label1122;
              }
              paramViewGroup.aebo.setVisibility(0);
              label903:
              paramViewGroup.vzm.setVisibility(4);
              label911:
              if (!((a)localObject1).aebg) {
                break label1295;
              }
              paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_item_highlight_selector);
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(33905);
          return paramView;
          paramView = View.inflate(this.FYB, R.i.giE, null);
          break;
          if (localObject2 == null) {
            break label426;
          }
          k localk = af.bHj().hM(((com.tencent.mm.an.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label426;
          }
          ((a)localObject1).lxj = localk.field_userName;
          ((a)localObject1).lAj = localk.nG(1);
          ((a)localObject1).nVs = localk.field_headImageUrl;
          break label426;
          label1012:
          ((a)localObject1).lPN = 0;
          break label467;
          label1021:
          localObject2 = f.d(this.FYB, ((a)localObject1).aebh.field_lastMsgTime, true);
          break label542;
          label1042:
          r.bKe().a(((a)localObject1).nVs, paramViewGroup.lBC, this.lMm);
          break label578;
          label1064:
          paramViewGroup.aebm.setVisibility(8);
          break label594;
          paramInt = -1;
          break label694;
          paramInt = R.k.msg_state_sending;
          break label694;
          paramInt = -1;
          break label694;
          paramInt = R.k.msg_state_failed;
          break label694;
          paramViewGroup.aebj.setDrawRightDrawable(false);
          break label750;
          label1111:
          paramViewGroup.aebl.setDrawLeftDrawable(false);
          break label771;
          label1122:
          paramViewGroup.aebo.setVisibility(4);
          break label903;
          label1133:
          paramViewGroup.aebo.setVisibility(4);
          if (((a)localObject1).aebh.field_unReadCount > 99)
          {
            paramViewGroup.vzm.setText("");
            paramViewGroup.vzm.setBackgroundResource(R.k.badge_count_more);
            paramViewGroup.vzm.setVisibility(0);
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label911;
          }
          if (((a)localObject1).aebh.field_unReadCount > 0)
          {
            paramViewGroup.vzm.setText(((a)localObject1).aebh.field_unReadCount);
            paramViewGroup.vzm.setVisibility(0);
            paramViewGroup.vzm.setBackgroundResource(v.bC(this.FYB, ((a)localObject1).aebh.field_unReadCount));
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label911;
          }
          paramViewGroup.vzm.setVisibility(4);
          Log.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label911;
          label1295:
          paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250794);
    if (this.aebd != null)
    {
      this.aebd.clear();
      this.aebd = null;
    }
    af.bHi().remove(this);
    af.bHi().a(this);
    AppMethodBeat.o(250794);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33910);
    super.onNotifyChange(paramInt, paramMStorageEx, paramObject);
    AppMethodBeat.o(33910);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(250789);
    jnI();
    AppMethodBeat.o(250789);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    this.xhA = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250769);
    this.xhA = true;
    if (this.aebe)
    {
      super.onNotifyChange(null, null);
      this.aebe = false;
    }
    AppMethodBeat.o(250769);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  public final void zF(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.aebd != null) {
      this.aebd.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  final class a
  {
    public boolean aebg;
    public com.tencent.mm.an.a.a aebh;
    public boolean lAj;
    int lPN = 0;
    String lxj = null;
    String nVs = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView aebj;
    public NoMeasuredTextView aebk;
    public NoMeasuredTextView aebl;
    public ImageView aebm;
    public ImageView aebn;
    public View aebo;
    public ImageView lBC;
    public TextView vzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */