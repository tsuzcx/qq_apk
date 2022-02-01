package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinderIconViewTipPreference
  extends NormalIconNewTipPreference
{
  ViewGroup IWK;
  View IWL;
  View IWM;
  View IWN;
  View IWO;
  ImageView IWP;
  ImageView IWQ;
  ImageView IWR;
  ImageView IWS;
  ImageView IWT;
  ImageView IWU;
  ArrayList<View> IWV;
  ArrayList<ImageView> IWW;
  Context mContext;
  TextView pqG;
  TextView pqH;
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.Jsy = true;
  }
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.Jsy = true;
  }
  
  private void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193645);
    paramViewGroup = View.inflate(this.mContext, 2131496412, paramViewGroup);
    this.IWL = paramViewGroup.findViewById(2131307454);
    this.IWM = paramViewGroup.findViewById(2131308117);
    this.IWP = ((ImageView)paramViewGroup.findViewById(2131307453));
    this.IWQ = ((ImageView)paramViewGroup.findViewById(2131308118));
    this.IWT = ((ImageView)paramViewGroup.findViewById(2131304190));
    acr(8);
    this.IWU = ((ImageView)paramViewGroup.findViewById(2131308189));
    this.pqH = ((TextView)paramViewGroup.findViewById(2131304200));
    this.pqG = ((TextView)paramViewGroup.findViewById(2131301392));
    AppMethodBeat.o(193645);
  }
  
  private void a(dnc paramdnc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193650);
    if ((this.IWQ == null) || (this.IWM == null))
    {
      AppMethodBeat.o(193650);
      return;
    }
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.IWQ.getLayoutParams();
      f = this.IWQ.getContext().getResources().getDimension(2131165294);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.IWQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (bt.isNullOrNil(paramdnc.url)) {
        break label335;
      }
      ad.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramdnc.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = i.sja;
      localObject = i.cCD();
      a locala = new a(paramdnc.url);
      ImageView localImageView = this.IWQ;
      i locali = i.sja;
      ((d)localObject).a(locala, localImageView, i.a(i.a.sje));
      label171:
      az(this.IWL, 8);
      az(this.IWM, 0);
      az(this.IWQ, 0);
      az(this.IWT, 8);
      az(this.IWK, 0);
      if (!paramBoolean2) {
        break label345;
      }
      az(this.IWU, 0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramdnc.title))
      {
        if (paramBoolean3)
        {
          az(this.pqG, 8);
          az(this.pqH, 0);
          if (this.pqH == null) {
            break label416;
          }
          this.pqH.setText(paramdnc.title);
          AppMethodBeat.o(193650);
          return;
          localObject = this.IWQ.getLayoutParams();
          f = this.IWQ.getContext().getResources().getDimension(2131165290);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.IWQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label335:
          ad.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
          break label171;
          label345:
          az(this.IWU, 8);
          continue;
        }
        az(this.pqH, 8);
        az(this.pqG, 0);
        if (this.pqG == null) {
          break label416;
        }
        this.pqG.setText(paramdnc.title);
        AppMethodBeat.o(193650);
        return;
      }
    }
    az(this.pqH, 8);
    az(this.pqG, 8);
    label416:
    AppMethodBeat.o(193650);
  }
  
  private void a(boolean paramBoolean1, dnc paramdnc, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(193653);
    acn(8);
    acm(8);
    acq(8);
    acl(8);
    xF(false);
    if (paramBoolean1) {
      b(paramdnc, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(193653);
      return;
      az(this.IWK, 8);
    }
  }
  
  private boolean aby(int paramInt)
  {
    AppMethodBeat.i(193644);
    if (this.IWK == null)
    {
      if (this.mView == null) {}
      for (Object localObject = null;; localObject = this.mView.findViewById(16908312))
      {
        localObject = (ViewGroup)localObject;
        if ((localObject != null) && (((ViewGroup)localObject).getChildCount() <= 0)) {
          break;
        }
        ad.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
        AppMethodBeat.o(193644);
        return false;
      }
      this.IWK = ((ViewGroup)localObject);
      if ((paramInt == 2) || (paramInt == 5)) {
        A(this.IWK);
      }
      for (;;)
      {
        AppMethodBeat.o(193644);
        return true;
        if (paramInt == 3)
        {
          localObject = this.IWK;
          localObject = View.inflate(this.mContext, 2131496411, (ViewGroup)localObject);
          this.IWL = ((View)localObject).findViewById(2131307454);
          this.IWN = ((View)localObject).findViewById(2131307456);
          this.IWO = ((View)localObject).findViewById(2131307458);
          this.IWV = new ArrayList(3);
          this.IWV.add(this.IWL);
          this.IWV.add(this.IWN);
          this.IWV.add(this.IWO);
          this.IWP = ((ImageView)((View)localObject).findViewById(2131307453));
          this.IWR = ((ImageView)((View)localObject).findViewById(2131307455));
          this.IWS = ((ImageView)((View)localObject).findViewById(2131307457));
          this.IWW = new ArrayList(3);
          this.IWW.add(this.IWP);
          this.IWW.add(this.IWR);
          this.IWW.add(this.IWS);
          this.IWT = ((ImageView)((View)localObject).findViewById(2131304190));
        }
        else if ((paramInt == 1) || (paramInt == 4))
        {
          A(this.IWK);
        }
      }
    }
    AppMethodBeat.o(193644);
    return true;
  }
  
  private static void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(193647);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(193647);
  }
  
  private void b(dnc paramdnc)
  {
    AppMethodBeat.i(193652);
    paramdnc = paramdnc.dcr;
    int i = paramdnc.size();
    ad.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(i)));
    int j = Math.min(i, 3);
    i = 0;
    for (;;)
    {
      int k;
      if (j > 0)
      {
        j -= 1;
        View localView = (View)this.IWV.get(j);
        ImageView localImageView = (ImageView)this.IWW.get(j);
        Object localObject = i.sja;
        localObject = i.cCC();
        k = i + 1;
        a locala = new a((String)paramdnc.get(i));
        i locali = i.sja;
        ((d)localObject).a(locala, localImageView, i.a(i.a.sjd));
        if (localView != null)
        {
          localView.setVisibility(0);
          i = k;
        }
      }
      else
      {
        AppMethodBeat.o(193652);
        return;
      }
      i = k;
    }
  }
  
  private void b(dnc paramdnc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193651);
    if ((this.IWP == null) || (this.IWL == null))
    {
      AppMethodBeat.o(193651);
      return;
    }
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.IWP.getLayoutParams();
      f = this.IWP.getContext().getResources().getDimension(2131165294);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.IWP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (bt.isNullOrNil(paramdnc.url)) {
        break label340;
      }
      ad.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramdnc.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = i.sja;
      localObject = i.cCC();
      a locala = new a(paramdnc.url);
      ImageView localImageView = this.IWP;
      i locali = i.sja;
      ((d)localObject).a(locala, localImageView, i.a(i.a.sjd));
      label174:
      az(this.IWL, 0);
      az(this.IWM, 8);
      az(this.IWQ, 8);
      az(this.IWU, 8);
      az(this.IWK, 0);
      if (!paramBoolean2) {
        break label351;
      }
      az(this.IWT, 0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramdnc.title))
      {
        if (paramBoolean3)
        {
          az(this.pqG, 8);
          az(this.pqH, 0);
          if (this.pqH == null) {
            break label423;
          }
          this.pqH.setText(paramdnc.title);
          AppMethodBeat.o(193651);
          return;
          localObject = this.IWP.getLayoutParams();
          f = this.IWP.getContext().getResources().getDimension(2131165290);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.IWP.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label340:
          ad.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
          break label174;
          label351:
          az(this.IWT, 8);
          continue;
        }
        az(this.pqH, 8);
        az(this.pqG, 0);
        if (this.pqG == null) {
          break label423;
        }
        this.pqG.setText(paramdnc.title);
        AppMethodBeat.o(193651);
        return;
      }
    }
    az(this.pqH, 8);
    az(this.pqG, 8);
    label423:
    AppMethodBeat.o(193651);
  }
  
  private void b(boolean paramBoolean1, dnc paramdnc, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(193654);
    acn(8);
    acm(8);
    acq(8);
    acl(8);
    xF(false);
    if (paramBoolean1) {
      a(paramdnc, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(193654);
      return;
      az(this.IWK, 8);
    }
  }
  
  private void e(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(193655);
    ad.d("FinderIconViewTipPreference", "bindAvatars() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if ((paramdnc != null) && (paramdnc.dcr != null) && (paramdnc.dcr.size() > 0) && (fvV()))
      {
        acn(8);
        acq(8);
        acp(8);
        acr(8);
        xF(false);
        fvU();
        b(paramdnc);
        az(this.IWT, 0);
        az(this.IWK, 0);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(193655);
      return;
      acn(8);
      acm(8);
      acq(8);
      acl(8);
      az(this.IWK, 8);
    }
  }
  
  private void fvU()
  {
    AppMethodBeat.i(193648);
    if (this.IWV == null)
    {
      AppMethodBeat.o(193648);
      return;
    }
    int j = this.IWV.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.IWV.get(i);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(193648);
  }
  
  private boolean fvV()
  {
    AppMethodBeat.i(193649);
    if ((this.IWV == null) || (this.IWW == null))
    {
      ad.i("FinderIconViewTipPreference", "friend avatar is null");
      AppMethodBeat.o(193649);
      return false;
    }
    int i = this.IWV.size();
    int j = this.IWW.size();
    if ((i != 3) || (i != j))
    {
      ad.i("FinderIconViewTipPreference", "friend avatar size illegal");
      AppMethodBeat.o(193649);
      return false;
    }
    AppMethodBeat.o(193649);
    return true;
  }
  
  public final void a(boolean paramBoolean1, dnc paramdnc, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193646);
    ad.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramdnc.title, paramdnc.url, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if (!aby(paramInt))
    {
      AppMethodBeat.o(193646);
      return;
    }
    if (paramInt == 1) {
      a(paramBoolean1, paramdnc, false, paramBoolean2, paramBoolean3);
    }
    for (;;)
    {
      if (!paramBoolean2)
      {
        az(this.IWT, 8);
        acr(8);
      }
      AppMethodBeat.o(193646);
      return;
      if (paramInt == 2) {
        b(paramBoolean1, paramdnc, false, paramBoolean2, paramBoolean3);
      } else if (paramInt == 4) {
        a(paramBoolean1, paramdnc, true, paramBoolean2, paramBoolean3);
      } else if (paramInt == 5) {
        b(paramBoolean1, paramdnc, true, paramBoolean2, paramBoolean3);
      } else if (paramInt == 3) {
        e(paramBoolean1, paramdnc);
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(193657);
    az(this.IWK, 8);
    paramBoolean = super.a(paramBoolean, paramdnc);
    AppMethodBeat.o(193657);
    return paramBoolean;
  }
  
  public final boolean a(boolean paramBoolean1, dnc paramdnc, boolean paramBoolean2)
  {
    AppMethodBeat.i(193658);
    az(this.IWK, 8);
    paramBoolean1 = super.a(paramBoolean1, paramdnc, paramBoolean2);
    AppMethodBeat.o(193658);
    return paramBoolean1;
  }
  
  public final boolean om(boolean paramBoolean)
  {
    AppMethodBeat.i(193656);
    az(this.IWK, 8);
    paramBoolean = super.om(paramBoolean);
    AppMethodBeat.o(193656);
    return paramBoolean;
  }
  
  public final boolean on(boolean paramBoolean)
  {
    AppMethodBeat.i(193659);
    az(this.IWK, 8);
    paramBoolean = super.on(paramBoolean);
    AppMethodBeat.o(193659);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FinderIconViewTipPreference
 * JD-Core Version:    0.7.0.1
 */