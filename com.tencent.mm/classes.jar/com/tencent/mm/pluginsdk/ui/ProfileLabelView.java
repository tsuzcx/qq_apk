package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cg;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView Fma;
  public TextView xgT;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean dEA()
  {
    AppMethodBeat.i(31233);
    if (this.Fma != null)
    {
      localObject = this.Fma.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.ax(getContext(), 2131165370);
      this.Fma.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.contact.c.lO(this.pSY.field_type))
    {
      if (v.zK(this.pSY.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.pSY.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().apq((String)localObject);
      if ((!bu.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.xgT.setText(k.c(getContext(), bu.m(localArrayList, getContext().getResources().getString(2131757526))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.pSY.field_encryptUsername;
    if (!bu.isNullOrNil((String)localObject)) {
      bc.aCg();
    }
    for (localObject = com.tencent.mm.model.c.azG().arE((String)localObject); localObject != null; localObject = com.tencent.mm.model.c.azG().arE(this.pSY.field_username))
    {
      localObject = ((cg)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().app((String)localObject);
      if ((bu.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.xgT.setText(k.c(getContext(), bu.m(localArrayList, getContext().getResources().getString(2131757526))));
      AppMethodBeat.o(31233);
      return true;
      bc.aCg();
    }
    setVisibility(8);
    AppMethodBeat.o(31233);
    return false;
  }
  
  public int getLayout()
  {
    return 2131495138;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31232);
    this.xgT = ((TextView)findViewById(2131298619));
    this.Fma = ((TextView)findViewById(2131298620));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */