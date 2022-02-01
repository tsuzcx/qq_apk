package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class e
  extends a
{
  private static final Pattern iCc;
  public String IzN;
  public boolean IzO;
  public boolean IzP;
  private b IzQ;
  private a IzR;
  public CharSequence gIg;
  public CharSequence iCd;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    iCc = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public e(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.IzQ = new b();
    this.IzR = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.jPN != null)
    {
      i = j;
      if (this.contact == null)
      {
        g.agS();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNn(this.jPN.sxG);
        i = j;
        if (this.contact == null)
        {
          g.agS();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNs(this.jPN.sxG);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      ac.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(102948);
      return;
    }
    this.username = this.contact.field_username;
    this.IzN = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(this.contact.field_openImAppid, this.contact.field_descWordingId);
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject3;
    CharSequence localCharSequence;
    Iterator localIterator;
    int k;
    int m;
    boolean bool6;
    boolean bool5;
    boolean bool7;
    boolean bool3;
    boolean bool4;
    boolean bool8;
    Resources localResources;
    String str;
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      localm = this.jPN;
      localObject3 = this.contact;
      localCharSequence = null;
      localIterator = null;
      k = 0;
      m = 0;
      bool6 = false;
      bool5 = false;
      bool7 = false;
      bool3 = false;
      bool4 = false;
      bool8 = false;
      localResources = paramContext.getResources();
      if (localObject3 == null) {
        break label1179;
      }
      str = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b((ai)localObject3, ((av)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localm.sxF)
      {
      default: 
        localObject2 = str;
        localObject1 = localCharSequence;
        parama = localIterator;
        j = k;
        i = m;
        bool2 = bool7;
        bool1 = bool8;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        ac.d("MicroMsg.ContactDataItem", "highlight first line");
        this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cc.a.au(paramContext, 2131165517));
        this.iCd = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.iCd, this.sxM, bool2, bool1)).syd;
        label459:
        if (i == 0) {
          break label1065;
        }
        ac.d("MicroMsg.ContactDataItem", "highlight second line");
        this.gIg = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cc.a.au(paramContext, 2131165466));
        this.gIg = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.gIg, this.sxM, bool2, bool1)).syd;
        label510:
        if ((!bs.isNullOrNil((String)localObject1)) && (this.gIg != null)) {
          this.gIg = TextUtils.concat(new CharSequence[] { localObject1, this.gIg });
        }
        AppMethodBeat.o(102948);
        return;
        bool1 = true;
      }
      label557:
      for (bool2 = true;; bool2 = bool6)
      {
        j = 1;
        i = m;
        parama = localIterator;
        localObject1 = localCharSequence;
        localObject2 = str;
        break;
        bool3 = true;
        bool5 = true;
        bool4 = bool3;
        parama = ((av)localObject3).field_nickname;
        localObject1 = localResources.getString(2131762930);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((av)localObject3).eyf;
        localObject1 = localResources.getString(2131762925);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((ai)localObject3).Tl();
        parama = (a.a)localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          parama = ((av)localObject3).field_username;
        }
        localObject1 = localResources.getString(2131762935);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localm.content;
        if (!bs.isNullOrNil(parama))
        {
          localObject2 = parama.split("​");
          j = localObject2.length;
          i = 0;
          label744:
          if (i < j)
          {
            localObject1 = localObject2[i];
            if (((String)localObject1).startsWith(this.query)) {
              parama = (a.a)localObject1;
            }
          }
        }
        for (;;)
        {
          localObject1 = localResources.getString(2131762929);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          i += 1;
          break label744;
          parama = localm.content;
          localObject1 = localResources.getString(2131762927);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          j = 1;
          parama = ((n)g.ad(n.class)).getFTSMainDB().afM(((av)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.sxM.sym;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.afQ((String)localObject3).contains(localCharSequence))
              {
                ((StringBuffer)localObject1).append((String)localObject3);
                ((StringBuffer)localObject1).append(",");
              }
            }
            i += 1;
          }
          ((StringBuffer)localObject1).trimToSize();
          if (((StringBuffer)localObject1).length() == 0) {}
          for (parama = "";; parama = ((StringBuffer)localObject1).substring(0, ((StringBuffer)localObject1).length() - 1))
          {
            localObject1 = localResources.getString(2131762934);
            bool1 = bool8;
            bool2 = bool7;
            i = j;
            j = k;
            localObject2 = str;
            break;
          }
          this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cc.a.au(paramContext, 2131165517));
          break label459;
          this.gIg = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cc.a.au(paramContext, 2131165466));
          break label510;
          if (bs.isNullOrNil(this.dby)) {}
          for (parama = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact);; parama = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.contact.field_username, this.dby))
          {
            this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cc.a.au(paramContext, 2131165517));
            AppMethodBeat.o(102948);
            return;
          }
        }
        bool1 = false;
        break label557;
        bool1 = false;
      }
      label1065:
      localObject2 = null;
      label1179:
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
    }
  }
  
  public a.b aOg()
  {
    return this.IzQ;
  }
  
  public a.a dyv()
  {
    return this.IzR;
  }
  
  public class a
    extends a.a
  {
    public ImageView IzS;
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public TextView iCh;
    public CheckBox iCi;
    public TextView ijE;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102944);
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (e.a)e.this.dyv();
        paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iCi = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.IzS = ((ImageView)paramContext.findViewById(2131304538));
        paramViewGroup.iCh = ((TextView)paramContext.findViewById(2131303032));
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(102944);
        return paramContext;
      }
    }
    
    public void a(final Context paramContext, final a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102945);
      parama = (e.a)parama;
      final e locale = (e)parama1;
      CheckBox localCheckBox;
      int i;
      if ((locale.username != null) && (locale.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fuY, locale.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(locale.iCd, parama.iCg);
        com.tencent.mm.plugin.fts.ui.m.a(locale.gIg, parama.ijE);
        if (!e.this.Iwh) {
          break label392;
        }
        parama.iCi.setBackgroundResource(2131233261);
        if (!paramBoolean1) {
          break label372;
        }
        parama.iCi.setChecked(true);
        parama.iCi.setEnabled(false);
        localCheckBox = parama.iCi;
        if (!aj.DT()) {
          break label365;
        }
        i = 2131689939;
        label132:
        localCheckBox.setBackgroundResource(i);
        label139:
        parama.iCi.setVisibility(0);
        label147:
        if (e.this.IzP)
        {
          parama.iCi.setVisibility(8);
          parama.IzS.setVisibility(8);
        }
        if (!e.this.nww) {
          break label552;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (locale.contact.field_deleteFlag == 1)
        {
          parama.ijE.setVisibility(0);
          parama.ijE.setText(paramContext.getString(2131762978));
        }
        if ((!e.this.IzO) && (parama.iCh != null))
        {
          parama.iCh.setVisibility(8);
          if ((ai.aNc(locale.username)) && (!bs.isNullOrNil(locale.IzN))) {
            parama.iCg.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.iCg.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + locale.IzN;
                  int j = com.tencent.mm.cc.a.au(paramContext, 2131165257);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.iCg.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(locale.iCd, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.cc.a.m(paramContext, 2131100724);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.cg.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject2, parama.iCg);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(locale.iCd, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ac.e("MicroMsg.ContactDataItem", "fillingViewItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
                  AppMethodBeat.o(102943);
                }
              }
            });
          }
        }
        if (!parama1.IzB) {
          break label583;
        }
        parama.fuY.setAlpha(0.3F);
        parama.iCg.setAlpha(0.3F);
        parama.ijE.setAlpha(0.3F);
        parama.iCi.setAlpha(0.3F);
        parama.iCh.setAlpha(0.3F);
        AppMethodBeat.o(102945);
        return;
        parama.fuY.setImageResource(2131231875);
        break;
        label365:
        i = 2131689938;
        break label132;
        label372:
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
        break label139;
        label392:
        if (e.this.IzA)
        {
          parama.iCi.setBackgroundResource(2131233872);
          if (paramBoolean1)
          {
            parama.iCi.setChecked(true);
            parama.iCi.setEnabled(false);
            localCheckBox = parama.iCi;
            if (aj.DT())
            {
              i = 2131689939;
              label448:
              localCheckBox.setBackgroundResource(i);
            }
          }
          for (;;)
          {
            parama.iCi.setVisibility(0);
            break;
            i = 2131689938;
            break label448;
            parama.iCi.setChecked(paramBoolean2);
            parama.iCi.setEnabled(true);
          }
        }
        if (e.this.Iwi)
        {
          parama.iCi.setVisibility(8);
          if (paramBoolean2)
          {
            parama.IzS.setVisibility(0);
            break label147;
          }
          parama.IzS.setVisibility(8);
          break label147;
        }
        parama.iCi.setVisibility(8);
        break label147;
        label552:
        if (parama1.IzC) {
          parama.contentView.setBackgroundResource(2131231136);
        } else {
          parama.contentView.setBackgroundResource(2131231818);
        }
      }
      label583:
      parama.fuY.setAlpha(1.0F);
      parama.iCg.setAlpha(1.0F);
      parama.ijE.setAlpha(1.0F);
      parama.iCi.setAlpha(1.0F);
      parama.iCh.setAlpha(1.0F);
      AppMethodBeat.o(102945);
    }
    
    public final boolean aOh()
    {
      AppMethodBeat.i(102946);
      if (e.this.jPN != null) {
        ((n)g.ad(n.class)).updateTopHitsRank(e.this.query, e.this.jPN, 1);
      }
      AppMethodBeat.o(102946);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */