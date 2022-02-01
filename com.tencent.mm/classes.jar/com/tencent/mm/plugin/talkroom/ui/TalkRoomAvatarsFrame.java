package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.ui.base.MMHorList.a;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private final int BGg;
  private final int BGh;
  private MMHorList BGi;
  private TalkRoomAvatarsFrame.a BGj;
  private aw BGk;
  private aq mHandler;
  private final int voU;
  private String vpi;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.BGg = 2000;
    this.BGh = 5;
    this.voU = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.BGg = 2000;
    this.BGh = 5;
    this.voU = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void dio()
  {
    AppMethodBeat.i(29587);
    this.BGj.vpi = this.vpi;
    if (bu.isNullOrNil(this.vpi))
    {
      this.BGj.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.BGi.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.BGj.indexOf(this.vpi) * this.voU;
    int j = this.BGi.getCurrentPosition();
    if (i < j)
    {
      this.BGi.acQ(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.voU * 4)
    {
      this.BGi.acQ(i - this.voU * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.BGj.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), 2131495741, this);
    this.BGi = ((MMHorList)findViewById(2131300761));
    this.BGi.setOverScrollEnabled(true);
    this.BGi.setCenterInParent(true);
    this.BGi.setItemWidth(this.voU);
    this.BGj = new TalkRoomAvatarsFrame.a(getContext());
    this.BGi.setAdapter(this.BGj);
    this.mHandler = new aq(Looper.getMainLooper());
    this.BGi.setHorListLitener(new MMHorList.a()
    {
      public final void bEo()
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
      
      public final void eaW()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).ay(2000L, 2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void erH()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.BGk = new aw(new aw.a()
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
    if (this.BGi == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((bu.isNullOrNil(this.vpi)) && (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!bu.isNullOrNil(this.vpi)) && (this.vpi.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.vpi = paramString;
    dio();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.BGj == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.BGj;
    if (paramList == null) {
      locala.BGn.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.BGn = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */