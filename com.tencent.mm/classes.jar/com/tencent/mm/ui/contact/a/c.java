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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.al;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern Art;
  public CharSequence Aru;
  private b KqM;
  a KqN;
  public CharSequence hbQ;
  public CharSequence iVn;
  public m kjY;
  public String username;
  
  static
  {
    AppMethodBeat.i(102939);
    Art = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.KqM = new b();
    this.KqN = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.kjY != null)
    {
      if (this.contact != null) {
        break label634;
      }
      g.ajD();
      this.contact = ((l)g.ab(l.class)).azp().aTf(this.kjY.tuh);
      if (this.contact != null) {
        break label634;
      }
      g.ajD();
      this.contact = ((l)g.ab(l.class)).azp().aTk(this.kjY.tuh);
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
        m localm;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          localm = this.kjY;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)g.ab(b.class)).b(parama, parama.field_username);
          switch (localm.tug)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.iVn = k.b(paramContext, str1, com.tencent.mm.cc.a.ax(paramContext, 2131165466));
              this.iVn = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.iVn, this.tun, bool2, bool1)).tuE;
              this.hbQ = parama;
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
          g.ajD();
          parama = g.ajC().gBq.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.Aru = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.tvv == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.n.a(paramContext, localm.tvv, parama, this.tun, b.c.tyi);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131762928), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = Art.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.iVn = k.b(paramContext, str1, com.tencent.mm.cc.a.ax(paramContext, 2131165466));
          break label320;
          this.iVn = ((b)g.ab(b.class)).b(this.contact, this.contact.field_username);
          if (this.kjY != null) {
            this.Aru = ("(" + this.kjY.tvo + ")");
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
  
  public final a.b aRs()
  {
    return this.KqM;
  }
  
  public final boolean cSX()
  {
    return this.kjY.tvy;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
    public CheckBox iVs;
    public TextView tAA;
    
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
      if (com.tencent.mm.cc.a.im(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.KqN;
        locala.fOf = ((ImageView)paramViewGroup.findViewById(2131297008));
        locala.iVq = ((TextView)paramViewGroup.findViewById(2131305948));
        locala.iVq.setMaxWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 200));
        locala.iCV = ((TextView)paramViewGroup.findViewById(2131299008));
        locala.tAA = ((TextView)paramViewGroup.findViewById(2131305880));
        locala.contentView = paramViewGroup.findViewById(2131304518);
        locala.iVs = ((CheckBox)paramViewGroup.findViewById(2131304502));
        if (c.this.nXU) {
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fOf, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.iVn, parama.iVq);
        if (!w.zm(parama1.username)) {
          break label205;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.iVq.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.hbQ, parama.iCV);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.Aru, parama.tAA);
        if (!c.this.KmP) {
          break label246;
        }
        if (!paramBoolean1) {
          break label226;
        }
        parama.iVs.setChecked(true);
        parama.iVs.setEnabled(false);
        paramContext = parama.iVs;
        if (!al.isDarkMode()) {
          break label219;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.iVs.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.fOf.setImageResource(2131231875);
        break;
        label205:
        parama.iVq.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label219:
        i = 2131689938;
        break label173;
        label226:
        parama.iVs.setChecked(paramBoolean2);
        parama.iVs.setEnabled(true);
      }
      label246:
      parama.iVs.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean aRt()
    {
      AppMethodBeat.i(102936);
      if (c.this.kjY != null) {
        ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(c.this.query, c.this.kjY, 1);
      }
      AppMethodBeat.o(102936);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */