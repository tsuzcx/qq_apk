package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class f
  extends a
{
  private static final Pattern pJF;
  public boolean JXq;
  public boolean afjT;
  private b afjU;
  private a afjV;
  public CharSequence nnT;
  public CharSequence pJG;
  public String prR;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    pJF = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public f(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.afjU = new b();
    this.afjV = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.rpp != null)
    {
      i = j;
      if (this.contact == null)
      {
        com.tencent.mm.kernel.h.baF();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq(this.rpp.Hsz);
        i = j;
        if (this.contact == null)
        {
          com.tencent.mm.kernel.h.baF();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxv(this.rpp.Hsz);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      Log.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(102948);
      return;
    }
    this.username = this.contact.field_username;
    this.prR = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(this.contact.field_openImAppid, this.contact.field_descWordingId);
    com.tencent.mm.plugin.fts.a.a.o localo;
    Object localObject3;
    CharSequence localCharSequence;
    Iterator localIterator;
    int k;
    int m;
    boolean bool6;
    boolean bool5;
    boolean bool7;
    boolean bool3;
    boolean bool4;
    boolean bool8;
    Resources localResources;
    String str;
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      localo = this.rpp;
      localObject3 = this.contact;
      localCharSequence = null;
      localIterator = null;
      k = 0;
      m = 0;
      bool6 = false;
      bool5 = false;
      bool7 = false;
      bool3 = false;
      bool4 = false;
      bool8 = false;
      localResources = paramContext.getResources();
      if (localObject3 == null) {
        break label1188;
      }
      str = ((b)com.tencent.mm.kernel.h.ax(b.class)).b((au)localObject3, ((az)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localo.subtype)
      {
      default: 
        localObject2 = str;
        localObject1 = localCharSequence;
        parama = localIterator;
        j = k;
        i = m;
        bool2 = bool7;
        bool1 = bool8;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        Log.d("MicroMsg.ContactDataItem", "highlight first line");
        this.pJG = p.d(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
        this.pJG = com.tencent.mm.plugin.fts.a.f.a(g.a(this.pJG, this.FWt, bool2, bool1)).HsX;
        label460:
        if (i == 0) {
          break label1072;
        }
        Log.d("MicroMsg.ContactDataItem", "highlight second line");
        this.nnT = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, a.c.HintTextSize));
        this.nnT = com.tencent.mm.plugin.fts.a.f.a(g.a(this.nnT, this.FWt, bool2, bool1)).HsX;
        label512:
        if ((!Util.isNullOrNil((String)localObject1)) && (this.nnT != null)) {
          this.nnT = TextUtils.concat(new CharSequence[] { localObject1, this.nnT });
        }
        AppMethodBeat.o(102948);
        return;
        bool1 = true;
      }
      label559:
      for (bool2 = true;; bool2 = bool6)
      {
        j = 1;
        i = m;
        parama = localIterator;
        localObject1 = localCharSequence;
        localObject2 = str;
        break;
        bool3 = true;
        bool5 = true;
        bool4 = bool3;
        parama = ((az)localObject3).field_nickname;
        localObject1 = localResources.getString(a.h.search_contact_tag_nickname);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((az)localObject3).kal;
        localObject1 = localResources.getString(a.h.search_contact_tag_description);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((au)localObject3).aJs();
        parama = (a.a)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          parama = ((az)localObject3).field_username;
        }
        localObject1 = localResources.getString(a.h.search_contact_tag_wxid);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localo.content;
        if (!Util.isNullOrNil(parama))
        {
          localObject2 = parama.split("​");
          j = localObject2.length;
          i = 0;
          label750:
          if (i < j)
          {
            localObject1 = localObject2[i];
            if (((String)localObject1).startsWith(this.query)) {
              parama = (a.a)localObject1;
            }
          }
        }
        for (;;)
        {
          localObject1 = localResources.getString(a.h.search_contact_tag_mobile);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          i += 1;
          break label750;
          parama = localo.content;
          localObject1 = localResources.getString(a.h.search_contact_tag_location);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          j = 1;
          parama = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aEd(((az)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.FWt.Htg;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.aEh((String)localObject3).contains(localCharSequence))
              {
                ((StringBuffer)localObject1).append((String)localObject3);
                ((StringBuffer)localObject1).append(",");
              }
            }
            i += 1;
          }
          ((StringBuffer)localObject1).trimToSize();
          if (((StringBuffer)localObject1).length() == 0) {}
          for (parama = "";; parama = ((StringBuffer)localObject1).substring(0, ((StringBuffer)localObject1).length() - 1))
          {
            localObject1 = localResources.getString(a.h.search_contact_tag_tag);
            bool1 = bool8;
            bool2 = bool7;
            i = j;
            j = k;
            localObject2 = str;
            break;
          }
          this.pJG = p.d(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
          break label460;
          label1072:
          this.nnT = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, a.c.HintTextSize));
          break label512;
          if (Util.isNullOrNil(this.hCy)) {}
          for (parama = ((b)com.tencent.mm.kernel.h.ax(b.class)).b(this.contact);; parama = ((b)com.tencent.mm.kernel.h.ax(b.class)).aV(this.contact.field_username, this.hCy))
          {
            this.pJG = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
            AppMethodBeat.o(102948);
            return;
          }
        }
        bool1 = false;
        break label559;
        bool1 = false;
      }
      label1188:
      localObject2 = null;
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
    }
  }
  
  public a.b bVv()
  {
    return this.afjU;
  }
  
  public a.a bVw()
  {
    return this.afjV;
  }
  
  public class a
    extends a.a
  {
    public ImageView afjW;
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView pJK;
    public CheckBox pJL;
    public TextView plr;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102944);
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.bVw();
        paramViewGroup.lBC = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.pJJ = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.plr = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
        paramViewGroup.pJL = ((CheckBox)paramContext.findViewById(a.e.select_cb));
        paramViewGroup.afjW = ((ImageView)paramContext.findViewById(a.e.select_single_mark_iv));
        paramViewGroup.pJK = ((TextView)paramContext.findViewById(a.e.openim_contact_desc));
        paramContext.setTag(paramViewGroup);
        if (f.this.Bva)
        {
          Resources localResources = paramViewGroup.pJJ.getContext().getResources();
          paramViewGroup.contentView.setBackgroundResource(a.d.comm_list_item_selector_dark);
          paramViewGroup.pJJ.setTextColor(localResources.getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_100_Alpha_0_8));
          paramViewGroup.plr.setTextColor(localResources.getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_100_Alpha_0_5));
          paramViewGroup.pJL.setBackgroundResource(a.d.red_check_box_selector);
        }
        AppMethodBeat.o(102944);
        return paramContext;
      }
    }
    
    public void a(final Context paramContext, final a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102945);
      parama = (f.a)parama;
      final f localf = (f)parama1;
      CheckBox localCheckBox;
      int i;
      if ((localf.username != null) && (localf.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.lBC, localf.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.o.a(localf.pJG, parama.pJJ);
        com.tencent.mm.plugin.fts.ui.o.a(localf.nnT, parama.plr);
        if (!f.this.afey) {
          break label430;
        }
        if (!f.this.Bva) {
          parama.pJL.setBackgroundResource(a.d.mm_checkbox_btn);
        }
        if (!paramBoolean1) {
          break label410;
        }
        parama.pJL.setChecked(true);
        parama.pJL.setEnabled(false);
        localCheckBox = parama.pJL;
        if ((!aw.isDarkMode()) && (!f.this.Bva)) {
          break label402;
        }
        i = a.g.checkbox_selected_grey_dark;
        label154:
        localCheckBox.setBackgroundResource(i);
        label161:
        parama.pJL.setVisibility(0);
        label169:
        if (f.this.afjT)
        {
          parama.pJL.setVisibility(8);
          parama.afjW.setVisibility(8);
        }
        if (!f.this.vDh) {
          break label603;
        }
        parama.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        if (localf.contact.field_deleteFlag == 1)
        {
          parama.plr.setVisibility(0);
          parama.plr.setText(paramContext.getString(a.h.select_contact_account_deleted));
        }
        if ((!f.this.JXq) && (parama.pJK != null))
        {
          parama.pJK.setVisibility(8);
          if ((au.bwO(localf.username)) && (!Util.isNullOrNil(localf.prR))) {
            parama.pJJ.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.pJJ.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + localf.prR;
                  int j = com.tencent.mm.cd.a.br(paramContext, a.c.DescTextSize);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.pJJ.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(localf.pJG, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = p.b(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.cd.a.l(paramContext, com.tencent.mm.plugin.selectcontact.a.b.openim_desc_text_color);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.cg.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.o.a((CharSequence)localObject2, parama.pJJ);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(localf.pJG, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
                  }
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.ContactDataItem", "fillingViewItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
                  AppMethodBeat.o(102943);
                }
              }
            });
          }
        }
        if (!parama1.JXr) {
          break label636;
        }
        parama.lBC.setAlpha(0.3F);
        parama.pJJ.setAlpha(0.3F);
        parama.plr.setAlpha(0.3F);
        parama.pJL.setAlpha(0.3F);
        if (parama.pJK == null) {
          break label683;
        }
        parama.pJK.setAlpha(0.3F);
        AppMethodBeat.o(102945);
        return;
        parama.lBC.setImageResource(a.d.default_avatar);
        break;
        label402:
        i = a.g.checkbox_selected_grey;
        break label154;
        label410:
        parama.pJL.setChecked(paramBoolean2);
        parama.pJL.setEnabled(true);
        break label161;
        label430:
        if (f.this.afjA)
        {
          parama.pJL.setBackgroundResource(a.d.round_selector);
          if (paramBoolean1)
          {
            parama.pJL.setChecked(true);
            parama.pJL.setEnabled(false);
            localCheckBox = parama.pJL;
            if ((aw.isDarkMode()) || (f.this.Bva))
            {
              i = a.g.checkbox_selected_grey_dark;
              label498:
              localCheckBox.setBackgroundResource(i);
            }
          }
          for (;;)
          {
            parama.pJL.setVisibility(0);
            break;
            i = a.g.checkbox_selected_grey;
            break label498;
            parama.pJL.setChecked(paramBoolean2);
            parama.pJL.setEnabled(true);
          }
        }
        if (f.this.afez)
        {
          parama.pJL.setVisibility(8);
          if (paramBoolean2)
          {
            parama.afjW.setVisibility(0);
            break label169;
          }
          parama.afjW.setVisibility(8);
          break label169;
        }
        parama.pJL.setVisibility(8);
        break label169;
        label603:
        if (parama1.afjB) {
          parama.contentView.setBackgroundResource(a.d.aa_seletct_contact_search_ui_item_selector);
        } else {
          parama.contentView.setBackgroundResource(a.d.comm_list_item_selector);
        }
      }
      label636:
      parama.lBC.setAlpha(1.0F);
      parama.pJJ.setAlpha(1.0F);
      parama.plr.setAlpha(1.0F);
      parama.pJL.setAlpha(1.0F);
      if (parama.pJK != null) {
        parama.pJK.setAlpha(1.0F);
      }
      label683:
      AppMethodBeat.o(102945);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(253553);
      if (f.this.rpp != null) {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(f.this.query, f.this.rpp, 1);
      }
      AppMethodBeat.o(253553);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */