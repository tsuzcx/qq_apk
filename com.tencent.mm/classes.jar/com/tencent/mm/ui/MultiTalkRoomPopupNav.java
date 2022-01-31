package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private LinearLayout zdB;
  private View zdC;
  private TextView zdD;
  private TextView zdE;
  private TextView zdF;
  private String zdG;
  private String zdH;
  private boolean zdI;
  private MultiTalkRoomPopupNav.b zdJ;
  private MultiTalkRoomPopupNav.a zdK;
  private final int zdL;
  private LinearLayout zdM;
  public boolean zdN;
  private f zdO;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29778);
    this.zdJ = MultiTalkRoomPopupNav.b.zdT;
    this.zdL = 6;
    this.zdN = false;
    this.zdO = new f();
    initView();
    AppMethodBeat.o(29778);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29777);
    this.zdJ = MultiTalkRoomPopupNav.b.zdT;
    this.zdL = 6;
    this.zdN = false;
    this.zdO = new f();
    initView();
    AppMethodBeat.o(29777);
  }
  
  private void d(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(29785);
    this.zdC.setVisibility(8);
    this.zdB.setVisibility(8);
    if (this.zdJ == MultiTalkRoomPopupNav.b.zdR) {}
    MultiTalkRoomPopupNav.a locala;
    MultiTalkRoomPopupNav.2 local2;
    for (boolean bool = true;; bool = false)
    {
      this.zdK = new MultiTalkRoomPopupNav.a(this, bool, (byte)0);
      locala = this.zdK;
      local2 = new MultiTalkRoomPopupNav.2(this, paramString2);
      paramString2 = new MultiTalkRoomPopupNav.3(this, paramString2);
      locala.titleView.setText(paramString1);
      locala.zdQ.setVisibility(0);
      locala.zdP.zdM.setVisibility(0);
      locala.zdP.zdM.removeAllViews();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        ImageView localImageView = new ImageView(locala.zdP.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 26), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        locala.zdP.zdM.addView(localImageView);
        a.b.c(localImageView, paramList);
      }
    }
    ((Button)locala.zdP.findViewById(2131826439)).setOnClickListener(local2);
    ((Button)locala.zdP.findViewById(2131826438)).setOnClickListener(paramString2);
    AppMethodBeat.o(29785);
  }
  
  private void eU(List<String> paramList)
  {
    AppMethodBeat.i(29786);
    if ((this.zdM != null) && (this.zdM.getVisibility() == 0))
    {
      this.zdM.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 26), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        this.zdM.addView(localImageView);
        a.b.c(localImageView, str);
      }
    }
    AppMethodBeat.o(29786);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29779);
    inflate(getContext(), 2130970322, this);
    this.zdB = ((LinearLayout)findViewById(2131826428));
    this.zdC = findViewById(2131826427);
    this.zdD = ((TextView)findViewById(2131826430));
    this.zdE = ((TextView)findViewById(2131826431));
    this.zdF = ((TextView)findViewById(2131826432));
    this.zdM = ((LinearLayout)findViewById(2131826435));
    this.zdB.setOnClickListener(new MultiTalkRoomPopupNav.1(this));
    AppMethodBeat.o(29779);
  }
  
  private static List<String> l(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(29787);
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
    AppMethodBeat.o(29787);
    return localArrayList2;
  }
  
  private void setDefaultBannerStyle(String paramString)
  {
    AppMethodBeat.i(29783);
    this.zdC.setBackgroundResource(2130839739);
    this.zdD.setTextColor(getResources().getColor(2131690300));
    this.zdD.setText(paramString);
    if ((this.zdM == null) || (this.zdM.getVisibility() != 0))
    {
      this.zdD.setVisibility(0);
      this.zdF.setVisibility(8);
      this.zdE.setVisibility(8);
      this.zdM.setVisibility(8);
    }
    AppMethodBeat.o(29783);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(29782);
    this.zdC.setBackgroundResource(2130839747);
    this.zdE.setTextColor(getResources().getColor(2131690300));
    this.zdE.setText(paramString);
    this.zdD.setVisibility(8);
    this.zdF.setVisibility(0);
    this.zdE.setVisibility(0);
    this.zdM.setVisibility(8);
    AppMethodBeat.o(29782);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(29781);
    this.zdC.setBackgroundResource(2130839747);
    this.zdD.setTextColor(getResources().getColor(2131690302));
    this.zdD.setText(paramString);
    this.zdD.setVisibility(0);
    this.zdF.setVisibility(8);
    this.zdE.setVisibility(8);
    AppMethodBeat.o(29781);
  }
  
  public final void dCZ()
  {
    AppMethodBeat.i(29784);
    this.zdN = false;
    setVisibility(8);
    if (this.zdK != null) {
      this.zdK.close();
    }
    AppMethodBeat.o(29784);
  }
  
  public final void qw(boolean paramBoolean)
  {
    AppMethodBeat.i(29780);
    this.zdN = false;
    if ((this.zdG == null) || (this.zdH == null))
    {
      ab.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.zdG + ",currentSenderUserName:" + this.zdH);
      AppMethodBeat.o(29780);
      return;
    }
    String str = this.zdG;
    if (!((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ui(str))
    {
      dCZ();
      AppMethodBeat.o(29780);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ul(str);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).qD(str);
      dCZ();
      AppMethodBeat.o(29780);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).fo(str, this.zdH);
    if (i == 1)
    {
      setUserTalkingStatus(MultiTalkRoomPopupNav.b.zdR);
      if (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Um(str))
      {
        dCZ();
        AppMethodBeat.o(29780);
        return;
      }
      setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).nE(((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).fp(str, this.zdH)));
    }
    for (;;)
    {
      setVisibility(0);
      this.zdB.setVisibility(0);
      this.zdC.setVisibility(0);
      if ((this.zdK != null) && ((paramBoolean) || (this.zdM == null) || (this.zdM.getVisibility() != 0))) {
        this.zdK.close();
      }
      eU(l(localList, ""));
      AppMethodBeat.o(29780);
      return;
      if (i == 10)
      {
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.zdS);
        if (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Um(str))
        {
          dCZ();
          AppMethodBeat.o(29780);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).bSD())
        {
          dCZ();
          AppMethodBeat.o(29780);
          return;
        }
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.zdT);
        setDefaultBannerStyle(ah.getContext().getString(2131301699, new Object[] { Integer.valueOf(localList.size()) }));
      }
      else
      {
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.zdT);
        setDefaultBannerStyle(ah.getContext().getString(2131301699, new Object[] { Integer.valueOf(localList.size()) }));
      }
    }
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.zdH = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.zdG = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.zdI = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.zdO = paramf;
  }
  
  public void setUserTalkingStatus(MultiTalkRoomPopupNav.b paramb)
  {
    this.zdJ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */