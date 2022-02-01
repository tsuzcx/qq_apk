package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crh
  extends dyl
{
  public String HlB;
  public int Tyq;
  public LinkedList<eaf> Tyr;
  public int Tys;
  public LinkedList<eaf> Tyt;
  
  public crh()
  {
    AppMethodBeat.i(155434);
    this.Tyr = new LinkedList();
    this.Tyt = new LinkedList();
    AppMethodBeat.o(155434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HlB != null) {
        paramVarArgs.f(2, this.HlB);
      }
      paramVarArgs.aY(3, this.Tyq);
      paramVarArgs.e(4, 8, this.Tyr);
      paramVarArgs.aY(5, this.Tys);
      paramVarArgs.e(6, 8, this.Tyt);
      AppMethodBeat.o(155435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.HlB);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Tyq);
      int j = g.a.a.a.c(4, 8, this.Tyr);
      int k = g.a.a.b.b.a.bM(5, this.Tys);
      int m = g.a.a.a.c(6, 8, this.Tyt);
      AppMethodBeat.o(155435);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tyr.clear();
        this.Tyt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        crh localcrh = (crh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155435);
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
            localcrh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 2: 
          localcrh.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155435);
          return 0;
        case 3: 
          localcrh.Tyq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155435);
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
            localcrh.Tyr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 5: 
          localcrh.Tys = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155435);
          return 0;
        }
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
          localcrh.Tyt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      AppMethodBeat.o(155435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crh
 * JD-Core Version:    0.7.0.1
 */