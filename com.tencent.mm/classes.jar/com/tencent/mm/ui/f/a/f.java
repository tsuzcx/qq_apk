package com.tencent.mm.ui.f.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class f
  extends i
{
  static final float[] vVW = { 20.0F, 60.0F };
  static final float[] vVX = { 40.0F, 60.0F };
  static final FrameLayout.LayoutParams vVY = new FrameLayout.LayoutParams(-1, -1);
  private String mUrl;
  private c.a vVZ;
  private ProgressDialog vWa;
  private ImageView vWb;
  private WebView vWc;
  private FrameLayout vWd;
  
  public f(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.vVZ = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.vWa = new ProgressDialog(getContext());
    this.vWa.requestWindowFeature(1);
    this.vWa.setMessage(getContext().getString(a.h.facebook_sdk_loading));
    requestWindowFeature(1);
    this.vWd = new FrameLayout(getContext());
    this.vWb = new ImageView(getContext());
    this.vWb.setOnClickListener(new f.1(this));
    paramBundle = getContext().getResources().getDrawable(a.d.close_facebook);
    this.vWb.setImageDrawable(paramBundle);
    this.vWb.setVisibility(4);
    int i = this.vWb.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.vWc = new WebView(getContext());
    this.vWc.setVerticalScrollBarEnabled(false);
    this.vWc.setHorizontalScrollBarEnabled(false);
    this.vWc.setWebViewClient(new f.a(this, (byte)0));
    this.vWc.getSettings().setJavaScriptEnabled(true);
    this.vWc.loadUrl(this.mUrl);
    this.vWc.setLayoutParams(vVY);
    this.vWc.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.vWc);
    this.vWd.addView(paramBundle);
    this.vWd.addView(this.vWb, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.vWd, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.vVZ.onCancel();
      dismiss();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.f
 * JD-Core Version:    0.7.0.1
 */