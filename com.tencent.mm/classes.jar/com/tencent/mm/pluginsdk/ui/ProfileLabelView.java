package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView BWi;
  public TextView uBa;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean dcY()
  {
    AppMethodBeat.i(31233);
    if (this.BWi != null)
    {
      localObject = this.BWi.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cd.a.ao(getContext(), 2131165370);
      this.BWi.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.n.b.ls(this.oFt.field_type))
    {
      if (u.se(this.oFt.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.oFt.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().aeK((String)localObject);
      if ((!bt.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.uBa.setText(k.c(getContext(), bt.n(localArrayList, getContext().getResources().getString(2131757526))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.oFt.field_encryptUsername;
    if (!bt.isNullOrNil((String)localObject)) {
      az.arV();
    }
    for (localObject = c.apN().agQ((String)localObject); localObject != null; localObject = c.apN().agQ(this.oFt.field_username))
    {
      localObject = ((bw)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().aeJ((String)localObject);
      if ((bt.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.uBa.setText(k.c(getContext(), bt.n(localArrayList, getContext().getResources().getString(2131757526))));
      AppMethodBeat.o(31233);
      return true;
      az.arV();
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
    this.uBa = ((TextView)findViewById(2131298619));
    this.BWi = ((TextView)findViewById(2131298620));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */