package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class arh
  extends ckq
{
  public String CtT;
  public String CtU;
  public int CtV;
  public cxe CtX;
  public String DrO;
  public String dyc;
  public String dyd;
  public int dye;
  public String nsI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114010);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114010);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dyc != null) {
        paramVarArgs.d(2, this.dyc);
      }
      paramVarArgs.aR(3, this.dye);
      if (this.nsI != null) {
        paramVarArgs.d(4, this.nsI);
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
      if (this.DrO != null) {
        paramVarArgs.d(9, this.DrO);
      }
      if (this.CtX != null)
      {
        paramVarArgs.kX(10, this.CtX.computeSize());
        this.CtX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyc);
      }
      i += f.a.a.b.b.a.bA(3, this.dye);
      paramInt = i;
      if (this.nsI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nsI);
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
      i += f.a.a.b.b.a.bA(8, this.CtV);
      paramInt = i;
      if (this.DrO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DrO);
      }
      i = paramInt;
      if (this.CtX != null) {
        i = paramInt + f.a.a.a.kW(10, this.CtX.computeSize());
      }
      AppMethodBeat.o(114010);
      return i;
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
          AppMethodBeat.o(114010);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arh localarh = (arh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114010);
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
            localarh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114010);
          return 0;
        case 2: 
          localarh.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 3: 
          localarh.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114010);
          return 0;
        case 4: 
          localarh.nsI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 5: 
          localarh.dyd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 6: 
          localarh.CtT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 7: 
          localarh.CtU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 8: 
          localarh.CtV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114010);
          return 0;
        case 9: 
          localarh.DrO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114010);
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
          localarh.CtX = ((cxe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      AppMethodBeat.o(114010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arh
 * JD-Core Version:    0.7.0.1
 */