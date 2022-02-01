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
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.d.b.c
{
  private static HashMap<String, f> PnL;
  private f BCr;
  private Bitmap PnH;
  private ImageView PnI;
  private boolean PnJ;
  private final MStorage.IOnStorageChange PnK;
  private ImageView tlu;
  
  static
  {
    AppMethodBeat.i(35176);
    PnL = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.PnJ = true;
    this.PnK = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35166);
        Log.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.dom.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.geA();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.BCr = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean cJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (PnL.containsKey(paramString))
    {
      this.BCr = ((f)PnL.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      this.BCr = new f(Util.convertStreamToString(paramContext.getAssets().open(paramString)), this.dom.Pwc.getContext());
      PnL.put(paramString, this.BCr);
      AppMethodBeat.o(35172);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(35172);
    }
    return false;
  }
  
  private void gPp()
  {
    AppMethodBeat.i(35169);
    if ((this.PnH != null) && (!this.PnH.isRecycled()))
    {
      Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.PnH.toString() });
      this.PnH.recycle();
    }
    if (this.PnI != null) {
      this.PnI.setImageBitmap(null);
    }
    if (this.tlu != null) {
      this.tlu.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int gPq()
  {
    AppMethodBeat.i(35170);
    int i = this.dom.Pwc.getMMResources().getColor(2131100240);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    gPp();
    if (this.PnI == null)
    {
      View localView = this.dom.findViewById(2131298408);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.PnI.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void cFx() {}
  
  public final void cFy() {}
  
  public final void gIk() {}
  
  public final void gIl()
  {
    AppMethodBeat.i(35173);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    geA();
    AppMethodBeat.o(35173);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35174);
    v.bew().add(this.PnK);
    v.bev().add(this.PnK);
    AppMethodBeat.o(35174);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(35175);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (bg.aAc())
    {
      v.bew().remove(this.PnK);
      v.bev().remove(this.PnK);
    }
    gPp();
    AppMethodBeat.o(35175);
  }
  
  public final f gPr()
  {
    return this.BCr;
  }
  
  public final boolean gPs()
  {
    AppMethodBeat.i(233050);
    com.tencent.mm.bb.a locala = v.bew().Pp(this.dom.getTalkerUserName());
    if ((locala == null) || (locala.jgE == -2))
    {
      AppMethodBeat.o(233050);
      return false;
    }
    AppMethodBeat.o(233050);
    return true;
  }
  
  public final void geA()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.bb.a locala;
    if (((ai)this.dom.bh(ai.class)).gQN())
    {
      locala = null;
      if (locala != null) {
        break label119;
      }
      bg.aVF();
    }
    label119:
    for (int i = ((Integer)com.tencent.mm.model.c.azQ().get(12311, Integer.valueOf(-2))).intValue();; i = locala.jgE)
    {
      if (i != -2) {
        break label128;
      }
      setBackgroundColor(gPq());
      cJ(this.dom.Pwc.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
      locala = v.bew().Pp(this.dom.getTalkerUserName());
      break;
    }
    label128:
    v.bev();
    int k = r.dd(this.dom.Pwc.getContext());
    switch (k)
    {
    default: 
      this.PnJ = true;
    }
    for (;;)
    {
      if (i == 0) {
        switch (k)
        {
        default: 
          i = -1;
          if (i != -1) {
            gPp();
          }
          break;
        }
      }
      try
      {
        this.PnH = BitmapFactory.decodeResource(this.dom.Pwc.getMMResources(), i);
        label237:
        if (this.PnH == null)
        {
          Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = ".concat(String.valueOf(i)));
          setBackgroundColor(this.dom.Pwc.getMMResources().getColor(2131100172));
          cJ(this.dom.Pwc.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          this.PnJ = false;
          continue;
          i = 2131231716;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        do
        {
          Log.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          localObject = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError);
          AppMethodBeat.o(35168);
          throw ((Throwable)localObject);
          if (this.PnI == null) {
            this.PnI = ((ImageView)this.dom.findViewById(2131298407));
          }
          if (this.tlu == null) {
            this.tlu = ((ImageView)this.dom.findViewById(2131297360));
          }
          if (this.PnI != null) {
            this.PnI.setImageBitmap(this.PnH);
          }
        } while (this.tlu == null);
        Object localObject = this.tlu;
        if (com.tencent.mm.ui.ao.isDarkMode()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        r localr = v.bev();
        if (i > 0)
        {
          cJ(this.dom.Pwc.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          gPp();
          this.PnH = u.Sq((String)localObject);
          if (this.PnH != null) {
            break;
          }
          Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(gPq());
          AppMethodBeat.o(35168);
          return;
          localObject = localr.dw(i, 1) + "horizontal_hdpi.jpg";
          continue;
          localObject = localr.dw(i, 1) + "horizontal_ldpi.jpg";
          continue;
          localObject = localr.dw(i, 1) + "vertical_hdpi.jpg";
          continue;
          localObject = localr.dw(i, 1) + "vertical_ldpi.jpg";
          continue;
          cJ(this.dom.Pwc.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = r.as("default", k);
          } else {
            localObject = r.as(this.dom.getTalkerUserName(), k);
          }
        }
        if (this.PnI == null) {
          this.PnI = ((ImageView)this.dom.findViewById(2131298407));
        }
        if (this.tlu == null) {
          this.tlu = ((ImageView)this.dom.findViewById(2131297360));
        }
        if (this.PnI != null) {
          this.PnI.setImageBitmap(this.PnH);
        }
        if (this.tlu != null)
        {
          localObject = this.tlu;
          if (!com.tencent.mm.ui.ao.isDarkMode()) {
            break label857;
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
        label857:
        break label237;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(233051);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.orientation == 1) && (!this.PnJ))
    {
      geA();
      AppMethodBeat.o(233051);
      return;
    }
    if ((paramConfiguration.orientation == 2) && (this.PnJ)) {
      geA();
    }
    AppMethodBeat.o(233051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.g
 * JD-Core Version:    0.7.0.1
 */