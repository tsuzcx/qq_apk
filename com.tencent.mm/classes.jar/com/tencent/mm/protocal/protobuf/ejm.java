package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejm
  extends dyl
{
  public String UlA;
  public long UlB;
  public String UlC;
  public int UlD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125775);
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
      paramVarArgs.bm(3, this.UlB);
      if (this.UlC != null) {
        paramVarArgs.f(4, this.UlC);
      }
      paramVarArgs.aY(5, this.UlD);
      AppMethodBeat.o(125775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      i += g.a.a.b.b.a.p(3, this.UlB);
      paramInt = i;
      if (this.UlC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UlC);
      }
      i = g.a.a.b.b.a.bM(5, this.UlD);
      AppMethodBeat.o(125775);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ejm localejm = (ejm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125775);
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
            localejm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125775);
          return 0;
        case 2: 
          localejm.UlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125775);
          return 0;
        case 3: 
          localejm.UlB = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125775);
          return 0;
        case 4: 
          localejm.UlC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125775);
          return 0;
        }
        localejm.UlD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125775);
        return 0;
      }
      AppMethodBeat.o(125775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejm
 * JD-Core Version:    0.7.0.1
 */