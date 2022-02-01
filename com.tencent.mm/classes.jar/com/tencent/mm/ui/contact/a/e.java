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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class e
  extends a
{
  private static final Pattern iYf;
  public String KNn;
  public boolean KNo;
  public boolean KNp;
  private b KNq;
  private a KNr;
  public CharSequence heE;
  public CharSequence iYg;
  public m kno;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    iYf = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public e(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.KNq = new b();
    this.KNr = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.kno != null)
    {
      i = j;
      if (this.contact == null)
      {
        g.ajS();
        this.contact = ((l)g.ab(l.class)).azF().aUG(this.kno.tEY);
        i = j;
        if (this.contact == null)
        {
          g.ajS();
          this.contact = ((l)g.ab(l.class)).azF().aUL(this.kno.tEY);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      ae.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(102948);
      return;
    }
    this.username = this.contact.field_username;
    this.KNn = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(this.contact.field_openImAppid, this.contact.field_descWordingId);
    m localm;
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
      localm = this.kno;
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
      str = ((b)g.ab(b.class)).b((an)localObject3, ((aw)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localm.tEX)
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
        ae.d("MicroMsg.ContactDataItem", "highlight first line");
        this.iYg = k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        this.iYg = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.iYg, this.tFe, bool2, bool1)).tFv;
        label459:
        if (i == 0) {
          break label1065;
        }
        ae.d("MicroMsg.ContactDataItem", "highlight second line");
        this.heE = k.b(paramContext, parama, com.tencent.mm.cb.a.ax(paramContext, 2131165466));
        this.heE = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.heE, this.tFe, bool2, bool1)).tFv;
        label510:
        if ((!bu.isNullOrNil((String)localObject1)) && (this.heE != null)) {
          this.heE = TextUtils.concat(new CharSequence[] { localObject1, this.heE });
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
        parama = ((aw)localObject3).field_nickname;
        localObject1 = localResources.getString(2131762930);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((aw)localObject3).eRo;
        localObject1 = localResources.getString(2131762925);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((an)localObject3).VI();
        parama = (a.a)localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          parama = ((aw)localObject3).field_username;
        }
        localObject1 = localResources.getString(2131762935);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localm.content;
        if (!bu.isNullOrNil(parama))
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
          parama = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().ali(((aw)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.tFe.tFE;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.alm((String)localObject3).contains(localCharSequence))
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
          this.iYg = k.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
          break label459;
          this.heE = k.b(paramContext, parama, com.tencent.mm.cb.a.ax(paramContext, 2131165466));
          break label510;
          if (bu.isNullOrNil(this.dnW)) {}
          for (parama = ((b)g.ab(b.class)).b(this.contact);; parama = ((b)g.ab(b.class)).getDisplayName(this.contact.field_username, this.dnW))
          {
            this.iYg = k.b(paramContext, parama, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
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
  
  public a.b aRR()
  {
    return this.KNq;
  }
  
  public a.a dNf()
  {
    return this.KNr;
  }
  
  public class a
    extends a.a
  {
    public ImageView KNs;
    public View contentView;
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    public TextView iYk;
    public CheckBox iYl;
    
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
      if (com.tencent.mm.cb.a.ir(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (e.a)e.this.dNf();
        paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iYl = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.KNs = ((ImageView)paramContext.findViewById(2131304538));
        paramViewGroup.iYk = ((TextView)paramContext.findViewById(2131303032));
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fQl, locale.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(locale.iYg, parama.iYj);
        com.tencent.mm.plugin.fts.ui.n.a(locale.heE, parama.iFO);
        if (!e.this.KJj) {
          break label399;
        }
        parama.iYl.setBackgroundResource(2131233261);
        if (!paramBoolean1) {
          break label379;
        }
        parama.iYl.setChecked(true);
        parama.iYl.setEnabled(false);
        localCheckBox = parama.iYl;
        if (!al.isDarkMode()) {
          break label372;
        }
        i = 2131689939;
        label132:
        localCheckBox.setBackgroundResource(i);
        label139:
        parama.iYl.setVisibility(0);
        label147:
        if (e.this.KNp)
        {
          parama.iYl.setVisibility(8);
          parama.KNs.setVisibility(8);
        }
        if (!e.this.odD) {
          break label559;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (locale.contact.field_deleteFlag == 1)
        {
          parama.iFO.setVisibility(0);
          parama.iFO.setText(paramContext.getString(2131762978));
        }
        if ((!e.this.KNo) && (parama.iYk != null))
        {
          parama.iYk.setVisibility(8);
          if ((an.aUq(locale.username)) && (!bu.isNullOrNil(locale.KNn))) {
            parama.iYj.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.iYj.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + locale.KNn;
                  int j = com.tencent.mm.cb.a.ax(paramContext, 2131165257);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.iYj.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(locale.iYg, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = k.c(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.cb.a.m(paramContext, 2131100724);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.cf.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.n.a((CharSequence)localObject2, parama.iYj);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(locale.iYg, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ae.e("MicroMsg.ContactDataItem", "fillingViewItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
                  AppMethodBeat.o(102943);
                }
              }
            });
          }
        }
        if (!parama1.KNb) {
          break label590;
        }
        parama.fQl.setAlpha(0.3F);
        parama.iYj.setAlpha(0.3F);
        parama.iFO.setAlpha(0.3F);
        parama.iYl.setAlpha(0.3F);
        if (parama.iYk == null) {
          break label637;
        }
        parama.iYk.setAlpha(0.3F);
        AppMethodBeat.o(102945);
        return;
        parama.fQl.setImageResource(2131231875);
        break;
        label372:
        i = 2131689938;
        break label132;
        label379:
        parama.iYl.setChecked(paramBoolean2);
        parama.iYl.setEnabled(true);
        break label139;
        label399:
        if (e.this.KNa)
        {
          parama.iYl.setBackgroundResource(2131233872);
          if (paramBoolean1)
          {
            parama.iYl.setChecked(true);
            parama.iYl.setEnabled(false);
            localCheckBox = parama.iYl;
            if (al.isDarkMode())
            {
              i = 2131689939;
              label455:
              localCheckBox.setBackgroundResource(i);
            }
          }
          for (;;)
          {
            parama.iYl.setVisibility(0);
            break;
            i = 2131689938;
            break label455;
            parama.iYl.setChecked(paramBoolean2);
            parama.iYl.setEnabled(true);
          }
        }
        if (e.this.KJk)
        {
          parama.iYl.setVisibility(8);
          if (paramBoolean2)
          {
            parama.KNs.setVisibility(0);
            break label147;
          }
          parama.KNs.setVisibility(8);
          break label147;
        }
        parama.iYl.setVisibility(8);
        break label147;
        label559:
        if (parama1.KNc) {
          parama.contentView.setBackgroundResource(2131231136);
        } else {
          parama.contentView.setBackgroundResource(2131231818);
        }
      }
      label590:
      parama.fQl.setAlpha(1.0F);
      parama.iYj.setAlpha(1.0F);
      parama.iFO.setAlpha(1.0F);
      parama.iYl.setAlpha(1.0F);
      if (parama.iYk != null) {
        parama.iYk.setAlpha(1.0F);
      }
      label637:
      AppMethodBeat.o(102945);
    }
    
    public final boolean aRS()
    {
      AppMethodBeat.i(102946);
      if (e.this.kno != null) {
        ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(e.this.query, e.this.kno, 1);
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