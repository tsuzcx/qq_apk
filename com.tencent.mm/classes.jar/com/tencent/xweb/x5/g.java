package com.tencent.xweb.x5;

import com.jg.JgClassChecked;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.m;

@JgClassChecked(author=30, fComment="checked", lastDate="20171020", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
{
  public static m a(WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse == null) {
      return null;
    }
    return new m(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.x5.g
 * JD-Core Version:    0.7.0.1
 */