package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ett
  extends dyl
{
  public String RMK;
  public String SpT;
  public ckh UvD;
  public int UvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SpT != null) {
        paramVarArgs.f(2, this.SpT);
      }
      if (this.RMK != null) {
        paramVarArgs.f(3, this.RMK);
      }
      if (this.UvD != null)
      {
        paramVarArgs.oE(4, this.UvD.computeSize());
        this.UvD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.UvE);
      AppMethodBeat.o(32471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label597;
      }
    }
    label597:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SpT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SpT);
      }
      i = paramInt;
      if (this.RMK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMK);
      }
      paramInt = i;
      if (this.UvD != null) {
        paramInt = i + g.a.a.a.oD(4, this.UvD.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.UvE);
      AppMethodBeat.o(32471);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ett localett = (ett)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32471);
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
            localett.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        case 2: 
          localett.SpT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 3: 
          localett.RMK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ckh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ckh)localObject2).parseFrom((byte[])localObject1);
            }
            localett.UvD = ((ckh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        }
        localett.UvE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32471);
        return 0;
      }
      AppMethodBeat.o(32471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ett
 * JD-Core Version:    0.7.0.1
 */