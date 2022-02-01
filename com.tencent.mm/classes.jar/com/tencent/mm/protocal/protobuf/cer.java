package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cer
  extends dyl
{
  public int CPw;
  public LinkedList<eaf> RIj;
  public int Tdc;
  public String jUi;
  
  public cer()
  {
    AppMethodBeat.i(32274);
    this.RIj = new LinkedList();
    AppMethodBeat.o(32274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32275);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUi != null) {
        paramVarArgs.f(2, this.jUi);
      }
      paramVarArgs.aY(3, this.Tdc);
      paramVarArgs.e(4, 8, this.RIj);
      paramVarArgs.aY(5, this.CPw);
      AppMethodBeat.o(32275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label569;
      }
    }
    label569:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jUi);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Tdc);
      int j = g.a.a.a.c(4, 8, this.RIj);
      int k = g.a.a.b.b.a.bM(5, this.CPw);
      AppMethodBeat.o(32275);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cer localcer = (cer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32275);
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
            localcer.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        case 2: 
          localcer.jUi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32275);
          return 0;
        case 3: 
          localcer.Tdc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32275);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localcer.RIj.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        }
        localcer.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32275);
        return 0;
      }
      AppMethodBeat.o(32275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cer
 * JD-Core Version:    0.7.0.1
 */