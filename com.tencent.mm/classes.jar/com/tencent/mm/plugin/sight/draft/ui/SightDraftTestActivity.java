package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.os.Bundle;

public class SightDraftTestActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new SightDraftContainerView(this);
    setContentView(paramBundle);
    paramBundle.bBx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftTestActivity
 * JD-Core Version:    0.7.0.1
 */