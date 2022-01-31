package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bxr
  extends com.tencent.mm.bv.a
{
  public String key;
  public String nyy;
  public LinkedList<String> tNJ = new LinkedList();
  public String value;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.key == null) {
        throw new b("Not all required fields were included: key");
      }
      if (this.value == null) {
        throw new b("Not all required fields were included: value");
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      if (this.nyy != null) {
        paramVarArgs.d(3, this.nyy);
      }
      paramVarArgs.d(4, 1, this.tNJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label408;
      }
    }
    label408:
    for (int i = d.a.a.b.b.a.e(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.value);
      }
      i = paramInt;
      if (this.nyy != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nyy);
      }
      return i + d.a.a.a.c(4, 1, this.tNJ);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tNJ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.key == null) {
          throw new b("Not all required fields were included: key");
        }
        if (this.value != null) {
          break;
        }
        throw new b("Not all required fields were included: value");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bxr localbxr = (bxr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbxr.key = locala.xpH.readString();
          return 0;
        case 2: 
          localbxr.value = locala.xpH.readString();
          return 0;
        case 3: 
          localbxr.nyy = locala.xpH.readString();
          return 0;
        }
        localbxr.tNJ.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxr
 * JD-Core Version:    0.7.0.1
 */