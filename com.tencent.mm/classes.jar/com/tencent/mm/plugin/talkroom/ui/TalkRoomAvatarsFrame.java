package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.ui.base.MMHorList.a;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private final int FQX;
  private final int FQY;
  private MMHorList FQZ;
  private a FRa;
  private MTimerHandler FRb;
  private MMHandler mHandler;
  private final int yIK;
  private String yIY;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.FQX = 2000;
    this.FQY = 5;
    this.yIK = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.FQX = 2000;
    this.FQY = 5;
    this.yIK = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void eco()
  {
    AppMethodBeat.i(29587);
    this.FRa.yIY = this.yIY;
    if (Util.isNullOrNil(this.yIY))
    {
      this.FRa.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.FQZ.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.FRa.indexOf(this.yIY) * this.yIK;
    int j = this.FQZ.getCurrentPosition();
    if (i < j)
    {
      this.FQZ.alA(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.yIK * 4)
    {
      this.FQZ.alA(i - this.yIK * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.FRa.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), 2131496647, this);
    this.FQZ = ((MMHorList)findViewById(2131302350));
    this.FQZ.setOverScrollEnabled(true);
    this.FQZ.setCenterInParent(true);
    this.FQZ.setItemWidth(this.yIK);
    this.FRa = new a(getContext());
    this.FQZ.setAdapter(this.FRa);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.FQZ.setHorListLitener(new MMHorList.a()
    {
      public final void efW()
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
      
      public final void fdM()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).startTimer(2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void fuk()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.FRb = new MTimerHandler(new MTimerHandler.CallBack()
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
    if (this.FQZ == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((Util.isNullOrNil(this.yIY)) && (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!Util.isNullOrNil(this.yIY)) && (this.yIY.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.yIY = paramString;
    eco();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.FRa == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    a locala = this.FRa;
    if (paramList == null) {
      locala.FRe.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.FRe = paramList;
    }
  }
  
  static final class a
    extends BaseAdapter
  {
    List<String> FRe;
    private Context mContext;
    String yIY;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(29577);
      this.FRe = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(29577);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29579);
      int i = this.FRe.size();
      AppMethodBeat.o(29579);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(29580);
      Object localObject = this.FRe.get(paramInt);
      AppMethodBeat.o(29580);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(29581);
      String str = (String)this.FRe.get(paramInt);
      ImageView localImageView;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131496648, null);
        paramViewGroup = new a();
        paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131302877));
        paramViewGroup.gvw = ((TextView)paramView.findViewById(2131309511));
        paramView.setTag(paramViewGroup);
        localImageView = paramViewGroup.gvv;
        if (!str.equals(this.yIY)) {
          break label140;
        }
      }
      label140:
      for (paramInt = 2131235184;; paramInt = 0)
      {
        localImageView.setBackgroundResource(paramInt);
        paramViewGroup.gvw.setVisibility(8);
        a.b.A(paramViewGroup.gvv, str);
        AppMethodBeat.o(29581);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final int indexOf(String paramString)
    {
      AppMethodBeat.i(29578);
      int i = this.FRe.indexOf(paramString);
      AppMethodBeat.o(29578);
      return i;
    }
    
    final class a
    {
      public ImageView gvv;
      public TextView gvw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */