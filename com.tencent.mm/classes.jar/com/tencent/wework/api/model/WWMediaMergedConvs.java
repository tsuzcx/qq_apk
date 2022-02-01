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
  public List<WWMediaConversation> bNN;
  
  public WWMediaMergedConvs()
  {
    AppMethodBeat.i(106546);
    this.bNN = new ArrayList();
    AppMethodBeat.o(106546);
  }
  
  public final boolean a(WWMediaConversation paramWWMediaConversation)
  {
    AppMethodBeat.i(106547);
    if (paramWWMediaConversation.checkArgs())
    {
      this.bNN.add(paramWWMediaConversation);
      AppMethodBeat.o(106547);
      return true;
    }
    AppMethodBeat.o(106547);
    return false;
  }
  
  public final void brA(String paramString)
  {
    AppMethodBeat.i(199011);
    super.brA(paramString);
    Iterator localIterator = this.bNN.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).brA(paramString);
    }
    AppMethodBeat.o(199011);
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106548);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106548);
      return false;
    }
    if ((this.bNN == null) || (this.bNN.size() == 0))
    {
      AppMethodBeat.o(106548);
      return false;
    }
    Iterator localIterator = this.bNN.iterator();
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
    AppMethodBeat.i(199009);
    int j = paramBundle.getInt("_wwmergedconvobject_messageslen");
    int i = 0;
    if (i < j)
    {
      BaseMessage localBaseMessage = BaseMessage.bB(paramBundle.getBundle("_wwmergedconvobject_messages".concat(String.valueOf(i))));
      if ((localBaseMessage != null) && ((localBaseMessage instanceof WWMediaConversation))) {
        this.bNN.add((WWMediaConversation)localBaseMessage);
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
    AppMethodBeat.o(199009);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(199012);
    super.setContext(paramContext);
    Iterator localIterator = this.bNN.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).setContext(paramContext);
    }
    AppMethodBeat.o(199012);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106549);
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.bNN.size());
    int i = 0;
    while (i < this.bNN.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages".concat(String.valueOf(i)), BaseMessage.a((BaseMessage)this.bNN.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
    AppMethodBeat.o(106549);
  }
  
  public final void v(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(199010);
    Iterator localIterator = this.bNN.iterator();
    while (localIterator.hasNext()) {
      ((BaseMessage)localIterator.next()).v(paramIntent, paramString);
    }
    AppMethodBeat.o(199010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */