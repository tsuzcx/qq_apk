package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqd
  extends com.tencent.mm.cd.a
{
  public String UNV;
  public String UNW;
  public LinkedList<dgz> UNX;
  public String UNY;
  public int UNZ;
  public String fwr;
  
  public fqd()
  {
    AppMethodBeat.i(50125);
    this.UNX = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNV != null) {
        paramVarArgs.f(1, this.UNV);
      }
      if (this.UNW != null) {
        paramVarArgs.f(2, this.UNW);
      }
      paramVarArgs.e(3, 8, this.UNX);
      if (this.UNY != null) {
        paramVarArgs.f(4, this.UNY);
      }
      paramVarArgs.aY(5, this.UNZ);
      if (this.fwr != null) {
        paramVarArgs.f(6, this.fwr);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNV == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.b.b.a.g(1, this.UNV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UNW != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UNW);
      }
      i += g.a.a.a.c(3, 8, this.UNX);
      paramInt = i;
      if (this.UNY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UNY);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UNZ);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fwr);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UNX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fqd localfqd = (fqd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localfqd.UNV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localfqd.UNW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dgz localdgz = new dgz();
            if ((localObject != null) && (localObject.length > 0)) {
              localdgz.parseFrom((byte[])localObject);
            }
            localfqd.UNX.add(localdgz);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localfqd.UNY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localfqd.UNZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(50126);
          return 0;
        }
        localfqd.fwr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqd
 * JD-Core Version:    0.7.0.1
 */