package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class tw
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String detail;
  public LinkedList<String> sQI = new LinkedList();
  public String sQJ;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.d(4, 1, this.sQI);
      if (this.detail != null) {
        paramVarArgs.d(5, this.detail);
      }
      if (this.sQJ != null) {
        paramVarArgs.d(6, this.sQJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label454;
      }
    }
    label454:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.desc);
      }
      i += d.a.a.a.c(4, 1, this.sQI);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.detail);
      }
      i = paramInt;
      if (this.sQJ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sQJ);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sQI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localtw.title = locala.xpH.readString();
          return 0;
        case 2: 
          localtw.url = locala.xpH.readString();
          return 0;
        case 3: 
          localtw.desc = locala.xpH.readString();
          return 0;
        case 4: 
          localtw.sQI.add(locala.xpH.readString());
          return 0;
        case 5: 
          localtw.detail = locala.xpH.readString();
          return 0;
        }
        localtw.sQJ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.tw
 * JD-Core Version:    0.7.0.1
 */