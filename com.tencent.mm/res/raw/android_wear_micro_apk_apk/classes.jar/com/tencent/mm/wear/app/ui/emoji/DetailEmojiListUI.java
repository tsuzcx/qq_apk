package com.tencent.mm.wear.app.ui.emoji;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.support.wearable.view.y;
import android.widget.TextView;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.g;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.widget.d;
import java.io.IOException;

public class DetailEmojiListUI
  extends MMActivity
  implements c
{
  private String acH;
  private int ada;
  private d aeC;
  private String afs;
  private WearableListView afw;
  private b afx;
  private TextView afy;
  private y afz = new y()
  {
    public final void a(android.support.wearable.view.af paramAnonymousaf)
    {
      paramAnonymousaf = (EmojiLayout)paramAnonymousaf.ve;
      if (DetailEmojiListUI.b(DetailEmojiListUI.this) > 0) {}
      for (int i = 2;; i = 1)
      {
        com.tencent.mm.e.a.af localaf = new com.tencent.mm.e.a.af();
        localaf.Vr = paramAnonymousaf.nm();
        localaf.VN = DetailEmojiListUI.c(DetailEmojiListUI.this);
        localaf.Vt = DetailEmojiListUI.d(DetailEmojiListUI.this);
        localaf.Ws = i;
        try
        {
          paramAnonymousaf = new com.tencent.mm.wear.app.f.e(DetailEmojiListUI.b(DetailEmojiListUI.this), 11024, localaf.toByteArray());
          paramAnonymousaf.a(new g()
          {
            public final void mV()
            {
              com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
              {
                public final void run()
                {
                  DetailEmojiListUI.this.setResult(-1);
                  DetailEmojiListUI.this.finish();
                }
              }, 1000L);
            }
          });
          h.mc().a(paramAnonymousaf);
          com.tencent.mm.wear.app.d.a.bM(3);
          return;
        }
        catch (IOException paramAnonymousaf) {}
      }
    }
  };
  
  public final void bW(int paramInt)
  {
    this.aeC.nD();
    if (paramInt > 0)
    {
      this.afw.setVisibility(0);
      this.afy.setVisibility(8);
      return;
    }
    this.afw.setVisibility(8);
    this.afy.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.afs = getIntent().getStringExtra("key_product_id");
    this.acH = getIntent().getStringExtra("key_talker");
    this.ada = getIntent().getIntExtra("key_notification_id", 0);
    this.aeC = new d(this);
    this.afy = ((TextView)findViewById(2131558447));
    this.afw = ((WearableListView)findViewById(2131558446));
    this.afx = new b(this, this.afs);
    this.afw.a(this.afx);
    this.afw.a(this.afz);
    this.aeC.a(new com.tencent.mm.wear.app.ui.widget.e()
    {
      public final void onStart()
      {
        DetailEmojiListUI.a(DetailEmojiListUI.this).nl();
      }
    });
    this.aeC.startLoading();
    this.afx.a(this);
    this.afx.nl();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    h.mf().stop();
  }
  
  protected void onResume()
  {
    super.onResume();
    h.mf().start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.DetailEmojiListUI
 * JD-Core Version:    0.7.0.1
 */