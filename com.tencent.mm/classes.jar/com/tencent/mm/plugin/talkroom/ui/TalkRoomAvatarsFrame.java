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
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.ui.base.MMHorList.a;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame
  extends FrameLayout
{
  private ao mHandler;
  private final int uaa;
  private String uao;
  private final int zXd;
  private final int zXe;
  private MMHorList zXf;
  private a zXg;
  private au zXh;
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29582);
    this.zXd = 2000;
    this.zXe = 5;
    this.uaa = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29582);
  }
  
  public TalkRoomAvatarsFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29583);
    this.zXd = 2000;
    this.zXe = 5;
    this.uaa = a.fromDPToPix(null, 58);
    initView();
    AppMethodBeat.o(29583);
  }
  
  private void cWl()
  {
    AppMethodBeat.i(29587);
    this.zXg.uao = this.uao;
    if (bs.isNullOrNil(this.uao))
    {
      this.zXg.notifyDataSetChanged();
      AppMethodBeat.o(29587);
      return;
    }
    if (this.zXf.getIsTouching())
    {
      AppMethodBeat.o(29587);
      return;
    }
    int i = this.zXg.indexOf(this.uao) * this.uaa;
    int j = this.zXf.getCurrentPosition();
    if (i < j)
    {
      this.zXf.ZZ(i);
      AppMethodBeat.o(29587);
      return;
    }
    if (i > j + this.uaa * 4)
    {
      this.zXf.ZZ(i - this.uaa * 4);
      AppMethodBeat.o(29587);
      return;
    }
    this.zXg.notifyDataSetChanged();
    AppMethodBeat.o(29587);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29584);
    inflate(getContext(), 2131495741, this);
    this.zXf = ((MMHorList)findViewById(2131300761));
    this.zXf.setOverScrollEnabled(true);
    this.zXf.setCenterInParent(true);
    this.zXf.setItemWidth(this.uaa);
    this.zXg = new a(getContext());
    this.zXf.setAdapter(this.zXg);
    this.mHandler = new ao(Looper.getMainLooper());
    this.zXf.setHorListLitener(new MMHorList.a()
    {
      public final void bzs()
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
      
      public final void dLc()
      {
        AppMethodBeat.i(29574);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).au(2000L, 2000L);
        AppMethodBeat.o(29574);
      }
      
      public final void ebJ()
      {
        AppMethodBeat.i(29573);
        TalkRoomAvatarsFrame.a(TalkRoomAvatarsFrame.this).stopTimer();
        AppMethodBeat.o(29573);
      }
    });
    this.zXh = new au(new au.a()
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
    if (this.zXf == null)
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((bs.isNullOrNil(this.uao)) && (bs.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    if ((!bs.isNullOrNil(this.uao)) && (this.uao.equals(paramString)))
    {
      AppMethodBeat.o(29586);
      return;
    }
    this.uao = paramString;
    cWl();
    AppMethodBeat.o(29586);
  }
  
  public void setMembersList(List<String> paramList)
  {
    AppMethodBeat.i(29585);
    if (this.zXg == null)
    {
      AppMethodBeat.o(29585);
      return;
    }
    a locala = this.zXg;
    if (paramList == null) {
      locala.zXk.clear();
    }
    for (;;)
    {
      locala.notifyDataSetChanged();
      AppMethodBeat.o(29585);
      return;
      locala.zXk = paramList;
    }
  }
  
  static final class a
    extends BaseAdapter
  {
    private Context mContext;
    String uao;
    List<String> zXk;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(29577);
      this.zXk = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(29577);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29579);
      int i = this.zXk.size();
      AppMethodBeat.o(29579);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(29580);
      Object localObject = this.zXk.get(paramInt);
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
      String str = (String)this.zXk.get(paramInt);
      ImageView localImageView;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131495742, null);
        paramViewGroup = new a();
        paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131301204));
        paramViewGroup.fuZ = ((TextView)paramView.findViewById(2131306142));
        paramView.setTag(paramViewGroup);
        localImageView = paramViewGroup.fuY;
        if (!str.equals(this.uao)) {
          break label140;
        }
      }
      label140:
      for (paramInt = 2131234301;; paramInt = 0)
      {
        localImageView.setBackgroundResource(paramInt);
        paramViewGroup.fuZ.setVisibility(8);
        a.b.w(paramViewGroup.fuY, str);
        AppMethodBeat.o(29581);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final int indexOf(String paramString)
    {
      AppMethodBeat.i(29578);
      int i = this.zXk.indexOf(paramString);
      AppMethodBeat.o(29578);
      return i;
    }
    
    final class a
    {
      public ImageView fuY;
      public TextView fuZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame
 * JD-Core Version:    0.7.0.1
 */