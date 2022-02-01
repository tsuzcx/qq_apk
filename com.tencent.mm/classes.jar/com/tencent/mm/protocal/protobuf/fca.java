package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fca
  extends dyl
{
  public String UBS;
  public LinkedList<String> UCd;
  
  public fca()
  {
    AppMethodBeat.i(201340);
    this.UCd = new LinkedList();
    AppMethodBeat.o(201340);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201351);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.UCd);
      if (this.UBS != null) {
        paramVarArgs.f(3, this.UBS);
      }
      AppMethodBeat.o(201351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label408;
      }
    }
    label408:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.UCd);
      paramInt = i;
      if (this.UBS != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UBS);
      }
      AppMethodBeat.o(201351);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fca localfca = (fca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201351);
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
            localfca.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(201351);
          return 0;
        case 2: 
          localfca.UCd.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(201351);
          return 0;
        }
        localfca.UBS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(201351);
        return 0;
      }
      AppMethodBeat.o(201351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fca
 * JD-Core Version:    0.7.0.1
 */