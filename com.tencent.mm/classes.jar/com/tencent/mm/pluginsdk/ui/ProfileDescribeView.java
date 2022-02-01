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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bz;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView Don;
  public TextView Doo;
  
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
  
  public final boolean dqG()
  {
    AppMethodBeat.i(31211);
    if (this.Doo != null)
    {
      localObject1 = this.Doo.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.au(getContext(), 2131165370);
      this.Doo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.piT == null)
    {
      setVisibility(8);
      AppMethodBeat.o(31211);
      return false;
    }
    Object localObject2 = this.piT.eyf;
    int i;
    if (!bs.isNullOrNil(this.piT.eyg)) {
      i = 1;
    }
    while (b.ln(this.piT.field_type)) {
      if ((!bs.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(2131689872);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).IZa = ((int)((localDrawable.getIntrinsicHeight() - this.Don.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.Don.setText(k.b(getContext(), (CharSequence)localObject2, this.Don.getTextSize()));
        AppMethodBeat.o(31211);
        return true;
        i = 0;
      }
      else
      {
        if ((!bs.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.Don.setText(k.b(getContext(), bs.nullAsNil((String)localObject2), this.Don.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bs.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(2131689872);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).IZa = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.Don.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(2131757793));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.Don.setText(k.b(getContext(), (CharSequence)localObject2, this.Don.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bs.isNullOrNil((String)localObject2)) && (i == 0))
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
    localObject2 = this.piT.field_encryptUsername;
    if (!bs.isNullOrNil((String)localObject2))
    {
      az.ayM();
      localObject1 = c.awC().alK((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((bz)localObject1).systemRowid < 0L)
      {
        az.ayM();
        localObject2 = c.awC().alK(this.piT.field_username);
      }
    }
    if ((localObject2 != null) && (!bs.isNullOrNil(((bz)localObject2).field_conDescription)))
    {
      this.Don.setText(k.b(getContext(), bs.nullAsNil(((bz)localObject2).field_conDescription), this.Don.getTextSize()));
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
    return 2131495134;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31210);
    this.Don = ((TextView)findViewById(2131298609));
    this.Doo = ((TextView)findViewById(2131298610));
    setClickable(true);
    AppMethodBeat.o(31210);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileDescribeView
 * JD-Core Version:    0.7.0.1
 */