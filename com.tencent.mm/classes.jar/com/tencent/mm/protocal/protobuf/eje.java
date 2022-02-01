package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eje
  extends dyl
{
  public int CPw;
  public int Cqs;
  public long Id;
  public dwf RJc;
  public eae Uld;
  public eae Ule;
  public int Ulf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Id);
      paramVarArgs.aY(3, this.CPw);
      if (this.Uld != null)
      {
        paramVarArgs.oE(4, this.Uld.computeSize());
        this.Uld.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Cqs);
      if (this.Ule != null)
      {
        paramVarArgs.oE(6, this.Ule.computeSize());
        this.Ule.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.Ulf);
      if (this.RJc != null)
      {
        paramVarArgs.oE(8, this.RJc.computeSize());
        this.RJc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Id) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.Uld != null) {
        paramInt = i + g.a.a.a.oD(4, this.Uld.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Cqs);
      paramInt = i;
      if (this.Ule != null) {
        paramInt = i + g.a.a.a.oD(6, this.Ule.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Ulf);
      paramInt = i;
      if (this.RJc != null) {
        paramInt = i + g.a.a.a.oD(8, this.RJc.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eje localeje = (eje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
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
            localeje.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localeje.Id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localeje.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125766);
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
            localeje.Uld = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localeje.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125766);
          return 0;
        case 6: 
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
            localeje.Ule = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localeje.Ulf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwf)localObject2).parseFrom((byte[])localObject1);
          }
          localeje.RJc = ((dwf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eje
 * JD-Core Version:    0.7.0.1
 */