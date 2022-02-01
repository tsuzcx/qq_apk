package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ao;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern ESG;
  public CharSequence ESH;
  private b Qag;
  a Qah;
  public CharSequence hXr;
  public CharSequence jVL;
  public m lqW;
  public String username;
  
  static
  {
    AppMethodBeat.i(102939);
    ESG = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.Qag = new b();
    this.Qah = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.lqW != null)
    {
      if (this.contact != null) {
        break label634;
      }
      g.aAi();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjF(this.lqW.wVX);
      if (this.contact != null) {
        break label634;
      }
      g.aAi();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(this.lqW.wVX);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        Log.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
        AppMethodBeat.o(102938);
        return;
        i = 0;
      }
      else
      {
        this.username = this.contact.field_username;
        m localm;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          localm = this.lqW;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)g.af(b.class)).b(parama, parama.field_username);
          switch (localm.wVW)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, str1, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
              this.jVL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jVL, this.wWd, bool2, bool1)).wWu;
              this.hXr = parama;
              AppMethodBeat.o(102938);
              return;
            }
            break;
          case 3: 
          case 7: 
            label275:
            label320:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(2131765066);
          i = j;
          parama = localObject;
          break label275;
          g.aAi();
          parama = g.aAh().hqK.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
          String str2;
          if (parama.moveToFirst())
          {
            str2 = parama.getString(0);
            parama.close();
            if (str2 == null) {
              parama = null;
            }
          }
          for (;;)
          {
            if ((parama != null) && (parama.length > 0)) {
              this.ESH = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.wXl == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.n.a(paramContext, localm.wXl, parama, this.wWd, b.c.wZY);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131765064), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = ESG.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, str1, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
          break label320;
          this.jVL = ((b)g.af(b.class)).b(this.contact, this.contact.field_username);
          if (this.lqW != null) {
            this.ESH = ("(" + this.lqW.wXe + ")");
          }
          AppMethodBeat.o(102938);
          return;
          bool1 = false;
        }
        label634:
        i = 1;
      }
    }
  }
  
  public final a.b bmx()
  {
    return this.Qag;
  }
  
  public final boolean dOL()
  {
    return this.lqW.wXo;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    public CheckBox jVQ;
    public TextView xcs;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102934);
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2131496221, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2131496220, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.Qah;
        locala.gvv = ((ImageView)paramViewGroup.findViewById(2131297134));
        locala.jVO = ((TextView)paramViewGroup.findViewById(2131309249));
        locala.jVO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
        locala.jBR = ((TextView)paramViewGroup.findViewById(2131299510));
        locala.xcs = ((TextView)paramViewGroup.findViewById(2131309163));
        locala.contentView = paramViewGroup.findViewById(2131307533);
        locala.jVQ = ((CheckBox)paramViewGroup.findViewById(2131307508));
        if (c.this.poB) {
          locala.contentView.setBackgroundResource(2131231901);
        }
        paramViewGroup.setTag(locala);
        AppMethodBeat.o(102934);
        return paramViewGroup;
      }
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102935);
      parama = (c.a)parama;
      parama1 = (c)parama1;
      label103:
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.gvv, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.jVL, parama.jVO);
        if (!ab.Iz(parama1.username)) {
          break label205;
        }
        paramContext = paramContext.getResources().getDrawable(2131691298);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.jVO.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.hXr, parama.jBR);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.ESH, parama.xcs);
        if (!c.this.PWh) {
          break label246;
        }
        if (!paramBoolean1) {
          break label226;
        }
        parama.jVQ.setChecked(true);
        parama.jVQ.setEnabled(false);
        paramContext = parama.jVQ;
        if (!ao.isDarkMode()) {
          break label219;
        }
        i = 2131689955;
        label173:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.jVQ.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.gvv.setImageResource(2131231957);
        break;
        label205:
        parama.jVO.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label219:
        i = 2131689954;
        break label173;
        label226:
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
      }
      label246:
      parama.jVQ.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean bmy()
    {
      AppMethodBeat.i(102936);
      if (c.this.lqW != null) {
        ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(c.this.query, c.this.lqW, 1);
      }
      AppMethodBeat.o(102936);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */