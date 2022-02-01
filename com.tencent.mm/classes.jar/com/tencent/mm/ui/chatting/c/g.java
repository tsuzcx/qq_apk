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
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.c.b.c
{
  private static HashMap<String, e> HTe;
  private Bitmap HTb;
  private ImageView HTc;
  private final k.a HTd;
  private ImageView qTu;
  private e weM;
  
  static
  {
    AppMethodBeat.i(35176);
    HTe = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.HTd = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35166);
        ac.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.cLy.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.eDd();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.weM = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean ck(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (HTe.containsKey(paramString))
    {
      this.weM = ((e)HTe.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      this.weM = new e(bs.convertStreamToString(paramContext.getAssets().open(paramString)), this.cLy.HZF.getContext());
      HTe.put(paramString, this.weM);
      AppMethodBeat.o(35172);
      return true;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(35172);
    }
    return false;
  }
  
  private void fmN()
  {
    AppMethodBeat.i(35169);
    if ((this.HTb != null) && (!this.HTb.isRecycled()))
    {
      ac.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.HTb.toString() });
      this.HTb.recycle();
    }
    if (this.HTc != null) {
      this.HTc.setImageBitmap(null);
    }
    if (this.qTu != null) {
      this.qTu.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int fmO()
  {
    AppMethodBeat.i(35170);
    int i = this.cLy.HZF.getMMResources().getColor(2131100207);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    fmN();
    if (this.HTc == null)
    {
      View localView = this.cLy.findViewById(2131298066);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.HTc.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void eDd()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.bb.a locala = t.aGP().CW(this.cLy.getTalkerUserName());
    if (locala == null) {
      az.ayM();
    }
    for (int i = ((Integer)com.tencent.mm.model.c.agA().get(12311, Integer.valueOf(-2))).intValue(); i == -2; i = locala.hPy)
    {
      setBackgroundColor(fmO());
      ck(this.cLy.HZF.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
    }
    t.aGO();
    int k = p.cI(this.cLy.HZF.getContext());
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
        fmN();
      }
      try
      {
        this.HTb = BitmapFactory.decodeResource(this.cLy.HZF.getMMResources(), 2131231650);
        label183:
        if (this.HTb == null)
        {
          ac.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = 2131231650");
          setBackgroundColor(this.cLy.HZF.getMMResources().getColor(2131100140));
          ck(this.cLy.HZF.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          i = 2131231650;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        do
        {
          ac.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          localObject = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError);
          AppMethodBeat.o(35168);
          throw ((Throwable)localObject);
          if (this.HTc == null) {
            this.HTc = ((ImageView)this.cLy.findViewById(2131298065));
          }
          if (this.qTu == null) {
            this.qTu = ((ImageView)this.cLy.findViewById(2131297208));
          }
          if (this.HTc != null) {
            this.HTc.setImageBitmap(this.HTb);
          }
        } while (this.qTu == null);
        Object localObject = this.qTu;
        if (aj.DT()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        p localp = t.aGO();
        if (i > 0)
        {
          ck(this.cLy.HZF.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          fmN();
          this.HTb = u.FE((String)localObject);
          if (this.HTb != null) {
            break;
          }
          ac.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(fmO());
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
          ck(this.cLy.HZF.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = p.al("default", k);
          } else {
            localObject = p.al(this.cLy.getTalkerUserName(), k);
          }
        }
        if (this.HTc == null) {
          this.HTc = ((ImageView)this.cLy.findViewById(2131298065));
        }
        if (this.qTu == null) {
          this.qTu = ((ImageView)this.cLy.findViewById(2131297208));
        }
        if (this.HTc != null) {
          this.HTc.setImageBitmap(this.HTb);
        }
        if (this.qTu != null)
        {
          localObject = this.qTu;
          if (!aj.DT()) {
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
  
  public final void fgg() {}
  
  public final void fgh()
  {
    AppMethodBeat.i(35173);
    ac.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    eDd();
    AppMethodBeat.o(35173);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35174);
    t.aGP().add(this.HTd);
    t.aGO().add(this.HTd);
    AppMethodBeat.o(35174);
  }
  
  public final void fgj() {}
  
  public final void fgk() {}
  
  public final void fgm()
  {
    AppMethodBeat.i(35175);
    ac.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (az.agM())
    {
      t.aGP().remove(this.HTd);
      t.aGO().remove(this.HTd);
    }
    fmN();
    AppMethodBeat.o(35175);
  }
  
  public final e fmP()
  {
    return this.weM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.g
 * JD-Core Version:    0.7.0.1
 */