package com.tencent.mm.ui.contact.address;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "", "showHeadCode", "(Lcom/tencent/mm/storage/Contact;II)V", "compareContentList", "Ljava/util/ArrayList;", "", "getCompareContentList", "()Ljava/util/ArrayList;", "setCompareContentList", "(Ljava/util/ArrayList;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "nickname", "", "getNickname", "()Ljava/lang/CharSequence;", "setNickname", "(Ljava/lang/CharSequence;)V", "openIMWording", "getOpenIMWording", "()Ljava/lang/String;", "setOpenIMWording", "(Ljava/lang/String;)V", "showDivider", "", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showHead", "getShowHead", "setShowHead", "getShowHeadCode", "()I", "showHeadDisplay", "getShowHeadDisplay", "setShowHeadDisplay", "getType", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.mvvmlist.a<d>
{
  boolean FWu;
  final int FWv;
  String FWw;
  private ArrayList<String> afjl;
  String afjm;
  final au contact;
  CharSequence pJG;
  final int type;
  boolean wFP;
  
  public d(au paramau, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253256);
    this.contact = paramau;
    this.type = paramInt1;
    this.FWv = paramInt2;
    this.FWw = "";
    this.wFP = true;
    this.afjl = new ArrayList(5);
    this.afjm = "";
    paramau = aa.b(this.contact);
    paramau = p.d(MMApplicationContext.getContext(), (CharSequence)paramau, com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.NormalTextSize));
    s.s(paramau, "spanForSmiley(MMApplicat… R.dimen.NormalTextSize))");
    this.pJG = ((CharSequence)paramau);
    paramau = this.contact.field_conRemarkPYFull;
    if (paramau != null) {
      if (!n.bp((CharSequence)paramau))
      {
        paramInt1 = 1;
        if (paramInt1 != 1) {
          break label425;
        }
        paramInt1 = 1;
        label132:
        if (paramInt1 == 0) {
          break label430;
        }
        paramau = this.contact.field_conRemarkPYFull;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.afjl;
      if (paramau == null)
      {
        paramau = "";
        label157:
        localArrayList.add(paramau);
        paramau = this.contact.field_conRemark;
        if (paramau == null) {
          break label532;
        }
        if (n.bp((CharSequence)paramau)) {
          break label527;
        }
        paramInt1 = 1;
        label188:
        if (paramInt1 != 1) {
          break label532;
        }
        paramInt1 = 1;
        label195:
        if (paramInt1 == 0) {
          break label537;
        }
        paramau = this.contact.field_conRemark;
      }
      for (;;)
      {
        localArrayList = this.afjl;
        if (paramau == null)
        {
          paramau = "";
          label220:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.aJu();
          if (paramau != null) {
            break label634;
          }
          paramau = "";
          label248:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.field_nickname;
          if (paramau != null) {
            break label675;
          }
          paramau = "";
          label276:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.field_username;
          if (paramau != null) {
            break label716;
          }
          paramau = "";
          label304:
          localArrayList.add(paramau);
          paramau = c.afjd;
          s.u(this, "item");
          paramau = MMApplicationContext.getContext();
          if (this.FWv != 123) {
            break label757;
          }
          paramau = "#";
          label337:
          this.FWw = paramau;
          if (au.bwO(this.contact.field_username))
          {
            paramau = (e)h.ax(e.class);
            if (paramau != null) {
              break label795;
            }
            paramau = "";
          }
        }
        for (;;)
        {
          this.afjm = paramau;
          if ((!Util.isNullOrNil(this.afjm)) && (s.p("3552365301", this.contact.field_openImAppid))) {
            this.afjm = s.X("@", this.afjm);
          }
          AppMethodBeat.o(253256);
          return;
          paramInt1 = 0;
          break;
          label425:
          paramInt1 = 0;
          break label132;
          label430:
          paramau = this.contact.aJu();
          if (paramau != null) {
            if (!n.bp((CharSequence)paramau))
            {
              paramInt1 = 1;
              label454:
              if (paramInt1 != 1) {
                break label481;
              }
            }
          }
          label481:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label837;
            }
            paramau = this.contact.aJu();
            break;
            paramInt1 = 0;
            break label454;
          }
          Object localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label157;
          }
          paramau = "";
          break label157;
          label527:
          paramInt1 = 0;
          break label188;
          label532:
          paramInt1 = 0;
          break label195;
          label537:
          paramau = this.contact.aJu();
          if (paramau != null) {
            if (!n.bp((CharSequence)paramau))
            {
              paramInt1 = 1;
              label561:
              if (paramInt1 != 1) {
                break label588;
              }
            }
          }
          label588:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label831;
            }
            paramau = this.contact.aJu();
            break;
            paramInt1 = 0;
            break label561;
          }
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label220;
          }
          paramau = "";
          break label220;
          label634:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label248;
          }
          paramau = "";
          break label248;
          label675:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label276;
          }
          paramau = "";
          break label276;
          label716:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label304;
          }
          paramau = "";
          break label304;
          label757:
          if (this.FWv == 32)
          {
            paramau = paramau.getString(R.l.gqy);
            s.s(paramau, "{\n                contex…talog_name)\n            }");
            break label337;
          }
          paramau = String.valueOf((char)this.FWv);
          break label337;
          label795:
          localObject = paramau.cc(this.contact.field_openImAppid, this.contact.field_descWordingId);
          paramau = (au)localObject;
          if (localObject == null) {
            paramau = "";
          }
        }
        label831:
        paramau = "";
      }
      label837:
      paramau = "";
    }
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(253269);
    Object localObject = super.clone();
    AppMethodBeat.o(253269);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(253263);
    String str = this.contact.field_username + '-' + this.type;
    AppMethodBeat.o(253263);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.d
 * JD-Core Version:    0.7.0.1
 */