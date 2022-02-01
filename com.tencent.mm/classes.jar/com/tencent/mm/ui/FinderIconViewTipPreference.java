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
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinderIconViewTipPreference
  extends NormalIconNewTipPreference
{
  ImageView JrA;
  ImageView JrB;
  ImageView JrC;
  ArrayList<View> JrD;
  ArrayList<ImageView> JrE;
  ViewGroup Jrs;
  View Jrt;
  View Jru;
  View Jrv;
  View Jrw;
  ImageView Jrx;
  ImageView Jry;
  ImageView Jrz;
  Context mContext;
  TextView pxm;
  TextView pxn;
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.JNn = true;
  }
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.JNn = true;
  }
  
  private void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(186931);
    paramViewGroup = View.inflate(this.mContext, 2131496412, paramViewGroup);
    this.Jrt = paramViewGroup.findViewById(2131307454);
    this.Jru = paramViewGroup.findViewById(2131308117);
    this.Jrx = ((ImageView)paramViewGroup.findViewById(2131307453));
    this.Jry = ((ImageView)paramViewGroup.findViewById(2131308118));
    this.JrB = ((ImageView)paramViewGroup.findViewById(2131304190));
    acY(8);
    this.JrC = ((ImageView)paramViewGroup.findViewById(2131308189));
    this.pxn = ((TextView)paramViewGroup.findViewById(2131304200));
    this.pxm = ((TextView)paramViewGroup.findViewById(2131301392));
    AppMethodBeat.o(186931);
  }
  
  private void a(dnz paramdnz, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(186936);
    if ((this.Jry == null) || (this.Jru == null))
    {
      AppMethodBeat.o(186936);
      return;
    }
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.Jry.getLayoutParams();
      f = this.Jry.getContext().getResources().getDimension(2131165294);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.Jry.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (bu.isNullOrNil(paramdnz.url)) {
        break label335;
      }
      ae.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramdnz.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = i.srW;
      localObject = i.cEp();
      a locala = new a(paramdnz.url);
      ImageView localImageView = this.Jry;
      i locali = i.srW;
      ((d)localObject).a(locala, localImageView, i.a(i.a.ssb));
      label171:
      az(this.Jrt, 8);
      az(this.Jru, 0);
      az(this.Jry, 0);
      az(this.JrB, 8);
      az(this.Jrs, 0);
      if (!paramBoolean2) {
        break label345;
      }
      az(this.JrC, 0);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramdnz.title))
      {
        if (paramBoolean3)
        {
          az(this.pxm, 8);
          az(this.pxn, 0);
          if (this.pxn == null) {
            break label416;
          }
          this.pxn.setText(paramdnz.title);
          AppMethodBeat.o(186936);
          return;
          localObject = this.Jry.getLayoutParams();
          f = this.Jry.getContext().getResources().getDimension(2131165290);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.Jry.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label335:
          ae.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
          break label171;
          label345:
          az(this.JrC, 8);
          continue;
        }
        az(this.pxn, 8);
        az(this.pxm, 0);
        if (this.pxm == null) {
          break label416;
        }
        this.pxm.setText(paramdnz.title);
        AppMethodBeat.o(186936);
        return;
      }
    }
    az(this.pxn, 8);
    az(this.pxm, 8);
    label416:
    AppMethodBeat.o(186936);
  }
  
  private void a(boolean paramBoolean1, dnz paramdnz, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(186939);
    acU(8);
    acT(8);
    acX(8);
    acS(8);
    xM(false);
    if (paramBoolean1) {
      b(paramdnz, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186939);
      return;
      az(this.Jrs, 8);
    }
  }
  
  private boolean acg(int paramInt)
  {
    AppMethodBeat.i(186930);
    if (this.Jrs == null)
    {
      if (this.mView == null) {}
      for (Object localObject = null;; localObject = this.mView.findViewById(16908312))
      {
        localObject = (ViewGroup)localObject;
        if ((localObject != null) && (((ViewGroup)localObject).getChildCount() <= 0)) {
          break;
        }
        ae.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
        AppMethodBeat.o(186930);
        return false;
      }
      this.Jrs = ((ViewGroup)localObject);
      if ((paramInt == 2) || (paramInt == 5)) {
        A(this.Jrs);
      }
      for (;;)
      {
        AppMethodBeat.o(186930);
        return true;
        if (paramInt == 3)
        {
          localObject = this.Jrs;
          localObject = View.inflate(this.mContext, 2131496411, (ViewGroup)localObject);
          this.Jrt = ((View)localObject).findViewById(2131307454);
          this.Jrv = ((View)localObject).findViewById(2131307456);
          this.Jrw = ((View)localObject).findViewById(2131307458);
          this.JrD = new ArrayList(3);
          this.JrD.add(this.Jrt);
          this.JrD.add(this.Jrv);
          this.JrD.add(this.Jrw);
          this.Jrx = ((ImageView)((View)localObject).findViewById(2131307453));
          this.Jrz = ((ImageView)((View)localObject).findViewById(2131307455));
          this.JrA = ((ImageView)((View)localObject).findViewById(2131307457));
          this.JrE = new ArrayList(3);
          this.JrE.add(this.Jrx);
          this.JrE.add(this.Jrz);
          this.JrE.add(this.JrA);
          this.JrB = ((ImageView)((View)localObject).findViewById(2131304190));
        }
        else if ((paramInt == 1) || (paramInt == 4))
        {
          A(this.Jrs);
        }
      }
    }
    AppMethodBeat.o(186930);
    return true;
  }
  
  private static void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(186933);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(186933);
  }
  
  private void b(dnz paramdnz)
  {
    AppMethodBeat.i(186938);
    paramdnz = paramdnz.ddt;
    int i = paramdnz.size();
    ae.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(i)));
    int j = Math.min(i, 3);
    i = 0;
    for (;;)
    {
      int k;
      if (j > 0)
      {
        j -= 1;
        View localView = (View)this.JrD.get(j);
        ImageView localImageView = (ImageView)this.JrE.get(j);
        Object localObject = i.srW;
        localObject = i.cEo();
        k = i + 1;
        a locala = new a((String)paramdnz.get(i));
        i locali = i.srW;
        ((d)localObject).a(locala, localImageView, i.a(i.a.srZ));
        if (localView != null)
        {
          localView.setVisibility(0);
          i = k;
        }
      }
      else
      {
        AppMethodBeat.o(186938);
        return;
      }
      i = k;
    }
  }
  
  private void b(dnz paramdnz, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(186937);
    if ((this.Jrx == null) || (this.Jrt == null))
    {
      AppMethodBeat.o(186937);
      return;
    }
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.Jrx.getLayoutParams();
      f = this.Jrx.getContext().getResources().getDimension(2131165294);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.Jrx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (bu.isNullOrNil(paramdnz.url)) {
        break label340;
      }
      ae.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramdnz.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = i.srW;
      localObject = i.cEo();
      a locala = new a(paramdnz.url);
      ImageView localImageView = this.Jrx;
      i locali = i.srW;
      ((d)localObject).a(locala, localImageView, i.a(i.a.srZ));
      label174:
      az(this.Jrt, 0);
      az(this.Jru, 8);
      az(this.Jry, 8);
      az(this.JrC, 8);
      az(this.Jrs, 0);
      if (!paramBoolean2) {
        break label351;
      }
      az(this.JrB, 0);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramdnz.title))
      {
        if (paramBoolean3)
        {
          az(this.pxm, 8);
          az(this.pxn, 0);
          if (this.pxn == null) {
            break label423;
          }
          this.pxn.setText(paramdnz.title);
          AppMethodBeat.o(186937);
          return;
          localObject = this.Jrx.getLayoutParams();
          f = this.Jrx.getContext().getResources().getDimension(2131165290);
          ((ViewGroup.LayoutParams)localObject).width = ((int)f);
          ((ViewGroup.LayoutParams)localObject).height = ((int)f);
          this.Jrx.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          label340:
          ae.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
          break label174;
          label351:
          az(this.JrB, 8);
          continue;
        }
        az(this.pxn, 8);
        az(this.pxm, 0);
        if (this.pxm == null) {
          break label423;
        }
        this.pxm.setText(paramdnz.title);
        AppMethodBeat.o(186937);
        return;
      }
    }
    az(this.pxn, 8);
    az(this.pxm, 8);
    label423:
    AppMethodBeat.o(186937);
  }
  
  private void b(boolean paramBoolean1, dnz paramdnz, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(186940);
    acU(8);
    acT(8);
    acX(8);
    acS(8);
    xM(false);
    if (paramBoolean1) {
      a(paramdnz, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186940);
      return;
      az(this.Jrs, 8);
    }
  }
  
  private void e(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(186941);
    ae.d("FinderIconViewTipPreference", "bindAvatars() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if ((paramdnz != null) && (paramdnz.ddt != null) && (paramdnz.ddt.size() > 0) && (fzV()))
      {
        acU(8);
        acX(8);
        acW(8);
        acY(8);
        xM(false);
        fzU();
        b(paramdnz);
        az(this.JrB, 0);
        az(this.Jrs, 0);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186941);
      return;
      acU(8);
      acT(8);
      acX(8);
      acS(8);
      az(this.Jrs, 8);
    }
  }
  
  private void fzU()
  {
    AppMethodBeat.i(186934);
    if (this.JrD == null)
    {
      AppMethodBeat.o(186934);
      return;
    }
    int j = this.JrD.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.JrD.get(i);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(186934);
  }
  
  private boolean fzV()
  {
    AppMethodBeat.i(186935);
    if ((this.JrD == null) || (this.JrE == null))
    {
      ae.i("FinderIconViewTipPreference", "friend avatar is null");
      AppMethodBeat.o(186935);
      return false;
    }
    int i = this.JrD.size();
    int j = this.JrE.size();
    if ((i != 3) || (i != j))
    {
      ae.i("FinderIconViewTipPreference", "friend avatar size illegal");
      AppMethodBeat.o(186935);
      return false;
    }
    AppMethodBeat.o(186935);
    return true;
  }
  
  public final void a(boolean paramBoolean1, dnz paramdnz, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(186932);
    ae.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramdnz.title, paramdnz.url, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if (!acg(paramInt))
    {
      AppMethodBeat.o(186932);
      return;
    }
    if (paramInt == 1) {
      a(paramBoolean1, paramdnz, false, paramBoolean2, paramBoolean3);
    }
    for (;;)
    {
      if (!paramBoolean2)
      {
        az(this.JrB, 8);
        acY(8);
      }
      AppMethodBeat.o(186932);
      return;
      if (paramInt == 2) {
        b(paramBoolean1, paramdnz, false, paramBoolean2, paramBoolean3);
      } else if (paramInt == 4) {
        a(paramBoolean1, paramdnz, true, paramBoolean2, paramBoolean3);
      } else if (paramInt == 5) {
        b(paramBoolean1, paramdnz, true, paramBoolean2, paramBoolean3);
      } else if (paramInt == 3) {
        e(paramBoolean1, paramdnz);
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(186943);
    az(this.Jrs, 8);
    paramBoolean = super.a(paramBoolean, paramdnz);
    AppMethodBeat.o(186943);
    return paramBoolean;
  }
  
  public final boolean a(boolean paramBoolean1, dnz paramdnz, boolean paramBoolean2)
  {
    AppMethodBeat.i(186944);
    az(this.Jrs, 8);
    paramBoolean1 = super.a(paramBoolean1, paramdnz, paramBoolean2);
    AppMethodBeat.o(186944);
    return paramBoolean1;
  }
  
  public final boolean or(boolean paramBoolean)
  {
    AppMethodBeat.i(186942);
    az(this.Jrs, 8);
    paramBoolean = super.or(paramBoolean);
    AppMethodBeat.o(186942);
    return paramBoolean;
  }
  
  public final boolean os(boolean paramBoolean)
  {
    AppMethodBeat.i(186945);
    az(this.Jrs, 8);
    paramBoolean = super.os(paramBoolean);
    AppMethodBeat.o(186945);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.FinderIconViewTipPreference
 * JD-Core Version:    0.7.0.1
 */