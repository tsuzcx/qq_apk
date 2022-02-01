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
import com.tencent.mm.al.a.a.a;
import com.tencent.mm.al.a.b.a.b;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
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
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends s<com.tencent.mm.al.a.a>
  implements com.tencent.mm.al.a.b.a, MStorageEx.IOnStorageChange
{
  private static float ppN = 0.1F;
  private long PaA;
  private float Paq;
  private final int Par;
  private HashMap<a.a, Integer> Pas;
  private float Pat;
  private float Pau;
  private ColorStateList[] Pav;
  private com.tencent.mm.av.a.a.c Paw;
  private HashMap<String, a> Pax;
  private boolean Pay;
  private boolean Paz;
  private com.tencent.mm.av.a.a.c gzE;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  private final String ppO;
  public final MMFragmentActivity wkt;
  
  public b(Context paramContext, s.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.al.a.a());
    AppMethodBeat.i(33902);
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.Paq = -1.0F;
    this.Pas = new LinkedHashMap();
    this.Pat = -1.0F;
    this.Pau = -1.0F;
    this.Pav = new ColorStateList[5];
    this.gzE = null;
    this.Paw = null;
    this.Pay = false;
    this.Paz = false;
    this.PaA = 0L;
    super.a(parama);
    this.wkt = ((MMFragmentActivity)paramContext);
    this.ppO = paramString;
    this.Pax = new HashMap();
    this.Pav[0] = com.tencent.mm.cb.a.m(paramContext, 2131100594);
    this.Pav[1] = com.tencent.mm.cb.a.m(paramContext, 2131100813);
    this.Pav[3] = com.tencent.mm.cb.a.m(paramContext, 2131100904);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
    this.Pav[4] = com.tencent.mm.cb.a.m(paramContext, 2131100681);
    this.Pas.put(a.a.iPr, Integer.valueOf(2131233056));
    this.Pas.put(a.a.iPs, Integer.valueOf(2131233057));
    this.Pas.put(a.a.iPt, Integer.valueOf(2131233058));
    this.Par = com.tencent.mm.cb.a.fromDPToPix(paramContext, 8);
    this.Paq = com.tencent.mm.cb.a.aG(paramContext, 2131165535);
    this.Pat = com.tencent.mm.cb.a.aG(paramContext, 2131165482);
    this.Pau = com.tencent.mm.cb.a.aG(paramContext, 2131165594);
    paramContext = new c.a();
    paramContext.prefixPath = e.fe(this.ppO);
    paramContext.jbf = true;
    paramContext.hZF = true;
    paramContext.jbq = 2131690042;
    paramContext.iaT = true;
    paramContext.jbx = (ppN * alQ(2131165526));
    this.gzE = paramContext.bdv();
    paramContext.jbx = (ppN * alQ(2131165193));
    this.Paw = paramContext.bdv();
    AppMethodBeat.o(33902);
  }
  
  private CharSequence a(com.tencent.mm.al.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!Util.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.wkt.getString(2131762834));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.wkt, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = bmp(parama.field_digest);
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
          String str2 = bmp(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
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
      str1 = this.wkt.getString(2131755793);
      if (Util.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (Util.isNullOrNil(parama.field_digest)) {
        break label597;
      }
      if (Util.isNullOrNil(parama.field_digestUser)) {
        break label589;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)) {
          break label604;
        }
        localObject = new SpannableStringBuilder();
        if (parama.field_atCount > 0) {
          ((SpannableStringBuilder)localObject).append(this.wkt.getString(2131762825));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.wkt.getString(2131762824));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.wkt, paramString, paramInt));
        AppMethodBeat.o(33907);
        return localObject;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label589:
      paramString = parama.field_digest;
      continue;
      label597:
      paramString = "";
    }
    label604:
    parama = com.tencent.mm.pluginsdk.ui.span.l.e(this.wkt, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static int ahn(String paramString)
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
  
  private int alQ(int paramInt)
  {
    AppMethodBeat.i(232768);
    paramInt = com.tencent.mm.cb.a.aH(this.wkt, paramInt);
    AppMethodBeat.o(232768);
    return paramInt;
  }
  
  private static String bmp(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private void gLY()
  {
    AppMethodBeat.i(232774);
    if (this.Pay)
    {
      super.onNotifyChange(null, null);
      AppMethodBeat.o(232774);
      return;
    }
    this.Paz = true;
    AppMethodBeat.o(232774);
  }
  
  public final void Np(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.Pax != null) {
      this.Pax.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  public final com.tencent.mm.al.a.a a(com.tencent.mm.al.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(232771);
    com.tencent.mm.al.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.al.a.a();
      this.PaA = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.PaA;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(232771);
    return locala;
  }
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(232772);
    gLY();
    AppMethodBeat.o(232772);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pla = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(33903);
    ebf();
    setCursor(ag.bak().NB(this.ppO));
    if (this.OFI != null) {
      this.OFI.bnE();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(33909);
    anp();
    AppMethodBeat.o(33909);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(232769);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(232769);
    return localCursor;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33905);
    Object localObject3 = (com.tencent.mm.al.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b();
        if (com.tencent.mm.cb.a.jk(this.wkt))
        {
          paramView = View.inflate(this.wkt, 2131493793, null);
          paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
          paramViewGroup.PaE = ((NoMeasuredTextView)paramView.findViewById(2131305440));
          paramViewGroup.PaF = ((NoMeasuredTextView)paramView.findViewById(2131309606));
          paramViewGroup.PaG = ((NoMeasuredTextView)paramView.findViewById(2131303011));
          paramViewGroup.plf = ((TextView)paramView.findViewById(2131309165));
          paramViewGroup.plf.setBackgroundResource(v.kH(this.wkt));
          paramViewGroup.plf.setTextSize(0, com.tencent.mm.cb.a.aH(this.wkt, 2131167084) * com.tencent.mm.cb.a.ji(this.wkt));
          paramViewGroup.PaH = ((ImageView)paramView.findViewById(2131302590));
          paramViewGroup.PaJ = paramView.findViewById(2131297142);
          paramViewGroup.PaI = ((ImageView)paramView.findViewById(2131308917));
          paramView.setTag(paramViewGroup);
          paramViewGroup.PaG.setTextSize(0, this.Pat);
          paramViewGroup.PaF.setTextSize(0, this.Pau);
          paramViewGroup.PaE.setTextSize(0, this.Paq);
          paramViewGroup.PaG.setTextColor(this.Pav[0]);
          paramViewGroup.PaF.setTextColor(this.Pav[4]);
          paramViewGroup.PaE.setTextColor(this.Pav[3]);
          paramViewGroup.PaG.setShouldEllipsize(true);
          paramViewGroup.PaF.setShouldEllipsize(false);
          paramViewGroup.PaE.setShouldEllipsize(true);
          paramViewGroup.PaF.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.al.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.Pax.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = ag.baj().bs(l);
          if (((com.tencent.mm.al.a.c)localObject2).isGroup())
          {
            ((a)localObject1).gqV = ((com.tencent.mm.al.a.c)localObject2).field_chatName;
            ((a)localObject1).guh = ((com.tencent.mm.al.a.c)localObject2).iE(1);
            ((a)localObject1).iAR = ((com.tencent.mm.al.a.c)localObject2).field_headImageUrl;
            label421:
            if (Util.isNullOrNil(((a)localObject1).gqV)) {
              ((a)localObject1).gqV = this.wkt.getString(2131764705);
            }
            ((a)localObject1).gCw = ((com.tencent.mm.al.a.c)localObject2).field_roomflag;
            ((a)localObject1).PaC = ((com.tencent.mm.al.a.a)localObject3);
            this.Pax.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          ag.bak();
          ((a)localObject1).PaB = com.tencent.mm.al.a.b.c((com.tencent.mm.al.a.a)localObject3);
          paramViewGroup.PaI.setVisibility(8);
          localObject3 = paramViewGroup.PaF;
          if (((a)localObject1).PaC.field_status != 1) {
            break label994;
          }
          localObject2 = this.wkt.getString(2131762861);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cb.a.jk(this.wkt)) {
            break label1015;
          }
          q.bcV().a(((a)localObject1).iAR, paramViewGroup.gvv, this.Paw);
          label568:
          if (!((a)localObject1).guh) {
            break label1037;
          }
          paramViewGroup.PaH.setVisibility(0);
          label584:
          paramViewGroup.PaE.setText(com.tencent.mm.pluginsdk.ui.span.l.e(this.wkt, ((a)localObject1).gqV, (int)paramViewGroup.PaE.getTextSize()));
          localObject2 = a(((a)localObject1).PaC, (int)paramViewGroup.PaG.getTextSize(), ((a)localObject1).gqV);
          switch (((a)localObject1).PaC.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.Pas.get(a.a.sQ(((a)localObject1).gCw));
            if (localObject3 != null)
            {
              paramViewGroup.PaE.setCompoundDrawablePadding(this.Par);
              paramViewGroup.PaE.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.PaE.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1084;
              }
              paramViewGroup.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.PaG.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.PaG.setText((CharSequence)localObject2);
              paramViewGroup.PaG.setTextColor(com.tencent.mm.cb.a.m(this.wkt, 2131100812));
              if ((ahn(((a)localObject1).PaC.field_msgType) == 34) && (((a)localObject1).PaC.field_isSend == 0) && (!Util.isNullOrNil(((a)localObject1).PaC.field_content)) && (!new p(((a)localObject1).PaC.field_content).jsi)) {
                paramViewGroup.PaG.setTextColor(com.tencent.mm.cb.a.m(this.wkt, 2131100813));
              }
              if (!((a)localObject1).guh) {
                break label1106;
              }
              if (((a)localObject1).PaC.field_unReadCount <= 0) {
                break label1095;
              }
              paramViewGroup.PaJ.setVisibility(0);
              label890:
              paramViewGroup.plf.setVisibility(4);
              label898:
              if (!((a)localObject1).PaB) {
                break label1268;
              }
              paramView.findViewById(2131299246).setBackgroundResource(2131231897);
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(33905);
          return paramView;
          paramView = View.inflate(this.wkt, 2131493792, null);
          break;
          k localk = ag.bal().fB(((com.tencent.mm.al.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).gqV = localk.field_userName;
          ((a)localObject1).guh = localk.iE(1);
          ((a)localObject1).iAR = localk.field_headImageUrl;
          break label421;
          label994:
          localObject2 = f.c(this.wkt, ((a)localObject1).PaC.field_lastMsgTime, true);
          break label532;
          label1015:
          q.bcV().a(((a)localObject1).iAR, paramViewGroup.gvv, this.gzE);
          break label568;
          label1037:
          paramViewGroup.PaH.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = 2131691165;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = 2131691164;
          break label682;
          paramViewGroup.PaE.setDrawRightDrawable(false);
          break label738;
          label1084:
          paramViewGroup.PaG.setDrawLeftDrawable(false);
          break label759;
          label1095:
          paramViewGroup.PaJ.setVisibility(4);
          break label890;
          label1106:
          paramViewGroup.PaJ.setVisibility(4);
          if (((a)localObject1).PaC.field_unReadCount > 99)
          {
            paramViewGroup.plf.setText("");
            paramViewGroup.plf.setBackgroundResource(2131689753);
            paramViewGroup.plf.setVisibility(0);
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label898;
          }
          if (((a)localObject1).PaC.field_unReadCount > 0)
          {
            paramViewGroup.plf.setText(((a)localObject1).PaC.field_unReadCount);
            paramViewGroup.plf.setVisibility(0);
            paramViewGroup.plf.setBackgroundResource(v.aQ(this.wkt, ((a)localObject1).PaC.field_unReadCount));
            Log.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label898;
          }
          paramViewGroup.plf.setVisibility(4);
          Log.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label898;
          label1268:
          paramView.findViewById(2131299246).setBackgroundResource(2131231898);
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
    AppMethodBeat.i(232775);
    if (this.Pax != null)
    {
      this.Pax.clear();
      this.Pax = null;
    }
    ag.bak().remove(this);
    ag.bak().a(this);
    AppMethodBeat.o(232775);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33910);
    super.onNotifyChange(paramInt, paramMStorageEx, paramObject);
    AppMethodBeat.o(33910);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(232773);
    gLY();
    AppMethodBeat.o(232773);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.plb != null) {
      this.plb.ebo();
    }
    this.Pay = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232770);
    this.Pay = true;
    if (this.Paz)
    {
      super.onNotifyChange(null, null);
      this.Paz = false;
    }
    AppMethodBeat.o(232770);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  final class a
  {
    public boolean PaB;
    public com.tencent.mm.al.a.a PaC;
    int gCw = 0;
    String gqV = null;
    public boolean guh;
    String iAR = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView PaE;
    public NoMeasuredTextView PaF;
    public NoMeasuredTextView PaG;
    public ImageView PaH;
    public ImageView PaI;
    public View PaJ;
    public ImageView gvv;
    public TextView plf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */