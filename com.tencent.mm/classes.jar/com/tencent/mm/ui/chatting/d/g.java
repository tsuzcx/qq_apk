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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.be.b;
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.c.class)
public class g
  extends a
  implements com.tencent.mm.ui.chatting.d.b.c
{
  private static HashMap<String, f> WHX;
  private f Hyv;
  private Bitmap WHT;
  private ImageView WHU;
  private boolean WHV;
  private final MStorage.IOnStorageChange WHW;
  private ImageView wRS;
  
  static
  {
    AppMethodBeat.i(35176);
    WHX = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.WHV = true;
    this.WHW = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35166);
        Log.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.fgR.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.gXB();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.Hyv = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean cU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (WHX.containsKey(paramString))
    {
      this.Hyv = ((f)WHX.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      paramContext = Util.convertStreamToString(paramContext.getAssets().open(paramString));
      if (!Util.isNullOrNil(paramContext))
      {
        this.Hyv = new f(paramContext, this.fgR.WQv.getContext());
        WHX.put(paramString, this.Hyv);
      }
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
  
  private void hOF()
  {
    AppMethodBeat.i(35169);
    if ((this.WHT != null) && (!this.WHT.isRecycled()))
    {
      Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.WHT.toString() });
      this.WHT.recycle();
    }
    if (this.WHU != null) {
      this.WHU.setImageBitmap(null);
    }
    if (this.wRS != null) {
      this.wRS.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private int hOG()
  {
    AppMethodBeat.i(35170);
    int i = this.fgR.WQv.getMMResources().getColor(R.e.default_background_color);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    hOF();
    if (this.WHU == null)
    {
      View localView = this.fgR.findViewById(R.h.chatting_bg_ll);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.WHU.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  public final void gXB()
  {
    int j = 0;
    AppMethodBeat.i(35168);
    com.tencent.mm.be.a locala;
    if (((ai)this.fgR.bC(ai.class)).hQk())
    {
      locala = null;
      if (locala != null) {
        break label115;
      }
      bh.beI();
    }
    label115:
    for (int i = ((Integer)com.tencent.mm.model.c.aHp().b(12311, Integer.valueOf(-2))).intValue();; i = locala.lXh)
    {
      if (i != -2) {
        break label124;
      }
      setBackgroundColor(hOG());
      cU(this.fgR.WQv.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(35168);
      return;
      locala = w.bnV().WM(this.fgR.getTalkerUserName());
      break;
    }
    label124:
    w.bnU();
    int k = s.da(this.fgR.WQv.getContext());
    switch (k)
    {
    default: 
      this.WHV = true;
    }
    for (;;)
    {
      if (i == 0) {
        switch (k)
        {
        default: 
          i = -1;
          if (i != -1) {
            hOF();
          }
          break;
        }
      }
      try
      {
        this.WHT = BitmapFactory.decodeResource(this.fgR.WQv.getMMResources(), i);
        label233:
        if (this.WHT == null)
        {
          Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = ".concat(String.valueOf(i)));
          setBackgroundColor(this.fgR.WQv.getMMResources().getColor(R.e.chatting_bg_purecolor));
          cU(this.fgR.WQv.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(35168);
          return;
          this.WHV = false;
          continue;
          i = R.g.chatting_bg_default;
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
          if (this.WHU == null) {
            this.WHU = ((ImageView)this.fgR.findViewById(R.h.dwX));
          }
          if (this.wRS == null) {
            this.wRS = ((ImageView)this.fgR.findViewById(R.h.dth));
          }
          if (this.WHU != null) {
            this.WHU.setImageBitmap(this.WHT);
          }
        } while (this.wRS == null);
        Object localObject = this.wRS;
        if (ar.isDarkMode()) {}
        for (i = 0;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
        s locals = w.bnU();
        if (i > 0)
        {
          cU(this.fgR.WQv.getContext(), "chatting/default_chat.xml");
          switch (k)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          hOF();
          this.WHT = u.ZS((String)localObject);
          if (this.WHT != null) {
            break;
          }
          Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(hOG());
          AppMethodBeat.o(35168);
          return;
          localObject = locals.dT(i, 1) + "horizontal_hdpi.jpg";
          continue;
          localObject = locals.dT(i, 1) + "horizontal_ldpi.jpg";
          continue;
          localObject = locals.dT(i, 1) + "vertical_hdpi.jpg";
          continue;
          localObject = locals.dT(i, 1) + "vertical_ldpi.jpg";
          continue;
          cU(this.fgR.WQv.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = s.aK("default", k);
          } else {
            localObject = s.aK(this.fgR.getTalkerUserName(), k);
          }
        }
        if (this.WHU == null) {
          this.WHU = ((ImageView)this.fgR.findViewById(R.h.dwX));
        }
        if (this.wRS == null) {
          this.wRS = ((ImageView)this.fgR.findViewById(R.h.dth));
        }
        if (this.WHU != null) {
          this.WHU.setImageBitmap(this.WHT);
        }
        if (this.wRS != null)
        {
          localObject = this.wRS;
          if (!ar.isDarkMode()) {
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
  
  public final void hGU() {}
  
  public final void hGV()
  {
    AppMethodBeat.i(35173);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    gXB();
    AppMethodBeat.o(35173);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35174);
    w.bnV().add(this.WHW);
    w.bnU().add(this.WHW);
    AppMethodBeat.o(35174);
  }
  
  public final void hGX() {}
  
  public final void hGY() {}
  
  public final void hHa()
  {
    AppMethodBeat.i(35175);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (bh.aHB())
    {
      w.bnV().remove(this.WHW);
      w.bnU().remove(this.WHW);
    }
    hOF();
    AppMethodBeat.o(35175);
  }
  
  public final f hOH()
  {
    return this.Hyv;
  }
  
  public final boolean hOI()
  {
    AppMethodBeat.i(291457);
    com.tencent.mm.be.a locala = w.bnV().WM(this.fgR.getTalkerUserName());
    if ((locala == null) || (locala.lXh == -2))
    {
      AppMethodBeat.o(291457);
      return false;
    }
    AppMethodBeat.o(291457);
    return true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(291458);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.orientation == 1) && (!this.WHV))
    {
      gXB();
      AppMethodBeat.o(291458);
      return;
    }
    if ((paramConfiguration.orientation == 2) && (this.WHV)) {
      gXB();
    }
    AppMethodBeat.o(291458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.g
 * JD-Core Version:    0.7.0.1
 */