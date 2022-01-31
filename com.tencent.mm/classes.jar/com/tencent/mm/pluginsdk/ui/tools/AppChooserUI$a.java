package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class AppChooserUI$a
  extends BaseAdapter
{
  List<AppChooserUI.c> lee;
  AppChooserUI.f wdM;
  
  public AppChooserUI$a(AppChooserUI paramAppChooserUI)
  {
    AppMethodBeat.i(125865);
    this.lee = new ArrayList();
    this.wdM = AppChooserUI.f.wdX;
    AppChooserUI.a(paramAppChooserUI, paramAppChooserUI.getPackageManager());
    AppMethodBeat.o(125865);
  }
  
  public final AppChooserUI.c Mu(int paramInt)
  {
    AppMethodBeat.i(125867);
    if (this.lee == null)
    {
      AppMethodBeat.o(125867);
      return null;
    }
    AppChooserUI.c localc = (AppChooserUI.c)this.lee.get(paramInt);
    AppMethodBeat.o(125867);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(125869);
    if (this.lee == null)
    {
      AppMethodBeat.o(125869);
      return 0;
    }
    int i = this.lee.size();
    AppMethodBeat.o(125869);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(125868);
    if (Mu(paramInt).wdS)
    {
      AppMethodBeat.o(125868);
      return 1;
    }
    AppMethodBeat.o(125868);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    AppMethodBeat.i(125866);
    AppChooserUI.c localc = Mu(paramInt);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.wdL.getContext());
      if (localc.wdS)
      {
        paramInt = 2130968755;
        paramView = paramView.inflate(paramInt, null);
        paramViewGroup = new AppChooserUI.b(this.wdL, paramView);
        paramView.setTag(paramViewGroup);
      }
    }
    Object localObject2;
    for (;;)
    {
      if (localc.wdR == null) {
        new AppChooserUI.d(this.wdL).execute(new AppChooserUI.c[] { localc });
      }
      paramViewGroup.nCN.setImageDrawable(localc.wdR);
      localObject2 = localc.wdQ;
      if (localc.wdP != null) {
        break label163;
      }
      this.wdL.finish();
      AppMethodBeat.o(125866);
      return paramView;
      paramInt = 2130968754;
      break;
      paramViewGroup = (AppChooserUI.b)paramView.getTag();
    }
    label163:
    Object localObject1 = localObject2;
    if (AppChooserUI.k(this.wdL))
    {
      localObject1 = localObject2;
      if (localc.wdP.activityInfo.packageName.equals(AppChooserUI.l(this.wdL)))
      {
        localObject2 = TextUtils.concat(new CharSequence[] { localObject2, this.wdL.getString(2131296900) });
        localObject1 = localObject2;
        if (AppChooserUI.c(this.wdL) == null)
        {
          AppChooserUI.a(this.wdL, localc);
          localObject1 = localObject2;
        }
      }
    }
    paramViewGroup.nCO.setText((CharSequence)localObject1);
    boolean bool;
    if ((localc != null) && ((!localc.wdS) || (localc.tqS) || ((localc.wdS) && (localc.nKJ) && (AppChooserUI.d(this.wdL) >= AppChooserUI.e(this.wdL)))) && (!localc.wdT))
    {
      paramViewGroup.wdN.setVisibility(8);
      paramViewGroup.wdO.setVisibility(0);
      localObject1 = paramViewGroup.wdO;
      localObject2 = AppChooserUI.c(this.wdL);
      if ((localObject2 instanceof AppChooserUI.c))
      {
        localObject2 = (AppChooserUI.c)localObject2;
        if (((((AppChooserUI.c)localObject2).wdP != null) && (localc.wdP != null) && (((AppChooserUI.c)localObject2).wdP.activityInfo.packageName.equals(localc.wdP.activityInfo.packageName))) || ((((AppChooserUI.c)localObject2).wdS) && (localc.wdS)))
        {
          bool = true;
          ((RadioButton)localObject1).setChecked(bool);
          label447:
          if (!localc.wdS) {
            break label750;
          }
          if (AppChooserUI.f(this.wdL) != 4) {
            break label730;
          }
          paramViewGroup.nCQ.setText(2131302192);
          label475:
          localObject1 = paramViewGroup.nCQ;
          paramInt = i;
          if (bo.isNullOrNil(AppChooserUI.n(this.wdL))) {
            paramInt = 8;
          }
          ((TextView)localObject1).setVisibility(paramInt);
        }
      }
    }
    for (;;)
    {
      if ((AppChooserUI.f(this.wdL) != 6) && (AppChooserUI.c(this.wdL) != null) && (AppChooserUI.c(this.wdL).equals(localc))) {
        paramViewGroup.wdO.setChecked(true);
      }
      AppMethodBeat.o(125866);
      return paramView;
      bool = false;
      break;
      paramViewGroup.wdN.setVisibility(0);
      paramViewGroup.wdO.setVisibility(8);
      paramViewGroup.wdN.setOnClickListener(AppChooserUI.m(this.wdL));
      if (this.wdM == AppChooserUI.f.wdX)
      {
        if (localc.wdT) {
          paramViewGroup.wdN.setText(2131297010);
        }
        for (;;)
        {
          paramViewGroup.wdN.setEnabled(true);
          break;
          paramViewGroup.wdN.setText(2131296907);
        }
      }
      if (this.wdM == AppChooserUI.f.wdY)
      {
        paramViewGroup.wdN.setText(2131296913);
        paramViewGroup.wdN.setEnabled(false);
        break label447;
      }
      if (this.wdM != AppChooserUI.f.wdZ) {
        break label447;
      }
      if (localc.wdT) {
        paramViewGroup.wdN.setText(2131297089);
      }
      for (;;)
      {
        paramViewGroup.wdN.setEnabled(true);
        break;
        paramViewGroup.wdN.setText(2131297088);
      }
      label730:
      paramViewGroup.nCQ.setText(bo.nullAsNil(AppChooserUI.n(this.wdL)));
      break label475;
      label750:
      paramViewGroup.nCQ.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.a
 * JD-Core Version:    0.7.0.1
 */