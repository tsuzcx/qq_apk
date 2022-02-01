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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cr;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView MWH;
  public TextView XZE;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean gCe()
  {
    AppMethodBeat.i(31233);
    if (this.XZE != null)
    {
      localObject = this.XZE.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cd.a.br(getContext(), R.f.FixedTitleWidth);
      this.XZE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (d.rs(this.xVS.field_type))
    {
      if (z.Iy(this.xVS.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(31233);
        return false;
      }
      localObject = this.xVS.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJJ((String)localObject);
      if ((!Util.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.MWH.setText(p.b(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(R.l.gAt))));
        AppMethodBeat.o(31233);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(31233);
      return false;
    }
    Object localObject = this.xVS.field_encryptUsername;
    if (!Util.isNullOrNil((String)localObject)) {
      bh.bCz();
    }
    for (localObject = c.bzB().aMi((String)localObject); localObject != null; localObject = c.bzB().aMi(this.xVS.field_username))
    {
      localObject = ((cr)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJI((String)localObject);
      if ((Util.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.MWH.setText(p.b(getContext(), Util.listToString(localArrayList, getContext().getResources().getString(R.l.gAt))));
      AppMethodBeat.o(31233);
      return true;
      bh.bCz();
    }
    setVisibility(8);
    AppMethodBeat.o(31233);
    return false;
  }
  
  public int getLayout()
  {
    return R.i.gnf;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31232);
    this.MWH = ((TextView)findViewById(R.h.fCq));
    this.XZE = ((TextView)findViewById(R.h.fCr));
    setClickable(true);
    AppMethodBeat.o(31232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */