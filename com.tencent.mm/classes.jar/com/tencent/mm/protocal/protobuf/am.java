package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends dyl
{
  public LinkedList<uo> REB;
  public String REw;
  public String REx;
  public int REy;
  public int fUN;
  
  public am()
  {
    AppMethodBeat.i(113924);
    this.REB = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.REB);
      paramVarArgs.aY(3, this.fUN);
      if (this.REw != null) {
        paramVarArgs.f(4, this.REw);
      }
      if (this.REx != null) {
        paramVarArgs.f(5, this.REx);
      }
      paramVarArgs.aY(6, this.REy);
      AppMethodBeat.o(113925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.REB) + g.a.a.b.b.a.bM(3, this.fUN);
      paramInt = i;
      if (this.REw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.REw);
      }
      i = paramInt;
      if (this.REx != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.REx);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.REy);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.REB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localam.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uo)localObject2).parseFrom((byte[])localObject1);
            }
            localam.REB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localam.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localam.REw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localam.REx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localam.REy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */