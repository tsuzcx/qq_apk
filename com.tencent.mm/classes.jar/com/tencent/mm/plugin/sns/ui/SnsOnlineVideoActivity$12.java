package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.b;

final class SnsOnlineVideoActivity$12
  implements View.OnClickListener
{
  SnsOnlineVideoActivity$12(SnsOnlineVideoActivity paramSnsOnlineVideoActivity, av paramav, TimeLineObject paramTimeLineObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39158);
    if (this.rOh.wmJ == null)
    {
      AppMethodBeat.o(39158);
      return;
    }
    SnsOnlineVideoActivity.n(this.rUf);
    paramView = com.tencent.mm.plugin.sns.c.a.gmP.dE(this.rOh.wmJ.fKw);
    int i = 0;
    if (this.rOi.xTS.wNZ == 1) {
      i = 2;
    }
    while (i.a(this.rOi, this.rUf))
    {
      com.tencent.mm.plugin.sns.c.a.gmP.a(this.rUf, this.rOh.wmJ.fKw, paramView, this.rOi.jJA, i, 19, 9, this.rOh.wmJ.wmD, this.rOi.Id);
      AppMethodBeat.o(39158);
      return;
      if (this.rOi.xTS.wNZ == 3) {
        i = 5;
      } else if (this.rOi.xTS.wNZ == 15) {
        i = 38;
      }
    }
    switch (this.rOh.jKs)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39158);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", this.rOh.Url);
      com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject, this.rUf);
      com.tencent.mm.plugin.sns.c.a.gmP.a(this.rUf, this.rOh.wmJ.fKw, paramView, this.rOi.jJA, i, 19, 1, this.rOh.wmJ.wmD, this.rOi.Id);
      AppMethodBeat.o(39158);
      return;
      if (this.rOh.Scene == 1)
      {
        localObject = new gu();
        ((gu)localObject).cvL.actionCode = 2;
        ((gu)localObject).cvL.scene = 3;
        ((gu)localObject).cvL.appId = this.rOh.wmJ.fKw;
        ((gu)localObject).cvL.context = this.rUf;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        com.tencent.mm.plugin.sns.c.a.gmP.a(this.rUf, this.rOh.wmJ.fKw, paramView, this.rOi.jJA, i, 19, 6, this.rOh.wmJ.wmD, this.rOi.Id);
        AppMethodBeat.o(39158);
        return;
        int j = af.a(this.rUf, this.rOh);
        if (j == 1)
        {
          localObject = new gu();
          ((gu)localObject).cvL.context = this.rUf;
          ((gu)localObject).cvL.actionCode = 2;
          ((gu)localObject).cvL.appId = this.rOh.wmJ.fKw;
          ((gu)localObject).cvL.messageAction = this.rOh.wmJ.wmF;
          ((gu)localObject).cvL.messageExt = this.rOh.wmJ.wmE;
          ((gu)localObject).cvL.scene = 3;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
          com.tencent.mm.plugin.sns.c.a.gmP.a(this.rUf, this.rOh.wmJ.fKw, paramView, this.rOi.jJA, i, 19, 6, this.rOh.wmJ.wmD, this.rOi.Id);
          AppMethodBeat.o(39158);
          return;
        }
        if (j == 2)
        {
          localObject = new gu();
          ((gu)localObject).cvL.context = this.rUf;
          ((gu)localObject).cvL.actionCode = 1;
          ((gu)localObject).cvL.appId = this.rOh.wmJ.fKw;
          ((gu)localObject).cvL.messageAction = this.rOh.wmJ.wmF;
          ((gu)localObject).cvL.messageExt = this.rOh.wmJ.wmE;
          ((gu)localObject).cvL.scene = 3;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
          com.tencent.mm.plugin.sns.c.a.gmP.a(this.rUf, this.rOh.wmJ.fKw, paramView, this.rOi.jJA, i, 19, 3, this.rOh.wmJ.wmD, this.rOi.Id);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.12
 * JD-Core Version:    0.7.0.1
 */