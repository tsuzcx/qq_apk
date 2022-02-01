package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drl
  extends dyl
{
  public String Saj;
  public boolean TYt;
  public int TYu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72566);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Saj != null) {
        paramVarArgs.f(2, this.Saj);
      }
      paramVarArgs.co(3, this.TYt);
      paramVarArgs.aY(4, this.TYu);
      AppMethodBeat.o(72566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Saj != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Saj);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.bM(4, this.TYu);
      AppMethodBeat.o(72566);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        drl localdrl = (drl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72566);
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
            localdrl.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72566);
          return 0;
        case 2: 
          localdrl.Saj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72566);
          return 0;
        case 3: 
          localdrl.TYt = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(72566);
          return 0;
        }
        localdrl.TYu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72566);
        return 0;
      }
      AppMethodBeat.o(72566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drl
 * JD-Core Version:    0.7.0.1
 */