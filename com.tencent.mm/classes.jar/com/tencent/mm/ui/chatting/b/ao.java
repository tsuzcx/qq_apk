package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import java.util.List;

public class ao
  extends a
  implements f, j.a, m.b, v
{
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
    }
    do
    {
      return;
      y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange " + paramInt);
      au.Hx();
      paramm = c.Fw().abl(this.byx.getTalkerUserName());
    } while ((paramm == null) || ((int)paramm.dBe == 0));
    if (bk.bl(paramm.field_nickname)) {
      paramm.dk(this.byx.pSb.field_nickname);
    }
    this.byx.ab(paramm);
    ((q)this.byx.ac(q.class)).cEE();
    ((q)this.byx.ac(q.class)).cEH();
    this.byx.axW();
  }
  
  public final void a(String paramString, l paraml)
  {
    label0:
    break label0;
  }
  
  public final void cyO()
  {
    au.Dk().a(137, this);
    au.Hx();
    c.Fw().a(this);
  }
  
  public final void cyR()
  {
    au.Dk().b(137, this);
    if (au.DK())
    {
      au.Hx();
      c.Fw().b(this);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int i = 1;
    y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.byx.dismissDialog();
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
    }
    label333:
    label335:
    label354:
    for (;;)
    {
      return;
      if (bk.bU(this.byx.vtz.getContext()))
      {
        Object localObject = this.byx.vtz.getContext();
        if (w.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7))
        {
          label121:
          if ((i != 0) || (paramInt1 != 0) || (paramInt2 != 0)) {
            break label333;
          }
          switch (paramm.getType())
          {
          default: 
            return;
          }
          paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).rTv;
          if ((paramString != null) && (!paramString.contains(this.byx.pSb.field_username))) {
            break;
          }
          localObject = this.byx.pSb;
          au.Hx();
          paramm = c.Fw().abl(((com.tencent.mm.h.c.ao)localObject).field_username);
          if (paramm != null)
          {
            paramString = paramm;
            if ((int)paramm.dBe != 0) {}
          }
          else
          {
            au.Hx();
            if (c.Fw().U((ad)localObject)) {
              break label335;
            }
            y.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((com.tencent.mm.h.c.ao)localObject).field_username);
          }
        }
        for (paramString = null;; paramString = c.Fw().abl(((com.tencent.mm.h.c.ao)localObject).field_username))
        {
          if (paramString == null) {
            break label354;
          }
          s.q(paramString);
          return;
          if (w.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
            break label121;
          }
          i = 0;
          break label121;
          break;
          au.Hx();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ao
 * JD-Core Version:    0.7.0.1
 */