package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ak
  extends ckq
{
  public String CtT;
  public String CtU;
  public int CtV;
  public int CtW;
  public cxe CtX;
  public String dyc;
  public String dyd;
  public int dye;
  public String nsI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nsI != null) {
        paramVarArgs.d(2, this.nsI);
      }
      paramVarArgs.aR(3, this.dye);
      if (this.dyc != null) {
        paramVarArgs.d(4, this.dyc);
      }
      if (this.dyd != null) {
        paramVarArgs.d(5, this.dyd);
      }
      if (this.CtT != null) {
        paramVarArgs.d(6, this.CtT);
      }
      if (this.CtU != null) {
        paramVarArgs.d(7, this.CtU);
      }
      paramVarArgs.aR(8, this.CtV);
      paramVarArgs.aR(9, this.CtW);
      if (this.CtX != null)
      {
        paramVarArgs.kX(10, this.CtX.computeSize());
        this.CtX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nsI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nsI);
      }
      i += f.a.a.b.b.a.bA(3, this.dye);
      paramInt = i;
      if (this.dyc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyc);
      }
      i = paramInt;
      if (this.dyd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dyd);
      }
      paramInt = i;
      if (this.CtT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CtT);
      }
      i = paramInt;
      if (this.CtU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CtU);
      }
      i = i + f.a.a.b.b.a.bA(8, this.CtV) + f.a.a.b.b.a.bA(9, this.CtW);
      paramInt = i;
      if (this.CtX != null) {
        paramInt = i + f.a.a.a.kW(10, this.CtX.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dyc == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localak.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localak.nsI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localak.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localak.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localak.dyd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localak.CtT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localak.CtU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localak.CtV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localak.CtW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localak.CtX = ((cxe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */