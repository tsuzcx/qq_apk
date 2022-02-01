package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ffg
  extends esc
{
  public int Qtb;
  public int YIq;
  public String abET;
  public int vgN;
  public LinkedList<ffe> vgO;
  
  public ffg()
  {
    AppMethodBeat.i(125819);
    this.vgO = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      if (this.abET != null) {
        paramVarArgs.g(3, this.abET);
      }
      paramVarArgs.bS(4, this.vgN);
      paramVarArgs.e(5, 8, this.vgO);
      paramVarArgs.bS(6, this.Qtb);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq);
      paramInt = i;
      if (this.abET != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abET);
      }
      i = i.a.a.b.b.a.cJ(4, this.vgN);
      int j = i.a.a.a.c(5, 8, this.vgO);
      int k = i.a.a.b.b.a.cJ(6, this.Qtb);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffg localffg = (ffg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localffg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localffg.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localffg.abET = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localffg.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffe)localObject2).parseFrom((byte[])localObject1);
            }
            localffg.vgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localffg.Qtb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffg
 * JD-Core Version:    0.7.0.1
 */