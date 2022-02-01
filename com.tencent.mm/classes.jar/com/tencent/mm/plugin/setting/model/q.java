package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.protocal.protobuf.fuo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/model/SettingsAuthUtils;", "", "()V", "TAG", "", "filterAuthScopeList", "", "Lcom/tencent/mm/protocal/protobuf/UserAuthItem;", "authItems", "getAuthScopeIconResId", "", "scope", "joinAuthScopeDescString", "separator", "joinAuthScopeString", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q PnN;
  
  static
  {
    AppMethodBeat.i(298545);
    PnN = new q();
    AppMethodBeat.o(298545);
  }
  
  public static final String G(String paramString, List<? extends fuo> paramList)
  {
    AppMethodBeat.i(298522);
    s.u(paramString, "separator");
    if (paramList == null)
    {
      AppMethodBeat.o(298522);
      return "";
    }
    paramString = p.a((Iterable)ko(paramList), (CharSequence)paramString, null, null, 0, null, (b)a.PnO, 30);
    AppMethodBeat.o(298522);
    return paramString;
  }
  
  public static final String H(String paramString, List<? extends fuo> paramList)
  {
    AppMethodBeat.i(298526);
    s.u(paramString, "separator");
    if (paramList == null)
    {
      AppMethodBeat.o(298526);
      return "";
    }
    paramString = p.a((Iterable)paramList, (CharSequence)paramString, null, null, 0, null, (b)b.PnP, 30);
    AppMethodBeat.o(298526);
    return paramString;
  }
  
  public static final int aVC(String paramString)
  {
    AppMethodBeat.i(298540);
    s.u(paramString, "scope");
    paramString = paramString.toLowerCase(Locale.ROOT);
    s.s(paramString, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      int i = b.h.icons_outlined_dot;
      AppMethodBeat.o(298540);
      return i;
      if (paramString.equals("snsapi_contact_message"))
      {
        label268:
        i = b.h.icons_outlined_chats;
        AppMethodBeat.o(298540);
        return i;
        if (paramString.equals("group_sns_userinfo"))
        {
          label288:
          i = b.h.icons_outlined_avatar;
          AppMethodBeat.o(298540);
          return i;
          if (paramString.equals("snsapi_channels_userinfo"))
          {
            label308:
            do
            {
              i = b.h.icons_outlined_channel;
              AppMethodBeat.o(298540);
              return i;
            } while (paramString.equals("snsapi_channels_livestream"));
            if ((goto 248) && (paramString.equals("snsapi_favorites")))
            {
              i = b.h.icons_outlined_subscriptions;
              AppMethodBeat.o(298540);
              return i;
              if (paramString.equals("group_sns_friend"))
              {
                i = b.h.icons_outlined_group_detail;
                AppMethodBeat.o(298540);
                return i;
                if (paramString.equals("snsapi_runtime_sdk")) {
                  do
                  {
                    do
                    {
                      do
                      {
                        i = b.h.icons_outlined_me;
                        AppMethodBeat.o(298540);
                        return i;
                        if (!paramString.equals("webapi_getuserwxphone_group")) {
                          break;
                        }
                        i = b.h.icons_outlined_cellphone;
                        AppMethodBeat.o(298540);
                        return i;
                        if (!paramString.equals("snsapi_friend")) {
                          break;
                        }
                        i = b.h.icons_outlined_group_detail;
                        AppMethodBeat.o(298540);
                        return i;
                        if (paramString.equals("snsapi_channels_useraccountinfo")) {
                          break label308;
                        }
                        if ((goto 248) || (!paramString.equals("snsapi_contact"))) {
                          break;
                        }
                        i = b.h.icons_outlined_group_detail;
                        AppMethodBeat.o(298540);
                        return i;
                        if (!paramString.equals("snsapi_health_realtime")) {
                          break;
                        }
                        do
                        {
                          do
                          {
                            i = b.h.icons_outlined_sports;
                            AppMethodBeat.o(298540);
                            return i;
                          } while (paramString.equals("snsapi_health_industry"));
                          if ((goto 248) || (!paramString.equals("snsapi_fav"))) {
                            break;
                          }
                          i = b.h.icons_outlined_favorites;
                          AppMethodBeat.o(298540);
                          return i;
                          if (paramString.equals("group_sns_login")) {
                            break label288;
                          }
                          if ((goto 248) || (!paramString.equals("snsapi_wxaapp_info"))) {
                            break;
                          }
                          i = b.h.icons_outlined_mini_program2;
                          AppMethodBeat.o(298540);
                          return i;
                        } while (paramString.equals("snsapi_health_history"));
                        if ((goto 248) || (!paramString.equals("snsapi_stickers"))) {
                          break;
                        }
                        i = b.h.icons_outlined_sticker;
                        AppMethodBeat.o(298540);
                        return i;
                        if (paramString.equals("snsapi_userinfo")) {
                          break label288;
                        }
                        break;
                        if (paramString.equals("snsapi_profile")) {
                          break label288;
                        }
                        break;
                      } while (paramString.equals("snsapi_channels_watchstream"));
                      break;
                      if (paramString.equals("snsapi_message")) {
                        break label268;
                      }
                      break;
                    } while (paramString.equals("snsapi_runtime_apk"));
                    break;
                    if (paramString.equals("snsapi_login")) {
                      break label288;
                    }
                    if ((goto 248) || (!paramString.equals("snsapi_channels_recommend"))) {
                      break;
                    }
                    i = b.h.icons_outlined_music;
                    AppMethodBeat.o(298540);
                    return i;
                  } while (paramString.equals("snsapi_getruntimecode"));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static final List<fuo> ko(List<? extends fuo> paramList)
  {
    AppMethodBeat.i(298531);
    s.u(paramList, "authItems");
    List localList = (List)new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      fuo localfuo = (fuo)localIterator.next();
      CharSequence localCharSequence = (CharSequence)localfuo.Poo;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (localHashSet.contains(localfuo.Poo))) {
          break label133;
        }
        localHashSet.add(localfuo.Poo);
        localList.add(localfuo);
        break;
      }
      label133:
      Log.w("MicroMsg.SettingsAuthUtils", "filterAuthScopeList scope_desc exist and ignore: " + localfuo.scope + ", " + localfuo.Poo);
    }
    Log.i("MicroMsg.SettingsAuthUtils", "filterAuthScopeList final size: " + localList.size() + ", origin size: " + paramList.size());
    AppMethodBeat.o(298531);
    return localList;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userAuthItem", "Lcom/tencent/mm/protocal/protobuf/UserAuthItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<fuo, CharSequence>
  {
    public static final a PnO;
    
    static
    {
      AppMethodBeat.i(298564);
      PnO = new a();
      AppMethodBeat.o(298564);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userAuthItem", "Lcom/tencent/mm/protocal/protobuf/UserAuthItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<fuo, CharSequence>
  {
    public static final b PnP;
    
    static
    {
      AppMethodBeat.i(298557);
      PnP = new b();
      AppMethodBeat.o(298557);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.q
 * JD-Core Version:    0.7.0.1
 */