package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ccy
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String Title;
  public String Url;
  public String xNn;
  public String xNo;
  public String xNp;
  public int xNq;
  public String xNr;
  public String xNs;
  public String xNt;
  public int xNu;
  public int xNv;
  public int xNw;
  public int xNx;
  public int xNy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124363);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xNn == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(124363);
        throw paramVarArgs;
      }
      if (this.xNn != null) {
        paramVarArgs.e(1, this.xNn);
      }
      if (this.xNo != null) {
        paramVarArgs.e(2, this.xNo);
      }
      if (this.xNp != null) {
        paramVarArgs.e(3, this.xNp);
      }
      paramVarArgs.aO(4, this.Scene);
      paramVarArgs.aO(5, this.xNq);
      if (this.Url != null) {
        paramVarArgs.e(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.e(7, this.Title);
      }
      if (this.xNr != null) {
        paramVarArgs.e(8, this.xNr);
      }
      if (this.xNs != null) {
        paramVarArgs.e(9, this.xNs);
      }
      if (this.xNt != null) {
        paramVarArgs.e(10, this.xNt);
      }
      paramVarArgs.aO(11, this.xNu);
      paramVarArgs.aO(12, this.xNv);
      paramVarArgs.aO(13, this.xNw);
      paramVarArgs.aO(14, this.xNx);
      paramVarArgs.aO(15, this.xNy);
      AppMethodBeat.o(124363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNn == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = e.a.a.b.b.a.f(1, this.xNn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNo != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xNo);
      }
      i = paramInt;
      if (this.xNp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xNp);
      }
      i = i + e.a.a.b.b.a.bl(4, this.Scene) + e.a.a.b.b.a.bl(5, this.xNq);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.Title);
      }
      paramInt = i;
      if (this.xNr != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xNr);
      }
      i = paramInt;
      if (this.xNs != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xNs);
      }
      paramInt = i;
      if (this.xNt != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xNt);
      }
      i = e.a.a.b.b.a.bl(11, this.xNu);
      int j = e.a.a.b.b.a.bl(12, this.xNv);
      int k = e.a.a.b.b.a.bl(13, this.xNw);
      int m = e.a.a.b.b.a.bl(14, this.xNx);
      int n = e.a.a.b.b.a.bl(15, this.xNy);
      AppMethodBeat.o(124363);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xNn == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(124363);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124363);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccy localccy = (ccy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124363);
          return -1;
        case 1: 
          localccy.xNn = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 2: 
          localccy.xNo = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 3: 
          localccy.xNp = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 4: 
          localccy.Scene = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        case 5: 
          localccy.xNq = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        case 6: 
          localccy.Url = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 7: 
          localccy.Title = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 8: 
          localccy.xNr = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 9: 
          localccy.xNs = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 10: 
          localccy.xNt = locala.CLY.readString();
          AppMethodBeat.o(124363);
          return 0;
        case 11: 
          localccy.xNu = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        case 12: 
          localccy.xNv = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        case 13: 
          localccy.xNw = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        case 14: 
          localccy.xNx = locala.CLY.sl();
          AppMethodBeat.o(124363);
          return 0;
        }
        localccy.xNy = locala.CLY.sl();
        AppMethodBeat.o(124363);
        return 0;
      }
      AppMethodBeat.o(124363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */