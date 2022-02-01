package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cak
  extends dyl
{
  public String TiN;
  public String TiO;
  public String vid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116454);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vid != null) {
        paramVarArgs.f(2, this.vid);
      }
      if (this.TiN != null) {
        paramVarArgs.f(3, this.TiN);
      }
      if (this.TiO != null) {
        paramVarArgs.f(4, this.TiO);
      }
      AppMethodBeat.o(116454);
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
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.vid);
      }
      i = paramInt;
      if (this.TiN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TiN);
      }
      paramInt = i;
      if (this.TiO != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TiO);
      }
      AppMethodBeat.o(116454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cak localcak = (cak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116454);
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
            localcak.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(116454);
          return 0;
        case 2: 
          localcak.vid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116454);
          return 0;
        case 3: 
          localcak.TiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116454);
          return 0;
        }
        localcak.TiO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116454);
        return 0;
      }
      AppMethodBeat.o(116454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cak
 * JD-Core Version:    0.7.0.1
 */