package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "orderId", "", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "(ILcom/tencent/mm/storage/Contact;ILcom/tencent/mm/storage/ChatRoomMember;)V", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "compareContent", "", "getCompareContent", "()Ljava/lang/String;", "setCompareContent", "(Ljava/lang/String;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;)V", "getOrderId", "()I", "showHead", "", "getShowHead", "()Z", "setShowHead", "(Z)V", "showHeadCode", "getShowHeadCode", "setShowHeadCode", "(I)V", "showHeadDisplay", "getShowHeadDisplay", "setShowHeadDisplay", "getType", "compareTo", "other", "getAtSomeoneDisplayShowHead", "getItemType", "getUniqueId", "isSameContent", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.mvvmlist.a<f>
{
  private final int FWs;
  j FWt;
  boolean FWu;
  private int FWv;
  String FWw;
  private String FWx;
  private final aj HuK;
  i aenF;
  final au contact;
  final int type;
  
  public f(int paramInt1, au paramau, int paramInt2, aj paramaj)
  {
    AppMethodBeat.i(254176);
    this.FWs = paramInt1;
    this.contact = paramau;
    this.type = paramInt2;
    this.HuK = paramaj;
    this.FWv = 127;
    this.FWw = "";
    this.FWx = "";
    if (this.type == 2)
    {
      if (Util.isNullOrNil(this.contact.field_conRemark)) {
        break label258;
      }
      paramau = this.contact.field_conRemark;
      paramaj = paramau;
      if (Util.isNullOrNil(paramau)) {
        paramaj = this.contact.aSU();
      }
      if (paramaj != null) {
        break label287;
      }
      paramau = "";
      label113:
      paramaj = d.aEj(paramau);
      if (paramaj != null) {
        break label323;
      }
      paramaj = locala;
      label128:
      if (paramaj == null)
      {
        paramaj = (f)this;
        paramaj.aBe(s.X(paramau, ""));
        locala = com.tencent.mm.plugin.ac.a.a.MnU;
        paramaj.FWv = a.a.aPL(paramau);
      }
      this.FWx = s.X(this.FWx, paramau);
      paramInt1 = this.FWv;
      if ((paramInt1 < 65) || (paramInt1 > 90)) {
        break label393;
      }
    }
    label258:
    label393:
    for (paramaj = String.valueOf((char)paramInt1);; paramaj = "#")
    {
      this.FWw = paramaj;
      Log.i("jiaminchen.AtSomeone", "uiDisplayName:" + paramau + " showHeadCode:" + (char)this.FWv + " compareContent:" + this.FWx);
      AppMethodBeat.o(254176);
      return;
      paramau = this.HuK;
      if (paramau == null)
      {
        paramau = null;
        break;
      }
      paramau = paramau.getDisplayName(this.contact.field_username);
      break;
      label287:
      paramau = Locale.getDefault();
      s.s(paramau, "getDefault()");
      paramau = paramaj.toUpperCase(paramau);
      s.s(paramau, "(this as java.lang.String).toUpperCase(locale)");
      if (paramau == null)
      {
        paramau = "";
        break label113;
      }
      break label113;
      label323:
      Object localObject = Locale.getDefault();
      s.s(localObject, "getDefault()");
      localObject = paramaj.toUpperCase((Locale)localObject);
      s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
      paramaj = locala;
      if (localObject == null) {
        break label128;
      }
      aBe(s.X((String)localObject, ""));
      paramaj = com.tencent.mm.plugin.ac.a.a.MnU;
      this.FWv = a.a.aPL((String)localObject);
      paramaj = ah.aiuX;
      break label128;
    }
  }
  
  private void aBe(String paramString)
  {
    AppMethodBeat.i(254188);
    s.u(paramString, "<set-?>");
    this.FWx = paramString;
    AppMethodBeat.o(254188);
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(254199);
    Object localObject = super.clone();
    AppMethodBeat.o(254199);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(254193);
    String str = this.contact.field_username + '-' + this.type;
    AppMethodBeat.o(254193);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.f
 * JD-Core Version:    0.7.0.1
 */