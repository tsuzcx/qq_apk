package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs
  extends WWMediaMessage.WWMediaObject
{
  public List<WWMediaConversation> MLs;
  
  public WWMediaMergedConvs()
  {
    AppMethodBeat.i(106546);
    this.MLs = new ArrayList();
    AppMethodBeat.o(106546);
  }
  
  public final boolean a(WWMediaConversation paramWWMediaConversation)
  {
    AppMethodBeat.i(106547);
    if (paramWWMediaConversation.checkArgs())
    {
      this.MLs.add(paramWWMediaConversation);
      AppMethodBeat.o(106547);
      return true;
    }
    AppMethodBeat.o(106547);
    return false;
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106548);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106548);
      return false;
    }
    if ((this.MLs == null) || (this.MLs.size() == 0))
    {
      AppMethodBeat.o(106548);
      return false;
    }
    Iterator localIterator = this.MLs.iterator();
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
    AppMethodBeat.i(193332);
    int j = paramBundle.getInt("_wwmergedconvobject_messageslen");
    int i = 0;
    if (i < j)
    {
      BaseMessage localBaseMessage = BaseMessage.bo(paramBundle.getBundle("_wwmergedconvobject_messages".concat(String.valueOf(i))));
      if ((localBaseMessage != null) && ((localBaseMessage instanceof WWMediaConversation))) {
        this.MLs.add((WWMediaConversation)localBaseMessage);
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
    AppMethodBeat.o(193332);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106549);
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.MLs.size());
    int i = 0;
    while (i < this.MLs.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages".concat(String.valueOf(i)), BaseMessage.b((BaseMessage)this.MLs.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
    AppMethodBeat.o(106549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */