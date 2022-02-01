package com.tencent.mm.ui.mvvm.item;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "", "showHeadCode", "(Lcom/tencent/mm/storage/Contact;II)V", "compareContentList", "Ljava/util/ArrayList;", "", "getCompareContentList", "()Ljava/util/ArrayList;", "setCompareContentList", "(Ljava/util/ArrayList;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "isAlwaysCheck", "", "()Z", "setAlwaysCheck", "(Z)V", "isCollapse", "setCollapse", "isMultiSelect", "setMultiSelect", "isSelect", "setSelect", "keywordIndex", "getKeywordIndex", "()I", "setKeywordIndex", "(I)V", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "multiSearch", "getMultiSearch", "setMultiSearch", "recommendOrderId", "getRecommendOrderId", "setRecommendOrderId", "searchOrderId", "getSearchOrderId", "setSearchOrderId", "showDivider", "getShowDivider", "setShowDivider", "showHead", "getShowHead", "setShowHead", "getShowHeadCode", "showHeadDisplay", "getShowHeadDisplay", "()Ljava/lang/String;", "setShowHeadDisplay", "(Ljava/lang/String;)V", "getType", "compareTo", "other", "compareType", "type1", "type2", "getItemType", "getUniqueId", "isSameContent", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.mvvmlist.a<b>
{
  public static final b.a afAM;
  public j FWt;
  public boolean FWu;
  public final int FWv;
  String FWw;
  public boolean Gxy;
  public int afAC;
  public boolean afAD;
  public int afAN;
  public boolean afAO;
  public int afAP;
  public boolean afey;
  private ArrayList<String> afjl;
  public final au contact;
  public o rpp;
  public final int type;
  boolean wFP;
  public boolean wwJ;
  
  static
  {
    AppMethodBeat.i(250546);
    afAM = new b.a((byte)0);
    AppMethodBeat.o(250546);
  }
  
  public b(au paramau, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250544);
    this.contact = paramau;
    this.type = paramInt1;
    this.FWv = paramInt2;
    this.Gxy = true;
    this.FWw = "";
    this.wFP = true;
    this.afjl = new ArrayList(5);
    paramau = this.contact.field_conRemarkPYFull;
    if (paramau != null) {
      if (!n.bp((CharSequence)paramau))
      {
        paramInt1 = 1;
        if (paramInt1 != 1) {
          break label310;
        }
        paramInt1 = 1;
        label89:
        if (paramInt1 == 0) {
          break label315;
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
        label114:
        localArrayList.add(paramau);
        paramau = this.contact.field_conRemark;
        if (paramau == null) {
          break label417;
        }
        if (n.bp((CharSequence)paramau)) {
          break label412;
        }
        paramInt1 = 1;
        label145:
        if (paramInt1 != 1) {
          break label417;
        }
        paramInt1 = 1;
        label152:
        if (paramInt1 == 0) {
          break label422;
        }
        paramau = this.contact.field_conRemark;
      }
      for (;;)
      {
        localArrayList = this.afjl;
        if (paramau == null)
        {
          paramau = "";
          label177:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.aJu();
          if (paramau != null) {
            break label519;
          }
          paramau = "";
          label205:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.field_nickname;
          if (paramau != null) {
            break label560;
          }
          paramau = "";
          label233:
          localArrayList.add(paramau);
          localArrayList = this.afjl;
          paramau = this.contact.field_username;
          if (paramau != null) {
            break label601;
          }
          paramau = "";
          label261:
          localArrayList.add(paramau);
          paramau = a.afAL;
          s.u(this, "item");
          paramau = MMApplicationContext.getContext();
          if (this.FWv != 123) {
            break label642;
          }
          paramau = "#";
        }
        for (;;)
        {
          this.FWw = paramau;
          AppMethodBeat.o(250544);
          return;
          paramInt1 = 0;
          break;
          label310:
          paramInt1 = 0;
          break label89;
          label315:
          paramau = this.contact.aJu();
          if (paramau != null) {
            if (!n.bp((CharSequence)paramau))
            {
              paramInt1 = 1;
              label339:
              if (paramInt1 != 1) {
                break label366;
              }
            }
          }
          label366:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label686;
            }
            paramau = this.contact.aJu();
            break;
            paramInt1 = 0;
            break label339;
          }
          Object localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label114;
          }
          paramau = "";
          break label114;
          label412:
          paramInt1 = 0;
          break label145;
          label417:
          paramInt1 = 0;
          break label152;
          label422:
          paramau = this.contact.aJu();
          if (paramau != null) {
            if (!n.bp((CharSequence)paramau))
            {
              paramInt1 = 1;
              label446:
              if (paramInt1 != 1) {
                break label473;
              }
            }
          }
          label473:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label680;
            }
            paramau = this.contact.aJu();
            break;
            paramInt1 = 0;
            break label446;
          }
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label177;
          }
          paramau = "";
          break label177;
          label519:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label205;
          }
          paramau = "";
          break label205;
          label560:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label233;
          }
          paramau = "";
          break label233;
          label601:
          localObject = Locale.getDefault();
          s.s(localObject, "getDefault()");
          localObject = paramau.toUpperCase((Locale)localObject);
          s.s(localObject, "(this as java.lang.String).toUpperCase(locale)");
          paramau = (au)localObject;
          if (localObject != null) {
            break label261;
          }
          paramau = "";
          break label261;
          label642:
          if (this.FWv == 32)
          {
            paramau = paramau.getString(a.h.select_contact_favour_contact_catalog_name);
            s.s(paramau, "{\n                contex…talog_name)\n            }");
          }
          else
          {
            paramau = String.valueOf((char)this.FWv);
          }
        }
        label680:
        paramau = "";
      }
      label686:
      paramau = "";
    }
  }
  
  public final void bCq(String paramString)
  {
    AppMethodBeat.i(250551);
    s.u(paramString, "<set-?>");
    this.FWw = paramString;
    AppMethodBeat.o(250551);
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(250563);
    Object localObject = super.clone();
    AppMethodBeat.o(250563);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(250554);
    String str = this.contact.field_username;
    s.s(str, "contact.username");
    str = b.a.bg(str, this.type, this.afAC);
    AppMethodBeat.o(250554);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.item.b
 * JD-Core Version:    0.7.0.1
 */