package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bz;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView Doz;
  public TextView vJT;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean dqG()
  {
    AppMethodBeat.i(31233);
    if (this.Doz != null)
    {
      localObject = this.Doz.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cc.a.au(getContext(), 2131165370);
      this.Doz.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.n.b.ln(this.piT.field_type))
    {
      if (u.wh(this.piT.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.piT.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().ajC((String)localObject);
      if ((!bs.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.vJT.setText(k.c(getContext(), bs.n(localArrayList, getContext().getResources().getString(2131757526))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.piT.field_encryptUsername;
    if (!bs.isNullOrNil((String)localObject)) {
      az.ayM();
    }
    for (localObject = c.awC().alK((String)localObject); localObject != null; localObject = c.awC().alK(this.piT.field_username))
    {
      localObject = ((bz)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().ajB((String)localObject);
      if ((bs.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.vJT.setText(k.c(getContext(), bs.n(localArrayList, getContext().getResources().getString(2131757526))));
      AppMethodBeat.o(31233);
      return true;
      az.ayM();
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
    this.vJT = ((TextView)findViewById(2131298619));
    this.Doz = ((TextView)findViewById(2131298620));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */