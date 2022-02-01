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
import com.tencent.mm.am.a.a.a;
import com.tencent.mm.am.a.b.a.b;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends q<com.tencent.mm.am.a.a>
  implements com.tencent.mm.am.a.b.a, n.b
{
  private static float mVi = 0.1F;
  public final MMFragmentActivity GgP;
  private float GgQ;
  private final int GgR;
  private HashMap<a.a, Integer> GgS;
  private float GgT;
  private float GgU;
  private ColorStateList[] GgV;
  private com.tencent.mm.aw.a.a.c GgW;
  private HashMap<String, a> GgX;
  private boolean GgY;
  private boolean GgZ;
  private long Gha;
  private com.tencent.mm.aw.a.a.c fvx;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  private final String mVj;
  
  public b(Context paramContext, q.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.am.a.a());
    AppMethodBeat.i(33902);
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.GgQ = -1.0F;
    this.GgS = new LinkedHashMap();
    this.GgT = -1.0F;
    this.GgU = -1.0F;
    this.GgV = new ColorStateList[5];
    this.fvx = null;
    this.GgW = null;
    this.GgY = false;
    this.GgZ = false;
    this.Gha = 0L;
    super.a(parama);
    this.GgP = ((MMFragmentActivity)paramContext);
    this.mVj = paramString;
    this.GgX = new HashMap();
    this.GgV[0] = com.tencent.mm.cd.a.m(paramContext, 2131100490);
    this.GgV[1] = com.tencent.mm.cd.a.m(paramContext, 2131100643);
    this.GgV[3] = com.tencent.mm.cd.a.m(paramContext, 2131100711);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
    this.GgV[4] = com.tencent.mm.cd.a.m(paramContext, 2131100543);
    this.GgS.put(a.a.gYu, Integer.valueOf(2131234830));
    this.GgS.put(a.a.gYv, Integer.valueOf(2131234831));
    this.GgS.put(a.a.gYw, Integer.valueOf(2131234832));
    this.GgR = com.tencent.mm.cd.a.fromDPToPix(paramContext, 8);
    this.GgQ = com.tencent.mm.cd.a.ao(paramContext, 2131165517);
    this.GgT = com.tencent.mm.cd.a.ao(paramContext, 2131165466);
    this.GgU = com.tencent.mm.cd.a.ao(paramContext, 2131165576);
    paramContext = new c.a();
    paramContext.prefixPath = e.dH(this.mVj);
    paramContext.hjU = true;
    paramContext.gjA = true;
    paramContext.hkf = 2131690013;
    paramContext.gkG = true;
    paramContext.hkm = (mVi * Yd(2131165508));
    this.fvx = paramContext.azc();
    paramContext.hkm = (mVi * Yd(2131165190));
    this.GgW = paramContext.azc();
    AppMethodBeat.o(33902);
  }
  
  private static int OV(String paramString)
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
  
  private int Yd(int paramInt)
  {
    AppMethodBeat.i(191428);
    paramInt = com.tencent.mm.cd.a.ap(this.GgP, paramInt);
    AppMethodBeat.o(191428);
    return paramInt;
  }
  
  private CharSequence a(com.tencent.mm.am.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!bt.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.GgP.getString(2131761048));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.GgP, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = aKr(parama.field_digest);
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
          String str2 = aKr(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bt.isNullOrNil(str1))
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
      str1 = this.GgP.getString(2131755722);
      if (bt.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bt.isNullOrNil(parama.field_digest)) {
        break label602;
      }
      if (bt.isNullOrNil(parama.field_digestUser)) {
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
          ((SpannableStringBuilder)localObject).append(this.GgP.getString(2131761044));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.GgP.getString(2131761043));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.GgP, paramString, paramInt));
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
    parama = com.tencent.mm.pluginsdk.ui.span.k.b(this.GgP, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static String aKr(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private void eTN()
  {
    AppMethodBeat.i(191434);
    if (this.GgY)
    {
      super.a(null, null);
      AppMethodBeat.o(191434);
      return;
    }
    this.GgZ = true;
    AppMethodBeat.o(191434);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(33903);
    cHX();
    setCursor(af.awh().xg(this.mVj));
    if (this.FNn != null) {
      this.FNn.aIp();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void We()
  {
    AppMethodBeat.i(33909);
    Wd();
    AppMethodBeat.o(33909);
  }
  
  public final com.tencent.mm.am.a.a a(com.tencent.mm.am.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(191431);
    com.tencent.mm.am.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.am.a.a();
      this.Gha = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.Gha;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(191431);
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
    AppMethodBeat.i(191432);
    eTN();
    AppMethodBeat.o(191432);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mRm = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(191433);
    eTN();
    AppMethodBeat.o(191433);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(191429);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(191429);
    return localCursor;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33905);
    Object localObject3 = (com.tencent.mm.am.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b();
        if (com.tencent.mm.cd.a.hS(this.GgP))
        {
          paramView = View.inflate(this.GgP, 2131493663, null);
          paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.Ghe = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.Ghf = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.Ghg = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.mRr = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.mRr.setBackgroundResource(u.kh(this.GgP));
          paramViewGroup.mRr.setTextSize(0, com.tencent.mm.cd.a.ap(this.GgP, 2131166949) * com.tencent.mm.cd.a.hQ(this.GgP));
          paramViewGroup.Ghh = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.Ghj = paramView.findViewById(2131297015);
          paramViewGroup.Ghi = ((ImageView)paramView.findViewById(2131305672));
          paramView.setTag(paramViewGroup);
          paramViewGroup.Ghg.setTextSize(0, this.GgT);
          paramViewGroup.Ghf.setTextSize(0, this.GgU);
          paramViewGroup.Ghe.setTextSize(0, this.GgQ);
          paramViewGroup.Ghg.setTextColor(this.GgV[0]);
          paramViewGroup.Ghf.setTextColor(this.GgV[4]);
          paramViewGroup.Ghe.setTextColor(this.GgV[3]);
          paramViewGroup.Ghg.setShouldEllipsize(true);
          paramViewGroup.Ghf.setShouldEllipsize(false);
          paramViewGroup.Ghe.setShouldEllipsize(true);
          paramViewGroup.Ghf.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.am.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.GgX.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = af.awg().bg(l);
          if (((com.tencent.mm.am.a.c)localObject2).isGroup())
          {
            ((a)localObject1).fod = ((com.tencent.mm.am.a.c)localObject2).field_chatName;
            ((a)localObject1).fqj = ((com.tencent.mm.am.a.c)localObject2).ht(1);
            ((a)localObject1).gLg = ((com.tencent.mm.am.a.c)localObject2).field_headImageUrl;
            label421:
            if (bt.isNullOrNil(((a)localObject1).fod)) {
              ((a)localObject1).fod = this.GgP.getString(2131762623);
            }
            ((a)localObject1).fyp = ((com.tencent.mm.am.a.c)localObject2).field_roomflag;
            ((a)localObject1).Ghc = ((com.tencent.mm.am.a.a)localObject3);
            this.GgX.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          af.awh();
          ((a)localObject1).Ghb = com.tencent.mm.am.a.b.c((com.tencent.mm.am.a.a)localObject3);
          paramViewGroup.Ghi.setVisibility(8);
          localObject3 = paramViewGroup.Ghf;
          if (((a)localObject1).Ghc.field_status != 1) {
            break label994;
          }
          localObject2 = this.GgP.getString(2131761075);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cd.a.hS(this.GgP)) {
            break label1015;
          }
          o.ayJ().a(((a)localObject1).gLg, paramViewGroup.frr, this.GgW);
          label568:
          if (!((a)localObject1).fqj) {
            break label1037;
          }
          paramViewGroup.Ghh.setVisibility(0);
          label584:
          paramViewGroup.Ghe.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.GgP, ((a)localObject1).fod, (int)paramViewGroup.Ghe.getTextSize()));
          localObject2 = a(((a)localObject1).Ghc, (int)paramViewGroup.Ghg.getTextSize(), ((a)localObject1).fod);
          switch (((a)localObject1).Ghc.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.GgS.get(a.a.nK(((a)localObject1).fyp));
            if (localObject3 != null)
            {
              paramViewGroup.Ghe.setCompoundDrawablePadding(this.GgR);
              paramViewGroup.Ghe.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.Ghe.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1084;
              }
              paramViewGroup.Ghg.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.Ghg.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.Ghg.setText((CharSequence)localObject2);
              paramViewGroup.Ghg.setTextColor(com.tencent.mm.cd.a.m(this.GgP, 2131100642));
              if ((OV(((a)localObject1).Ghc.field_msgType) == 34) && (((a)localObject1).Ghc.field_isSend == 0) && (!bt.isNullOrNil(((a)localObject1).Ghc.field_content)) && (!new p(((a)localObject1).Ghc.field_content).hAc)) {
                paramViewGroup.Ghg.setTextColor(com.tencent.mm.cd.a.m(this.GgP, 2131100643));
              }
              if (!((a)localObject1).fqj) {
                break label1106;
              }
              if (((a)localObject1).Ghc.field_unReadCount <= 0) {
                break label1095;
              }
              paramViewGroup.Ghj.setVisibility(0);
              label890:
              paramViewGroup.mRr.setVisibility(4);
              label898:
              if (!((a)localObject1).Ghb) {
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
          paramView = View.inflate(this.GgP, 2131493662, null);
          break;
          com.tencent.mm.am.a.k localk = af.awi().ea(((com.tencent.mm.am.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).fod = localk.field_userName;
          ((a)localObject1).fqj = localk.ht(1);
          ((a)localObject1).gLg = localk.field_headImageUrl;
          break label421;
          label994:
          localObject2 = h.c(this.GgP, ((a)localObject1).Ghc.field_lastMsgTime, true);
          break label532;
          label1015:
          o.ayJ().a(((a)localObject1).gLg, paramViewGroup.frr, this.fvx);
          break label568;
          label1037:
          paramViewGroup.Ghh.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = 2131690878;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = 2131690877;
          break label682;
          paramViewGroup.Ghe.setDrawRightDrawable(false);
          break label738;
          label1084:
          paramViewGroup.Ghg.setDrawLeftDrawable(false);
          break label759;
          label1095:
          paramViewGroup.Ghj.setVisibility(4);
          break label890;
          label1106:
          paramViewGroup.Ghj.setVisibility(4);
          if (((a)localObject1).Ghc.field_unReadCount > 99)
          {
            paramViewGroup.mRr.setText("");
            paramViewGroup.mRr.setBackgroundResource(2131689744);
            paramViewGroup.mRr.setVisibility(0);
            ad.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label898;
          }
          if (((a)localObject1).Ghc.field_unReadCount > 0)
          {
            paramViewGroup.mRr.setText(((a)localObject1).Ghc.field_unReadCount);
            paramViewGroup.mRr.setVisibility(0);
            paramViewGroup.mRr.setBackgroundResource(u.aG(this.GgP, ((a)localObject1).Ghc.field_unReadCount));
            ad.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label898;
          }
          paramViewGroup.mRr.setVisibility(4);
          ad.v("MicroMsg.BizChatConversationAdapter", "no unread");
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
    AppMethodBeat.i(191435);
    if (this.GgX != null)
    {
      this.GgX.clear();
      this.GgX = null;
    }
    af.awh().remove(this);
    af.awh().a(this);
    AppMethodBeat.o(191435);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    this.GgY = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(191430);
    this.GgY = true;
    if (this.GgZ)
    {
      super.a(null, null);
      this.GgZ = false;
    }
    AppMethodBeat.o(191430);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  public final void wt(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.GgX != null) {
      this.GgX.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  final class a
  {
    public boolean Ghb;
    public com.tencent.mm.am.a.a Ghc;
    String fod = null;
    public boolean fqj;
    int fyp = 0;
    String gLg = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView Ghe;
    public NoMeasuredTextView Ghf;
    public NoMeasuredTextView Ghg;
    public ImageView Ghh;
    public ImageView Ghi;
    public View Ghj;
    public ImageView frr;
    public TextView mRr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */