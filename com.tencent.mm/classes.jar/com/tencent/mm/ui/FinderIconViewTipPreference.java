package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinderIconViewTipPreference
  extends NormalIconNewTipPreference
{
  ViewGroup OBA;
  View OBB;
  View OBC;
  View OBD;
  View OBE;
  ImageView OBF;
  ImageView OBG;
  ImageView OBH;
  ImageView OBI;
  ImageView OBJ;
  ImageView OBK;
  ImageView OBL;
  ArrayList<View> OBM;
  ArrayList<ImageView> OBN;
  private RelativeLayout OBO;
  private WeImageView OBP;
  private LinearLayout OBQ;
  private RelativeLayout OBR;
  private LinearLayout.LayoutParams OBS;
  private LinearLayout.LayoutParams OBT;
  private LinearLayout.LayoutParams OBU;
  private LinearLayout.LayoutParams OBV;
  Context mContext;
  TextView qMD;
  TextView qME;
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232525);
    this.mContext = paramContext;
    this.OYo = true;
    setLayoutResource(2131494517);
    AppMethodBeat.o(232525);
  }
  
  private void AY(boolean paramBoolean)
  {
    AppMethodBeat.i(232530);
    Log.i("FinderIconViewTipPreference", "changeContentLayoutParam :".concat(String.valueOf(paramBoolean)));
    ViewGroup localViewGroup;
    if (this.gvQ != null)
    {
      localViewGroup = (ViewGroup)this.gvQ.findViewById(2131299180);
      if (!paramBoolean) {
        break label94;
      }
      localViewGroup.setLayoutParams(this.OBU);
      this.OBQ.setLayoutParams(this.OBS);
      aE(this.OBR, 8);
      aE(this.OBP, 0);
    }
    for (;;)
    {
      this.OBR.requestLayout();
      AppMethodBeat.o(232530);
      return;
      label94:
      localViewGroup.setLayoutParams(this.OBV);
      this.OBQ.setLayoutParams(this.OBT);
      aE(this.OBR, 0);
      aE(this.OBA, 0);
      aE(this.OBP, 8);
    }
  }
  
  private void a(ehv paramehv, boolean paramBoolean)
  {
    AppMethodBeat.i(232536);
    if (paramBoolean)
    {
      this.qMD.setMaxLines(2);
      int i = (int)(av.az(this.qMD.getContext()).x * 0.4D);
      this.qMD.setMaxWidth(i);
    }
    for (;;)
    {
      aE(this.qMD, 0);
      aE(this.OBK, 0);
      aE(this.qME, 8);
      aE(this.OBO, 8);
      if (this.qMD != null) {
        this.qMD.setText(paramehv.title);
      }
      AppMethodBeat.o(232536);
      return;
      gHL();
    }
  }
  
  private void a(ehv paramehv, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(232535);
    if ((this.OBG == null) || (this.OBC == null))
    {
      AppMethodBeat.o(232535);
      return;
    }
    aE(this.OBO, 0);
    aE(this.OBK, 8);
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.OBG.getLayoutParams();
      f = this.OBG.getContext().getResources().getDimension(2131165303);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.OBG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Util.isNullOrNil(paramehv.url)) {
        break label410;
      }
      Log.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramehv.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = m.uJa;
      localObject = m.dkb();
      a locala = new a(paramehv.url);
      ImageView localImageView = this.OBG;
      m localm = m.uJa;
      ((com.tencent.mm.loader.d)localObject).a(locala, localImageView, m.a(m.a.uJg));
      label190:
      aE(this.OBB, 8);
      aE(this.OBC, 0);
      aE(this.OBG, 0);
      aE(this.OBJ, 8);
      aE(this.OBA, 0);
      if (!paramBoolean2) {
        break label481;
      }
      aE(this.OBL, 0);
      if (paramBoolean4) {
        break label421;
      }
      localObject = this.OBL.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -2;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.OBL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.OBL.setImageResource(2131235385);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramehv.title))
      {
        if (paramBoolean3)
        {
          aE(this.qMD, 8);
          aE(this.qME, 0);
          if (this.qME == null) {
            break label561;
          }
          this.qME.setText(paramehv.title);
          AppMethodBeat.o(232535);
          return;
          localObject = this.OBG.getLayoutParams();
          f = this.OBG.getContext().getResources().getDimension(2131165297);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.OBG.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label410:
          Log.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
          break label190;
          label421:
          localObject = this.OBJ.getLayoutParams();
          int i = com.tencent.mm.view.d.e(this.OBJ.getContext(), 11.1F);
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.OBL.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.OBL.setImageResource(2131690266);
          continue;
          label481:
          aE(this.OBL, 8);
          continue;
        }
        aE(this.qME, 8);
        gHL();
        aE(this.qMD, 0);
        if (this.qMD == null) {
          break label561;
        }
        this.qMD.setText(paramehv.title);
        AppMethodBeat.o(232535);
        return;
      }
    }
    aE(this.qME, 8);
    aE(this.qMD, 8);
    label561:
    AppMethodBeat.o(232535);
  }
  
  private void a(boolean paramBoolean1, ehv paramehv, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Boolean paramBoolean)
  {
    AppMethodBeat.i(232539);
    alF(8);
    alE(8);
    alI(8);
    alD(8);
    BB(false);
    if (paramBoolean1) {
      b(paramehv, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean.booleanValue());
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(232539);
      return;
      aE(this.OBA, 8);
    }
  }
  
  private void a(boolean paramBoolean1, ehv paramehv, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(232540);
    alF(8);
    alE(8);
    alI(8);
    alD(8);
    BB(false);
    if (paramBoolean1) {
      a(paramehv, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(232540);
      return;
      aE(this.OBA, 8);
    }
  }
  
  private void aE(View paramView, int paramInt)
  {
    AppMethodBeat.i(232532);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    if ((paramView != null) && (paramView == this.OBA) && (paramInt == 8)) {
      AY(true);
    }
    AppMethodBeat.o(232532);
  }
  
  private boolean akN(int paramInt)
  {
    AppMethodBeat.i(232528);
    if (this.OBA == null)
    {
      if (this.mView == null) {}
      for (Object localObject = null;; localObject = this.mView.findViewById(16908312))
      {
        localObject = (ViewGroup)localObject;
        gHI();
        if ((localObject != null) && (((ViewGroup)localObject).getChildCount() <= 0)) {
          break;
        }
        Log.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
        AppMethodBeat.o(232528);
        return false;
      }
      this.OBA = ((ViewGroup)localObject);
      if ((paramInt == 2) || (paramInt == 5) || (paramInt == 1) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7))
      {
        localObject = this.OBA;
        localObject = View.inflate(this.mContext, 2131495621, (ViewGroup)localObject);
        this.OBB = ((View)localObject).findViewById(2131301771);
        this.OBC = ((View)localObject).findViewById(2131301781);
        this.OBF = ((ImageView)((View)localObject).findViewById(2131301770));
        this.OBG = ((ImageView)((View)localObject).findViewById(2131301793));
        this.OBJ = ((ImageView)((View)localObject).findViewById(2131307102));
        alJ(8);
        this.OBL = ((ImageView)((View)localObject).findViewById(2131307108));
        this.qME = ((TextView)((View)localObject).findViewById(2131307114));
        this.qMD = ((TextView)((View)localObject).findViewById(2131303147));
        this.OBK = ((ImageView)((View)localObject).findViewById(2131305482));
        this.OBO = ((RelativeLayout)((View)localObject).findViewById(2131297128));
      }
      for (;;)
      {
        AppMethodBeat.o(232528);
        return true;
        if (paramInt == 3)
        {
          localObject = this.OBA;
          localObject = View.inflate(this.mContext, 2131495611, (ViewGroup)localObject);
          this.OBB = ((View)localObject).findViewById(2131301771);
          this.OBD = ((View)localObject).findViewById(2131301773);
          this.OBE = ((View)localObject).findViewById(2131301775);
          this.OBM = new ArrayList(3);
          this.OBM.add(this.OBB);
          this.OBM.add(this.OBD);
          this.OBM.add(this.OBE);
          this.OBF = ((ImageView)((View)localObject).findViewById(2131301770));
          this.OBH = ((ImageView)((View)localObject).findViewById(2131301772));
          this.OBI = ((ImageView)((View)localObject).findViewById(2131301774));
          this.OBN = new ArrayList(3);
          this.OBN.add(this.OBF);
          this.OBN.add(this.OBH);
          this.OBN.add(this.OBI);
          this.OBJ = ((ImageView)((View)localObject).findViewById(2131307102));
        }
      }
    }
    AppMethodBeat.o(232528);
    return true;
  }
  
  private void b(ehv paramehv)
  {
    AppMethodBeat.i(232538);
    paramehv = paramehv.duo;
    int i = paramehv.size();
    Log.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(i)));
    int j = Math.min(i, 3);
    i = 0;
    for (;;)
    {
      int k;
      if (j > 0)
      {
        j -= 1;
        View localView = (View)this.OBM.get(j);
        ImageView localImageView = (ImageView)this.OBN.get(j);
        Object localObject = m.uJa;
        localObject = m.dka();
        k = i + 1;
        a locala = new a((String)paramehv.get(i));
        m localm = m.uJa;
        ((com.tencent.mm.loader.d)localObject).a(locala, localImageView, m.a(m.a.uJe));
        if (localView != null)
        {
          localView.setVisibility(0);
          i = k;
        }
      }
      else
      {
        AppMethodBeat.o(232538);
        return;
      }
      i = k;
    }
  }
  
  private void b(ehv paramehv, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(232537);
    if ((this.OBF == null) || (this.OBB == null))
    {
      AppMethodBeat.o(232537);
      return;
    }
    aE(this.OBO, 0);
    aE(this.OBK, 8);
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.OBF.getLayoutParams();
      f = this.OBF.getContext().getResources().getDimension(2131165303);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.OBF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Util.isNullOrNil(paramehv.url)) {
        break label415;
      }
      Log.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramehv.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = m.uJa;
      localObject = m.dka();
      a locala = new a(paramehv.url);
      ImageView localImageView = this.OBF;
      m localm = m.uJa;
      ((com.tencent.mm.loader.d)localObject).a(locala, localImageView, m.a(m.a.uJe));
      label193:
      aE(this.OBB, 0);
      aE(this.OBC, 8);
      aE(this.OBG, 8);
      aE(this.OBL, 8);
      aE(this.OBA, 0);
      if (!paramBoolean2) {
        break label486;
      }
      aE(this.OBJ, 0);
      if (paramBoolean4) {
        break label426;
      }
      localObject = this.OBJ.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -2;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.OBJ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.OBJ.setImageResource(2131235385);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramehv.title))
      {
        if (paramBoolean3)
        {
          aE(this.qMD, 8);
          aE(this.qME, 0);
          if (this.qME == null) {
            break label567;
          }
          this.qME.setText(paramehv.title);
          AppMethodBeat.o(232537);
          return;
          localObject = this.OBF.getLayoutParams();
          f = this.OBF.getContext().getResources().getDimension(2131165297);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.OBF.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label415:
          Log.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
          break label193;
          label426:
          localObject = this.OBJ.getLayoutParams();
          int i = com.tencent.mm.view.d.e(this.OBJ.getContext(), 11.1F);
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.OBJ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.OBJ.setImageResource(2131690266);
          continue;
          label486:
          aE(this.OBJ, 8);
          continue;
        }
        aE(this.qME, 8);
        gHL();
        aE(this.qMD, 0);
        if (this.qMD == null) {
          break label567;
        }
        this.qMD.setText(paramehv.title);
        AppMethodBeat.o(232537);
        return;
      }
    }
    aE(this.qME, 8);
    aE(this.qMD, 8);
    label567:
    AppMethodBeat.o(232537);
  }
  
  private void e(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(232541);
    alF(8);
    alE(8);
    alI(8);
    alD(8);
    BB(false);
    if (paramBoolean) {
      a(paramehv, false);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(232541);
      return;
      aE(this.OBA, 8);
    }
  }
  
  private void f(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(232542);
    alF(8);
    alE(8);
    alI(8);
    alD(8);
    BB(false);
    if (paramBoolean) {
      a(paramehv, true);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(232542);
      return;
      aE(this.OBA, 8);
    }
  }
  
  private void g(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(232544);
    Log.d("FinderIconViewTipPreference", "bindAvatars() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if ((paramehv != null) && (paramehv.duo != null) && (paramehv.duo.size() > 0) && (gHK()))
      {
        alF(8);
        alI(8);
        alH(8);
        alJ(8);
        BB(false);
        gHJ();
        b(paramehv);
        aE(this.OBJ, 0);
        aE(this.OBA, 0);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(232544);
      return;
      alF(8);
      alE(8);
      alI(8);
      alD(8);
      aE(this.OBA, 8);
    }
  }
  
  private void gHI()
  {
    AppMethodBeat.i(232529);
    Log.i("FinderIconViewTipPreference", "changeContent");
    if (this.gvQ != null)
    {
      if (this.OBU == null) {
        this.OBU = ((LinearLayout.LayoutParams)((ViewGroup)this.gvQ.findViewById(2131299180)).getLayoutParams());
      }
      if (this.OBV == null) {
        this.OBV = new LinearLayout.LayoutParams(-2, this.OBU.height, 0.0F);
      }
      if (this.OBS == null) {
        this.OBS = ((LinearLayout.LayoutParams)this.OBQ.getLayoutParams());
      }
      if (this.OBT == null) {
        this.OBT = new LinearLayout.LayoutParams(-1, -1, 0.0F);
      }
    }
    AppMethodBeat.o(232529);
  }
  
  private void gHJ()
  {
    AppMethodBeat.i(232533);
    if (this.OBM == null)
    {
      AppMethodBeat.o(232533);
      return;
    }
    int j = this.OBM.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.OBM.get(i);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(232533);
  }
  
  private boolean gHK()
  {
    AppMethodBeat.i(232534);
    if ((this.OBM == null) || (this.OBN == null))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar is null");
      AppMethodBeat.o(232534);
      return false;
    }
    int i = this.OBM.size();
    int j = this.OBN.size();
    if ((i != 3) || (i != j))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar size illegal");
      AppMethodBeat.o(232534);
      return false;
    }
    AppMethodBeat.o(232534);
    return true;
  }
  
  private void gHL()
  {
    AppMethodBeat.i(232543);
    this.qMD.setMaxLines(1);
    AppMethodBeat.o(232543);
  }
  
  private void gHM()
  {
    AppMethodBeat.i(232548);
    aE(this.OBA, 8);
    AppMethodBeat.o(232548);
  }
  
  public final void a(boolean paramBoolean1, ehv paramehv, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(232531);
    Log.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s isLiveRedDot=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramehv.title, paramehv.url, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) });
    if (!akN(paramInt))
    {
      AppMethodBeat.o(232531);
      return;
    }
    if (paramInt == 1)
    {
      AY(false);
      a(paramBoolean1, paramehv, false, paramBoolean2, paramBoolean3, Boolean.valueOf(paramBoolean4));
    }
    for (;;)
    {
      if (!paramBoolean2)
      {
        aE(this.OBJ, 8);
        alJ(8);
      }
      AppMethodBeat.o(232531);
      return;
      if (paramInt == 2)
      {
        AY(false);
        a(paramBoolean1, paramehv, false, paramBoolean2, paramBoolean3, paramBoolean4);
      }
      else if (paramInt == 4)
      {
        AY(false);
        a(paramBoolean1, paramehv, true, paramBoolean2, paramBoolean3, Boolean.valueOf(paramBoolean4));
      }
      else if (paramInt == 5)
      {
        AY(false);
        a(paramBoolean1, paramehv, true, paramBoolean2, paramBoolean3, paramBoolean4);
      }
      else if (paramInt == 3)
      {
        AY(false);
        g(paramBoolean1, paramehv);
      }
      else if (paramInt == 6)
      {
        AY(false);
        e(paramBoolean1, paramehv);
      }
      else if (paramInt == 7)
      {
        AY(false);
        f(paramBoolean1, paramehv);
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(232546);
    gHM();
    paramBoolean = super.a(paramBoolean, paramehv);
    AppMethodBeat.o(232546);
    return paramBoolean;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(232527);
    super.onBindView(paramView);
    Log.i("FinderIconViewTipPreference", "onBindView view:" + paramView + " root:" + this.gvQ);
    c localc = c.vVc;
    if (this.gvQ != null) {}
    for (boolean bool = true;; bool = false)
    {
      localc.a("FinderIconViewTipPreference", bool, true, false, new FinderIconViewTipPreference.1(this));
      if ((this.gvQ == null) && (paramView != null))
      {
        this.gvQ = paramView;
        Log.i("FinderIconViewTipPreference", "has exception");
      }
      this.OBP = ((WeImageView)this.gvQ.findViewById(2131307082));
      this.OBQ = ((LinearLayout)this.gvQ.findViewById(2131307437));
      this.OBR = ((RelativeLayout)this.gvQ.findViewById(2131309045));
      gHI();
      AppMethodBeat.o(232527);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(232526);
    paramViewGroup = super.onCreateView(paramViewGroup);
    Log.i("FinderIconViewTipPreference", "onCreateView hashCode:" + hashCode() + " view:" + paramViewGroup);
    AppMethodBeat.o(232526);
    return paramViewGroup;
  }
  
  public final boolean qW(boolean paramBoolean)
  {
    AppMethodBeat.i(232545);
    if (paramBoolean) {
      gHM();
    }
    for (;;)
    {
      paramBoolean = super.qW(paramBoolean);
      AppMethodBeat.o(232545);
      return paramBoolean;
      AY(true);
    }
  }
  
  public final boolean qX(boolean paramBoolean)
  {
    AppMethodBeat.i(232547);
    gHM();
    paramBoolean = super.qX(paramBoolean);
    AppMethodBeat.o(232547);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FinderIconViewTipPreference
 * JD-Core Version:    0.7.0.1
 */