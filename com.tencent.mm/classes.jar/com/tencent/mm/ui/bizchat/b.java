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
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends r<com.tencent.mm.al.a.a>
  implements com.tencent.mm.al.a.b.a, n.b
{
  private static float oeP = 0.1F;
  public final MMFragmentActivity JPk;
  private float JPl;
  private final int JPm;
  private HashMap<a.a, Integer> JPn;
  private float JPo;
  private float JPp;
  private ColorStateList[] JPq;
  private com.tencent.mm.av.a.a.c JPr;
  private HashMap<String, a> JPs;
  private boolean JPt;
  private boolean JPu;
  private long JPv;
  private com.tencent.mm.av.a.a.c fUx;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.f oae;
  protected MMSlideDelView.d oaf;
  private final String oeQ;
  
  public b(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.al.a.a());
    AppMethodBeat.i(33902);
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.JPl = -1.0F;
    this.JPn = new LinkedHashMap();
    this.JPo = -1.0F;
    this.JPp = -1.0F;
    this.JPq = new ColorStateList[5];
    this.fUx = null;
    this.JPr = null;
    this.JPt = false;
    this.JPu = false;
    this.JPv = 0L;
    super.a(parama);
    this.JPk = ((MMFragmentActivity)paramContext);
    this.oeQ = paramString;
    this.JPs = new HashMap();
    this.JPq[0] = com.tencent.mm.cb.a.m(paramContext, 2131100490);
    this.JPq[1] = com.tencent.mm.cb.a.m(paramContext, 2131100643);
    this.JPq[3] = com.tencent.mm.cb.a.m(paramContext, 2131100711);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
    this.JPq[4] = com.tencent.mm.cb.a.m(paramContext, 2131100543);
    this.JPn.put(a.a.hUf, Integer.valueOf(2131234830));
    this.JPn.put(a.a.hUg, Integer.valueOf(2131234831));
    this.JPn.put(a.a.hUh, Integer.valueOf(2131234832));
    this.JPm = com.tencent.mm.cb.a.fromDPToPix(paramContext, 8);
    this.JPl = com.tencent.mm.cb.a.ax(paramContext, 2131165517);
    this.JPo = com.tencent.mm.cb.a.ax(paramContext, 2131165466);
    this.JPp = com.tencent.mm.cb.a.ax(paramContext, 2131165576);
    paramContext = new c.a();
    paramContext.prefixPath = e.ex(this.oeQ);
    paramContext.igk = true;
    paramContext.hgL = true;
    paramContext.igv = 2131690013;
    paramContext.hhW = true;
    paramContext.igC = (oeP * adg(2131165508));
    this.fUx = paramContext.aJu();
    paramContext.igC = (oeP * adg(2131165190));
    this.JPr = paramContext.aJu();
    AppMethodBeat.o(33902);
  }
  
  private static int Xr(String paramString)
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
  
  private CharSequence a(com.tencent.mm.al.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!bu.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.JPk.getString(2131761048));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.JPk, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = aXl(parama.field_digest);
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
          String str2 = aXl(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bu.isNullOrNil(str1))
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
      str1 = this.JPk.getString(2131755722);
      if (bu.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bu.isNullOrNil(parama.field_digest)) {
        break label602;
      }
      if (bu.isNullOrNil(parama.field_digestUser)) {
        break label594;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)) {
          break label609;
        }
        localObject = new SpannableStringBuilder();
        if (parama.field_atCount > 0) {
          ((SpannableStringBuilder)localObject).append(this.JPk.getString(2131761044));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.JPk.getString(2131761043));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.JPk, paramString, paramInt));
        AppMethodBeat.o(33907);
        return localObject;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label594:
      paramString = parama.field_digest;
      continue;
      label602:
      paramString = "";
    }
    label609:
    parama = com.tencent.mm.pluginsdk.ui.span.k.b(this.JPk, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static String aXl(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private int adg(int paramInt)
  {
    AppMethodBeat.i(187084);
    paramInt = com.tencent.mm.cb.a.ay(this.JPk, paramInt);
    AppMethodBeat.o(187084);
    return paramInt;
  }
  
  private void fDR()
  {
    AppMethodBeat.i(187090);
    if (this.JPt)
    {
      super.a(null, null);
      AppMethodBeat.o(187090);
      return;
    }
    this.JPu = true;
    AppMethodBeat.o(187090);
  }
  
  public final void El(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.JPs != null) {
      this.JPs.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(33903);
    dhl();
    setCursor(ag.aGs().EN(this.oeQ));
    if (this.Jvn != null) {
      this.Jvn.aSR();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(33909);
    ZD();
    AppMethodBeat.o(33909);
  }
  
  public final com.tencent.mm.al.a.a a(com.tencent.mm.al.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(187087);
    com.tencent.mm.al.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.al.a.a();
      this.JPv = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.JPv;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(187087);
    return locala;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(33910);
    super.a(paramInt, paramn, paramObject);
    AppMethodBeat.o(33910);
  }
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(187088);
    fDR();
    AppMethodBeat.o(187088);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.oae = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(187089);
    fDR();
    AppMethodBeat.o(187089);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(187085);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(187085);
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
        if (com.tencent.mm.cb.a.ir(this.JPk))
        {
          paramView = View.inflate(this.JPk, 2131493663, null);
          paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.JPz = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.JPA = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.JPB = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.oaj = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.oaj.setBackgroundResource(u.kL(this.JPk));
          paramViewGroup.oaj.setTextSize(0, com.tencent.mm.cb.a.ay(this.JPk, 2131166949) * com.tencent.mm.cb.a.ip(this.JPk));
          paramViewGroup.JPC = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.JPE = paramView.findViewById(2131297015);
          paramViewGroup.JPD = ((ImageView)paramView.findViewById(2131305672));
          paramView.setTag(paramViewGroup);
          paramViewGroup.JPB.setTextSize(0, this.JPo);
          paramViewGroup.JPA.setTextSize(0, this.JPp);
          paramViewGroup.JPz.setTextSize(0, this.JPl);
          paramViewGroup.JPB.setTextColor(this.JPq[0]);
          paramViewGroup.JPA.setTextColor(this.JPq[4]);
          paramViewGroup.JPz.setTextColor(this.JPq[3]);
          paramViewGroup.JPB.setShouldEllipsize(true);
          paramViewGroup.JPA.setShouldEllipsize(false);
          paramViewGroup.JPz.setShouldEllipsize(true);
          paramViewGroup.JPA.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.al.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.JPs.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = ag.aGr().bd(l);
          if (((com.tencent.mm.al.a.c)localObject2).isGroup())
          {
            ((a)localObject1).fLJ = ((com.tencent.mm.al.a.c)localObject2).field_chatName;
            ((a)localObject1).fOX = ((com.tencent.mm.al.a.c)localObject2).hk(1);
            ((a)localObject1).hGI = ((com.tencent.mm.al.a.c)localObject2).field_headImageUrl;
            label421:
            if (bu.isNullOrNil(((a)localObject1).fLJ)) {
              ((a)localObject1).fLJ = this.JPk.getString(2131762623);
            }
            ((a)localObject1).fXq = ((com.tencent.mm.al.a.c)localObject2).field_roomflag;
            ((a)localObject1).JPx = ((com.tencent.mm.al.a.a)localObject3);
            this.JPs.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          ag.aGs();
          ((a)localObject1).JPw = com.tencent.mm.al.a.b.c((com.tencent.mm.al.a.a)localObject3);
          paramViewGroup.JPD.setVisibility(8);
          localObject3 = paramViewGroup.JPA;
          if (((a)localObject1).JPx.field_status != 1) {
            break label994;
          }
          localObject2 = this.JPk.getString(2131761075);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cb.a.ir(this.JPk)) {
            break label1015;
          }
          q.aJb().a(((a)localObject1).hGI, paramViewGroup.fQl, this.JPr);
          label568:
          if (!((a)localObject1).fOX) {
            break label1037;
          }
          paramViewGroup.JPC.setVisibility(0);
          label584:
          paramViewGroup.JPz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JPk, ((a)localObject1).fLJ, (int)paramViewGroup.JPz.getTextSize()));
          localObject2 = a(((a)localObject1).JPx, (int)paramViewGroup.JPB.getTextSize(), ((a)localObject1).fLJ);
          switch (((a)localObject1).JPx.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.JPn.get(a.a.pc(((a)localObject1).fXq));
            if (localObject3 != null)
            {
              paramViewGroup.JPz.setCompoundDrawablePadding(this.JPm);
              paramViewGroup.JPz.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.JPz.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1084;
              }
              paramViewGroup.JPB.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.JPB.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.JPB.setText((CharSequence)localObject2);
              paramViewGroup.JPB.setTextColor(com.tencent.mm.cb.a.m(this.JPk, 2131100642));
              if ((Xr(((a)localObject1).JPx.field_msgType) == 34) && (((a)localObject1).JPx.field_isSend == 0) && (!bu.isNullOrNil(((a)localObject1).JPx.field_content)) && (!new p(((a)localObject1).JPx.field_content).iwT)) {
                paramViewGroup.JPB.setTextColor(com.tencent.mm.cb.a.m(this.JPk, 2131100643));
              }
              if (!((a)localObject1).fOX) {
                break label1106;
              }
              if (((a)localObject1).JPx.field_unReadCount <= 0) {
                break label1095;
              }
              paramViewGroup.JPE.setVisibility(0);
              label890:
              paramViewGroup.oaj.setVisibility(4);
              label898:
              if (!((a)localObject1).JPw) {
                break label1268;
              }
              paramView.findViewById(2131298792).setBackgroundResource(2131231817);
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(33905);
          return paramView;
          paramView = View.inflate(this.JPk, 2131493662, null);
          break;
          com.tencent.mm.al.a.k localk = ag.aGt().eP(((com.tencent.mm.al.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).fLJ = localk.field_userName;
          ((a)localObject1).fOX = localk.hk(1);
          ((a)localObject1).hGI = localk.field_headImageUrl;
          break label421;
          label994:
          localObject2 = i.c(this.JPk, ((a)localObject1).JPx.field_lastMsgTime, true);
          break label532;
          label1015:
          q.aJb().a(((a)localObject1).hGI, paramViewGroup.fQl, this.fUx);
          break label568;
          label1037:
          paramViewGroup.JPC.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = 2131690878;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = 2131690877;
          break label682;
          paramViewGroup.JPz.setDrawRightDrawable(false);
          break label738;
          label1084:
          paramViewGroup.JPB.setDrawLeftDrawable(false);
          break label759;
          label1095:
          paramViewGroup.JPE.setVisibility(4);
          break label890;
          label1106:
          paramViewGroup.JPE.setVisibility(4);
          if (((a)localObject1).JPx.field_unReadCount > 99)
          {
            paramViewGroup.oaj.setText("");
            paramViewGroup.oaj.setBackgroundResource(2131689744);
            paramViewGroup.oaj.setVisibility(0);
            ae.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label898;
          }
          if (((a)localObject1).JPx.field_unReadCount > 0)
          {
            paramViewGroup.oaj.setText(((a)localObject1).JPx.field_unReadCount);
            paramViewGroup.oaj.setVisibility(0);
            paramViewGroup.oaj.setBackgroundResource(u.aP(this.JPk, ((a)localObject1).JPx.field_unReadCount));
            ae.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label898;
          }
          paramViewGroup.oaj.setVisibility(4);
          ae.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label898;
          label1268:
          paramView.findViewById(2131298792).setBackgroundResource(2131231818);
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
    AppMethodBeat.i(187091);
    if (this.JPs != null)
    {
      this.JPs.clear();
      this.JPs = null;
    }
    ag.aGs().remove(this);
    ag.aGs().a(this);
    AppMethodBeat.o(187091);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    this.JPt = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(187086);
    this.JPt = true;
    if (this.JPu)
    {
      super.a(null, null);
      this.JPu = false;
    }
    AppMethodBeat.o(187086);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  final class a
  {
    public boolean JPw;
    public com.tencent.mm.al.a.a JPx;
    String fLJ = null;
    public boolean fOX;
    int fXq = 0;
    String hGI = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView JPA;
    public NoMeasuredTextView JPB;
    public ImageView JPC;
    public ImageView JPD;
    public View JPE;
    public NoMeasuredTextView JPz;
    public ImageView fQl;
    public TextView oaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */