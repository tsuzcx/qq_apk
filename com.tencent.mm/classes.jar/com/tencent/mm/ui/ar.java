package com.tencent.mm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.c.a;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public final class ar
  extends BaseAdapter
{
  private LiveTalkRoomTipsBar LCE;
  LinkedList<a> LCF;
  String qsP;
  
  public ar(LiveTalkRoomTipsBar paramLiveTalkRoomTipsBar, String paramString, LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(204915);
    this.LCF = new LinkedList();
    this.LCE = paramLiveTalkRoomTipsBar;
    this.qsP = paramString;
    this.LCF = paramLinkedList;
    paramLiveTalkRoomTipsBar.setLiveTalkRoomTipsBarAdapter(this);
    AppMethodBeat.o(204915);
  }
  
  public final a ain(int paramInt)
  {
    AppMethodBeat.i(204917);
    if (this.LCF == null)
    {
      AppMethodBeat.o(204917);
      return null;
    }
    a locala = (a)this.LCF.get(paramInt);
    AppMethodBeat.o(204917);
    return locala;
  }
  
  public final void gaf()
  {
    AppMethodBeat.i(204919);
    this.LCF = as.aWi(this.qsP).gag();
    if (this.LCE != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204914);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).gad();
          }
          AppMethodBeat.o(204914);
        }
      });
    }
    AppMethodBeat.o(204919);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(204916);
    if (this.LCF != null)
    {
      int i = this.LCF.size();
      AppMethodBeat.o(204916);
      return i;
    }
    AppMethodBeat.o(204916);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204918);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.LCE.context).inflate(2131496334, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.GHC = ((LinearLayout)paramView.findViewById(2131307709));
      paramViewGroup.LCI = ((WeImageView)paramView.findViewById(2131307708));
      paramViewGroup.LCw = ((RelativeLayout)paramView.findViewById(2131307710));
      paramViewGroup.LCJ = ((TextView)paramView.findViewById(2131307716));
      paramViewGroup.LCK = ((TextView)paramView.findViewById(2131307707));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final a locala = ain(paramInt);
      if (locala != null)
      {
        a.b.c(paramViewGroup.LCI, locala.field_anchorUsername);
        paramViewGroup.LCJ.setText(k.c(this.LCE.context, locala.field_liveName));
        paramViewGroup.LCK.setText("主播：" + k.b(this.LCE.context, v.sh(locala.field_anchorUsername), paramViewGroup.LCK.getTextSize()));
      }
      paramViewGroup.GHC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204912);
          if (locala != null) {
            ar.a(ar.this).b(locala);
          }
          AppMethodBeat.o(204912);
        }
      });
      paramViewGroup.LCw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204913);
          as.Ci(((a)ar.this.LCF.get(paramInt)).field_liveId);
          ar.this.gaf();
          AppMethodBeat.o(204913);
        }
      });
      AppMethodBeat.o(204918);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  final class a
  {
    LinearLayout GHC;
    WeImageView LCI;
    TextView LCJ;
    TextView LCK;
    RelativeLayout LCw;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ar
 * JD-Core Version:    0.7.0.1
 */