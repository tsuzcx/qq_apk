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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.aj;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern yZD;
  private b IzG;
  a IzH;
  public CharSequence gIg;
  public CharSequence iCd;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public String username;
  public CharSequence yZE;
  
  static
  {
    AppMethodBeat.i(102939);
    yZD = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.IzG = new b();
    this.IzH = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.jPN != null)
    {
      if (this.contact != null) {
        break label634;
      }
      g.agS();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNn(this.jPN.sxG);
      if (this.contact != null) {
        break label634;
      }
      g.agS();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNs(this.jPN.sxG);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        ac.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
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
          localm = this.jPN;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)g.ab(b.class)).b(parama, parama.field_username);
          switch (localm.sxF)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cc.a.au(paramContext, 2131165466));
              this.iCd = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.iCd, this.sxM, bool2, bool1)).syd;
              this.gIg = parama;
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
          g.agS();
          parama = g.agR().ghG.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.yZE = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.syU == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.m.a(paramContext, localm.syU, parama, this.sxM, b.c.sBH);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131762928), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = yZD.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cc.a.au(paramContext, 2131165466));
          break label320;
          this.iCd = ((b)g.ab(b.class)).b(this.contact, this.contact.field_username);
          if (this.jPN != null) {
            this.yZE = ("(" + this.jPN.syN + ")");
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
  
  public final a.b aOg()
  {
    return this.IzG;
  }
  
  public final boolean cKI()
  {
    return this.jPN.syX;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public CheckBox iCi;
    public TextView ijE;
    public TextView sDL;
    
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
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.IzH;
        locala.fuY = ((ImageView)paramViewGroup.findViewById(2131297008));
        locala.iCg = ((TextView)paramViewGroup.findViewById(2131305948));
        locala.iCg.setMaxWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 200));
        locala.ijE = ((TextView)paramViewGroup.findViewById(2131299008));
        locala.sDL = ((TextView)paramViewGroup.findViewById(2131305880));
        locala.contentView = paramViewGroup.findViewById(2131304518);
        locala.iCi = ((CheckBox)paramViewGroup.findViewById(2131304502));
        if (c.this.nww) {
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fuY, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.iCd, parama.iCg);
        if (!w.wr(parama1.username)) {
          break label205;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.iCg.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.gIg, parama.ijE);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.yZE, parama.sDL);
        if (!c.this.Iwh) {
          break label246;
        }
        if (!paramBoolean1) {
          break label226;
        }
        parama.iCi.setChecked(true);
        parama.iCi.setEnabled(false);
        paramContext = parama.iCi;
        if (!aj.DT()) {
          break label219;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.iCi.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.fuY.setImageResource(2131231875);
        break;
        label205:
        parama.iCg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label219:
        i = 2131689938;
        break label173;
        label226:
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
      }
      label246:
      parama.iCi.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean aOh()
    {
      AppMethodBeat.i(102936);
      if (c.this.jPN != null) {
        ((n)g.ad(n.class)).updateTopHitsRank(c.this.query, c.this.jPN, 1);
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