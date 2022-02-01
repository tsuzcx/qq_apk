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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class e
  extends a
{
  private static final Pattern jVK;
  public String Qan;
  public boolean Qao;
  public boolean Qap;
  private b Qaq;
  private a Qar;
  public CharSequence hXr;
  public CharSequence jVL;
  public m lqW;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    jVK = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public e(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.Qaq = new b();
    this.Qar = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.lqW != null)
    {
      i = j;
      if (this.contact == null)
      {
        g.aAi();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjF(this.lqW.wVX);
        i = j;
        if (this.contact == null)
        {
          g.aAi();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(this.lqW.wVX);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      Log.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(102948);
      return;
    }
    this.username = this.contact.field_username;
    this.Qan = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(this.contact.field_openImAppid, this.contact.field_descWordingId);
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
      localm = this.lqW;
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
      str = ((b)g.af(b.class)).b((as)localObject3, ((ax)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localm.wVW)
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
        Log.d("MicroMsg.ContactDataItem", "highlight first line");
        this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        this.jVL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jVL, this.wWd, bool2, bool1)).wWu;
        label459:
        if (i == 0) {
          break label1065;
        }
        Log.d("MicroMsg.ContactDataItem", "highlight second line");
        this.hXr = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
        this.hXr = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.hXr, this.wWd, bool2, bool1)).wWu;
        label510:
        if ((!Util.isNullOrNil((String)localObject1)) && (this.hXr != null)) {
          this.hXr = TextUtils.concat(new CharSequence[] { localObject1, this.hXr });
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
        parama = ((ax)localObject3).field_nickname;
        localObject1 = localResources.getString(2131765066);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((ax)localObject3).fuR;
        localObject1 = localResources.getString(2131765061);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((as)localObject3).ajx();
        parama = (a.a)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          parama = ((ax)localObject3).field_username;
        }
        localObject1 = localResources.getString(2131765071);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localm.content;
        if (!Util.isNullOrNil(parama))
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
          localObject1 = localResources.getString(2131765065);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          i += 1;
          break label744;
          parama = localm.content;
          localObject1 = localResources.getString(2131765063);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          j = 1;
          parama = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aym(((ax)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.wWd.wWD;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.ayq((String)localObject3).contains(localCharSequence))
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
            localObject1 = localResources.getString(2131765070);
            bool1 = bool8;
            bool2 = bool7;
            i = j;
            j = k;
            localObject2 = str;
            break;
          }
          this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
          break label459;
          this.hXr = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
          break label510;
          if (Util.isNullOrNil(this.dFl)) {}
          for (parama = ((b)g.af(b.class)).b(this.contact);; parama = ((b)g.af(b.class)).getDisplayName(this.contact.field_username, this.dFl))
          {
            this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
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
  
  public a.b bmx()
  {
    return this.Qaq;
  }
  
  public a.a eOf()
  {
    return this.Qar;
  }
  
  public class a
    extends a.a
  {
    public ImageView Qas;
    public View contentView;
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    public TextView jVP;
    public CheckBox jVQ;
    
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
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131496221, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131496220, paramViewGroup, false))
      {
        paramViewGroup = (e.a)e.this.eOf();
        paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
        paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
        paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
        paramViewGroup.contentView = paramContext.findViewById(2131307533);
        paramViewGroup.jVQ = ((CheckBox)paramContext.findViewById(2131307508));
        paramViewGroup.Qas = ((ImageView)paramContext.findViewById(2131307561));
        paramViewGroup.jVP = ((TextView)paramContext.findViewById(2131305635));
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.gvv, locale.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(locale.jVL, parama.jVO);
        com.tencent.mm.plugin.fts.ui.n.a(locale.hXr, parama.jBR);
        if (!e.this.PWh) {
          break label399;
        }
        parama.jVQ.setBackgroundResource(2131233932);
        if (!paramBoolean1) {
          break label379;
        }
        parama.jVQ.setChecked(true);
        parama.jVQ.setEnabled(false);
        localCheckBox = parama.jVQ;
        if (!ao.isDarkMode()) {
          break label372;
        }
        i = 2131689955;
        label132:
        localCheckBox.setBackgroundResource(i);
        label139:
        parama.jVQ.setVisibility(0);
        label147:
        if (e.this.Qap)
        {
          parama.jVQ.setVisibility(8);
          parama.Qas.setVisibility(8);
        }
        if (!e.this.poB) {
          break label559;
        }
        parama.contentView.setBackgroundResource(2131231901);
      }
      for (;;)
      {
        if (locale.contact.field_deleteFlag == 1)
        {
          parama.jBR.setVisibility(0);
          parama.jBR.setText(paramContext.getString(2131765115));
        }
        if ((!e.this.Qao) && (parama.jVP != null))
        {
          parama.jVP.setVisibility(8);
          if ((as.bjp(locale.username)) && (!Util.isNullOrNil(locale.Qan))) {
            parama.jVO.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.jVO.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + locale.Qan;
                  int j = com.tencent.mm.cb.a.aG(paramContext, 2131165261);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.jVO.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(locale.jVL, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.cb.a.m(paramContext, 2131100918);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.cf.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.n.a((CharSequence)localObject2, parama.jVO);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(locale.jVL, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.ContactDataItem", "fillingViewItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
                  AppMethodBeat.o(102943);
                }
              }
            });
          }
        }
        if (!parama1.Qab) {
          break label590;
        }
        parama.gvv.setAlpha(0.3F);
        parama.jVO.setAlpha(0.3F);
        parama.jBR.setAlpha(0.3F);
        parama.jVQ.setAlpha(0.3F);
        if (parama.jVP == null) {
          break label637;
        }
        parama.jVP.setAlpha(0.3F);
        AppMethodBeat.o(102945);
        return;
        parama.gvv.setImageResource(2131231957);
        break;
        label372:
        i = 2131689954;
        break label132;
        label379:
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
        break label139;
        label399:
        if (e.this.Qaa)
        {
          parama.jVQ.setBackgroundResource(2131234697);
          if (paramBoolean1)
          {
            parama.jVQ.setChecked(true);
            parama.jVQ.setEnabled(false);
            localCheckBox = parama.jVQ;
            if (ao.isDarkMode())
            {
              i = 2131689955;
              label455:
              localCheckBox.setBackgroundResource(i);
            }
          }
          for (;;)
          {
            parama.jVQ.setVisibility(0);
            break;
            i = 2131689954;
            break label455;
            parama.jVQ.setChecked(paramBoolean2);
            parama.jVQ.setEnabled(true);
          }
        }
        if (e.this.PWi)
        {
          parama.jVQ.setVisibility(8);
          if (paramBoolean2)
          {
            parama.Qas.setVisibility(0);
            break label147;
          }
          parama.Qas.setVisibility(8);
          break label147;
        }
        parama.jVQ.setVisibility(8);
        break label147;
        label559:
        if (parama1.Qac) {
          parama.contentView.setBackgroundResource(2131230750);
        } else {
          parama.contentView.setBackgroundResource(2131231898);
        }
      }
      label590:
      parama.gvv.setAlpha(1.0F);
      parama.jVO.setAlpha(1.0F);
      parama.jBR.setAlpha(1.0F);
      parama.jVQ.setAlpha(1.0F);
      if (parama.jVP != null) {
        parama.jVP.setAlpha(1.0F);
      }
      label637:
      AppMethodBeat.o(102945);
    }
    
    public final boolean bmy()
    {
      AppMethodBeat.i(102946);
      if (e.this.lqW != null) {
        ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(e.this.query, e.this.lqW, 1);
      }
      AppMethodBeat.o(102946);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */