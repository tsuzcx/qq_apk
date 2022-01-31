package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class SightDraftUI
  extends MMActivity
{
  private int qVq;
  SightDraftContainerView qVr;
  private LinkedList<String> qVs;
  
  public SightDraftUI()
  {
    AppMethodBeat.i(25028);
    this.qVq = 1;
    this.qVs = new LinkedList();
    AppMethodBeat.o(25028);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25029);
    super.onCreate(paramBundle);
    setMMTitle(2131303725);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131689763));
    this.qVr = new SightDraftContainerView(this);
    setContentView(this.qVr);
    this.qVr.cmX();
    setBackBtn(new SightDraftUI.1(this));
    this.qVr.setSightDraftCallback(new SightDraftUI.2(this));
    AppMethodBeat.o(25029);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI
 * JD-Core Version:    0.7.0.1
 */