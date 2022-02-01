package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends dyl
{
  public String RDX;
  public int RDY;
  public int RDZ;
  public String REa;
  public int limit;
  public int offset;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.limit);
      paramVarArgs.aY(3, this.offset);
      paramVarArgs.aY(4, this.type);
      if (this.RDX != null) {
        paramVarArgs.f(5, this.RDX);
      }
      paramVarArgs.aY(6, this.RDY);
      paramVarArgs.aY(7, this.RDZ);
      if (this.REa != null) {
        paramVarArgs.f(8, this.REa);
      }
      AppMethodBeat.o(91336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.limit) + g.a.a.b.b.a.bM(3, this.offset) + g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.RDX != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDX);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.RDY) + g.a.a.b.b.a.bM(7, this.RDZ);
      paramInt = i;
      if (this.REa != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.REa);
      }
      AppMethodBeat.o(91336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91336);
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
            localaa.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91336);
          return 0;
        case 2: 
          localaa.limit = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91336);
          return 0;
        case 3: 
          localaa.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91336);
          return 0;
        case 4: 
          localaa.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91336);
          return 0;
        case 5: 
          localaa.RDX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91336);
          return 0;
        case 6: 
          localaa.RDY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91336);
          return 0;
        case 7: 
          localaa.RDZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91336);
          return 0;
        }
        localaa.REa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91336);
        return 0;
      }
      AppMethodBeat.o(91336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */