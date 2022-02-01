package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cn;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView KcG;
  public TextView KcH;
  
  public ProfileDescribeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileDescribeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileDescribeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean eEV()
  {
    AppMethodBeat.i(31211);
    if (this.KcH != null)
    {
      localObject1 = this.KcH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aG(getContext(), 2131165381);
      this.KcH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.rjX == null)
    {
      setVisibility(8);
      AppMethodBeat.o(31211);
      return false;
    }
    Object localObject2 = this.rjX.fuR;
    int i;
    if (!Util.isNullOrNil(this.rjX.fuS)) {
      i = 1;
    }
    while (com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
      if ((!Util.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(2131689887);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).QBM = ((int)((localDrawable.getIntrinsicHeight() - this.KcG.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.KcG.setText(l.b(getContext(), (CharSequence)localObject2, this.KcG.getTextSize()));
        AppMethodBeat.o(31211);
        return true;
        i = 0;
      }
      else
      {
        if ((!Util.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.KcG.setText(l.b(getContext(), Util.nullAsNil((String)localObject2), this.KcG.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((Util.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(2131689887);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).QBM = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.KcG.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(2131758033));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.KcG.setText(l.b(getContext(), (CharSequence)localObject2, this.KcG.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((Util.isNullOrNil((String)localObject2)) && (i == 0))
        {
          Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
          setVisibility(8);
          AppMethodBeat.o(31211);
          return false;
        }
        Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
        setVisibility(8);
        AppMethodBeat.o(31211);
        return false;
      }
    }
    Object localObject1 = null;
    localObject2 = this.rjX.field_encryptUsername;
    if (!Util.isNullOrNil((String)localObject2))
    {
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSO().aEZ((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((cn)localObject1).systemRowid < 0L)
      {
        bg.aVF();
        localObject2 = com.tencent.mm.model.c.aSO().aEZ(this.rjX.field_username);
      }
    }
    if ((localObject2 != null) && (!Util.isNullOrNil(((cn)localObject2).field_conDescription)))
    {
      this.KcG.setText(l.b(getContext(), Util.nullAsNil(((cn)localObject2).field_conDescription), this.KcG.getTextSize()));
      AppMethodBeat.o(31211);
      return true;
    }
    Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
    setVisibility(8);
    AppMethodBeat.o(31211);
    return false;
  }
  
  public int getLayout()
  {
    return 2131495977;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31210);
    this.KcG = ((TextView)findViewById(2131299046));
    this.KcH = ((TextView)findViewById(2131299047));
    setClickable(true);
    AppMethodBeat.o(31210);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileDescribeView
 * JD-Core Version:    0.7.0.1
 */