package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "()V", "alwaysSelectUserSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getAlwaysSelectUserSet", "()Ljava/util/HashSet;", "setAlwaysSelectUserSet", "(Ljava/util/HashSet;)V", "cardUsernameToReceive", "getCardUsernameToReceive", "()Ljava/lang/String;", "setCardUsernameToReceive", "(Ljava/lang/String;)V", "cardUsernameToSend", "getCardUsernameToSend", "setCardUsernameToSend", "createGroupRecommend", "", "getCreateGroupRecommend", "()Z", "setCreateGroupRecommend", "(Z)V", "hasFocus", "getHasFocus", "setHasFocus", "isRecommendToFriend", "setRecommendToFriend", "isSendCard", "setSendCard", "listAttr", "", "getListAttr", "()I", "setListAttr", "(I)V", "listType", "getListType", "setListType", "maxLimitNum", "getMaxLimitNum", "setMaxLimitNum", "menuMode", "getMenuMode", "setMenuMode", "minLimitNum", "getMinLimitNum", "setMinLimitNum", "originQuery", "getOriginQuery", "setOriginQuery", "resultMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "Lkotlin/collections/HashMap;", "getResultMap", "()Ljava/util/HashMap;", "setResultMap", "(Ljava/util/HashMap;)V", "scene", "getScene", "setScene", "searchId", "getSearchId", "setSearchId", "selectUserSet", "getSelectUserSet", "setSelectUserSet", "source", "getSource", "setSource", "subQueryList", "", "getSubQueryList", "()Ljava/util/List;", "setSubQueryList", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", "getAllSelectUsernameList", "nested", "getSelectUsernameList", "isAlwaysSelect", "username", "isCreateChatroomWhenMultiSelect", "isMenuRightUp", "isMultiSelect", "isSearching", "isSelect", "isSelectReturn", "showBizEntrance", "showFaceChat", "showGroupCardItem", "showOpenImHeader", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends BaseState
{
  public String Hte;
  public List<String> Hti;
  public boolean Nxq;
  public HashMap<Integer, m> afAS;
  public int afAV;
  public int afAW;
  public boolean afAX;
  public String afAY;
  public String afAZ;
  public boolean afBa;
  public int afbe;
  public int afhC;
  private HashSet<String> afhc;
  public int afhe;
  public boolean afhx;
  public String mpa;
  public HashSet<String> pJQ;
  public int scene;
  public String source;
  public String title;
  
  public i()
  {
    AppMethodBeat.i(250483);
    this.source = "";
    this.title = "";
    this.afhc = new HashSet();
    this.pJQ = new HashSet();
    this.afhC = 1;
    this.afAY = "";
    this.afAZ = "";
    AppMethodBeat.o(250483);
  }
  
  public final List<String> MR(boolean paramBoolean)
  {
    AppMethodBeat.i(250523);
    Object localObject1 = new HashSet();
    if (!paramBoolean)
    {
      localObject2 = ((Iterable)this.pJQ).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (ab.IQ(str)) {
          ((HashSet)localObject1).addAll((Collection)v.Im(str));
        } else {
          ((HashSet)localObject1).add(str);
        }
      }
    }
    ((HashSet)localObject1).addAll((Collection)this.pJQ);
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((String)((Iterator)localObject2).next());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(250523);
    return localObject1;
  }
  
  public final List<String> MS(boolean paramBoolean)
  {
    AppMethodBeat.i(250530);
    Object localObject1 = new HashSet();
    if (!paramBoolean)
    {
      localObject2 = ((Iterable)this.pJQ).iterator();
      String str;
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (ab.IQ(str)) {
          ((HashSet)localObject1).addAll((Collection)v.Im(str));
        } else {
          ((HashSet)localObject1).add(str);
        }
      }
      localObject2 = ((Iterable)this.afhc).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (ab.IQ(str)) {
          ((HashSet)localObject1).addAll((Collection)v.Im(str));
        } else {
          ((HashSet)localObject1).add(str);
        }
      }
    }
    ((HashSet)localObject1).addAll((Collection)this.pJQ);
    ((HashSet)localObject1).addAll((Collection)this.afhc);
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((String)((Iterator)localObject2).next());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(250530);
    return localObject1;
  }
  
  public final boolean bCr(String paramString)
  {
    AppMethodBeat.i(250510);
    s.u(paramString, "username");
    boolean bool = this.pJQ.contains(paramString);
    AppMethodBeat.o(250510);
    return bool;
  }
  
  public final boolean bCs(String paramString)
  {
    AppMethodBeat.i(250514);
    s.u(paramString, "username");
    boolean bool = this.afhc.contains(paramString);
    AppMethodBeat.o(250514);
    return bool;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(250535);
    Object localObject = super.clone();
    AppMethodBeat.o(250535);
    return localObject;
  }
  
  public final boolean gZe()
  {
    AppMethodBeat.i(250490);
    boolean bool = w.hasAttr(this.afhe, 64);
    AppMethodBeat.o(250490);
    return bool;
  }
  
  public final boolean jBW()
  {
    AppMethodBeat.i(250497);
    boolean bool = w.hasAttr(this.afhe, 16384);
    AppMethodBeat.o(250497);
    return bool;
  }
  
  public final boolean jBX()
  {
    AppMethodBeat.i(250503);
    CharSequence localCharSequence = (CharSequence)this.mpa;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(250503);
      return true;
    }
    AppMethodBeat.o(250503);
    return false;
  }
  
  public final boolean jBY()
  {
    return this.afhC == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.i
 * JD-Core Version:    0.7.0.1
 */