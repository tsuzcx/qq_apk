package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean vep = false;
  private String drl;
  private String drm;
  private n drn;
  private ListView fry;
  private long idK;
  private String mTitle;
  private String talker;
  private BizChatAtSomeoneUI.a ven;
  private c veo;
  
  protected static String a(c paramc, String paramString)
  {
    if (paramc == null) {
      return null;
    }
    return paramc.gV(paramString);
  }
  
  protected final int getLayoutId()
  {
    return R.i.at_someone_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(this.mTitle);
    setBackBtn(new BizChatAtSomeoneUI.1(this));
    this.drn = new n((byte)0);
    this.drn.weq = new BizChatAtSomeoneUI.2(this);
    a(this.drn);
    this.fry = ((ListView)findViewById(R.h.chatroom_member_lv));
    j localj = new j();
    c localc = this.veo;
    String[] arrayOfString = null;
    if (!ah.bl(this.drm))
    {
      arrayOfString = this.drm.split(";");
      y.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!ah.bl(this.drl)) {
      localObject = ah.h(this.drl.split(";"));
    }
    this.ven = new BizChatAtSomeoneUI.a(this, localj, localc, arrayOfString, (List)localObject);
    this.fry.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.vep))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.l.at_all, new Object[] { "" }));
          paramAnonymousAdapterView.putExtra("select_raw_user_name", "notify@all");
        }
        for (;;)
        {
          BizChatAtSomeoneUI.this.setResult(-1, paramAnonymousAdapterView);
          BizChatAtSomeoneUI.this.finish();
          return;
          paramAnonymousView = (j)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          String str = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", str);
        }
      }
    });
    this.fry.setAdapter(this.ven);
    this.fry.setOnScrollListener(new BizChatAtSomeoneUI.4(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.drl = getIntent().getStringExtra("Block_list");
    this.drm = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.idK = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.veo = z.MA().aj(this.idK);
    if (this.veo == null)
    {
      y.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      return;
    }
    if ((this.veo != null) && (this.veo.field_ownerUserId.equals(q.Gj()))) {
      vep = true;
    }
    initView();
  }
  
  protected void onDestroy()
  {
    this.ven.bcS();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.drn != null) {
      this.drn.cJg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */