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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cr;
import org.xwalk.core.Log;

public class ProfileDescribeView
  extends ProfileItemView
{
  public TextView XZr;
  public TextView XZs;
  
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
  
  public final boolean gCe()
  {
    AppMethodBeat.i(31211);
    if (this.XZs != null)
    {
      localObject1 = this.XZs.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.br(getContext(), R.f.FixedTitleWidth);
      this.XZs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.xVS == null)
    {
      setVisibility(8);
      AppMethodBeat.o(31211);
      return false;
    }
    Object localObject2 = this.xVS.kal;
    int i;
    if (!Util.isNullOrNil(this.xVS.kam)) {
      i = 1;
    }
    while (d.rs(this.xVS.field_type)) {
      if ((!Util.isNullOrNil((String)localObject2)) && (i != 0))
      {
        Drawable localDrawable = getContext().getResources().getDrawable(R.k.card_photoicon);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localObject1 = new com.tencent.mm.ui.widget.a(localDrawable, 1);
        ((com.tencent.mm.ui.widget.a)localObject1).afSg = ((int)((localDrawable.getIntrinsicHeight() - this.XZr.getTextSize()) / 2.0F));
        localObject2 = new SpannableString("  ".concat(String.valueOf(localObject2)));
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        this.XZr.setText(p.b(getContext(), (CharSequence)localObject2, this.XZr.getTextSize()));
        AppMethodBeat.o(31211);
        return true;
        i = 0;
      }
      else
      {
        if ((!Util.isNullOrNil((String)localObject2)) && (i == 0))
        {
          this.XZr.setText(p.b(getContext(), Util.nullAsNil((String)localObject2), this.XZr.getTextSize()));
          AppMethodBeat.o(31211);
          return true;
        }
        if ((Util.isNullOrNil((String)localObject2)) && (i != 0))
        {
          localObject2 = getContext().getResources().getDrawable(R.k.card_photoicon);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
          ((com.tencent.mm.ui.widget.a)localObject1).afSg = ((int)((((Drawable)localObject2).getIntrinsicHeight() - this.XZr.getTextSize()) / 2.0F));
          localObject2 = new SpannableString("  " + getContext().getString(R.l.gBR));
          ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
          this.XZr.setText(p.b(getContext(), (CharSequence)localObject2, this.XZr.getTextSize()));
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
    localObject2 = this.xVS.field_encryptUsername;
    if (!Util.isNullOrNil((String)localObject2))
    {
      bh.bCz();
      localObject1 = c.bzB().aMi((String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((cr)localObject1).systemRowid < 0L)
      {
        bh.bCz();
        localObject2 = c.bzB().aMi(this.xVS.field_username);
      }
    }
    if ((localObject2 != null) && (!Util.isNullOrNil(((cr)localObject2).field_conDescription)))
    {
      this.XZr.setText(p.b(getContext(), Util.nullAsNil(((cr)localObject2).field_conDescription), this.XZr.getTextSize()));
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
    return R.i.gnb;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31210);
    this.XZr = ((TextView)findViewById(R.h.fCj));
    this.XZs = ((TextView)findViewById(R.h.fCk));
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