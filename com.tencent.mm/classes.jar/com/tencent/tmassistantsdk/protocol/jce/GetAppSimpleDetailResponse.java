package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class GetAppSimpleDetailResponse
  extends JceStruct
{
  static ArrayList<AppSimpleDetail> cache_appSimpleDetailList;
  public ArrayList<AppSimpleDetail> appSimpleDetailList = null;
  public int ret = 0;
  
  public GetAppSimpleDetailResponse() {}
  
  public GetAppSimpleDetailResponse(int paramInt, ArrayList<AppSimpleDetail> paramArrayList)
  {
    this.ret = paramInt;
    this.appSimpleDetailList = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102291);
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_appSimpleDetailList == null)
    {
      cache_appSimpleDetailList = new ArrayList();
      AppSimpleDetail localAppSimpleDetail = new AppSimpleDetail();
      cache_appSimpleDetailList.add(localAppSimpleDetail);
    }
    this.appSimpleDetailList = ((ArrayList)paramJceInputStream.read(cache_appSimpleDetailList, 1, true));
    AppMethodBeat.o(102291);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102290);
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.appSimpleDetailList, 1);
    AppMethodBeat.o(102290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailResponse
 * JD-Core Version:    0.7.0.1
 */