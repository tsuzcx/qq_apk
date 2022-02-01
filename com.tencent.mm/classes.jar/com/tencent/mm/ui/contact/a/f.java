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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class f
  extends a
{
  private static final Pattern mMX;
  public String XxK;
  public boolean XxL;
  public boolean XxM;
  private b XxN;
  private a XxO;
  public CharSequence kLX;
  public CharSequence mMY;
  public m olG;
  public String username;
  
  static
  {
    AppMethodBeat.i(102949);
    mMX = Pattern.compile(",");
    AppMethodBeat.o(102949);
  }
  
  public f(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(102947);
    this.XxN = new b();
    this.XxO = new a();
    AppMethodBeat.o(102947);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102948);
    int j = 1;
    if (this.olG != null)
    {
      i = j;
      if (this.contact == null)
      {
        com.tencent.mm.kernel.h.aHH();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc(this.olG.BHS);
        i = j;
        if (this.contact == null)
        {
          com.tencent.mm.kernel.h.aHH();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(this.olG.BHS);
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
    this.XxK = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(this.contact.field_openImAppid, this.contact.field_descWordingId);
    m localm;
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
      localm = this.olG;
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
      str = ((b)com.tencent.mm.kernel.h.ae(b.class)).b((as)localObject3, ((ax)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (localm.BHR)
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
        this.mMY = l.d(paramContext, (CharSequence)localObject2, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
        this.mMY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mMY, this.BHY, bool2, bool1)).BIp;
        label460:
        if (i == 0) {
          break label1072;
        }
        Log.d("MicroMsg.ContactDataItem", "highlight second line");
        this.kLX = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, a.c.HintTextSize));
        this.kLX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.kLX, this.BHY, bool2, bool1)).BIp;
        label512:
        if ((!Util.isNullOrNil((String)localObject1)) && (this.kLX != null)) {
          this.kLX = TextUtils.concat(new CharSequence[] { localObject1, this.kLX });
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
        parama = ((ax)localObject3).field_nickname;
        localObject1 = localResources.getString(a.h.search_contact_tag_nickname);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((ax)localObject3).hDq;
        localObject1 = localResources.getString(a.h.search_contact_tag_description);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((as)localObject3).apf();
        parama = (a.a)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          parama = ((ax)localObject3).field_username;
        }
        localObject1 = localResources.getString(a.h.search_contact_tag_wxid);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = localm.content;
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
          parama = localm.content;
          localObject1 = localResources.getString(a.h.search_contact_tag_location);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          j = 1;
          parama = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aHF(((ax)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.BHY.BIy;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (d.aHJ((String)localObject3).contains(localCharSequence))
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
          this.mMY = l.d(paramContext, (CharSequence)localObject2, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
          break label460;
          label1072:
          this.kLX = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, a.c.HintTextSize));
          break label512;
          if (Util.isNullOrNil(this.fxT)) {}
          for (parama = ((b)com.tencent.mm.kernel.h.ae(b.class)).b(this.contact);; parama = ((b)com.tencent.mm.kernel.h.ae(b.class)).aL(this.contact.field_username, this.fxT))
          {
            this.mMY = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
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
  
  public a.b bwF()
  {
    return this.XxN;
  }
  
  public a.a bwG()
  {
    return this.XxO;
  }
  
  public class a
    extends a.a
  {
    public ImageView XxP;
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public TextView mNc;
    public CheckBox mNd;
    public TextView mrM;
    
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
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (f.a)f.this.bwG();
        paramViewGroup.iZG = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
        paramViewGroup.mNb = ((TextView)paramContext.findViewById(a.e.title_tv));
        paramViewGroup.mrM = ((TextView)paramContext.findViewById(a.e.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
        paramViewGroup.mNd = ((CheckBox)paramContext.findViewById(a.e.select_cb));
        paramViewGroup.XxP = ((ImageView)paramContext.findViewById(a.e.select_single_mark_iv));
        paramViewGroup.mNc = ((TextView)paramContext.findViewById(a.e.openim_contact_desc));
        paramContext.setTag(paramViewGroup);
        if (f.this.xUe)
        {
          Resources localResources = paramViewGroup.mNb.getContext().getResources();
          paramViewGroup.contentView.setBackgroundResource(a.d.comm_list_item_selector_dark);
          paramViewGroup.mNb.setTextColor(localResources.getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_100_Alpha_0_8));
          paramViewGroup.mrM.setTextColor(localResources.getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_100_Alpha_0_5));
          paramViewGroup.mNd.setBackgroundResource(a.d.red_check_box_selector);
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.iZG, localf.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.n.a(localf.mMY, parama.mNb);
        com.tencent.mm.plugin.fts.ui.n.a(localf.kLX, parama.mrM);
        if (!f.this.XsX) {
          break label430;
        }
        if (!f.this.xUe) {
          parama.mNd.setBackgroundResource(a.d.mm_checkbox_btn);
        }
        if (!paramBoolean1) {
          break label410;
        }
        parama.mNd.setChecked(true);
        parama.mNd.setEnabled(false);
        localCheckBox = parama.mNd;
        if ((!ar.isDarkMode()) && (!f.this.xUe)) {
          break label402;
        }
        i = a.g.checkbox_selected_grey_dark;
        label154:
        localCheckBox.setBackgroundResource(i);
        label161:
        parama.mNd.setVisibility(0);
        label169:
        if (f.this.XxM)
        {
          parama.mNd.setVisibility(8);
          parama.XxP.setVisibility(8);
        }
        if (!f.this.sxA) {
          break label603;
        }
        parama.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        if (localf.contact.field_deleteFlag == 1)
        {
          parama.mrM.setVisibility(0);
          parama.mrM.setText(paramContext.getString(a.h.select_contact_account_deleted));
        }
        if ((!f.this.XxL) && (parama.mNc != null))
        {
          parama.mNc.setVisibility(8);
          if ((as.bvK(localf.username)) && (!Util.isNullOrNil(localf.XxK))) {
            parama.mNb.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(102943);
                try
                {
                  int i = ((ViewGroup)parama.mNb.getParent()).getMeasuredWidth();
                  if (i == 0)
                  {
                    AppMethodBeat.o(102943);
                    return;
                  }
                  Object localObject1 = "@" + localf.XxK;
                  int j = com.tencent.mm.ci.a.aY(paramContext, a.c.DescTextSize);
                  Object localObject2 = new TextView(paramContext);
                  ((TextView)localObject2).getPaint().setTextSize(j);
                  float f = ((TextView)localObject2).getPaint().measureText(" ".concat(String.valueOf(localObject1)));
                  ((TextView)localObject2).getPaint().setTextSize(parama.mNb.getTextSize());
                  CharSequence localCharSequence;
                  if (f >= i * 0.6D)
                  {
                    localCharSequence = TextUtils.ellipsize(localf.mMY, ((TextView)localObject2).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
                    f = ((TextView)localObject2).getPaint().measureText(localCharSequence.toString());
                    ((TextView)localObject2).getPaint().setTextSize(j);
                    localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject2).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
                  }
                  for (;;)
                  {
                    localObject2 = l.c(paramContext, localCharSequence + " " + localObject1);
                    ColorStateList localColorStateList = com.tencent.mm.ci.a.l(paramContext, com.tencent.mm.plugin.selectcontact.a.b.openim_desc_text_color);
                    ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, localColorStateList, localColorStateList), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    ((SpannableString)localObject2).setSpan(new com.tencent.mm.cm.a(j), localCharSequence.length() + 1, localCharSequence.length() + 1 + ((CharSequence)localObject1).length(), 33);
                    com.tencent.mm.plugin.fts.ui.n.a((CharSequence)localObject2, parama.mNb);
                    AppMethodBeat.o(102943);
                    return;
                    localCharSequence = TextUtils.ellipsize(localf.mMY, ((TextView)localObject2).getPaint(), i - f, TextUtils.TruncateAt.END);
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
        if (!parama1.Xxt) {
          break label636;
        }
        parama.iZG.setAlpha(0.3F);
        parama.mNb.setAlpha(0.3F);
        parama.mrM.setAlpha(0.3F);
        parama.mNd.setAlpha(0.3F);
        if (parama.mNc == null) {
          break label683;
        }
        parama.mNc.setAlpha(0.3F);
        AppMethodBeat.o(102945);
        return;
        parama.iZG.setImageResource(a.d.default_avatar);
        break;
        label402:
        i = a.g.checkbox_selected_grey;
        break label154;
        label410:
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
        break label161;
        label430:
        if (f.this.Xxs)
        {
          parama.mNd.setBackgroundResource(a.d.round_selector);
          if (paramBoolean1)
          {
            parama.mNd.setChecked(true);
            parama.mNd.setEnabled(false);
            localCheckBox = parama.mNd;
            if ((ar.isDarkMode()) || (f.this.xUe))
            {
              i = a.g.checkbox_selected_grey_dark;
              label498:
              localCheckBox.setBackgroundResource(i);
            }
          }
          for (;;)
          {
            parama.mNd.setVisibility(0);
            break;
            i = a.g.checkbox_selected_grey;
            break label498;
            parama.mNd.setChecked(paramBoolean2);
            parama.mNd.setEnabled(true);
          }
        }
        if (f.this.XsY)
        {
          parama.mNd.setVisibility(8);
          if (paramBoolean2)
          {
            parama.XxP.setVisibility(0);
            break label169;
          }
          parama.XxP.setVisibility(8);
          break label169;
        }
        parama.mNd.setVisibility(8);
        break label169;
        label603:
        if (parama1.Xxu) {
          parama.contentView.setBackgroundResource(a.d.aa_seletct_contact_search_ui_item_selector);
        } else {
          parama.contentView.setBackgroundResource(a.d.comm_list_item_selector);
        }
      }
      label636:
      parama.iZG.setAlpha(1.0F);
      parama.mNb.setAlpha(1.0F);
      parama.mrM.setAlpha(1.0F);
      parama.mNd.setAlpha(1.0F);
      if (parama.mNc != null) {
        parama.mNc.setAlpha(1.0F);
      }
      label683:
      AppMethodBeat.o(102945);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(187481);
      if (f.this.olG != null) {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(f.this.query, f.this.olG, 1);
      }
      AppMethodBeat.o(187481);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */