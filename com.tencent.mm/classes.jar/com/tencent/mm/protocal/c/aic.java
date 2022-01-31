package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aic
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String auI;
  public LinkedList<String> tfs = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.auI != null) {
        paramVarArgs.d(1, this.auI);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.d(3, 1, this.tfs);
      return 0;
    }
    if (paramInt == 1) {
      if (this.auI == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = d.a.a.b.b.a.e(1, this.auI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.app_id);
      }
      return i + d.a.a.a.c(3, 1, this.tfs);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tfs.clear();
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
        aic localaic = (aic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaic.auI = locala.xpH.readString();
          return 0;
        case 2: 
          localaic.app_id = locala.xpH.readString();
          return 0;
        }
        localaic.tfs.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aic
 * JD-Core Version:    0.7.0.1
 */