package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs
  extends WWMediaMessage.WWMediaObject
{
  public List<WWMediaConversation> dJE;
  
  public WWMediaMergedConvs()
  {
    AppMethodBeat.i(106546);
    this.dJE = new ArrayList();
    AppMethodBeat.o(106546);
  }
  
  public final boolean a(WWMediaConversation paramWWMediaConversation)
  {
    AppMethodBeat.i(106547);
    if (paramWWMediaConversation.checkArgs())
    {
      this.dJE.add(paramWWMediaConversation);
      AppMethodBeat.o(106547);
      return true;
    }
    AppMethodBeat.o(106547);
    return false;
  }
  
  public final void bGY(String paramString)
  {
    AppMethodBeat.i(210644);
    super.bGY(paramString);
    Iterator localIterator = this.dJE.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).bGY(paramString);
    }
    AppMethodBeat.o(210644);
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106548);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106548);
      return false;
    }
    if ((this.dJE == null) || (this.dJE.size() == 0))
    {
      AppMethodBeat.o(106548);
      return false;
    }
    Iterator localIterator = this.dJE.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((BaseMessage)localIterator.next()).checkArgs());
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(106548);
      return bool;
    }
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(210636);
    int j = paramBundle.getInt("_wwmergedconvobject_messageslen");
    int i = 0;
    if (i < j)
    {
      BaseMessage localBaseMessage = BaseMessage.ch(paramBundle.getBundle("_wwmergedconvobject_messages".concat(String.valueOf(i))));
      if ((localBaseMessage != null) && ((localBaseMessage instanceof WWMediaConversation))) {
        this.dJE.add((WWMediaConversation)localBaseMessage);
      }
      for (;;)
      {
        i += 1;
        break;
        StringBuilder localStringBuilder = new StringBuilder("fromBundle ");
        Object localObject = localBaseMessage;
        if (localBaseMessage == null) {
          localObject = "null";
        }
        localStringBuilder.append(localObject);
      }
    }
    super.fromBundle(paramBundle);
    AppMethodBeat.o(210636);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(210651);
    super.setContext(paramContext);
    Iterator localIterator = this.dJE.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).setContext(paramContext);
    }
    AppMethodBeat.o(210651);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106549);
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.dJE.size());
    int i = 0;
    while (i < this.dJE.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages".concat(String.valueOf(i)), BaseMessage.a((BaseMessage)this.dJE.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
    AppMethodBeat.o(106549);
  }
  
  public final void w(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(210639);
    Iterator localIterator = this.dJE.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).w(paramIntent, paramString);
    }
    AppMethodBeat.o(210639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */