package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.o;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ah.f, com.tencent.mm.ai.n
{
  private static boolean dnY = false;
  private SharedPreferences dnD = null;
  private boolean dnG = false;
  private int dnI;
  private boolean dnJ;
  private com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      o.ON().bR(paramAnonymousInt);
    }
  });
  boolean dnS = false;
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private SignaturePreference dnr;
  private ContactListExpandPreference dnv;
  private CheckBoxPreference dnw;
  private CheckBoxPreference dnx;
  private CheckBoxPreference dny;
  private int fromScene;
  private long idK;
  private String idQ;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ai.a.j mWL = null;
  private d.a veU = new BizChatroomInfoUI.3(this);
  private c veo = null;
  private String vfR;
  private boolean vfS = false;
  private boolean vfT;
  private boolean vfU;
  private int vfV;
  private com.tencent.mm.ai.a.j vfW = null;
  
  private void A(boolean paramBoolean, int paramInt)
  {
    this.vfV = this.veo.field_bitFlag;
    this.vfR = this.veo.field_chatName;
    Object localObject;
    if (this.vfS)
    {
      if (paramBoolean) {
        localObject = this.veo;
      }
      for (((c)localObject).field_bitFlag |= paramInt;; ((c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        y.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.veo.field_bitFlag) });
        z.MA().b(this.veo);
        localObject = new io();
        ((io)localObject).sCI = this.veo.field_bizChatServId;
        ((io)localObject).sCK = this.veo.field_bitFlag;
        z.MG();
        com.tencent.mm.ai.a.h.a(this.veo.field_brandUserName, (io)localObject, this);
        return;
        localObject = this.veo;
      }
    }
    if (paramBoolean) {
      localObject = this.mWL;
    }
    for (((com.tencent.mm.ai.a.j)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.ai.a.j)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      z.MC().b(this.mWL);
      this.veo.field_bitFlag = this.mWL.field_bitFlag;
      z.MA().b(this.veo);
      break;
      localObject = this.mWL;
    }
  }
  
  private void a(ir paramir1, ir paramir2)
  {
    y.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramir1 == null) {}
    for (String str = getString(R.l.room_del_member);; str = getString(R.l.adding_room_mem))
    {
      z.MG();
      paramir1 = com.tencent.mm.ai.a.h.a(this.veo.field_brandUserName, this.veo.field_bizChatServId, paramir1, paramir2, this);
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(this, str, true, new BizChatroomInfoUI.6(this, paramir1));
      return;
    }
  }
  
  private boolean adl(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ir localir = new ir();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = z.MC().bY(str);
          if (paramString != null) {
            break label243;
          }
          paramString = new com.tencent.mm.ai.a.j();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.idQ;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.vfW == null) {
            break label246;
          }
          localObject = this.vfW.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!z.MC().b(paramString)) {
            z.MC().a(paramString);
          }
          localObject = new iq();
          ((iq)localObject).sCP = paramString.field_userId;
          localir.sCQ.add(localObject);
          i += 1;
          continue;
        }
        a(localir, null);
        return true;
      }
      catch (JSONException paramString)
      {
        y.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        y.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      return false;
      label243:
      continue;
      label246:
      Object localObject = null;
    }
  }
  
  private void bsC()
  {
    y.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vfS) {
      this.vfU = this.veo.il(16);
    }
    for (this.vfV = this.veo.field_bitFlag;; this.vfV = this.mWL.field_bitFlag)
    {
      if (this.dny != null) {
        this.dnD.edit().putBoolean("room_placed_to_the_top", this.vfU).commit();
      }
      this.dnn.notifyDataSetChanged();
      return;
      this.vfU = this.mWL.il(16);
    }
  }
  
  private void cBJ()
  {
    y.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vfS)
    {
      this.vfT = this.veo.il(8);
      this.vfV = this.veo.field_bitFlag;
      if (!this.vfT) {
        break label153;
      }
      if (this.dnx != null) {
        this.dnD.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      this.vfT = this.mWL.il(8);
      this.vfV = this.mWL.field_bitFlag;
      break;
      label153:
      if (this.dnx != null) {
        this.dnD.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void cBK()
  {
    y.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.veo.field_chatName = this.vfR;
    this.veo.field_bitFlag = this.vfV;
    this.dnJ = this.veo.il(1);
    this.vfT = this.veo.il(8);
    this.vfU = this.veo.il(16);
    z.MA().b(this.veo);
    if (this.vfU) {
      z.MB().bO(this.veo.field_bizChatLocalId);
    }
    for (;;)
    {
      this.dnD.edit().putBoolean("room_placed_to_the_top", z.MB().bN(this.veo.field_bizChatLocalId)).commit();
      xt();
      xr();
      bsC();
      cBJ();
      Toast.makeText(this, getString(R.l.room_change_fail), 0).show();
      return;
      if (!this.vfU) {
        z.MB().bP(this.veo.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    if (this.dnv != null)
    {
      xt();
      updateTitle();
      xr();
      xp();
      cBJ();
      bsC();
      this.dnv.notifyChanged();
    }
    this.dnn.notifyDataSetChanged();
  }
  
  private void updateTitle()
  {
    if (this.vfS)
    {
      this.dnI = e.bQ(this.idK);
      if (this.dnI != 0)
      {
        setMMTitle(getString(R.l.fmt_chatting_title_group, new Object[] { getString(R.l.roominfo_name), Integer.valueOf(this.dnI) }));
        return;
      }
    }
    setMMTitle(getString(R.l.roominfo_name));
  }
  
  private void xp()
  {
    Object localObject;
    if (this.dnv != null)
    {
      if (!this.vfS) {
        break label70;
      }
      localObject = e.bR(this.idK);
      if (localObject == null) {
        break label95;
      }
      this.dnI = ((List)localObject).size();
      label36:
      if (this.dnI > 1) {
        break label103;
      }
      this.dnv.lS(true).lT(false);
    }
    for (;;)
    {
      this.dnv.s(this.idQ, (List)localObject);
      return;
      label70:
      localObject = new LinkedList();
      ((List)localObject).add(this.veo.field_bizChatServId);
      break;
      label95:
      this.dnI = 0;
      break label36;
      label103:
      this.dnv.lS(true).lT(this.dnG);
    }
  }
  
  private void xr()
  {
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vfS)
    {
      this.dnJ = this.veo.il(1);
      this.vfV = this.veo.field_bitFlag;
      if (!this.dnJ) {
        break label148;
      }
      setTitleMuteIconVisibility(0);
      if (this.dnw != null) {
        this.dnD.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      this.dnJ = this.mWL.il(1);
      this.vfV = this.mWL.field_bitFlag;
      break;
      label148:
      setTitleMuteIconVisibility(8);
      if (this.dnw != null) {
        this.dnD.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void xt()
  {
    if (this.dnr != null)
    {
      if (xu())
      {
        Object localObject2 = this.veo.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        y.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.dnr;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(R.l.settings_signature_empty);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
      }
    }
    else {
      return;
    }
    this.dnr.setSummary(getString(R.l.room_has_no_topic));
  }
  
  private boolean xu()
  {
    if (this.vfS) {}
    for (String str = this.veo.field_chatName; bk.bl(str); str = this.mWL.field_userName) {
      return false;
    }
    return true;
  }
  
  public final com.tencent.mm.ai.a.j GG(int paramInt)
  {
    if ((this.dnv.getItem(paramInt) instanceof com.tencent.mm.ai.a.j)) {
      return (com.tencent.mm.ai.a.j)this.dnv.getItem(paramInt);
    }
    return null;
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final void a(int paramInt, m paramm)
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    Object localObject;
    if (paramm.getType() == 1355)
    {
      localObject = ((com.tencent.mm.ai.a.n)paramm).MT();
      paramm = ((com.tencent.mm.ai.a.n)paramm).MU();
      localObject = z.MA().lp(((rx)localObject).sPX.sYQ.sCI);
      if (localObject == null) {
        Toast.makeText(ae.getContext(), getString(R.l.room_change_add_memberfail), 0).show();
      }
    }
    do
    {
      do
      {
        return;
        if (this.fromScene == 2)
        {
          localIntent = new Intent();
          localIntent.addFlags(67108864);
          localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
          localIntent.putExtra("Contact_User", paramm.sCO);
          localIntent.putExtra("biz_chat_chat_id", ((c)localObject).field_bizChatLocalId);
          com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", localIntent);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("Chat_User", paramm.sCO);
        localIntent.putExtra("key_biz_chat_id", ((c)localObject).field_bizChatLocalId);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        localIntent.putExtra("key_is_biz_chat", true);
        localIntent.setClass(this, ChattingUI.class);
        startActivity(localIntent);
        return;
        if (paramm.getType() != 1356) {
          break;
        }
      } while (paramInt == 0);
      cBK();
      return;
    } while ((paramm.getType() != 1353) || (paramInt < 0) || (this.mWL == null));
    this.mWL = z.MC().bY(this.mWL.field_userId);
    onDataChanged();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramf = paramPreference.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = "";
      if (xu()) {
        paramf = this.veo.field_chatName;
      }
      com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(R.l.room_name_modify), paramf, "", 32, new BizChatroomInfoUI.9(this, paramf));
    }
    do
    {
      return false;
      if (paramf.equals("room_notify_new_msg"))
      {
        if (!this.dnJ) {}
        for (bool1 = true;; bool1 = false)
        {
          this.dnJ = bool1;
          A(this.dnJ, 1);
          xr();
          return false;
        }
      }
      if (paramf.equals("room_placed_to_the_top"))
      {
        if (!this.vfU) {}
        for (;;)
        {
          this.vfU = bool1;
          A(this.vfU, 16);
          if (!this.vfU) {
            break;
          }
          z.MB().bO(this.veo.field_bizChatLocalId);
          return false;
          bool1 = false;
        }
        z.MB().bP(this.veo.field_bizChatLocalId);
        return false;
      }
      if (paramf.equals("room_del_quit"))
      {
        y.d("MicroMsg.BizChatroomInfoUI", " quit " + this.idK);
        com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(R.l.del_room_mem_comfirm), "", new BizChatroomInfoUI.10(this), null);
        return false;
      }
    } while (!paramf.equals("room_save_to_contact"));
    if (!this.vfT) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.vfT = bool1;
      A(this.vfT, 8);
      cBJ();
      return false;
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    Object localObject = this.veo.field_ownerUserId;
    this.dnI = this.veo.MN().size();
    if (bk.bl((String)localObject))
    {
      this.dnG = false;
      y.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.dnv = ((ContactListExpandPreference)this.dnn.add("roominfo_contact_anchor"));
      this.dnv.a(this.dnn, this.dnv.mKey);
      this.dnr = ((SignaturePreference)this.dnn.add("room_name"));
      this.dnw = ((CheckBoxPreference)this.dnn.add("room_notify_new_msg"));
      this.dny = ((CheckBoxPreference)this.dnn.add("room_placed_to_the_top"));
      this.dnx = ((CheckBoxPreference)this.dnn.add("room_save_to_contact"));
      localObject = this.dnv;
      boolean bool = this.vfS;
      if (((ContactListExpandPreference)localObject).sdh != null) {
        ((ContactListExpandPreference)localObject).sdh.scu.scI = bool;
      }
      localObject = this.dnv;
      bool = this.dnG;
      if (((ContactListExpandPreference)localObject).sdh != null) {
        ((ContactListExpandPreference)localObject).sdh.scu.scH = bool;
      }
      if (!this.dnG) {
        break label405;
      }
      this.dnv.lS(true).lT(true);
    }
    for (;;)
    {
      this.dnv.WI(this.veo.field_ownerUserId);
      this.dnv.cmO();
      this.dnv.cmR();
      if (!this.vfS)
      {
        this.dnn.bJ("room_save_to_contact", true);
        this.dnn.bJ("room_name", true);
        this.dnn.bJ("room_del_quit", true);
      }
      cBJ();
      bsC();
      xr();
      if (this.dnv != null)
      {
        this.lwE.setOnScrollListener(this.dnR);
        this.dnv.a(this.dnR);
        this.dnv.a(new BizChatroomInfoUI.7(this));
      }
      setBackBtn(new BizChatroomInfoUI.8(this));
      return;
      this.dnG = ((String)localObject).equals(z.MC().bZ(this.idQ));
      break;
      label405:
      this.dnv.lS(true).lT(false);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      String str;
      boolean bool;
      if (paramIntent != null)
      {
        y.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
        str = paramIntent.getString("enterprise_members");
        y.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
        if (this.vfS) {
          bool = adl(str);
        }
      }
      while (!bool)
      {
        Toast.makeText(this, getString(R.l.room_change_add_memberfail), 0).show();
        return;
        zp localzp = new zp();
        c localc = new c();
        if (this.vfW != null) {}
        for (paramIntent = this.vfW.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.idQ;
          if (!e.a(localc, str, this.mWL.field_userId, localzp)) {
            break label241;
          }
          z.MG();
          paramIntent = com.tencent.mm.ai.a.h.a(this.idQ, localzp, this);
          getString(R.l.app_tip);
          this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.adding_room_mem), true, new BizChatroomInfoUI.5(this, paramIntent));
          bool = true;
          break;
        }
        label241:
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    z.MA().a(this.veU, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.idQ = getIntent().getStringExtra("Chat_User");
    this.idK = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.veo = z.MA().aj(this.idK);
    this.vfR = this.veo.field_chatName;
    this.vfS = e.lr(this.veo.field_bizChatServId);
    if (!this.vfS) {
      this.mWL = z.MC().bY(this.veo.field_bizChatServId);
    }
    this.vfW = z.MC().lB(this.idQ);
    initView();
    if ((this.veo == null) || (this.veo.field_bizChatServId == null) || (this.idQ == null)) {
      return;
    }
    if (this.veo.isGroup())
    {
      z.MG();
      com.tencent.mm.ai.a.h.ar(this.veo.field_bizChatServId, this.idQ);
      return;
    }
    z.MG();
    com.tencent.mm.ai.a.h.a(this.veo.field_bizChatServId, this.idQ, this);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.ui.g.a.dismiss();
    com.tencent.mm.ui.g.a.dismiss();
    z.MA().a(this.veU);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    xt();
    updateTitle();
    xr();
    bsC();
    cBJ();
    xp();
    this.dnn.notifyDataSetChanged();
    super.onResume();
    if (!this.dnS)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bk.bl(str))
      {
        int i = this.dnn.adf(str);
        setSelection(i - 3);
        new ah().postDelayed(new BizChatroomInfoUI.4(this, i), 10L);
      }
      this.dnS = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm == null)
    {
      y.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      return;
    }
    y.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    this.dnI = e.bQ(this.idK);
    y.d("MicroMsg.BizChatroomInfoUI", "now is " + this.dnI);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      cBK();
      return;
    }
    paramm.getType();
  }
  
  public final int xj()
  {
    return R.o.bizchat_roominfo_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */