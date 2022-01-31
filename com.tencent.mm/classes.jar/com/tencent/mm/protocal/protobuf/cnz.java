package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnz
  extends com.tencent.mm.bv.a
{
  public int pIx;
  public int pIy;
  public String wQh;
  public String wQi;
  public String wQj;
  public String wQr;
  public com.tencent.mm.bv.b xWN;
  public boolean xWO;
  public LinkedList<String> xWP;
  public String xWQ;
  
  public cnz()
  {
    AppMethodBeat.i(62584);
    this.xWP = new LinkedList();
    AppMethodBeat.o(62584);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62585);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xWN == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(62585);
        throw paramVarArgs;
      }
      if (this.wQr != null) {
        paramVarArgs.e(1, this.wQr);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.xWN != null) {
        paramVarArgs.c(4, this.xWN);
      }
      paramVarArgs.aS(5, this.xWO);
      paramVarArgs.e(6, 1, this.xWP);
      if (this.wQh != null) {
        paramVarArgs.e(7, this.wQh);
      }
      if (this.xWQ != null) {
        paramVarArgs.e(8, this.xWQ);
      }
      if (this.wQj != null) {
        paramVarArgs.e(9, this.wQj);
      }
      if (this.wQi != null) {
        paramVarArgs.e(10, this.wQi);
      }
      AppMethodBeat.o(62585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQr == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQr) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.xWN != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xWN);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 1) + e.a.a.a.c(6, 1, this.xWP);
      paramInt = i;
      if (this.wQh != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wQh);
      }
      i = paramInt;
      if (this.xWQ != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xWQ);
      }
      paramInt = i;
      if (this.wQj != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wQj);
      }
      i = paramInt;
      if (this.wQi != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wQi);
      }
      AppMethodBeat.o(62585);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xWP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xWN == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(62585);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62585);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cnz localcnz = (cnz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62585);
          return -1;
        case 1: 
          localcnz.wQr = locala.CLY.readString();
          AppMethodBeat.o(62585);
          return 0;
        case 2: 
          localcnz.pIy = locala.CLY.sl();
          AppMethodBeat.o(62585);
          return 0;
        case 3: 
          localcnz.pIx = locala.CLY.sl();
          AppMethodBeat.o(62585);
          return 0;
        case 4: 
          localcnz.xWN = locala.CLY.eqS();
          AppMethodBeat.o(62585);
          return 0;
        case 5: 
          localcnz.xWO = locala.CLY.emu();
          AppMethodBeat.o(62585);
          return 0;
        case 6: 
          localcnz.xWP.add(locala.CLY.readString());
          AppMethodBeat.o(62585);
          return 0;
        case 7: 
          localcnz.wQh = locala.CLY.readString();
          AppMethodBeat.o(62585);
          return 0;
        case 8: 
          localcnz.xWQ = locala.CLY.readString();
          AppMethodBeat.o(62585);
          return 0;
        case 9: 
          localcnz.wQj = locala.CLY.readString();
          AppMethodBeat.o(62585);
          return 0;
        }
        localcnz.wQi = locala.CLY.readString();
        AppMethodBeat.o(62585);
        return 0;
      }
      AppMethodBeat.o(62585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnz
 * JD-Core Version:    0.7.0.1
 */