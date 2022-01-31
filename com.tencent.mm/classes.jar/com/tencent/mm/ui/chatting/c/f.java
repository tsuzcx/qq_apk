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
import com.tencent.mm.ba.b;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.c.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.c.b.c
{
  private static HashMap<String, e> zEK;
  private e pUc;
  private Bitmap zEH;
  private ImageView zEI;
  private final k.a zEJ;
  
  static
  {
    AppMethodBeat.i(31286);
    zEK = new HashMap();
    AppMethodBeat.o(31286);
  }
  
  public f()
  {
    AppMethodBeat.i(31277);
    this.zEJ = new f.1(this);
    this.pUc = null;
    AppMethodBeat.o(31277);
  }
  
  private boolean bR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31282);
    if (zEK.containsKey(paramString))
    {
      this.pUc = ((e)zEK.get(paramString));
      AppMethodBeat.o(31282);
      return true;
    }
    try
    {
      this.pUc = new e(bo.convertStreamToString(paramContext.getAssets().open(paramString)));
      zEK.put(paramString, this.pUc);
      AppMethodBeat.o(31282);
      return true;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(31282);
    }
    return false;
  }
  
  private void dHQ()
  {
    AppMethodBeat.i(31279);
    if ((this.zEH != null) && (!this.zEH.isRecycled()))
    {
      ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.zEH.toString() });
      this.zEH.recycle();
    }
    if (this.zEI != null) {
      this.zEI.setImageBitmap(null);
    }
    AppMethodBeat.o(31279);
  }
  
  private int dHR()
  {
    AppMethodBeat.i(31280);
    int i = this.caz.zJz.getMMResources().getColor(2131689877);
    AppMethodBeat.o(31280);
    return i;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(31281);
    dHQ();
    if (this.zEI == null)
    {
      View localView = this.caz.findViewById(2131821559);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(31281);
      return;
    }
    this.zEI.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(31281);
  }
  
  public final void dBY() {}
  
  public final void dBZ()
  {
    AppMethodBeat.i(31283);
    ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    ddH();
    AppMethodBeat.o(31283);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31284);
    r.aiQ().add(this.zEJ);
    r.aiP().add(this.zEJ);
    AppMethodBeat.o(31284);
  }
  
  public final void dCb() {}
  
  public final void dCc() {}
  
  public final void dCe()
  {
    AppMethodBeat.i(31285);
    ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (aw.RG())
    {
      r.aiQ().remove(this.zEJ);
      r.aiP().remove(this.zEJ);
    }
    dHQ();
    AppMethodBeat.o(31285);
  }
  
  public final e dHS()
  {
    return this.pUc;
  }
  
  public final void ddH()
  {
    AppMethodBeat.i(31278);
    com.tencent.mm.ba.a locala = r.aiQ().tS(this.caz.getTalkerUserName());
    if (locala == null) {
      aw.aaz();
    }
    for (int i = ((Integer)com.tencent.mm.model.c.Ru().get(12311, Integer.valueOf(-2))).intValue(); i == -2; i = locala.fMk)
    {
      setBackgroundColor(dHR());
      bR(this.caz.zJz.getContext(), "chatting/purecolor_chat.xml");
      AppMethodBeat.o(31278);
      return;
    }
    r.aiP();
    int j = n.cg(this.caz.zJz.getContext());
    if (i == 0) {
      switch (j)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      if (i != -1) {
        dHQ();
      }
      try
      {
        this.zEH = BitmapFactory.decodeResource(this.caz.zJz.getMMResources(), 2130838299);
        label179:
        if (this.zEH == null)
        {
          ab.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = 2130838299");
          setBackgroundColor(this.caz.zJz.getMMResources().getColor(2131689877));
          bR(this.caz.zJz.getContext(), "chatting/reserved_chat.xml");
          AppMethodBeat.o(31278);
          return;
          i = 2130838299;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        Object localObject;
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          localObject = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError);
          AppMethodBeat.o(31278);
          throw ((Throwable)localObject);
          if (this.zEI == null) {
            this.zEI = ((ImageView)this.caz.findViewById(2131822460));
          }
          if (this.zEI != null) {
            this.zEI.setImageBitmap(this.zEH);
          }
        }
        n localn = r.aiP();
        if (i > 0)
        {
          bR(this.caz.zJz.getContext(), "chatting/default_chat.xml");
          switch (j)
          {
          default: 
            localObject = null;
          }
        }
        for (;;)
        {
          dHQ();
          this.zEH = x.wx((String)localObject);
          if (this.zEH != null) {
            break;
          }
          ab.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(localObject)));
          setBackgroundColor(dHR());
          AppMethodBeat.o(31278);
          return;
          localObject = localn.cC(i, 1) + "horizontal_hdpi.jpg";
          continue;
          localObject = localn.cC(i, 1) + "horizontal_ldpi.jpg";
          continue;
          localObject = localn.cC(i, 1) + "vertical_hdpi.jpg";
          continue;
          localObject = localn.cC(i, 1) + "vertical_ldpi.jpg";
          continue;
          bR(this.caz.zJz.getContext(), "chatting/default_chat.xml");
          if (localObject == null) {
            localObject = n.Z("default", j);
          } else {
            localObject = n.Z(this.caz.getTalkerUserName(), j);
          }
        }
        if (this.zEI == null) {
          this.zEI = ((ImageView)this.caz.findViewById(2131822460));
        }
        if (this.zEI != null) {
          this.zEI.setImageBitmap(this.zEH);
        }
        AppMethodBeat.o(31278);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label179;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.f
 * JD-Core Version:    0.7.0.1
 */