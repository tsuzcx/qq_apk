package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dta
  extends dyl
{
  public String TZz;
  public String appid;
  public int dXr;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.dXr);
      if (this.TZz != null) {
        paramVarArgs.f(3, this.TZz);
      }
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      paramVarArgs.aY(5, this.scene);
      AppMethodBeat.o(32403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.dXr);
      paramInt = i;
      if (this.TZz != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TZz);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.appid);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.scene);
      AppMethodBeat.o(32403);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32403);
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
            localdta.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32403);
          return 0;
        case 2: 
          localdta.dXr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32403);
          return 0;
        case 3: 
          localdta.TZz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32403);
          return 0;
        case 4: 
          localdta.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32403);
          return 0;
        }
        localdta.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32403);
        return 0;
      }
      AppMethodBeat.o(32403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */