package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cis
  extends com.tencent.mm.cd.a
{
  public String Crx;
  public acu TpG;
  public float height;
  public String thumbUrl;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.thumbUrl != null) {
        paramVarArgs.f(1, this.thumbUrl);
      }
      paramVarArgs.i(2, this.width);
      paramVarArgs.i(3, this.height);
      if (this.TpG != null)
      {
        paramVarArgs.oE(4, this.TpG.computeSize());
        this.TpG.writeFields(paramVarArgs);
      }
      if (this.Crx != null) {
        paramVarArgs.f(5, this.Crx);
      }
      AppMethodBeat.o(197682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thumbUrl == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.b.b.a.g(1, this.thumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4);
      paramInt = i;
      if (this.TpG != null) {
        paramInt = i + g.a.a.a.oD(4, this.TpG.computeSize());
      }
      i = paramInt;
      if (this.Crx != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Crx);
      }
      AppMethodBeat.o(197682);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197682);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cis localcis = (cis)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197682);
          return -1;
        case 1: 
          localcis.thumbUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197682);
          return 0;
        case 2: 
          localcis.width = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(197682);
          return 0;
        case 3: 
          localcis.height = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(197682);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            acu localacu = new acu();
            if ((localObject != null) && (localObject.length > 0)) {
              localacu.parseFrom((byte[])localObject);
            }
            localcis.TpG = localacu;
            paramInt += 1;
          }
          AppMethodBeat.o(197682);
          return 0;
        }
        localcis.Crx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(197682);
        return 0;
      }
      AppMethodBeat.o(197682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cis
 * JD-Core Version:    0.7.0.1
 */