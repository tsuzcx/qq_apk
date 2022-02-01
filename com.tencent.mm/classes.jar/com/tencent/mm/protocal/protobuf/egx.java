package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class egx
  extends dyl
{
  public eae RMM;
  public eae RMN;
  public eae RNM;
  public int Ujn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32441);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RNM != null)
      {
        paramVarArgs.oE(2, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Ujn);
      if (this.RMM != null)
      {
        paramVarArgs.oE(4, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(5, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label789;
      }
    }
    label789:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RNM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RNM.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.Ujn);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(4, this.RMM.computeSize());
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(5, this.RMN.computeSize());
      }
      AppMethodBeat.o(32441);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(32441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egx localegx = (egx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32441);
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
            localegx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localegx.RNM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        case 3: 
          localegx.Ujn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32441);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localegx.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localegx.RMN = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32441);
        return 0;
      }
      AppMethodBeat.o(32441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egx
 * JD-Core Version:    0.7.0.1
 */