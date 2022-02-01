package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqw
  extends dyl
{
  public int CPw;
  public int Utj;
  public LinkedList<eqv> Utk;
  
  public eqw()
  {
    AppMethodBeat.i(32468);
    this.Utk = new LinkedList();
    AppMethodBeat.o(32468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Utj);
      paramVarArgs.e(3, 8, this.Utk);
      paramVarArgs.aY(4, this.CPw);
      AppMethodBeat.o(32469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Utj);
      int j = g.a.a.a.c(3, 8, this.Utk);
      int k = g.a.a.b.b.a.bM(4, this.CPw);
      AppMethodBeat.o(32469);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Utk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqw localeqw = (eqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32469);
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
            localeqw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        case 2: 
          localeqw.Utj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32469);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqv)localObject2).parseFrom((byte[])localObject1);
            }
            localeqw.Utk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        }
        localeqw.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32469);
        return 0;
      }
      AppMethodBeat.o(32469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqw
 * JD-Core Version:    0.7.0.1
 */