package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class bc
  implements TbsReaderView.ReaderCallback
{
  bc(TbsReaderPredownload paramTbsReaderPredownload) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(139366);
    switch (paramInteger.intValue())
    {
    default: 
      AppMethodBeat.o(139366);
      return;
    }
    int i = ((Integer)paramObject1).intValue();
    if (5014 == i)
    {
      AppMethodBeat.o(139366);
      return;
    }
    if (5013 == i) {
      this.a.a(0);
    }
    for (;;)
    {
      this.a.j = "";
      this.a.a(3, 100);
      break;
      if (i == 0) {
        this.a.a(0);
      } else {
        this.a.a(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.bc
 * JD-Core Version:    0.7.0.1
 */