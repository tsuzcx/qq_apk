package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cif
  extends dyl
{
  public String EBP;
  public String tUC;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ybP != null) {
        paramVarArgs.f(2, this.ybP);
      }
      if (this.tUC != null) {
        paramVarArgs.f(3, this.tUC);
      }
      if (this.EBP != null) {
        paramVarArgs.f(4, this.EBP);
      }
      AppMethodBeat.o(91517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ybP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ybP);
      }
      i = paramInt;
      if (this.tUC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tUC);
      }
      paramInt = i;
      if (this.EBP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.EBP);
      }
      AppMethodBeat.o(91517);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cif localcif = (cif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91517);
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
            localcif.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91517);
          return 0;
        case 2: 
          localcif.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91517);
          return 0;
        case 3: 
          localcif.tUC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91517);
          return 0;
        }
        localcif.EBP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91517);
        return 0;
      }
      AppMethodBeat.o(91517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cif
 * JD-Core Version:    0.7.0.1
 */