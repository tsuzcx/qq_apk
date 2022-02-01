package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eri
  extends dyl
{
  public eae RQU;
  public String SwW;
  public int Utz;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133203);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SwW != null) {
        paramVarArgs.f(2, this.SwW);
      }
      paramVarArgs.aY(3, this.Utz);
      if (this.vhq != null) {
        paramVarArgs.f(4, this.vhq);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(5, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SwW != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SwW);
      }
      i += g.a.a.b.b.a.bM(3, this.Utz);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.vhq);
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(5, this.RQU.computeSize());
      }
      AppMethodBeat.o(133203);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133203);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eri localeri = (eri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133203);
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
            localeri.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133203);
          return 0;
        case 2: 
          localeri.SwW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133203);
          return 0;
        case 3: 
          localeri.Utz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133203);
          return 0;
        case 4: 
          localeri.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133203);
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
          localeri.RQU = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133203);
        return 0;
      }
      AppMethodBeat.o(133203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eri
 * JD-Core Version:    0.7.0.1
 */