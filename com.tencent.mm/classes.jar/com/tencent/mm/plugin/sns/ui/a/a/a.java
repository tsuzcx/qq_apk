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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern AIH;
  public CharSequence AII;
  private b AIJ;
  a AIK;
  public View.OnClickListener AIp;
  public CharSequence heE;
  public CharSequence iYg;
  public m kno;
  public String username;
  
  static
  {
    AppMethodBeat.i(99837);
    AIH = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.AIp = null;
    this.AIJ = new b();
    this.AIK = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.kno != null)
    {
      if (this.contact != null) {
        break label622;
      }
      g.ajS();
      this.contact = ((l)g.ab(l.class)).azF().aUG(this.kno.tEY);
      if (this.contact != null) {
        break label622;
      }
      g.ajS();
      this.contact = ((l)g.ab(l.class)).azF().aUL(this.kno.tEY);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.iYg = "";
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
          localm = this.kno;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(parama, parama.field_username);
          switch (localm.tEX)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.iYg = k.b(paramContext, str1, com.tencent.mm.cb.a.ax(paramContext, 2131165466));
              this.iYg = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.iYg, this.tFe, bool2, bool1)).tFv;
              this.heE = parama;
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
          g.ajS();
          parama = g.ajR().gDX.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.AII = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.tGm == null)) {
              break;
            }
            parama = n.a(paramContext, localm.tGm, parama, this.tFe, b.c.tIZ);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131762928), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label263;
            parama = AIH.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.iYg = k.b(paramContext, str1, com.tencent.mm.cb.a.ax(paramContext, 2131165466));
          break label308;
          this.iYg = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
          if (this.kno != null) {
            this.AII = ("(" + this.kno.tGf + ")");
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
  
  public final com.tencent.mm.ui.contact.a.a.b aRR()
  {
    return this.AIJ;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView Awo;
    public ImageView fQl;
    public TextView fQm;
    public TextView iFO;
    public CheckBox iYl;
    public TextView tLr;
    
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
      a.a locala = (a.a)a.this.AIK;
      locala.fQl = ((ImageView)paramViewGroup.findViewById(2131304945));
      locala.fQm = ((TextView)paramViewGroup.findViewById(2131304950));
      locala.iFO = ((TextView)paramViewGroup.findViewById(2131304946));
      locala.iFO.setVisibility(8);
      locala.tLr = ((TextView)paramViewGroup.findViewById(2131304949));
      locala.iYl = ((CheckBox)paramViewGroup.findViewById(2131304948));
      locala.Awo = ((ImageView)paramViewGroup.findViewById(2131304947));
      locala.Awo.setImageDrawable(ao.k(paramContext, 2131691196, paramContext.getResources().getColor(2131099676)));
      locala.Awo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (a.this.AIp != null) {
            a.this.AIp.onClick(paramAnonymousView);
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fQl, parama1.username, 0.1F, false);
        n.a(parama1.iYg, parama.fQm);
        if (!x.zW(parama1.username)) {
          break label219;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.fQm.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        n.a(parama1.heE, parama.iFO);
        n.a(parama1.AII, parama.tLr);
        if (!a.this.KJj) {
          break label260;
        }
        if (!paramBoolean1) {
          break label240;
        }
        parama.iYl.setChecked(true);
        parama.iYl.setEnabled(false);
        paramContext = parama.iYl;
        if (!al.isDarkMode()) {
          break label233;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
        label179:
        parama.iYl.setVisibility(0);
      }
      for (;;)
      {
        parama.Awo.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.fQl.setImageResource(2131231875);
        break;
        label219:
        parama.fQm.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label233:
        i = 2131689938;
        break label173;
        label240:
        parama.iYl.setChecked(paramBoolean2);
        parama.iYl.setEnabled(true);
        break label179;
        label260:
        parama.iYl.setVisibility(8);
      }
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */