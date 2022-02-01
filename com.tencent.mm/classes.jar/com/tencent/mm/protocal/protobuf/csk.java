package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csk
  extends ckq
{
  public cxe CtX;
  public String DHP;
  public String DrO;
  public int Eks;
  public ctb Ekt;
  public int dye;
  public LinkedList<csm> gKs;
  
  public csk()
  {
    AppMethodBeat.i(114070);
    this.gKs = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Eks);
      paramVarArgs.e(3, 8, this.gKs);
      if (this.DHP != null) {
        paramVarArgs.d(4, this.DHP);
      }
      if (this.DrO != null) {
        paramVarArgs.d(5, this.DrO);
      }
      if (this.Ekt != null)
      {
        paramVarArgs.kX(6, this.Ekt.computeSize());
        this.Ekt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.dye);
      if (this.CtX != null)
      {
        paramVarArgs.kX(8, this.CtX.computeSize());
        this.CtX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Eks) + f.a.a.a.c(3, 8, this.gKs);
      paramInt = i;
      if (this.DHP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DHP);
      }
      i = paramInt;
      if (this.DrO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DrO);
      }
      paramInt = i;
      if (this.Ekt != null) {
        paramInt = i + f.a.a.a.kW(6, this.Ekt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.dye);
      paramInt = i;
      if (this.CtX != null) {
        paramInt = i + f.a.a.a.kW(8, this.CtX.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.gKs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csk localcsk = (csk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localcsk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localcsk.Eks = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsk.gKs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localcsk.DHP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localcsk.DrO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsk.Ekt = ((ctb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localcsk.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114071);
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
          localcsk.CtX = ((cxe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csk
 * JD-Core Version:    0.7.0.1
 */