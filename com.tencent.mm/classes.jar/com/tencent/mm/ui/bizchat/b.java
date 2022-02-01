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
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.i;
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
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b
  extends r<com.tencent.mm.am.a.a>
  implements com.tencent.mm.am.a.b.a, n.b
{
  private static float nZg = 0.1F;
  private float JuA;
  private ColorStateList[] JuB;
  private com.tencent.mm.aw.a.a.c JuC;
  private HashMap<String, a> JuD;
  private boolean JuE;
  private boolean JuF;
  private long JuG;
  public final MMFragmentActivity Juv;
  private float Juw;
  private final int Jux;
  private HashMap<a.a, Integer> Juy;
  private float Juz;
  private com.tencent.mm.aw.a.a.c fSr;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  private final String nZh;
  
  public b(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.am.a.a());
    AppMethodBeat.i(33902);
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.Juw = -1.0F;
    this.Juy = new LinkedHashMap();
    this.Juz = -1.0F;
    this.JuA = -1.0F;
    this.JuB = new ColorStateList[5];
    this.fSr = null;
    this.JuC = null;
    this.JuE = false;
    this.JuF = false;
    this.JuG = 0L;
    super.a(parama);
    this.Juv = ((MMFragmentActivity)paramContext);
    this.nZh = paramString;
    this.JuD = new HashMap();
    this.JuB[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.JuB[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.JuB[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.JuB[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
    this.Juy.put(a.a.hRn, Integer.valueOf(2131234830));
    this.Juy.put(a.a.hRo, Integer.valueOf(2131234831));
    this.Juy.put(a.a.hRp, Integer.valueOf(2131234832));
    this.Jux = com.tencent.mm.cc.a.fromDPToPix(paramContext, 8);
    this.Juw = com.tencent.mm.cc.a.ax(paramContext, 2131165517);
    this.Juz = com.tencent.mm.cc.a.ax(paramContext, 2131165466);
    this.JuA = com.tencent.mm.cc.a.ax(paramContext, 2131165576);
    paramContext = new c.a();
    paramContext.prefixPath = e.es(this.nZh);
    paramContext.idr = true;
    paramContext.hdX = true;
    paramContext.idD = 2131690013;
    paramContext.hfi = true;
    paramContext.idK = (nZg * acy(2131165508));
    this.fSr = paramContext.aJc();
    paramContext.idK = (nZg * acy(2131165190));
    this.JuC = paramContext.aJc();
    AppMethodBeat.o(33902);
  }
  
  private static int WF(String paramString)
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
  
  private CharSequence a(com.tencent.mm.am.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(33907);
    if ((!bt.isNullOrNil(parama.field_editingMsg)) && (((parama.field_atCount <= 0) && (parama.field_atAll <= 0)) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.Juv.getString(2131761048));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.Juv, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(33907);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = aVK(parama.field_digest);
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
          String str2 = aVK(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
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
      str1 = this.Juv.getString(2131755722);
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
          ((SpannableStringBuilder)localObject).append(this.Juv.getString(2131761044));
        }
        if (parama.field_atAll > 0) {
          ((SpannableStringBuilder)localObject).append(this.Juv.getString(2131761043));
        }
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject).length(), 33);
        ((SpannableStringBuilder)localObject).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.Juv, paramString, paramInt));
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
    parama = com.tencent.mm.pluginsdk.ui.span.k.b(this.Juv, paramString, paramInt);
    AppMethodBeat.o(33907);
    return parama;
  }
  
  private static String aVK(String paramString)
  {
    AppMethodBeat.i(33906);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(paramString);
      AppMethodBeat.o(33906);
      return paramString;
    }
    AppMethodBeat.o(33906);
    return null;
  }
  
  private int acy(int paramInt)
  {
    AppMethodBeat.i(193788);
    paramInt = com.tencent.mm.cc.a.ay(this.Juv, paramInt);
    AppMethodBeat.o(193788);
    return paramInt;
  }
  
  private void fzP()
  {
    AppMethodBeat.i(193794);
    if (this.JuE)
    {
      super.a(null, null);
      AppMethodBeat.o(193794);
      return;
    }
    this.JuF = true;
    AppMethodBeat.o(193794);
  }
  
  public final void DM(long paramLong)
  {
    AppMethodBeat.i(33911);
    if (this.JuD != null) {
      this.JuD.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(33911);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(33903);
    det();
    setCursor(ag.aGc().El(this.nZh));
    if (this.JaF != null) {
      this.JaF.aSs();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33903);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(33909);
    Zu();
    AppMethodBeat.o(33909);
  }
  
  public final com.tencent.mm.am.a.a a(com.tencent.mm.am.a.a parama, Cursor paramCursor)
  {
    AppMethodBeat.i(193791);
    com.tencent.mm.am.a.a locala = parama;
    if (parama == null)
    {
      locala = new com.tencent.mm.am.a.a();
      this.JuG = locala.field_bizChatId;
    }
    locala.field_bizChatId = this.JuG;
    locala.convertFrom(paramCursor);
    AppMethodBeat.o(193791);
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
    AppMethodBeat.i(193792);
    fzP();
    AppMethodBeat.o(193792);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(193793);
    fzP();
    AppMethodBeat.o(193793);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(193789);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(193789);
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
        if (com.tencent.mm.cc.a.im(this.Juv))
        {
          paramView = View.inflate(this.Juv, 2131493663, null);
          paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.JuK = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.JuL = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.JuM = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.nUD = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.nUD.setBackgroundResource(u.kE(this.Juv));
          paramViewGroup.nUD.setTextSize(0, com.tencent.mm.cc.a.ay(this.Juv, 2131166949) * com.tencent.mm.cc.a.ik(this.Juv));
          paramViewGroup.JuN = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.JuP = paramView.findViewById(2131297015);
          paramViewGroup.JuO = ((ImageView)paramView.findViewById(2131305672));
          paramView.setTag(paramViewGroup);
          paramViewGroup.JuM.setTextSize(0, this.Juz);
          paramViewGroup.JuL.setTextSize(0, this.JuA);
          paramViewGroup.JuK.setTextSize(0, this.Juw);
          paramViewGroup.JuM.setTextColor(this.JuB[0]);
          paramViewGroup.JuL.setTextColor(this.JuB[4]);
          paramViewGroup.JuK.setTextColor(this.JuB[3]);
          paramViewGroup.JuM.setShouldEllipsize(true);
          paramViewGroup.JuL.setShouldEllipsize(false);
          paramViewGroup.JuK.setShouldEllipsize(true);
          paramViewGroup.JuL.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.am.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.JuD.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          localObject2 = ag.aGb().bd(l);
          if (((com.tencent.mm.am.a.c)localObject2).isGroup())
          {
            ((a)localObject1).fJG = ((com.tencent.mm.am.a.c)localObject2).field_chatName;
            ((a)localObject1).fMP = ((com.tencent.mm.am.a.c)localObject2).hj(1);
            ((a)localObject1).hDQ = ((com.tencent.mm.am.a.c)localObject2).field_headImageUrl;
            label421:
            if (bt.isNullOrNil(((a)localObject1).fJG)) {
              ((a)localObject1).fJG = this.Juv.getString(2131762623);
            }
            ((a)localObject1).fVk = ((com.tencent.mm.am.a.c)localObject2).field_roomflag;
            ((a)localObject1).JuI = ((com.tencent.mm.am.a.a)localObject3);
            this.JuD.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          ag.aGc();
          ((a)localObject1).JuH = com.tencent.mm.am.a.b.c((com.tencent.mm.am.a.a)localObject3);
          paramViewGroup.JuO.setVisibility(8);
          localObject3 = paramViewGroup.JuL;
          if (((a)localObject1).JuI.field_status != 1) {
            break label994;
          }
          localObject2 = this.Juv.getString(2131761075);
          label532:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          if (!com.tencent.mm.cc.a.im(this.Juv)) {
            break label1015;
          }
          q.aIJ().a(((a)localObject1).hDQ, paramViewGroup.fOf, this.JuC);
          label568:
          if (!((a)localObject1).fMP) {
            break label1037;
          }
          paramViewGroup.JuN.setVisibility(0);
          label584:
          paramViewGroup.JuK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.Juv, ((a)localObject1).fJG, (int)paramViewGroup.JuK.getTextSize()));
          localObject2 = a(((a)localObject1).JuI, (int)paramViewGroup.JuM.getTextSize(), ((a)localObject1).fJG);
          switch (((a)localObject1).JuI.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label682:
            localObject3 = (Integer)this.Juy.get(a.a.oZ(((a)localObject1).fVk));
            if (localObject3 != null)
            {
              paramViewGroup.JuK.setCompoundDrawablePadding(this.Jux);
              paramViewGroup.JuK.setCompoundRightDrawablesWithIntrinsicBounds(((Integer)localObject3).intValue());
              paramViewGroup.JuK.setDrawRightDrawable(true);
              label738:
              if (paramInt == -1) {
                break label1084;
              }
              paramViewGroup.JuM.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.JuM.setDrawLeftDrawable(true);
              label759:
              paramViewGroup.JuM.setText((CharSequence)localObject2);
              paramViewGroup.JuM.setTextColor(com.tencent.mm.cc.a.m(this.Juv, 2131100642));
              if ((WF(((a)localObject1).JuI.field_msgType) == 34) && (((a)localObject1).JuI.field_isSend == 0) && (!bt.isNullOrNil(((a)localObject1).JuI.field_content)) && (!new p(((a)localObject1).JuI.field_content).itZ)) {
                paramViewGroup.JuM.setTextColor(com.tencent.mm.cc.a.m(this.Juv, 2131100643));
              }
              if (!((a)localObject1).fMP) {
                break label1106;
              }
              if (((a)localObject1).JuI.field_unReadCount <= 0) {
                break label1095;
              }
              paramViewGroup.JuP.setVisibility(0);
              label890:
              paramViewGroup.nUD.setVisibility(4);
              label898:
              if (!((a)localObject1).JuH) {
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
          paramView = View.inflate(this.Juv, 2131493662, null);
          break;
          com.tencent.mm.am.a.k localk = ag.aGd().eK(((com.tencent.mm.am.a.c)localObject2).field_bizChatServId);
          if (localk == null) {
            break label421;
          }
          ((a)localObject1).fJG = localk.field_userName;
          ((a)localObject1).fMP = localk.hj(1);
          ((a)localObject1).hDQ = localk.field_headImageUrl;
          break label421;
          label994:
          localObject2 = i.c(this.Juv, ((a)localObject1).JuI.field_lastMsgTime, true);
          break label532;
          label1015:
          q.aIJ().a(((a)localObject1).hDQ, paramViewGroup.fOf, this.fSr);
          break label568;
          label1037:
          paramViewGroup.JuN.setVisibility(8);
          break label584;
          paramInt = -1;
          break label682;
          paramInt = 2131690878;
          break label682;
          paramInt = -1;
          break label682;
          paramInt = 2131690877;
          break label682;
          paramViewGroup.JuK.setDrawRightDrawable(false);
          break label738;
          label1084:
          paramViewGroup.JuM.setDrawLeftDrawable(false);
          break label759;
          label1095:
          paramViewGroup.JuP.setVisibility(4);
          break label890;
          label1106:
          paramViewGroup.JuP.setVisibility(4);
          if (((a)localObject1).JuI.field_unReadCount > 99)
          {
            paramViewGroup.nUD.setText("");
            paramViewGroup.nUD.setBackgroundResource(2131689744);
            paramViewGroup.nUD.setVisibility(0);
            ad.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label898;
          }
          if (((a)localObject1).JuI.field_unReadCount > 0)
          {
            paramViewGroup.nUD.setText(((a)localObject1).JuI.field_unReadCount);
            paramViewGroup.nUD.setVisibility(0);
            paramViewGroup.nUD.setBackgroundResource(u.aP(this.Juv, ((a)localObject1).JuI.field_unReadCount));
            ad.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label898;
          }
          paramViewGroup.nUD.setVisibility(4);
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
    AppMethodBeat.i(193795);
    if (this.JuD != null)
    {
      this.JuD.clear();
      this.JuD = null;
    }
    ag.aGc().remove(this);
    ag.aGc().a(this);
    AppMethodBeat.o(193795);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33904);
    if (this.nUz != null) {
      this.nUz.deC();
    }
    this.JuE = false;
    AppMethodBeat.o(33904);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(193790);
    this.JuE = true;
    if (this.JuF)
    {
      super.a(null, null);
      this.JuF = false;
    }
    AppMethodBeat.o(193790);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  final class a
  {
    public boolean JuH;
    public com.tencent.mm.am.a.a JuI;
    String fJG = null;
    public boolean fMP;
    int fVk = 0;
    String hDQ = null;
    
    private a() {}
  }
  
  public static final class b
  {
    public NoMeasuredTextView JuK;
    public NoMeasuredTextView JuL;
    public NoMeasuredTextView JuM;
    public ImageView JuN;
    public ImageView JuO;
    public View JuP;
    public ImageView fOf;
    public TextView nUD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */