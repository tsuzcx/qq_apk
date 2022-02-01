package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.f;
import com.tencent.mm.bj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private LinearLayout FQJ;
  private View FQK;
  private TextView FQL;
  private TextView FQM;
  private TextView FQN;
  private String FQO;
  private String FQP;
  private boolean FQQ;
  private b FQR;
  private a FQS;
  private final int FQT;
  private LinearLayout FQU;
  public boolean FQV;
  private f FQW;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.FQR = b.FRb;
    this.FQT = 6;
    this.FQV = false;
    this.FQW = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.FQR = b.FRb;
    this.FQT = 6;
    this.FQV = false;
    this.FQW = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void e(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.FQK.setVisibility(8);
    this.FQJ.setVisibility(8);
    if (this.FQR == b.FQZ) {}
    a locala;
    View.OnClickListener local2;
    for (boolean bool = true;; bool = false)
    {
      this.FQS = new a(bool, (byte)0);
      locala = this.FQS;
      local2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33612);
          ad.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
          if (paramString2 != null)
          {
            if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRC())
            {
              ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
              com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761418), null, true);
              AppMethodBeat.o(33612);
              return;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahs(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
            if (paramAnonymousView.size() != 1) {
              break label242;
            }
            MultiTalkRoomPopupNav.aKc(paramString2);
            com.tencent.mm.plugin.report.service.h.vKh.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
          for (;;)
          {
            MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
            MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
            AppMethodBeat.o(33612);
            return;
            label242:
            int i;
            if (paramAnonymousView.size() >= c.cTy())
            {
              ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
              com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761424, new Object[] { Integer.valueOf(c.cTy()) }), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.FQZ) {}
              for (i = 1;; i = 0)
              {
                paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
                AppMethodBeat.o(33612);
                return;
              }
            }
            if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRB())
            {
              ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
              com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761416), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.FQZ) {}
              for (i = 1;; i = 0)
              {
                paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
                AppMethodBeat.o(33612);
                return;
              }
            }
            MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, paramString2);
          }
        }
      };
      paramString2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33613);
          ad.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
          int i;
          if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.FQZ)
          {
            ad.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
            boolean bool = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahx(paramString2);
            ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahy(paramString2);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
            if (bool)
            {
              i = 0;
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
            }
          }
          for (;;)
          {
            MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
            MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
            AppMethodBeat.o(33613);
            return;
            i = 1;
            break;
            com.tencent.mm.plugin.report.service.h.vKh.f(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
        }
      };
      locala.titleView.setText(paramString1);
      locala.FQY.setVisibility(0);
      locala.FQX.FQU.setVisibility(0);
      locala.FQX.FQU.removeAllViews();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        ImageView localImageView = new ImageView(locala.FQX.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 26), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        locala.FQX.FQU.addView(localImageView);
        a.b.c(localImageView, paramList);
      }
    }
    ((Button)locala.FQX.findViewById(2131302574)).setOnClickListener(local2);
    ((Button)locala.FQX.findViewById(2131302573)).setOnClickListener(paramString2);
    AppMethodBeat.o(33627);
  }
  
  private void hp(List<String> paramList)
  {
    AppMethodBeat.i(33628);
    if ((this.FQU != null) && (this.FQU.getVisibility() == 0))
    {
      this.FQU.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 26), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        this.FQU.addView(localImageView);
        a.b.c(localImageView, str);
      }
    }
    AppMethodBeat.o(33628);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33621);
    inflate(getContext(), 2131494977, this);
    this.FQJ = ((LinearLayout)findViewById(2131302587));
    this.FQK = findViewById(2131302586);
    this.FQL = ((TextView)findViewById(2131302591));
    this.FQM = ((TextView)findViewById(2131302592));
    this.FQN = ((TextView)findViewById(2131302593));
    this.FQU = ((LinearLayout)findViewById(2131302580));
    this.FQJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        if ((d.hxx != null) && (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ce(MultiTalkRoomPopupNav.this.getContext())))
        {
          ad.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          AppMethodBeat.o(33611);
          return;
        }
        if ((d.hxx != null) && (d.hxx.aCk()))
        {
          Toast.makeText(aj.getContext(), aj.getContext().getString(2131760332), 0).show();
          ad.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
          AppMethodBeat.o(33611);
          return;
        }
        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
        AppMethodBeat.o(33611);
      }
    });
    AppMethodBeat.o(33621);
  }
  
  private static List<String> s(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(33629);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramList;
    if (paramString != null)
    {
      localObject = paramList;
      if (paramString != "")
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if ((localObject != null) && (!((String)localObject).equals(paramString))) {
            localArrayList1.add(localObject);
          }
        }
        localObject = localArrayList1;
      }
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext()) {
      localArrayList2.add((String)paramList.next());
    }
    AppMethodBeat.o(33629);
    return localArrayList2;
  }
  
  private void setDefaultBannerStyle(String paramString)
  {
    AppMethodBeat.i(33625);
    this.FQK.setBackgroundResource(2131234389);
    this.FQL.setTextColor(getResources().getColor(2131100685));
    this.FQL.setText(paramString);
    if ((this.FQU == null) || (this.FQU.getVisibility() != 0))
    {
      this.FQL.setVisibility(0);
      this.FQN.setVisibility(8);
      this.FQM.setVisibility(8);
      this.FQU.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.FQK.setBackgroundResource(2131234378);
    this.FQM.setTextColor(getResources().getColor(2131100685));
    this.FQM.setText(paramString);
    this.FQL.setVisibility(8);
    this.FQN.setVisibility(0);
    this.FQM.setVisibility(0);
    this.FQU.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.FQK.setBackgroundResource(2131234378);
    this.FQL.setTextColor(getResources().getColor(2131100687));
    this.FQL.setText(paramString);
    this.FQL.setVisibility(0);
    this.FQN.setVisibility(8);
    this.FQM.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  public final void eRC()
  {
    AppMethodBeat.i(33626);
    this.FQV = false;
    setVisibility(8);
    if (this.FQS != null) {
      this.FQS.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.FQP = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.FQO = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.FQQ = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.FQW = paramf;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.FQR = paramb;
  }
  
  public final void vD(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.FQV = false;
    if ((this.FQO == null) || (this.FQP == null))
    {
      ad.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.FQO + ",currentSenderUserName:" + this.FQP);
      AppMethodBeat.o(33622);
      return;
    }
    String str = this.FQO;
    if (!((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahp(str))
    {
      eRC();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahs(str);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).vv(str);
      eRC();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ht(str, this.FQP);
    if (i == 1)
    {
      setUserTalkingStatus(b.FQZ);
      if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aht(str))
      {
        eRC();
        AppMethodBeat.o(33622);
        return;
      }
      setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).sh(((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).hu(str, this.FQP)));
    }
    for (;;)
    {
      setVisibility(0);
      this.FQJ.setVisibility(0);
      this.FQK.setVisibility(0);
      if ((this.FQS != null) && ((paramBoolean) || (this.FQU == null) || (this.FQU.getVisibility() != 0))) {
        this.FQS.close();
      }
      hp(s(localList, ""));
      AppMethodBeat.o(33622);
      return;
      if (i == 10)
      {
        setUserTalkingStatus(b.FRa);
        if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aht(str))
        {
          eRC();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRE())
        {
          eRC();
          AppMethodBeat.o(33622);
          return;
        }
        setUserTalkingStatus(b.FRb);
        setDefaultBannerStyle(aj.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) }));
      }
      else
      {
        setUserTalkingStatus(b.FRb);
        setDefaultBannerStyle(aj.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) }));
      }
    }
  }
  
  final class a
  {
    LinearLayout FQY;
    private Button pSG;
    TextView titleView;
    
    private a(boolean paramBoolean)
    {
      AppMethodBeat.i(33614);
      this.pSG = ((Button)MultiTalkRoomPopupNav.this.findViewById(2131302573));
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(2131302590));
      this.FQY = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(2131302578));
      if (paramBoolean)
      {
        this.FQY.setBackgroundResource(2131234378);
        this.pSG.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(2131100685));
        AppMethodBeat.o(33614);
        return;
      }
      this.FQY.setBackgroundResource(2131234389);
      this.pSG.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(2131100079));
      AppMethodBeat.o(33614);
    }
    
    final void close()
    {
      AppMethodBeat.i(33615);
      this.FQY.setVisibility(8);
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      FQZ = new b("Inviting", 0);
      FRa = new b("Talking", 1);
      FRb = new b("NotInTalking", 2);
      FRc = new b[] { FQZ, FRa, FRb };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */