package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a.a;
import java.lang.ref.WeakReference;

public class n
  extends ClickableSpan
  implements a
{
  private static final String TAG = "MicroMsg.PressableClickSpan";
  private boolean isPressed;
  private int mBgColor;
  protected h mClickListener;
  private boolean mEnable;
  private m mHrefInfo;
  private int mLinkColor;
  private String mSessionId;
  private WeakReference<View> mViewRef;
  private Context uiContext;
  
  public n()
  {
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
  }
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79879);
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
    setColor(paramInt1, paramInt2);
    this.mClickListener = new h();
    AppMethodBeat.o(79879);
  }
  
  public n(int paramInt, m paramm)
  {
    AppMethodBeat.i(79878);
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
    int j;
    int i;
    if (paramm != null)
    {
      j = paramm.linkColor;
      i = paramm.backgroundColor;
    }
    for (;;)
    {
      setColorConfig(paramInt, j, i);
      this.mClickListener = new h();
      this.mHrefInfo = paramm;
      AppMethodBeat.o(79878);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private void setColorConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151632);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      setColorConfig(paramInt1);
      AppMethodBeat.o(151632);
      return;
    }
    setColor(paramInt2, paramInt3);
    AppMethodBeat.o(151632);
  }
  
  public int getBgColor()
  {
    return this.mBgColor;
  }
  
  public boolean getPress()
  {
    return this.isPressed;
  }
  
  public int getType()
  {
    if (this.mHrefInfo == null) {
      return 2147483647;
    }
    return this.mHrefInfo.type;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(79881);
    h localh;
    if ((this.mClickListener != null) && (this.mHrefInfo != null) && (this.mEnable))
    {
      localh = this.mClickListener;
      if (this.uiContext == null) {
        break label74;
      }
    }
    label74:
    for (Context localContext = this.uiContext;; localContext = paramView.getContext())
    {
      localh.mContext = localContext;
      this.mClickListener.a(paramView, this.mHrefInfo);
      this.mClickListener.mContext = null;
      AppMethodBeat.o(79881);
      return;
    }
  }
  
  protected void setColor(int paramInt1, int paramInt2)
  {
    this.mLinkColor = paramInt1;
    this.mBgColor = paramInt2;
  }
  
  protected void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(79880);
    Context localContext = ah.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79880);
      return;
      setColor(localContext.getResources().getColor(2131689874), localContext.getResources().getColor(2131689482));
      AppMethodBeat.o(79880);
      return;
      setColor(localContext.getResources().getColor(2131689778), localContext.getResources().getColor(2131690488));
      AppMethodBeat.o(79880);
      return;
      setColor(localContext.getResources().getColor(2131690497), localContext.getResources().getColor(2131690488));
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.uiContext = paramContext;
    this.mClickListener.mContext = paramContext;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setIsPressed(boolean paramBoolean)
  {
    this.isPressed = paramBoolean;
  }
  
  public void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
    if (this.mClickListener != null) {
      this.mClickListener.mSessionId = this.mSessionId;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(79882);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.mLinkColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.linkColor = this.mLinkColor;
    if (getPress())
    {
      paramTextPaint.bgColor = this.mBgColor;
      AppMethodBeat.o(79882);
      return;
    }
    paramTextPaint.bgColor = 0;
    AppMethodBeat.o(79882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.n
 * JD-Core Version:    0.7.0.1
 */