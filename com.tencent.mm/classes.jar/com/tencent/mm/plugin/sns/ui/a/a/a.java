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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern ESG;
  public CharSequence ESH;
  private b ESI;
  a ESJ;
  public View.OnClickListener ESo;
  public CharSequence hXr;
  public CharSequence jVL;
  public m lqW;
  public String username;
  
  static
  {
    AppMethodBeat.i(99837);
    ESG = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.ESo = null;
    this.ESI = new b();
    this.ESJ = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.lqW != null)
    {
      if (this.contact != null) {
        break label622;
      }
      g.aAi();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjF(this.lqW.wVX);
      if (this.contact != null) {
        break label622;
      }
      g.aAi();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(this.lqW.wVX);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.jVL = "";
        AppMethodBeat.o(99836);
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
          str1 = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(parama, parama.field_username);
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
          localResources.getString(2131765066);
          i = j;
          parama = localObject;
          break label263;
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
            parama = n.a(paramContext, localm.wXl, parama, this.wWd, b.c.wZY);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131765064), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label263;
            parama = ESG.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, str1, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
          break label308;
          this.jVL = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
          if (this.lqW != null) {
            this.ESH = ("(" + this.lqW.wXe + ")");
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
  
  public final com.tencent.mm.ui.contact.a.a.b bmx()
  {
    return this.ESI;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView EFD;
    public ImageView gvv;
    public TextView gvw;
    public TextView jBR;
    public CheckBox jVQ;
    public TextView xcs;
    
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131496481, paramViewGroup, false);
      a.a locala = (a.a)a.this.ESJ;
      locala.gvv = ((ImageView)paramViewGroup.findViewById(2131308085));
      locala.gvw = ((TextView)paramViewGroup.findViewById(2131308090));
      locala.jBR = ((TextView)paramViewGroup.findViewById(2131308086));
      locala.jBR.setVisibility(8);
      locala.xcs = ((TextView)paramViewGroup.findViewById(2131308089));
      locala.jVQ = ((CheckBox)paramViewGroup.findViewById(2131308088));
      locala.EFD = ((ImageView)paramViewGroup.findViewById(2131308087));
      locala.EFD.setImageDrawable(ar.m(paramContext, 2131691518, paramContext.getResources().getColor(2131099683)));
      locala.EFD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.this.ESo != null) {
            a.this.ESo.onClick(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.gvv, parama1.username, 0.1F, false);
        n.a(parama1.jVL, parama.gvw);
        if (!ab.Iz(parama1.username)) {
          break label219;
        }
        paramContext = paramContext.getResources().getDrawable(2131691298);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.gvw.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        n.a(parama1.hXr, parama.jBR);
        n.a(parama1.ESH, parama.xcs);
        if (!a.this.PWh) {
          break label260;
        }
        if (!paramBoolean1) {
          break label240;
        }
        parama.jVQ.setChecked(true);
        parama.jVQ.setEnabled(false);
        paramContext = parama.jVQ;
        if (!ao.isDarkMode()) {
          break label233;
        }
        i = 2131689955;
        label173:
        paramContext.setBackgroundResource(i);
        label179:
        parama.jVQ.setVisibility(0);
      }
      for (;;)
      {
        parama.EFD.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.gvv.setImageResource(2131231957);
        break;
        label219:
        parama.gvw.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label233:
        i = 2131689954;
        break label173;
        label240:
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
        break label179;
        label260:
        parama.jVQ.setVisibility(8);
      }
    }
    
    public final boolean bmy()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */