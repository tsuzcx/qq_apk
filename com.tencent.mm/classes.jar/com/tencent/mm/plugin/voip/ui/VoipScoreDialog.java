package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e.a;

@a(3)
public class VoipScoreDialog
  extends MMActivity
{
  private VoipScoreState pQq;
  private ViewGroup pXn;
  private ImageView[] pXo = new ImageView[5];
  private c pXp = null;
  private int pXq = 0;
  
  protected final int getLayoutId()
  {
    return a.c.voip_transparent_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.pQq = ((VoipScoreState)getIntent().getParcelableExtra("key_score_state"));
    if (this.pQq == null)
    {
      b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
      finish();
    }
    do
    {
      return;
      this.pXn = ((ViewGroup)View.inflate(this, a.c.voip_score_star_line, null));
      this.pXo[0] = ((ImageView)this.pXn.findViewById(a.b.score_1));
      this.pXo[1] = ((ImageView)this.pXn.findViewById(a.b.score_2));
      this.pXo[2] = ((ImageView)this.pXn.findViewById(a.b.score_3));
      this.pXo[3] = ((ImageView)this.pXn.findViewById(a.b.score_4));
      this.pXo[4] = ((ImageView)this.pXn.findViewById(a.b.score_5));
      int i = 0;
      while (i < this.pXo.length)
      {
        this.pXo[i].setOnClickListener(new VoipScoreDialog.1(this, i));
        i += 1;
      }
      paramBundle = new e.a(this);
      paramBundle.aeF(this.pQq.pTn);
      paramBundle.ek(this.pXn);
      paramBundle.wnv = getString(a.e.voip_score_dialog_reject);
      paramBundle.b(new VoipScoreDialog.2(this));
      paramBundle.nY(false);
      this.pXp = paramBundle.few;
    } while (this.pXp == null);
    this.pXp.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog
 * JD-Core Version:    0.7.0.1
 */