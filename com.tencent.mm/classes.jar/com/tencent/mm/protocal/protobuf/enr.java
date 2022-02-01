package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enr
  extends dyl
{
  public String UlA;
  public long UlB;
  public long UmO;
  public int UmP;
  public String UserName;
  public int vhG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118449);
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
      paramVarArgs.aY(4, this.vhG);
      paramVarArgs.bm(5, this.UlB);
      paramVarArgs.bm(6, this.UmO);
      paramVarArgs.aY(7, this.UmP);
      AppMethodBeat.o(118449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label596;
      }
    }
    label596:
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
      paramInt = g.a.a.b.b.a.bM(4, this.vhG);
      int j = g.a.a.b.b.a.p(5, this.UlB);
      int k = g.a.a.b.b.a.p(6, this.UmO);
      int m = g.a.a.b.b.a.bM(7, this.UmP);
      AppMethodBeat.o(118449);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        enr localenr = (enr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118449);
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
            localenr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(118449);
          return 0;
        case 2: 
          localenr.UlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 3: 
          localenr.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 4: 
          localenr.vhG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118449);
          return 0;
        case 5: 
          localenr.UlB = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118449);
          return 0;
        case 6: 
          localenr.UmO = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118449);
          return 0;
        }
        localenr.UmP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118449);
        return 0;
      }
      AppMethodBeat.o(118449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enr
 * JD-Core Version:    0.7.0.1
 */