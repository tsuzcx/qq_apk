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
  private ListView aiK;
  private f aiL;
  private View aiM;
  private View aiN;
  private View aiO;
  private View aiP;
  private View aiQ;
  private com.tencent.mm.sdk.a.e aiR = new com.tencent.mm.sdk.a.e() {};
  private com.tencent.mm.wear.app.ui.widget.d aie;
  private boolean ail;
  private AbsListView.OnScrollListener aim = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (MessageHistoryUI.a(MessageHistoryUI.this).getFirstVisiblePosition() == 0) && (!MessageHistoryUI.c(MessageHistoryUI.this)) && (MessageHistoryUI.b(MessageHistoryUI.this).nX()))
      {
        MessageHistoryUI.d(MessageHistoryUI.this);
        MessageHistoryUI.e(MessageHistoryUI.this).setVisibility(0);
      }
    }
  };
  
  public final void ai(int paramInt1, int paramInt2)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryUI", "increaseCount %d scene %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.aie.or();
    this.aiK.setVisibility(0);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.ail = false;
      this.aiN.setVisibility(8);
      return;
      if (MMActivity.isRect()) {}
      for (paramInt1 = nO() - 106;; paramInt1 = nO() - 87)
      {
        this.aiK.setSelectionFromTop(this.aiL.getCount() + 1, paramInt1);
        break;
      }
      this.aiK.setSelectionFromTop(paramInt1 + 1, 45);
    }
  }
  
  public final void c(int paramInt, long paramLong)
  {
    this.aiL.notifyDataSetChanged();
    getWindow().clearFlags(128);
  }
  
  public final void g(long paramLong)
  {
    this.aiL.notifyDataSetChanged();
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
        f((Intent)localObject);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = RemoteInput.getResultsFromIntent(paramIntent);
    } while (paramIntent == null);
    paramIntent = paramIntent.getCharSequence("android.intent.extra.TEXT").toString();
    try
    {
      localObject = new ah();
      ((ah)localObject).XI = getUsername();
      ((ah)localObject).Yn = 1;
      ((ah)localObject).Yo = paramIntent;
      paramIntent = new com.tencent.mm.wear.app.f.e(nQ(), 11023, ((ah)localObject).toByteArray());
      paramIntent.nG();
      com.tencent.mm.wear.app.b.h.mP().a(paramIntent);
      com.tencent.mm.wear.app.d.a.ci(2);
      return;
    }
    catch (IOException paramIntent) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aiK = ((ListView)findViewById(2131558471));
    this.aie = new com.tencent.mm.wear.app.ui.widget.d(this);
    if (!MMActivity.isRect())
    {
      this.aiK.setPadding(36, 0, 36, 0);
      this.aiM = getLayoutInflater().inflate(2130903063, null);
      this.aiO = this.aiM.findViewById(2131558473);
      this.aiP = this.aiM.findViewById(2131558474);
      this.aiQ = this.aiM.findViewById(2131558472);
      this.aiK.addFooterView(this.aiM);
      if (MMActivity.isRect()) {
        break label341;
      }
    }
    label341:
    for (paramBundle = getLayoutInflater().inflate(2130903065, null);; paramBundle = getLayoutInflater().inflate(2130903064, null))
    {
      this.aiN = paramBundle.findViewById(2131558459);
      this.aiK.addHeaderView(paramBundle);
      this.aiL = new f(this, getUsername());
      this.aiL.a(this);
      this.aiK.setAdapter(this.aiL);
      this.aiK.setOnScrollListener(this.aim);
      this.aiK.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
            paramAnonymousAdapterView = MessageHistoryUI.b(MessageHistoryUI.this).cn(paramAnonymousInt);
          } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.a(MessageHistoryUI.this, paramAnonymousAdapterView)));
          switch (paramAnonymousAdapterView.akG.aiI.XP)
          {
          default: 
            return;
          }
          if (MMActivity.nR())
          {
            if (paramAnonymousAdapterView.akG.aiI.XJ == com.tencent.mm.wear.app.b.h.mQ().nh().nt())
            {
              com.tencent.mm.wear.app.b.h.mQ().nh().ns();
              return;
            }
            MessageHistoryUI.this.getWindow().addFlags(128);
            com.tencent.mm.wear.app.b.h.mQ().nh().k(MessageHistoryUI.b(MessageHistoryUI.this).cr(paramAnonymousInt));
            return;
          }
          Toast.makeText(MessageHistoryUI.this, 2131165249, 0).show();
        }
      });
      this.aie.a(new com.tencent.mm.wear.app.ui.widget.e()
      {
        public final void onStart()
        {
          MessageHistoryUI.b(MessageHistoryUI.this).nV();
        }
      });
      this.aie.startLoading();
      this.aiO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.cj(3);
          paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyVoiceUI.class);
          MessageHistoryUI.this.f(paramAnonymousView);
        }
      });
      this.aiP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.cj(4);
          if (!com.tencent.mm.wear.app.b.h.mO().mH())
          {
            paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyTextUI.class);
            MessageHistoryUI.this.f(paramAnonymousView);
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
            MessageHistoryUI.this.g(paramAnonymousView);
          }
        }
      });
      this.aiQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.wear.app.d.a.cj(2);
          paramAnonymousView = new Intent(MessageHistoryUI.this, ReplyEmojiListUI.class);
          MessageHistoryUI.this.f(paramAnonymousView);
        }
      });
      U(getUsername());
      this.aiL.nV();
      com.tencent.mm.sdk.a.a.YM.a(this.aiR);
      com.tencent.mm.wear.app.b.h.mQ().nh().a(this);
      com.tencent.mm.wear.app.d.a.cj(1);
      return;
      this.aiM = getLayoutInflater().inflate(2130903062, null);
      break;
    }
  }
  
  protected void onDestroy()
  {
    if (this.aiL != null) {
      this.aiL.finish();
    }
    com.tencent.mm.wear.app.b.h.mQ().nh().ns();
    com.tencent.mm.sdk.a.a.YM.b(this.aiR);
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11021, null);
    com.tencent.mm.wear.app.b.h.mP().a(localb);
    com.tencent.mm.wear.app.b.h.mQ().nh().a(null);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.wear.app.b.h.mS().stop();
    com.tencent.mm.wear.app.b.h.mQ().nh().ns();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.wear.app.b.h.mS().start();
    this.aiL.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.MessageHistoryUI
 * JD-Core Version:    0.7.0.1
 */