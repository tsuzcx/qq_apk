package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eon
  extends dyl
{
  public int Cqs;
  public String RIi;
  public String UlA;
  public long UlB;
  public long UmO;
  public int UmP;
  public long Urf;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      paramVarArgs.bm(4, this.UlB);
      paramVarArgs.bm(5, this.UmO);
      paramVarArgs.aY(6, this.UmP);
      paramVarArgs.bm(7, this.Urf);
      paramVarArgs.aY(8, this.Cqs);
      if (this.RIi != null) {
        paramVarArgs.f(9, this.RIi);
      }
      AppMethodBeat.o(118476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label688;
      }
    }
    label688:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UlA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UserName);
      }
      i = i + g.a.a.b.b.a.p(4, this.UlB) + g.a.a.b.b.a.p(5, this.UmO) + g.a.a.b.b.a.bM(6, this.UmP) + g.a.a.b.b.a.p(7, this.Urf) + g.a.a.b.b.a.bM(8, this.Cqs);
      paramInt = i;
      if (this.RIi != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RIi);
      }
      AppMethodBeat.o(118476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eon localeon = (eon)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118476);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localeon.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(118476);
          return 0;
        case 2: 
          localeon.UlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 3: 
          localeon.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 4: 
          localeon.UlB = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118476);
          return 0;
        case 5: 
          localeon.UmO = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118476);
          return 0;
        case 6: 
          localeon.UmP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118476);
          return 0;
        case 7: 
          localeon.Urf = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118476);
          return 0;
        case 8: 
          localeon.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118476);
          return 0;
        }
        localeon.RIi = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(118476);
        return 0;
      }
      AppMethodBeat.o(118476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eon
 * JD-Core Version:    0.7.0.1
 */