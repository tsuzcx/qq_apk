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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern yZe;
  private b LgJ;
  a LgK;
  public View.OnClickListener Lgr;
  public CharSequence kLX;
  public CharSequence mMY;
  public m olG;
  public String username;
  public CharSequence yZb;
  
  static
  {
    AppMethodBeat.i(99837);
    yZe = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.Lgr = null;
    this.LgJ = new b();
    this.LgK = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.olG != null)
    {
      if (this.contact != null) {
        break label626;
      }
      com.tencent.mm.kernel.h.aHH();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc(this.olG.BHS);
      if (this.contact != null) {
        break label626;
      }
      com.tencent.mm.kernel.h.aHH();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(this.olG.BHS);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.mMY = "";
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
          localm = this.olG;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).b(parama, parama.field_username);
          switch (localm.BHR)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.mMY = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, i.d.HintTextSize));
              this.mMY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mMY, this.BHY, bool2, bool1)).BIp;
              this.kLX = parama;
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
          localResources.getString(i.j.search_contact_tag_nickname);
          i = j;
          parama = localObject;
          break label263;
          com.tencent.mm.kernel.h.aHH();
          parama = com.tencent.mm.kernel.h.aHG().kcF.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
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
              this.yZb = ("(" + parama.length + ")");
            }
            if ((parama == null) || (localm.BJg == null)) {
              break;
            }
            parama = com.tencent.mm.plugin.fts.ui.n.a(paramContext, localm.BJg, parama, this.BHY, b.c.BLX);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(i.j.search_contact_tag_member), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label263;
            parama = yZe.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.mMY = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, i.d.HintTextSize));
          break label309;
          this.mMY = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
          if (this.olG != null) {
            this.yZb = ("(" + this.olG.BIZ + ")");
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
  
  public final com.tencent.mm.ui.contact.a.a.b bwF()
  {
    return this.LgJ;
  }
  
  public final com.tencent.mm.ui.contact.a.a.a bwG()
  {
    return this.LgK;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView KTx;
    public ImageView iZG;
    public TextView iZH;
    public CheckBox mNd;
    public TextView mrM;
    public TextView yZg;
    
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(i.g.sns_select_chat_room_item, paramViewGroup, false);
      a.a locala = (a.a)a.this.LgK;
      locala.iZG = ((ImageView)paramViewGroup.findViewById(i.f.sns_chat_room_avatar_iv));
      locala.iZH = ((TextView)paramViewGroup.findViewById(i.f.sns_chat_room_title_tv));
      locala.mrM = ((TextView)paramViewGroup.findViewById(i.f.sns_chat_room_desc_tv));
      locala.mrM.setVisibility(8);
      locala.yZg = ((TextView)paramViewGroup.findViewById(i.f.sns_chat_room_tip_tv));
      locala.mNd = ((CheckBox)paramViewGroup.findViewById(i.f.sns_chat_room_select_cb));
      locala.KTx = ((ImageView)paramViewGroup.findViewById(i.f.sns_chat_room_more_img));
      locala.KTx.setImageDrawable(au.o(paramContext, i.i.sns_label_more_btn, paramContext.getResources().getColor(i.c.BW_50)));
      locala.KTx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.this.Lgr != null) {
            a.this.Lgr.onClick(paramAnonymousView);
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.iZG, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.mMY, parama.iZH);
        if (!ab.PR(parama1.username)) {
          break label222;
        }
        paramContext = paramContext.getResources().getDrawable(i.i.open_im_main_logo);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.iZH.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.kLX, parama.mrM);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.yZb, parama.yZg);
        if (!a.this.XsX) {
          break label264;
        }
        if (!paramBoolean1) {
          break label244;
        }
        parama.mNd.setChecked(true);
        parama.mNd.setEnabled(false);
        paramContext = parama.mNd;
        if (!ar.isDarkMode()) {
          break label236;
        }
        i = i.i.checkbox_selected_grey_dark;
        label175:
        paramContext.setBackgroundResource(i);
        label181:
        parama.mNd.setVisibility(0);
      }
      for (;;)
      {
        parama.KTx.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.iZG.setImageResource(i.e.default_avatar);
        break;
        label222:
        parama.iZH.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label104;
        label236:
        i = i.i.checkbox_selected_grey;
        break label175;
        label244:
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
        break label181;
        label264:
        parama.mNd.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */