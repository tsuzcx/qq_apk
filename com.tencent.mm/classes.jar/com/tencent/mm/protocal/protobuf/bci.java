package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bci
  extends dyl
{
  public String RLN;
  public alr SLA;
  public String SNL;
  public String SNM;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229239);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(2, this.RLN);
      }
      if (this.SNL != null) {
        paramVarArgs.f(3, this.SNL);
      }
      if (this.SNM != null) {
        paramVarArgs.f(4, this.SNM);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.SLA != null)
      {
        paramVarArgs.oE(6, this.SLA.computeSize());
        this.SLA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(229239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RLN);
      }
      i = paramInt;
      if (this.SNL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SNL);
      }
      paramInt = i;
      if (this.SNM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SNM);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.SLA != null) {
        paramInt = i + g.a.a.a.oD(6, this.SLA.computeSize());
      }
      AppMethodBeat.o(229239);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229239);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bci localbci = (bci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229239);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbci.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229239);
          return 0;
        case 2: 
          localbci.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229239);
          return 0;
        case 3: 
          localbci.SNL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229239);
          return 0;
        case 4: 
          localbci.SNM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229239);
          return 0;
        case 5: 
          localbci.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229239);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new alr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((alr)localObject2).parseFrom((byte[])localObject1);
          }
          localbci.SLA = ((alr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229239);
        return 0;
      }
      AppMethodBeat.o(229239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bci
 * JD-Core Version:    0.7.0.1
 */