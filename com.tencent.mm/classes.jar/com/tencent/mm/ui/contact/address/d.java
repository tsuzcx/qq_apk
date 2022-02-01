package com.tencent.mm.ui.contact.address;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.livelist.a;
import com.tencent.mm.plugin.livelist.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "", "showHeadCode", "(Lcom/tencent/mm/storage/Contact;II)V", "compareContentList", "Ljava/util/ArrayList;", "", "getCompareContentList", "()Ljava/util/ArrayList;", "setCompareContentList", "(Ljava/util/ArrayList;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "showDivider", "", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showHead", "getShowHead", "setShowHead", "getShowHeadCode", "()I", "showHeadDisplay", "getShowHeadDisplay", "()Ljava/lang/String;", "setShowHeadDisplay", "(Ljava/lang/String;)V", "getType", "clone", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "app_release"})
public final class d
  extends a
{
  boolean WGl;
  final int WGm;
  String WGn;
  private ArrayList<String> Xxd;
  final as contact;
  boolean tBr;
  final int type;
  
  public d(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266950);
    this.contact = paramas;
    this.type = paramInt1;
    this.WGm = paramInt2;
    this.WGn = "";
    this.tBr = true;
    this.Xxd = new ArrayList(5);
    paramas = this.contact.apk();
    if (paramas != null) {
      if (!n.ba((CharSequence)paramas))
      {
        paramInt1 = 1;
        if (paramInt1 != 1) {
          break label138;
        }
        paramas = this.contact.apk();
      }
    }
    for (;;)
    {
      Object localObject1 = this.Xxd;
      Object localObject2;
      if (paramas != null)
      {
        localObject2 = Locale.getDefault();
        p.j(localObject2, "Locale.getDefault()");
        if (paramas == null)
        {
          paramas = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(266950);
          throw paramas;
          paramInt1 = 0;
          break;
          label138:
          paramas = this.contact.api();
          if (paramas != null)
          {
            if (!n.ba((CharSequence)paramas)) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 != 1) {
                break label718;
              }
              paramas = this.contact.api();
              break;
            }
          }
          paramas = "";
          continue;
        }
        paramas = paramas.toUpperCase((Locale)localObject2);
        p.j(paramas, "(this as java.lang.String).toUpperCase(locale)");
        if (paramas != null) {
          break label715;
        }
      }
      paramas = "";
      label301:
      label706:
      label709:
      label715:
      for (;;)
      {
        ((ArrayList)localObject1).add(paramas);
        paramas = this.contact.apg();
        if (paramas != null) {
          if (!n.ba((CharSequence)paramas))
          {
            paramInt1 = 1;
            if (paramInt1 != 1) {
              break label301;
            }
            paramas = this.contact.apg();
          }
        }
        for (;;)
        {
          localObject1 = this.Xxd;
          if (paramas != null)
          {
            localObject2 = Locale.getDefault();
            p.j(localObject2, "Locale.getDefault()");
            if (paramas == null)
            {
              paramas = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(266950);
              throw paramas;
              paramInt1 = 0;
              break;
              paramas = this.contact.api();
              if (paramas != null)
              {
                if (!n.ba((CharSequence)paramas)) {}
                for (paramInt1 = 1;; paramInt1 = 0)
                {
                  if (paramInt1 != 1) {
                    break label709;
                  }
                  paramas = this.contact.api();
                  break;
                }
              }
              paramas = "";
              continue;
            }
            paramas = paramas.toUpperCase((Locale)localObject2);
            p.j(paramas, "(this as java.lang.String).toUpperCase(locale)");
            if (paramas != null) {
              break label706;
            }
          }
          paramas = "";
          for (;;)
          {
            ((ArrayList)localObject1).add(paramas);
            localObject2 = this.Xxd;
            paramas = this.contact.api();
            if (paramas != null)
            {
              localObject1 = Locale.getDefault();
              p.j(localObject1, "Locale.getDefault()");
              if (paramas == null)
              {
                paramas = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(266950);
                throw paramas;
              }
              localObject1 = paramas.toUpperCase((Locale)localObject1);
              p.j(localObject1, "(this as java.lang.String).toUpperCase(locale)");
              paramas = (as)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramas = "";
            }
            ((ArrayList)localObject2).add(paramas);
            localObject2 = this.Xxd;
            paramas = this.contact.getNickname();
            if (paramas != null)
            {
              localObject1 = Locale.getDefault();
              p.j(localObject1, "Locale.getDefault()");
              if (paramas == null)
              {
                paramas = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(266950);
                throw paramas;
              }
              localObject1 = paramas.toUpperCase((Locale)localObject1);
              p.j(localObject1, "(this as java.lang.String).toUpperCase(locale)");
              paramas = (as)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramas = "";
            }
            ((ArrayList)localObject2).add(paramas);
            localObject2 = this.Xxd;
            paramas = this.contact.getUsername();
            if (paramas != null)
            {
              localObject1 = Locale.getDefault();
              p.j(localObject1, "Locale.getDefault()");
              if (paramas == null)
              {
                paramas = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(266950);
                throw paramas;
              }
              localObject1 = paramas.toUpperCase((Locale)localObject1);
              p.j(localObject1, "(this as java.lang.String).toUpperCase(locale)");
              paramas = (as)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramas = "";
            }
            ((ArrayList)localObject2).add(paramas);
            paramas = c.Xxa;
            p.k(this, "item");
            paramas = MMApplicationContext.getContext();
            if (this.WGm == 123)
            {
              paramas = "#";
              this.WGn = paramas;
              AppMethodBeat.o(266950);
              return;
            }
            if (this.WGm == 32) {}
            for (paramas = paramas.getString(R.l.eny);; paramas = String.valueOf((char)this.WGm))
            {
              p.j(paramas, "if (item.showHeadCode ==….toString()\n            }");
              break;
            }
          }
          paramas = "";
        }
      }
      label718:
      paramas = "";
    }
  }
  
  public final int bAQ()
  {
    return this.type;
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(266947);
    p.k(paramb, "other");
    if ((paramb instanceof d))
    {
      if ((p.h(this.contact, ((d)paramb).contact)) && (this.WGl == ((d)paramb).WGl) && (p.h(this.WGn, ((d)paramb).WGn)) && (this.tBr == ((d)paramb).tBr) && (this.WGm == ((d)paramb).WGm))
      {
        AppMethodBeat.o(266947);
        return true;
      }
      AppMethodBeat.o(266947);
      return false;
    }
    AppMethodBeat.o(266947);
    return false;
  }
  
  public final b eLO()
  {
    AppMethodBeat.i(266948);
    Object localObject = new d(this.contact, this.type, this.WGm);
    ((d)localObject).WGl = this.WGl;
    ((d)localObject).tBr = this.tBr;
    ((d)localObject).WGn = this.WGn;
    ((d)localObject).Xxd = this.Xxd;
    localObject = (b)localObject;
    AppMethodBeat.o(266948);
    return localObject;
  }
  
  public final String eLP()
  {
    AppMethodBeat.i(266946);
    String str = this.contact.getUsername() + '-' + this.type;
    AppMethodBeat.o(266946);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.d
 * JD-Core Version:    0.7.0.1
 */