package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bv;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView say;
  public TextView saz;
  
  public ProfileDescribeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileDescribeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean bsP()
  {
    if (this.saz != null)
    {
      localObject1 = this.saz.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aa(getContext(), R.f.FixedTitleWidth);
      this.saz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.jgl == null)
    {
      setVisibility(8);
      return false;
    }
    Object localObject2 = this.jgl.cCJ;
    int i;
    if (!bk.bl(this.jgl.cCK)) {
      i = 1;
    }
    while (com.tencent.mm.n.a.gR(this.jgl.field_type)) {
      if ((!bk.bl((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(R.k.card_photoicon);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).wjc = ((int)((localDrawable.getIntrinsicHeight() - this.say.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  " + (String)localObject2);
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.say.setText(j.a(getContext(), (CharSequence)localObject2, this.say.getTextSize()));
        return true;
        i = 0;
      }
      else
      {
        if ((!bk.bl((String)localObject2)) && (i == 0))
        {
          this.say.setText(j.a(getContext(), bk.pm((String)localObject2), this.say.getTextSize()));
          return true;
        }
        if ((bk.bl((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(R.k.card_photoicon);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).wjc = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.say.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(R.l.contact_info_remark_info_with_image));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.say.setText(j.a(getContext(), (CharSequence)localObject2, this.say.getTextSize()));
          return true;
        }
        if ((bk.bl((String)localObject2)) && (i == 0))
        {
          setVisibility(8);
          return false;
        }
        setVisibility(8);
        return false;
      }
    }
    Object localObject1 = this.jgl.field_encryptUsername;
    if (!bk.bl((String)localObject1)) {
      au.Hx();
    }
    for (localObject1 = c.Fx().Id((String)localObject1); (localObject1 != null) && (!bk.bl(((bv)localObject1).field_conDescription)); localObject1 = c.Fx().Id(this.jgl.field_username))
    {
      this.say.setText(j.a(getContext(), bk.pm(((bv)localObject1).field_conDescription), this.say.getTextSize()));
      return true;
      au.Hx();
    }
    setVisibility(8);
    return false;
  }
  
  public int getLayout()
  {
    return R.i.profile_describe_layout;
  }
  
  public final void init()
  {
    this.say = ((TextView)findViewById(R.h.contact_info_describe));
    this.saz = ((TextView)findViewById(R.h.contact_info_describe_title));
    setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileDescribeView
 * JD-Core Version:    0.7.0.1
 */