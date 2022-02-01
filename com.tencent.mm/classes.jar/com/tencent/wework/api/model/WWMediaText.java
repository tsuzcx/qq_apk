package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaText
  extends WWMediaMessage.WWMediaObject
{
  public String text;
  
  public WWMediaText() {}
  
  public WWMediaText(String paramString)
  {
    this.text = paramString;
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106555);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106555);
      return false;
    }
    if ((this.text != null) && (this.text.length() != 0) && (this.text.length() <= 10240))
    {
      AppMethodBeat.o(106555);
      return true;
    }
    AppMethodBeat.o(106555);
    return false;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106556);
    paramBundle.putString("_wwtextobject_text", this.text);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaText
 * JD-Core Version:    0.7.0.1
 */