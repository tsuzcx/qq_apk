package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buu
  extends dyl
{
  public String TeR;
  public int scene;
  public String ufq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193548);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      if (this.ufq != null) {
        paramVarArgs.f(3, this.ufq);
      }
      if (this.TeR != null) {
        paramVarArgs.f(4, this.TeR);
      }
      AppMethodBeat.o(193548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.ufq != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ufq);
      }
      i = paramInt;
      if (this.TeR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TeR);
      }
      AppMethodBeat.o(193548);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(193548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        buu localbuu = (buu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(193548);
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
            localbuu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(193548);
          return 0;
        case 2: 
          localbuu.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(193548);
          return 0;
        case 3: 
          localbuu.ufq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(193548);
          return 0;
        }
        localbuu.TeR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(193548);
        return 0;
      }
      AppMethodBeat.o(193548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buu
 * JD-Core Version:    0.7.0.1
 */