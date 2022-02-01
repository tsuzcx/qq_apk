package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aik
  extends dyl
{
  public String Std;
  public int Ste;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Std != null) {
        paramVarArgs.f(2, this.Std);
      }
      paramVarArgs.aY(3, this.Ste);
      AppMethodBeat.o(91438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Std != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Std);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Ste);
      AppMethodBeat.o(91438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aik localaik = (aik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91438);
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
            localaik.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91438);
          return 0;
        case 2: 
          localaik.Std = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91438);
          return 0;
        }
        localaik.Ste = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91438);
        return 0;
      }
      AppMethodBeat.o(91438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aik
 * JD-Core Version:    0.7.0.1
 */