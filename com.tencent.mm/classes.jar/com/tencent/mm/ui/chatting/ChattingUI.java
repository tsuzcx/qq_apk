package com.tencent.mm.ui.chatting;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.qq;
import com.tencent.mm.autogen.a.uz;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.component.BizComponent;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.x;
import com.tencent.mm.xwebutil.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.kernel.k
public class ChattingUI
  extends MMSecDataFragmentActivity
{
  public ChattingUIFragment aekg;
  public MMHandler aekh;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.aekh = new MMHandler();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    Log.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.aekg != null) && (this.aekg.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34697);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34697);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(253870);
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if ((this.aekg != null) && (((ap)this.aekg.iNh().cm(ap.class)).jtm()) && (!((ap)this.aekg.iNh().cm(ap.class)).jtp()))
    {
      i = ((ap)this.aekg.iNh().cm(ap.class)).jtr();
      getIntent().putExtra("select_record_msg_num", i);
      localObject1 = ((m)this.aekg.iNh().cm(m.class)).jqk();
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        l = 9223372036854775807L;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          if (((Long)localObject2).longValue() >= l) {
            break label311;
          }
          l = ((Long)localObject2).longValue();
        }
      }
    }
    label311:
    for (;;)
    {
      break;
      getIntent().putExtra("select_record_min_msg_id", l);
      localObject2 = ((ap)this.aekg.iNh().cm(ap.class)).jtq();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(String.valueOf(((Long)((Iterator)localObject2).next()).longValue()));
        }
        getIntent().putStringArrayListExtra("key_select_record_msg_black_list", (ArrayList)localObject1);
      }
      Log.i("MicroMsg.ChattingUI", "select record msg %s", new Object[] { Integer.valueOf(i) });
      setResult(-1, getIntent());
      super.finish();
      AppMethodBeat.o(253870);
      return;
    }
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(253858);
    HashSet localHashSet = new HashSet();
    Set localSet = super.importUIComponents();
    if (localSet != null) {
      localHashSet.addAll(localSet);
    }
    localHashSet.add(q.class);
    localHashSet.add(e.class);
    localHashSet.add(d.class);
    AppMethodBeat.o(253858);
    return localHashSet;
  }
  
  protected ChattingUIFragment jot()
  {
    AppMethodBeat.i(34696);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment((byte)0);
    AppMethodBeat.o(34696);
    return localChattingUIFragment;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34701);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.aekg.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    if (!aw.jkS()) {
      aw.jkT();
    }
    super.onCreate(null);
    if (BizComponent.cg(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(R.i.ghA);
    this.aekg = jot();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.aekg.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(R.h.fOk, this.aekg).FW();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34692);
          com.tencent.mm.ui.base.k.b(ChattingUI.this, ChattingUI.this.getString(R.l.notification_need_resend_dialog_prompt), "", ChattingUI.this.getString(R.l.notification_need_resend_dialog_prompt_resend_now), ChattingUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34690);
              new uz().publish();
              AppMethodBeat.o(34690);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34691);
              new qq().publish();
              AppMethodBeat.o(34691);
            }
          });
          AppMethodBeat.o(34692);
        }
      }, 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.aekh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if ((ChattingUI.this.aekg != null) && (!aw.jkS()) && (!aw.jkT())) {
          h.b(ChattingUI.this, ChattingUI.this.aekg.getBodyView());
        }
        b.dg(ChattingUI.this.aekg.getContext());
        AppMethodBeat.o(34693);
      }
    });
    AppMethodBeat.o(34695);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34699);
    Log.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34699);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34698);
    Log.d("MicroMsg.ChattingUI", "chatting ui on key up");
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(34698);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(253863);
    super.onPause();
    if (aw.jkS()) {
      bh.getNotification().eu(false);
    }
    AppMethodBeat.o(253863);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34700);
    Log.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.aekg.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(34700);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(253859);
    super.onResume();
    com.tencent.mm.plugin.ai.data.business.tools_mp.a.caq();
    if (com.tencent.mm.plugin.ai.data.business.tools_mp.a.car()) {
      c.jQE();
    }
    if (aw.jkS()) {
      bh.getNotification().eu(true);
    }
    AppMethodBeat.o(253859);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(253889);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      x localx = x.afLD;
      x.bCG(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(253889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */