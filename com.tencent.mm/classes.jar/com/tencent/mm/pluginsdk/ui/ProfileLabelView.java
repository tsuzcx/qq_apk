package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cf;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView ETF;
  public TextView wRc;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean dBj()
  {
    AppMethodBeat.i(31233);
    if (this.ETF != null)
    {
      localObject = this.ETF.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cc.a.ax(getContext(), 2131165370);
      this.ETF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.o.b.lM(this.pMt.field_type))
    {
      if (u.za(this.pMt.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.pMt.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aoo((String)localObject);
      if ((!bt.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.wRc.setText(k.c(getContext(), bt.m(localArrayList, getContext().getResources().getString(2131757526))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.pMt.field_encryptUsername;
    if (!bt.isNullOrNil((String)localObject)) {
      ba.aBQ();
    }
    for (localObject = c.azq().aqz((String)localObject); localObject != null; localObject = c.azq().aqz(this.pMt.field_username))
    {
      localObject = ((cf)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aon((String)localObject);
      if ((bt.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.wRc.setText(k.c(getContext(), bt.m(localArrayList, getContext().getResources().getString(2131757526))));
      AppMethodBeat.o(31233);
      return true;
      ba.aBQ();
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
    this.wRc = ((TextView)findViewById(2131298619));
    this.ETF = ((TextView)findViewById(2131298620));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */