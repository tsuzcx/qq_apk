package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.widget.c.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> eka;
  private RecyclerView adt;
  private ProgressBar gJE;
  private LinkedList<AllRemindMsgUI.d> ksE;
  private View yTA;
  private AllRemindMsgUI.b yTB;
  private AllRemindMsgUI.a yTC;
  
  static
  {
    AppMethodBeat.i(29136);
    eka = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(29136);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(29129);
    this.yTC = new AllRemindMsgUI.a(this);
    AppMethodBeat.o(29129);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29135);
    String str = "";
    Object localObject = j.b.mY(paramString);
    switch (paramInt1)
    {
    default: 
      localObject = paramContext.getString(2131301870);
    }
    for (;;)
    {
      AppMethodBeat.o(29135);
      return localObject;
      localObject = paramContext.getString(2131296607);
      continue;
      localObject = paramContext.getString(2131302366, new Object[] { Integer.valueOf((int)s.hi(new com.tencent.mm.modelvoice.p(paramString).time)) });
      continue;
      localObject = paramContext.getString(2131297036);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = 2131297077;; paramInt1 = 2131297102)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      aw.aaz();
      com.tencent.mm.model.c.YC().Tz(paramString);
      localObject = paramContext.getString(2131302357, new Object[] { "" });
      continue;
      localObject = paramContext.getString(2131296967);
      continue;
      if (localObject == null)
      {
        ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
        AppMethodBeat.o(29135);
        return "";
      }
      switch (((j.b)localObject).type)
      {
      default: 
        ab.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((j.b)localObject).type) });
        break;
      case 33: 
        localObject = paramContext.getString(2131296607);
        break;
      case 6: 
        localObject = paramContext.getString(2131302354, new Object[] { ((j.b)localObject).title });
        break;
      case 5: 
      case 7: 
        localObject = paramContext.getString(2131302364, new Object[] { "" });
        break;
      case 8: 
        localObject = paramContext.getString(2131296916);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131296915);
        break;
      case 25: 
        localObject = paramContext.getString(2131296903);
        break;
      case 17: 
        localObject = paramContext.getString(2131302357, new Object[] { "" });
        break;
      case 19: 
        localObject = paramContext.getString(2131302360, new Object[] { "" });
        break;
      case 24: 
        localObject = paramContext.getString(2131302359, new Object[] { "" });
        break;
      case 3: 
        localObject = paramContext.getString(2131302358, new Object[] { "" });
        break;
      case 4: 
        localObject = paramContext.getString(2131302365, new Object[] { "" });
        break;
      case 2: 
        localObject = paramContext.getString(2131297036);
        break;
      case 44: 
        if (bo.isNullOrNil(((j.b)localObject).q(paramContext, true))) {
          break;
        }
        localObject = ((j.b)localObject).q(paramContext, true) + " " + ((j.b)localObject).title;
        continue;
        localObject = paramContext.getString(2131296915);
        continue;
        localObject = paramContext.getString(2131302361);
        continue;
        if (localObject == null)
        {
          ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(29135);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131302351, new Object[] { ((j.b)localObject).fie, "" });
        }
        else
        {
          localObject = paramContext.getString(2131302351, new Object[] { ((j.b)localObject).fie, "" });
          continue;
          if (localObject == null)
          {
            ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(29135);
            return "";
          }
          localObject = paramContext.getString(2131302351, new Object[] { ((j.b)localObject).fie, "" });
          continue;
          localObject = paramContext.getString(2131302352, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131302352, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131302350, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131302363, new Object[] { "" });
          continue;
          localObject = str;
          if (paramString != null)
          {
            localObject = str;
            if (paramString.length() > 0)
            {
              paramString = bi.d.asm(paramString);
              localObject = str;
              if (paramString.tac != null)
              {
                localObject = str;
                if (paramString.tac.length() > 0) {
                  switch (paramString.scene)
                  {
                  case 19: 
                  case 20: 
                  case 21: 
                  default: 
                    localObject = paramContext.getString(2131300111, new Object[] { paramString.getDisplayName() });
                    break;
                  case 18: 
                    localObject = paramContext.getString(2131300092, new Object[] { paramString.getDisplayName() });
                    break;
                  case 22: 
                  case 23: 
                  case 24: 
                  case 26: 
                  case 27: 
                  case 28: 
                  case 29: 
                    localObject = paramContext.getString(2131300102, new Object[] { paramString.getDisplayName() });
                    break;
                  case 25: 
                    localObject = paramContext.getString(2131300024, new Object[] { paramString.getDisplayName() });
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
  }
  
  protected int getLayoutId()
  {
    return 2130968648;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(29132);
    setMMTitle(2131302512);
    this.adt = ((RecyclerView)findViewById(2131821118));
    this.gJE = ((ProgressBar)findViewById(2131821119));
    this.yTA = findViewById(2131821120);
    this.adt.setVisibility(8);
    RecyclerView localRecyclerView = this.adt;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.yTB = new AllRemindMsgUI.b(this);
    this.adt.setAdapter(this.yTB);
    this.yTB.a(new AllRemindMsgUI.1(this));
    setBackBtn(new AllRemindMsgUI.2(this));
    AppMethodBeat.o(29132);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29133);
    finish();
    AppMethodBeat.o(29133);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29130);
    super.onCreate(paramBundle);
    aw.Rc().a(866, this.yTC);
    aw.Rc().a(525, this);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 3L, 1L, false);
    initView();
    d.post(new AllRemindMsgUI.a(this), "load remind data!");
    AppMethodBeat.o(29130);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29131);
    super.onDestroy();
    aw.Rc().b(866, this.yTC);
    aw.Rc().b(525, this);
    AppMethodBeat.o(29131);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29134);
    ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 525)
      {
        AppMethodBeat.o(29134);
        return;
      }
      paramString = (caw)((y)paramm).fBd.fsV.fta;
      paramm = this.ksE.listIterator();
      while (paramm.hasNext()) {
        if (((AllRemindMsgUI.d)paramm.next()).yTL == paramString.xLU.xGT) {
          paramm.remove();
        }
      }
      this.yTB.ajb.notifyChanged();
      AppMethodBeat.o(29134);
      return;
    }
    Toast.makeText(getContext(), bo.bf(paramString, getString(2131301979)), 0).show();
    AppMethodBeat.o(29134);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */