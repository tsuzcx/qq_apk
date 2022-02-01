package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mk
  extends com.tencent.mm.bx.a
{
  public String CIK;
  public int CIL;
  public String CIO;
  public String CIR;
  public String CIZ;
  public LinkedList<ml> CJa;
  public int CJb;
  public String nvC;
  public int ver;
  
  public mk()
  {
    AppMethodBeat.i(191086);
    this.CJa = new LinkedList();
    AppMethodBeat.o(191086);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIR != null) {
        paramVarArgs.d(1, this.CIR);
      }
      if (this.nvC != null) {
        paramVarArgs.d(2, this.nvC);
      }
      paramVarArgs.aR(3, this.ver);
      if (this.CIK != null) {
        paramVarArgs.d(4, this.CIK);
      }
      if (this.CIZ != null) {
        paramVarArgs.d(5, this.CIZ);
      }
      paramVarArgs.aR(6, this.CIL);
      if (this.CIO != null) {
        paramVarArgs.d(7, this.CIO);
      }
      paramVarArgs.e(8, 8, this.CJa);
      paramVarArgs.aR(9, this.CJb);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIR == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nvC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nvC);
      }
      i += f.a.a.b.b.a.bA(3, this.ver);
      paramInt = i;
      if (this.CIK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CIK);
      }
      i = paramInt;
      if (this.CIZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CIZ);
      }
      i += f.a.a.b.b.a.bA(6, this.CIL);
      paramInt = i;
      if (this.CIO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CIO);
      }
      i = f.a.a.a.c(8, 8, this.CJa);
      int j = f.a.a.b.b.a.bA(9, this.CJb);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CJa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mk localmk = (mk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localmk.CIR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localmk.nvC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localmk.ver = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localmk.CIK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localmk.CIZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localmk.CIL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localmk.CIO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ml();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmk.CJa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localmk.CJb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */