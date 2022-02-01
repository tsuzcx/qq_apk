package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eke
  extends dpc
{
  public String Njj;
  public int Njq;
  public LinkedList<cfl> Njr;
  public cfl Njs;
  public int pTZ;
  public String pUa;
  public String subtitle;
  public String title;
  
  public eke()
  {
    AppMethodBeat.i(72603);
    this.Njr = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.e(5, this.subtitle);
      }
      paramVarArgs.aM(6, this.Njq);
      paramVarArgs.e(7, 8, this.Njr);
      if (this.Njs != null)
      {
        paramVarArgs.ni(8, this.Njs.computeSize());
        this.Njs.writeFields(paramVarArgs);
      }
      if (this.Njj != null) {
        paramVarArgs.e(9, this.Njj);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.subtitle);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Njq) + g.a.a.a.c(7, 8, this.Njr);
      paramInt = i;
      if (this.Njs != null) {
        paramInt = i + g.a.a.a.nh(8, this.Njs.computeSize());
      }
      i = paramInt;
      if (this.Njj != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Njj);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Njr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eke localeke = (eke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeke.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localeke.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localeke.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localeke.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localeke.subtitle = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localeke.Njq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeke.Njr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeke.Njs = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localeke.Njj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eke
 * JD-Core Version:    0.7.0.1
 */