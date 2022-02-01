package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fed
  extends dyl
{
  public int Svu;
  public long Svv;
  public long UCJ;
  public String UDO;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      if (this.UDO != null) {
        paramVarArgs.f(4, this.UDO);
      }
      paramVarArgs.aY(5, this.rWu);
      paramVarArgs.bm(6, this.UCJ);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv);
      paramInt = i;
      if (this.UDO != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UDO);
      }
      i = g.a.a.b.b.a.bM(5, this.rWu);
      int j = g.a.a.b.b.a.p(6, this.UCJ);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fed localfed = (fed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
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
            localfed.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localfed.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localfed.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localfed.UDO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localfed.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115878);
          return 0;
        }
        localfed.UCJ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fed
 * JD-Core Version:    0.7.0.1
 */