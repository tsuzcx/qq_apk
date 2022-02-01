package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.ui.base.MMHorList.a;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private final int BoH;
  private final int BoI;
  private MMHorList BoJ;
  private TalkRoomAvatarsFrame.a BoK;
  private av BoL;
  private ap mHandler;
  private final int vcJ;
  private String vcX;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.BoH = 2000;
    this.BoI = 5;
    this.vcJ = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.BoH = 2000;
    this.BoI = 5;
    this.vcJ = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void dfw()
  {
    AppMethodBeat.i(29587);
    this.BoK.vcX = this.vcX;
    if (bt.isNullOrNil(this.vcX))
    {
      this.BoK.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.BoJ.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.BoK.indexOf(this.vcX) * this.vcJ;
    int j = this.BoJ.getCurrentPosition();
    if (i < j)
    {
      this.BoJ.acj(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.vcJ * 4)
    {
      this.BoJ.acj(i - this.vcJ * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.BoK.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), 2131495741, this);
    this.BoJ = ((MMHorList)findViewById(2131300761));
    this.BoJ.setOverScrollEnabled(true);
    this.BoJ.setCenterInParent(true);
    this.BoJ.setItemWidth(this.vcJ);
    this.BoK = new TalkRoomAvatarsFrame.a(getContext());
    this.BoJ.setAdapter(this.BoK);
    this.mHandler = new ap(Looper.getMainLooper());
    this.BoJ.setHorListLitener(new MMHorList.a()
    {
      public final void bDw()
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
      
      public final void dXt()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).az(2000L, 2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void eoa()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.BoL = new av(new av.a()
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
    if (this.BoJ == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((bt.isNullOrNil(this.vcX)) && (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!bt.isNullOrNil(this.vcX)) && (this.vcX.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.vcX = paramString;
    dfw();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.BoK == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.BoK;
    if (paramList == null) {
      locala.BoO.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.BoO = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */