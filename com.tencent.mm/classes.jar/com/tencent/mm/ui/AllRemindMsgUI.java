package com.tencent.mm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.widget.b.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> dss = new com.tencent.mm.a.f(32);
  private RecyclerView acI;
  private ProgressBar fsc;
  private LinkedList<AllRemindMsgUI.d> irx;
  private AllRemindMsgUI.a uGA = new AllRemindMsgUI.a(this);
  private View uGy;
  private AllRemindMsgUI.b uGz;
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    String str = "";
    Object localObject = g.a.gp(paramString);
    switch (paramInt1)
    {
    default: 
      localObject = paramContext.getString(R.l.none_type);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            return paramContext.getString(R.l.app_brand_default_name_with_brackets);
            paramString = new n(paramString);
            return paramContext.getString(R.l.record_voice_with_time, new Object[] { Integer.valueOf((int)q.ck(paramString.time)) });
            return paramContext.getString(R.l.app_pic);
            if (62 == paramInt1) {}
            for (paramInt1 = R.l.app_shortvideo;; paramInt1 = R.l.app_video) {
              return paramContext.getString(paramInt1);
            }
            au.Hx();
            com.tencent.mm.model.c.Fy().HO(paramString);
            return paramContext.getString(R.l.record_location_with_title, new Object[] { "" });
            return paramContext.getString(R.l.app_friend_card);
            if (localObject == null)
            {
              y.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
              return "";
            }
            switch (((g.a)localObject).type)
            {
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 16: 
            case 18: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            default: 
              y.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((g.a)localObject).type) });
              break;
            case 33: 
              return paramContext.getString(R.l.app_brand_default_name_with_brackets);
            case 6: 
              return paramContext.getString(R.l.record_file_with_title, new Object[] { ((g.a)localObject).title });
            case 5: 
            case 7: 
              return paramContext.getString(R.l.record_url_with_title, new Object[] { "" });
            case 8: 
              return paramContext.getString(R.l.app_emoji2);
            case 15: 
            case 26: 
            case 27: 
              return paramContext.getString(R.l.app_emoji);
            case 25: 
              return paramContext.getString(R.l.app_designer_share);
            case 17: 
              return paramContext.getString(R.l.record_location_with_title, new Object[] { "" });
            case 19: 
              return paramContext.getString(R.l.record_record_with_title, new Object[] { "" });
            case 24: 
              return paramContext.getString(R.l.record_note_with_title, new Object[] { "" });
            case 3: 
              return paramContext.getString(R.l.record_music_with_title, new Object[] { "" });
            case 4: 
              return paramContext.getString(R.l.record_video_with_title, new Object[] { "" });
            case 2: 
              return paramContext.getString(R.l.app_pic);
              return paramContext.getString(R.l.app_emoji);
              return paramContext.getString(R.l.record_remittance_with_title);
              if (localObject == null)
              {
                y.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                return "";
              }
              if (paramInt2 == 1) {
                return paramContext.getString(R.l.record_c2c_with_title, new Object[] { ((g.a)localObject).dSf, "" });
              }
              return paramContext.getString(R.l.record_c2c_with_title, new Object[] { ((g.a)localObject).dSf, "" });
              if (localObject == null)
              {
                y.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                return "";
              }
              return paramContext.getString(R.l.record_c2c_with_title, new Object[] { ((g.a)localObject).dSf, "" });
              return paramContext.getString(R.l.record_card_with_title, new Object[] { "" });
              return paramContext.getString(R.l.record_card_with_title, new Object[] { "" });
              return paramContext.getString(R.l.record_app_with_title, new Object[] { "" });
              return paramContext.getString(R.l.record_share_location_with_title, new Object[] { "" });
              localObject = str;
            }
          } while (paramString == null);
          localObject = str;
        } while (paramString.length() <= 0);
        paramString = bi.d.acc(paramString);
        localObject = str;
      } while (paramString.pyp == null);
      localObject = str;
    } while (paramString.pyp.length() <= 0);
    switch (paramString.scene)
    {
    case 19: 
    case 20: 
    case 21: 
    default: 
      return paramContext.getString(R.l.fmt_want_to_be_your_friend, new Object[] { paramString.getDisplayName() });
    case 18: 
      return paramContext.getString(R.l.fmt_say_hello_to_you, new Object[] { paramString.getDisplayName() });
    case 22: 
    case 23: 
    case 24: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
      return paramContext.getString(R.l.fmt_shake_say_hello_to_you, new Object[] { paramString.getDisplayName() });
    }
    return paramContext.getString(R.l.fmt_bottle_say_hello_to_you, new Object[] { paramString.getDisplayName() });
  }
  
  protected final int getLayoutId()
  {
    return R.i.all_remind_msg_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.remind_title);
    this.acI = ((RecyclerView)findViewById(R.h.all_msg_list));
    this.fsc = ((ProgressBar)findViewById(R.h.progress_bar));
    this.uGy = findViewById(R.h.hint_tip);
    this.acI.setVisibility(8);
    RecyclerView localRecyclerView = this.acI;
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.uGz = new AllRemindMsgUI.b(this);
    this.acI.setAdapter(this.uGz);
    this.uGz.a(new AllRemindMsgUI.1(this));
    setBackBtn(new AllRemindMsgUI.2(this));
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(866, this.uGA);
    au.Dk().a(525, this);
    h.nFQ.a(795L, 3L, 1L, false);
    initView();
    e.post(new AllRemindMsgUI.a(this), "load remind data!");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(866, this.uGA);
    au.Dk().b(525, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 525) {
        return;
      }
      paramString = (bqo)((x)paramm).esv.ecE.ecN;
      paramm = this.irx.listIterator();
      while (paramm.hasNext()) {
        if (((AllRemindMsgUI.d)paramm.next()).uGJ == paramString.tHE.tEd) {
          paramm.remove();
        }
      }
      this.uGz.agL.notifyChanged();
      return;
    }
    Toast.makeText(this.mController.uMN, bk.aM(paramString, getString(R.l.notify_message_settings_complain_failed)), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */