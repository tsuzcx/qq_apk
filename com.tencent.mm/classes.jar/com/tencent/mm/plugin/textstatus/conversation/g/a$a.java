package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements bx.a
{
  public final au JE(String paramString)
  {
    AppMethodBeat.i(291092);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; (i != 0) || (!au.bwY(paramString)); i = 0)
    {
      AppMethodBeat.o(291092);
      return null;
    }
    localObject1 = a.Tjq;
    h localh = a.bdK(paramString);
    if (localh == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new au();
      }
      ((au)localObject2).setUsername(paramString);
      AppMethodBeat.o(291092);
      return localObject2;
    }
    Object localObject2 = new au();
    localObject1 = (CharSequence)localh.field_nickname;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
    {
      i = 1;
      label124:
      if (i == 0) {
        break label190;
      }
    }
    label190:
    for (localObject1 = "​";; localObject1 = localh.field_nickname)
    {
      ((au)localObject2).setNickname((String)localObject1);
      ((au)localObject2).acDG = ((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)localh.field_nickname));
      ((au)localObject2).setUsername(localh.field_userName);
      ((au)localObject2).maN = ((au)localObject2).systemRowid;
      localObject1 = localObject2;
      break;
      i = 0;
      break label124;
    }
  }
  
  public final void a(bx parambx, au paramau) {}
  
  public final int b(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(291102);
    if (paramau == null)
    {
      AppMethodBeat.o(291102);
      return -1;
    }
    if (!au.bwY(paramau.field_username))
    {
      AppMethodBeat.o(291102);
      return -1;
    }
    AppMethodBeat.o(291102);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.a.a
 * JD-Core Version:    0.7.0.1
 */