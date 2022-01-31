package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.b.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.b.b.b
{
  private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> vpi = new HashMap();
  private com.tencent.mm.pluginsdk.ui.e noO = null;
  private Bitmap vpf;
  private ImageView vpg;
  private final j.a vph = new f.1(this);
  
  private boolean bE(Context paramContext, String paramString)
  {
    if (vpi.containsKey(paramString))
    {
      this.noO = ((com.tencent.mm.pluginsdk.ui.e)vpi.get(paramString));
      return true;
    }
    try
    {
      this.noO = new com.tencent.mm.pluginsdk.ui.e(bk.convertStreamToString(paramContext.getAssets().open(paramString)));
      vpi.put(paramString, this.noO);
      return true;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  private void cEa()
  {
    if ((this.vpf != null) && (!this.vpf.isRecycled()))
    {
      y.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.vpf.toString() });
      this.vpf.recycle();
    }
    if (this.vpg != null) {
      this.vpg.setImageBitmap(null);
    }
  }
  
  private int cEb()
  {
    return this.byx.vtz.getMMResources().getColor(R.e.chatting_bg_purecolor);
  }
  
  private void setBackgroundColor(int paramInt)
  {
    cEa();
    if (this.vpg == null)
    {
      View localView = this.byx.findViewById(R.h.chatting_bg_ll);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      return;
    }
    this.vpg.setImageDrawable(new ColorDrawable(paramInt));
  }
  
  public final com.tencent.mm.pluginsdk.ui.e cEc()
  {
    return this.noO;
  }
  
  public final void cdH()
  {
    com.tencent.mm.az.a locala = r.PL().mI(this.byx.getTalkerUserName());
    int i;
    if (locala == null)
    {
      au.Hx();
      i = ((Integer)c.Dz().get(12311, Integer.valueOf(-2))).intValue();
      if (i != -2) {
        break label83;
      }
      setBackgroundColor(cEb());
      bE(this.byx.vtz.getContext(), "chatting/purecolor_chat.xml");
    }
    for (;;)
    {
      return;
      i = locala.ewu;
      break;
      label83:
      r.PK();
      int j = n.bB(this.byx.vtz.getContext());
      if (i == 0) {
        switch (j)
        {
        default: 
          i = -1;
          if (i == -1) {
            continue;
          }
          cEa();
        }
      }
      try
      {
        this.vpf = BitmapFactory.decodeResource(this.byx.vtz.getMMResources(), i);
        label165:
        if (this.vpf == null)
        {
          y.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = " + i);
          setBackgroundColor(this.byx.vtz.getMMResources().getColor(R.e.chatting_bg_purecolor));
          bE(this.byx.vtz.getContext(), "chatting/reserved_chat.xml");
          return;
          i = R.g.chatting_bg_default;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
          throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError));
          if (this.vpg == null) {
            this.vpg = ((ImageView)this.byx.findViewById(R.h.chatting_bg_iv));
          }
          if (this.vpg != null) {
            this.vpg.setImageBitmap(this.vpf);
          }
        }
        n localn = r.PK();
        String str;
        if (i > 0)
        {
          bE(this.byx.vtz.getContext(), "chatting/default_chat.xml");
          switch (j)
          {
          default: 
            str = null;
          }
        }
        for (;;)
        {
          cEa();
          this.vpf = x.pg(str);
          if (this.vpf != null) {
            break;
          }
          y.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = " + str);
          setBackgroundColor(cEb());
          return;
          str = localn.bs(i, 1) + "horizontal_hdpi.jpg";
          continue;
          str = localn.bs(i, 1) + "horizontal_ldpi.jpg";
          continue;
          str = localn.bs(i, 1) + "vertical_hdpi.jpg";
          continue;
          str = localn.bs(i, 1) + "vertical_ldpi.jpg";
          continue;
          bE(this.byx.vtz.getContext(), "chatting/default_chat.xml");
          if (str == null) {
            str = n.R("default", j);
          } else {
            str = n.R(this.byx.getTalkerUserName(), j);
          }
        }
        if (this.vpg == null) {
          this.vpg = ((ImageView)this.byx.findViewById(R.h.chatting_bg_iv));
        }
        if (this.vpg == null) {
          continue;
        }
        this.vpg.setImageBitmap(this.vpf);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label165;
      }
    }
  }
  
  public final void cyM() {}
  
  public final void cyN()
  {
    y.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    cdH();
  }
  
  public final void cyO()
  {
    r.PL().c(this.vph);
    r.PK().c(this.vph);
  }
  
  public final void cyP() {}
  
  public final void cyQ() {}
  
  public final void cyS()
  {
    y.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (au.DK())
    {
      r.PL().d(this.vph);
      r.PK().d(this.vph);
    }
    cEa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.f
 * JD-Core Version:    0.7.0.1
 */