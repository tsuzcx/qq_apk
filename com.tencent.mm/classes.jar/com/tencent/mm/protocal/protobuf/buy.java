package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buy
  extends dyl
{
  public String TeR;
  public String Tfb;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      if (this.Tfb != null) {
        paramVarArgs.f(3, this.Tfb);
      }
      if (this.TeR != null) {
        paramVarArgs.f(4, this.TeR);
      }
      AppMethodBeat.o(196118);
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
      if (this.Tfb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Tfb);
      }
      i = paramInt;
      if (this.TeR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TeR);
      }
      AppMethodBeat.o(196118);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(196118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        buy localbuy = (buy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196118);
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
            localbuy.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(196118);
          return 0;
        case 2: 
          localbuy.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(196118);
          return 0;
        case 3: 
          localbuy.Tfb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(196118);
          return 0;
        }
        localbuy.TeR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(196118);
        return 0;
      }
      AppMethodBeat.o(196118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buy
 * JD-Core Version:    0.7.0.1
 */