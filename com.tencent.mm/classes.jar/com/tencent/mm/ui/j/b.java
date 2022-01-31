package com.tencent.mm.ui.j;

import android.annotation.SuppressLint;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class b
  extends i
{
  static final float[] Aof;
  static final float[] Aog;
  static final FrameLayout.LayoutParams Aoh;
  private a ABo;
  private ProgressDialog Aoj;
  private ImageView Aok;
  private FrameLayout Aol;
  private String mUrl;
  private WebView uNH;
  
  static
  {
    AppMethodBeat.i(80369);
    Aof = new float[] { 20.0F, 60.0F };
    Aog = new float[] { 40.0F, 60.0F };
    Aoh = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(80369);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.ABo = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80367);
    super.onCreate(paramBundle);
    this.Aoj = new ProgressDialog(getContext());
    this.Aoj.requestWindowFeature(1);
    this.Aoj.setMessage(getContext().getString(2131304397));
    requestWindowFeature(1);
    this.Aol = new FrameLayout(getContext());
    this.Aok = new ImageView(getContext());
    this.Aok.setOnClickListener(new b.1(this));
    paramBundle = getContext().getResources().getDrawable(2130838396);
    this.Aok.setImageDrawable(paramBundle);
    this.Aok.setVisibility(4);
    int i = this.Aok.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.uNH = new WebView(getContext());
    this.uNH.setVerticalScrollBarEnabled(false);
    this.uNH.setHorizontalScrollBarEnabled(false);
    this.uNH.setWebViewClient(new b.b(this, (byte)0));
    this.uNH.getSettings().setJavaScriptEnabled(true);
    this.uNH.loadUrl(this.mUrl);
    this.uNH.setLayoutParams(Aoh);
    this.uNH.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.uNH);
    this.Aol.addView(paramBundle);
    this.Aol.addView(this.Aok, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.Aol, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(80367);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80368);
    if (paramInt == 4)
    {
      this.ABo.onCancel();
      dismiss();
      AppMethodBeat.o(80368);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80368);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void dOz();
    
    public abstract void onCancel();
    
    public abstract void u(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.j.b
 * JD-Core Version:    0.7.0.1
 */