package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class b
  extends dyl
{
  public String MEL;
  public LinkedList<String> MEM;
  public String MEN;
  
  public b()
  {
    AppMethodBeat.i(243855);
    this.MEM = new LinkedList();
    AppMethodBeat.o(243855);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243856);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MEL != null) {
        paramVarArgs.f(2, this.MEL);
      }
      paramVarArgs.e(3, 1, this.MEM);
      if (this.MEN != null) {
        paramVarArgs.f(4, this.MEN);
      }
      AppMethodBeat.o(243856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MEL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.MEL);
      }
      i += g.a.a.a.c(3, 1, this.MEM);
      paramInt = i;
      if (this.MEN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.MEN);
      }
      AppMethodBeat.o(243856);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MEM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243856);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243856);
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
            localb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(243856);
          return 0;
        case 2: 
          localb.MEL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243856);
          return 0;
        case 3: 
          localb.MEM.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(243856);
          return 0;
        }
        localb.MEN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(243856);
        return 0;
      }
      AppMethodBeat.o(243856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.b
 * JD-Core Version:    0.7.0.1
 */