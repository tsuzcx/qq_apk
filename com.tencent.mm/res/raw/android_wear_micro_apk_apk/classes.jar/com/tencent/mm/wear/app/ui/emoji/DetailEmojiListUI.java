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
  private int agB;
  private String agi;
  private String aiU;
  private WearableListView aiY;
  private b aiZ;
  private d aie;
  private TextView aja;
  private y ajb = new y()
  {
    public final void a(android.support.wearable.view.af paramAnonymousaf)
    {
      paramAnonymousaf = (EmojiLayout)paramAnonymousaf.wT;
      if (DetailEmojiListUI.b(DetailEmojiListUI.this) > 0) {}
      for (int i = 2;; i = 1)
      {
        com.tencent.mm.e.a.af localaf = new com.tencent.mm.e.a.af();
        localaf.Xm = paramAnonymousaf.nZ();
        localaf.XI = DetailEmojiListUI.c(DetailEmojiListUI.this);
        localaf.Xo = DetailEmojiListUI.d(DetailEmojiListUI.this);
        localaf.Yn = i;
        try
        {
          paramAnonymousaf = new com.tencent.mm.wear.app.f.e(DetailEmojiListUI.b(DetailEmojiListUI.this), 11024, localaf.toByteArray());
          paramAnonymousaf.a(new g()
          {
            public final void nH()
            {
              com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
              {
                public final void run()
                {
                  DetailEmojiListUI.this.setResult(-1);
                  DetailEmojiListUI.this.finish();
                }
              }, 1000L);
            }
          });
          h.mP().a(paramAnonymousaf);
          com.tencent.mm.wear.app.d.a.ci(3);
          return;
        }
        catch (IOException paramAnonymousaf) {}
      }
    }
  };
  
  public final void cs(int paramInt)
  {
    this.aie.or();
    if (paramInt > 0)
    {
      this.aiY.setVisibility(0);
      this.aja.setVisibility(8);
      return;
    }
    this.aiY.setVisibility(8);
    this.aja.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.aiU = getIntent().getStringExtra("key_product_id");
    this.agi = getIntent().getStringExtra("key_talker");
    this.agB = getIntent().getIntExtra("key_notification_id", 0);
    this.aie = new d(this);
    this.aja = ((TextView)findViewById(2131558448));
    this.aiY = ((WearableListView)findViewById(2131558447));
    this.aiZ = new b(this, this.aiU);
    this.aiY.a(this.aiZ);
    this.aiY.a(this.ajb);
    this.aie.a(new com.tencent.mm.wear.app.ui.widget.e()
    {
      public final void onStart()
      {
        DetailEmojiListUI.a(DetailEmojiListUI.this).nY();
      }
    });
    this.aie.startLoading();
    this.aiZ.a(this);
    this.aiZ.nY();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    h.mS().stop();
  }
  
  protected void onResume()
  {
    super.onResume();
    h.mS().start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.DetailEmojiListUI
 * JD-Core Version:    0.7.0.1
 */