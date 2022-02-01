package com.tencent.xweb.x5;

import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171020", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
{
  public static com.tencent.xweb.WebResourceResponse a(com.tencent.smtt.export.external.interfaces.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(153858);
    if (paramWebResourceResponse == null)
    {
      AppMethodBeat.o(153858);
      return null;
    }
    paramWebResourceResponse = new com.tencent.xweb.WebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
    AppMethodBeat.o(153858);
    return paramWebResourceResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.g
 * JD-Core Version:    0.7.0.1
 */