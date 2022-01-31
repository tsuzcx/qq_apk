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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bv;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView vRp;
  public TextView vRq;
  
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
  
  public final boolean ccG()
  {
    AppMethodBeat.i(27508);
    if (this.vRq != null)
    {
      localObject1 = this.vRq.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.ao(getContext(), 2131427664);
      this.vRq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.lpe == null)
    {
      setVisibility(8);
      AppMethodBeat.o(27508);
      return false;
    }
    Object localObject2 = this.lpe.dqT;
    int i;
    if (!bo.isNullOrNil(this.lpe.dqU)) {
      i = 1;
    }
    while (com.tencent.mm.n.a.je(this.lpe.field_type)) {
      if ((!bo.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(2131231080);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).ACa = ((int)((localDrawable.getIntrinsicHeight() - this.vRp.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.vRp.setText(j.b(getContext(), (CharSequence)localObject2, this.vRp.getTextSize()));
        AppMethodBeat.o(27508);
        return true;
        i = 0;
      }
      else
      {
        if ((!bo.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.vRp.setText(j.b(getContext(), bo.nullAsNil((String)localObject2), this.vRp.getTextSize()));
          AppMethodBeat.o(27508);
          return true;
        }
        if ((bo.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(2131231080);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).ACa = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.vRp.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(2131298730));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.vRp.setText(j.b(getContext(), (CharSequence)localObject2, this.vRp.getTextSize()));
          AppMethodBeat.o(27508);
          return true;
        }
        if ((bo.isNullOrNil((String)localObject2)) && (i == 0))
        {
          Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
          setVisibility(8);
          AppMethodBeat.o(27508);
          return false;
        }
        Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
        setVisibility(8);
        AppMethodBeat.o(27508);
        return false;
      }
    }
    Object localObject1 = null;
    localObject2 = this.lpe.field_encryptUsername;
    if (!bo.isNullOrNil((String)localObject2))
    {
      aw.aaz();
      localObject1 = c.YB().TM((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((bv)localObject1).systemRowid < 0L)
      {
        aw.aaz();
        localObject2 = c.YB().TM(this.lpe.field_username);
      }
    }
    if ((localObject2 != null) && (!bo.isNullOrNil(((bv)localObject2).field_conDescription)))
    {
      this.vRp.setText(j.b(getContext(), bo.nullAsNil(((bv)localObject2).field_conDescription), this.vRp.getTextSize()));
      AppMethodBeat.o(27508);
      return true;
    }
    Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
    setVisibility(8);
    AppMethodBeat.o(27508);
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int getLayout()
  {
    return 2130970461;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27507);
    this.vRp = ((TextView)findViewById(2131826846));
    this.vRq = ((TextView)findViewById(2131826845));
    setClickable(true);
    AppMethodBeat.o(27507);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileDescribeView
 * JD-Core Version:    0.7.0.1
 */