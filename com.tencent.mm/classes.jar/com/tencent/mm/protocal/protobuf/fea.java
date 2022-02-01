package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fea
  extends esc
{
  public int NkN;
  public int NkO;
  public gol YLa;
  public String abDD;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125783);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.YLa != null)
      {
        paramVarArgs.qD(4, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      if (this.abDD != null) {
        paramVarArgs.g(5, this.abDD);
      }
      paramVarArgs.bS(6, this.vhJ);
      AppMethodBeat.o(125783);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(4, this.YLa.computeSize());
      }
      i = paramInt;
      if (this.abDD != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abDD);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.vhJ);
      AppMethodBeat.o(125783);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        if (this.YLa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125783);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fea localfea = (fea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125783);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfea.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 2: 
          localfea.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125783);
          return 0;
        case 3: 
          localfea.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125783);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfea.YLa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 5: 
          localfea.abDD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125783);
          return 0;
        }
        localfea.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125783);
        return 0;
      }
      AppMethodBeat.o(125783);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fea
 * JD-Core Version:    0.7.0.1
 */