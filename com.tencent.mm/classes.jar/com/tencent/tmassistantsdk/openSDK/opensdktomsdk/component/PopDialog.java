package com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component;

import android.app.Dialog;
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
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;

public class PopDialog
  extends Dialog
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
    this.titleView.setPadding(px(30), 0, px(30), 0);
    this.contentLayout.setPadding(px(30), 0, px(30), px(30));
    this.contentView.setPadding(0, px(30), 0, px(30));
  }
  
  private void initMulDialog()
  {
    this.negativeBtn.setHeight(px(78));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.negativeBtn.getLayoutParams();
    localMarginLayoutParams.setMargins(0, 0, px(30), 0);
    this.negativeBtn.setLayoutParams(localMarginLayoutParams);
    this.positiveBtn.setHeight(px(78));
    this.positiveBtn.setTextSize(px(30));
    this.downloadProgressBar.setMinimumHeight(px(78));
    this.downloadText.setHeight(px(78));
  }
  
  private void initSingleDialog()
  {
    this.positiveLayout.setVisibility(8);
    this.negativeBtn.setHeight(px(78));
    this.negativeBtn.setText(this.mContext.getString(this.rTool.string("white_list_submit")));
  }
  
  private int px(int paramInt)
  {
    int i = getScreenHeight();
    int j = getScreenWidth();
    TMLog.i("PopDialog", " width = " + j + "  height = " + i);
    if (i > j) {}
    for (;;)
    {
      float f = paramInt;
      i = (int)((i + 0.0F) * f / 1280.0F);
      TMLog.i("PopDialog", "rtn" + paramInt + ":" + i);
      return i;
      i = j;
    }
  }
  
  private void relayoutView()
  {
    initHeaderView();
    switch (this.style)
    {
    default: 
      return;
    case 1: 
      initSingleDialog();
      return;
    }
    initMulDialog();
  }
  
  public int getScreenHeight()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().widthPixels;
    }
    return 0;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
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
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.contentView.setText(paramString);
    }
  }
  
  public void setNegativeBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.negativeBtn.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setNegativeBtnText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.negativeBtn.setText(paramString);
    }
  }
  
  public void setPositiveBtnBgResource(int paramInt)
  {
    if (paramInt != 0) {
      this.positiveBtn.setBackgroundResource(paramInt);
    }
  }
  
  public void setPositiveBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.positiveBtn.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPositiveBtnEnable(boolean paramBoolean)
  {
    if (this.positiveBtn != null) {
      this.positiveBtn.setEnabled(paramBoolean);
    }
  }
  
  public void setPositiveBtnTag(ActionButton paramActionButton)
  {
    if (paramActionButton != null) {
      this.positiveBtn.setTag(paramActionButton);
    }
  }
  
  public void setPositiveBtnText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.downloadText.setText(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.titleView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog
 * JD-Core Version:    0.7.0.1
 */