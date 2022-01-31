package com.tencent.wework.api.model;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs
  extends WWMediaMessage.WWMediaObject
{
  public List<WWMediaConversation> xgf = new ArrayList();
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while ((this.xgf == null) || (this.xgf.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.xgf.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((BaseMessage)localIterator.next()).checkArgs());
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.xgf.size());
    int i = 0;
    while (i < this.xgf.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages" + i, BaseMessage.b((BaseMessage)this.xgf.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */