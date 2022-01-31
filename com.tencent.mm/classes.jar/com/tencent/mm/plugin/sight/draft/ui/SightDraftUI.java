package com.tencent.mm.plugin.sight.draft.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class SightDraftUI
  extends MMActivity
{
  private int ohb = 1;
  SightDraftContainerView ohc;
  private LinkedList<String> ohd = new LinkedList();
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.sight_old_draft_title);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.black));
    this.ohc = new SightDraftContainerView(this);
    setContentView(this.ohc);
    this.ohc.bBx();
    setBackBtn(new SightDraftUI.1(this));
    this.ohc.setSightDraftCallback(new SightDraftUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI
 * JD-Core Version:    0.7.0.1
 */