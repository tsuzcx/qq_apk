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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ai;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern xMO;
  private b GZo;
  a GZp;
  public CharSequence ibW;
  public CharSequence ibX;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public String username;
  public CharSequence xMP;
  
  static
  {
    AppMethodBeat.i(102939);
    xMO = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.GZo = new b();
    this.GZp = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.jpy != null)
    {
      if (this.contact != null) {
        break label634;
      }
      g.afC();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHS(this.jpy.roN);
      if (this.contact != null) {
        break label634;
      }
      g.afC();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHX(this.jpy.roN);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        ad.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
        AppMethodBeat.o(102938);
        return;
        i = 0;
      }
      else
      {
        this.username = this.contact.field_username;
        com.tencent.mm.plugin.fts.a.a.m localm;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          localm = this.jpy;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)g.ab(b.class)).b(parama, parama.field_username);
          switch (localm.roM)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
              this.ibW = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.ibW, this.roS, bool2, bool1)).rpj;
              this.ibX = parama;
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
          localResources.getString(2131762930);
          i = j;
          parama = localObject;
          break label275;
          g.afC();
          parama = g.afB().gda.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.xMP = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.rqa == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.m.a(paramContext, localm.rqa, parama, this.roS, b.c.rsN);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131762928), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = xMO.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
          break label320;
          this.ibW = ((b)g.ab(b.class)).b(this.contact, this.contact.field_username);
          if (this.jpy != null) {
            this.xMP = ("(" + this.jpy.rpT + ")");
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
  
  public final a.b aHr()
  {
    return this.GZo;
  }
  
  public final boolean cxw()
  {
    return this.jpy.rqd;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public CheckBox icb;
    public TextView ruT;
    
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
      if (com.tencent.mm.cd.a.hS(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.GZp;
        locala.frr = ((ImageView)paramViewGroup.findViewById(2131297008));
        locala.ica = ((TextView)paramViewGroup.findViewById(2131305948));
        locala.ica.setMaxWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 200));
        locala.hJe = ((TextView)paramViewGroup.findViewById(2131299008));
        locala.ruT = ((TextView)paramViewGroup.findViewById(2131305880));
        locala.contentView = paramViewGroup.findViewById(2131304518);
        locala.icb = ((CheckBox)paramViewGroup.findViewById(2131304502));
        if (c.this.mUe) {
          locala.contentView.setBackgroundResource(2131231820);
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.frr, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibW, parama.ica);
        if (!w.so(parama1.username)) {
          break label205;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.ica.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibX, parama.hJe);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.xMP, parama.ruT);
        if (!c.this.GVT) {
          break label246;
        }
        if (!paramBoolean1) {
          break label226;
        }
        parama.icb.setChecked(true);
        parama.icb.setEnabled(false);
        paramContext = parama.icb;
        if (!ai.Eq()) {
          break label219;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.icb.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.frr.setImageResource(2131231875);
        break;
        label205:
        parama.ica.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label219:
        i = 2131689938;
        break label173;
        label226:
        parama.icb.setChecked(paramBoolean2);
        parama.icb.setEnabled(true);
      }
      label246:
      parama.icb.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean aHs()
    {
      AppMethodBeat.i(102936);
      if (c.this.jpy != null) {
        ((n)g.ad(n.class)).updateTopHitsRank(c.this.query, c.this.jpy, 1);
      }
      AppMethodBeat.o(102936);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */