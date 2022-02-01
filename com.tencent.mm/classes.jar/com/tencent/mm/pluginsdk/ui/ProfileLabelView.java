package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cn;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView BeG;
  public TextView KcS;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean eEV()
  {
    AppMethodBeat.i(31233);
    if (this.KcS != null)
    {
      localObject = this.KcS.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.aG(getContext(), 2131165381);
      this.KcS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.contact.c.oR(this.rjX.field_type))
    {
      if (z.Im(this.rjX.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.rjX.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCJ((String)localObject);
      if ((!Util.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.BeG.setText(l.c(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(2131757746))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.rjX.field_encryptUsername;
    if (!Util.isNullOrNil((String)localObject)) {
      bg.aVF();
    }
    for (localObject = com.tencent.mm.model.c.aSO().aEZ((String)localObject); localObject != null; localObject = com.tencent.mm.model.c.aSO().aEZ(this.rjX.field_username))
    {
      localObject = ((cn)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCI((String)localObject);
      if ((Util.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.BeG.setText(l.c(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(2131757746))));
      AppMethodBeat.o(31233);
      return true;
      bg.aVF();
    }
    setVisibility(8);
    AppMethodBeat.o(31233);
    return false;
  }
  
  public int getLayout()
  {
    return 2131495981;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31232);
    this.BeG = ((TextView)findViewById(2131299056));
    this.KcS = ((TextView)findViewById(2131299057));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */