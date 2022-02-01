package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avi
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b SDI;
  public long SGM;
  public int SHG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201202);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SGM);
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      if (this.SDI != null) {
        paramVarArgs.c(4, this.SDI);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(5, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.SHG);
      AppMethodBeat.o(201202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SGM);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RLN);
      }
      i = paramInt;
      if (this.SDI != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.SDI);
      }
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(5, this.RLM.computeSize());
      }
      i = g.a.a.b.b.a.bM(6, this.SHG);
      AppMethodBeat.o(201202);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avi localavi = (avi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201202);
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
            localavi.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201202);
          return 0;
        case 2: 
          localavi.SGM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(201202);
          return 0;
        case 3: 
          localavi.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(201202);
          return 0;
        case 4: 
          localavi.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(201202);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localavi.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201202);
          return 0;
        }
        localavi.SHG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(201202);
        return 0;
      }
      AppMethodBeat.o(201202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avi
 * JD-Core Version:    0.7.0.1
 */