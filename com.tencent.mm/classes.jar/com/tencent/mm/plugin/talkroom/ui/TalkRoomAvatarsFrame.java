package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMHorList;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private final int lFO = a.fromDPToPix(null, 58);
  private String lGc;
  private ah mHandler;
  private final int pBM = 2000;
  private final int pBN = 5;
  private MMHorList pBO;
  private TalkRoomAvatarsFrame.a pBP;
  private am pBQ;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bdJ()
  {
    this.pBP.lGc = this.lGc;
    if (bk.bl(this.lGc)) {
      this.pBP.notifyDataSetChanged();
    }
    while (this.pBO.getIsTouching()) {
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.pBP;
    String str = this.lGc;
    int i = locala.pBT.indexOf(str) * this.lFO;
    int j = this.pBO.getCurrentPosition();
    if (i < j)
    {
      this.pBO.Gq(i);
      return;
    }
    if (i > j + this.lFO * 4)
    {
      this.pBO.Gq(i - this.lFO * 4);
      return;
    }
    this.pBP.notifyDataSetChanged();
  }
  
  private void initView()
  {
    inflate(getContext(), R.i.talk_room_avatar_frame, this);
    this.pBO = ((MMHorList)findViewById(R.h.hor_list));
    this.pBO.setOverScrollEnabled(true);
    this.pBO.setCenterInParent(true);
    this.pBO.setItemWidth(this.lFO);
    this.pBP = new TalkRoomAvatarsFrame.a(getContext());
    this.pBO.setAdapter(this.pBP);
    this.mHandler = new ah(Looper.getMainLooper());
    this.pBO.setHorListLitener(new TalkRoomAvatarsFrame.1(this));
    this.pBQ = new am(new TalkRoomAvatarsFrame.2(this), false);
  }
  
  public void setCurMemeber(String paramString)
  {
    if (this.pBO == null) {}
    while (((bk.bl(this.lGc)) && (bk.bl(paramString))) || ((!bk.bl(this.lGc)) && (this.lGc.equals(paramString)))) {
      return;
    }
    this.lGc = paramString;
    bdJ();
  }
  
  public void setMembersList(List<String> paramList)
  {
    if (this.pBP == null) {
      return;
    }
    TalkRoomAvatarsFrame.a locala = this.pBP;
    if (paramList == null) {
      locala.pBT.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      return;
      locala.pBT = paramList;
    }
  }
  
  final class a$a
  {
    public ImageView doU;
    public TextView doV;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */