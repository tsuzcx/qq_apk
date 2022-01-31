package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

public class ClearCacheUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_message");
    long l = getIntent().getLongExtra("key_mask", 0L);
    h.a(this, paramBundle, getString(R.l.clear_cache_title), getString(R.l.clear_cache_now), getString(R.l.clear_cache_cancel), false, new ClearCacheUI.1(this, l), new ClearCacheUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI
 * JD-Core Version:    0.7.0.1
 */