package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;

public class ProfileLabelView
  extends ProfileItemView
{
  public TextView mWv;
  public TextView saI;
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean bsP()
  {
    if (this.saI != null)
    {
      localObject = this.saI.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.aa(getContext(), R.f.FixedTitleWidth);
      this.saI.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ArrayList localArrayList;
    if (com.tencent.mm.n.a.gR(this.jgl.field_type))
    {
      if (q.gS(this.jgl.field_username))
      {
        setVisibility(8);
        return false;
      }
      localObject = this.jgl.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bdA().Gn((String)localObject);
      if ((!bk.bl((String)localObject)) && (localArrayList != null) && (localArrayList.size() > 0))
      {
        this.mWv.setText(j.b(getContext(), bk.c(localArrayList, getContext().getResources().getString(R.l.comma))));
        return true;
      }
      setVisibility(8);
      return false;
    }
    Object localObject = this.jgl.field_encryptUsername;
    if (!bk.bl((String)localObject)) {
      au.Hx();
    }
    for (localObject = c.Fx().Id((String)localObject); localObject != null; localObject = c.Fx().Id(this.jgl.field_username))
    {
      localObject = ((bv)localObject).field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bdA().Gm((String)localObject);
      if ((bk.bl((String)localObject)) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.mWv.setText(j.b(getContext(), bk.c(localArrayList, getContext().getResources().getString(R.l.comma))));
      return true;
      au.Hx();
    }
    setVisibility(8);
    return false;
  }
  
  public int getLayout()
  {
    return R.i.profile_label_layout;
  }
  
  public final void init()
  {
    this.mWv = ((TextView)findViewById(R.h.contact_info_label));
    this.saI = ((TextView)findViewById(R.h.contact_info_label_title));
    setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileLabelView
 * JD-Core Version:    0.7.0.1
 */