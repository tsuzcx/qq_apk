package com.tencent.mm.plugin.sns.ui.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern xMO;
  public CharSequence ibW;
  public CharSequence ibX;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public String username;
  public CharSequence xMP;
  private b xMQ;
  a xMR;
  public View.OnClickListener xMw;
  
  static
  {
    AppMethodBeat.i(99837);
    xMO = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.xMw = null;
    this.xMQ = new b();
    this.xMR = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.jpy != null)
    {
      if (this.contact != null) {
        break label622;
      }
      g.afC();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHS(this.jpy.roN);
      if (this.contact != null) {
        break label622;
      }
      g.afC();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHX(this.jpy.roN);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.ibW = "";
        AppMethodBeat.o(99836);
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
              AppMethodBeat.o(99836);
              return;
            }
            break;
          case 3: 
          case 7: 
            label263:
            label308:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(2131762930);
          i = j;
          parama = localObject;
          break label263;
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
            break label263;
            parama = xMO.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
          break label308;
          this.ibW = ((b)g.ab(b.class)).b(this.contact, this.contact.field_username);
          if (this.jpy != null) {
            this.xMP = ("(" + this.jpy.rpT + ")");
          }
          AppMethodBeat.o(99836);
          return;
          bool1 = false;
        }
        label622:
        i = 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aHr()
  {
    return this.xMQ;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView frr;
    public TextView frs;
    public TextView hJe;
    public CheckBox icb;
    public TextView ruT;
    public ImageView xAS;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(99833);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131495583, paramViewGroup, false);
      a.a locala = (a.a)a.this.xMR;
      locala.frr = ((ImageView)paramViewGroup.findViewById(2131304945));
      locala.frs = ((TextView)paramViewGroup.findViewById(2131304950));
      locala.hJe = ((TextView)paramViewGroup.findViewById(2131304946));
      locala.hJe.setVisibility(8);
      locala.ruT = ((TextView)paramViewGroup.findViewById(2131304949));
      locala.icb = ((CheckBox)paramViewGroup.findViewById(2131304948));
      locala.xAS = ((ImageView)paramViewGroup.findViewById(2131304947));
      locala.xAS.setImageDrawable(am.i(paramContext, 2131691196, paramContext.getResources().getColor(2131099676)));
      locala.xAS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          if (a.this.xMw != null) {
            a.this.xMw.onClick(paramAnonymousView);
          }
          AppMethodBeat.o(99832);
        }
      });
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(99833);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(99834);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      label103:
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.frr, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibW, parama.frs);
        if (!w.so(parama1.username)) {
          break label219;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.frs.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.ibX, parama.hJe);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.xMP, parama.ruT);
        if (!a.this.GVT) {
          break label260;
        }
        if (!paramBoolean1) {
          break label240;
        }
        parama.icb.setChecked(true);
        parama.icb.setEnabled(false);
        paramContext = parama.icb;
        if (!ai.Eq()) {
          break label233;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
        label179:
        parama.icb.setVisibility(0);
      }
      for (;;)
      {
        parama.xAS.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.frr.setImageResource(2131231875);
        break;
        label219:
        parama.frs.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label233:
        i = 2131689938;
        break label173;
        label240:
        parama.icb.setChecked(paramBoolean2);
        parama.icb.setEnabled(true);
        break label179;
        label260:
        parama.icb.setVisibility(8);
      }
    }
    
    public final boolean aHs()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */