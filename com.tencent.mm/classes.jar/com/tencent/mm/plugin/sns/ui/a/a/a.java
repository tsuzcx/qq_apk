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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern yZD;
  public CharSequence gIg;
  public CharSequence iCd;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public String username;
  public CharSequence yZE;
  private b yZF;
  a yZG;
  public View.OnClickListener yZl;
  
  static
  {
    AppMethodBeat.i(99837);
    yZD = Pattern.compile(";");
    AppMethodBeat.o(99837);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(99835);
    this.yZl = null;
    this.yZF = new b();
    this.yZG = new a();
    AppMethodBeat.o(99835);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(99836);
    int i;
    if (this.jPN != null)
    {
      if (this.contact != null) {
        break label622;
      }
      g.agS();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNn(this.jPN.sxG);
      if (this.contact != null) {
        break label622;
      }
      g.agS();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNs(this.jPN.sxG);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.iCd = "";
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
            break label263;
            parama = yZD.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, com.tencent.mm.cc.a.au(paramContext, 2131165466));
          break label308;
          this.iCd = ((b)g.ab(b.class)).b(this.contact, this.contact.field_username);
          if (this.jPN != null) {
            this.yZE = ("(" + this.jPN.syN + ")");
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
  
  public final com.tencent.mm.ui.contact.a.a.b aOg()
  {
    return this.yZF;
  }
  
  public final class a
    extends com.tencent.mm.ui.contact.a.a.a
  {
    public ImageView fuY;
    public TextView fuZ;
    public CheckBox iCi;
    public TextView ijE;
    public TextView sDL;
    public ImageView yNG;
    
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
      a.a locala = (a.a)a.this.yZG;
      locala.fuY = ((ImageView)paramViewGroup.findViewById(2131304945));
      locala.fuZ = ((TextView)paramViewGroup.findViewById(2131304950));
      locala.ijE = ((TextView)paramViewGroup.findViewById(2131304946));
      locala.ijE.setVisibility(8);
      locala.sDL = ((TextView)paramViewGroup.findViewById(2131304949));
      locala.iCi = ((CheckBox)paramViewGroup.findViewById(2131304948));
      locala.yNG = ((ImageView)paramViewGroup.findViewById(2131304947));
      locala.yNG.setImageDrawable(am.k(paramContext, 2131691196, paramContext.getResources().getColor(2131099676)));
      locala.yNG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99832);
          if (a.this.yZl != null) {
            a.this.yZl.onClick(paramAnonymousView);
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fuY, parama1.username, 0.1F, false);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.iCd, parama.fuZ);
        if (!w.wr(parama1.username)) {
          break label219;
        }
        paramContext = paramContext.getResources().getDrawable(2131691000);
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
        parama.fuZ.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.gIg, parama.ijE);
        com.tencent.mm.plugin.fts.ui.m.a(parama1.yZE, parama.sDL);
        if (!a.this.Iwh) {
          break label260;
        }
        if (!paramBoolean1) {
          break label240;
        }
        parama.iCi.setChecked(true);
        parama.iCi.setEnabled(false);
        paramContext = parama.iCi;
        if (!aj.DT()) {
          break label233;
        }
        i = 2131689939;
        label173:
        paramContext.setBackgroundResource(i);
        label179:
        parama.iCi.setVisibility(0);
      }
      for (;;)
      {
        parama.yNG.setTag(a.this.contact);
        AppMethodBeat.o(99834);
        return;
        parama.fuY.setImageResource(2131231875);
        break;
        label219:
        parama.fuZ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label103;
        label233:
        i = 2131689938;
        break label173;
        label240:
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
        break label179;
        label260:
        parama.iCi.setVisibility(8);
      }
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */