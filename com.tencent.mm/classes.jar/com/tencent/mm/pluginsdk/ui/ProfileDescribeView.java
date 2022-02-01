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
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cg;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView FlO;
  public TextView FlP;
  
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
  
  public final boolean dEA()
  {
    AppMethodBeat.i(31211);
    if (this.FlP != null)
    {
      localObject1 = this.FlP.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.ax(getContext(), 2131165370);
      this.FlP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.pSY == null)
    {
      setVisibility(8);
      AppMethodBeat.o(31211);
      return false;
    }
    Object localObject2 = this.pSY.eRo;
    int i;
    if (!bu.isNullOrNil(this.pSY.eRp)) {
      i = 1;
    }
    while (com.tencent.mm.contact.c.lO(this.pSY.field_type)) {
      if ((!bu.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(2131689872);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable);
        ((com.tencent.mm.ui.widget.a)localObject1).LmE = ((int)((localDrawable.getIntrinsicHeight() - this.FlO.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.FlO.setText(k.b(getContext(), (CharSequence)localObject2, this.FlO.getTextSize()));
        AppMethodBeat.o(31211);
        return true;
        i = 0;
      }
      else
      {
        if ((!bu.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.FlO.setText(k.b(getContext(), bu.nullAsNil((String)localObject2), this.FlO.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bu.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(2131689872);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
          ((com.tencent.mm.ui.widget.a)localObject1).LmE = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.FlO.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(2131757793));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.FlO.setText(k.b(getContext(), (CharSequence)localObject2, this.FlO.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((bu.isNullOrNil((String)localObject2)) && (i == 0))
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
    localObject2 = this.pSY.field_encryptUsername;
    if (!bu.isNullOrNil((String)localObject2))
    {
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azG().arE((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((cg)localObject1).systemRowid < 0L)
      {
        bc.aCg();
        localObject2 = com.tencent.mm.model.c.azG().arE(this.pSY.field_username);
      }
    }
    if ((localObject2 != null) && (!bu.isNullOrNil(((cg)localObject2).field_conDescription)))
    {
      this.FlO.setText(k.b(getContext(), bu.nullAsNil(((cg)localObject2).field_conDescription), this.FlO.getTextSize()));
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
    this.FlO = ((TextView)findViewById(2131298609));
    this.FlP = ((TextView)findViewById(2131298610));
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