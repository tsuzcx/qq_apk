package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class GetAppSimpleDetailRequest
  extends JceStruct
{
  static ArrayList<AppDetailParam> cache_appReqList;
  public ArrayList<AppDetailParam> appReqList = null;
  
  public GetAppSimpleDetailRequest() {}
  
  public GetAppSimpleDetailRequest(ArrayList<AppDetailParam> paramArrayList)
  {
    this.appReqList = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102289);
    if (cache_appReqList == null)
    {
      cache_appReqList = new ArrayList();
      AppDetailParam localAppDetailParam = new AppDetailParam();
      cache_appReqList.add(localAppDetailParam);
    }
    this.appReqList = ((ArrayList)paramJceInputStream.read(cache_appReqList, 0, false));
    AppMethodBeat.o(102289);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102288);
    if (this.appReqList != null) {
      paramJceOutputStream.write(this.appReqList, 0);
    }
    AppMethodBeat.o(102288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailRequest
 * JD-Core Version:    0.7.0.1
 */