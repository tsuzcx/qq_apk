package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezs
  extends dyl
{
  public int TaU;
  public cky Tba;
  public ckz Tbb;
  public int fOv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72622);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TaU);
      paramVarArgs.aY(3, this.fOv);
      if (this.Tba != null)
      {
        paramVarArgs.oE(4, this.Tba.computeSize());
        this.Tba.writeFields(paramVarArgs);
      }
      if (this.Tbb != null)
      {
        paramVarArgs.oE(5, this.Tbb.computeSize());
        this.Tbb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TaU) + g.a.a.b.b.a.bM(3, this.fOv);
      paramInt = i;
      if (this.Tba != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tba.computeSize());
      }
      i = paramInt;
      if (this.Tbb != null) {
        i = paramInt + g.a.a.a.oD(5, this.Tbb.computeSize());
      }
      AppMethodBeat.o(72622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ezs localezs = (ezs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72622);
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
            localezs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        case 2: 
          localezs.TaU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72622);
          return 0;
        case 3: 
          localezs.fOv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72622);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cky();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cky)localObject2).parseFrom((byte[])localObject1);
            }
            localezs.Tba = ((cky)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckz)localObject2).parseFrom((byte[])localObject1);
          }
          localezs.Tbb = ((ckz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      AppMethodBeat.o(72622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezs
 * JD-Core Version:    0.7.0.1
 */