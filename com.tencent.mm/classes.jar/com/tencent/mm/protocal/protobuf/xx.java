package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xx
  extends dyl
{
  public String DNV;
  public String Skg;
  public String Skh;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Skg != null) {
        paramVarArgs.f(2, this.Skg);
      }
      if (this.Skh != null) {
        paramVarArgs.f(3, this.Skh);
      }
      if (this.DNV != null) {
        paramVarArgs.f(4, this.DNV);
      }
      if (this.fvP != null) {
        paramVarArgs.f(5, this.fvP);
      }
      AppMethodBeat.o(72452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Skg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Skg);
      }
      i = paramInt;
      if (this.Skh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Skh);
      }
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.DNV);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fvP);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xx localxx = (xx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localxx.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localxx.Skg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localxx.Skh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localxx.DNV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localxx.fvP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xx
 * JD-Core Version:    0.7.0.1
 */