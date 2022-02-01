package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bru
  extends dyl
{
  public LinkedList<uo> REB;
  public String REw;
  public String REx;
  public int REy;
  public String Tcj;
  public int fUN;
  public String sign;
  public String ufY;
  public String ufq;
  
  public bru()
  {
    AppMethodBeat.i(114012);
    this.REB = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
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
      if (this.ufY != null) {
        paramVarArgs.f(4, this.ufY);
      }
      if (this.ufq != null) {
        paramVarArgs.f(5, this.ufq);
      }
      if (this.sign != null) {
        paramVarArgs.f(6, this.sign);
      }
      if (this.REw != null) {
        paramVarArgs.f(7, this.REw);
      }
      if (this.REx != null) {
        paramVarArgs.f(8, this.REx);
      }
      if (this.Tcj != null) {
        paramVarArgs.f(9, this.Tcj);
      }
      paramVarArgs.aY(10, this.REy);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.REB) + g.a.a.b.b.a.bM(3, this.fUN);
      paramInt = i;
      if (this.ufY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufY);
      }
      i = paramInt;
      if (this.ufq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ufq);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sign);
      }
      i = paramInt;
      if (this.REw != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.REw);
      }
      paramInt = i;
      if (this.REx != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.REx);
      }
      i = paramInt;
      if (this.Tcj != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Tcj);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.REy);
      AppMethodBeat.o(114013);
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
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bru localbru = (bru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
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
            localbru.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
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
            localbru.REB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localbru.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localbru.ufY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localbru.ufq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localbru.sign = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localbru.REw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localbru.REx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localbru.Tcj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localbru.REy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bru
 * JD-Core Version:    0.7.0.1
 */