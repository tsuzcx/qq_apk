package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
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
  private ap mHandler;
  private final int sRN;
  private String sSb;
  private final int yJQ;
  private final int yJR;
  private MMHorList yJS;
  private TalkRoomAvatarsFrame.a yJT;
  private av yJU;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.yJQ = 2000;
    this.yJR = 5;
    this.sRN = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.yJQ = 2000;
    this.yJR = 5;
    this.sRN = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void cJa()
  {
    AppMethodBeat.i(29587);
    this.yJT.sSb = this.sSb;
    if (bt.isNullOrNil(this.sSb))
    {
      this.yJT.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.yJS.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.yJT.indexOf(this.sSb) * this.sRN;
    int j = this.yJS.getCurrentPosition();
    if (i < j)
    {
      this.yJS.XO(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.sRN * 4)
    {
      this.yJS.XO(i - this.sRN * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.yJT.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), 2131495741, this);
    this.yJS = ((MMHorList)findViewById(2131300761));
    this.yJS.setOverScrollEnabled(true);
    this.yJS.setCenterInParent(true);
    this.yJS.setItemWidth(this.sRN);
    this.yJT = new TalkRoomAvatarsFrame.a(getContext());
    this.yJS.setAdapter(this.yJT);
    this.mHandler = new ap(Looper.getMainLooper());
    this.yJS.setHorListLitener(new MMHorList.a()
    {
      public final void bss()
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
      
      public final void dNj()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
      
      public final void dwD()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).av(2000L, 2000L);
        AppMethodBeat.o(29574);
      }
    });
    this.yJU = new av(new av.a()
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
    if (this.yJS == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((bt.isNullOrNil(this.sSb)) && (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!bt.isNullOrNil(this.sSb)) && (this.sSb.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.sSb = paramString;
    cJa();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.yJT == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.yJT;
    if (paramList == null) {
      locala.yJX.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.yJX = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */