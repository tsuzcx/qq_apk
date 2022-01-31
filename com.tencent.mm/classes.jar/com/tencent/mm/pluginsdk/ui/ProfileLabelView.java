package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView pzr;
  public TextView vRB;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean ccG()
  {
    AppMethodBeat.i(27531);
    if (this.vRB != null)
    {
      localObject = this.vRB.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.ao(getContext(), 2131427664);
      this.vRB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.n.a.je(this.lpe.field_type))
    {
      if (r.nB(this.lpe.field_username))
      {
        setVisibility(8);
        AppMethodBeat.o(27531);
        return false;
      }
      localObject = this.lpe.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RQ((String)localObject);
      if ((!bo.isNullOrNil((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.pzr.setText(j.b(getContext(), bo.d(localArrayList, getContext().getResources().getString(2131298491))));
        AppMethodBeat.o(27531);
        return true;
      }
      setVisibility(8);
      AppMethodBeat.o(27531);
      return false;
    }
    Object localObject = this.lpe.field_encryptUsername;
    if (!bo.isNullOrNil((String)localObject)) {
      aw.aaz();
    }
    for (localObject = c.YB().TM((String)localObject); localObject != null; localObject = c.YB().TM(this.lpe.field_username))
    {
      localObject = ((bv)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RP((String)localObject);
      if ((bo.isNullOrNil((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.pzr.setText(j.b(getContext(), bo.d(localArrayList, getContext().getResources().getString(2131298491))));
      AppMethodBeat.o(27531);
      return true;
      aw.aaz();
    }
    setVisibility(8);
    AppMethodBeat.o(27531);
    return false;
  }
  
  public int getLayout()
  {
    return 2130970465;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27530);
    this.pzr = ((TextView)findViewById(2131826851));
    this.vRB = ((TextView)findViewById(2131826850));
    setClickable(true);
    AppMethodBeat.o(27530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */