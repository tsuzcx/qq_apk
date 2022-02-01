package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.livelist.b;
import com.tencent.mm.plugin.p.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "orderId", "", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "(ILcom/tencent/mm/storage/Contact;ILcom/tencent/mm/storage/ChatRoomMember;)V", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "compareContent", "", "getCompareContent", "()Ljava/lang/String;", "setCompareContent", "(Ljava/lang/String;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;)V", "getOrderId", "()I", "showHead", "", "getShowHead", "()Z", "setShowHead", "(Z)V", "showHeadCode", "getShowHeadCode", "setShowHeadCode", "(I)V", "showHeadDisplay", "getShowHeadDisplay", "setShowHeadDisplay", "getType", "clone", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "compareTo", "other", "getAtSomeoneDisplayShowHead", "getItemType", "getUniqueId", "isSameContent", "app_release"})
public final class f
  extends com.tencent.mm.plugin.livelist.a
{
  h BHY;
  private final int GdZ;
  private final ah WFW;
  g WGk;
  boolean WGl;
  private int WGm;
  String WGn;
  private String WGo;
  final as contact;
  final int type;
  
  public f(int paramInt1, as paramas, int paramInt2, ah paramah)
  {
    AppMethodBeat.i(289629);
    this.GdZ = paramInt1;
    this.contact = paramas;
    this.type = paramInt2;
    this.WFW = paramah;
    this.WGm = 127;
    this.WGn = "";
    this.WGo = "";
    if (this.type == 2)
    {
      if (!Util.isNullOrNil(this.contact.apg())) {
        paramas = this.contact.apg();
      }
      for (;;)
      {
        paramah = paramas;
        if (Util.isNullOrNil(paramas)) {
          paramah = this.contact.ayr();
        }
        if (paramah == null) {
          break label185;
        }
        paramas = Locale.getDefault();
        p.j(paramas, "Locale.getDefault()");
        if (paramah != null) {
          break;
        }
        paramas = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(289629);
        throw paramas;
        paramas = this.WFW;
        if (paramas != null) {
          paramas = paramas.PJ(this.contact.getUsername());
        } else {
          paramas = null;
        }
      }
      paramas = paramah.toUpperCase(paramas);
      p.j(paramas, "(this as java.lang.String).toUpperCase(locale)");
      if (paramas != null) {
        break label453;
      }
      label185:
      paramas = "";
    }
    label446:
    label453:
    for (;;)
    {
      paramah = d.aHL(paramas);
      Object localObject;
      if (paramah != null)
      {
        localObject = Locale.getDefault();
        p.j(localObject, "Locale.getDefault()");
        if (paramah == null)
        {
          paramas = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(289629);
          throw paramas;
        }
        paramah = paramah.toUpperCase((Locale)localObject);
        p.j(paramah, "(this as java.lang.String).toUpperCase(locale)");
        if (paramah != null)
        {
          this.WGo = (paramah + '');
          localObject = com.tencent.mm.plugin.p.a.a.Ejf;
          this.WGm = a.a.aNg(paramah);
          this.WGo += paramas;
          paramInt1 = this.WGm;
          if ((paramInt1 < 65) || (paramInt1 > 90)) {
            break label446;
          }
        }
      }
      for (paramah = String.valueOf((char)paramInt1);; paramah = "#")
      {
        this.WGn = paramah;
        Log.i("jiaminchen.AtSomeone", "uiDisplayName:" + paramas + " showHeadCode:" + (char)this.WGm + " compareContent:" + this.WGo);
        AppMethodBeat.o(289629);
        return;
        paramah = (f)this;
        paramah.WGo = (paramas + '');
        localObject = com.tencent.mm.plugin.p.a.a.Ejf;
        paramah.WGm = a.a.aNg(paramas);
        break;
      }
    }
  }
  
  public final int bAQ()
  {
    return this.type;
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(289625);
    p.k(paramb, "other");
    if ((paramb instanceof f))
    {
      if ((p.h(this.contact, ((f)paramb).contact)) && (p.h(this.BHY, ((f)paramb).BHY)) && (this.WGl == ((f)paramb).WGl))
      {
        AppMethodBeat.o(289625);
        return true;
      }
      AppMethodBeat.o(289625);
      return false;
    }
    AppMethodBeat.o(289625);
    return false;
  }
  
  public final b eLO()
  {
    AppMethodBeat.i(289626);
    Object localObject = new f(this.GdZ, this.contact, this.type);
    ((f)localObject).WGk = this.WGk;
    ((f)localObject).BHY = this.BHY;
    ((f)localObject).WGl = this.WGl;
    ((f)localObject).WGn = this.WGn;
    localObject = (b)localObject;
    AppMethodBeat.o(289626);
    return localObject;
  }
  
  public final String eLP()
  {
    AppMethodBeat.i(289624);
    String str = this.contact.getUsername() + '-' + this.type;
    AppMethodBeat.o(289624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.f
 * JD-Core Version:    0.7.0.1
 */