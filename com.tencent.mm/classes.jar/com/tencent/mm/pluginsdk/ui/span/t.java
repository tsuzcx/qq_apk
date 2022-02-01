package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public class t
  extends ClickableSpan
  implements com.tencent.mm.ui.base.span.a
{
  private static final String TAG = "MicroMsg.PressableClickSpan";
  private boolean isPressed;
  private a mAdTagClickCallback;
  private int mAdTagClickScene;
  private int mBgColor;
  protected n mClickListener;
  private boolean mEnable;
  private u mHrefInfo;
  private int mLinkColor;
  private String mSessionId;
  private WeakReference<View> mViewRef;
  private int position;
  private Object tag;
  private Context uiContext;
  
  public t()
  {
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
    this.tag = null;
  }
  
  public t(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152340);
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
    this.tag = null;
    setColor(paramInt1, paramInt2);
    this.mClickListener = new n();
    AppMethodBeat.o(152340);
  }
  
  public t(int paramInt, u paramu)
  {
    AppMethodBeat.i(152339);
    this.isPressed = false;
    this.mClickListener = null;
    this.mHrefInfo = null;
    this.mEnable = true;
    this.mViewRef = null;
    this.uiContext = null;
    this.tag = null;
    int j;
    int i;
    if (paramu != null)
    {
      j = paramu.linkColor;
      i = paramu.backgroundColor;
    }
    for (;;)
    {
      setColorConfig(paramInt, j, i);
      this.mClickListener = new n();
      this.mHrefInfo = paramu;
      AppMethodBeat.o(152339);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private void setColorConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152341);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      setColorConfig(paramInt1);
      AppMethodBeat.o(152341);
      return;
    }
    setColor(paramInt2, paramInt3);
    AppMethodBeat.o(152341);
  }
  
  public int getBgColor()
  {
    return this.mBgColor;
  }
  
  public u getHrefInfo()
  {
    return this.mHrefInfo;
  }
  
  public boolean getPress()
  {
    return this.isPressed;
  }
  
  public Object getTag()
  {
    return this.tag;
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
    AppMethodBeat.i(152343);
    n localn;
    if ((this.mClickListener != null) && (this.mHrefInfo != null) && (this.mEnable))
    {
      localn = this.mClickListener;
      if (this.uiContext == null) {
        break label98;
      }
    }
    label98:
    for (Context localContext = this.uiContext;; localContext = paramView.getContext())
    {
      localn.mContext = localContext;
      this.mClickListener.a(paramView, this.mHrefInfo);
      this.mClickListener.mContext = null;
      if (this.mAdTagClickCallback != null) {
        this.mAdTagClickCallback.lG(this.position, this.mAdTagClickScene);
      }
      AppMethodBeat.o(152343);
      return;
    }
  }
  
  public void setAdTagClickCallback(a parama, int paramInt)
  {
    this.mAdTagClickCallback = parama;
    this.position = paramInt;
  }
  
  public void setAdTagClickScene(int paramInt)
  {
    this.mAdTagClickScene = paramInt;
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.mLinkColor = paramInt1;
    this.mBgColor = paramInt2;
  }
  
  protected void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(152342);
    Context localContext = MMApplicationContext.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152342);
      return;
      setColor(localContext.getResources().getColor(c.b.chat_url_color), localContext.getResources().getColor(c.b.BW_0_Alpha_0_1));
      AppMethodBeat.o(152342);
      return;
      setColor(localContext.getResources().getColor(c.b.chat_to_url_color), localContext.getResources().getColor(c.b.BW_0_Alpha_0_1));
      AppMethodBeat.o(152342);
      return;
      setColor(localContext.getResources().getColor(c.b.brand_text_color), localContext.getResources().getColor(c.b.sns_link_bg_color));
      AppMethodBeat.o(152342);
      return;
      setColor(localContext.getResources().getColor(c.b.sns_lucky_item_gold), localContext.getResources().getColor(c.b.sns_link_bg_color));
      setColor(localContext.getResources().getColor(c.b.red_packet_link_color), localContext.getResources().getColor(c.b.sns_link_bg_color));
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.uiContext = paramContext;
    if (this.mClickListener != null) {
      this.mClickListener.mContext = paramContext;
    }
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
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(152344);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.PressableClickSpan", "updateDrawState, isPressed:%b", new Object[] { Boolean.valueOf(this.isPressed) });
    }
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.mLinkColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.linkColor = this.mLinkColor;
    if (getPress())
    {
      paramTextPaint.bgColor = this.mBgColor;
      AppMethodBeat.o(152344);
      return;
    }
    paramTextPaint.bgColor = 0;
    AppMethodBeat.o(152344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.t
 * JD-Core Version:    0.7.0.1
 */