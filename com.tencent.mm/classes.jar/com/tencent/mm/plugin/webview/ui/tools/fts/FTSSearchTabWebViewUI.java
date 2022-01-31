package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.ae;

@com.tencent.mm.ui.base.a(3)
public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public boolean apb()
  {
    if (this.kAW != null) {
      this.kAW.getFtsEditText().kEp.clearFocus();
    }
    return super.apb();
  }
  
  public String getHint()
  {
    String str = getIntent().getStringExtra("key_search_input_hint");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    int i = -1;
    switch (this.type)
    {
    }
    while (i < 0)
    {
      return ae.getContext().getResources().getString(R.l.app_search);
      i = R.l.search_education_biz_contact;
      continue;
      i = R.l.fts_header_timeline;
      continue;
      i = R.l.search_education_article;
      continue;
      i = R.l.fts_header_poi;
      continue;
      i = R.l.app_brand_entrance;
      continue;
      i = R.l.fts_header_emoji;
      continue;
      i = R.l.fts_header_emoji_product;
      continue;
      i = R.l.fts_header_music;
      continue;
      i = R.l.fts_header_novel;
    }
    return ae.getContext().getResources().getString(R.l.search_detail_page_hint, new Object[] { ae.getContext().getResources().getString(i) });
  }
  
  public void onClickCancelBtn(View paramView)
  {
    super.onClickCancelBtn(paramView);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    czo();
  }
  
  protected void onPause()
  {
    super.onPause();
    ao.bZN();
  }
  
  public void onResume()
  {
    super.onResume();
    ao.bZM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI
 * JD-Core Version:    0.7.0.1
 */