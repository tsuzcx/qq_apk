package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.a;
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
  private final int Kfm;
  private String Kfz;
  private final int SOs;
  private final int SOt;
  private MMHorList SOu;
  private TalkRoomAvatarsFrame.a SOv;
  private MTimerHandler SOw;
  private MMHandler mHandler;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.SOs = 2000;
    this.SOt = 5;
    this.Kfm = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.SOs = 2000;
    this.SOt = 5;
    this.Kfm = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void fTt()
  {
    AppMethodBeat.i(29587);
    this.SOv.Kfz = this.Kfz;
    if (Util.isNullOrNil(this.Kfz))
    {
      this.SOv.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.SOu.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.SOv.cs(this.Kfz) * this.Kfm;
    int j = this.SOu.getCurrentPosition();
    if (i < j)
    {
      this.SOu.Wa(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.Kfm * 4)
    {
      this.SOu.Wa(i - this.Kfm * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.SOv.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), R.i.goz, this);
    this.SOu = ((MMHorList)findViewById(R.h.fJO));
    this.SOu.setOverScrollEnabled(true);
    this.SOu.setCenterInParent(true);
    this.SOu.setItemWidth(this.Kfm);
    this.SOv = new TalkRoomAvatarsFrame.a(getContext());
    this.SOu.setAdapter(this.SOv);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.SOu.setHorListLitener(new MMHorList.a()
    {
      public final void fYb()
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
      
      public final void hjF()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).startTimer(2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void hpY()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.SOw = new MTimerHandler(new MTimerHandler.CallBack()
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
    if (this.SOu == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((Util.isNullOrNil(this.Kfz)) && (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!Util.isNullOrNil(this.Kfz)) && (this.Kfz.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.Kfz = paramString;
    fTt();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.SOv == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.SOv;
    if (paramList == null) {
      locala.SOz.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.SOz = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */