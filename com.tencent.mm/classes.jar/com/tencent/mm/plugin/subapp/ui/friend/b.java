package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.w;

public final class b
  extends p<av>
{
  private Context context;
  private View.OnClickListener sXL;
  private View.OnClickListener sXM;
  
  public b(Context paramContext)
  {
    super(paramContext, new av());
    AppMethodBeat.i(25351);
    this.sXL = new b.2(this);
    this.sXM = new b.3(this);
    this.context = paramContext;
    AppMethodBeat.o(25351);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(25353);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(d.ali().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(25353);
      return;
    }
    al.d(new b.1(this));
    AppMethodBeat.o(25353);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(25354);
    bKb();
    Ku();
    AppMethodBeat.o(25354);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25352);
    if (paramView == null)
    {
      paramView = w.hM(this.context).inflate(2130969610, null);
      paramViewGroup = new a();
      paramViewGroup.sXT = ((MaskLayout)paramView.findViewById(2131824206));
      paramViewGroup.pAN = ((TextView)paramView.findViewById(2131824208));
      paramViewGroup.sXZ = ((TextView)paramView.findViewById(2131824209));
      paramViewGroup.sXU = ((Button)paramView.findViewById(2131824211));
      paramViewGroup.sXU.setOnClickListener(this.sXL);
      paramViewGroup.sXV = ((Button)paramView.findViewById(2131824212));
      paramViewGroup.sXV.setOnClickListener(this.sXM);
      paramViewGroup.sXW = ((TextView)paramView.findViewById(2131824213));
      paramViewGroup.sXX = ((TextView)paramView.findViewById(2131824214));
      paramViewGroup.gpp = ((TextView)paramView.findViewById(2131824204));
      paramViewGroup.sXY = ((TextView)paramView.findViewById(2131824215));
      paramView.setTag(paramViewGroup);
    }
    av localav;
    for (;;)
    {
      localav = (av)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.sXT.getContentView(), localav.field_talker);
      paramViewGroup.pAN.setText(j.b(this.context, localav.field_displayName, paramViewGroup.pAN.getTextSize()));
      if (localav.field_fmsgSysRowId > 0L) {
        break label541;
      }
      ab.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = d.alh().asd(localav.field_talker);
      if (localObject1 != null) {
        break;
      }
      ab.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localav.field_talker);
      paramViewGroup.sXU.setVisibility(8);
      paramViewGroup.sXV.setVisibility(8);
      paramViewGroup.sXW.setVisibility(8);
      paramViewGroup.sXX.setVisibility(8);
      paramViewGroup.sXZ.setVisibility(8);
      AppMethodBeat.o(25352);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (ax)localObject1);
    ab.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localav.field_talker);
    Object localObject2;
    if (localav.field_state == 1)
    {
      com.tencent.mm.model.aw.aaz();
      localObject2 = c.YA().arw(localav.field_talker);
      if ((localObject2 != null) && ((int)((a)localObject2).euF != 0) && (!a.je(((aq)localObject2).field_type))) {
        d.ali().eD(localav.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      ab.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localav.field_talker);
      paramViewGroup.sXU.setVisibility(8);
      paramViewGroup.sXV.setVisibility(8);
      paramViewGroup.sXW.setVisibility(8);
      paramViewGroup.sXX.setVisibility(8);
      paramViewGroup.sXZ.setVisibility(8);
      AppMethodBeat.o(25352);
      return paramView;
      localObject1 = this.context;
      l = localav.field_fmsgSysRowId;
      if (localav.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localav.field_talker, localav.field_fmsgContent, localav.field_fmsgType, localav.field_contentFromUsername, localav.field_contentNickname, localav.field_contentPhoneNumMD5, localav.field_contentFullPhoneNumMD5, localav.field_contentVerifyContent, localav.field_addScene);
        ab.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localav.field_fmsgSysRowId + ", talker = " + localav.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).qQk = localav.field_addScene;
    paramViewGroup.sXZ.setText(j.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).fjL, paramViewGroup.sXZ.getTextSize()));
    int i;
    if ((localav.field_state == 0) && (cb.abq() - localav.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localav.field_state = i;
      switch (localav.field_state)
      {
      default: 
        paramViewGroup.sXY.setVisibility(8);
        paramViewGroup.sXU.setVisibility(8);
        paramViewGroup.sXV.setVisibility(8);
        paramViewGroup.sXW.setVisibility(8);
        paramViewGroup.sXX.setVisibility(8);
        label821:
        paramView.findViewById(2131824205).setBackgroundResource(2130840969);
        l = cb.abq();
        if ((paramInt == 0) && (localav.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.gpp.setVisibility(0);
          paramViewGroup.gpp.setText(this.context.getString(2131300015));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(25352);
      return paramView;
      i = localav.field_state;
      break;
      if (localav.field_fmsgSysRowId <= 0L)
      {
        ab.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = d.alh().ase(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.sXU.setVisibility(0);
          paramViewGroup.sXU.setTag(localObject1);
          paramViewGroup.sXV.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.sXW.setVisibility(8);
        paramViewGroup.sXX.setVisibility(8);
        paramViewGroup.sXY.setVisibility(8);
        break;
        i = ((ax)localObject2).field_type;
        break label940;
        i = localav.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.sXV.setVisibility(0);
        paramViewGroup.sXV.setTag(localObject1);
        paramViewGroup.sXU.setVisibility(8);
      }
      paramViewGroup.sXW.setVisibility(0);
      paramViewGroup.sXU.setVisibility(8);
      paramViewGroup.sXV.setVisibility(8);
      paramViewGroup.sXX.setVisibility(8);
      paramViewGroup.sXY.setVisibility(8);
      break label821;
      paramViewGroup.sXX.setVisibility(0);
      paramViewGroup.sXU.setVisibility(8);
      paramViewGroup.sXV.setVisibility(8);
      paramViewGroup.sXW.setVisibility(8);
      paramViewGroup.sXY.setVisibility(8);
      break label821;
      paramViewGroup.sXY.setVisibility(0);
      paramViewGroup.sXU.setVisibility(8);
      paramViewGroup.sXV.setVisibility(8);
      paramViewGroup.sXW.setVisibility(8);
      paramViewGroup.sXX.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((av)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((av)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.gpp.setVisibility(0);
        paramViewGroup.gpp.setText(this.context.getString(2131300014));
      }
      else
      {
        paramViewGroup.gpp.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView gpp;
    public TextView pAN;
    public MaskLayout sXT;
    public Button sXU;
    public Button sXV;
    public TextView sXW;
    public TextView sXX;
    public TextView sXY;
    public TextView sXZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */