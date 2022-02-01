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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern DSA;
  public CharSequence DSx;
  private b afjH;
  a afjI;
  public CharSequence nnT;
  public CharSequence pJG;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  
  static
  {
    AppMethodBeat.i(102939);
    DSA = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.afjH = new b();
    this.afjI = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.rpp != null)
    {
      if (this.contact != null) {
        break label638;
      }
      com.tencent.mm.kernel.h.baF();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq(this.rpp.Hsz);
      if (this.contact != null) {
        break label638;
      }
      com.tencent.mm.kernel.h.baF();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxv(this.rpp.Hsz);
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
        com.tencent.mm.plugin.fts.a.a.o localo;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          localo = this.rpp;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)com.tencent.mm.kernel.h.ax(b.class)).b(parama, parama.field_username);
          switch (localo.subtype)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.pJG = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, a.c.HintTextSize));
              this.pJG = com.tencent.mm.plugin.fts.a.f.a(g.a(this.pJG, this.FWt, bool2, bool1)).HsX;
              this.nnT = parama;
              AppMethodBeat.o(102938);
              return;
            }
            break;
          case 3: 
          case 7: 
            label275:
            label321:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(a.h.search_contact_tag_nickname);
          i = j;
          parama = localObject;
          break label275;
          com.tencent.mm.kernel.h.baF();
          parama = com.tencent.mm.kernel.h.baE().mCN.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.DSx = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localo.HtP == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.o.a(paramContext, localo.HtP, parama, this.FWt, b.c.HwT);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(a.h.search_contact_tag_member), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = DSA.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.pJG = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, a.c.HintTextSize));
          break label321;
          this.pJG = ((b)com.tencent.mm.kernel.h.ax(b.class)).b(this.contact, this.contact.field_username);
          if (this.rpp != null) {
            this.DSx = ("(" + this.rpp.HtI + ")");
          }
          AppMethodBeat.o(102938);
          return;
          bool1 = false;
        }
        label638:
        i = 1;
      }
    }
  }
  
  public final a.b bVv()
  {
    return this.afjH;
  }
  
  protected final a.a bVw()
  {
    return this.afjI;
  }
  
  public final boolean fxL()
  {
    return this.rpp.HtT;
  }
  
  public final class a
    extends a.a
  {
    public TextView DSB;
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public CheckBox pJL;
    public TextView plr;
    
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
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.afjI;
        locala.lBC = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
        locala.pJJ = ((TextView)paramViewGroup.findViewById(a.e.title_tv));
        locala.pJJ.setMaxWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 200));
        locala.plr = ((TextView)paramViewGroup.findViewById(a.e.desc_tv));
        locala.DSB = ((TextView)paramViewGroup.findViewById(a.e.tip_tv));
        locala.contentView = paramViewGroup.findViewById(a.e.select_item_content_layout);
        locala.pJL = ((CheckBox)paramViewGroup.findViewById(a.e.select_cb));
        if (c.this.vDh) {
          locala.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
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
      label104:
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.lBC, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.pJG, parama.pJJ);
        if (!ab.IG(parama1.username)) {
          break label208;
        }
        paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.pJJ.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.nnT, parama.plr);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.DSx, parama.DSB);
        if (!c.this.afey) {
          break label250;
        }
        if (!paramBoolean1) {
          break label230;
        }
        parama.pJL.setChecked(true);
        parama.pJL.setEnabled(false);
        paramContext = parama.pJL;
        if (!aw.isDarkMode()) {
          break label222;
        }
        i = a.g.checkbox_selected_grey_dark;
        label175:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.pJL.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.lBC.setImageResource(a.d.default_avatar);
        break;
        label208:
        parama.pJJ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label104;
        label222:
        i = a.g.checkbox_selected_grey;
        break label175;
        label230:
        parama.pJL.setChecked(paramBoolean2);
        parama.pJL.setEnabled(true);
      }
      label250:
      parama.pJL.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(253510);
      if (c.this.rpp != null) {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(c.this.query, c.this.rpp, 1);
      }
      AppMethodBeat.o(253510);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */