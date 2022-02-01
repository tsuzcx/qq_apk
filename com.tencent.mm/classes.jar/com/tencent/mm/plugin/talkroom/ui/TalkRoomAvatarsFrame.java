package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.ui.base.MMHorList.a;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private final int EmD;
  private String EmR;
  private final int MkY;
  private final int MkZ;
  private MMHorList Mla;
  private TalkRoomAvatarsFrame.a Mlb;
  private MTimerHandler Mlc;
  private MMHandler mHandler;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.MkY = 2000;
    this.MkZ = 5;
    this.EmD = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.MkY = 2000;
    this.MkZ = 5;
    this.EmD = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void eLm()
  {
    AppMethodBeat.i(29587);
    this.Mlb.EmR = this.EmR;
    if (Util.isNullOrNil(this.EmR))
    {
      this.Mlb.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.Mla.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.Mlb.bf(this.EmR) * this.EmD;
    int j = this.Mla.getCurrentPosition();
    if (i < j)
    {
      this.Mla.auy(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.EmD * 4)
    {
      this.Mla.auy(i - this.EmD * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.Mlb.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), R.i.elv, this);
    this.Mla = ((MMHorList)findViewById(R.h.dIw));
    this.Mla.setOverScrollEnabled(true);
    this.Mla.setCenterInParent(true);
    this.Mla.setItemWidth(this.EmD);
    this.Mlb = new TalkRoomAvatarsFrame.a(getContext());
    this.Mla.setAdapter(this.Mlb);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Mla.setHorListLitener(new MMHorList.a()
    {
      public final void ePx()
      {
        AppMethodBeat.i(29575);
        TalkRoomAvatarsFrame.c(TalkRoomAvatarsFrame.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29572);
            TalkRoomAvatarsFrame.b(TalkRoomAvatarsFrame.this).notifyDataSetChanged();
            AppMethodBeat.o(29572);
          }
        });
        AppMethodBeat.o(29575);
      }
      
      public final void fRF()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).startTimer(2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void giM()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.Mlc = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29576);
        TalkRoomAvatarsFrame.d(TalkRoomAvatarsFrame.this);
        AppMethodBeat.o(29576);
        return false;
      }
    }, false);
    AppMethodBeat.o(29584);
  }
  
  public void setCurMemeber(String paramString)
  {
    AppMethodBeat.i(29586);
    if (this.Mla == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((Util.isNullOrNil(this.EmR)) && (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!Util.isNullOrNil(this.EmR)) && (this.EmR.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.EmR = paramString;
    eLm();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.Mlb == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.Mlb;
    if (paramList == null) {
      locala.Mlf.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.Mlf = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */