package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
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
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.d.b.c
{
  private static HashMap<String, f> Kcp;
  private Bitmap Kcl;
  private ImageView Kcm;
  private boolean Kcn;
  private final k.a Kco;
  private ImageView rLI;
  private f xCs;
  
  static
  {
    AppMethodBeat.i(35176);
    Kcp = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.Kcn = true;
    this.Kco = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35166);
        ae.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.cXJ.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.eVH();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.xCs = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean cq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (Kcp.containsKey(paramString))
    {
      this.xCs = ((f)Kcp.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      this.xCs = new f(bu.convertStreamToString(paramContext.getAssets().open(paramString)), this.cXJ.Kkd.getContext());
      Kcp.put(paramString, this.xCs);
      AppMethodBeat.o(35172);
      return true;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(35172);
    }
    return false;
  }
  
  private void fHj()
  {
    AppMethodBeat.i(35169);
    if ((this.Kcl != null) && (!this.Kcl.isRecycled()))
    {
      ae.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.Kcl.toString() });
      this.Kcl.recycle();
    }
    if (this.Kcm != null) {
      this.Kcm.setImageBitmap(null);
    }
    if (this.rLI != null) {
      this.rLI.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int fHk()
  {
    AppMethodBeat.i(35170);
    int i = this.cXJ.Kkd.getMMResources().getColor(2131100207);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    fHj();
    if (this.Kcm == null)
    {
      View localView = this.cXJ.findViewById(2131298066);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.Kcm.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void eVH()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.bb.a locala;
    if (((af)this.cXJ.bh(af.class)).fID())
    {
      locala = null;
      if (locala != null) {
        break label115;
      }
      bc.aCg();
    }
    label115:
    for (int i = ((Integer)com.tencent.mm.model.c.ajA().get(12311, Integer.valueOf(-2))).intValue();; i = locala.ilF)
    {
      if (i != -2) {
        break label124;
      }
      setBackgroundColor(fHk());
      cq(this.cXJ.Kkd.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
      locala = t.aKt().GD(this.cXJ.getTalkerUserName());
      break;
    }
    label124:
    t.aKs();
    int k = p.cH(this.cXJ.Kkd.getContext());
    switch (k)
    {
    default: 
      this.Kcn = true;
    }
    for (;;)
    {
      if (i == 0) {
        switch (k)
        {
        default: 
          i = -1;
          if (i != -1) {
            fHj();
          }
          break;
        }
      }
      try
      {
        this.Kcl = BitmapFactory.decodeResource(this.cXJ.Kkd.getMMResources(), i);
        label233:
        if (this.Kcl == null)
        {
          ae.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = ".concat(String.valueOf(i)));
          setBackgroundColor(this.cXJ.Kkd.getMMResources().getColor(2131100140));
          cq(this.cXJ.Kkd.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          this.Kcn = false;
          continue;
          i = 2131231650;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        do
        {
          ae.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          localObject = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError);
          AppMethodBeat.o(35168);
          throw ((Throwable)localObject);
          if (this.Kcm == null) {
            this.Kcm = ((ImageView)this.cXJ.findViewById(2131298065));
          }
          if (this.rLI == null) {
            this.rLI = ((ImageView)this.cXJ.findViewById(2131297208));
          }
          if (this.Kcm != null) {
            this.Kcm.setImageBitmap(this.Kcl);
          }
        } while (this.rLI == null);
        Object localObject = this.rLI;
        if (al.isDarkMode()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        p localp = t.aKs();
        if (i > 0)
        {
          cq(this.cXJ.Kkd.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          fHj();
          this.Kcl = u.Js((String)localObject);
          if (this.Kcl != null) {
            break;
          }
          ae.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(fHk());
          AppMethodBeat.o(35168);
          return;
          localObject = localp.dm(i, 1) + "horizontal_hdpi.jpg";
          continue;
          localObject = localp.dm(i, 1) + "horizontal_ldpi.jpg";
          continue;
          localObject = localp.dm(i, 1) + "vertical_hdpi.jpg";
          continue;
          localObject = localp.dm(i, 1) + "vertical_ldpi.jpg";
          continue;
          cq(this.cXJ.Kkd.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = p.ao("default", k);
          } else {
            localObject = p.ao(this.cXJ.getTalkerUserName(), k);
          }
        }
        if (this.Kcm == null) {
          this.Kcm = ((ImageView)this.cXJ.findViewById(2131298065));
        }
        if (this.rLI == null) {
          this.rLI = ((ImageView)this.cXJ.findViewById(2131297208));
        }
        if (this.Kcm != null) {
          this.Kcm.setImageBitmap(this.Kcl);
        }
        if (this.rLI != null)
        {
          localObject = this.rLI;
          if (!al.isDarkMode()) {
            break label851;
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
        label851:
        break label233;
      }
    }
  }
  
  public final void fAs() {}
  
  public final void fAt()
  {
    AppMethodBeat.i(35173);
    ae.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    eVH();
    AppMethodBeat.o(35173);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35174);
    t.aKt().add(this.Kco);
    t.aKs().add(this.Kco);
    AppMethodBeat.o(35174);
  }
  
  public final void fAv() {}
  
  public final void fAw() {}
  
  public final void fAy()
  {
    AppMethodBeat.i(35175);
    ae.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (bc.ajM())
    {
      t.aKt().remove(this.Kco);
      t.aKs().remove(this.Kco);
    }
    fHj();
    AppMethodBeat.o(35175);
  }
  
  public final f fHl()
  {
    return this.xCs;
  }
  
  public final boolean fHm()
  {
    AppMethodBeat.i(187291);
    com.tencent.mm.bb.a locala = t.aKt().GD(this.cXJ.getTalkerUserName());
    if ((locala == null) || (locala.ilF == -2))
    {
      AppMethodBeat.o(187291);
      return false;
    }
    AppMethodBeat.o(187291);
    return true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(187292);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.orientation == 1) && (!this.Kcn))
    {
      eVH();
      AppMethodBeat.o(187292);
      return;
    }
    if ((paramConfiguration.orientation == 2) && (this.Kcn)) {
      eVH();
    }
    AppMethodBeat.o(187292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.g
 * JD-Core Version:    0.7.0.1
 */