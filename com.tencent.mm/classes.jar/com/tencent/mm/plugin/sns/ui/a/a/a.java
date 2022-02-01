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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern DSA;
  public CharSequence DSx;
  public View.OnClickListener RGB;
  private b RGY;
  a RGZ;
  public CharSequence nnT;
  public CharSequence pJG;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  
  static
  {
    AppMethodBeat.i(99837);
    DSA = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.RGB = null;
    this.RGY = new b();
    this.RGZ = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.rpp != null)
    {
      if (this.contact != null) {
        break label626;
      }
      com.tencent.mm.kernel.h.baF();
      this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq(this.rpp.Hsz);
      if (this.contact != null) {
        break label626;
      }
      com.tencent.mm.kernel.h.baF();
      this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(this.rpp.Hsz);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.pJG = "";
        AppMethodBeat.o(99836);
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
          str1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b(parama, parama.field_username);
          switch (localo.subtype)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.pJG = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, b.d.HintTextSize));
              this.pJG = com.tencent.mm.plugin.fts.a.f.a(g.a(this.pJG, this.FWt, bool2, bool1)).HsX;
              this.nnT = parama;
              AppMethodBeat.o(99836);
              return;
            }
            break;
          case 3: 
          case 7: 
            label263:
            label309:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(b.j.search_contact_tag_nickname);
          i = j;
          parama = localObject;
          break label263;
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
            parama = com.tencent.mm.plugin.fts.ui.o.a(paramContext, localo.HtP, parama, this.FWt, com.tencent.mm.plugin.fts.ui.b.c.HwT);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(b.j.search_contact_tag_member), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label263;
            parama = DSA.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.pJG = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, b.d.HintTextSize));
          break label309;
          this.pJG = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
          if (this.rpp != null) {
            this.DSx = ("(" + this.rpp.HtI + ")");
          }
          AppMethodBeat.o(99836);
          return;
          bool1 = false;
        }
        label626:
        i = 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bVv()
  {
    return this.RGY;
  }
  
  public final com.tencent.mm.ui.contact.a.a.a bVw()
  {
    return this.RGZ;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public TextView DSB;
    public ImageView Rtu;
    public ImageView lBC;
    public TextView lBD;
    public CheckBox pJL;
    public TextView plr;
    
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(b.g.sns_select_chat_room_item, paramViewGroup, false);
      a.a locala = (a.a)a.this.RGZ;
      locala.lBC = ((ImageView)paramViewGroup.findViewById(b.f.sns_chat_room_avatar_iv));
      locala.lBD = ((TextView)paramViewGroup.findViewById(b.f.sns_chat_room_title_tv));
      locala.plr = ((TextView)paramViewGroup.findViewById(b.f.sns_chat_room_desc_tv));
      locala.plr.setVisibility(8);
      locala.DSB = ((TextView)paramViewGroup.findViewById(b.f.sns_chat_room_tip_tv));
      locala.pJL = ((CheckBox)paramViewGroup.findViewById(b.f.sns_chat_room_select_cb));
      locala.Rtu = ((ImageView)paramViewGroup.findViewById(b.f.sns_chat_room_more_img));
      locala.Rtu.setImageDrawable(bb.m(paramContext, b.i.sns_label_more_btn, paramContext.getResources().getColor(com.tencent.mm.plugin.sns.b.c.BW_50)));
      locala.Rtu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.this.RGB != null) {
            a.this.RGB.onClick(paramAnonymousView);
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
      label104:
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.lBC, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.pJG, parama.lBD);
        if (!ab.IG(parama1.username)) {
          break label222;
        }
        paramContext = paramContext.getResources().getDrawable(b.i.open_im_main_logo);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.lBD.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.nnT, parama.plr);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.DSx, parama.DSB);
        if (!a.this.afey) {
          break label264;
        }
        if (!paramBoolean1) {
          break label244;
        }
        parama.pJL.setChecked(true);
        parama.pJL.setEnabled(false);
        paramContext = parama.pJL;
        if (!aw.isDarkMode()) {
          break label236;
        }
        i = b.i.checkbox_selected_grey_dark;
        label175:
        paramContext.setBackgroundResource(i);
        label181:
        parama.pJL.setVisibility(0);
      }
      for (;;)
      {
        parama.Rtu.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.lBC.setImageResource(b.e.default_avatar);
        break;
        label222:
        parama.lBD.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label104;
        label236:
        i = b.i.checkbox_selected_grey;
        break label175;
        label244:
        parama.pJL.setChecked(paramBoolean2);
        parama.pJL.setEnabled(true);
        break label181;
        label264:
        parama.pJL.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */