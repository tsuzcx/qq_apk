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
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.d.b.c
{
  private static HashMap<String, f> JHy;
  private Bitmap JHu;
  private ImageView JHv;
  private boolean JHw;
  private final k.a JHx;
  private ImageView rDx;
  private f xmv;
  
  static
  {
    AppMethodBeat.i(35176);
    JHy = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.JHw = true;
    this.JHx = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35166);
        ad.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.cWM.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.eRV();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.xmv = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean cp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (JHy.containsKey(paramString))
    {
      this.xmv = ((f)JHy.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      this.xmv = new f(bt.convertStreamToString(paramContext.getAssets().open(paramString)), this.cWM.JOR.getContext());
      JHy.put(paramString, this.xmv);
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
  
  private void fDh()
  {
    AppMethodBeat.i(35169);
    if ((this.JHu != null) && (!this.JHu.isRecycled()))
    {
      ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.JHu.toString() });
      this.JHu.recycle();
    }
    if (this.JHv != null) {
      this.JHv.setImageBitmap(null);
    }
    if (this.rDx != null) {
      this.rDx.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int fDi()
  {
    AppMethodBeat.i(35170);
    int i = this.cWM.JOR.getMMResources().getColor(2131100207);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    fDh();
    if (this.JHv == null)
    {
      View localView = this.cWM.findViewById(2131298066);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.JHv.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void eRV()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.bc.a locala;
    if (((af)this.cWM.bh(af.class)).fEz())
    {
      locala = null;
      if (locala != null) {
        break label115;
      }
      ba.aBQ();
    }
    label115:
    for (int i = ((Integer)com.tencent.mm.model.c.ajl().get(12311, Integer.valueOf(-2))).intValue();; i = locala.iiM)
    {
      if (i != -2) {
        break label124;
      }
      setBackgroundColor(fDi());
      cp(this.cWM.JOR.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
      locala = t.aKa().Gb(this.cWM.getTalkerUserName());
      break;
    }
    label124:
    t.aJZ();
    int k = p.cF(this.cWM.JOR.getContext());
    switch (k)
    {
    default: 
      this.JHw = true;
    }
    for (;;)
    {
      if (i == 0) {
        switch (k)
        {
        default: 
          i = -1;
          if (i != -1) {
            fDh();
          }
          break;
        }
      }
      try
      {
        this.JHu = BitmapFactory.decodeResource(this.cWM.JOR.getMMResources(), i);
        label233:
        if (this.JHu == null)
        {
          ad.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = ".concat(String.valueOf(i)));
          setBackgroundColor(this.cWM.JOR.getMMResources().getColor(2131100140));
          cp(this.cWM.JOR.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          this.JHw = false;
          continue;
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
          if (this.JHv == null) {
            this.JHv = ((ImageView)this.cWM.findViewById(2131298065));
          }
          if (this.rDx == null) {
            this.rDx = ((ImageView)this.cWM.findViewById(2131297208));
          }
          if (this.JHv != null) {
            this.JHv.setImageBitmap(this.JHu);
          }
        } while (this.rDx == null);
        Object localObject = this.rDx;
        if (al.isDarkMode()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        p localp = t.aJZ();
        if (i > 0)
        {
          cp(this.cWM.JOR.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          fDh();
          this.JHu = u.IT((String)localObject);
          if (this.JHu != null) {
            break;
          }
          ad.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(fDi());
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
          cp(this.cWM.JOR.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = p.an("default", k);
          } else {
            localObject = p.an(this.cWM.getTalkerUserName(), k);
          }
        }
        if (this.JHv == null) {
          this.JHv = ((ImageView)this.cWM.findViewById(2131298065));
        }
        if (this.rDx == null) {
          this.rDx = ((ImageView)this.cWM.findViewById(2131297208));
        }
        if (this.JHv != null) {
          this.JHv.setImageBitmap(this.JHu);
        }
        if (this.rDx != null)
        {
          localObject = this.rDx;
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
  
  public final f fDj()
  {
    return this.xmv;
  }
  
  public final void fws() {}
  
  public final void fwt()
  {
    AppMethodBeat.i(35173);
    ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    eRV();
    AppMethodBeat.o(35173);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35174);
    t.aKa().add(this.JHx);
    t.aJZ().add(this.JHx);
    AppMethodBeat.o(35174);
  }
  
  public final void fwv() {}
  
  public final void fww() {}
  
  public final void fwy()
  {
    AppMethodBeat.i(35175);
    ad.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (ba.ajx())
    {
      t.aKa().remove(this.JHx);
      t.aJZ().remove(this.JHx);
    }
    fDh();
    AppMethodBeat.o(35175);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(193984);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.orientation == 1) && (!this.JHw))
    {
      eRV();
      AppMethodBeat.o(193984);
      return;
    }
    if ((paramConfiguration.orientation == 2) && (this.JHw)) {
      eRV();
    }
    AppMethodBeat.o(193984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.g
 * JD-Core Version:    0.7.0.1
 */