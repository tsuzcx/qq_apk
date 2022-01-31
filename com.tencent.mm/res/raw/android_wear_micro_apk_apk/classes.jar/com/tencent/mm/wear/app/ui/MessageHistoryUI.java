package com.tencent.mm.wear.app.ui;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.b.a.k;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.ui.emoji.ReplyEmojiListUI;
import com.tencent.mm.wear.app.ui.message.ReplyTextUI;
import com.tencent.mm.wear.app.ui.message.ReplyVoiceUI;
import com.tencent.mm.wear.app.ui.message.TextMessageConfirmUI;
import java.io.IOException;
import java.util.ArrayList;

public class MessageHistoryUI
  extends MMAvatarActivity
  implements com.tencent.mm.wear.app.d.a.a.e, h
{
  private com.tencent.mm.wear.app.ui.widget.d aeC;
  private boolean aeJ;
  private AbsListView.OnScrollListener aeK = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (MessageHistoryUI.a(MessageHistoryUI.this).getFirstVisiblePosition() == 0) && (!MessageHistoryUI.c(MessageHistoryUI.this)) && (MessageHistoryUI.b(MessageHistoryUI.this).nk()))
      {
        MessageHistoryUI.d(MessageHistoryUI.this);
        MessageHistoryUI.e(MessageHistoryUI.this).setVisibility(0);
      }
    }
  };
  private ListView afi;
  private f afj;
  private View afk;
  private View afl;
  private View afm;
  private View afn;
  private View afo;
  private com.tencent.mm.sdk.a.e afp = new com.tencent.mm.sdk.a.e() {};
  
  public final void af(int paramInt1, int paramInt2)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryUI", "increaseCount %d scene %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.aeC.nD();
    this.afi.setVisibility(0);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.aeJ = false;
      this.afl.setVisibility(8);
      return;
      if (MMActivity.isRect()) {}
      for (paramInt1 = nb() - 106;; paramInt1 = nb() - 87)
      {
        this.afi.setSelectionFromTop(this.afj.getCount() + 1, paramInt1);
        break;
      }
      this.afi.setSelectionFromTop(paramInt1 + 1, 45);
    }
  }
  
  public final void c(int paramInt, long paramLong)
  {
    this.afj.notifyDataSetChanged();
    getWindow().clearFlags(128);
  }
  
  public final void f(long paramLong)
  {
    this.afj.notifyDataSetChanged();
  }
  
  public final int getLayoutId()
  {
    return 2130903061;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        paramIntent = paramIntent.getStringArrayListExtra("android.speech.extra.RESULTS");
        localObject = new Intent(this, TextMessageConfirmUI.class);
        ((Intent)localObject).putExtra("key_text", (String)paramIntent.get(0));
        d((Intent)localObject);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = RemoteInput.getResultsFromIntent(paramIntent);
    } while (paramIntent == null);
    paramIntent = paramIntent.getCharSequence("android.intent.extra.TEXT").toString();
    try
    {
      localObject = new ah();
      ((ah)localObject).VN = getUsername();
      ((ah)localObject).Ws = 1;
      ((ah)localObject).Wt = paramIntent;
      paramIntent = new com.tencent.mm.wear.app.f.e(nd(), 11023, ((ah)localObject).toByteArray());
      paramIntent.mU();
      com.tencent.mm.wear.app.b.h.mc().a(paramIntent);
      com.tencent.mm.wear.app.d.a.bM(2);
      return;
    }
    catch (IOException paramIntent) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.afi = ((ListView)findViewById(2131558470));
    this.aeC = new com.tencent.mm.wear.app.ui.widget.d(this);
    if (!MMActivity.isRect())
    {
      this.afi.setPadding(36, 0, 36, 0);
      this.afk = getLayoutInflater().inflate(2130903063, null);
      this.afm = this.afk.findViewById(2131558472);
      this.afn = this.afk.findViewById(2131558473);
      this.afo = this.afk.findViewById(2131558471);
      this.afi.addFooterView(this.afk);
      if (MMActivity.isRect()) {
        break label341;
      }
    }
    label341:
    for (paramBundle = getLayoutInflater().inflate(2130903065, null);; paramBundle = getLayoutInflater().inflate(2130903064, null))
    {
      this.afl = paramBundle.findViewById(2131558458);
      this.afi.addHeaderView(paramBundle);
      this.afj = new f(this, getUsername());
      this.afj.a(this);
      this.afi.setAdapter(this.afj);
      this.afi.setOnScrollListener(this.aeK);
      this.afi.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryUI", "onItemClick %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousInt -= MessageHistoryUI.a(MessageHistoryUI.this).getHeaderViewsCount();
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= MessageHistoryUI.b(MessageHistoryUI.this).getCount())) {
            com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryUI", "not hit the real item", new Object[0]);
          }
          do
          {
            return;
            paramAnonymousAdapterView = MessageHistoryUI.b(MessageHistoryUI.this).bR(paramAnonymousInt);
          } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.a(MessageHistoryUI.this, paramAnonymousAdapterView)));
          switch (paramAnonymousAdapterView.ahe.afg.VU)
          {
          default: 
            return;
          }
          if (MMActivity.ne())
          {
            if (paramAnonymousAdapterView.ahe.afg.VO == com.tencent.mm.wear.app.b.h.md().mv().mH())
            {
              com.tencent.mm.wear.app.b.h.md().mv().mG();
              return;
            }
            MessageHistoryUI.this.getWindow().addFlags(128);
            com.tencent.mm.wear.app.b.h.md().mv().k(MessageHistoryUI.b(MessageHistoryUI.this).bV(paramAnonymousInt));
            return;
          }
          Toast.makeText(MessageHistoryUI.this, 2131165246, 0).show();
        }
      });
      this.aeC.a(new com.tencent.mm.wear.app.ui.widget.e()
      {
        public final void onStart()
        {
          MessageHistoryUI.b(MessageHistoryUI.this).ni();
        }
      });
      this.aeC.startLoading();
      this.afm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.bN(3);
          paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyVoiceUI.class);
          MessageHistoryUI.this.d(paramAnonymousView);
        }
      });
      this.afn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.bN(4);
          if (!com.tencent.mm.wear.app.b.h.mb().lU())
          {
            paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyTextUI.class);
            MessageHistoryUI.this.d(paramAnonymousView);
            return;
          }
          try
          {
            paramAnonymousView = MessageHistoryUI.this.getString(2131165222);
            Object localObject = MessageHistoryUI.this.getResources().getStringArray(2131492880);
            paramAnonymousView = new RemoteInput.Builder("android.intent.extra.TEXT").setLabel(paramAnonymousView).setChoices((CharSequence[])localObject).build();
            localObject = new Intent("android.support.wearable.input.action.REMOTE_INPUT");
            ((Intent)localObject).putExtra("android.support.wearable.input.extra.REMOTE_INPUTS", new RemoteInput[] { paramAnonymousView });
            MessageHistoryUI.this.startActivityForResult((Intent)localObject, 1);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            paramAnonymousView = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            MessageHistoryUI.this.e(paramAnonymousView);
          }
        }
      });
      this.afo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.bN(2);
          paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyEmojiListUI.class);
          MessageHistoryUI.this.d(paramAnonymousView);
        }
      });
      N(getUsername());
      this.afj.ni();
      com.tencent.mm.sdk.a.a.WJ.a(this.afp);
      com.tencent.mm.wear.app.b.h.md().mv().a(this);
      com.tencent.mm.wear.app.d.a.bN(1);
      return;
      this.afk = getLayoutInflater().inflate(2130903062, null);
      break;
    }
  }
  
  protected void onDestroy()
  {
    if (this.afj != null) {
      this.afj.finish();
    }
    com.tencent.mm.wear.app.b.h.md().mv().mG();
    com.tencent.mm.sdk.a.a.WJ.b(this.afp);
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11021, null);
    com.tencent.mm.wear.app.b.h.mc().a(localb);
    com.tencent.mm.wear.app.b.h.md().mv().a(null);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.wear.app.b.h.mf().stop();
    com.tencent.mm.wear.app.b.h.md().mv().mG();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.wear.app.b.h.mf().start();
    this.afj.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.MessageHistoryUI
 * JD-Core Version:    0.7.0.1
 */