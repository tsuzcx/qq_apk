package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.co;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView GYE;
  public TextView Rdy;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean fqK()
  {
    AppMethodBeat.i(31233);
    if (this.Rdy != null)
    {
      localObject = this.Rdy.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.ci.a.aY(getContext(), R.f.FixedTitleWidth);
      this.Rdy.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (d.rk(this.uNk.field_type))
    {
      if (z.PD(this.uNk.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.uNk.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().aMQ((String)localObject);
      if ((!Util.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.GYE.setText(l.c(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(R.l.exJ))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.uNk.field_encryptUsername;
    if (!Util.isNullOrNil((String)localObject)) {
      bh.beI();
    }
    for (localObject = c.bbM().aPj((String)localObject); localObject != null; localObject = c.bbM().aPj(this.uNk.field_username))
    {
      localObject = ((co)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().aMP((String)localObject);
      if ((Util.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.GYE.setText(l.c(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(R.l.exJ))));
      AppMethodBeat.o(31233);
      return true;
      bh.beI();
    }
    setVisibility(8);
    AppMethodBeat.o(31233);
    return false;
  }
  
  public int getLayout()
  {
    return R.i.ekc;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31232);
    this.GYE = ((TextView)findViewById(R.h.dBc));
    this.Rdy = ((TextView)findViewById(R.h.dBd));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */