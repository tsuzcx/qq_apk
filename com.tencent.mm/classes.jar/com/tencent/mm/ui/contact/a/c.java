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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern yZe;
  private b Xxy;
  a Xxz;
  public CharSequence kLX;
  public CharSequence mMY;
  public m olG;
  public String username;
  public CharSequence yZb;
  
  static
  {
    AppMethodBeat.i(102939);
    yZe = Pattern.compile(";");
    AppMethodBeat.o(102939);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(102937);
    this.Xxy = new b();
    this.Xxz = new a();
    AppMethodBeat.o(102937);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(102938);
    int i;
    if (this.olG != null)
    {
      if (this.contact != null) {
        break label638;
      }
      com.tencent.mm.kernel.h.aHH();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc(this.olG.BHS);
      if (this.contact != null) {
        break label638;
      }
      com.tencent.mm.kernel.h.aHH();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(this.olG.BHS);
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
          localm = this.olG;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).b(parama, parama.field_username);
          switch (localm.BHR)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.mMY = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, a.c.HintTextSize));
              this.mMY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mMY, this.BHY, bool2, bool1)).BIp;
              this.kLX = parama;
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
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(a.h.search_contact_tag_member), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label275;
            parama = yZe.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.mMY = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, a.c.HintTextSize));
          break label321;
          this.mMY = ((b)com.tencent.mm.kernel.h.ae(b.class)).b(this.contact, this.contact.field_username);
          if (this.olG != null) {
            this.yZb = ("(" + this.olG.BIZ + ")");
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
  
  public final a.b bwF()
  {
    return this.Xxy;
  }
  
  protected final a.a bwG()
  {
    return this.Xxz;
  }
  
  public final boolean ere()
  {
    return this.olG.BJk;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public CheckBox mNd;
    public TextView mrM;
    public TextView yZg;
    
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
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.Xxz;
        locala.iZG = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
        locala.mNb = ((TextView)paramViewGroup.findViewById(a.e.title_tv));
        locala.mNb.setMaxWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 200));
        locala.mrM = ((TextView)paramViewGroup.findViewById(a.e.desc_tv));
        locala.yZg = ((TextView)paramViewGroup.findViewById(a.e.tip_tv));
        locala.contentView = paramViewGroup.findViewById(a.e.select_item_content_layout);
        locala.mNd = ((CheckBox)paramViewGroup.findViewById(a.e.select_cb));
        if (c.this.sxA) {
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.iZG, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.mMY, parama.mNb);
        if (!ab.PR(parama1.username)) {
          break label208;
        }
        paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.mNb.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.kLX, parama.mrM);
        com.tencent.mm.plugin.fts.ui.n.a(parama1.yZb, parama.yZg);
        if (!c.this.XsX) {
          break label250;
        }
        if (!paramBoolean1) {
          break label230;
        }
        parama.mNd.setChecked(true);
        parama.mNd.setEnabled(false);
        paramContext = parama.mNd;
        if (!ar.isDarkMode()) {
          break label222;
        }
        i = a.g.checkbox_selected_grey_dark;
        label175:
        paramContext.setBackgroundResource(i);
      }
      for (;;)
      {
        parama.mNd.setVisibility(0);
        AppMethodBeat.o(102935);
        return;
        parama.iZG.setImageResource(a.d.default_avatar);
        break;
        label208:
        parama.mNb.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label104;
        label222:
        i = a.g.checkbox_selected_grey;
        break label175;
        label230:
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
      }
      label250:
      parama.mNd.setVisibility(8);
      AppMethodBeat.o(102935);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(186747);
      if (c.this.olG != null) {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(c.this.query, c.this.olG, 1);
      }
      AppMethodBeat.o(186747);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */