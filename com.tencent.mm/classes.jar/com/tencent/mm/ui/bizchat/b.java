package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.tools.t;
import java.util.HashMap;

public final class b
  extends com.tencent.mm.ui.p<com.tencent.mm.aj.a.a>
  implements n.b
{
  private com.tencent.mm.at.a.a.c eiK;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  private final String jUE;
  private final MMFragmentActivity zsZ;
  private float zta;
  private float ztb;
  private float ztc;
  private ColorStateList[] ztd;
  HashMap<String, a> zte;
  
  public b(Context paramContext, p.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.aj.a.a());
    AppMethodBeat.i(30044);
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.zta = -1.0F;
    this.ztb = -1.0F;
    this.ztc = -1.0F;
    this.ztd = new ColorStateList[5];
    this.eiK = null;
    super.a(parama);
    this.zsZ = ((MMFragmentActivity)paramContext);
    this.jUE = paramString;
    this.zte = new HashMap();
    this.ztd[0] = com.tencent.mm.cb.a.l(paramContext, 2131690168);
    this.ztd[1] = com.tencent.mm.cb.a.l(paramContext, 2131690773);
    this.ztd[3] = com.tencent.mm.cb.a.l(paramContext, 2131690322);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[4] = com.tencent.mm.cb.a.l(paramContext, 2131690210);
    this.zta = com.tencent.mm.cb.a.ao(paramContext, 2131427809);
    this.ztb = com.tencent.mm.cb.a.ao(paramContext, 2131427758);
    this.ztc = com.tencent.mm.cb.a.ao(paramContext, 2131427862);
    paramContext = new c.a();
    paramContext.eNP = e.cV(this.jUE);
    paramContext.eNM = true;
    paramContext.eOe = true;
    paramContext.eNY = 2131231207;
    this.eiK = paramContext.ahY();
    AppMethodBeat.o(30044);
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(30050);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(30050);
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
  
  private CharSequence a(com.tencent.mm.aj.a.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(30049);
    if ((!bo.isNullOrNil(parama.field_editingMsg)) && ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.zsZ.getString(2131301401));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.zsZ, parama.field_editingMsg, paramInt));
      AppMethodBeat.o(30049);
      return paramString;
    }
    Object localObject;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = atE(parama.field_digest);
      str1 = "";
      if (localObject != null)
      {
        parama = "[" + (String)localObject + "]";
        AppMethodBeat.o(30049);
        return parama;
      }
      localObject = str1;
      if (parama.field_digest != null)
      {
        localObject = str1;
        if (parama.field_digest.contains(":"))
        {
          str1 = parama.field_digest.substring(0, parama.field_digest.indexOf(":"));
          String str2 = atE(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bo.isNullOrNil(str1))
            {
              AppMethodBeat.o(30049);
              return parama;
            }
            parama = str1 + ": " + parama;
            AppMethodBeat.o(30049);
            return parama;
          }
        }
      }
      str1 = this.zsZ.getString(2131296915);
      if (bo.isNullOrNil((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bo.isNullOrNil(parama.field_digest)) {
        break label537;
      }
      if (bo.isNullOrNil(parama.field_digestUser)) {
        break label529;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)) {
          break label543;
        }
        parama = new SpannableStringBuilder(this.zsZ.getString(2131301397));
        parama.setSpan(new ForegroundColorSpan(-5569532), 0, parama.length(), 33);
        parama.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.zsZ, paramString, paramInt));
        AppMethodBeat.o(30049);
        return parama;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label529:
      paramString = parama.field_digest;
      continue;
      label537:
      paramString = "";
    }
    label543:
    parama = com.tencent.mm.pluginsdk.ui.d.j.b(this.zsZ, paramString, paramInt);
    AppMethodBeat.o(30049);
    return parama;
  }
  
  private static String atE(String paramString)
  {
    AppMethodBeat.i(30048);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(30048);
      return paramString;
    }
    AppMethodBeat.o(30048);
    return null;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(30045);
    bKb();
    setCursor(z.afl().si(this.jUE));
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(30045);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(30051);
    Ku();
    AppMethodBeat.o(30051);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(30052);
    super.a(paramInt, paramn, paramObject);
    AppMethodBeat.o(30052);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30047);
    Object localObject3 = (com.tencent.mm.aj.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b.b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b.b();
        if (com.tencent.mm.cb.a.gt(this.zsZ))
        {
          paramView = View.inflate(this.zsZ, 2130969275, null);
          paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
          paramViewGroup.zti = ((NoMeasuredTextView)paramView.findViewById(2131823254));
          paramViewGroup.ztj = ((NoMeasuredTextView)paramView.findViewById(2131823255));
          paramViewGroup.ztk = ((NoMeasuredTextView)paramView.findViewById(2131823256));
          paramViewGroup.jSi = ((TextView)paramView.findViewById(2131821087));
          paramViewGroup.jSi.setBackgroundResource(t.iF(this.zsZ));
          paramViewGroup.jSi.setTextSize(0, com.tencent.mm.cb.a.ap(this.zsZ, 2131428775) * com.tencent.mm.cb.a.gr(this.zsZ));
          paramViewGroup.ztl = ((ImageView)paramView.findViewById(2131823258));
          paramViewGroup.ztn = paramView.findViewById(2131823253);
          paramViewGroup.ztm = ((ImageView)paramView.findViewById(2131823259));
          paramView.setTag(paramViewGroup);
          paramViewGroup.ztk.setTextSize(0, this.ztb);
          paramViewGroup.ztj.setTextSize(0, this.ztc);
          paramViewGroup.zti.setTextSize(0, this.zta);
          paramViewGroup.ztk.setTextColor(this.ztd[0]);
          paramViewGroup.ztj.setTextColor(this.ztd[4]);
          paramViewGroup.zti.setTextColor(this.ztd[3]);
          paramViewGroup.ztk.setShouldEllipsize(true);
          paramViewGroup.ztj.setShouldEllipsize(false);
          paramViewGroup.zti.setShouldEllipsize(true);
          paramViewGroup.ztj.setGravity(5);
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.aj.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.zte.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          z.afl();
          ((a)localObject1).ztf = com.tencent.mm.aj.a.b.c((com.tencent.mm.aj.a.a)localObject3);
          localObject2 = z.afk().aG(l);
          if (((com.tencent.mm.aj.a.c)localObject2).isGroup())
          {
            ((a)localObject1).edK = ((com.tencent.mm.aj.a.c)localObject2).field_chatName;
            ((a)localObject1).efg = ((com.tencent.mm.aj.a.c)localObject2).kY(1);
            ((a)localObject1).hAq = ((com.tencent.mm.aj.a.c)localObject2).field_headImageUrl;
            label435:
            if (bo.isNullOrNil(((a)localObject1).edK)) {
              ((a)localObject1).edK = this.zsZ.getString(2131302712);
            }
            ((a)localObject1).ztg = ((com.tencent.mm.aj.a.a)localObject3);
            this.zte.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          paramViewGroup.ztm.setVisibility(8);
          localObject3 = paramViewGroup.ztj;
          if (((a)localObject1).ztg.field_status != 1) {
            break label926;
          }
          localObject2 = this.zsZ.getString(2131301428);
          label522:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          o.ahG().a(((a)localObject1).hAq, paramViewGroup.egq, this.eiK);
          if (!((a)localObject1).efg) {
            break label947;
          }
          paramViewGroup.ztl.setVisibility(0);
          label564:
          paramViewGroup.zti.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.zsZ, ((a)localObject1).edK, (int)paramViewGroup.zti.getTextSize()));
          localObject2 = a(((a)localObject1).ztg, (int)paramViewGroup.ztk.getTextSize(), ((a)localObject1).edK);
          switch (((a)localObject1).ztg.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label662:
            paramViewGroup.zti.setDrawRightDrawable(false);
            if (paramInt != -1)
            {
              paramViewGroup.ztk.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
              paramViewGroup.ztk.setDrawLeftDrawable(true);
              label691:
              paramViewGroup.ztk.setText((CharSequence)localObject2);
              paramViewGroup.ztk.setTextColor(com.tencent.mm.cb.a.l(this.zsZ, 2131690772));
              if ((GH(((a)localObject1).ztg.field_msgType) == 34) && (((a)localObject1).ztg.field_isSend == 0) && (!bo.isNullOrNil(((a)localObject1).ztg.field_content)) && (!new com.tencent.mm.modelvoice.p(((a)localObject1).ztg.field_content).fXr)) {
                paramViewGroup.ztk.setTextColor(com.tencent.mm.cb.a.l(this.zsZ, 2131690773));
              }
              if (!((a)localObject1).efg) {
                break label1005;
              }
              if (((a)localObject1).ztg.field_unReadCount <= 0) {
                break label994;
              }
              paramViewGroup.ztn.setVisibility(0);
              label822:
              paramViewGroup.jSi.setVisibility(4);
              label830:
              if (!((a)localObject1).ztf) {
                break label1158;
              }
              paramView.findViewById(2131823252).setBackgroundResource(2130838444);
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(30047);
          return paramView;
          paramView = View.inflate(this.zsZ, 2130969274, null);
          break;
          localObject2 = z.afm().df(((com.tencent.mm.aj.a.c)localObject2).field_bizChatServId);
          if (localObject2 == null) {
            break label435;
          }
          ((a)localObject1).edK = ((com.tencent.mm.aj.a.j)localObject2).field_userName;
          ((a)localObject1).efg = ((com.tencent.mm.aj.a.j)localObject2).kY(1);
          ((a)localObject1).hAq = ((com.tencent.mm.aj.a.j)localObject2).field_headImageUrl;
          break label435;
          label926:
          localObject2 = h.c(this.zsZ, ((a)localObject1).ztg.field_lastMsgTime, true);
          break label522;
          label947:
          paramViewGroup.ztl.setVisibility(8);
          break label564;
          paramInt = -1;
          break label662;
          paramInt = 2131231716;
          break label662;
          paramInt = -1;
          break label662;
          paramInt = 2131231715;
          break label662;
          paramViewGroup.ztk.setDrawLeftDrawable(false);
          break label691;
          label994:
          paramViewGroup.ztn.setVisibility(4);
          break label822;
          label1005:
          paramViewGroup.ztn.setVisibility(4);
          if (((a)localObject1).ztg.field_unReadCount > 99)
          {
            paramViewGroup.jSi.setText("");
            paramViewGroup.jSi.setBackgroundResource(2131230963);
            paramViewGroup.jSi.setVisibility(0);
            ab.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label830;
          }
          if (((a)localObject1).ztg.field_unReadCount > 0)
          {
            paramViewGroup.jSi.setText(((a)localObject1).ztg.field_unReadCount);
            paramViewGroup.jSi.setVisibility(0);
            paramViewGroup.jSi.setBackgroundResource(t.iF(this.zsZ));
            ab.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label830;
          }
          paramViewGroup.jSi.setVisibility(4);
          ab.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label830;
          label1158:
          paramView.findViewById(2131823252).setBackgroundResource(2130838445);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(30046);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    AppMethodBeat.o(30046);
  }
  
  public final void ov(long paramLong)
  {
    AppMethodBeat.i(30053);
    if (this.zte != null) {
      this.zte.remove(String.valueOf(paramLong));
    }
    AppMethodBeat.o(30053);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  final class a
  {
    String edK = null;
    public boolean efg;
    String hAq = null;
    public boolean ztf;
    public com.tencent.mm.aj.a.a ztg;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.b
 * JD-Core Version:    0.7.0.1
 */