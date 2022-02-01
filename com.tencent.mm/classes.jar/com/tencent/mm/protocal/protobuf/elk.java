package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elk
  extends dyl
{
  public int Cqs;
  public String UlA;
  public long UlB;
  public long UmO;
  public int UmP;
  public int UmU;
  public int Uny;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125835);
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
      if (this.Username != null) {
        paramVarArgs.f(3, this.Username);
      }
      paramVarArgs.bm(4, this.UlB);
      paramVarArgs.aY(5, this.Cqs);
      paramVarArgs.bm(6, this.UmO);
      paramVarArgs.aY(7, this.UmP);
      paramVarArgs.aY(8, this.Uny);
      paramVarArgs.aY(9, this.UmU);
      AppMethodBeat.o(125835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label692;
      }
    }
    label692:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UlA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Username);
      }
      paramInt = g.a.a.b.b.a.p(4, this.UlB);
      int j = g.a.a.b.b.a.bM(5, this.Cqs);
      int k = g.a.a.b.b.a.p(6, this.UmO);
      int m = g.a.a.b.b.a.bM(7, this.UmP);
      int n = g.a.a.b.b.a.bM(8, this.Uny);
      int i1 = g.a.a.b.b.a.bM(9, this.UmU);
      AppMethodBeat.o(125835);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        elk localelk = (elk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125835);
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
            localelk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125835);
          return 0;
        case 2: 
          localelk.UlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 3: 
          localelk.Username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 4: 
          localelk.UlB = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125835);
          return 0;
        case 5: 
          localelk.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125835);
          return 0;
        case 6: 
          localelk.UmO = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125835);
          return 0;
        case 7: 
          localelk.UmP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125835);
          return 0;
        case 8: 
          localelk.Uny = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125835);
          return 0;
        }
        localelk.UmU = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125835);
        return 0;
      }
      AppMethodBeat.o(125835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elk
 * JD-Core Version:    0.7.0.1
 */