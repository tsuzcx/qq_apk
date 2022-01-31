package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs
  extends WWMediaMessage.WWMediaObject
{
  public List<WWMediaConversation> BCM;
  
  public WWMediaMergedConvs()
  {
    AppMethodBeat.i(80505);
    this.BCM = new ArrayList();
    AppMethodBeat.o(80505);
  }
  
  public final boolean a(WWMediaConversation paramWWMediaConversation)
  {
    AppMethodBeat.i(80506);
    if (paramWWMediaConversation.checkArgs())
    {
      this.BCM.add(paramWWMediaConversation);
      AppMethodBeat.o(80506);
      return true;
    }
    AppMethodBeat.o(80506);
    return false;
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(80507);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(80507);
      return false;
    }
    if ((this.BCM == null) || (this.BCM.size() == 0))
    {
      AppMethodBeat.o(80507);
      return false;
    }
    Iterator localIterator = this.BCM.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((BaseMessage)localIterator.next()).checkArgs());
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(80507);
      return bool;
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80508);
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.BCM.size());
    int i = 0;
    while (i < this.BCM.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages".concat(String.valueOf(i)), BaseMessage.b((BaseMessage)this.BCM.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
    AppMethodBeat.o(80508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */