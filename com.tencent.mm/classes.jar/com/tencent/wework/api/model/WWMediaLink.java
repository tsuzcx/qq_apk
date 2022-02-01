package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaLink
  extends WWMediaMessage.WWMediaObject
{
  public String thumbUrl;
  public String webpageUrl;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106542);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106542);
      return false;
    }
    if ((this.webpageUrl != null) && (this.webpageUrl.length() != 0) && (this.webpageUrl.length() <= 10240))
    {
      AppMethodBeat.o(106542);
      return true;
    }
    AppMethodBeat.o(106542);
    return false;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106543);
    paramBundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
    paramBundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLink
 * JD-Core Version:    0.7.0.1
 */