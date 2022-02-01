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
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static float nxI = 0.1F;
  public final MMFragmentActivity HGE;
  private float HGF;
  private final int HGG;
  private HashMap<a.a, Integer> HGH;
  private float HGI;
  private float HGJ;
  private ColorStateList[] HGK;
  private com.tencent.mm.av.a.a.c HGL;
  private HashMap<String, a> HGM;
  private boolean HGN;
  private boolean HGO;
  private long HGP;
  private com.tencent.mm.av.a.a.c fze;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  private final String nxJ;
  
  public b(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.al.a.a());
    AppMethodBeat.i(33902);
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.HGF = -1.0F;
    this.HGH = new LinkedHashMap();
    this.HGI = -1.0F;
    this.HGJ = -1.0F;
    this.HGK = new ColorStateList[5];
    this.fze = null;
    this.HGL = null;
    this.HGN = false;
    this.HGO = false;
    this.HGP = 0L;
    super.a(parama);
    this.HGE = ((MMFragmentActivity)paramContext);
    this.nxJ = paramString;
    this.HGM = new HashMap();
    this.HGK[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.HGK[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.HGK[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.HGK[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
    this.HGH.put(a.a.hyT, Integer.valueOf(2131234830));
    this.HGH.put(a.a.hyU, Integer.valueOf(2131234831));
    this.HGH.put(a.a.hyV, Integer.valueOf(2131234832));
    this.HGG = com.tencent.mm.cc.a.fromDPToPix(paramContext, 8);
    this.HGF = com.tencent.mm.cc.a.au(paramContext, 2131165517);
    this.HGI = com.tencent.mm.cc.a.au(paramContext, 2131165466);
    this.HGJ = com.tencent.mm.cc.a.au(paramContext, 2131165576);
    paramContext = new c.a();
    paramContext.prefixPath = e.dw(this.nxJ);
    paramContext.hKx = true;
    paramContext.gKm = true;
    paramContext.hKI = 2131690013;
    paramContext.gLt = true;
    paramContext.hKP = (nxI * aao(2131165508));
    this.fze = paramContext.aFT();
    paramContext.hKP = (nxI * aao(2131165190));
    this.HGL = paramContext.aFT();
    AppMethodBeat.o(33902);
  }
  
  private static int Tf(String paramString)
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
    if ((!bs.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.HGE.getString(2131761048));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.HGE, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = aPU(parama.field_digest);
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
          String str2 = aPU(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bs.isNullOrNil(str1))
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
      str1 = this.HGE.getString(2131755722);
      if (bs.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bs.isNullOrNil(parama.field_digest)) {
        break label602;
      }
      if (bs.isNullOrNil(parama.field_digestUser)) {
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
          ((SpannableStringBuilder)localObject).append(this.HGE.getString(2131761044));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.HGE.getString(2131761043));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.HGE, paramString, paramInt));
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
    parama = com.tencent.mm.pluginsdk.ui.span.k.b(this.HGE, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static String aPU(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private int aao(int paramInt)
  {
    AppMethodBeat.i(196366);
    paramInt = com.tencent.mm.cc.a.av(this.HGE, paramInt);
    AppMethodBeat.o(196366);
    return paramInt;
  }
  
  private void fjA()
  {
    AppMethodBeat.i(196372);
    if (this.HGN)
    {
      super.a(null, null);
      AppMethodBeat.o(196372);
      return;
    }
    this.HGO = true;
    AppMethodBeat.o(196372);
  }
  
  public final void AW(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.HGM != null) {
      this.HGM.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(33903);
    cVi();
    setCursor(af.aCZ().Bm(this.nxJ));
    if (this.HmY != null) {
      this.HmY.aPg();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(33909);
    Xb();
    AppMethodBeat.o(33909);
  }
  
  public final com.tencent.mm.al.a.a a(com.tencent.mm.al.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(196369);
    com.tencent.mm.al.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.al.a.a();
      this.HGP = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.HGP;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(196369);
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
    AppMethodBeat.i(196370);
    fjA();
    AppMethodBeat.o(196370);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ntC = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(196371);
    fjA();
    AppMethodBeat.o(196371);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(196367);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(196367);
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
        if (com.tencent.mm.cc.a.id(this.HGE))
        {
          paramView = View.inflate(this.HGE, 2131493663, null);
          paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.HGT = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.HGU = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.HGV = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.ntH = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.ntH.setBackgroundResource(u.ks(this.HGE));
          paramViewGroup.ntH.setTextSize(0, com.tencent.mm.cc.a.av(this.HGE, 2131166949) * com.tencent.mm.cc.a.ib(this.HGE));
          paramViewGroup.HGW = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.HGY = paramView.findViewById(2131297015);
          paramViewGroup.HGX = ((ImageView)paramView.findViewById(2131305672));
          paramView.setTag(paramViewGroup);
          paramViewGroup.HGV.setTextSize(0, this.HGI);
          paramViewGroup.HGU.setTextSize(0, this.HGJ);
          paramViewGroup.HGT.setTextSize(0, this.HGF);
          paramViewGroup.HGV.setTextColor(this.HGK[0]);
          paramViewGroup.HGU.setTextColor(this.HGK[4]);
          paramViewGroup.HGT.setTextColor(this.HGK[3]);
          paramViewGroup.HGV.setShouldEllipsize(true);
          paramViewGroup.HGU.setShouldEllipsize(false);
          paramViewGroup.HGT.setShouldEllipsize(true);
          paramViewGroup.HGU.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.al.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.HGM.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = af.aCY().bd(l);
          if (((com.tencent.mm.al.a.c)localObject2).isGroup())
          {
            ((a)localObject1).frx = ((com.tencent.mm.al.a.c)localObject2).field_chatName;
            ((a)localObject1).ftN = ((com.tencent.mm.al.a.c)localObject2).hc(1);
            ((a)localObject1).hlG = ((com.tencent.mm.al.a.c)localObject2).field_headImageUrl;
            label421:
            if (bs.isNullOrNil(((a)localObject1).frx)) {
              ((a)localObject1).frx = this.HGE.getString(2131762623);
            }
            ((a)localObject1).fBW = ((com.tencent.mm.al.a.c)localObject2).field_roomflag;
            ((a)localObject1).HGR = ((com.tencent.mm.al.a.a)localObject3);
            this.HGM.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          af.aCZ();
          ((a)localObject1).HGQ = com.tencent.mm.al.a.b.c((com.tencent.mm.al.a.a)localObject3);
          paramViewGroup.HGX.setVisibility(8);
          localObject3 = paramViewGroup.HGU;
          if (((a)localObject1).HGR.field_status != 1) {
            break label994;
          }
          localObject2 = this.HGE.getString(2131761075);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cc.a.id(this.HGE)) {
            break label1015;
          }
          o.aFB().a(((a)localObject1).hlG, paramViewGroup.fuY, this.HGL);
          label568:
          if (!((a)localObject1).ftN) {
            break label1037;
          }
          paramViewGroup.HGW.setVisibility(0);
          label584:
          paramViewGroup.HGT.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.HGE, ((a)localObject1).frx, (int)paramViewGroup.HGT.getTextSize()));
          localObject2 = a(((a)localObject1).HGR, (int)paramViewGroup.HGV.getTextSize(), ((a)localObject1).frx);
          switch (((a)localObject1).HGR.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.HGH.get(a.a.oy(((a)localObject1).fBW));
            if (localObject3 != null)
            {
              paramViewGroup.HGT.setCompoundDrawablePadding(this.HGG);
              paramViewGroup.HGT.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.HGT.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1084;
              }
              paramViewGroup.HGV.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.HGV.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.HGV.setText((CharSequence)localObject2);
              paramViewGroup.HGV.setTextColor(com.tencent.mm.cc.a.m(this.HGE, 2131100642));
              if ((Tf(((a)localObject1).HGR.field_msgType) == 34) && (((a)localObject1).HGR.field_isSend == 0) && (!bs.isNullOrNil(((a)localObject1).HGR.field_content)) && (!new p(((a)localObject1).HGR.field_content).iaD)) {
                paramViewGroup.HGV.setTextColor(com.tencent.mm.cc.a.m(this.HGE, 2131100643));
              }
              if (!((a)localObject1).ftN) {
                break label1106;
              }
              if (((a)localObject1).HGR.field_unReadCount <= 0) {
                break label1095;
              }
              paramViewGroup.HGY.setVisibility(0);
              label890:
              paramViewGroup.ntH.setVisibility(4);
              label898:
              if (!((a)localObject1).HGQ) {
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
          paramView = View.inflate(this.HGE, 2131493662, null);
          break;
          com.tencent.mm.al.a.k localk = af.aDa().dP(((com.tencent.mm.al.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).frx = localk.field_userName;
          ((a)localObject1).ftN = localk.hc(1);
          ((a)localObject1).hlG = localk.field_headImageUrl;
          break label421;
          label994:
          localObject2 = h.c(this.HGE, ((a)localObject1).HGR.field_lastMsgTime, true);
          break label532;
          label1015:
          o.aFB().a(((a)localObject1).hlG, paramViewGroup.fuY, this.fze);
          break label568;
          label1037:
          paramViewGroup.HGW.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = 2131690878;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = 2131690877;
          break label682;
          paramViewGroup.HGT.setDrawRightDrawable(false);
          break label738;
          label1084:
          paramViewGroup.HGV.setDrawLeftDrawable(false);
          break label759;
          label1095:
          paramViewGroup.HGY.setVisibility(4);
          break label890;
          label1106:
          paramViewGroup.HGY.setVisibility(4);
          if (((a)localObject1).HGR.field_unReadCount > 99)
          {
            paramViewGroup.ntH.setText("");
            paramViewGroup.ntH.setBackgroundResource(2131689744);
            paramViewGroup.ntH.setVisibility(0);
            ac.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label898;
          }
          if (((a)localObject1).HGR.field_unReadCount > 0)
          {
            paramViewGroup.ntH.setText(((a)localObject1).HGR.field_unReadCount);
            paramViewGroup.ntH.setVisibility(0);
            paramViewGroup.ntH.setBackgroundResource(u.aM(this.HGE, ((a)localObject1).HGR.field_unReadCount));
            ac.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label898;
          }
          paramViewGroup.ntH.setVisibility(4);
          ac.v("MicroMsg.BizChatConversationAdapter", "no unread");
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
    AppMethodBeat.i(196373);
    if (this.HGM != null)
    {
      this.HGM.clear();
      this.HGM = null;
    }
    af.aCZ().remove(this);
    af.aCZ().a(this);
    AppMethodBeat.o(196373);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    this.HGN = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(196368);
    this.HGN = true;
    if (this.HGO)
    {
      super.a(null, null);
      this.HGO = false;
    }
    AppMethodBeat.o(196368);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  final class a
  {
    public boolean HGQ;
    public com.tencent.mm.al.a.a HGR;
    int fBW = 0;
    String frx = null;
    public boolean ftN;
    String hlG = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView HGT;
    public NoMeasuredTextView HGU;
    public NoMeasuredTextView HGV;
    public ImageView HGW;
    public ImageView HGX;
    public View HGY;
    public ImageView fuY;
    public TextView ntH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */