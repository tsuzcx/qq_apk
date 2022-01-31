package com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;

public class PopDialog
  extends i
{
  public static final int DIALOG_STYLE_MUL_BTN = 2;
  public static final int DIALOG_STYLE_SINGLE_BTN = 1;
  protected static final String TAG = "PopDialog";
  protected RelativeLayout contentLayout = null;
  protected TextView contentView = null;
  public ProgressBar downloadProgressBar = null;
  public TextView downloadText = null;
  protected Context mContext = null;
  private Button negativeBtn = null;
  protected Button positiveBtn = null;
  protected FrameLayout positiveLayout = null;
  public Res rTool = null;
  protected int style = 0;
  protected TextView titleView = null;
  
  public PopDialog(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public PopDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
  }
  
  public PopDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mContext = paramContext;
    this.style = paramInt2;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(75956);
    this.titleView.setPadding(px(30), 0, px(30), 0);
    this.contentLayout.setPadding(px(30), 0, px(30), px(30));
    this.contentView.setPadding(0, px(30), 0, px(30));
    AppMethodBeat.o(75956);
  }
  
  private void initMulDialog()
  {
    AppMethodBeat.i(75958);
    this.negativeBtn.setHeight(px(78));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.negativeBtn.getLayoutParams();
    localMarginLayoutParams.setMargins(0, 0, px(30), 0);
    this.negativeBtn.setLayoutParams(localMarginLayoutParams);
    this.positiveBtn.setHeight(px(78));
    this.positiveBtn.setTextSize(px(30));
    this.downloadProgressBar.setMinimumHeight(px(78));
    this.downloadText.setHeight(px(78));
    AppMethodBeat.o(75958);
  }
  
  private void initSingleDialog()
  {
    AppMethodBeat.i(75957);
    this.positiveLayout.setVisibility(8);
    this.negativeBtn.setHeight(px(78));
    this.negativeBtn.setText(this.mContext.getString(this.rTool.string("white_list_submit")));
    AppMethodBeat.o(75957);
  }
  
  private int px(int paramInt)
  {
    AppMethodBeat.i(75970);
    int i = getScreenHeight();
    int j = getScreenWidth();
    TMLog.i("PopDialog", " width = " + j + "  height = " + i);
    if (i > j) {}
    for (;;)
    {
      float f = paramInt;
      i = (int)((i + 0.0F) * f / 1280.0F);
      TMLog.i("PopDialog", "rtn" + paramInt + ":" + i);
      AppMethodBeat.o(75970);
      return i;
      i = j;
    }
  }
  
  private void relayoutView()
  {
    AppMethodBeat.i(75955);
    initHeaderView();
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75955);
      return;
      initSingleDialog();
      AppMethodBeat.o(75955);
      return;
      initMulDialog();
    }
  }
  
  public int getScreenHeight()
  {
    AppMethodBeat.i(75969);
    if (this.mContext != null)
    {
      int i = this.mContext.getResources().getDisplayMetrics().heightPixels;
      AppMethodBeat.o(75969);
      return i;
    }
    AppMethodBeat.o(75969);
    return 0;
  }
  
  public int getScreenWidth()
  {
    AppMethodBeat.i(75968);
    if (this.mContext != null)
    {
      int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(75968);
      return i;
    }
    AppMethodBeat.o(75968);
    return 0;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(75954);
    super.onCreate(paramBundle);
    this.rTool = new Res(this.mContext);
    super.setContentView(this.rTool.layout("com_tencent_tmassistant_sdk_white_list_dlg"));
    super.getWindow().setLayout(px(662), px(662));
    setCancelable(false);
    this.titleView = ((TextView)findViewById(this.rTool.id("dlg_title_tv")));
    this.contentLayout = ((RelativeLayout)findViewById(this.rTool.id("content")));
    this.contentView = ((TextView)findViewById(this.rTool.id("dlg_body_tv")));
    this.positiveBtn = ((Button)findViewById(this.rTool.id("positive_btn")));
    this.positiveLayout = ((FrameLayout)findViewById(this.rTool.id("positive_btn_frame_layout")));
    this.downloadProgressBar = ((ProgressBar)findViewById(this.rTool.id("download_pb")));
    this.downloadText = ((TextView)findViewById(this.rTool.id("progress_txt_tv")));
    this.negativeBtn = ((Button)findViewById(this.rTool.id("negtive_btn")));
    relayoutView();
    AppMethodBeat.o(75954);
  }
  
  public void setContent(String paramString)
  {
    AppMethodBeat.i(75960);
    if (!TextUtils.isEmpty(paramString)) {
      this.contentView.setText(paramString);
    }
    AppMethodBeat.o(75960);
  }
  
  public void setNegativeBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75967);
    if (paramOnClickListener != null) {
      this.negativeBtn.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(75967);
  }
  
  public void setNegativeBtnText(String paramString)
  {
    AppMethodBeat.i(75966);
    if (!TextUtils.isEmpty(paramString)) {
      this.negativeBtn.setText(paramString);
    }
    AppMethodBeat.o(75966);
  }
  
  public void setPositiveBtnBgResource(int paramInt)
  {
    AppMethodBeat.i(75964);
    if (paramInt != 0) {
      this.positiveBtn.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(75964);
  }
  
  public void setPositiveBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75962);
    if (paramOnClickListener != null) {
      this.positiveBtn.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(75962);
  }
  
  public void setPositiveBtnEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(75965);
    if (this.positiveBtn != null) {
      this.positiveBtn.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(75965);
  }
  
  public void setPositiveBtnTag(ActionButton paramActionButton)
  {
    AppMethodBeat.i(75961);
    if (paramActionButton != null) {
      this.positiveBtn.setTag(paramActionButton);
    }
    AppMethodBeat.o(75961);
  }
  
  public void setPositiveBtnText(String paramString)
  {
    AppMethodBeat.i(75963);
    if (!TextUtils.isEmpty(paramString)) {
      this.downloadText.setText(paramString);
    }
    AppMethodBeat.o(75963);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(75959);
    if (!TextUtils.isEmpty(paramString)) {
      this.titleView.setText(paramString);
    }
    AppMethodBeat.o(75959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog
 * JD-Core Version:    0.7.0.1
 */