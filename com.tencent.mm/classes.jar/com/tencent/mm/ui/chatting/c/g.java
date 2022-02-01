package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.c.b.c
{
  private static HashMap<String, e> Gtl;
  private Bitmap Gti;
  private ImageView Gtj;
  private final k.a Gtk;
  private ImageView qkS;
  private e uVX;
  
  static
  {
    AppMethodBeat.i(35176);
    Gtl = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.Gtk = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35166);
        ad.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.cOd.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.enK();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.uVX = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean ck(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (Gtl.containsKey(paramString))
    {
      this.uVX = ((e)Gtl.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      this.uVX = new e(bt.convertStreamToString(paramContext.getAssets().open(paramString)), this.cOd.GzJ.getContext());
      Gtl.put(paramString, this.uVX);
      AppMethodBeat.o(35172);
      return true;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(35172);
    }
    return false;
  }
  
  private void eXb()
  {
    AppMethodBeat.i(35169);
    if ((this.Gti != null) && (!this.Gti.isRecycled()))
    {
      ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.Gti.toString() });
      this.Gti.recycle();
    }
    if (this.Gtj != null) {
      this.Gtj.setImageBitmap(null);
    }
    if (this.qkS != null) {
      this.qkS.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int eXc()
  {
    AppMethodBeat.i(35170);
    int i = this.cOd.GzJ.getMMResources().getColor(2131100207);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    eXb();
    if (this.Gtj == null)
    {
      View localView = this.cOd.findViewById(2131298066);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.Gtj.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void eQA() {}
  
  public final void eQB()
  {
    AppMethodBeat.i(35173);
    ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    enK();
    AppMethodBeat.o(35173);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35174);
    t.azZ().add(this.Gtk);
    t.azY().add(this.Gtk);
    AppMethodBeat.o(35174);
  }
  
  public final void eQD() {}
  
  public final void eQE() {}
  
  public final void eQG()
  {
    AppMethodBeat.i(35175);
    ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (az.afw())
    {
      t.azZ().remove(this.Gtk);
      t.azY().remove(this.Gtk);
    }
    eXb();
    AppMethodBeat.o(35175);
  }
  
  public final e eXd()
  {
    return this.uVX;
  }
  
  public final void enK()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.bc.a locala = t.azZ().yR(this.cOd.getTalkerUserName());
    if (locala == null) {
      az.arV();
    }
    for (int i = ((Integer)com.tencent.mm.model.c.afk().get(12311, Integer.valueOf(-2))).intValue(); i == -2; i = locala.hoW)
    {
      setBackgroundColor(eXc());
      ck(this.cOd.GzJ.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
    }
    t.azY();
    int k = p.cz(this.cOd.GzJ.getContext());
    if (i == 0) {
      switch (k)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      if (i != -1) {
        eXb();
      }
      try
      {
        this.Gti = BitmapFactory.decodeResource(this.cOd.GzJ.getMMResources(), 2131231650);
        label183:
        if (this.Gti == null)
        {
          ad.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = 2131231650");
          setBackgroundColor(this.cOd.GzJ.getMMResources().getColor(2131100140));
          ck(this.cOd.GzJ.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          i = 2131231650;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        do
        {
          ad.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          localObject = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError);
          AppMethodBeat.o(35168);
          throw ((Throwable)localObject);
          if (this.Gtj == null) {
            this.Gtj = ((ImageView)this.cOd.findViewById(2131298065));
          }
          if (this.qkS == null) {
            this.qkS = ((ImageView)this.cOd.findViewById(2131297208));
          }
          if (this.Gtj != null) {
            this.Gtj.setImageBitmap(this.Gti);
          }
        } while (this.qkS == null);
        Object localObject = this.qkS;
        if (ai.Eq()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        p localp = t.azY();
        if (i > 0)
        {
          ck(this.cOd.GzJ.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          eXb();
          this.Gti = u.BA((String)localObject);
          if (this.Gti != null) {
            break;
          }
          ad.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(eXc());
          AppMethodBeat.o(35168);
          return;
          localObject = localp.dj(i, 1) + "horizontal_hdpi.jpg";
          continue;
          localObject = localp.dj(i, 1) + "horizontal_ldpi.jpg";
          continue;
          localObject = localp.dj(i, 1) + "vertical_hdpi.jpg";
          continue;
          localObject = localp.dj(i, 1) + "vertical_ldpi.jpg";
          continue;
          ck(this.cOd.GzJ.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = p.ah("default", k);
          } else {
            localObject = p.ah(this.cOd.getTalkerUserName(), k);
          }
        }
        if (this.Gtj == null) {
          this.Gtj = ((ImageView)this.cOd.findViewById(2131298065));
        }
        if (this.qkS == null) {
          this.qkS = ((ImageView)this.cOd.findViewById(2131297208));
        }
        if (this.Gtj != null) {
          this.Gtj.setImageBitmap(this.Gti);
        }
        if (this.qkS != null)
        {
          localObject = this.qkS;
          if (!ai.Eq()) {
            break label783;
          }
        }
        for (i = j;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          AppMethodBeat.o(35168);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        label783:
        break label183;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.g
 * JD-Core Version:    0.7.0.1
 */