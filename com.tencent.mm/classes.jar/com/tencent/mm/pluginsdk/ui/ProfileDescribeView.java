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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cf;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView ETt;
  public TextView ETu;
  
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
  
  public final boolean dBj()
  {
    AppMethodBeat.i(31211);
    if (this.ETu != null)
    {
      localObject1 = this.ETu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.ax(getContext(), 2131165370);
      this.ETu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.pMt == null)
    {
      setVisibility(8);
      AppMethodBeat.o(31211);
      return false;
    }
    Object localObject2 = this.pMt.ePD;
    int i;
    if (!bt.isNullOrNil(this.pMt.ePE)) {
      i = 1;
    }
    while (b.lM(this.pMt.field_type)) {
      if ((!bt.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(2131689872);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).KQg = ((int)((localDrawable.getIntrinsicHeight() - this.ETt.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.ETt.setText(k.b(getContext(), (CharSequence)localObject2, this.ETt.getTextSize()));
        AppMethodBeat.o(31211);
        return true;
        i = 0;
      }
      else
      {
        if ((!bt.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.ETt.setText(k.b(getContext(), bt.nullAsNil((String)localObject2), this.ETt.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bt.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(2131689872);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).KQg = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.ETt.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(2131757793));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.ETt.setText(k.b(getContext(), (CharSequence)localObject2, this.ETt.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bt.isNullOrNil((String)localObject2)) && (i == 0))
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
    localObject2 = this.pMt.field_encryptUsername;
    if (!bt.isNullOrNil((String)localObject2))
    {
      ba.aBQ();
      localObject1 = c.azq().aqz((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((cf)localObject1).systemRowid < 0L)
      {
        ba.aBQ();
        localObject2 = c.azq().aqz(this.pMt.field_username);
      }
    }
    if ((localObject2 != null) && (!bt.isNullOrNil(((cf)localObject2).field_conDescription)))
    {
      this.ETt.setText(k.b(getContext(), bt.nullAsNil(((cf)localObject2).field_conDescription), this.ETt.getTextSize()));
      AppMethodBeat.o(31211);
      return true;
    }
    Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
    setVisibility(8);
    AppMethodBeat.o(31211);
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int getLayout()
  {
    return 2131495134;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31210);
    this.ETt = ((TextView)findViewById(2131298609));
    this.ETu = ((TextView)findViewById(2131298610));
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