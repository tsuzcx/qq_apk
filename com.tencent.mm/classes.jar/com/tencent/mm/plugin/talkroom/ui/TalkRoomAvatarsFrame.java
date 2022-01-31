package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private ak mHandler;
  private final int odb;
  private String odp;
  private final int tdv;
  private final int tdw;
  private MMHorList tdx;
  private TalkRoomAvatarsFrame.a tdy;
  private ap tdz;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25900);
    this.tdv = 2000;
    this.tdw = 5;
    this.odb = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(25900);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25901);
    this.tdv = 2000;
    this.tdw = 5;
    this.odb = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(25901);
  }
  
  private void bLd()
  {
    AppMethodBeat.i(25905);
    this.tdy.odp = this.odp;
    if (bo.isNullOrNil(this.odp))
    {
      this.tdy.notifyDataSetChanged();
      AppMethodBeat.o(25905);
      return;
    }
    if (this.tdx.getIsTouching())
    {
      AppMethodBeat.o(25905);
      return;
    }
    int i = this.tdy.indexOf(this.odp) * this.odb;
    int j = this.tdx.getCurrentPosition();
    if (i < j)
    {
      this.tdx.OI(i);
      AppMethodBeat.o(25905);
      return;
    }
    if (i > j + this.odb * 4)
    {
      this.tdx.OI(i - this.odb * 4);
      AppMethodBeat.o(25905);
      return;
    }
    this.tdy.notifyDataSetChanged();
    AppMethodBeat.o(25905);
  }
  
  private void initView()
  {
    AppMethodBeat.i(25902);
    inflate(getContext(), 2130970985, this);
    this.tdx = ((MMHorList)findViewById(2131828476));
    this.tdx.setOverScrollEnabled(true);
    this.tdx.setCenterInParent(true);
    this.tdx.setItemWidth(this.odb);
    this.tdy = new TalkRoomAvatarsFrame.a(getContext());
    this.tdx.setAdapter(this.tdy);
    this.mHandler = new ak(Looper.getMainLooper());
    this.tdx.setHorListLitener(new TalkRoomAvatarsFrame.1(this));
    this.tdz = new ap(new TalkRoomAvatarsFrame.2(this), false);
    AppMethodBeat.o(25902);
  }
  
  public void setCurMemeber(String paramString)
  {
    AppMethodBeat.i(25904);
    if (this.tdx == null)
    {
      AppMethodBeat.o(25904);
      return;
    }
    if ((bo.isNullOrNil(this.odp)) && (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(25904);
      return;
    }
    if ((!bo.isNullOrNil(this.odp)) && (this.odp.equals(paramString)))
    {
      AppMethodBeat.o(25904);
      return;
    }
    this.odp = paramString;
    bLd();
    AppMethodBeat.o(25904);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(25903);
    if (this.tdy == null)
    {
      AppMethodBeat.o(25903);
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.tdy;
    if (paramList == null) {
      locala.tdC.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(25903);
      return;
      locala.tdC = paramList;
    }
  }
  
  final class a$a
  {
    public ImageView egq;
    public TextView egr;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */