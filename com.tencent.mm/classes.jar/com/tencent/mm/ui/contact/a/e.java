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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class e
  extends a
{
  private static final Pattern ibV;
  public String GZv;
  public boolean GZw;
  public boolean GZx;
  private b GZy;
  private a GZz;
  public CharSequence ibW;
  public CharSequence ibX;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    ibV = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public e(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.GZy = new b();
    this.GZz = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.jpy != null)
    {
      i = j;
      if (this.contact == null)
      {
        g.afC();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHS(this.jpy.roN);
        i = j;
        if (this.contact == null)
        {
          g.afC();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHX(this.jpy.roN);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      ad.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(102948);
      return;
    }
    this.username = this.contact.field_username;
    this.GZv = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(this.contact.field_openImAppid, this.contact.field_descWordingId);
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
      localm = this.jpy;
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
      str = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b((af)localObject3, ((au)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localm.roM)
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
        ad.d("MicroMsg.ContactDataItem", "highlight first line");
        this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        this.ibW = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.ibW, this.roS, bool2, bool1)).rpj;
        label459:
        if (i == 0) {
          break label1065;
        }
        ad.d("MicroMsg.ContactDataItem", "highlight second line");
        this.ibX = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
        this.ibX = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.ibX, this.roS, bool2, bool1)).rpj;
        label510:
        if ((!bt.isNullOrNil((String)localObject1)) && (this.ibX != null)) {
          this.ibX = TextUtils.concat(new CharSequence[] { localObject1, this.ibX });
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
        parama = ((au)localObject3).field_nickname;
        localObject1 = localResources.getString(2131762930);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((au)localObject3).evI;
        localObject1 = localResources.getString(2131762925);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((af)localObject3).Ss();
        parama = (a.a)localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          parama = ((au)localObject3).field_username;
        }
        localObject1 = localResources.getString(2131762935);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localm.content;
        if (!bt.isNullOrNil(parama))
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
          parama = ((n)g.ad(n.class)).getFTSMainDB().aaU(((au)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.roS.rps;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.aaY((String)localObject3).contains(localCharSequence))
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
          this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
          break label459;
          this.ibX = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
          break label510;
          if (bt.isNullOrNil(this.dec)) {}
          for (parama = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact);; parama = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.contact.field_username, this.dec))
          {
            this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
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
  
  public a.b aHr()
  {
    return this.GZy;
  }
  
  public a.a dkt()
  {
    return this.GZz;
  }
  
  public class a
    extends a.a
  {
    public TextView GSx;
    public ImageView GZA;
    public View contentView;
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public CheckBox icb;
    
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
      if (com.tencent.mm.cd.a.hS(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (e.a)e.this.dkt();
        paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.icb = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.GZA = ((ImageView)paramContext.findViewById(2131304538));
        paramViewGroup.GSx = ((TextView)paramContext.findViewById(2131303032));
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(102944);
        return paramContext;
      }
    }
    
    public void a(final Context paramContext, final a.a parama, final a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      int i = 2131689938;
      AppMethodBeat.i(102945);
      parama = (e.a)parama;
      parama1 = (e)parama1;
      CheckBox localCheckBox;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.frr, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibW, parama.ica);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibX, parama.hJe);
        if (!e.this.GVT) {
          break label327;
        }
        parama.icb.setBackgroundResource(2131233261);
        if (!paramBoolean1) {
          break label307;
        }
        parama.icb.setChecked(true);
        parama.icb.setEnabled(false);
        localCheckBox = parama.icb;
        if (ai.Eq()) {
          i = 2131689939;
        }
        localCheckBox.setBackgroundResource(i);
        label137:
        parama.icb.setVisibility(0);
        label145:
        if (e.this.GZx)
        {
          parama.icb.setVisibility(8);
          parama.GZA.setVisibility(8);
        }
        if (!e.this.mUe) {
          break label480;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.hJe.setVisibility(0);
          parama.hJe.setText(paramContext.getString(2131762978));
        }
        if ((!e.this.GZw) && (parama.GSx != null))
        {
          parama.GSx.setVisibility(8);
          if ((af.aHH(parama1.username)) && (!bt.isNullOrNil(parama1.GZv))) {
            parama.ica.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.ica.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + parama1.GZv;
                  int j = com.tencent.mm.cd.a.ao(paramContext, 2131165257);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.ica.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(parama1.ibW, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.cd.a.m(paramContext, 2131100724);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.ch.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject2, parama.ica);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(parama1.ibW, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ad.e("MicroMsg.ContactDataItem", "fillingViewItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
                  AppMethodBeat.o(102943);
                }
              }
            });
          }
        }
        AppMethodBeat.o(102945);
        return;
        parama.frr.setImageResource(2131231875);
        break;
        label307:
        parama.icb.setChecked(paramBoolean2);
        parama.icb.setEnabled(true);
        break label137;
        label327:
        if (e.this.GZk)
        {
          parama.icb.setBackgroundResource(2131233872);
          if (paramBoolean1)
          {
            parama.icb.setChecked(true);
            parama.icb.setEnabled(false);
            localCheckBox = parama.icb;
            if (ai.Eq()) {
              i = 2131689939;
            }
            localCheckBox.setBackgroundResource(i);
          }
          for (;;)
          {
            parama.icb.setVisibility(0);
            break;
            parama.icb.setChecked(paramBoolean2);
            parama.icb.setEnabled(true);
          }
        }
        if (e.this.GVU)
        {
          parama.icb.setVisibility(8);
          if (paramBoolean2)
          {
            parama.GZA.setVisibility(0);
            break label145;
          }
          parama.GZA.setVisibility(8);
          break label145;
        }
        parama.icb.setVisibility(8);
        break label145;
        label480:
        parama.contentView.setBackgroundResource(2131231818);
      }
    }
    
    public final boolean aHs()
    {
      AppMethodBeat.i(102946);
      if (e.this.jpy != null) {
        ((n)g.ad(n.class)).updateTopHitsRank(e.this.query, e.this.jpy, 1);
      }
      AppMethodBeat.o(102946);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */