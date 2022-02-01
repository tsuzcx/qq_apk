package org.xwalk.core;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkExtendPluginNativeViewClient
{
  private static final String TAG = "XWalkExtendPluginNativeViewClient";
  private Context mContext;
  private XWalkExtendPluginNativeViewDelegate mDelegate;
  private int mHeight;
  private NativeViewPresentation mNativeViewPresentation;
  private FrameLayout mRootView;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private VirtualDisplay mVirtualDisplay;
  private int mWidth;
  
  public XWalkExtendPluginNativeViewClient(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183758);
    this.mContext = paramContext;
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    AppMethodBeat.o(183758);
  }
  
  private void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(183763);
    if (this.mNativeViewPresentation != null) {
      this.mNativeViewPresentation.detach();
    }
    if (this.mVirtualDisplay != null)
    {
      this.mVirtualDisplay.setSurface(null);
      this.mVirtualDisplay.release();
    }
    this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
    DisplayManager localDisplayManager = (DisplayManager)getContext().getSystemService("display");
    int i = getContext().getResources().getDisplayMetrics().densityDpi;
    this.mVirtualDisplay = localDisplayManager.createVirtualDisplay("xweb-vd" + hashCode(), this.mWidth, this.mHeight, i, this.mSurface, 0);
    this.mNativeViewPresentation = new NativeViewPresentation(getContext(), this.mVirtualDisplay.getDisplay(), false, this);
    this.mNativeViewPresentation.show();
    AppMethodBeat.o(183763);
  }
  
  public void dispose()
  {
    AppMethodBeat.i(183762);
    if (this.mDelegate != null) {
      this.mDelegate.onDestroy();
    }
    if (this.mNativeViewPresentation != null)
    {
      this.mNativeViewPresentation.cancel();
      this.mNativeViewPresentation.detach();
    }
    if (this.mVirtualDisplay != null) {
      this.mVirtualDisplay.release();
    }
    AppMethodBeat.o(183762);
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(183760);
    if (this.mDelegate != null)
    {
      Context localContext = this.mDelegate.getContext();
      AppMethodBeat.o(183760);
      return localContext;
    }
    Log.e("XWalkExtendPluginNativeViewClient", "no context");
    AppMethodBeat.o(183760);
    return null;
  }
  
  public FrameLayout getRootView()
  {
    return this.mRootView;
  }
  
  public void onNativeViewDestroy(int paramInt) {}
  
  public void onNativeViewReady(int paramInt) {}
  
  public void onNativeViewSizeChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onNativeViewTouch(int paramInt, MotionEvent paramMotionEvent) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183761);
    if (this.mDelegate != null) {
      this.mDelegate.onSizeChanged(paramInt1, paramInt2);
    }
    if ((this.mWidth != paramInt1) || (this.mHeight != paramInt2))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      refresh(false);
    }
    AppMethodBeat.o(183761);
  }
  
  public void setDelegate(XWalkExtendPluginNativeViewDelegate paramXWalkExtendPluginNativeViewDelegate)
  {
    AppMethodBeat.i(183759);
    this.mDelegate = paramXWalkExtendPluginNativeViewDelegate;
    if (paramXWalkExtendPluginNativeViewDelegate != null)
    {
      this.mRootView = new FrameLayout(paramXWalkExtendPluginNativeViewDelegate.getContext());
      refresh(false);
    }
    AppMethodBeat.o(183759);
  }
  
  @TargetApi(17)
  @Keep
  class NativeViewPresentation
    extends Presentation
  {
    private XWalkExtendPluginNativeViewClient mClient;
    private FrameLayout mContentView;
    private boolean mStartFocused;
    
    public NativeViewPresentation(Context paramContext, Display paramDisplay, boolean paramBoolean, XWalkExtendPluginNativeViewClient paramXWalkExtendPluginNativeViewClient)
    {
      super(paramDisplay);
      AppMethodBeat.i(183755);
      this.mStartFocused = false;
      getWindow().setFlags(8, 8);
      this.mStartFocused = paramBoolean;
      this.mClient = paramXWalkExtendPluginNativeViewClient;
      AppMethodBeat.o(183755);
    }
    
    public void detach()
    {
      AppMethodBeat.i(183757);
      if (XWalkExtendPluginNativeViewClient.this.mRootView != null) {
        XWalkExtendPluginNativeViewClient.this.mRootView.removeAllViews();
      }
      AppMethodBeat.o(183757);
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(183756);
      super.onCreate(paramBundle);
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      XWalkExtendPluginNativeViewClient.access$002(XWalkExtendPluginNativeViewClient.this, new FrameLayout(getContext()));
      if (this.mContentView != null)
      {
        if (this.mStartFocused) {
          this.mContentView.requestFocus();
        }
        XWalkExtendPluginNativeViewClient.this.mRootView.addView(this.mContentView);
      }
      setContentView(XWalkExtendPluginNativeViewClient.this.mRootView);
      if (XWalkExtendPluginNativeViewClient.this.mDelegate != null) {
        XWalkExtendPluginNativeViewClient.this.mDelegate.onCreate(this.mClient.mWidth, this.mClient.mHeight);
      }
      AppMethodBeat.o(183756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginNativeViewClient
 * JD-Core Version:    0.7.0.1
 */